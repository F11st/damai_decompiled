package tb;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class t60 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DisplayMetrics a;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517765801")) {
            return ((Integer) ipChange.ipc$dispatch("-1517765801", new Object[]{context, Float.valueOf(f)})).intValue();
        }
        if (context == null || context.getResources() == null) {
            return 1;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152024019")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("152024019", new Object[]{context});
        }
        if (a == null) {
            a = context.getResources().getDisplayMetrics();
        }
        return a;
    }

    public static int c(Context context, int i) {
        double d;
        double d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079057522")) {
            return ((Integer) ipChange.ipc$dispatch("-1079057522", new Object[]{context, Integer.valueOf(i)})).intValue();
        }
        double d3 = d(context);
        if (d3 <= 0.0d) {
            return i;
        }
        if (d3 >= 37.0d) {
            d2 = i * 0.9d;
        } else if (d3 < 33.0d) {
            if (d3 >= 27.0d) {
                d = i;
                return (int) (d * 0.9d);
            }
            return i;
        } else {
            d2 = i;
        }
        d = d2 * 0.9d;
        return (int) (d * 0.9d);
    }

    public static double d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725723666")) {
            return ((Double) ipChange.ipc$dispatch("-1725723666", new Object[]{context})).doubleValue();
        }
        try {
            if (Build.VERSION.SDK_INT > 16) {
                Point point = new Point();
                Display.getRealSize(((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), point);
                return new BigDecimal(Math.pow(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) / context.getResources().getDisplayMetrics().ydpi, 2.0d)).setScale(1, 4).doubleValue();
            }
            return 0.0d;
        } catch (Exception e) {
            cb1.b("DensityUtil", e.getMessage());
            return 0.0d;
        }
    }

    public static int e(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1812442939") ? ((Integer) ipChange.ipc$dispatch("-1812442939", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
