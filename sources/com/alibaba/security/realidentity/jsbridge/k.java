package com.alibaba.security.realidentity.jsbridge;

import android.app.Activity;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "startByCtid")
/* loaded from: classes8.dex */
public class k extends a {
    private static final String as = "NativeCtidVerifyApi";

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return "startByCtid";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        com.alibaba.security.common.c.a.a(as, "NativeCtidVerifyApi execute params: ".concat(String.valueOf(str)));
        try {
            try {
                RPVerify.startByCtidWithVerifyToken((Activity) this.ao, new JSONObject(str).getString(a.d), null, new RPEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.k.1
                    @Override // com.alibaba.security.realidentity.RPEventListener
                    public final void onFinish(RPResult rPResult, String str2, String str3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(a.F, rPResult.code);
                        } catch (JSONException unused) {
                            com.alibaba.security.common.c.a.b();
                        }
                        WVResult wVResult = new WVResult();
                        wVResult.setData(jSONObject);
                        hVar.b(wVResult);
                        k.this.a(wVResult, true);
                    }
                });
                return true;
            } catch (Exception e) {
                com.alibaba.security.common.c.a.c(as, "Context cannot cast to Activity ");
                a.a("Context cannot cast to Activity ", e);
                a.a(hVar);
                return true;
            }
        } catch (JSONException e2) {
            com.alibaba.security.common.c.a.c(as, "NativeCtidVerifyApi parse params error");
            a.a("NativeCtidVerifyApi parse params error", e2);
            a.a(hVar);
            return false;
        }
    }
}
