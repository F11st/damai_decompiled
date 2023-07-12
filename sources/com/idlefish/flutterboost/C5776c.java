package com.idlefish.flutterboost;

import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.idlefish.flutterboost.c */
/* loaded from: classes10.dex */
public class C5776c {
    private final String a;
    private final Map<String, Object> b;
    private final int c;
    private final String d;

    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.c$b */
    /* loaded from: classes10.dex */
    public static class C5778b {
        private String a;
        private Map<String, Object> b;
        private int c;
        private String d;
        private boolean e = true;

        public C5778b f(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public C5776c g() {
            return new C5776c(this);
        }

        public C5778b h(boolean z) {
            this.e = z;
            return this;
        }

        public C5778b i(String str) {
            this.a = str;
            return this;
        }

        public C5778b j(int i) {
            this.c = i;
            return this;
        }

        public C5778b k(String str) {
            this.d = str;
            return this;
        }
    }

    public Map<String, Object> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    private C5776c(C5778b c5778b) {
        this.a = c5778b.a;
        this.b = c5778b.b;
        this.c = c5778b.c;
        this.d = c5778b.d;
        boolean unused = c5778b.e;
    }
}
