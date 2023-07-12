package com.alibaba.motu.crashreporter;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Utils {
    private static final int kSystemRootStateDisable = 0;
    private static final int kSystemRootStateEnable = 1;
    private static final int kSystemRootStateUnknow = -1;
    private static int systemRootState = -1;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class SystemPropertiesUtils {
        static boolean initSuccess;
        static Class<?> mSystemPropertiesClazz;
        static Method mSystemPropertiesClazz_getMethod;
        static Method mSystemPropertiesClazz_setMethod;

        static {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                mSystemPropertiesClazz = cls;
                mSystemPropertiesClazz_getMethod = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
                mSystemPropertiesClazz_setMethod = mSystemPropertiesClazz.getMethod("set", String.class, String.class);
                initSuccess = true;
            } catch (Exception unused) {
                LogUtil.e("init system properties utils");
            }
        }

        public static String get(String str) {
            if (initSuccess && !StringUtils.isBlank(str)) {
                try {
                    return (String) mSystemPropertiesClazz_getMethod.invoke(mSystemPropertiesClazz, str);
                } catch (Exception e) {
                    LogUtil.e("invoke system properties get", e);
                    return null;
                }
            }
            return null;
        }

        public static void set(String str, String str2) {
            if (!initSuccess || StringUtils.isBlank(str) || StringUtils.isBlank(str2)) {
                return;
            }
            try {
                mSystemPropertiesClazz_setMethod.invoke(mSystemPropertiesClazz, str, str2);
            } catch (Exception e) {
                LogUtil.e("invoke system properties set", e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class VMRuntimeUtils {
        static boolean initSuccess;
        static Object mRuntime;
        static Class<?> mVMRuntimeClazz;
        static Method mVMRuntimeClazz_DisableJitCompilationMethod;
        static Method mVMRuntimeClazz_IsDebuggerActiveMethod;
        static Method mVMRuntimeClazz_StartJitCompilationMethod;

        static {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                mVMRuntimeClazz = cls;
                mRuntime = cls.getMethod("getRuntime", new Class[0]).invoke(mVMRuntimeClazz, new Object[0]);
                mVMRuntimeClazz_IsDebuggerActiveMethod = mVMRuntimeClazz.getMethod("isDebuggerActive", new Class[0]);
                mVMRuntimeClazz_StartJitCompilationMethod = mVMRuntimeClazz.getMethod("startJitCompilation", new Class[0]);
                mVMRuntimeClazz_DisableJitCompilationMethod = mVMRuntimeClazz.getMethod("disableJitCompilation", new Class[0]);
                initSuccess = true;
            } catch (Exception unused) {
                LogUtil.e("init system properties utils");
            }
        }

        public static boolean disableJitCompilation() {
            if (initSuccess) {
                try {
                    mVMRuntimeClazz_DisableJitCompilationMethod.invoke(mRuntime, new Object[0]);
                    return true;
                } catch (Exception e) {
                    LogUtil.e("disableJitCompilation", e);
                }
            }
            return false;
        }

        public static boolean isDebuggerActive() {
            if (initSuccess) {
                try {
                    return ((Boolean) mVMRuntimeClazz_IsDebuggerActiveMethod.invoke(mRuntime, new Object[0])).booleanValue();
                } catch (Exception e) {
                    LogUtil.e("isDebuggerActive", e);
                }
            }
            return false;
        }

        public static boolean startJitCompilation() {
            if (initSuccess) {
                try {
                    mVMRuntimeClazz_StartJitCompilationMethod.invoke(mRuntime, new Object[0]);
                    return true;
                } catch (Exception e) {
                    LogUtil.e("startJitCompilation", e);
                }
            }
            return false;
        }
    }

    public static String getContextAppVersion(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                LogUtil.d("get context app version failure");
                return null;
            }
        }
        return null;
    }

    public static Long getContextFirstInstallTime(Context context) {
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    return Long.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime);
                }
                return null;
            } catch (Exception unused) {
                LogUtil.d("get context first install time failure");
                return null;
            }
        }
        return null;
    }

    public static Long getContextLastUpdateTime(Context context) {
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    return Long.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime);
                }
                return null;
            } catch (Exception unused) {
                LogUtil.d("get context last update time failure");
                return null;
            }
        }
        return null;
    }

    public static void getMTLMetaData(Map<String, Object> map, Context context) {
        if (context != null) {
            try {
                if (!map.containsKey("pt")) {
                    String mTLString = getMTLString(context, "package_type");
                    if (!TextUtils.isEmpty(mTLString)) {
                        map.put("pt", mTLString);
                    }
                }
                if (!map.containsKey("pid")) {
                    String mTLString2 = getMTLString(context, "project_id");
                    if (!TextUtils.isEmpty(mTLString2)) {
                        map.put("pid", mTLString2);
                    }
                }
                if (!map.containsKey("bid")) {
                    String mTLString3 = getMTLString(context, "build_id");
                    if (!TextUtils.isEmpty(mTLString3)) {
                        map.put("bid", mTLString3);
                    }
                }
                if (map.containsKey("bv")) {
                    return;
                }
                String mTLString4 = getMTLString(context, "base_version");
                if (TextUtils.isEmpty(mTLString4)) {
                    return;
                }
                map.put("bv", mTLString4);
            } catch (Exception unused) {
            }
        }
    }

    public static String getMTLString(Context context, String str) {
        if (context == null) {
            return null;
        }
        int i = 0;
        try {
            i = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception unused) {
        }
        if (i != 0) {
            return context.getString(i);
        }
        return null;
    }

    public static boolean isInstallOnSDCard(Context context) {
        try {
            return (context.getApplicationInfo().flags & 262144) != 0;
        } catch (Exception e) {
            LogUtil.e("isInstallOnSDCard", e);
            return false;
        }
    }

    public static Boolean isLockScreenOn(Context context) {
        try {
            if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            LogUtil.e("isLockScreenOn", e);
            return Boolean.FALSE;
        }
    }

    public static Boolean isMainThread(Thread thread) {
        if (thread != null) {
            return Boolean.valueOf(Looper.getMainLooper().getThread() == thread);
        }
        return Boolean.FALSE;
    }

    public static boolean isRootSystem() {
        int i = systemRootState;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                if (new File(strArr[i2] + "su").exists()) {
                    systemRootState = 1;
                    return true;
                }
            } catch (Exception e) {
                LogUtil.e("isRootSystem", e);
            }
        }
        systemRootState = 0;
        return false;
    }

    public static Boolean isServiceProcess(String str) {
        if (str != null) {
            return Boolean.valueOf(str.contains(":"));
        }
        return Boolean.FALSE;
    }

    public static Boolean isUIProcess(Context context, String str) {
        if (context != null && str != null) {
            return Boolean.valueOf(context.getPackageName().equals(str));
        }
        return Boolean.FALSE;
    }

    public static String reverse(String str) {
        if (StringUtils.isBlank(str)) {
            return "LLUN";
        }
        int i = 0;
        if (str.length() > 48) {
            str = str.substring(0, 48);
            i = str.length() - 48;
        }
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (int length = bytes.length - 1; length >= 0; length--) {
            byte b = bytes[length];
            if (b == 46) {
                sb.append(YKUpsConvert.CHAR_ZERO);
            } else if (b == 58) {
                sb.append('1');
            } else if (b >= 97 && b <= 122) {
                sb.append((char) ((b + 65) - 97));
            } else if (b >= 65 && b <= 90) {
                sb.append((char) b);
            } else if (b >= 48 && b <= 57) {
                sb.append((char) b);
            } else {
                sb.append('2');
            }
        }
        if (i > 0) {
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }

    public static void stopService(Context context) {
        try {
            int myUid = Process.myUid();
            String packageName = context.getPackageName();
            for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
                if (runningServiceInfo.uid == myUid && packageName.equals(runningServiceInfo.service.getPackageName()) && runningServiceInfo.started) {
                    ComponentName componentName = runningServiceInfo.service;
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    context.stopService(intent);
                }
            }
        } catch (Exception e) {
            LogUtil.e("stopService", e);
        }
    }
}
