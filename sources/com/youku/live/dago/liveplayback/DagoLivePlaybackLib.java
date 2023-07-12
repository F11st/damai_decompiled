package com.youku.live.dago.liveplayback;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import com.youku.live.widgets.WidgetSDKEngine;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLivePlaybackLib {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1291814932")) {
            ipChange.ipc$dispatch("1291814932", new Object[]{application});
        } else {
            WidgetSDKEngine.registerWidget(AlixLivePlayback.WIDGET_NAME, AlixLivePlayback.class);
        }
    }
}
