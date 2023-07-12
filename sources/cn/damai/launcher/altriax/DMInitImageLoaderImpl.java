package cn.damai.launcher.altriax;

import cn.damai.launcher.initialize.CommonBiz;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitImageLoaderDelegate;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitImageLoaderImpl implements DMInitImageLoaderDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitImageLoaderDelegate
    public void initImageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913118810")) {
            ipChange.ipc$dispatch("-1913118810", new Object[]{this});
        } else {
            CommonBiz.getInstance().j();
        }
    }
}
