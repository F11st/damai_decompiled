package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kq {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements ko {
        private int a;
        private int b;
        private int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.amap.api.mapcore.util.ko
        public final long a() {
            return kq.a(this.a, this.b);
        }

        @Override // com.amap.api.mapcore.util.ko
        public final int b() {
            return this.c;
        }
    }

    public static long a(int i, int i2) {
        return (i2 & 4294967295L) | ((i & 4294967295L) << 32);
    }

    public static synchronized void a(List<ks> list) {
        a aVar;
        synchronized (kq.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ks ksVar : list) {
                        if (ksVar instanceof ku) {
                            ku kuVar = (ku) ksVar;
                            aVar = new a(kuVar.j, kuVar.k, kuVar.c);
                        } else if (ksVar instanceof kv) {
                            kv kvVar = (kv) ksVar;
                            aVar = new a(kvVar.j, kvVar.k, kvVar.c);
                        } else if (ksVar instanceof kw) {
                            kw kwVar = (kw) ksVar;
                            aVar = new a(kwVar.j, kwVar.k, kwVar.c);
                        } else if (ksVar instanceof kt) {
                            kt ktVar = (kt) ksVar;
                            aVar = new a(ktVar.k, ktVar.l, ktVar.c);
                        }
                        arrayList.add(aVar);
                    }
                    kp.a().a(arrayList);
                }
            }
        }
    }
}
