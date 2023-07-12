package com.youku.live.dsl.log;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PerfLogUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TAG_PERF_YW";
    private static boolean enableLog = true;
    private static long startTime;

    public static void log(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532519023")) {
            ipChange.ipc$dispatch("-1532519023", new Object[]{str});
        } else if (enableLog) {
            Log.e(TAG, (System.currentTimeMillis() - startTime) + AVFSCacheConstants.COMMA_SEP + System.currentTimeMillis() + AVFSCacheConstants.COMMA_SEP + str);
        }
    }

    public static void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800891433")) {
            ipChange.ipc$dispatch("1800891433", new Object[0]);
        } else if (enableLog) {
            startTime = System.currentTimeMillis();
            Log.e(TAG, "0, " + startTime + ", start....");
        }
    }
}
