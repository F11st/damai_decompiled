package com.meizu.cloud.pushsdk.c.g;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.io.InputStream;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.g.i */
/* loaded from: classes10.dex */
final class C5989i implements InterfaceC5984d {
    private final C5982b a;
    private final InterfaceC5993m b;
    private boolean c;

    public C5989i(InterfaceC5993m interfaceC5993m) {
        this(interfaceC5993m, new C5982b());
    }

    public C5989i(InterfaceC5993m interfaceC5993m, C5982b c5982b) {
        if (interfaceC5993m == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = c5982b;
        this.b = interfaceC5993m;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5993m
    public long b(C5982b c5982b, long j) throws IOException {
        if (c5982b != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.c) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else {
                C5982b c5982b2 = this.a;
                if (c5982b2.b == 0 && this.b.b(c5982b2, 2048L) == -1) {
                    return -1L;
                }
                return this.a.b(c5982b, Math.min(j, this.a.b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5993m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.j();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5984d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.c.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (C5989i.this.c) {
                    throw new IOException(IRequestConst.CLOSED);
                }
                return (int) Math.min(C5989i.this.a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                C5989i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (C5989i.this.c) {
                    throw new IOException(IRequestConst.CLOSED);
                }
                if (C5989i.this.a.b == 0 && C5989i.this.b.b(C5989i.this.a, 2048L) == -1) {
                    return -1;
                }
                return C5989i.this.a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
                if (C5989i.this.c) {
                    throw new IOException(IRequestConst.CLOSED);
                }
                C5995o.a(bArr.length, i, i2);
                if (C5989i.this.a.b == 0 && C5989i.this.b.b(C5989i.this.a, 2048L) == -1) {
                    return -1;
                }
                return C5989i.this.a.a(bArr, i, i2);
            }

            public String toString() {
                return C5989i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5984d
    public String h() throws IOException {
        this.a.a(this.b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.InterfaceC5984d
    public byte[] i() throws IOException {
        this.a.a(this.b);
        return this.a.i();
    }

    public String toString() {
        return "buffer(" + this.b + jn1.BRACKET_END_STR;
    }
}
