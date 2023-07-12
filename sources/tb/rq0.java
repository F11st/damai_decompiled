package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.common.Constants;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class rq0 {
    @Nullable
    private GXIExpression a;
    @Nullable
    private final GXIExpression b;
    @Nullable
    private final GXIExpression c;
    @Nullable
    private final GXIExpression d;
    @Nullable
    private final GXIExpression e;
    @Nullable
    private final Map<String, GXIExpression> f;

    public rq0() {
        this(null, null, null, null, null, null, 63, null);
    }

    public rq0(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @Nullable GXIExpression gXIExpression3, @Nullable GXIExpression gXIExpression4, @Nullable GXIExpression gXIExpression5, @Nullable Map<String, GXIExpression> map) {
        this.a = gXIExpression;
        this.b = gXIExpression2;
        this.c = gXIExpression3;
        this.d = gXIExpression4;
        this.e = gXIExpression5;
        this.f = map;
    }

    @Nullable
    public JSONObject a(@NotNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        b41.i(jSONObject, "templateData");
        GXIExpression gXIExpression = this.a;
        if (gXIExpression == null || (value5 = gXIExpression.value(jSONObject)) == null) {
            jSONObject2 = null;
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("value", value5);
            jSONObject2 = jSONObject3;
        }
        GXIExpression gXIExpression2 = this.e;
        if (gXIExpression2 != null && (value4 = gXIExpression2.value(jSONObject)) != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put(Constants.Name.PLACEHOLDER, value4);
        }
        GXIExpression gXIExpression3 = this.b;
        if (gXIExpression3 != null && (value3 = gXIExpression3.value(jSONObject)) != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("accessibilityDesc", value3);
        }
        GXIExpression gXIExpression4 = this.c;
        if (gXIExpression4 != null && (value2 = gXIExpression4.value(jSONObject)) != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("accessibilityEnable", value2);
        }
        GXIExpression gXIExpression5 = this.d;
        if (gXIExpression5 != null && (value = gXIExpression5.value(jSONObject)) != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("accessibilityTraits", value);
        }
        JSONObject b = b(jSONObject);
        if (b != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("extend", (Object) b);
        }
        return jSONObject2;
    }

    @Nullable
    public JSONObject b(@Nullable JSON json) {
        Map<String, GXIExpression> map = this.f;
        JSONObject jSONObject = null;
        if (map != null) {
            for (Map.Entry<String, GXIExpression> entry : map.entrySet()) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put((JSONObject) entry.getKey(), (String) entry.getValue().value(json));
            }
        }
        return jSONObject;
    }

    @Nullable
    public final GXIExpression c() {
        return this.a;
    }

    public /* synthetic */ rq0(GXIExpression gXIExpression, GXIExpression gXIExpression2, GXIExpression gXIExpression3, GXIExpression gXIExpression4, GXIExpression gXIExpression5, Map map, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : gXIExpression, (i & 2) != 0 ? null : gXIExpression2, (i & 4) != 0 ? null : gXIExpression3, (i & 8) != 0 ? null : gXIExpression4, (i & 16) != 0 ? null : gXIExpression5, (i & 32) != 0 ? null : map);
    }
}
