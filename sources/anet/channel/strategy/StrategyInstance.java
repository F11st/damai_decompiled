package anet.channel.strategy;

import android.content.Context;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0214b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.util.ALog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import tb.C9708t9;
import tb.a5;
import tb.g62;
import tb.lw2;
import tb.o01;
import tb.ym;
import tb.z90;
import tb.zh2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyInstance implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {
    boolean a = false;
    StrategyInfoHolder b = null;
    long c = 0;
    CopyOnWriteArraySet<IStrategyListener> d = new CopyOnWriteArraySet<>();
    private IStrategyFilter e = new C0209a(this);

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.StrategyInstance$a */
    /* loaded from: classes.dex */
    class C0209a implements IStrategyFilter {
        C0209a(StrategyInstance strategyInstance) {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            String str = iConnStrategy.getProtocol().protocol;
            if (!ConnType.QUIC.equals(str) && !ConnType.QUIC_PLAIN.equals(str)) {
                boolean u = C9708t9.u();
                boolean j = Http3ConnectionDetector.j();
                if (!(u && j) && (ConnType.HTTP3.equals(str) || ConnType.HTTP3_PLAIN.equals(str))) {
                    ALog.f("awcn.StrategyCenter", "http3 strategy disabled", null, "strategy", iConnStrategy);
                    return false;
                }
                return true;
            }
            ALog.f("awcn.StrategyCenter", "gquic strategy disabled", null, "strategy", iConnStrategy);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (this.b == null) {
            ALog.k("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.a));
            return true;
        }
        return false;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void forceRefreshStrategy(String str) {
        if (b() || TextUtils.isEmpty(str)) {
            return;
        }
        ALog.f("awcn.StrategyCenter", "force refresh strategy", null, "host", str);
        this.b.e().sendAmdcRequest(str, true);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public boolean getAbStrategyStatusByHost(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || b()) {
            return false;
        }
        return this.b.e().getAbStrategyStatusByHost(str, str2);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getCNameByHost(String str) {
        if (b() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.e().getCnameByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getClientIp() {
        return b() ? "" : this.b.e().clientIp;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.e);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListWithoutWait(String str) {
        if (!TextUtils.isEmpty(str) && !b()) {
            String cnameByHost = this.b.e().getCnameByHost(str);
            if (!TextUtils.isEmpty(cnameByHost)) {
                str = cnameByHost;
            }
            List<IConnStrategy> queryByHost = this.b.e().queryByHost(str);
            if (queryByHost.isEmpty()) {
                queryByHost = this.b.c.g(str);
            }
            ListIterator<IConnStrategy> listIterator = queryByHost.listIterator();
            while (listIterator.hasNext()) {
                if (!this.e.accept(listIterator.next())) {
                    listIterator.remove();
                }
            }
            return queryByHost;
        }
        return Collections.EMPTY_LIST;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getFormalizeUrl(String str) {
        o01 g = o01.g(str);
        if (g == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", null, "URL", str);
            return null;
        }
        String n = g.n();
        try {
            String schemeByHost = getSchemeByHost(g.d(), g.j());
            if (!schemeByHost.equalsIgnoreCase(g.j())) {
                n = zh2.e(schemeByHost, ":", str.substring(str.indexOf(WVUtils.URL_SEPARATOR)));
            }
            if (ALog.g(1)) {
                ALog.c("awcn.StrategyCenter", "", null, "raw", zh2.i(str, 128), "ret", zh2.i(n, 128));
            }
        } catch (Exception e) {
            ALog.d("awcn.StrategyCenter", "getFormalizeUrl failed", null, e, "raw", str);
        }
        return n;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getIpv4ConnStrategyListByHost(String str, boolean z, int i) {
        List<IConnStrategy> f = this.b.c.f(str, z, i);
        if (f.isEmpty()) {
            return f;
        }
        ListIterator<IConnStrategy> listIterator = f.listIterator();
        while (listIterator.hasNext()) {
            if (!this.e.accept(listIterator.next())) {
                listIterator.remove();
            }
        }
        return f;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getUnitByHost(String str) {
        if (b()) {
            return null;
        }
        return this.b.b.getUnitByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void initialize(Context context) {
        if (this.a || context == null) {
            return;
        }
        try {
            ALog.f("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
            C9708t9.f(context);
            NetworkStatusHelper.t(context);
            AmdcRuntimeInfo.g(context);
            C0225c.e(context);
            HttpDispatcher.f().b(this);
            this.b = StrategyInfoHolder.k();
            this.a = true;
            ALog.f("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
        } catch (Exception e) {
            ALog.d("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e, new Object[0]);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ym ymVar) {
        if (b() || iConnStrategy == null || !(iConnStrategy instanceof IPConnStrategy)) {
            return;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
        if (iPConnStrategy.ipSource == 1) {
            this.b.c.d(str, iConnStrategy, ymVar);
        } else if (iPConnStrategy.ipSource == 0) {
            this.b.e().notifyConnEvent(str, iConnStrategy, ymVar);
        }
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(z90 z90Var) {
        if (z90Var.a != 1 || this.b == null) {
            return;
        }
        ALog.c("awcn.StrategyCenter", "receive amdc event", null, new Object[0]);
        C0214b.C0221g a = C0214b.a((JSONObject) z90Var.b);
        if (a == null) {
            return;
        }
        this.b.n(a);
        saveData();
        Iterator<IStrategyListener> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStrategyUpdated(a);
            } catch (Exception e) {
                ALog.d("awcn.StrategyCenter", "onStrategyUpdated failed", null, e, new Object[0]);
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "registerListener", null, "listener", this.d);
        if (iStrategyListener != null) {
            this.d.add(iStrategyListener);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void saveData() {
        ALog.f("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c > 30000) {
            this.c = currentTimeMillis;
            a5.c(new Runnable() { // from class: anet.channel.strategy.StrategyInstance.2
                @Override // java.lang.Runnable
                public void run() {
                    if (StrategyInstance.this.b()) {
                        return;
                    }
                    StrategyInstance.this.b.m();
                }
            }, 500L);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void switchEnv() {
        C0225c.b();
        HttpDispatcher.f().i();
        StrategyInfoHolder strategyInfoHolder = this.b;
        if (strategyInfoHolder != null) {
            strategyInfoHolder.d();
            this.b = StrategyInfoHolder.k();
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "unregisterListener", null, "listener", this.d);
        this.d.remove(iStrategyListener);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter) {
        if (!TextUtils.isEmpty(str) && !b()) {
            String cnameByHost = this.b.e().getCnameByHost(str);
            if (TextUtils.isEmpty(cnameByHost)) {
                cnameByHost = str;
            }
            List queryByHost = this.b.e().queryByHost(cnameByHost);
            if (queryByHost.isEmpty()) {
                queryByHost = this.b.c.e(cnameByHost);
            }
            if (!queryByHost.isEmpty() && iStrategyFilter != null) {
                boolean z = !C9708t9.C() || (C9708t9.A() && this.b.e().isHostInIpv6BlackList(cnameByHost, C9708t9.d()));
                ListIterator<IConnStrategy> listIterator = queryByHost.listIterator();
                while (listIterator.hasNext()) {
                    IConnStrategy next = listIterator.next();
                    if (!iStrategyFilter.accept(next)) {
                        listIterator.remove();
                    } else if (z && lw2.d(next.getIp())) {
                        listIterator.remove();
                    } else if (ConnType.HTTP3.equals(next.getProtocol().protocol) || ConnType.HTTP3_PLAIN.equals(next.getProtocol().protocol)) {
                        if (C9708t9.t(cnameByHost)) {
                            ALog.e("awcn.StrategyCenter", "the host in  http3 strategy black list", null, "host", cnameByHost);
                            listIterator.remove();
                        }
                    }
                }
                if (ALog.g(1)) {
                    ALog.c("getConnStrategyListByHost", null, "host", cnameByHost, "result", queryByHost);
                }
                return queryByHost;
            }
            ALog.c("getConnStrategyListByHost", null, "host", cnameByHost, "result", queryByHost);
            return queryByHost;
        }
        return Collections.EMPTY_LIST;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b()) {
            return str2;
        }
        String safeAislesByHost = this.b.b.getSafeAislesByHost(str);
        if (safeAislesByHost != null || TextUtils.isEmpty(str2)) {
            str2 = safeAislesByHost;
        }
        if (str2 == null && (str2 = g62.a().b(str)) == null) {
            str2 = "http";
        }
        ALog.c("awcn.StrategyCenter", "getSchemeByHost", null, "host", str, "scheme", str2);
        return str2;
    }
}
