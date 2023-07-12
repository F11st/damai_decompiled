package com.youku.live.dsl.alarm;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ILiveAlarmVirtualImp implements ILiveAlarm {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.alarm.ILiveAlarm
    public void alarm(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317891266")) {
            ipChange.ipc$dispatch("-317891266", new Object[]{this, str, str2, str3});
        }
    }

    @Override // com.youku.live.dsl.alarm.ILiveAlarm
    public void alarm(String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902994809")) {
            ipChange.ipc$dispatch("-1902994809", new Object[]{this, str, str2, str3, map});
        }
    }
}
