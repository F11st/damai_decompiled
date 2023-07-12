package tb;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k00 extends hy {
    protected Object d;

    public k00(long j, int i, Object obj, long j2) {
        super(j);
        this.d = obj;
        HashMap hashMap = new HashMap();
        hashMap.put("index", az.J(i));
        if (obj instanceof JSONObject) {
            hashMap.put("data", az.M((JSONObject) obj));
        } else if (obj instanceof Object) {
            hashMap.put("data", az.K(obj));
        }
        hashMap.put("duration", az.J(j2));
        d(hashMap);
    }
}
