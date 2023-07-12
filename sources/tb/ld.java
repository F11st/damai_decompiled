package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ld {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ld INSTANCE = new ld();
    @NotNull
    private static String a = "a2o4t";

    private ld() {
    }

    @NotNull
    public final String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2118287752") ? (String) ipChange.ipc$dispatch("2118287752", new Object[]{this}) : a;
    }
}
