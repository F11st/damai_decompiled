package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kd0 {
    public JSONArray a;
    public String b;
    public String c;
    public String d;
    public String e;

    public kd0() {
    }

    public String toString() {
        if (("DynamicTemplate [type=" + this.a) != null) {
            return this.a.toJSONString();
        }
        return "null, containerType=" + this.b + ", name=" + this.c + ", url=" + this.d + ", version=" + this.e + jn1.ARRAY_END_STR;
    }

    public kd0(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.getJSONArray("type");
            this.b = jSONObject.getString("containerType");
            this.c = jSONObject.getString("name");
            this.d = jSONObject.getString("url");
            this.e = jSONObject.getString("version");
            jSONObject.getString("md5");
        }
    }
}
