package com.youku.middlewareservice_impl.provider.json;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.youku.middlewareservice.provider.json.JsonProvider;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class JsonProviderImpl implements JsonProvider {
    @Override // com.youku.middlewareservice.provider.json.JsonProvider
    public <T> T fromJson(String str, Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    @Override // com.youku.middlewareservice.provider.json.JsonProvider
    public <T> T parseObject(String str, Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    @Override // com.youku.middlewareservice.provider.json.JsonProvider
    public String toJSONString(Object obj) {
        return JSON.toJSONString(obj);
    }

    @Override // com.youku.middlewareservice.provider.json.JsonProvider
    public String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }
}
