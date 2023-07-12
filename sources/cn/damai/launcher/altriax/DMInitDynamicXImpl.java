package cn.damai.launcher.altriax;

import cn.damai.commonbusiness.dynamicx.DynamicXInit;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitDynamicXDelegate;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitDynamicXImpl implements DMInitDynamicXDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitDynamicXDelegate
    public void initDynamicX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220118550")) {
            ipChange.ipc$dispatch("-220118550", new Object[]{this});
        } else {
            DynamicXInit.k();
        }
    }
}
