package anet.channel.session;

import android.content.Context;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.request.C0193a;
import anet.channel.request.Cancelable;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.C0240b;
import anet.channel.util.C0241c;
import anet.channel.util.Inet64Util;
import com.ali.user.open.tbauth.TbAuthConstants;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.C9708t9;
import tb.cf0;
import tb.g22;
import tb.h01;
import tb.he;
import tb.lw2;
import tb.sf0;
import tb.vp0;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HttpSession extends Session {
    private SSLSocketFactory B;
    private boolean C;

    public HttpSession(Context context, zm zmVar) {
        super(context, zmVar);
        this.C = false;
        if (this.l == null) {
            String str = this.d;
            this.k = (str == null || !str.startsWith("https")) ? ConnType.d : ConnType.e;
        } else if (C9708t9.w() && this.k.equals(ConnType.e)) {
            this.B = new C0240b(this.e);
        }
    }

    public void F(boolean z) {
        this.C = z;
    }

    @Override // anet.channel.Session
    public void b() {
        r(6, null);
    }

    @Override // anet.channel.Session
    public void c(boolean z) {
        this.v = false;
        b();
    }

    @Override // anet.channel.Session
    public void e() {
        try {
            IConnStrategy iConnStrategy = this.l;
            if (iConnStrategy != null && iConnStrategy.getIpSource() == 1) {
                r(4, new sf0(1));
                return;
            }
            IConnStrategy iConnStrategy2 = this.l;
            if (iConnStrategy2 != null && iConnStrategy2.getStatus() == 1) {
                r(4, new sf0(1));
                return;
            }
            C0193a.C0195b U = new C0193a.C0195b().Z(this.d).X(this.r).O((int) (this.t * C0241c.f())).T((int) (this.u * C0241c.f())).U(false);
            SSLSocketFactory sSLSocketFactory = this.B;
            if (sSLSocketFactory != null) {
                U.Y(sSLSocketFactory);
            }
            if (this.n) {
                U.I(BizTime.HOST, this.f);
            }
            if (C9708t9.k() && Inet64Util.p() && lw2.c(this.f)) {
                try {
                    this.g = Inet64Util.e(this.f);
                } catch (Exception unused) {
                }
            }
            ALog.e("awcn.HttpSession", "HttpSession connect", null, "host", this.d, TbAuthConstants.IP, this.g, "port", Integer.valueOf(this.h));
            final C0193a J = U.J();
            J.w(this.g, this.h);
            ThreadPoolExecutorFactory.g(new Runnable() { // from class: anet.channel.session.HttpSession.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = C0201a.a(J).a;
                    if (i > 0) {
                        HttpSession.this.r(4, new sf0(1));
                    } else {
                        HttpSession.this.n(256, new sf0(256, i, "Http connect fail"));
                    }
                }
            }, ThreadPoolExecutorFactory.C0235b.c);
        } catch (Throwable th) {
            ALog.d("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    @Override // anet.channel.Session
    protected Runnable l() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean q() {
        return this.o == 4;
    }

    @Override // anet.channel.Session
    public Cancelable w(final C0193a c0193a, final RequestCb requestCb) {
        vp0 vp0Var;
        vp0 vp0Var2 = vp0.NULL;
        C0193a.C0195b c0195b = null;
        final RequestStatistic requestStatistic = c0193a != null ? c0193a.r : new RequestStatistic(this.e, null);
        requestStatistic.setConnType(this.k);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        requestStatistic.isComplex = this.s.isComplex;
        if (c0193a == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, cf0.b(-102), requestStatistic);
            }
            return vp0Var2;
        }
        try {
            if (c0193a.o() == null && this.B != null) {
                c0195b = c0193a.u().Y(this.B);
            }
            if (this.n) {
                if (c0195b == null) {
                    c0195b = c0193a.u();
                }
                c0195b.I(BizTime.HOST, this.f);
            }
            if (c0195b != null) {
                c0193a = c0195b.J();
            }
            if (this.g == null) {
                String d = c0193a.j().d();
                if (C9708t9.k() && Inet64Util.p() && lw2.c(d)) {
                    try {
                        this.g = Inet64Util.e(d);
                    } catch (Exception unused) {
                    }
                }
            }
            c0193a.w(this.g, this.h);
            c0193a.x(this.k.k());
            IConnStrategy iConnStrategy = this.l;
            if (iConnStrategy != null) {
                c0193a.r.setIpInfo(iConnStrategy.getIpSource(), this.l.getIpType());
            } else {
                c0193a.r.setIpInfo(1, 1);
            }
            c0193a.r.unit = this.m;
            Runnable runnable = new Runnable() { // from class: anet.channel.session.HttpSession.2

                /* compiled from: Taobao */
                /* renamed from: anet.channel.session.HttpSession$2$a */
                /* loaded from: classes.dex */
                class C0197a implements RequestCb {
                    C0197a() {
                    }

                    @Override // anet.channel.RequestCb
                    public void onDataReceive(he heVar, boolean z) {
                        requestCb.onDataReceive(heVar, z);
                    }

                    @Override // anet.channel.RequestCb
                    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                        if (i <= 0 && i != -204) {
                            HttpSession.this.n(2, new sf0(2, 0, "Http connect fail"));
                        }
                        requestCb.onFinish(i, str, requestStatistic);
                    }

                    @Override // anet.channel.RequestCb
                    public void onResponseCode(int i, Map<String, List<String>> map) {
                        ALog.f("awcn.HttpSession", "", c0193a.n(), "httpStatusCode", Integer.valueOf(i));
                        ALog.f("awcn.HttpSession", "", c0193a.n(), "response headers", map);
                        requestCb.onResponseCode(i, map);
                        requestStatistic.serverRT = h01.h(map);
                        requestStatistic.eagleEyeId = h01.g(map);
                        requestStatistic.isHitCache = h01.e(map);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        HttpSession.this.o(c0193a, i);
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        HttpSession.this.p(c0193a, map);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    c0193a.r.sendBeforeTime = System.currentTimeMillis() - c0193a.r.reqStart;
                    C0201a.c(c0193a, new C0197a(), HttpSession.this.C);
                }
            };
            if (!this.C) {
                vp0Var = new vp0(ThreadPoolExecutorFactory.g(runnable, g22.a(c0193a)), c0193a.n());
            } else {
                vp0Var = new vp0(ThreadPoolExecutorFactory.c(runnable), c0193a.n());
            }
            return vp0Var;
        } catch (Throwable th) {
            requestCb.onFinish(-101, cf0.a(-101, th.toString()), requestStatistic);
            return vp0Var2;
        }
    }
}
