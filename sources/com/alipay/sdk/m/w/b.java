package com.alipay.sdk.m.w;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.w.a;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements Callable<WifiInfo> {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public WifiInfo call() {
            return ((WifiManager) this.a.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0203b implements a.InterfaceC0202a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0202a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c implements Callable<String> {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            return com.alipay.sdk.m.b.c.a(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d implements a.InterfaceC0202a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0202a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class e implements Callable<NetworkInfo> {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public NetworkInfo call() {
            return ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.a.getApplicationContext().getSystemService("connectivity"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class f implements a.InterfaceC0202a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0202a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class g implements Callable<String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ com.alipay.sdk.m.s.a b;

        public g(Context context, com.alipay.sdk.m.s.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            try {
                return com.alipay.sdk.m.n0.a.c(this.a);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.b(this.b, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.u, th.getClass().getName());
                return "";
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class h implements a.InterfaceC0202a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0202a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class i implements Callable<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ com.alipay.sdk.m.s.a d;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class a implements APSecuritySdk.InitResultListener {
            public final /* synthetic */ String[] a;
            public final /* synthetic */ ConditionVariable b;

            public a(String[] strArr, ConditionVariable conditionVariable) {
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

        public i(String str, String str2, Context context, com.alipay.sdk.m.s.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = context;
            this.d = aVar;
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
                aPSecuritySdk.initToken(0, hashMap, new a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                com.alipay.sdk.m.k.a.b(this.d, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.r, th.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.m.k.a.b(this.d, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.s, "missing token");
            }
            return strArr[0];
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class j implements a.InterfaceC0202a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0202a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof WifiInfo) || obj == null);
        }
    }

    public static NetworkInfo a(com.alipay.sdk.m.s.a aVar, Context context) {
        Context a2 = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) com.alipay.sdk.m.w.a.a(2, 10L, timeUnit, new d(), new e(a2), false, 10L, timeUnit, aVar, false);
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context) {
        if (com.alipay.sdk.m.m.a.D().x()) {
            return (String) com.alipay.sdk.m.w.a.a(1, 1L, TimeUnit.DAYS, new C0203b(), new c(com.alipay.sdk.m.w.a.a(context)), true, 200L, TimeUnit.MILLISECONDS, aVar, true);
        }
        return "";
    }

    public static String c(com.alipay.sdk.m.s.a aVar, Context context) {
        return (String) com.alipay.sdk.m.w.a.a(3, 1L, TimeUnit.DAYS, new f(), new g(com.alipay.sdk.m.w.a.a(context), aVar), true, 3L, TimeUnit.SECONDS, aVar, false);
    }

    public static WifiInfo d(com.alipay.sdk.m.s.a aVar, Context context) {
        Context a2 = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (WifiInfo) com.alipay.sdk.m.w.a.a(5, 10L, timeUnit, new j(), new a(a2), false, 10L, timeUnit, aVar, false);
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2) {
        Context a2 = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) com.alipay.sdk.m.w.a.a(4, 10L, timeUnit, new h(), new i(str, str2, a2, aVar), true, 3L, timeUnit, aVar, true);
    }
}
