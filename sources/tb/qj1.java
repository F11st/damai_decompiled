package tb;

import anet.channel.flow.INetworkAnalysis;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qj1 {
    private static volatile INetworkAnalysis a = new C9606a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.qj1$a */
    /* loaded from: classes.dex */
    private static class C9606a implements INetworkAnalysis {
        private INetworkAnalysis a;

        C9606a(INetworkAnalysis iNetworkAnalysis) {
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
        a = new C9606a(iNetworkAnalysis);
    }
}
