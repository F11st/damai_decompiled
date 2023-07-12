package tb;

import anet.channel.flow.INetworkAnalysis;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qj1 {
    private static volatile INetworkAnalysis a = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class a implements INetworkAnalysis {
        private INetworkAnalysis a;

        a(INetworkAnalysis iNetworkAnalysis) {
            this.a = null;
            this.a = iNetworkAnalysis;
        }

        @Override // anet.channel.flow.INetworkAnalysis
        public void commitFlow(ln0 ln0Var) {
            INetworkAnalysis iNetworkAnalysis = this.a;
            if (iNetworkAnalysis != null) {
                iNetworkAnalysis.commitFlow(ln0Var);
            }
        }
    }

    public static INetworkAnalysis a() {
        return a;
    }

    public static void b(INetworkAnalysis iNetworkAnalysis) {
        a = new a(iNetworkAnalysis);
    }
}
