package okhttp3.internal.cache;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import mtopsdk.network.util.Constants;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.internal.cache.b;
import okhttp3.l;
import okhttp3.q;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.h;
import okio.o;
import tb.ez1;
import tb.g01;
import tb.j01;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class a implements Interceptor {
    @Nullable
    final InternalCache a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0441a implements Source {
        boolean a;
        final /* synthetic */ BufferedSource b;
        final /* synthetic */ CacheRequest c;
        final /* synthetic */ BufferedSink d;

        C0441a(a aVar, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.b = bufferedSource;
            this.c = cacheRequest;
            this.d = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.a && !okhttp3.internal.a.p(this, 100, TimeUnit.MILLISECONDS)) {
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
        public o timeout() {
            return this.b.timeout();
        }
    }

    public a(@Nullable InternalCache internalCache) {
        this.a = internalCache;
    }

    private q a(CacheRequest cacheRequest, q qVar) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return qVar;
        }
        return qVar.m().b(new ez1(qVar.g("Content-Type"), qVar.a().f(), h.d(new C0441a(this, qVar.a().j(), cacheRequest, h.c(body))))).c();
    }

    private static l b(l lVar, l lVar2) {
        l.a aVar = new l.a();
        int h = lVar.h();
        for (int i = 0; i < h; i++) {
            String e = lVar.e(i);
            String j = lVar.j(i);
            if ((!"Warning".equalsIgnoreCase(e) || !j.startsWith("1")) && (c(e) || !d(e) || lVar2.c(e) == null)) {
                w31.a.b(aVar, e, j);
            }
        }
        int h2 = lVar2.h();
        for (int i2 = 0; i2 < h2; i2++) {
            String e2 = lVar2.e(i2);
            if (!c(e2) && d(e2)) {
                w31.a.b(aVar, e2, lVar2.j(i2));
            }
        }
        return aVar.e();
    }

    static boolean c(String str) {
        return Constants.Protocol.CONTENT_LENGTH.equalsIgnoreCase(str) || Constants.Protocol.CONTENT_ENCODING.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean d(String str) {
        return (IRequestConst.CONNECTION.equalsIgnoreCase(str) || IRequestConst.CONNECTION_VALUE.equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static q e(q qVar) {
        return (qVar == null || qVar.a() == null) ? qVar : qVar.m().b(null).c();
    }

    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.a;
        q qVar = internalCache != null ? internalCache.get(chain.request()) : null;
        b c = new b.a(System.currentTimeMillis(), chain.request(), qVar).c();
        okhttp3.o oVar = c.a;
        q qVar2 = c.b;
        InternalCache internalCache2 = this.a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(c);
        }
        if (qVar != null && qVar2 == null) {
            okhttp3.internal.a.g(qVar.a());
        }
        if (oVar == null && qVar2 == null) {
            return new q.a().q(chain.request()).o(Protocol.HTTP_1_1).g(504).l("Unsatisfiable Request (only-if-cached)").b(okhttp3.internal.a.EMPTY_RESPONSE).r(-1L).p(System.currentTimeMillis()).c();
        }
        if (oVar == null) {
            return qVar2.m().d(e(qVar2)).c();
        }
        try {
            q proceed = chain.proceed(oVar);
            if (proceed == null && qVar != null) {
            }
            if (qVar2 != null) {
                if (proceed.e() == 304) {
                    q c2 = qVar2.m().j(b(qVar2.j(), proceed.j())).r(proceed.r()).p(proceed.p()).d(e(qVar2)).m(e(proceed)).c();
                    proceed.a().close();
                    this.a.trackConditionalCacheHit();
                    this.a.update(qVar2, c2);
                    return c2;
                }
                okhttp3.internal.a.g(qVar2.a());
            }
            q c3 = proceed.m().d(e(qVar2)).m(e(proceed)).c();
            if (this.a != null) {
                if (g01.c(c3) && b.a(c3, oVar)) {
                    return a(this.a.put(c3), c3);
                }
                if (j01.a(oVar.g())) {
                    try {
                        this.a.remove(oVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c3;
        } finally {
            if (qVar != null) {
                okhttp3.internal.a.g(qVar.a());
            }
        }
    }
}
