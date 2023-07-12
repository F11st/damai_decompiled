package com.ali.user.mobile.login.presenter;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.OneKeyLoginView;
import com.ali.user.mobile.login.ui.RecommendLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SimLoginPresenter extends BaseLoginPresenter {
    protected static final String TAG = "login." + SimLoginPresenter.class.getSimpleName();

    public SimLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    public void login(LoginParam loginParam) {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        LoginApi.mobileVerifyLogin(loginParam, buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.SimLoginPresenter.1
            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onCancel() {
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onFail(LoginException<LoginReturnData> loginException) {
                BaseLoginView baseLoginView2 = SimLoginPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                if (loginException.getCode() == 1601) {
                    BaseLoginView baseLoginView3 = SimLoginPresenter.this.mViewer;
                    if (baseLoginView3 instanceof OneKeyLoginView) {
                        ((OneKeyLoginView) baseLoginView3).onGetAccessTokenFail();
                    } else if (baseLoginView3 instanceof RecommendLoginView) {
                        ((RecommendLoginView) baseLoginView3).onGetAccessTokenFail();
                    }
                } else if (loginException.getCode() == 1303 && loginException.getOrinResponse() != null && loginException.getOrinResponse().returnValue != null) {
                    BaseLoginView baseLoginView4 = SimLoginPresenter.this.mViewer;
                    if (baseLoginView4 instanceof OneKeyLoginView) {
                        ((OneKeyLoginView) baseLoginView4).onNeedVerifyMobileForReg(loginException.getMsg(), loginException.getOrinResponse().returnValue.mobile);
                    } else if (baseLoginView4 instanceof RecommendLoginView) {
                        ((RecommendLoginView) baseLoginView4).onNeedVerifyMobileForReg(loginException.getMsg(), loginException.getOrinResponse().returnValue.mobile);
                    }
                } else if (loginException.getCode() != 800 && loginException.getCode() != 700) {
                    SimLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                } else {
                    SimLoginPresenter simLoginPresenter = SimLoginPresenter.this;
                    simLoginPresenter.onReceiveToast(simLoginPresenter.mLoginParam, loginException.getOrinResponse());
                }
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
            }
        });
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void onLoginSuccess(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        LoginReturnData loginReturnData;
        if (rpcResponse == null || (loginReturnData = rpcResponse.returnValue) == null) {
            return;
        }
        LoginDataHelper.processLoginReturnData(true, loginReturnData, loginParam, "", null);
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
                BaseLoginView baseLoginView = this.mViewer;
                if (baseLoginView instanceof RecommendLoginView) {
                    ((RecommendLoginView) baseLoginView).onNeedVerifyMobileForReg(str, loginReturnData.mobile);
                    return;
                } else if (baseLoginView instanceof OneKeyLoginView) {
                    ((OneKeyLoginView) baseLoginView).onNeedVerifyMobileForReg(str, loginReturnData.mobile);
                    return;
                } else {
                    return;
                }
            }
            String str3 = "";
            if (this.mLoginParam != null) {
                Properties properties2 = new Properties();
                properties2.setProperty("sdkTraceId", this.mLoginParam.traceId + "");
                UserTrackAdapter.sendUT(this.mLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties2);
            }
            boolean z = true;
            Map<String, String> map = loginReturnData.extMap;
            if (map != null) {
                z = ("false".equals(map.get("showTaobaoAgreement")) || "false".equals(loginReturnData.extMap.get("showAgreement"))) ? false : false;
                if (!TextUtils.isEmpty(loginReturnData.extMap.get("regHintTitle"))) {
                    str = loginReturnData.extMap.get("regHintTitle");
                }
                if (!TextUtils.isEmpty(loginReturnData.extMap.get("regHintSubTitle"))) {
                    str3 = loginReturnData.extMap.get("regHintSubTitle");
                }
            }
            Login2RegParam login2RegParam = new Login2RegParam();
            login2RegParam.needAlert = z;
            login2RegParam.token = loginReturnData.token;
            login2RegParam.title = str;
            login2RegParam.subTitle = str3;
            BaseLoginView baseLoginView2 = this.mViewer;
            if (baseLoginView2 instanceof RecommendLoginView) {
                baseLoginView2.onNeedReg(login2RegParam);
            } else if (baseLoginView2 instanceof OneKeyLoginView) {
                baseLoginView2.onNeedReg(login2RegParam);
            }
        }
    }

    public void simLoginWithUserInput(String str, String str2) {
        LoginParam loginParam = this.mLoginParam;
        loginParam.token = str;
        loginParam.tokenType = str2;
        login();
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
            LoginDataRepository.getInstance().simLoginWithUserInput(loginParam, rpcRequestCallback);
        } else {
            super.login(loginParam, rpcRequestCallback);
        }
    }

    public void simLoginWithUserInput(String str) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        LoginParam loginParam = this.mLoginParam;
        loginParam.loginAccount = str;
        login(loginParam);
    }
}
