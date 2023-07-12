package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "startVerifyByNative")
/* renamed from: com.alibaba.security.realidentity.jsbridge.l */
/* loaded from: classes8.dex */
public class C3911l extends AbstractC3893a {
    private static final String as = "NativeVerifyJSApi";

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return "startVerifyByNative";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, final AbstractC3907h abstractC3907h) {
        C3800a.a(as, "NativeVerifyApi execute params: ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(AbstractC3893a.d);
            jSONObject.optString(AbstractC3893a.E, "");
            RPVerify.startByNative(this.ao, string, new RPEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.l.1
                @Override // com.alibaba.security.realidentity.RPEventListener
                public final void onFinish(RPResult rPResult, String str2, String str3) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(AbstractC3893a.F, rPResult.code);
                    } catch (JSONException unused) {
                        C3800a.b();
                    }
                    WVResult wVResult = new WVResult();
                    wVResult.setData(jSONObject2);
                    abstractC3907h.b(wVResult);
                    C3911l.this.a(wVResult, true);
                }
            });
            return true;
        } catch (JSONException e) {
            C3800a.c(as, "NativeVerifyApi parse params error");
            AbstractC3893a.a("NativeVerifyApi parse params error", e);
            AbstractC3893a.a(abstractC3907h);
            return false;
        }
    }
}
