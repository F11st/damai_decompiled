package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.ip */
/* loaded from: classes10.dex */
public class C4595ip {
    static WeakReference<C4593in> a;

    public static void a(final String str, final Context context) {
        hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.ip.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (C4595ip.class) {
                    try {
                        String a2 = gk.a(gn.a(str));
                        C4593in a3 = iu.a(C4595ip.a);
                        iu.a(context, a3, hb.j, 50, 102400, "10");
                        if (a3.e == null) {
                            a3.e = new hu(new hx(new hw()));
                        }
                        String a4 = gn.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                        C4594io.a(a2, gn.a(" \"timestamp\":\"" + a4 + "\",\"details\":" + str), a3);
                    }
                }
            }
        });
    }
}
