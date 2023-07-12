package cn.damai.launcher.altriax;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitOrangeDelegate;
import tb.mu0;
import tb.on1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitOrangeImpl implements DMInitOrangeDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759882840")) {
            ipChange.ipc$dispatch("759882840", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c();
        OrangeConfigCenter.d(mu0.a());
        on1.c();
    }
}
