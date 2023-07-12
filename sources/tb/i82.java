package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class i82 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;

    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2069377480") ? (String) ipChange.ipc$dispatch("-2069377480", new Object[]{this}) : this.a;
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-512399847") ? (String) ipChange.ipc$dispatch("-512399847", new Object[]{this}) : this.b;
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671688614")) {
            ipChange.ipc$dispatch("671688614", new Object[]{this, str});
        } else {
            this.a = str;
        }
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123679205")) {
            ipChange.ipc$dispatch("123679205", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }
}
