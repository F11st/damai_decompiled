package com.meizu.cloud.pushsdk.c.g;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class h implements c {
    private final b a;
    private final l b;
    private boolean c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = bVar;
        this.b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = mVar.b(this.a, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public c a() throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        long e = this.a.e();
        if (e > 0) {
            this.b.a(this.a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(e eVar) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            b bVar = this.a;
            long j = bVar.b;
            if (j > 0) {
                this.b.a(bVar, j);
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
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c e(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        this.a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
        b bVar = this.a;
        long j = bVar.b;
        if (j > 0) {
            this.b.a(bVar, j);
        }
        this.b.flush();
    }

    public String toString() {
        return "buffer(" + this.b + jn1.BRACKET_END_STR;
    }
}
