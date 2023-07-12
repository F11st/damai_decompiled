package com.taobao.login4android.biz.autologin;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.TokenLoginRequest;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.session.SessionManager;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AutoLoginBusiness {
    public static final String TAG = "loginsdk.AutoLoginBusiness";

    public static void appendRefer(RpcResponse<LoginReturnData> rpcResponse, SessionManager sessionManager) {
        ApiReferer.Refer refer = new ApiReferer.Refer();
        refer.eventName = "autologinFailed";
        if (rpcResponse != null) {
            refer.errorCode = String.valueOf(rpcResponse.code);
        }
        sessionManager.appendEventTrace(JSON.toJSONString(refer));
    }

    public RpcResponse<LoginReturnData> autoLogin(String str, String str2, int i, boolean z, String str3) {
        return autoLogin(str, str2, i, str3);
    }

    public RpcResponse<LoginReturnData> oldLogin(String str, String str2, int i, String str3) {
        return autoLogin(str, "", i, str3, true, str2);
    }

    public RpcResponse<LoginReturnData> autoLogin(String str, String str2, int i, String str3) {
        return autoLogin(str, str2, i, str3, false, "");
    }

    private RpcResponse<LoginReturnData> autoLogin(String str, String str2, int i, String str3, boolean z, String str4) {
        RpcResponse<LoginReturnData> rpcResponse;
        HistoryAccount findHistoryAccount;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z || !TextUtils.isEmpty(str2)) {
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "autoLogin_commit", properties);
            try {
                RpcRequest rpcRequest = new RpcRequest();
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("apiReferer", str3);
                }
                rpcRequest.VERSION = "1.0";
                if (i == 4) {
                    rpcRequest.API_NAME = ApiConstants.ApiName.OCEAN_AUTO_LOGIN;
                    hashMap.put(ApiConstants.ApiField.OCEAN_APPKEY, DataProviderFactory.getDataProvider().getOceanAppkey());
                } else if (z) {
                    rpcRequest.API_NAME = ApiConstants.ApiName.OLD_TO_NEW_AUTO_LOGIN;
                } else {
                    rpcRequest.API_NAME = ApiConstants.ApiName.AUTO_LOGIN;
                }
                if (i == 13 && SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getExtJson() != null) {
                    try {
                        String string = JSON.parseObject(SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getExtJson()).getJSONObject("aeExt").getString("refreshToken");
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put("refreshToken", string);
                        }
                    } catch (Throwable unused) {
                    }
                }
                rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
                rpcRequest.NEED_SESSION = true;
                if (!z) {
                    long j = 0;
                    try {
                        j = Long.parseLong(str2);
                    } catch (Throwable unused2) {
                    }
                    rpcRequest.addParam("userId", Long.valueOf(j));
                }
                TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
                tokenLoginRequest.token = str;
                if (z) {
                    tokenLoginRequest.tokenType = str4;
                }
                tokenLoginRequest.site = i;
                rpcRequest.requestSite = i;
                tokenLoginRequest.locale = ResourceUtil.getLocaleStr();
                tokenLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
                tokenLoginRequest.t = System.currentTimeMillis();
                if (!z && !TextUtils.isEmpty(str2) && (findHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(Long.parseLong(str2))) != null) {
                    tokenLoginRequest.deviceTokenKey = findHistoryAccount.tokenKey;
                    tokenLoginRequest.appVersion = AppInfo.getInstance().getAndroidAppVersion();
                    DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
                    deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
                    deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
                    deviceTokenSignParam.addHavanaId(str2);
                    deviceTokenSignParam.addTimestamp(String.valueOf(tokenLoginRequest.t));
                    deviceTokenSignParam.addAutoLoginToken(str);
                    deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
                    if (!TextUtils.isEmpty(findHistoryAccount.tokenKey)) {
                        tokenLoginRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(tokenLoginRequest.deviceTokenKey, deviceTokenSignParam.build());
                    }
                }
                UserLoginServiceImpl.buildBaseRequest(new LoginParam(), tokenLoginRequest);
                if (DataProviderFactory.getDataProvider().getExternalData() != null) {
                    if (tokenLoginRequest.ext == null) {
                        tokenLoginRequest.ext = new HashMap();
                    }
                    tokenLoginRequest.ext.putAll(DataProviderFactory.getDataProvider().getExternalData());
                }
                rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
                rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
                rpcResponse = ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, DefaultLoginResponseData.class, String.valueOf(str2));
            } catch (RpcException e) {
                rpcResponse = new RpcResponse<>();
                rpcResponse.code = e.getCode();
                rpcResponse.message = e.getMsg();
            } catch (Exception e2) {
                rpcResponse = new RpcResponse<>();
                rpcResponse.code = 405;
                TLogAdapter.e(TAG, "MtopResponse error", e2);
                e2.printStackTrace();
            }
            SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            if (rpcResponse != null && "SUCCESS".equals(rpcResponse.actionType)) {
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "autoLogin_success", properties2);
            } else {
                int i2 = rpcResponse != null ? rpcResponse.code : 405;
                try {
                    Properties properties3 = new Properties();
                    properties3.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "autoLogin_failure", String.valueOf(i2), properties3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (rpcResponse != null && !RpcException.isSystemError(i2)) {
                    TLogAdapter.e(TAG, "clear SessionInfo in auto login fail");
                    if (TextUtils.equals(str2, sessionManager.getUserId())) {
                        sessionManager.clearSessionInfo();
                        sessionManager.clearAutoLoginInfo();
                        TLogAdapter.e(TAG, "call mtop logout");
                        ((RpcService) ServiceFactory.getService(RpcService.class)).logout();
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "autoLogin_need_clear_session");
                    }
                    SecurityGuardManagerWraper.clearAutologinTokenFromFile(str2);
                }
                appendRefer(rpcResponse, sessionManager);
            }
            return rpcResponse;
        }
        return null;
    }
}
