package anet.channel.detect;

import android.content.Context;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.C0193a;
import anet.channel.session.C0201a;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.C0214b;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyListener;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.C0240b;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.netutil.C8875b;
import org.android.netutil.PingTask;
import tb.C9708t9;
import tb.cf0;
import tb.he;
import tb.hu0;
import tb.jg1;
import tb.lw2;
import tb.o01;
import tb.sf0;
import tb.x6;
import tb.zm;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorseRaceDetector {
    private TreeMap<String, C0214b.C0220f> a = new TreeMap<>();
    private AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.HorseRaceDetector$a */
    /* loaded from: classes.dex */
    public class C0168a implements IStrategyListener {
        C0168a() {
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(C0214b.C0221g c0221g) {
            C0214b.C0220f[] c0220fArr;
            int i = 0;
            ALog.f("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
            if (!C9708t9.s() || (c0220fArr = c0221g.d) == null || c0220fArr.length == 0) {
                return;
            }
            synchronized (HorseRaceDetector.this.a) {
                while (true) {
                    C0214b.C0220f[] c0220fArr2 = c0221g.d;
                    if (i < c0220fArr2.length) {
                        C0214b.C0220f c0220f = c0220fArr2[i];
                        HorseRaceDetector.this.a.put(c0220f.a, c0220f);
                        i++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.HorseRaceDetector$b */
    /* loaded from: classes.dex */
    public class C0169b implements EventCb {
        final /* synthetic */ HorseRaceStat a;
        final /* synthetic */ long b;
        final /* synthetic */ String c;
        final /* synthetic */ C0214b.C0224j d;
        final /* synthetic */ TnetSpdySession e;

        /* compiled from: Taobao */
        /* renamed from: anet.channel.detect.HorseRaceDetector$b$a */
        /* loaded from: classes.dex */
        class C0170a implements RequestCb {
            C0170a() {
            }

            @Override // anet.channel.RequestCb
            public void onDataReceive(he heVar, boolean z) {
            }

            @Override // anet.channel.RequestCb
            public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                ALog.f("anet.HorseRaceDetector", "LongLinkTask request finish", C0169b.this.c, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i), "msg", str);
                if (C0169b.this.a.reqErrorCode == 0) {
                    C0169b.this.a.reqErrorCode = i;
                } else {
                    HorseRaceStat horseRaceStat = C0169b.this.a;
                    horseRaceStat.reqRet = horseRaceStat.reqErrorCode == 200 ? 1 : 0;
                }
                HorseRaceStat horseRaceStat2 = C0169b.this.a;
                long currentTimeMillis = System.currentTimeMillis();
                C0169b c0169b = C0169b.this;
                horseRaceStat2.reqTime = (currentTimeMillis - c0169b.b) + c0169b.a.connTime;
                synchronized (C0169b.this.a) {
                    C0169b.this.a.notify();
                }
            }

            @Override // anet.channel.RequestCb
            public void onResponseCode(int i, Map<String, List<String>> map) {
                C0169b.this.a.reqErrorCode = i;
            }
        }

        C0169b(HorseRaceDetector horseRaceDetector, HorseRaceStat horseRaceStat, long j, String str, C0214b.C0224j c0224j, TnetSpdySession tnetSpdySession) {
            this.a = horseRaceStat;
            this.b = j;
            this.c = str;
            this.d = c0224j;
            this.e = tnetSpdySession;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, sf0 sf0Var) {
            if (this.a.connTime != 0) {
                return;
            }
            this.a.connTime = System.currentTimeMillis() - this.b;
            if (i == 1) {
                ALog.f("anet.HorseRaceDetector", "tnetSpdySession connect success", this.c, new Object[0]);
                this.a.connRet = 1;
                o01 g = o01.g(session.h() + this.d.c);
                if (g == null) {
                    return;
                }
                this.e.w(new C0193a.C0195b().a0(g).T(this.d.b.d).U(false).X(this.c).J(), new C0170a());
                return;
            }
            this.a.connErrorCode = sf0Var.a;
            synchronized (this.a) {
                this.a.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.HorseRaceDetector$c */
    /* loaded from: classes.dex */
    public static class C0171c implements IConnStrategy {
        final /* synthetic */ C0214b.C0224j a;
        final /* synthetic */ ConnProtocol b;

        C0171c(C0214b.C0224j c0224j, ConnProtocol connProtocol) {
            this.a = c0224j;
            this.b = connProtocol;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getConnectionTimeout() {
            return this.a.b.c;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getHeartbeat() {
            return 0;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public String getIp() {
            return this.a.a;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpSource() {
            return 2;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getIpType() {
            return 1;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getPort() {
            return this.a.b.a;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public ConnProtocol getProtocol() {
            return this.b;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getReadTimeout() {
            return this.a.b.d;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getRetryTimes() {
            return 0;
        }

        @Override // anet.channel.strategy.IConnStrategy
        public int getStatus() {
            return -1;
        }
    }

    private static IConnStrategy c(ConnProtocol connProtocol, C0214b.C0224j c0224j) {
        return new C0171c(c0224j, connProtocol);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ALog.e("anet.HorseRaceDetector", "network detect thread start", null, new Object[0]);
        while (true) {
            synchronized (this.a) {
                if (!C9708t9.s()) {
                    this.a.clear();
                    return;
                }
                Map.Entry<String, C0214b.C0220f> pollFirstEntry = this.a.pollFirstEntry();
                if (pollFirstEntry == null) {
                    return;
                }
                try {
                    i(pollFirstEntry.getValue());
                } catch (Exception e) {
                    ALog.d("anet.HorseRaceDetector", "start hr task failed", null, e, new Object[0]);
                }
            }
        }
    }

    private void f(String str, C0214b.C0224j c0224j) {
        ConnProtocol valueOf = ConnProtocol.valueOf(c0224j.b);
        ConnType l = ConnType.l(valueOf);
        if (l == null) {
            return;
        }
        ALog.f("anet.HorseRaceDetector", "startLongLinkTask", null, "host", str, TbAuthConstants.IP, c0224j.a, "port", Integer.valueOf(c0224j.b.a), "protocol", valueOf);
        String str2 = "HR" + this.b.getAndIncrement();
        Context c = hu0.c();
        StringBuilder sb = new StringBuilder();
        sb.append(l.k() ? "https://" : "http://");
        sb.append(str);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(c, new zm(sb.toString(), str2, c(valueOf, c0224j)));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, c0224j);
        long currentTimeMillis = System.currentTimeMillis();
        tnetSpdySession.v(257, new C0169b(this, horseRaceStat, currentTimeMillis, str2, c0224j, tnetSpdySession));
        tnetSpdySession.e();
        synchronized (horseRaceStat) {
            try {
                int i = c0224j.b.c;
                if (i == 0) {
                    i = 10000;
                }
                horseRaceStat.wait(i);
                if (horseRaceStat.connTime == 0) {
                    horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
                }
                g(c0224j.a, horseRaceStat);
                x6.b().commitStat(horseRaceStat);
            } catch (InterruptedException unused) {
            }
        }
        tnetSpdySession.c(false);
    }

    private void g(String str, HorseRaceStat horseRaceStat) {
        if (lw2.d(str)) {
            try {
                C8875b c8875b = new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (c8875b == null) {
                    return;
                }
                horseRaceStat.pingSuccessCount = c8875b.f();
                horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                horseRaceStat.localIP = c8875b.d();
            } catch (Throwable th) {
                ALog.d("anet.HorseRaceDetector", "ping6 task fail.", null, th, new Object[0]);
            }
        }
    }

    private void h(String str, C0214b.C0224j c0224j) {
        o01 g = o01.g(c0224j.b.b + jg1.SCHEME_SLASH + str + c0224j.c);
        if (g == null) {
            return;
        }
        ALog.f("anet.HorseRaceDetector", "startShortLinkTask", null, "url", g);
        C0193a.C0195b Y = new C0193a.C0195b().a0(g).I(IRequestConst.CONNECTION, "close").O(c0224j.b.c).T(c0224j.b.d).U(false).Y(new C0240b(str));
        C0193a J = Y.X("HR" + this.b.getAndIncrement()).J();
        J.w(c0224j.a, c0224j.b.a);
        long currentTimeMillis = System.currentTimeMillis();
        C0201a.C0203b a = C0201a.a(J);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, c0224j);
        horseRaceStat.connTime = currentTimeMillis2;
        int i = a.a;
        if (i <= 0) {
            horseRaceStat.connErrorCode = i;
        } else {
            horseRaceStat.connRet = 1;
            horseRaceStat.reqRet = a.a == 200 ? 1 : 0;
            horseRaceStat.reqErrorCode = a.a;
            horseRaceStat.reqTime = horseRaceStat.connTime;
        }
        g(c0224j.a, horseRaceStat);
        x6.b().commitStat(horseRaceStat);
    }

    private void i(C0214b.C0220f c0220f) {
        C0214b.C0224j[] c0224jArr = c0220f.b;
        if (c0224jArr == null || c0224jArr.length == 0) {
            return;
        }
        String str = c0220f.a;
        int i = 0;
        while (true) {
            C0214b.C0224j[] c0224jArr2 = c0220f.b;
            if (i >= c0224jArr2.length) {
                return;
            }
            C0214b.C0224j c0224j = c0224jArr2[i];
            String str2 = c0224j.b.b;
            if (!str2.equalsIgnoreCase("http") && !str2.equalsIgnoreCase("https")) {
                if (!str2.equalsIgnoreCase(ConnType.HTTP2) && !str2.equalsIgnoreCase(ConnType.SPDY) && !str2.equalsIgnoreCase(ConnType.QUIC)) {
                    if (str2.equalsIgnoreCase("tcp")) {
                        j(str, c0224j);
                    }
                } else {
                    f(str, c0224j);
                }
            } else {
                h(str, c0224j);
            }
            i++;
        }
    }

    private void j(String str, C0214b.C0224j c0224j) {
        String str2 = "HR" + this.b.getAndIncrement();
        ALog.f("anet.HorseRaceDetector", "startTcpTask", str2, TbAuthConstants.IP, c0224j.a, "port", Integer.valueOf(c0224j.b.a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, c0224j);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(c0224j.a, c0224j.b.a);
            int i = c0224j.b.c;
            if (i == 0) {
                i = 10000;
            }
            socket.setSoTimeout(i);
            ALog.f("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            horseRaceStat.connErrorCode = cf0.ERROR_IO_EXCEPTION;
        }
        x6.b().commitStat(horseRaceStat);
    }

    public void d() {
        C0213a.a().registerListener(new C0168a());
        AppLifecycle.f(new AppLifecycle.AppLifecycleListener() { // from class: anet.channel.detect.HorseRaceDetector.2
            @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
            public void background() {
                ALog.f("anet.HorseRaceDetector", "background", null, new Object[0]);
                if (C9708t9.s()) {
                    ThreadPoolExecutorFactory.f(new Runnable() { // from class: anet.channel.detect.HorseRaceDetector.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HorseRaceDetector.this.e();
                        }
                    });
                }
            }

            @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
            public void forground() {
            }
        });
    }
}
