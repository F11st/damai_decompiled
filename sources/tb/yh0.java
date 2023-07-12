package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class yh0 {
    @NotNull
    public static final yh0 INSTANCE = new yh0();

    private yh0() {
    }

    @NotNull
    public final JSONObject a(@Nullable String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            b41.h(parseObject, "{\n            JSON.parseObject(text)\n        }");
            return parseObject;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public final <T> T b(@Nullable String str, @Nullable TypeReference<T> typeReference) {
        return (T) JSON.parseObject(str, typeReference, new Feature[0]);
    }

    public final <T> T c(@Nullable String str, @Nullable Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    @NotNull
    public final <T> String d(T t) {
        String jSONString = JSON.toJSONString(t);
        b41.h(jSONString, "toJSONString(`object`)");
        return jSONString;
    }

    @NotNull
    public final String e(@Nullable Object obj) {
        String jSONString;
        if (obj != null) {
            try {
                jSONString = JSON.toJSONString(obj);
            } catch (Exception unused) {
                return "";
            }
        } else {
            jSONString = null;
        }
        return jSONString == null ? "" : jSONString;
    }

    @Nullable
    public final <T> T f(@Nullable JSON json, @Nullable Class<T> cls) {
        if (json != null) {
            try {
                return (T) INSTANCE.c(json.toJSONString(), cls);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
