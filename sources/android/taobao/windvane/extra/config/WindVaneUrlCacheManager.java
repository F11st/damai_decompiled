package android.taobao.windvane.extra.config;

import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WindVaneUrlCacheManager {
    static Map<String, String> urlMap;

    public static String getCacheFilePath(String str) {
        String str2;
        if (urlMap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (WindVaneUrlCacheManager.class) {
            str2 = urlMap.containsKey(str) ? urlMap.get(str) : null;
        }
        return str2;
    }

    public static boolean registerUrl(String str, String str2) {
        synchronized (WindVaneUrlCacheManager.class) {
            if (urlMap == null) {
                urlMap = new HashMap();
            }
            if (new File(str).exists()) {
                Map<String, String> map = urlMap;
                map.put(str2, "File://" + str);
                return true;
            }
            return false;
        }
    }

    public static void unRegisterUrl(String str) {
        if (urlMap == null) {
            return;
        }
        synchronized (WindVaneUrlCacheManager.class) {
            if (urlMap.containsKey(str)) {
                urlMap.remove(str);
            }
        }
    }
}
