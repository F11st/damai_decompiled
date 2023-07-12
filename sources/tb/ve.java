package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ve {
    Map<String, JSONObject> a;
    Map<String, DMComponent> b;
    List<kd0> c;

    public Map<String, DMComponent> a() {
        return this.b;
    }

    public Map<String, JSONObject> b() {
        return this.a;
    }

    public List<kd0> c() {
        return this.c;
    }

    public void d(Map<String, DMComponent> map) {
        this.b = map;
    }

    public void e(Map<String, JSONObject> map) {
        this.a = map;
    }

    public void f(List<kd0> list) {
        this.c = list;
    }
}
