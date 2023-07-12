package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: okio.h */
/* loaded from: classes2.dex */
public final class C8844h {
    static final Logger a = Logger.getLogger(C8844h.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okio.h$a */
    /* loaded from: classes2.dex */
    public final class C8845a implements Sink {
        final /* synthetic */ C8857o a;
        final /* synthetic */ OutputStream b;

        C8845a(C8857o c8857o, OutputStream outputStream) {
            this.a = c8857o;
            this.b = outputStream;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        @Override // okio.Sink
        public C8857o timeout() {
            return this.a;
        }

        public String toString() {
            return "sink(" + this.b + jn1.BRACKET_END_STR;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            C8859p.b(buffer.size, 0L, j);
            while (j > 0) {
                this.a.throwIfReached();
                C8855m c8855m = buffer.head;
                int min = (int) Math.min(j, c8855m.c - c8855m.b);
                this.b.write(c8855m.a, c8855m.b, min);
                int i = c8855m.b + min;
                c8855m.b = i;
                long j2 = min;
                j -= j2;
                buffer.size -= j2;
                if (i == c8855m.c) {
                    buffer.head = c8855m.b();
                    C8856n.a(c8855m);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okio.h$b */
    /* loaded from: classes2.dex */
    public final class C8846b implements Source {
        final /* synthetic */ C8857o a;
        final /* synthetic */ InputStream b;

        C8846b(C8857o c8857o, InputStream inputStream) {
            this.a = c8857o;
            this.b = inputStream;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i == 0) {
                return 0L;
            } else {
                try {
                    this.a.throwIfReached();
                    C8855m writableSegment = buffer.writableSegment(1);
                    int read = this.b.read(writableSegment.a, writableSegment.c, (int) Math.min(j, 8192 - writableSegment.c));
                    if (read == -1) {
                        return -1L;
                    }
                    writableSegment.c += read;
                    long j2 = read;
                    buffer.size += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (C8844h.e(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        @Override // okio.Source
        public C8857o timeout() {
            return this.a;
        }

        public String toString() {
            return "source(" + this.b + jn1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okio.h$c */
    /* loaded from: classes2.dex */
    final class C8847c implements Sink {
        C8847c() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // okio.Sink
        public C8857o timeout() {
            return C8857o.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            buffer.skip(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okio.h$d */
    /* loaded from: classes2.dex */
    public final class C8848d extends AsyncTimeout {
        final /* synthetic */ Socket a;

        C8848d(Socket socket) {
            this.a = socket;
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            try {
                this.a.close();
            } catch (AssertionError e) {
                if (C8844h.e(e)) {
                    Logger logger = C8844h.a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.a, (Throwable) e);
                    return;
                }
                throw e;
            } catch (Exception e2) {
                Logger logger2 = C8844h.a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.a, (Throwable) e2);
            }
        }
    }

    private C8844h() {
    }

    public static Sink a(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink b() {
        return new C8847c();
    }

    public static BufferedSink c(Sink sink) {
        return new C8851k(sink);
    }

    public static BufferedSource d(Source source) {
        return new C8853l(source);
    }

    static boolean e(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink f(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink g(OutputStream outputStream) {
        return h(outputStream, new C8857o());
    }

    private static Sink h(OutputStream outputStream, C8857o c8857o) {
        if (outputStream != null) {
            if (c8857o != null) {
                return new C8845a(c8857o, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static Sink i(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                AsyncTimeout n = n(socket);
                return n.sink(h(socket.getOutputStream(), n));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Source j(File file) throws FileNotFoundException {
        if (file != null) {
            return k(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source k(InputStream inputStream) {
        return l(inputStream, new C8857o());
    }

    private static Source l(InputStream inputStream, C8857o c8857o) {
        if (inputStream != null) {
            if (c8857o != null) {
                return new C8846b(c8857o, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static Source m(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                AsyncTimeout n = n(socket);
                return n.source(l(socket.getInputStream(), n));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static AsyncTimeout n(Socket socket) {
        return new C8848d(socket);
    }
}
