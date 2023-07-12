package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ir {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    private static WeakReference<C4593in> d = null;
    private static int e = 10;

    @Deprecated
    public static synchronized void a(int i, boolean z) {
        synchronized (ir.class) {
            a = i;
            b = z;
        }
    }

    public static synchronized void a(final iq iqVar, final Context context) {
        synchronized (ir.class) {
            hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.ir.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (ir.class) {
                            String l = Long.toString(System.currentTimeMillis());
                            C4593in a2 = iu.a(ir.d);
                            iu.a(context, a2, hb.i, ir.a, 2097152, "6");
                            if (a2.e == null) {
                                a2.e = new hu(new hw(new hx(new hw())));
                            }
                            C4594io.a(l, iqVar.a(), a2);
                        }
                    } catch (Throwable th) {
                        hd.c(th, "ofm", "aple");
                    }
                }
            });
        }
    }

    public static void a(final Context context) {
        hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.ir.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4593in a2 = iu.a(ir.d);
                    iu.a(context, a2, hb.i, ir.a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        a2.g = new iy(new ix(context, new jc(), new hu(new hw(new hx())), new String(gy.a(10)), C4554gc.f(context), gg.w(context), gg.n(context), gg.i(context), gg.a(), Build.getMANUFACTURER(), android.os.Build.DEVICE, gg.y(context), C4554gc.c(context), Build.getMODEL(), C4554gc.d(context), C4554gc.b(context)));
                    }
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    Context context2 = context;
                    a2.f = new jg(context2, a2.h, a2.i, new je(context2, ir.b, ir.e * 1024, ir.c * 1024, "offLocKey"));
                    C4594io.a(a2);
                } catch (Throwable th) {
                    hd.c(th, "ofm", "uold");
                }
            }
        });
    }
}
