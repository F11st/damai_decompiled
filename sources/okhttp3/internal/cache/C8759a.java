package okhttp3.internal.cache;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import okhttp3.C8816l;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.internal.C8753a;
import okhttp3.internal.cache.C8761b;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.C8844h;
import okio.C8857o;
import okio.Sink;
import okio.Source;
import tb.ez1;
import tb.g01;
import tb.j01;
import tb.w31;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.cache.a */
/* loaded from: classes2.dex */
public final class C8759a implements Interceptor {
    @Nullable
    final InternalCache a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.a$a */
    /* loaded from: classes2.dex */
    public class C8760a implements Source {
        boolean a;
        final /* synthetic */ BufferedSource b;
        final /* synthetic */ CacheRequest c;
        final /* synthetic */ BufferedSink d;

        C8760a(C8759a c8759a, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.b = bufferedSource;
            this.c = cacheRequest;
            this.d = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.a && !C8753a.p(this, 100, TimeUnit.MILLISECONDS)) {
                this.a = true;
                this.c.abort();
            }
            this.b.close();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = this.b.read(buffer, j);
                if (read == -1) {
                    if (!this.a) {
                        this.a = true;
                        this.d.close();
                    }
                    return -1L;
                }
                buffer.copyTo(this.d.buffer(), buffer.size() - read, read);
                this.d.emitCompleteSegments();
                return read;
            } catch (IOException e) {
                if (!this.a) {
                    this.a = true;
                    this.c.abort();
                }
                throw e;
            }
        }

        @Override // okio.Source
        public C8857o timeout() {
            return this.b.timeout();
        }
    }

    public C8759a(@Nullable InternalCache internalCache) {
        this.a = internalCache;
    }

    private C8827q a(CacheRequest cacheRequest, C8827q c8827q) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return c8827q;
        }
        return c8827q.m().b(new ez1(c8827q.g("Content-Type"), c8827q.a().f(), C8844h.d(new C8760a(this, c8827q.a().j(), cacheRequest, C8844h.c(body))))).c();
    }

    private static C8816l b(C8816l c8816l, C8816l c8816l2) {
        C8816l.C8817a c8817a = new C8816l.C8817a();
        int h = c8816l.h();
        for (int i = 0; i < h; i++) {
            String e = c8816l.e(i);
            String j = c8816l.j(i);
            if ((!"Warning".equalsIgnoreCase(e) || !j.startsWith("1")) && (c(e) || !d(e) || c8816l2.c(e) == null)) {
                w31.a.b(c8817a, e, j);
            }
        }
        int h2 = c8816l2.h();
        for (int i2 = 0; i2 < h2; i2++) {
            String e2 = c8816l2.e(i2);
            if (!c(e2) && d(e2)) {
                w31.a.b(c8817a, e2, c8816l2.j(i2));
            }
        }
        return c8817a.e();
    }

    static boolean c(String str) {
        return Constants.Protocol.CONTENT_LENGTH.equalsIgnoreCase(str) || Constants.Protocol.CONTENT_ENCODING.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean d(String str) {
        return (IRequestConst.CONNECTION.equalsIgnoreCase(str) || IRequestConst.CONNECTION_VALUE.equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static C8827q e(C8827q c8827q) {
        return (c8827q == null || c8827q.a() == null) ? c8827q : c8827q.m().b(null).c();
    }

    @Override // okhttp3.Interceptor
    public C8827q intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.a;
        C8827q c8827q = internalCache != null ? internalCache.get(chain.request()) : null;
        C8761b c = new C8761b.C8762a(System.currentTimeMillis(), chain.request(), c8827q).c();
        C8823o c8823o = c.a;
        C8827q c8827q2 = c.b;
        InternalCache internalCache2 = this.a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(c);
        }
        if (c8827q != null && c8827q2 == null) {
            C8753a.g(c8827q.a());
        }
        if (c8823o == null && c8827q2 == null) {
            return new C8827q.C8828a().q(chain.request()).o(Protocol.HTTP_1_1).g(504).l("Unsatisfiable Request (only-if-cached)").b(C8753a.EMPTY_RESPONSE).r(-1L).p(System.currentTimeMillis()).c();
        }
        if (c8823o == null) {
            return c8827q2.m().d(e(c8827q2)).c();
        }
        try {
            C8827q proceed = chain.proceed(c8823o);
            if (proceed == null && c8827q != null) {
            }
            if (c8827q2 != null) {
                if (proceed.e() == 304) {
                    C8827q c2 = c8827q2.m().j(b(c8827q2.j(), proceed.j())).r(proceed.r()).p(proceed.p()).d(e(c8827q2)).m(e(proceed)).c();
                    proceed.a().close();
                    this.a.trackConditionalCacheHit();
                    this.a.update(c8827q2, c2);
                    return c2;
                }
                C8753a.g(c8827q2.a());
            }
            C8827q c3 = proceed.m().d(e(c8827q2)).m(e(proceed)).c();
            if (this.a != null) {
                if (g01.c(c3) && C8761b.a(c3, c8823o)) {
                    return a(this.a.put(c3), c3);
                }
                if (j01.a(c8823o.g())) {
                    try {
                        this.a.remove(c8823o);
                    } catch (IOException unused) {
                    }
                }
            }
            return c3;
        } finally {
            if (c8827q != null) {
                C8753a.g(c8827q.a());
            }
        }
    }
}
