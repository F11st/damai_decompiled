package tb;

import com.taobao.monitor.impl.trace.IDispatcher;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ca0 {
    private static Map<String, IDispatcher> a = new HashMap();

    public static void a(String str, IDispatcher iDispatcher) {
        a.put(str, iDispatcher);
    }

    public static IDispatcher b(String str) {
        IDispatcher iDispatcher = a.get(str);
        return iDispatcher == null ? de0.c : iDispatcher;
    }

    public static boolean c(IDispatcher iDispatcher) {
        return iDispatcher == null || iDispatcher == de0.c;
    }
}
