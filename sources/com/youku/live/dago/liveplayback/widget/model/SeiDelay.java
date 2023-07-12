package com.youku.live.dago.liveplayback.widget.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SeiDelay {
    private static transient /* synthetic */ IpChange $ipChange;
    public long ntpOffset;
    public long mDelay = 0;
    public String seiTimestamp = "0";
    public String localTimestamp = "0";

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50604938")) {
            ipChange.ipc$dispatch("-50604938", new Object[]{this});
            return;
        }
        this.mDelay = 0L;
        this.seiTimestamp = "0";
        this.ntpOffset = 0L;
        this.localTimestamp = "0";
    }
}
