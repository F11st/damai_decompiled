package com.youku.live.messagechannel.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ServerTimeEstimater {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "com.youku.live.messagechannel.utils.ServerTimeEstimater";
    private static long localAndServerTimestampDiff;

    public static long estimateServerTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1504337410") ? ((Long) ipChange.ipc$dispatch("-1504337410", new Object[0])).longValue() : System.currentTimeMillis() + localAndServerTimestampDiff;
    }

    public static void syncEstimaterByServerTime(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513419329")) {
            ipChange.ipc$dispatch("-513419329", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j;
        localAndServerTimestampDiff = j2 - ((j + currentTimeMillis) / 2);
        String str = TAG;
        MyLog.d(str, "Request cost time is ", Long.valueOf(j3), " ms.");
        MyLog.d(str, "LocalTime and serverTime diff is set to ", Long.valueOf(localAndServerTimestampDiff), " ms.");
    }
}
