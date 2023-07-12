package tb;

import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class zn2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static long a;
    private static long b;

    public static int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1694776098")) {
            return ((Integer) ipChange.ipc$dispatch("-1694776098", new Object[0])).intValue();
        }
        long j = (b - a) / 2;
        if (j > 0) {
            if (j <= 1000) {
                return 1;
            }
            int i = (int) (j / 1000);
            return j % 1000 > 0 ? i + 1 : i;
        }
        return 0;
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833274008")) {
            ipChange.ipc$dispatch("1833274008", new Object[0]);
        } else {
            b = SystemClock.elapsedRealtime();
        }
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1911555959")) {
            ipChange.ipc$dispatch("1911555959", new Object[0]);
        } else {
            a = SystemClock.elapsedRealtime();
        }
    }
}
