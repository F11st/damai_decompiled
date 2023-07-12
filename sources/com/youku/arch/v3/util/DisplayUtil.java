package com.youku.arch.v3.util;

import android.content.Context;
import android.util.TypedValue;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DisplayUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1358418677") ? ((Integer) ipChange.ipc$dispatch("1358418677", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1063744422") ? ((Integer) ipChange.ipc$dispatch("1063744422", new Object[]{context, Integer.valueOf(i)})).intValue() : (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
