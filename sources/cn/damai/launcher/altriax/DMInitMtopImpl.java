package cn.damai.launcher.altriax;

import cn.damai.launcher.initialize.CommonBiz;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitMtopDelegate;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitMtopImpl implements DMInitMtopDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862179662")) {
            ipChange.ipc$dispatch("-862179662", new Object[]{this});
        } else {
            CommonBiz.getInstance().n();
        }
    }
}
