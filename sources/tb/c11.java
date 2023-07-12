package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class c11 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(int i, short s, byte b, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040100548")) {
            return ((Long) ipChange.ipc$dispatch("-2040100548", new Object[]{Integer.valueOf(i), Short.valueOf(s), Byte.valueOf(b), Boolean.valueOf(z)})).longValue();
        }
        return ((((((z ? 1L : 0L) << 8) + b) << 16) + s) << 32) + i;
    }
}
