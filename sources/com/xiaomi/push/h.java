package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        private final int f443a;

        a(int i) {
            this.f443a = i;
        }

        public int a() {
            return this.f443a;
        }
    }

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                    return 0;
                }
                return bundle.getInt("SupportForPushVersionCode");
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ApplicationInfo m939a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.m586a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m940a(Context context, String str) {
        ApplicationInfo m939a = m939a(context, str);
        Drawable drawable = null;
        if (m939a != null) {
            try {
                drawable = m939a.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = m939a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m586a("get app icon drawable failed, " + e);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    private static a a(Context context, ApplicationInfo applicationInfo) {
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return a.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object a2 = i >= 29 ? bk.a(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) bk.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.ALLOWED : a.NOT_ALLOWED;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("are notifications enabled error " + e);
        }
        return a.UNKNOWN;
    }

    @TargetApi(19)
    public static a a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        a a2;
        a aVar;
        if (context == null || TextUtils.isEmpty(str)) {
            return a.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
            aVar = a.UNKNOWN;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m586a("get app op error " + th);
        }
        if (a2 != aVar) {
            return a2;
        }
        Integer num = (Integer) bk.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return aVar;
        }
        Integer num2 = (Integer) bk.a((Object) ((AppOpsManager) context.getSystemService("appops")), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
        int i = (Integer) bk.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        int i2 = (Integer) bk.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
        if (i == null) {
            i = 0;
        }
        if (i2 == null) {
            i2 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i2) ? a.ALLOWED : a.NOT_ALLOWED : num2.equals(i) ? a.ALLOWED : a.NOT_ALLOWED;
        }
        return a.UNKNOWN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m941a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m942a(Context context) {
        String str = (String) bk.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equals(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m943a(Context context, String str) {
        if (m.m1118a()) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public static int b(Context context, String str) {
        ApplicationInfo m939a = m939a(context, str);
        if (m939a != null) {
            int i = m939a.icon;
            return i == 0 ? m939a.logo : i;
        }
        return 0;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m944b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m945b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
