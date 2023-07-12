package com.youku.live.dsl.json;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ISerializeImp implements ISerialize {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.json.ISerialize
    public <T> String serialize(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495442970")) {
            return (String) ipChange.ipc$dispatch("-495442970", new Object[]{this, t});
        }
        try {
            return JSON.toJSONString(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
