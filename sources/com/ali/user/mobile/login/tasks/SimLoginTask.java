package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SimLoginTask extends BaseLoginTask {
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.SimLoginTask.1
            @Override // java.lang.Runnable
            public void run() {
                SimLoginTask.this.matchHistoryAccount();
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.SimLoginTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        SimLoginTask.this.fetchSimLoginToken(commonDataCallback);
                    }
                });
            }
        });
    }

    public void buildTokenParam(LoginParam loginParam, String str, String str2, String str3) {
        if (this.loginParam == null) {
            this.loginParam = new LoginParam();
        }
        this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        LoginParam loginParam2 = this.loginParam;
        loginParam2.token = str;
        loginParam2.tokenType = str2;
        loginParam2.scene = str3;
        if (loginParam2.externParams == null) {
            loginParam2.externParams = new HashMap();
        }
        this.loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        if (loginParam != null) {
            LoginParam loginParam3 = this.loginParam;
            loginParam3.traceId = loginParam.traceId;
            loginParam3.loginSourcePage = loginParam.loginSourcePage;
            loginParam3.loginSourceSpm = loginParam.loginSourceSpm;
            loginParam3.loginSourceType = loginParam.loginSourceType;
        }
    }

    protected void fetchSimLoginToken(final CommonDataCallback commonDataCallback) {
        if (this.loginParam == null) {
            LoginParam loginParam = new LoginParam();
            this.loginParam = loginParam;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        }
        TrackingModel trackingModel = this.trackingModel;
        final String str = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
        String str2 = trackingModel == null ? "" : trackingModel.pageSpm;
        this.loginParam.traceId = trackingModel != null ? trackingModel.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.SIM_LOGIN, str);
        LoginParam loginParam2 = this.loginParam;
        loginParam2.loginSourceType = LoginType.LocalLoginType.SIM_LOGIN;
        loginParam2.loginSourcePage = str;
        loginParam2.loginSourceSpm = str2;
        loginParam2.nativeLoginType = getLoginType();
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(str, str2, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SIM_LOGIN, hashMap);
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            showLoading();
            final Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str, "get_onekey_login_token_commit", "", LoginType.LocalLoginType.SIM_LOGIN, properties);
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("openLoginView", new NumAuthTokenCallback() { // from class: com.ali.user.mobile.login.tasks.SimLoginTask.2
                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, String str3) {
                    SimLoginTask.this.dismissLoading();
                    Properties properties2 = new Properties();
                    properties2.setProperty("code", i + "");
                    properties2.setProperty("cause", str3 + "");
                    UserTrackAdapter.sendUT(str, "get_login_token_fail", properties2);
                    String str4 = str;
                    UserTrackAdapter.sendUT(str4, "get_onekey_login_token_failure", i + "", LoginType.LocalLoginType.SIM_LOGIN, properties);
                    CommonDataCallback commonDataCallback2 = commonDataCallback;
                    if (commonDataCallback2 != null) {
                        commonDataCallback2.onFail(1501, str3);
                    }
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str3) {
                    UserTrackAdapter.sendUT(str, "get_login_token_success");
                    UserTrackAdapter.sendUT(str, "get_onekey_login_token_success", "", LoginType.LocalLoginType.SIM_LOGIN, properties);
                    Properties properties2 = new Properties();
                    if (SimLoginTask.this.loginParam != null) {
                        properties2.setProperty("sdkTraceId", SimLoginTask.this.loginParam.traceId + "");
                    }
                    properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                    properties2.setProperty("loginId", SimLoginTask.this.loginParam.loginAccount + "");
                    properties2.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SIM_LOGIN, properties2);
                    SimLoginTask simLoginTask = SimLoginTask.this;
                    simLoginTask.buildTokenParam(simLoginTask.loginParam, str3, TokenType.NUMBER, "");
                    CommonDataCallback commonDataCallback2 = commonDataCallback;
                    if (commonDataCallback2 != null) {
                        commonDataCallback2.onSuccess(null);
                    }
                }
            });
        }
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected String getLoginType() {
        return LoginType.ServerLoginType.SimLogin.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().simLogin(loginParam, rpcRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (rpcResponse.code == 14044) {
            String str = loginParam != null ? loginParam.loginSourcePage : UTConstant.PageName.UT_PAGE_EXTEND;
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, UTConstant.ErrorCode.LOGIN2REG_CANCEL_ALERT, LoginType.LocalLoginType.SIM_LOGIN, properties);
            if (loginTasksCallback != null) {
                loginTasksCallback.onFail(new LoginException<>(1303, "", rpcResponse));
                return;
            }
            return;
        }
        super.onReceiveRegister(loginParam, rpcResponse, loginTasksCallback);
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void onReceiverOtherError(RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            if (rpcResponse != null && rpcResponse.code == 14076) {
                loginTasksCallback.onFail(new LoginException<>(1502, rpcResponse.message, rpcResponse));
            } else {
                loginTasksCallback.onFail(new LoginException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
            }
        }
    }
}
