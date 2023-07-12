package tb;

import androidx.annotation.Nullable;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vg2 {
    public static Map<String, Object> a(List<String> list) {
        if (list == null) {
            list = new ArrayList<>(1);
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", "success");
        hashMap.put("data", list);
        return hashMap;
    }

    public static Map<String, Object> b(String str) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", str != null ? "success" : "failed");
        if (str == null) {
            str = Constants.Name.UNDEFINED;
        }
        hashMap.put("data", str);
        return hashMap;
    }

    public static Map<String, Object> c(long j) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", "success");
        hashMap.put("data", Long.valueOf(j));
        return hashMap;
    }

    public static void d(@Nullable JSCallback jSCallback) {
        f(jSCallback, "failed", "invalid_param");
    }

    public static void e(@Nullable JSCallback jSCallback) {
        f(jSCallback, "failed", "no_handler");
    }

    private static void f(@Nullable JSCallback jSCallback, String str, Object obj) {
        if (jSCallback == null) {
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", str);
        hashMap.put("data", obj);
        jSCallback.invoke(hashMap);
    }

    public static Map<String, Object> g(boolean z) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", z ? "success" : "failed");
        hashMap.put("data", Constants.Name.UNDEFINED);
        return hashMap;
    }

    public static Map<String, Object> h(boolean z) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", z ? "success" : "failed");
        hashMap.put("data", Constants.Name.UNDEFINED);
        return hashMap;
    }
}
