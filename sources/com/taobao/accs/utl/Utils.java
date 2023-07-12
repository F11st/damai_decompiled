package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.common.Constants;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Utils {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";
    private static final String TAG = "Utils";
    private static final byte[] mLock = new byte[0];
    static int mode = -1;
    private static int targetSdkVersion = -1;

    public static void clearAgooBindCache(Context context) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, "AGOO_BIND", 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e) {
            ALog.e("Utils", "clearAgooBindCache", e, new Object[0]);
        }
    }

    public static void clearAllSharePreferences(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "clearAllSharePreferences", th, new Object[0]);
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Bundle getMetaInfo(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            return null;
        } catch (Throwable th) {
            ALog.e("Utils", "getMetaInfo", th, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static int getMode(Context context) {
        int i = mode;
        if (i != -1) {
            return i;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            context = 0;
        }
        synchronized (mLock) {
            try {
                context = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                return context;
            } catch (Throwable th3) {
                th = th3;
                context = 0;
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    ALog.e("Utils", "getMode", th, new Object[0]);
                    return context;
                }
            }
        }
    }

    public static String getSpValue(Context context, String str, String str2) {
        String str3 = null;
        try {
            synchronized (mLock) {
                str3 = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getString(str, null);
            }
            ALog.i("Utils", "getSpValue", "value", str3);
            if (TextUtils.isEmpty(str3)) {
                ALog.e("Utils", "getSpValue use default!", new Object[0]);
                return str2;
            }
        } catch (Throwable th) {
            ALog.e("Utils", "getSpValue fail", th, new Object[0]);
        }
        return str3;
    }

    @Deprecated
    public static void initConfig() {
        try {
            AccsConfig.build();
        } catch (Throwable th) {
            ALog.e("Utils", "initConfig", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static boolean isMainProcess(Context context) {
        boolean z;
        try {
            z = UtilityImpl.isMainProcess(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killservice", th, new Object[0]);
            th.printStackTrace();
            z = true;
        }
        ALog.i("Utils", "isMainProcess", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isTarget26(Context context) {
        if (context == null) {
            return false;
        }
        if (targetSdkVersion == -1) {
            targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        }
        return targetSdkVersion >= 26 && Build.VERSION.SDK_INT >= 26;
    }

    public static void killService(Context context) {
        try {
            UtilityImpl.killService(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killService", th, new Object[0]);
        }
    }

    public static void setAgooAppkey(Context context, String str) {
        try {
            Config.setAgooAppKey(context, str);
        } catch (Throwable th) {
            ALog.e("Utils", "setAgooAppkey", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static void setMode(Context context, int i) {
        try {
            synchronized (mLock) {
                mode = i;
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
                edit.putInt(Constants.SP_KEY_DEBUG_MODE, i);
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "setMode", th, new Object[0]);
        }
    }

    public static void setSpValue(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ALog.e("Utils", "setSpValue null", new Object[0]);
            return;
        }
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
                edit.putString(str, str2);
                edit.apply();
            }
            ALog.i("Utils", "setSpValue", "key", str, "value", str2);
        } catch (Exception e) {
            ALog.e("Utils", "setSpValue fail", e, new Object[0]);
        }
    }
}
