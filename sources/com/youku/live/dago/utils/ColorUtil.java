package com.youku.live.dago.utils;

import android.graphics.Color;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ColorUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int getColorWithAlpha(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "424015660") ? ((Integer) ipChange.ipc$dispatch("424015660", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public static String getHexString(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127506992")) {
            return (String) ipChange.ipc$dispatch("127506992", new Object[]{Integer.valueOf(i)});
        }
        return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + Integer.toHexString((i & 255) | ((-16777216) & i) | (16711680 & i) | (65280 & i));
    }

    public static int parseColor(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1375166003")) {
            return ((Integer) ipChange.ipc$dispatch("1375166003", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        if (str != null) {
            if (str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                return Color.parseColor(str);
            }
            if (str.startsWith("rgb")) {
                String substring = str.substring(str.indexOf(jn1.BRACKET_START_STR) + 1, str.indexOf(jn1.BRACKET_END_STR));
                if (TextUtils.isEmpty(substring)) {
                    return i;
                }
                String[] split = substring.split(",");
                return (split == null || split.length != 4) ? Color.argb((int) (Float.parseFloat(split[3]) * 255.0f), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])) : i;
            }
            return i;
        }
        return i;
    }
}
