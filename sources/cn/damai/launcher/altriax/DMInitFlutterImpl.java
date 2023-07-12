package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitFlutterDelegate;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitFlutterImpl implements DMInitFlutterDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitFlutterDelegate
    public void initFlutter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805181962")) {
            ipChange.ipc$dispatch("1805181962", new Object[]{this});
        }
    }
}
