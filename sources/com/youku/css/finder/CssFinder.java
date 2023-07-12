package com.youku.css.finder;

import com.youku.css.dto.Css;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssFinder {
    public static <T extends Css> T findCss(Map<String, Css> map, String str) {
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (T) map.get(str);
    }
}
