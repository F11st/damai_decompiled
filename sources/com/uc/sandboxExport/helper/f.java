package com.uc.sandboxExport.helper;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class f {
    private static WeakReference<Context> a = null;
    private static String b = "sandbox.Utils";

    public static void a(Context context) {
        if (context != null) {
            WeakReference<Context> weakReference = a;
            if (weakReference == null || weakReference.get() == null) {
                Context context2 = null;
                try {
                    context2 = context.getApplicationContext();
                } catch (Throwable unused) {
                }
                if (context2 != null) {
                    context = context2;
                }
                a = new WeakReference<>(context);
            }
        }
    }

    public static void b(String str, String str2) {
        Context a2 = a();
        if (a2 == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = a2.getSharedPreferences("u4app_core", 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable th) {
            c.b(b, "SharedPreferences.putString(%s, %s) failure", str, str2, th);
        }
    }

    public static Context a() {
        WeakReference<Context> weakReference = a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String a(String str, String str2) {
        Context a2 = a();
        if (a2 == null) {
            return str2;
        }
        try {
            return a2.getSharedPreferences("u4app_core", 0).getString(str, str2);
        } catch (Throwable th) {
            c.b(b, "SharedPreferences.getString(%s) failure", str, th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        String str = Build.VERSION.CODENAME;
        return (str.length() == 1 && str.charAt(0) >= 'Q' && str.charAt(0) <= 'Z') || Build.VERSION.SDK_INT >= 29;
    }

    public static String b(Context context) {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable unused) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
    }

    public static boolean a(String str) {
        Context a2 = a();
        if (a2 == null) {
            return false;
        }
        try {
            return a2.getSharedPreferences("u4app_core", 0).getBoolean(str, false);
        } catch (Throwable th) {
            c.b(b, "SharedPreferences.getBoolean(%s) failure", str, th);
            return false;
        }
    }

    public static void a(String str, boolean z) {
        Context a2 = a();
        if (a2 == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = a2.getSharedPreferences("u4app_core", 0).edit();
            edit.putBoolean(str, z);
            edit.apply();
        } catch (Throwable th) {
            c.b(b, "SharedPreferences.putInt(%s, %b) failure", str, Boolean.valueOf(z), th);
        }
    }
}
