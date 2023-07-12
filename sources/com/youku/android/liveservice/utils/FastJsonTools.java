package com.youku.android.liveservice.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FastJsonTools {
    public static <T> T deserialize(String str, Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    public static <T> T deserializeAny(String str, TypeReference<T> typeReference) {
        return (T) JSON.parseObject(str, typeReference, new Feature[0]);
    }

    public static <T> List<T> deserializeList(String str, Class<T> cls) {
        return JSON.parseArray(str, cls);
    }

    public static <T> String serialize(T t) {
        return JSON.toJSONString(t);
    }
}
