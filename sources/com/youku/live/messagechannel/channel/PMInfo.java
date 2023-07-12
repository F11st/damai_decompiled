package com.youku.live.messagechannel.channel;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PMInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @NonNull
    public int bizCode;
    @NonNull
    public boolean isBanConnect = false;
    @NonNull
    public int msgFetchMode;
    @NonNull
    public String topic;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656997148")) {
            return (String) ipChange.ipc$dispatch("1656997148", new Object[]{this});
        }
        return "PMInfo{bizCode=" + this.bizCode + ", topic='" + this.topic + "', msgFetchMode=" + this.msgFetchMode + ", isBanConnect=" + this.isBanConnect + '}';
    }
}
