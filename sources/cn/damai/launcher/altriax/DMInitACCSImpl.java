package cn.damai.launcher.altriax;

import cn.damai.push.DaMaiPushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitACCSDelegate;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitACCSImpl implements DMInitACCSDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitACCSDelegate
    public void initACCS() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854343306")) {
            ipChange.ipc$dispatch("854343306", new Object[]{this});
        } else {
            DaMaiPushAgent.h(mu0.a());
        }
    }
}
