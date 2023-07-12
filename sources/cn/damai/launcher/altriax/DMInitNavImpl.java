package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitNavDelegate;
import tb.jo0;
import tb.zi1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitNavImpl implements DMInitNavDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514871499")) {
            ipChange.ipc$dispatch("1514871499", new Object[]{this});
            return;
        }
        jo0.f().e();
        new zi1().a();
    }
}
