package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.C0214b;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import tb.C9708t9;
import tb.lw2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyConfig implements Serializable {
    private static final int MAX_CACHE_SIZE = 256;
    public static final String NO_RESULT = "No_Result";
    private static transient boolean isStrategyUpgrade = C9708t9.N();
    private static final long serialVersionUID = -7798500032935529499L;
    private SerialLruCache<String, String> schemeMap = null;
    private Map<String, String> unitMap = null;
    private transient StrategyInfoHolder holder = null;
    private Map<String, String> bssidUniqueIdMap = null;

    private TreeMap<String, String> updateDns(C0214b.C0218d[] c0218dArr) {
        TreeMap<String, String> treeMap = null;
        if (c0218dArr != null && c0218dArr.length != 0) {
            for (C0214b.C0218d c0218d : c0218dArr) {
                if (c0218d.f) {
                    this.schemeMap.remove(c0218d.a);
                } else if (c0218d.d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    treeMap.put(c0218d.a, c0218d.d);
                } else {
                    if (!"http".equalsIgnoreCase(c0218d.c) && !"https".equalsIgnoreCase(c0218d.c)) {
                        this.schemeMap.put(c0218d.a, NO_RESULT);
                    } else {
                        this.schemeMap.put(c0218d.a, c0218d.c);
                    }
                    if (!TextUtils.isEmpty(c0218d.e)) {
                        this.unitMap.put(c0218d.a, c0218d.e);
                    } else {
                        this.unitMap.remove(c0218d.a);
                    }
                }
            }
        }
        return treeMap;
    }

    private TreeMap<String, String> updateDnsInfo(C0214b.C0219e[] c0219eArr) {
        TreeMap<String, String> treeMap = null;
        if (c0219eArr != null && c0219eArr.length != 0) {
            for (C0214b.C0219e c0219e : c0219eArr) {
                if (c0219e.j) {
                    this.schemeMap.remove(c0219e.a);
                } else if (c0219e.d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    treeMap.put(c0219e.a, c0219e.d);
                } else {
                    if (!"http".equalsIgnoreCase(c0219e.c) && !"https".equalsIgnoreCase(c0219e.c)) {
                        this.schemeMap.put(c0219e.a, NO_RESULT);
                    } else {
                        this.schemeMap.put(c0219e.a, c0219e.c);
                    }
                    if (!TextUtils.isEmpty(c0219e.e)) {
                        this.unitMap.put(c0219e.a, c0219e.e);
                    } else {
                        this.unitMap.remove(c0219e.a);
                    }
                }
            }
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkInit() {
        if (this.schemeMap == null) {
            this.schemeMap = new SerialLruCache<>(256);
        }
        if (this.unitMap == null) {
            this.unitMap = new ConcurrentHashMap();
        }
        if (this.bssidUniqueIdMap == null) {
            this.bssidUniqueIdMap = new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StrategyConfig createSelf() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.schemeMap = new SerialLruCache<>(this.schemeMap, 256);
            strategyConfig.unitMap = new ConcurrentHashMap(this.unitMap);
            strategyConfig.bssidUniqueIdMap = new ConcurrentHashMap(this.bssidUniqueIdMap);
            strategyConfig.holder = this.holder;
        }
        return strategyConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSafeAislesByHost(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !lw2.a(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.schemeMap.get(str);
            if (str2 == null) {
                this.schemeMap.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.holder.e().sendAmdcRequest(str, false);
        } else if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUniqueIdByBssid(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bssidUniqueIdMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUnitByHost(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.unitMap.get(str);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHolder(StrategyInfoHolder strategyInfoHolder) {
        this.holder = strategyInfoHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(C0214b.C0221g c0221g) {
        synchronized (this) {
            TreeMap<String, String> updateDns = isStrategyUpgrade ? updateDns(c0221g.c) : updateDnsInfo(c0221g.b);
            if (updateDns != null) {
                for (Map.Entry<String, String> entry : updateDns.entrySet()) {
                    String value = entry.getValue();
                    if (this.schemeMap.containsKey(value)) {
                        this.schemeMap.put(entry.getKey(), this.schemeMap.get(value));
                    } else {
                        this.schemeMap.put(entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.g(1)) {
            ALog.c("awcn.StrategyConfig", "", null, "SchemeMap", this.schemeMap.toString());
            ALog.c("awcn.StrategyConfig", "", null, "UnitMap", this.unitMap.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateBssidUniqueIdMap(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.bssidUniqueIdMap.put(str, str2);
    }
}
