package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.common.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class sq0 {
    @NotNull
    public static final sq0 INSTANCE = new sq0();

    private sq0() {
    }

    private final rq0 b(String str, Object obj) {
        LinkedHashMap linkedHashMap;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("value");
            String string2 = jSONObject.getString(Constants.Name.PLACEHOLDER);
            String string3 = jSONObject.getString("accessibilityDesc");
            String string4 = jSONObject.getString("accessibilityEnable");
            String string5 = jSONObject.getString("accessibilityTraits");
            JSONObject jSONObject2 = jSONObject.getJSONObject("extend");
            xq0 xq0Var = xq0.INSTANCE;
            GXIExpression a = xq0Var.a(str, string);
            GXIExpression a2 = xq0Var.a(str, string2);
            GXIExpression a3 = xq0Var.a(str, string3);
            GXIExpression a4 = xq0Var.a(str, string4);
            GXIExpression a5 = xq0Var.a(str, string5);
            if (jSONObject2 == null || !(!jSONObject2.isEmpty())) {
                linkedHashMap = null;
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        xq0 xq0Var2 = xq0.INSTANCE;
                        String key = entry.getKey();
                        b41.h(key, "entry.key");
                        GXIExpression b = xq0Var2.b(str, key, entry.getValue());
                        if (b != null) {
                            String key2 = entry.getKey();
                            b41.h(key2, "entry.key");
                            linkedHashMap2.put(key2, b);
                        }
                    }
                }
                linkedHashMap = linkedHashMap2;
            }
            if (a == null && a2 == null && a3 == null && a4 == null && linkedHashMap == null) {
                return null;
            }
            return new rq0(a, a3, a4, a5, a2, linkedHashMap);
        }
        return null;
    }

    @Nullable
    public final rq0 a(@Nullable String str, @NotNull Object obj) {
        rq0 create;
        b41.i(obj, "data");
        GXRegisterCenter.GXIExtensionDataBinding g = GXRegisterCenter.Companion.a().g();
        return (g == null || (create = g.create(str, obj)) == null) ? b(str, obj) : create;
    }
}
