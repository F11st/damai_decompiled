package com.ali.user.mobile.login.service.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.AccountType;
import com.ali.user.mobile.login.model.AppLaunchInfoResponseData;
import com.ali.user.mobile.login.model.GetVerifyTokenResponseData;
import com.ali.user.mobile.login.presenter.ExtRiskData;
import com.ali.user.mobile.login.presenter.ScanFaceWSecurityData;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.ApplyTokenRequest;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginRequestBase;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.LoginTokenResponseData;
import com.ali.user.mobile.rpc.login.model.MLoginTokenReturnValue;
import com.ali.user.mobile.rpc.login.model.MemberRequestBase;
import com.ali.user.mobile.rpc.login.model.PasswordLoginRequest;
import com.ali.user.mobile.rpc.login.model.SimLoginRequest;
import com.ali.user.mobile.rpc.login.model.TokenLoginRequest;
import com.ali.user.mobile.rpc.login.model.WSecurityData;
import com.ali.user.mobile.rpc.safe.RSAKey;
import com.ali.user.mobile.rpc.safe.Rsa;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.FileUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.cookies.LoginCookieUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserLoginServiceImpl {
    private static UserLoginServiceImpl instance;
    private final String TAG = "login.UserLoginServiceImpl";

    private UserLoginServiceImpl() {
    }

    public static void addEaExt(Map<String, String> map) {
        if (map == null || DataProviderFactory.getDataProvider().getSite() != 21) {
            return;
        }
        if (TextUtils.isEmpty(DataProviderFactory.getDataProvider().getEaDeviceId())) {
            String eaDeviceId = FileUtil.getEaDeviceId();
            if (TextUtils.isEmpty(eaDeviceId)) {
                return;
            }
            map.put("oaDeviceId", eaDeviceId);
            return;
        }
        map.put("oaDeviceId", DataProviderFactory.getDataProvider().getEaDeviceId());
    }

    public static void addExt(LoginRequestBase loginRequestBase) {
        if (loginRequestBase == null) {
            return;
        }
        if (loginRequestBase.ext == null) {
            loginRequestBase.ext = new HashMap();
        }
        if (TextUtils.isEmpty(LoginContext.mFrom)) {
            return;
        }
        loginRequestBase.ext.put("aFrom", LoginContext.mFrom);
    }

    public static void addFrom(Properties properties) {
        if (!TextUtils.isEmpty(LoginStatus.mFrom)) {
            properties.setProperty("aFrom", LoginStatus.mFrom);
        } else if (TextUtils.isEmpty(ApiReferer.getApiRefer())) {
        } else {
            properties.setProperty("aFrom", ApiReferer.getApiRefer());
        }
    }

    public static void buildBaseRequest(LoginParam loginParam, LoginRequestBase loginRequestBase) {
        loginRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        loginRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        loginRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        loginRequestBase.utdid = AppInfo.getInstance().getUtdid();
        loginRequestBase.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        if (ServiceFactory.getService(FingerprintService.class) != null) {
            if (((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintSetable()) {
                loginRequestBase.supportBiometricType = "fingerprint";
            }
            if (((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable()) {
                loginRequestBase.biometricState = "available";
            }
        }
        buildExt(loginRequestBase);
    }

    public static void buildExt(MemberRequestBase memberRequestBase) {
        try {
            HashMap hashMap = new HashMap();
            memberRequestBase.ext = hashMap;
            hashMap.put("huaweiLogin", Boolean.valueOf(LoginStatus.huaweiLogin));
            if (DataProviderFactory.getDataProvider().isYoukuApps()) {
                memberRequestBase.ext.put("firstLogin", Boolean.valueOf(LoginStatus.youkuFirstLogin));
            } else {
                boolean isEmpty = TextUtils.isEmpty(SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldUserId());
                LoginStatus.firstLogin = isEmpty;
                memberRequestBase.ext.put("firstLogin", Boolean.valueOf(isEmpty));
            }
            String apiRefer = ApiReferer.getApiRefer();
            if (!TextUtils.isEmpty(LoginStatus.mFrom)) {
                memberRequestBase.ext.put("aFrom", LoginStatus.mFrom);
            } else if (!TextUtils.isEmpty(apiRefer)) {
                memberRequestBase.ext.put("aFrom", apiRefer);
            }
            if (!TextUtils.isEmpty(LoginStatus.benifit_id)) {
                memberRequestBase.ext.put("benifit_id", LoginStatus.benifit_id);
            }
            if (DataProviderFactory.getDataProvider().getExternalData() != null) {
                memberRequestBase.ext.putAll(DataProviderFactory.getDataProvider().getExternalData());
            }
            if (LoginSwitch.getSwitch("add_miid", "true")) {
                String value = LoginCookieUtils.getValue("miid");
                if (!TextUtils.isEmpty(value)) {
                    memberRequestBase.ext.put("miid", value);
                    TLogAdapter.e("Ext", "miid =" + value);
                    return;
                }
                TLogAdapter.e("Ext", "miid is null");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private RpcRequest buildScanRequest(LoginParam loginParam, String str) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = str;
        rpcRequest.VERSION = "1.0";
        rpcRequest.NEED_ECODE = false;
        rpcRequest.NEED_SESSION = false;
        LoginRequestBase loginRequestBase = new LoginRequestBase();
        loginRequestBase.hid = String.valueOf(loginParam.havanaId);
        if (!TextUtils.isEmpty(loginParam.deviceTokenKey)) {
            loginRequestBase.deviceTokenKey = loginParam.deviceTokenKey;
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(String.valueOf(loginParam.havanaId));
            deviceTokenSignParam.addTimestamp(String.valueOf(loginRequestBase.t));
            deviceTokenSignParam.addSDKVersion(loginRequestBase.sdkVersion);
            loginRequestBase.deviceTokenSign = AlibabaSecurityTokenService.sign(loginRequestBase.deviceTokenKey, deviceTokenSignParam.build());
            loginRequestBase.hid = loginParam.havanaId + "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "2.0");
        buildExt(hashMap);
        loginRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        loginRequestBase.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        loginRequestBase.site = DataProviderFactory.getDataProvider().getSite();
        buildBaseRequest(loginParam, loginRequestBase);
        loginRequestBase.t = System.currentTimeMillis();
        rpcRequest.addParam("loginInfo", JSON.toJSONString(loginRequestBase));
        return rpcRequest;
    }

    public static UserLoginServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserLoginServiceImpl();
        }
        return instance;
    }

    @NonNull
    public static ScanFaceWSecurityData getScanFaceWSecurityData() {
        ScanFaceWSecurityData scanFaceWSecurityData = new ScanFaceWSecurityData();
        WSecurityData buildWSecurityData = SecurityGuardManagerWraper.buildWSecurityData();
        scanFaceWSecurityData.apdId = buildWSecurityData.apdId;
        scanFaceWSecurityData.t = buildWSecurityData.t;
        scanFaceWSecurityData.umidToken = buildWSecurityData.umidToken;
        scanFaceWSecurityData.wua = buildWSecurityData.wua;
        try {
            ExtRiskData extRiskData = new ExtRiskData();
            scanFaceWSecurityData.extRiskData = extRiskData;
            extRiskData.scanfaceWua = SecurityGuardManagerWraper.buildRPSecurityData().wua;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return scanFaceWSecurityData;
    }

    public static void loginRpcEntranceTracker(LoginParam loginParam) {
        if (loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            properties.setProperty("loginId", loginParam.loginAccount + "");
            properties.setProperty("site", loginParam.loginSite + "");
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_RPC, "", loginParam.loginSourceType, properties);
            AppMonitorAdapter.commitSuccess("Page_Member_Login", "loginMonitorPoint", "action=loginRpc;biz=" + loginParam.loginSourceType + ";page=" + loginParam.loginSourcePage);
        }
    }

    private static <V extends RpcResponse<?>> void requestWithRemoteBusiness(RpcRequest rpcRequest, V v, RpcRequestCallback rpcRequestCallback) {
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, v.getClass(), rpcRequestCallback);
    }

    private void tokenLoginFailure(String str, LoginParam loginParam, RpcResponse rpcResponse, boolean z) {
        String str2;
        String str3;
        Properties properties = new Properties();
        if (loginParam != null) {
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            properties.setProperty("continueLogin", z ? "T" : UTConstant.Args.UT_SUCCESS_F);
            properties.setProperty("loginId", loginParam.loginAccount + "");
            properties.setProperty("site", loginParam.loginSite + "");
        }
        if (loginParam != null) {
            str2 = UTConstant.getLoginTypeByTraceId(loginParam.traceId);
            if (TextUtils.isEmpty(str2)) {
                str2 = UTConstant.getLoginTypeByTokenType(loginParam.tokenType);
            }
        } else {
            str2 = "";
        }
        if (rpcResponse == null) {
            str3 = "-1";
        } else {
            str3 = rpcResponse.code + "";
        }
        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_LOGIN_FAIL, str3, str2, properties);
        Properties properties2 = new Properties();
        properties2.setProperty("monitor", "T");
        if (loginParam != null) {
            properties2.setProperty("loginId", loginParam.loginAccount + "");
            properties2.setProperty("site", loginParam.loginSite + "");
        }
        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str3, str2, properties2);
    }

    public RpcResponse<MLoginTokenReturnValue> applyToken(int i, String str, Map<String, String> map) {
        HistoryAccount findHistoryAccount;
        RpcRequest rpcRequest = new RpcRequest();
        if (map == null) {
            map = new HashMap<>();
        }
        rpcRequest.requestSite = i;
        if (i == 4) {
            rpcRequest.API_NAME = ApiConstants.ApiName.OCEAN_APPLY_SSO_TOKEN;
            rpcRequest.VERSION = "1.0";
            rpcRequest.addParam("userId", str);
            map.put(ApiConstants.ApiField.OCEAN_APPKEY, DataProviderFactory.getDataProvider().getOceanAppkey());
        } else {
            rpcRequest.API_NAME = "com.taobao.mtop.mLoginTokenService.applySsoToken";
            rpcRequest.VERSION = "1.1";
        }
        rpcRequest.addParam("ext", JSON.toJSONString(map));
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
        applyTokenRequest.t = System.currentTimeMillis();
        applyTokenRequest.appVersion = AppInfo.getInstance().getAndroidAppVersion();
        applyTokenRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
        applyTokenRequest.site = i;
        if (!TextUtils.isEmpty(str) && (findHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(Long.parseLong(str))) != null) {
            applyTokenRequest.deviceTokenKey = findHistoryAccount.tokenKey;
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getAppkey())) {
                deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            }
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(str);
            deviceTokenSignParam.addTimestamp(String.valueOf(applyTokenRequest.t));
            deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
            if (!TextUtils.isEmpty(findHistoryAccount.tokenKey)) {
                applyTokenRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(findHistoryAccount.tokenKey, deviceTokenSignParam.build());
            }
        }
        rpcRequest.addParam("request", JSON.toJSONString(applyTokenRequest));
        return ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, LoginTokenResponseData.class, str);
    }

    public RpcRequest buildLoginByTokenRequest(LoginParam loginParam) {
        loginRpcEntranceTracker(loginParam);
        return getTokenLoginRpcRequest(loginParam);
    }

    public RpcRequest buildPwdLoginRequest(LoginParam loginParam) {
        loginRpcEntranceTracker(loginParam);
        RpcRequest rpcRequest = new RpcRequest();
        PasswordLoginRequest passwordLoginRequest = new PasswordLoginRequest();
        Map map = loginParam.externParams;
        if (map == null) {
            map = new HashMap();
        }
        map.put("apiVersion", "2.0");
        try {
            map.put("deviceName", Build.getMODEL());
            map.put("sdkTraceId", loginParam.traceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = loginParam.h5QueryString;
        if (str != null) {
            map.put("aliusersdk_h5querystring", str);
        }
        if (LoginSwitch.getSwitch("pwd2sms_pwdpage", "true")) {
            map.put("scene", "recommendLogin");
            map.remove(ApiConstants.ApiField.SNS_BIND_TITLE);
            map.remove(ApiConstants.ApiField.SNS_BIND_CONTENT);
        }
        if (LoginSwitch.getSwitch(LoginSwitch.PWD_ERROR_TO_ALIPAY, "true")) {
            map.put("alipayInstalled", String.valueOf(loginParam.alipayInstalled));
        }
        if (loginParam.loginSite == 4) {
            rpcRequest.API_NAME = ApiConstants.ApiName.OCEAN_PW_LOGIN;
            rpcRequest.VERSION = "1.0";
            passwordLoginRequest.loginType = AccountType.ICBU_ACCOUNT.getType();
            if (!TextUtils.isEmpty(loginParam.snsToken)) {
                map.put(ApiConstants.ApiField.SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
            }
            map.put(ApiConstants.ApiField.OCEAN_APPKEY, DataProviderFactory.getDataProvider().getOceanAppkey());
        } else {
            rpcRequest.API_NAME = ApiConstants.ApiName.PW_LOGIN;
            rpcRequest.VERSION = "1.0";
            passwordLoginRequest.loginType = loginParam.loginType;
            if (!TextUtils.isEmpty(loginParam.snsToken)) {
                map.put(ApiConstants.ApiField.SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
            }
        }
        addEaExt(map);
        rpcRequest.addParam("ext", JSON.toJSONString(map));
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        passwordLoginRequest.site = i;
        passwordLoginRequest.locale = ResourceUtil.getLocaleStr();
        passwordLoginRequest.loginId = loginParam.loginAccount;
        if (!TextUtils.isEmpty(loginParam.loginPassword)) {
            try {
                String rsaPubkey = RSAKey.getRsaPubkey();
                if (!TextUtils.isEmpty(rsaPubkey)) {
                    passwordLoginRequest.password = Rsa.encrypt(loginParam.loginPassword, rsaPubkey);
                } else {
                    TLogAdapter.e("login.UserLoginServiceImpl", "RSAKey == null");
                    throw new RpcException("getRsaKeyResult is null");
                }
            } catch (RpcException e2) {
                throw new RpcException("get RSA exception===> " + e2.getMessage());
            }
        }
        passwordLoginRequest.pwdEncrypted = true;
        passwordLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        buildBaseRequest(loginParam, passwordLoginRequest);
        passwordLoginRequest.t = System.currentTimeMillis();
        if (!TextUtils.isEmpty(loginParam.deviceTokenKey)) {
            passwordLoginRequest.deviceTokenKey = loginParam.deviceTokenKey;
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(String.valueOf(loginParam.havanaId));
            deviceTokenSignParam.addTimestamp(String.valueOf(passwordLoginRequest.t));
            deviceTokenSignParam.addSDKVersion(passwordLoginRequest.sdkVersion);
            passwordLoginRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(passwordLoginRequest.deviceTokenKey, deviceTokenSignParam.build());
            passwordLoginRequest.hid = loginParam.havanaId + "";
        }
        rpcRequest.addParam("loginInfo", JSON.toJSONString(passwordLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(getScanFaceWSecurityData()));
        return rpcRequest;
    }

    public RpcRequest buildSimLoginRequest(LoginParam loginParam) {
        return buildSimLoginRequestInner(loginParam, ApiConstants.ApiName.API_SIM_LOGIN, "", null);
    }

    public RpcRequest buildSimLoginRequestInner(LoginParam loginParam, String str, String str2, Map<String, String> map) {
        loginRpcEntranceTracker(loginParam);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = str;
        rpcRequest.VERSION = "1.0";
        SimLoginRequest simLoginRequest = new SimLoginRequest();
        buildBaseRequest(loginParam, simLoginRequest);
        simLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        simLoginRequest.accessCode = loginParam.token;
        if (!TextUtils.isEmpty(str2)) {
            simLoginRequest.loginId = loginParam.loginAccount;
        }
        simLoginRequest.site = loginParam.loginSite;
        Map map2 = loginParam.externParams;
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (ApiConstants.ApiName.API_SIM_LOGIN.equals(str)) {
            map2.put("syncMobileReopenCheck", "true");
        }
        map2.put("apiVersion", "2.0");
        try {
            map2.put("deviceName", Build.getMODEL());
            map2.put("newSimLogin", "true");
            map2.put("sdkTraceId", loginParam.traceId);
            if (map != null) {
                map2.putAll(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(loginParam.snsToken)) {
            map2.put(ApiConstants.ApiField.SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
        }
        addEaExt(map2);
        rpcRequest.addParam("ext", JSON.toJSONString(map2));
        rpcRequest.addParam("loginInfo", JSON.toJSONString(simLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        return rpcRequest;
    }

    public RpcRequest buildSimLoginWithUserInputRequest(LoginParam loginParam) {
        return buildSimLoginRequestInner(loginParam, ApiConstants.ApiName.API_SIM_MOBILE_LOGIN, loginParam.loginAccount, null);
    }

    public RpcRequest buildUnifySsoTokenLoginRequest(LoginParam loginParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.UNIFY_SSO_LOGIN;
        rpcRequest.VERSION = "1.0";
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        buildBaseRequest(loginParam, tokenLoginRequest);
        tokenLoginRequest.token = loginParam.token;
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        tokenLoginRequest.site = i;
        tokenLoginRequest.locale = ResourceUtil.getLocaleStr();
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        return rpcRequest;
    }

    public RpcResponse easyLogin(LoginParam loginParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.EASY_LOGIN;
        rpcRequest.VERSION = "1.0";
        PasswordLoginRequest passwordLoginRequest = new PasswordLoginRequest();
        passwordLoginRequest.loginId = loginParam.loginAccount;
        passwordLoginRequest.password = loginParam.loginPassword;
        int i = loginParam.loginSite;
        passwordLoginRequest.site = i;
        if (i == 4) {
            passwordLoginRequest.loginType = AccountType.ICBU_ACCOUNT.getType();
        }
        rpcRequest.requestSite = loginParam.loginSite;
        rpcRequest.addParam("loginInfo", JSON.toJSONString(passwordLoginRequest));
        return ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId));
    }

    public RpcResponse getAppLaunchInfo(LoginParam loginParam) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.GET_APP_LAUNCH_INFO;
        rpcRequest.VERSION = "1.0";
        MemberRequestBase memberRequestBase = new MemberRequestBase();
        memberRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        memberRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        memberRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        memberRequestBase.utdid = AppInfo.getInstance().getUtdid();
        memberRequestBase.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        memberRequestBase.locale = ResourceUtil.getLocaleStr();
        return ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, AppLaunchInfoResponseData.class);
    }

    public void getScanToken(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildScanRequest = buildScanRequest(loginParam, ApiConstants.ApiName.FETCH_LOING_SCAN_TOKEN);
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "2.0");
        try {
            hashMap.put("deviceName", Build.getMODEL());
            hashMap.put("sdkTraceId", loginParam.traceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        buildScanRequest.addParam("ext", JSON.toJSONString(hashMap));
        buildScanRequest.addParam("riskControlInfo", JSON.toJSONString(getScanFaceWSecurityData()));
        requestWithRemoteBusiness(buildScanRequest, new GetVerifyTokenResponseData(), rpcRequestCallback);
    }

    @NonNull
    public RpcRequest getTokenLoginRpcRequest(LoginParam loginParam) {
        RpcRequest rpcRequest = new RpcRequest();
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        Map map = loginParam.externParams;
        if (map == null) {
            map = new HashMap();
        }
        map.put("apiVersion", "2.0");
        try {
            map.put("deviceName", Build.getMODEL());
            map.put("sdkTraceId", loginParam.traceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = loginParam.h5QueryString;
        if (str != null) {
            map.put("aliusersdk_h5querystring", str);
        }
        addEaExt(map);
        if (loginParam.loginSite == 4) {
            rpcRequest.API_NAME = ApiConstants.ApiName.OCEAN_TOKEN_LOGIN;
            rpcRequest.VERSION = "1.0";
            if (!TextUtils.isEmpty(loginParam.snsToken)) {
                map.put(ApiConstants.ApiField.SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
            }
            map.put(ApiConstants.ApiField.OCEAN_APPKEY, DataProviderFactory.getDataProvider().getOceanAppkey());
            tokenLoginRequest.locale = ResourceUtil.getLocaleStr();
        } else {
            rpcRequest.API_NAME = ApiConstants.ApiName.TOKEN_LOGIN;
            rpcRequest.VERSION = "1.0";
            if (!TextUtils.isEmpty(loginParam.snsToken)) {
                map.put(ApiConstants.ApiField.SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
            }
        }
        rpcRequest.addParam("ext", JSON.toJSONString(map));
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        tokenLoginRequest.site = i;
        buildBaseRequest(loginParam, tokenLoginRequest);
        tokenLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        tokenLoginRequest.tokenType = TokenType.MLOGIN_TOKEN;
        tokenLoginRequest.scene = loginParam.scene;
        tokenLoginRequest.token = loginParam.token;
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        return rpcRequest;
    }

    public RpcResponse<LoginReturnData> loginByAlipaySSOToken(String str, Map<String, Object> map, LoginParam loginParam) {
        loginRpcEntranceTracker(loginParam);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.ALIPAY_SSO_LOGIN;
        rpcRequest.VERSION = "2.0";
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        buildBaseRequest(loginParam, tokenLoginRequest);
        tokenLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        tokenLoginRequest.token = str;
        tokenLoginRequest.ext = map;
        int site = DataProviderFactory.getDataProvider().getSite();
        tokenLoginRequest.site = site;
        rpcRequest.requestSite = site;
        tokenLoginRequest.locale = ResourceUtil.getLocaleStr();
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceName", Build.getMODEL());
            hashMap.put("apiReferer", ApiReferer.getApiRefer());
            if (loginParam != null) {
                hashMap.put("sdkTraceId", loginParam.traceId);
            }
            rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(getScanFaceWSecurityData()));
        return ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, DefaultLoginResponseData.class);
    }

    public RpcResponse loginByToken(LoginParam loginParam) {
        T t;
        RpcResponse post = ((RpcService) ServiceFactory.getService(RpcService.class)).post(buildLoginByTokenRequest(loginParam), DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId));
        if (post != null && (t = post.returnValue) != 0) {
            ((LoginReturnData) t).loginType = loginParam.loginType;
        }
        tokenLoginUT(post, loginParam, true);
        return post;
    }

    public void pwdFailUT(LoginParam loginParam, RpcResponse rpcResponse) {
        String str;
        Properties properties = new Properties();
        properties.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
        String valueOf = rpcResponse != null ? String.valueOf(rpcResponse.code) : UTConstant.CustomEvent.UT_NETWORK_FAIL;
        if (loginParam != null && !TextUtils.isEmpty(loginParam.loginSourcePage)) {
            str = loginParam.loginSourcePage;
        } else if (loginParam != null && loginParam.isFromAccount) {
            properties.setProperty("type", "NoFirstLoginFailure");
            str = UTConstant.PageName.UT_PAGE_HISTORY_LOGIN;
        } else {
            properties.setProperty("type", "TbLoginFailure");
            str = UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
        }
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        properties.setProperty("loginId", loginParam.loginAccount + "");
        properties.setProperty("site", loginParam.loginSite + "");
        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_LOGIN_FAIL, valueOf, LoginType.LocalLoginType.PWD_LOGIN, properties);
        Properties properties2 = new Properties();
        properties2.setProperty("monitor", "T");
        properties2.setProperty("loginId", loginParam.loginAccount + "");
        properties2.setProperty("site", loginParam.loginSite + "");
        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, valueOf, LoginType.LocalLoginType.PWD_LOGIN, properties2);
    }

    public void pwdLoginUT(LoginParam loginParam, RpcResponse rpcResponse) {
        String str;
        if (rpcResponse != null) {
            try {
                if (rpcResponse.actionType != null) {
                    if (loginParam != null && !TextUtils.isEmpty(loginParam.loginSourcePage)) {
                        str = loginParam.loginSourcePage;
                    } else {
                        str = (loginParam == null || !loginParam.isFromAccount) ? UTConstant.PageName.UT_PAGE_FIRST_LOGIN : UTConstant.PageName.UT_PAGE_HISTORY_LOGIN;
                    }
                    if ("SUCCESS".equals(rpcResponse.actionType)) {
                        Properties properties = new Properties();
                        properties.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
                        if (!TextUtils.isEmpty(loginParam.source)) {
                            if (TextUtils.equals("Page_Login5-Reg", loginParam.source)) {
                                properties.setProperty("source", "Page_Login5-RegistSuc");
                            } else if (TextUtils.equals("Page_Login5-Login", loginParam.source)) {
                                properties.setProperty("source", "Page_Login5-LoginSuc");
                            }
                        }
                        properties.setProperty("sdkTraceId", loginParam.traceId + "");
                        properties.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
                        if (loginParam.isFromAccount) {
                            properties.setProperty("type", "NoFirstLoginSuccessByTb");
                        } else {
                            properties.setProperty("type", "TbLoginSuccess");
                        }
                        properties.setProperty("loginId", loginParam.loginAccount + "");
                        properties.setProperty("site", loginParam.loginSite + "");
                        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_LOGIN_SUCCESS, null, LoginType.LocalLoginType.PWD_LOGIN, properties);
                        Properties properties2 = new Properties();
                        properties2.setProperty("sdkTraceId", loginParam.traceId + "");
                        properties2.setProperty("monitor", "T");
                        properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                        properties2.setProperty("loginId", loginParam.loginAccount + "");
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.PWD_LOGIN, properties2);
                        return;
                    } else if ("H5".equals(rpcResponse.actionType)) {
                        Properties properties3 = new Properties();
                        properties3.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                        properties3.setProperty("sdkTraceId", loginParam.traceId + "");
                        properties3.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
                        if (loginParam.isFromAccount) {
                            properties3.setProperty("type", "NoFirstLoginH5");
                        } else {
                            properties3.setProperty("type", "TbLoginH5");
                        }
                        properties3.setProperty("loginId", loginParam.loginAccount + "");
                        properties3.setProperty("site", loginParam.loginSite + "");
                        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_LOGIN_FAIL, String.valueOf(rpcResponse.code), LoginType.LocalLoginType.PWD_LOGIN, properties3);
                        return;
                    } else {
                        pwdFailUT(loginParam, rpcResponse);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                pwdFailUT(loginParam, rpcResponse);
                return;
            }
        }
        pwdFailUT(loginParam, rpcResponse);
    }

    public void tokenLoginUT(RpcResponse rpcResponse, LoginParam loginParam, boolean z) {
        LoginParam loginParam2;
        String str;
        if (loginParam == null) {
            try {
                loginParam2 = new LoginParam();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            loginParam2 = loginParam;
        }
        String str2 = UTConstant.PageName.UT_PAGE_EXTEND;
        if (!TextUtils.isEmpty(loginParam2.loginSourcePage)) {
            str2 = loginParam2.loginSourcePage;
        }
        if (rpcResponse != null && (str = rpcResponse.actionType) != null) {
            boolean equals = "SUCCESS".equals(str);
            String str3 = UTConstant.Args.UT_SUCCESS_F;
            if (equals) {
                Properties properties = new Properties();
                properties.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
                properties.setProperty("type", "ContinueLoginSuccess");
                if (!TextUtils.isEmpty(loginParam2.source)) {
                    if (TextUtils.equals("Page_Login5-Reg", loginParam2.source)) {
                        properties.setProperty("source", "Page_Login5-RegistSuc");
                    } else if (TextUtils.equals("Page_Login5-Login", loginParam2.source)) {
                        properties.setProperty("source", "Page_Login5-LoginSuc");
                    }
                }
                properties.setProperty("sdkTraceId", loginParam2.traceId + "");
                properties.setProperty("spm", loginParam2.spm + "");
                if (z) {
                    str3 = "T";
                }
                properties.setProperty("continueLogin", str3);
                String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(loginParam2.traceId);
                if (TextUtils.isEmpty(loginTypeByTraceId)) {
                    loginTypeByTraceId = UTConstant.getLoginTypeByTokenType(loginParam2.tokenType);
                }
                properties.setProperty("loginId", loginParam2.loginAccount + "");
                properties.setProperty("site", loginParam2.loginSite + "");
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_LOGIN_SUCCESS, null, loginTypeByTraceId, properties);
                Properties properties2 = new Properties();
                properties2.setProperty("sdkTraceId", loginParam2.traceId + "");
                properties2.setProperty("monitor", "T");
                properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                properties2.setProperty("loginId", loginParam2.loginAccount + "");
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", loginTypeByTraceId, properties2);
                return;
            } else if ("H5".equals(rpcResponse.actionType)) {
                Properties properties3 = new Properties();
                properties3.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                properties3.setProperty("type", "ContinueLoginH5");
                properties3.setProperty("sdkTraceId", loginParam2.traceId + "");
                properties3.setProperty("spm", loginParam2.spm + "");
                if (z) {
                    str3 = "T";
                }
                properties3.setProperty("continueLogin", str3);
                properties3.setProperty("loginId", loginParam2.loginAccount + "");
                properties3.setProperty("site", loginParam2.loginSite + "");
                String loginTypeByTraceId2 = UTConstant.getLoginTypeByTraceId(loginParam2.traceId);
                if (TextUtils.isEmpty(loginTypeByTraceId2)) {
                    loginTypeByTraceId2 = UTConstant.getLoginTypeByTokenType(loginParam2.tokenType);
                }
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_LOGIN_FAIL, rpcResponse.code + "", loginTypeByTraceId2, properties3);
                return;
            } else {
                if (!ApiConstants.ResultActionType.REGISTER.equals(rpcResponse.actionType) && !ApiConstants.ResultActionType.TOKENLOGIN.equals(rpcResponse.actionType)) {
                    tokenLoginFailure(str2, loginParam2, rpcResponse, z);
                    return;
                }
                return;
            }
        }
        tokenLoginFailure(str2, loginParam2, rpcResponse, z);
    }

    public RpcResponse unifySsoTokenLogin(LoginParam loginParam) {
        T t;
        RpcResponse post = ((RpcService) ServiceFactory.getService(RpcService.class)).post(buildUnifySsoTokenLoginRequest(loginParam), DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId));
        if (post != null && (t = post.returnValue) != 0) {
            ((LoginReturnData) t).loginType = loginParam.loginType;
        }
        return post;
    }

    public void getAppLaunchInfo(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_SNS_INIT;
        rpcRequest.VERSION = "1.0";
        rpcRequest.connectionTimeoutMilliSecond = 2000;
        rpcRequest.socketTimeoutMilliSecond = 2000;
        MemberRequestBase memberRequestBase = new MemberRequestBase();
        memberRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        memberRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        memberRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        memberRequestBase.utdid = AppInfo.getInstance().getUtdid();
        memberRequestBase.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        buildExt(memberRequestBase);
        memberRequestBase.locale = ResourceUtil.getLocaleStr();
        rpcRequest.addParam("loginInfo", JSON.toJSONString(memberRequestBase));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, AppLaunchInfoResponseData.class, rpcRequestCallback);
    }

    private void buildExt(Map<String, String> map) {
        try {
            map.put("deviceName", Build.getMODEL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
