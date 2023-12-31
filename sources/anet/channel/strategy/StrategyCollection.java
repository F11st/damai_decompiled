package anet.channel.strategy;

import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.time.DateUtils;
import tb.jn1;
import tb.t9;
import tb.x6;
import tb.y90;
import tb.ym;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyCollection implements Serializable {
    private static final long MAX_AVAILABLE_PERIOD = 172800000;
    private static final String TAG = "awcn.StrategyCollection";
    private static final int UPDATE_MODE_DEFAULT = 0;
    private static final int UPDATE_MODE_LAZY = 2;
    private static final int UPDATE_MODE_ONCE = 3;
    private static final int UPDATE_MODE_PRE = 1;
    private static transient boolean isStrategyUpgrade = t9.N();
    private static final long serialVersionUID = 1454976454894208229L;
    Map<String, Boolean> abStrategy;
    volatile String cname;
    String host;
    private transient boolean isFirstUsed;
    boolean isFixed;
    private transient boolean isUpdated;
    private transient long lastAmdcRequestSend;
    private StrategyEntity strategyEntity;
    private StrategyList strategyList;
    volatile long ttl;
    int updateMode;
    int version;

    public StrategyCollection() {
        this.strategyList = null;
        this.strategyEntity = null;
        this.ttl = 0L;
        this.cname = null;
        this.isFixed = false;
        this.version = 0;
        this.updateMode = 0;
        this.lastAmdcRequestSend = 0L;
        this.isFirstUsed = true;
        this.isUpdated = false;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.ttl > MAX_AVAILABLE_PERIOD) {
            this.strategyList = null;
            this.strategyEntity = null;
            return;
        }
        if (isStrategyUpgrade) {
            StrategyEntity strategyEntity = this.strategyEntity;
            if (strategyEntity != null) {
                strategyEntity.checkInit();
            }
        } else {
            StrategyList strategyList = this.strategyList;
            if (strategyList != null) {
                strategyList.checkInit();
            }
        }
    }

    public synchronized boolean getAbStrategyStatus(String str) {
        Map<String, Boolean> map = this.abStrategy;
        if (map != null) {
            Boolean bool = map.get(str);
            return bool != null ? bool.booleanValue() : false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAllowUpdate(boolean z) {
        if (AmdcRuntimeInfo.e()) {
            int i = this.updateMode;
            if (i != 0 && i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        z = !this.isUpdated;
                    }
                }
                ALog.f(TAG, "[isAllowUpdate]", null, "host", this.host, "updateMode", Integer.valueOf(i), "status", Boolean.valueOf(z));
                return z;
            }
            z = true;
            ALog.f(TAG, "[isAllowUpdate]", null, "host", this.host, "updateMode", Integer.valueOf(i), "status", Boolean.valueOf(z));
            return z;
        }
        return true;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.ttl;
    }

    boolean isSupportUpdateMode(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ym ymVar) {
        if (isStrategyUpgrade) {
            StrategyEntity strategyEntity = this.strategyEntity;
            if (strategyEntity != null) {
                strategyEntity.notifyConnEvent(iConnStrategy, ymVar);
                if (!ymVar.a && this.strategyEntity.shouldRefresh()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.lastAmdcRequestSend > DateUtils.MILLIS_PER_MINUTE) {
                        a.a().forceRefreshStrategy(this.host);
                        this.lastAmdcRequestSend = currentTimeMillis;
                    }
                }
            }
        } else {
            StrategyList strategyList = this.strategyList;
            if (strategyList != null) {
                strategyList.notifyConnEvent(iConnStrategy, ymVar);
                if (!ymVar.a && this.strategyList.shouldRefresh()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - this.lastAmdcRequestSend > DateUtils.MILLIS_PER_MINUTE) {
                        a.a().forceRefreshStrategy(this.host);
                        this.lastAmdcRequestSend = currentTimeMillis2;
                    }
                }
            }
        }
    }

    public boolean parseStrategyData() {
        StrategyEntity strategyEntity;
        StrategyList strategyList;
        boolean z = isStrategyUpgrade;
        if (z && this.strategyEntity == null && (strategyList = this.strategyList) != null) {
            this.strategyEntity = parseToStrategyEntity(strategyList);
            this.strategyList = null;
            ALog.e(TAG, "parseStrategyData to strategyEntity success.", null, new Object[0]);
            return true;
        } else if (z || (strategyEntity = this.strategyEntity) == null || this.strategyList != null) {
            return false;
        } else {
            this.strategyList = parseToStrategyList(strategyEntity);
            this.strategyEntity = null;
            ALog.e(TAG, "parseStrategyData to strategyList success.", null, new Object[0]);
            return true;
        }
    }

    StrategyEntity parseToStrategyEntity(StrategyList strategyList) {
        try {
            return new StrategyEntity(strategyList.getIpStrategyList(), strategyList.getHistoryItemMap(), strategyList.isContainsStaticIp());
        } catch (Exception e) {
            ALog.d(TAG, "parseToStrategyEntity error!", null, e, new Object[0]);
            return null;
        }
    }

    StrategyList parseToStrategyList(StrategyEntity strategyEntity) {
        try {
            return new StrategyList(strategyEntity.getIpStrategyList(), strategyEntity.getHistoryItemMap(), strategyEntity.isContainsStaticIp());
        } catch (Exception e) {
            ALog.d(TAG, "parseToStrategyList error!", null, e, new Object[0]);
            return null;
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (isStrategyUpgrade) {
            if (this.strategyEntity == null) {
                return Collections.EMPTY_LIST;
            }
        } else if (this.strategyList == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.isFirstUsed) {
            this.isFirstUsed = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.host, this.version);
            policyVersionStat.reportType = 0;
            x6.b().commitStat(policyVersionStat);
        }
        return isStrategyUpgrade ? this.strategyEntity.getStrategyList() : this.strategyList.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyCollection = ");
        sb.append(this.ttl);
        if (this.strategyList != null) {
            sb.append("\nStrategyList = ");
            sb.append(this.strategyList.toString());
        } else if (this.strategyEntity != null) {
            sb.append("\nstrategyEntity = ");
            sb.append(this.strategyEntity.toString());
        } else if (this.cname != null) {
            sb.append(jn1.ARRAY_START);
            sb.append(this.host);
            sb.append("=>");
            sb.append(this.cname);
            sb.append(jn1.ARRAY_END);
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(b.e eVar) {
        b.j[] jVarArr;
        b.a[] aVarArr;
        this.ttl = System.currentTimeMillis() + (eVar.b * 1000);
        if (!eVar.a.equalsIgnoreCase(this.host)) {
            ALog.e(TAG, "update error!", null, "host", this.host, "dnsInfo.host", eVar.a);
            return;
        }
        int i = this.version;
        int i2 = eVar.l;
        if (i != i2) {
            this.version = i2;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.host, i2);
            policyVersionStat.reportType = 1;
            x6.b().commitStat(policyVersionStat);
        }
        this.cname = eVar.d;
        HashMap<String, Boolean> hashMap = eVar.n;
        if (hashMap != null && hashMap.size() > 0) {
            if (this.abStrategy == null) {
                this.abStrategy = new ConcurrentHashMap();
            }
            this.abStrategy.putAll(eVar.n);
        }
        if (isSupportUpdateMode(eVar.o)) {
            this.updateMode = eVar.o;
        }
        this.isUpdated = true;
        String[] strArr = eVar.f;
        if ((strArr != null && strArr.length != 0 && (aVarArr = eVar.h) != null && aVarArr.length != 0) || ((jVarArr = eVar.i) != null && jVarArr.length != 0)) {
            if (this.strategyList == null) {
                this.strategyList = new StrategyList();
            }
            this.strategyList.update(eVar);
            return;
        }
        this.strategyList = null;
    }

    public synchronized void updateStrategy(b.d dVar) {
        this.ttl = System.currentTimeMillis() + (dVar.b * 1000);
        if (!dVar.a.equalsIgnoreCase(this.host)) {
            ALog.e(TAG, "update error!", null, "host", this.host, "dnsInfo.host", dVar.a);
            return;
        }
        int i = this.version;
        int i2 = dVar.h;
        if (i != i2) {
            this.version = i2;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.host, i2);
            policyVersionStat.reportType = 1;
            x6.b().commitStat(policyVersionStat);
        }
        this.cname = dVar.d;
        HashMap<String, Boolean> hashMap = dVar.j;
        if (hashMap != null && hashMap.size() > 0) {
            if (this.abStrategy == null) {
                this.abStrategy = new ConcurrentHashMap();
            }
            this.abStrategy.putAll(dVar.j);
        }
        if (isSupportUpdateMode(dVar.l)) {
            this.updateMode = dVar.l;
        }
        this.isUpdated = true;
        b.i[] iVarArr = dVar.k;
        if (iVarArr != null && iVarArr.length != 0) {
            if (this.strategyEntity == null) {
                this.strategyEntity = new StrategyEntity();
            }
            this.strategyEntity.update(dVar);
            return;
        }
        this.strategyEntity = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StrategyCollection(String str) {
        this.strategyList = null;
        this.strategyEntity = null;
        this.ttl = 0L;
        this.cname = null;
        this.isFixed = false;
        this.version = 0;
        this.updateMode = 0;
        this.lastAmdcRequestSend = 0L;
        this.isFirstUsed = true;
        this.isUpdated = false;
        this.host = str;
        this.isFixed = y90.d(str);
    }
}
