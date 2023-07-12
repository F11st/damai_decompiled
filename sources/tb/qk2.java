package tb;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qk2 extends hy {
    public qk2(long j, int i, int i2, JSONObject jSONObject, boolean z, boolean z2) {
        super(j);
        HashMap hashMap = new HashMap();
        hashMap.put("index", az.J(i));
        hashMap.put("fromIndex", az.J(i2));
        hashMap.put("data", az.M(jSONObject));
        hashMap.put("isFirstSelected", az.F(z));
        hashMap.put("isTapEvent", az.F(z2));
        d(hashMap);
    }
}
