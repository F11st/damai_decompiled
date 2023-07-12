package cn.damai.launcher.altriax;

import cn.damai.commonbusiness.poplayer.DMPopLayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitPopLayerDelegate;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitPopLayerImpl implements DMInitPopLayerDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811028970")) {
            ipChange.ipc$dispatch("1811028970", new Object[]{this});
        } else {
            new DMPopLayer().setup(mu0.a());
        }
    }
}
