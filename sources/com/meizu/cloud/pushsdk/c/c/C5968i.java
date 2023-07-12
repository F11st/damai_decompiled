package com.meizu.cloud.pushsdk.c.c;

import anet.channel.request.C0193a;
import com.meizu.cloud.pushsdk.c.c.C5957c;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.i */
/* loaded from: classes10.dex */
public class C5968i {
    private final C5961f a;
    private final String b;
    private final C5957c c;
    private final AbstractC5970j d;
    private final Object e;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.i$a */
    /* loaded from: classes10.dex */
    public static class C5969a {
        private C5961f a;
        private String b = "GET";
        private C5957c.C5958a c = new C5957c.C5958a();
        private AbstractC5970j d;
        private Object e;

        public C5969a a() {
            return a("GET", (AbstractC5970j) null);
        }

        public C5969a a(C5957c c5957c) {
            this.c = c5957c.c();
            return this;
        }

        public C5969a a(C5961f c5961f) {
            if (c5961f != null) {
                this.a = c5961f;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public C5969a a(AbstractC5970j abstractC5970j) {
            return a("POST", abstractC5970j);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.meizu.cloud.pushsdk.c.c.C5968i.C5969a a(java.lang.String r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L61
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 3
                java.lang.String r3 = "ws:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L26
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "http:"
                r0.append(r1)
                r1 = 3
            L1a:
                java.lang.String r7 = r7.substring(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                goto L3f
            L26:
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 4
                java.lang.String r3 = "wss:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L3f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "https:"
                r0.append(r1)
                r1 = 4
                goto L1a
            L3f:
                com.meizu.cloud.pushsdk.c.c.f r0 = com.meizu.cloud.pushsdk.c.c.C5961f.c(r7)
                if (r0 == 0) goto L4a
                com.meizu.cloud.pushsdk.c.c.i$a r7 = r6.a(r0)
                return r7
            L4a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "unexpected url: "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>(r7)
                throw r0
            L61:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "url == null"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.C5968i.C5969a.a(java.lang.String):com.meizu.cloud.pushsdk.c.c.i$a");
        }

        public C5969a a(String str, AbstractC5970j abstractC5970j) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (abstractC5970j != null && !C5959d.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (abstractC5970j != null || !C5959d.a(str)) {
                this.b = str;
                this.d = abstractC5970j;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public C5969a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public C5969a b() {
            return a(C0193a.C0196c.HEAD, (AbstractC5970j) null);
        }

        public C5969a b(AbstractC5970j abstractC5970j) {
            return a(C0193a.C0196c.DELETE, abstractC5970j);
        }

        public C5969a c(AbstractC5970j abstractC5970j) {
            return a(C0193a.C0196c.PUT, abstractC5970j);
        }

        public C5968i c() {
            if (this.a != null) {
                return new C5968i(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C5969a d(AbstractC5970j abstractC5970j) {
            return a("PATCH", abstractC5970j);
        }
    }

    private C5968i(C5969a c5969a) {
        this.a = c5969a.a;
        this.b = c5969a.b;
        this.c = c5969a.c.a();
        this.d = c5969a.d;
        this.e = c5969a.e != null ? c5969a.e : this;
    }

    public C5961f a() {
        return this.a;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public String b() {
        return this.b;
    }

    public int c() {
        if ("POST".equals(b())) {
            return 1;
        }
        if (C0193a.C0196c.PUT.equals(b())) {
            return 2;
        }
        if (C0193a.C0196c.DELETE.equals(b())) {
            return 3;
        }
        if (C0193a.C0196c.HEAD.equals(b())) {
            return 4;
        }
        return "PATCH".equals(b()) ? 5 : 0;
    }

    public C5957c d() {
        return this.c;
    }

    public AbstractC5970j e() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
