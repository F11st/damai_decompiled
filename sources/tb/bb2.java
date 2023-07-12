package tb;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class bb2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Collection collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518632443")) {
            return ((Integer) ipChange.ipc$dispatch("1518632443", new Object[]{collection})).intValue();
        }
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Nullable
    public static <T> T b(List<T> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655402705")) {
            return (T) ipChange.ipc$dispatch("655402705", new Object[]{list, Integer.valueOf(i)});
        }
        if (!d(list) && i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        return null;
    }

    public static int c(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2145859593") ? ((Integer) ipChange.ipc$dispatch("2145859593", new Object[]{collection})).intValue() : a(collection);
    }

    public static boolean d(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1236394164") ? ((Boolean) ipChange.ipc$dispatch("-1236394164", new Object[]{collection})).booleanValue() : collection == null || collection.size() == 0;
    }

    public static boolean e(Map map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1210757484") ? ((Boolean) ipChange.ipc$dispatch("-1210757484", new Object[]{map})).booleanValue() : map == null || map.size() == 0;
    }

    public static boolean f(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2031521355") ? ((Boolean) ipChange.ipc$dispatch("2031521355", new Object[]{collection})).booleanValue() : !d(collection);
    }

    public static boolean g(Map map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-470608621") ? ((Boolean) ipChange.ipc$dispatch("-470608621", new Object[]{map})).booleanValue() : !e(map);
    }
}
