package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.bb1;
import tb.xg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class o {
    private static Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return n((JSONObject) obj);
        }
        return obj instanceof JSONArray ? m((JSONArray) obj) : obj;
    }

    public static boolean b(Map<String, Object> map, String str, boolean z) {
        Object obj;
        if (map == null || TextUtils.isEmpty(str) || (obj = map.get(str)) == null) {
            return z;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            try {
                return Boolean.parseBoolean((String) obj);
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    @Nullable
    public static Map<String, xg0> c(@NonNull Map<String, Object> map) {
        xg0 xg0Var;
        Object obj = map.get("interceptors");
        if (obj == null || !(obj instanceof Map)) {
            return null;
        }
        HashMap hashMap = new HashMap(8);
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                try {
                    xg0Var = e((Map) value, DXTraceUtil.TYPE_EXPRESSION_STRING);
                } catch (Exception unused) {
                    xg0Var = null;
                }
                if (xg0Var != null) {
                    hashMap.put((String) key, xg0Var);
                }
            }
        }
        return hashMap;
    }

    public static double d(Map<String, Object> map, String str, double d) {
        Object obj;
        if (map == null || TextUtils.isEmpty(str) || (obj = map.get(str)) == null) {
            return d;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (Throwable unused) {
                return d;
            }
        }
        try {
            return Double.valueOf(obj.toString()).doubleValue();
        } catch (Throwable unused2) {
            return d;
        }
    }

    @Nullable
    public static xg0 e(@NonNull Map<String, Object> map, @NonNull String str) {
        JSONObject jSONObject;
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return xg0.a(null, (String) obj);
        }
        if (obj instanceof Map) {
            try {
                jSONObject = new JSONObject((Map) obj);
            } catch (Throwable th) {
                bb1.c("unexpected json parse error.", th);
                jSONObject = null;
            }
            if (jSONObject == null) {
                return xg0.a(null, null);
            }
            String optString = jSONObject.optString("origin", null);
            Object opt = jSONObject.opt("transformed");
            if (opt == null) {
                return xg0.a(null, null);
            }
            if (opt instanceof JSONObject) {
                return xg0.b(optString, (JSONObject) opt);
            }
            if (opt instanceof String) {
                return xg0.a(optString, (String) opt);
            }
            return xg0.a(optString, String.valueOf(obj));
        }
        return null;
    }

    public static Map<String, Object> f(Map<String, Object> map, String str) {
        if (map != null && !TextUtils.isEmpty(str)) {
            Object obj = map.get(str);
            if (obj == null) {
                return Collections.emptyMap();
            }
            if (obj instanceof Map) {
                return (Map) obj;
            }
            return Collections.emptyMap();
        }
        return Collections.emptyMap();
    }

    @Nullable
    public static List<Map<String, Object>> g(@NonNull Map<String, Object> map) {
        Object obj = map.get("props");
        if (obj == null) {
            return null;
        }
        try {
            return (List) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static String h(@NonNull Map<String, Object> map, @NonNull String str) {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    @SafeVarargs
    public static <E> ArrayList<E> i(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>(eArr.length);
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @SafeVarargs
    public static <E> HashSet<E> j(E... eArr) {
        HashSet<E> hashSet = new HashSet<>(eArr.length);
        Collections.addAll(hashSet, eArr);
        return hashSet;
    }

    public static int k(@NonNull Context context, int i) {
        return (int) (context.getApplicationContext().getResources().getDisplayMetrics().density * i * 5.0f);
    }

    @Nullable
    public static Pair<Float, Float> l(@Nullable String str, @NonNull View view) {
        int indexOf;
        int width;
        float f;
        int height;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(32)) != -1) {
            int i = indexOf;
            while (i < str.length() && str.charAt(i) == ' ') {
                i++;
            }
            if (i < str.length() && str.charAt(i) != ' ') {
                String trim = str.substring(0, indexOf).trim();
                String trim2 = str.substring(i, str.length()).trim();
                float f2 = 0.0f;
                if ("left".equals(trim)) {
                    f = 0.0f;
                } else {
                    if ("right".equals(trim)) {
                        width = view.getWidth();
                    } else if ("center".equals(trim)) {
                        width = view.getWidth() / 2;
                    } else {
                        width = view.getWidth() / 2;
                    }
                    f = width;
                }
                if (!"top".equals(trim2)) {
                    if ("bottom".equals(trim2)) {
                        height = view.getHeight();
                    } else if ("center".equals(trim2)) {
                        height = view.getHeight() / 2;
                    } else {
                        height = view.getHeight() / 2;
                    }
                    f2 = height;
                }
                return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
            }
        }
        return null;
    }

    public static List m(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static Map<String, Object> n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next)));
        }
        return hashMap;
    }
}
