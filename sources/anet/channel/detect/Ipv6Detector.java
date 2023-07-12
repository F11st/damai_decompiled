package anet.channel.detect;

import android.text.TextUtils;
import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.session.HttpSession;
import anet.channel.statist.Ipv6DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.uc.crashsdk.export.LogType;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.hu0;
import tb.jn1;
import tb.lw2;
import tb.sf0;
import tb.t9;
import tb.v70;
import tb.x6;
import tb.y90;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Ipv6Detector {
    private static v70 a;
    private static AtomicInteger b;
    private static AtomicBoolean c;
    static Random d;
    private static IStrategyFilter e;
    private static NetworkStatusHelper.INetworkStatusChangeListener f;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class a implements IStrategyFilter {
        a() {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            return lw2.d(iConnStrategy.getIp());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class b implements NetworkStatusHelper.INetworkStatusChangeListener {
        b() {
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            Ipv6Detector.f();
        }
    }

    static {
        new ConcurrentHashMap();
        b = new AtomicInteger(1);
        c = new AtomicBoolean(false);
        d = new Random();
        e = new a();
        f = new b();
    }

    public static int d() {
        if (t9.B()) {
            String j = NetworkStatusHelper.j(NetworkStatusHelper.i());
            v70 v70Var = a;
            if (v70Var != null) {
                return v70Var.a(j);
            }
            return -1;
        }
        return 1;
    }

    public static void e() {
        if (c.compareAndSet(false, true)) {
            a = new v70("networksdk_ipv6_history_records");
            f();
            NetworkStatusHelper.a(f);
        }
    }

    public static void f() {
        if (!t9.B()) {
            ALog.e("awcn.Ipv6Detector", "ipv6 detect is disable.", null, new Object[0]);
        } else if (!NetworkStatusHelper.n()) {
            ALog.e("awcn.Ipv6Detector", "network is not connected.", null, new Object[0]);
        } else if (NetworkStatusHelper.i() != NetworkStatusHelper.NetworkStatus.WIFI) {
            ALog.e("awcn.Ipv6Detector", "current network is not wifi.", null, new Object[0]);
        } else if (Inet64Util.n() != 3) {
            ALog.e("awcn.Ipv6Detector", "ip stack is not dual-stack.", null, new Object[0]);
        } else {
            final String j = NetworkStatusHelper.j(NetworkStatusHelper.i());
            if (a == null) {
                a = new v70("networksdk_ipv6_history_records");
            }
            if (a.b(j)) {
                ThreadPoolExecutorFactory.e(new Runnable() { // from class: anet.channel.detect.Ipv6Detector.1

                    /* compiled from: Taobao */
                    /* renamed from: anet.channel.detect.Ipv6Detector$1$a */
                    /* loaded from: classes.dex */
                    class a implements EventCb {
                        final /* synthetic */ Ipv6DetectStat a;
                        final /* synthetic */ long b;

                        a(Ipv6DetectStat ipv6DetectStat, long j) {
                            this.a = ipv6DetectStat;
                            this.b = j;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r7v1 */
                        /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
                        /* JADX WARN: Type inference failed for: r7v4 */
                        @Override // anet.channel.entity.EventCb
                        public void onEvent(Session session, int i, sf0 sf0Var) {
                            ?? r7 = i == 512 ? 1 : 0;
                            this.a.cip = anet.channel.strategy.a.a().getClientIp();
                            Ipv6DetectStat ipv6DetectStat = this.a;
                            ipv6DetectStat.ret = r7;
                            ipv6DetectStat.detectTime = System.currentTimeMillis() - this.b;
                            ALog.e("awcn.Ipv6Detector", "start ipv6 detect finish.", null, "uniqueId", j, "isSucc", Boolean.valueOf((boolean) r7));
                            Ipv6Detector.a.e(j, r7);
                            x6.b().commitStat(this.a);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        List<IConnStrategy> connStrategyListByHost = anet.channel.strategy.a.a().getConnStrategyListByHost("amdc.m.taobao.com", Ipv6Detector.e);
                        StringBuilder sb = new StringBuilder("http://");
                        if (connStrategyListByHost != null && connStrategyListByHost.size() > 0) {
                            str = connStrategyListByHost.get(0).getIp();
                        } else {
                            String[] c2 = y90.c();
                            str = c2.length > 0 ? c2[Ipv6Detector.d.nextInt(c2.length)] : null;
                        }
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        sb.append(jn1.ARRAY_START_STR);
                        sb.append(str);
                        sb.append(jn1.ARRAY_END_STR);
                        Ipv6DetectStat ipv6DetectStat = new Ipv6DetectStat("amdc.m.taobao.com");
                        ipv6DetectStat.ip = str;
                        ipv6DetectStat.detectUrl = sb.toString();
                        long currentTimeMillis = System.currentTimeMillis();
                        ALog.e("awcn.Ipv6Detector", "start ipv6 detect.", null, "url", sb);
                        String sb2 = sb.toString();
                        HttpSession httpSession = new HttpSession(hu0.c(), new zm(sb2, "Ipv6Detector-" + Ipv6Detector.b.getAndIncrement(), null));
                        httpSession.v(LogType.UNEXP_OTHER, new a(ipv6DetectStat, currentTimeMillis));
                        httpSession.e();
                    }
                });
            } else {
                ALog.e("awcn.Ipv6Detector", "detectHistoryRecord has ipv6-detect-record.", null, "uniqueId", j, "status", Integer.valueOf(d()));
            }
        }
    }
}
