package tb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes5.dex */
public class fd1 {
    public static Map<String, String> a(Map<String, Object> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            if (map == null || map.size() <= 0 || (r1 = map.keySet().iterator()) == null) {
                return null;
            }
            for (String str : map.keySet()) {
                String c = yh2.c(map.get(str));
                if (str != null) {
                    hashMap.put(str, c);
                }
            }
            return hashMap;
        }
        return null;
    }

    public static Map<String, String> b(Properties properties) {
        if (properties != null) {
            HashMap hashMap = new HashMap();
            for (Object obj : properties.keySet()) {
                if (obj instanceof String) {
                    String c = yh2.c(obj);
                    String c2 = yh2.c(properties.get(obj));
                    if (!yh2.f(c) && !yh2.f(c2)) {
                        hashMap.put(c, c2);
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                if (str instanceof String) {
                    String str2 = map.get(str);
                    if (!yh2.f(str) && !yh2.f(str2)) {
                        try {
                            hashMap.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return hashMap;
        }
        return map;
    }
}
