package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.s.C4293a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class APayEntranceActivity extends Activity {
    public static final String d = "ap_order_info";
    public static final String e = "ap_target_packagename";
    public static final String f = "ap_session";
    public static final String g = "ap_local_info";
    public static final ConcurrentHashMap<String, InterfaceC4121a> h = new ConcurrentHashMap<>();
    public String a;
    public String b;
    public C4293a c;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.APayEntranceActivity$a */
    /* loaded from: classes12.dex */
    public interface InterfaceC4121a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        String str = this.b;
        C4293a c4293a = this.c;
        C4218a.a(c4293a, C4226b.l, "BSAFinish", str + "|" + TextUtils.isEmpty(this.a));
        if (TextUtils.isEmpty(this.a)) {
            this.a = C4212b.a();
            C4293a c4293a2 = this.c;
            if (c4293a2 != null) {
                c4293a2.b(true);
            }
        }
        if (str != null) {
            InterfaceC4121a remove = h.remove(str);
            if (remove != null) {
                remove.a(this.a);
            } else {
                C4293a c4293a3 = this.c;
                C4218a.b(c4293a3, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (Throwable th) {
            C4218a.a(this.c, "wr", "APStartFinish", th);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C4293a c4293a = this.c;
        C4218a.a(c4293a, C4226b.l, "BSAOnAR", this.b + "|" + i + "," + i2);
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
                C4293a a = C4293a.C4294a.a(this.b);
                this.c = a;
                C4218a.a(a, C4226b.l, "BSAEntryCreate", this.b + "|" + SystemClock.elapsedRealtime());
            }
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable th) {
                C4218a.a(this.c, "wr", "APStartEx", th);
                finish();
            }
            if (this.c != null) {
                Context applicationContext = getApplicationContext();
                C4293a c4293a = this.c;
                C4218a.a(applicationContext, c4293a, string, c4293a.d);
                this.c.a(true);
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
