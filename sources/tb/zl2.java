package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class zl2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499613412")) {
            return ((Integer) ipChange.ipc$dispatch("1499613412", new Object[]{context, Float.valueOf(f)})).intValue();
        }
        if (context == null || context.getResources() == null) {
            return 1;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
