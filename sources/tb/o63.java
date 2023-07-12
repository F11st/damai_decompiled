package tb;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class o63 {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements com.loc.dl {
        private int a;
        private int b;
        private int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.loc.dl
        public final long a() {
            return o63.a(this.a, this.b);
        }

        @Override // com.loc.dl
        public final int b() {
            return this.c;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b implements com.loc.dl {
        private long a;
        private int b;

        b(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // com.loc.dl
        public final long a() {
            return this.a;
        }

        @Override // com.loc.dl
        public final int b() {
            return this.b;
        }
    }

    public static long a(int i, int i2) {
        return (i2 & 4294967295L) | ((i & 4294967295L) << 32);
    }

    public static synchronized short b(long j) {
        short b2;
        synchronized (o63.class) {
            b2 = n63.a().b(j);
        }
        return b2;
    }

    public static synchronized void c(List<com.loc.dr> list) {
        a aVar;
        synchronized (o63.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (com.loc.dr drVar : list) {
                        if (drVar instanceof com.loc.dt) {
                            com.loc.dt dtVar = (com.loc.dt) drVar;
                            aVar = new a(dtVar.j, dtVar.k, dtVar.c);
                        } else if (drVar instanceof com.loc.du) {
                            com.loc.du duVar = (com.loc.du) drVar;
                            aVar = new a(duVar.j, duVar.k, duVar.c);
                        } else if (drVar instanceof com.loc.dv) {
                            com.loc.dv dvVar = (com.loc.dv) drVar;
                            aVar = new a(dvVar.j, dvVar.k, dvVar.c);
                        } else if (drVar instanceof com.loc.ds) {
                            com.loc.ds dsVar = (com.loc.ds) drVar;
                            aVar = new a(dsVar.k, dsVar.l, dsVar.c);
                        }
                        arrayList.add(aVar);
                    }
                    n63.a().d(arrayList);
                }
            }
        }
    }

    public static synchronized short d(long j) {
        short g;
        synchronized (o63.class) {
            g = n63.a().g(j);
        }
        return g;
    }

    public static synchronized void e(List<com.loc.y0> list) {
        synchronized (o63.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (com.loc.y0 y0Var : list) {
                        arrayList.add(new b(y0Var.a, y0Var.c));
                    }
                    n63.a().h(arrayList);
                }
            }
        }
    }
}
