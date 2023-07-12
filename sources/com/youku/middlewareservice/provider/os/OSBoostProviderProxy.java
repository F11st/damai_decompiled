package com.youku.middlewareservice.provider.os;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class OSBoostProviderProxy {
    private static OSBoostProvider sProxy;

    public static void cancelCpuHighFreq() {
        try {
            OSBoostProvider oSBoostProvider = sProxy;
            if (oSBoostProvider == null) {
                return;
            }
            oSBoostProvider.cancelCpuHighFreq();
        } catch (Throwable th) {
            Log.e("OneService", "methodName: cancelCpuHighFreqThrowable: " + th.toString());
        }
    }

    public static void cancelThreadPriority(int i) {
        try {
            OSBoostProvider oSBoostProvider = sProxy;
            if (oSBoostProvider == null) {
                return;
            }
            oSBoostProvider.cancelThreadPriority(i);
        } catch (Throwable th) {
            Log.e("OneService", "methodName: cancelThreadPriorityThrowable: " + th.toString());
        }
    }

    public static OSBoostProvider getProxy() {
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && OSBoostProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (OSBoostProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isSupportBoost() {
        try {
            OSBoostProvider oSBoostProvider = sProxy;
            if (oSBoostProvider == null) {
                return false;
            }
            return oSBoostProvider.isSupportBoost();
        } catch (Throwable th) {
            Log.e("OneService", "methodName: isSupportBoostThrowable: " + th.toString());
            return false;
        }
    }

    public static boolean requestCpuHighFreq(int i, int i2) {
        try {
            OSBoostProvider oSBoostProvider = sProxy;
            if (oSBoostProvider == null) {
                return false;
            }
            return oSBoostProvider.requestCpuHighFreq(i, i2);
        } catch (Throwable th) {
            Log.e("OneService", "methodName: requestCpuHighFreqThrowable: " + th.toString());
            return false;
        }
    }

    public static boolean requestThreadPriority(int i, int i2) {
        try {
            OSBoostProvider oSBoostProvider = sProxy;
            if (oSBoostProvider == null) {
                return false;
            }
            return oSBoostProvider.requestThreadPriority(i, i2);
        } catch (Throwable th) {
            Log.e("OneService", "methodName: requestThreadPriorityThrowable: " + th.toString());
            return false;
        }
    }

    public static void unregisterBoostType(int i) {
        try {
            OSBoostProvider oSBoostProvider = sProxy;
            if (oSBoostProvider == null) {
                return;
            }
            oSBoostProvider.unregisterBoostType(i);
        } catch (Throwable th) {
            Log.e("OneService", "methodName: unregisterBoostTypeThrowable: " + th.toString());
        }
    }
}
