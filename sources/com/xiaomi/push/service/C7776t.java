package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.huawei.hms.opendevice.AbstractC5658c;
import com.xiaomi.push.C7667h;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.C7787w;
import com.xiaomi.push.service.bg;
import java.util.Locale;
import tb.tx0;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.t */
/* loaded from: classes11.dex */
public class C7776t {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f996a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public C7776t(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f996a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }

    private static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (TextUtils.isEmpty(null)) {
                String m1116a = C7688m.m1116a("ro.miui.region");
                return TextUtils.isEmpty(m1116a) ? C7688m.m1116a("ro.product.locale.region") : m1116a;
            }
            return null;
        }
        return C7688m.b();
    }

    public static boolean a() {
        try {
            return C7786v.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1237a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public bg.C7737b a(XMPushService xMPushService) {
        bg.C7737b c7737b = new bg.C7737b(xMPushService);
        a(c7737b, xMPushService, xMPushService.m1152b(), AbstractC5658c.a);
        return c7737b;
    }

    public bg.C7737b a(bg.C7737b c7737b, Context context, C7759j c7759j, String str) {
        c7737b.f925a = context.getPackageName();
        c7737b.f928b = this.f996a;
        c7737b.h = this.c;
        c7737b.c = this.b;
        c7737b.g = "5";
        c7737b.d = "XMPUSH-PASS";
        c7737b.f927a = false;
        C7787w.C7788a c7788a = new C7787w.C7788a();
        c7788a.a("sdk_ver", 48).a("cpvn", "4_9_1").a("cpvc", 40091).a(RegistConstants.REGISTER_COUNTRY_CODE, C7718a.a(context).b()).a(RegistConstants.REGION_INFO, C7718a.a(context).a()).a("miui_vn", C7688m.c()).a("miui_vc", Integer.valueOf(C7688m.a(context))).a("xmsf_vc", Integer.valueOf(C7667h.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(ax.m1181a(context))).a("systemui_vc", Integer.valueOf(C7667h.a(context)));
        String a = a(context);
        if (!TextUtils.isEmpty(a)) {
            c7788a.a("latest_country_code", a);
        }
        String d = C7688m.d();
        if (!TextUtils.isEmpty(d)) {
            c7788a.a("device_ch", d);
        }
        String e = C7688m.e();
        if (!TextUtils.isEmpty(e)) {
            c7788a.a("device_mfr", e);
        }
        c7737b.e = c7788a.toString();
        String str2 = b(context) ? "1000271" : this.d;
        C7787w.C7788a c7788a2 = new C7787w.C7788a();
        c7788a2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m1237a(context)) {
            c7788a2.a(tx0.VALUE_MODEL_DEFAULT, str);
        }
        c7737b.f = c7788a2.toString();
        c7737b.f924a = c7759j;
        return c7737b;
    }
}
