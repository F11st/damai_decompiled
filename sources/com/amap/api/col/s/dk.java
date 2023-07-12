package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dk {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    static int d = 0;
    private static WeakReference<dh> e = null;
    private static int f = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends ee {
        private int a = 2;
        private Context b;
        private dj c;

        a(Context context) {
            this.b = context;
        }

        @Override // com.amap.api.col.s.ee
        public final void a() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (dk.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        dh a = dn.a(dk.e);
                        dn.a(this.b, a, cj.i, dk.a, 2097152, "6");
                        if (a.e == null) {
                            a.e = new cr(new ct(new cu(new ct())));
                        }
                        di.a(l, this.c.a(), a);
                    }
                } catch (Throwable th) {
                    cl.c(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    dh a2 = dn.a(dk.e);
                    dn.a(this.b, a2, cj.i, dk.a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        a2.g = new dr(new dq(this.b, new dv(), new cr(new ct(new cu())), new String(cf.a(10)), bk.f(this.b), bo.r(this.b), bo.k(this.b), bo.h(this.b), bo.a(), Build.getMANUFACTURER(), android.os.Build.DEVICE, bo.t(this.b), bk.c(this.b), Build.getMODEL(), bk.d(this.b), bk.b(this.b), bo.g(this.b), bo.a(this.b), String.valueOf(Build.VERSION.SDK_INT)));
                    }
                    if (TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    Context context = this.b;
                    a2.f = new dz(context, a2.h, a2.i, new dx(context, dk.b, dk.f * 1024, dk.c * 1024, "offLocKey", dk.d * 1024));
                    di.a(a2);
                } catch (Throwable th2) {
                    cl.c(th2, "ofm", "uold");
                }
            }
        }
    }

    public static void a(Context context) {
        ed.a().b(new a(context));
    }
}
