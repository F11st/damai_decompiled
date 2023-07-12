package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.h0 */
/* loaded from: classes10.dex */
public class C5623h0 {
    public static C5623h0 b;
    public Context a;

    static {
        new HashMap();
    }

    public static C5623h0 a() {
        return b();
    }

    public static synchronized C5623h0 b() {
        C5623h0 c5623h0;
        synchronized (C5623h0.class) {
            if (b == null) {
                b = new C5623h0();
            }
            c5623h0 = b;
        }
        return c5623h0;
    }

    public void a(Context context) {
        this.a = context;
        b(context);
        C5624i.c().b().h(AbstractC5616f.a());
    }

    public void a(String str, int i) {
        if (this.a == null) {
            C5653y.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        C5653y.c("hmsSdk", "onReport: Before calling runtaskhandler()");
        a(str, u0.a(i), AbstractC5607b.g());
    }

    public void a(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = u0.a(RetryMonitorDbHelper.DATE_FORMAT, currentTimeMillis);
        }
        C5637o0.c().a(new C5627j0(str2, jSONObject, str, u0.a(i), currentTimeMillis));
    }

    public void a(String str, String str2) {
        if (!AbstractC5609c.a(str, str2)) {
            C5653y.c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long j = AbstractC5609c.j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j <= 30000) {
            C5653y.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        C5653y.a("hmsSdk", "begin to call onReport!");
        AbstractC5609c.a(str, str2, currentTimeMillis);
        a(str, str2, AbstractC5607b.g());
    }

    public void a(String str, String str2, String str3) {
        Context context = this.a;
        if (context == null) {
            C5653y.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String a = C5622h.a(context);
        if (AbstractC5609c.e(str, str2) && !"WIFI".equals(a)) {
            C5653y.c("hmsSdk", "strNetworkType is :" + a);
        } else if (TextUtils.isEmpty(a) || "2G".equals(a)) {
            C5653y.e("hmsSdk", "The network is bad.");
        } else {
            C5637o0.c().a(new C5629k0(str, str2, str3));
        }
    }

    public final void b(Context context) {
        String str;
        String d = AbstractC5616f.d(context);
        AbstractC5607b.a(d);
        if (w0.b().a()) {
            String a = C5621g0.a(context, "global_v2", "app_ver", "");
            C5621g0.b(context, "global_v2", "app_ver", d);
            AbstractC5607b.b(a);
            if (!TextUtils.isEmpty(a)) {
                if (a.equals(d)) {
                    return;
                }
                C5653y.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        C5653y.c("hmsSdk", str);
    }
}
