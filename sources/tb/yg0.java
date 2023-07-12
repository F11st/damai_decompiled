package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yg0 {
    public static Object a(JSONObject jSONObject, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return wg0.d(jSONObject, (String) obj);
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) obj;
            for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                entry.setValue(a(jSONObject, entry.getValue()));
            }
            return jSONObject2;
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object a = a(jSONObject, it.next());
                if (a != null) {
                    arrayList.add(a);
                }
            }
            jSONArray.clear();
            jSONArray.addAll(arrayList);
            return jSONArray;
        } else {
            return null;
        }
    }
}
