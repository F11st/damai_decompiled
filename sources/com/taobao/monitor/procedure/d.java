package com.taobao.monitor.procedure;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d {
    private final IProcedure a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private boolean a;
        private boolean b;
        private boolean c;
        private IProcedure d;
        private boolean e;

        public d f() {
            return new d(this);
        }

        public b g(boolean z) {
            this.b = z;
            return this;
        }

        public b h(IProcedure iProcedure) {
            this.d = iProcedure;
            return this;
        }

        public b i(boolean z) {
            this.c = z;
            return this;
        }

        public b j(boolean z) {
            this.e = z;
            return this;
        }

        public b k(boolean z) {
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

    private d(b bVar) {
        this.e = bVar.e;
        this.c = bVar.b;
        this.a = bVar.d;
        this.d = bVar.c;
        this.b = bVar.a;
    }
}
