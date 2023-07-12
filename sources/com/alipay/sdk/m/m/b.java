package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.n;
import java.util.Random;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile b g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    public b() {
        String a = com.alipay.sdk.m.j.a.a();
        if (com.alipay.sdk.m.j.a.b()) {
            return;
        }
        this.b += '_' + a;
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (g == null) {
                g = new b();
            }
            bVar = g;
        }
        return bVar;
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
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b2).d())) {
                b = c();
            } else {
                b = c.b(b2).b();
            }
            String str = b;
            sharedPreferences.edit().putString(e, str).apply();
            return str;
        }
        return string;
    }

    public static String g() {
        String c;
        Context b = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = b.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b).d())) {
                String c2 = com.alipay.sdk.m.s.b.d().c();
                if (!TextUtils.isEmpty(c2) && c2.length() >= 18) {
                    c = c2.substring(3, 18);
                } else {
                    c = c();
                }
            } else {
                c = c.b(b).c();
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
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.i, str).apply();
            com.alipay.sdk.m.l.a.e = str;
        }
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context, boolean z) {
        if (z) {
            return "-1";
        }
        try {
            WifiInfo d2 = com.alipay.sdk.m.w.b.d(aVar, context);
            return d2 != null ? d2.getSSID() : "-1";
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "lacking_per_1", th);
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

    public String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.t.a aVar2, boolean z) {
        Context b = com.alipay.sdk.m.s.b.d().b();
        c b2 = c.b(b);
        if (TextUtils.isEmpty(this.a)) {
            String f2 = n.f();
            String e2 = n.e();
            String c = n.c(b);
            String e3 = n.e(b);
            String f3 = n.f(b);
            String a = a(b);
            this.a = "Msp/15.8.11 (" + f2 + ";" + e2 + ";" + c + ";" + e3 + ";" + f3 + ";" + a;
        }
        String b3 = c.d(b).b();
        String b4 = n.b(b);
        String e4 = e();
        String c2 = b2.c();
        String b5 = b2.b();
        String g2 = g();
        String f4 = f();
        if (aVar2 != null) {
            this.c = aVar2.c();
        }
        String replace = Build.getMANUFACTURER().replace(";", " ");
        String replace2 = Build.getMODEL().replace(";", " ");
        boolean e5 = com.alipay.sdk.m.s.b.e();
        String d2 = b2.d();
        String b6 = b(aVar, b, z);
        String a2 = a(aVar, b, z);
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
        if (aVar2 != null) {
            String a3 = com.alipay.sdk.m.w.b.a(aVar, b, com.alipay.sdk.m.t.a.a(b).d(), com.alipay.sdk.m.w.b.c(aVar, b));
            if (!TextUtils.isEmpty(a3)) {
                sb.append(";;;");
                sb.append(a3);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, boolean z) {
        if (z) {
            return "00";
        }
        try {
            WifiInfo d2 = com.alipay.sdk.m.w.b.d(aVar, context);
            return d2 != null ? d2.getBSSID() : "00";
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "lacking_per_2", th);
            return "00";
        }
    }
}
