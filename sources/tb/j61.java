package tb;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class j61 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> ArrayList<T> a(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315320319")) {
            return (ArrayList) ipChange.ipc$dispatch("315320319", new Object[]{str, cls});
        }
        try {
            return (ArrayList) JSON.parseArray(str, cls);
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }

    public static <T> String b(List<T> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "773999041") ? (String) ipChange.ipc$dispatch("773999041", new Object[]{list}) : JSON.toJSONString(list);
    }
}
