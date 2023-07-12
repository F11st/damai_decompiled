package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.j.C4214d;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.u.C4318n;
import com.alipay.sdk.m.x.AbstractC4344c;
import com.alipay.sdk.m.x.C4345d;
import com.youku.network.HttpIntent;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class H5PayActivity extends Activity {
    public AbstractC4344c a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public WeakReference<C4293a> h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            C4302e.a(th);
        }
    }

    public void a() {
        Object obj = PayTask.h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            C4214d.a((C4293a) C4318n.a(this.h), i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AbstractC4344c abstractC4344c = this.a;
        if (abstractC4344c == null) {
            finish();
        } else if (abstractC4344c.a()) {
            abstractC4344c.b();
        } else {
            if (!abstractC4344c.b()) {
                super.onBackPressed();
            }
            C4212b.a(C4212b.a());
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            C4293a a = C4293a.C4294a.a(getIntent());
            if (a == null) {
                finish();
                return;
            }
            this.h = new WeakReference<>(a);
            if (!C4245a.D().y()) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(3);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.b = string;
                if (!C4318n.f(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString(HttpIntent.COOKIE, null);
                this.c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", AbstractC4344c.c);
                this.f = extras.getBoolean("backisexit", false);
                try {
                    C4345d c4345d = new C4345d(this, a, this.g);
                    setContentView(c4345d);
                    c4345d.a(this.e, this.c, this.f);
                    c4345d.a(this.b, this.d);
                    c4345d.a(this.b);
                    this.a = c4345d;
                } catch (Throwable th) {
                    C4218a.a(a, C4226b.l, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC4344c abstractC4344c = this.a;
        if (abstractC4344c != null) {
            abstractC4344c.c();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            try {
                C4218a.a((C4293a) C4318n.a(this.h), C4226b.l, C4226b.B, th);
            } catch (Throwable unused) {
            }
        }
    }
}
