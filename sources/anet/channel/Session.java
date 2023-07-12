package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import mtopsdk.common.util.HttpHeaderConstant;
import org.apache.commons.lang3.time.DateUtils;
import tb.h01;
import tb.jg1;
import tb.jn1;
import tb.sf0;
import tb.zh2;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {
    protected Context a;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected int h;
    protected String i;
    protected int j;
    protected ConnType k;
    protected IConnStrategy l;
    protected boolean n;
    protected Runnable p;
    private Future<?> q;
    public final String r;
    public final SessionStatistic s;
    protected int t;
    protected int u;
    Map<EventCb, Integer> b = new LinkedHashMap();
    private boolean c = false;
    protected String m = null;
    protected int o = 6;
    protected boolean v = false;
    protected boolean w = true;
    private List<Long> x = null;
    private long y = 0;
    public boolean z = false;
    public boolean A = false;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;
        static final String[] a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        static String a(int i) {
            return a[i];
        }
    }

    public Session(Context context, zm zmVar) {
        boolean z = false;
        this.n = false;
        this.a = context;
        String e = zmVar.e();
        this.f = e;
        this.g = e;
        this.h = zmVar.f();
        this.k = zmVar.a();
        String d = zmVar.d();
        this.d = d;
        this.e = d.substring(d.indexOf(jg1.SCHEME_SLASH) + 3);
        this.u = zmVar.g();
        this.t = zmVar.b();
        IConnStrategy iConnStrategy = zmVar.a;
        this.l = iConnStrategy;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z = true;
        }
        this.n = z;
        this.r = zmVar.h();
        SessionStatistic sessionStatistic = new SessionStatistic(zmVar);
        this.s = sessionStatistic;
        sessionStatistic.host = this.e;
    }

    protected void a() {
        Future<?> future;
        if (this.p == null || (future = this.q) == null) {
            return;
        }
        future.cancel(true);
    }

    public abstract void b();

    public void c(boolean z) {
        this.v = z;
        b();
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(Session session) {
        return ConnType.a(this.k, session.k);
    }

    public void e() {
    }

    public IConnStrategy f() {
        return this.l;
    }

    public ConnType g() {
        return this.k;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.f;
    }

    public int j() {
        return this.h;
    }

    public String k() {
        return this.e;
    }

    protected abstract Runnable l();

    public String m() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(final int i, final sf0 sf0Var) {
        ThreadPoolExecutorFactory.k(new Runnable() { // from class: anet.channel.Session.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map<EventCb, Integer> map = Session.this.b;
                    if (map != null) {
                        for (EventCb eventCb : map.keySet()) {
                            if (eventCb != null) {
                                int intValue = Session.this.b.get(eventCb).intValue();
                                int i2 = i;
                                if ((intValue & i2) != 0) {
                                    try {
                                        eventCb.onEvent(Session.this, i2, sf0Var);
                                    } catch (Exception e) {
                                        ALog.e("awcn.Session", e.toString(), Session.this.r, new Object[0]);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    ALog.d("awcn.Session", "handleCallbacks", Session.this.r, e2, new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(anet.channel.request.a aVar, int i) {
        if (aVar.g().containsKey(HttpHeaderConstant.X_PV) && i >= 500 && i < 600) {
            synchronized (this) {
                if (this.x == null) {
                    this.x = new LinkedList();
                }
                if (this.x.size() < 5) {
                    this.x.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long longValue = this.x.remove(0).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue <= DateUtils.MILLIS_PER_MINUTE) {
                        anet.channel.strategy.a.a().forceRefreshStrategy(aVar.h());
                        this.x.clear();
                    } else {
                        this.x.add(Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(anet.channel.request.a aVar, Map<String, List<String>> map) {
        try {
            if (map.containsKey("x-switch-unit")) {
                String d = h01.d(map, "x-switch-unit");
                if (TextUtils.isEmpty(d)) {
                    d = null;
                }
                if (zh2.g(this.m, d)) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.y > DateUtils.MILLIS_PER_MINUTE) {
                    anet.channel.strategy.a.a().forceRefreshStrategy(aVar.h());
                    this.y = currentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean q();

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void r(int i, sf0 sf0Var) {
        ALog.e("awcn.Session", "notifyStatus", this.r, "status", a.a(i));
        if (i == this.o) {
            ALog.f("awcn.Session", "ignore notifyStatus", this.r, new Object[0]);
            return;
        }
        this.o = i;
        if (i == 0) {
            n(1, sf0Var);
        } else if (i == 2) {
            n(256, sf0Var);
        } else if (i == 4) {
            this.m = anet.channel.strategy.a.a().getUnitByHost(this.e);
            n(512, sf0Var);
        } else if (i == 5) {
            n(1024, sf0Var);
        } else if (i == 6) {
            s();
            if (!this.c) {
                n(2, sf0Var);
            }
        }
    }

    protected void s() {
    }

    public void t(boolean z) {
    }

    public String toString() {
        return "Session@[" + this.r + '|' + this.k + jn1.ARRAY_END;
    }

    public void u(boolean z, int i) {
    }

    public void v(int i, EventCb eventCb) {
        Map<EventCb, Integer> map = this.b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i));
        }
    }

    public abstract Cancelable w(anet.channel.request.a aVar, RequestCb requestCb);

    public void x(int i, byte[] bArr, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i) {
        if (this.p == null) {
            this.p = l();
        }
        a();
        Runnable runnable = this.p;
        if (runnable != null) {
            this.q = ThreadPoolExecutorFactory.j(runnable, i, TimeUnit.MILLISECONDS);
        }
    }
}
