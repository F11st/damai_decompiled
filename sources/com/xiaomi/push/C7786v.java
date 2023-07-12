package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.C4151a;
import com.taobao.weex.annotation.JSMethod;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.v */
/* loaded from: classes11.dex */
public class C7786v {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static String f1004a;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m1245a() {
        return a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (Throwable unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            AbstractC7535b.m586a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", th);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m1246a() {
        synchronized (C7786v.class) {
            String str = f1004a;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    b = c();
                    if (TextUtils.isEmpty(b)) {
                        b = d();
                        if (TextUtils.isEmpty(b)) {
                            str2 = String.valueOf(C7785u.a("ro.product.brand", "Android") + JSMethod.NOT_SET + str2);
                        }
                    }
                }
                str2 = b;
            }
            f1004a = str2;
            return str2;
        }
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1247a() {
        return TextUtils.equals((String) bk.a("android.os.SystemProperties", gn1.TYPE_OPEN_URL_METHOD_GET, "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1248a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            AbstractC7535b.a(e);
            return false;
        }
    }

    private static String b() {
        String a2 = C7785u.a(C4151a.a, "");
        f1004a = a2;
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m1249b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            AbstractC7535b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            AbstractC7535b.a(e);
            return false;
        }
    }

    private static String c() {
        String a2 = C7785u.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f1004a = "ColorOS_" + a2;
        }
        return f1004a;
    }

    private static String d() {
        String a2 = C7785u.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f1004a = "FuntouchOS_" + a2;
        }
        return f1004a;
    }
}
