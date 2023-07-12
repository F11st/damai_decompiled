package com.youku.live.widgets.weex;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class WidgetWeex {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343443287")) {
            ipChange.ipc$dispatch("-343443287", new Object[0]);
        }
    }

    public static void uninit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339311344")) {
            ipChange.ipc$dispatch("339311344", new Object[0]);
        }
    }
}
