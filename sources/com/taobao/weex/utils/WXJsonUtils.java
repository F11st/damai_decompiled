package com.taobao.weex.utils;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.common.WXRuntimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXJsonUtils {
    @NonNull
    public static String fromObjectToJSONString(Object obj, boolean z) {
        try {
            return z ? JSON.toJSONString(obj, SerializerFeature.WriteNonStringKeyAsString) : JSON.toJSONString(obj);
        } catch (Exception e) {
            if (!WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("fromObjectToJSONString error:", e);
                return "{}";
            }
            throw new WXRuntimeException("fromObjectToJSONString parse error!");
        }
    }

    @NonNull
    public static <T> List<T> getList(String str, Class<T> cls) {
        try {
            return JSON.parseArray(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public static void putAll(Map<String, Object> map, JSONObject jSONObject) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                map.put(key, value);
            }
        }
    }

    @NonNull
    public static String fromObjectToJSONString(Object obj) {
        return fromObjectToJSONString(obj, false);
    }
}
