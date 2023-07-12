package com.youku.live.dsl.usertrack;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MonitorMeasure {
    private static transient /* synthetic */ IpChange $ipChange;
    public double max;
    public double min;
    public String name;
    public double value;

    public MonitorMeasure(String str) {
        this.name = str;
    }

    public void setRange(double d, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805543606")) {
            ipChange.ipc$dispatch("805543606", new Object[]{this, Double.valueOf(d), Double.valueOf(d2)});
            return;
        }
        this.min = d;
        this.max = d2;
    }

    public MonitorMeasure(String str, double d, double d2, double d3) {
        this.name = str;
        this.value = d;
        this.max = d3;
        this.min = d2;
    }
}
