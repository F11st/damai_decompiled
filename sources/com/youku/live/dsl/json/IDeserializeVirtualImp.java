package com.youku.live.dsl.json;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDeserializeVirtualImp implements IDeserialize {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.json.IDeserialize
    public <T> T deserialize(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1848469176")) {
            return (T) ipChange.ipc$dispatch("1848469176", new Object[]{this, str, cls});
        }
        return null;
    }
}
