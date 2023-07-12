package anet.channel.statist;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "request_monitor_full_sampling")
/* loaded from: classes.dex */
public class RequestMonitorFullSampling extends RequestMonitor {
    public RequestMonitorFullSampling(RequestStatistic requestStatistic) {
        super(requestStatistic);
    }
}
