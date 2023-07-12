package tb;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.C8816l;
import okhttp3.C8818m;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.OkHttpClient;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8770e;
import okhttp3.internal.http.C8783e;
import okhttp3.internal.http.ExchangeCodec;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.C8841e;
import okio.C8857o;
import okio.Sink;
import okio.Source;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class b01 implements ExchangeCodec {
    private final OkHttpClient a;
    private final C8770e b;
    private final BufferedSource c;
    private final BufferedSink d;
    private int e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    private C8816l g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.b01$b */
    /* loaded from: classes2.dex */
    public abstract class AbstractC8936b implements Source {
        protected final C8841e a;
        protected boolean b;

        private AbstractC8936b() {
            this.a = new C8841e(b01.this.c.timeout());
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
        public C8857o timeout() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.b01$c */
    /* loaded from: classes2.dex */
    public final class C8937c implements Sink {
        private final C8841e a;
        private boolean b;

        C8937c() {
            this.a = new C8841e(b01.this.d.timeout());
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
        public C8857o timeout() {
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
    /* renamed from: tb.b01$d */
    /* loaded from: classes2.dex */
    public class C8938d extends AbstractC8936b {
        private final C8818m d;
        private long e;
        private boolean f;

        C8938d(C8818m c8818m) {
            super();
            this.e = -1L;
            this.f = true;
            this.d = c8818m;
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
            if (this.f && !C8753a.p(this, 100, TimeUnit.MILLISECONDS)) {
                b01.this.b.p();
                a();
            }
            this.b = true;
        }

        @Override // tb.b01.AbstractC8936b, okio.Source
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
    /* renamed from: tb.b01$e */
    /* loaded from: classes2.dex */
    public class C8939e extends AbstractC8936b {
        private long d;

        C8939e(long j) {
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
            if (this.d != 0 && !C8753a.p(this, 100, TimeUnit.MILLISECONDS)) {
                b01.this.b.p();
                a();
            }
            this.b = true;
        }

        @Override // tb.b01.AbstractC8936b, okio.Source
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
    /* renamed from: tb.b01$f */
    /* loaded from: classes2.dex */
    public final class C8940f implements Sink {
        private final C8841e a;
        private boolean b;

        private C8940f() {
            this.a = new C8841e(b01.this.d.timeout());
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
        public C8857o timeout() {
            return this.a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.b) {
                C8753a.f(buffer.size(), 0L, j);
                b01.this.d.write(buffer, j);
                return;
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.b01$g */
    /* loaded from: classes2.dex */
    public class C8941g extends AbstractC8936b {
        private boolean d;

        private C8941g(b01 b01Var) {
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

        @Override // tb.b01.AbstractC8936b, okio.Source
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

    public b01(OkHttpClient okHttpClient, C8770e c8770e, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.a = okHttpClient;
        this.b = c8770e;
        this.c = bufferedSource;
        this.d = bufferedSink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(C8841e c8841e) {
        C8857o a = c8841e.a();
        c8841e.b(C8857o.NONE);
        a.clearDeadline();
        a.clearTimeout();
    }

    private Sink l() {
        if (this.e == 1) {
            this.e = 2;
            return new C8937c();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source m(C8818m c8818m) {
        if (this.e == 4) {
            this.e = 5;
            return new C8938d(c8818m);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source n(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new C8939e(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Sink o() {
        if (this.e == 1) {
            this.e = 2;
            return new C8940f();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source p() {
        if (this.e == 4) {
            this.e = 5;
            this.b.p();
            return new C8941g();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private String q() throws IOException {
        String readUtf8LineStrict = this.c.readUtf8LineStrict(this.f);
        this.f -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8816l r() throws IOException {
        C8816l.C8817a c8817a = new C8816l.C8817a();
        while (true) {
            String q = q();
            if (q.length() != 0) {
                w31.a.a(c8817a, q);
            } else {
                return c8817a.e();
            }
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        C8770e c8770e = this.b;
        if (c8770e != null) {
            c8770e.c();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C8770e connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(C8823o c8823o, long j) throws IOException {
        if (c8823o.a() != null && c8823o.a().f()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(c8823o.c("Transfer-Encoding"))) {
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
    public Source openResponseBodySource(C8827q c8827q) {
        if (!g01.c(c8827q)) {
            return n(0L);
        }
        if ("chunked".equalsIgnoreCase(c8827q.g("Transfer-Encoding"))) {
            return m(c8827q.q().i());
        }
        long b = g01.b(c8827q);
        if (b != -1) {
            return n(b);
        }
        return p();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C8827q.C8828a readResponseHeaders(boolean z) throws IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            C8783e a = C8783e.a(q());
            C8827q.C8828a j = new C8827q.C8828a().o(a.a).g(a.b).l(a.c).j(r());
            if (z && a.b == 100) {
                return null;
            }
            if (a.b == 100) {
                this.e = 3;
                return j;
            }
            this.e = 4;
            return j;
        } catch (EOFException e) {
            C8770e c8770e = this.b;
            String A = c8770e != null ? c8770e.route().a().l().A() : "unknown";
            throw new IOException("unexpected end of stream on " + A, e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(C8827q c8827q) {
        if (g01.c(c8827q)) {
            if ("chunked".equalsIgnoreCase(c8827q.g("Transfer-Encoding"))) {
                return -1L;
            }
            return g01.b(c8827q);
        }
        return 0L;
    }

    public void s(C8827q c8827q) throws IOException {
        long b = g01.b(c8827q);
        if (b == -1) {
            return;
        }
        Source n = n(b);
        C8753a.F(n, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        n.close();
    }

    public void t(C8816l c8816l, String str) throws IOException {
        if (this.e == 0) {
            this.d.writeUtf8(str).writeUtf8(SocketClient.NETASCII_EOL);
            int h = c8816l.h();
            for (int i = 0; i < h; i++) {
                this.d.writeUtf8(c8816l.e(i)).writeUtf8(": ").writeUtf8(c8816l.j(i)).writeUtf8(SocketClient.NETASCII_EOL);
            }
            this.d.writeUtf8(SocketClient.NETASCII_EOL);
            this.e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C8816l trailers() {
        if (this.e == 6) {
            C8816l c8816l = this.g;
            return c8816l != null ? c8816l : C8753a.EMPTY_HEADERS;
        }
        throw new IllegalStateException("too early; can't read the trailers yet");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(C8823o c8823o) throws IOException {
        t(c8823o.e(), d22.a(c8823o, this.b.route().b().type()));
    }
}
