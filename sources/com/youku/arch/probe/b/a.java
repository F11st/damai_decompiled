package com.youku.arch.probe.b;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    public volatile int a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public volatile int e;
    public volatile int f;
    public volatile int g;
    public volatile int h;
    public volatile int i;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266742311")) {
            return (String) ipChange.ipc$dispatch("266742311", new Object[]{this});
        }
        return "{\"ul_rt\":" + this.a + ",\"dl_rt\":" + this.b + ",\"ul_bw\":" + this.c + ",\"dl_bw\":" + this.d + ",\"ul_loss\":" + this.e + ",\"dl_rate\":" + this.f + ",\"ul_rate\":" + this.g + ",\"QoeLevel\":" + this.h + ",\"channel_index\":" + this.i + "}";
    }
}
