package com.ali.user.mobile.login.presenter;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.model.GetVerifyTokenResponseData;
import com.ali.user.mobile.login.model.GetVerifyTokenResult;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.FaceLoginView;
import com.ali.user.mobile.model.FaceVerifyCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.verify.impl.VerifyServiceImpl;
import com.ali.user.mobile.verify.model.GetVerifyUrlResponse;
import com.ali.user.mobile.verify.model.GetVerifyUrlReturnData;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FaceLoginPresenter extends BaseLoginPresenter {
    private static final String TAG = "login." + FaceLoginPresenter.class.getSimpleName();

    public FaceLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.SCAN_FACE_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SCAN_FACE_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFaceLoginError(LoginParam loginParam, RpcResponse rpcResponse, String str) {
        String str2;
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        String str3 = loginParam.loginSourcePage;
        if (rpcResponse == null) {
            str2 = "-1";
        } else {
            str2 = rpcResponse.code + "";
        }
        UserTrackAdapter.sendUT(str3, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_FAIL, str2, "preScanFaceLogin", properties);
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive() || this.mViewer.getBaseActivity() == null) {
            return;
        }
        this.mViewer.dismissLoading();
        this.mViewer.toast((rpcResponse == null || TextUtils.isEmpty(rpcResponse.message)) ? this.mViewer.getBaseActivity().getString(R.string.aliuser_network_error) : rpcResponse.message, 0);
    }

    public void activeFaceLogin(final LoginParam loginParam) {
        if (loginParam == null) {
            return;
        }
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, GetVerifyUrlResponse>() { // from class: com.ali.user.mobile.login.presenter.FaceLoginPresenter.3
            private long userId;

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.AsyncTask
            public GetVerifyUrlResponse doInBackground(Object[] objArr) {
                VerifyParam verifyParam = new VerifyParam();
                verifyParam.fromSite = FaceLoginPresenter.this.mViewer.getLoginSite();
                verifyParam.actionType = "h5_non_login_open_verify";
                LoginParam loginParam2 = loginParam;
                if (loginParam2 != null) {
                    verifyParam.deviceTokenKey = loginParam2.deviceTokenKey;
                    verifyParam.userId = loginParam.havanaId + "";
                    this.userId = loginParam.havanaId;
                }
                try {
                    return VerifyServiceImpl.getInstance().getNonLoginVerfiyUrl(verifyParam);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(GetVerifyUrlResponse getVerifyUrlResponse) {
                T t;
                if (getVerifyUrlResponse == null) {
                    return;
                }
                if (getVerifyUrlResponse.code == 3000 && (t = getVerifyUrlResponse.returnValue) != 0 && !TextUtils.isEmpty(((GetVerifyUrlReturnData) t).url)) {
                    UrlParam urlParam = new UrlParam();
                    urlParam.url = ((GetVerifyUrlReturnData) getVerifyUrlResponse.returnValue).url;
                    urlParam.ivScene = "h5_non_login_open_verify";
                    urlParam.userid = this.userId + "";
                    if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                        ((FaceService) ServiceFactory.getService(FaceService.class)).activeFaceLogin(((GetVerifyUrlReturnData) getVerifyUrlResponse.returnValue).url, null);
                    } else {
                        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(DataProviderFactory.getApplicationContext(), urlParam);
                    }
                } else if (getVerifyUrlResponse.code == 13050) {
                    FaceLoginPresenter.this.fetchScanToken(loginParam);
                }
            }
        }, new Object[0]);
    }

    public void fetchScanToken(final LoginParam loginParam) {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            LoginApi.faceLogin(loginParam, buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.FaceLoginPresenter.1
                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onCancel() {
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onFail(LoginException<LoginReturnData> loginException) {
                    BaseLoginView baseLoginView = FaceLoginPresenter.this.mViewer;
                    if (baseLoginView == null || !baseLoginView.isActive() || loginException == null) {
                        return;
                    }
                    int code = loginException.getCode();
                    if (code == 1401) {
                        ((FaceLoginView) FaceLoginPresenter.this.mViewer).toLastLoginFragment();
                    } else if (code != 1402) {
                        FaceLoginPresenter.this.mViewer.toast((loginException.getOrinResponse() == null || TextUtils.isEmpty(loginException.getOrinResponse().message)) ? FaceLoginPresenter.this.mViewer.getBaseActivity().getString(R.string.aliuser_network_error) : loginException.getOrinResponse().message, 0);
                    } else {
                        BaseLoginView baseLoginView2 = FaceLoginPresenter.this.mViewer;
                        baseLoginView2.toast(baseLoginView2.getBaseActivity().getString(R.string.aliuser_scan_login_fail), 0);
                    }
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                }
            });
            return;
        }
        this.mViewer.showLoading();
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_COMMIT, properties);
        UserLoginServiceImpl.getInstance().getScanToken(loginParam, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.FaceLoginPresenter.2
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                FaceLoginPresenter.this.onFaceLoginError(loginParam, rpcResponse, "Error");
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                BaseLoginView baseLoginView = FaceLoginPresenter.this.mViewer;
                if (baseLoginView == null || !baseLoginView.isActive() || FaceLoginPresenter.this.mViewer.getBaseActivity() == null) {
                    return;
                }
                FaceLoginPresenter.this.mViewer.dismissLoading();
                GetVerifyTokenResponseData getVerifyTokenResponseData = (GetVerifyTokenResponseData) rpcResponse;
                if (getVerifyTokenResponseData == null || (t = getVerifyTokenResponseData.returnValue) == 0 || ((GetVerifyTokenResult) t).extMap == null) {
                    FaceLoginPresenter.this.onFaceLoginError(loginParam, rpcResponse, "Error");
                    return;
                }
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                properties2.setProperty("sdkTraceId", loginParam.traceId + "");
                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_SUCCESS, properties2);
                String str = ((GetVerifyTokenResult) getVerifyTokenResponseData.returnValue).extMap.get("scanFaceLoginRPToken");
                T t2 = getVerifyTokenResponseData.returnValue;
                final String str2 = ((GetVerifyTokenResult) t2).token;
                final String str3 = ((GetVerifyTokenResult) t2).scene;
                if (ServiceFactory.getService(FaceService.class) != null) {
                    Properties properties3 = new Properties();
                    properties3.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_FACE_SDK_COMMIT, properties3);
                    ((FaceService) ServiceFactory.getService(FaceService.class)).nativeLogin(str, new FaceVerifyCallback() { // from class: com.ali.user.mobile.login.presenter.FaceLoginPresenter.2.1
                        @Override // com.ali.user.mobile.model.CommonCallback
                        public void onFail(int i, String str4) {
                            BaseLoginView baseLoginView2 = FaceLoginPresenter.this.mViewer;
                            if (baseLoginView2 != null && baseLoginView2.isActive() && FaceLoginPresenter.this.mViewer.getBaseActivity() != null) {
                                Properties properties4 = new Properties();
                                properties4.setProperty("monitor", "T");
                                String str5 = loginParam.loginSourcePage;
                                UserTrackAdapter.sendUT(str5, UTConstant.CustomEvent.UT_FACE_SDK_FAIL, i + "", properties4);
                                if (i == 3) {
                                    ((FaceLoginView) FaceLoginPresenter.this.mViewer).toLastLoginFragment();
                                    return;
                                }
                                FaceLoginPresenter.this.mViewer.toast(FaceLoginPresenter.this.mViewer.getBaseActivity().getString(R.string.aliuser_scan_login_fail), 0);
                                return;
                            }
                            LoginStatus.resetLoginFlag();
                        }

                        @Override // com.ali.user.mobile.model.CommonCallback
                        public void onSuccess() {
                            Properties properties4 = new Properties();
                            properties4.setProperty("monitor", "T");
                            UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_FACE_SDK_SUCCESS, properties4);
                            BaseLoginView baseLoginView2 = FaceLoginPresenter.this.mViewer;
                            if (baseLoginView2 != null && baseLoginView2.isActive() && FaceLoginPresenter.this.mViewer.getBaseActivity() != null) {
                                Properties properties5 = new Properties();
                                if (loginParam != null) {
                                    properties5.setProperty("sdkTraceId", loginParam.traceId + "");
                                }
                                properties5.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                properties5.setProperty("monitor", "T");
                                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties5);
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                FaceLoginPresenter.this.buildTokenParam(loginParam, str2, TokenType.FACE_LOGIN, str3);
                                FaceLoginPresenter.this.login();
                                return;
                            }
                            LoginStatus.resetLoginFlag();
                        }
                    });
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                FaceLoginPresenter.this.onFaceLoginError(loginParam, rpcResponse, "SystemError");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (TextUtils.isEmpty(loginParam.token)) {
            return;
        }
        LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
    }
}
