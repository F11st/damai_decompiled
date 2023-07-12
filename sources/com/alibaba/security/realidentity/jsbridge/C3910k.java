package com.alibaba.security.realidentity.jsbridge;

import android.app.Activity;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "startByCtid")
/* renamed from: com.alibaba.security.realidentity.jsbridge.k */
/* loaded from: classes8.dex */
public class C3910k extends AbstractC3893a {
    private static final String as = "NativeCtidVerifyApi";

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return "startByCtid";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, final AbstractC3907h abstractC3907h) {
        C3800a.a(as, "NativeCtidVerifyApi execute params: ".concat(String.valueOf(str)));
        try {
            try {
                RPVerify.startByCtidWithVerifyToken((Activity) this.ao, new JSONObject(str).getString(AbstractC3893a.d), null, new RPEventListener() { // from class: com.alibaba.security.realidentity.jsbridge.k.1
                    @Override // com.alibaba.security.realidentity.RPEventListener
                    public final void onFinish(RPResult rPResult, String str2, String str3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(AbstractC3893a.F, rPResult.code);
                        } catch (JSONException unused) {
                            C3800a.b();
                        }
                        WVResult wVResult = new WVResult();
                        wVResult.setData(jSONObject);
                        abstractC3907h.b(wVResult);
                        C3910k.this.a(wVResult, true);
                    }
                });
                return true;
            } catch (Exception e) {
                C3800a.c(as, "Context cannot cast to Activity ");
                AbstractC3893a.a("Context cannot cast to Activity ", e);
                AbstractC3893a.a(abstractC3907h);
                return true;
            }
        } catch (JSONException e2) {
            C3800a.c(as, "NativeCtidVerifyApi parse params error");
            AbstractC3893a.a("NativeCtidVerifyApi parse params error", e2);
            AbstractC3893a.a(abstractC3907h);
            return false;
        }
    }
}
