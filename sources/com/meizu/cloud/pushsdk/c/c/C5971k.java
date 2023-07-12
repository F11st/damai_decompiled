package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.C5957c;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.k */
/* loaded from: classes10.dex */
public class C5971k {
    private final C5968i a;
    private final int b;
    private final String c;
    private final C5957c d;
    private final AbstractC5973l e;
    private final C5971k f;
    private final C5971k g;
    private final C5971k h;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.k$a */
    /* loaded from: classes10.dex */
    public static class C5972a {
        private C5968i a;
        private String c;
        private AbstractC5973l e;
        private C5971k f;
        private C5971k g;
        private C5971k h;
        private int b = -1;
        private C5957c.C5958a d = new C5957c.C5958a();

        public C5972a a(int i) {
            this.b = i;
            return this;
        }

        public C5972a a(C5957c c5957c) {
            this.d = c5957c.c();
            return this;
        }

        public C5972a a(C5968i c5968i) {
            this.a = c5968i;
            return this;
        }

        public C5972a a(AbstractC5973l abstractC5973l) {
            this.e = abstractC5973l;
            return this;
        }

        public C5972a a(String str) {
            this.c = str;
            return this;
        }

        public C5971k a() {
            if (this.a != null) {
                if (this.b >= 0) {
                    return new C5971k(this);
                }
                throw new IllegalStateException("code < 0: " + this.b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    private C5971k(C5972a c5972a) {
        this.a = c5972a.a;
        this.b = c5972a.b;
        this.c = c5972a.c;
        this.d = c5972a.d.a();
        this.e = c5972a.e;
        this.f = c5972a.f;
        this.g = c5972a.g;
        this.h = c5972a.h;
    }

    public int a() {
        return this.b;
    }

    public AbstractC5973l b() {
        return this.e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.b + ", message=" + this.c + ", url=" + this.a.a() + '}';
    }
}
