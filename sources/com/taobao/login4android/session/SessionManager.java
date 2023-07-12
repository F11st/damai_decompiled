package com.taobao.login4android.session;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.session.constants.SessionConstants;
import com.taobao.login4android.session.cookies.LoginCookie;
import com.taobao.login4android.session.cookies.LoginCookieUtils;
import com.taobao.login4android.thread.LoginThreadHelper;
import com.taobao.login4android.utils.FileUtils;
import com.taobao.login4android.utils.LoginSwitch;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.network.HttpIntent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SessionManager implements ISession {
    public static final String CHANNEL_PROCESS = ":channel";
    private static final String CLEAR_SESSION_ACTION = "NOTIFY_CLEAR_SESSION";
    private static final String CLEAR_SESSION_COOKIES_ACTION = "NOTIFY_CLEAR_SESSION_COOKIES";
    public static final String CURRENT_PROCESS = "PROCESS_NAME";
    private static boolean DEBUG = false;
    private static final String NEW_SESSION_TAG = "newSession";
    public static final String NOTIFY_SESSION_VALID = "NOTIFY_SESSION_VALID";
    private static final String TAG = "loginsdk.LoginSessionManager";
    public static final String USERINFO = "userinfo";
    private static final Object checkLock = new Object();
    private static SessionManager instance = null;
    public static boolean isNeedCleanSessionCookie = true;
    private static BroadcastReceiver receiver;
    private static SecurityGuardManager securityGuardManager;
    private String extJson;
    private String mAutoLoginToken;
    private String mBiometricId;
    private Context mContext;
    private String mCookieStr;
    private String mDomainListStr;
    private String mEcode;
    private String mEmail;
    private long mHavanaSsoTokenExpiredTime;
    private String mHeadPicLink;
    private int mInjectCookieCount;
    private boolean mIsCommentUsed;
    public String mLoginPhone;
    private int mLoginSite;
    private long mLoginTime;
    private String mNick;
    private String mOldEncryptedUserId;
    private String mOldNick;
    private String mOldSid;
    private String mOldUserId;
    private String mSessionDisastergrd;
    private long mSessionExpiredTime;
    private String mShowNick;
    private String mSid;
    private String mSubSid;
    private SuccessTip mSuccessTip;
    private String mUidDigest;
    private String mUserId;
    private String mUserName;
    private SharedPreferences storage;
    private List<LoginCookie> mCookie = new CopyOnWriteArrayList();
    private boolean mNewSessionTag = false;
    protected boolean canWriteUT = true;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.session.SessionManager$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 extends Thread {
        AnonymousClass1(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = true;
            try {
                boolean unused = SessionManager.DEBUG = (SessionManager.this.mContext.getApplicationInfo().flags & 2) != 0;
            } catch (Exception unused2) {
            }
            BroadcastReceiver unused3 = SessionManager.receiver = new BroadcastReceiver() { // from class: com.taobao.login4android.session.SessionManager.1.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String stringExtra;
                    final String curProcessName = LoginThreadHelper.getCurProcessName(SessionManager.this.mContext);
                    if (intent != null) {
                        try {
                            stringExtra = intent.getStringExtra("PROCESS_NAME");
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    } else {
                        stringExtra = null;
                    }
                    if (intent != null && TextUtils.equals(intent.getAction(), SessionManager.CLEAR_SESSION_ACTION)) {
                        LoginTLogAdapter.e(SessionManager.TAG, "receive CLEAR_SESSION_ACTION in currentProcessName:" + curProcessName + " sendProcessName:" + stringExtra);
                        if (TextUtils.equals(curProcessName, stringExtra)) {
                            return;
                        }
                        LoginTLogAdapter.e(SessionManager.TAG, "CLEAR_SESSION_ACTION real handler");
                        String stringExtra2 = intent.getStringExtra(Preloader.KEY_SESSION);
                        SessionManager.this.clearMemoryData();
                        if (!TextUtils.isEmpty(stringExtra2)) {
                            SessionManager.this.initChildProcessMemoryData((SessionParams) JSON.parseObject(stringExtra2, SessionParams.class));
                        }
                        new Thread("init-session-data") { // from class: com.taobao.login4android.session.SessionManager.1.1.1
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(curProcessName) || curProcessName.contains(SessionManager.CHANNEL_PROCESS)) {
                                    return;
                                }
                                LoginTLogAdapter.e(SessionManager.TAG, "recoverCookie");
                                SessionManager.this.recoverCookie();
                            }
                        }.start();
                        LoginStatus.resetLoginFlag();
                    } else if (intent == null || !TextUtils.equals(intent.getAction(), SessionManager.CLEAR_SESSION_COOKIES_ACTION)) {
                    } else {
                        LoginTLogAdapter.e(SessionManager.TAG, "receive CLEAR_SESSION_COOKIES_ACTION in currentProcessName:" + curProcessName + " sendProcessName:" + stringExtra);
                        if (TextUtils.equals(curProcessName, stringExtra)) {
                            return;
                        }
                        LoginTLogAdapter.e(SessionManager.TAG, "CLEAR_SESSION_COOKIES_ACTION real handler");
                        SessionManager.this.clearMemoryData();
                        SessionManager.this.getSsoDomainList();
                        if (!TextUtils.isEmpty(curProcessName) && !curProcessName.contains(SessionManager.CHANNEL_PROCESS)) {
                            SessionManager.this.clearChildProcessCookies();
                            return;
                        }
                        if (LoginSwitch.getSwitch("ingoreChannelProcess", "true")) {
                            return;
                        }
                        SessionManager.this.clearChildProcessCookies();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SessionManager.CLEAR_SESSION_ACTION);
            intentFilter.addAction(SessionManager.NOTIFY_SESSION_VALID);
            intentFilter.addAction(SessionManager.CLEAR_SESSION_COOKIES_ACTION);
            try {
                SessionManager.this.mContext.registerReceiver(SessionManager.receiver, intentFilter);
            } catch (Exception unused4) {
            }
            SessionManager.this.initMemoryData();
            boolean checkSessionValid = SessionManager.this.checkSessionValid();
            if (checkSessionValid) {
                try {
                    Intent intent = new Intent(SessionManager.NOTIFY_SESSION_VALID);
                    intent.putExtra("PROCESS_NAME", LoginThreadHelper.getCurProcessName(SessionManager.this.mContext));
                    intent.setPackage(SessionManager.this.mContext.getPackageName());
                    SessionManager.this.mContext.sendBroadcast(intent);
                    LoginTLogAdapter.i(SessionManager.TAG, "sendBroadcast: NOTIFY_SESSION_VALID");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                HashMap hashMap = new HashMap();
                if (TextUtils.isEmpty(SessionManager.this.getLoginToken())) {
                    z = false;
                }
                hashMap.put("isValidLogin", String.valueOf(checkSessionValid));
                hashMap.put("canAutoLogin", String.valueOf(z));
                SessionManager.this.sendCustomTrack(UTConstant.PageName.UT_PAGE_EXTEND, "loginValid", hashMap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    protected SessionManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChildProcessCookies() {
        new Thread("clear-cookie-data") { // from class: com.taobao.login4android.session.SessionManager.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    String readFileData = FileUtils.readFileData(SessionManager.this.mContext, SessionConstants.INJECT_COOKIE_OLD);
                    if (TextUtils.isEmpty(readFileData)) {
                        return;
                    }
                    SessionManager.this.mCookie.addAll(JSON.parseArray(SessionManager.this.decrypt(readFileData), LoginCookie.class));
                    SessionManager sessionManager = SessionManager.this;
                    sessionManager.clearWebviewCookie(sessionManager.getSsoDomainList());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryData() {
        this.mSid = null;
        this.mSessionExpiredTime = 0L;
        this.mEcode = null;
        this.mNick = null;
        this.mUserName = null;
        this.mUserId = null;
        this.mLoginTime = 0L;
        this.mHeadPicLink = null;
        this.mOldSid = null;
        this.mOldNick = null;
        this.mOldUserId = null;
        this.mOldEncryptedUserId = null;
        this.mBiometricId = null;
        this.extJson = null;
        this.mEmail = null;
        this.mLoginSite = 0;
        this.mUidDigest = null;
        this.mLoginPhone = null;
        this.mDomainListStr = null;
        this.storage = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWebviewCookie(String[] strArr) {
        clearWebviewCookie(strArr, false);
    }

    private void doSidCheck(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.contains("%")) {
                return;
            }
            clearMemoryData();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized SessionManager getInstance(Context context) {
        SessionManager sessionManager;
        synchronized (SessionManager.class) {
            if (instance == null && context != null) {
                instance = new SessionManager(context);
            }
            sessionManager = instance;
        }
        return sessionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initChildProcessMemoryData(SessionParams sessionParams) {
        if (sessionParams != null) {
            this.mUserId = sessionParams.mUserId;
            this.mAutoLoginToken = sessionParams.mAutoLoginToken;
            this.mNick = sessionParams.mNick;
            this.mSid = sessionParams.mSid;
            LoginTLogAdapter.e(TAG, "initChildProcessMemoryData sid:" + this.mSid);
            this.mEcode = sessionParams.mEcode;
            this.mEmail = sessionParams.mEmail;
            this.mHavanaSsoTokenExpiredTime = sessionParams.mHavanaSsoTokenExpiredTime;
            this.mHeadPicLink = sessionParams.mHeadPicLink;
            this.mLoginPhone = sessionParams.mLoginPhone;
            this.mLoginSite = sessionParams.mLoginSite;
            this.mLoginTime = sessionParams.mLoginTime;
            this.mOldNick = sessionParams.mOldNick;
            this.mOldEncryptedUserId = sessionParams.mOldEncryptedUserId;
            this.mOldSid = sessionParams.mOldSid;
            this.mOldUserId = sessionParams.mOldUserId;
            this.mSessionDisastergrd = sessionParams.mSessionDisastergrd;
            this.mSessionExpiredTime = sessionParams.mSessionExpiredTime;
            this.mShowNick = sessionParams.mShowNick;
            this.mSubSid = sessionParams.mSubSid;
            this.mUidDigest = sessionParams.mUidDigest;
            this.mUserName = sessionParams.mUserName;
            this.mDomainListStr = sessionParams.domainList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMemoryData() {
        String sid = getSid();
        getSubSid();
        getEcode();
        getLoginToken();
        getNick();
        getSessionExpiredTime();
        getSsoToken();
        getUserId();
        getOldUserId();
        getUserName();
        isCommentTokenUsed();
        isNewSessionTag();
        getExtJson();
        getLoginSite();
        getUidDigest();
        getOneTimeToken();
        getHavanaSsoTokenExpiredTime();
        doSidCheck(sid);
    }

    private void initSecurityGuardManager() {
        if (securityGuardManager != null || this.mContext == null) {
            return;
        }
        synchronized (checkLock) {
            if (securityGuardManager == null) {
                securityGuardManager = SecurityGuardManager.getInstance(this.mContext.getApplicationContext());
            }
        }
    }

    private void initStorage() {
        Context context = this.mContext;
        if (context == null || this.storage != null) {
            return;
        }
        this.storage = context.getSharedPreferences(USERINFO, 4);
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    private void removeSingleCookie(String str, String str2) {
        LoginCookie loginCookie = new LoginCookie();
        loginCookie.name = str;
        loginCookie.domain = str2;
        loginCookie.path = "/";
        loginCookie.value = "";
        LoginCookieUtils.expiresCookies(loginCookie);
        try {
            CookieManager.getInstance().setCookie(LoginCookieUtils.getHttpDomin(loginCookie), loginCookie.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeUTCookie() {
        removeSingleCookie("unb", ".taobao.com");
    }

    private void removeWeitaoCookie() {
        removeSingleCookie("cookiej007", ".jaeapp.com");
        new LoginCookie();
    }

    private boolean sendBroadcast(String str) {
        Intent intent = new Intent(str);
        intent.putExtra("PROCESS_NAME", LoginThreadHelper.getCurProcessName(this.mContext));
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.sendBroadcast(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCustomTrack(String str, String str2, Map<String, String> map) {
        try {
            if (UTAnalytics.getInstance().isInit()) {
                UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
                uTCustomHitBuilder.setEventPage(str);
                if (map != null) {
                    uTCustomHitBuilder.setProperties(map);
                }
                UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
            }
        } catch (Throwable unused) {
        }
    }

    private void setCookie(String str, String str2) {
        try {
            CookieManager.getInstance().setCookie(str, str2);
            if (TextUtils.isEmpty(str2) || !str2.contains("cookie2")) {
                return;
            }
            LoginTLogAdapter.e(TAG, "setCookie cookie2:" + str2);
        } catch (Throwable unused) {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpIntent.COOKIE, str2);
            sendCustomTrack(UTConstant.PageName.UT_PAGE_EXTEND, "setCookieException", hashMap);
        }
    }

    private void setOldNick(String str) {
        LoginTLogAdapter.d(TAG, "set OldNick=" + str);
        this.mOldNick = str;
        saveStorage(SessionConstants.OLDNICK, str);
    }

    private void setOldSid(String str) {
        LoginTLogAdapter.d(TAG, "set OldSid=" + str);
        this.mOldSid = str;
        saveStorage(SessionConstants.OLDSID, encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void appendEventTrace(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LoginTLogAdapter.i(TAG, "logEventTrace : " + str);
        String str2 = getEventTrace() + str;
        int length = str2.length();
        if (length > 512) {
            try {
                if (str2.contains(jn1.BLOCK_START_STR) && str2.contains("}")) {
                    int indexOf = str2.indexOf(jn1.BLOCK_START_STR);
                    int indexOf2 = str2.indexOf("}");
                    if (indexOf < indexOf2) {
                        saveStorage(SessionConstants.EVENT_TRACE, str2.substring(indexOf2 + 1));
                        return;
                    } else {
                        saveStorage(SessionConstants.EVENT_TRACE, str2.substring(indexOf));
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            str2 = str2.substring(length - 512, length);
        }
        saveStorage(SessionConstants.EVENT_TRACE, str2);
    }

    public boolean checkHavanaExpired() {
        return System.currentTimeMillis() / 1000 > getHavanaSsoTokenExpiredTime();
    }

    @Override // com.taobao.login4android.session.ISession
    public boolean checkSessionValid() {
        return (TextUtils.isEmpty(getSid()) || System.currentTimeMillis() / 1000 >= getSessionExpiredTime() || TextUtils.isEmpty(getUserId())) ? false : true;
    }

    @Override // com.taobao.login4android.session.ISession
    public void clearAutoLoginInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", (Object) "clearAutoLoginInfo");
            appendEventTrace(JSON.toJSONString(jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginTLogAdapter.e(TAG, "Clear AutoLoginInfo");
        this.mAutoLoginToken = null;
        setLoginToken(null);
    }

    @Override // com.taobao.login4android.session.ISession
    public void clearCookieManager() {
        List<LoginCookie> list = this.mCookie;
        if (list == null || list.size() == 0) {
            this.mCookie = getCookies();
        }
        clearWebviewCookie(getSsoDomainList());
    }

    @Override // com.taobao.login4android.session.ISession
    public void clearSessionInfo() {
        clearSessionInfo(LoginSwitch.getSwitch(LoginSwitch.SGCOOKIE, "true"));
    }

    @Override // com.taobao.login4android.session.ISession
    public void clearSessionOnlyCookie() {
        LoginTLogAdapter.i(TAG, "start clearSessionOnlyCookie");
        try {
            if (isNeedCleanSessionCookie) {
                CookieSyncManager createInstance = CookieSyncManager.createInstance(this.mContext);
                CookieManager.getInstance().removeSessionCookie();
                CookieManager.getInstance().removeExpiredCookie();
                createInstance.sync();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String decrypt(String str) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            initSecurityGuardManager();
            SecurityGuardManager securityGuardManager2 = securityGuardManager;
            if (securityGuardManager2 == null || (dynamicDataEncryptComp = securityGuardManager2.getDynamicDataEncryptComp()) == null) {
                return "";
            }
            if (str.length() > 4 && str.charAt(3) == '&') {
                return dynamicDataEncryptComp.dynamicDecryptDDp(str);
            }
            return dynamicDataEncryptComp.dynamicDecrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String encode(String str) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            initSecurityGuardManager();
            SecurityGuardManager securityGuardManager2 = securityGuardManager;
            if (securityGuardManager2 != null && (dynamicDataEncryptComp = securityGuardManager2.getDynamicDataEncryptComp()) != null) {
                String dynamicEncryptDDp = dynamicDataEncryptComp.dynamicEncryptDDp(str);
                return TextUtils.isEmpty(dynamicEncryptDDp) ? str : dynamicEncryptDDp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getBiometricId() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mBiometricId)) {
            return this.mBiometricId;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mBiometricId) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.BIOMETRIC, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mBiometricId = decrypt(string);
        }
        return this.mBiometricId;
    }

    public String getByKey(String str) {
        initStorage();
        if (this.storage == null || !TextUtils.isEmpty(str)) {
            return "";
        }
        String string = this.storage.getString(str, "");
        return !TextUtils.isEmpty(string) ? decrypt(string) : "";
    }

    public List<LoginCookie> getCookies() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String readFileData = FileUtils.readFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW);
        if (readFileData != null && !readFileData.isEmpty()) {
            String decrypt = decrypt(readFileData);
            LoginTLogAdapter.i(TAG, "get cookie from storage:" + decrypt);
            try {
                copyOnWriteArrayList.addAll(JSON.parseArray(decrypt, LoginCookie.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return copyOnWriteArrayList;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getDisplayNick() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getDisplayNick");
        if (!TextUtils.isEmpty(this.mShowNick)) {
            return this.mShowNick;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mShowNick) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.SHOW_NICK, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mShowNick = string;
        }
        return this.mShowNick;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getEcode() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getEcode");
        if (!TextUtils.isEmpty(this.mEcode)) {
            return this.mEcode;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mEcode) && (sharedPreferences = this.storage) != null) {
            try {
                String string = sharedPreferences.getString("ecode", "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                this.mEcode = decrypt(string);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.mEcode;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getEmail() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mEmail)) {
            return this.mEmail;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mEmail) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString("email", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mEmail = decrypt(string);
        }
        return this.mEmail;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getEventTrace() {
        initStorage();
        SharedPreferences sharedPreferences = this.storage;
        String string = sharedPreferences != null ? sharedPreferences.getString(SessionConstants.EVENT_TRACE, "") : null;
        return string != null ? string : "";
    }

    @Override // com.taobao.login4android.session.ISession
    public String getExtJson() {
        SharedPreferences sharedPreferences;
        initStorage();
        if (TextUtils.isEmpty(this.extJson) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.EXT_JSON, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.extJson = decrypt(string);
        }
        return this.extJson;
    }

    @Override // com.taobao.login4android.session.ISession
    public long getHavanaSsoTokenExpiredTime() {
        SharedPreferences sharedPreferences;
        long j = this.mHavanaSsoTokenExpiredTime;
        if (j > 0) {
            return j;
        }
        initStorage();
        if (this.mHavanaSsoTokenExpiredTime <= 0 && (sharedPreferences = this.storage) != null) {
            this.mHavanaSsoTokenExpiredTime = sharedPreferences.getLong(SessionConstants.HAVANA_SSO_TOKEN_EXPIRE, 0L);
        }
        return this.mHavanaSsoTokenExpiredTime;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getHeadPicLink() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getHeadPicLink");
        if (!TextUtils.isEmpty(this.mHeadPicLink)) {
            return this.mHeadPicLink;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mHeadPicLink) && (sharedPreferences = this.storage) != null) {
            this.mHeadPicLink = sharedPreferences.getString(SessionConstants.HEAD_PIC_LINK, "");
        }
        return this.mHeadPicLink;
    }

    @Override // com.taobao.login4android.session.ISession
    public int getInjectCookieCount() {
        SharedPreferences sharedPreferences;
        initStorage();
        if (this.mInjectCookieCount == 0 && (sharedPreferences = this.storage) != null) {
            this.mInjectCookieCount = sharedPreferences.getInt(SessionConstants.INJECT_COOKIE_COUNT, 0);
        }
        return this.mInjectCookieCount;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getLoginPhone() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getLoginPhone");
        if (!TextUtils.isEmpty(this.mLoginPhone)) {
            return this.mLoginPhone;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mLoginPhone) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.LOGIN_PHONE, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mLoginPhone = decrypt(string);
        }
        return this.mLoginPhone;
    }

    @Override // com.taobao.login4android.session.ISession
    public int getLoginSite() {
        initStorage();
        int i = this.storage.getInt(SessionConstants.LOGIN_SITE, 0);
        this.mLoginSite = i;
        return i;
    }

    @Override // com.taobao.login4android.session.ISession
    public long getLoginTime() {
        SharedPreferences sharedPreferences;
        long j = this.mLoginTime;
        if (j > 0) {
            return j;
        }
        initStorage();
        if (this.mLoginTime == 0 && (sharedPreferences = this.storage) != null) {
            this.mLoginTime = sharedPreferences.getLong(SessionConstants.LOGIN_TIME, 0L);
        }
        return this.mLoginTime;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getLoginToken() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getLoginToken");
        if (!TextUtils.isEmpty(this.mAutoLoginToken)) {
            LoginTLogAdapter.e(TAG, "after_getLoginToken_cache");
            return this.mAutoLoginToken;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mAutoLoginToken) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.AUTO_LOGIN_STR, "");
            if (TextUtils.isEmpty(string)) {
                LoginTLogAdapter.e(TAG, "after_getLoginToken_empty");
                return null;
            }
            this.mAutoLoginToken = decrypt(string);
        }
        LoginTLogAdapter.e(TAG, "after_getLoginToken");
        return this.mAutoLoginToken;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getNick() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getNick");
        if (!TextUtils.isEmpty(this.mNick)) {
            return this.mNick;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mNick) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString("nick", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mNick = string;
        }
        return this.mNick;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getOldEncryptedUserId() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.e(TAG, "getOldEncryptedUserId");
        initStorage();
        if (TextUtils.isEmpty(this.mOldEncryptedUserId) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.OLD_ENCRYPTED_USERID, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mOldEncryptedUserId = decrypt(string);
        }
        LoginTLogAdapter.e(TAG, "after_getOldEncryptedUserId");
        return this.mOldEncryptedUserId;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getOldNick() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mOldNick)) {
            return this.mOldNick;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mOldNick) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.OLDNICK, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mOldNick = string;
        }
        return this.mOldNick;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getOldSid() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mOldSid)) {
            return this.mOldSid;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mOldSid) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.OLDSID, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mOldSid = decrypt(string);
        }
        return this.mOldSid;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getOldUserId() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getOldUserId");
        if (!TextUtils.isEmpty(this.mOldUserId)) {
            return this.mOldUserId;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mOldUserId) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.OLDUSERID, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mOldUserId = decrypt(string);
        }
        LoginTLogAdapter.i(TAG, "get old userId=" + this.mOldUserId);
        return this.mOldUserId;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getOneTimeToken() {
        initStorage();
        if (checkHavanaExpired() || this.storage == null) {
            return null;
        }
        try {
            initStorage();
            String string = this.storage.getString(SessionConstants.OneTimeTOKEN, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return decrypt(string);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public String getSessionDisastergrd() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mSessionDisastergrd)) {
            return this.mSessionDisastergrd;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mSessionDisastergrd) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.SESSION_DISASTERGRD, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mSessionDisastergrd = string;
        }
        LoginTLogAdapter.i(TAG, "get sessionDisastergrd=" + this.mSessionDisastergrd);
        return this.mSessionDisastergrd;
    }

    @Override // com.taobao.login4android.session.ISession
    public long getSessionExpiredTime() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getSessionExpiredTime");
        long j = this.mSessionExpiredTime;
        if (j > 0) {
            return j;
        }
        initStorage();
        if (this.mSessionExpiredTime <= 0 && (sharedPreferences = this.storage) != null) {
            this.mSessionExpiredTime = sharedPreferences.getLong(SessionConstants.SESSION_EXPIRED_TIME, 0L);
        }
        return this.mSessionExpiredTime;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getSid() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.e(TAG, "getSid");
        if (!TextUtils.isEmpty(this.mSid)) {
            LoginTLogAdapter.e(TAG, "after_getSid_cache");
            return this.mSid;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mSid) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString("sid", "");
            if (TextUtils.isEmpty(string)) {
                LoginTLogAdapter.e(TAG, "after_getSid_empty");
                return null;
            }
            this.mSid = decrypt(string);
        }
        LoginTLogAdapter.e(TAG, "after_getSid");
        return this.mSid;
    }

    public String[] getSsoDomainList() {
        try {
            if (!TextUtils.isEmpty(this.mDomainListStr)) {
                return (String[]) JSON.parseArray(this.mDomainListStr).toArray(new String[0]);
            }
            initStorage();
            SharedPreferences sharedPreferences = this.storage;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(SessionConstants.SSO_DOMAIN_LIST, "");
                this.mDomainListStr = string;
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return (String[]) JSON.parseArray(this.mDomainListStr).toArray(new String[0]);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public String getSsoToken() {
        initStorage();
        SharedPreferences sharedPreferences = this.storage;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("ssoToken", "");
            if (!TextUtils.isEmpty(string)) {
                return decrypt(string);
            }
        }
        return null;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getSubSid() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mSubSid)) {
            return this.mSubSid;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mSubSid) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.SUBSID, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mSubSid = decrypt(string);
        }
        return this.mSubSid;
    }

    @Override // com.taobao.login4android.session.ISession
    public SuccessTip getSuccessTip() {
        return this.mSuccessTip;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getUidDigest() {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(this.mUidDigest)) {
            return this.mUidDigest;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mUidDigest) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString(SessionConstants.SESSION_KEY, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mUidDigest = string;
        }
        return this.mUidDigest;
    }

    @Override // com.taobao.login4android.session.ISession
    public String getUserId() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getUserId");
        if (!TextUtils.isEmpty(this.mUserId)) {
            LoginTLogAdapter.e(TAG, "after_getUserId_cache");
            return this.mUserId;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mUserId) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                LoginTLogAdapter.e(TAG, "after_getUserId_empty");
                return null;
            }
            this.mUserId = decrypt(string);
        }
        try {
            Long.parseLong(this.mUserId);
            LoginTLogAdapter.e(TAG, "after_getUserId");
            return this.mUserId;
        } catch (Throwable th) {
            HashMap hashMap = new HashMap();
            hashMap.put("invalidUserId", String.valueOf(this.mUserId));
            sendCustomTrack(UTConstant.PageName.UT_PAGE_EXTEND, "userIdInvalid", hashMap);
            th.printStackTrace();
            LoginTLogAdapter.e(TAG, "UserIdParseError");
            clearSessionInfo();
            return null;
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public String getUserName() {
        SharedPreferences sharedPreferences;
        LoginTLogAdapter.d(TAG, "getUserName");
        if (!TextUtils.isEmpty(this.mUserName)) {
            return this.mUserName;
        }
        initStorage();
        if (TextUtils.isEmpty(this.mUserName) && (sharedPreferences = this.storage) != null) {
            String string = sharedPreferences.getString("username", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            this.mUserName = string;
        }
        return this.mUserName;
    }

    @Override // com.taobao.login4android.session.ISession
    public synchronized void injectCookie(String[] strArr, String[] strArr2) {
        injectCookie(strArr, strArr2, false);
    }

    @Override // com.taobao.login4android.session.ISession
    public synchronized void injectExternalCookies(String[] strArr) {
        injectExternalCookies(strArr, false);
    }

    @Override // com.taobao.login4android.session.ISession
    public boolean isCommentTokenUsed() {
        SharedPreferences sharedPreferences;
        initStorage();
        if (!this.mIsCommentUsed && (sharedPreferences = this.storage) != null) {
            this.mIsCommentUsed = sharedPreferences.getBoolean(SessionConstants.COMMENT_TOKEN_USED, false);
        }
        return this.mIsCommentUsed;
    }

    public boolean isNewSessionTag() {
        SharedPreferences sharedPreferences;
        boolean z = this.mNewSessionTag;
        if (z) {
            return z;
        }
        initStorage();
        if (!this.mNewSessionTag && (sharedPreferences = this.storage) != null) {
            this.mNewSessionTag = sharedPreferences.getBoolean(NEW_SESSION_TAG, false);
        }
        return this.mNewSessionTag;
    }

    @Override // com.taobao.login4android.session.ISession
    public void onLoginSuccess(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j, String[] strArr, String[] strArr2, String[] strArr3, long j2, long j3, String str9) {
        initStorage();
        LoginTLogAdapter.e(TAG, "onLoginSuccess");
        sendCustomTrack(UTConstant.PageName.UT_PAGE_EXTEND, "session_start_store", null);
        SharedPreferences sharedPreferences = this.storage;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (!TextUtils.isEmpty(str5) || !TextUtils.equals(getOldNick(), str3)) {
                this.mHeadPicLink = str5;
                edit.putString(SessionConstants.HEAD_PIC_LINK, str5);
            }
            if (isDebug()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("sdk onLoginSuccess, saveSession. sid=");
                stringBuffer.append(str);
                stringBuffer.append(", nick=");
                stringBuffer.append(str3);
                stringBuffer.append(", userId=");
                stringBuffer.append(str4);
                stringBuffer.append(", autologintoken:");
                stringBuffer.append(!TextUtils.isEmpty(str6));
                stringBuffer.append(", ssotoken:");
                stringBuffer.append(!TextUtils.isEmpty(str7));
                stringBuffer.append(", expiresTime=");
                stringBuffer.append(j2);
                LoginTLogAdapter.d(TAG, stringBuffer.toString());
            }
            this.mSid = str;
            edit.putString("sid", encode(str));
            this.mOldSid = str;
            edit.putString(SessionConstants.OLDSID, encode(str));
            this.mSessionExpiredTime = j2;
            edit.putLong(SessionConstants.SESSION_EXPIRED_TIME, j2);
            this.mEcode = str2;
            edit.putString("ecode", encode(str2));
            this.mUserId = str4;
            edit.putString("userId", encode(str4));
            this.mOldUserId = str4;
            edit.putString(SessionConstants.OLDUSERID, encode(str4));
            this.mNick = str3;
            edit.putString("nick", str3);
            this.mOldNick = str3;
            edit.putString(SessionConstants.OLDNICK, str3);
            this.mUserName = str3;
            edit.putString("username", str3);
            this.mLoginTime = j3;
            edit.putLong(SessionConstants.LOGIN_TIME, j3);
            this.mLoginPhone = str9;
            edit.putString(SessionConstants.LOGIN_PHONE, encode(str9));
            try {
                if (!TextUtils.isEmpty(str6)) {
                    this.mAutoLoginToken = str6;
                    edit.putString(SessionConstants.AUTO_LOGIN_STR, encode(str6));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            edit.putString("ssoToken", encode(str7));
            if (!TextUtils.isEmpty(str8)) {
                edit.putString(SessionConstants.OneTimeTOKEN, encode(str8));
            }
            if (j == 0) {
                this.mHavanaSsoTokenExpiredTime = (System.currentTimeMillis() / 1000) + 900;
            } else {
                this.mHavanaSsoTokenExpiredTime = (System.currentTimeMillis() / 1000) + j;
            }
            edit.putLong(SessionConstants.HAVANA_SSO_TOKEN_EXPIRE, this.mHavanaSsoTokenExpiredTime);
            edit.putString(SessionConstants.EVENT_TRACE, "");
            edit.commit();
        }
        if (this.mCookie != null) {
            LoginTLogAdapter.e(TAG, "clear mCookie list");
            this.mCookie.clear();
        }
        LoginTLogAdapter.e(TAG, "start inject cookie");
        injectExternalCookies(strArr, true);
        try {
            injectCookie(strArr2, strArr3);
        } catch (Throwable unused) {
        }
        try {
            SessionParams sessionParams = new SessionParams();
            sessionParams.mAutoLoginToken = this.mAutoLoginToken;
            sessionParams.mEcode = this.mEcode;
            sessionParams.mEmail = this.mEmail;
            sessionParams.mHavanaSsoTokenExpiredTime = this.mHavanaSsoTokenExpiredTime;
            sessionParams.mHeadPicLink = this.mHeadPicLink;
            sessionParams.mLoginPhone = this.mLoginPhone;
            sessionParams.mLoginSite = this.mLoginSite;
            sessionParams.mLoginTime = this.mLoginTime;
            sessionParams.mNick = this.mNick;
            sessionParams.mOldNick = this.mOldNick;
            sessionParams.mOldEncryptedUserId = this.mOldEncryptedUserId;
            sessionParams.mOldSid = this.mOldSid;
            sessionParams.mOldUserId = this.mOldUserId;
            sessionParams.mSessionDisastergrd = this.mSessionDisastergrd;
            sessionParams.mSessionExpiredTime = this.mSessionExpiredTime;
            sessionParams.mShowNick = this.mShowNick;
            sessionParams.mSid = this.mSid;
            sessionParams.mSubSid = this.mSubSid;
            sessionParams.mUidDigest = this.mUidDigest;
            sessionParams.mUserId = this.mUserId;
            sessionParams.mUserName = this.mUserName;
            if (strArr3 != null && strArr3.length > 0) {
                sessionParams.domainList = JSON.toJSONString(strArr3);
            }
            Intent intent = new Intent(CLEAR_SESSION_ACTION);
            intent.putExtra(Preloader.KEY_SESSION, JSON.toJSONString(sessionParams));
            intent.putExtra("PROCESS_NAME", LoginThreadHelper.getCurProcessName(this.mContext));
            intent.setPackage(this.mContext.getPackageName());
            this.mContext.sendBroadcast(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean oneTimeTokenExpired() {
        return System.currentTimeMillis() - this.mLoginTime <= 900;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    @Override // com.taobao.login4android.session.ISession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean recoverCookie() {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.login4android.session.SessionManager.recoverCookie():boolean");
    }

    @SuppressLint({"NewApi"})
    public void removeStorage(String str) {
        try {
            initStorage();
            SharedPreferences sharedPreferences = this.storage;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(str);
                edit.apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public void saveStorage(String str, String str2) {
        try {
            initStorage();
            SharedPreferences sharedPreferences = this.storage;
            if (sharedPreferences != null) {
                if (str2 == null) {
                    removeStorage(str);
                } else {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(str, str2);
                    edit.apply();
                }
                if (this.mNewSessionTag) {
                    return;
                }
                setNewSessionTag(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public boolean sendClearSessionBroadcast() {
        return sendBroadcast(CLEAR_SESSION_ACTION);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setCommentTokenUsed(boolean z) {
        this.mIsCommentUsed = z;
        initStorage();
        SharedPreferences sharedPreferences = this.storage;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(SessionConstants.COMMENT_TOKEN_USED, z);
            edit.apply();
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public void setDisplayNick(String str) {
        LoginTLogAdapter.d(TAG, "set mShowNick=" + str);
        this.mShowNick = str;
        saveStorage(SessionConstants.SHOW_NICK, str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setEcode(String str) {
        this.mEcode = str;
        saveStorage("ecode", encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setEmail(String str) {
        this.mEmail = str;
        saveStorage("email", encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setExtJson(String str) {
        this.extJson = str;
        saveStorage(SessionConstants.EXT_JSON, encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setHavanaSsoTokenExpiredTime(long j) {
        this.mHavanaSsoTokenExpiredTime = j;
        saveStorage(SessionConstants.HAVANA_SSO_TOKEN_EXPIRE, j);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setHeadPicLink(String str) {
        this.mHeadPicLink = str;
        saveStorage(SessionConstants.HEAD_PIC_LINK, str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setInjectCookieCount(int i) {
        LoginTLogAdapter.d(TAG, "set session count = " + i);
        this.mInjectCookieCount = i;
        saveStorage(SessionConstants.INJECT_COOKIE_COUNT, i);
    }

    public void setLoginPhone(String str) {
        this.mLoginPhone = str;
        saveStorage(SessionConstants.LOGIN_PHONE, str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setLoginSite(int i) {
        this.mLoginSite = i;
        saveStorage(SessionConstants.LOGIN_SITE, i);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setLoginTime(long j) {
        this.mLoginTime = j;
        saveStorage(SessionConstants.LOGIN_TIME, j);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setLoginToken(String str) {
        saveStorage(SessionConstants.AUTO_LOGIN_STR, encode(str));
    }

    public void setNewSessionTag(boolean z) {
        this.mNewSessionTag = z;
        initStorage();
        SharedPreferences sharedPreferences = this.storage;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(NEW_SESSION_TAG, z);
            edit.apply();
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public void setNick(String str) {
        LoginTLogAdapter.d(TAG, "set nick=" + str);
        this.mNick = str;
        saveStorage("nick", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setOldNick(str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setOldEncryptedUserId(String str) {
        this.mOldEncryptedUserId = str;
        saveStorage(SessionConstants.OLD_ENCRYPTED_USERID, encode(str));
    }

    public void setOldUserId(String str) {
        LoginTLogAdapter.d(TAG, "setOldUserId=" + str);
        this.mOldUserId = str;
        saveStorage(SessionConstants.OLDUSERID, encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setOneTimeToken(String str) {
        saveStorage(SessionConstants.OneTimeTOKEN, encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setSessionDisastergrd(String str) {
        this.mSessionDisastergrd = str;
        saveStorage(SessionConstants.SESSION_DISASTERGRD, str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setSessionExpiredTime(long j) {
        LoginTLogAdapter.d(TAG, "set sessionExpiredTime=" + j);
        this.mSessionExpiredTime = j;
        saveStorage(SessionConstants.SESSION_EXPIRED_TIME, j);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setSid(String str) {
        LoginTLogAdapter.d(TAG, "set sid=" + str);
        this.mSid = str;
        saveStorage("sid", encode(str));
        setOldSid(str);
    }

    public void setSsoDomainList(String[] strArr) {
        saveStorage(SessionConstants.SSO_DOMAIN_LIST, strArr != null ? JSON.toJSONString(strArr) : "");
    }

    @Override // com.taobao.login4android.session.ISession
    public void setSsoToken(String str) {
        saveStorage("ssoToken", encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setSubSid(String str) {
        LoginTLogAdapter.d(TAG, "set sub sid=" + str);
        this.mSubSid = str;
        saveStorage(SessionConstants.SUBSID, encode(str));
    }

    @Override // com.taobao.login4android.session.ISession
    public void setSuccessTip(SuccessTip successTip) {
        this.mSuccessTip = successTip;
    }

    @Override // com.taobao.login4android.session.ISession
    public void setUidDigest(String str) {
        this.mUidDigest = str;
        saveStorage(SessionConstants.SESSION_KEY, str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setUserId(String str) {
        LoginTLogAdapter.d(TAG, "set userId=" + str);
        this.mUserId = str;
        saveStorage("userId", encode(str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setOldUserId(str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setUserName(String str) {
        LoginTLogAdapter.d(TAG, "set userName=" + str);
        this.mUserName = str;
        saveStorage("username", str);
    }

    @Override // com.taobao.login4android.session.ISession
    public void setWriteUT(boolean z) {
        this.canWriteUT = z;
    }

    public void setbiometricId(String str) {
        this.mBiometricId = str;
        saveStorage(SessionConstants.BIOMETRIC, encode(str));
    }

    private void clearWebviewCookie(String[] strArr, boolean z) {
        ArrayList<LoginCookie> arrayList = new ArrayList();
        List<LoginCookie> list = this.mCookie;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.mCookie.size(); i++) {
            LoginCookie loginCookie = this.mCookie.get(i);
            if (loginCookie != null && !TextUtils.isEmpty(loginCookie.domain) && (!z || !LoginSwitch.SGCOOKIE.equals(loginCookie.name))) {
                String httpDomin = LoginCookieUtils.getHttpDomin(loginCookie);
                LoginCookieUtils.expiresCookies(loginCookie);
                setCookie(httpDomin, loginCookie.toString());
                if (TextUtils.equals(loginCookie.domain, ".taobao.com")) {
                    arrayList.add(loginCookie);
                }
            }
        }
        if (strArr == null) {
            strArr = getSsoDomainList();
        }
        if (strArr != null && strArr.length > 0 && !arrayList.isEmpty()) {
            for (LoginCookie loginCookie2 : arrayList) {
                if (loginCookie2 != null) {
                    String str = loginCookie2.domain;
                    for (String str2 : strArr) {
                        loginCookie2.domain = str2;
                        String httpDomin2 = LoginCookieUtils.getHttpDomin(loginCookie2);
                        LoginCookieUtils.expiresCookies(loginCookie2);
                        setCookie(httpDomin2, loginCookie2.toString());
                    }
                    loginCookie2.domain = str;
                }
            }
        }
        removeUTCookie();
        removeWeitaoCookie();
        List<LoginCookie> list2 = this.mCookie;
        if (list2 != null) {
            list2.clear();
        }
    }

    public void clearSessionInfo(boolean z) {
        LoginTLogAdapter.e(TAG, "Clear sessionInfo");
        sendCustomTrack(UTConstant.PageName.UT_PAGE_EXTEND, "session_clear", null);
        setSid(null);
        setSubSid(null);
        removeStorage(SessionConstants.SESSION_EXPIRED_TIME);
        setEcode(null);
        setNick(null);
        setUserId(null);
        setUserName(null);
        setHeadPicLink(null);
        setExtJson(null);
        setEmail(null);
        setOneTimeToken(null);
        setLoginPhone(null);
        removeStorage(SessionConstants.LOGIN_SITE);
        try {
            injectCookie(null, null, false, z);
            LoginTLogAdapter.e(TAG, "send CLEAR_SESSION_COOKIES_ACTION");
            Intent intent = new Intent(CLEAR_SESSION_COOKIES_ACTION);
            intent.putExtra("PROCESS_NAME", LoginThreadHelper.getCurProcessName(this.mContext));
            intent.setPackage(this.mContext.getPackageName());
            this.mContext.sendBroadcast(intent);
        } catch (Exception unused) {
            removeUTCookie();
            removeWeitaoCookie();
            List<LoginCookie> list = this.mCookie;
            if (list != null) {
                list.clear();
            }
            FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW, "");
        }
        if (this.canWriteUT) {
            try {
                UTAnalytics.getInstance().updateUserAccount("", "", "");
            } catch (Throwable unused2) {
                UTAnalytics.getInstance().updateUserAccount("", "");
            }
        }
    }

    @Override // com.taobao.login4android.session.ISession
    public synchronized void injectCookie(String[] strArr, String[] strArr2, boolean z) {
        injectCookie(strArr, strArr2, z, false);
    }

    public synchronized void injectExternalCookies(String[] strArr, boolean z) {
        LoginCookie parseCookie;
        boolean z2;
        if (this.mContext != null && strArr != null) {
            List<LoginCookie> list = this.mCookie;
            if (list != null && list.size() == 0 && !z) {
                this.mCookie = getCookies();
            } else if (this.mCookie == null) {
                this.mCookie = new CopyOnWriteArrayList();
            }
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (parseCookie = LoginCookieUtils.parseCookie(str)) != null) {
                    String httpDomin = LoginCookieUtils.getHttpDomin(parseCookie);
                    String loginCookie = parseCookie.toString();
                    LoginTLogAdapter.i(TAG, "add external cookie: " + loginCookie);
                    setCookie(httpDomin, loginCookie);
                    List<LoginCookie> list2 = this.mCookie;
                    if (list2 != null) {
                        Iterator<LoginCookie> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            LoginCookie next = it.next();
                            if (next != null && TextUtils.equals(next.domain, parseCookie.domain) && TextUtils.equals(next.name, parseCookie.name)) {
                                next.value = parseCookie.value;
                                next.expires = parseCookie.expires;
                                z2 = true;
                                break;
                            }
                        }
                        if (!z2) {
                            this.mCookie.add(parseCookie);
                        }
                    }
                }
            }
            List<LoginCookie> list3 = this.mCookie;
            if (list3 != null && !list3.isEmpty() && !z) {
                FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW, encode(JSON.toJSONString(this.mCookie)));
            }
        }
    }

    private SessionManager(Context context) {
        if (context != null) {
            this.mContext = context;
            new AnonymousClass1("login-session-init").start();
        }
    }

    public synchronized void injectCookie(String[] strArr, String[] strArr2, boolean z, boolean z2) {
        LoginCookie parseCookie;
        String[] strArr3 = strArr2;
        synchronized (this) {
            if (this.mContext != null) {
                LoginTLogAdapter.e(TAG, "injectCookie start cookies:" + strArr + " ssoDomainList:" + strArr3 + " isExternalH5Cookies:" + z + " keepSgCookie:" + z2);
                LoginCookie loginCookie = null;
                if (strArr != null) {
                    sendCustomTrack(UTConstant.PageName.UT_PAGE_EXTEND, "session_load_cookie", null);
                    LoginTLogAdapter.e(TAG, "injectCookie cookies  size=" + strArr.length);
                    ArrayList<LoginCookie> arrayList = new ArrayList();
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (parseCookie = LoginCookieUtils.parseCookie(str)) != null) {
                            String httpDomin = LoginCookieUtils.getHttpDomin(parseCookie);
                            String loginCookie2 = parseCookie.toString();
                            LoginTLogAdapter.w(TAG, "add cookie: " + loginCookie2);
                            setCookie(httpDomin, loginCookie2);
                            if (TextUtils.equals(parseCookie.domain, ".taobao.com")) {
                                arrayList.add(parseCookie);
                            }
                            List<LoginCookie> list = this.mCookie;
                            if (list != null) {
                                list.add(parseCookie);
                            }
                        }
                    }
                    if (strArr3 == null) {
                        strArr3 = getSsoDomainList();
                    }
                    if (strArr3 != null && strArr3.length > 0 && !arrayList.isEmpty()) {
                        for (LoginCookie loginCookie3 : arrayList) {
                            if (loginCookie3 != null) {
                                String str2 = loginCookie3.domain;
                                for (String str3 : strArr3) {
                                    loginCookie3.domain = str3;
                                    String httpDomin2 = LoginCookieUtils.getHttpDomin(loginCookie3);
                                    String loginCookie4 = loginCookie3.toString();
                                    LoginTLogAdapter.d(TAG, "add cookies to domain:" + str3 + ", cookie = " + loginCookie4);
                                    setCookie(httpDomin2, loginCookie4);
                                }
                                loginCookie3.domain = str2;
                            }
                        }
                    }
                    setSsoDomainList(strArr3);
                    if (Build.VERSION.SDK_INT >= 21) {
                        CookieManager.getInstance().flush();
                    } else {
                        CookieSyncManager.createInstance(this.mContext).sync();
                    }
                    List<LoginCookie> list2 = this.mCookie;
                    if (list2 != null && !list2.isEmpty()) {
                        if (z) {
                            FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_External_H5_COOKIE, encode(JSON.toJSONString(this.mCookie)));
                        } else {
                            FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW, encode(JSON.toJSONString(this.mCookie)));
                            FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_OLD, "");
                        }
                    }
                } else {
                    this.mCookie = getCookies();
                    LoginTLogAdapter.e(TAG, "injectCookie cookies  is null getCookies:" + this.mCookie);
                    List<LoginCookie> list3 = this.mCookie;
                    if (list3 != null && !list3.isEmpty()) {
                        Iterator<LoginCookie> it = this.mCookie.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            LoginCookie next = it.next();
                            if (LoginSwitch.SGCOOKIE.equals(next.name)) {
                                loginCookie = next;
                                break;
                            }
                        }
                        if (z2 && loginCookie != null) {
                            new CopyOnWriteArrayList().add(loginCookie);
                            clearWebviewCookie(strArr3, z2);
                            FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW, encode(JSON.toJSONString(this.mCookie)));
                        } else {
                            clearWebviewCookie(strArr3);
                            FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW, "");
                        }
                        FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_OLD, FileUtils.readFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW));
                        FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_COOKIE_NEW, "");
                        FileUtils.writeFileData(this.mContext, SessionConstants.INJECT_External_H5_COOKIE, "");
                    }
                    if (isNeedCleanSessionCookie) {
                        CookieManager.getInstance().removeSessionCookie();
                    }
                    CookieManager.getInstance().removeExpiredCookie();
                    if (Build.VERSION.SDK_INT >= 21) {
                        CookieManager.getInstance().flush();
                    } else {
                        CookieSyncManager.createInstance(this.mContext).sync();
                    }
                }
                LoginTLogAdapter.e(TAG, "injectCookie end cookies:" + strArr + " ssoDomainList:" + strArr3 + " isExternalH5Cookies:" + z + " keepSgCookie:" + z2);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void saveStorage(String str, long j) {
        try {
            initStorage();
            SharedPreferences sharedPreferences = this.storage;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str, j);
                edit.apply();
                if (this.mNewSessionTag) {
                    return;
                }
                setNewSessionTag(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public void saveStorage(String str, int i) {
        try {
            initStorage();
            SharedPreferences sharedPreferences = this.storage;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(str, i);
                edit.apply();
                if (this.mNewSessionTag) {
                    return;
                }
                setNewSessionTag(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
