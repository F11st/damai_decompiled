package com.ali.user.mobile.login;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.filter.IAfterFilter;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.TokenLoginRequest;
import com.ali.user.mobile.rpc.login.model.TouristLoginRequest;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.security.realidentity.jsbridge.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginDataRepository {
    private static LoginDataRepository instance;

    private LoginDataRepository() {
    }

    public static LoginDataRepository getInstance() {
        if (instance == null) {
            synchronized (LoginDataRepository.class) {
                if (instance == null) {
                    instance = new LoginDataRepository();
                }
            }
        }
        return instance;
    }

    public void finger(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        UserLoginServiceImpl.loginRpcEntranceTracker(loginParam);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.BIOMETRIC_LOGIN;
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        UserLoginServiceImpl.getInstance();
        UserLoginServiceImpl.buildBaseRequest(loginParam, tokenLoginRequest);
        tokenLoginRequest.token = loginParam.token;
        tokenLoginRequest.biometricId = loginParam.biometricId;
        tokenLoginRequest.site = DataProviderFactory.getDataProvider().getSite();
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.7
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                UserLoginServiceImpl.getInstance().tokenLoginUT(rpcResponse, loginParam, false);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, DefaultLoginResponseData.class, rpcRequestCallback);
    }

    public void loginByToken(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildLoginByTokenRequest = UserLoginServiceImpl.getInstance().buildLoginByTokenRequest(loginParam);
        buildLoginByTokenRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.3
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                UserLoginServiceImpl.getInstance().tokenLoginUT(rpcResponse, loginParam, true);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildLoginByTokenRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void simLogin(final LoginParam loginParam, Map<String, String> map, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSimLoginRequestInner = UserLoginServiceImpl.getInstance().buildSimLoginRequestInner(loginParam, ApiConstants.ApiName.API_SIM_LOGIN, "", map);
        buildSimLoginRequestInner.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.1
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                UserLoginServiceImpl.getInstance().tokenLoginUT(rpcResponse, loginParam, false);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSimLoginRequestInner, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void simLoginWithUserInput(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSimLoginWithUserInputRequest = UserLoginServiceImpl.getInstance().buildSimLoginWithUserInputRequest(loginParam);
        buildSimLoginWithUserInputRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.4
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                UserLoginServiceImpl.getInstance().tokenLoginUT(rpcResponse, loginParam, false);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSimLoginWithUserInputRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void touristLogin(String str, LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.TOURIST_LOGIN;
        rpcRequest.VERSION = "1.0";
        TouristLoginRequest touristLoginRequest = new TouristLoginRequest();
        touristLoginRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
        touristLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
        touristLoginRequest.ttid = DataProviderFactory.getDataProvider().getTTID();
        touristLoginRequest.utdid = AppInfo.getInstance().getUtdid();
        touristLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        touristLoginRequest.thirdId = str;
        touristLoginRequest.deviceType = "device_app";
        touristLoginRequest.site = DataProviderFactory.getDataProvider().getSite();
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "2.0");
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
        rpcRequest.addParam(a.I, JSON.toJSONString(touristLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, DefaultLoginResponseData.class, rpcRequestCallback);
    }

    public void unifyLoginWithTaobaoGW(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildPwdLoginRequest = UserLoginServiceImpl.getInstance().buildPwdLoginRequest(loginParam);
        buildPwdLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.2
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                UserLoginServiceImpl.getInstance().pwdLoginUT(loginParam, rpcResponse);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildPwdLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void unifySsoTokenLogin(final LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        RpcRequest buildUnifySsoTokenLoginRequest = UserLoginServiceImpl.getInstance().buildUnifySsoTokenLoginRequest(loginParam);
        buildUnifySsoTokenLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.6
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse == null || (t = rpcResponse.returnValue) == 0 || (loginParam2 = loginParam) == null) {
                    return "STOP";
                }
                ((LoginReturnData) t).loginType = loginParam2.loginType;
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildUnifySsoTokenLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void simLogin(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest buildSimLoginRequest = UserLoginServiceImpl.getInstance().buildSimLoginRequest(loginParam);
        buildSimLoginRequest.addAfter(new IAfterFilter() { // from class: com.ali.user.mobile.login.LoginDataRepository.5
            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                T t;
                LoginParam loginParam2;
                if (rpcResponse != null && (t = rpcResponse.returnValue) != 0 && (loginParam2 = loginParam) != null) {
                    ((LoginReturnData) t).loginType = loginParam2.loginType;
                }
                UserLoginServiceImpl.getInstance().tokenLoginUT(rpcResponse, loginParam, false);
                return "STOP";
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(buildSimLoginRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }
}
