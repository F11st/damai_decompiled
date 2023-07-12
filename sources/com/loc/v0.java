package com.loc;

import android.os.SystemClock;
import com.loc.u0;
import java.util.List;
import tb.m53;
import tb.p63;
import tb.s63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v0 {
    private static volatile v0 f;
    private static Object g = new Object();
    private s63 c;
    private s63 e = new s63();
    private u0 a = new u0();
    private w0 b = new w0();
    private C5876r0 d = new C5876r0();

    /* compiled from: Taobao */
    /* renamed from: com.loc.v0$a */
    /* loaded from: classes10.dex */
    public static class C5895a {
        public s63 a;
        public List<y0> b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public String h;
        public List<dr> i;
        public boolean j;
    }

    private v0() {
    }

    public static v0 a() {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = new v0();
                }
            }
        }
        return f;
    }

    public final m53 b(C5895a c5895a) {
        m53 m53Var = null;
        if (c5895a == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        s63 s63Var = this.c;
        if (s63Var == null || c5895a.a.a(s63Var) >= 10.0d) {
            u0.C5885a a = this.a.a(c5895a.a, c5895a.j, c5895a.g, c5895a.h, c5895a.i);
            List<y0> b = this.b.b(c5895a.a, c5895a.b, c5895a.e, c5895a.d, currentTimeMillis);
            if (a != null || b != null) {
                p63.a(this.e, c5895a.a, c5895a.f, currentTimeMillis);
                m53Var = new m53(0, this.d.f(this.e, a, c5895a.c, b));
            }
            this.c = c5895a.a;
        }
        return m53Var;
    }
}
