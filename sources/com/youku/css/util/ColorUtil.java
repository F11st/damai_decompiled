package com.youku.css.util;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ColorUtil {
    private static Map<String, Integer> mCachedColor = new HashMap();

    public static int parseColorSafely(String str) {
        return parseColorSafely(str, 0);
    }

    public static int parseColorSafely(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return parseColorSafely(str2);
            }
            Integer num = mCachedColor.get(str);
            if (num != null) {
                return num.intValue();
            }
            int parseColor = Color.parseColor(str);
            mCachedColor.put(str, Integer.valueOf(parseColor));
            return parseColor;
        } catch (Exception e) {
            e.printStackTrace();
            return parseColorSafely(str2);
        }
    }

    public static int parseColorSafely(String str, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            Integer num = mCachedColor.get(str);
            if (num != null) {
                return num.intValue();
            }
            int parseColor = Color.parseColor(str);
            mCachedColor.put(str, Integer.valueOf(parseColor));
            return parseColor;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
