package anetwork.channel;

import anetwork.channel.statist.StatisticData;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface NetworkEvent$FinishEvent {
    String getDesc();

    int getHttpCode();

    StatisticData getStatisticData();
}
