package com.youku.live.livesdk.wkit.utils;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ColorUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int parseColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384636975")) {
            return ((Integer) ipChange.ipc$dispatch("-384636975", new Object[]{str})).intValue();
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
