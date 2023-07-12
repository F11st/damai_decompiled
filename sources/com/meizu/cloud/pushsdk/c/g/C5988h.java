package com.meizu.cloud.pushsdk.c.g;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.h */
/* loaded from: classes10.dex */
final class C5988h implements InterfaceC5983c {
    private final C5982b a;
    private final InterfaceC5992l b;
    private boolean c;

    public C5988h(InterfaceC5992l interfaceC5992l) {
        this(interfaceC5992l, new C5982b());
    }

    public C5988h(InterfaceC5992l interfaceC5992l, C5982b c5982b) {
        if (interfaceC5992l == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = c5982b;
        this.b = interfaceC5992l;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public long a(InterfaceC5993m interfaceC5993m) throws IOException {
        if (interfaceC5993m == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = interfaceC5993m.b(this.a, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public InterfaceC5983c a() throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        long e = this.a.e();
        if (e > 0) {
            this.b.a(this.a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l
    public void a(C5982b c5982b, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.a(c5982b, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public C5982b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public InterfaceC5983c b(C5985e c5985e) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.b(c5985e);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public InterfaceC5983c b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public InterfaceC5983c c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public InterfaceC5983c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
    public void close() {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            C5982b c5982b = this.a;
            long j = c5982b.b;
            if (j > 0) {
                this.b.a(c5982b, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            C5995o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5983c
    public InterfaceC5983c e(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5992l, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        C5982b c5982b = this.a;
        long j = c5982b.b;
        if (j > 0) {
            this.b.a(c5982b, j);
        }
        this.b.flush();
    }

    public String toString() {
        return "buffer(" + this.b + jn1.BRACKET_END_STR;
    }
}
