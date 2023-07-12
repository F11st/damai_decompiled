package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.m.n.C4250a;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tb.gn1;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.m */
/* loaded from: classes11.dex */
public class C7688m {
    private static volatile int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, EnumC7693q> f810a = null;
    private static int b = -1;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a() {
        /*
            int r0 = com.xiaomi.push.C7688m.a
            if (r0 != 0) goto L47
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = m1116a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            r2 = 1
            if (r1 == 0) goto L21
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = m1116a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == 0) goto L25
            goto L26
        L25:
            r2 = 2
        L26:
            com.xiaomi.push.C7688m.a = r2     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.a(r2, r1)
            com.xiaomi.push.C7688m.a = r0
        L31:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = com.xiaomi.push.C7688m.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.b(r0)
        L47:
            int r0 = com.xiaomi.push.C7688m.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C7688m.a():int");
    }

    public static int a(Context context) {
        String m1116a = m1116a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(m1116a) || !TextUtils.isDigitsOnly(m1116a)) {
            return 0;
        }
        return Integer.parseInt(m1116a);
    }

    public static EnumC7693q a(String str) {
        EnumC7693q b2 = b(str);
        return b2 == null ? EnumC7693q.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m1115a() {
        int a2 = C7786v.a();
        return (!m1118a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : Constants.Name.STABLE;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        String a2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
                sb.append(str);
                sb.append(C4250a.h);
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a2 = a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m1116a(String str) {
        try {
            try {
                return (String) bk.a("android.os.SystemProperties", gn1.TYPE_OPEN_URL_METHOD_GET, str, "");
            } catch (Exception e) {
                AbstractC7535b.d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m1117a() {
        if (f810a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f810a = hashMap;
        hashMap.put("CN", EnumC7693q.China);
        Map<String, EnumC7693q> map = f810a;
        EnumC7693q enumC7693q = EnumC7693q.Europe;
        map.put("FI", enumC7693q);
        f810a.put("SE", enumC7693q);
        f810a.put("NO", enumC7693q);
        f810a.put("FO", enumC7693q);
        f810a.put("EE", enumC7693q);
        f810a.put("LV", enumC7693q);
        f810a.put("LT", enumC7693q);
        f810a.put("BY", enumC7693q);
        f810a.put("MD", enumC7693q);
        f810a.put("UA", enumC7693q);
        f810a.put("PL", enumC7693q);
        f810a.put("CZ", enumC7693q);
        f810a.put("SK", enumC7693q);
        f810a.put("HU", enumC7693q);
        f810a.put("DE", enumC7693q);
        f810a.put("AT", enumC7693q);
        f810a.put("CH", enumC7693q);
        f810a.put("LI", enumC7693q);
        f810a.put("GB", enumC7693q);
        f810a.put("IE", enumC7693q);
        f810a.put("NL", enumC7693q);
        f810a.put("BE", enumC7693q);
        f810a.put("LU", enumC7693q);
        f810a.put("FR", enumC7693q);
        f810a.put("RO", enumC7693q);
        f810a.put("BG", enumC7693q);
        f810a.put("RS", enumC7693q);
        f810a.put("MK", enumC7693q);
        f810a.put("AL", enumC7693q);
        f810a.put("GR", enumC7693q);
        f810a.put("SI", enumC7693q);
        f810a.put("HR", enumC7693q);
        f810a.put("IT", enumC7693q);
        f810a.put("SM", enumC7693q);
        f810a.put("MT", enumC7693q);
        f810a.put("ES", enumC7693q);
        f810a.put("PT", enumC7693q);
        f810a.put("AD", enumC7693q);
        f810a.put("CY", enumC7693q);
        f810a.put("DK", enumC7693q);
        f810a.put("IS", enumC7693q);
        f810a.put("UK", enumC7693q);
        f810a.put("EL", enumC7693q);
        f810a.put("RU", EnumC7693q.Russia);
        f810a.put("IN", EnumC7693q.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1118a() {
        return a() == 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1119a(Context context) {
        return context != null && m1120a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1120a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static EnumC7693q b(String str) {
        m1117a();
        return f810a.get(str.toUpperCase());
    }

    public static String b() {
        String a2 = C7785u.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = m1121b(C7785u.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = C7785u.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            AbstractC7535b.m586a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            AbstractC7535b.m586a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    private static String m1121b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split("-");
        return split.length > 0 ? split[0] : str;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m1122b() {
        return a() == 2;
    }

    public static String c() {
        return m1116a("ro.miui.ui.version.name");
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m1123c() {
        if (b < 0) {
            b = !m1125e() ? 1 : 0;
        }
        return b > 0;
    }

    public static String d() {
        return m1116a("ro.build.characteristics");
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m1124d() {
        return !EnumC7693q.China.name().equalsIgnoreCase(a(b()).name());
    }

    public static String e() {
        return m1116a("ro.product.manufacturer");
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m1125e() {
        String str = "";
        try {
            str = C7785u.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }
}
