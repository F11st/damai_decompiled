package com.alibaba.security.realidentity.jsbridge.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;
import com.alibaba.security.realidentity.view.RPTopBar;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "setTitle,rpSetTitle")
/* loaded from: classes8.dex */
public class d extends com.alibaba.security.realidentity.jsbridge.a {
    private static boolean d() {
        return true;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "setTitle";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean c() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        try {
            final String string = new JSONObject(str).getString(com.alibaba.security.realidentity.jsbridge.a.e);
            Context context = this.ao;
            if (context != null && (context instanceof RPWebViewActivity)) {
                ((RPWebViewActivity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.a.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((RPTopBar) ((RPWebViewActivity) d.this.ao).findViewById(R.id.topBar)).setTitle(string);
                    }
                });
                hVar.b();
                a(new WVResult("success"), true);
                return true;
            }
            com.alibaba.security.realidentity.jsbridge.a.b("SetTitleApi context is not RPWebViewActivity: " + this.ao);
            a(com.alibaba.security.realidentity.jsbridge.a.a(hVar, "context is not RPWebViewActivity"), false);
            return false;
        } catch (JSONException e) {
            com.alibaba.security.realidentity.jsbridge.a.a("SetTitleApi json parse error", com.alibaba.security.common.d.b.a(e));
            com.alibaba.security.realidentity.jsbridge.a.a(hVar);
            return false;
        }
    }
}
