package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class fy1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_SCAN_PAGE = "scan";
    public static final String HOME_TICKET_SCAN_PAGE = "ticket_scan";

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    private static class a {
        private static final fy1 a = new fy1();
    }

    public static final fy1 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-77638405") ? (fy1) ipChange.ipc$dispatch("-77638405", new Object[0]) : a.a;
    }

    public a.b g(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1821838401") ? (a.b) ipChange.ipc$dispatch("1821838401", new Object[]{this, str}) : b(str);
    }
}
