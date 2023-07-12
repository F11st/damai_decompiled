package tb;

import anet.channel.request.C0193a;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.C0241c;
import anetwork.channel.aidl.ParcelableRequest;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class z12 {
    private ParcelableRequest a;
    private C0193a b;
    private int d;
    public RequestStatistic f;
    public final int g;
    public final int h;
    public final String i;
    public final int j;
    private final boolean k;
    private final String l;
    private int c = 0;
    public int e = 0;

    public z12(ParcelableRequest parcelableRequest, int i, boolean z) {
        this.b = null;
        this.d = 0;
        if (parcelableRequest != null) {
            this.a = parcelableRequest;
            this.j = i;
            this.k = z;
            this.i = na2.a(parcelableRequest.seqNo, i == 0 ? "HTTP" : "DGRD");
            int i2 = parcelableRequest.connectTimeout;
            this.g = i2 <= 0 ? (int) (C0241c.f() * 12000.0f) : i2;
            int i3 = parcelableRequest.readTimeout;
            this.h = i3 <= 0 ? (int) (C0241c.f() * 12000.0f) : i3;
            int i4 = parcelableRequest.retryTime;
            this.d = (i4 < 0 || i4 > 3) ? 2 : 2;
            o01 k = k();
            RequestStatistic requestStatistic = new RequestStatistic(k.d(), String.valueOf(parcelableRequest.bizId));
            this.f = requestStatistic;
            requestStatistic.url = k.l();
            this.f.maxRetryTime = this.d;
            this.b = a(k);
            Map<String, String> map = parcelableRequest.headers;
            this.l = map != null ? map.get(HttpHeaderConstant.F_REFER) : null;
            return;
        }
        throw new IllegalArgumentException("request is null");
    }

    private C0193a a(o01 o01Var) {
        C0193a.C0195b W = new C0193a.C0195b().a0(o01Var).R(this.a.method).M(this.a.bodyEntry).T(this.h).O(this.g).U(this.a.allowRedirect).V(this.c).L(this.a.bizId).X(this.i).W(this.f);
        W.S(this.a.params);
        String str = this.a.charset;
        if (str != null) {
            W.N(str);
        }
        W.P(j(o01Var));
        return W.J();
    }

    private Map<String, String> j(o01 o01Var) {
        String d = o01Var.d();
        boolean z = !lw2.c(d);
        if (d.length() > 2 && d.charAt(0) == '[' && d.charAt(d.length() - 1) == ']' && lw2.d(d.substring(1, d.length() - 1))) {
            z = false;
        }
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.a.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!BizTime.HOST.equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean equalsIgnoreCase = "true".equalsIgnoreCase(this.a.getExtProperty("KeepCustomCookie"));
                    if (!IRequestConst.COOKIE.equalsIgnoreCase(key) || equalsIgnoreCase) {
                        hashMap.put(key, entry.getValue());
                    }
                } else if (!z) {
                    hashMap.put(BizTime.HOST, entry.getValue());
                }
            }
        }
        return hashMap;
    }

    private o01 k() {
        o01 g = o01.g(this.a.url);
        if (g != null) {
            if (!rj1.E()) {
                ALog.f("anet.RequestConfig", "request ssl disabled.", this.i, new Object[0]);
                g.b();
            } else if ("false".equalsIgnoreCase(this.a.getExtProperty("EnableSchemeReplace"))) {
                g.f();
            }
            return g;
        }
        throw new IllegalArgumentException("url is invalid. url=" + this.a.url);
    }

    public C0193a b() {
        return this.b;
    }

    public String c() {
        return this.l;
    }

    public Map<String, String> d() {
        return this.b.g();
    }

    public o01 e() {
        return this.b.j();
    }

    public Map<String, String> f() {
        return this.a.extProperties;
    }

    public String g(String str) {
        return this.a.getExtProperty(str);
    }

    public String h() {
        return this.b.q();
    }

    public int i() {
        return this.h * (this.d + 1);
    }

    public boolean l() {
        return this.e < this.d;
    }

    public boolean m() {
        return rj1.q() && !"false".equalsIgnoreCase(this.a.getExtProperty("EnableHttpDns")) && (rj1.g() || this.e == 0);
    }

    public boolean n() {
        return !"false".equalsIgnoreCase(this.a.getExtProperty("EnableCookie"));
    }

    public boolean o() {
        return this.k;
    }

    public void p(o01 o01Var) {
        ALog.f("anet.RequestConfig", "redirect", this.i, "to url", o01Var.toString());
        this.c++;
        this.f.url = o01Var.l();
        this.b = a(o01Var);
    }

    public void q() {
        int i = this.e + 1;
        this.e = i;
        this.f.retryTimes = i;
    }

    public void r(C0193a c0193a) {
        this.b = c0193a;
    }

    public boolean s() {
        return "true".equals(this.a.getExtProperty("CheckContentLength"));
    }
}
