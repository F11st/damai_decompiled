package tb;

import android.content.Context;
import android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class k62 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static long a;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2033106594") ? ((Integer) ipChange.ipc$dispatch("2033106594", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-698095906") ? (DisplayMetrics) ipChange.ipc$dispatch("-698095906", new Object[]{context}) : context.getResources().getDisplayMetrics();
    }

    public static int c(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1107439833") ? ((Integer) ipChange.ipc$dispatch("1107439833", new Object[]{context})).intValue() : com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
    }

    public static boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705006309")) {
            return ((Boolean) ipChange.ipc$dispatch("1705006309", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - a <= 300;
        if (!z) {
            a = currentTimeMillis;
        }
        return z;
    }
}
