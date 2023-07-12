package com.youku.live.livesdk.preloader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LayoutPreloader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LayoutPreloader sLayoutPreloader;

    public static LayoutPreloader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062122235")) {
            return (LayoutPreloader) ipChange.ipc$dispatch("1062122235", new Object[0]);
        }
        if (sLayoutPreloader == null) {
            synchronized (LayoutPreloader.class) {
                if (sLayoutPreloader == null) {
                    sLayoutPreloader = new LayoutPreloader();
                }
            }
            sLayoutPreloader.init();
        }
        return sLayoutPreloader;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229628056")) {
            ipChange.ipc$dispatch("-229628056", new Object[]{this});
        }
    }
}
