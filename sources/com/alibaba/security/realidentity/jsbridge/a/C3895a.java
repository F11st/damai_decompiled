package com.alibaba.security.realidentity.jsbridge.a;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.realidentity.a.AbstractC3841b;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.AbstractC3907h;
import com.alibaba.security.realidentity.jsbridge.InterfaceC3904f;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "rpTrace")
/* renamed from: com.alibaba.security.realidentity.jsbridge.a.a */
/* loaded from: classes8.dex */
public class C3895a extends AbstractC3893a {
    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final String a() {
        return "rpTrace";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, AbstractC3907h abstractC3907h) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("pageName");
            String string2 = jSONObject.getString("eventId");
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
            AbstractC3841b.a().a(string, string2, hashMap);
            abstractC3907h.b();
            a(new WVResult("success"), true);
            return true;
        } catch (JSONException e) {
            AbstractC3893a.a(abstractC3907h);
            AbstractC3893a.a("EasyTrackApi parse json error", e);
            return false;
        }
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean c() {
        return false;
    }
}
