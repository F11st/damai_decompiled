package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.Inet64Util;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "ipv6_detect")
/* loaded from: classes.dex */
public class Ipv6DetectStat extends StatObject {
    @Dimension
    public String cip;
    @Dimension
    public long detectTime;
    @Dimension
    public String detectUrl;
    @Dimension
    public String host;
    @Dimension
    public String ip;
    @Dimension
    public int ipv4MTU;
    @Dimension
    public int ipv6MTU;
    @Dimension
    public String localIpv4;
    @Dimension
    public String localIpv6;
    @Dimension
    public String netType = NetworkStatusHelper.e();
    @Dimension
    public int ipStack = Inet64Util.n();
    @Dimension
    public int ret = -1;

    public Ipv6DetectStat(String str) {
        this.host = str;
        Inet64Util.j();
        this.localIpv4 = Inet64Util.d;
        this.localIpv6 = Inet64Util.e;
        this.ipv4MTU = Inet64Util.f;
        this.ipv6MTU = Inet64Util.g;
    }
}
