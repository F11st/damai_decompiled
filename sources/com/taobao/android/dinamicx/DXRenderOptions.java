package com.taobao.android.dinamicx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import tb.c20;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXRenderOptions {
    public static final int NORMAL = 0;
    public static final int PRE_FETCH = 1;
    public static final int PRE_RENDER = 2;
    public static final int SIMPLE = 3;
    private int a;
    private int b;
    private c20 c;
    @Deprecated
    private Object d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private Map<String, String> j;
    public static final DXRenderOptions DEFAULT_RENDER_OPTIONS = new C6359b().k();
    public static final DXRenderOptions DEFAULT_PRERENDER_OPTIONS = new C6359b().r(2).s(8).k();

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXRenderType {
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.DXRenderOptions$b */
    /* loaded from: classes12.dex */
    public static final class C6359b {
        private c20 c;
        private Object d;
        private boolean e;
        private boolean f;
        private int g;
        private Map<String, String> j;
        private int a = z00.f();
        private int b = z00.e();
        private int h = 0;
        private int i = 8;

        public DXRenderOptions k() {
            return new DXRenderOptions(this);
        }

        public C6359b l(int i) {
            this.h = i;
            return this;
        }

        public C6359b m(int i) {
            this.b = i;
            return this;
        }

        public C6359b n(boolean z) {
            this.f = z;
            return this;
        }

        public C6359b o(boolean z) {
            this.e = z;
            return this;
        }

        public C6359b p(Object obj) {
            this.d = obj;
            return this;
        }

        public C6359b q(Map<String, String> map) {
            this.j = map;
            return this;
        }

        public C6359b r(int i) {
            this.g = i;
            return this;
        }

        public C6359b s(int i) {
            this.i = i;
            return this;
        }

        public C6359b t(c20 c20Var) {
            return this;
        }

        public C6359b u(int i) {
            this.a = i;
            return this;
        }
    }

    public int a() {
        return this.h;
    }

    public int b() {
        int i = this.b;
        return i == 0 ? z00.e() : i;
    }

    public Object c() {
        return this.d;
    }

    public Map<String, String> d() {
        return this.j;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.i;
    }

    public c20 g() {
        return this.c;
    }

    public int h() {
        int i = this.a;
        return i == 0 ? z00.f() : i;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.e;
    }

    public void k(boolean z) {
        this.f = z;
    }

    private DXRenderOptions(C6359b c6359b) {
        this.a = c6359b.a;
        this.b = c6359b.b;
        c20 unused = c6359b.c;
        this.d = c6359b.d;
        this.e = c6359b.e;
        this.f = c6359b.f;
        this.h = c6359b.h;
        this.i = c6359b.i;
        this.g = c6359b.g;
        this.j = c6359b.j;
    }
}
