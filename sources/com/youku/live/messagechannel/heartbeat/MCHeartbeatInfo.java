package com.youku.live.messagechannel.heartbeat;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCHeartbeatInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public int hbInterval;
    public String heartbeatToken;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1532120850")) {
            return (String) ipChange.ipc$dispatch("1532120850", new Object[]{this});
        }
        return "MCHeartbeatInfo{heartbeatToken='" + this.heartbeatToken + "', hbInterval=" + this.hbInterval + '}';
    }
}
