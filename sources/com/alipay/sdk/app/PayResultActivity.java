package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4302e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class PayResultActivity extends Activity {
    public static final String b = "{\"isLogin\":\"false\"}";
    public static final HashMap<String, Object> c = new HashMap<>();
    public static final String d = "hk.alipay.wallet";
    public static final String e = "phonecashier.pay.hash";
    public static final String f = "orderSuffix";
    public static final String g = "externalPkgName";
    public static final String h = "phonecashier.pay.result";
    public static final String i = "phonecashier.pay.resultOrderHash";
    public C4293a a = null;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.PayResultActivity$a */
    /* loaded from: classes12.dex */
    public static class RunnableC4126a implements Runnable {
        public final /* synthetic */ Activity a;

        public RunnableC4126a(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.finish();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.PayResultActivity$b */
    /* loaded from: classes12.dex */
    public static final class C4127b {
        public static volatile String a;
        public static volatile String b;
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(d);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            C4302e.a(e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(f))) {
                C4127b.a = intent.getStringExtra(e);
                String stringExtra = intent.getStringExtra(f);
                String stringExtra2 = intent.getStringExtra(g);
                C4293a a = C4293a.C4294a.a(intent);
                this.a = a;
                if (a == null) {
                    finish();
                }
                a(this, C4127b.a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.a == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra(h);
            int intExtra = intent.getIntExtra(i, 0);
            if (intExtra != 0 && TextUtils.equals(C4127b.a, String.valueOf(intExtra))) {
                if (!TextUtils.isEmpty(stringExtra3)) {
                    a(stringExtra3, C4127b.a);
                } else {
                    a(C4127b.a);
                }
                C4127b.a = "";
                a(this, 300);
                return;
            }
            C4293a c4293a = this.a;
            C4218a.b(c4293a, C4226b.l, C4226b.l0, "Expected " + C4127b.a + ", got " + intExtra);
            a(C4127b.a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }

    public static void a(String str) {
        C4127b.b = C4212b.a();
        a(c, str);
    }

    public static void a(String str, String str2) {
        C4127b.b = str;
        a(c, str2);
    }

    public static void a(Activity activity, int i2) {
        new Handler().postDelayed(new RunnableC4126a(activity), i2);
    }

    public static boolean a(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}
