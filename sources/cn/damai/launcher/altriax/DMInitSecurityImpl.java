package cn.damai.launcher.altriax;

import cn.damai.security.AliSecurityHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitSecurityDelegate;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitSecurityImpl implements DMInitSecurityDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580828074")) {
            ipChange.ipc$dispatch("1580828074", new Object[]{this});
            return;
        }
        cb1.f("MainScheduler", "initAliSecurity");
        AliSecurityHelper.a();
    }
}
