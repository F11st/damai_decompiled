package com.ali.user.mobile.data;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.filter.IAfterFilter;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginRequestBase;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.PasswordLoginRequest;
import com.ali.user.mobile.rpc.login.model.SMSLoginRequest;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.login4android.config.LoginSwitch;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginComponent {
    private static LoginComponent mRegisterComponent;
    private final String TAG = "login.RegisterComponent";

    private LoginComponent() {
    }

    public static LoginComponent getInstance() {
        if (mRegisterComponent == null) {
            synchronized (LoginComponent.class) {
                if (mRegisterComponent == null) {
                    mRegisterComponent = new LoginComponent();
                }
            }
        }
        return mRegisterComponent;
    }

    private void sendSMSFailUT(LoginParam loginParam, RpcResponse rpcResponse, boolean z) {
        String str;
        String valueOf = rpcResponse != null ? String.valueOf(rpcResponse.code) : UTConstant.CustomEvent.UT_NETWORK_FAIL;
        if (loginParam != null && !TextUtils.isEmpty(loginParam.loginSourcePage)) {
            str = loginParam.loginSourcePage;
        } else {
            str = (loginParam == null || !loginParam.isFromAccount) ? UTConstant.PageName.UT_PAGE_SMS_LOGIN1 : UTConstant.PageName.UT_PAGE_SMS_LOGIN2;
        }
        Properties properties = new Properties();
        if (loginParam != null) {
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
        }
        properties.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
        UserTrackAdapter.sendUT(str, UTConstans.CustomEvent.UT_SMS_SEND_FAIL, valueOf, z ? LoginType.LocalLoginType.NICK_SMS_LOGIN : LoginType.LocalLoginType.SMS_LOGIN, properties);
        AppMonitorAdapter.commitFail("Page_Member_Login", "loginMonitorPoint", valueOf, "action=result;biz=smssend;page=" + str);
    }

    private void smsLoginFailureUT(LoginParam loginParam, RpcResponse rpcResponse, boolean z) {
        String str;
        try {
            Properties properties = new Properties();
            properties.setProperty(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            properties.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
            String str2 = UTConstant.CustomEvent.UT_NETWORK_FAIL;
            if (rpcResponse != null) {
                str2 = String.valueOf(rpcResponse.code);
            }
            if (!TextUtils.isEmpty(loginParam.loginSourcePage)) {
                str = loginParam.loginSourcePage;
            } else {
                str = loginParam.isFromAccount ? UTConstant.PageName.UT_PAGE_SMS_LOGIN2 : UTConstant.PageName.UT_PAGE_SMS_LOGIN1;
            }
            String str3 = LoginType.LocalLoginType.SMS_LOGIN;
            if (z) {
                str3 = LoginType.LocalLoginType.NICK_SMS_LOGIN;
            }
            properties.setProperty("loginId", loginParam.loginAccount + "");
            properties.setProperty("site", loginParam.loginSite + "");
            UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_LOGIN_FAIL, str2, str3, properties);
            Properties properties2 = new Properties();
            properties2.setProperty("sdkTraceId", loginParam.traceId + "");
            properties2.setProperty("monitor", "T");
            properties2.setProperty("loginId", loginParam.loginAccount + "");
            properties2.setProperty("site", loginParam.loginSite + "");
            UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str2, str3, properties2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void smsLoginUT(com.ali.user.mobile.model.LoginParam r13, com.ali.user.mobile.rpc.RpcResponse r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.data.LoginComponent.smsLoginUT(com.ali.user.mobile.model.LoginParam, com.ali.user.mobile.rpc.RpcResponse, boolean):void");
    }

    public RpcRequest buildSendSmsByLoginRequest(LoginParam loginParam) {
        return buildSendSmsByLoginRequest(loginParam, false);
    }

    public RpcRequest buildSmsLoginRequest(LoginParam loginParam) {
        return buildSmsLoginRequest(loginParam, false);
    }

    public RpcResponse getCountryList() {
        return getCountryList(ResourceUtil.getLocaleStr());
    }

    public void sendSMSUT(LoginParam loginParam, RpcResponse rpcResponse, boolean z) {
        String str;
        String str2;
        if (loginParam != null) {
            try {
                if (!TextUtils.isEmpty(loginParam.loginSourcePage)) {
                    str = loginParam.loginSourcePage;
                    if (rpcResponse == null && (str2 = rpcResponse.actionType) != null) {
                        if ("SUCCESS".equals(str2)) {
                            Properties properties = new Properties();
                            if (loginParam != null) {
                                properties.setProperty("sdkTraceId", loginParam.traceId + "");
                            }
                            properties.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
                            properties.setProperty("monitor", "T");
                            UserTrackAdapter.sendUT(str, UTConstans.CustomEvent.UT_SMS_SEND_SUCCESS, "", z ? LoginType.LocalLoginType.NICK_SMS_LOGIN : LoginType.LocalLoginType.SMS_LOGIN, properties);
                            return;
                        }
                        sendSMSFailUT(loginParam, rpcResponse, z);
                        return;
                    }
                    sendSMSFailUT(loginParam, rpcResponse, z);
                }
            } catch (Exception unused) {
                sendSMSFailUT(loginParam, rpcResponse, z);
                return;
            }
        }
        str = (loginParam == null || !loginParam.isFromAccount) ? UTConstant.PageName.UT_PAGE_SMS_LOGIN1 : UTConstant.PageName.UT_PAGE_SMS_LOGIN2;
        if (rpcResponse == null) {
        }
        sendSMSFailUT(loginParam, rpcResponse, z);
    }

    public void sendSmsByLogin(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSendSmsByLoginRequest = buildSendSmsByLoginRequest(loginParam);
        buildSendSmsByLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.data.LoginComponent.1
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                LoginComponent.this.sendSMSUT(loginParam, rpcResponse, false);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSendSmsByLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void sendSmsByLoginWithNick(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSendSmsByLoginRequest = buildSendSmsByLoginRequest(loginParam, true);
        buildSendSmsByLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.data.LoginComponent.2
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                LoginComponent.this.sendSMSUT(loginParam, rpcResponse, true);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSendSmsByLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void smsLogin(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSmsLoginRequest = buildSmsLoginRequest(loginParam);
        buildSmsLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.data.LoginComponent.3
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                LoginComponent.this.smsLoginUT(loginParam, rpcResponse, false);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSmsLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void smsLoginWithNick(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSmsLoginRequest = buildSmsLoginRequest(loginParam, true);
        buildSmsLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.data.LoginComponent.4
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                LoginComponent.this.smsLoginUT(loginParam, rpcResponse, true);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSmsLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public RpcRequest buildSendSmsByLoginRequest(LoginParam loginParam, boolean z) {
        if (loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstans.CustomEvent.UT_SMS_SEND, "", z ? LoginType.LocalLoginType.NICK_SMS_LOGIN : LoginType.LocalLoginType.SMS_LOGIN, properties);
        }
        RpcRequest rpcRequest = new RpcRequest();
        if (z) {
            rpcRequest.API_NAME = ApiConstants.ApiName.API_LOGIN_SEND_SMS_NICK;
            rpcRequest.VERSION = "1.0";
        } else {
            rpcRequest.API_NAME = ApiConstants.ApiName.API_LOGIN_SEND_SMS;
            rpcRequest.VERSION = "1.0";
        }
        SMSLoginRequest sMSLoginRequest = new SMSLoginRequest();
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
        if (loginParam.enableVoiceSMS) {
            map.put("sendAudio", "true");
        }
        String str = loginParam.h5QueryString;
        if (str != null) {
            map.put("aliusersdk_h5querystring", str);
        }
        sMSLoginRequest.loginType = loginParam.loginType;
        rpcRequest.addParam("ext", JSON.toJSONString(map));
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        sMSLoginRequest.site = i;
        sMSLoginRequest.locale = ResourceUtil.getLocaleStr();
        if (z) {
            sMSLoginRequest.nick = loginParam.loginAccount;
        } else {
            sMSLoginRequest.loginId = loginParam.loginAccount;
        }
        sMSLoginRequest.countryCode = loginParam.countryCode;
        sMSLoginRequest.phoneCode = loginParam.phoneCode;
        sMSLoginRequest.smsSid = loginParam.smsSid;
        if (!LoginSwitch.isInABTestRegion(LoginSwitch.SMSCODE_LENGTH, -1) && DataProviderFactory.getDataProvider().getSmsLength() != 4) {
            sMSLoginRequest.codeLength = "6";
        } else {
            sMSLoginRequest.codeLength = "4";
        }
        UserLoginServiceImpl.getInstance();
        UserLoginServiceImpl.buildBaseRequest(loginParam, sMSLoginRequest);
        sMSLoginRequest.t = System.currentTimeMillis();
        if (!TextUtils.isEmpty(loginParam.deviceTokenKey)) {
            sMSLoginRequest.deviceTokenKey = loginParam.deviceTokenKey;
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(String.valueOf(loginParam.havanaId));
            deviceTokenSignParam.addTimestamp(String.valueOf(sMSLoginRequest.t));
            deviceTokenSignParam.addSDKVersion(sMSLoginRequest.sdkVersion);
            sMSLoginRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(sMSLoginRequest.deviceTokenKey, deviceTokenSignParam.build());
            if (Debuggable.isDebug()) {
                TLogAdapter.d("login.RegisterComponent", "mtop key=" + sMSLoginRequest.deviceTokenKey);
                TLogAdapter.d("login.RegisterComponent", "mtop sign=" + sMSLoginRequest.deviceTokenSign);
            }
            ((PasswordLoginRequest) sMSLoginRequest).hid = loginParam.havanaId + "";
        }
        rpcRequest.addParam("loginInfo", JSON.toJSONString(sMSLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        return rpcRequest;
    }

    public RpcRequest buildSmsLoginRequest(LoginParam loginParam, boolean z) {
        if (loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", loginParam.traceId + "");
            properties.setProperty("monitor", "T");
            properties.setProperty("site", loginParam.loginSite + "");
            properties.setProperty("loginId", loginParam.loginAccount + "");
            UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_RPC, properties);
        }
        RpcRequest rpcRequest = new RpcRequest();
        if (z) {
            rpcRequest.API_NAME = ApiConstants.ApiName.API_SMS_LOGIN_NICK;
            rpcRequest.VERSION = "1.0";
        } else {
            rpcRequest.API_NAME = ApiConstants.ApiName.API_SMS_LOGIN;
            rpcRequest.VERSION = "1.0";
        }
        SMSLoginRequest sMSLoginRequest = new SMSLoginRequest();
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
        if (loginParam.enableVoiceSMS) {
            map.put("checkAudio", "true");
        }
        if (!TextUtils.isEmpty(loginParam.snsToken)) {
            map.put(ApiConstants.ApiField.SNS_TRUST_LOGIN_TOKEN, loginParam.snsToken);
        }
        sMSLoginRequest.loginType = loginParam.loginType;
        rpcRequest.addParam("ext", JSON.toJSONString(map));
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        sMSLoginRequest.site = i;
        sMSLoginRequest.locale = ResourceUtil.getLocaleStr();
        if (z) {
            sMSLoginRequest.nick = loginParam.loginAccount;
        } else {
            sMSLoginRequest.loginId = loginParam.loginAccount;
        }
        sMSLoginRequest.countryCode = loginParam.countryCode;
        sMSLoginRequest.phoneCode = loginParam.phoneCode;
        sMSLoginRequest.smsCode = loginParam.smsCode;
        sMSLoginRequest.smsSid = loginParam.smsSid;
        UserLoginServiceImpl.getInstance();
        UserLoginServiceImpl.buildBaseRequest(loginParam, sMSLoginRequest);
        sMSLoginRequest.t = System.currentTimeMillis();
        if (!TextUtils.isEmpty(loginParam.deviceTokenKey)) {
            sMSLoginRequest.deviceTokenKey = loginParam.deviceTokenKey;
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(String.valueOf(loginParam.havanaId));
            deviceTokenSignParam.addTimestamp(String.valueOf(sMSLoginRequest.t));
            deviceTokenSignParam.addSDKVersion(sMSLoginRequest.sdkVersion);
            sMSLoginRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(sMSLoginRequest.deviceTokenKey, deviceTokenSignParam.build());
            ((PasswordLoginRequest) sMSLoginRequest).hid = loginParam.havanaId + "";
        }
        rpcRequest.addParam("loginInfo", JSON.toJSONString(sMSLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        return rpcRequest;
    }

    public RpcResponse getCountryList(String str) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_LOGIN_COUNTRY;
        rpcRequest.VERSION = "1.0";
        LoginRequestBase loginRequestBase = new LoginRequestBase();
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "2.0");
        try {
            hashMap.put("deviceName", Build.getMODEL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
        loginRequestBase.locale = str;
        loginRequestBase.appName = DataProviderFactory.getDataProvider().getAppkey();
        loginRequestBase.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        loginRequestBase.site = DataProviderFactory.getDataProvider().getSite();
        loginRequestBase.sdkVersion = AppInfo.getInstance().getSdkVersion();
        loginRequestBase.ttid = DataProviderFactory.getDataProvider().getTTID();
        loginRequestBase.utdid = AppInfo.getInstance().getUtdid();
        rpcRequest.addParam("info", JSON.toJSONString(loginRequestBase));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        return ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, MtopRegisterInitcontextResponseData.class);
    }
}
