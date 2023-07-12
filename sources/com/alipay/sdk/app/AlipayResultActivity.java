package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4316l;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AlipayResultActivity extends Activity {
    public static final ConcurrentHashMap<String, InterfaceC4122a> a = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.AlipayResultActivity$a */
    /* loaded from: classes12.dex */
    public interface InterfaceC4122a {
        void a(int i, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        InterfaceC4122a remove = a.remove(str);
        if (remove == null) {
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(C4316l.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th;
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra(Preloader.KEY_SESSION);
            Bundle bundleExtra = intent.getBundleExtra("result");
            String stringExtra2 = intent.getStringExtra("scene");
            C4293a a2 = C4293a.C4294a.a(stringExtra);
            if (a2 == null) {
                finish();
                return;
            }
            C4218a.a(a2, C4226b.l, "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
            if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                a(stringExtra, bundleExtra);
                return;
            }
            if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                    jSONObject = jSONObject2.getJSONObject("result");
                    stringExtra = jSONObject2.getString(Preloader.KEY_SESSION);
                    C4218a.a(a2, C4226b.l, "BSPUriSession", stringExtra);
                    bundle2 = new Bundle();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle2.putString(next, jSONObject.getString(next));
                    }
                    bundleExtra = bundle2;
                } catch (Throwable th3) {
                    th = th3;
                    bundleExtra = bundle2;
                    C4218a.a(a2, C4226b.l, "BSPResEx", th);
                    C4218a.a(a2, C4226b.l, C4226b.s0, th);
                    if (TextUtils.isEmpty(stringExtra)) {
                    }
                    C4218a.b(this, a2, "", a2.d);
                    finish();
                }
            }
            if (TextUtils.isEmpty(stringExtra) && bundleExtra != null) {
                C4218a.a(a2, C4226b.l, C4226b.V, "" + SystemClock.elapsedRealtime());
                C4218a.a(a2, C4226b.l, C4226b.W, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(C4316l.b, "-"));
                OpenAuthTask.a(stringExtra, 9000, WXModalUIModule.OK, bundleExtra);
                C4218a.b(this, a2, "", a2.d);
                finish();
                return;
            }
            C4218a.b(this, a2, "", a2.d);
            finish();
        } catch (Throwable unused) {
            finish();
        }
    }
}
