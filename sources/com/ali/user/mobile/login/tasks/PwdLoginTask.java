package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class PwdLoginTask extends BaseLoginTask {
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.PwdLoginTask.1
            @Override // java.lang.Runnable
            public void run() {
                PwdLoginTask pwdLoginTask = PwdLoginTask.this;
                if (pwdLoginTask.loginParam == null) {
                    pwdLoginTask.loginParam = new LoginParam();
                    PwdLoginTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                }
                PwdLoginTask pwdLoginTask2 = PwdLoginTask.this;
                TrackingModel trackingModel = pwdLoginTask2.trackingModel;
                String str = UTConstant.PageName.UT_PAGE_EXTEND;
                String str2 = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
                LoginParam loginParam = pwdLoginTask2.loginParam;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                PwdLoginTask.this.loginParam.externParams.put("apiReferer", ApiReferer.getApiRefer());
                PwdLoginTask.this.matchHistoryAccount();
                PwdLoginTask pwdLoginTask3 = PwdLoginTask.this;
                LoginParam loginParam2 = pwdLoginTask3.loginParam;
                TrackingModel trackingModel2 = pwdLoginTask3.trackingModel;
                loginParam2.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.PWD_LOGIN, str2);
                PwdLoginTask pwdLoginTask4 = PwdLoginTask.this;
                LoginParam loginParam3 = pwdLoginTask4.loginParam;
                loginParam3.loginSourceType = LoginType.LocalLoginType.PWD_LOGIN;
                loginParam3.loginSourcePage = str2;
                TrackingModel trackingModel3 = pwdLoginTask4.trackingModel;
                if (trackingModel3 != null) {
                    str = trackingModel3.pageSpm;
                }
                loginParam3.loginSourceSpm = str;
                loginParam3.nativeLoginType = pwdLoginTask4.getLoginType();
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", PwdLoginTask.this.loginParam.traceId + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                properties.setProperty("loginId", PwdLoginTask.this.loginParam.loginAccount + "");
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.PWD_LOGIN, properties);
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.PwdLoginTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        commonDataCallback.onSuccess(null);
                    }
                });
            }
        });
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected String getLoginType() {
        return LoginType.ServerLoginType.PasswordLogin.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().unifyLoginWithTaobaoGW(loginParam, rpcRequestCallback);
    }
}
