package com.youku.live.arch.monitor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class OnlineMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getCurrentPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1403238072") ? (String) ipChange.ipc$dispatch("1403238072", new Object[0]) : "";
    }

    public static String getCurrentSpm() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1718529896") ? (String) ipChange.ipc$dispatch("1718529896", new Object[0]) : "";
    }

    public static void loge(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858441193")) {
            ipChange.ipc$dispatch("-858441193", new Object[]{str, map});
        }
    }
}
