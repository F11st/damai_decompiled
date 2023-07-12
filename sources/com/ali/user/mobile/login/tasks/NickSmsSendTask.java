package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class NickSmsSendTask extends SmsSendTask {
    @Override // com.ali.user.mobile.login.tasks.SmsSendTask, com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.NickSmsSendTask.1
            @Override // java.lang.Runnable
            public void run() {
                NickSmsSendTask nickSmsSendTask = NickSmsSendTask.this;
                if (nickSmsSendTask.loginParam == null) {
                    nickSmsSendTask.loginParam = new LoginParam();
                    NickSmsSendTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                }
                NickSmsSendTask nickSmsSendTask2 = NickSmsSendTask.this;
                TrackingModel trackingModel = nickSmsSendTask2.trackingModel;
                String str = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
                LoginParam loginParam = nickSmsSendTask2.loginParam;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                NickSmsSendTask.this.loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
                NickSmsSendTask nickSmsSendTask3 = NickSmsSendTask.this;
                LoginParam loginParam2 = nickSmsSendTask3.loginParam;
                loginParam2.deviceTokenKey = "";
                loginParam2.havanaId = 0L;
                nickSmsSendTask3.matchHistoryAccount();
                NickSmsSendTask nickSmsSendTask4 = NickSmsSendTask.this;
                LoginParam loginParam3 = nickSmsSendTask4.loginParam;
                TrackingModel trackingModel2 = nickSmsSendTask4.trackingModel;
                loginParam3.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.NICK_SMS_LOGIN, str);
                NickSmsSendTask nickSmsSendTask5 = NickSmsSendTask.this;
                LoginParam loginParam4 = nickSmsSendTask5.loginParam;
                loginParam4.loginSourceType = LoginType.LocalLoginType.NICK_SMS_LOGIN;
                loginParam4.loginSourcePage = str;
                TrackingModel trackingModel3 = nickSmsSendTask5.trackingModel;
                loginParam4.loginSourceSpm = trackingModel3 != null ? trackingModel3.pageSpm : "";
                loginParam4.nativeLoginType = nickSmsSendTask5.getLoginType();
                MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.NickSmsSendTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        commonDataCallback.onSuccess(null);
                    }
                });
            }
        });
    }

    @Override // com.ali.user.mobile.login.tasks.SmsSendTask, com.ali.user.mobile.login.tasks.BaseLoginTask
    protected String getLoginType() {
        return LoginType.ServerLoginType.SMSLogin.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.SmsSendTask, com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginComponent.getInstance().sendSmsByLoginWithNick(loginParam, rpcRequestCallback);
    }
}
