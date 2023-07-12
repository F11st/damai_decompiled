package com.youku.live.livesdk;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.livesdk.wkit.WidgetKitMananger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveSDK {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void initWithContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13526678")) {
            ipChange.ipc$dispatch("-13526678", new Object[]{context});
            return;
        }
        Dsl.initWithContext(context.getApplicationContext());
        WidgetKitMananger.initWithContext(context);
    }
}
