package anet.channel.appmonitor;

import anet.channel.statist.StatObject;
import tb.g4;
import tb.wo;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IAppMonitor {
    void commitAlarm(g4 g4Var);

    void commitCount(wo woVar);

    void commitStat(StatObject statObject);

    @Deprecated
    void register();

    @Deprecated
    void register(Class<?> cls);
}
