package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class p41 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;

    public p41() {
        this(0, 0);
    }

    public boolean a(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1064476304") ? ((Boolean) ipChange.ipc$dispatch("-1064476304", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i >= c() && i <= d();
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-476160784") ? ((Integer) ipChange.ipc$dispatch("-476160784", new Object[]{this})).intValue() : this.b;
    }

    public int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-654021713") ? ((Integer) ipChange.ipc$dispatch("-654021713", new Object[]{this})).intValue() : this.a;
    }

    public int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-327574213") ? ((Integer) ipChange.ipc$dispatch("-327574213", new Object[]{this})).intValue() : (c() + b()) - 1;
    }

    public p41(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
