package tb;

import com.alibaba.appmonitor.pool.C3316a;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class f4 extends qf0 {
    public int g = 0;
    public int h = 0;
    public Map<String, String> i;
    public Map<String, Integer> j;

    @Override // tb.qf0
    public synchronized JSONObject b() {
        JSONObject b;
        b = super.b();
        b.put(h23.POINT_SUCCESS_COUNT_MEASURE, (Object) Integer.valueOf(this.g));
        b.put(h23.POINT_FAIL_COUNT_MEASURE, (Object) Integer.valueOf(this.h));
        if (this.j != null) {
            JSONArray jSONArray = (JSONArray) C3316a.a().poll(ReuseJSONArray.class, new Object[0]);
            for (Map.Entry<String, Integer> entry : this.j.entrySet()) {
                JSONObject jSONObject = (JSONObject) C3316a.a().poll(ReuseJSONObject.class, new Object[0]);
                String key = entry.getKey();
                jSONObject.put("errorCode", (Object) key);
                jSONObject.put("errorCount", (Object) entry.getValue());
                if (this.i.containsKey(key)) {
                    jSONObject.put("errorMsg", (Object) this.i.get(key));
                }
                jSONArray.add(jSONObject);
            }
            b.put("errors", (Object) jSONArray);
        }
        return b;
    }

    public synchronized void c(String str, String str2) {
        if (yh2.e(str)) {
            return;
        }
        if (this.i == null) {
            this.i = new HashMap();
        }
        if (this.j == null) {
            this.j = new HashMap();
        }
        if (yh2.g(str2)) {
            int i = 100;
            if (str2.length() <= 100) {
                i = str2.length();
            }
            this.i.put(str, str2.substring(0, i));
        }
        if (!this.j.containsKey(str)) {
            this.j.put(str, 1);
        } else {
            Map<String, Integer> map = this.j;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        }
    }

    @Override // tb.qf0, com.alibaba.appmonitor.pool.Reusable
    public synchronized void clean() {
        super.clean();
        this.g = 0;
        this.h = 0;
        Map<String, String> map = this.i;
        if (map != null) {
            map.clear();
        }
        Map<String, Integer> map2 = this.j;
        if (map2 != null) {
            map2.clear();
        }
    }

    public synchronized void d(Long l) {
        this.h++;
        super.a(l);
    }

    public synchronized void e(Long l) {
        this.g++;
        super.a(l);
    }
}
