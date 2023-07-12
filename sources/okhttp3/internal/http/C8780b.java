package okhttp3.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Interceptor;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8766c;
import okio.BufferedSink;
import okio.C8844h;
import tb.j01;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.b */
/* loaded from: classes2.dex */
public final class C8780b implements Interceptor {
    private final boolean a;

    public C8780b(boolean z) {
        this.a = z;
    }

    @Override // okhttp3.Interceptor
    public C8827q intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        C8827q c;
        C8781c c8781c = (C8781c) chain;
        C8766c a = c8781c.a();
        C8823o request = c8781c.request();
        long currentTimeMillis = System.currentTimeMillis();
        a.r(request);
        C8827q.C8828a c8828a = null;
        if (j01.b(request.g()) && request.a() != null) {
            if ("100-continue".equalsIgnoreCase(request.c("Expect"))) {
                a.g();
                a.o();
                c8828a = a.m(true);
                z = true;
            } else {
                z = false;
            }
            if (c8828a == null) {
                if (request.a().f()) {
                    a.g();
                    request.a().h(C8844h.c(a.d(request, true)));
                } else {
                    BufferedSink c2 = C8844h.c(a.d(request, false));
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
        if (c8828a == null) {
            c8828a = a.m(false);
        }
        C8827q c3 = c8828a.q(request).h(a.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
        int e = c3.e();
        if (e == 100) {
            c3 = a.m(false).q(request).h(a.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
            e = c3.e();
        }
        a.n(c3);
        if (this.a && e == 101) {
            c = c3.m().b(C8753a.EMPTY_RESPONSE).c();
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
