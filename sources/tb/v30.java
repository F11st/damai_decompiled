package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class v30 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1570974587") ? ((Integer) ipChange.ipc$dispatch("-1570974587", new Object[0])).intValue() : Calendar.getInstance().get(5);
    }

    public static int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-856820166") ? ((Integer) ipChange.ipc$dispatch("-856820166", new Object[0])).intValue() : Calendar.getInstance().get(2) + 1;
    }

    public static int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-898347399") ? ((Integer) ipChange.ipc$dispatch("-898347399", new Object[0])).intValue() : Calendar.getInstance().get(1);
    }
}
