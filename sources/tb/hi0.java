package tb;

import com.alibaba.analytics.utils.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class hi0 {
    private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n]|\u0001|\u0000)+");

    private static String a(String str) {
        return b(str);
    }

    private static String b(String str) {
        return (str == null || "".equals(str)) ? str : a.matcher(str).replaceAll("");
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = map.keySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    try {
                        String next = it.next();
                        if (next != null) {
                            hashMap.put(next, a(map.get(next)));
                        }
                    } catch (Throwable th) {
                        Logger.h("[_checkMapFields]", th, new Object[0]);
                    }
                }
            }
            return hashMap;
        }
        return null;
    }
}
