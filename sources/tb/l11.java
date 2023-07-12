package tb;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class l11 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private final boolean b;
    @Nullable
    private j52 c;

    public l11(boolean z, boolean z2, @Nullable j52 j52Var) {
        this.a = z;
        this.b = z2;
        this.c = j52Var;
    }

    @Nullable
    public j52 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1772501468") ? (j52) ipChange.ipc$dispatch("1772501468", new Object[]{this}) : this.c;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-800247417") ? ((Boolean) ipChange.ipc$dispatch("-800247417", new Object[]{this})).booleanValue() : this.b;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1659735090") ? ((Boolean) ipChange.ipc$dispatch("-1659735090", new Object[]{this})).booleanValue() : this.a;
    }
}
