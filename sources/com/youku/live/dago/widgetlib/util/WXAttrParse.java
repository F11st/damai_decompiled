package com.youku.live.dago.widgetlib.util;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WXAttrParse {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean getBoolean(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1183250432") ? ((Boolean) ipChange.ipc$dispatch("-1183250432", new Object[]{obj})).booleanValue() : obj != null && Boolean.parseBoolean(getString(obj));
    }

    public static int getColor(Object obj, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133976395")) {
            return ((Integer) ipChange.ipc$dispatch("-133976395", new Object[]{obj, Integer.valueOf(i)})).intValue();
        }
        if (obj == null) {
            return i;
        }
        return Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + String.valueOf(obj));
    }

    public static int getInt(Object obj, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1292360319") ? ((Integer) ipChange.ipc$dispatch("-1292360319", new Object[]{obj, Integer.valueOf(i)})).intValue() : obj == null ? i : Integer.parseInt(getString(obj));
    }

    public static String getString(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2043353363") ? (String) ipChange.ipc$dispatch("2043353363", new Object[]{obj}) : getString(obj, null);
    }

    public static String getString(Object obj, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1761764809") ? (String) ipChange.ipc$dispatch("1761764809", new Object[]{obj, str}) : obj == null ? str : String.valueOf(obj);
    }
}
