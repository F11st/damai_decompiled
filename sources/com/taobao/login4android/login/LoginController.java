package com.taobao.login4android.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.user.userprofile.FeedsViewModel;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProvider;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.AliUserInit;
import com.ali.user.mobile.base.helper.AliuserActionReceiver;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.CPHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.AutoLoginCallback;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.SSOMasterParam;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.h5.MtopAccountCenterUrlResponseData;
import com.ali.user.mobile.rpc.h5.MtopCanChangeNickResponseData;
import com.ali.user.mobile.rpc.login.model.ApplyTokenRequest;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.login.model.LoginTokenResponseData;
import com.ali.user.mobile.rpc.login.model.MLoginTokenReturnValue;
import com.ali.user.mobile.rpc.login.model.SessionList;
import com.ali.user.mobile.rpc.login.model.SessionModel;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SSOSecurityService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.model.AccountCenterParam;
import com.ali.user.mobile.url.service.impl.UrlFetchServiceImpl;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.SiteUtil;
import com.ali.user.mobile.verify.impl.VerifyServiceImpl;
import com.ali.user.mobile.verify.model.GetVerifyUrlResponse;
import com.ali.user.mobile.verify.model.GetVerifyUrlReturnData;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.alibaba.fastjson.JSON;
import com.taobao.android.scancode.common.jsbridge.ScancodeCallback;
import com.taobao.android.sso.v2.model.ApplySsoTokenRequest;
import com.taobao.android.sso.v2.model.SSOIPCConstants;
import com.taobao.android.sso.v2.model.SSOV2ApplySsoTokenResponseData;
import com.taobao.login4android.Login;
import com.taobao.login4android.biz.alipaysso.AlipayConstant;
import com.taobao.login4android.biz.alipaysso.AlipaySSOLogin;
import com.taobao.login4android.biz.autologin.AutoLoginBusiness;
import com.taobao.login4android.biz.before.logout.BeforeLogoutBiz;
import com.taobao.login4android.biz.getWapCookies.GetWapLoginCookiesBusiness;
import com.taobao.login4android.biz.logout.LogoutBusiness;
import com.taobao.login4android.biz.logout.LogoutParam;
import com.taobao.login4android.biz.unifysso.UnifySsoLogin;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.jsbridge.JSBridgeService;
import com.taobao.login4android.jsbridge.SDKJSBridgeService;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.receiver.LoginTestBroadcastReceiver;
import com.taobao.login4android.receiver.StatusReceiver;
import com.taobao.login4android.sdk.R;
import com.taobao.login4android.session.ISession;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.thread.LoginTask;
import com.taobao.login4android.thread.LoginThreadHelper;
import com.taobao.login4android.utils.ToastUtil;
import com.taobao.login4android.video.VerifyJsbridge;
import com.taobao.weex.common.Constants;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginController {
    private static final String TAG = "loginsdk.LoginController";
    private static LoginController controller;
    public String browserRefUrl;
    private boolean isNotifyLogout = false;
    private AtomicBoolean isAliuserSDKInited = new AtomicBoolean(false);

    private LoginController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLoginPlugin() {
        TLogAdapter.d(TAG, "add aluWVJSbridge");
        WVPluginManager.registerPlugin("SDKJSBridgeService", (Class<? extends WVApiPlugin>) SDKJSBridgeService.class);
        try {
            WVPluginManager.registerPlugin("Scancode", (Class<? extends WVApiPlugin>) ScancodeCallback.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WVPluginManager.registerPlugin("aluWVJSBridge", (Class<? extends WVApiPlugin>) JSBridgeService.class);
        WVPluginManager.registerPlugin("aluVerifyJSBridge", (Class<? extends WVApiPlugin>) VerifyJsbridge.class);
    }

    private void alipaySsoLogin(Bundle bundle) {
        TLogAdapter.e(TAG, "alipay login");
        String generateTraceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN, UTConstant.PageName.UT_PAGE_ALIPAY_TRUST_LOGIN);
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", generateTraceId);
        UserTrackAdapter.control(UTConstant.PageName.UT_PAGE_ALIPAY_TRUST_LOGIN, null, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.ASO_LOGIN, hashMap);
        Properties properties = new Properties();
        properties.setProperty("sdkTraceId", generateTraceId + "");
        properties.setProperty("monitor", "T");
        properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN, properties);
        String string = bundle.getString("loginToken", "");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("source", bundle.getString("source", ""));
        hashMap2.put("version", bundle.getString("version", ""));
        hashMap2.put("app_id", bundle.getString("app_id", ""));
        hashMap2.put("auth_code", bundle.getString("auth_code", ""));
        hashMap2.put(AlipayConstant.LOGIN_ALIPAY_CLIENT_VERSION_KEY, bundle.getString(AlipayConstant.LOGIN_ALIPAY_CLIENT_VERSION_KEY, ""));
        hashMap2.put(AlipayConstant.LOGIN_ALIPAY_USER_ID_KEY, bundle.getString(AlipayConstant.LOGIN_ALIPAY_USER_ID_KEY, ""));
        if ((Login.checkSessionValid() || !TextUtils.isEmpty(Login.getLoginToken())) && LoginApprearanceExtensions.AsoLoginFlow.getAsoLoginCallback() != null && LoginSwitch.getSwitch(LoginSwitch.CHECK_SAME_ACCOUNT, "true")) {
            hashMap2.put(AlipayConstant.LOGIN_ALIPAY_ACCOUNT_CHECK_KEY, Boolean.TRUE);
            hashMap2.put(AlipayConstant.LOGIN_ALIPAY_HAVANA_ID_KEY, Login.getUserId());
        }
        LoginParam loginParam = new LoginParam();
        loginParam.traceId = generateTraceId;
        loginParam.loginSourceType = LoginType.LocalLoginType.ALIPAY_TRUST_LOGIN;
        loginParam.loginSourcePage = UTConstant.PageName.UT_PAGE_ALIPAY_TRUST_LOGIN;
        loginParam.tokenType = TokenType.ALIPAY_TRUST_LOGIN;
        AlipaySSOLogin.alipayLogin(string, hashMap2, loginParam);
    }

    private void apiReferUT(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("apiName");
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(jSONObject.optString("eventName", "NO_SESSION"));
            uTCustomHitBuilder.setEventPage(UTConstant.PageName.UT_PAGE_EXTEND);
            if (!TextUtils.isEmpty(optString)) {
                uTCustomHitBuilder.setProperty("apiName", optString);
            }
            String optString2 = jSONObject.optString("msgCode");
            if (!TextUtils.isEmpty(optString2)) {
                uTCustomHitBuilder.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG2, optString2);
            }
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
        } catch (JSONException unused) {
        }
    }

    private void easyLogin2(Bundle bundle) {
        String string = bundle.getString("username", "");
        String string2 = bundle.getString(Constants.Value.PASSWORD, "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            LoginParam loginParam = new LoginParam();
            loginParam.loginAccount = string;
            loginParam.loginPassword = string2;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
            try {
                processPwdLoginResponse(UserLoginServiceImpl.getInstance().easyLogin(loginParam), true);
                return;
            } catch (Exception unused) {
                LoginStatus.resetLoginFlag();
                return;
            }
        }
        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, -1, "username or password is null", this.browserRefUrl);
    }

    public static synchronized LoginController getInstance() {
        LoginController loginController;
        synchronized (LoginController.class) {
            if (controller == null) {
                controller = new LoginController();
            }
            loginController = controller;
        }
        return loginController;
    }

    private void logoutClean(String str) {
        if (this.isNotifyLogout) {
            return;
        }
        clearLoginInfo(str);
        ApiReferer.Refer refer = new ApiReferer.Refer();
        refer.eventName = "USER_LOGOUT";
        Login.session.appendEventTrace(JSON.toJSONString(refer));
        LoginStatus.setLastRefreshCookieTime(0L);
        LoginStatus.resetLoginFlag();
        HashMap hashMap = new HashMap();
        hashMap.put(LoginConstants.LOGOUT_TYPE, LoginConstants.LogoutType.NORMAL_LOGOUT.getType());
        hashMap.put("nick", Login.session.getOldNick());
        hashMap.put("uid", Login.getOldUserId());
        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGOUT, false, 0, "", (Map<String, String>) hashMap, this.browserRefUrl);
        LoginTLogAdapter.e(TAG, "logout finish");
        this.isNotifyLogout = true;
    }

    private void processNetworkError(RpcResponse<LoginReturnData> rpcResponse, boolean z, boolean z2, Bundle bundle) {
        if (rpcResponse != null && !RpcException.isSystemError(rpcResponse.code)) {
            userLogin(z, z2, bundle);
            return;
        }
        if (LoginStatus.isFromChangeAccount()) {
            Login.session.recoverCookie();
        }
        if (z2) {
            HashMap hashMap = new HashMap();
            hashMap.put("clearSession", "false");
            hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.LocalLoginType.AUTO_LOGIN);
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, rpcResponse == null ? LoginResActions.LoginFailCode.UCC_LOGIN_EXCEPTION : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message, (Map<String, String>) hashMap, this.browserRefUrl);
        }
    }

    private boolean processPwdLoginResponse(RpcResponse<LoginReturnData> rpcResponse, boolean z) {
        if (rpcResponse == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.PasswordLogin.getType());
        if (LoginDataHelper.processLoginReturnData(z, rpcResponse.returnValue, hashMap)) {
            return true;
        }
        LoginStatus.resetLoginFlag();
        return false;
    }

    private void registerAliuserActionReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(LoginResActions.LOGIN_CANCEL_ACTION);
            intentFilter.addAction(LoginResActions.LOGIN_FAIL_ACTION);
            intentFilter.addAction(LoginResActions.LOGIN_SUCCESS_ACTION);
            intentFilter.addAction(LoginResActions.LOGIN_OPEN_ACTION);
            intentFilter.addAction(LoginResActions.LOGIN_NETWORK_ERROR);
            intentFilter.addAction(LoginResActions.WEB_ACTIVITY_CANCEL);
            intentFilter.addAction(LoginResActions.WEB_ACTIVITY_RESULT);
            intentFilter.addAction(LoginResActions.REG_CANCEL);
            intentFilter.addAction(AppInfo.INITED_ACTION);
            intentFilter.addAction(com.ali.user.mobile.utils.Constants.RESET_LOGIN_STATUS);
            intentFilter.setPriority(1000);
            LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).registerReceiver(new AliuserActionReceiver(), intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.ali.user.sdk.login.TEST_ACCOUNT_SSO");
            DataProviderFactory.getApplicationContext().registerReceiver(new LoginTestBroadcastReceiver(), intentFilter2);
            LoginTLogAdapter.d("AliuserActionReceiver", "register receiver");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            DataProviderFactory.getApplicationContext().registerReceiver(new StatusReceiver(), intentFilter3);
        } catch (Exception e) {
            LoginTLogAdapter.w("register status receiver error", e);
        }
    }

    public void applyToken(InternalTokenCallback internalTokenCallback) {
        applyToken(DataProviderFactory.getDataProvider().getSite(), internalTokenCallback);
    }

    public void applyTokenWithRemoteBiz(int i, String str, InternalTokenCallback internalTokenCallback) {
        applyTokenWithRemoteBiz(i, str, null, true, internalTokenCallback);
    }

    public void autoLogin(boolean z, Bundle bundle) {
        if (Login.session == null) {
            Login.session = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        }
        String userId = Login.getUserId();
        String loginToken = Login.getLoginToken();
        int defaultLoginSite = SiteUtil.getDefaultLoginSite();
        if (bundle != null) {
            BroadCastHelper.sLoginBundle = bundle;
            boolean z2 = bundle.getBoolean("easylogin2", false);
            String string = bundle.getString("loginToken", "");
            String string2 = bundle.getString(LoginConstant.LOGIN_BUNDLE_UNIFY_SSO_TOKEN, "");
            boolean z3 = bundle.getBoolean(LoginConstant.CHANGE_ACCOUNT_FLAG);
            String string3 = bundle.getString(LoginConstant.OUTTER_LOGIN_TOKEN, "");
            String string4 = bundle.getString(LoginConstant.OUTTER_LOGIN_TOKEN_TYPE, "");
            if (z2) {
                TLogAdapter.d(TAG, "isEasyLogin2:" + z2);
                easyLogin2(bundle);
                return;
            } else if (!TextUtils.isEmpty(string2)) {
                UnifySsoLogin.tokenLogin(bundle.getInt(LoginConstant.ALIUSER_LOGIN_SITE, 0), string2, bundle.getBoolean("isSilent"), Login.session);
                return;
            } else if (!TextUtils.isEmpty(string) && DataProviderFactory.getDataProvider().enableAlipaySSO()) {
                alipaySsoLogin(bundle);
                return;
            } else {
                if (z3) {
                    userId = bundle.getString(LoginConstant.CHANGE_ACCOUNT_USER_ID, "");
                    loginToken = bundle.getString(LoginConstant.CHANGE_ACCOUNT_AUTOLOGIN_TOKEN, "");
                    defaultLoginSite = bundle.getInt(LoginConstant.ALIUSER_LOGIN_SITE, 0);
                    LoginStatus.compareAndSetFromChangeAccount(false, true);
                    ApiReferer.Refer refer = new ApiReferer.Refer();
                    refer.eventName = "changeAccount";
                    refer.userId = userId;
                    refer.site = String.valueOf(defaultLoginSite);
                    Login.session.appendEventTrace(JSON.toJSONString(refer));
                } else if (!TextUtils.isEmpty(string3)) {
                    old2NewAutoLogin(string3, string4, DataProviderFactory.getDataProvider().getSite(), z, bundle);
                    return;
                }
                this.browserRefUrl = bundle.getString(LoginConstants.BROWSER_REF_URL);
                TLogAdapter.d(TAG, "autologin with bundle. browserRefUrl = " + this.browserRefUrl);
                String string5 = bundle.getString("apiReferer");
                apiReferUT(string5);
                if (!TextUtils.isEmpty(string5)) {
                    try {
                        Login.session.appendEventTrace(string5);
                    } catch (Throwable unused) {
                        ApiReferer.Refer refer2 = new ApiReferer.Refer();
                        refer2.eventName = string5;
                        Login.session.appendEventTrace(JSON.toJSONString(refer2));
                    }
                }
                UserTrackAdapter.sendUT("apiReferer", string5);
                if (!TextUtils.isEmpty(this.browserRefUrl)) {
                    ApiReferer.Refer refer3 = new ApiReferer.Refer();
                    refer3.eventName = this.browserRefUrl;
                    Login.session.appendEventTrace(JSON.toJSONString(refer3));
                }
            }
        }
        int i = defaultLoginSite;
        String str = loginToken;
        String str2 = userId;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            autoLoginTargetAccount(str2, str, i, z, bundle);
            return;
        }
        ApiReferer.Refer refer4 = new ApiReferer.Refer();
        refer4.eventName = "autoLoginToken=null|trySdkLogin";
        Login.session.appendEventTrace(JSON.toJSONString(refer4));
        try {
            Properties properties = new Properties();
            properties.put("action", "autologin token null trySdkLogin");
            properties.put("logintoken", TextUtils.isEmpty(str) + "");
            properties.put(FeedsViewModel.ARG_USERID, TextUtils.isEmpty(str2) + "");
            UserTrackAdapter.sendUT("NullAutoLoginToken", properties);
        } catch (Exception unused2) {
        }
        if (!TextUtils.isEmpty(str) && LoginSwitch.getSwitch("autologin_only", "false")) {
            autoLoginTargetAccount(str2, str, i, z, bundle);
        } else {
            userLogin(z, true, bundle);
        }
    }

    public void autoLoginTargetAccount(final String str, final String str2, final int i, final boolean z, final Bundle bundle) {
        try {
            if (TextUtils.isEmpty(AppInfo.getInstance().getUmidToken())) {
                AppInfo.getInstance().getUmidToken(new DataCallback<String>() { // from class: com.taobao.login4android.login.LoginController.2
                    @Override // com.ali.user.mobile.callback.DataCallback
                    public void result(String str3) {
                        if (!TextUtils.isEmpty(str3)) {
                            LoginController.this.autoLoginTargetAccount(str, str2, i, z, bundle);
                            return;
                        }
                        boolean z2 = z;
                        if (z2) {
                            LoginController.this.userLogin(z2, true, bundle);
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("clearSession", "false");
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, 727, "umidtoken is null", (Map<String, String>) hashMap, LoginController.this.browserRefUrl);
                    }
                });
            } else {
                processAutoLoginResponse(new AutoLoginBusiness().autoLogin(str2, str, i, z, ApiReferer.generateApiReferer()), z, true, bundle);
            }
        } catch (Throwable th) {
            if (TextUtils.equals(Login.getUserId(), str)) {
                ApiReferer.Refer refer = new ApiReferer.Refer();
                refer.eventName = "autoLoginFailed";
                refer.errorMessage = th.getMessage();
                Login.session.appendEventTrace(JSON.toJSONString(refer));
            }
            userLogin(z, true, bundle);
        }
    }

    protected void callAfterLogoutRpc(String str, boolean z, CommonCallback commonCallback) {
        if (z) {
            emptySessionList();
        }
        logoutClean(str);
        if (commonCallback != null) {
            commonCallback.onSuccess();
        }
    }

    public void checkNickModifiable(final CheckResultCallback checkResultCallback) {
        if (checkResultCallback == null) {
            return;
        }
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, String>() { // from class: com.taobao.login4android.login.LoginController.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Object[] objArr) {
                return Login.getDeviceTokenKey(Login.getUserId());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str) {
                UrlFetchServiceImpl.getInstance().checkNickModifiable(new RpcRequestCallback() { // from class: com.taobao.login4android.login.LoginController.7.1
                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onError(RpcResponse rpcResponse) {
                        checkResultCallback.result(false);
                    }

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onSuccess(RpcResponse rpcResponse) {
                        MtopCanChangeNickResponseData mtopCanChangeNickResponseData = (MtopCanChangeNickResponseData) rpcResponse;
                        if (mtopCanChangeNickResponseData != null) {
                            checkResultCallback.result(mtopCanChangeNickResponseData.success);
                        }
                    }

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onSystemError(RpcResponse rpcResponse) {
                        checkResultCallback.result(false);
                    }
                });
            }
        }, new Object[0]);
    }

    public void clearHistoryNames() {
    }

    public void clearLoginInfo(String str) {
        LoginTLogAdapter.d(TAG, "clearLoginInfo");
        try {
            if (DataProviderFactory.getDataProvider().isRemoveSessionWhenLogout()) {
                SecurityGuardManagerWraper.removeSessionModelFromFile(str);
            } else {
                SecurityGuardManagerWraper.removeSessionAutoLoginTokenFromFile(str);
            }
            Login.session.setSsoToken(null);
            Login.session.setOneTimeToken(null);
            try {
                Login.session.clearAutoLoginInfo();
            } catch (Throwable unused) {
            }
            try {
                Login.session.clearSessionInfo();
            } catch (Throwable unused2) {
            }
            LoginTLogAdapter.e(TAG, "clear sessionInfo in LoginController.clearLoginInfo");
            if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                CPHelper.delete(DataProviderFactory.getApplicationContext(), LoginConstant.ACCOUNT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public void doAutoLoginWithCallback(final String str, final String str2, final int i, final String str3, final boolean z, final AutoLoginCallback autoLoginCallback) {
        if (autoLoginCallback == null) {
            return;
        }
        LoginStatus.compareAndSetLogining(false, true);
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, RpcResponse<LoginReturnData>>() { // from class: com.taobao.login4android.login.LoginController.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.AsyncTask
            public RpcResponse<LoginReturnData> doInBackground(Object... objArr) {
                try {
                    return new AutoLoginBusiness().autoLogin(str, str2, i, str3);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(RpcResponse<LoginReturnData> rpcResponse) {
                if (rpcResponse == null) {
                    autoLoginCallback.onBizFail(-2, "Null Response");
                    LoginStatus.resetLoginFlag();
                } else if (RpcException.isSystemError(rpcResponse.code)) {
                    autoLoginCallback.onNetworkError();
                    LoginStatus.resetLoginFlag();
                } else if ("SUCCESS".equals(rpcResponse.actionType)) {
                    LoginController.this.processAutoLoginResponse(rpcResponse, false, z, null);
                    autoLoginCallback.onSuccess();
                } else {
                    LoginStatus.resetLoginFlag();
                    autoLoginCallback.onBizFail(rpcResponse.code, rpcResponse.message);
                }
            }
        }, new Object[0]);
    }

    protected void doSimpleLogoutRpc(LogoutParam logoutParam, CommonCallback commonCallback) {
        new LogoutBusiness().logout(logoutParam);
        callAfterLogoutRpc(logoutParam.userid, logoutParam.emptyAll, commonCallback);
    }

    public void emptySessionList() {
        if (DataProviderFactory.getDataProvider().isRemoveSessionWhenLogout()) {
            SecurityGuardManagerWraper.emptySessionListFromFile();
        } else {
            SecurityGuardManagerWraper.emptyAllSessionAutoLoginTokenFromFile();
        }
    }

    public void fetchRegisterUrl(Context context, RegistParam registParam) {
        try {
            LoginTLogAdapter.d(TAG, "start sdk h5 register");
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fetchRegisterUrl(context, registParam);
            LoginTLogAdapter.i(TAG, "aliuserLogin.fetchRegisterUrl");
        } catch (Exception e) {
            e.printStackTrace();
            LoginTLogAdapter.d(TAG, "open register h5 page failed: Exception:" + e.getMessage());
        }
    }

    public void initAliuserSDK(DefaultTaobaoAppProvider defaultTaobaoAppProvider) {
        if (this.isAliuserSDKInited.compareAndSet(false, true) || DataProviderFactory.getApplicationContext() == null) {
            TLogAdapter.e(TAG, "start init AliuserSDK | isAliuserSDKInited:" + this.isAliuserSDKInited.get());
            registerAliuserActionReceiver();
            AliUserInit.init(defaultTaobaoAppProvider);
            TLogAdapter.e(TAG, "end init AliuserSDK");
            MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.9
                @Override // java.lang.Runnable
                public void run() {
                    LoginController.this.addLoginPlugin();
                }
            });
        }
    }

    public boolean isLoginSDKInited() {
        return this.isAliuserSDKInited.get();
    }

    public synchronized void logout(int i, String str, String str2, String str3, boolean z, CommonCallback commonCallback) {
        LogoutParam logoutParam = new LogoutParam();
        logoutParam.site = i;
        logoutParam.sid = str;
        logoutParam.autologinToken = str2;
        logoutParam.userid = str3;
        logoutParam.emptyAll = z;
        logout(logoutParam, commonCallback);
    }

    public void navByScheme(String str, String str2, final String str3, final String str4, final CommonCallback commonCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.APPLY_SSO_TOKEN_V2;
        rpcRequest.VERSION = "1.0";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
        final ApplySsoTokenRequest applySsoTokenRequest = new ApplySsoTokenRequest();
        applySsoTokenRequest.slaveAppKey = str;
        applySsoTokenRequest.masterAppKey = DataProviderFactory.getDataProvider().getAppkey();
        applySsoTokenRequest.ssoVersion = SSOIPCConstants.CURRENT_SSO_MINI_PROGRAM;
        String str5 = "hap://app/" + str2 + "/SsoLoginMid?visa=8617ab96f88d12c0";
        applySsoTokenRequest.targetUrl = str5;
        applySsoTokenRequest.slaveBundleId = str5;
        applySsoTokenRequest.hid = Login.getUserId();
        rpcRequest.addParam(ApiConstants.ApiField.SSO_TOKEN_APPLY_REQUEST, JSON.toJSONString(applySsoTokenRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addParam("ext", JSON.toJSONString(new HashMap()));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, SSOV2ApplySsoTokenResponseData.class, new RpcRequestCallback() { // from class: com.taobao.login4android.login.LoginController.12
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                String str6;
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    int i = 1001;
                    if (rpcResponse != null) {
                        i = rpcResponse.code;
                        str6 = rpcResponse.message;
                    } else {
                        str6 = "unknown error";
                    }
                    commonCallback2.onFail(i, str6);
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                SSOV2ApplySsoTokenResponseData sSOV2ApplySsoTokenResponseData;
                if (rpcResponse != null) {
                    Intent intent = new Intent();
                    String str6 = applySsoTokenRequest.targetUrl;
                    SSOMasterParam sSOMasterParam = new SSOMasterParam();
                    sSOMasterParam.appKey = DataProviderFactory.getDataProvider().getAppkey();
                    sSOMasterParam.ssoToken = (String) ((SSOV2ApplySsoTokenResponseData) rpcResponse).returnValue;
                    sSOMasterParam.t = System.currentTimeMillis();
                    sSOMasterParam.userId = Login.getUserId();
                    sSOMasterParam.ssoVersion = SSOIPCConstants.CURRENT_SSO_MINI_PROGRAM;
                    try {
                        sSOMasterParam.sign = SSOSecurityService.getInstace(DataProviderFactory.getApplicationContext()).sign(sSOMasterParam.appKey, sSOMasterParam.toMap());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    intent.setData(Uri.parse(((str6 + "&resultCode=500") + "&ssoToken=" + ((String) sSOV2ApplySsoTokenResponseData.returnValue)) + "&sourceAppKey=" + sSOMasterParam.appKey + "&ssoVersion=" + sSOMasterParam.ssoVersion + "&" + SSOIPCConstants.IPC_MASTER_T + "=" + sSOMasterParam.t + "&userId=" + sSOMasterParam.userId + "&sign=" + sSOMasterParam.sign + "&" + SSOIPCConstants.IPC_JUMP_URL + "=" + Uri.encode(str3)));
                    if (!TextUtils.isEmpty(str4)) {
                        intent.setAction(str4);
                    } else {
                        intent.setAction("android.intent.action.VIEW");
                    }
                    List<ResolveInfo> queryIntentActivities = DataProviderFactory.getApplicationContext().getPackageManager().queryIntentActivities(intent, 0);
                    ResolveInfo resolveInfo = null;
                    if (queryIntentActivities != null) {
                        for (ResolveInfo resolveInfo2 : queryIntentActivities) {
                            String str7 = resolveInfo2.activityInfo.packageName;
                            String config = LoginSwitch.getConfig(LoginSwitch.SUPPORT_MINI_PROGRAME, "");
                            if (!TextUtils.isEmpty(config)) {
                                try {
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                if (new JSONObject(config).optBoolean(str7)) {
                                }
                            }
                            resolveInfo = resolveInfo2;
                        }
                    }
                    if (resolveInfo != null) {
                        intent.setFlags(268435456);
                        intent.setPackage(resolveInfo.activityInfo.packageName);
                        try {
                            DataProviderFactory.getApplicationContext().startActivity(intent);
                            CommonCallback commonCallback2 = commonCallback;
                            if (commonCallback2 != null) {
                                commonCallback2.onSuccess();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            CommonCallback commonCallback3 = commonCallback;
                            if (commonCallback3 != null) {
                                commonCallback3.onFail(1001, "start activity failed");
                                return;
                            }
                            return;
                        }
                    }
                    CommonCallback commonCallback4 = commonCallback;
                    if (commonCallback4 != null) {
                        commonCallback4.onFail(1002, "can't find packageName");
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                String str6;
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    int i = 1001;
                    if (rpcResponse != null) {
                        i = rpcResponse.code;
                        str6 = rpcResponse.message;
                    } else {
                        str6 = "unknown error";
                    }
                    commonCallback2.onFail(i, str6);
                }
            }
        });
    }

    public void navToIVByScene(Context context, String str, int i) {
        navToIVByScene(context, str, i, null);
    }

    public void navToIVWithUserId(Context context, String str, String str2) {
        navToIVWithUserId(context, str, DataProviderFactory.getDataProvider().getSite(), str2);
    }

    public void navToWebViewByScene(Context context, String str, int i) {
        navToWebViewByScene(context, str, i, null);
    }

    public void old2NewAutoLogin(String str, String str2, int i, boolean z, Bundle bundle) {
        try {
            processAutoLoginResponse(new AutoLoginBusiness().oldLogin(str, str2, i, ApiReferer.generateApiReferer()), z, true, bundle);
        } catch (Throwable unused) {
            userLogin(z, true, bundle);
        }
    }

    public void openLoginPage(Context context) {
        try {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openLoginPage(context, ApiReferer.generateApiReferer(), null);
            TLogAdapter.i(TAG, "aliuserLogin.openLoginPage");
        } catch (Exception e) {
            e.printStackTrace();
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, 724, "Exception", this.browserRefUrl);
            LoginTLogAdapter.d(TAG, "open register page failed: Exception:" + e.getMessage());
        }
    }

    public void openRegisterPage(Context context, RegistParam registParam) {
        try {
            LoginTLogAdapter.d(TAG, "start sdk register");
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openRegisterPage(context, registParam);
            LoginTLogAdapter.i(TAG, "aliuserLogin.openRegisterPage");
        } catch (Exception e) {
            e.printStackTrace();
            LoginTLogAdapter.d(TAG, "open register page failed: Exception:" + e.getMessage());
        }
    }

    public void openScheme(Context context, UrlParam urlParam) {
        if (context == null) {
            context = DataProviderFactory.getApplicationContext();
        }
        if (urlParam != null && !TextUtils.isEmpty(urlParam.url)) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(urlParam.url));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        TLogAdapter.e(TAG, "openScheme fail ,url=" + urlParam.url);
    }

    public void openUrl(Context context, UrlParam urlParam) {
        if (context == null) {
            context = DataProviderFactory.getApplicationContext();
        }
        if (urlParam != null && !TextUtils.isEmpty(urlParam.url)) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(context, urlParam);
            return;
        }
        TLogAdapter.e(TAG, "openUrl fail ,url=" + urlParam.url);
    }

    public void openUrlInRegWeb(Context context, UrlParam urlParam) {
        if (urlParam == null) {
            return;
        }
        if (context == null) {
            context = DataProviderFactory.getApplicationContext();
        }
        if (!TextUtils.isEmpty(urlParam.url)) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openRegWebViewPage(context, urlParam.url, "", (LoginParam) null);
            return;
        }
        TLogAdapter.e(TAG, "openUrl fail ,url=" + urlParam.url);
    }

    public boolean processAutoLoginResponse(RpcResponse<LoginReturnData> rpcResponse, boolean z) {
        return processAutoLoginResponse(rpcResponse, z, true, null);
    }

    public boolean refreshCookies(boolean z, boolean z2) {
        if (z) {
            if ((DataProviderFactory.getDataProvider() instanceof DataProvider) && DataProviderFactory.getDataProvider().isRefreshCookiesDegrade()) {
                return refreshCookies(z2);
            }
            ISession iSession = Login.session;
            if (iSession != null) {
                return iSession.recoverCookie();
            }
            return false;
        }
        return false;
    }

    public void sendBroadcast(LoginAction loginAction) {
        BroadCastHelper.sendBroadcast(loginAction, false, this.browserRefUrl);
    }

    public boolean sessionMoreThen1(SessionList sessionList) {
        List<SessionModel> list;
        return (sessionList == null || (list = sessionList.sessionModels) == null || list.size() <= 1) ? false : true;
    }

    public void userLogin(boolean z) {
        userLogin(z, true, null);
    }

    public void applyToken(final int i, final InternalTokenCallback internalTokenCallback) {
        if (internalTokenCallback == null) {
            TLogAdapter.d(TAG, "Callback is null ");
            return;
        }
        try {
            if (Login.session != null) {
                BackgroundExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentTimeMillis;
                        long j;
                        final String oneTimeToken = Login.getOneTimeToken();
                        if (oneTimeToken != null) {
                            MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    internalTokenCallback.onSucess(oneTimeToken);
                                }
                            });
                        } else if (TextUtils.isEmpty(Login.session.getUserId())) {
                            MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    internalTokenCallback.onFail(LoginConstant.FETCH_TOKEN_FAIL_SESSION_INVALID, "Session is null or Session is invalid.");
                                }
                            });
                        } else {
                            try {
                                final RpcResponse<MLoginTokenReturnValue> applyToken = UserLoginServiceImpl.getInstance().applyToken(i, Login.session.getUserId(), null);
                                if (applyToken == null) {
                                    AppMonitorAdapter.commitFail("Page_Member_Other", "GetHavanaSSOtoken", "0", "");
                                    MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            internalTokenCallback.onFail("RET_NULL", "apply token return null.");
                                        }
                                    });
                                    return;
                                }
                                int i2 = applyToken.code;
                                if (i2 == 3000 && applyToken.returnValue != null) {
                                    AppMonitorAdapter.commitSuccess("Page_Member_Other", "GetHavanaSSOtoken");
                                    int i3 = applyToken.returnValue.expireTime;
                                    if (i3 == 0) {
                                        currentTimeMillis = System.currentTimeMillis() / 1000;
                                        j = 900;
                                    } else {
                                        currentTimeMillis = System.currentTimeMillis() / 1000;
                                        j = i3;
                                    }
                                    Login.setHavanaSsoTokenExpiredTime(currentTimeMillis + j);
                                    Login.setOneTimeToken(applyToken.returnValue.token);
                                    MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.4
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            internalTokenCallback.onSucess(((MLoginTokenReturnValue) applyToken.returnValue).token);
                                        }
                                    });
                                    return;
                                }
                                AppMonitorAdapter.commitFail("Page_Member_Other", "GetHavanaSSOtoken", "0", String.valueOf(i2));
                                if (applyToken.code != 13032) {
                                    MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            internalTokenCallback.onFail(LoginConstant.FETCH_TOKEN_FAIL_NOT_SESSION_INVALID, "网络获取旺信token失败，非session失效");
                                        }
                                    });
                                    Login.setHavanaSsoTokenExpiredTime(0L);
                                    Login.setOneTimeToken(null);
                                    return;
                                }
                                RpcResponse<LoginReturnData> autoLogin = new AutoLoginBusiness().autoLogin(Login.getLoginToken(), Login.getUserId(), SiteUtil.getDefaultLoginSite(), ApiReferer.generateApiReferer());
                                if (autoLogin != null && "SUCCESS".equals(autoLogin.actionType)) {
                                    LoginController.this.processAutoLoginResponse(autoLogin, false);
                                    final String oneTimeToken2 = Login.getOneTimeToken();
                                    MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.7
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            internalTokenCallback.onSucess(oneTimeToken2);
                                        }
                                    });
                                    return;
                                }
                                MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        InternalTokenCallback internalTokenCallback2 = internalTokenCallback;
                                        internalTokenCallback2.onFail(LoginConstant.FETCH_TOKEN_FAIL_AUTO_LOGIN_FAIL, applyToken.message + ", mtop autoLoginFail");
                                    }
                                });
                            } catch (RpcException e) {
                                e.printStackTrace();
                                LoginTLogAdapter.e(LoginController.TAG, e);
                                MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.8
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        InternalTokenCallback internalTokenCallback2 = internalTokenCallback;
                                        internalTokenCallback2.onFail(LoginConstant.FETCH_TOKEN_FAIL_EXCEPTION, e.getMessage() + "|" + e.getExtCode());
                                    }
                                });
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                LoginTLogAdapter.e(LoginController.TAG, e2);
                                MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.10.9
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        internalTokenCallback.onFail(LoginConstant.FETCH_TOKEN_FAIL_EXCEPTION, e2.getMessage());
                                    }
                                });
                            }
                        }
                    }
                });
            } else {
                internalTokenCallback.onFail(LoginConstant.FETCH_TOKEN_FAIL_SESSION_INVALID, "Session is null or Session is invalid.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LoginTLogAdapter.e(TAG, e);
            internalTokenCallback.onFail(LoginConstant.FETCH_TOKEN_FAIL_EXCEPTION, e.getMessage());
        }
    }

    public void applyTokenWithRemoteBiz(int i, String str, Map<String, String> map, boolean z, final InternalTokenCallback internalTokenCallback) {
        HistoryAccount findHistoryAccount;
        if (internalTokenCallback == null) {
            TLogAdapter.d(TAG, "Callback is null ");
            return;
        }
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = "com.taobao.mtop.mLoginTokenService.applySsoToken";
        rpcRequest.VERSION = "1.1";
        rpcRequest.addParam("ext", JSON.toJSONString(new HashMap()));
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        if (map != null) {
            rpcRequest.addParam("ext", JSON.toJSONString(map));
        }
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
        applyTokenRequest.t = System.currentTimeMillis();
        applyTokenRequest.appVersion = AppInfo.getInstance().getAndroidAppVersion();
        applyTokenRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
        applyTokenRequest.site = i;
        rpcRequest.requestSite = i;
        if (!TextUtils.isEmpty(str) && (findHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(Long.parseLong(str))) != null) {
            applyTokenRequest.deviceTokenKey = findHistoryAccount.tokenKey;
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getAppkey())) {
                deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            }
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(str);
            deviceTokenSignParam.addTimestamp(String.valueOf(applyTokenRequest.t));
            deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
            if (!TextUtils.isEmpty(findHistoryAccount.tokenKey)) {
                applyTokenRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(findHistoryAccount.tokenKey, deviceTokenSignParam.build());
            }
        }
        rpcRequest.addParam("request", JSON.toJSONString(applyTokenRequest));
        rpcRequest.SHOW_LOGIN_UI = z;
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginTokenResponseData.class, new RpcRequestCallback() { // from class: com.taobao.login4android.login.LoginController.11
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                internalTokenCallback.onFail("RET_NULL", rpcResponse.message);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                long currentTimeMillis;
                long j;
                if (rpcResponse instanceof LoginTokenResponseData) {
                    final LoginTokenResponseData loginTokenResponseData = (LoginTokenResponseData) rpcResponse;
                    AppMonitorAdapter.commitSuccess("Page_Member_Other", "GetHavanaSSOtoken");
                    int i2 = ((MLoginTokenReturnValue) loginTokenResponseData.returnValue).expireTime;
                    if (i2 == 0) {
                        currentTimeMillis = System.currentTimeMillis() / 1000;
                        j = 900;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() / 1000;
                        j = i2;
                    }
                    Login.setHavanaSsoTokenExpiredTime(currentTimeMillis + j);
                    Login.setOneTimeToken(((MLoginTokenReturnValue) loginTokenResponseData.returnValue).token);
                    MainThreadExecutor.execute(new Runnable() { // from class: com.taobao.login4android.login.LoginController.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            internalTokenCallback.onSucess(((MLoginTokenReturnValue) loginTokenResponseData.returnValue).token);
                        }
                    });
                    return;
                }
                internalTokenCallback.onFail("RET_NULL", rpcResponse.message);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                internalTokenCallback.onFail("RET_NULL", rpcResponse.message);
            }
        });
    }

    public void navToIVByScene(final Context context, final String str, int i, final Bundle bundle) {
        final VerifyParam verifyParam = new VerifyParam();
        verifyParam.fromSite = i;
        verifyParam.actionType = str;
        verifyParam.userId = Login.getUserId();
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, String>() { // from class: com.taobao.login4android.login.LoginController.6
            /* JADX INFO: Access modifiers changed from: private */
            public void errorBroadcast(RpcResponse rpcResponse) {
                int i2;
                String str2;
                if (rpcResponse != null) {
                    i2 = rpcResponse.code;
                    str2 = rpcResponse.message;
                } else {
                    i2 = 1100;
                    str2 = "";
                }
                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, i2, str2, "");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Object[] objArr) {
                return Login.getDeviceTokenKey(Login.getUserId());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str2) {
                verifyParam.deviceTokenKey = str2;
                VerifyServiceImpl.getInstance().getIdentityVerificationUrl(verifyParam, new RpcRequestCallback() { // from class: com.taobao.login4android.login.LoginController.6.1
                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onError(RpcResponse rpcResponse) {
                        errorBroadcast(rpcResponse);
                    }

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onSuccess(RpcResponse rpcResponse) {
                        GetVerifyUrlResponse getVerifyUrlResponse = (GetVerifyUrlResponse) rpcResponse;
                        T t = getVerifyUrlResponse.returnValue;
                        if (t != 0) {
                            String str3 = ((GetVerifyUrlReturnData) t).token;
                            if (!TextUtils.isEmpty(str3)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("token", str3);
                                hashMap.put("scene", str);
                                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_SUCCESS, false, 0, "", (Map<String, String>) hashMap, "");
                                return;
                            }
                            String str4 = ((GetVerifyUrlReturnData) getVerifyUrlResponse.returnValue).url;
                            UrlParam urlParam = new UrlParam();
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            urlParam.ivScene = str;
                            urlParam.url = str4;
                            Bundle bundle2 = bundle;
                            if (bundle2 != null) {
                                urlParam.showSkipButton = bundle2.getBoolean(LoginConstant.ICBU_IV_SKIP, false);
                            }
                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                            LoginController.this.openUrl(context, urlParam);
                        }
                    }

                    @Override // com.ali.user.mobile.callback.RpcRequestCallback
                    public void onSystemError(RpcResponse rpcResponse) {
                        errorBroadcast(rpcResponse);
                    }
                });
            }
        }, new Object[0]);
    }

    public void navToIVWithUserId(final Context context, final String str, final int i, final String str2) {
        if (TextUtils.isEmpty(str)) {
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, -3, LoginConstant.FETCH_IV_FAIL_INVALID_SCENE, "");
        } else if (TextUtils.isEmpty(str2)) {
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, -2, LoginConstant.FETCH_IV_FAIL_INVALID_USERID, "");
        } else {
            new CoordinatorWrapper().execute(new AsyncTask<Object, Void, GetVerifyUrlResponse>() { // from class: com.taobao.login4android.login.LoginController.8
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.AsyncTask
                public GetVerifyUrlResponse doInBackground(Object[] objArr) {
                    VerifyParam verifyParam = new VerifyParam();
                    verifyParam.fromSite = i;
                    String str3 = str2;
                    verifyParam.userId = str3;
                    verifyParam.actionType = str;
                    verifyParam.deviceTokenKey = Login.getDeviceTokenKey(str3);
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
                    if (getVerifyUrlResponse == null) {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, -1, "RET_NULL", "");
                        return;
                    }
                    int i2 = getVerifyUrlResponse.code;
                    if (i2 != 3000) {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, i2, getVerifyUrlResponse.message, "");
                        return;
                    }
                    T t = getVerifyUrlResponse.returnValue;
                    if (t != 0) {
                        if (TextUtils.isEmpty(((GetVerifyUrlReturnData) t).url)) {
                            return;
                        }
                        UrlParam urlParam = new UrlParam();
                        urlParam.ivScene = str;
                        urlParam.url = ((GetVerifyUrlReturnData) getVerifyUrlResponse.returnValue).url;
                        urlParam.userid = str2;
                        LoginController.this.openUrl(context, urlParam);
                        return;
                    }
                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_IV_FAIL, false, -4, LoginConstant.FETCH_IV_FAIL_INVALID_RETURNVALUE, "");
                }
            }, new Object[0]);
        }
    }

    public void navToWebViewByScene(final Context context, final String str, int i, final Map<String, Object> map) {
        AccountCenterParam accountCenterParam = new AccountCenterParam();
        accountCenterParam.scene = str;
        if (DataProviderFactory.getDataProvider().isYoukuApps()) {
            if (DataProviderFactory.getDataProvider().getSite() == 0) {
                accountCenterParam.fromSite = 23;
            } else {
                accountCenterParam.fromSite = DataProviderFactory.getDataProvider().getCurrentSite();
            }
            accountCenterParam.useSessionDomain = true;
        } else {
            accountCenterParam.fromSite = i;
        }
        if (context == null) {
            context = DataProviderFactory.getApplicationContext();
        }
        UrlFetchServiceImpl.getInstance().navBySceneRemote(accountCenterParam, new RpcRequestCallback() { // from class: com.taobao.login4android.login.LoginController.5
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                ToastUtil.showToast(context, (rpcResponse == null || !TextUtils.isEmpty(rpcResponse.message)) ? context.getString(R.string.aliuser_network_error) : rpcResponse.message, 0);
                AppMonitorAdapter.commitFail("Page_Member_Account", "Account_" + str + "_URL", "0", "");
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse == null) {
                    AppMonitorAdapter.commitFail("Page_Member_Account", "Account_" + str + "_URL", "0", "");
                    return;
                }
                MtopAccountCenterUrlResponseData mtopAccountCenterUrlResponseData = (MtopAccountCenterUrlResponseData) rpcResponse;
                if (!TextUtils.isEmpty(mtopAccountCenterUrlResponseData.h5Url)) {
                    AppMonitorAdapter.commitSuccess("Page_Member_Account", "Account_" + str + "_URL");
                    UrlParam urlParam = new UrlParam();
                    urlParam.scene = str;
                    urlParam.url = mtopAccountCenterUrlResponseData.h5Url;
                    urlParam.site = DataProviderFactory.getDataProvider().getSite();
                    urlParam.ext = map;
                    ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(context, urlParam);
                    return;
                }
                AppMonitorAdapter.commitFail("Page_Member_Account", "Account_" + str + "_URL", "0", String.valueOf(mtopAccountCenterUrlResponseData.code));
                ToastUtil.showToast(context, mtopAccountCenterUrlResponseData.errorMessage, 0);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                onError(rpcResponse);
                AppMonitorAdapter.commitFail("Page_Member_Account", "Account_" + str + "_URL", "0", "");
            }
        });
    }

    public boolean processAutoLoginResponse(RpcResponse<LoginReturnData> rpcResponse, boolean z, boolean z2, Bundle bundle) {
        if (rpcResponse != null && "SUCCESS".equals(rpcResponse.actionType)) {
            if (SiteUtil.getDefaultLoginSite() == 4 && !DataProviderFactory.getDataProvider().isAccountProfileExist()) {
                UserTrackAdapter.sendUT("ICBU_Profile_NoExist");
                logout();
                if (z2) {
                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, 725, "", this.browserRefUrl);
                }
                return false;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(LoginConstants.LOGIN_TYPE, LoginType.ServerLoginType.AutoLogin.getType());
                LoginDataHelper.processLoginReturnData(z2, rpcResponse.returnValue, hashMap);
                return true;
            } catch (Exception unused) {
                if (z) {
                    userLogin(z, z2, bundle);
                } else if (z2) {
                    BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, 726, "", this.browserRefUrl);
                }
                return false;
            }
        }
        processNetworkError(rpcResponse, z, z2, bundle);
        return false;
    }

    public void userLogin(boolean z, final boolean z2, final Bundle bundle) {
        if (z) {
            LoginTLogAdapter.e(TAG, "try sdkLogin");
            LoginThreadHelper.runOnUIThread(new LoginTask() { // from class: com.taobao.login4android.login.LoginController.3
                @Override // com.taobao.login4android.thread.LoginTask
                public void excuteTask() {
                    if (DataProviderFactory.getApplicationContext() != null) {
                        try {
                            Login.session.clearSessionOnlyCookie();
                            LoginTLogAdapter.e(LoginController.TAG, "start openLoginPage");
                            UserTrackAdapter.sendUT("login_api_show_page");
                            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openLoginPage(DataProviderFactory.getApplicationContext(), ApiReferer.generateApiReferer(), bundle);
                            LoginTLogAdapter.i(LoginController.TAG, "aliuserLogin.openLoginPage");
                            return;
                        } catch (Exception e) {
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "openLoginPageFail");
                            LoginTLogAdapter.e(LoginController.TAG, e.getMessage());
                            e.printStackTrace();
                            if (z2) {
                                BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, LoginConstant.RESULT_WINDVANE_CLOSEALL, "Exception", LoginController.this.browserRefUrl);
                            }
                            LoginTLogAdapter.d(LoginController.TAG, "login failed: Exception:" + e.getMessage());
                            return;
                        }
                    }
                    if (z2) {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, 722, "ContextNull", LoginController.this.browserRefUrl);
                    }
                    LoginTLogAdapter.d(LoginController.TAG, "DataProviderFactory.getApplicationContext() is null");
                }
            });
        } else if (z2) {
            BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED, false, 723, "showUI=false", this.browserRefUrl);
        }
    }

    private boolean refreshCookies(boolean z) {
        try {
            String[] wapCookies = new GetWapLoginCookiesBusiness().getWapCookies(ApiReferer.generateApiReferer(), z);
            if (wapCookies == null || wapCookies.length <= 0) {
                return false;
            }
            Login.session.injectCookie(wapCookies, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void openRegisterPage(Context context) {
        openRegisterPage(context, null);
    }

    public synchronized void logout(final LogoutParam logoutParam, final CommonCallback commonCallback) {
        if (logoutParam == null) {
            return;
        }
        this.isNotifyLogout = false;
        Login.session.clearAutoLoginInfo();
        boolean isInABTestRegion = LoginSwitch.isInABTestRegion(LoginSwitch.LOGOUT_REFACTOR, -1);
        boolean isInABTestRegion2 = LoginSwitch.isInABTestRegion(LoginSwitch.LOGOUT_TO_MULTI, 3000);
        boolean isInABTestRegion3 = LoginSwitch.isInABTestRegion(LoginSwitch.LOGOUT_POST, LoginSwitch.LOGOUT_POST_DEFAULT);
        if (isInABTestRegion && !isInABTestRegion2 && isInABTestRegion3) {
            SecurityGuardManagerWraper.getSessionList(new DataCallback<SessionList>() { // from class: com.taobao.login4android.login.LoginController.4
                @Override // com.ali.user.mobile.callback.DataCallback
                public void result(SessionList sessionList) {
                    if (LoginController.this.sessionMoreThen1(sessionList)) {
                        logoutParam.loggedUserNum = sessionList.sessionModels.size();
                        UserTrackAdapter.sendUT("LogoutTong2");
                        BeforeLogoutBiz.callBeforeLogout(logoutParam, new CommonCallback() { // from class: com.taobao.login4android.login.LoginController.4.1
                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onFail(int i, String str) {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                LoginController.this.doSimpleLogoutRpc(logoutParam, commonCallback);
                            }

                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onSuccess() {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                LoginController.this.doSimpleLogoutRpc(logoutParam, commonCallback);
                            }
                        });
                        return;
                    }
                    LoginController.this.doSimpleLogoutRpc(logoutParam, commonCallback);
                }
            });
        } else {
            doSimpleLogoutRpc(logoutParam, commonCallback);
        }
    }

    public synchronized void logout() {
        logout(Login.getLoginSite(), Login.getSid(), Login.getLoginToken(), Login.getUserId(), false, null);
    }
}
