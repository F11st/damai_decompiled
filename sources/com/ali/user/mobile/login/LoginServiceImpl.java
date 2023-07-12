package com.ali.user.mobile.login;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.LoginService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.service.impl.UrlUtil;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.constants.LoginStatus;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LoginServiceImpl implements LoginService {
    private final int ONEKEY_LOGIN_FAIL_CODE_LOGIN_DATA_NULL = -1;
    private final int ONEKEY_LOGIN_FAIL_CODE_RESPONSE_NULL = -2;
    private final int ONEKEY_LOGIN_FAIL_CODE_NEED_IV = -3;

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiveUCCH5(Context context, LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, final CommonCallback commonCallback) {
        String str = rpcResponse.returnValue.h5Url;
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        urlParam.loginType = loginParam.nativeLoginType;
        urlParam.loginParam = loginParam;
        UrlUtil.OpenUCC(context, urlParam, new CommonDataCallback() { // from class: com.ali.user.mobile.login.LoginServiceImpl.3
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str2) {
                LoginStatus.resetLoginFlag();
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onFail(i, str2);
                }
            }

            /* JADX WARN: Type inference failed for: r4v6, types: [com.ali.user.mobile.rpc.login.model.LoginReturnData, T] */
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                LoginStatus.resetLoginFlag();
                if (map != null) {
                    String str2 = map.get(UccConstants.PARAM_LOGIN_DATA);
                    if (!TextUtils.isEmpty(str2)) {
                        ?? r4 = (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class);
                        RpcResponse rpcResponse2 = new RpcResponse();
                        rpcResponse2.returnValue = r4;
                        rpcResponse2.actionType = "SUCCESS";
                        LoginDataHelper.processLoginReturnData(true, (LoginReturnData) r4, LoginStatus.browserRefUrl);
                        CommonCallback commonCallback2 = commonCallback;
                        if (commonCallback2 != null) {
                            commonCallback2.onSuccess();
                            return;
                        }
                        return;
                    }
                    CommonCallback commonCallback3 = commonCallback;
                    if (commonCallback3 != null) {
                        commonCallback3.onFail(LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION, "");
                        return;
                    }
                    return;
                }
                CommonCallback commonCallback4 = commonCallback;
                if (commonCallback4 != null) {
                    commonCallback4.onFail(LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void simLogin(final Context context, final LoginParam loginParam, Map<String, String> map, final CommonCallback commonCallback) {
        LoginDataRepository.getInstance().simLogin(loginParam, map, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.LoginServiceImpl.2
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                CommonCallback commonCallback2;
                if (rpcResponse != null) {
                    String str = rpcResponse.actionType;
                    if (!TextUtils.isEmpty(str) && "H5".equals(str)) {
                        if (TextUtils.isEmpty(((LoginReturnData) ((DefaultLoginResponseData) rpcResponse).returnValue).h5Url) || (commonCallback2 = commonCallback) == null) {
                            return;
                        }
                        commonCallback2.onFail(-3, "need iv");
                        return;
                    } else if (ApiConstants.ResultActionType.UCC_H5.equals(str)) {
                        LoginServiceImpl.this.onReceiveUCCH5(context, loginParam, rpcResponse, commonCallback);
                    }
                }
                CommonCallback commonCallback3 = commonCallback;
                if (commonCallback3 != null) {
                    commonCallback3.onFail(rpcResponse == null ? -2 : rpcResponse.code, rpcResponse == null ? "response is null" : rpcResponse.message);
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse != null) {
                    String str = rpcResponse.actionType;
                    if (!TextUtils.isEmpty(str)) {
                        if ("SUCCESS".equals(str)) {
                            LoginReturnData loginReturnData = (LoginReturnData) ((DefaultLoginResponseData) rpcResponse).returnValue;
                            if (loginReturnData != null) {
                                LoginDataHelper.processLoginReturnData(true, loginReturnData, LoginStatus.browserRefUrl);
                                CommonCallback commonCallback2 = commonCallback;
                                if (commonCallback2 != null) {
                                    commonCallback2.onSuccess();
                                    return;
                                }
                                return;
                            }
                            CommonCallback commonCallback3 = commonCallback;
                            if (commonCallback3 != null) {
                                commonCallback3.onFail(-1, "login data is null");
                                return;
                            }
                            return;
                        }
                        CommonCallback commonCallback4 = commonCallback;
                        if (commonCallback4 != null) {
                            commonCallback4.onFail(rpcResponse.code, rpcResponse.message);
                            return;
                        }
                        return;
                    }
                    CommonCallback commonCallback5 = commonCallback;
                    if (commonCallback5 != null) {
                        commonCallback5.onFail(rpcResponse.code, rpcResponse.message);
                        return;
                    }
                    return;
                }
                CommonCallback commonCallback6 = commonCallback;
                if (commonCallback6 != null) {
                    commonCallback6.onFail(-2, "response is null");
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }

    @Override // com.ali.user.mobile.service.LoginService
    public void onekeyLogin(final Context context, final Map<String, String> map, final CommonCallback commonCallback) {
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("openLoginView", new NumAuthTokenCallback() { // from class: com.ali.user.mobile.login.LoginServiceImpl.1
                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, String str) {
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFail(i, str);
                    }
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str) {
                    LoginParam loginParam = new LoginParam();
                    loginParam.token = str;
                    loginParam.tokenType = TokenType.NUMBER;
                    loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                    LoginServiceImpl.this.simLogin(context, loginParam, map, commonCallback);
                }
            });
        }
    }

    @Override // com.ali.user.mobile.service.LoginService
    public void touristLogin(String str, LoginParam loginParam) {
        LoginDataRepository.getInstance().touristLogin(str, loginParam, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.LoginServiceImpl.4
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                BroadCastHelper.sendLoginFailBroadcast(-1, "");
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                LoginReturnData loginReturnData;
                if (rpcResponse != null) {
                    String str2 = rpcResponse.actionType;
                    if (!TextUtils.isEmpty(str2) && "SUCCESS".equals(str2) && (loginReturnData = (LoginReturnData) ((DefaultLoginResponseData) rpcResponse).returnValue) != null) {
                        LoginDataHelper.processLoginReturnData(true, loginReturnData, LoginStatus.browserRefUrl);
                        return;
                    }
                }
                BroadCastHelper.sendLoginFailBroadcast(rpcResponse == null ? -1 : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }
}
