package tb;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class cb2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Collection collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854904448")) {
            return ((Integer) ipChange.ipc$dispatch("-854904448", new Object[]{collection})).intValue();
        }
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Nullable
    public static <T> T b(List<T> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985071148")) {
            return (T) ipChange.ipc$dispatch("985071148", new Object[]{list, Integer.valueOf(i)});
        }
        if (!d(list) && i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        return null;
    }

    public static boolean c(ArrayMap arrayMap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1873736910") ? ((Boolean) ipChange.ipc$dispatch("-1873736910", new Object[]{arrayMap})).booleanValue() : arrayMap == null || arrayMap.size() == 0;
    }

    public static boolean d(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-66033881") ? ((Boolean) ipChange.ipc$dispatch("-66033881", new Object[]{collection})).booleanValue() : collection == null || collection.size() == 0;
    }

    public static boolean e(LongSparseArray longSparseArray) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-776573957") ? ((Boolean) ipChange.ipc$dispatch("-776573957", new Object[]{longSparseArray})).booleanValue() : longSparseArray == null || longSparseArray.size() == 0;
    }

    public static boolean f(Map map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "127122415") ? ((Boolean) ipChange.ipc$dispatch("127122415", new Object[]{map})).booleanValue() : map == null || map.size() == 0;
    }

    public static boolean g(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-342015536") ? ((Boolean) ipChange.ipc$dispatch("-342015536", new Object[]{collection})).booleanValue() : !d(collection);
    }

    public static boolean h(Map map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1946004712") ? ((Boolean) ipChange.ipc$dispatch("-1946004712", new Object[]{map})).booleanValue() : !f(map);
    }

    public static void i(Map<String, String> map, Map<String, String> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546641759")) {
            ipChange.ipc$dispatch("-1546641759", new Object[]{map, map2});
        } else if (map == null || map2 == null || map2.size() <= 0) {
        } else {
            map.putAll(map2);
        }
    }
}
