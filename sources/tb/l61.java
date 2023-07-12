package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class l61 {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(@NonNull Class<T> cls, @Nullable JSONObject jSONObject, @NonNull String str, @Nullable T t) {
        T t2;
        if (jSONObject == null || jSONObject.get(str) == null) {
            return t;
        }
        T t3 = null;
        try {
            if (cls == String.class) {
                t2 = jSONObject.getString(str);
            } else {
                t2 = jSONObject.getObject(str, cls);
            }
            t3 = t2;
        } catch (Exception unused) {
        }
        return t3 != null ? t3 : t;
    }

    public static boolean b(@Nullable JSONObject jSONObject, @NonNull String str, boolean z) {
        return ((Boolean) a(Boolean.class, jSONObject, str, Boolean.valueOf(z))).booleanValue();
    }

    public static String c(@Nullable JSONObject jSONObject, @NonNull String str, @Nullable String str2) {
        return (String) a(String.class, jSONObject, str, str2);
    }
}
