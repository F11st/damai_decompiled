package com.youku.live.livesdk.widgets.helper;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ColorHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int parseColor(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506809055")) {
            return ((Integer) ipChange.ipc$dispatch("506809055", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        int length = str.length();
        if (str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            String str2 = null;
            if (length == 7 || length == 9) {
                StringBuilder sb = new StringBuilder();
                sb.append(length == 7 ? "FF" : "");
                sb.append(str.substring(1));
                str2 = sb.toString();
            }
            if (str2 != null) {
                try {
                    return Integer.parseInt(str2, 16);
                } catch (Throwable unused) {
                    return i;
                }
            }
            return i;
        }
        return i;
    }
}
