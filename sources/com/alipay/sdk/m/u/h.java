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
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.n;
import com.vivo.push.PushClientConstants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class h {
    public static final String j = "failed";
    public static final String k = "scheme_failed";
    public Activity a;
    public volatile IAlixPay b;
    public boolean d;
    public g e;
    public final com.alipay.sdk.m.s.a f;
    public final Object c = IAlixPay.class;
    public boolean g = false;
    public String h = null;
    public String i = null;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a implements AlipayResultActivity.a {
        public final /* synthetic */ CountDownLatch a;

        public a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i, String str, String str2) {
            h.this.h = com.alipay.sdk.m.j.b.a(i, str, str2);
            this.a.countDown();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b implements APayEntranceActivity.a {
        public final /* synthetic */ Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            h.this.i = str;
            synchronized (this.a) {
                try {
                    this.a.notify();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public final /* synthetic */ APayEntranceActivity.a a;

        public c(APayEntranceActivity.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f == null || h.this.f.d()) {
                return;
            }
            com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.e0, "");
            if (com.alipay.sdk.m.m.a.D().w()) {
                h.this.f.b(true);
                this.a.a(com.alipay.sdk.m.j.b.a());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Object b;

        public d(Intent intent, Object obj) {
            this.a = intent;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.this.a != null) {
                    h.this.a.startActivity(this.a);
                } else {
                    com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.c0, "");
                    Context a = h.this.f.a();
                    if (a != null) {
                        a.startActivity(this.a);
                    }
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.d0, th);
                n.a("alipaySdk", com.alipay.sdk.m.l.b.q, h.this.a, h.this.f);
                synchronized (this.b) {
                    try {
                        h.this.i = h.k;
                        this.b.notify();
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class e extends IRemoteServiceCallback.Stub {
        public e() {
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
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (h.this.e != null) {
                    h.this.e.a();
                }
                if (h.this.f != null) {
                    h.this.f.c(true);
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
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Z, e);
            }
            intent.setClassName(str, str2);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    com.alipay.sdk.m.s.a aVar = h.this.f;
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                }
            } catch (Throwable unused) {
            }
            try {
                if (h.this.a == null) {
                    com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    Context a = h.this.f.a();
                    if (a != null) {
                        a.startActivity(intent);
                        return;
                    }
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                h.this.a.startActivity(intent);
                com.alipay.sdk.m.s.a aVar2 = h.this.f;
                com.alipay.sdk.m.k.a.a(aVar2, com.alipay.sdk.m.k.b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th);
                throw th;
            }
        }

        public /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class f implements ServiceConnection {
        public f() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvCon");
            synchronized (h.this.c) {
                h.this.b = IAlixPay.Stub.asInterface(iBinder);
                h.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvDis");
            h.this.b = null;
        }

        public /* synthetic */ f(h hVar, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface g {
        void a();

        void b();
    }

    public h(Activity activity, com.alipay.sdk.m.s.a aVar, g gVar) {
        this.a = activity;
        this.f = aVar;
        this.e = gVar;
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "alipaySdk");
    }

    private void e(n.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.g0, th);
        }
        Thread.sleep(200L);
    }

    private String f(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String a2 = n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSAStart", a2 + "|" + elapsedRealtime);
        a.C0200a.a(this.f, a2);
        b bVar = new b(obj);
        APayEntranceActivity.h.put(a2, bVar);
        try {
            HashMap<String, String> a3 = com.alipay.sdk.m.s.a.a(this.f);
            a3.put("ts_intent", String.valueOf(elapsedRealtime));
            jSONObject = new JSONObject(a3);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSALocEx", th);
                jSONObject = null;
            } catch (InterruptedException e2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAWaiting", e2);
                com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
                return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEx", th2);
                n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, this.f);
                return k;
            }
        }
        Intent intent = new Intent(this.a, APayEntranceActivity.class);
        intent.putExtra(APayEntranceActivity.d, str);
        intent.putExtra(APayEntranceActivity.e, str2);
        intent.putExtra(APayEntranceActivity.f, a2);
        if (jSONObject != null) {
            intent.putExtra(APayEntranceActivity.g, jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new c(bVar), com.alipay.sdk.m.m.a.D().k());
        Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
        if (com.alipay.sdk.m.m.a.D().z()) {
            new Handler(Looper.getMainLooper()).post(new d(intent, obj));
        } else {
            try {
                Activity activity2 = this.a;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    com.alipay.sdk.m.k.a.b(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    Context a4 = this.f.a();
                    if (a4 != null) {
                        a4.startActivity(intent);
                    }
                }
            } catch (Throwable th3) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th3);
                throw th3;
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        String str3 = this.i;
        String str4 = "unknown";
        try {
            String str5 = l.a(this.f, str3).get(l.a);
            str4 = str5 == null ? "null" : str5;
        } catch (Throwable th4) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStatEx", th4);
        }
        com.alipay.sdk.m.s.a aVar3 = this.f;
        com.alipay.sdk.m.k.a.a(aVar3, com.alipay.sdk.m.k.b.l, "BSADone-" + str4);
        if (TextUtils.isEmpty(str3)) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEmpty");
            return k;
        }
        return str3;
    }

    public static /* synthetic */ com.alipay.sdk.m.s.a a(h hVar) {
        return hVar.f;
    }

    private String c(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay payInvokeAct");
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, str2 + "|" + str3);
        Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
        return f(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0188 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(java.lang.String r9, java.lang.String r10, android.content.pm.PackageInfo r11, com.alipay.sdk.m.u.n.c r12) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.d(java.lang.String, java.lang.String, android.content.pm.PackageInfo, com.alipay.sdk.m.u.n$c):java.lang.String");
    }

    public static boolean b(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail");
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail", th);
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
            com.alipay.sdk.m.m.a r2 = com.alipay.sdk.m.m.a.D()     // Catch: java.lang.Throwable -> Lb0
            java.util.List r2 = r2.l()     // Catch: java.lang.Throwable -> Lb0
            com.alipay.sdk.m.m.a r3 = com.alipay.sdk.m.m.a.D()     // Catch: java.lang.Throwable -> Lb0
            boolean r3 = r3.h     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L15
            if (r2 != 0) goto L17
        L15:
            java.util.List<com.alipay.sdk.m.m.a$b> r2 = com.alipay.sdk.m.j.a.d     // Catch: java.lang.Throwable -> Lb0
        L17:
            com.alipay.sdk.m.s.a r3 = r8.f     // Catch: java.lang.Throwable -> Lb0
            android.app.Activity r4 = r8.a     // Catch: java.lang.Throwable -> Lb0
            com.alipay.sdk.m.u.n$c r2 = com.alipay.sdk.m.u.n.a(r3, r4, r2)     // Catch: java.lang.Throwable -> Lb0
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
            boolean r4 = com.alipay.sdk.m.u.n.a(r4)     // Catch: java.lang.Throwable -> Lad
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
            java.lang.String r0 = com.alipay.sdk.m.u.n.b()     // Catch: java.lang.Throwable -> Lad
        L54:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L59
            r1 = r3
        L59:
            com.alipay.sdk.m.m.a r3 = com.alipay.sdk.m.m.a.D()     // Catch: java.lang.Throwable -> Lad
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
            com.alipay.sdk.m.m.a r6 = com.alipay.sdk.m.m.a.D()     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
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
            com.alipay.sdk.m.k.a.a(r4, r5, r6, r3)
        Lbb:
            com.alipay.sdk.m.s.a r3 = r8.f
            boolean r3 = com.alipay.sdk.m.u.n.b(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.a(java.lang.String, boolean):java.lang.String");
    }

    private String b(String str, String str2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String a2 = n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPStart", a2 + "|" + elapsedRealtime);
        a.C0200a.a(this.f, a2);
        AlipayResultActivity.a.put(a2, new a(countDownLatch));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put(com.alipay.sdk.m.l.b.d, str);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.a.getPackageName());
            jSONObject.put(Preloader.KEY_SESSION, a2);
            String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(ALBiometricsKeys.KEY_APP_ID, "20000125");
            appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
            HashMap<String, String> a3 = com.alipay.sdk.m.s.a.a(this.f);
            a3.put("ts_scheme", String.valueOf(elapsedRealtime));
            appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a3).toString());
            String uri = appendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(uri));
            Activity activity = this.a;
            com.alipay.sdk.m.s.a aVar2 = this.f;
            com.alipay.sdk.m.k.a.a(activity, aVar2, str, aVar2.d);
            this.a.startActivity(intent);
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay scheme waiting " + uri);
            countDownLatch.await();
            String str3 = this.h;
            String str4 = l.a(this.f, str3).get(l.a);
            if (str4 == null) {
                str4 = "null";
            }
            com.alipay.sdk.m.s.a aVar3 = this.f;
            com.alipay.sdk.m.k.a.a(aVar3, com.alipay.sdk.m.k.b.l, "BSPDone-" + str4);
            if (TextUtils.isEmpty(str3)) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPEmpty");
                return k;
            }
            return str3;
        } catch (InterruptedException e2) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPWaiting", e2);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPEx", th);
            return k;
        }
    }

    public static boolean a(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail");
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail", th);
            return false;
        }
    }

    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.m.s.a aVar) {
        int i;
        f fVar;
        e eVar;
        Activity activity;
        Activity activity2;
        long elapsedRealtime;
        StringBuilder sb;
        String Pay;
        Activity activity3;
        Activity activity4;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(n.c(str2));
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(elapsedRealtime2);
        sb2.append("|");
        sb2.append(str != null ? str.length() : 0);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.R, sb2.toString());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        try {
            if (!com.alipay.sdk.m.m.a.D().f()) {
                ComponentName startService = this.a.getApplication().startService(intent);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", startService != null ? startService.getPackageName() : "null");
            } else {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", "skipped");
            }
            if (com.alipay.sdk.m.m.a.D().b()) {
                i = 65;
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindFlg", MonitorType.IMPRESSION);
            } else {
                i = 1;
            }
            f fVar2 = new f(this, null);
            if (this.a.getApplicationContext().bindService(intent, fVar2, i)) {
                synchronized (this.c) {
                    if (this.b == null) {
                        try {
                            this.c.wait(com.alipay.sdk.m.m.a.D().k());
                        } catch (InterruptedException e2) {
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.L, e2);
                        }
                    }
                }
                IAlixPay iAlixPay = this.b;
                try {
                    if (iAlixPay == null) {
                        com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, "");
                        n.a("alipaySdk", com.alipay.sdk.m.l.b.o, this.a, this.f);
                        Pair<String, Boolean> pair = new Pair<>("failed", Boolean.TRUE);
                        try {
                            this.a.getApplicationContext().unbindService(fVar2);
                        } catch (Throwable th) {
                            com.alipay.sdk.m.u.e.a(th);
                        }
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                        this.b = null;
                        if (this.d && (activity4 = this.a) != null) {
                            activity4.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return pair;
                    }
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.S, "" + elapsedRealtime3);
                    g gVar = this.e;
                    if (gVar != null) {
                        gVar.b();
                    }
                    if (this.a.getRequestedOrientation() == 0) {
                        this.a.setRequestedOrientation(1);
                        this.d = true;
                    }
                    int version = iAlixPay.getVersion();
                    eVar = new e(this, null);
                    try {
                        if (version >= 3) {
                            iAlixPay.registerCallback03(eVar, str, null);
                        } else {
                            iAlixPay.registerCallback(eVar);
                        }
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        th = th2;
                        fVar = fVar2;
                    }
                    try {
                        sb.append("");
                        sb.append(elapsedRealtime);
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.U, sb.toString());
                        if (version >= 3) {
                            iAlixPay.r03(com.alipay.sdk.m.k.b.l, "bind_pay", null);
                        }
                        if (version >= 2) {
                            HashMap<String, String> a2 = com.alipay.sdk.m.s.a.a(aVar);
                            a2.put("ts_bind", String.valueOf(elapsedRealtime2));
                            a2.put("ts_bend", String.valueOf(elapsedRealtime3));
                            a2.put("ts_pay", String.valueOf(elapsedRealtime));
                            Pay = iAlixPay.pay02(str, a2);
                        } else {
                            Pay = iAlixPay.Pay(str);
                        }
                        String str3 = Pay;
                        try {
                            iAlixPay.unregisterCallback(eVar);
                        } catch (Throwable th3) {
                            com.alipay.sdk.m.u.e.a(th3);
                        }
                        try {
                            this.a.getApplicationContext().unbindService(fVar2);
                        } catch (Throwable th4) {
                            com.alipay.sdk.m.u.e.a(th4);
                        }
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                        this.b = null;
                        if (this.d && (activity3 = this.a) != null) {
                            activity3.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return new Pair<>(str3, Boolean.FALSE);
                    } catch (Throwable th5) {
                        th = th5;
                        fVar = fVar2;
                        try {
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                            Pair<String, Boolean> pair2 = new Pair<>("failed", Boolean.TRUE);
                            if (eVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(eVar);
                                } catch (Throwable th6) {
                                    com.alipay.sdk.m.u.e.a(th6);
                                }
                            }
                            try {
                                this.a.getApplicationContext().unbindService(fVar);
                            } catch (Throwable th7) {
                                com.alipay.sdk.m.u.e.a(th7);
                            }
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                            this.b = null;
                            if (this.d && (activity2 = this.a) != null) {
                                activity2.setRequestedOrientation(0);
                                this.d = false;
                            }
                            return pair2;
                        } catch (Throwable th8) {
                            if (eVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(eVar);
                                } catch (Throwable th9) {
                                    com.alipay.sdk.m.u.e.a(th9);
                                }
                            }
                            try {
                                this.a.getApplicationContext().unbindService(fVar);
                            } catch (Throwable th10) {
                                com.alipay.sdk.m.u.e.a(th10);
                            }
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
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
                    fVar = fVar2;
                    eVar = null;
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
