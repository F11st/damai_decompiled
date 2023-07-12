package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ForeBackManager;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitFbmDelegate;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMInitFbmImpl implements DMInitFbmDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitFbmDelegate
    public void initForeBackManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174816377")) {
            ipChange.ipc$dispatch("-174816377", new Object[]{this});
            return;
        }
        GlobalClientInfo.mContext = mu0.a().getApplicationContext();
        ForeBackManager.getManager().initialize(mu0.a());
    }
}
