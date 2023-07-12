package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "CustomFrame")
/* loaded from: classes.dex */
public class CustomFrameStat extends StatObject {
    @Dimension
    public int errCode;
    @Dimension
    public String host;
    @Dimension
    public boolean isAccs;
    @Dimension
    public int ret = 0;
    @Dimension
    public String netType = NetworkStatusHelper.i().toString();

    public String toString() {
        return "CustomFrameStat{host='" + this.host + "', isAccs=" + this.isAccs + ", ret=" + this.ret + ", errCode=" + this.errCode + ", netType='" + this.netType + "'}";
    }
}
