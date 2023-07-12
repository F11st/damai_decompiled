package cn.damai.launcher.altriax;

import cn.damai.launcher.initialize.CommonBiz;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitLoginSDKDelegate;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitLoginSDKImpl implements DMInitLoginSDKDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217496901")) {
            ipChange.ipc$dispatch("-1217496901", new Object[]{this});
            return;
        }
        cb1.f("MainScheduler", "initLoginSDK");
        CommonBiz.getInstance().m();
    }
}
