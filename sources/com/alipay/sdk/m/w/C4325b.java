package com.alipay.sdk.m.w;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.b.C4144c;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.n0.C4255a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.w.C4323a;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.w.b */
/* loaded from: classes10.dex */
public class C4325b {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$a */
    /* loaded from: classes10.dex */
    public static class CallableC4326a implements Callable<WifiInfo> {
        public final /* synthetic */ Context a;

        public CallableC4326a(Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public WifiInfo call() {
            return ((WifiManager) this.a.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$b */
    /* loaded from: classes10.dex */
    public static class C4327b implements C4323a.InterfaceC4324a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.C4323a.InterfaceC4324a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$c */
    /* loaded from: classes10.dex */
    public static class CallableC4328c implements Callable<String> {
        public final /* synthetic */ Context a;

        public CallableC4328c(Context context) {
            this.a = context;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            return C4144c.a(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$d */
    /* loaded from: classes10.dex */
    public static class C4329d implements C4323a.InterfaceC4324a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.C4323a.InterfaceC4324a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$e */
    /* loaded from: classes10.dex */
    public static class CallableC4330e implements Callable<NetworkInfo> {
        public final /* synthetic */ Context a;

        public CallableC4330e(Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public NetworkInfo call() {
            return ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.a.getApplicationContext().getSystemService("connectivity"));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$f */
    /* loaded from: classes10.dex */
    public static class C4331f implements C4323a.InterfaceC4324a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.C4323a.InterfaceC4324a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$g */
    /* loaded from: classes10.dex */
    public static class CallableC4332g implements Callable<String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ C4293a b;

        public CallableC4332g(Context context, C4293a c4293a) {
            this.a = context;
            this.b = c4293a;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            try {
                return C4255a.c(this.a);
            } catch (Throwable th) {
                C4218a.b(this.b, C4226b.o, C4226b.u, th.getClass().getName());
                return "";
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$h */
    /* loaded from: classes10.dex */
    public static class C4333h implements C4323a.InterfaceC4324a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.C4323a.InterfaceC4324a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$i */
    /* loaded from: classes10.dex */
    public static class CallableC4334i implements Callable<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ C4293a d;

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.w.b$i$a */
        /* loaded from: classes10.dex */
        public class C4335a implements APSecuritySdk.InitResultListener {
            public final /* synthetic */ String[] a;
            public final /* synthetic */ ConditionVariable b;

            public C4335a(String[] strArr, ConditionVariable conditionVariable) {
                this.a = strArr;
                this.b = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.a[0] = tokenResult.apdidToken;
                }
                this.b.open();
            }
        }

        public CallableC4334i(String str, String str2, Context context, C4293a c4293a) {
            this.a = str;
            this.b = str2;
            this.c = context;
            this.d = c4293a;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.a);
            hashMap.put("utdid", this.b);
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(this.c);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, hashMap, new C4335a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                C4302e.a(th);
                C4218a.b(this.d, C4226b.o, C4226b.r, th.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                C4218a.b(this.d, C4226b.o, C4226b.s, "missing token");
            }
            return strArr[0];
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$j */
    /* loaded from: classes10.dex */
    public static class C4336j implements C4323a.InterfaceC4324a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.C4323a.InterfaceC4324a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof WifiInfo) || obj == null);
        }
    }

    public static NetworkInfo a(C4293a c4293a, Context context) {
        Context a = C4323a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) C4323a.a(2, 10L, timeUnit, new C4329d(), new CallableC4330e(a), false, 10L, timeUnit, c4293a, false);
    }

    public static String b(C4293a c4293a, Context context) {
        if (C4245a.D().x()) {
            return (String) C4323a.a(1, 1L, TimeUnit.DAYS, new C4327b(), new CallableC4328c(C4323a.a(context)), true, 200L, TimeUnit.MILLISECONDS, c4293a, true);
        }
        return "";
    }

    public static String c(C4293a c4293a, Context context) {
        return (String) C4323a.a(3, 1L, TimeUnit.DAYS, new C4331f(), new CallableC4332g(C4323a.a(context), c4293a), true, 3L, TimeUnit.SECONDS, c4293a, false);
    }

    public static WifiInfo d(C4293a c4293a, Context context) {
        Context a = C4323a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (WifiInfo) C4323a.a(5, 10L, timeUnit, new C4336j(), new CallableC4326a(a), false, 10L, timeUnit, c4293a, false);
    }

    public static String a(C4293a c4293a, Context context, String str, String str2) {
        Context a = C4323a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) C4323a.a(4, 10L, timeUnit, new C4333h(), new CallableC4334i(str, str2, a, c4293a), true, 3L, timeUnit, c4293a, true);
    }
}
