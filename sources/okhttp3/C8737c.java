package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import okhttp3.C8816l;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.internal.C8753a;
import okhttp3.internal.cache.C8761b;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.C8783e;
import okhttp3.internal.io.FileSystem;
import okio.AbstractC8839c;
import okio.AbstractC8840d;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.C8844h;
import okio.Sink;
import okio.Source;
import tb.g01;
import tb.j01;
import tb.ps1;
import tb.xd1;

/* compiled from: Taobao */
/* renamed from: okhttp3.c */
/* loaded from: classes2.dex */
public final class C8737c implements Closeable, Flushable {
    final InternalCache a;
    final DiskLruCache b;
    int c;
    int d;
    private int e;
    private int f;
    private int g;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.c$a */
    /* loaded from: classes2.dex */
    class C8738a implements InternalCache {
        C8738a() {
        }

        @Override // okhttp3.internal.cache.InternalCache
        @Nullable
        public C8827q get(C8823o c8823o) throws IOException {
            return C8737c.this.b(c8823o);
        }

        @Override // okhttp3.internal.cache.InternalCache
        @Nullable
        public CacheRequest put(C8827q c8827q) throws IOException {
            return C8737c.this.d(c8827q);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void remove(C8823o c8823o) throws IOException {
            C8737c.this.f(c8823o);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackConditionalCacheHit() {
            C8737c.this.g();
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackResponse(C8761b c8761b) {
            C8737c.this.h(c8761b);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void update(C8827q c8827q, C8827q c8827q2) {
            C8737c.this.i(c8827q, c8827q2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.c$b */
    /* loaded from: classes2.dex */
    public final class C8739b implements CacheRequest {
        private final DiskLruCache.C8755b a;
        private Sink b;
        private Sink c;
        boolean d;

        /* compiled from: Taobao */
        /* renamed from: okhttp3.c$b$a */
        /* loaded from: classes2.dex */
        class C8740a extends AbstractC8839c {
            final /* synthetic */ DiskLruCache.C8755b a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C8740a(Sink sink, C8737c c8737c, DiskLruCache.C8755b c8755b) {
                super(sink);
                this.a = c8755b;
            }

            @Override // okio.AbstractC8839c, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (C8737c.this) {
                    C8739b c8739b = C8739b.this;
                    if (c8739b.d) {
                        return;
                    }
                    c8739b.d = true;
                    C8737c.this.c++;
                    super.close();
                    this.a.b();
                }
            }
        }

        C8739b(DiskLruCache.C8755b c8755b) {
            this.a = c8755b;
            Sink d = c8755b.d(1);
            this.b = d;
            this.c = new C8740a(d, C8737c.this, c8755b);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (C8737c.this) {
                if (this.d) {
                    return;
                }
                this.d = true;
                C8737c.this.d++;
                C8753a.g(this.b);
                try {
                    this.a.a();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.c$c */
    /* loaded from: classes2.dex */
    public static class C8741c extends AbstractC8829r {
        final DiskLruCache.C8758d a;
        private final BufferedSource b;
        @Nullable
        private final String c;
        @Nullable
        private final String d;

        /* compiled from: Taobao */
        /* renamed from: okhttp3.c$c$a */
        /* loaded from: classes2.dex */
        class C8742a extends AbstractC8840d {
            final /* synthetic */ DiskLruCache.C8758d a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C8742a(C8741c c8741c, Source source, DiskLruCache.C8758d c8758d) {
                super(source);
                this.a = c8758d;
            }

            @Override // okio.AbstractC8840d, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.a.close();
                super.close();
            }
        }

        C8741c(DiskLruCache.C8758d c8758d, String str, String str2) {
            this.a = c8758d;
            this.c = str;
            this.d = str2;
            this.b = C8844h.d(new C8742a(this, c8758d.b(1), c8758d));
        }

        @Override // okhttp3.AbstractC8829r
        public long f() {
            try {
                String str = this.d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.AbstractC8829r
        public xd1 g() {
            String str = this.c;
            if (str != null) {
                return xd1.d(str);
            }
            return null;
        }

        @Override // okhttp3.AbstractC8829r
        public BufferedSource j() {
            return this.b;
        }
    }

    public C8737c(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    private void a(@Nullable DiskLruCache.C8755b c8755b) {
        if (c8755b != null) {
            try {
                c8755b.a();
            } catch (IOException unused) {
            }
        }
    }

    public static String c(C8818m c8818m) {
        return ByteString.encodeUtf8(c8818m.toString()).md5().hex();
    }

    static int e(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong < 0 || readDecimalLong > 2147483647L || !readUtf8LineStrict.isEmpty()) {
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
            }
            return (int) readDecimalLong;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Nullable
    C8827q b(C8823o c8823o) {
        try {
            DiskLruCache.C8758d i = this.b.i(c(c8823o.i()));
            if (i == null) {
                return null;
            }
            try {
                C8743d c8743d = new C8743d(i.b(0));
                C8827q d = c8743d.d(i);
                if (c8743d.b(c8823o, d)) {
                    return d;
                }
                C8753a.g(d.a());
                return null;
            } catch (IOException unused) {
                C8753a.g(i);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Nullable
    CacheRequest d(C8827q c8827q) {
        DiskLruCache.C8755b c8755b;
        String g = c8827q.q().g();
        if (j01.a(c8827q.q().g())) {
            try {
                f(c8827q.q());
            } catch (IOException unused) {
            }
            return null;
        } else if (!g.equals("GET") || g01.e(c8827q)) {
            return null;
        } else {
            C8743d c8743d = new C8743d(c8827q);
            try {
                c8755b = this.b.g(c(c8827q.q().i()));
                if (c8755b == null) {
                    return null;
                }
                try {
                    c8743d.f(c8755b);
                    return new C8739b(c8755b);
                } catch (IOException unused2) {
                    a(c8755b);
                    return null;
                }
            } catch (IOException unused3) {
                c8755b = null;
            }
        }
    }

    void f(C8823o c8823o) throws IOException {
        this.b.q(c(c8823o.i()));
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    synchronized void g() {
        this.f++;
    }

    synchronized void h(C8761b c8761b) {
        this.g++;
        if (c8761b.a != null) {
            this.e++;
        } else if (c8761b.b != null) {
            this.f++;
        }
    }

    void i(C8827q c8827q, C8827q c8827q2) {
        DiskLruCache.C8755b c8755b;
        C8743d c8743d = new C8743d(c8827q2);
        try {
            c8755b = ((C8741c) c8827q.a()).a.a();
            if (c8755b != null) {
                try {
                    c8743d.f(c8755b);
                    c8755b.b();
                } catch (IOException unused) {
                    a(c8755b);
                }
            }
        } catch (IOException unused2) {
            c8755b = null;
        }
    }

    C8737c(File file, long j, FileSystem fileSystem) {
        this.a = new C8738a();
        this.b = DiskLruCache.e(fileSystem, file, 201105, 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.c$d */
    /* loaded from: classes2.dex */
    public static final class C8743d {
        private static final String k = ps1.j().k() + "-Sent-Millis";
        private static final String l = ps1.j().k() + "-Received-Millis";
        private final String a;
        private final C8816l b;
        private final String c;
        private final Protocol d;
        private final int e;
        private final String f;
        private final C8816l g;
        @Nullable
        private final C8815k h;
        private final long i;
        private final long j;

        C8743d(Source source) throws IOException {
            TlsVersion tlsVersion;
            try {
                BufferedSource d = C8844h.d(source);
                this.a = d.readUtf8LineStrict();
                this.c = d.readUtf8LineStrict();
                C8816l.C8817a c8817a = new C8816l.C8817a();
                int e = C8737c.e(d);
                for (int i = 0; i < e; i++) {
                    c8817a.b(d.readUtf8LineStrict());
                }
                this.b = c8817a.e();
                C8783e a = C8783e.a(d.readUtf8LineStrict());
                this.d = a.a;
                this.e = a.b;
                this.f = a.c;
                C8816l.C8817a c8817a2 = new C8816l.C8817a();
                int e2 = C8737c.e(d);
                for (int i2 = 0; i2 < e2; i2++) {
                    c8817a2.b(d.readUtf8LineStrict());
                }
                String str = k;
                String f = c8817a2.f(str);
                String str2 = l;
                String f2 = c8817a2.f(str2);
                c8817a2.g(str);
                c8817a2.g(str2);
                this.i = f != null ? Long.parseLong(f) : 0L;
                this.j = f2 != null ? Long.parseLong(f2) : 0L;
                this.g = c8817a2.e();
                if (a()) {
                    String readUtf8LineStrict = d.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        C8747e b = C8747e.b(d.readUtf8LineStrict());
                        List<Certificate> c = c(d);
                        List<Certificate> c2 = c(d);
                        if (!d.exhausted()) {
                            tlsVersion = TlsVersion.forJavaName(d.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.h = C8815k.c(tlsVersion, b, c, c2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.h = null;
                }
            } finally {
                source.close();
            }
        }

        private boolean a() {
            return this.a.startsWith("https://");
        }

        private List<Certificate> c(BufferedSource bufferedSource) throws IOException {
            int e = C8737c.e(bufferedSource);
            if (e == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(e);
                for (int i = 0; i < e; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void e(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean b(C8823o c8823o, C8827q c8827q) {
            return this.a.equals(c8823o.i().toString()) && this.c.equals(c8823o.g()) && g01.o(c8827q, this.b, c8823o);
        }

        public C8827q d(DiskLruCache.C8758d c8758d) {
            String c = this.g.c("Content-Type");
            String c2 = this.g.c(Constants.Protocol.CONTENT_LENGTH);
            return new C8827q.C8828a().q(new C8823o.C8824a().k(this.a).f(this.c, null).e(this.b).b()).o(this.d).g(this.e).l(this.f).j(this.g).b(new C8741c(c8758d, c, c2)).h(this.h).r(this.i).p(this.j).c();
        }

        public void f(DiskLruCache.C8755b c8755b) throws IOException {
            BufferedSink c = C8844h.c(c8755b.d(0));
            c.writeUtf8(this.a).writeByte(10);
            c.writeUtf8(this.c).writeByte(10);
            c.writeDecimalLong(this.b.h()).writeByte(10);
            int h = this.b.h();
            for (int i = 0; i < h; i++) {
                c.writeUtf8(this.b.e(i)).writeUtf8(": ").writeUtf8(this.b.j(i)).writeByte(10);
            }
            c.writeUtf8(new C8783e(this.d, this.e, this.f).toString()).writeByte(10);
            c.writeDecimalLong(this.g.h() + 2).writeByte(10);
            int h2 = this.g.h();
            for (int i2 = 0; i2 < h2; i2++) {
                c.writeUtf8(this.g.e(i2)).writeUtf8(": ").writeUtf8(this.g.j(i2)).writeByte(10);
            }
            c.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.i).writeByte(10);
            c.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.j).writeByte(10);
            if (a()) {
                c.writeByte(10);
                c.writeUtf8(this.h.a().e()).writeByte(10);
                e(c, this.h.f());
                e(c, this.h.d());
                c.writeUtf8(this.h.g().javaName()).writeByte(10);
            }
            c.close();
        }

        C8743d(C8827q c8827q) {
            this.a = c8827q.q().i().toString();
            this.b = g01.n(c8827q);
            this.c = c8827q.q().g();
            this.d = c8827q.o();
            this.e = c8827q.e();
            this.f = c8827q.k();
            this.g = c8827q.j();
            this.h = c8827q.f();
            this.i = c8827q.r();
            this.j = c8827q.p();
        }
    }
}
