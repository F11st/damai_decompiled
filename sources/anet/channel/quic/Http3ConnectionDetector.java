package anet.channel.quic;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.C0162c;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.C0214b;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import tb.C9708t9;
import tb.ab2;
import tb.hu0;
import tb.o01;
import tb.sf0;
import tb.v70;
import tb.x6;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Http3ConnectionDetector {
    private static v70 a;
    private static String b;
    private static SharedPreferences f;
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static AtomicBoolean e = new AtomicBoolean(false);
    private static boolean g = false;
    private static IStrategyFilter h = new C0187a();
    private static AtomicInteger i = new AtomicInteger(1);
    private static IStrategyListener j = new C0188b();
    private static NetworkStatusHelper.INetworkStatusChangeListener k = new C0189c();
    private static AppLifecycle.AppLifecycleListener l = new C0190d();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.quic.Http3ConnectionDetector$a */
    /* loaded from: classes.dex */
    static class C0187a implements IStrategyFilter {
        C0187a() {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            String str = iConnStrategy.getProtocol().protocol;
            return ConnType.HTTP3.equals(str) || ConnType.HTTP3_PLAIN.equals(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.quic.Http3ConnectionDetector$b */
    /* loaded from: classes.dex */
    static class C0188b implements IStrategyListener {
        C0188b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
            if (r3.equals(anet.channel.quic.Http3ConnectionDetector.b) != false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:
            r0 = anet.channel.quic.Http3ConnectionDetector.b = r3;
            r12 = anet.channel.quic.Http3ConnectionDetector.f.edit();
            r12.putString("http3_detector_host", anet.channel.quic.Http3ConnectionDetector.b);
            r12.apply();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0076, code lost:
            anet.channel.quic.Http3ConnectionDetector.o(anet.channel.status.NetworkStatusHelper.i());
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0084, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(anet.channel.strategy.C0214b.C0218d[] r12) {
            /*
                r11 = this;
                if (r12 == 0) goto L88
                int r0 = r12.length
                if (r0 != 0) goto L7
                goto L88
            L7:
                r0 = 0
                r1 = 0
            L9:
                int r2 = r12.length
                if (r1 >= r2) goto L88
                r2 = r12[r1]
                java.lang.String r3 = r2.a
                boolean r4 = tb.C9708t9.t(r3)
                if (r4 != 0) goto L84
                anet.channel.strategy.b$i[] r4 = r2.k
                if (r4 != 0) goto L1b
                goto L84
            L1b:
                r4 = 0
            L1c:
                anet.channel.strategy.b$i[] r5 = r2.k
                int r6 = r5.length
                if (r4 >= r6) goto L84
                r5 = r5[r4]
                anet.channel.strategy.b$b[] r5 = r5.a
                if (r5 == 0) goto L81
                int r6 = r5.length
                if (r6 != 0) goto L2b
                goto L81
            L2b:
                r6 = 0
            L2c:
                int r7 = r5.length
                if (r6 >= r7) goto L81
                r7 = r5[r6]
                anet.channel.strategy.b$c[] r7 = r7.b
                if (r7 == 0) goto L7e
                int r8 = r7.length
                if (r8 != 0) goto L39
                goto L7e
            L39:
                r8 = 0
            L3a:
                int r9 = r7.length
                if (r8 >= r9) goto L7e
                r9 = r7[r8]
                java.lang.String r9 = r9.b
                java.lang.String r10 = "http3"
                boolean r10 = r10.equals(r9)
                if (r10 != 0) goto L55
                java.lang.String r10 = "http3plain"
                boolean r9 = r10.equals(r9)
                if (r9 == 0) goto L52
                goto L55
            L52:
                int r8 = r8 + 1
                goto L3a
            L55:
                java.lang.String r12 = anet.channel.quic.Http3ConnectionDetector.a()
                boolean r12 = r3.equals(r12)
                if (r12 != 0) goto L76
                anet.channel.quic.Http3ConnectionDetector.b(r3)
                android.content.SharedPreferences r12 = anet.channel.quic.Http3ConnectionDetector.c()
                android.content.SharedPreferences$Editor r12 = r12.edit()
                java.lang.String r0 = anet.channel.quic.Http3ConnectionDetector.a()
                java.lang.String r1 = "http3_detector_host"
                r12.putString(r1, r0)
                r12.apply()
            L76:
                anet.channel.status.NetworkStatusHelper$NetworkStatus r12 = anet.channel.status.NetworkStatusHelper.i()
                anet.channel.quic.Http3ConnectionDetector.o(r12)
                return
            L7e:
                int r6 = r6 + 1
                goto L2c
            L81:
                int r4 = r4 + 1
                goto L1c
            L84:
                int r1 = r1 + 1
                goto L9
            L88:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.quic.Http3ConnectionDetector.C0188b.a(anet.channel.strategy.b$d[]):void");
        }

        private void b(C0214b.C0219e[] c0219eArr) {
            if (c0219eArr == null || c0219eArr.length == 0) {
                return;
            }
            for (int i = 0; i < c0219eArr.length; i++) {
                String str = c0219eArr[i].a;
                if (!C9708t9.t(str)) {
                    C0214b.C0215a[] c0215aArr = c0219eArr[i].h;
                    if (c0215aArr != null && c0215aArr.length > 0) {
                        for (C0214b.C0215a c0215a : c0215aArr) {
                            String str2 = c0215a.b;
                            if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
                                if (!str.equals(Http3ConnectionDetector.b)) {
                                    String unused = Http3ConnectionDetector.b = str;
                                    SharedPreferences.Editor edit = Http3ConnectionDetector.f.edit();
                                    edit.putString("http3_detector_host", Http3ConnectionDetector.b);
                                    edit.apply();
                                }
                                Http3ConnectionDetector.o(NetworkStatusHelper.i());
                                return;
                            }
                        }
                    }
                    C0214b.C0224j[] c0224jArr = c0219eArr[i].i;
                    if (c0224jArr != null) {
                        for (int i2 = 0; i2 < c0224jArr.length; i2++) {
                            if (c0224jArr[i2].b != null) {
                                String str3 = c0224jArr[i2].b.b;
                                if (ConnType.HTTP3.equals(str3) || ConnType.HTTP3_PLAIN.equals(str3)) {
                                    if (!str.equals(Http3ConnectionDetector.b)) {
                                        String unused2 = Http3ConnectionDetector.b = str;
                                        SharedPreferences.Editor edit2 = Http3ConnectionDetector.f.edit();
                                        edit2.putString("http3_detector_host", Http3ConnectionDetector.b);
                                        edit2.apply();
                                    }
                                    Http3ConnectionDetector.o(NetworkStatusHelper.i());
                                    return;
                                }
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(C0214b.C0221g c0221g) {
            if (c0221g == null) {
                return;
            }
            if (C9708t9.N()) {
                a(c0221g.c);
            } else {
                b(c0221g.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.quic.Http3ConnectionDetector$c */
    /* loaded from: classes.dex */
    static class C0189c implements NetworkStatusHelper.INetworkStatusChangeListener {
        C0189c() {
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.quic.Http3ConnectionDetector$d */
    /* loaded from: classes.dex */
    static class C0190d implements AppLifecycle.AppLifecycleListener {
        C0190d() {
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            if (Http3ConnectionDetector.g) {
                Http3ConnectionDetector.o(NetworkStatusHelper.i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.quic.Http3ConnectionDetector$e */
    /* loaded from: classes.dex */
    public static class C0191e implements IConnStrategy {
        final /* synthetic */ IConnStrategy a;

        C0191e(IConnStrategy iConnStrategy) {
            this.a = iConnStrategy;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getConnectionTimeout() {
            return this.a.getConnectionTimeout();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getHeartbeat() {
            return this.a.getHeartbeat();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public String getIp() {
            return this.a.getIp();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpSource() {
            return this.a.getIpSource();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpType() {
            return this.a.getIpType();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getPort() {
            return this.a.getPort();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public ConnProtocol getProtocol() {
            this.a.getProtocol();
            return ConnProtocol.valueOf(ConnType.HTTP3_1RTT, null, null);
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getReadTimeout() {
            return this.a.getReadTimeout();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getRetryTimes() {
            return this.a.getRetryTimes();
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getStatus() {
            return this.a.getStatus();
        }
    }

    public static int i() {
        v70 v70Var = a;
        if (v70Var != null) {
            return v70Var.a(NetworkStatusHelper.j(NetworkStatusHelper.i()));
        }
        return -1;
    }

    public static boolean j() {
        return i() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IConnStrategy k(IConnStrategy iConnStrategy) {
        return new C0191e(iConnStrategy);
    }

    public static void l() {
        try {
            if (c.compareAndSet(false, true)) {
                ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(C9708t9.u()));
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(hu0.c());
                f = defaultSharedPreferences;
                b = defaultSharedPreferences.getString("http3_detector_host", "");
                m();
                NetworkStatusHelper.a(k);
                AppLifecycle.f(l);
                C0213a.a().registerListener(j);
            }
        } catch (Exception e2) {
            ALog.d("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    private static void m() {
        if (o(NetworkStatusHelper.i()) || !C9708t9.r()) {
            return;
        }
        C0162c.k().j(o01.g("https://guide-acs.m.taobao.com"), ab2.a, 0L);
    }

    public static void n(long j2) {
    }

    public static boolean o(final NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!C9708t9.u()) {
            ALog.f("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return false;
        } else if (e.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return false;
        } else if (NetworkStatusHelper.n()) {
            if (TextUtils.isEmpty(b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return false;
            }
            final List<IConnStrategy> connStrategyListByHost = C0213a.a().getConnStrategyListByHost(b, h);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return false;
            }
            if (d.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(hu0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    ALog.d("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    e.set(true);
                    return false;
                }
            }
            if (a == null) {
                a = new v70("networksdk_http3_history_records");
            }
            if (a.b(NetworkStatusHelper.j(networkStatus))) {
                ThreadPoolExecutorFactory.e(new Runnable() { // from class: anet.channel.quic.Http3ConnectionDetector.5

                    /* compiled from: Taobao */
                    /* renamed from: anet.channel.quic.Http3ConnectionDetector$5$a */
                    /* loaded from: classes.dex */
                    class C0186a implements EventCb {
                        final /* synthetic */ IConnStrategy a;

                        C0186a(IConnStrategy iConnStrategy) {
                            this.a = iConnStrategy;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r8v1 */
                        /* JADX WARN: Type inference failed for: r8v11 */
                        /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
                        @Override // anet.channel.entity.EventCb
                        public void onEvent(Session session, int i, sf0 sf0Var) {
                            ?? r8 = i == 1 ? 1 : 0;
                            boolean unused = Http3ConnectionDetector.g = false;
                            if (hu0.i() && r8 == 0) {
                                boolean unused2 = Http3ConnectionDetector.g = true;
                                return;
                            }
                            String j = NetworkStatusHelper.j(networkStatus);
                            ALog.e("awcn.Http3ConnDetector", "enable http3", null, "uniqueId", j, "enable", Boolean.valueOf((boolean) r8));
                            Http3ConnectionDetector.a.e(j, r8);
                            session.c(false);
                            Http3DetectStat http3DetectStat = new Http3DetectStat(Http3ConnectionDetector.b, this.a);
                            http3DetectStat.ret = r8;
                            if (r8 == 0 && sf0Var != null) {
                                http3DetectStat.code = sf0Var.a;
                            }
                            http3DetectStat.isBg = hu0.i() ? "bg" : "fg";
                            x6.b().commitStat(http3DetectStat);
                            C0162c.k().j(o01.g("https://guide-acs.m.taobao.com"), ab2.a, 0L);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IConnStrategy iConnStrategy = (IConnStrategy) connStrategyListByHost.get(0);
                        TnetSpdySession tnetSpdySession = new TnetSpdySession(hu0.c(), new zm("https://" + Http3ConnectionDetector.b, "Http3Detect" + Http3ConnectionDetector.i.getAndIncrement(), Http3ConnectionDetector.k(iConnStrategy)));
                        tnetSpdySession.v(257, new C0186a(iConnStrategy));
                        tnetSpdySession.s.isCommitted = true;
                        tnetSpdySession.e();
                    }
                });
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
