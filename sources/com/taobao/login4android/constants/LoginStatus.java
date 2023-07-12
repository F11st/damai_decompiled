package com.taobao.login4android.constants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.thread.LoginThreadHelper;
import com.taobao.login4android.utils.FileUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginStatus {
    private static final String CURRENT_PROCESS = "currentProcess";
    private static final String IS_LOGIGING = "isLogining";
    private static final String IS_USER_LOGINING = "isUserLogining";
    private static final String NOTIFY_LOGIN_STATUS_CHANGE = "NOTIFY_LOGIN_STATUS_CHANGE";
    public static final String TAG = "login.LoginStatus";
    public static boolean askServerForGuide = true;
    public static String benifit_id = null;
    public static String browserRefUrl = null;
    public static boolean enableOnekeyLoginV2 = false;
    public static boolean enableSsoAlways = true;
    public static boolean firstLogin = true;
    public static boolean huaweiLogin = false;
    public static boolean isFromAuthOnCreate = false;
    public static String locationUrl = null;
    private static Context mContext = null;
    public static String mFrom = null;
    private static BroadcastReceiver mStatusReceiver = null;
    public static int outline = 0;
    public static boolean saveSalt = true;
    public static boolean youkuFirstLogin = true;
    private static AtomicBoolean isLogining = new AtomicBoolean(false);
    private static AtomicBoolean userLogin = new AtomicBoolean(false);
    private static AtomicBoolean isFromAccountChange = new AtomicBoolean(false);
    private static AtomicBoolean isNewFingerPrintEnrolled = new AtomicBoolean(false);
    private static AtomicLong lastLoginTime = new AtomicLong(0);
    public static final AtomicLong lastRefreshCookieTime = new AtomicLong(0);
    public static String loginEntrance = "";
    public static AtomicLong lastCheckSpFileTime = new AtomicLong(0);

    public static synchronized boolean compareAndSetFromChangeAccount(boolean z, boolean z2) {
        boolean compareAndSet;
        synchronized (LoginStatus.class) {
            compareAndSet = isFromAccountChange.compareAndSet(z, z2);
        }
        return compareAndSet;
    }

    public static synchronized boolean compareAndSetLogining(boolean z, boolean z2) {
        boolean compareAndSet;
        synchronized (LoginStatus.class) {
            LoginTLogAdapter.e("login.LoginStatus", "compareAndSetLogining  expect=" + z + ",update=" + z2);
            compareAndSet = isLogining.compareAndSet(z, z2);
            if (!compareAndSet || !z || !z2) {
                nofityStatusChange();
            }
            if (compareAndSet) {
                lastLoginTime.set(System.currentTimeMillis());
            }
        }
        return compareAndSet;
    }

    public static synchronized boolean compareAndSetNewFingerPrintEntrolled(boolean z, boolean z2) {
        boolean compareAndSet;
        synchronized (LoginStatus.class) {
            compareAndSet = isNewFingerPrintEnrolled.compareAndSet(z, z2);
        }
        return compareAndSet;
    }

    public static long getLastLoginTime() {
        return lastLoginTime.get();
    }

    public static long getLastRefreshCookieTime() {
        AtomicLong atomicLong = lastRefreshCookieTime;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public static void init(Context context) {
        LoginTLogAdapter.e("login.LoginStatus", "init Login Status");
        mContext = context;
        mStatusReceiver = new BroadcastReceiver() { // from class: com.taobao.login4android.constants.LoginStatus.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent != null) {
                    try {
                        if (TextUtils.equals(LoginThreadHelper.getCurProcessName(context2), intent.getStringExtra(LoginStatus.CURRENT_PROCESS))) {
                            return;
                        }
                        LoginStatus.isLogining.set(intent.getBooleanExtra(LoginStatus.IS_LOGIGING, false));
                        LoginStatus.userLogin.set(intent.getBooleanExtra(LoginStatus.IS_USER_LOGINING, false));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        mContext.registerReceiver(mStatusReceiver, new IntentFilter(NOTIFY_LOGIN_STATUS_CHANGE));
    }

    public static boolean isFromChangeAccount() {
        return isFromAccountChange.get();
    }

    public static boolean isLogining() {
        return isLogining.get() || userLogin.get();
    }

    public static boolean isUserLogin() {
        return userLogin.get();
    }

    private static void nofityStatusChange() {
        if (mContext == null || mStatusReceiver == null) {
            return;
        }
        Intent intent = new Intent(NOTIFY_LOGIN_STATUS_CHANGE);
        intent.putExtra(CURRENT_PROCESS, LoginThreadHelper.getCurProcessName(mContext));
        intent.putExtra(IS_LOGIGING, isLogining.get());
        intent.putExtra(IS_USER_LOGINING, userLogin.get());
        intent.setPackage(mContext.getPackageName());
        mContext.sendBroadcast(intent);
    }

    public static synchronized void resetFingerPrintEntrolled() {
        synchronized (LoginStatus.class) {
            compareAndSetNewFingerPrintEntrolled(true, false);
        }
    }

    public static void resetLoginFlag() {
        try {
            LoginTLogAdapter.e("login.LoginStatus", "reset login status " + FileUtils.readThreadStack());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        boolean compareAndSet = isLogining.compareAndSet(true, false);
        boolean compareAndSet2 = userLogin.compareAndSet(true, false);
        if (compareAndSet || compareAndSet2) {
            nofityStatusChange();
        }
        isFromAccountChange.compareAndSet(true, false);
    }

    public static void setLastRefreshCookieTime(long j) {
        lastRefreshCookieTime.set(j);
    }

    public static void setUserLogin(boolean z) {
        LoginTLogAdapter.e("login.LoginStatus", "set userLogin=" + z);
        if (userLogin.compareAndSet(!z, z)) {
            nofityStatusChange();
        }
    }
}
