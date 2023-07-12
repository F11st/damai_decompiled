package com.amap.api.col.s;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bx {
    private static bx a;
    private final Context b;
    private final String c = ce.a(bw.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private bx(Context context) {
        this.b = context.getApplicationContext();
    }

    public static bx a(Context context) {
        if (a == null) {
            synchronized (bx.class) {
                if (a == null) {
                    a = new bx(context);
                }
            }
        }
        return a;
    }

    public final synchronized void a() {
        try {
            if (bo.c() == null) {
                bo.a(cb.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        by.a(this.b).a(this.c);
        by.a(this.b).b(str);
    }
}
