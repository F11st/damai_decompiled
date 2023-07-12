package cn.damai.commonbusiness.tab;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TabClickStatusManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static TabClickStatusManager b;
    private HomeTabStatus a = HomeTabStatus.SELECTED;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum HomeTabStatus {
        SELECTED,
        RE_SELECTED
    }

    public static synchronized TabClickStatusManager b() {
        synchronized (TabClickStatusManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-576563927")) {
                return (TabClickStatusManager) ipChange.ipc$dispatch("-576563927", new Object[0]);
            }
            if (b == null) {
                b = new TabClickStatusManager();
            }
            return b;
        }
    }

    public HomeTabStatus a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1072798712") ? (HomeTabStatus) ipChange.ipc$dispatch("1072798712", new Object[]{this}) : this.a;
    }

    public void c(HomeTabStatus homeTabStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181035996")) {
            ipChange.ipc$dispatch("181035996", new Object[]{this, homeTabStatus});
        } else {
            this.a = homeTabStatus;
        }
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508256177")) {
            ipChange.ipc$dispatch("-1508256177", new Object[]{this, str});
        }
    }
}
