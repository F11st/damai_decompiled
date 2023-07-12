package com.taobao.login4android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.init.AliUserInit;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.LoginService;
import com.ali.user.mobile.service.MemberCenterService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.StorageService;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.login4android.biz.getAlipayCookies.mtop.GetThirdCookiesResponseData;
import com.taobao.login4android.biz.getWapCookies.GetWapLoginCookiesBusiness;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.broadcast.LoginBroadcastReceiver;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.constants.LoginEnvType;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.constants.LoginUrlConstants;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.login.CheckResultCallback;
import com.taobao.login4android.login.DefaultTaobaoAppProvider;
import com.taobao.login4android.login.InternalTokenCallback;
import com.taobao.login4android.login.LoginController;
import com.taobao.login4android.scan.QrScanActivity;
import com.taobao.login4android.session.ISession;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.SuccessTip;
import com.taobao.login4android.session.constants.SessionConstants;
import com.taobao.login4android.thread.LoginAsyncTask;
import com.taobao.login4android.thread.LoginThreadHelper;
import com.taobao.login4android.utils.ReflectionHelper;
import com.ut.mini.UTAnalytics;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Login {
    private static final long COOKIES_REFRESH_INTERVAL = 1800000;
    private static final long COOKIES_REFRESH_SHRINK = 1680000;
    private static final String REFRESH_RESULT = "refreshResult";
    public static final String TAG = "login.Login";
    public static Bundle launchBundle;
    private static AsyncTask loginTask;
    private static transient Pattern[] mLoginPatterns;
    private static transient Pattern[] mLogoutPatterns;
    private static BroadcastReceiver mReceiver;
    public static ISession session;
    private static final Object lock = new Object();
    private static Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.Login$a */
    /* loaded from: classes11.dex */
    public static class AsyncTaskC6704a extends LoginAsyncTask {
        final /* synthetic */ boolean a;

        AsyncTaskC6704a(boolean z) {
            this.a = z;
        }

        @Override // com.taobao.login4android.thread.LoginAsyncTask
        public Object excuteTask(Object[] objArr) throws Exception {
            LoginTLogAdapter.e(LoginAsyncTask.TAG, "loginWithBundle finish");
            UserTrackAdapter.sendUT("OPEN_LOGIN_PAGE_WHEN_TIMEOUT");
            LoginController.getInstance().userLogin(this.a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.Login$b */
    /* loaded from: classes11.dex */
    public static class AsyncTaskC6705b extends LoginAsyncTask<Object, Void, Void> {
        final /* synthetic */ boolean a;
        final /* synthetic */ Bundle b;

        AsyncTaskC6705b(boolean z, Bundle bundle) {
            this.a = z;
            this.b = bundle;
        }

        @Override // com.taobao.login4android.thread.LoginAsyncTask
        /* renamed from: a */
        public Void excuteTask(Object... objArr) throws RemoteException {
            TLogAdapter.e(LoginAsyncTask.TAG, "login progress: excuteTask");
            LoginController.getInstance().autoLogin(this.a, this.b);
            TLogAdapter.d(LoginAsyncTask.TAG, "loginWithBundle finish");
            return null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.Login$c */
    /* loaded from: classes11.dex */
    static class AsyncTaskC6706c extends LoginAsyncTask {
        final /* synthetic */ RegistParam a;

        AsyncTaskC6706c(RegistParam registParam) {
            this.a = registParam;
        }

        @Override // com.taobao.login4android.thread.LoginAsyncTask
        public Object excuteTask(Object[] objArr) throws Exception {
            LoginController.getInstance().openRegisterPage(DataProviderFactory.getApplicationContext(), this.a);
            TLogAdapter.d(LoginAsyncTask.TAG, "goRegister finish");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.Login$d */
    /* loaded from: classes11.dex */
    public static class C6707d implements CommonCallback {
        final /* synthetic */ Context a;

        C6707d(Context context) {
            this.a = context;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            onSuccess();
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            AliUserLogin.cleanCache();
            LoginTLogAdapter.e(Login.TAG, "logout finish");
            if (this.a != null) {
                LoginController.getInstance().openLoginPage(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.Login$e */
    /* loaded from: classes11.dex */
    static class AsyncTaskC6708e extends LoginAsyncTask<Object, Void, Boolean> {
        AsyncTaskC6708e() {
        }

        @Override // com.taobao.login4android.thread.LoginAsyncTask
        /* renamed from: a */
        public Boolean excuteTask(Object... objArr) throws RemoteException {
            return Boolean.valueOf(LoginController.getInstance().refreshCookies(true, false));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis());
                Login.notifyRefreshResult(true);
            } else {
                LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis() - Login.COOKIES_REFRESH_SHRINK);
                Login.notifyRefreshResult(false);
            }
            LoginTLogAdapter.d(LoginAsyncTask.TAG, "refreshCookies finish");
        }
    }

    public static void applyToken(InternalTokenCallback internalTokenCallback) {
        UserTrackAdapter.sendUT("LoginAPI_ApplyToken");
        LoginController.getInstance().applyToken(internalTokenCallback);
        TLogAdapter.d(TAG, "applyToken finish");
    }

    public static void applyTokenWithRemoteBiz(InternalTokenCallback internalTokenCallback) {
        UserTrackAdapter.sendUT("LoginAPI_ApplyTokenRemoteBiz");
        LoginController.getInstance().applyTokenWithRemoteBiz(DataProviderFactory.getDataProvider().getSite(), getUserId(), internalTokenCallback);
        TLogAdapter.d(TAG, "applyToken finish");
    }

    public static void bindAlipay(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.taobao.login4android.membercenter.bind.BindAlipay");
            ReflectionHelper.invokeMethod(cls, cls.getDeclaredMethod("bindAlipay", String.class, String.class), str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void checkNickModifiable(CheckResultCallback checkResultCallback) {
        LoginController.getInstance().checkNickModifiable(checkResultCallback);
    }

    public static boolean checkSessionValid() {
        ISession iSession = session;
        if (iSession != null) {
            return iSession.checkSessionValid();
        }
        return false;
    }

    public static String getAlipayLoginId() {
        ISession iSession = session;
        if (iSession != null) {
            try {
                JSONObject parseObject = JSON.parseObject(iSession.getExtJson());
                return parseObject != null ? StringUtil.dataMasking(parseObject.getString(SessionConstants.ALIPAY_LOGIN_ID)) : "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static boolean getCommentUsed() {
        ISession iSession = session;
        if (iSession != null) {
            return iSession.isCommentTokenUsed();
        }
        return true;
    }

    public static String getDeviceTokenKey(String str) {
        return SecurityGuardManagerWraper.getDeviceTokenKey(str);
    }

    public static String getDisplayNick() {
        ISession iSession = session;
        return iSession != null ? iSession.getDisplayNick() : "";
    }

    public static String getEcode() {
        ISession iSession = session;
        return iSession != null ? iSession.getEcode() : "";
    }

    public static String getEmail() {
        ISession iSession = session;
        return iSession != null ? iSession.getEmail() : "";
    }

    public static String getExtJson() {
        ISession iSession = session;
        return iSession != null ? iSession.getExtJson() : "";
    }

    public static long getHavanaSsoTokenExpiredTime() {
        ISession iSession = session;
        if (iSession != null) {
            return iSession.getHavanaSsoTokenExpiredTime();
        }
        return 0L;
    }

    public static String getHeadPicLink() {
        ISession iSession = session;
        return iSession != null ? iSession.getHeadPicLink() : "";
    }

    public static void getLoginMaskPhone(int i, CommonDataCallback commonDataCallback) {
        if (commonDataCallback == null) {
            return;
        }
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginMaskPhone(i, commonDataCallback);
        } else {
            commonDataCallback.onFail(-199, "sdk not init");
        }
    }

    public static String getLoginPhone() {
        ISession iSession = session;
        if (iSession != null) {
            String loginPhone = iSession.getLoginPhone();
            return TextUtils.isEmpty(loginPhone) ? "" : StringUtil.dataMasking(loginPhone);
        }
        return "";
    }

    public static int getLoginSite() {
        ISession iSession = session;
        if (iSession != null) {
            return iSession.getLoginSite();
        }
        return 0;
    }

    public static String getLoginToken() {
        ISession iSession = session;
        return iSession != null ? iSession.getLoginToken() : "";
    }

    public static String getNick() {
        ISession iSession = session;
        return iSession != null ? iSession.getNick() : "";
    }

    public static String getOldEncryptedUserId() {
        ISession iSession = session;
        return iSession != null ? iSession.getOldEncryptedUserId() : "";
    }

    public static String getOldUserId() {
        ISession iSession = session;
        return iSession != null ? iSession.getOldUserId() : "";
    }

    public static String getOneTimeToken() {
        ISession iSession = session;
        return iSession != null ? iSession.getOneTimeToken() : "";
    }

    public static String getSid() {
        ISession iSession = session;
        return iSession != null ? iSession.getSid() : "";
    }

    public static String getSnsNick() {
        ISession iSession = session;
        if (iSession != null) {
            try {
                JSONObject parseObject = JSON.parseObject(iSession.getExtJson());
                return parseObject != null ? parseObject.getString(SessionConstants.TAOBAO_NICK_NAME) : "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String getSubSid() {
        ISession iSession = session;
        return iSession != null ? iSession.getSubSid() : "";
    }

    public static SuccessTip getSuccessTip() {
        ISession iSession = session;
        if (iSession != null) {
            return iSession.getSuccessTip();
        }
        return null;
    }

    public static String getUserId() {
        ISession iSession = session;
        return iSession != null ? iSession.getUserId() : "";
    }

    @Deprecated
    public static String getUserName() {
        ISession iSession = session;
        return iSession != null ? iSession.getUserName() : "";
    }

    public static void goRegister(RegistParam registParam) {
        new CoordinatorWrapper().execute(new AsyncTaskC6706c(registParam), new Object[0]);
    }

    public static void init(Context context, String str, String str2, LoginEnvType loginEnvType) {
        init(context, str, str2, loginEnvType, new DefaultTaobaoAppProvider(), loginEnvType != null && loginEnvType.getSdkEnvType() == 1);
    }

    public static boolean isLoginUrl(String str) {
        return isLoginUrl(LoginUrlConstants.getLoginUrls(), str);
    }

    public static boolean isLogoutUrl(String str) {
        try {
            return isUrlValid(LoginUrlConstants.getLogoutUrls(), str);
        } catch (Throwable th) {
            LoginTLogAdapter.e(TAG, th.getMessage());
            return false;
        }
    }

    public static boolean isQRLoginUrl(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("qrcodeCheck.htm");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isUrlValid(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Pattern[] patternArr = null;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("[;]");
            int length = split.length;
            Pattern[] patternArr2 = new Pattern[length];
            for (int i = 0; i < length; i++) {
                patternArr2[i] = Pattern.compile(split[i]);
            }
            patternArr = patternArr2;
        }
        if (patternArr != null) {
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(str2).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void login(boolean z) {
        login(z, null);
    }

    public static void logout(Context context, int i, String str, String str2, String str3, boolean z) {
        UserTrackAdapter.sendUT("LoginAPI_Logout");
        if (!LoginStatus.compareAndSetLogining(false, true)) {
            TLogAdapter.e(TAG, "logout: return because is logining right now. isLogining=true, userLogin=" + LoginStatus.isUserLogin() + ", lastLoginTime=" + LoginStatus.getLastLoginTime());
            return;
        }
        LoginController.getInstance().logout(i, str, str2, str3, z, new C6707d(context));
    }

    public static void navByScene(Context context, String str) {
        navByScene(context, str, DataProviderFactory.getDataProvider().getSite());
    }

    public static void navToIVByScene(Context context, String str) {
        navToIVByScene(context, str, null);
    }

    public static void navToIVWithUserId(Context context, String str, String str2) {
        LoginController.getInstance().navToIVWithUserId(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyRefreshResult(boolean z) {
        try {
            LoginAction loginAction = LoginAction.NOTIFY_REFRESH_COOKIES;
            Intent intent = new Intent(loginAction.name());
            intent.putExtra(REFRESH_RESULT, z);
            intent.setPackage(DataProviderFactory.getApplicationContext().getPackageName());
            DataProviderFactory.getApplicationContext().sendBroadcast(intent);
            LoginTLogAdapter.d(TAG, "sendBroadcast:" + loginAction.name());
        } catch (NullPointerException unused) {
        }
    }

    public static void onekeyLogin(Context context, Map<String, String> map, CommonCallback commonCallback) {
        ((LoginService) ServiceFactory.getService(LoginService.class)).onekeyLogin(context, map, commonCallback);
    }

    public static void openScheme(Context context, String str) {
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        LoginController.getInstance().openScheme(context, urlParam);
    }

    public static void openUrl(Context context, String str) {
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        LoginController.getInstance().openUrl(context, urlParam);
    }

    private static void preFetchAliComInfo() {
        if (ServiceFactory.getService(NumberAuthService.class) == null || !LoginSwitch.getSwitch("enable_auth_prefetch", "true")) {
            return;
        }
        try {
            if (TextUtils.isEmpty(getLoginToken())) {
                TLogAdapter.e(TAG, "call authsdk prefetch");
                ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).preFecth();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void qrLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent(context, QrScanActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(LoginConstant.SCAN_KEY, str);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static GetThirdCookiesResponseData refreshAlipayCookie() {
        if (checkSessionValid()) {
            return new GetWapLoginCookiesBusiness().getAlipayCookies();
        }
        return null;
    }

    public static void refreshCookies() {
        boolean z;
        UserTrackAdapter.sendUT("LoginAPI_RefreshCookies");
        if (!checkSessionValid()) {
            LoginTLogAdapter.d(TAG, "SessionManager invalid, discard refresh cookies");
            notifyRefreshResult(false);
            return;
        }
        synchronized (mLock) {
            if (System.currentTimeMillis() - LoginStatus.getLastRefreshCookieTime() > 1800000) {
                z = true;
                LoginStatus.setLastRefreshCookieTime(System.currentTimeMillis());
            } else {
                z = false;
            }
        }
        if (z) {
            new CoordinatorWrapper().execute(new AsyncTaskC6708e(), new Object[0]);
            return;
        }
        notifyRefreshResult(false);
        LoginTLogAdapter.d(TAG, "No need to refresh cookies");
    }

    public static void setCommentUsed(boolean z) {
        ISession iSession = session;
        if (iSession != null) {
            iSession.setCommentTokenUsed(z);
        }
    }

    public static void setHavanaSsoTokenExpiredTime(long j) {
        ISession iSession = session;
        if (iSession != null) {
            iSession.setHavanaSsoTokenExpiredTime(j);
        }
    }

    public static void setLaunchBundle(Bundle bundle) {
        TLogAdapter.e(TAG, "setLaunchBundle," + bundle.getString("loginToken"));
        launchBundle = bundle;
    }

    public static void setOneTimeToken(String str) {
        ISession iSession = session;
        if (iSession != null) {
            iSession.setOneTimeToken(str);
        }
    }

    public static void touristLogin(String str) {
        if (ServiceFactory.getService(LoginService.class) != null) {
            ((LoginService) ServiceFactory.getService(LoginService.class)).touristLogin(str, null);
        }
    }

    public static boolean isLoginUrl(String str, String str2) {
        try {
            return isUrlValid(str, str2);
        } catch (Throwable th) {
            LoginTLogAdapter.e(TAG, th.getMessage());
            return false;
        }
    }

    public static void login(boolean z, Bundle bundle) {
        TLogAdapter.e(TAG, "start login: showUI:" + z);
        if (!LoginController.getInstance().isLoginSDKInited()) {
            TLogAdapter.e(TAG, "loginsdk has not inited, return");
            return;
        }
        if (bundle != null) {
            LoginStatus.browserRefUrl = bundle.getString(LoginConstants.BROWSER_REF_URL);
        }
        if (!LoginStatus.compareAndSetLogining(false, true)) {
            UserTrackAdapter.sendUT("login_api_login_exist");
            StringBuilder sb = new StringBuilder();
            sb.append("login: return because is logining right now. isLogining=true, userLogin=");
            sb.append(LoginStatus.isUserLogin());
            sb.append(", lastLoginTime=");
            sb.append(LoginStatus.getLastLoginTime());
            sb.append(", extraData = ");
            sb.append(bundle == null ? "null" : bundle.toString());
            TLogAdapter.e(TAG, sb.toString());
            long currentTimeMillis = System.currentTimeMillis() - LoginStatus.getLastLoginTime();
            Log.e(TAG, "t = " + currentTimeMillis);
            if (currentTimeMillis >= 180000) {
                TLogAdapter.e(TAG, "reset login status after 3min");
                LoginStatus.resetLoginFlag();
            } else if (z && LoginStatus.isUserLogin()) {
                AsyncTask asyncTask = loginTask;
                if (asyncTask != null && !asyncTask.isCancelled() && loginTask.getStatus() != AsyncTask.Status.FINISHED) {
                    TLogAdapter.e(TAG, "cancel last login task");
                    try {
                        loginTask.cancel(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (LoginSwitch.getSwitch(LoginSwitch.OPEN_LOGIN_PAGE_WHEN_IS_LOGIN, "false")) {
                    BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_CLOSE_ACTION));
                    loginTask = new AsyncTaskC6704a(z);
                    new CoordinatorWrapper().execute(loginTask, new Object[0]);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        loginTask = new AsyncTaskC6705b(z, bundle);
        new CoordinatorWrapper().execute(loginTask, new Object[0]);
    }

    public static void navByScene(Context context, String str, Map<String, Object> map) {
        LoginController.getInstance().navToWebViewByScene(context, str, DataProviderFactory.getDataProvider().getSite(), map);
    }

    public static void navToIVByScene(Context context, String str, Bundle bundle) {
        navToIVByScene(context, str, DataProviderFactory.getDataProvider().getSite(), bundle);
    }

    public static void init(Context context, String str, String str2, LoginEnvType loginEnvType, DefaultTaobaoAppProvider defaultTaobaoAppProvider) {
        init(context, str, str2, loginEnvType, defaultTaobaoAppProvider, loginEnvType != null && loginEnvType.getSdkEnvType() == 1);
    }

    public static void navByScene(Context context, String str, int i) {
        Properties properties = new Properties();
        if (!TextUtils.isEmpty(str)) {
            properties.put("scene", str);
        }
        UserTrackAdapter.sendUT("LoginAPI_NavByScene", properties);
        LoginController.getInstance().navToWebViewByScene(context, str, i);
    }

    public static void navToIVByScene(Context context, String str, int i, Bundle bundle) {
        Properties properties = new Properties();
        if (!TextUtils.isEmpty(str)) {
            properties.put("scene", str);
        }
        UserTrackAdapter.sendUT("LoginAPI_navToIV", properties);
        LoginController.getInstance().navToIVByScene(context, str, i, bundle);
    }

    public static synchronized void init(Context context, String str, String str2, LoginEnvType loginEnvType, boolean z) {
        synchronized (Login.class) {
            init(context, str, str2, loginEnvType, new DefaultTaobaoAppProvider(), z);
        }
    }

    private static synchronized void init(final Context context, String str, String str2, LoginEnvType loginEnvType, final DefaultTaobaoAppProvider defaultTaobaoAppProvider, boolean z) {
        synchronized (Login.class) {
            Debuggable.init(context);
            if (DataProviderFactory.getDataProvider() != null && (DataProviderFactory.getDataProvider() instanceof DefaultTaobaoAppProvider) && DataProviderFactory.getApplicationContext() != null) {
                TLogAdapter.d(TAG, "Login has inited, discard current request.");
                return;
            }
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT("sdk_init_commit", properties);
            session = SessionManager.getInstance(context);
            boolean z2 = true;
            HashMap hashMap = new HashMap();
            boolean z3 = !TextUtils.isEmpty(getLoginToken());
            hashMap.put("isValidLogin", String.valueOf(checkSessionValid()));
            hashMap.put("canAutoLogin", String.valueOf(z3));
            UserTrackAdapter.sendUserTrack(UTConstant.PageName.UT_PAGE_EXTEND, "loginValid", hashMap);
            TLogAdapter.e(TAG, " start Login init.");
            defaultTaobaoAppProvider.setContext(context);
            defaultTaobaoAppProvider.setTTID(str);
            defaultTaobaoAppProvider.setEnvType(loginEnvType.getSdkEnvType());
            DataProviderFactory.setDataProvider(defaultTaobaoAppProvider);
            TLogAdapter.e(TAG, " start Login init.app version = " + AppInfo.getInstance().getAppVersion());
            if (ServiceFactory.getService(StorageService.class) != null) {
                ((StorageService) ServiceFactory.getService(StorageService.class)).init(context.getApplicationContext());
            }
            ISession iSession = session;
            if (!DataProviderFactory.getDataProvider().registerSidToMtop() || !DataProviderFactory.getDataProvider().isNeedUpdateUTAccount()) {
                z2 = false;
            }
            iSession.setWriteUT(z2);
            preFetchAliComInfo();
            new CoordinatorWrapper().execute(new Runnable() { // from class: com.taobao.login4android.Login.1
                @Override // java.lang.Runnable
                public void run() {
                    String[] split;
                    try {
                        AliUserInit.initSystemService();
                        LoginController.getInstance().initAliuserSDK(DefaultTaobaoAppProvider.this);
                        if (Login.session != null) {
                            String str3 = "";
                            if (DataProviderFactory.getDataProvider().registerSidToMtop() && DataProviderFactory.getDataProvider().isNeedUpdateUTAccount()) {
                                UserTrackAdapter.sendUT("init_step_register_mtop");
                                TLogAdapter.e(Login.TAG, "register SessionInfo to mtopsdk:(sid:" + Login.session.getSid());
                                ((RpcService) ServiceFactory.getService(RpcService.class)).registerSessionInfo(Login.session.getSid(), Login.session.getUserId(), Login.session.getSessionDisastergrd());
                                try {
                                    try {
                                        UTAnalytics.getInstance().updateUserAccount(Login.session.getNick() == null ? "" : Login.session.getNick(), Login.session.getUserId() == null ? "" : Login.session.getUserId(), Login.session.getUidDigest() == null ? "" : Login.session.getUidDigest());
                                        UserTrackAdapter.sendUT("init_step_update_usertrack");
                                    } catch (Throwable unused) {
                                        UTAnalytics.getInstance().updateUserAccount(Login.session.getNick() == null ? "" : Login.session.getNick(), Login.session.getUserId() == null ? "" : Login.session.getUserId());
                                    }
                                } catch (Throwable unused2) {
                                }
                            } else {
                                UserTrackAdapter.sendUT("init_step_login_do_not_write_mtop_usertrack");
                            }
                            if (Login.session.checkSessionValid()) {
                                boolean z4 = true;
                                if (DataProviderFactory.getDataProvider().isCheckCookieValid() && LoginSwitch.getSwitch("login_init_check", "true") && TextUtils.equals(LoginThreadHelper.getCurProcessName(context), context.getPackageName())) {
                                    try {
                                        SessionConstants.IS_CHECK_COOKIE_VALID = true;
                                        CookieManager cookieManager = CookieManager.getInstance();
                                        cookieManager.setAcceptCookie(true);
                                        String cookie = cookieManager.getCookie(".taobao.com");
                                        if (TextUtils.isEmpty(cookie)) {
                                            z4 = false;
                                        } else {
                                            String str4 = "";
                                            for (String str5 : cookie.split(";")) {
                                                if (!TextUtils.isEmpty(str5) && str5.trim().startsWith("unb")) {
                                                    str3 = str5.split("=")[1];
                                                } else if (!TextUtils.isEmpty(str5) && str5.trim().startsWith("munb")) {
                                                    str4 = str5.split("=")[1];
                                                }
                                            }
                                            if (!TextUtils.equals(Login.session.getUserId(), str3) && (!TextUtils.isEmpty(str3) || !TextUtils.equals(Login.session.getUserId(), str4))) {
                                                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                                                    if (LoginSwitch.getSwitch("login_init_validcookie", "false")) {
                                                        Login.session.setSessionExpiredTime(1L);
                                                    } else if (LoginSwitch.getSwitch("login_init_refreshcookie", "true") && !Login.session.recoverCookie()) {
                                                        Login.session.setSessionExpiredTime(1L);
                                                    }
                                                    UserTrackAdapter.sendUT(UTConstans.PageName.UT_PAGE_SMS, "unbIsNull");
                                                } else {
                                                    if (LoginSwitch.getSwitch("login_init_recovercookie", "false")) {
                                                        Login.session.recoverCookie();
                                                    } else {
                                                        Login.session.setSessionExpiredTime(1L);
                                                    }
                                                    TLogAdapter.e(Login.TAG, "SessionNotEqual:  cookie:" + cookie);
                                                    UserTrackAdapter.sendUT(UTConstans.PageName.UT_PAGE_SMS, "SessionNotEqual");
                                                }
                                            }
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (z4) {
                                    if (LoginSwitch.getSwitch(LoginSwitch.FORCE_SID_CHECK, "false")) {
                                        String encode = URLEncoder.encode(Login.getSid(), "utf-8");
                                        if (!TextUtils.isEmpty(encode) && encode.contains("%")) {
                                            TLogAdapter.e(Login.TAG, "sid encode is invalid: urlEncodeSid=" + encode + ",sid=" + Login.getSid());
                                        } else {
                                            ((RpcService) ServiceFactory.getService(RpcService.class)).registerSessionInfo(Login.session.getSid(), Login.session.getUserId(), Login.session.getSessionDisastergrd());
                                        }
                                    } else {
                                        ((RpcService) ServiceFactory.getService(RpcService.class)).registerSessionInfo(Login.session.getSid(), Login.session.getUserId(), Login.session.getSessionDisastergrd());
                                    }
                                    if (SecurityGuardManagerWraper.getSessionListFromFile() == null) {
                                        SecurityGuardManagerWraper.putSessionModelToFile(LoginDataHelper.sessionToModel(Login.session));
                                    }
                                } else {
                                    if (LoginSwitch.getSwitch("login_init_recovercookie_v3", "true")) {
                                        if (!Login.session.recoverCookie()) {
                                            Login.session.setSessionExpiredTime(1L);
                                        }
                                    } else if (!LoginSwitch.getSwitch("login_init_recovercookie2", "false")) {
                                        Login.session.setSessionExpiredTime(1L);
                                    }
                                    TLogAdapter.e(Login.TAG, "CookieIsNull:  sid:" + Login.getSid());
                                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "CookieIsNull");
                                }
                            }
                        }
                        if (TextUtils.isEmpty(DefaultTaobaoAppProvider.this.getAppkey())) {
                            LoginBroadcastHelper.sentInitFailBroadcast(DataProviderFactory.getApplicationContext());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            if (mReceiver == null) {
                synchronized (lock) {
                    if (mReceiver == null) {
                        mReceiver = new LoginBroadcastReceiver();
                        LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), mReceiver);
                    }
                }
            }
        }
    }

    public static void logout(Context context) {
        logout(context, getLoginSite(), getSid(), getLoginToken(), getUserId(), false);
    }

    public static void navByScene(Context context, String str, boolean z) {
        if (z && ServiceFactory.getService(MemberCenterService.class) != null) {
            ((MemberCenterService) ServiceFactory.getService(MemberCenterService.class)).navByScene(context, str);
        } else {
            navByScene(context, str, DataProviderFactory.getDataProvider().getSite());
        }
    }

    public static void logout() {
        logout(null);
    }
}
