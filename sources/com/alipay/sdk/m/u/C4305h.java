package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.j.EnumC4213c;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.l.C4231b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4318n;
import com.vivo.push.PushClientConstants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.h */
/* loaded from: classes10.dex */
public class C4305h {
    public static final String j = "failed";
    public static final String k = "scheme_failed";
    public Activity a;
    public volatile IAlixPay b;
    public boolean d;
    public InterfaceC4312g e;
    public final C4293a f;
    public final Object c = IAlixPay.class;
    public boolean g = false;
    public String h = null;
    public String i = null;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$a */
    /* loaded from: classes10.dex */
    public class C4306a implements AlipayResultActivity.InterfaceC4122a {
        public final /* synthetic */ CountDownLatch a;

        public C4306a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.InterfaceC4122a
        public void a(int i, String str, String str2) {
            C4305h.this.h = C4212b.a(i, str, str2);
            this.a.countDown();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$b */
    /* loaded from: classes10.dex */
    public class C4307b implements APayEntranceActivity.InterfaceC4121a {
        public final /* synthetic */ Object a;

        public C4307b(Object obj) {
            this.a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.InterfaceC4121a
        public void a(String str) {
            C4305h.this.i = str;
            synchronized (this.a) {
                try {
                    this.a.notify();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$c */
    /* loaded from: classes10.dex */
    public class RunnableC4308c implements Runnable {
        public final /* synthetic */ APayEntranceActivity.InterfaceC4121a a;

        public RunnableC4308c(APayEntranceActivity.InterfaceC4121a interfaceC4121a) {
            this.a = interfaceC4121a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4305h.this.f == null || C4305h.this.f.d()) {
                return;
            }
            C4218a.b(C4305h.this.f, C4226b.l, C4226b.e0, "");
            if (C4245a.D().w()) {
                C4305h.this.f.b(true);
                this.a.a(C4212b.a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$d */
    /* loaded from: classes10.dex */
    public class RunnableC4309d implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Object b;

        public RunnableC4309d(Intent intent, Object obj) {
            this.a = intent;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (C4305h.this.a != null) {
                    C4305h.this.a.startActivity(this.a);
                } else {
                    C4218a.b(C4305h.this.f, C4226b.l, C4226b.c0, "");
                    Context a = C4305h.this.f.a();
                    if (a != null) {
                        a.startActivity(this.a);
                    }
                }
            } catch (Throwable th) {
                C4218a.a(C4305h.this.f, C4226b.l, C4226b.d0, th);
                C4318n.a("alipaySdk", C4231b.q, C4305h.this.a, C4305h.this.f);
                synchronized (this.b) {
                    try {
                        C4305h.this.i = C4305h.k;
                        this.b.notify();
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$e */
    /* loaded from: classes10.dex */
    public class BinderC4310e extends IRemoteServiceCallback.Stub {
        public BinderC4310e() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            C4218a.a(C4305h.this.f, C4226b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (C4305h.this.e != null) {
                    C4305h.this.e.a();
                }
                if (C4305h.this.f != null) {
                    C4305h.this.f.c(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                C4218a.a(C4305h.this.f, C4226b.l, C4226b.Z, e);
            }
            intent.setClassName(str, str2);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    C4293a c4293a = C4305h.this.f;
                    C4218a.a(c4293a, C4226b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                }
            } catch (Throwable unused) {
            }
            try {
                if (C4305h.this.a == null) {
                    C4218a.b(C4305h.this.f, C4226b.l, C4226b.a0, "");
                    Context a = C4305h.this.f.a();
                    if (a != null) {
                        a.startActivity(intent);
                        return;
                    }
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C4305h.this.a.startActivity(intent);
                C4293a c4293a2 = C4305h.this.f;
                C4218a.a(c4293a2, C4226b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            } catch (Throwable th) {
                C4218a.a(C4305h.this.f, C4226b.l, C4226b.b0, th);
                throw th;
            }
        }

        public /* synthetic */ BinderC4310e(C4305h c4305h, C4306a c4306a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$f */
    /* loaded from: classes10.dex */
    public class ServiceConnectionC4311f implements ServiceConnection {
        public ServiceConnectionC4311f() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C4218a.a(C4305h.this.f, C4226b.l, "srvCon");
            synchronized (C4305h.this.c) {
                C4305h.this.b = IAlixPay.Stub.asInterface(iBinder);
                C4305h.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C4218a.a(C4305h.this.f, C4226b.l, "srvDis");
            C4305h.this.b = null;
        }

        public /* synthetic */ ServiceConnectionC4311f(C4305h c4305h, C4306a c4306a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.h$g */
    /* loaded from: classes10.dex */
    public interface InterfaceC4312g {
        void a();

        void b();
    }

    public C4305h(Activity activity, C4293a c4293a, InterfaceC4312g interfaceC4312g) {
        this.a = activity;
        this.f = c4293a;
        this.e = interfaceC4312g;
        C4302e.d(C4230a.z, "alipaySdk");
    }

    private void e(C4318n.C4321c c4321c) throws InterruptedException {
        PackageInfo packageInfo;
        if (c4321c == null || (packageInfo = c4321c.a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.a.startActivity(intent);
        } catch (Throwable th) {
            C4218a.a(this.f, C4226b.l, C4226b.g0, th);
        }
        Thread.sleep(200L);
    }

    private String f(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String a = C4318n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C4293a c4293a = this.f;
        C4218a.a(c4293a, C4226b.l, "BSAStart", a + "|" + elapsedRealtime);
        C4293a.C4294a.a(this.f, a);
        C4307b c4307b = new C4307b(obj);
        APayEntranceActivity.h.put(a, c4307b);
        try {
            HashMap<String, String> a2 = C4293a.a(this.f);
            a2.put("ts_intent", String.valueOf(elapsedRealtime));
            jSONObject = new JSONObject(a2);
        } catch (Throwable th) {
            try {
                C4218a.a(this.f, C4226b.l, "BSALocEx", th);
                jSONObject = null;
            } catch (InterruptedException e) {
                C4218a.a(this.f, C4226b.l, "BSAWaiting", e);
                EnumC4213c enumC4213c = EnumC4213c.PAY_WAITTING;
                return C4212b.a(enumC4213c.b(), enumC4213c.a(), "");
            } catch (Throwable th2) {
                C4218a.a(this.f, C4226b.l, "BSAEx", th2);
                C4318n.a("alipaySdk", C4231b.q, this.a, this.f);
                return k;
            }
        }
        Intent intent = new Intent(this.a, APayEntranceActivity.class);
        intent.putExtra(APayEntranceActivity.d, str);
        intent.putExtra(APayEntranceActivity.e, str2);
        intent.putExtra(APayEntranceActivity.f, a);
        if (jSONObject != null) {
            intent.putExtra(APayEntranceActivity.g, jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC4308c(c4307b), C4245a.D().k());
        Activity activity = this.a;
        C4293a c4293a2 = this.f;
        C4218a.a(activity, c4293a2, str, c4293a2.d);
        if (C4245a.D().z()) {
            new Handler(Looper.getMainLooper()).post(new RunnableC4309d(intent, obj));
        } else {
            try {
                Activity activity2 = this.a;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    C4218a.b(this.f, C4226b.l, C4226b.a0, "");
                    Context a3 = this.f.a();
                    if (a3 != null) {
                        a3.startActivity(intent);
                    }
                }
            } catch (Throwable th3) {
                C4218a.a(this.f, C4226b.l, C4226b.b0, th3);
                throw th3;
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        String str3 = this.i;
        String str4 = "unknown";
        try {
            String str5 = C4316l.a(this.f, str3).get(C4316l.a);
            str4 = str5 == null ? "null" : str5;
        } catch (Throwable th4) {
            C4218a.a(this.f, C4226b.l, "BSAStatEx", th4);
        }
        C4293a c4293a3 = this.f;
        C4218a.a(c4293a3, C4226b.l, "BSADone-" + str4);
        if (TextUtils.isEmpty(str3)) {
            C4218a.a(this.f, C4226b.l, "BSAEmpty");
            return k;
        }
        return str3;
    }

    public static /* synthetic */ C4293a a(C4305h c4305h) {
        return c4305h.f;
    }

    private String c(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        C4302e.d(C4230a.z, "pay payInvokeAct");
        C4293a c4293a = this.f;
        C4218a.a(c4293a, C4226b.l, C4226b.X, str2 + "|" + str3);
        Activity activity = this.a;
        C4293a c4293a2 = this.f;
        C4218a.a(activity, c4293a2, str, c4293a2.d);
        return f(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0188 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(java.lang.String r9, java.lang.String r10, android.content.pm.PackageInfo r11, com.alipay.sdk.m.u.C4318n.C4321c r12) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.C4305h.d(java.lang.String, java.lang.String, android.content.pm.PackageInfo, com.alipay.sdk.m.u.n$c):java.lang.String");
    }

    public static boolean b(String str, Context context, C4293a c4293a) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                C4218a.a(c4293a, C4226b.l, "BSADetectFail");
                return false;
            }
            return true;
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, "BSADetectFail", th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #3 {all -> 0x00ad, blocks: (B:10:0x0023, B:12:0x002b, B:15:0x0033, B:18:0x003c, B:21:0x0042, B:24:0x004b, B:26:0x0054, B:29:0x0059, B:31:0x0063, B:25:0x0050), top: B:72:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            com.alipay.sdk.m.m.a r2 = com.alipay.sdk.m.m.C4245a.D()     // Catch: java.lang.Throwable -> Lb0
            java.util.List r2 = r2.l()     // Catch: java.lang.Throwable -> Lb0
            com.alipay.sdk.m.m.a r3 = com.alipay.sdk.m.m.C4245a.D()     // Catch: java.lang.Throwable -> Lb0
            boolean r3 = r3.h     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L15
            if (r2 != 0) goto L17
        L15:
            java.util.List<com.alipay.sdk.m.m.a$b> r2 = com.alipay.sdk.m.j.C4211a.d     // Catch: java.lang.Throwable -> Lb0
        L17:
            com.alipay.sdk.m.s.a r3 = r8.f     // Catch: java.lang.Throwable -> Lb0
            android.app.Activity r4 = r8.a     // Catch: java.lang.Throwable -> Lb0
            com.alipay.sdk.m.u.n$c r2 = com.alipay.sdk.m.u.C4318n.a(r3, r4, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r3 = "failed"
            if (r2 == 0) goto Laf
            com.alipay.sdk.m.s.a r4 = r8.f     // Catch: java.lang.Throwable -> Lad
            boolean r4 = r2.a(r4)     // Catch: java.lang.Throwable -> Lad
            if (r4 != 0) goto Laf
            boolean r4 = r2.a()     // Catch: java.lang.Throwable -> Lad
            if (r4 == 0) goto L33
            goto Laf
        L33:
            android.content.pm.PackageInfo r4 = r2.a     // Catch: java.lang.Throwable -> Lad
            boolean r4 = com.alipay.sdk.m.u.C4318n.a(r4)     // Catch: java.lang.Throwable -> Lad
            if (r4 == 0) goto L3c
            return r3
        L3c:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L50
            java.lang.String r4 = "com.eg.android.AlipayGphone"
            java.lang.String r3 = r3.packageName     // Catch: java.lang.Throwable -> Lad
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L4b
            goto L50
        L4b:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = r3.packageName     // Catch: java.lang.Throwable -> Lad
            goto L54
        L50:
            java.lang.String r0 = com.alipay.sdk.m.u.C4318n.b()     // Catch: java.lang.Throwable -> Lad
        L54:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L59
            r1 = r3
        L59:
            com.alipay.sdk.m.m.a r3 = com.alipay.sdk.m.m.C4245a.D()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto Lbb
            int r4 = r3.length()     // Catch: java.lang.Throwable -> Lad
            if (r4 <= 0) goto Lbb
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lab
            r4.<init>(r3)     // Catch: java.lang.Throwable -> Lab
            org.json.JSONObject r3 = r4.optJSONObject(r0)     // Catch: java.lang.Throwable -> Lab
            if (r3 == 0) goto Lbb
            int r4 = r3.length()     // Catch: java.lang.Throwable -> Lab
            if (r4 <= 0) goto Lbb
            java.util.Iterator r4 = r3.keys()     // Catch: java.lang.Throwable -> Lab
        L7e:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lab
            if (r5 == 0) goto Lbb
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lab
            int r6 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto L7e
            int r7 = r1.versionCode     // Catch: java.lang.Throwable -> Lab
            if (r7 < r6) goto L7e
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            com.alipay.sdk.m.m.a r6 = com.alipay.sdk.m.m.C4245a.D()     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            android.app.Activity r7 = r8.a     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            boolean r5 = r6.a(r7, r5)     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            r8.g = r5     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            if (r5 == 0) goto L7e
            goto Lbb
        Lab:
            goto Lbb
        Lad:
            r3 = move-exception
            goto Lb2
        Laf:
            return r3
        Lb0:
            r3 = move-exception
            r2 = r1
        Lb2:
            com.alipay.sdk.m.s.a r4 = r8.f
            java.lang.String r5 = "biz"
            java.lang.String r6 = "CheckClientSignEx"
            com.alipay.sdk.m.k.C4218a.a(r4, r5, r6, r3)
        Lbb:
            com.alipay.sdk.m.s.a r3 = r8.f
            boolean r3 = com.alipay.sdk.m.u.C4318n.b(r3)
            if (r10 != 0) goto Lc7
            boolean r10 = r8.g
            if (r10 == 0) goto Ld8
        Lc7:
            if (r3 != 0) goto Ld8
            android.app.Activity r10 = r8.a
            com.alipay.sdk.m.s.a r3 = r8.f
            boolean r10 = b(r0, r10, r3)
            if (r10 == 0) goto Ld8
            java.lang.String r9 = r8.c(r9, r0, r1)
            return r9
        Ld8:
            java.lang.String r9 = r8.d(r9, r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.C4305h.a(java.lang.String, boolean):java.lang.String");
    }

    private String b(String str, String str2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String a = C4318n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C4293a c4293a = this.f;
        C4218a.a(c4293a, C4226b.l, "BSPStart", a + "|" + elapsedRealtime);
        C4293a.C4294a.a(this.f, a);
        AlipayResultActivity.a.put(a, new C4306a(countDownLatch));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put(C4231b.d, str);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.a.getPackageName());
            jSONObject.put(Preloader.KEY_SESSION, a);
            String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(ALBiometricsKeys.KEY_APP_ID, "20000125");
            appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
            HashMap<String, String> a2 = C4293a.a(this.f);
            a2.put("ts_scheme", String.valueOf(elapsedRealtime));
            appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a2).toString());
            String uri = appendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(uri));
            Activity activity = this.a;
            C4293a c4293a2 = this.f;
            C4218a.a(activity, c4293a2, str, c4293a2.d);
            this.a.startActivity(intent);
            C4302e.d(C4230a.z, "pay scheme waiting " + uri);
            countDownLatch.await();
            String str3 = this.h;
            String str4 = C4316l.a(this.f, str3).get(C4316l.a);
            if (str4 == null) {
                str4 = "null";
            }
            C4293a c4293a3 = this.f;
            C4218a.a(c4293a3, C4226b.l, "BSPDone-" + str4);
            if (TextUtils.isEmpty(str3)) {
                C4218a.a(this.f, C4226b.l, "BSPEmpty");
                return k;
            }
            return str3;
        } catch (InterruptedException e) {
            C4218a.a(this.f, C4226b.l, "BSPWaiting", e);
            EnumC4213c enumC4213c = EnumC4213c.PAY_WAITTING;
            return C4212b.a(enumC4213c.b(), enumC4213c.a(), "");
        } catch (Throwable th) {
            C4218a.a(this.f, C4226b.l, "BSPEx", th);
            return k;
        }
    }

    public static boolean a(String str, Context context, C4293a c4293a) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                C4218a.a(c4293a, C4226b.l, "BSPDetectFail");
                return false;
            }
            return true;
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, "BSPDetectFail", th);
            return false;
        }
    }

    private Pair<String, Boolean> a(String str, String str2, C4293a c4293a) {
        int i;
        ServiceConnectionC4311f serviceConnectionC4311f;
        BinderC4310e binderC4310e;
        Activity activity;
        Activity activity2;
        long elapsedRealtime;
        StringBuilder sb;
        String Pay;
        Activity activity3;
        Activity activity4;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(C4318n.c(str2));
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(elapsedRealtime2);
        sb2.append("|");
        sb2.append(str != null ? str.length() : 0);
        C4218a.a(c4293a, C4226b.l, C4226b.R, sb2.toString());
        C4218a.a(this.a, c4293a, str, c4293a.d);
        try {
            if (!C4245a.D().f()) {
                ComponentName startService = this.a.getApplication().startService(intent);
                C4218a.a(c4293a, C4226b.l, "stSrv", startService != null ? startService.getPackageName() : "null");
            } else {
                C4218a.a(c4293a, C4226b.l, "stSrv", "skipped");
            }
            if (C4245a.D().b()) {
                i = 65;
                C4218a.a(c4293a, C4226b.l, "bindFlg", MonitorType.IMPRESSION);
            } else {
                i = 1;
            }
            ServiceConnectionC4311f serviceConnectionC4311f2 = new ServiceConnectionC4311f(this, null);
            if (this.a.getApplicationContext().bindService(intent, serviceConnectionC4311f2, i)) {
                synchronized (this.c) {
                    if (this.b == null) {
                        try {
                            this.c.wait(C4245a.D().k());
                        } catch (InterruptedException e) {
                            C4218a.a(c4293a, C4226b.l, C4226b.L, e);
                        }
                    }
                }
                IAlixPay iAlixPay = this.b;
                try {
                    if (iAlixPay == null) {
                        C4218a.b(c4293a, C4226b.l, C4226b.E, "");
                        C4318n.a("alipaySdk", C4231b.o, this.a, this.f);
                        Pair<String, Boolean> pair = new Pair<>("failed", Boolean.TRUE);
                        try {
                            this.a.getApplicationContext().unbindService(serviceConnectionC4311f2);
                        } catch (Throwable th) {
                            C4302e.a(th);
                        }
                        C4218a.a(c4293a, C4226b.l, C4226b.T, "" + SystemClock.elapsedRealtime());
                        C4218a.a(this.a, c4293a, str, c4293a.d);
                        this.b = null;
                        if (this.d && (activity4 = this.a) != null) {
                            activity4.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return pair;
                    }
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    C4218a.a(c4293a, C4226b.l, C4226b.S, "" + elapsedRealtime3);
                    InterfaceC4312g interfaceC4312g = this.e;
                    if (interfaceC4312g != null) {
                        interfaceC4312g.b();
                    }
                    if (this.a.getRequestedOrientation() == 0) {
                        this.a.setRequestedOrientation(1);
                        this.d = true;
                    }
                    int version = iAlixPay.getVersion();
                    binderC4310e = new BinderC4310e(this, null);
                    try {
                        if (version >= 3) {
                            iAlixPay.registerCallback03(binderC4310e, str, null);
                        } else {
                            iAlixPay.registerCallback(binderC4310e);
                        }
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        th = th2;
                        serviceConnectionC4311f = serviceConnectionC4311f2;
                    }
                    try {
                        sb.append("");
                        sb.append(elapsedRealtime);
                        C4218a.a(c4293a, C4226b.l, C4226b.U, sb.toString());
                        if (version >= 3) {
                            iAlixPay.r03(C4226b.l, "bind_pay", null);
                        }
                        if (version >= 2) {
                            HashMap<String, String> a = C4293a.a(c4293a);
                            a.put("ts_bind", String.valueOf(elapsedRealtime2));
                            a.put("ts_bend", String.valueOf(elapsedRealtime3));
                            a.put("ts_pay", String.valueOf(elapsedRealtime));
                            Pay = iAlixPay.pay02(str, a);
                        } else {
                            Pay = iAlixPay.Pay(str);
                        }
                        String str3 = Pay;
                        try {
                            iAlixPay.unregisterCallback(binderC4310e);
                        } catch (Throwable th3) {
                            C4302e.a(th3);
                        }
                        try {
                            this.a.getApplicationContext().unbindService(serviceConnectionC4311f2);
                        } catch (Throwable th4) {
                            C4302e.a(th4);
                        }
                        C4218a.a(c4293a, C4226b.l, C4226b.T, "" + SystemClock.elapsedRealtime());
                        C4218a.a(this.a, c4293a, str, c4293a.d);
                        this.b = null;
                        if (this.d && (activity3 = this.a) != null) {
                            activity3.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return new Pair<>(str3, Boolean.FALSE);
                    } catch (Throwable th5) {
                        th = th5;
                        serviceConnectionC4311f = serviceConnectionC4311f2;
                        try {
                            C4218a.a(c4293a, C4226b.l, C4226b.E, th, "in_bind");
                            Pair<String, Boolean> pair2 = new Pair<>("failed", Boolean.TRUE);
                            if (binderC4310e != null) {
                                try {
                                    iAlixPay.unregisterCallback(binderC4310e);
                                } catch (Throwable th6) {
                                    C4302e.a(th6);
                                }
                            }
                            try {
                                this.a.getApplicationContext().unbindService(serviceConnectionC4311f);
                            } catch (Throwable th7) {
                                C4302e.a(th7);
                            }
                            C4218a.a(c4293a, C4226b.l, C4226b.T, "" + SystemClock.elapsedRealtime());
                            C4218a.a(this.a, c4293a, str, c4293a.d);
                            this.b = null;
                            if (this.d && (activity2 = this.a) != null) {
                                activity2.setRequestedOrientation(0);
                                this.d = false;
                            }
                            return pair2;
                        } catch (Throwable th8) {
                            if (binderC4310e != null) {
                                try {
                                    iAlixPay.unregisterCallback(binderC4310e);
                                } catch (Throwable th9) {
                                    C4302e.a(th9);
                                }
                            }
                            try {
                                this.a.getApplicationContext().unbindService(serviceConnectionC4311f);
                            } catch (Throwable th10) {
                                C4302e.a(th10);
                            }
                            C4218a.a(c4293a, C4226b.l, C4226b.T, "" + SystemClock.elapsedRealtime());
                            C4218a.a(this.a, c4293a, str, c4293a.d);
                            this.b = null;
                            if (this.d && (activity = this.a) != null) {
                                activity.setRequestedOrientation(0);
                                this.d = false;
                            }
                            throw th8;
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    serviceConnectionC4311f = serviceConnectionC4311f2;
                    binderC4310e = null;
                }
            } else {
                throw new Throwable("bindService fail");
            }
        }
    }

    public void a() {
        this.a = null;
        this.e = null;
    }
}
