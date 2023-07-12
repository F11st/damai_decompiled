package com.amap.api.mapcore.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kl {
    Context a;
    private C4599js e;
    private lb f;
    private ju h;
    private ConnectivityManager i;
    private jw j;
    private Inner_3dMap_locationOption l;
    private C4604a g = null;
    boolean b = false;
    private StringBuilder k = new StringBuilder();
    String c = null;
    private kj m = null;
    long d = 0;
    private final String n = "\"status\":\"0\"";
    private final String o = "</body></html>";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.kl$a */
    /* loaded from: classes10.dex */
    public class C4604a extends BroadcastReceiver {
        private C4604a() {
        }

        /* synthetic */ C4604a(kl klVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (kl.this.e != null) {
                        kl.this.e.c();
                    }
                } else if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || kl.this.e == null) {
                } else {
                    kl.this.e.d();
                }
            } catch (Throwable th) {
                jy.a(th, "MapNetLocation", "onReceive");
            }
        }
    }

    public kl(Context context) {
        this.a = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        try {
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            kc.b(applicationContext);
            a(this.a);
            this.l = new Inner_3dMap_locationOption();
            if (this.e == null) {
                C4599js c4599js = new C4599js(this.a, (WifiManager) kc.a(this.a, "wifi"));
                this.e = c4599js;
                c4599js.a(this.b);
            }
            if (this.f == null) {
                this.f = new lb(this.a);
            }
            if (this.h == null) {
                gd.a(this.a);
                this.h = ju.a(this.a);
            }
            if (this.i == null) {
                this.i = (ConnectivityManager) kc.a(this.a, "connectivity");
            }
            this.j = new jw();
            c();
        } catch (Throwable th) {
            jy.a(th, "MapNetLocation", "<init>");
        }
    }

    private static kj a(kj kjVar) {
        return kf.a().a(kjVar);
    }

    private void a(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(gn.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.b = true;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(long j) {
        if (kc.b() - j < 800) {
            if ((kn.a(this.m) ? kc.a() - this.m.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        try {
            if (this.g == null) {
                this.g = new C4604a(this, (byte) 0);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.a.registerReceiver(this.g, intentFilter);
            this.e.b(false);
            this.f.b();
        } catch (Throwable th) {
            jy.a(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    private kj d() throws Exception {
        StringBuilder sb;
        String str;
        String str2 = "";
        kj kjVar = new kj("");
        C4599js c4599js = this.e;
        if (c4599js != null && c4599js.g()) {
            kjVar.setErrorCode(15);
            return kjVar;
        }
        try {
            if (this.j == null) {
                this.j = new jw();
            }
            this.j.a(this.a, this.l.isNeedAddress(), this.l.isOffset(), this.f, this.e, this.i, this.c);
            km kmVar = new km();
            byte[] bArr = null;
            try {
                try {
                    ik a = this.h.a(this.h.a(this.a, this.j.a(), jy.a(), jy.b()));
                    if (a != null) {
                        bArr = a.a;
                        str2 = a.c;
                    }
                    if (bArr == null || bArr.length == 0) {
                        kjVar.setErrorCode(4);
                        this.k.append("please check the network");
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb2 = this.k;
                            sb2.append(" #csid:" + str2);
                        }
                        kjVar.setLocationDetail(this.k.toString());
                        return kjVar;
                    }
                    String str3 = new String(bArr, "UTF-8");
                    if (str3.contains("\"status\":\"0\"")) {
                        return kmVar.a(str3, this.a, a);
                    }
                    if (str3.contains("</body></html>")) {
                        kjVar.setErrorCode(5);
                        C4599js c4599js2 = this.e;
                        if (c4599js2 == null || !c4599js2.a(this.i)) {
                            sb = this.k;
                            str = "request may be intercepted";
                        } else {
                            sb = this.k;
                            str = "make sure you are logged in to the network";
                        }
                        sb.append(str);
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb3 = this.k;
                            sb3.append(" #csid:" + str2);
                        }
                        kjVar.setLocationDetail(this.k.toString());
                        return kjVar;
                    }
                    byte[] a2 = jt.a(bArr);
                    if (a2 == null) {
                        kjVar.setErrorCode(5);
                        this.k.append("decrypt response data error");
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb4 = this.k;
                            sb4.append(" #csid:" + str2);
                        }
                        kjVar.setLocationDetail(this.k.toString());
                        return kjVar;
                    }
                    kj a3 = kmVar.a(a2);
                    this.c = a3.a();
                    if (a3.getErrorCode() != 0) {
                        if (!TextUtils.isEmpty(str2)) {
                            a3.setLocationDetail(a3.getLocationDetail() + " #csid:" + str2);
                        }
                        return a3;
                    } else if (!kn.a(a3)) {
                        String b = a3.b();
                        a3.setErrorCode(6);
                        StringBuilder sb5 = this.k;
                        StringBuilder sb6 = new StringBuilder("location faile retype:");
                        sb6.append(a3.d());
                        sb6.append(" rdesc:");
                        if (b == null) {
                            b = "null";
                        }
                        sb6.append(b);
                        sb5.append(sb6.toString());
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb7 = this.k;
                            sb7.append(" #csid:" + str2);
                        }
                        a3.setLocationDetail(this.k.toString());
                        return a3;
                    } else {
                        a3.e();
                        if (a3.getErrorCode() == 0 && a3.getLocationType() == 0) {
                            if ("-5".equals(a3.d()) || "1".equals(a3.d()) || "2".equals(a3.d()) || "14".equals(a3.d()) || "24".equals(a3.d()) || "-1".equals(a3.d())) {
                                a3.setLocationType(5);
                            } else {
                                a3.setLocationType(6);
                            }
                            this.k.append(a3.d());
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder sb8 = this.k;
                                sb8.append(" #csid:" + str2);
                            }
                            a3.setLocationDetail(this.k.toString());
                        }
                        return a3;
                    }
                } catch (Throwable th) {
                    jy.a(th, "MapNetLocation", "getApsLoc req");
                    kjVar.setErrorCode(4);
                    this.k.append("please check the network");
                    kjVar.setLocationDetail(this.k.toString());
                    return kjVar;
                }
            } catch (Throwable th2) {
                jy.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                kjVar.setErrorCode(3);
                StringBuilder sb9 = this.k;
                sb9.append("buildV4Dot2 error " + th2.getMessage());
                kjVar.setLocationDetail(this.k.toString());
                return kjVar;
            }
        } catch (Throwable th3) {
            jy.a(th3, "MapNetLocation", "getApsLoc");
            StringBuilder sb10 = this.k;
            sb10.append("get parames error:" + th3.getMessage());
            kjVar.setErrorCode(3);
            kjVar.setLocationDetail(this.k.toString());
            return kjVar;
        }
    }

    public final Inner_3dMap_location a() {
        if (this.k.length() > 0) {
            StringBuilder sb = this.k;
            sb.delete(0, sb.length());
        }
        if (a(this.d) && kn.a(this.m)) {
            return this.m;
        }
        this.d = kc.b();
        if (this.a == null) {
            this.k.append("context is null");
            Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.k.toString());
            return inner_3dMap_location;
        }
        try {
            this.f.b();
        } catch (Throwable th) {
            jy.a(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.e.b(true);
        } catch (Throwable th2) {
            jy.a(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            kj d = d();
            this.m = d;
            this.m = a(d);
        } catch (Throwable th3) {
            jy.a(th3, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.m;
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.l = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.l = new Inner_3dMap_locationOption();
        }
        try {
            C4599js c4599js = this.e;
            this.l.isWifiActiveScan();
            c4599js.c(this.l.isWifiScan());
        } catch (Throwable unused) {
        }
        try {
            this.h.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
        } catch (Throwable unused2) {
        }
    }

    public final void b() {
        C4604a c4604a;
        this.b = false;
        this.c = null;
        try {
            Context context = this.a;
            if (context != null && (c4604a = this.g) != null) {
                context.unregisterReceiver(c4604a);
            }
            lb lbVar = this.f;
            if (lbVar != null) {
                lbVar.h();
            }
            C4599js c4599js = this.e;
            if (c4599js != null) {
                c4599js.h();
            }
            this.g = null;
        } catch (Throwable unused) {
            this.g = null;
        }
    }
}
