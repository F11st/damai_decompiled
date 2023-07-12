package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C8753a;
import okio.BufferedSink;
import tb.xd1;

/* compiled from: Taobao */
/* renamed from: okhttp3.p */
/* loaded from: classes2.dex */
public abstract class AbstractC8825p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.p$a */
    /* loaded from: classes2.dex */
    public class C8826a extends AbstractC8825p {
        final /* synthetic */ xd1 a;
        final /* synthetic */ int b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ int d;

        C8826a(xd1 xd1Var, int i, byte[] bArr, int i2) {
            this.a = xd1Var;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // okhttp3.AbstractC8825p
        public long a() {
            return this.b;
        }

        @Override // okhttp3.AbstractC8825p
        @Nullable
        public xd1 b() {
            return this.a;
        }

        @Override // okhttp3.AbstractC8825p
        public void h(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.c, this.d, this.b);
        }
    }

    public static AbstractC8825p c(@Nullable xd1 xd1Var, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (xd1Var != null && (charset = xd1Var.a()) == null) {
            charset = StandardCharsets.UTF_8;
            xd1Var = xd1.d(xd1Var + "; charset=utf-8");
        }
        return d(xd1Var, str.getBytes(charset));
    }

    public static AbstractC8825p d(@Nullable xd1 xd1Var, byte[] bArr) {
        return e(xd1Var, bArr, 0, bArr.length);
    }

    public static AbstractC8825p e(@Nullable xd1 xd1Var, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        C8753a.f(bArr.length, i, i2);
        return new C8826a(xd1Var, i2, bArr, i);
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
