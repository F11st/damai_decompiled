package tb;

import anet.channel.appmonitor.IAppMonitor;
import anet.channel.statist.StatObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class x6 {
    private static volatile IAppMonitor a = new C9908a(null);
    private static volatile IAppMonitor b = null;

    /* compiled from: Taobao */
    /* renamed from: tb.x6$a */
    /* loaded from: classes.dex */
    static class C9908a implements IAppMonitor {
        IAppMonitor a;

        C9908a(IAppMonitor iAppMonitor) {
            this.a = null;
            this.a = iAppMonitor;
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitAlarm(g4 g4Var) {
            IAppMonitor iAppMonitor = this.a;
            if (iAppMonitor != null) {
                iAppMonitor.commitAlarm(g4Var);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitCount(wo woVar) {
            IAppMonitor iAppMonitor = this.a;
            if (iAppMonitor != null) {
                iAppMonitor.commitCount(woVar);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitStat(StatObject statObject) {
            if (x6.b != null) {
                x6.b.commitStat(statObject);
            }
            IAppMonitor iAppMonitor = this.a;
            if (iAppMonitor != null) {
                iAppMonitor.commitStat(statObject);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        @Deprecated
        public void register() {
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        @Deprecated
        public void register(Class<?> cls) {
        }
    }

    public static IAppMonitor b() {
        return a;
    }

    public static void c(IAppMonitor iAppMonitor) {
        b = iAppMonitor;
    }

    public static void d(IAppMonitor iAppMonitor) {
        a = new C9908a(iAppMonitor);
    }
}
