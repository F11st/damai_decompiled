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
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.io.FileSystem;
import okhttp3.l;
import okhttp3.o;
import okhttp3.q;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import tb.g01;
import tb.j01;
import tb.ps1;
import tb.xd1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class c implements Closeable, Flushable {
    final InternalCache a;
    final DiskLruCache b;
    int c;
    int d;
    private int e;
    private int f;
    private int g;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class a implements InternalCache {
        a() {
        }

        @Override // okhttp3.internal.cache.InternalCache
        @Nullable
        public q get(o oVar) throws IOException {
            return c.this.b(oVar);
        }

        @Override // okhttp3.internal.cache.InternalCache
        @Nullable
        public CacheRequest put(q qVar) throws IOException {
            return c.this.d(qVar);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void remove(o oVar) throws IOException {
            c.this.f(oVar);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackConditionalCacheHit() {
            c.this.g();
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackResponse(okhttp3.internal.cache.b bVar) {
            c.this.h(bVar);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void update(q qVar, q qVar2) {
            c.this.i(qVar, qVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class b implements CacheRequest {
        private final DiskLruCache.b a;
        private Sink b;
        private Sink c;
        boolean d;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        class a extends okio.c {
            final /* synthetic */ DiskLruCache.b a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Sink sink, c cVar, DiskLruCache.b bVar) {
                super(sink);
                this.a = bVar;
            }

            @Override // okio.c, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (c.this) {
                    b bVar = b.this;
                    if (bVar.d) {
                        return;
                    }
                    bVar.d = true;
                    c.this.c++;
                    super.close();
                    this.a.b();
                }
            }
        }

        b(DiskLruCache.b bVar) {
            this.a = bVar;
            Sink d = bVar.d(1);
            this.b = d;
            this.c = new a(d, c.this, bVar);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (c.this) {
                if (this.d) {
                    return;
                }
                this.d = true;
                c.this.d++;
                okhttp3.internal.a.g(this.b);
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
    /* renamed from: okhttp3.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0440c extends r {
        final DiskLruCache.d a;
        private final BufferedSource b;
        @Nullable
        private final String c;
        @Nullable
        private final String d;

        /* compiled from: Taobao */
        /* renamed from: okhttp3.c$c$a */
        /* loaded from: classes2.dex */
        class a extends okio.d {
            final /* synthetic */ DiskLruCache.d a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C0440c c0440c, Source source, DiskLruCache.d dVar) {
                super(source);
                this.a = dVar;
            }

            @Override // okio.d, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.a.close();
                super.close();
            }
        }

        C0440c(DiskLruCache.d dVar, String str, String str2) {
            this.a = dVar;
            this.c = str;
            this.d = str2;
            this.b = okio.h.d(new a(this, dVar.b(1), dVar));
        }

        @Override // okhttp3.r
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

        @Override // okhttp3.r
        public xd1 g() {
            String str = this.c;
            if (str != null) {
                return xd1.d(str);
            }
            return null;
        }

        @Override // okhttp3.r
        public BufferedSource j() {
            return this.b;
        }
    }

    public c(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    private void a(@Nullable DiskLruCache.b bVar) {
        if (bVar != null) {
            try {
                bVar.a();
            } catch (IOException unused) {
            }
        }
    }

    public static String c(m mVar) {
        return ByteString.encodeUtf8(mVar.toString()).md5().hex();
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
    q b(o oVar) {
        try {
            DiskLruCache.d i = this.b.i(c(oVar.i()));
            if (i == null) {
                return null;
            }
            try {
                d dVar = new d(i.b(0));
                q d2 = dVar.d(i);
                if (dVar.b(oVar, d2)) {
                    return d2;
                }
                okhttp3.internal.a.g(d2.a());
                return null;
            } catch (IOException unused) {
                okhttp3.internal.a.g(i);
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
    CacheRequest d(q qVar) {
        DiskLruCache.b bVar;
        String g = qVar.q().g();
        if (j01.a(qVar.q().g())) {
            try {
                f(qVar.q());
            } catch (IOException unused) {
            }
            return null;
        } else if (!g.equals("GET") || g01.e(qVar)) {
            return null;
        } else {
            d dVar = new d(qVar);
            try {
                bVar = this.b.g(c(qVar.q().i()));
                if (bVar == null) {
                    return null;
                }
                try {
                    dVar.f(bVar);
                    return new b(bVar);
                } catch (IOException unused2) {
                    a(bVar);
                    return null;
                }
            } catch (IOException unused3) {
                bVar = null;
            }
        }
    }

    void f(o oVar) throws IOException {
        this.b.q(c(oVar.i()));
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    synchronized void g() {
        this.f++;
    }

    synchronized void h(okhttp3.internal.cache.b bVar) {
        this.g++;
        if (bVar.a != null) {
            this.e++;
        } else if (bVar.b != null) {
            this.f++;
        }
    }

    void i(q qVar, q qVar2) {
        DiskLruCache.b bVar;
        d dVar = new d(qVar2);
        try {
            bVar = ((C0440c) qVar.a()).a.a();
            if (bVar != null) {
                try {
                    dVar.f(bVar);
                    bVar.b();
                } catch (IOException unused) {
                    a(bVar);
                }
            }
        } catch (IOException unused2) {
            bVar = null;
        }
    }

    c(File file, long j, FileSystem fileSystem) {
        this.a = new a();
        this.b = DiskLruCache.e(fileSystem, file, 201105, 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class d {
        private static final String k = ps1.j().k() + "-Sent-Millis";
        private static final String l = ps1.j().k() + "-Received-Millis";
        private final String a;
        private final l b;
        private final String c;
        private final Protocol d;
        private final int e;
        private final String f;
        private final l g;
        @Nullable
        private final k h;
        private final long i;
        private final long j;

        d(Source source) throws IOException {
            TlsVersion tlsVersion;
            try {
                BufferedSource d = okio.h.d(source);
                this.a = d.readUtf8LineStrict();
                this.c = d.readUtf8LineStrict();
                l.a aVar = new l.a();
                int e = c.e(d);
                for (int i = 0; i < e; i++) {
                    aVar.b(d.readUtf8LineStrict());
                }
                this.b = aVar.e();
                okhttp3.internal.http.e a = okhttp3.internal.http.e.a(d.readUtf8LineStrict());
                this.d = a.a;
                this.e = a.b;
                this.f = a.c;
                l.a aVar2 = new l.a();
                int e2 = c.e(d);
                for (int i2 = 0; i2 < e2; i2++) {
                    aVar2.b(d.readUtf8LineStrict());
                }
                String str = k;
                String f = aVar2.f(str);
                String str2 = l;
                String f2 = aVar2.f(str2);
                aVar2.g(str);
                aVar2.g(str2);
                this.i = f != null ? Long.parseLong(f) : 0L;
                this.j = f2 != null ? Long.parseLong(f2) : 0L;
                this.g = aVar2.e();
                if (a()) {
                    String readUtf8LineStrict = d.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        e b = e.b(d.readUtf8LineStrict());
                        List<Certificate> c = c(d);
                        List<Certificate> c2 = c(d);
                        if (!d.exhausted()) {
                            tlsVersion = TlsVersion.forJavaName(d.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.h = k.c(tlsVersion, b, c, c2);
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
            int e = c.e(bufferedSource);
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

        public boolean b(o oVar, q qVar) {
            return this.a.equals(oVar.i().toString()) && this.c.equals(oVar.g()) && g01.o(qVar, this.b, oVar);
        }

        public q d(DiskLruCache.d dVar) {
            String c = this.g.c("Content-Type");
            String c2 = this.g.c(Constants.Protocol.CONTENT_LENGTH);
            return new q.a().q(new o.a().k(this.a).f(this.c, null).e(this.b).b()).o(this.d).g(this.e).l(this.f).j(this.g).b(new C0440c(dVar, c, c2)).h(this.h).r(this.i).p(this.j).c();
        }

        public void f(DiskLruCache.b bVar) throws IOException {
            BufferedSink c = okio.h.c(bVar.d(0));
            c.writeUtf8(this.a).writeByte(10);
            c.writeUtf8(this.c).writeByte(10);
            c.writeDecimalLong(this.b.h()).writeByte(10);
            int h = this.b.h();
            for (int i = 0; i < h; i++) {
                c.writeUtf8(this.b.e(i)).writeUtf8(": ").writeUtf8(this.b.j(i)).writeByte(10);
            }
            c.writeUtf8(new okhttp3.internal.http.e(this.d, this.e, this.f).toString()).writeByte(10);
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

        d(q qVar) {
            this.a = qVar.q().i().toString();
            this.b = g01.n(qVar);
            this.c = qVar.q().g();
            this.d = qVar.o();
            this.e = qVar.e();
            this.f = qVar.k();
            this.g = qVar.j();
            this.h = qVar.f();
            this.i = qVar.r();
            this.j = qVar.p();
        }
    }
}
