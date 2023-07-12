package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class lk {
    private static transient /* synthetic */ IpChange $ipChange;

    @SafeVarargs
    public static <T> ArrayList<T> a(T... tArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-809620153") ? (ArrayList) ipChange.ipc$dispatch("-809620153", new Object[]{tArr}) : new ArrayList<>(Arrays.asList(tArr));
    }
}
