package com.youku.live.dsl.json;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDeserializeImp implements IDeserialize {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.json.IDeserialize
    public <T> T deserialize(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371490019")) {
            return (T) ipChange.ipc$dispatch("-371490019", new Object[]{this, str, cls});
        }
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
