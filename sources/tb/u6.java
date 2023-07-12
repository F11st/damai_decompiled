package tb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class u6 {
    private static Boolean a;
    private static String b;
    static Map<String, String> c;

    public static String a() {
        return Variables.n().g();
    }

    public static String b() {
        return Variables.n().h();
    }

    public static String c(Context context) {
        Map<String, String> e = e(context);
        if (e != null) {
            return e.get("preLoad_Channel2");
        }
        return null;
    }

    public static String d(Context context) {
        String str = b;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                String str2 = runningAppProcessInfo.processName;
                b = str2;
                return str2;
            }
        }
        return "";
    }

    public static Map<String, String> e(Context context) {
        Map<String, String> map = c;
        if (map != null) {
            Logger.r("AppInfoUtil", "getInfoForPreApk preInfoMap", map);
            return c;
        } else if (context == null) {
            Logger.i("AppInfoUtil", "getInfoForPreApk context is null");
            return null;
        } else {
            c = new HashMap();
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("manufacture_config", 0);
                boolean z = sharedPreferences.getBoolean("preLoad", false);
                String string = sharedPreferences.getString("preLoad_VersionName", "");
                String string2 = sharedPreferences.getString("preLoad_Channel1", "");
                String string3 = sharedPreferences.getString("preLoad_Channel2", "");
                if (z) {
                    c.put("preLoad", "true");
                    c.put("preLoad_VersionName", string);
                    c.put("preLoad_Channel1", string2);
                    c.put("preLoad_Channel2", string3);
                }
            } catch (Exception e) {
                Logger.h("AppInfoUtil", e, new Object[0]);
            }
            Logger.f("AppInfoUtil", "getInfoForPreApk preInfoMap", c);
            return c;
        }
    }

    public static String f(Context context, String str) {
        int identifier;
        if (context == null) {
            return null;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null && (identifier = resources.getIdentifier(str, "string", context.getPackageName())) != 0) {
                return context.getString(identifier);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Deprecated
    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                Logger.f("AppInfoUtil", "appProcess.processName", runningAppProcessInfo.processName, "appProcess.importance", Integer.valueOf(runningAppProcessInfo.importance));
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    int i = runningAppProcessInfo.importance;
                    if (i != 400 && i != 125) {
                        if (powerManager.isScreenOn()) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static boolean h(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return true;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
            String d = d(context);
            Boolean valueOf = Boolean.valueOf((TextUtils.isEmpty(str) || TextUtils.isEmpty(d)) ? true : d.equalsIgnoreCase(str));
            a = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean i(Context context, boolean z) {
        if (context == null) {
            return z;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
            String d = d(context);
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(d)) ? z : d.equalsIgnoreCase(str);
        } catch (Throwable unused) {
            return z;
        }
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                Logger.f("AppInfoUtil", "appProcess.processName", runningAppProcessInfo.processName);
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
