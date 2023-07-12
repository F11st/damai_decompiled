package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.b;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import tb.lw2;
import tb.t9;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyConfig implements Serializable {
    private static final int MAX_CACHE_SIZE = 256;
    public static final String NO_RESULT = "No_Result";
    private static transient boolean isStrategyUpgrade = t9.N();
    private static final long serialVersionUID = -7798500032935529499L;
    private SerialLruCache<String, String> schemeMap = null;
    private Map<String, String> unitMap = null;
    private transient StrategyInfoHolder holder = null;
    private Map<String, String> bssidUniqueIdMap = null;

    private TreeMap<String, String> updateDns(b.d[] dVarArr) {
        TreeMap<String, String> treeMap = null;
        if (dVarArr != null && dVarArr.length != 0) {
            for (b.d dVar : dVarArr) {
                if (dVar.f) {
                    this.schemeMap.remove(dVar.a);
                } else if (dVar.d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    treeMap.put(dVar.a, dVar.d);
                } else {
                    if (!"http".equalsIgnoreCase(dVar.c) && !"https".equalsIgnoreCase(dVar.c)) {
                        this.schemeMap.put(dVar.a, NO_RESULT);
                    } else {
                        this.schemeMap.put(dVar.a, dVar.c);
                    }
                    if (!TextUtils.isEmpty(dVar.e)) {
                        this.unitMap.put(dVar.a, dVar.e);
                    } else {
                        this.unitMap.remove(dVar.a);
                    }
                }
            }
        }
        return treeMap;
    }

    private TreeMap<String, String> updateDnsInfo(b.e[] eVarArr) {
        TreeMap<String, String> treeMap = null;
        if (eVarArr != null && eVarArr.length != 0) {
            for (b.e eVar : eVarArr) {
                if (eVar.j) {
                    this.schemeMap.remove(eVar.a);
                } else if (eVar.d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                    }
                    treeMap.put(eVar.a, eVar.d);
                } else {
                    if (!"http".equalsIgnoreCase(eVar.c) && !"https".equalsIgnoreCase(eVar.c)) {
                        this.schemeMap.put(eVar.a, NO_RESULT);
                    } else {
                        this.schemeMap.put(eVar.a, eVar.c);
                    }
                    if (!TextUtils.isEmpty(eVar.e)) {
                        this.unitMap.put(eVar.a, eVar.e);
                    } else {
                        this.unitMap.remove(eVar.a);
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
    public void update(b.g gVar) {
        synchronized (this) {
            TreeMap<String, String> updateDns = isStrategyUpgrade ? updateDns(gVar.c) : updateDnsInfo(gVar.b);
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
