package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
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
public class NickSmsLoginTask extends BaseLoginTask {
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.NickSmsLoginTask.1
            @Override // java.lang.Runnable
            public void run() {
                NickSmsLoginTask nickSmsLoginTask = NickSmsLoginTask.this;
                if (nickSmsLoginTask.loginParam == null) {
                    nickSmsLoginTask.loginParam = new LoginParam();
                    NickSmsLoginTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                }
                NickSmsLoginTask nickSmsLoginTask2 = NickSmsLoginTask.this;
                TrackingModel trackingModel = nickSmsLoginTask2.trackingModel;
                String str = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
                LoginParam loginParam = nickSmsLoginTask2.loginParam;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                NickSmsLoginTask.this.loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
                NickSmsLoginTask nickSmsLoginTask3 = NickSmsLoginTask.this;
                LoginParam loginParam2 = nickSmsLoginTask3.loginParam;
                loginParam2.deviceTokenKey = "";
                loginParam2.havanaId = 0L;
                nickSmsLoginTask3.matchHistoryAccount();
                NickSmsLoginTask nickSmsLoginTask4 = NickSmsLoginTask.this;
                LoginParam loginParam3 = nickSmsLoginTask4.loginParam;
                TrackingModel trackingModel2 = nickSmsLoginTask4.trackingModel;
                loginParam3.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.NICK_SMS_LOGIN, str);
                NickSmsLoginTask nickSmsLoginTask5 = NickSmsLoginTask.this;
                LoginParam loginParam4 = nickSmsLoginTask5.loginParam;
                loginParam4.loginSourceType = LoginType.LocalLoginType.NICK_SMS_LOGIN;
                loginParam4.loginSourcePage = str;
                TrackingModel trackingModel3 = nickSmsLoginTask5.trackingModel;
                loginParam4.loginSourceSpm = trackingModel3 == null ? "" : trackingModel3.pageSpm;
                loginParam4.nativeLoginType = nickSmsLoginTask5.getLoginType();
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", NickSmsLoginTask.this.loginParam.traceId + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                properties.setProperty("loginId", NickSmsLoginTask.this.loginParam.loginAccount + "");
                UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.NICK_SMS_LOGIN, properties);
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.NickSmsLoginTask.1.1
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
        return LoginType.ServerLoginType.SMSLogin.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginComponent.getInstance().smsLoginWithNick(loginParam, rpcRequestCallback);
    }
}
