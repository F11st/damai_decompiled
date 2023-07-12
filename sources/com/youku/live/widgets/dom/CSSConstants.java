package com.youku.live.widgets.dom;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CSSConstants {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final float UNDEFINED = Float.NaN;

    public static boolean isUndefined(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "717892581") ? ((Boolean) ipChange.ipc$dispatch("717892581", new Object[]{Float.valueOf(f)})).booleanValue() : Float.compare(f, Float.NaN) == 0;
    }
}
