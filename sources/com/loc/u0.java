package com.loc;

import android.os.SystemClock;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.ArrayList;
import java.util.List;
import tb.o63;
import tb.s63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class u0 {
    private dr a;
    private dr b;
    private s63 c;
    private a d = new a();
    private final List<dr> e = new ArrayList(3);

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public byte a;
        public String b;
        public dr c;
        public dr d;
        public dr e;
        public List<dr> f = new ArrayList();
        public List<dr> g = new ArrayList();

        public static boolean c(dr drVar, dr drVar2) {
            if (drVar == null || drVar2 == null) {
                return (drVar == null) == (drVar2 == null);
            } else if ((drVar instanceof dt) && (drVar2 instanceof dt)) {
                dt dtVar = (dt) drVar;
                dt dtVar2 = (dt) drVar2;
                return dtVar.j == dtVar2.j && dtVar.k == dtVar2.k;
            } else if ((drVar instanceof ds) && (drVar2 instanceof ds)) {
                ds dsVar = (ds) drVar;
                ds dsVar2 = (ds) drVar2;
                return dsVar.l == dsVar2.l && dsVar.k == dsVar2.k && dsVar.j == dsVar2.j;
            } else if ((drVar instanceof du) && (drVar2 instanceof du)) {
                du duVar = (du) drVar;
                du duVar2 = (du) drVar2;
                return duVar.j == duVar2.j && duVar.k == duVar2.k;
            } else {
                if ((drVar instanceof dv) && (drVar2 instanceof dv)) {
                    dv dvVar = (dv) drVar;
                    dv dvVar2 = (dv) drVar2;
                    if (dvVar.j == dvVar2.j && dvVar.k == dvVar2.k) {
                        return true;
                    }
                }
                return false;
            }
        }

        public final void a() {
            this.a = (byte) 0;
            this.b = "";
            this.c = null;
            this.d = null;
            this.e = null;
            this.f.clear();
            this.g.clear();
        }

        public final void b(byte b, String str, List<dr> list) {
            a();
            this.a = b;
            this.b = str;
            if (list != null) {
                this.f.addAll(list);
                for (dr drVar : this.f) {
                    boolean z = drVar.i;
                    if (!z && drVar.h) {
                        this.d = drVar;
                    } else if (z && drVar.h) {
                        this.e = drVar;
                    }
                }
            }
            dr drVar2 = this.d;
            if (drVar2 == null) {
                drVar2 = this.e;
            }
            this.c = drVar2;
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.a) + ", operator='" + this.b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }
    }

    private void b(a aVar) {
        synchronized (this.e) {
            for (dr drVar : aVar.f) {
                if (drVar != null && drVar.h) {
                    dr clone = drVar.clone();
                    clone.e = SystemClock.elapsedRealtime();
                    c(clone);
                }
            }
            this.d.g.clear();
            this.d.g.addAll(this.e);
        }
    }

    private void c(dr drVar) {
        if (drVar == null) {
            return;
        }
        int size = this.e.size();
        if (size != 0) {
            long j = AbsPerformance.LONG_NIL;
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            while (true) {
                if (i >= size) {
                    i2 = i3;
                    break;
                }
                dr drVar2 = this.e.get(i);
                if (drVar.equals(drVar2)) {
                    int i4 = drVar.c;
                    if (i4 != drVar2.c) {
                        drVar2.e = i4;
                        drVar2.c = i4;
                    }
                } else {
                    j = Math.min(j, drVar2.e);
                    if (j == drVar2.e) {
                        i3 = i;
                    }
                    i++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (size >= 3) {
                if (drVar.e <= j || i2 >= size) {
                    return;
                }
                this.e.remove(i2);
                this.e.add(drVar);
                return;
            }
        }
        this.e.add(drVar);
    }

    private boolean d(s63 s63Var) {
        float f = s63Var.e;
        return s63Var.a(this.c) > ((double) ((f > 10.0f ? 1 : (f == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f > 2.0f ? 1 : (f == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a a(s63 s63Var, boolean z, byte b, String str, List<dr> list) {
        if (z) {
            this.d.a();
            return null;
        }
        this.d.b(b, str, list);
        if (this.d.c == null) {
            return null;
        }
        if (this.c == null || d(s63Var) || !a.c(this.d.d, this.a) || !a.c(this.d.e, this.b)) {
            a aVar = this.d;
            this.a = aVar.d;
            this.b = aVar.e;
            this.c = s63Var;
            o63.c(aVar.f);
            b(this.d);
            return this.d;
        }
        return null;
    }
}
