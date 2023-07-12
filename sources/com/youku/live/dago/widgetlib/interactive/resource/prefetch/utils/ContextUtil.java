package com.youku.live.dago.widgetlib.interactive.resource.prefetch.utils;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ContextUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Context getApplicationContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1323938646") ? (Context) ipChange.ipc$dispatch("-1323938646", new Object[0]) : AppContextUtils.getApp().getApplicationContext();
    }
}
