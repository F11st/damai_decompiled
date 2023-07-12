package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class oi {
    private static transient /* synthetic */ IpChange $ipChange;
    boolean a = true;

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612463137")) {
            ipChange.ipc$dispatch("-612463137", new Object[]{this});
        } else {
            this.a = false;
        }
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1089951280") ? ((Boolean) ipChange.ipc$dispatch("1089951280", new Object[]{this})).booleanValue() : this.a;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876865012")) {
            ipChange.ipc$dispatch("876865012", new Object[]{this});
        } else {
            this.a = true;
        }
    }
}
