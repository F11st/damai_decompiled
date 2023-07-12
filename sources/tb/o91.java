package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class o91 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(List<?> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1972693645") ? ((Boolean) ipChange.ipc$dispatch("1972693645", new Object[]{list})).booleanValue() : list == null || list.size() <= 0;
    }
}
