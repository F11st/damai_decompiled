package com.amap.api.col.s;

import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.ae */
/* loaded from: classes10.dex */
public class C4373ae {
    private static volatile C4373ae a;
    private HashMap<String, af> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.ae$a */
    /* loaded from: classes10.dex */
    public static class C4374a {
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
    /* renamed from: com.amap.api.col.s.ae$b */
    /* loaded from: classes10.dex */
    public static class C4375b {
        String a;
        Object b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C4375b.class == obj.getClass()) {
                C4375b c4375b = (C4375b) obj;
                String str = this.a;
                if (str == null) {
                    return c4375b.a == null && this.b == c4375b.b;
                } else if (str.equals(c4375b.a) && this.b == c4375b.b) {
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
    /* renamed from: com.amap.api.col.s.ae$c */
    /* loaded from: classes10.dex */
    public static class C4376c {
        Object a;
        boolean b;

        public C4376c(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }
    }

    public static C4373ae a() {
        if (a == null) {
            synchronized (C4373ae.class) {
                if (a == null) {
                    a = new C4373ae();
                }
            }
        }
        return a;
    }

    public final boolean b(C4375b c4375b) {
        if (c4375b == null) {
            return false;
        }
        for (af afVar : this.b.values()) {
            if (afVar != null && afVar.b(c4375b)) {
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

    public final C4376c a(C4375b c4375b) {
        C4376c a2;
        if (c4375b == null) {
            return null;
        }
        for (af afVar : this.b.values()) {
            if (afVar != null && (a2 = afVar.a(c4375b)) != null) {
                return a2;
            }
        }
        return null;
    }

    public final void a(C4375b c4375b, Object obj) {
        for (af afVar : this.b.values()) {
            if (afVar != null) {
                afVar.a(c4375b, obj);
            }
        }
    }

    public final void a(C4374a c4374a) {
        if (c4374a == null) {
            return;
        }
        for (af afVar : this.b.values()) {
            if (afVar != null) {
                afVar.a(c4374a);
            }
        }
    }

    public final void a(String str, C4374a c4374a) {
        af afVar;
        if (str == null || c4374a == null || (afVar = this.b.get(str)) == null) {
            return;
        }
        afVar.a(c4374a);
    }
}
