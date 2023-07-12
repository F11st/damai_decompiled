package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "policyVersion")
/* loaded from: classes.dex */
public class PolicyVersionStat extends StatObject {
    @Dimension
    public String host;
    @Dimension
    public int reportType;
    @Dimension
    public int version;
    @Dimension
    public String netType = NetworkStatusHelper.e();
    @Dimension
    public String mnc = NetworkStatusHelper.h();

    public PolicyVersionStat(String str, int i) {
        this.host = str;
        this.version = i;
    }
}
