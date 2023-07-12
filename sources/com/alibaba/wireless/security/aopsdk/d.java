package com.alibaba.wireless.security.aopsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectUtil.java */
/* loaded from: classes.dex */
public class d {
    public static final boolean a = true;
    private static final String c = "AOP-ReflectUtil";
    private static Object l = null;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    private static final ThreadLocal<String> b = new ThreadLocal<>();
    private static ActivityManager d = null;
    private static boolean e = false;
    private static String f = null;
    private static boolean g = true;
    private static int h = -1;
    private static boolean i = false;
    private static boolean j = true;
    private static Map<?, ?> k = null;

    public static String a(Invocation invocation) {
        ArrayList arrayList;
        long nanoTime = System.nanoTime();
        if (b.get() == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean c2 = c();
            ArrayList arrayList2 = new ArrayList(stackTrace.length);
            for (int i2 = 2; i2 < stackTrace.length; i2++) {
                if (!c2 || !stackTrace[i2].getClassName().startsWith(BuildConfig.LIBRARY_PACKAGE_NAME)) {
                    arrayList2.add(stackTrace[i2].toString());
                }
            }
            int b2 = b();
            if (b2 == -1 || b2 >= arrayList2.size()) {
                arrayList = arrayList2;
            } else {
                int i3 = b2 / 2;
                int size = arrayList2.size() - b2;
                arrayList = new ArrayList(arrayList2.subList(0, i3));
                arrayList.add("...");
                arrayList.addAll(arrayList2.subList(i3 + size, arrayList2.size()));
            }
            b.set(Arrays.toString(arrayList.toArray()));
        }
        String str = b.get();
        invocation.stackTimeCost = (System.nanoTime() - nanoTime) / 1000;
        return str;
    }

    private static synchronized ActivityManager b(Context context) {
        ActivityManager activityManager;
        synchronized (d.class) {
            if (!e) {
                e = true;
                d = (ActivityManager) context.getSystemService("activity");
            }
            activityManager = d;
        }
        return activityManager;
    }

    public static int c(Context context) {
        if (context == null) {
            if (ConfigManager.DEBUG) {
                Log.d(c, "context is null");
            }
        } else if (e()) {
            try {
                ActivityManager b2 = b(context);
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                String packageName = context.getPackageName();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : b2.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equals(packageName)) {
                        int i2 = runningAppProcessInfo.importance;
                        if (i2 == 400 || i2 == 125) {
                            return 2;
                        }
                        return powerManager.isScreenOn() ? 0 : 1;
                    }
                }
            } catch (Throwable th) {
                com.alibaba.wireless.security.aopsdk.i.a.a(c, "isAppOnForeground", th);
            }
        }
        return 3;
    }

    public static boolean d() {
        return j;
    }

    public static String e(Context context) {
        if (f == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                f = Application.getProcessName();
            } else {
                try {
                    f = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(i2 >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
                } catch (Throwable th) {
                    com.alibaba.wireless.security.aopsdk.i.a.a(c, "getProcessName", th);
                }
            }
            if (e() && context != null) {
                int myPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = b(context).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            f = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
        }
        return f;
    }

    public static String f(Context context) {
        if (e()) {
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = b(context).getRunningTasks(1);
                if (runningTasks != null && runningTasks.size() > 0) {
                    return runningTasks.get(0).topActivity.toString();
                }
            } catch (Throwable th) {
                com.alibaba.wireless.security.aopsdk.i.a.a(c, "getSnapshot", th);
            }
        }
        return "";
    }

    public static boolean g(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        if (e() && context != null) {
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = b(context).getRunningTasks(1);
                if (runningTasks != null && runningTasks.size() > 0 && (runningTaskInfo = runningTasks.get(0)) != null && (componentName = runningTaskInfo.topActivity) != null) {
                    return componentName.getPackageName().equals(context.getPackageName());
                }
            } catch (Throwable th) {
                if (ConfigManager.DEBUG) {
                    Log.e(c, "isAppInForeground", th);
                }
            }
        }
        return true;
    }

    private static Context d(Context context) {
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        return context2;
    }

    public static void b(boolean z) {
        j = z;
    }

    public static int b() {
        return h;
    }

    public static boolean c() {
        return g;
    }

    public static void c(boolean z) {
        i = z;
    }

    public static boolean e() {
        return i;
    }

    public static void a() {
        b.set(null);
    }

    public static void a(boolean z) {
        g = z;
    }

    public static void a(int i2) {
        h = i2;
    }

    private static Object a(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            return null;
        }
    }

    private static Map<?, ?> a(Context context) {
        if (l == null) {
            l = a(d(context), "mMainThread");
        }
        return (Map) a(l, "mActivities");
    }

    public static boolean a(Context context, Activity activity) {
        if (k == null) {
            k = a(context);
        }
        Collection<?> values = k.values();
        if (!values.isEmpty()) {
            for (Object obj : values) {
                if (obj != null && Boolean.FALSE.equals(a(obj, DXRecyclerLayout.LOAD_MORE_STOPED)) && (activity == null || a(obj, "activity") != activity)) {
                    return true;
                }
            }
        }
        return false;
    }
}
