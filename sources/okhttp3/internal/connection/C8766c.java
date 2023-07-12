package okhttp3.internal.connection;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import javax.annotation.Nullable;
import okhttp3.AbstractC8829r;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.ws.RealWebSocket;
import okio.AbstractC8839c;
import okio.AbstractC8840d;
import okio.Buffer;
import okio.C8844h;
import okio.Sink;
import okio.Source;
import tb.ez1;
import tb.w31;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.c */
/* loaded from: classes2.dex */
public final class C8766c {
    final C8776i a;
    final Call b;
    final EventListener c;
    final C8769d d;
    final ExchangeCodec e;
    private boolean f;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.c$a */
    /* loaded from: classes2.dex */
    private final class C8767a extends AbstractC8839c {
        private boolean a;
        private long b;
        private long c;
        private boolean d;

        C8767a(Sink sink, long j) {
            super(sink);
            this.b = j;
        }

        @Nullable
        private IOException a(@Nullable IOException iOException) {
            if (this.a) {
                return iOException;
            }
            this.a = true;
            return C8766c.this.a(this.c, false, true, iOException);
        }

        @Override // okio.AbstractC8839c, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.d) {
                return;
            }
            this.d = true;
            long j = this.b;
            if (j != -1 && this.c != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // okio.AbstractC8839c, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // okio.AbstractC8839c, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.d) {
                long j2 = this.b;
                if (j2 != -1 && this.c + j > j2) {
                    throw new ProtocolException("expected " + this.b + " bytes but received " + (this.c + j));
                }
                try {
                    super.write(buffer, j);
                    this.c += j;
                    return;
                } catch (IOException e) {
                    throw a(e);
                }
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.c$b */
    /* loaded from: classes2.dex */
    final class C8768b extends AbstractC8840d {
        private final long a;
        private long b;
        private boolean c;
        private boolean d;

        C8768b(Source source, long j) {
            super(source);
            this.a = j;
            if (j == 0) {
                a(null);
            }
        }

        @Nullable
        IOException a(@Nullable IOException iOException) {
            if (this.c) {
                return iOException;
            }
            this.c = true;
            return C8766c.this.a(this.b, true, false, iOException);
        }

        @Override // okio.AbstractC8840d, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.d) {
                return;
            }
            this.d = true;
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // okio.AbstractC8840d, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (!this.d) {
                try {
                    long read = delegate().read(buffer, j);
                    if (read == -1) {
                        a(null);
                        return -1L;
                    }
                    long j2 = this.b + read;
                    long j3 = this.a;
                    if (j3 != -1 && j2 > j3) {
                        throw new ProtocolException("expected " + this.a + " bytes but received " + j2);
                    }
                    this.b = j2;
                    if (j2 == j3) {
                        a(null);
                    }
                    return read;
                } catch (IOException e) {
                    throw a(e);
                }
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    public C8766c(C8776i c8776i, Call call, EventListener eventListener, C8769d c8769d, ExchangeCodec exchangeCodec) {
        this.a = c8776i;
        this.b = call;
        this.c = eventListener;
        this.d = c8769d;
        this.e = exchangeCodec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException a(long j, boolean z, boolean z2, @Nullable IOException iOException) {
        if (iOException != null) {
            p(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.c.p(this.b, iOException);
            } else {
                this.c.n(this.b, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.c.u(this.b, iOException);
            } else {
                this.c.s(this.b, j);
            }
        }
        return this.a.g(this, z2, z, iOException);
    }

    public void b() {
        this.e.cancel();
    }

    public C8770e c() {
        return this.e.connection();
    }

    public Sink d(C8823o c8823o, boolean z) throws IOException {
        this.f = z;
        long a = c8823o.a().a();
        this.c.o(this.b);
        return new C8767a(this.e.createRequestBody(c8823o, a), a);
    }

    public void e() {
        this.e.cancel();
        this.a.g(this, true, true, null);
    }

    public void f() throws IOException {
        try {
            this.e.finishRequest();
        } catch (IOException e) {
            this.c.p(this.b, e);
            p(e);
            throw e;
        }
    }

    public void g() throws IOException {
        try {
            this.e.flushRequest();
        } catch (IOException e) {
            this.c.p(this.b, e);
            p(e);
            throw e;
        }
    }

    public boolean h() {
        return this.f;
    }

    public RealWebSocket.AbstractC8809d i() throws SocketException {
        this.a.p();
        return this.e.connection().o(this);
    }

    public void j() {
        this.e.connection().p();
    }

    public void k() {
        this.a.g(this, true, false, null);
    }

    public AbstractC8829r l(C8827q c8827q) throws IOException {
        try {
            this.c.t(this.b);
            String g = c8827q.g("Content-Type");
            long reportedContentLength = this.e.reportedContentLength(c8827q);
            return new ez1(g, reportedContentLength, C8844h.d(new C8768b(this.e.openResponseBodySource(c8827q), reportedContentLength)));
        } catch (IOException e) {
            this.c.u(this.b, e);
            p(e);
            throw e;
        }
    }

    @Nullable
    public C8827q.C8828a m(boolean z) throws IOException {
        try {
            C8827q.C8828a readResponseHeaders = this.e.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                w31.a.g(readResponseHeaders, this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.c.u(this.b, e);
            p(e);
            throw e;
        }
    }

    public void n(C8827q c8827q) {
        this.c.v(this.b, c8827q);
    }

    public void o() {
        this.c.w(this.b);
    }

    void p(IOException iOException) {
        this.d.h();
        this.e.connection().t(iOException);
    }

    public void q() {
        a(-1L, true, true, null);
    }

    public void r(C8823o c8823o) throws IOException {
        try {
            this.c.r(this.b);
            this.e.writeRequestHeaders(c8823o);
            this.c.q(this.b, c8823o);
        } catch (IOException e) {
            this.c.p(this.b, e);
            p(e);
            throw e;
        }
    }
}
