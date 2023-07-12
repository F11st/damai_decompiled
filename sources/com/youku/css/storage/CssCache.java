package com.youku.css.storage;

import android.text.TextUtils;
import com.youku.css.binder.CssBinder;
import com.youku.css.dto.Css;
import com.youku.css.parser.CssParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssCache {
    public static ConcurrentHashMap<String, CssBinder> allCsses = new ConcurrentHashMap<>();

    public static CssBinder getCssBinder(Map map) {
        if (map != null) {
            Long l = 0L;
            String str = map.containsKey("tag") ? (String) map.get("tag") : "";
            if (TextUtils.isEmpty(str)) {
                return CssParser.parseCss(map);
            }
            CssBinder cssBinder = allCsses.get(str);
            if (cssBinder != null) {
                if (map.containsKey("updateTime")) {
                    if (map.get("updateTime") instanceof Long) {
                        l = (Long) map.get("updateTime");
                    } else if (map.get("updateTime") instanceof String) {
                        l = Long.valueOf(Long.parseLong((String) map.get("updateTime")));
                    }
                }
                if (cssBinder.isUpdateFromGlobalStyle() || l.longValue() == 0 || cssBinder.getUpdateTime().longValue() < l.longValue()) {
                    CssBinder parseCss = CssParser.parseCss(map);
                    allCsses.put(str, parseCss);
                    return parseCss;
                }
                return cssBinder;
            }
            CssBinder parseCss2 = CssParser.parseCss(map);
            allCsses.put(str, parseCss2);
            return parseCss2;
        }
        return null;
    }

    public static Map<String, Css> getCssMap(String str) {
        if (allCsses.containsKey(str)) {
            return allCsses.get(str).getCssMap();
        }
        return null;
    }
}
