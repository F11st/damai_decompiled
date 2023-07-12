package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class gu1<Response> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean a = Boolean.FALSE;
    @Nullable
    private dc0<Response> b;

    @Nullable
    public final dc0<Response> a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1092786299") ? (dc0) ipChange.ipc$dispatch("1092786299", new Object[]{this}) : this.b;
    }

    @Nullable
    public final Boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "8963219") ? (Boolean) ipChange.ipc$dispatch("8963219", new Object[]{this}) : this.a;
    }

    public final void c(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820874633")) {
            ipChange.ipc$dispatch("-820874633", new Object[]{this, bool});
        } else {
            this.a = bool;
        }
    }

    public final void d(@Nullable dc0<Response> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133594581")) {
            ipChange.ipc$dispatch("2133594581", new Object[]{this, dc0Var});
        } else {
            this.b = dc0Var;
        }
    }
}
