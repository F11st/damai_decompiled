package com.youku.arch.v3.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ColorUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Map<String, Integer> sCachedColor = new HashMap();

    public static int parseColorSafely(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2138503853") ? ((Integer) ipChange.ipc$dispatch("2138503853", new Object[]{str})).intValue() : parseColorSafely(str, 0);
    }

    public static int parseColorSafely(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570206711")) {
            return ((Integer) ipChange.ipc$dispatch("570206711", new Object[]{str, str2})).intValue();
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869139836")) {
            return ((Integer) ipChange.ipc$dispatch("1869139836", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
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
