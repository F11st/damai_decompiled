package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class aw0 {
    private static transient /* synthetic */ IpChange $ipChange;

    static {
        new aw0();
    }

    private aw0() {
    }

    public static int a(double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "973021104") ? ((Integer) ipChange.ipc$dispatch("973021104", new Object[]{Double.valueOf(d)})).intValue() : (int) (d * 100.0d);
    }

    public static int b(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1291808891") ? ((Integer) ipChange.ipc$dispatch("-1291808891", new Object[]{Integer.valueOf(i)})).intValue() : i;
    }

    public static int c(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-861214427") ? ((Integer) ipChange.ipc$dispatch("-861214427", new Object[]{Long.valueOf(j)})).intValue() : (int) (j ^ (j >>> 32));
    }

    public static int d(Long l) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "777051140") ? ((Integer) ipChange.ipc$dispatch("777051140", new Object[]{l})).intValue() : l.hashCode();
    }

    public static int e(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2138078374") ? ((Integer) ipChange.ipc$dispatch("-2138078374", new Object[]{str})).intValue() : str.hashCode();
    }
}
