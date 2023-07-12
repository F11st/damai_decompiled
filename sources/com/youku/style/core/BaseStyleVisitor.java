package com.youku.style.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.youku.css.util.ColorUtil;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class BaseStyleVisitor<STYLE extends Map> implements Serializable {
    protected STYLE styleMap;

    public BaseStyleVisitor(STYLE style) {
        this.styleMap = style;
    }

    public static String getColorString(int i) {
        return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + Integer.toHexString(i);
    }

    public static String getColorStringFromRes(Context context, int i) {
        return getColorString(getResColor(context, i));
    }

    private static int getResColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getStyleColor(@Nullable Map map, String str) {
        return getStyleColor(map, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getStyleColorFromRes(Context context, @Nullable Map map, String str, int i) {
        return getStyleColor(map, str, getResColor(context, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float getStyleFloatValue(@Nullable Map map, String str) {
        if (hasStyleTypedValue(map, str, Float.class)) {
            return ((Float) map.get(str)).floatValue();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getStyleIntValue(@Nullable Map map, String str) {
        if (hasStyleTypedValue(map, str, Integer.class)) {
            return ((Integer) map.get(str)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getStyleStringValue(@Nullable Map map, String str) {
        if (hasStyleTypedValue(map, str, String.class)) {
            return (String) map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean hasStyleStringValue(@Nullable Map map, String str) {
        return hasStyleTypedValue(map, str, String.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean hasStyleTypedValue(@Nullable Map map, String str, Class cls) {
        boolean z = map != null && map.containsKey(str) && map.get(str) != null && map.get(str).getClass().isAssignableFrom(cls);
        if (z && cls == String.class && TextUtils.isEmpty((String) map.get(str))) {
            return false;
        }
        return z;
    }

    public static boolean isStyleEquals(Map map, Map map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null) {
            return false;
        }
        if (map.size() == 0 && map2.size() == 0) {
            return true;
        }
        return StyleFactory.getInstance().create(map).equals(StyleFactory.getInstance().create(map2));
    }

    public STYLE getStyle() {
        return this.styleMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getStyleColor(@Nullable Map map, String str, String str2) {
        return getStyleColor(map, str, ColorUtil.parseColorSafely(str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getStyleColor(@Nullable Map map, String str, int i) {
        String styleStringValue = getStyleStringValue(map, str);
        return !TextUtils.isEmpty(styleStringValue) ? ColorUtil.parseColorSafely(styleStringValue, i) : i;
    }
}
