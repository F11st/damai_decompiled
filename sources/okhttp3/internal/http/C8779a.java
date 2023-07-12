package okhttp3.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.n.C4250a;
import java.io.IOException;
import java.util.List;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import okhttp3.AbstractC8825p;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.internal.C8753a;
import okio.C8842f;
import okio.C8844h;
import tb.ez1;
import tb.fx2;
import tb.g01;
import tb.go;
import tb.xd1;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.a */
/* loaded from: classes2.dex */
public final class C8779a implements Interceptor {
    private final CookieJar a;

    public C8779a(CookieJar cookieJar) {
        this.a = cookieJar;
    }

    private String a(List<go> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            go goVar = list.get(i);
            sb.append(goVar.c());
            sb.append(C4250a.h);
            sb.append(goVar.k());
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    public C8827q intercept(Interceptor.Chain chain) throws IOException {
        C8823o request = chain.request();
        C8823o.C8824a h = request.h();
        AbstractC8825p a = request.a();
        if (a != null) {
            xd1 b = a.b();
            if (b != null) {
                h.d("Content-Type", b.toString());
            }
            long a2 = a.a();
            if (a2 != -1) {
                h.d(Constants.Protocol.CONTENT_LENGTH, Long.toString(a2));
                h.h("Transfer-Encoding");
            } else {
                h.d("Transfer-Encoding", "chunked");
                h.h(Constants.Protocol.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.c(BizTime.HOST) == null) {
            h.d(BizTime.HOST, C8753a.s(request.i(), false));
        }
        if (request.c(IRequestConst.CONNECTION) == null) {
            h.d(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        }
        if (request.c("Accept-Encoding") == null && request.c("Range") == null) {
            z = true;
            h.d("Accept-Encoding", "gzip");
        }
        List<go> loadForRequest = this.a.loadForRequest(request.i());
        if (!loadForRequest.isEmpty()) {
            h.d(IRequestConst.COOKIE, a(loadForRequest));
        }
        if (request.c(IRequestConst.USER_AGENT) == null) {
            h.d(IRequestConst.USER_AGENT, fx2.a());
        }
        C8827q proceed = chain.proceed(h.b());
        g01.g(this.a, request.i(), proceed.j());
        C8827q.C8828a q = proceed.m().q(request);
        if (z && "gzip".equalsIgnoreCase(proceed.g(Constants.Protocol.CONTENT_ENCODING)) && g01.c(proceed)) {
            C8842f c8842f = new C8842f(proceed.a().j());
            q.j(proceed.j().f().g(Constants.Protocol.CONTENT_ENCODING).g(Constants.Protocol.CONTENT_LENGTH).e());
            q.b(new ez1(proceed.g("Content-Type"), -1L, C8844h.d(c8842f)));
        }
        return q.c();
    }
}
