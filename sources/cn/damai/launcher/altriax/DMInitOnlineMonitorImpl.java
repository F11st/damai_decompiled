package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitOnlineMonitorDelegate;
import tb.b5;
import tb.cb1;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitOnlineMonitorImpl implements DMInitOnlineMonitorDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitOnlineMonitorDelegate
    public void initOnlineMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898798836")) {
            ipChange.ipc$dispatch("898798836", new Object[]{this});
            return;
        }
        cb1.f("MainScheduler", "initOnlineMonitor");
        b5.d(mu0.a(), true);
    }
}
