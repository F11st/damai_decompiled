package com.youku.live.arch.utils;

import android.content.res.Resources;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DPUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1942150808") ? ((Integer) ipChange.ipc$dispatch("-1942150808", new Object[]{Float.valueOf(f)})).intValue() : (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-809698246") ? ((Integer) ipChange.ipc$dispatch("-809698246", new Object[]{Float.valueOf(f)})).intValue() : (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
