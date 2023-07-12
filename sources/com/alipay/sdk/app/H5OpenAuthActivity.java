package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;

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
                a a = a.C0200a.a(getIntent());
                if (a != null) {
                    com.alipay.sdk.m.k.a.b(this, a, "", a.d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            a a = a.C0200a.a(intent);
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
                    com.alipay.sdk.m.k.a.a(a, b.l, b.p0, th, uri);
                }
                this.i = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
