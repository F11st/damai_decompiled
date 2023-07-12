package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class tq {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Object[] objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305990087")) {
            return ((Integer) ipChange.ipc$dispatch("-1305990087", new Object[]{objArr})).intValue();
        }
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public static int b(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1901949573")) {
            return ((Integer) ipChange.ipc$dispatch("-1901949573", new Object[]{iArr})).intValue();
        }
        if (iArr == null) {
            return 0;
        }
        return iArr.length;
    }
}
