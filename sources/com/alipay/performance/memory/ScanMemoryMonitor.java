package com.alipay.performance.memory;

import android.app.ActivityManager;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ScanMemoryMonitor {
    private static boolean a(int i) {
        return i == 5 || i == 10 || i == 15;
    }

    public static int getLastTrimMemoryLevel() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            MPaasLogger.d("ScanMemoryMonitor", new Object[]{"getLastTrimMemoryLevel, lastTrimLevel:", Integer.valueOf(runningAppProcessInfo.lastTrimLevel), ",consume time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return runningAppProcessInfo.lastTrimLevel;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean inLowMemory() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            MPaasLogger.d("ScanMemoryMonitor", new Object[]{"inLowMemory, lastTrimLevel:", Integer.valueOf(runningAppProcessInfo.lastTrimLevel), ",consume time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return a(runningAppProcessInfo.lastTrimLevel);
        } catch (Throwable unused) {
            return false;
        }
    }
}
