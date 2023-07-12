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
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MobileVerifyLoginTask extends BaseLoginTask {
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.1
            @Override // java.lang.Runnable
            public void run() {
                MobileVerifyLoginTask.this.matchHistoryAccount();
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        MobileVerifyLoginTask.this.fetchVerificationToken(commonDataCallback);
                    }
                });
            }
        });
    }

    protected void fetchVerificationToken(final CommonDataCallback commonDataCallback) {
        TrackingModel trackingModel = this.trackingModel;
        final String str = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
        String str2 = trackingModel == null ? "" : trackingModel.pageSpm;
        if (this.loginParam == null) {
            LoginParam loginParam = new LoginParam();
            this.loginParam = loginParam;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        }
        LoginParam loginParam2 = this.loginParam;
        TrackingModel trackingModel2 = this.trackingModel;
        loginParam2.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, str);
        LoginParam loginParam3 = this.loginParam;
        loginParam3.loginSourceType = LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN;
        loginParam3.loginSourcePage = str;
        loginParam3.loginSourceSpm = str2;
        loginParam3.nativeLoginType = getLoginType();
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(str, str2, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, hashMap);
        if (ServiceFactory.getService(NumberAuthService.class) == null) {
            if (commonDataCallback != null) {
                commonDataCallback.onFail(1601, "");
                return;
            }
            return;
        }
        showLoading();
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(str, "sim_access_code_commit", "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties);
        ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getToken(new NumAuthTokenCallback() { // from class: com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.2
            @Override // com.ali.user.mobile.model.NumAuthTokenCallback
            public void onGetAuthTokenFail(int i, final String str3) {
                MobileVerifyLoginTask.this.dismissLoading();
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                String str4 = str;
                UserTrackAdapter.sendUT(str4, "sim_access_code_failure", i + "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties2);
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CommonDataCallback commonDataCallback2 = commonDataCallback;
                        if (commonDataCallback2 != null) {
                            commonDataCallback2.onFail(1601, str3);
                        }
                    }
                });
            }

            @Override // com.ali.user.mobile.model.NumAuthTokenCallback
            public void onGetAuthTokenSuccess(String str3) {
                MobileVerifyLoginTask.this.dismissLoading();
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(str, "sim_access_code_success", "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties2);
                Properties properties3 = new Properties();
                properties3.setProperty("sdkTraceId", MobileVerifyLoginTask.this.loginParam.traceId + "");
                properties3.setProperty("monitor", "T");
                properties3.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                properties3.setProperty("loginId", MobileVerifyLoginTask.this.loginParam.loginAccount + "");
                UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties3);
                LoginParam loginParam4 = MobileVerifyLoginTask.this.loginParam;
                loginParam4.token = str3;
                loginParam4.tokenType = TokenType.NUMBER;
                CommonDataCallback commonDataCallback2 = commonDataCallback;
                if (commonDataCallback2 != null) {
                    commonDataCallback2.onSuccess(null);
                }
            }
        });
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected String getLoginType() {
        return LoginType.ServerLoginType.MobileVerifyLogin.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().simLoginWithUserInput(loginParam, rpcRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (rpcResponse.code == 14044) {
            String str = loginParam != null ? loginParam.loginSourcePage : UTConstant.PageName.UT_PAGE_EXTEND;
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, UTConstant.ErrorCode.LOGIN2REG_CANCEL_ALERT, LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties);
            if (loginTasksCallback != null) {
                loginTasksCallback.onFail(new LoginException<>(1303, "", rpcResponse));
                return;
            }
            return;
        }
        super.onReceiveRegister(loginParam, rpcResponse, loginTasksCallback);
    }
}
