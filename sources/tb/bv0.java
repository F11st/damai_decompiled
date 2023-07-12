package tb;

import android.app.Activity;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class bv0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final bv0 INSTANCE = new bv0();

    private bv0() {
    }

    public final int a(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644389549")) {
            return ((Integer) ipChange.ipc$dispatch("-1644389549", new Object[]{this, activity})).intValue();
        }
        b41.i(activity, "activity");
        if (Build.VERSION.SDK_INT >= 23) {
            return s60.INSTANCE.a(activity, 45.0f) + jg2.a(activity);
        }
        return s60.INSTANCE.a(activity, 45.0f);
    }
}
