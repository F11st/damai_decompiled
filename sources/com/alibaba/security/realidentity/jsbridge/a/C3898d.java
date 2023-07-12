package com.alibaba.security.realidentity.jsbridge.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.AbstractC3907h;
import com.alibaba.security.realidentity.jsbridge.InterfaceC3904f;
import com.alibaba.security.realidentity.view.RPTopBar;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "setTitle,rpSetTitle")
/* renamed from: com.alibaba.security.realidentity.jsbridge.a.d */
/* loaded from: classes8.dex */
public class C3898d extends AbstractC3893a {
    private static boolean d() {
        return true;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final String a() {
        return "setTitle";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean c() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, AbstractC3907h abstractC3907h) {
        try {
            final String string = new JSONObject(str).getString(AbstractC3893a.e);
            Context context = this.ao;
            if (context != null && (context instanceof RPWebViewActivity)) {
                ((RPWebViewActivity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.security.realidentity.jsbridge.a.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((RPTopBar) ((RPWebViewActivity) C3898d.this.ao).findViewById(R.id.topBar)).setTitle(string);
                    }
                });
                abstractC3907h.b();
                a(new WVResult("success"), true);
                return true;
            }
            AbstractC3893a.b("SetTitleApi context is not RPWebViewActivity: " + this.ao);
            a(AbstractC3893a.a(abstractC3907h, "context is not RPWebViewActivity"), false);
            return false;
        } catch (JSONException e) {
            AbstractC3893a.a("SetTitleApi json parse error", C3805b.a(e));
            AbstractC3893a.a(abstractC3907h);
            return false;
        }
    }
}
