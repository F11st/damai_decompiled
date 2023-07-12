package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "nettype")
/* loaded from: classes.dex */
public class NetTypeStat extends StatObject {
    @Dimension
    public int ipStackType;
    @Dimension
    public int lastIpStackType;
    @Dimension
    public String nat64Prefix;
    @Dimension
    public String carrierName = NetworkStatusHelper.c();
    @Dimension
    public String mnc = NetworkStatusHelper.h();
    @Dimension
    public String netType = NetworkStatusHelper.i().getType();
}
