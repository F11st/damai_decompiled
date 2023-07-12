package com.ali.user.mobile.login.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.BasePresenter;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.OnLoginCaller;
import com.ali.user.mobile.data.DataRepository;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.AccountType;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.ui.BaseLoginFragment;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResponseData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.url.service.impl.UrlUtil;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.mobile.webview.LoginPostHandler;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BaseLoginPresenter implements BasePresenter {
    public static final int FACE_LOGIN_REQUEST = 1004;
    public static final int SEND_SMS_NICK_REQUEST = 1003;
    public static final int SEND_SMS_REQUEST = 1001;
    protected static final String TAG = "login." + BaseLoginPresenter.class.getSimpleName();
    public LoginParam mLoginParam;
    protected BaseLoginView mViewer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.user.mobile.login.presenter.BaseLoginPresenter$3  reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ RpcRequestCallback val$callback;
        final /* synthetic */ LoginParam val$loginParam;

        AnonymousClass3(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
            this.val$loginParam = loginParam;
            this.val$callback = rpcRequestCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseLoginView baseLoginView = BaseLoginPresenter.this.mViewer;
            if (baseLoginView != null && baseLoginView.isHistoryMode()) {
                BaseLoginPresenter.this.matchHistoryAccount();
            }
            try {
                LoginParam loginParam = this.val$loginParam;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                this.val$loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
                this.val$loginParam.isFromAccount = BaseLoginPresenter.this.mViewer.isHistoryMode();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    RpcRequestCallback rpcRequestCallback = anonymousClass3.val$callback;
                    if (rpcRequestCallback == null) {
                        return;
                    }
                    LoginParam loginParam2 = anonymousClass3.val$loginParam;
                    if (loginParam2 == null) {
                        rpcRequestCallback.onSystemError(null);
                    } else {
                        BaseLoginPresenter.this.login(loginParam2, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.3.1.1
                            @Override // com.ali.user.mobile.callback.RpcRequestCallback
                            public void onError(RpcResponse rpcResponse) {
                                RpcRequestCallback rpcRequestCallback2 = AnonymousClass3.this.val$callback;
                                if (rpcRequestCallback2 != null) {
                                    rpcRequestCallback2.onError(rpcResponse);
                                }
                            }

                            @Override // com.ali.user.mobile.callback.RpcRequestCallback
                            public void onSuccess(RpcResponse rpcResponse) {
                                RpcRequestCallback rpcRequestCallback2 = AnonymousClass3.this.val$callback;
                                if (rpcRequestCallback2 != null) {
                                    rpcRequestCallback2.onSuccess(rpcResponse);
                                }
                            }

                            @Override // com.ali.user.mobile.callback.RpcRequestCallback
                            public void onSystemError(RpcResponse rpcResponse) {
                                RpcRequestCallback rpcRequestCallback2 = AnonymousClass3.this.val$callback;
                                if (rpcRequestCallback2 != null) {
                                    rpcRequestCallback2.onSystemError(rpcResponse);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public BaseLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        this.mViewer = baseLoginView;
        this.mLoginParam = loginParam;
        if (loginParam == null || !TextUtils.isEmpty(loginParam.token)) {
            return;
        }
        this.mLoginParam.loginSite = this.mViewer.getLoginSite();
    }

    protected void addNativeLoginType(LoginParam loginParam) {
        if (this instanceof UserMobileLoginPresenter) {
            loginParam.nativeLoginType = LoginType.ServerLoginType.SMSLogin.getType();
        } else if (this instanceof UserLoginPresenter) {
            loginParam.nativeLoginType = LoginType.ServerLoginType.PasswordLogin.getType();
        }
    }

    public void buildLoginParam(String str, String str2) {
        buildLoginParam(str, str2, false);
    }

    public void buildTokenParam(LoginParam loginParam, String str, String str2, String str3) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        this.mLoginParam.loginSite = this.mViewer.getLoginSite();
        LoginParam loginParam2 = this.mLoginParam;
        loginParam2.token = str;
        loginParam2.tokenType = str2;
        loginParam2.scene = str3;
        if (loginParam2.externParams == null) {
            loginParam2.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        if (loginParam != null) {
            LoginParam loginParam3 = this.mLoginParam;
            loginParam3.traceId = loginParam.traceId;
            loginParam3.loginSourcePage = loginParam.loginSourcePage;
            loginParam3.loginSourceSpm = loginParam.loginSourceSpm;
            loginParam3.loginSourceType = loginParam.loginSourceType;
        }
    }

    public void callApi() {
        LoginApi.tokenLogin(this.mLoginParam, null, null, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.1
            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onCancel() {
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onFail(LoginException<LoginReturnData> loginException) {
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cleanDataHodler() {
        LoginParam loginParam = this.mLoginParam;
        if (loginParam == null || loginParam.isFromRegister || loginParam.isFoundPassword) {
            return;
        }
        loginParam.scene = null;
        loginParam.token = null;
        Map<String, String> map = loginParam.externParams;
        if (map != null) {
            map.remove(LoginConstant.EXT_ACTION);
        }
    }

    public void directRegister(RegistParam registParam, String str, final String str2) {
        String str3;
        final String str4;
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        BaseLoginView baseLoginView2 = this.mViewer;
        if (baseLoginView2 instanceof BaseLoginFragment) {
            str4 = ((BaseLoginFragment) baseLoginView2).getPageName();
            str3 = ((BaseLoginFragment) this.mViewer).getPageSpm();
        } else {
            str3 = null;
            str4 = UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = ApiReferer.generateTraceId(LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN, str4);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", str2);
        UserTrackAdapter.control(str4, str3, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN, hashMap);
        if (registParam == null) {
            registParam = new RegistParam();
        }
        this.mViewer.showLoading();
        DataRepository.getInstance().directRegister(registParam, str, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.4
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                String str5;
                String str6;
                BaseLoginView baseLoginView3 = BaseLoginPresenter.this.mViewer;
                if (baseLoginView3 == null || !baseLoginView3.isActive()) {
                    return;
                }
                BaseLoginPresenter.this.mViewer.dismissLoading();
                BaseLoginView baseLoginView4 = BaseLoginPresenter.this.mViewer;
                if (baseLoginView4 == null || !baseLoginView4.isActive()) {
                    return;
                }
                if (rpcResponse == null) {
                    str5 = UTConstant.ErrorCode.LOGIN2REG_ERROR;
                } else {
                    str5 = rpcResponse.code + "";
                }
                String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(str2);
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(str4, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str5, loginTypeByTraceId, properties);
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                if (rpcResponse == null) {
                    str6 = "-1";
                } else {
                    str6 = rpcResponse.code + "";
                }
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_FAILURE, str6, UTConstant.getLoginTypeByTraceId(str2), properties2);
                BaseLoginPresenter.this.mViewer.toast(rpcResponse != null ? rpcResponse.message : "", 0);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView3 = BaseLoginPresenter.this.mViewer;
                if (baseLoginView3 == null || !baseLoginView3.isActive()) {
                    return;
                }
                BaseLoginPresenter.this.mViewer.dismissLoading();
                OceanRegisterResponseData oceanRegisterResponseData = (OceanRegisterResponseData) rpcResponse;
                if (oceanRegisterResponseData != null) {
                    if ("SUCCESS".equals(rpcResponse.actionType)) {
                        AppMonitorAdapter.commitSuccess("Page_Member_Register", "Register_Result");
                        Properties properties = new Properties();
                        properties.setProperty("monitor", "T");
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_SUCCESS, "", UTConstant.getLoginTypeByTraceId(str2), properties);
                        if (oceanRegisterResponseData.returnValue != 0) {
                            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_REGISTER_SUCCESS, new HashMap());
                            BaseLoginPresenter baseLoginPresenter = BaseLoginPresenter.this;
                            LoginParam loginParam = baseLoginPresenter.mLoginParam;
                            loginParam.token = ((OceanRegisterResult) oceanRegisterResponseData.returnValue).continueLoginToken;
                            loginParam.scene = "1012";
                            loginParam.tokenType = UTConstant.CustomEvent.UT_TYPE_SMS_LOGIN_TO_REG;
                            BaseLoginView baseLoginView4 = baseLoginPresenter.mViewer;
                            if (baseLoginView4 instanceof BaseLoginFragment) {
                                loginParam.loginSourcePage = ((BaseLoginFragment) baseLoginView4).getPageName();
                                BaseLoginPresenter baseLoginPresenter2 = BaseLoginPresenter.this;
                                baseLoginPresenter2.mLoginParam.loginSourceSpm = ((BaseLoginFragment) baseLoginPresenter2.mViewer).getPageSpm();
                            }
                            LoginParam loginParam2 = BaseLoginPresenter.this.mLoginParam;
                            loginParam2.traceId = str2;
                            loginParam2.loginSourceType = LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN;
                            loginParam2.loginType = AccountType.TAOBAO_ACCOUNT.getType();
                            BaseLoginPresenter baseLoginPresenter3 = BaseLoginPresenter.this;
                            baseLoginPresenter3.addNativeLoginType(baseLoginPresenter3.mLoginParam);
                            BaseLoginPresenter.this.login();
                        }
                    } else if ("H5".equals(rpcResponse.actionType)) {
                        T t = oceanRegisterResponseData.returnValue;
                        String str5 = ((OceanRegisterResult) t).h5Url;
                        if (t == 0 || TextUtils.isEmpty(str5)) {
                            return;
                        }
                        NavigatorManager.getInstance().navToRegWebViewPage(BaseLoginPresenter.this.mViewer.getBaseActivity(), str5, "", "", null);
                    } else {
                        onError(rpcResponse);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
            }
        });
    }

    public LoginParam getLoginParam() {
        return this.mLoginParam;
    }

    public void login() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        this.mViewer.showLoading();
        unifyLogin(this.mLoginParam, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.2
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView2 = BaseLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                BaseLoginPresenter.this.mViewer.dismissLoading();
                BaseLoginPresenter baseLoginPresenter = BaseLoginPresenter.this;
                baseLoginPresenter.updateLoginParam(baseLoginPresenter.mLoginParam, rpcResponse);
                BaseLoginPresenter baseLoginPresenter2 = BaseLoginPresenter.this;
                baseLoginPresenter2.loginResultAction(baseLoginPresenter2.mLoginParam, rpcResponse);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView2 = BaseLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                BaseLoginPresenter baseLoginPresenter = BaseLoginPresenter.this;
                baseLoginPresenter.updateLoginParam(baseLoginPresenter.mLoginParam, rpcResponse);
                BaseLoginPresenter baseLoginPresenter2 = BaseLoginPresenter.this;
                if (baseLoginPresenter2.loginResultAction(baseLoginPresenter2.mLoginParam, rpcResponse)) {
                    BaseLoginPresenter.this.mViewer.dismissLoading();
                    return;
                }
                OnLoginCaller onLoginCaller = AliUserLogin.mLoginCaller;
                if (onLoginCaller != null) {
                    onLoginCaller.failLogin();
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView2 = BaseLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                BaseLoginPresenter.this.mViewer.dismissLoading();
                if (rpcResponse != null) {
                    SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException(Integer.valueOf(rpcResponse.code), rpcResponse.message));
                } else {
                    SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                }
            }
        });
    }

    protected boolean loginResultAction(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            if (rpcResponse != null) {
                String str = rpcResponse.actionType;
                String str2 = TAG;
                TLogAdapter.d(str2, "loginType=" + loginParam.nativeLoginType + ", actionType=" + str + ", msg=" + rpcResponse.message);
                if (str != null) {
                    if ("SUCCESS".equals(str)) {
                        return onReceiveSuccess(loginParam, rpcResponse);
                    }
                    String valueOf = String.valueOf(rpcResponse.code);
                    String str3 = rpcResponse.message;
                    if (str3 == null) {
                        str3 = "";
                    }
                    AppMonitor.Alarm.commitFail("Page_Login", "login", valueOf, str3);
                    if ("H5".equals(str)) {
                        onReceiveH5(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.TOAST.equals(str)) {
                        onReceiveToast(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.ALERT.equals(str)) {
                        onReceiveAlert(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.REGISTER.equals(str)) {
                        onReceiveRegister(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.NOTIFY.equals(str)) {
                        onReceiveNotify(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.UCC_H5.equals(str)) {
                        onReceiveUCCH5(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.ALERT_WITH_H5.equals(str)) {
                        onReceiveAlertWithH5(loginParam, rpcResponse);
                    } else if (ApiConstants.ResultActionType.TOKENLOGIN.equals(str)) {
                        onReceiveTokenLogin(loginParam, rpcResponse);
                    } else {
                        onReceiverOtherError(rpcResponse);
                    }
                } else {
                    onReceiverOtherError(rpcResponse);
                }
            } else if (this.mViewer != null) {
                SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_tb_login_exception)));
            }
            BaseLoginView baseLoginView2 = this.mViewer;
            if (baseLoginView2 != null) {
                baseLoginView2.onError(rpcResponse);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void matchHistoryAccount() {
        HistoryAccount matchHistoryAccount;
        LoginParam loginParam = this.mLoginParam;
        if (loginParam == null || (matchHistoryAccount = SecurityGuardManagerWraper.matchHistoryAccount(loginParam.loginAccount)) == null) {
            return;
        }
        LoginParam loginParam2 = this.mLoginParam;
        loginParam2.deviceTokenKey = matchHistoryAccount.tokenKey;
        loginParam2.havanaId = matchHistoryAccount.userId;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        UserTrackAdapter.sendUT("onActivityResult");
        if (i == 257 && (i2 == 258 || i2 == 0)) {
            onActivityResultForWebView(i2, intent);
            UserTrackAdapter.sendUT("onActivityResultForWebView");
        } else if (i == 264) {
            onActivityResultForLoginIV(i2, intent);
            UserTrackAdapter.sendUT("onActivityResultForLoginIV");
        }
    }

    protected void onActivityResultForLoginIV(int i, Intent intent) {
        LoginParam loginParam;
        if (i != -1 || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
        if (TextUtils.isEmpty(stringExtra) || (loginParam = (LoginParam) JSON.parseObject(stringExtra, LoginParam.class)) == null) {
            return;
        }
        this.mLoginParam = loginParam;
        if (TextUtils.isEmpty(loginParam.token)) {
            return;
        }
        login();
    }

    protected void onActivityResultForWebView(int i, Intent intent) {
        LoginParam loginParam;
        Map<String, String> map;
        Map<String, String> map2;
        if ((intent != null && "quit".equals(intent.getStringExtra("action"))) || i == 0) {
            cleanDataHodler();
        } else if (intent != null) {
            LoginParam loginParam2 = null;
            try {
                loginParam2 = (LoginParam) intent.getSerializableExtra(WebConstant.SSO_LOGIN_PARAM);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (loginParam2 != null && (map2 = loginParam2.externParams) != null && "continueLogin".equals(map2.get(LoginConstant.EXT_ACTION))) {
                this.mLoginParam.h5QueryString = intent.getStringExtra("aliusersdk_h5querystring");
                LoginParam loginParam3 = this.mLoginParam;
                loginParam3.scene = loginParam2.scene;
                loginParam3.token = loginParam2.token;
                login();
                return;
            }
            LoginParam loginParam4 = this.mLoginParam;
            if (loginParam4 != null && (map = loginParam4.externParams) != null && "continueLogin".equals(map.get(LoginConstant.EXT_ACTION))) {
                this.mLoginParam.h5QueryString = intent.getStringExtra("aliusersdk_h5querystring");
                login();
            } else if (this.mViewer == null || (loginParam = this.mLoginParam) == null) {
            } else {
                loginParam.h5QueryString = intent.getStringExtra("aliusersdk_h5querystring");
                login();
            }
        }
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onDestory() {
        this.mViewer = null;
    }

    public void onLoginFail(RpcResponse<LoginReturnData> rpcResponse) {
        LoginStatus.setLastRefreshCookieTime(0L);
    }

    public void onLoginSuccess(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        LoginDataHelper.onLoginSuccess(loginParam, rpcResponse);
    }

    protected void onReceiveAlert(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (this.mViewer != null) {
            String str = rpcResponse.message;
            if (TextUtils.isEmpty(str)) {
                str = ResourceUtil.getStringById("aliuser_network_error");
            }
            BaseLoginView baseLoginView = this.mViewer;
            baseLoginView.alert("", str, baseLoginView.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseLoginView baseLoginView2 = BaseLoginPresenter.this.mViewer;
                    if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                        return;
                    }
                    BaseLoginPresenter.this.mViewer.dismissAlertDialog();
                }
            }, null, null);
        }
    }

    protected void onReceiveAlertWithH5(final LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        String str = rpcResponse.message;
        final String str2 = rpcResponse.returnValue.h5Url;
        this.mViewer.alert("", str, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (BaseLoginPresenter.this.mViewer != null) {
                    NavigatorManager.getInstance().navToWebViewPage(BaseLoginPresenter.this.mViewer.getBaseActivity(), str2, loginParam, false);
                    BaseLoginPresenter.this.mViewer.dismissAlertDialog();
                }
            }
        }, null, null);
    }

    protected void onReceiveH5(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        LoginReturnData loginReturnData = rpcResponse.returnValue;
        if (!TextUtils.isEmpty(loginReturnData.h5Url)) {
            if (loginParam != null) {
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", loginParam.traceId + "");
                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_TO_H5, properties);
            }
            String str = loginReturnData.h5Url;
            if (loginParam != null) {
                loginParam.tokenType = TokenType.LOGIN;
            }
            loginParam.errorCode = rpcResponse.code + "";
            NavigatorManager.getInstance().navToWebViewPage(this.mViewer.getBaseActivity(), str, loginParam, loginReturnData);
            return;
        }
        this.mViewer.toast(rpcResponse.message, 0);
    }

    protected void onReceiveNotify(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null) {
            baseLoginView.onNotify(rpcResponse);
        }
    }

    protected void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (this.mViewer != null) {
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
            this.mViewer.onNeedReg(login2RegParam);
        }
    }

    protected boolean onReceiveSuccess(final LoginParam loginParam, final RpcResponse<LoginReturnData> rpcResponse) {
        LoginReturnData loginReturnData;
        if (this.mViewer != null) {
            if (rpcResponse != null && (loginReturnData = rpcResponse.returnValue) != null && loginReturnData.extMap != null && !TextUtils.isEmpty(loginReturnData.extMap.get("loginPostUrl"))) {
                String str = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
                if (!TextUtils.isEmpty(rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE)) && !TextUtils.isEmpty(str)) {
                    this.mViewer.onPostSuccess(loginParam, rpcResponse);
                    return false;
                }
                LoginPostHandler.openPostPage(this.mViewer.getBaseActivity(), rpcResponse.returnValue.extMap.get("loginPostUrl"), new LoginFilterCallback() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.6
                    @Override // com.ali.user.mobile.filter.LoginFilterCallback
                    public void onFail(int i, Map<String, String> map) {
                        onSuccess();
                    }

                    @Override // com.ali.user.mobile.filter.LoginFilterCallback
                    public void onSuccess() {
                        BaseLoginView baseLoginView = BaseLoginPresenter.this.mViewer;
                        if (baseLoginView != null) {
                            baseLoginView.onSuccess(loginParam, rpcResponse);
                        } else {
                            LoginDataHelper.onLoginSuccess(loginParam, rpcResponse);
                        }
                    }
                });
            } else {
                this.mViewer.onSuccess(loginParam, rpcResponse);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReceiveToast(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (this.mViewer.loginFailHandler(rpcResponse)) {
            return;
        }
        onReceiveAlert(loginParam, rpcResponse);
    }

    protected void onReceiveTokenLogin(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
    }

    protected void onReceiveUCCH5(final LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        String str = rpcResponse.returnValue.h5Url;
        Activity baseActivity = this.mViewer.getBaseActivity();
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        urlParam.loginType = loginParam.nativeLoginType;
        urlParam.loginParam = loginParam;
        final String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(loginParam.traceId);
        if (TextUtils.isEmpty(loginTypeByTraceId)) {
            loginTypeByTraceId = UTConstant.getLoginTypeByTokenType(loginParam.tokenType);
        }
        UrlUtil.OpenUCC(baseActivity, urlParam, new CommonDataCallback() { // from class: com.ali.user.mobile.login.presenter.BaseLoginPresenter.7
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str2) {
                BaseLoginView baseLoginView;
                BroadCastHelper.sendLoginFailBroadcast(i, str2);
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                properties.setProperty("site", loginParam.loginSite + "");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, i + "", loginTypeByTraceId, properties);
                if (TextUtils.isEmpty(str2) || (baseLoginView = BaseLoginPresenter.this.mViewer) == null || i == 10003 || i == 10004 || i == 15) {
                    return;
                }
                baseLoginView.toast(str2, 0);
            }

            /* JADX WARN: Type inference failed for: r7v4, types: [com.ali.user.mobile.rpc.login.model.LoginReturnData, T] */
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                BaseLoginView baseLoginView;
                if (map != null) {
                    String str2 = map.get(UccConstants.PARAM_LOGIN_DATA);
                    if (!TextUtils.isEmpty(str2)) {
                        ?? r7 = (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class);
                        RpcResponse rpcResponse2 = new RpcResponse();
                        rpcResponse2.returnValue = r7;
                        rpcResponse2.actionType = "SUCCESS";
                        Properties properties = new Properties();
                        properties.setProperty("monitor", "T");
                        properties.setProperty("site", loginParam.loginSite + "");
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", loginTypeByTraceId, properties);
                        if (r7 == 0 || (baseLoginView = BaseLoginPresenter.this.mViewer) == null) {
                            return;
                        }
                        baseLoginView.onSuccess(loginParam, rpcResponse2);
                        return;
                    }
                    BroadCastHelper.sendLoginFailBroadcast(LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION, "");
                    return;
                }
                BroadCastHelper.sendLoginFailBroadcast(LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION, "");
            }
        });
    }

    protected void onReceiverOtherError(RpcResponse<LoginReturnData> rpcResponse) {
        if (this.mViewer == null || TextUtils.isEmpty(rpcResponse.message)) {
            return;
        }
        this.mViewer.toast(rpcResponse.message, 0);
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onStart() {
        LoginParam loginParam = this.mLoginParam;
        if (loginParam != null) {
            if (!TextUtils.isEmpty(loginParam.token)) {
                if (LoginSwitch.isInABTestRegion("api", 10000)) {
                    callApi();
                } else {
                    login();
                }
            } else if (TextUtils.isEmpty(this.mLoginParam.loginAccount)) {
            } else {
                this.mViewer.setLoginAccountInfo(this.mLoginParam.loginAccount);
            }
        }
    }

    public void setSnsToken(String str) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        LoginParam loginParam = this.mLoginParam;
        loginParam.snsToken = str;
        loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        LoginParam loginParam2 = this.mLoginParam;
        if (loginParam2.externParams == null) {
            loginParam2.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
    }

    protected void unifyLogin(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        BackgroundExecutor.execute(new AnonymousClass3(loginParam, rpcRequestCallback));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLoginParam(LoginParam loginParam, RpcResponse rpcResponse) {
        if (rpcResponse == null) {
            return;
        }
        LoginReturnData loginReturnData = (LoginReturnData) rpcResponse.returnValue;
        if (loginReturnData != null) {
            loginParam.scene = loginReturnData.scene;
            loginParam.token = loginReturnData.token;
            loginParam.isFromRegister = false;
            loginParam.isFoundPassword = false;
            loginParam.enableVoiceSMS = false;
            loginParam.h5QueryString = null;
            Map<String, String> map = loginReturnData.extMap;
            if (map != null) {
                if (loginParam.externParams == null) {
                    loginParam.externParams = map;
                    return;
                }
                loginParam.externParams = new HashMap();
                for (Map.Entry<String, String> entry : loginReturnData.extMap.entrySet()) {
                    loginParam.externParams.put(entry.getKey(), entry.getValue());
                }
                return;
            }
            return;
        }
        loginParam.scene = null;
        loginParam.token = null;
        loginParam.tokenType = null;
        loginParam.isFromRegister = false;
        loginParam.enableVoiceSMS = false;
        loginParam.h5QueryString = null;
        loginParam.externParams = null;
    }

    public void buildLoginParam(String str, String str2, boolean z) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        this.mLoginParam.isFromAccount = this.mViewer.isHistoryMode();
        this.mLoginParam.loginSite = this.mViewer.getLoginSite();
        LoginParam loginParam = this.mLoginParam;
        loginParam.loginAccount = str;
        loginParam.loginPassword = str2;
        if (loginParam.externParams == null) {
            loginParam.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        if (z) {
            this.mLoginParam.externParams.put("mobileCheckSimilarity", "true");
        } else {
            this.mLoginParam.externParams.put("mobileCheckSimilarity", "false");
        }
        this.mLoginParam.loginType = this.mViewer.getLoginType().getType();
        LoginParam loginParam2 = this.mLoginParam;
        loginParam2.deviceTokenKey = "";
        loginParam2.havanaId = 0L;
        addNativeLoginType(loginParam2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (TokenType.NUMBER.equals(loginParam.tokenType)) {
            LoginStatus.loginEntrance = TokenType.NUMBER;
            LoginDataRepository.getInstance().simLogin(loginParam, null, rpcRequestCallback);
        } else if (!TextUtils.isEmpty(loginParam.token)) {
            LoginStatus.loginEntrance = loginParam.tokenType;
            LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
        } else {
            LoginStatus.loginEntrance = LoginType.ServerLoginType.PasswordLogin.getType();
            LoginDataRepository.getInstance().unifyLoginWithTaobaoGW(loginParam, rpcRequestCallback);
        }
    }
}
