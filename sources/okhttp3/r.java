package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import tb.xd1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class r implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class a extends r {
        final /* synthetic */ xd1 a;
        final /* synthetic */ long b;
        final /* synthetic */ BufferedSource c;

        a(xd1 xd1Var, long j, BufferedSource bufferedSource) {
            this.a = xd1Var;
            this.b = j;
            this.c = bufferedSource;
        }

        @Override // okhttp3.r
        public long f() {
            return this.b;
        }

        @Override // okhttp3.r
        @Nullable
        public xd1 g() {
            return this.a;
        }

        @Override // okhttp3.r
        public BufferedSource j() {
            return this.c;
        }
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private Charset e() {
        xd1 g = g();
        return g != null ? g.b(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static r h(@Nullable xd1 xd1Var, long j, BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new a(xd1Var, j, bufferedSource);
    }

    public static r i(@Nullable xd1 xd1Var, byte[] bArr) {
        return h(xd1Var, bArr.length, new Buffer().write(bArr));
    }

    public final InputStream c() {
        return j().inputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.a.g(j());
    }

    public abstract long f();

    @Nullable
    public abstract xd1 g();

    public abstract BufferedSource j();

    public final String k() throws IOException {
        BufferedSource j = j();
        try {
            String readString = j.readString(okhttp3.internal.a.c(j, e()));
            a(null, j);
            return readString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (j != null) {
                    a(th, j);
                }
                throw th2;
            }
        }
    }
}
