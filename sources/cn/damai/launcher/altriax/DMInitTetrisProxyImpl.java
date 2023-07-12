package cn.damai.launcher.altriax;

import cn.damai.launcher.DmShareImpl;
import cn.damai.launcher.initialize.CommonBiz;
import com.alibaba.pictures.bricks.util.share.ShareProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitTetrisProxyDelegate;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitTetrisProxyImpl implements DMInitTetrisProxyDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197616387")) {
            ipChange.ipc$dispatch("-1197616387", new Object[]{this});
            return;
        }
        CommonBiz.getInstance().A();
        ShareProxy.b(DmShareImpl.class);
    }
}
