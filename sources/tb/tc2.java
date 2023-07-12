package tb;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class tc2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;
    private Activity b;

    public tc2() {
    }

    public Activity a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "376917394") ? (Activity) ipChange.ipc$dispatch("376917394", new Object[]{this}) : this.b;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-989056493") ? ((Boolean) ipChange.ipc$dispatch("-989056493", new Object[]{this})).booleanValue() : this.a;
    }

    public tc2(boolean z, Activity activity) {
        this.a = z;
        this.b = activity;
    }
}
