package anet.channel.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import com.ta.utdid2.device.UTDevice;
import com.taobao.android.ab.api.ABGlobal;
import java.lang.reflect.Method;
import java.util.List;
import tb.cf0;
import tb.gn1;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c {
    public static Context a;
    private static Boolean b;
    private static String c;

    public static String a() {
        return "";
    }

    public static Context b() {
        Context context = a;
        if (context != null) {
            return context;
        }
        synchronized (c.class) {
            Context context2 = a;
            if (context2 != null) {
                return context2;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                a = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e) {
                ALog.j("awcn.Utils", "getAppContext", null, e, new Object[0]);
            }
            return a;
        }
    }

    public static String c(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static String d() {
        String str = c;
        if (str != null) {
            return str;
        }
        String str2 = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, com.alipay.sdk.m.c.a.b);
        } catch (Throwable unused) {
        }
        if (str2 == null) {
            str2 = "";
        }
        c = str2;
        return str2;
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static float f() {
        NetworkStatusHelper.NetworkStatus i = NetworkStatusHelper.i();
        float f = (i == NetworkStatusHelper.NetworkStatus.G4 || i == NetworkStatusHelper.NetworkStatus.WIFI) ? 0.8f : 1.0f;
        return BandWidthSampler.f().h() == NetworkSpeed.Fast.getCode() ? f * 0.75f : f;
    }

    public static String g(Context context, int i) {
        String str = "";
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            } else {
                x6.b().commitStat(new ExceptionStatistic(-108, cf0.a(-108, "BuildVersion=" + String.valueOf(Build.VERSION.SDK_INT)), "rt"));
            }
        } catch (Exception e) {
            x6.b().commitStat(new ExceptionStatistic(-108, e.toString(), "rt"));
        }
        return TextUtils.isEmpty(str) ? h(i) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0089, code lost:
        r10 = r3[8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008d, code lost:
        r7.close();
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
        anet.channel.util.ALog.d("awcn.Utils", "getProcessNameNew ", null, r0, new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String h(int r10) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.c.h(int):java.lang.String");
    }

    public static Object i(String str, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        Method declaredMethod;
        if (str == null || str2 == null) {
            return null;
        }
        Class<?> cls = Class.forName(str);
        if (clsArr != null) {
            declaredMethod = cls.getDeclaredMethod(str2, clsArr);
        } else {
            declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            if (objArr != null) {
                return declaredMethod.invoke(cls, objArr);
            }
            return declaredMethod.invoke(cls, new Object[0]);
        }
        return null;
    }

    public static Boolean j(Context context, String str) {
        try {
            boolean isFeatureOpened = ABGlobal.isFeatureOpened(context, str);
            ALog.e("awcn.Utils", "[isABGlobalFeatureOpened]", null, "featureName", str, "status", Boolean.valueOf(isFeatureOpened));
            return Boolean.valueOf(isFeatureOpened);
        } catch (Throwable unused) {
            ALog.e("awcn.Utils", "ABGlobal get error", null, new Object[0]);
            return null;
        }
    }

    public static boolean k() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            z = "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
        }
        Boolean bool2 = new Boolean(z);
        b = bool2;
        return bool2.booleanValue();
    }
}
