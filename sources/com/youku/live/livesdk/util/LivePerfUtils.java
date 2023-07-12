package com.youku.live.livesdk.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.config.OptConfigUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LivePerfUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean enableNotDestroySurfaceInLaifeng() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1605407940") ? ((Boolean) ipChange.ipc$dispatch("-1605407940", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("enableNotDestroySurfaceInLaifeng", true);
    }

    public static boolean enableRecyclePlayerContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2036760880") ? ((Boolean) ipChange.ipc$dispatch("2036760880", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("enableRecyclePlayerContainer", true);
    }

    public static boolean findRapidPlayInfoFromCache() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "115560301") ? ((Boolean) ipChange.ipc$dispatch("115560301", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("findRapidPlayInfoFromCache", true);
    }

    public static boolean preplayInWorkThread() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1063750171") ? ((Boolean) ipChange.ipc$dispatch("1063750171", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("preplayInWorkThread", true);
    }

    public static boolean supportAsyncViewPreLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937964242")) {
            return ((Boolean) ipChange.ipc$dispatch("-937964242", new Object[0])).booleanValue();
        }
        return false;
    }

    public static boolean supportPageMonitorTask() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1510815329") ? ((Boolean) ipChange.ipc$dispatch("-1510815329", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("supportPageMonitorTask", true);
    }

    public static boolean supportPlayerContextPrePlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "627559290") ? ((Boolean) ipChange.ipc$dispatch("627559290", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("supportPlayerContextPrePlay", true);
    }

    public static boolean usePrefetchPlayControl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1729403531") ? ((Boolean) ipChange.ipc$dispatch("-1729403531", new Object[0])).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("usePrefetchPlayControl", false);
    }
}
