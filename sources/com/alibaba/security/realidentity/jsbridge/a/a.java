package com.alibaba.security.realidentity.jsbridge.a;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "rpTrace")
/* loaded from: classes8.dex */
public class a extends com.alibaba.security.realidentity.jsbridge.a {
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "rpTrace";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
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
            com.alibaba.security.realidentity.a.b.a().a(string, string2, hashMap);
            hVar.b();
            a(new WVResult("success"), true);
            return true;
        } catch (JSONException e) {
            com.alibaba.security.realidentity.jsbridge.a.a(hVar);
            com.alibaba.security.realidentity.jsbridge.a.a("EasyTrackApi parse json error", e);
            return false;
        }
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean c() {
        return false;
    }
}
