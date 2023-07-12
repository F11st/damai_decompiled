package com.huawei.hms.hatool;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class h1 {
    public static h1 b;
    public static final Object c = new Object();
    public Context a;

    public static h1 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static synchronized void b() {
        synchronized (h1.class) {
            if (b == null) {
                b = new h1();
            }
        }
    }

    public void a(Context context) {
        synchronized (c) {
            if (this.a != null) {
                y.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.a = context;
            i.c().b().a(this.a);
            i.c().b().j(context.getPackageName());
            z0.a().a(context);
        }
    }

    public void a(String str) {
        y.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.a;
        if (context == null) {
            y.e("hmsSdk", "sdk is not init");
            return;
        }
        i.c().b().i(s0.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
