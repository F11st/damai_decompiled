package com.amap.api.col.s;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ae {
    private static volatile ae a;
    private HashMap<String, af> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private boolean a = true;
        private long b = 86400;
        private int c = 10;
        private double d = 0.0d;

        public final boolean a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final double d() {
            return this.d;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void a(int i) {
            this.c = i;
        }

        public final void a(double d) {
            this.d = d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        String a;
        Object b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.a;
                if (str == null) {
                    return bVar.a == null && this.b == bVar.b;
                } else if (str.equals(bVar.a) && this.b == bVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c {
        Object a;
        boolean b;

        public c(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }
    }

    public static ae a() {
        if (a == null) {
            synchronized (ae.class) {
                if (a == null) {
                    a = new ae();
                }
            }
        }
        return a;
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (af afVar : this.b.values()) {
            if (afVar != null && afVar.b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized af a(String str) {
        return this.b.get(str);
    }

    public final synchronized void a(String str, af afVar) {
        this.b.put(str, afVar);
    }

    public final c a(b bVar) {
        c a2;
        if (bVar == null) {
            return null;
        }
        for (af afVar : this.b.values()) {
            if (afVar != null && (a2 = afVar.a(bVar)) != null) {
                return a2;
            }
        }
        return null;
    }

    public final void a(b bVar, Object obj) {
        for (af afVar : this.b.values()) {
            if (afVar != null) {
                afVar.a(bVar, obj);
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        for (af afVar : this.b.values()) {
            if (afVar != null) {
                afVar.a(aVar);
            }
        }
    }

    public final void a(String str, a aVar) {
        af afVar;
        if (str == null || aVar == null || (afVar = this.b.get(str)) == null) {
            return;
        }
        afVar.a(aVar);
    }
}
