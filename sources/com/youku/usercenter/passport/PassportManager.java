package com.youku.usercenter.passport;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.open.core.broadcast.LoginAction;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.passport.libs.LoginArgument;
import com.youku.passport.result.AbsResult;
import com.youku.usercenter.passport.callback.ICallback;
import com.youku.usercenter.passport.listener.IAuthorizeListener;
import com.youku.usercenter.passport.orange.OrangeManager;
import com.youku.usercenter.passport.result.Result;
import com.youku.usercenter.passport.result.UserInfo;
import com.youku.usercenter.passport.statistics.PassportAppMonitor;
import com.youku.usercenter.passport.task.ConfigTask;
import com.youku.usercenter.passport.task.HYTask;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.usercenter.passport.util.Logger;
import com.youku.usercenter.passport.util.MiscUtil;
import com.youku.usercenter.passport.util.SysUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PassportManager implements IPassport {
    public static final String TAG = "YKLogin.PassportManager";
    private static PassportManager sInstance;
    @NonNull
    private Account mAccount;
    private IAuthorizeListener mAuthorizeListener;
    private Context mContext;
    private PassportConfig mPassportConfig;
    private PassportService mPassportService;
    private RefreshTask mRefreshTask;
    private long mServerSyncTime;
    private long mServerTime;
    private volatile boolean mIsInit = false;
    private ArrayList<ICallback<Result>> mInitCallbacks = new ArrayList<>();
    private final Object mInitLock = new Object();

    /* compiled from: Taobao */
    /* renamed from: com.youku.usercenter.passport.PassportManager$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus;

        static {
            int[] iArr = new int[AuthorizeStatus.values().length];
            $SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus = iArr;
            try {
                iArr[AuthorizeStatus.REGISTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus[AuthorizeStatus.USER_LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus[AuthorizeStatus.USER_LOGOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus[AuthorizeStatus.EXPIRE_LOGOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus[AuthorizeStatus.LOGIN_CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum AuthorizeStatus {
        REGISTER,
        USER_LOGIN,
        USER_LOGOUT,
        EXPIRE_LOGOUT,
        LOGIN_CANCEL
    }

    private PassportManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncInit() {
        synchronized (this.mInitLock) {
            if (this.mIsInit) {
                return;
            }
            AdapterForTLog.loge(TAG, "Passport asyncInit start!");
            PassportPreference passportPreference = PassportPreference.getInstance(this.mContext);
            this.mAccount = Account.load(this.mContext);
            this.mRefreshTask = new RefreshTask(this.mContext);
            this.mPassportService = new PassportService(this.mContext, this.mPassportConfig);
            this.mServerTime = passportPreference.getServerTime();
            this.mServerSyncTime = passportPreference.getServerSyncTime();
            boolean mtopSwitchServer = passportPreference.getMtopSwitchServer();
            if (this.mServerTime < 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mServerTime = currentTimeMillis;
                this.mServerSyncTime = currentTimeMillis;
            }
            this.mPassportConfig.setUseMtopServer(mtopSwitchServer);
            this.mIsInit = true;
            AdapterForTLog.loge(TAG, "Passport core init finish!");
            postInit();
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.youku.usercenter.passport.PassportManager.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (PassportManager.class) {
                        Result result = new Result();
                        result.setResultCode(0);
                        String runningInfo = SysUtil.getRunningInfo();
                        AdapterForTLog.loge(PassportManager.TAG, runningInfo + " begin to delivery result");
                        if (PassportManager.this.mInitCallbacks != null) {
                            Iterator it = PassportManager.this.mInitCallbacks.iterator();
                            while (it.hasNext()) {
                                ICallback iCallback = (ICallback) it.next();
                                Logger.d(PassportManager.TAG, runningInfo + " delivery initiated result " + iCallback);
                                if (iCallback != null) {
                                    iCallback.onSuccess(result);
                                }
                            }
                            PassportManager.this.mInitCallbacks.clear();
                        }
                    }
                }
            });
            AdapterForTLog.loge(TAG, "Passport init finish! login = " + this.mAccount.isLogin() + " ytid is empty:" + TextUtils.isEmpty(this.mAccount.mYtid));
            AdapterForTLog.loge(TAG, "SystemTime = " + System.currentTimeMillis() + " ServerSyncTime = " + this.mServerSyncTime + " mServerTime = " + this.mServerTime);
            Logger.d("asyncInit complete!");
        }
    }

    private void checkInit() {
        if (this.mPassportConfig != null) {
            if (this.mIsInit) {
                return;
            }
            asyncInit();
            return;
        }
        throw new IllegalStateException(PassportManager.class.getName() + " have not been initialized!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUtdidChange() {
        String deviceId = SysUtil.getDeviceId(this.mContext);
        String lastUtdid = PassportPreference.getInstance(this.mContext).getLastUtdid();
        if (TextUtils.isEmpty(lastUtdid)) {
            PassportPreference.getInstance(this.mContext).setLastUtdid(deviceId);
        } else if (TextUtils.equals(deviceId, lastUtdid)) {
        } else {
            AdapterForTLog.loge(TAG, "Utdid changed! currentUtdid = " + deviceId + " lastUtdid = " + lastUtdid);
            if (this.mAccount.isLogin()) {
                PassportAppMonitor.commitUtdidChange("login");
            } else {
                PassportAppMonitor.commitUtdidChange("logout");
            }
            PassportPreference.getInstance(this.mContext).setLastUtdid(deviceId);
        }
    }

    public static PassportManager getInstance() {
        if (sInstance == null) {
            synchronized (PassportManager.class) {
                if (sInstance == null) {
                    sInstance = new PassportManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTaobaoLogin() {
        MiscUtil.setUccEnv();
    }

    @SuppressLint({"StaticFieldLeak"})
    private void postInit() {
        this.mAccount.refreshSToken();
        new HYTask(null) { // from class: com.youku.usercenter.passport.PassportManager.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(String... strArr) {
                PassportManager.this.initTaobaoLogin();
                PassportManager.this.onAppForeground(false);
                PassportManager.this.startRefreshTask();
                PassportManager.this.checkUtdidChange();
                CookieUtil.markSDK(PassportManager.this.mContext, PassportManager.this.mPassportConfig.mAppId, PassportManager.this.mPassportConfig.mDebug);
                if (PassportManager.this.mPassportConfig.isUseOrange()) {
                    OrangeManager.init();
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new ConfigTask(PassportManager.this.mContext), PassportManager.this.mPassportConfig.mDebug ? 3000L : DateUtils.MILLIS_PER_MINUTE + (new Random().nextInt(60) * 1000));
                }
                PassportManager.this.registerReceiver();
                MiscUtil.getSecurityUMID(PassportManager.this.mContext);
                return null;
            }
        }.start(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction(LoginAction.NOTIFY_SNS_UNBIND.name());
            this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.youku.usercenter.passport.PassportManager.4
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(LoginAction.NOTIFY_SNS_UNBIND.name(), intent.getAction())) {
                        if ("youku".equals(intent.getStringExtra(LoginArgument.EXT_TL_SITE)) && PassportManager.this.isLogin()) {
                            PassportManager.getInstance().logout("ucc_unbind_youku");
                        }
                    } else if (PassportManager.this.isLogin()) {
                        AdapterForTLog.loge(PassportManager.TAG, "refresh sToken from ACTION_SCREEN_ON");
                        PassportManager.this.mAccount.refreshSToken();
                    }
                }
            }, intentFilter);
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
    }

    public Account getAccount() {
        return this.mAccount;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public PassportConfig getConfig() {
        checkInit();
        return this.mPassportConfig;
    }

    public Context getContext() {
        checkInit();
        return this.mContext;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public String getCookie() {
        checkInit();
        return this.mAccount.getCookie();
    }

    @Override // com.youku.usercenter.passport.IPassport
    public String getLastLoginType() {
        checkInit();
        return PassportPreference.getInstance(this.mContext).getLoginType();
    }

    public String getMaskMobile() {
        checkInit();
        return this.mAccount.mMaskMobile;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public String getSToken() {
        checkInit();
        return this.mAccount.getSToken();
    }

    public PassportService getService() {
        checkInit();
        return this.mPassportService;
    }

    public synchronized long getTimestamp() {
        checkInit();
        return (System.currentTimeMillis() - this.mServerSyncTime) + this.mServerTime;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public UserInfo getUserInfo() {
        checkInit();
        return this.mAccount.toUserInfo();
    }

    @Override // com.youku.usercenter.passport.IPassport
    public String getYktk() {
        checkInit();
        return this.mAccount.mYktk;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public void h5ToNativeLogin(com.youku.usercenter.passport.remote.ICallback iCallback) {
        checkInit();
        this.mPassportService.h5ToNativeLogin(iCallback);
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean handleCookieError(int i, long j) {
        checkInit();
        return this.mPassportService.handleCookieError(i, j);
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean handleSchema(Uri uri) {
        checkInit();
        return false;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public synchronized void init(PassportConfig passportConfig) {
        if (passportConfig != null) {
            if (this.mPassportConfig == null) {
                AdapterForTLog.loge(TAG, SysUtil.getRunningInfo() + " 3) Start initiating...");
                Logger.setDebug(passportConfig.mDebug);
                Context applicationContext = passportConfig.mContext.getApplicationContext();
                this.mContext = applicationContext;
                String packageName = applicationContext.getPackageName();
                String processName = SysUtil.getProcessName(this.mContext);
                if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(processName) && !TextUtils.equals(packageName, processName)) {
                    AdapterForTLog.loge(TAG, "Passport init in other process! process = " + processName);
                    throw new RuntimeException("For data consistence, only allow sdk in main process. If login status and token are needed in other process, use IPC like aidl");
                }
                this.mPassportConfig = passportConfig;
                this.mAuthorizeListener = passportConfig.mListener;
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.youku.usercenter.passport.PassportManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PassportManager.this.asyncInit();
                    }
                });
            }
        } else {
            throw new IllegalArgumentException(PassportManager.class.getSimpleName() + " initialized failed: PassportConfig can't be null");
        }
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean isBoundMobile() {
        checkInit();
        return this.mAccount.mBoundMobile;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean isFingerprintAuthEnabled() {
        checkInit();
        return false;
    }

    public boolean isInit() {
        return this.mIsInit;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean isLogin() {
        checkInit();
        return this.mAccount.isLogin();
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean isLogining() {
        return false;
    }

    @Override // com.youku.usercenter.passport.IPassport
    public void logout() {
        checkInit();
        this.mPassportService.logout(null);
    }

    public void onAppForeground(boolean z) {
        if (this.mPassportConfig == null) {
            return;
        }
        this.mPassportService.onAppForeground(z);
    }

    @Override // com.youku.usercenter.passport.IPassport
    public void refreshSToken() {
        checkInit();
        this.mAccount.refreshSToken();
    }

    @Override // com.youku.usercenter.passport.IPassport
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        checkInit();
        return this.mPassportService.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRefreshTask() {
        if (this.mRefreshTask == null || !isLogin() || TextUtils.isEmpty(getAccount().mPToken)) {
            return;
        }
        this.mRefreshTask.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRefreshTask() {
        RefreshTask refreshTask = this.mRefreshTask;
        if (refreshTask != null) {
            refreshTask.stop();
        }
    }

    @Override // com.youku.usercenter.passport.IPassport
    public void uccTrustLogin(String str, Map map, ICallback<AbsResult> iCallback) {
        checkInit();
        this.mPassportService.uccTrustLogin(str, map, iCallback);
    }

    public void updateAuthorizeStatus(AuthorizeStatus authorizeStatus) {
        try {
            if (this.mAuthorizeListener != null) {
                int i = AnonymousClass5.$SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus[authorizeStatus.ordinal()];
                if (i == 1 || i == 2) {
                    this.mAuthorizeListener.onUserLogin();
                } else if (i == 3) {
                    this.mAuthorizeListener.onUserLogout();
                } else if (i == 4) {
                    this.mAuthorizeListener.onExpireLogout();
                }
            }
            int i2 = AnonymousClass5.$SwitchMap$com$youku$usercenter$passport$PassportManager$AuthorizeStatus[authorizeStatus.ordinal()];
            if (i2 == 1 || i2 == 2) {
                CookieUtil.checkMarkSDK(this.mContext);
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new Intent(IPassport.ACTION_USER_LOGIN));
            } else if (i2 == 3) {
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new Intent(IPassport.ACTION_USER_LOOUT));
            } else if (i2 == 4) {
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new Intent(IPassport.ACTION_EXPIRE_LOGOUT));
            } else if (i2 == 5) {
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new Intent(IPassport.ACTION_LOGIN_CANCEL));
            }
            Logger.d("updateAuthorizeStatus " + authorizeStatus.toString());
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateSyncTime(long j) {
        Logger.d("updateSyncTime!");
        this.mServerTime = j;
        this.mServerSyncTime = System.currentTimeMillis();
        PassportPreference.getInstance(this.mContext).updateSyncTime(this.mServerTime, this.mServerSyncTime);
        AdapterForTLog.loge(TAG, "updateSyncTime! ServerTime = " + this.mServerTime + " ServerSyncTime = " + this.mServerSyncTime);
    }

    @Override // com.youku.usercenter.passport.IPassport
    public void logout(String str) {
        checkInit();
        this.mPassportService.logout(str);
    }

    @Override // com.youku.usercenter.passport.IPassport
    public synchronized void init(PassportConfig passportConfig, ICallback<Result> iCallback) {
        String runningInfo = SysUtil.getRunningInfo();
        AdapterForTLog.loge(TAG, runningInfo + " 2) Prepare initiating " + iCallback);
        if (this.mIsInit) {
            AdapterForTLog.loge(TAG, runningInfo + " 2.5) Initiated by other process");
            if (iCallback != null) {
                Result result = new Result();
                result.setResultCode(0);
                iCallback.onSuccess(result);
            }
        } else if (iCallback != null) {
            this.mInitCallbacks.add(iCallback);
            init(passportConfig);
        }
    }
}
