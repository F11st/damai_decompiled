package cn.damai.launcher.altriax;

import android.app.Application;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitTLogDelegate;
import tb.ik2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitTLogImpl implements DMInitTLogDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767371034")) {
            ipChange.ipc$dispatch("1767371034", new Object[]{this});
            return;
        }
        Application a = mu0.a();
        ik2.a(a, a, AppConfig.n(a));
    }
}
