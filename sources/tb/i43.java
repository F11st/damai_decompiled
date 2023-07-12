package tb;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class i43 {
    public Map<String, Object> a = new ConcurrentHashMap();

    public final Map<String, Object> a() {
        HashMap hashMap = new HashMap(this.a);
        u23.c();
        hashMap.put("ctime", Long.valueOf(u23.e() / 1000));
        u23.c();
        hashMap.put("w_tm", Long.valueOf(u23.e() / 1000));
        return hashMap;
    }

    public final void b(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final Object c(String str, Object obj) {
        Object obj2 = this.a.get(str);
        return (obj2 != null || this.a.containsKey(str)) ? obj2 : obj;
    }
}
