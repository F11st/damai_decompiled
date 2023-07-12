package tb;

import android.content.Context;
import android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xr2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Context context, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895953123")) {
            return ((Integer) ipChange.ipc$dispatch("-895953123", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
        }
        if (i3 == 0 || i4 == 0) {
            return 0;
        }
        s60 s60Var = s60.INSTANCE;
        DisplayMetrics d = s60Var.d(context);
        int b = d != null ? com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(d) - s60Var.b(context, i2 + i2) : i4;
        return (b * i3) / i4 >= i ? (i * i4) / i3 : b;
    }

    public static float b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1266463885") ? ((Float) ipChange.ipc$dispatch("-1266463885", new Object[]{context})).floatValue() : com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
    }
}
