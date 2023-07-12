package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class h0 {
    public static h0 b;
    public Context a;

    static {
        new HashMap();
    }

    public static h0 a() {
        return b();
    }

    public static synchronized h0 b() {
        h0 h0Var;
        synchronized (h0.class) {
            if (b == null) {
                b = new h0();
            }
            h0Var = b;
        }
        return h0Var;
    }

    public void a(Context context) {
        this.a = context;
        b(context);
        i.c().b().h(f.a());
    }

    public void a(String str, int i) {
        if (this.a == null) {
            y.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        y.c("hmsSdk", "onReport: Before calling runtaskhandler()");
        a(str, u0.a(i), b.g());
    }

    public void a(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = u0.a(RetryMonitorDbHelper.DATE_FORMAT, currentTimeMillis);
        }
        o0.c().a(new j0(str2, jSONObject, str, u0.a(i), currentTimeMillis));
    }

    public void a(String str, String str2) {
        if (!c.a(str, str2)) {
            y.c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long j = c.j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j <= 30000) {
            y.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        y.a("hmsSdk", "begin to call onReport!");
        c.a(str, str2, currentTimeMillis);
        a(str, str2, b.g());
    }

    public void a(String str, String str2, String str3) {
        Context context = this.a;
        if (context == null) {
            y.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String a = h.a(context);
        if (c.e(str, str2) && !"WIFI".equals(a)) {
            y.c("hmsSdk", "strNetworkType is :" + a);
        } else if (TextUtils.isEmpty(a) || "2G".equals(a)) {
            y.e("hmsSdk", "The network is bad.");
        } else {
            o0.c().a(new k0(str, str2, str3));
        }
    }

    public final void b(Context context) {
        String str;
        String d = f.d(context);
        b.a(d);
        if (w0.b().a()) {
            String a = g0.a(context, "global_v2", "app_ver", "");
            g0.b(context, "global_v2", "app_ver", d);
            b.b(a);
            if (!TextUtils.isEmpty(a)) {
                if (a.equals(d)) {
                    return;
                }
                y.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        y.c("hmsSdk", str);
    }
}
