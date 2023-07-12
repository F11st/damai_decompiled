package com.youku.live.dsl.alarm;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IYoukuLiveAlarmVirtualImp implements IYoukuLiveAlarm {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.alarm.IYoukuLiveAlarm
    public void commitFail(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637082757")) {
            ipChange.ipc$dispatch("1637082757", new Object[]{this, str, str2, str3});
        }
    }

    @Override // com.youku.live.dsl.alarm.IYoukuLiveAlarm
    public void commitFail(String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551727200")) {
            ipChange.ipc$dispatch("1551727200", new Object[]{this, str, str2, str3, map});
        }
    }

    @Override // com.youku.live.dsl.alarm.IYoukuLiveAlarm
    public void commitSuccess(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562732458")) {
            ipChange.ipc$dispatch("-562732458", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.alarm.IYoukuLiveAlarm
    public void commitSuccess(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624456593")) {
            ipChange.ipc$dispatch("-1624456593", new Object[]{this, str, str2, map});
        }
    }
}
