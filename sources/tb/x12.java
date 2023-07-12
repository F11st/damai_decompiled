package tb;

import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterOutputStream;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class x12 {
    private final sj1 a;
    private final String b;
    private ByteArrayOutputStream c;
    private C9899a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.x12$b */
    /* loaded from: classes5.dex */
    public static class C9900b extends FilterOutputStream {
        private static final ExecutorService b = Executors.newCachedThreadPool();
        private final Future<Void> a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: tb.x12$b$a */
        /* loaded from: classes5.dex */
        public static class CallableC9901a implements Callable<Void> {
            private final InputStream a;
            private final OutputStream b;

            public CallableC9901a(InputStream inputStream, OutputStream outputStream) {
                this.a = inputStream;
                this.b = outputStream;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws IOException {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(this.a);
                try {
                    C9900b.b(gZIPInputStream, this.b, new byte[1024]);
                    gZIPInputStream.close();
                    this.b.close();
                    return null;
                } catch (Throwable th) {
                    gZIPInputStream.close();
                    this.b.close();
                    throw th;
                }
            }
        }

        private C9900b(OutputStream outputStream, Future<Void> future) throws IOException {
            super(outputStream);
            this.a = future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        }

        public static C9900b c(OutputStream outputStream) throws IOException {
            PipedInputStream pipedInputStream = new PipedInputStream();
            return new C9900b(new PipedOutputStream(pipedInputStream), b.submit(new CallableC9901a(pipedInputStream, outputStream)));
        }

        private static <T> T d(Future<T> future) throws IOException {
            while (true) {
                try {
                    return future.get();
                } catch (InterruptedException unused) {
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    f(cause, IOException.class);
                    e(cause);
                }
            }
        }

        private static RuntimeException e(Throwable th) {
            f(th, Error.class);
            f(th, RuntimeException.class);
            throw new RuntimeException(th);
        }

        private static <T extends Throwable> void f(Throwable th, Class<T> cls) throws Throwable {
            if (cls.isInstance(th)) {
                throw th;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                super.close();
                try {
                } catch (IOException e) {
                    throw e;
                }
            } finally {
                try {
                    d(this.a);
                } catch (IOException unused) {
                }
            }
        }
    }

    public x12(sj1 sj1Var, String str) {
        this.a = sj1Var;
        this.b = str;
    }

    private void e() {
        if (!c()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }

    public OutputStream a(@Nullable String str) throws IOException {
        OutputStream inflaterOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if ("gzip".equals(str)) {
            inflaterOutputStream = C9900b.c(byteArrayOutputStream);
        } else {
            inflaterOutputStream = "deflate".equals(str) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
        }
        C9899a c9899a = new C9899a(this, inflaterOutputStream);
        this.d = c9899a;
        this.c = byteArrayOutputStream;
        return c9899a;
    }

    public byte[] b() {
        e();
        return this.c.toByteArray();
    }

    public boolean c() {
        return this.c != null;
    }

    public void d() {
        e();
        this.a.b(this.b, this.c.size(), (int) this.d.getCount());
    }

    /* compiled from: Taobao */
    /* renamed from: tb.x12$a */
    /* loaded from: classes5.dex */
    private class C9899a extends FilterOutputStream {
        private long a;

        public C9899a(x12 x12Var, OutputStream outputStream) {
            super(outputStream);
        }

        public long getCount() {
            return this.a;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            ((FilterOutputStream) this).out.write(i);
            this.a++;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            this.a += i2;
        }
    }
}
