package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.C5982b;
import com.meizu.cloud.pushsdk.c.g.C5985e;
import com.meizu.cloud.pushsdk.c.g.InterfaceC5983c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.h */
/* loaded from: classes10.dex */
public final class C5965h extends AbstractC5970j {
    public static final C5964g a = C5964g.a("multipart/mixed");
    public static final C5964g b = C5964g.a("multipart/alternative");
    public static final C5964g c = C5964g.a("multipart/digest");
    public static final C5964g d = C5964g.a("multipart/parallel");
    public static final C5964g e = C5964g.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final C5985e i;
    private final C5964g j;
    private final C5964g k;
    private final List<C5967b> l;
    private long m = -1;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.h$a */
    /* loaded from: classes10.dex */
    public static final class C5966a {
        private final C5985e a;
        private C5964g b;
        private final List<C5967b> c;

        public C5966a() {
            this(UUID.randomUUID().toString());
        }

        public C5966a(String str) {
            this.b = C5965h.a;
            this.c = new ArrayList();
            this.a = C5985e.a(str);
        }

        public C5966a a(C5957c c5957c, AbstractC5970j abstractC5970j) {
            return a(C5967b.a(c5957c, abstractC5970j));
        }

        public C5966a a(C5964g c5964g) {
            Objects.requireNonNull(c5964g, "type == null");
            if ("multipart".equals(c5964g.a())) {
                this.b = c5964g;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + c5964g);
        }

        public C5966a a(C5967b c5967b) {
            Objects.requireNonNull(c5967b, "part == null");
            this.c.add(c5967b);
            return this;
        }

        public C5965h a() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new C5965h(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.h$b */
    /* loaded from: classes10.dex */
    public static final class C5967b {
        private final C5957c a;
        private final AbstractC5970j b;

        private C5967b(C5957c c5957c, AbstractC5970j abstractC5970j) {
            this.a = c5957c;
            this.b = abstractC5970j;
        }

        public static C5967b a(C5957c c5957c, AbstractC5970j abstractC5970j) {
            Objects.requireNonNull(abstractC5970j, "body == null");
            if (c5957c == null || c5957c.a("Content-Type") == null) {
                if (c5957c == null || c5957c.a(Constants.Protocol.CONTENT_LENGTH) == null) {
                    return new C5967b(c5957c, abstractC5970j);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
    }

    C5965h(C5985e c5985e, C5964g c5964g, List<C5967b> list) {
        this.i = c5985e;
        this.j = c5964g;
        this.k = C5964g.a(c5964g + "; boundary=" + c5985e.a());
        this.l = C5974m.a(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(InterfaceC5983c interfaceC5983c, boolean z) throws IOException {
        C5982b c5982b;
        if (z) {
            interfaceC5983c = new C5982b();
            c5982b = interfaceC5983c;
        } else {
            c5982b = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C5967b c5967b = this.l.get(i);
            C5957c c5957c = c5967b.a;
            AbstractC5970j abstractC5970j = c5967b.b;
            interfaceC5983c.c(h);
            interfaceC5983c.b(this.i);
            interfaceC5983c.c(g);
            if (c5957c != null) {
                int a2 = c5957c.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    interfaceC5983c.b(c5957c.a(i2)).c(f).b(c5957c.b(i2)).c(g);
                }
            }
            C5964g a3 = abstractC5970j.a();
            if (a3 != null) {
                interfaceC5983c.b("Content-Type: ").b(a3.toString()).c(g);
            }
            long b2 = abstractC5970j.b();
            if (b2 != -1) {
                interfaceC5983c.b("Content-Length: ").e(b2).c(g);
            } else if (z) {
                c5982b.j();
                return -1L;
            }
            byte[] bArr = g;
            interfaceC5983c.c(bArr);
            if (z) {
                j += b2;
            } else {
                abstractC5970j.a(interfaceC5983c);
            }
            interfaceC5983c.c(bArr);
        }
        byte[] bArr2 = h;
        interfaceC5983c.c(bArr2);
        interfaceC5983c.b(this.i);
        interfaceC5983c.c(bArr2);
        interfaceC5983c.c(g);
        if (z) {
            long a4 = j + c5982b.a();
            c5982b.j();
            return a4;
        }
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public C5964g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public void a(InterfaceC5983c interfaceC5983c) throws IOException {
        a(interfaceC5983c, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.AbstractC5970j
    public long b() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((InterfaceC5983c) null, true);
        this.m = a2;
        return a2;
    }
}
