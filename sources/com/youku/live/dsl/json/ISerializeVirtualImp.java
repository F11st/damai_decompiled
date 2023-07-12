package com.youku.live.dsl.json;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ISerializeVirtualImp implements ISerialize {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.json.ISerialize
    public <T> String serialize(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1017136819")) {
            return (String) ipChange.ipc$dispatch("-1017136819", new Object[]{this, t});
        }
        return null;
    }
}
