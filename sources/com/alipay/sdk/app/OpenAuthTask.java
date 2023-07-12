package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.common.track.model.C3834a;
import com.alipay.sdk.m.j.C4211a;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.u.C4318n;
import com.youku.live.livesdk.preloader.Preloader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;
    public static final Map<String, Callback> e = new ConcurrentHashMap();
    public static long f = -1;
    public static final int g = 122;
    public final Activity b;
    public Callback c;
    public volatile boolean a = false;
    public final Handler d = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");
        
        public String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Callback {
        void onResult(int i, String str, Bundle bundle);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.OpenAuthTask$a */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class C4124a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BizType.values().length];
            a = iArr;
            try {
                iArr[BizType.Deduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BizType.AccountAuth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.OpenAuthTask$b */
    /* loaded from: classes12.dex */
    public final class RunnableC4125b implements Runnable {
        public final int a;
        public final String b;
        public final Bundle c;

        public /* synthetic */ RunnableC4125b(OpenAuthTask openAuthTask, int i, String str, Bundle bundle, C4124a c4124a) {
            this(i, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthTask.this.c != null) {
                OpenAuthTask.this.c.onResult(this.a, this.b, this.c);
            }
        }

        public RunnableC4125b(int i, String str, Bundle bundle) {
            this.a = i;
            this.b = str;
            this.c = bundle;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.b = activity;
        C4295b.d().a(activity);
    }

    private String b(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LoginConstant.START_TIME, String.valueOf(j));
        jSONObject.put(Preloader.KEY_SESSION, str);
        jSONObject.put("package", this.b.getPackageName());
        if (bizType != null) {
            jSONObject.put(ALBiometricsKeys.KEY_APP_ID, bizType.appId);
        }
        jSONObject.put("sdkVersion", "h.a.3.8.11");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    private String c(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(ALBiometricsKeys.KEY_APP_ID, bizType.appId);
            if (C4124a.a[bizType.ordinal()] == 1) {
                appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return appendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    private boolean d(C4293a c4293a, String str, BizType bizType, Map<String, String> map, boolean z) {
        PackageInfo packageInfo;
        if (this.a) {
            this.d.post(new RunnableC4125b(this, 4000, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.a = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f <= 3000) {
            this.d.post(new RunnableC4125b(this, 5000, "3s 内重复支付", null, null));
            return true;
        }
        f = elapsedRealtime;
        C4211a.a("");
        String a = C4318n.a(32);
        HashMap hashMap = new HashMap(map);
        hashMap.put("mqpPkgName", this.b.getPackageName());
        hashMap.put("mqpScene", C3834a.C3835a.a);
        List<C4245a.C4247b> l = C4245a.D().l();
        if (!C4245a.D().h || l == null) {
            l = C4211a.d;
        }
        C4318n.C4321c a2 = C4318n.a(c4293a, this.b, l);
        if (a2 == null || a2.a(c4293a) || a2.a() || (packageInfo = a2.a) == null || packageInfo.versionCode < 122) {
            if (z) {
                hashMap.put("mqpScheme", String.valueOf(str));
                hashMap.put("mqpNotifyName", a);
                hashMap.put("mqpScene", "landing");
                String c = c(bizType, hashMap);
                Intent intent = new Intent(this.b, H5OpenAuthActivity.class);
                intent.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(c)));
                C4293a.C4294a.a(c4293a, intent);
                this.b.startActivity(intent);
                return false;
            }
            this.d.post(new RunnableC4125b(this, 4001, "支付宝未安装或签名错误", null, null));
            return true;
        }
        try {
            HashMap<String, String> a3 = C4293a.a(c4293a);
            a3.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
            hashMap.put("mqpLoc", new JSONObject(a3).toString());
            String c2 = c(bizType, hashMap);
            e.put(a, this.c);
            String str2 = null;
            try {
                str2 = b(elapsedRealtime, a, bizType, c2);
            } catch (JSONException e2) {
                C4218a.a(c4293a, C4226b.l, C4226b.q0, e2);
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                this.d.post(new RunnableC4125b(this, 4000, "参数错误", null, null));
                return true;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(ALBiometricsKeys.KEY_APP_ID, "20001129").appendQueryParameter("payload", str3).build());
            intent2.addFlags(268435456);
            intent2.setPackage(a2.a.packageName);
            try {
                C4218a.a(c4293a, C4226b.l, C4226b.Y, "" + elapsedRealtime);
                C4293a.C4294a.a(c4293a, a);
                this.b.startActivity(intent2);
            } catch (Throwable th) {
                C4218a.a(c4293a, C4226b.l, "StartWalletEx", th);
            }
            return false;
        }
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        Activity activity = this.b;
        String valueOf = String.valueOf(map);
        C4293a c4293a = new C4293a(activity, valueOf, "oa-" + bizType);
        this.c = callback;
        if (d(c4293a, str, bizType, map, z)) {
            C4218a.b(this.b, c4293a, "", c4293a.d);
        }
    }

    public static void a(String str, int i, String str2, Bundle bundle) {
        Callback remove = e.remove(str);
        if (remove != null) {
            try {
                remove.onResult(i, str2, bundle);
            } catch (Throwable th) {
                C4302e.a(th);
            }
        }
    }
}
