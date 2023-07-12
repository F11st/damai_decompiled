package com.youku.live.messagechannel.channel;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MASSInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @NonNull
    public boolean connectByMyself;
    @NonNull
    public String topic;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653956155")) {
            return (String) ipChange.ipc$dispatch("-653956155", new Object[]{this});
        }
        return "MASSInfo{topic='" + this.topic + "', connectByMyself=" + this.connectByMyself + '}';
    }
}
