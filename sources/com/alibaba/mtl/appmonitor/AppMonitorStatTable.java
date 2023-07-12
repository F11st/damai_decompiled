package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes6.dex */
public class AppMonitorStatTable {
    private String module;
    private String monitorPoint;

    public AppMonitorStatTable(String str, String str2) {
        this.module = str;
        this.monitorPoint = str2;
    }

    public AppMonitorStatTable registerRowAndColumn(DimensionSet dimensionSet, MeasureSet measureSet, boolean z) {
        AppMonitor.register(this.module, this.monitorPoint, measureSet, dimensionSet, z);
        return this;
    }

    public AppMonitorStatTable update(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        AppMonitor.Stat.commit(this.module, this.monitorPoint, dimensionValueSet, measureValueSet);
        return this;
    }
}
