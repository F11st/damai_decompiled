package tb;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wa2 {
    private static volatile wa2 b;
    private final ConcurrentHashMap<String, Object> a = new ConcurrentHashMap<>();

    private wa2() {
    }

    public static wa2 b() {
        if (b == null) {
            synchronized (wa2.class) {
                if (b == null) {
                    b = new wa2();
                }
            }
        }
        return b;
    }

    public void a(List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            this.a.remove(str);
        }
    }

    public Object c(String str) {
        return this.a.get(str);
    }

    public void d(String str, Object obj) {
        this.a.putIfAbsent(str, obj);
    }
}
