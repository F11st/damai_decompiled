package anetwork.channel.stat;

import anetwork.channel.statist.StatisticData;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class NetworkStatCache implements INetworkStat {
    private Map<String, String> a;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class a {
        public static NetworkStatCache a = new NetworkStatCache();
    }

    public static NetworkStatCache a() {
        return a.a;
    }

    @Override // anetwork.channel.stat.INetworkStat
    public String get(String str) {
        return this.a.get(str);
    }

    @Override // anetwork.channel.stat.INetworkStat
    public void put(String str, StatisticData statisticData) {
        if (zh2.f(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("{\"oneWayTime\" : ");
        sb.append(statisticData.oneWayTime_ANet);
        sb.append(", \"totalSize\" : ");
        sb.append(statisticData.totalSize);
        sb.append("}");
        this.a.put(str, sb.toString());
    }

    @Override // anetwork.channel.stat.INetworkStat
    public void reset(String str) {
        if (this.a.containsKey(str)) {
            this.a.put(str, "{\"oneWayTime\" : 0, \"totalSize\" : 0}");
        }
    }

    private NetworkStatCache() {
        this.a = Collections.synchronizedMap(new LinkedHashMap<String, String>() { // from class: anetwork.channel.stat.NetworkStatCache.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 100;
            }
        });
    }
}
