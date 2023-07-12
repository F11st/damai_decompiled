package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.hu0;
import tb.lw2;
import tb.t9;
import tb.ym;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyTable implements Serializable {
    private static final int FRESH_TTL = 30000;
    private static final int MAX_HOST_COUNT_IN_ONCE_UPDATE = 40;
    private static final int MAX_HOST_SIZE = 256;
    private static final String TAG = "awcn.StrategyTable";
    private static final long serialVersionUID = 6044722613437834958L;
    protected volatile String clientIp;
    private volatile transient int configVersion;
    private HostLruCache hostStrategyMap;
    Map<String, Long> ipv6BlackList;
    protected transient boolean isChanged = false;
    protected String uniqueId;
    private static transient boolean isStrategyUpgrade = t9.N();
    protected static Comparator<StrategyCollection> comparator = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        private static final long serialVersionUID = -4001655685948369525L;

        public HostLruCache(int i) {
            super(i);
        }

        @Override // anet.channel.strategy.utils.SerialLruCache
        protected boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (entry.getValue().isFixed) {
                Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
                while (it.hasNext()) {
                    if (!it.next().getValue().isFixed) {
                        it.remove();
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class a implements Comparator<StrategyCollection> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
            if (strategyCollection.ttl != strategyCollection2.ttl) {
                return strategyCollection.ttl - strategyCollection2.ttl > 0 ? 1 : -1;
            }
            return strategyCollection.host.compareTo(strategyCollection2.host);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StrategyTable(String str) {
        this.uniqueId = str;
        checkInit();
    }

    private void checkInitHost() {
        try {
            if (HttpDispatcher.f().g(this.uniqueId)) {
                TreeSet treeSet = null;
                synchronized (this.hostStrategyMap) {
                    for (String str : HttpDispatcher.f().e()) {
                        if (!this.hostStrategyMap.containsKey(str)) {
                            this.hostStrategyMap.put(str, new StrategyCollection(str));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(str);
                        }
                    }
                }
                if (treeSet != null) {
                    sendAmdcRequest(treeSet);
                }
            }
        } catch (Exception e) {
            ALog.d(TAG, "checkInitHost failed", this.uniqueId, e, new Object[0]);
        }
    }

    private void fillUpdateHosts(Set<String> set) {
        TreeSet treeSet = new TreeSet(comparator);
        synchronized (this.hostStrategyMap) {
            treeSet.addAll(this.hostStrategyMap.values());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            StrategyCollection strategyCollection = (StrategyCollection) it.next();
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            if (strategyCollection.isAllowUpdate(false)) {
                strategyCollection.ttl = 30000 + currentTimeMillis;
                set.add(strategyCollection.host);
            }
        }
    }

    private void initStrategy() {
        if (HttpDispatcher.f().g(this.uniqueId)) {
            for (String str : HttpDispatcher.f().e()) {
                this.hostStrategyMap.put(str, new StrategyCollection(str));
            }
        }
    }

    private void sendAmdcRequest(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        sendAmdcRequest(treeSet);
    }

    private void updateDns(b.g gVar) {
        String str;
        b.d[] dVarArr = gVar.c;
        if (dVarArr == null) {
            return;
        }
        synchronized (this.hostStrategyMap) {
            for (b.d dVar : dVarArr) {
                if (dVar != null && (str = dVar.a) != null) {
                    if (dVar.f) {
                        this.hostStrategyMap.remove(str);
                    } else {
                        StrategyCollection strategyCollection = this.hostStrategyMap.get(str);
                        if (strategyCollection == null) {
                            strategyCollection = new StrategyCollection(dVar.a);
                            this.hostStrategyMap.put(dVar.a, strategyCollection);
                        }
                        strategyCollection.updateStrategy(dVar);
                    }
                }
            }
        }
    }

    private void updateDnsInfo(b.g gVar) {
        String str;
        b.e[] eVarArr = gVar.b;
        if (eVarArr == null) {
            return;
        }
        synchronized (this.hostStrategyMap) {
            for (b.e eVar : eVarArr) {
                if (eVar != null && (str = eVar.a) != null) {
                    if (eVar.j) {
                        this.hostStrategyMap.remove(str);
                    } else {
                        StrategyCollection strategyCollection = this.hostStrategyMap.get(str);
                        if (strategyCollection == null) {
                            strategyCollection = new StrategyCollection(eVar.a);
                            this.hostStrategyMap.put(eVar.a, strategyCollection);
                        }
                        strategyCollection.update(eVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkInit() {
        if (this.hostStrategyMap == null) {
            this.hostStrategyMap = new HostLruCache(256);
            initStrategy();
        }
        for (StrategyCollection strategyCollection : this.hostStrategyMap.values()) {
            strategyCollection.checkInit();
        }
        ALog.f(TAG, "strategy map", null, "size", Integer.valueOf(this.hostStrategyMap.size()));
        this.configVersion = hu0.j() ? 0 : -1;
        if (this.ipv6BlackList == null) {
            this.ipv6BlackList = new ConcurrentHashMap();
        }
    }

    public boolean getAbStrategyStatusByHost(String str, String str2) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        synchronized (this.hostStrategyMap) {
            strategyCollection = this.hostStrategyMap.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.a() == 0) {
            sendAmdcRequest(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.getAbStrategyStatus(str2);
        }
        return false;
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.hostStrategyMap) {
            strategyCollection = this.hostStrategyMap.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.a() == 0) {
            sendAmdcRequest(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.cname;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHostInIpv6BlackList(String str, long j) {
        Long l = this.ipv6BlackList.get(str);
        if (l == null) {
            return false;
        }
        if (l.longValue() + j < System.currentTimeMillis()) {
            this.ipv6BlackList.remove(str);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ym ymVar) {
        StrategyCollection strategyCollection;
        if (ALog.g(1)) {
            ALog.c(TAG, "[notifyConnEvent]", null, BizTime.HOST, str, "IConnStrategy", iConnStrategy, "ConnEvent", ymVar);
        }
        if (!ymVar.a && lw2.d(iConnStrategy.getIp())) {
            this.ipv6BlackList.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e(TAG, "disable ipv6", null, "uniqueId", this.uniqueId, "host", str);
        }
        synchronized (this.hostStrategyMap) {
            strategyCollection = this.hostStrategyMap.get(str);
        }
        if (strategyCollection != null) {
            ConnType l = ConnType.l(iConnStrategy.getProtocol());
            if (!hu0.i() || l == null || !l.h() || ymVar.a) {
                strategyCollection.notifyConnEvent(iConnStrategy, ymVar);
            }
        }
    }

    public void parseStrategyData() {
        try {
            HostLruCache hostLruCache = this.hostStrategyMap;
            if (hostLruCache != null) {
                for (Map.Entry<String, StrategyCollection> entry : hostLruCache.entrySet()) {
                    StrategyCollection value = entry.getValue();
                    if (value != null && value.parseStrategyData()) {
                        this.isChanged = true;
                    }
                }
            }
        } catch (Exception e) {
            ALog.d(TAG, "parseStrategyData error !", null, e, new Object[0]);
        }
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (!TextUtils.isEmpty(str) && lw2.a(str)) {
            checkInitHost();
            synchronized (this.hostStrategyMap) {
                strategyCollection = this.hostStrategyMap.get(str);
                if (strategyCollection == null) {
                    strategyCollection = new StrategyCollection(str);
                    this.hostStrategyMap.put(str, strategyCollection);
                }
            }
            if (strategyCollection.ttl == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.a() == 0)) {
                sendAmdcRequest(str);
            }
            return strategyCollection.queryStrategyList();
        }
        return Collections.EMPTY_LIST;
    }

    public void update(b.g gVar) {
        ALog.f(TAG, "update strategyTable with httpDns response", this.uniqueId, new Object[0]);
        try {
            this.clientIp = gVar.a;
            this.configVersion = gVar.e;
            if (isStrategyUpgrade) {
                updateDns(gVar);
            } else {
                updateDnsInfo(gVar);
            }
        } catch (Throwable th) {
            ALog.d(TAG, "fail to update strategyTable", this.uniqueId, th, new Object[0]);
        }
        this.isChanged = true;
        if (ALog.g(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.uniqueId);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.c(TAG, sb.toString(), null, new Object[0]);
            synchronized (this.hostStrategyMap) {
                for (Map.Entry<String, StrategyCollection> entry : this.hostStrategyMap.entrySet()) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    sb.append(" = ");
                    sb.append(entry.getValue().toString());
                    ALog.e(TAG, sb.toString(), null, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendAmdcRequest(String str, boolean z) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.hostStrategyMap) {
            strategyCollection = this.hostStrategyMap.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.hostStrategyMap.put(str, strategyCollection);
            }
        }
        if (z || strategyCollection.ttl == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.a() == 0)) {
            sendAmdcRequest(str);
        }
    }

    private void sendAmdcRequest(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((hu0.i() && AppLifecycle.b > 0) || !NetworkStatusHelper.n()) {
            ALog.f(TAG, "app in background or no network", this.uniqueId, new Object[0]);
            return;
        }
        int a2 = AmdcRuntimeInfo.a();
        if (a2 == 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hostStrategyMap) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                StrategyCollection strategyCollection = this.hostStrategyMap.get(it.next());
                if (strategyCollection != null) {
                    if (!strategyCollection.isAllowUpdate(true)) {
                        it.remove();
                    } else {
                        strategyCollection.ttl = 30000 + currentTimeMillis;
                    }
                }
            }
        }
        if (a2 == 0) {
            fillUpdateHosts(set);
        }
        HttpDispatcher.f().h(set, this.configVersion);
    }
}
