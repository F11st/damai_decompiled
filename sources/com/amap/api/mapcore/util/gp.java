package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gp {
    private static gp a;
    private final Context b;
    private final String c = gw.a(gn.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    public gp(Context context) {
        this.b = context.getApplicationContext();
    }

    public static gp a(Context context) {
        if (a == null) {
            synchronized (gp.class) {
                if (a == null) {
                    a = new gp(context);
                }
            }
        }
        return a;
    }

    public void a(String str) {
        gq.a(this.b).a(this.c);
        gq.a(this.b).b(str);
    }
}
