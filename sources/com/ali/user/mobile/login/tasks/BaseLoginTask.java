package com.ali.user.mobile.login.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventBusEnum;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.AccountType;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.register.RegisterApi;
import com.ali.user.mobile.register.RegisterException;
import com.ali.user.mobile.register.tasks.BaseRegisterTask;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.service.impl.UrlUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.constants.LoginConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public abstract class BaseLoginTask {
    protected static final String TAG = "BaseLoginTask";
    protected WeakReference<BaseView> baseView;
    protected LoginParam loginParam;
    protected TrackingModel trackingModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class LoginRpcRequestCallback implements RpcRequestCallback<LoginReturnData> {
        private final LoginParam loginParam;
        private final LoginTasksCallback<LoginReturnData> loginResultCallback;

        public LoginRpcRequestCallback(LoginParam loginParam, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
            this.loginParam = loginParam;
            this.loginResultCallback = loginTasksCallback;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse<LoginReturnData> rpcResponse) {
            BaseLoginTask.this.dismissLoading();
            BaseLoginTask.this.processLoginResult(this.loginParam, rpcResponse, this.loginResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
            BaseLoginTask.this.dismissLoading();
            BaseLoginTask.this.processLoginResult(this.loginParam, rpcResponse, this.loginResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse<LoginReturnData> rpcResponse) {
            BaseLoginTask.this.dismissLoading();
            LoginTasksCallback<LoginReturnData> loginTasksCallback = this.loginResultCallback;
            if (loginTasksCallback != null) {
                loginTasksCallback.onFail(new LoginException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
            }
        }
    }

    private RpcRequestCallback<LoginReturnData> createLoginRpcCallback(LoginParam loginParam, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        return new LoginRpcRequestCallback(loginParam, loginTasksCallback);
    }

    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.2
            @Override // java.lang.Runnable
            public void run() {
                commonDataCallback.onSuccess(null);
            }
        });
    }

    protected void directRegister(final LoginParam loginParam, Login2RegParam login2RegParam, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        String str;
        String str2;
        String str3;
        if (loginParam != null) {
            str = loginParam.loginSourcePage;
            str2 = loginParam.loginSourceSpm;
            str3 = loginParam.traceId;
        } else {
            str = UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
            str2 = null;
            str3 = "";
        }
        final String str4 = str;
        String str5 = str2;
        final String generateTraceId = TextUtils.isEmpty(str3) ? ApiReferer.generateTraceId(LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN, str4) : str3;
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", generateTraceId);
        UserTrackAdapter.control(str4, str5, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN, hashMap);
        RegistParam registParam = new RegistParam();
        if (DataProviderFactory.getDataProvider().isYoukuApps()) {
            registParam.userSiteHere = true;
            registParam.registSite = 23;
            if (login2RegParam.needTaobao) {
                registParam.registerSiteString = "taobao";
            }
        }
        showLoading();
        RegisterApi.directRegister(registParam, login2RegParam.token, null, this.trackingModel, this.baseView.get(), new BaseRegisterTask.RegisterTasksCallback<OceanRegisterResult>() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.9
            @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask.RegisterTasksCallback
            public void onCancel() {
                LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                if (loginTasksCallback2 != null) {
                    loginTasksCallback2.onCancel();
                }
            }

            @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask.RegisterTasksCallback
            public void onFail(RegisterException<OceanRegisterResult> registerException) {
                String str6;
                BaseLoginTask.this.dismissLoading();
                if (registerException == null) {
                    str6 = UTConstant.ErrorCode.LOGIN2REG_ERROR;
                } else if (registerException.getOrinResponse() != null) {
                    if (RpcException.isSystemError(registerException.getOrinResponse().code) && !TextUtils.isEmpty(registerException.getOrinResponse().msgCode)) {
                        str6 = registerException.getOrinResponse().msgCode;
                    } else {
                        str6 = registerException.getOrinResponse().code + "";
                    }
                } else {
                    str6 = registerException.getCode() + "";
                }
                String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(generateTraceId);
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(str4, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str6, loginTypeByTraceId, properties);
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_FAILURE, str6, UTConstant.getLoginTypeByTraceId(generateTraceId), properties2);
                LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                if (loginTasksCallback2 != null) {
                    loginTasksCallback2.onFail(new LoginException(registerException == null ? Integer.parseInt(UTConstant.ErrorCode.LOGIN2REG_ERROR) : registerException.getCode(), registerException == null ? ResourceUtil.getStringById("aliuser_network_error") : registerException.getMsg()));
                }
            }

            @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask.RegisterTasksCallback
            public void onSuccess(RpcResponse<OceanRegisterResult> rpcResponse) {
                BaseLoginTask.this.dismissLoading();
                if (rpcResponse != null) {
                    AppMonitorAdapter.commitSuccess("Page_Member_Register", "Register_Result");
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_SUCCESS, "", UTConstant.getLoginTypeByTraceId(generateTraceId), properties);
                    if (rpcResponse.returnValue != null) {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_REGISTER_SUCCESS, new HashMap());
                        LoginParam loginParam2 = loginParam;
                        loginParam2.token = rpcResponse.returnValue.continueLoginToken;
                        loginParam2.scene = "1012";
                        loginParam2.tokenType = UTConstant.CustomEvent.UT_TYPE_SMS_LOGIN_TO_REG;
                        if (loginParam2 != null) {
                            loginParam2.loginSourcePage = loginParam2.loginSourcePage;
                            loginParam2.loginSourceSpm = loginParam2.loginSourceSpm;
                        }
                        loginParam2.traceId = generateTraceId;
                        loginParam2.loginSourceType = LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN;
                        loginParam2.loginType = AccountType.TAOBAO_ACCOUNT.getType();
                        loginParam.nativeLoginType = BaseLoginTask.this.getLoginType();
                        BaseLoginTask.this.invokeTokenLoginRpc(loginParam, loginTasksCallback);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.4
            @Override // java.lang.Runnable
            public void run() {
                WeakReference<BaseView> weakReference = BaseLoginTask.this.baseView;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                BaseLoginTask.this.baseView.get().dismissLoading();
            }
        });
    }

    protected abstract String getLoginType();

    protected abstract void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback);

    protected void invokeTokenLoginRpc(LoginParam loginParam, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        showLoading();
        LoginDataRepository.getInstance().loginByToken(loginParam, createLoginRpcCallback(loginParam, loginTasksCallback));
    }

    public void login(LoginParam loginParam, TrackingModel trackingModel, BaseView baseView, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        this.loginParam = loginParam;
        this.trackingModel = trackingModel;
        this.baseView = new WeakReference<>(baseView);
        buildLoginParam(new CommonDataCallback() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.1
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                if (loginTasksCallback2 != null) {
                    loginTasksCallback2.onFail(new LoginException(i, str));
                }
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                BaseLoginTask baseLoginTask = BaseLoginTask.this;
                baseLoginTask.startLogin(baseLoginTask.loginParam, loginTasksCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void matchHistoryAccount() {
        HistoryAccount matchHistoryAccount;
        LoginParam loginParam = this.loginParam;
        if (loginParam == null || !loginParam.isFromAccount || (matchHistoryAccount = SecurityGuardManagerWraper.matchHistoryAccount(loginParam.loginAccount)) == null) {
            return;
        }
        LoginParam loginParam2 = this.loginParam;
        loginParam2.deviceTokenKey = matchHistoryAccount.tokenKey;
        loginParam2.havanaId = matchHistoryAccount.userId;
        loginParam2.isFromAccount = true;
    }

    protected void navToWebViewPage(LoginParam loginParam, final RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        EventBus.getDefault().registerEventListener(EventBusEnum.EventName.ACTION_H5, new EventListener() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.7
            @Override // com.ali.user.mobile.eventbus.EventListener
            public void onEvent(Event event) {
                Map<String, Object> map;
                LoginTasksCallback loginTasksCallback2;
                EventBus.getDefault().unregisterEventListener(EventBusEnum.EventName.ACTION_H5, this);
                if (event != null && (map = event.params) != null) {
                    String str = (String) map.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                    String str2 = (String) event.params.get("result");
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "success")) {
                        LoginParam loginParam2 = (LoginParam) JSON.parseObject(str, LoginParam.class);
                        if (loginParam2 == null) {
                            loginParam2 = new LoginParam();
                        }
                        BaseLoginTask.this.invokeTokenLoginRpc(loginParam2, loginTasksCallback);
                        return;
                    } else if (TextUtils.equals(str2, "cancel") && (loginTasksCallback2 = loginTasksCallback) != null) {
                        loginTasksCallback2.onCancel();
                        return;
                    } else {
                        LoginTasksCallback loginTasksCallback3 = loginTasksCallback;
                        if (loginTasksCallback3 != null) {
                            String str3 = rpcResponse.message;
                            if (str3 == null) {
                                str3 = ResourceUtil.getStringById("aliuser_network_error");
                            }
                            loginTasksCallback3.onFail(new LoginException(604, str3, rpcResponse));
                            return;
                        }
                        return;
                    }
                }
                LoginTasksCallback loginTasksCallback4 = loginTasksCallback;
                if (loginTasksCallback4 != null) {
                    String str4 = rpcResponse.message;
                    if (str4 == null) {
                        str4 = ResourceUtil.getStringById("aliuser_network_error");
                    }
                    loginTasksCallback4.onFail(new LoginException(605, str4, rpcResponse));
                }
            }
        });
        if (loginParam == null) {
            loginParam = new LoginParam();
        }
        loginParam.scene = loginReturnData.scene;
        loginParam.token = loginReturnData.token;
        loginParam.loginSite = loginReturnData.site;
        loginParam.h5QueryString = null;
        Map<String, String> map = loginReturnData.extMap;
        if (map != null) {
            if (loginParam.externParams == null) {
                loginParam.externParams = map;
            } else {
                loginParam.externParams = new HashMap();
                for (Map.Entry<String, String> entry : loginReturnData.extMap.entrySet()) {
                    loginParam.externParams.put(entry.getKey(), entry.getValue());
                }
            }
        }
        UrlParam urlParam = new UrlParam();
        urlParam.url = loginReturnData.h5Url;
        urlParam.token = loginReturnData.token;
        urlParam.scene = loginReturnData.scene;
        urlParam.loginId = loginReturnData.showLoginId;
        urlParam.loginParam = loginParam;
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToWebViewPage(EventBusEnum.EventName.ACTION_H5, urlParam);
    }

    protected void onNeedVerification(LoginParam loginParam, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(603, ""));
        }
    }

    protected void onReceiveAlert(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(700, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    protected void onReceiveAlertWithH5(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(1000, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    protected void onReceiveH5(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        if (loginReturnData == null) {
            if (loginTasksCallback != null) {
                String str = rpcResponse.message;
                if (str == null) {
                    str = ResourceUtil.getStringById("aliuser_network_error");
                }
                loginTasksCallback.onFail(new LoginException<>(601, str, rpcResponse));
            }
        } else if (!TextUtils.isEmpty(loginReturnData.h5Url)) {
            navToWebViewPage(loginParam, rpcResponse, loginTasksCallback);
        } else if (loginTasksCallback != null) {
            String str2 = rpcResponse.message;
            if (str2 == null) {
                str2 = ResourceUtil.getStringById("aliuser_network_error");
            }
            loginTasksCallback.onFail(new LoginException<>(602, str2, rpcResponse));
        }
    }

    protected void onReceiveNotSuccessActionType(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (rpcResponse != null) {
            String valueOf = String.valueOf(rpcResponse.code);
            String str = rpcResponse.message;
            if (str == null) {
                str = "";
            }
            AppMonitorAdapter.commitFail("Page_Login", "login", valueOf, str);
        }
    }

    protected void onReceiveNotify(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(900, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        String str = rpcResponse.message;
        loginParam.token = null;
        Map<String, String> map = loginReturnData.extMap;
        boolean z = true;
        boolean z2 = map != null && "true".equals(map.get("needTaobao"));
        Map<String, String> map2 = loginReturnData.extMap;
        if (map2 != null && ("false".equals(map2.get("showTaobaoAgreement")) || "false".equals(loginReturnData.extMap.get("showAgreement")))) {
            z = false;
        }
        Login2RegParam login2RegParam = new Login2RegParam();
        login2RegParam.h5Url = loginReturnData.h5Url;
        login2RegParam.needAlert = z;
        login2RegParam.needTaobao = z2;
        login2RegParam.token = loginReturnData.token;
        login2RegParam.tips = str;
        Properties properties = new Properties();
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties);
        directRegister(loginParam, login2RegParam, loginTasksCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReceiveSuccess(final LoginParam loginParam, final RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        LoginReturnData loginReturnData;
        AppMonitorAdapter.commitSuccess("Page_Login", "login");
        if (rpcResponse != null && (loginReturnData = rpcResponse.returnValue) != null && loginReturnData.extMap != null && !TextUtils.isEmpty(loginReturnData.extMap.get("loginPostUrl"))) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToLoginPostPage(DataProviderFactory.getApplicationContext(), rpcResponse.returnValue.extMap.get("loginPostUrl"), new LoginFilterCallback() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.5
                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onFail(int i, Map<String, String> map) {
                    BaseLoginTask.this.onSuccessCall(loginParam, rpcResponse, loginTasksCallback);
                }

                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onSuccess() {
                    BaseLoginTask.this.onSuccessCall(loginParam, rpcResponse, loginTasksCallback);
                }
            });
        } else {
            onSuccessCall(loginParam, rpcResponse, loginTasksCallback);
        }
    }

    protected void onReceiveToast(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(800, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    protected void onReceiveTokenLogin(final LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        long j;
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        Map<String, String> map = loginReturnData.extMap;
        if (map == null || TextUtils.isEmpty(map.get("syncWaitTime"))) {
            return;
        }
        try {
            j = Long.parseLong(loginReturnData.extMap.get("syncWaitTime"));
        } catch (Throwable th) {
            th.printStackTrace();
            j = 1000;
        }
        loginParam.token = loginReturnData.token;
        loginParam.scene = loginReturnData.scene;
        MainThreadExecutor.postDelayed(new Runnable() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.6
            @Override // java.lang.Runnable
            public void run() {
                BaseLoginTask.this.invokeTokenLoginRpc(loginParam, loginTasksCallback);
            }
        }, j);
    }

    protected void onReceiveUCCH5(final LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        String str = rpcResponse.returnValue.h5Url;
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        urlParam.loginType = loginParam.nativeLoginType;
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        if (loginReturnData != null) {
            urlParam.token = loginReturnData.token;
            urlParam.scene = loginReturnData.scene;
        }
        urlParam.loginParam = loginParam;
        UrlUtil.OpenUCC(DataProviderFactory.getApplicationContext(), urlParam, new CommonDataCallback() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.8
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str2) {
                LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                if (loginTasksCallback2 != null) {
                    loginTasksCallback2.onFail(new LoginException(1202, ResourceUtil.getStringById("aliuser_network_error")));
                }
            }

            /* JADX WARN: Type inference failed for: r4v6, types: [com.ali.user.mobile.rpc.login.model.LoginReturnData, T] */
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                if (map != null) {
                    String str2 = map.get(UccConstants.PARAM_LOGIN_DATA);
                    if (!TextUtils.isEmpty(str2)) {
                        RpcResponse<LoginReturnData> rpcResponse2 = new RpcResponse<>();
                        rpcResponse2.returnValue = (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class);
                        rpcResponse2.actionType = "SUCCESS";
                        BaseLoginTask.this.onReceiveSuccess(loginParam, rpcResponse2, loginTasksCallback);
                        return;
                    }
                    LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                    if (loginTasksCallback2 != null) {
                        loginTasksCallback2.onFail(new LoginException(1201, ResourceUtil.getStringById("aliuser_network_error")));
                        return;
                    }
                    return;
                }
                LoginTasksCallback loginTasksCallback3 = loginTasksCallback;
                if (loginTasksCallback3 != null) {
                    loginTasksCallback3.onFail(new LoginException(1201, ResourceUtil.getStringById("aliuser_network_error")));
                }
            }
        });
    }

    protected void onReceiverOtherError(RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    protected void onSuccessCall(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        processLoginSessionData(loginParam, rpcResponse);
        if (loginTasksCallback != null) {
            loginTasksCallback.onSuccess(rpcResponse);
        }
    }

    protected void processLoginResult(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (rpcResponse != null) {
            String str = rpcResponse.actionType;
            String str2 = TAG;
            TLogAdapter.d(str2, "loginType=" + loginParam.nativeLoginType + ", actionType=" + str + ", msg=" + rpcResponse.message);
            if (!TextUtils.isEmpty(str)) {
                if ("SUCCESS".equals(str)) {
                    onReceiveSuccess(loginParam, rpcResponse, loginTasksCallback);
                    return;
                }
                onReceiveNotSuccessActionType(loginParam, rpcResponse);
                if ("H5".equals(str)) {
                    onReceiveH5(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.TOAST.equals(str)) {
                    onReceiveToast(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.ALERT.equals(str)) {
                    onReceiveAlert(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.REGISTER.equals(str)) {
                    onReceiveRegister(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.NOTIFY.equals(str)) {
                    onReceiveNotify(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.UCC_H5.equals(str)) {
                    onReceiveUCCH5(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.ALERT_WITH_H5.equals(str)) {
                    onReceiveAlertWithH5(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else if (ApiConstants.ResultActionType.TOKENLOGIN.equals(str)) {
                    onReceiveTokenLogin(loginParam, rpcResponse, loginTasksCallback);
                    return;
                } else {
                    onReceiverOtherError(rpcResponse, loginTasksCallback);
                    return;
                }
            }
            onReceiveNotSuccessActionType(loginParam, rpcResponse);
            onReceiverOtherError(rpcResponse, loginTasksCallback);
            return;
        }
        onReceiveNotSuccessActionType(loginParam, null);
        onReceiverOtherError(null, loginTasksCallback);
    }

    protected void processLoginSessionData(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        if (loginReturnData != null) {
            HashMap hashMap = new HashMap();
            String loginType = getLoginType();
            if (TextUtils.isEmpty(loginType) && loginParam != null && !TextUtils.isEmpty(loginParam.nativeLoginType)) {
                loginType = loginParam.nativeLoginType;
            }
            hashMap.put(LoginConstants.LOGIN_TYPE, loginType);
            LoginDataHelper.processLoginReturnData(true, loginReturnData, loginParam, "", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.BaseLoginTask.3
            @Override // java.lang.Runnable
            public void run() {
                WeakReference<BaseView> weakReference = BaseLoginTask.this.baseView;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                BaseLoginTask.this.baseView.get().showLoading();
            }
        });
    }

    protected void startLogin(LoginParam loginParam, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        showLoading();
        invokeLoginRpc(loginParam, createLoginRpcCallback(loginParam, loginTasksCallback));
    }
}
