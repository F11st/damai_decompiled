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
    private r0 d = new r0();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
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

    public final m53 b(a aVar) {
        m53 m53Var = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        s63 s63Var = this.c;
        if (s63Var == null || aVar.a.a(s63Var) >= 10.0d) {
            u0.a a2 = this.a.a(aVar.a, aVar.j, aVar.g, aVar.h, aVar.i);
            List<y0> b = this.b.b(aVar.a, aVar.b, aVar.e, aVar.d, currentTimeMillis);
            if (a2 != null || b != null) {
                p63.a(this.e, aVar.a, aVar.f, currentTimeMillis);
                m53Var = new m53(0, this.d.f(this.e, a2, aVar.c, b));
            }
            this.c = aVar.a;
        }
        return m53Var;
    }
}
