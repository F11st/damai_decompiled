package anet.channel.statist;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "session_monitor")
/* loaded from: classes.dex */
public class SessionMonitor extends SessionStatistic {
    public SessionMonitor(SessionStatistic sessionStatistic) {
        super(null);
        if (sessionStatistic == null) {
            return;
        }
        this.host = sessionStatistic.host;
        this.ip = sessionStatistic.ip;
        this.port = sessionStatistic.port;
        this.closeReason = sessionStatistic.closeReason;
        this.retryTimes = sessionStatistic.retryTimes;
        this.errorCode = sessionStatistic.errorCode;
        this.sdkv = sessionStatistic.sdkv;
        this.conntype = sessionStatistic.conntype;
        this.isProxy = sessionStatistic.isProxy;
        this.isTunnel = sessionStatistic.isTunnel;
        this.isKL = sessionStatistic.isKL;
        this.ret = sessionStatistic.ret;
        this.isBackground = sessionStatistic.isBackground;
        this.netType = sessionStatistic.netType;
        this.ipRefer = sessionStatistic.ipRefer;
        this.ipType = sessionStatistic.ipType;
        this.extra = sessionStatistic.extra;
        this.connectionTime = sessionStatistic.connectionTime;
        this.authTime = sessionStatistic.authTime;
        this.sslTime = sessionStatistic.sslTime;
        this.liveTime = sessionStatistic.liveTime;
        this.requestCount = sessionStatistic.requestCount;
        this.cfRCount = sessionStatistic.cfRCount;
        this.stdRCount = sessionStatistic.stdRCount;
        this.ppkgCount = sessionStatistic.ppkgCount;
        this.pRate = sessionStatistic.pRate;
        this.ackTime = sessionStatistic.ackTime;
        this.lastPingInterval = sessionStatistic.lastPingInterval;
        this.sslCalTime = sessionStatistic.sslCalTime;
        this.sendSizeCount = sessionStatistic.sendSizeCount;
        this.recvSizeCount = sessionStatistic.recvSizeCount;
        this.inceptCount = sessionStatistic.inceptCount;
    }
}
