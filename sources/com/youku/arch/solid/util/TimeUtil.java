package com.youku.arch.solid.util;

import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TimeUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long getCurTimeStamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1725453590") ? ((Long) ipChange.ipc$dispatch("-1725453590", new Object[0])).longValue() : SystemClock.elapsedRealtime();
    }
}
