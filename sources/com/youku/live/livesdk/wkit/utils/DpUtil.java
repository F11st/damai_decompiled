package com.youku.live.livesdk.wkit.utils;

import android.content.res.Resources;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DpUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-210937055") ? ((Integer) ipChange.ipc$dispatch("-210937055", new Object[]{Float.valueOf(f)})).intValue() : (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "921515507") ? ((Integer) ipChange.ipc$dispatch("921515507", new Object[]{Float.valueOf(f)})).intValue() : (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
