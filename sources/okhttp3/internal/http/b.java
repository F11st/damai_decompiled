package okhttp3.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.o;
import okhttp3.q;
import okio.BufferedSink;
import okio.h;
import tb.j01;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class b implements Interceptor {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        q c;
        c cVar = (c) chain;
        okhttp3.internal.connection.c a = cVar.a();
        o request = cVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        a.r(request);
        q.a aVar = null;
        if (j01.b(request.g()) && request.a() != null) {
            if ("100-continue".equalsIgnoreCase(request.c("Expect"))) {
                a.g();
                a.o();
                aVar = a.m(true);
                z = true;
            } else {
                z = false;
            }
            if (aVar == null) {
                if (request.a().f()) {
                    a.g();
                    request.a().h(h.c(a.d(request, true)));
                } else {
                    BufferedSink c2 = h.c(a.d(request, false));
                    request.a().h(c2);
                    c2.close();
                }
            } else {
                a.k();
                if (!a.c().m()) {
                    a.j();
                }
            }
        } else {
            a.k();
            z = false;
        }
        if (request.a() == null || !request.a().f()) {
            a.f();
        }
        if (!z) {
            a.o();
        }
        if (aVar == null) {
            aVar = a.m(false);
        }
        q c3 = aVar.q(request).h(a.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
        int e = c3.e();
        if (e == 100) {
            c3 = a.m(false).q(request).h(a.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
            e = c3.e();
        }
        a.n(c3);
        if (this.a && e == 101) {
            c = c3.m().b(okhttp3.internal.a.EMPTY_RESPONSE).c();
        } else {
            c = c3.m().b(a.l(c3)).c();
        }
        if ("close".equalsIgnoreCase(c.q().c(IRequestConst.CONNECTION)) || "close".equalsIgnoreCase(c.g(IRequestConst.CONNECTION))) {
            a.j();
        }
        if ((e == 204 || e == 205) && c.a().f() > 0) {
            throw new ProtocolException("HTTP " + e + " had non-zero Content-Length: " + c.a().f());
        }
        return c;
    }
}
