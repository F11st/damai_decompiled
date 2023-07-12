package com.alibaba.security.realidentity.jsbridge.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "option")
/* loaded from: classes8.dex */
public class c extends com.alibaba.security.realidentity.jsbridge.a {
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "option";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        g.a.a.l = System.currentTimeMillis();
        try {
            String optString = new JSONObject(str).optString(com.alibaba.security.realidentity.jsbridge.a.d);
            if (!TextUtils.isEmpty(optString)) {
                g.a.a.d = optString;
            }
        } catch (Exception e) {
            com.alibaba.security.realidentity.jsbridge.a.a("option api get token fail", e);
        }
        g.a.a.c();
        WVResult wVResult = new WVResult();
        String str2 = VersionKey.RP_SDK_VERSION;
        if (!TextUtils.isEmpty(com.alibaba.security.realidentity.a.a.I) && !TextUtils.isEmpty(str2)) {
            wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.t, com.alibaba.security.realidentity.a.a.I);
            wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.u, str2);
            wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.v, com.alibaba.security.realidentity.a.a.J);
            wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.w, VersionKey.FL_SDK_VERSION);
            Context context = this.ao;
            if (context != null && (context instanceof RPWebViewActivity)) {
                wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.x, "false");
            } else {
                wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.x, "true");
            }
            wVResult.setSuccess();
            hVar.b(wVResult);
            a(wVResult, true);
        } else {
            a(com.alibaba.security.realidentity.jsbridge.a.a(hVar, "NO_INFO"), false);
        }
        return true;
    }
}
