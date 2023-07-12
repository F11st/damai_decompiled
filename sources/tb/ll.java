package tb;

import android.net.Uri;
import cn.damai.common.nav.DMNav;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class ll implements DMNav.NavPreprocessor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public void addStackUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404311071")) {
            ipChange.ipc$dispatch("1404311071", new Object[]{this, uri});
        }
    }
}
