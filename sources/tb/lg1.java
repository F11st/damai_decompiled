package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class lg1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final lg1 INSTANCE = new lg1();
    @NotNull
    public static final String TAG = "MoImageView";

    private lg1() {
    }

    public final void a(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109517881")) {
            ipChange.ipc$dispatch("1109517881", new Object[]{this, str});
        } else if (mg1.INSTANCE.a()) {
            if (str == null) {
                str = "";
            }
            Log.d(TAG, str);
        }
    }

    public final void b(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117170749")) {
            ipChange.ipc$dispatch("-1117170749", new Object[]{this, str, str2});
            return;
        }
        a(str + jn1.CONDITION_IF_MIDDLE + str2);
    }

    public final void c(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928538408")) {
            ipChange.ipc$dispatch("-928538408", new Object[]{this, str});
        } else if (mg1.INSTANCE.a()) {
            if (str == null) {
                str = "";
            }
            Log.e(TAG, str);
        }
    }

    public final void d(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344409250")) {
            ipChange.ipc$dispatch("344409250", new Object[]{this, str, str2});
            return;
        }
        c(str + jn1.CONDITION_IF_MIDDLE + str2);
    }

    public final void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041154054")) {
            ipChange.ipc$dispatch("1041154054", new Object[]{this, str});
        } else if (mg1.INSTANCE.a()) {
            if (str == null) {
                str = "";
            }
            Log.w(TAG, str);
        }
    }

    public final void f(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883045456")) {
            ipChange.ipc$dispatch("883045456", new Object[]{this, str, str2});
            return;
        }
        e(str + jn1.CONDITION_IF_MIDDLE + str2);
    }
}
