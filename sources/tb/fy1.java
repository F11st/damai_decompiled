package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class fy1 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_SCAN_PAGE = "scan";
    public static final String HOME_TICKET_SCAN_PAGE = "ticket_scan";

    /* compiled from: Taobao */
    /* renamed from: tb.fy1$a */
    /* loaded from: classes4.dex */
    private static class C9150a {
        private static final fy1 a = new fy1();
    }

    public static final fy1 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-77638405") ? (fy1) ipChange.ipc$dispatch("-77638405", new Object[0]) : C9150a.a;
    }

    public C0525a.C0527b g(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1821838401") ? (C0525a.C0527b) ipChange.ipc$dispatch("1821838401", new Object[]{this, str}) : b(str);
    }
}
