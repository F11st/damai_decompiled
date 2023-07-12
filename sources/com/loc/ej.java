package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import tb.j73;
import tb.k73;
import tb.l73;
import tb.t43;
import tb.v73;
import tb.w73;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class ej {
    public static String[] O = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static String P = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;
    private Handler H;
    private ev I;
    boolean J;
    private String M;
    private ek N;
    Context a = null;
    ConnectivityManager b = null;
    l73 c = null;
    c1 d = null;
    f1 e = null;
    v73 f = null;
    ArrayList<y0> g = new ArrayList<>();
    a h = null;
    AMapLocationClientOption i = new AMapLocationClientOption();
    eo j = null;
    long k = 0;
    private int l = 0;
    w73 m = null;
    boolean n = false;
    private String o = null;
    h1 p = null;
    StringBuilder q = new StringBuilder();
    boolean r = true;
    boolean s = true;
    AMapLocationClientOption.GeoLanguage t = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean u = true;
    boolean v = false;
    WifiInfo w = null;
    boolean x = true;
    private String y = null;
    StringBuilder z = null;
    boolean A = false;
    int B = 12;
    private boolean C = true;
    z0 D = null;
    boolean E = false;
    j73 F = null;
    String G = null;
    IntentFilter K = null;
    LocationManager L = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            l73 l73Var;
            l73 l73Var2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (!action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || (l73Var = ej.this.c) == null) {
                        return;
                    }
                    l73Var.u();
                    return;
                }
                l73 l73Var3 = ej.this.c;
                if (l73Var3 != null) {
                    l73Var3.t();
                }
                try {
                    if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (l73Var2 = ej.this.c) == null) {
                        return;
                    }
                    l73Var2.s();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                j1.h(th, "Aps", "onReceive");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ej(boolean z) {
        this.J = false;
        this.J = z;
    }

    private void D() {
        if (this.p != null) {
            try {
                if (this.i == null) {
                    this.i = new AMapLocationClientOption();
                }
                this.p.e(this.i.getHttpTimeOut(), this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), E());
            } catch (Throwable unused) {
            }
        }
    }

    private int E() {
        int i;
        if (this.i.getGeoLanguage() != null && (i = b.a[this.i.getGeoLanguage().ordinal()]) != 1) {
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
        }
        return 0;
    }

    private void F() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z5 = true;
        try {
            geoLanguage = this.i.getGeoLanguage();
            z = this.i.isNeedAddress();
            try {
                z3 = this.i.isOffset();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z = true;
        }
        try {
            z4 = this.i.isLocationCacheEnable();
            try {
                this.v = this.i.isOnceLocationLatest();
                this.E = this.i.isSensorEnable();
                if (z3 != this.s || z != this.r || z4 != this.u || geoLanguage != this.t) {
                    M();
                }
            } catch (Throwable unused3) {
                z2 = z4;
                z5 = z3;
                boolean z6 = z2;
                z3 = z5;
                z4 = z6;
                this.s = z3;
                this.r = z;
                this.u = z4;
                this.t = geoLanguage;
            }
        } catch (Throwable unused4) {
            z5 = z3;
            z2 = true;
            boolean z62 = z2;
            z3 = z5;
            z4 = z62;
            this.s = z3;
            this.r = z;
            this.u = z4;
            this.t = geoLanguage;
        }
        this.s = z3;
        this.r = z;
        this.u = z4;
        this.t = geoLanguage;
    }

    private void G() {
        try {
            if (this.h == null) {
                this.h = new a();
            }
            if (this.K == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.K = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.K.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.a.registerReceiver(this.h, this.K);
        } catch (Throwable th) {
            j1.h(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] H() throws Throwable {
        if (this.m == null) {
            this.m = new w73();
        }
        if (this.i == null) {
            this.i = new AMapLocationClientOption();
        }
        this.m.b(this.a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.b, this.G, this.I);
        return this.m.e();
    }

    private boolean I() {
        return this.k == 0 || m1.B() - this.k > 20000;
    }

    private void J() {
        l73 l73Var = this.c;
        if (l73Var == null) {
            return;
        }
        l73Var.e(this.n);
    }

    private boolean K() {
        ArrayList<y0> p = this.c.p();
        this.g = p;
        return p == null || p.size() <= 0;
    }

    private void L() {
        if (this.y != null) {
            this.y = null;
        }
        StringBuilder sb = this.z;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void M() {
        try {
            f1 f1Var = this.e;
            if (f1Var != null) {
                f1Var.f();
            }
            y(null);
            this.C = false;
            j73 j73Var = this.F;
            if (j73Var != null) {
                j73Var.c();
            }
        } catch (Throwable th) {
            j1.h(th, "Aps", "cleanCache");
        }
    }

    private static eo b(int i, String str) {
        eo eoVar = new eo("");
        eoVar.setErrorCode(i);
        eoVar.setLocationDetail(str);
        if (i == 15) {
            l1.p(null, 2151);
        }
        return eoVar;
    }

    private eo e(eo eoVar, t43 t43Var, ei eiVar) {
        if (t43Var != null) {
            try {
                byte[] bArr = t43Var.a;
                if (bArr != null && bArr.length != 0) {
                    v73 v73Var = new v73();
                    String str = new String(t43Var.a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        eo c = v73Var.c(str, this.a, t43Var, eiVar);
                        c.h(this.z.toString());
                        return c;
                    } else if (str.contains("</body></html>")) {
                        eoVar.setErrorCode(5);
                        l73 l73Var = this.c;
                        if (l73Var == null || !l73Var.h(this.b)) {
                            eiVar.f("#0502");
                            this.q.append("请求可能被劫持了#0502");
                            l1.p(null, 2052);
                        } else {
                            eiVar.f("#0501");
                            this.q.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                            l1.p(null, 2051);
                        }
                        eoVar.setLocationDetail(this.q.toString());
                        return eoVar;
                    } else {
                        return null;
                    }
                }
            } catch (Throwable th) {
                eoVar.setErrorCode(4);
                j1.h(th, "Aps", "checkResponseEntity");
                eiVar.f("#0403");
                StringBuilder sb = this.q;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                eoVar.setLocationDetail(this.q.toString());
                return eoVar;
            }
        }
        eoVar.setErrorCode(4);
        this.q.append("网络异常,请求异常#0403");
        eiVar.f("#0403");
        eoVar.h(this.z.toString());
        eoVar.setLocationDetail(this.q.toString());
        if (t43Var != null) {
            l1.p(t43Var.d, 2041);
        }
        return eoVar;
    }

    private StringBuilder h(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.H());
        sb.append(this.c.z());
        return sb;
    }

    private boolean o(long j) {
        if (!this.C) {
            this.C = true;
            return false;
        }
        if (m1.B() - j < 800) {
            if ((m1.r(this.j) ? m1.g() - this.j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0106 A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #1 {all -> 0x01fa, blocks: (B:10:0x0052, B:12:0x007b, B:16:0x0086, B:18:0x008e, B:21:0x0096, B:22:0x0098, B:24:0x009e, B:25:0x00a8, B:29:0x00b1, B:31:0x00c4, B:33:0x00c8, B:34:0x00d2, B:37:0x00e8, B:39:0x00ee, B:41:0x00f2, B:44:0x0102, B:46:0x0106, B:42:0x00f9, B:43:0x00ff), top: B:102:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.loc.eo p(boolean r12, com.loc.ei r13) {
        /*
            Method dump skipped, instructions count: 752
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ej.p(boolean, com.loc.ei):com.loc.eo");
    }

    private void r(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(v1.v("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.n = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01be, code lost:
        if (com.loc.m1.W(r16.a) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ce, code lost:
        if (com.loc.m1.W(r16.a) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d0, code lost:
        r16.q.append("或后台运行没有后台定位权限");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d5, code lost:
        r1 = r16.q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0255, code lost:
        if (r16.x == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0290, code lost:
        if (r16.x == false) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String u(com.loc.ei r17) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ej.u(com.loc.ei):java.lang.String");
    }

    private static void w(eo eoVar) {
        if (eoVar.getErrorCode() == 0 && eoVar.getLocationType() == 0) {
            if ("-5".equals(eoVar.d()) || "1".equals(eoVar.d()) || "2".equals(eoVar.d()) || "14".equals(eoVar.d()) || "24".equals(eoVar.d()) || "-1".equals(eoVar.d())) {
                eoVar.setLocationType(5);
            } else {
                eoVar.setLocationType(6);
            }
        }
    }

    private void y(eo eoVar) {
        if (eoVar != null) {
            this.j = eoVar;
        }
    }

    public final void A() {
        ek ekVar = this.N;
        if (ekVar != null) {
            ekVar.r();
        }
    }

    public final void B() {
        try {
            if (this.a == null) {
                return;
            }
            if (this.N == null) {
                this.N = new ek(this.a);
            }
            this.N.g(this.d, this.c, this.H);
        } catch (Throwable th) {
            an.m(th, "as", ReportManager.f);
        }
    }

    public final void C() {
        ek ekVar = this.N;
        if (ekVar != null) {
            ekVar.d();
        }
    }

    public final eo a(double d, double d2) {
        try {
            String b2 = this.p.b(this.a, d, d2);
            if (b2.contains("\"status\":\"1\"")) {
                eo b3 = this.f.b(b2);
                b3.setLatitude(d);
                b3.setLongitude(d2);
                return b3;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:45|(1:47)(2:75|(1:77)(9:78|(1:80)|49|50|(2:53|(1:55)(2:56|(1:58)(2:59|(1:61)(1:62))))|63|(3:65|(1:71)(1:69)|70)|72|73))|48|49|50|(2:53|(0)(0))|63|(0)|72|73) */
    /* JADX WARN: Can't wrap try/catch for region: R(12:20|(2:22|(1:24)(1:25))|26|27|28|(6:33|34|35|36|37|(2:39|40)(2:41|(2:43|44)(10:45|(1:47)(2:75|(1:77)(9:78|(1:80)|49|50|(2:53|(1:55)(2:56|(1:58)(2:59|(1:61)(1:62))))|63|(3:65|(1:71)(1:69)|70)|72|73))|48|49|50|(2:53|(0)(0))|63|(0)|72|73)))|85|34|35|36|37|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
        com.loc.j1.h(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0164 A[Catch: all -> 0x0181, TryCatch #0 {all -> 0x0181, blocks: (B:60:0x0154, B:63:0x015a, B:65:0x0164, B:68:0x016e, B:71:0x0178, B:72:0x017d), top: B:86:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.loc.eo c(com.loc.ei r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ej.c(com.loc.ei):com.loc.eo");
    }

    public final eo d(eo eoVar) {
        this.F.d(this.u);
        return this.F.b(eoVar);
    }

    public final eo f(boolean z) {
        int i;
        String sb;
        if (this.c.y()) {
            i = 15;
            sb = "networkLocation has been mocked!#1502";
        } else if (!TextUtils.isEmpty(this.y)) {
            eo a2 = this.e.a(this.a, this.y, this.z, true, z);
            if (m1.r(a2)) {
                y(a2);
            }
            return a2;
        } else {
            i = this.B;
            sb = this.q.toString();
        }
        return b(i, sb);
    }

    public final eo g(boolean z, ei eiVar) {
        eiVar.e(z ? "statics" : ShareperfenceConstants.FIRST);
        if (this.a == null) {
            eiVar.f("#0101");
            this.q.append("context is null#0101");
            l1.p(null, 2011);
            return b(1, this.q.toString());
        } else if (this.c.y()) {
            eiVar.f("#1502");
            return b(15, "networkLocation has been mocked!#1502");
        } else {
            q();
            if (TextUtils.isEmpty(this.y)) {
                return b(this.B, this.q.toString());
            }
            eo p = p(z, eiVar);
            if (m1.r(p) && !Q) {
                this.e.k(this.z.toString());
                this.e.j(this.d.z());
                y(p);
            }
            Q = true;
            return p;
        }
    }

    public final void i() {
        c1 c1Var = this.d;
        if (c1Var != null) {
            c1Var.r();
        }
    }

    public final void j(Context context) {
        try {
            if (this.a != null) {
                return;
            }
            this.F = new j73();
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            m1.D(applicationContext);
            if (this.c == null) {
                this.c = new l73(this.a, (WifiManager) m1.h(this.a, "wifi"), this.H);
            }
            if (this.d == null) {
                this.d = new c1(this.a, this.H);
            }
            this.I = new ev(context, this.H);
            if (this.e == null) {
                this.e = new f1();
            }
            if (this.f == null) {
                this.f = new v73();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            j1.h(th, "Aps", "initBase");
        }
    }

    public final void k(Handler handler) {
        this.H = handler;
    }

    public final void l(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        k73 k73Var = new k73();
        k73Var.a = aMapLocation.getLocationType();
        k73Var.d = aMapLocation.getTime();
        k73Var.e = (int) aMapLocation.getAccuracy();
        k73Var.b = aMapLocation.getLatitude();
        k73Var.c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.I.c(k73Var);
        }
    }

    public final void m(AMapLocationClientOption aMapLocationClientOption) {
        this.i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.i = new AMapLocationClientOption();
        }
        l73 l73Var = this.c;
        if (l73Var != null) {
            this.i.isWifiActiveScan();
            l73Var.f(this.i.isWifiScan(), this.i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        D();
        f1 f1Var = this.e;
        if (f1Var != null) {
            f1Var.i(this.i);
        }
        v73 v73Var = this.f;
        if (v73Var != null) {
            v73Var.d(this.i);
        }
        F();
    }

    public final void n(eo eoVar, int i) {
        if (eoVar != null && eoVar.getErrorCode() == 0) {
            k73 k73Var = new k73();
            k73Var.d = eoVar.getTime();
            k73Var.e = (int) eoVar.getAccuracy();
            k73Var.b = eoVar.getLatitude();
            k73Var.c = eoVar.getLongitude();
            k73Var.a = i;
            k73Var.g = Integer.parseInt(eoVar.d());
            k73Var.h = eoVar.l();
            this.I.g(k73Var);
        }
    }

    public final void q() {
        this.p = h1.a(this.a);
        D();
        if (this.b == null) {
            this.b = (ConnectivityManager) m1.h(this.a, "connectivity");
        }
        if (this.m == null) {
            this.m = new w73();
        }
    }

    public final void s(ei eiVar) {
        try {
        } catch (Throwable th) {
            j1.h(th, "Aps", "initFirstLocateParam");
        }
        if (this.A) {
            return;
        }
        L();
        if (this.v) {
            G();
        }
        this.c.k(this.v);
        this.g = this.c.p();
        this.d.o(true, K());
        String u = u(eiVar);
        this.y = u;
        if (!TextUtils.isEmpty(u)) {
            this.z = h(this.z);
        }
        this.A = true;
    }

    public final void t(eo eoVar) {
        if (m1.r(eoVar)) {
            this.e.m(this.y, this.z, eoVar, this.a, true);
        }
    }

    public final void v() {
        if (this.D == null) {
            this.D = new z0(this.a);
        }
        G();
        this.c.k(false);
        this.g = this.c.p();
        this.d.o(false, K());
        this.e.g(this.a);
        r(this.a);
    }

    public final void x() {
        if (this.q.length() > 0) {
            StringBuilder sb = this.q;
            sb.delete(0, sb.length());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z() {
        /*
            r4 = this;
            r0 = 0
            r4.G = r0
            r1 = 0
            r4.A = r1
            com.loc.f1 r1 = r4.e
            if (r1 == 0) goto Lf
            android.content.Context r2 = r4.a
            r1.t(r2)
        Lf:
            tb.j73 r1 = r4.F
            if (r1 == 0) goto L16
            r1.c()
        L16:
            tb.v73 r1 = r4.f
            if (r1 == 0) goto L1c
            r4.f = r0
        L1c:
            com.loc.ev r1 = r4.I
            if (r1 == 0) goto L25
            boolean r2 = r4.J
            r1.d(r2)
        L25:
            android.content.Context r1 = r4.a     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L30
            com.loc.ej$a r2 = r4.h     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L30
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> L33
        L30:
            r4.h = r0
            goto L3c
        L33:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.loc.j1.h(r1, r2, r3)     // Catch: java.lang.Throwable -> L65
            goto L30
        L3c:
            com.loc.c1 r1 = r4.d
            if (r1 == 0) goto L45
            boolean r2 = r4.J
            r1.n(r2)
        L45:
            tb.l73 r1 = r4.c
            if (r1 == 0) goto L4e
            boolean r2 = r4.J
            r1.m(r2)
        L4e:
            java.util.ArrayList<com.loc.y0> r1 = r4.g
            if (r1 == 0) goto L55
            r1.clear()
        L55:
            com.loc.z0 r1 = r4.D
            if (r1 == 0) goto L5c
            r1.i()
        L5c:
            r4.j = r0
            r4.a = r0
            r4.z = r0
            r4.L = r0
            return
        L65:
            r1 = move-exception
            r4.h = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ej.z():void");
    }
}
