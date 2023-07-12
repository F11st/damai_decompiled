package com.youku.live.dsl.weex;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IWeexManangerImp implements IWeexMananger {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.weex.IWeexMananger
    public void tryInitAndRegister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88412872")) {
            ipChange.ipc$dispatch("88412872", new Object[]{this});
        }
    }
}
