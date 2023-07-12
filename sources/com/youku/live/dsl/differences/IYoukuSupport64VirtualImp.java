package com.youku.live.dsl.differences;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IYoukuSupport64VirtualImp implements IYoukuSupport64 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.differences.IYoukuSupport64
    public boolean isDevice32Install64Apk() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656055275")) {
            return ((Boolean) ipChange.ipc$dispatch("656055275", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.differences.IYoukuSupport64
    public void showGuideUpGradePanel(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705126092")) {
            ipChange.ipc$dispatch("1705126092", new Object[]{this, activity});
        }
    }
}
