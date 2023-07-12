package com.idlefish.flutterboost;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    private final String a;
    private final Map<String, Object> b;
    private final int c;
    private final String d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private String a;
        private Map<String, Object> b;
        private int c;
        private String d;
        private boolean e = true;

        public b f(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(boolean z) {
            this.e = z;
            return this;
        }

        public b i(String str) {
            this.a = str;
            return this;
        }

        public b j(int i) {
            this.c = i;
            return this;
        }

        public b k(String str) {
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

    private c(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        boolean unused = bVar.e;
    }
}
