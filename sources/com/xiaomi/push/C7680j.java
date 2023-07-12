package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.j */
/* loaded from: classes11.dex */
public class C7680j {
    private static String a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final Set<String> f789a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f790a = false;
    private static String b = null;
    private static String c = "";
    private static String d;
    private static String e;
    private static final String f = String.valueOf((char) 2);

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f791a = {"--", "a-", "u-", W3CStyleConstants.V_PREFIX, "o-", "g-"};

    static {
        HashSet hashSet = new HashSet();
        f789a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        f790a = true;
    }

    private static double a(double d2) {
        int i = 1;
        while (true) {
            double d3 = i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    private static float a(int i) {
        float f2 = ((((((i + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    @TargetApi(17)
    public static int a() {
        Object a2 = bk.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(a2)).intValue();
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m1091a() {
        return a(b()) + "GB";
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m1092a(int i) {
        if (i > 0) {
            String[] strArr = f791a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f791a[0];
    }

    public static String a(Context context) {
        try {
            return C7683k.a(context).a();
        } catch (Exception e2) {
            AbstractC7535b.m586a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        if (d == null) {
            String c2 = c(context);
            String d2 = !C7688m.m1124d() ? z ? d(context) : l(context) : "";
            String b2 = b(context);
            int i = 1;
            if (!(Build.VERSION.SDK_INT < 26) && b(d2) && b(b2)) {
                String b3 = ba.a(context).b();
                if (TextUtils.isEmpty(b3)) {
                    String mo670a = ba.a(context).mo670a();
                    if (TextUtils.isEmpty(mo670a) || mo670a.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i = 5;
                    } else {
                        i = 4;
                        c2 = mo670a;
                    }
                } else {
                    c2 = b3 + c2;
                    i = 2;
                }
            } else {
                c2 = d2 + c2 + b2;
            }
            AbstractC7535b.b("devid rule select:" + i);
            if (i == 3) {
                d = c2;
            } else {
                d = m1092a(i) + bp.b(c2);
            }
        }
        return d;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1093a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) bk.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            int i = applicationInfo.flags;
            if ((i & 2097152) != 2097152 || (i & 8388608) == 8388608) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f791a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static int b() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
        return 0;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m1094b() {
        double a2 = a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    public static String b(Context context) {
        return null;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m1095b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown");
    }

    private static int c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m1096c() {
        return b() + "KB";
    }

    public static String c(Context context) {
        String str = b;
        if (str == null && f790a) {
            boolean m1098d = m1098d(context);
            f790a = m1098d;
            if (m1098d) {
                try {
                    b = Settings.Secure.getString(context.getContentResolver(), "android_id");
                } catch (Throwable th) {
                    AbstractC7535b.m586a("failure to get androidId: " + th);
                }
                return b;
            }
            return null;
        }
        return str;
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m1097c(Context context) {
        String packageName = context.getPackageName();
        if (C7688m.m1118a() && f789a.contains(packageName)) {
            return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
        }
        return false;
    }

    private static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bp.m705b(str) && !bp.c(str);
    }

    public static String d() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    public static String d(Context context) {
        int c2 = c();
        String e2 = e(context);
        while (e2 == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            e2 = e(context);
            c2 = i;
        }
        return e2;
    }

    /* renamed from: d  reason: collision with other method in class */
    private static boolean m1098d(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
        intent.setComponent(componentName);
        try {
            Bundle bundle = context.getPackageManager().getServiceInfo(componentName, 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("supportGetAndroidID");
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                return Boolean.parseBoolean(string);
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static String e(Context context) {
        String str;
        Object obj;
        Object a2;
        Object a3;
        if (C7688m.m1124d()) {
            return "";
        }
        String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (m1097c(context)) {
                str = (!C7688m.m1118a() || (a2 = bk.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = bk.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
                if (str == null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT < 26) {
                        str = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                    } else {
                        if (1 == telephonyManager.getPhoneType()) {
                            obj = bk.a((Object) telephonyManager, "getImei", (Object[]) null);
                        } else if (2 == telephonyManager.getPhoneType()) {
                            obj = bk.a((Object) telephonyManager, "getMeid", (Object[]) null);
                        }
                        str = (String) obj;
                    }
                }
            } else {
                str = null;
            }
            if (c(str)) {
                a = str;
                return str;
            }
            return "";
        } catch (Throwable th) {
            AbstractC7535b.m586a("failure to get id:" + th);
            return null;
        }
    }

    public static String f(Context context) {
        int c2 = c();
        String h = h(context);
        while (h == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            h = h(context);
            c2 = i;
        }
        return h;
    }

    public static String g(Context context) {
        Object a2;
        if (!C7688m.m1124d() && Build.VERSION.SDK_INT >= 22) {
            if (TextUtils.isEmpty(c)) {
                e(context);
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                try {
                    if (m1097c(context)) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) bk.a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                        if (num != null && num.intValue() > 1) {
                            String str = null;
                            for (int i = 0; i < num.intValue(); i++) {
                                if (Build.VERSION.SDK_INT < 26) {
                                    a2 = bk.a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i));
                                } else if (1 == telephonyManager.getPhoneType()) {
                                    a2 = bk.a((Object) telephonyManager, "getImei", Integer.valueOf(i));
                                } else {
                                    if (2 == telephonyManager.getPhoneType()) {
                                        a2 = bk.a((Object) telephonyManager, "getMeid", Integer.valueOf(i));
                                    }
                                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(a, str) && c(str)) {
                                        c += str + ",";
                                    }
                                }
                                str = (String) a2;
                                if (!TextUtils.isEmpty(str)) {
                                    c += str + ",";
                                }
                            }
                            int length = c.length();
                            if (length > 0) {
                                c = c.substring(0, length - 1);
                            }
                            return c;
                        }
                    }
                    return "";
                } catch (Exception e2) {
                    AbstractC7535b.m586a("failure to get ids: " + e2);
                    return "";
                }
            }
            return c;
        }
        return "";
    }

    public static String h(Context context) {
        g(context);
        String str = "";
        if (TextUtils.isEmpty(c)) {
            return "";
        }
        for (String str2 : c.split(",")) {
            if (c(str2)) {
                str = str + bp.a(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String i(Context context) {
        synchronized (C7680j.class) {
            String str = e;
            if (str != null) {
                return str;
            }
            String c2 = c(context);
            String b2 = b(context);
            String b3 = bp.b(c2 + b2);
            e = b3;
            return b3;
        }
    }

    public static synchronized String j(Context context) {
        String b2;
        synchronized (C7680j.class) {
            String c2 = c(context);
            b2 = bp.b(c2 + ((String) null));
        }
        return b2;
    }

    public static String k(Context context) {
        return com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName((TelephonyManager) context.getSystemService("phone"));
    }

    private static String l(Context context) {
        int c2 = c();
        String e2 = e(context);
        while (TextUtils.isEmpty(e2)) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            e2 = e(context);
            c2 = i;
        }
        return e2;
    }
}
