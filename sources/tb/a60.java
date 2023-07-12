package tb;

import anet.channel.flow.INetworkAnalysis;
import anet.channel.util.ALog;
import com.taobao.analysis.FlowCenter;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a60 implements INetworkAnalysis {
    private boolean a;

    public a60() {
        try {
            Class.forName("com.taobao.analysis.FlowCenter");
            FlowCenter.getInstance();
            this.a = true;
        } catch (Exception unused) {
            this.a = false;
            ALog.e("DefaultNetworkAnalysis", "no NWNetworkAnalysisSDK sdk", null, new Object[0]);
        }
    }

    @Override // anet.channel.flow.INetworkAnalysis
    public void commitFlow(ln0 ln0Var) {
        if (this.a) {
            FlowCenter.getInstance().commitFlow(hu0.c(), ln0Var.a, ln0Var.b, ln0Var.c, ln0Var.d, ln0Var.e);
        }
    }
}
