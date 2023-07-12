package com.ali.user.open.tbauth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.cookies.CookieManagerWrapper;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.config.AuthOption;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.model.SystemMessageConstants;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.core.util.ResourceUtils;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.callback.LogoutCallback;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.task.LogoutTask;
import com.ali.user.open.tbauth.task.RpcPresenter;
import com.ali.user.open.tbauth.ui.TbAuthActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import tb.uj2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class TbAuthServiceImpl implements TbAuthService {
    private static final String TAG = "TbAuthService";
    private transient Pattern[] mLoginPatterns;
    private transient Pattern[] mLogoutPatterns;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class RefreshTask extends AsyncTask<Object, Void, Void> {
        MemberCallback callback;

        RefreshTask(MemberCallback memberCallback) {
            this.callback = memberCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            CookieManagerWrapper.INSTANCE.refreshCookie("taobao");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r2) {
            this.callback.onSuccess(r2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goLogin(LoginCallback loginCallback) {
        SDKLogger.d(TAG, "auth goLogin");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), TbAuthActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    private void goQrCodeLogin(Map<String, String> map, LoginCallback loginCallback) {
        SDKLogger.d(TAG, "goQrCodeLogin start");
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), TbAuthActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("login_type", 4);
        intent.putExtra("params", map == null ? "" : JSONUtils.toJsonObject(map).toString());
        KernelContext.getApplicationContext().startActivity(intent);
    }

    private boolean isAuthEnvironmentValid(LoginCallback loginCallback) {
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d(TAG, "auth static field is null");
            if (loginCallback != null) {
                loginCallback.onFailure(SystemMessageConstants.NPE_ERROR, "服务不存在");
            }
            return false;
        } else if (CommonUtils.isNetworkAvailable()) {
            return true;
        } else {
            SDKLogger.d(TAG, "auth network not available");
            loginCallback.onFailure(SystemMessageConstants.NET_WORK_ERROR, ResourceUtils.getString("member_sdk_network_not_available_message"));
            return false;
        }
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void auth(LoginCallback loginCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_NEED_AUTOLOGIN, "0");
        hashMap.put("needSession", "0");
        auth(hashMap, loginCallback);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void autoLogin(final LoginCallback loginCallback) {
        SessionManager sessionManager = SessionManager.INSTANCE;
        if (!TextUtils.isEmpty(sessionManager.getInternalSession().autoLoginToken) && sessionManager.getInternalSession() != null && !TextUtils.isEmpty(sessionManager.getInternalSession().userId)) {
            SDKLogger.d(TAG, "auth auto login");
            RpcPresenter.loginByRefreshToken(new LoginCallback() { // from class: com.ali.user.open.tbauth.TbAuthServiceImpl.2
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    SDKLogger.d(TbAuthServiceImpl.TAG, "auth auto login success");
                    LoginCallback loginCallback2 = loginCallback;
                    if (loginCallback2 != null) {
                        loginCallback2.onFailure(i, str);
                    }
                }

                @Override // com.ali.user.open.callback.LoginCallback
                public void onSuccess(Session session) {
                    SDKLogger.d(TbAuthServiceImpl.TAG, "auth auto login success");
                    LoginCallback loginCallback2 = loginCallback;
                    if (loginCallback2 != null) {
                        loginCallback2.onSuccess(TbAuthServiceImpl.this.getSession());
                    }
                    LoginCallback loginCallback3 = CallbackContext.mGlobalLoginCallback;
                    if (loginCallback3 != null) {
                        loginCallback3.onSuccess(TbAuthServiceImpl.this.getSession());
                    }
                }
            });
        } else if (loginCallback != null) {
            loginCallback.onFailure(-1, "auto login token is empty");
        }
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean checkSessionValid() {
        return ((SessionService) AliMemberSDK.getService(SessionService.class)).isSessionValid();
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public Session getSession() {
        return ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean isAppAuthSurpport(Context context) {
        AuthOption authOption = KernelContext.sOneTimeAuthOption;
        AuthOption authOption2 = AuthOption.H5ONLY;
        if (authOption == authOption2 || KernelContext.authOption == authOption2) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(uj2.ACTION_CUSTOM);
        intent.setData(Uri.parse("tbopen://m.taobao.com/getway/oauth?&appkey=" + ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey() + "&pluginName=taobao.oauth.code.create&apkSign=&sign="));
        if (context == null) {
            context = KernelContext.getApplicationContext();
        }
        return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean isLoginUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mLoginPatterns == null && !TextUtils.isEmpty(ConfigManager.LOGIN_URLS)) {
            String[] split = ConfigManager.LOGIN_URLS.split("[;]");
            Pattern[] patternArr = new Pattern[split.length];
            this.mLoginPatterns = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.mLoginPatterns[i] = Pattern.compile(split[i]);
            }
        }
        for (Pattern pattern : this.mLoginPatterns) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public boolean isLogoutUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mLogoutPatterns == null && !TextUtils.isEmpty(ConfigManager.LOGOUT_URLS)) {
            String[] split = ConfigManager.LOGOUT_URLS.split("[,]");
            Pattern[] patternArr = new Pattern[split.length];
            this.mLogoutPatterns = patternArr;
            int length = patternArr.length;
            for (int i = 0; i < length; i++) {
                this.mLogoutPatterns[i] = Pattern.compile(split[i]);
            }
        }
        for (Pattern pattern : this.mLogoutPatterns) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void logout(LogoutCallback logoutCallback) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("withNoActivity", "true");
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("logout".toUpperCase(), hashMap);
        } catch (Exception unused) {
        }
        new LogoutTask(logoutCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void refreshCookie(MemberCallback memberCallback) {
        new RefreshTask(memberCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void setLoginCallback(LoginCallback loginCallback) {
        CallbackContext.mGlobalLoginCallback = loginCallback;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void setWebViewProxy(WebViewProxy webViewProxy) {
        KernelContext.mWebViewProxy = webViewProxy;
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void tokenLogin(int i, String str, String str2, String str3, LoginCallback loginCallback) {
        TbAuthContext.needSession = true;
        CallbackContext.loginCallback = loginCallback;
        Intent intent = new Intent();
        intent.setClass(KernelContext.getApplicationContext(), TbAuthActivity.class);
        intent.putExtra("login_type", 1);
        intent.putExtra("site", i);
        intent.putExtra("scene", str);
        intent.putExtra("loginToken", str2);
        intent.putExtra(TbAuthConstants.H5_QUERY_STR, str3);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    @Override // com.ali.user.open.tbauth.TbAuthService
    public void auth(Map<String, String> map, final LoginCallback loginCallback) {
        String str;
        String str2;
        String str3;
        String str4;
        SDKLogger.d(TAG, "auth start");
        HashMap hashMap = new HashMap();
        if (map != null && !TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_TRACE_ID))) {
            str = map.get(ParamsConstants.Key.PARAM_TRACE_ID);
        } else {
            str = "oauth" + DeviceInfo.deviceId + (System.currentTimeMillis() / 1000);
        }
        hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, str);
        TbAuthContext.traceId = str;
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Invoke", hashMap);
        if (!isAuthEnvironmentValid(loginCallback)) {
            SDKLogger.d(TAG, "AuthEnvironment invalid");
            return;
        }
        TbAuthContext.sSceneCode = "";
        TbAuthContext.sIBB = "";
        TbAuthContext.authorizeToken = "";
        String str5 = "0";
        if (map != null) {
            str5 = map.get("needSession");
            str2 = map.get(ParamsConstants.Key.PARAM_NEED_AUTOLOGIN);
            str3 = map.get(ParamsConstants.Key.PARAM_ONLY_AUTHCODE);
            TbAuthContext.sSceneCode = map.get(ParamsConstants.Key.PARAM_SCENE_CODE);
            TbAuthContext.authorizeToken = map.get(ParamsConstants.Key.PARAM_AUTHROIZE_TOKEN);
            TbAuthContext.sIBB = map.get(ParamsConstants.Key.PARAM_IBB);
            str4 = map.get(ParamsConstants.Key.PARAM_IS_BIND);
            if ("1".equals(map.get(ParamsConstants.Key.PARAM_H5ONLY))) {
                TbAuthContext.h5Only = true;
            } else {
                TbAuthContext.h5Only = false;
            }
        } else {
            str2 = "0";
            str3 = str2;
            str4 = str3;
        }
        TbAuthContext.needSession = TextUtils.equals(str5, "1");
        TbAuthContext.onlyAuthCode = TextUtils.equals(str3, "1");
        TbAuthContext.isBind = TextUtils.equals(str4, "1");
        if (TextUtils.equals(str2, "1")) {
            autoLogin(new LoginCallback() { // from class: com.ali.user.open.tbauth.TbAuthServiceImpl.1
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str6) {
                    TbAuthServiceImpl.this.goLogin(loginCallback);
                }

                @Override // com.ali.user.open.callback.LoginCallback
                public void onSuccess(Session session) {
                    LoginCallback loginCallback2 = loginCallback;
                    if (loginCallback2 != null) {
                        loginCallback2.onSuccess(TbAuthServiceImpl.this.getSession());
                    }
                }
            });
        } else {
            goLogin(loginCallback);
        }
    }
}
