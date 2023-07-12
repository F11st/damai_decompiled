package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.lang.ref.WeakReference;
import tb.g53;
import tb.i53;
import tb.u43;
import tb.w33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bq {
    static int a = 1000;
    static boolean b = false;
    private static WeakReference<u43> c = null;
    static int d = 20;
    private static int e = 10;
    static int f;

    /* compiled from: Taobao */
    /* renamed from: com.loc.bq$a */
    /* loaded from: classes10.dex */
    static class C5803a extends ck {
        private int a;
        private Context b;
        private C5807c0 c;

        C5803a(Context context, int i) {
            this.b = context;
            this.a = i;
        }

        C5803a(Context context, C5807c0 c5807c0) {
            this(context, 1);
            this.c = c5807c0;
        }

        @Override // com.loc.ck
        public final void a() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (bq.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        u43 d = C5822e0.d(bq.c);
                        C5822e0.e(this.b, d, al.i, bq.a, 2097152, "6");
                        if (d.e == null) {
                            d.e = new C5871q(new C5877s(new C5884u(new C5877s())));
                        }
                        C5792b0.c(l, this.c.b(), d);
                    }
                } catch (Throwable th) {
                    an.m(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    u43 d2 = C5822e0.d(bq.c);
                    C5822e0.e(this.b, d2, al.i, bq.a, 2097152, "6");
                    d2.h = 14400000;
                    if (d2.g == null) {
                        d2.g = new C5840i0(new C5837h0(this.b, new C5860n0(), new C5871q(new C5877s(new C5884u())), new String(w33.c(10)), C5846l.j(this.b), C5861o.h0(this.b), C5861o.W(this.b), C5861o.R(this.b), C5861o.v(), Build.getMANUFACTURER(), android.os.Build.DEVICE, C5861o.k0(this.b), C5846l.g(this.b), Build.getMODEL(), C5846l.h(this.b), C5846l.e(this.b), C5861o.Q(this.b), C5861o.w(this.b), String.valueOf(Build.VERSION.SDK_INT)));
                    }
                    if (TextUtils.isEmpty(d2.i)) {
                        d2.i = "fKey";
                    }
                    Context context = this.b;
                    d2.f = new i53(context, d2.h, d2.i, new g53(context, bq.b, bq.e * 1024, bq.d * 1024, "offLocKey", bq.f * 1024));
                    C5792b0.a(d2);
                } catch (Throwable th2) {
                    an.m(th2, "ofm", "uold");
                }
            }
        }
    }

    public static synchronized void b(int i, boolean z, int i2, int i3) {
        synchronized (bq.class) {
            a = i;
            b = z;
            i2 = (i2 < 10 || i2 > 100) ? 20 : 20;
            d = i2;
            if (i2 / 5 > e) {
                e = i2 / 5;
            }
            f = i3;
        }
    }

    public static void c(Context context) {
        C5866o0.f().d(new C5803a(context, 2));
    }

    public static synchronized void d(C5807c0 c5807c0, Context context) {
        synchronized (bq.class) {
            C5866o0.f().d(new C5803a(context, c5807c0));
        }
    }
}
