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
/* loaded from: classes2.dex */
public final class h {
    static final Logger a = Logger.getLogger(h.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class a implements Sink {
        final /* synthetic */ o a;
        final /* synthetic */ OutputStream b;

        a(o oVar, OutputStream outputStream) {
            this.a = oVar;
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
        public o timeout() {
            return this.a;
        }

        public String toString() {
            return "sink(" + this.b + jn1.BRACKET_END_STR;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            p.b(buffer.size, 0L, j);
            while (j > 0) {
                this.a.throwIfReached();
                m mVar = buffer.head;
                int min = (int) Math.min(j, mVar.c - mVar.b);
                this.b.write(mVar.a, mVar.b, min);
                int i = mVar.b + min;
                mVar.b = i;
                long j2 = min;
                j -= j2;
                buffer.size -= j2;
                if (i == mVar.c) {
                    buffer.head = mVar.b();
                    n.a(mVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class b implements Source {
        final /* synthetic */ o a;
        final /* synthetic */ InputStream b;

        b(o oVar, InputStream inputStream) {
            this.a = oVar;
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
                    m writableSegment = buffer.writableSegment(1);
                    int read = this.b.read(writableSegment.a, writableSegment.c, (int) Math.min(j, 8192 - writableSegment.c));
                    if (read == -1) {
                        return -1L;
                    }
                    writableSegment.c += read;
                    long j2 = read;
                    buffer.size += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (h.e(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        @Override // okio.Source
        public o timeout() {
            return this.a;
        }

        public String toString() {
            return "source(" + this.b + jn1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    final class c implements Sink {
        c() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // okio.Sink
        public o timeout() {
            return o.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            buffer.skip(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class d extends AsyncTimeout {
        final /* synthetic */ Socket a;

        d(Socket socket) {
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
                if (h.e(e)) {
                    Logger logger = h.a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.a, (Throwable) e);
                    return;
                }
                throw e;
            } catch (Exception e2) {
                Logger logger2 = h.a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.a, (Throwable) e2);
            }
        }
    }

    private h() {
    }

    public static Sink a(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink b() {
        return new c();
    }

    public static BufferedSink c(Sink sink) {
        return new k(sink);
    }

    public static BufferedSource d(Source source) {
        return new l(source);
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
        return h(outputStream, new o());
    }

    private static Sink h(OutputStream outputStream, o oVar) {
        if (outputStream != null) {
            if (oVar != null) {
                return new a(oVar, outputStream);
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
        return l(inputStream, new o());
    }

    private static Source l(InputStream inputStream, o oVar) {
        if (inputStream != null) {
            if (oVar != null) {
                return new b(oVar, inputStream);
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
        return new d(socket);
    }
}
