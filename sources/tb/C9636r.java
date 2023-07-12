package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* renamed from: tb.r */
/* loaded from: classes8.dex */
public class C9636r {
    public static final String KEY_PARAMS = "params";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    private final JSONObject a;
    private final JSONObject b;

    public C9636r(@NonNull JSONObject jSONObject) {
        this.b = jSONObject;
        this.a = jSONObject.getJSONObject("params");
    }

    public String a() {
        return this.b.getString("type");
    }

    public JSONObject b() {
        return this.b;
    }

    public JSONObject c() {
        return this.a;
    }
}
