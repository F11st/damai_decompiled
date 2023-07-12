package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ao {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Map<String, String> a(Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931019261")) {
            return (Map) ipChange.ipc$dispatch("931019261", new Object[]{map, str, str2});
        }
        if (map == null) {
            return null;
        }
        map.put("content_id", str);
        map.put("content_type", str2);
        return map;
    }
}
