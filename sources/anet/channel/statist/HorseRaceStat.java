package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.b;
import anet.channel.util.Inet64Util;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "horseRace")
/* loaded from: classes.dex */
public class HorseRaceStat extends StatObject {
    @Dimension
    public volatile int connErrorCode;
    @Measure
    public volatile long connTime;
    @Dimension
    public volatile String host;
    @Dimension
    public volatile String ip;
    @Dimension
    public volatile String localIP;
    @Dimension
    public volatile String path;
    @Dimension
    public volatile int pingSuccessCount;
    @Dimension
    public volatile int pingTimeoutCount;
    @Dimension
    public volatile int port;
    @Dimension
    public volatile String protocol;
    @Dimension
    public volatile int reqErrorCode;
    @Measure
    public volatile long reqTime;
    @Dimension
    public volatile int connRet = 0;
    @Dimension
    public volatile int reqRet = 0;
    @Dimension
    public volatile String nettype = NetworkStatusHelper.e();
    @Dimension
    public volatile String mnc = NetworkStatusHelper.h();
    @Dimension
    public volatile String bssid = NetworkStatusHelper.k();
    @Dimension
    public volatile int ipStackType = Inet64Util.n();

    public HorseRaceStat(String str, b.j jVar) {
        this.host = str;
        this.ip = jVar.a;
        this.port = jVar.b.a;
        this.protocol = ConnProtocol.valueOf(jVar.b).name;
        this.path = jVar.c;
    }
}
