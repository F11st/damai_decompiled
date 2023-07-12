package anet.channel.detect;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.session.HttpSession;
import anet.channel.statist.HttpDetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.b;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.uc.crashsdk.export.LogType;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import tb.hu0;
import tb.sf0;
import tb.t9;
import tb.x6;
import tb.ym;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HttpStrategyDetector {
    private static SharedPreferences b;
    private static CopyOnWriteArraySet<String> c;
    private static AtomicInteger a = new AtomicInteger(1);
    private static IStrategyListener d = new a();
    private static IStrategyFilter e = new b();
    private static IStrategyFilter f = new c();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class a implements IStrategyListener {
        a() {
        }

        private void a(b.d[] dVarArr) {
            if (dVarArr == null || dVarArr.length == 0) {
                return;
            }
            for (b.d dVar : dVarArr) {
                String str = dVar.a;
                if (t9.l(str) || HttpStrategyDetector.c.contains(str)) {
                    if (!HttpStrategyDetector.c.contains(str)) {
                        HttpStrategyDetector.c.add(str);
                        SharedPreferences.Editor edit = HttpStrategyDetector.b.edit();
                        edit.putStringSet("http_detector_host", HttpStrategyDetector.c);
                        edit.apply();
                    }
                    HttpStrategyDetector.i(str);
                }
            }
        }

        private void b(b.e[] eVarArr) {
            if (eVarArr == null || eVarArr.length == 0) {
                return;
            }
            for (b.e eVar : eVarArr) {
                String str = eVar.a;
                if (t9.l(str) || HttpStrategyDetector.c.contains(str)) {
                    if (!HttpStrategyDetector.c.contains(str)) {
                        HttpStrategyDetector.c.add(str);
                        SharedPreferences.Editor edit = HttpStrategyDetector.b.edit();
                        edit.putStringSet("http_detector_host", HttpStrategyDetector.c);
                        edit.apply();
                    }
                    HttpStrategyDetector.i(str);
                }
            }
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(b.g gVar) {
            if (gVar == null) {
                return;
            }
            if (t9.N()) {
                a(gVar.c);
            } else {
                b(gVar.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class b implements IStrategyFilter {
        b() {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            return "https".equals(iConnStrategy.getProtocol().protocol) && iConnStrategy.getIpSource() == 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class c implements IStrategyFilter {
        c() {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            return "http".equals(iConnStrategy.getProtocol().protocol) && iConnStrategy.getIpSource() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class d implements EventCb {
        final /* synthetic */ String a;
        final /* synthetic */ IConnStrategy b;
        final /* synthetic */ boolean c;
        final /* synthetic */ List d;

        d(String str, IConnStrategy iConnStrategy, boolean z, List list) {
            this.a = str;
            this.b = iConnStrategy;
            this.c = z;
            this.d = list;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, sf0 sf0Var) {
            ym ymVar = new ym();
            HttpDetectStat httpDetectStat = new HttpDetectStat(this.a, this.b);
            int i2 = i == 512 ? 1 : 0;
            httpDetectStat.ret = i2;
            if (i2 == 0 && sf0Var != null) {
                httpDetectStat.code = sf0Var.a;
            }
            ALog.e("awcn.HttpStrategyDetector", "detect is " + httpDetectStat.ret, session.r, "host", this.a);
            x6.b().commitStat(httpDetectStat);
            if (i != 512) {
                if (i == 1024) {
                    ymVar.a = false;
                    anet.channel.strategy.a.a().notifyConnEvent(this.a, this.b, ymVar);
                    HttpStrategyDetector.j(this.a, this.c, this.d);
                    return;
                }
                return;
            }
            ymVar.a = true;
            anet.channel.strategy.a.a().notifyConnEvent(this.a, this.b, ymVar);
            try {
                anet.channel.c k = anet.channel.c.k();
                StringBuilder sb = new StringBuilder();
                sb.append(this.c ? "https://" : "http://");
                sb.append(this.a);
                k.i(sb.toString(), ConnType.TypeLevel.HTTP, 0L);
            } catch (Exception unused) {
            }
        }
    }

    public static void g() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(hu0.c());
        b = defaultSharedPreferences;
        Set<String> stringSet = defaultSharedPreferences.getStringSet("http_detector_host", null);
        c = new CopyOnWriteArraySet<>();
        if (stringSet != null && stringSet.size() > 0) {
            c.addAll(stringSet);
        }
        ALog.e("awcn.HttpStrategyDetector", "init host :" + c.toString(), null, new Object[0]);
        anet.channel.strategy.a.a().registerListener(d);
        h();
    }

    public static void h() {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = c;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() <= 0) {
            return;
        }
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final String str) {
        if (!t9.v()) {
            ALog.e("awcn.HttpStrategyDetector", "isHttpDetectEnable is false!", null, new Object[0]);
        } else if (!NetworkStatusHelper.n()) {
            ALog.e("awcn.HttpStrategyDetector", "network is not connected!", null, new Object[0]);
        } else if (TextUtils.isEmpty(str)) {
            ALog.e("awcn.HttpStrategyDetector", "host is null !", null, new Object[0]);
        } else {
            ThreadPoolExecutorFactory.e(new Runnable() { // from class: anet.channel.detect.HttpStrategyDetector.4
                @Override // java.lang.Runnable
                public void run() {
                    List<IConnStrategy> connStrategyListByHost = anet.channel.strategy.a.a().getConnStrategyListByHost(str, HttpStrategyDetector.e);
                    List<IConnStrategy> connStrategyListByHost2 = anet.channel.strategy.a.a().getConnStrategyListByHost(str, HttpStrategyDetector.f);
                    if (connStrategyListByHost != null && connStrategyListByHost.size() > 0) {
                        HttpStrategyDetector.j(str, true, connStrategyListByHost);
                    } else {
                        ALog.e("awcn.HttpStrategyDetector", "the https strategy list is empty!", null, new Object[0]);
                    }
                    if (connStrategyListByHost2 != null && connStrategyListByHost2.size() > 0) {
                        HttpStrategyDetector.j(str, false, connStrategyListByHost2);
                    } else {
                        ALog.e("awcn.HttpStrategyDetector", "the http strategy list is empty!", null, new Object[0]);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, boolean z, List<IConnStrategy> list) {
        ALog.e("awcn.HttpStrategyDetector", "startHttpDetect", null, "isSSL ", Boolean.valueOf(z), "host", str);
        IConnStrategy remove = list.remove(0);
        if (remove.getStatus() != -1) {
            ALog.e("awcn.HttpStrategyDetector", "this strategy has detected!", null, new Object[0]);
            if (remove.getStatus() == 1) {
                anet.channel.c k = anet.channel.c.k();
                StringBuilder sb = new StringBuilder();
                sb.append(z ? "https://" : "http://");
                sb.append(str);
                k.i(sb.toString(), ConnType.TypeLevel.HTTP, 0L);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "https://" : "http://");
        sb2.append(str);
        String sb3 = sb2.toString();
        HttpSession httpSession = new HttpSession(hu0.c(), new zm(sb3, "HttpDetect" + a.getAndIncrement(), remove));
        httpSession.v(LogType.UNEXP_OTHER, new d(str, remove, z, list));
        httpSession.s.isCommitted = true;
        httpSession.e();
    }
}
