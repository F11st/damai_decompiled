package com.youku.live.dsl.usertrack;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IStatMonitorVirtualImp implements IStatMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948851816")) {
            ipChange.ipc$dispatch("948851816", new Object[]{this, str, str2, map, map2});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitFail(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886716574")) {
            ipChange.ipc$dispatch("886716574", new Object[]{this, str, str2, str3, str4});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitFail(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698988264")) {
            ipChange.ipc$dispatch("698988264", new Object[]{this, str, str2, str3, str4, str5});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitSuccess(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019193113")) {
            ipChange.ipc$dispatch("-1019193113", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitSuccess(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475903729")) {
            ipChange.ipc$dispatch("475903729", new Object[]{this, str, str2, str3});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void register(String str, String str2, List<MonitorMeasure> list, List<MonitorDimension> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-807542658")) {
            ipChange.ipc$dispatch("-807542658", new Object[]{this, str, str2, list, list2});
        }
    }
}
