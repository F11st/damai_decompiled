package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class APayEntranceActivity extends Activity {
    public static final String d = "ap_order_info";
    public static final String e = "ap_target_packagename";
    public static final String f = "ap_session";
    public static final String g = "ap_local_info";
    public static final ConcurrentHashMap<String, a> h = new ConcurrentHashMap<>();
    public String a;
    public String b;
    public com.alipay.sdk.m.s.a c;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        String str = this.b;
        com.alipay.sdk.m.s.a aVar = this.c;
        com.alipay.sdk.m.k.a.a(aVar, b.l, "BSAFinish", str + "|" + TextUtils.isEmpty(this.a));
        if (TextUtils.isEmpty(this.a)) {
            this.a = com.alipay.sdk.m.j.b.a();
            com.alipay.sdk.m.s.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b(true);
            }
        }
        if (str != null) {
            a remove = h.remove(str);
            if (remove != null) {
                remove.a(this.a);
            } else {
                com.alipay.sdk.m.s.a aVar3 = this.c;
                com.alipay.sdk.m.k.a.b(aVar3, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.c, "wr", "APStartFinish", th);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.alipay.sdk.m.s.a aVar = this.c;
        com.alipay.sdk.m.k.a.a(aVar, b.l, "BSAOnAR", this.b + "|" + i + "," + i2);
        if (i == 1000) {
            if (intent != null) {
                try {
                    this.a = intent.getStringExtra("result");
                } catch (Throwable unused) {
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString(d);
            String string2 = extras.getString(e);
            this.b = extras.getString(f);
            String string3 = extras.getString(g, "{}");
            if (!TextUtils.isEmpty(this.b)) {
                com.alipay.sdk.m.s.a a2 = a.C0200a.a(this.b);
                this.c = a2;
                com.alipay.sdk.m.k.a.a(a2, b.l, "BSAEntryCreate", this.b + "|" + SystemClock.elapsedRealtime());
            }
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.c, "wr", "APStartEx", th);
                finish();
            }
            if (this.c != null) {
                Context applicationContext = getApplicationContext();
                com.alipay.sdk.m.s.a aVar = this.c;
                com.alipay.sdk.m.k.a.a(applicationContext, aVar, string, aVar.d);
                this.c.a(true);
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
