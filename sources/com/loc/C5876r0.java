package com.loc;

import android.os.SystemClock;
import com.loc.u0;
import java.util.List;
import tb.b73;
import tb.c63;
import tb.d63;
import tb.f63;
import tb.g63;
import tb.h63;
import tb.i63;
import tb.j63;
import tb.k63;
import tb.l63;
import tb.m63;
import tb.o53;
import tb.o63;
import tb.q53;
import tb.r53;
import tb.s63;

/* compiled from: Taobao */
/* renamed from: com.loc.r0 */
/* loaded from: classes10.dex */
public final class C5876r0 extends AbstractC5872q0 {
    public C5876r0() {
        super(2048);
    }

    private int b(long j, List<y0> list) {
        g(list);
        int size = list.size();
        if (size > 0) {
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                y0 y0Var = list.get(i);
                int b = this.a.b(y0Var.b);
                long j2 = y0Var.a;
                iArr[i] = m63.b(this.a, j2 == j && j2 != -1, j2, (short) y0Var.c, b, y0Var.g, (short) y0Var.d);
            }
            return l63.b(this.a, l63.c(this.a, iArr));
        }
        return -1;
    }

    private int c(u0.C5885a c5885a) {
        int i;
        int i2;
        s0 s0Var;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6;
        e(c5885a.f);
        int size = c5885a.f.size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            dr drVar = c5885a.f.get(i7);
            if (drVar instanceof dt) {
                dt dtVar = (dt) drVar;
                i6 = !dtVar.i ? g63.b(this.a, dtVar.j, dtVar.k, dtVar.c, dtVar.l) : g63.c(this.a, dtVar.b(), dtVar.c(), dtVar.j, dtVar.k, dtVar.c, dtVar.m, dtVar.n, dtVar.d, dtVar.l);
                i5 = -1;
                b = 1;
            } else if (drVar instanceof du) {
                du duVar = (du) drVar;
                i6 = h63.b(this.a, duVar.b(), duVar.c(), duVar.j, duVar.k, duVar.l, duVar.c, duVar.m, duVar.d);
                i5 = -1;
                b = 3;
            } else if (drVar instanceof ds) {
                ds dsVar = (ds) drVar;
                boolean z = dsVar.i;
                s0 s0Var2 = this.a;
                int i8 = dsVar.j;
                int i9 = dsVar.k;
                int i10 = dsVar.l;
                int i11 = dsVar.m;
                int i12 = dsVar.n;
                int i13 = dsVar.c;
                i6 = !z ? q53.b(s0Var2, i8, i9, i10, i11, i12, i13) : q53.c(s0Var2, i8, i9, i10, i11, i12, i13, dsVar.d);
                i5 = -1;
                b = 2;
            } else if (drVar instanceof dv) {
                dv dvVar = (dv) drVar;
                i6 = k63.b(this.a, dvVar.b(), dvVar.c(), dvVar.j, dvVar.k, dvVar.l, dvVar.c, dvVar.m, dvVar.d);
                i5 = -1;
                b = 4;
            } else {
                i5 = -1;
                b = 0;
                i6 = -1;
            }
            if (i6 == i5) {
                return i5;
            }
            iArr[i7] = d63.b(this.a, drVar.h ? (byte) 1 : (byte) 0, drVar.i ? (byte) 1 : (byte) 0, (short) drVar.g, b, i6);
        }
        int b2 = this.a.b(c5885a.b);
        int c = r53.c(this.a, iArr);
        int size2 = c5885a.g.size();
        int[] iArr2 = new int[size2];
        for (int i14 = 0; i14 < size2; i14++) {
            dr drVar2 = c5885a.g.get(i14);
            long elapsedRealtime = (SystemClock.elapsedRealtime() - drVar2.e) / 1000;
            elapsedRealtime = (elapsedRealtime > 32767 || elapsedRealtime < 0) ? 32767L : 32767L;
            if (drVar2 instanceof dt) {
                dt dtVar2 = (dt) drVar2;
                s0Var = this.a;
                i3 = dtVar2.j;
                i4 = dtVar2.k;
            } else if (drVar2 instanceof du) {
                du duVar2 = (du) drVar2;
                s0Var = this.a;
                i3 = duVar2.j;
                i4 = duVar2.k;
            } else {
                if (drVar2 instanceof ds) {
                    ds dsVar2 = (ds) drVar2;
                    i = i63.a(this.a, dsVar2.j, dsVar2.k, dsVar2.l, (short) elapsedRealtime);
                    i2 = 2;
                } else if (drVar2 instanceof dv) {
                    dv dvVar2 = (dv) drVar2;
                    s0Var = this.a;
                    i3 = dvVar2.j;
                    i4 = dvVar2.k;
                } else {
                    i = 0;
                    i2 = 0;
                }
                iArr2[i14] = c63.b(this.a, (byte) i2, i);
            }
            i = j63.a(s0Var, i3, i4, (short) elapsedRealtime);
            i2 = 1;
            iArr2[i14] = c63.b(this.a, (byte) i2, i);
        }
        return r53.b(this.a, b2, c5885a.a, c, r53.f(this.a, iArr2));
    }

    private int d(s63 s63Var) {
        long j = s63Var.h;
        int i = (int) s63Var.g;
        int i2 = (int) s63Var.e;
        short s = (short) s63Var.f;
        byte b = s63Var.i;
        return f63.b(this.a, s63Var.a, j, (int) (s63Var.c * 1000000.0d), (int) (s63Var.b * 1000000.0d), (int) s63Var.d, i, i2, s, b);
    }

    private static void e(List<dr> list) {
        int i;
        int i2;
        if (list == null || list.size() == 0) {
            return;
        }
        for (dr drVar : list) {
            if (drVar instanceof dt) {
                dt dtVar = (dt) drVar;
                i = dtVar.j;
                i2 = dtVar.k;
            } else if (drVar instanceof du) {
                du duVar = (du) drVar;
                i = duVar.j;
                i2 = duVar.k;
            } else if (drVar instanceof dv) {
                dv dvVar = (dv) drVar;
                i = dvVar.j;
                i2 = dvVar.k;
            } else if (drVar instanceof ds) {
                ds dsVar = (ds) drVar;
                i = dsVar.k;
                i2 = dsVar.l;
            }
            drVar.g = o63.b(o63.a(i, i2));
        }
    }

    private static void g(List<y0> list) {
        for (y0 y0Var : list) {
            y0Var.g = o63.d(y0Var.a);
        }
    }

    public final byte[] f(s63 s63Var, u0.C5885a c5885a, long j, List<y0> list) {
        List<dr> list2;
        super.a();
        try {
            int d = d(s63Var);
            int i = -1;
            int c = (c5885a == null || (list2 = c5885a.f) == null || list2.size() <= 0) ? -1 : c(c5885a);
            if (list != null && list.size() > 0) {
                i = b(j, list);
            }
            o53.a(this.a);
            o53.b(this.a, d);
            if (c > 0) {
                o53.e(this.a, c);
            }
            if (i > 0) {
                o53.d(this.a, i);
            }
            this.a.w(o53.c(this.a));
            return this.a.z();
        } catch (Throwable th) {
            b73.a(th);
            return null;
        }
    }
}
