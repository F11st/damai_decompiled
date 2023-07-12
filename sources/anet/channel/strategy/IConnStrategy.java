package anet.channel.strategy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IConnStrategy {
    int getConnectionTimeout();

    int getHeartbeat();

    String getIp();

    int getIpSource();

    int getIpType();

    int getPort();

    ConnProtocol getProtocol();

    int getReadTimeout();

    int getRetryTimes();

    int getStatus();
}
