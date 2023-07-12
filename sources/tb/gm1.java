package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class gm1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static double a(double d, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "89813162") ? ((Double) ipChange.ipc$dispatch("89813162", new Object[]{Double.valueOf(d), Integer.valueOf(i)})).doubleValue() : new BigDecimal(Double.toString(d)).divide(new BigDecimal(Integer.toString(i))).doubleValue();
    }

    public static double b(double d, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1199558431") ? ((Double) ipChange.ipc$dispatch("1199558431", new Object[]{Double.valueOf(d), Integer.valueOf(i)})).doubleValue() : new BigDecimal(Double.toString(d)).multiply(new BigDecimal(Integer.toString(i))).doubleValue();
    }

    public static String c(double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "256887362") ? (String) ipChange.ipc$dispatch("256887362", new Object[]{Double.valueOf(d)}) : th2.a(d);
    }
}
