package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class mz1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(float f, float f2, float f3, float f4, float f5, float f6) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1975935200") ? ((Boolean) ipChange.ipc$dispatch("1975935200", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})).booleanValue() : f >= f3 && f <= f5 && f2 >= f4 && f2 <= f6;
    }
}
