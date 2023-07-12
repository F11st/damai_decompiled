package com.youku.live.messagechannel.channel;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CDNInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @NonNull
    public int pullInterval;
    @NonNull
    public String url;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636276540")) {
            return (String) ipChange.ipc$dispatch("-1636276540", new Object[]{this});
        }
        return "CDNInfo{pullInterval=" + this.pullInterval + ", url='" + this.url + "'}";
    }
}
