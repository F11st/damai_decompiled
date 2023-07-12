package com.ali.user.mobile.login.presenter;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.OneKeyLoginFragment;
import com.ali.user.mobile.login.ui.OneKeyLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.taobao.login4android.config.LoginSwitch;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OneKeyLoginPresenter extends BaseLoginPresenter {
    protected static final String TAG = "login." + OneKeyLoginPresenter.class.getSimpleName();

    public OneKeyLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.SIM_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SIM_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login() {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView == null || !baseLoginView.isActive()) {
                return;
            }
            LoginApi.simLogin(this.mLoginParam, buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.OneKeyLoginPresenter.1
                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onCancel() {
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onFail(LoginException<LoginReturnData> loginException) {
                    BaseLoginView baseLoginView2 = OneKeyLoginPresenter.this.mViewer;
                    if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                        return;
                    }
                    if (loginException.getCode() != 1501 && loginException.getCode() != 1502) {
                        if (loginException.getCode() == 1303 && loginException.getOrinResponse() != null && loginException.getOrinResponse().returnValue != null) {
                            BaseLoginView baseLoginView3 = OneKeyLoginPresenter.this.mViewer;
                            if (baseLoginView3 instanceof OneKeyLoginFragment) {
                                ((OneKeyLoginFragment) baseLoginView3).onNeedVerifyMobileForReg(loginException.getMsg(), loginException.getOrinResponse().returnValue.mobile);
                                return;
                            }
                            return;
                        } else if (loginException.getCode() != 800 && loginException.getCode() != 700) {
                            OneKeyLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                            return;
                        } else {
                            OneKeyLoginPresenter oneKeyLoginPresenter = OneKeyLoginPresenter.this;
                            oneKeyLoginPresenter.onReceiveToast(oneKeyLoginPresenter.mLoginParam, loginException.getOrinResponse());
                            return;
                        }
                    }
                    OneKeyLoginPresenter.this.mViewer.toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_onekey_login_fail_tip), 0);
                    BaseLoginView baseLoginView4 = OneKeyLoginPresenter.this.mViewer;
                    if (baseLoginView4 instanceof OneKeyLoginFragment) {
                        ((OneKeyLoginFragment) baseLoginView4).switchToRecommendLogin();
                    }
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                }
            });
            return;
        }
        super.login();
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    protected void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (this.mViewer != null) {
            LoginReturnData loginReturnData = rpcResponse.returnValue;
            String str = rpcResponse.message;
            loginParam.token = null;
            if (rpcResponse.code == 14044) {
                String str2 = loginParam.loginSourcePage;
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, UTConstant.ErrorCode.LOGIN2REG_CANCEL_ALERT, LoginType.LocalLoginType.SIM_LOGIN, properties);
                ((OneKeyLoginView) this.mViewer).onNeedVerifyMobileForReg(str, loginReturnData.mobile);
                return;
            }
            boolean z = true;
            Map<String, String> map = loginReturnData.extMap;
            String str3 = "";
            if (map != null) {
                z = ("false".equals(map.get("showTaobaoAgreement")) || "false".equals(loginReturnData.extMap.get("showAgreement"))) ? false : false;
                if (!TextUtils.isEmpty(loginReturnData.extMap.get("regHintSubTitle"))) {
                    str3 = loginReturnData.extMap.get("regHintSubTitle");
                }
            }
            Login2RegParam login2RegParam = new Login2RegParam();
            login2RegParam.needAlert = z;
            login2RegParam.token = loginReturnData.token;
            login2RegParam.title = str;
            login2RegParam.subTitle = str3;
            login2RegParam.tips = str;
            this.mViewer.onNeedReg(login2RegParam);
        }
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    protected void onReceiveTokenLogin(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        LoginReturnData loginReturnData;
        if (this.mViewer == null || rpcResponse == null || (loginReturnData = rpcResponse.returnValue) == null) {
            return;
        }
        LoginReturnData loginReturnData2 = loginReturnData;
        long j = 1000;
        Map<String, String> map = loginReturnData2.extMap;
        if (map != null && !TextUtils.isEmpty(map.get("syncWaitTime"))) {
            try {
                j = Long.parseLong(loginReturnData2.extMap.get("syncWaitTime"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ((OneKeyLoginView) this.mViewer).waitTokenLogin(loginReturnData2.token, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void updateLoginParam(LoginParam loginParam, RpcResponse rpcResponse) {
        String str = TokenType.NUMBER.equals(loginParam.tokenType) ? loginParam.token : "";
        super.updateLoginParam(loginParam, rpcResponse);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        loginParam.token = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (!TextUtils.isEmpty(loginParam.token) && TokenType.NUMBER.equals(loginParam.tokenType)) {
            LoginDataRepository.getInstance().simLogin(loginParam, rpcRequestCallback);
        } else {
            super.login(loginParam, rpcRequestCallback);
        }
    }
}
