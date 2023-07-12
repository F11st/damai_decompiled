package tb;

import androidx.fragment.app.FragmentActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class ab {
    private static transient /* synthetic */ IpChange $ipChange;

    public final void a(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722022874")) {
            ipChange.ipc$dispatch("-722022874", new Object[]{this, str, str2});
        }
    }

    public abstract void b(@NotNull FragmentActivity fragmentActivity, @NotNull HashSet<String> hashSet);
}
