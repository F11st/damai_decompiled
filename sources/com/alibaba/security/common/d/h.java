package com.alibaba.security.common.d;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class h {
    private static final String a = "JsonUtils";

    private static <T> T a(String str, Type type) {
        return (T) JSON.parseObject(str, type, new Feature[0]);
    }

    private static <T> T b(String str, Class<T> cls) {
        return (T) a(str, cls, false);
    }

    public static <T> List<T> a(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return JSON.parseArray(str, cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, Object> b(String str) {
        return JSON.parseObject(str);
    }

    private static JSONObject b(Map map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static <T> T a(String str, Class<T> cls, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            try {
                return (T) JSON.parseObject(str, cls);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (T) JSON.parseObject(str, cls);
    }

    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return JSON.toJSONString(obj);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Map map) {
        JSONObject b = b(map);
        return b == null ? "" : b.toString();
    }

    public static boolean a(String str) {
        try {
            JSON.parseObject(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
