package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class x2<R> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    @Nullable
    private final R b;

    public x2(boolean z, @Nullable R r, @Nullable String str, @Nullable String str2) {
        this.a = z;
        this.b = r;
    }

    @Nullable
    public final R a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1880646823") ? (R) ipChange.ipc$dispatch("-1880646823", new Object[]{this}) : this.b;
    }

    public final boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1885133323") ? ((Boolean) ipChange.ipc$dispatch("-1885133323", new Object[]{this})).booleanValue() : this.a;
    }

    public /* synthetic */ x2(boolean z, Object obj, String str, String str2, int i, k50 k50Var) {
        this(z, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }
}
