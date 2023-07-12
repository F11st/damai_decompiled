package com.alient.resource.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ColorUtil {
    private static final Map<String, Integer> sCachedColor = new HashMap();

    public static int parseColorSafely(String str) {
        return parseColorSafely(str, 0);
    }

    public static int parseColorSafely(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return parseColorSafely(str2);
            }
            Map<String, Integer> map = sCachedColor;
            Integer num = map.get(str);
            if (num != null) {
                return num.intValue();
            }
            if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str;
            }
            int parseColor = Color.parseColor(str);
            map.put(str, Integer.valueOf(parseColor));
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
            Map<String, Integer> map = sCachedColor;
            Integer num = map.get(str);
            if (num != null) {
                return num.intValue();
            }
            if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str;
            }
            int parseColor = Color.parseColor(str);
            map.put(str, Integer.valueOf(parseColor));
            return parseColor;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
