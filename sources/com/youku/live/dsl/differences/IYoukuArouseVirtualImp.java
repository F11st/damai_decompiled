package com.youku.live.dsl.differences;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IYoukuArouseVirtualImp implements IYoukuArouse {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.differences.IYoukuArouse
    public void sendDrawFinish(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944278036")) {
            ipChange.ipc$dispatch("1944278036", new Object[]{this, activity});
        }
    }

    @Override // com.youku.live.dsl.differences.IYoukuArouse
    public void sendPageError(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401435082")) {
            ipChange.ipc$dispatch("1401435082", new Object[]{this, activity});
        }
    }

    @Override // com.youku.live.dsl.differences.IYoukuArouse
    public void sendReadyToDraw(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533658049")) {
            ipChange.ipc$dispatch("1533658049", new Object[]{this, activity});
        }
    }
}
