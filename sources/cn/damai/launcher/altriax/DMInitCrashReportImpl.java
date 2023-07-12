package cn.damai.launcher.altriax;

import cn.damai.launcher.AppPreLauncher;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitCrashReportDelegate;
import tb.cb1;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitCrashReportImpl implements DMInitCrashReportDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitCrashReportDelegate
    public void initCrashReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246831692")) {
            ipChange.ipc$dispatch("1246831692", new Object[]{this});
            return;
        }
        cb1.f("MainScheduler", "initCrashReport");
        new AppPreLauncher().b(mu0.a());
    }
}
