package com.alibaba.security.realidentity.jsbridge.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.AbstractC3907h;
import com.alibaba.security.realidentity.jsbridge.InterfaceC3904f;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "option")
/* renamed from: com.alibaba.security.realidentity.jsbridge.a.c */
/* loaded from: classes8.dex */
public class C3897c extends AbstractC3893a {
    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final String a() {
        return "option";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, AbstractC3907h abstractC3907h) {
        C3847g.C3848a.a.l = System.currentTimeMillis();
        try {
            String optString = new JSONObject(str).optString(AbstractC3893a.d);
            if (!TextUtils.isEmpty(optString)) {
                C3847g.C3848a.a.d = optString;
            }
        } catch (Exception e) {
            AbstractC3893a.a("option api get token fail", e);
        }
        C3847g.C3848a.a.c();
        WVResult wVResult = new WVResult();
        String str2 = VersionKey.RP_SDK_VERSION;
        if (!TextUtils.isEmpty(AbstractC3840a.I) && !TextUtils.isEmpty(str2)) {
            wVResult.addData(AbstractC3893a.t, AbstractC3840a.I);
            wVResult.addData(AbstractC3893a.u, str2);
            wVResult.addData(AbstractC3893a.v, AbstractC3840a.J);
            wVResult.addData(AbstractC3893a.w, VersionKey.FL_SDK_VERSION);
            Context context = this.ao;
            if (context != null && (context instanceof RPWebViewActivity)) {
                wVResult.addData(AbstractC3893a.x, "false");
            } else {
                wVResult.addData(AbstractC3893a.x, "true");
            }
            wVResult.setSuccess();
            abstractC3907h.b(wVResult);
            a(wVResult, true);
        } else {
            a(AbstractC3893a.a(abstractC3907h, "NO_INFO"), false);
        }
        return true;
    }
}
