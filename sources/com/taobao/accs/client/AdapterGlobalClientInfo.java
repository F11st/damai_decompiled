package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoConstants;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AdapterGlobalClientInfo {
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    private static final String TAG = "AdapterGlobalClientInfo";
    public static String mAgooCustomServiceName;
    public static String mAuthCode;
    public static String mChannelProcessName;
    private static Context mContext;
    private static volatile AdapterGlobalClientInfo mInstance;
    public static String mMainProcessName;
    public static IProcessName mProcessNameImpl;
    public static int mSecurityType;
    public static AtomicInteger mStartServiceTimes = new AtomicInteger(-1);
    private ActivityManager mActivityManager;
    private ConnectivityManager mConnectivityManager;

    private AdapterGlobalClientInfo(Context context) {
        if (context != null) {
            if (mContext == null) {
                mContext = context.getApplicationContext();
                return;
            }
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    public static String getAgooCustomServiceName(String str) {
        String str2;
        if (TextUtils.isEmpty(mAgooCustomServiceName)) {
            str2 = str + TaobaoConstants.DEFAULT_INTENT_SERVICE_CLASS_NAME;
        } else {
            str2 = mAgooCustomServiceName;
        }
        ALog.d(TAG, "getAgooCustomServiceName", "serviceName", str2);
        return str2;
    }

    public static Context getContext() {
        return mContext;
    }

    public static AdapterGlobalClientInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AdapterGlobalClientInfo.class) {
                if (mInstance == null) {
                    mInstance = new AdapterGlobalClientInfo(context);
                }
            }
        }
        return mInstance;
    }

    public static boolean isFirstStartProc() {
        return mStartServiceTimes.intValue() == 0;
    }

    public ActivityManager getActivityManager() {
        if (this.mActivityManager == null) {
            this.mActivityManager = (ActivityManager) mContext.getSystemService("activity");
        }
        return this.mActivityManager;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        }
        return this.mConnectivityManager;
    }
}
