package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.detect.HttpStrategyDetector;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0214b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import com.alibaba.analytics.core.network.NetworkUtil;
import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.C9708t9;
import tb.a5;
import tb.hu0;
import tb.x6;
import tb.y90;
import tb.zh2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {
    private String f;
    private volatile NetworkStatusHelper.NetworkStatus i;
    Map<String, StrategyTable> a = new LruStrategyMap();
    volatile StrategyConfig b = null;
    final LocalDnsStrategyTable c = new LocalDnsStrategyTable();
    private final StrategyTable d = new StrategyTable(NetworkUtil.NETWORK_CLASS_UNKNOWN);
    private final Set<String> e = new HashSet();
    private volatile String g = "";
    private volatile boolean h = false;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        private static final long serialVersionUID = 1866478394612290927L;

        public LruStrategyMap() {
            super(3);
        }

        @Override // anet.channel.strategy.utils.SerialLruCache
        protected boolean entryRemoved(final Map.Entry<String, StrategyTable> entry) {
            a5.d(new Runnable() { // from class: anet.channel.strategy.StrategyInfoHolder.LruStrategyMap.1
                @Override // java.lang.Runnable
                public void run() {
                    StrategyTable strategyTable = (StrategyTable) entry.getValue();
                    if (strategyTable.isChanged) {
                        StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                        strategyStatObject.writeStrategyFileId = strategyTable.uniqueId;
                        C0225c.f((Serializable) entry.getValue(), strategyTable.uniqueId, strategyStatObject);
                        strategyTable.isChanged = false;
                    }
                }
            });
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            h();
            l();
        } catch (Throwable unused) {
        }
        c();
    }

    private void c() {
        synchronized (this.a) {
            for (Map.Entry<String, StrategyTable> entry : this.a.entrySet()) {
                entry.getValue().checkInit();
            }
        }
        synchronized (this) {
            if (this.b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.checkInit();
                strategyConfig.setHolder(this);
                this.b = strategyConfig;
            }
        }
    }

    private String f() {
        String str;
        File[] c = C0225c.c();
        if (c == null) {
            return this.f;
        }
        int i = 0;
        while (true) {
            if (i >= c.length) {
                str = "";
                break;
            }
            File file = c[i];
            if (!file.isDirectory()) {
                str = file.getName();
                if (str.startsWith("WIFI")) {
                    break;
                }
            }
            i++;
        }
        return TextUtils.isEmpty(str) ? this.f : str;
    }

    private String g(NetworkStatusHelper.NetworkStatus networkStatus) {
        String str;
        String str2;
        str = "";
        if (networkStatus.isWifi()) {
            String k = NetworkStatusHelper.k();
            if (C9708t9.M()) {
                if (this.b != null && !TextUtils.isEmpty(k) && !"02:00:00:00:00:00".equals(k)) {
                    str = this.b.getUniqueIdByBssid(zh2.h(k));
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                this.h = true;
                str2 = f();
            } else {
                String h = zh2.h(k);
                str2 = "WIFI$" + (TextUtils.isEmpty(h) ? "" : h);
            }
            return str2;
        } else if (networkStatus.isMobile()) {
            return networkStatus.getType() + "$" + NetworkStatusHelper.b();
        } else {
            return "";
        }
    }

    private void h() {
        NetworkStatusHelper.a(this);
        this.i = NetworkStatusHelper.i();
        this.f = "WIFI$" + hu0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.g = g(this.i);
        if (C9708t9.M() && this.i.isWifi() && this.h) {
            e().sendAmdcRequest(y90.a(), true);
            this.h = false;
        }
    }

    public static StrategyInfoHolder k() {
        return new StrategyInfoHolder();
    }

    private void l() {
        ALog.f("awcn.StrategyInfoHolder", "restore", null, new Object[0]);
        if (!C9708t9.n()) {
            this.b = (StrategyConfig) C0225c.h("StrategyConfig", null);
            if (this.b != null) {
                this.b.checkInit();
                this.b.setHolder(this);
            }
            j();
            String str = this.g;
            if (!TextUtils.isEmpty(str)) {
                i(str, true);
            }
        }
        a5.d(new Runnable() { // from class: anet.channel.strategy.StrategyInfoHolder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ALog.f("awcn.StrategyInfoHolder", "start loading strategy files", null, new Object[0]);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (C9708t9.n()) {
                        ALog.f("awcn.StrategyInfoHolder", "load strategy async", null, new Object[0]);
                        StrategyConfig strategyConfig = (StrategyConfig) C0225c.h("StrategyConfig", null);
                        if (strategyConfig != null) {
                            strategyConfig.checkInit();
                            strategyConfig.setHolder(StrategyInfoHolder.this);
                            synchronized (StrategyInfoHolder.this) {
                                StrategyInfoHolder.this.b = strategyConfig;
                            }
                        }
                        StrategyInfoHolder.this.j();
                        String str2 = StrategyInfoHolder.this.g;
                        if (!TextUtils.isEmpty(str2)) {
                            StrategyInfoHolder.this.i(str2, true);
                        }
                    }
                    File[] c = C0225c.c();
                    if (c == null) {
                        return;
                    }
                    int i = 0;
                    for (int i2 = 0; i2 < c.length && i < 2; i2++) {
                        File file = c[i2];
                        if (!file.isDirectory()) {
                            String name = file.getName();
                            if (!name.equals(StrategyInfoHolder.this.g) && !name.startsWith("StrategyConfig")) {
                                StrategyInfoHolder.this.i(name, false);
                                i++;
                            }
                        }
                    }
                    ALog.f("awcn.StrategyInfoHolder", "end loading strategy files", null, "total cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        NetworkStatusHelper.s(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StrategyTable e() {
        StrategyTable strategyTable = this.d;
        String str = this.g;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                strategyTable = this.a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    protected void i(String str, boolean z) {
        synchronized (this.e) {
            if (this.e.contains(str)) {
                return;
            }
            this.e.add(str);
            StrategyStatObject strategyStatObject = null;
            if (z) {
                strategyStatObject = new StrategyStatObject(0);
                strategyStatObject.readStrategyFileId = str;
            }
            StrategyTable strategyTable = (StrategyTable) C0225c.h(str, strategyStatObject);
            if (strategyTable != null) {
                strategyTable.checkInit();
                strategyTable.parseStrategyData();
                synchronized (this.a) {
                    this.a.put(strategyTable.uniqueId, strategyTable);
                }
            }
            synchronized (this.e) {
                this.e.remove(str);
            }
            if (z) {
                strategyStatObject.isSucceed = strategyTable != null ? 1 : 0;
                x6.b().commitStat(strategyStatObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        synchronized (this.a) {
            for (StrategyTable strategyTable : this.a.values()) {
                if (strategyTable.isChanged) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    String str = strategyTable.uniqueId;
                    strategyStatObject.writeStrategyFileId = str;
                    C0225c.f(strategyTable, str, strategyStatObject);
                    strategyTable.isChanged = false;
                }
            }
            C0225c.f(this.b.createSelf(), "StrategyConfig", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(C0214b.C0221g c0221g) {
        int i = c0221g.f;
        if (i != 0) {
            AmdcRuntimeInfo.k(i, c0221g.g);
        }
        o(c0221g.h);
        e().update(c0221g);
        this.b.update(c0221g);
    }

    void o(String str) {
        if (C9708t9.M() && this.i.isWifi()) {
            String str2 = "WIFI$" + str;
            if (TextUtils.isEmpty(str)) {
                str2 = this.f;
            }
            if (str2.equals(this.g)) {
                return;
            }
            ALog.f("awcn.StrategyInfoHolder", "update uniqueId old uniqueId :" + this.g, str2, new Object[0]);
            this.g = str2;
            String k = NetworkStatusHelper.k();
            if (!TextUtils.isEmpty(k) && !"02:00:00:00:00:00".equals(k) && !this.g.equals(this.f)) {
                this.b.updateBssidUniqueIdMap(zh2.h(k), this.g);
            }
            synchronized (this.a) {
                if (!this.a.containsKey(this.g)) {
                    i(this.g, true);
                }
            }
        }
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(final NetworkStatusHelper.NetworkStatus networkStatus) {
        this.i = networkStatus;
        j();
        final String str = this.g;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.a) {
            if (!this.a.containsKey(str)) {
                a5.d(new Runnable() { // from class: anet.channel.strategy.StrategyInfoHolder.2
                    @Override // java.lang.Runnable
                    public void run() {
                        StrategyInfoHolder.this.i(str, true);
                        Http3ConnectionDetector.o(networkStatus);
                        HttpStrategyDetector.h();
                    }
                });
            } else {
                Http3ConnectionDetector.o(networkStatus);
                HttpStrategyDetector.h();
            }
        }
    }
}
