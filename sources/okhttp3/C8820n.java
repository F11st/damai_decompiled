package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import okhttp3.C8816l;
import okhttp3.internal.C8753a;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import tb.jn1;
import tb.xd1;

/* compiled from: Taobao */
/* renamed from: okhttp3.n */
/* loaded from: classes2.dex */
public final class C8820n extends AbstractC8825p {
    private final ByteString a;
    private final xd1 b;
    private final List<C8822b> c;
    private long d = -1;
    public static final xd1 MIXED = xd1.c("multipart/mixed");
    public static final xd1 ALTERNATIVE = xd1.c("multipart/alternative");
    public static final xd1 DIGEST = xd1.c("multipart/digest");
    public static final xd1 PARALLEL = xd1.c("multipart/parallel");
    public static final xd1 FORM = xd1.c("multipart/form-data");
    private static final byte[] e = {58, 32};
    private static final byte[] f = {13, 10};
    private static final byte[] g = {45, 45};

    /* compiled from: Taobao */
    /* renamed from: okhttp3.n$a */
    /* loaded from: classes2.dex */
    public static final class C8821a {
        private final ByteString a;
        private xd1 b;
        private final List<C8822b> c;

        public C8821a() {
            this(UUID.randomUUID().toString());
        }

        public C8821a a(String str, String str2) {
            return c(C8822b.b(str, str2));
        }

        public C8821a b(String str, @Nullable String str2, AbstractC8825p abstractC8825p) {
            return c(C8822b.c(str, str2, abstractC8825p));
        }

        public C8821a c(C8822b c8822b) {
            Objects.requireNonNull(c8822b, "part == null");
            this.c.add(c8822b);
            return this;
        }

        public C8820n d() {
            if (!this.c.isEmpty()) {
                return new C8820n(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public C8821a(String str) {
            this.b = C8820n.MIXED;
            this.c = new ArrayList();
            this.a = ByteString.encodeUtf8(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.n$b */
    /* loaded from: classes2.dex */
    public static final class C8822b {
        @Nullable
        final C8816l a;
        final AbstractC8825p b;

        private C8822b(@Nullable C8816l c8816l, AbstractC8825p abstractC8825p) {
            this.a = c8816l;
            this.b = abstractC8825p;
        }

        public static C8822b a(@Nullable C8816l c8816l, AbstractC8825p abstractC8825p) {
            Objects.requireNonNull(abstractC8825p, "body == null");
            if (c8816l != null && c8816l.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (c8816l != null && c8816l.c(Constants.Protocol.CONTENT_LENGTH) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new C8822b(c8816l, abstractC8825p);
        }

        public static C8822b b(String str, String str2) {
            return c(str, null, AbstractC8825p.c(null, str2));
        }

        public static C8822b c(String str, @Nullable String str2, AbstractC8825p abstractC8825p) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            C8820n.i(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                C8820n.i(sb, str2);
            }
            return a(new C8816l.C8817a().d("Content-Disposition", sb.toString()).e(), abstractC8825p);
        }
    }

    C8820n(ByteString byteString, xd1 xd1Var, List<C8822b> list) {
        this.a = byteString;
        this.b = xd1.c(xd1Var + "; boundary=" + byteString.utf8());
        this.c = C8753a.t(list);
    }

    static void i(StringBuilder sb, String str) {
        sb.append(jn1.QUOTE);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(jn1.QUOTE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long j(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.c.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C8822b c8822b = this.c.get(i);
            C8816l c8816l = c8822b.a;
            AbstractC8825p abstractC8825p = c8822b.b;
            bufferedSink.write(g);
            bufferedSink.write(this.a);
            bufferedSink.write(f);
            if (c8816l != null) {
                int h = c8816l.h();
                for (int i2 = 0; i2 < h; i2++) {
                    bufferedSink.writeUtf8(c8816l.e(i2)).write(e).writeUtf8(c8816l.j(i2)).write(f);
                }
            }
            xd1 b = abstractC8825p.b();
            if (b != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(b.toString()).write(f);
            }
            long a = abstractC8825p.a();
            if (a != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(a).write(f);
            } else if (z) {
                buffer.clear();
                return -1L;
            }
            byte[] bArr = f;
            bufferedSink.write(bArr);
            if (z) {
                j += a;
            } else {
                abstractC8825p.h(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = g;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.a);
        bufferedSink.write(bArr2);
        bufferedSink.write(f);
        if (z) {
            long size2 = j + buffer.size();
            buffer.clear();
            return size2;
        }
        return j;
    }

    @Override // okhttp3.AbstractC8825p
    public long a() throws IOException {
        long j = this.d;
        if (j != -1) {
            return j;
        }
        long j2 = j(null, true);
        this.d = j2;
        return j2;
    }

    @Override // okhttp3.AbstractC8825p
    public xd1 b() {
        return this.b;
    }

    @Override // okhttp3.AbstractC8825p
    public void h(BufferedSink bufferedSink) throws IOException {
        j(bufferedSink, false);
    }
}
