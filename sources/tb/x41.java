package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x41 {
    public static <T> T a(int i, JSONArray jSONArray, T t) {
        if (jSONArray != null && i >= 0 && i < jSONArray.size()) {
            try {
                T t2 = (T) jSONArray.get(i);
                return t2 == null ? t : t2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T b(String str, JSONObject jSONObject, T t) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                T t2 = (T) jSONObject.get(str);
                return t2 == null ? t : t2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return t;
    }

    public static Boolean c(String str, JSONObject jSONObject, Boolean bool) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                Boolean bool2 = jSONObject.getBoolean(str);
                return bool2 == null ? bool : bool2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bool;
    }

    public static int d(String str, JSONObject jSONObject, int i) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                Integer integer = jSONObject.getInteger(str);
                return integer == null ? i : integer.intValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i;
    }

    public static JSONArray e(String str, JSONObject jSONObject, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray(str);
                return jSONArray2 == null ? jSONArray : jSONArray2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static <T> JSONObject f(T t, boolean z, Class<? super T> cls) {
        if (t == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        g(jSONObject, t.getClass(), t, z, cls);
        return jSONObject;
    }

    public static <T> void g(@NonNull JSONObject jSONObject, Class<?> cls, @NonNull T t, boolean z, Class<? super T> cls2) {
        Field[] declaredFields;
        if (cls == null || cls == Object.class) {
            return;
        }
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!z || !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    if (!jSONObject.containsKey(field.getName())) {
                        jSONObject.put(field.getName(), field.get(t));
                    }
                }
            }
            if (cls2 == null || cls == cls2) {
                return;
            }
            g(jSONObject, cls.getSuperclass(), t, z, cls2);
        } catch (Exception e) {
            ry.b(e);
        }
    }
}
