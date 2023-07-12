package com.ali.user.mobile.login.service.impl;

import android.text.TextUtils;
import android.util.Log;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.FingerprintLoginInfo;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.filter.IAfterFilter;
import com.ali.user.mobile.rpc.login.model.AliUserResponseData;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.TokenLoginRequest;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FingerprintLoginServiceImpl {
    private static final String INFO_SP_KEY = "fingerprint_login_info";
    private static final String TAG = "login.FingerprintLoginService";
    private static FingerprintLoginServiceImpl instance;
    private FingerprintLoginInfo fingerprintLoginInfo;

    private void closeFingerprintInfo(FingerprintLoginInfo fingerprintLoginInfo, boolean z) {
        fingerprintLoginInfo.open = false;
        if (z) {
            fingerprintLoginInfo.loginEntrance = null;
        }
        resetFingerprintInfo(fingerprintLoginInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fingerprintLoginUT(LoginParam loginParam, RpcResponse rpcResponse) {
        String str;
        try {
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            if (rpcResponse != null && (str = rpcResponse.actionType) != null) {
                if ("SUCCESS".equals(str)) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.BIO_LOGIN, properties);
                    AppMonitorAdapter.commitSuccess("Page_Member_Login", "Login_Fingerprint");
                } else if (!"H5".equals(rpcResponse.actionType)) {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, "0", LoginType.LocalLoginType.BIO_LOGIN, properties);
                    AppMonitorAdapter.commitFail("Page_Member_Login", "Login_Fingerprint", "0", rpcResponse.message);
                }
            } else {
                AppMonitorAdapter.commitFail("Page_Member_Login", "Login_Fingerprint", "0", UTConstant.CustomEvent.UT_NETWORK_FAIL);
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, "0", LoginType.LocalLoginType.BIO_LOGIN, properties);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            AppMonitorAdapter.commitFail("Page_Member_Login", "Login_Fingerprint", "0", UTConstant.CustomEvent.UT_NETWORK_FAIL);
        }
    }

    public static FingerprintLoginServiceImpl getInstance() {
        if (instance == null) {
            instance = new FingerprintLoginServiceImpl();
        }
        return instance;
    }

    private boolean isSupportedLoginEntrance(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetFingerprintInfo(FingerprintLoginInfo fingerprintLoginInfo) {
        if (fingerprintLoginInfo == null) {
            return;
        }
        fingerprintLoginInfo.token = null;
        fingerprintLoginInfo.showLoginId = "";
    }

    public void applyFingerprintLoginToken() {
        T t;
        FingerprintLoginInfo fingerprintLoginInfo = null;
        try {
        } catch (Exception e) {
            TLogAdapter.e(TAG, "applyFingerprintLoginToken error", e);
            resetFingerprintInfo(fingerprintLoginInfo);
        }
        if (isFingerprintLoginAvailable()) {
            fingerprintLoginInfo = getFingerprintLoginInfo();
            if (fingerprintLoginInfo.open && isSupportedLoginEntrance(fingerprintLoginInfo.loginEntrance)) {
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.API_NAME = ApiConstants.ApiName.FINGER_PRINT_APPLY_TOKEN;
                rpcRequest.VERSION = "1.0";
                rpcRequest.NEED_ECODE = true;
                rpcRequest.NEED_SESSION = true;
                rpcRequest.preDomain = DataProviderFactory.getDataProvider().getSessionPreDomain();
                rpcRequest.onlineDomain = DataProviderFactory.getDataProvider().getSessionOnlineDomain();
                TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
                tokenLoginRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
                tokenLoginRequest.t = System.currentTimeMillis();
                tokenLoginRequest.appVersion = AppInfo.getInstance().getAndroidAppVersion();
                tokenLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
                rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
                rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
                rpcRequest.addParam("ext", JSON.toJSONString(new HashMap()));
                RpcResponse post = ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, RpcResponse.class);
                if (post.code == 3000 && (t = post.returnValue) != 0) {
                    JSONObject jSONObject = (JSONObject) t;
                    fingerprintLoginInfo.token = jSONObject.getString("fingerprintLoginToken");
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = jSONObject.getLongValue("fingerprintLoginToken_expire_in");
                    Long.signum(longValue);
                    fingerprintLoginInfo.tokenExpireTime = currentTimeMillis + (longValue * 1000);
                    fingerprintLoginInfo.showLoginId = jSONObject.getString("showLoginId");
                    fingerprintLoginInfo.userId = jSONObject.getLongValue("havanaId");
                } else {
                    resetFingerprintInfo(fingerprintLoginInfo);
                }
                updateFingerprintInfo(fingerprintLoginInfo);
            }
        }
    }

    public boolean canUseFingerprintLogin() {
        FingerprintLoginInfo fingerprintLoginInfo;
        try {
            if (isFingerprintLoginAvailable() && (fingerprintLoginInfo = getFingerprintLoginInfo()) != null && isSupportedLoginEntrance(fingerprintLoginInfo.loginEntrance) && fingerprintLoginInfo.token != null) {
                return System.currentTimeMillis() < fingerprintLoginInfo.tokenExpireTime;
            }
            return false;
        } catch (Exception e) {
            TLogAdapter.e(TAG, "canUseFingerprintLogin error", e);
            return false;
        }
    }

    public void clearFingerprintInfo(AliUserResponseData aliUserResponseData) {
        try {
            if (isFingerprintLoginAvailable()) {
                getFingerprintLoginInfo().token = null;
            }
        } catch (Exception e) {
            TLogAdapter.e(TAG, "clearFingerprintInfo error", e);
        }
    }

    public void closeFingerprintLoginSet() {
        FingerprintLoginInfo fingerprintLoginInfo = getFingerprintLoginInfo();
        closeFingerprintInfo(fingerprintLoginInfo, false);
        updateFingerprintInfo(fingerprintLoginInfo);
    }

    public void closeLead(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FingerprintLoginInfo fingerprintLoginInfo = getFingerprintLoginInfo();
        fingerprintLoginInfo.notLeads.put(str, Boolean.TRUE);
        closeFingerprintInfo(fingerprintLoginInfo, false);
        updateFingerprintInfo(fingerprintLoginInfo);
    }

    public void disableFingerprintLogin() {
        FingerprintLoginInfo fingerprintLoginInfo = getFingerprintLoginInfo();
        fingerprintLoginInfo.disable = true;
        updateFingerprintInfo(fingerprintLoginInfo);
    }

    public FingerprintLoginInfo getFingerprintLoginInfo() {
        FingerprintLoginInfo fingerprintLoginInfo = this.fingerprintLoginInfo;
        if (fingerprintLoginInfo != null) {
            return fingerprintLoginInfo;
        }
        String str = (String) SharedPreferencesUtil.getData(DataProviderFactory.getApplicationContext(), INFO_SP_KEY, "{}");
        Log.e("TAG", "info=" + str);
        FingerprintLoginInfo fingerprintLoginInfo2 = (FingerprintLoginInfo) JSON.parseObject(str, FingerprintLoginInfo.class);
        this.fingerprintLoginInfo = fingerprintLoginInfo2;
        return fingerprintLoginInfo2;
    }

    public String getShowLoginId() {
        FingerprintLoginInfo fingerprintLoginInfo = getFingerprintLoginInfo();
        return fingerprintLoginInfo != null ? fingerprintLoginInfo.showLoginId : "";
    }

    public boolean isFingerprintLoginAvailable() {
        FingerprintService fingerprintService = (FingerprintService) ServiceFactory.getService(FingerprintService.class);
        if (DataProviderFactory.getDataProvider().isSupportFingerprintLogin() && fingerprintService != null && fingerprintService.isFingerprintAvailable()) {
            return !getFingerprintLoginInfo().disable;
        }
        return false;
    }

    public boolean isFingerprintLoginOpen() {
        if (isFingerprintLoginAvailable()) {
            return getFingerprintLoginInfo().open;
        }
        return false;
    }

    public boolean isFingerprintLoginSetable() {
        if (isFingerprintLoginAvailable()) {
            return isSupportedLoginEntrance(getFingerprintLoginInfo().loginEntrance);
        }
        return false;
    }

    public void loginByFingerprintToken(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        Object obj = loginParam.externParams;
        if (obj == null) {
            obj = new HashMap();
        }
        rpcRequest.API_NAME = ApiConstants.ApiName.FINGER_PRINT_LOGIN;
        rpcRequest.VERSION = "1.0";
        rpcRequest.addParam("ext", JSON.toJSONString(obj));
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        tokenLoginRequest.site = i;
        tokenLoginRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
        tokenLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
        tokenLoginRequest.ttid = DataProviderFactory.getDataProvider().getTTID();
        tokenLoginRequest.utdid = AppInfo.getInstance().getUtdid();
        tokenLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        final FingerprintLoginInfo fingerprintLoginInfo = getFingerprintLoginInfo();
        tokenLoginRequest.token = fingerprintLoginInfo.token;
        UserLoginServiceImpl.buildExt(tokenLoginRequest);
        rpcRequest.addParam(ApiConstants.ApiField.HID, Long.valueOf(fingerprintLoginInfo.userId));
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.service.impl.FingerprintLoginServiceImpl.1
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                FingerprintLoginServiceImpl.this.resetFingerprintInfo(fingerprintLoginInfo);
                FingerprintLoginServiceImpl.this.updateFingerprintInfo(fingerprintLoginInfo);
                FingerprintLoginServiceImpl.this.fingerprintLoginUT(loginParam, rpcResponse);
                return null;
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void openFingerprintLoginSet() {
        FingerprintLoginInfo fingerprintLoginInfo = getFingerprintLoginInfo();
        fingerprintLoginInfo.open = true;
        updateFingerprintInfo(fingerprintLoginInfo);
    }

    public void updateFingerprintInfo(FingerprintLoginInfo fingerprintLoginInfo) {
        if (fingerprintLoginInfo == null) {
            return;
        }
        try {
            fingerprintLoginInfo.lastUpdateTime = System.currentTimeMillis();
            String jSONString = JSON.toJSONString(fingerprintLoginInfo);
            TLogAdapter.w(TAG, "updateFingerprintInfo to " + jSONString);
            SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), INFO_SP_KEY, jSONString);
        } catch (Exception e) {
            TLogAdapter.e(TAG, "updateFingerprintInfo error", e);
        }
    }
}
