package com.taobao.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.helper.LoginResultHelper;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.LongLifeCycleUserTrack;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.SSOMasterParam;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.security.biz.R;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sso.v2.launch.model.ISsoRemoteParam;
import com.taobao.android.sso.v2.model.SSOIPCConstants;
import com.taobao.android.sso.v2.model.SsoLoginRequest;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TBSsoLogin {
    public static final String TAG = "Login.TBSsoLogin";
    public static LoginParam a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.TBSsoLogin$a */
    /* loaded from: classes8.dex */
    public static class AsyncTaskC6293a extends AsyncTask<Object, Void, DefaultLoginResponseData> {
        final /* synthetic */ Bundle a;
        final /* synthetic */ ISsoRemoteParam b;
        final /* synthetic */ Context c;
        final /* synthetic */ DataCallback d;

        AsyncTaskC6293a(Bundle bundle, ISsoRemoteParam iSsoRemoteParam, Context context, DataCallback dataCallback) {
            this.a = bundle;
            this.b = iSsoRemoteParam;
            this.c = context;
            this.d = dataCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DefaultLoginResponseData doInBackground(Object... objArr) {
            try {
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SSO_LOGIN, properties);
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_RPC, "", LoginType.LocalLoginType.SSO_LOGIN, properties2);
                SsoLoginRequest ssoLoginRequest = new SsoLoginRequest();
                ssoLoginRequest.masterAppKey = this.a.getString(SSOIPCConstants.IPC_MASTER_APPKEY);
                ssoLoginRequest.slaveAppKey = this.b.getAppKey();
                ssoLoginRequest.ssoToken = this.a.getString("ssoToken");
                ssoLoginRequest.ssoVersion = this.a.getString("ssoVersion");
                SSOMasterParam sSOMasterParam = new SSOMasterParam();
                sSOMasterParam.appKey = ssoLoginRequest.masterAppKey;
                sSOMasterParam.ssoToken = ssoLoginRequest.ssoToken;
                ssoLoginRequest.sign = this.a.getString("sign");
                String string = this.a.getString("uuid");
                if (TextUtils.isEmpty(string)) {
                    string = this.c.getSharedPreferences("uuid", 0).getString("uuid", "");
                }
                ssoLoginRequest.uuid = string;
                long j = this.a.getLong(SSOIPCConstants.IPC_MASTER_T, 0L);
                ssoLoginRequest.masterT = j;
                if (j == 0) {
                    ssoLoginRequest.masterT = Long.parseLong(this.a.getString(SSOIPCConstants.IPC_MASTER_T));
                }
                ssoLoginRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
                ssoLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
                ssoLoginRequest.hid = this.a.getString("userId");
                ssoLoginRequest.site = DataProviderFactory.getDataProvider().getSite();
                UserLoginServiceImpl.buildExt(ssoLoginRequest);
                return TBSsoLogin.i(this.c.getApplicationContext(), this.b, ssoLoginRequest);
            } catch (RpcException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(DefaultLoginResponseData defaultLoginResponseData) {
            String str;
            String str2 = UTConstant.PageName.UT_PAGE_EXTEND;
            if (defaultLoginResponseData != null) {
                try {
                    if (defaultLoginResponseData.returnValue != 0 && defaultLoginResponseData.code == 3000) {
                        Properties properties = new Properties();
                        properties.setProperty("monitor", "T");
                        properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.SSO_LOGIN, properties);
                        Properties properties2 = new Properties();
                        if (TBSsoLogin.a != null) {
                            properties2.setProperty("sdkTraceId", TBSsoLogin.a.traceId + "");
                            properties2.setProperty("loginId", TBSsoLogin.a.loginAccount + "");
                            properties2.setProperty("site", TBSsoLogin.a.loginSite + "");
                        }
                        LoginParam loginParam = TBSsoLogin.a;
                        if (loginParam != null) {
                            str2 = loginParam.loginSourcePage;
                        }
                        UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_LOGIN_SUCCESS, "", LoginType.LocalLoginType.SSO_LOGIN, properties2);
                        DataCallback dataCallback = this.d;
                        if (dataCallback != null) {
                            dataCallback.result(defaultLoginResponseData.returnValue);
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.TaobaoSSOLogin.getType());
                        LoginDataHelper.processLoginReturnData(true, (LoginReturnData) defaultLoginResponseData.returnValue, (Map<String, String>) hashMap);
                        return;
                    }
                } catch (RpcException e) {
                    e.printStackTrace();
                    TBSsoLogin.j(defaultLoginResponseData);
                    SDKExceptionHelper.getInstance().rpcExceptionHandler(e);
                    TBSsoLogin.h(-1, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                    return;
                }
            }
            if (defaultLoginResponseData != null && "H5".equals(defaultLoginResponseData.actionType) && defaultLoginResponseData.returnValue != 0) {
                String str3 = defaultLoginResponseData.code + "";
                Properties properties3 = new Properties();
                if (TBSsoLogin.a != null) {
                    properties3.setProperty("sdkTraceId", TBSsoLogin.a.traceId + "");
                    properties3.setProperty("site", TBSsoLogin.a.loginSite + "");
                }
                properties3.setProperty("continueLogin", UTConstant.Args.UT_SUCCESS_F);
                LoginParam loginParam2 = TBSsoLogin.a;
                if (loginParam2 != null) {
                    str2 = loginParam2.loginSourcePage;
                }
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_LOGIN_FAIL, str3, LoginType.LocalLoginType.SSO_LOGIN, properties3);
                LoginParam loginParam3 = new LoginParam();
                loginParam3.tokenType = TokenType.TAOBAO_SSO;
                loginParam3.errorCode = defaultLoginResponseData.code + "";
                LoginResultHelper.gotoH5PlaceHolder(this.c, (LoginReturnData) defaultLoginResponseData.returnValue, loginParam3);
            } else if (defaultLoginResponseData != null && ((ApiConstants.ResultActionType.ALERT.equals(defaultLoginResponseData.actionType) || ApiConstants.ResultActionType.TOAST.equals(defaultLoginResponseData.actionType)) && !TextUtils.isEmpty(defaultLoginResponseData.message))) {
                if (TBSsoLogin.a != null) {
                    Properties properties4 = new Properties();
                    properties4.setProperty("monitor", "T");
                    if (TBSsoLogin.a == null) {
                        str = "";
                    } else {
                        str = TBSsoLogin.a.loginSite + "";
                    }
                    properties4.setProperty("site", str);
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, defaultLoginResponseData.code + "", LoginType.LocalLoginType.SSO_LOGIN, properties4);
                    TBSsoLogin.a = null;
                }
                if (this.c instanceof Activity) {
                    new ActivityUIHelper((Activity) this.c).toast(defaultLoginResponseData.message, 0);
                }
                TBSsoLogin.h(-1, defaultLoginResponseData.message);
            } else {
                String string = DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error);
                if (defaultLoginResponseData != null && !TextUtils.isEmpty(defaultLoginResponseData.message)) {
                    string = defaultLoginResponseData.message;
                }
                TBSsoLogin.h(-2, string);
                LongLifeCycleUserTrack.sendUT("Taobao_AuthCode_Login_FAILURE");
                TBSsoLogin.j(defaultLoginResponseData);
                if (defaultLoginResponseData != null && ApiConstants.ResultActionType.TOAST.equals(defaultLoginResponseData.actionType) && (this.c instanceof Activity)) {
                    new ActivityUIHelper((Activity) this.c).toast(defaultLoginResponseData.message, 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.TBSsoLogin$b */
    /* loaded from: classes8.dex */
    public static class AsyncTaskC6294b extends AsyncTask<Object, Void, RpcResponse<LoginReturnData>> {
        final /* synthetic */ LoginParam a;
        final /* synthetic */ DataCallback b;
        final /* synthetic */ Activity c;

        AsyncTaskC6294b(LoginParam loginParam, DataCallback dataCallback, Activity activity) {
            this.a = loginParam;
            this.b = dataCallback;
            this.c = activity;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public RpcResponse<LoginReturnData> doInBackground(Object... objArr) {
            try {
                LoginParam loginParam = this.a;
                if (loginParam.externParams == null) {
                    loginParam.externParams = new HashMap();
                }
                this.a.externParams.put("apiReferer", "SSOV2_H5_tokenLogin");
                return TBSsoLogin.k(this.a);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(RpcResponse<LoginReturnData> rpcResponse) {
            try {
                if (rpcResponse == null) {
                    TBSsoLogin.h(-1, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
                    return;
                }
                LoginReturnData loginReturnData = rpcResponse.returnValue;
                if ("SUCCESS".equals(rpcResponse.actionType) && loginReturnData != null) {
                    DataCallback dataCallback = this.b;
                    if (dataCallback == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.TokenLogin.getType());
                        LoginDataHelper.processLoginReturnData(true, rpcResponse.returnValue, (Map<String, String>) hashMap);
                    } else {
                        dataCallback.result(loginReturnData);
                    }
                    LongLifeCycleUserTrack.sendUT(LongLifeCycleUserTrack.getResultScene() + "_SUCCESS");
                } else if ("H5".equals(rpcResponse.actionType)) {
                    LoginParam loginParam = new LoginParam();
                    loginParam.tokenType = TokenType.TAOBAO_SSO;
                    loginParam.errorCode = rpcResponse.code + "";
                    LoginResultHelper.gotoH5PlaceHolder(this.c, loginReturnData, loginParam);
                } else {
                    LongLifeCycleUserTrack.sendUT(LongLifeCycleUserTrack.getResultScene() + "_FAILURE");
                    String string = DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error);
                    if (!TextUtils.isEmpty(rpcResponse.message)) {
                        string = rpcResponse.message;
                    }
                    TBSsoLogin.h(-2, string);
                }
            } catch (RpcException unused) {
                LongLifeCycleUserTrack.sendUT(LongLifeCycleUserTrack.getResultScene() + "_FAILURE");
                TBSsoLogin.h(-1, DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error));
            }
        }
    }

    public static void c(Activity activity, Bundle bundle, ISsoRemoteParam iSsoRemoteParam) {
        d(activity, bundle, iSsoRemoteParam, null);
    }

    public static void d(Context context, Bundle bundle, ISsoRemoteParam iSsoRemoteParam, DataCallback<LoginReturnData> dataCallback) {
        if (bundle == null || bundle.getInt(SSOIPCConstants.APPLY_SSO_RESULT, 0) != 500) {
            return;
        }
        g(context, bundle, iSsoRemoteParam, dataCallback);
        LongLifeCycleUserTrack.setResultScene("Taobao_AuthCode_Login");
    }

    public static void e(Activity activity, LoginParam loginParam) {
        f(activity, loginParam, null);
    }

    public static void f(Activity activity, LoginParam loginParam, DataCallback<LoginReturnData> dataCallback) {
        new CoordinatorWrapper().execute(new AsyncTaskC6294b(loginParam, dataCallback, activity), new Object[0]);
    }

    public static void g(Context context, Bundle bundle, ISsoRemoteParam iSsoRemoteParam, DataCallback<LoginReturnData> dataCallback) {
        new CoordinatorWrapper().execute(new AsyncTaskC6293a(bundle, iSsoRemoteParam, context, dataCallback), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(int i, final String str) {
        MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.android.TBSsoLogin.3
            @Override // java.lang.Runnable
            public void run() {
                LoginStatus.setLastRefreshCookieTime(0L);
                Intent intent = new Intent(LoginResActions.LOGIN_NETWORK_ERROR);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("message", str);
                }
                BroadCastHelper.sendLocalBroadCast(intent);
            }
        });
    }

    public static DefaultLoginResponseData i(Context context, ISsoRemoteParam iSsoRemoteParam, SsoLoginRequest ssoLoginRequest) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.SSO_LOGIN;
        rpcRequest.VERSION = "2.0";
        rpcRequest.addParam(ApiConstants.ApiField.HID, ssoLoginRequest.hid);
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(ssoLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addParam("ext", JSON.toJSONString(new HashMap()));
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        return (DefaultLoginResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, DefaultLoginResponseData.class, ssoLoginRequest.hid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(RpcResponse<LoginReturnData> rpcResponse) {
        String valueOf = rpcResponse != null ? String.valueOf(rpcResponse.code) : "-1";
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("site", "0");
        String str = UTConstant.PageName.UT_PAGE_EXTEND;
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, valueOf, LoginType.LocalLoginType.SSO_LOGIN, properties);
        Properties properties2 = new Properties();
        if (a != null) {
            properties2.setProperty("sdkTraceId", a.traceId + "");
            properties2.setProperty("site", a.loginSite + "");
        }
        LoginParam loginParam = a;
        if (loginParam != null) {
            str = loginParam.loginSourcePage;
        }
        UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_LOGIN_FAIL, valueOf, LoginType.LocalLoginType.SSO_LOGIN, properties2);
    }

    protected static RpcResponse k(LoginParam loginParam) {
        if (loginParam.token != null) {
            return UserLoginServiceImpl.getInstance().loginByToken(loginParam);
        }
        return null;
    }
}
