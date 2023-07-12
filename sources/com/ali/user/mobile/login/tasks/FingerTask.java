package com.ali.user.mobile.login.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FingerTask extends BaseLoginTask {
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void buildLoginParam(final CommonDataCallback commonDataCallback) {
        if (commonDataCallback == null) {
            return;
        }
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.FingerTask.1
            @Override // java.lang.Runnable
            public void run() {
                FingerTask fingerTask = FingerTask.this;
                LoginParam loginParam = fingerTask.loginParam;
                if (loginParam != null) {
                    TrackingModel trackingModel = fingerTask.trackingModel;
                    String str = UTConstant.PageName.UT_PAGE_EXTEND;
                    final String str2 = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
                    if (loginParam.externParams == null) {
                        loginParam.externParams = new HashMap();
                    }
                    FingerTask.this.loginParam.externParams.put("apiReferer", ApiReferer.getApiRefer());
                    FingerTask.this.matchHistoryAccount();
                    FingerTask.this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
                    FingerTask fingerTask2 = FingerTask.this;
                    fingerTask2.loginParam.nativeLoginType = fingerTask2.getLoginType();
                    FingerTask fingerTask3 = FingerTask.this;
                    LoginParam loginParam2 = fingerTask3.loginParam;
                    TrackingModel trackingModel2 = fingerTask3.trackingModel;
                    loginParam2.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.BIO_LOGIN, str2);
                    FingerTask fingerTask4 = FingerTask.this;
                    LoginParam loginParam3 = fingerTask4.loginParam;
                    loginParam3.loginSourceType = LoginType.LocalLoginType.BIO_LOGIN;
                    loginParam3.loginSourcePage = str2;
                    TrackingModel trackingModel3 = fingerTask4.trackingModel;
                    if (trackingModel3 != null) {
                        str = trackingModel3.pageSpm;
                    }
                    loginParam3.loginSourceSpm = str;
                    loginParam3.nativeLoginType = fingerTask4.getLoginType();
                    Properties properties = new Properties();
                    properties.setProperty("sdkTraceId", FingerTask.this.loginParam.traceId + "");
                    properties.setProperty("monitor", "T");
                    properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                    properties.setProperty("loginId", FingerTask.this.loginParam.loginAccount + "");
                    UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.FINGER_TOKEN_COMMIT, "", LoginType.LocalLoginType.BIO_LOGIN, properties);
                    if (TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(FingerTask.this.loginParam.biometricId))) {
                        FingerTask.this.fail(1601, "指纹登录失败，请换个方式登录", str2, commonDataCallback);
                    } else if (ServiceFactory.getService(FingerprintService.class) != null) {
                        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerLogin(DataProviderFactory.getApplicationContext(), new CommonCallback() { // from class: com.ali.user.mobile.login.tasks.FingerTask.1.1
                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onFail(int i, String str3) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                FingerTask.this.fail(i, str3, str2, commonDataCallback);
                            }

                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onSuccess() {
                                String fingerValue = SecurityGuardManagerWraper.getFingerValue(FingerTask.this.loginParam.biometricId);
                                if (TextUtils.isEmpty(fingerValue)) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    FingerTask.this.fail(1601, "指纹登录失败，请换个方式登录", str2, commonDataCallback);
                                    return;
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                FingerTask fingerTask5 = FingerTask.this;
                                fingerTask5.loginParam.token = fingerValue;
                                fingerTask5.success(commonDataCallback);
                                Properties properties2 = new Properties();
                                properties2.setProperty("monitor", "T");
                                UserTrackAdapter.sendUT(FingerTask.this.loginParam.loginSourcePage, UTConstant.CustomEvent.FINGER_TOKEN_SUCCESS, properties2);
                                Properties properties3 = new Properties();
                                if (FingerTask.this.loginParam != null) {
                                    properties3.setProperty("sdkTraceId", FingerTask.this.loginParam.traceId + "");
                                }
                                properties3.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                properties3.setProperty("monitor", "T");
                                UserTrackAdapter.sendUT(FingerTask.this.loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.BIO_LOGIN, properties3);
                            }
                        });
                    } else {
                        FingerTask.this.fail(1600, "缺少指纹SDK", str2, commonDataCallback);
                    }
                }
            }
        });
    }

    public void fail(final int i, final String str, String str2, final CommonDataCallback commonDataCallback) {
        if (commonDataCallback == null) {
            return;
        }
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        String str3 = this.loginParam.loginSourcePage;
        UserTrackAdapter.sendUT(str3, UTConstant.CustomEvent.FINGER_TOKEN_FAIL, i + "", properties);
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.FingerTask.3
            @Override // java.lang.Runnable
            public void run() {
                CommonDataCallback commonDataCallback2 = commonDataCallback;
                if (commonDataCallback2 != null) {
                    commonDataCallback2.onFail(i, str);
                }
            }
        });
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected String getLoginType() {
        return LoginType.ServerLoginType.BIOLOGIN.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().finger(loginParam, rpcRequestCallback);
    }

    public void success(final CommonDataCallback commonDataCallback) {
        if (commonDataCallback == null) {
            return;
        }
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.tasks.FingerTask.2
            @Override // java.lang.Runnable
            public void run() {
                commonDataCallback.onSuccess(null);
            }
        });
    }
}
