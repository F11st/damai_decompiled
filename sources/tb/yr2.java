package tb;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class yr2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1976789297") ? ((Integer) ipChange.ipc$dispatch("1976789297", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int b(Context context, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833258033") ? ((Integer) ipChange.ipc$dispatch("1833258033", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2)})).intValue() : c(context, (int) (DisplayMetrics.getheightPixels(q60.b(context)) * 0.75d), 50, i, i2);
    }

    public static int c(Context context, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825333009")) {
            return ((Integer) ipChange.ipc$dispatch("825333009", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
        }
        if (i3 == 0 || i4 == 0) {
            return 0;
        }
        int a = DisplayMetrics.getwidthPixels(q60.b(context)) - q60.a(context, i2 + i2);
        return (a * i3) / i4 >= i ? (i * i4) / i3 : a;
    }

    public static float d(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "326260583") ? ((Float) ipChange.ipc$dispatch("326260583", new Object[]{context})).floatValue() : DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
    }
}
