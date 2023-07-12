package com.ali.user.mobile.login.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.UserMobileLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.register.model.MtopCountryCodeContextResult;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.CountryCodeUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserMobileLoginPresenter extends BaseLoginPresenter {
    private static final String TAG = "login." + UserMobileLoginPresenter.class.getSimpleName();

    public UserMobileLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.SMS_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissLoading() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        this.mViewer.dismissLoading();
    }

    private void getRegion(final RpcRequestCallback rpcRequestCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                final MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData;
                new BaseRegistRequest().ext = new HashMap();
                try {
                    mtopRegisterInitcontextResponseData = (MtopRegisterInitcontextResponseData) LoginComponent.getInstance().getCountryList();
                } catch (Throwable th) {
                    th.printStackTrace();
                    mtopRegisterInitcontextResponseData = null;
                }
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RpcRequestCallback rpcRequestCallback2 = rpcRequestCallback;
                        if (rpcRequestCallback2 == null) {
                            return;
                        }
                        MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData2 = mtopRegisterInitcontextResponseData;
                        if (mtopRegisterInitcontextResponseData2 == null) {
                            rpcRequestCallback2.onSystemError(null);
                        } else if (mtopRegisterInitcontextResponseData2.code == 3000) {
                            rpcRequestCallback2.onSuccess(mtopRegisterInitcontextResponseData2);
                        } else {
                            rpcRequestCallback2.onError(mtopRegisterInitcontextResponseData2);
                        }
                    }
                });
            }
        });
    }

    private void newSendSms(String str) {
        this.mViewer.showLoading();
        snewSndSMSAction(this.mLoginParam, str, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.7
            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onCancel() {
                UserMobileLoginPresenter.this.dismissLoading();
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onFail(LoginException<LoginReturnData> loginException) {
                LoginParam loginParam;
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView == null || !baseLoginView.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.dismissLoading();
                if (loginException.getCode() == 800) {
                    if (UserMobileLoginPresenter.this.mViewer != null) {
                        if (loginException.getOrinResponse().code == 14100 && (loginParam = UserMobileLoginPresenter.this.mLoginParam) != null && !TextUtils.isEmpty(loginParam.smsSid) && !TextUtils.isEmpty(UserMobileLoginPresenter.this.mLoginParam.codeLength)) {
                            ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSMSOverLimit(loginException.getOrinResponse());
                            return;
                        }
                        String str2 = loginException.getOrinResponse().message;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = ResourceUtil.getStringById("aliuser_network_error");
                        }
                        BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                        baseLoginView2.alert(str2, "", baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.7.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                BaseLoginView baseLoginView3 = UserMobileLoginPresenter.this.mViewer;
                                if (baseLoginView3 == null || !baseLoginView3.isActive()) {
                                    return;
                                }
                                UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                            }
                        }, null, null);
                        return;
                    }
                    return;
                }
                String msg = loginException.getMsg();
                if (TextUtils.isEmpty(msg)) {
                    msg = ResourceUtil.getStringById("aliuser_network_error");
                }
                UserMobileLoginPresenter.this.mViewer.toast(msg, 0);
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView == null || !baseLoginView.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.dismissLoading();
                LoginReturnData loginReturnData = rpcResponse.returnValue;
                if (loginReturnData != null) {
                    UserMobileLoginPresenter.this.mLoginParam.smsSid = loginReturnData.extMap.get("smsSid");
                    UserMobileLoginPresenter.this.mLoginParam.codeLength = loginReturnData.extMap.get(RegistConstants.REGISTER_CODE_LENGTH);
                    if (!TextUtils.isEmpty(loginReturnData.extMap.get("helpVideoUrl"))) {
                        UserMobileLoginPresenter.this.mLoginParam.helpUrl = loginReturnData.extMap.get("helpVideoUrl");
                    }
                    if (TextUtils.equals(rpcResponse.actionType, "SUCCESS")) {
                        if (rpcResponse.code == 14050) {
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert("", rpcResponse.message, baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.7.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView3 = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView3 == null || !baseLoginView3.isActive()) {
                                        return;
                                    }
                                    UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                }
                            }, null, null);
                            ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
                            return;
                        }
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, true);
                    }
                }
            }
        });
    }

    private void sendSMSAction(final LoginParam loginParam, final String str, final RpcRequestCallback rpcRequestCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isHistoryMode()) {
                    UserMobileLoginPresenter.this.matchHistoryAccount();
                }
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        if (rpcRequestCallback == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(str)) {
                            LoginComponent loginComponent = LoginComponent.getInstance();
                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                            loginComponent.sendSmsByLogin(loginParam, rpcRequestCallback);
                            return;
                        }
                        AnonymousClass6 anonymousClass63 = AnonymousClass6.this;
                        loginParam.loginAccount = str;
                        LoginComponent loginComponent2 = LoginComponent.getInstance();
                        AnonymousClass6 anonymousClass64 = AnonymousClass6.this;
                        loginComponent2.sendSmsByLoginWithNick(loginParam, rpcRequestCallback);
                    }
                });
            }
        });
    }

    private void snewSndSMSAction(LoginParam loginParam, String str, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (TextUtils.isEmpty(str)) {
            LoginApi.smsSend(loginParam, buildTrackingModel(), this.mViewer, loginTasksCallback);
            return;
        }
        loginParam.loginAccount = str;
        LoginApi.nickSmsSend(loginParam, buildTrackingModel(), this.mViewer, loginTasksCallback);
    }

    public void buildSMSLoginParam(String str, String str2, boolean z) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        this.mLoginParam.nativeLoginType = LoginType.ServerLoginType.SMSLogin.getType();
        this.mLoginParam.isFromAccount = this.mViewer.isHistoryMode();
        this.mLoginParam.loginSite = this.mViewer.getLoginSite();
        LoginParam loginParam = this.mLoginParam;
        loginParam.loginAccount = str;
        loginParam.smsCode = str2;
        if (loginParam.externParams == null) {
            loginParam.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        this.mLoginParam.externParams.put("showReigsterPolicy", "true");
        this.mLoginParam.loginType = this.mViewer.getLoginType().getType();
        this.mLoginParam.countryCode = ((UserMobileLoginView) this.mViewer).getCountryCode();
        this.mLoginParam.phoneCode = ((UserMobileLoginView) this.mViewer).getPhoneCode();
        LoginParam loginParam2 = this.mLoginParam;
        loginParam2.deviceTokenKey = "";
        loginParam2.havanaId = 0L;
        loginParam2.enableVoiceSMS = z;
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login() {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView == null || !baseLoginView.isActive()) {
                return;
            }
            LoginApi.smsLogin(this.mLoginParam.m104clone(), buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.1
                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onCancel() {
                    UserMobileLoginPresenter.this.dismissLoading();
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onFail(LoginException<LoginReturnData> loginException) {
                    BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                    if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                        return;
                    }
                    UserMobileLoginPresenter.this.dismissLoading();
                    if (loginException.getCode() == 700) {
                        UserMobileLoginPresenter userMobileLoginPresenter = UserMobileLoginPresenter.this;
                        userMobileLoginPresenter.onReceiveAlert(userMobileLoginPresenter.mLoginParam, loginException.getOrinResponse());
                        return;
                    }
                    UserMobileLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                    UserMobileLoginPresenter.this.dismissLoading();
                }
            });
            return;
        }
        super.login();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void onReceiveAlert(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        String str;
        if (this.mViewer != null) {
            String str2 = rpcResponse.message;
            LoginReturnData loginReturnData = rpcResponse.returnValue;
            if (loginReturnData == null || loginReturnData.extMap == null) {
                str = "";
            } else {
                str = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                str2 = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = ResourceUtil.getStringById("aliuser_network_error");
            }
            BaseLoginView baseLoginView = this.mViewer;
            baseLoginView.alert(str, str2, baseLoginView.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                    if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                        return;
                    }
                    UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                    ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onCheckCodeError();
                }
            }, null, null);
        }
    }

    public void region() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        this.mViewer.showLoading();
        getRegion(new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.2
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.mViewer.dismissLoading();
                SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData;
                T t;
                BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive() || (mtopRegisterInitcontextResponseData = (MtopRegisterInitcontextResponseData) rpcResponse) == null || (t = mtopRegisterInitcontextResponseData.returnValue) == 0 || ((MtopCountryCodeContextResult) t).countrycodes == null) {
                    return;
                }
                ArrayList<RegionInfo> fillData = CountryCodeUtil.fillData(ResourceUtil.getStringById("aliuser_common_region"), ((MtopCountryCodeContextResult) mtopRegisterInitcontextResponseData.returnValue).countrycodes, new HashMap(), new ArrayList());
                UserMobileLoginPresenter.this.mViewer.dismissLoading();
                UserMobileLoginPresenter.this.mViewer.onGetRegion(fillData);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.mViewer.dismissLoading();
                SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
            }
        });
    }

    public void sendSMS() {
        sendSMS("");
    }

    public void sendSMS(String str) {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            newSendSms(str);
            return;
        }
        this.mViewer.showLoading();
        sendSMSAction(getLoginParam(), str, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.5
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                LoginParam loginParam;
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView == null || !baseLoginView.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.mViewer.dismissLoading();
                if (rpcResponse != null) {
                    if (TextUtils.equals(rpcResponse.actionType, ApiConstants.ResultActionType.TOAST)) {
                        UserMobileLoginPresenter userMobileLoginPresenter = UserMobileLoginPresenter.this;
                        if (userMobileLoginPresenter.mViewer != null) {
                            if (rpcResponse.code == 14100 && (loginParam = userMobileLoginPresenter.mLoginParam) != null && !TextUtils.isEmpty(loginParam.smsSid) && !TextUtils.isEmpty(UserMobileLoginPresenter.this.mLoginParam.codeLength)) {
                                ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSMSOverLimit(rpcResponse);
                                return;
                            }
                            String str2 = rpcResponse.message;
                            if (TextUtils.isEmpty(str2)) {
                                str2 = ResourceUtil.getStringById("aliuser_network_error");
                            }
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert("", str2, baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.5.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView3 = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView3 == null || !baseLoginView3.isActive()) {
                                        return;
                                    }
                                    UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                }
                            }, null, null);
                            return;
                        }
                        return;
                    }
                    LoginReturnData loginReturnData = (LoginReturnData) rpcResponse.returnValue;
                    if (loginReturnData != null) {
                        if (TextUtils.equals(rpcResponse.actionType, "H5")) {
                            if (!TextUtils.isEmpty(loginReturnData.h5Url)) {
                                String str3 = loginReturnData.h5Url;
                                LoginParam loginParam2 = UserMobileLoginPresenter.this.mLoginParam;
                                loginParam2.tokenType = TokenType.SMS_LOGIN;
                                loginParam2.errorCode = "" + rpcResponse.code;
                                NavigatorManager.getInstance().navToWebViewPage(UserMobileLoginPresenter.this.mViewer.getBaseActivity(), str3, UserMobileLoginPresenter.this.mLoginParam, loginReturnData);
                                return;
                            }
                            String str4 = rpcResponse.message;
                            if (TextUtils.isEmpty(str4)) {
                                str4 = ResourceUtil.getStringById("aliuser_network_error");
                            }
                            UserMobileLoginPresenter.this.mViewer.toast(str4, 0);
                            return;
                        }
                        return;
                    }
                    String str5 = rpcResponse.message;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = ResourceUtil.getStringById("aliuser_network_error");
                    }
                    UserMobileLoginPresenter.this.mViewer.toast(str5, 0);
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView == null || !baseLoginView.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.mViewer.dismissLoading();
                LoginReturnData loginReturnData = (LoginReturnData) rpcResponse.returnValue;
                if (loginReturnData != null) {
                    UserMobileLoginPresenter.this.mLoginParam.smsSid = loginReturnData.extMap.get("smsSid");
                    UserMobileLoginPresenter.this.mLoginParam.codeLength = loginReturnData.extMap.get(RegistConstants.REGISTER_CODE_LENGTH);
                    if (!TextUtils.isEmpty(loginReturnData.extMap.get("helpVideoUrl"))) {
                        UserMobileLoginPresenter.this.mLoginParam.helpUrl = loginReturnData.extMap.get("helpVideoUrl");
                    }
                    if (TextUtils.equals(rpcResponse.actionType, "SUCCESS")) {
                        if (rpcResponse.code == 14050) {
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert("", rpcResponse.message, baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.5.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView3 = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView3 == null || !baseLoginView3.isActive()) {
                                        return;
                                    }
                                    UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                }
                            }, null, null);
                            ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
                            return;
                        }
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, true);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView == null || !baseLoginView.isActive()) {
                    return;
                }
                UserMobileLoginPresenter.this.mViewer.dismissLoading();
                if (rpcResponse != null) {
                    SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException(Integer.valueOf(rpcResponse.code), rpcResponse.message));
                } else {
                    SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (!TextUtils.isEmpty(loginParam.token)) {
            if (!TextUtils.isEmpty(loginParam.snsType)) {
                LoginStatus.loginEntrance = loginParam.snsType;
            } else {
                LoginStatus.loginEntrance = loginParam.tokenType;
            }
            LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
            return;
        }
        if (TextUtils.isEmpty(loginParam.snsToken)) {
            LoginStatus.loginEntrance = LoginType.ServerLoginType.SMSLogin.getType();
        }
        LoginComponent.getInstance().smsLogin(loginParam, rpcRequestCallback);
    }
}
