package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.BufferedSink;
import tb.xd1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class a extends p {
        final /* synthetic */ xd1 a;
        final /* synthetic */ int b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ int d;

        a(xd1 xd1Var, int i, byte[] bArr, int i2) {
            this.a = xd1Var;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // okhttp3.p
        public long a() {
            return this.b;
        }

        @Override // okhttp3.p
        @Nullable
        public xd1 b() {
            return this.a;
        }

        @Override // okhttp3.p
        public void h(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.c, this.d, this.b);
        }
    }

    public static p c(@Nullable xd1 xd1Var, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (xd1Var != null && (charset = xd1Var.a()) == null) {
            charset = StandardCharsets.UTF_8;
            xd1Var = xd1.d(xd1Var + "; charset=utf-8");
        }
        return d(xd1Var, str.getBytes(charset));
    }

    public static p d(@Nullable xd1 xd1Var, byte[] bArr) {
        return e(xd1Var, bArr, 0, bArr.length);
    }

    public static p e(@Nullable xd1 xd1Var, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        okhttp3.internal.a.f(bArr.length, i, i2);
        return new a(xd1Var, i2, bArr, i);
    }

    public abstract long a() throws IOException;

    @Nullable
    public abstract xd1 b();

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract void h(BufferedSink bufferedSink) throws IOException;
}
