package tb;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.l;
import okhttp3.q;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class b01 implements ExchangeCodec {
    private final OkHttpClient a;
    private final okhttp3.internal.connection.e b;
    private final BufferedSource c;
    private final BufferedSink d;
    private int e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    private okhttp3.l g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public abstract class b implements Source {
        protected final okio.e a;
        protected boolean b;

        private b() {
            this.a = new okio.e(b01.this.c.timeout());
        }

        final void a() {
            if (b01.this.e == 6) {
                return;
            }
            if (b01.this.e == 5) {
                b01.this.k(this.a);
                b01.this.e = 6;
                return;
            }
            throw new IllegalStateException("state: " + b01.this.e);
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                return b01.this.c.read(buffer, j);
            } catch (IOException e) {
                b01.this.b.p();
                a();
                throw e;
            }
        }

        @Override // okio.Source
        public okio.o timeout() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class c implements Sink {
        private final okio.e a;
        private boolean b;

        c() {
            this.a = new okio.e(b01.this.d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            b01.this.d.writeUtf8("0\r\n\r\n");
            b01.this.k(this.a);
            b01.this.e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.b) {
                return;
            }
            b01.this.d.flush();
        }

        @Override // okio.Sink
        public okio.o timeout() {
            return this.a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.b) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            if (j == 0) {
                return;
            }
            b01.this.d.writeHexadecimalUnsignedLong(j);
            b01.this.d.writeUtf8(SocketClient.NETASCII_EOL);
            b01.this.d.write(buffer, j);
            b01.this.d.writeUtf8(SocketClient.NETASCII_EOL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class d extends b {
        private final okhttp3.m d;
        private long e;
        private boolean f;

        d(okhttp3.m mVar) {
            super();
            this.e = -1L;
            this.f = true;
            this.d = mVar;
        }

        private void c() throws IOException {
            if (this.e != -1) {
                b01.this.c.readUtf8LineStrict();
            }
            try {
                this.e = b01.this.c.readHexadecimalUnsignedLong();
                String trim = b01.this.c.readUtf8LineStrict().trim();
                if (this.e >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.e == 0) {
                        this.f = false;
                        b01 b01Var = b01.this;
                        b01Var.g = b01Var.r();
                        g01.g(b01.this.a.cookieJar(), this.d, b01.this.g);
                        a();
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + trim + "\"");
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f && !okhttp3.internal.a.p(this, 100, TimeUnit.MILLISECONDS)) {
                b01.this.b.p();
                a();
            }
            this.b = true;
        }

        @Override // tb.b01.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.b) {
                    if (this.f) {
                        long j2 = this.e;
                        if (j2 == 0 || j2 == -1) {
                            c();
                            if (!this.f) {
                                return -1L;
                            }
                        }
                        long read = super.read(buffer, Math.min(j, this.e));
                        if (read == -1) {
                            b01.this.b.p();
                            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                            a();
                            throw protocolException;
                        }
                        this.e -= read;
                        return read;
                    }
                    return -1L;
                }
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class e extends b {
        private long d;

        e(long j) {
            super();
            this.d = j;
            if (j == 0) {
                a();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.d != 0 && !okhttp3.internal.a.p(this, 100, TimeUnit.MILLISECONDS)) {
                b01.this.b.p();
                a();
            }
            this.b = true;
        }

        @Override // tb.b01.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.b) {
                    long j2 = this.d;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long read = super.read(buffer, Math.min(j2, j));
                    if (read == -1) {
                        b01.this.b.p();
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        a();
                        throw protocolException;
                    }
                    long j3 = this.d - read;
                    this.d = j3;
                    if (j3 == 0) {
                        a();
                    }
                    return read;
                }
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class f implements Sink {
        private final okio.e a;
        private boolean b;

        private f() {
            this.a = new okio.e(b01.this.d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            b01.this.k(this.a);
            b01.this.e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.b) {
                return;
            }
            b01.this.d.flush();
        }

        @Override // okio.Sink
        public okio.o timeout() {
            return this.a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.b) {
                okhttp3.internal.a.f(buffer.size(), 0L, j);
                b01.this.d.write(buffer, j);
                return;
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class g extends b {
        private boolean d;

        private g(b01 b01Var) {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.d) {
                a();
            }
            this.b = true;
        }

        @Override // tb.b01.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.b) {
                    if (this.d) {
                        return -1L;
                    }
                    long read = super.read(buffer, j);
                    if (read == -1) {
                        this.d = true;
                        a();
                        return -1L;
                    }
                    return read;
                }
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public b01(OkHttpClient okHttpClient, okhttp3.internal.connection.e eVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.a = okHttpClient;
        this.b = eVar;
        this.c = bufferedSource;
        this.d = bufferedSink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(okio.e eVar) {
        okio.o a2 = eVar.a();
        eVar.b(okio.o.NONE);
        a2.clearDeadline();
        a2.clearTimeout();
    }

    private Sink l() {
        if (this.e == 1) {
            this.e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source m(okhttp3.m mVar) {
        if (this.e == 4) {
            this.e = 5;
            return new d(mVar);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source n(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Sink o() {
        if (this.e == 1) {
            this.e = 2;
            return new f();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source p() {
        if (this.e == 4) {
            this.e = 5;
            this.b.p();
            return new g();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private String q() throws IOException {
        String readUtf8LineStrict = this.c.readUtf8LineStrict(this.f);
        this.f -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public okhttp3.l r() throws IOException {
        l.a aVar = new l.a();
        while (true) {
            String q = q();
            if (q.length() != 0) {
                w31.a.a(aVar, q);
            } else {
                return aVar.e();
            }
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        okhttp3.internal.connection.e eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.internal.connection.e connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(okhttp3.o oVar, long j) throws IOException {
        if (oVar.a() != null && oVar.a().f()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(oVar.c("Transfer-Encoding"))) {
            return l();
        }
        if (j != -1) {
            return o();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(okhttp3.q qVar) {
        if (!g01.c(qVar)) {
            return n(0L);
        }
        if ("chunked".equalsIgnoreCase(qVar.g("Transfer-Encoding"))) {
            return m(qVar.q().i());
        }
        long b2 = g01.b(qVar);
        if (b2 != -1) {
            return n(b2);
        }
        return p();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public q.a readResponseHeaders(boolean z) throws IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            okhttp3.internal.http.e a2 = okhttp3.internal.http.e.a(q());
            q.a j = new q.a().o(a2.a).g(a2.b).l(a2.c).j(r());
            if (z && a2.b == 100) {
                return null;
            }
            if (a2.b == 100) {
                this.e = 3;
                return j;
            }
            this.e = 4;
            return j;
        } catch (EOFException e2) {
            okhttp3.internal.connection.e eVar = this.b;
            String A = eVar != null ? eVar.route().a().l().A() : "unknown";
            throw new IOException("unexpected end of stream on " + A, e2);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(okhttp3.q qVar) {
        if (g01.c(qVar)) {
            if ("chunked".equalsIgnoreCase(qVar.g("Transfer-Encoding"))) {
                return -1L;
            }
            return g01.b(qVar);
        }
        return 0L;
    }

    public void s(okhttp3.q qVar) throws IOException {
        long b2 = g01.b(qVar);
        if (b2 == -1) {
            return;
        }
        Source n = n(b2);
        okhttp3.internal.a.F(n, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        n.close();
    }

    public void t(okhttp3.l lVar, String str) throws IOException {
        if (this.e == 0) {
            this.d.writeUtf8(str).writeUtf8(SocketClient.NETASCII_EOL);
            int h = lVar.h();
            for (int i = 0; i < h; i++) {
                this.d.writeUtf8(lVar.e(i)).writeUtf8(": ").writeUtf8(lVar.j(i)).writeUtf8(SocketClient.NETASCII_EOL);
            }
            this.d.writeUtf8(SocketClient.NETASCII_EOL);
            this.e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.l trailers() {
        if (this.e == 6) {
            okhttp3.l lVar = this.g;
            return lVar != null ? lVar : okhttp3.internal.a.EMPTY_HEADERS;
        }
        throw new IllegalStateException("too early; can't read the trailers yet");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(okhttp3.o oVar) throws IOException {
        t(oVar.e(), d22.a(oVar, this.b.route().b().type()));
    }
}
