package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import tb.hu0;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "amdc")
/* loaded from: classes.dex */
public class AmdcStatistic extends StatObject {
    @Dimension
    public String errorCode;
    @Dimension
    public String errorMsg;
    @Dimension
    public String host;
    @Dimension
    public int retryTimes;
    @Dimension
    public String trace;
    @Dimension
    public String url;
    @Dimension
    public String netType = NetworkStatusHelper.i().toString();
    @Dimension
    public String proxyType = NetworkStatusHelper.f();
    @Dimension
    public String ttid = hu0.f();
}
