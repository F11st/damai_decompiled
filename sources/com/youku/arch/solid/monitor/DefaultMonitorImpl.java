package com.youku.arch.solid.monitor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefaultMonitorImpl implements IMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.solid.monitor.IMonitor
    public void reportStageResult(SolidMonitor.Stage stage, Map<SolidMonitor.Params, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163087418")) {
            ipChange.ipc$dispatch("1163087418", new Object[]{this, stage, map});
        }
    }
}
