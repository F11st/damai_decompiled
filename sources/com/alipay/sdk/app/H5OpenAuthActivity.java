package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.s.C4293a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class H5OpenAuthActivity extends H5PayActivity {
    public boolean i = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.i) {
            try {
                C4293a a = C4293a.C4294a.a(getIntent());
                if (a != null) {
                    C4218a.b(this, a, "", a.d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            C4293a a = C4293a.C4294a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (Throwable th) {
                String uri = (intent == null || intent.getData() == null) ? "null" : intent.getData().toString();
                if (a != null) {
                    C4218a.a(a, C4226b.l, C4226b.p0, th, uri);
                }
                this.i = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
