package com.ali.user.mobile.login.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ResourceUtil;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class BioPresenter {
    private static final String TAG = "login." + UserMobileLoginPresenter.class.getSimpleName();
    public LoginParam mLoginParam;
    public BaseLoginView mViewer;

    public BioPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        this.mViewer = baseLoginView;
        this.mLoginParam = loginParam;
    }

    private TrackingModel buildTrackingModel(LoginParam loginParam) {
        TrackingModel trackingModel = new TrackingModel();
        String str = loginParam.loginSourcePage;
        trackingModel.pageName = str;
        trackingModel.pageSpm = loginParam.loginSourceSpm;
        trackingModel.loginType = LoginType.LocalLoginType.BIO_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.BIO_LOGIN, str);
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

    public void buildLoginParam() {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
    }

    public void login() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView == null || !baseLoginView.isActive()) {
            return;
        }
        LoginParam m104clone = this.mLoginParam.m104clone();
        LoginApi.fingerLogin(m104clone, buildTrackingModel(m104clone), this.mViewer, new LoginTasksCallback<LoginReturnData>() { // from class: com.ali.user.mobile.login.presenter.BioPresenter.1
            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onCancel() {
                BioPresenter.this.dismissLoading();
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onFail(LoginException<LoginReturnData> loginException) {
                BaseLoginView baseLoginView2 = BioPresenter.this.mViewer;
                if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                    return;
                }
                BioPresenter.this.dismissLoading();
                if (loginException.getCode() == 700) {
                    BioPresenter bioPresenter = BioPresenter.this;
                    bioPresenter.onReceiveAlert(bioPresenter.mLoginParam, loginException.getOrinResponse());
                    return;
                }
                BioPresenter.this.mViewer.toast(loginException.getMsg(), 0);
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                BioPresenter.this.dismissLoading();
            }
        });
    }

    protected void onReceiveAlert(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        String str;
        String str2;
        String str3;
        if (this.mViewer != null) {
            String str4 = rpcResponse.message;
            boolean z = false;
            LoginReturnData loginReturnData = rpcResponse.returnValue;
            if (loginReturnData == null || loginReturnData.extMap == null) {
                str = "";
            } else {
                String str5 = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
                z = true;
                str = loginReturnData.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                str4 = str5;
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = ResourceUtil.getStringById("aliuser_network_error");
            }
            if (z) {
                str2 = str4;
                str3 = str;
            } else {
                str3 = str4;
                str2 = "";
            }
            BaseLoginView baseLoginView = this.mViewer;
            baseLoginView.alert(str3, str2, baseLoginView.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.login.presenter.BioPresenter.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseLoginView baseLoginView2 = BioPresenter.this.mViewer;
                    if (baseLoginView2 == null || !baseLoginView2.isActive()) {
                        return;
                    }
                    BioPresenter.this.mViewer.dismissAlertDialog();
                }
            }, null, null);
        }
    }
}
