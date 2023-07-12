package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.Inet64Util;
import tb.hu0;
import tb.jn1;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "amdcResult")
/* loaded from: classes.dex */
public class AmdcResultStat extends StatObject {
    @Dimension
    public String bssid;
    @Dimension
    public int code;
    @Dimension
    public String host;
    @Dimension
    public boolean isContainHttp3;
    @Dimension
    public boolean isContainIpv6;
    @Dimension
    public String trace;
    @Dimension
    public String netType = NetworkStatusHelper.i().toString();
    @Dimension
    public String proxyType = NetworkStatusHelper.f();
    @Dimension
    public String ttid = hu0.f();
    @Dimension
    public int ipStackType = Inet64Util.n();

    public AmdcResultStat() {
        if (NetworkStatusHelper.i().isWifi()) {
            this.bssid = NetworkStatusHelper.k();
        }
    }

    public String toString() {
        return "AmdcResultStat [host:" + this.host + ",ipStackType=" + this.ipStackType + ",isContainHttp3=" + this.isContainHttp3 + ",isContainIpv6=" + this.isContainIpv6 + ",netType=" + this.netType + ",bssid=" + this.bssid + ",code=" + this.bssid + jn1.ARRAY_END_STR;
    }
}
