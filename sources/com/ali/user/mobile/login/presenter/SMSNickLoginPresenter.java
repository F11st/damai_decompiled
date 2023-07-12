package com.ali.user.mobile.login.presenter;

import android.text.TextUtils;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.taobao.login4android.config.LoginSwitch;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SMSNickLoginPresenter extends UserMobileLoginPresenter {
    private static final String TAG = "login." + SMSNickLoginPresenter.class.getSimpleName();

    public SMSNickLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
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

    @Override // com.ali.user.mobile.login.presenter.UserMobileLoginPresenter
    public void buildSMSLoginParam(String str, String str2, boolean z) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        this.mLoginParam.isFromAccount = this.mViewer.isHistoryMode();
        this.mLoginParam.loginSite = this.mViewer.getLoginSite();
        LoginParam loginParam = this.mLoginParam;
        loginParam.loginAccount = str;
        loginParam.smsCode = str2;
        if (loginParam.externParams == null) {
            loginParam.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        this.mLoginParam.loginType = this.mViewer.getLoginType().getType();
        LoginParam loginParam2 = this.mLoginParam;
        loginParam2.deviceTokenKey = "";
        loginParam2.havanaId = 0L;
        loginParam2.enableVoiceSMS = z;
    }

    @Override // com.ali.user.mobile.login.presenter.UserMobileLoginPresenter, com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login() {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView == null || !baseLoginView.isActive()) {
                return;
            }
            LoginApi.nickSmsLogin(this.mLoginParam.m104clone(), buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.SMSNickLoginPresenter.1
                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onCancel() {
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onFail(LoginException<LoginReturnData> loginException) {
                    BaseLoginView baseLoginView2 = SMSNickLoginPresenter.this.mViewer;
                    if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                        return;
                    }
                    if (loginException.getCode() == 700) {
                        SMSNickLoginPresenter sMSNickLoginPresenter = SMSNickLoginPresenter.this;
                        sMSNickLoginPresenter.onReceiveAlert(sMSNickLoginPresenter.mLoginParam, loginException.getOrinResponse());
                        return;
                    }
                    SMSNickLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                }
            });
            return;
        }
        super.login();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.UserMobileLoginPresenter, com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (!TextUtils.isEmpty(loginParam.token)) {
            LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
        } else {
            LoginComponent.getInstance().smsLoginWithNick(loginParam, rpcRequestCallback);
        }
    }
}
