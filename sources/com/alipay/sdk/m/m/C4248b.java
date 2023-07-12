package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.j.C4211a;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.l.C4231b;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.t.C4296a;
import com.alipay.sdk.m.u.C4300c;
import com.alipay.sdk.m.u.C4318n;
import com.alipay.sdk.m.w.C4325b;
import java.util.Random;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.m.b */
/* loaded from: classes12.dex */
public class C4248b {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile C4248b g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    public C4248b() {
        String a = C4211a.a();
        if (C4211a.b()) {
            return;
        }
        this.b += '_' + a;
    }

    public static synchronized C4248b b() {
        C4248b c4248b;
        synchronized (C4248b.class) {
            if (g == null) {
                g = new C4248b();
            }
            c4248b = g;
        }
        return c4248b;
    }

    public static String c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        String b;
        Context b2 = C4295b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(C4296a.a(b2).d())) {
                b = c();
            } else {
                b = C4300c.b(b2).b();
            }
            String str = b;
            sharedPreferences.edit().putString(e, str).apply();
            return str;
        }
        return string;
    }

    public static String g() {
        String c;
        Context b = C4295b.d().b();
        SharedPreferences sharedPreferences = b.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(C4296a.a(b).d())) {
                String c2 = C4295b.d().c();
                if (!TextUtils.isEmpty(c2) && c2.length() >= 18) {
                    c = c2.substring(3, 18);
                } else {
                    c = c();
                }
            } else {
                c = C4300c.b(b).c();
            }
            String str = c;
            sharedPreferences.edit().putString(f, str).apply();
            return str;
        }
        return string;
    }

    public String a() {
        return this.c;
    }

    public static synchronized void a(String str) {
        synchronized (C4248b.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            PreferenceManager.getDefaultSharedPreferences(C4295b.d().b()).edit().putString(C4231b.i, str).apply();
            C4230a.e = str;
        }
    }

    public static String b(C4293a c4293a, Context context, boolean z) {
        if (z) {
            return "-1";
        }
        try {
            WifiInfo d2 = C4325b.d(c4293a, context);
            return d2 != null ? d2.getSSID() : "-1";
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, "lacking_per_1", th);
            return "-1";
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public static String b(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                sb.append(jn1.BRACKET_START_STR);
                sb.append(packageName);
                sb.append(";");
                sb.append(packageInfo.versionCode);
                sb.append(jn1.BRACKET_END_STR);
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public String a(C4293a c4293a, C4296a c4296a, boolean z) {
        Context b = C4295b.d().b();
        C4300c b2 = C4300c.b(b);
        if (TextUtils.isEmpty(this.a)) {
            String f2 = C4318n.f();
            String e2 = C4318n.e();
            String c = C4318n.c(b);
            String e3 = C4318n.e(b);
            String f3 = C4318n.f(b);
            String a = a(b);
            this.a = "Msp/15.8.11 (" + f2 + ";" + e2 + ";" + c + ";" + e3 + ";" + f3 + ";" + a;
        }
        String b3 = C4300c.d(b).b();
        String b4 = C4318n.b(b);
        String e4 = e();
        String c2 = b2.c();
        String b5 = b2.b();
        String g2 = g();
        String f4 = f();
        if (c4296a != null) {
            this.c = c4296a.c();
        }
        String replace = Build.getMANUFACTURER().replace(";", " ");
        String replace2 = Build.getMODEL().replace(";", " ");
        boolean e5 = C4295b.e();
        String d2 = b2.d();
        String b6 = b(c4293a, b, z);
        String a2 = a(c4293a, b, z);
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(";");
        sb.append(b3);
        sb.append(";");
        sb.append(b4);
        sb.append(";");
        sb.append(e4);
        sb.append(";");
        sb.append(c2);
        sb.append(";");
        sb.append(b5);
        sb.append(";");
        sb.append(this.c);
        sb.append(";");
        sb.append(replace);
        sb.append(";");
        sb.append(replace2);
        sb.append(";");
        sb.append(e5);
        sb.append(";");
        sb.append(d2);
        sb.append(";");
        sb.append(d());
        sb.append(";");
        sb.append(this.b);
        sb.append(";");
        sb.append(g2);
        sb.append(";");
        sb.append(f4);
        sb.append(";");
        sb.append(b6);
        sb.append(";");
        sb.append(a2);
        if (c4296a != null) {
            String a3 = C4325b.a(c4293a, b, C4296a.a(b).d(), C4325b.c(c4293a, b));
            if (!TextUtils.isEmpty(a3)) {
                sb.append(";;;");
                sb.append(a3);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }

    public static String a(C4293a c4293a, Context context, boolean z) {
        if (z) {
            return "00";
        }
        try {
            WifiInfo d2 = C4325b.d(c4293a, context);
            return d2 != null ? d2.getBSSID() : "00";
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, "lacking_per_2", th);
            return "00";
        }
    }
}
