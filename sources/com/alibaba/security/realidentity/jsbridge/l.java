package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "startVerifyByNative")
/* loaded from: classes8.dex */
public class l extends a {
    private static final String as = "NativeVerifyJSApi";

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return "startVerifyByNative";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        com.alibaba.security.common.c.a.a(as, "NativeVerifyApi execute params: ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(a.d);
            jSONObject.optString(a.E, "");
            RPVerify.startByNative(this.ao, string, new RPEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.l.1
                @Override // com.alibaba.security.realidentity.RPEventListener
                public final void onFinish(RPResult rPResult, String str2, String str3) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(a.F, rPResult.code);
                    } catch (JSONException unused) {
                        com.alibaba.security.common.c.a.b();
                    }
                    WVResult wVResult = new WVResult();
                    wVResult.setData(jSONObject2);
                    hVar.b(wVResult);
                    l.this.a(wVResult, true);
                }
            });
            return true;
        } catch (JSONException e) {
            com.alibaba.security.common.c.a.c(as, "NativeVerifyApi parse params error");
            a.a("NativeVerifyApi parse params error", e);
            a.a(hVar);
            return false;
        }
    }
}
