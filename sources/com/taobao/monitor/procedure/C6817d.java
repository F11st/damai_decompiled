package com.taobao.monitor.procedure;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.procedure.d */
/* loaded from: classes11.dex */
public class C6817d {
    private final IProcedure a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.procedure.d$b */
    /* loaded from: classes11.dex */
    public static class C6819b {
        private boolean a;
        private boolean b;
        private boolean c;
        private IProcedure d;
        private boolean e;

        public C6817d f() {
            return new C6817d(this);
        }

        public C6819b g(boolean z) {
            this.b = z;
            return this;
        }

        public C6819b h(IProcedure iProcedure) {
            this.d = iProcedure;
            return this;
        }

        public C6819b i(boolean z) {
            this.c = z;
            return this;
        }

        public C6819b j(boolean z) {
            this.e = z;
            return this;
        }

        public C6819b k(boolean z) {
            this.a = z;
            return this;
        }
    }

    public IProcedure a() {
        return this.a;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.b;
    }

    private C6817d(C6819b c6819b) {
        this.e = c6819b.e;
        this.c = c6819b.b;
        this.a = c6819b.d;
        this.d = c6819b.c;
        this.b = c6819b.a;
    }
}
