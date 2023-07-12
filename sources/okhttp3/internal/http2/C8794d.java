package okhttp3.internal.http2;

import com.taobao.login4android.constants.LoginConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import okhttp3.C8816l;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8770e;
import okhttp3.internal.http.C8783e;
import okhttp3.internal.http.ExchangeCodec;
import okio.Sink;
import okio.Source;
import tb.d22;
import tb.g01;
import tb.w31;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.d */
/* loaded from: classes2.dex */
public final class C8794d implements ExchangeCodec {
    private static final List<String> g = C8753a.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", LoginConstants.LOGIN_UPGRADE, C8789a.TARGET_METHOD_UTF8, C8789a.TARGET_PATH_UTF8, C8789a.TARGET_SCHEME_UTF8, C8789a.TARGET_AUTHORITY_UTF8);
    private static final List<String> h = C8753a.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", LoginConstants.LOGIN_UPGRADE);
    private final Interceptor.Chain a;
    private final C8770e b;
    private final Http2Connection c;
    private volatile C8795e d;
    private final Protocol e;
    private volatile boolean f;

    public C8794d(OkHttpClient okHttpClient, C8770e c8770e, Interceptor.Chain chain, Http2Connection http2Connection) {
        this.b = c8770e;
        this.a = chain;
        this.c = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.e = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List<C8789a> a(C8823o c8823o) {
        C8816l e = c8823o.e();
        ArrayList arrayList = new ArrayList(e.h() + 4);
        arrayList.add(new C8789a(C8789a.TARGET_METHOD, c8823o.g()));
        arrayList.add(new C8789a(C8789a.TARGET_PATH, d22.c(c8823o.i())));
        String c = c8823o.c(BizTime.HOST);
        if (c != null) {
            arrayList.add(new C8789a(C8789a.TARGET_AUTHORITY, c));
        }
        arrayList.add(new C8789a(C8789a.TARGET_SCHEME, c8823o.i().C()));
        int h2 = e.h();
        for (int i = 0; i < h2; i++) {
            String lowerCase = e.e(i).toLowerCase(Locale.US);
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && e.j(i).equals("trailers"))) {
                arrayList.add(new C8789a(lowerCase, e.j(i)));
            }
        }
        return arrayList;
    }

    public static C8827q.C8828a b(C8816l c8816l, Protocol protocol) throws IOException {
        C8816l.C8817a c8817a = new C8816l.C8817a();
        int h2 = c8816l.h();
        C8783e c8783e = null;
        for (int i = 0; i < h2; i++) {
            String e = c8816l.e(i);
            String j = c8816l.j(i);
            if (e.equals(C8789a.RESPONSE_STATUS_UTF8)) {
                c8783e = C8783e.a("HTTP/1.1 " + j);
            } else if (!h.contains(e)) {
                w31.a.b(c8817a, e, j);
            }
        }
        if (c8783e != null) {
            return new C8827q.C8828a().o(protocol).g(c8783e.b).l(c8783e.c).j(c8817a.e());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.f = true;
        if (this.d != null) {
            this.d.f(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C8770e connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(C8823o c8823o, long j) {
        return this.d.h();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.d.h().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.c.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(C8827q c8827q) {
        return this.d.i();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C8827q.C8828a readResponseHeaders(boolean z) throws IOException {
        C8827q.C8828a b = b(this.d.p(), this.e);
        if (z && w31.a.d(b) == 100) {
            return null;
        }
        return b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(C8827q c8827q) {
        return g01.b(c8827q);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C8816l trailers() throws IOException {
        return this.d.q();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(C8823o c8823o) throws IOException {
        if (this.d != null) {
            return;
        }
        this.d = this.c.t(a(c8823o), c8823o.a() != null);
        if (!this.f) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.d.l().timeout(this.a.readTimeoutMillis(), timeUnit);
            this.d.s().timeout(this.a.writeTimeoutMillis(), timeUnit);
            return;
        }
        this.d.f(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    }
}
