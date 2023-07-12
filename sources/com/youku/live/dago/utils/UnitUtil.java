package com.youku.live.dago.utils;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UnitUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dp2px(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1777164426") ? ((Integer) ipChange.ipc$dispatch("-1777164426", new Object[]{context, Integer.valueOf(i)})).intValue() : (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
