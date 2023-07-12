package com.youku.live.dsl.usertrack;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IStatMonitorImp implements IStatMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758539567")) {
            ipChange.ipc$dispatch("-1758539567", new Object[]{this, str, str2, map, map2});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitFail(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545796153")) {
            ipChange.ipc$dispatch("-1545796153", new Object[]{this, str, str2, str3, str4});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitFail(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54727727")) {
            ipChange.ipc$dispatch("-54727727", new Object[]{this, str, str2, str3, str4, str5});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitSuccess(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844669282")) {
            ipChange.ipc$dispatch("-844669282", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void commitSuccess(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404656872")) {
            ipChange.ipc$dispatch("1404656872", new Object[]{this, str, str2, str3});
        }
    }

    @Override // com.youku.live.dsl.usertrack.IStatMonitor
    public void register(String str, String str2, List<MonitorMeasure> list, List<MonitorDimension> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213726617")) {
            ipChange.ipc$dispatch("-1213726617", new Object[]{this, str, str2, list, list2});
        }
    }
}
