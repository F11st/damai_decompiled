package tb;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class l73 {
    static long A;
    public static HashMap<String, Long> B = new HashMap<>(36);
    public static long C = 0;
    static int D = 0;
    public static long E = 0;
    static long w;
    static long x;
    static long y;
    public static long z;
    WifiManager a;
    Context d;
    com.loc.d1 p;
    private com.loc.ek u;
    ArrayList<com.loc.y0> b = new ArrayList<>();
    ArrayList<com.loc.y0> c = new ArrayList<>();
    boolean e = false;
    StringBuilder f = null;
    boolean g = true;
    boolean h = true;
    boolean i = true;
    private volatile WifiInfo j = null;
    String k = null;
    TreeMap<Integer, com.loc.y0> l = null;
    public boolean m = true;
    public boolean n = true;
    public boolean o = false;
    String q = "";
    long r = 0;
    ConnectivityManager s = null;
    private long t = 30000;
    volatile boolean v = false;

    public l73(Context context, WifiManager wifiManager, Handler handler) {
        this.a = wifiManager;
        this.d = context;
        com.loc.d1 d1Var = new com.loc.d1(context, "wifiAgee", handler);
        this.p = d1Var;
        d1Var.c();
    }

    public static String A() {
        return String.valueOf(com.loc.m1.B() - z);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0087 A[Catch: all -> 0x0101, SecurityException -> 0x010c, TryCatch #2 {SecurityException -> 0x010c, all -> 0x0101, blocks: (B:4:0x0005, B:6:0x000f, B:8:0x0025, B:10:0x002b, B:12:0x0034, B:13:0x0038, B:15:0x003e, B:16:0x0050, B:18:0x0058, B:23:0x006e, B:25:0x0087, B:27:0x0091, B:29:0x0097, B:31:0x009f, B:33:0x00af, B:37:0x00ba, B:39:0x00dc, B:41:0x00ed, B:42:0x00ef, B:43:0x00fb, B:20:0x0060, B:21:0x0066, B:22:0x0069, B:7:0x0016), top: B:50:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f A[Catch: all -> 0x0101, SecurityException -> 0x010c, TryCatch #2 {SecurityException -> 0x010c, all -> 0x0101, blocks: (B:4:0x0005, B:6:0x000f, B:8:0x0025, B:10:0x002b, B:12:0x0034, B:13:0x0038, B:15:0x003e, B:16:0x0050, B:18:0x0058, B:23:0x006e, B:25:0x0087, B:27:0x0091, B:29:0x0097, B:31:0x009f, B:33:0x00af, B:37:0x00ba, B:39:0x00dc, B:41:0x00ed, B:42:0x00ef, B:43:0x00fb, B:20:0x0060, B:21:0x0066, B:22:0x0069, B:7:0x0016), top: B:50:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.loc.y0> C() {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.l73.C():java.util.List");
    }

    private int D() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean E() {
        long B2 = com.loc.m1.B() - w;
        if (B2 < 4900) {
            return false;
        }
        if (!F() || B2 >= 9900) {
            if (D > 1) {
                long j = this.t;
                if (j == 30000) {
                    j = com.loc.i1.D() != -1 ? com.loc.i1.D() : 30000L;
                }
                if (Build.VERSION.SDK_INT >= 28 && B2 < j) {
                    return false;
                }
            }
            if (this.a != null) {
                w = com.loc.m1.B();
                int i = D;
                if (i < 2) {
                    D = i + 1;
                }
                if (com.loc.m1.N(this.d, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                    return this.a.startScan();
                }
                com.loc.j1.h(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
            }
            return false;
        }
        return false;
    }

    private boolean F() {
        if (this.s == null) {
            this.s = (ConnectivityManager) com.loc.m1.h(this.d, "connectivity");
        }
        return h(this.s);
    }

    private boolean G() {
        if (this.a == null) {
            return false;
        }
        return com.loc.m1.Y(this.d);
    }

    private void H() {
        if (b()) {
            long B2 = com.loc.m1.B();
            if (B2 - x >= 10000) {
                this.b.clear();
                A = z;
            }
            I();
            if (B2 - x >= 10000) {
                for (int i = 20; i > 0 && z == A; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void I() {
        if (b()) {
            try {
                if (E()) {
                    y = com.loc.m1.B();
                }
            } catch (Throwable th) {
                com.loc.j1.h(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void J() {
        if (A != z) {
            List<com.loc.y0> list = null;
            try {
                list = C();
            } catch (Throwable th) {
                com.loc.j1.h(th, "WifiManager", "updateScanResult");
            }
            A = z;
            if (list == null) {
                this.b.clear();
                return;
            }
            this.b.clear();
            this.b.addAll(list);
        }
    }

    private void K() {
        try {
            if (this.a == null) {
                return;
            }
            int D2 = D();
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (D2 == 0 || D2 == 1 || D2 == 4) {
                r();
            }
        } catch (Throwable unused) {
        }
    }

    private void a() {
        try {
            if (com.loc.m1.N(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.n = this.a.isWifiEnabled();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean b() {
        this.m = G();
        a();
        if (this.m && this.g) {
            if (y == 0) {
                return true;
            }
            if (com.loc.m1.B() - y >= 4900 && com.loc.m1.B() - z >= 1500) {
                com.loc.m1.B();
                return true;
            }
        }
        return false;
    }

    private static boolean g(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            com.loc.j1.h(e, "Aps", "wifiSigFine");
        }
        return i2 > 0;
    }

    public static boolean i(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !com.loc.m1.s(wifiInfo.getBSSID())) ? false : true;
    }

    public static long j() {
        return ((com.loc.m1.B() - C) / 1000) + 1;
    }

    private void o(boolean z2) {
        String valueOf;
        ArrayList<com.loc.y0> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.loc.m1.B() - z > DateUtils.MILLIS_PER_HOUR) {
            r();
        }
        if (this.l == null) {
            this.l = new TreeMap<>(Collections.reverseOrder());
        }
        this.l.clear();
        if (this.o && z2) {
            try {
                this.c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.b.size();
        this.r = 0L;
        for (int i = 0; i < size; i++) {
            com.loc.y0 y0Var = this.b.get(i);
            if (y0Var.h) {
                this.r = y0Var.f;
            }
            if (com.loc.m1.s(com.loc.y0.c(y0Var.a)) && (size <= 20 || g(y0Var.c))) {
                if (this.o && z2) {
                    this.c.add(y0Var);
                }
                if (!TextUtils.isEmpty(y0Var.b)) {
                    valueOf = "<unknown ssid>".equals(y0Var.b) ? "unkwn" : String.valueOf(i);
                    this.l.put(Integer.valueOf((y0Var.c * 25) + i), y0Var);
                }
                y0Var.b = valueOf;
                this.l.put(Integer.valueOf((y0Var.c * 25) + i), y0Var);
            }
        }
        this.b.clear();
        for (com.loc.y0 y0Var2 : this.l.values()) {
            this.b.add(y0Var2);
        }
        this.l.clear();
    }

    public final long B() {
        return this.r;
    }

    public final ArrayList<com.loc.y0> c() {
        if (this.o) {
            k(true);
            return this.c;
        }
        return this.c;
    }

    public final void d(com.loc.ek ekVar) {
        this.u = ekVar;
    }

    public final void e(boolean z2) {
        Context context = this.d;
        if (!com.loc.i1.C() || !this.i || this.a == null || context == null || !z2 || com.loc.m1.K() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) com.loc.k1.e("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                com.loc.k1.e("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            com.loc.j1.h(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final void f(boolean z2, boolean z3, boolean z4, long j) {
        this.g = z2;
        this.h = z3;
        this.i = z4;
        if (j < 10000) {
            this.t = 10000L;
        } else {
            this.t = j;
        }
    }

    public final boolean h(ConnectivityManager connectivityManager) {
        try {
            if (com.loc.m1.f(com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == 1) {
                return i(l());
            }
            return false;
        } catch (Throwable th) {
            com.loc.j1.h(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void k(boolean z2) {
        if (z2) {
            H();
        } else {
            I();
        }
        boolean z3 = false;
        if (this.v) {
            this.v = false;
            K();
        }
        J();
        if (com.loc.m1.B() - z > 20000) {
            this.b.clear();
        }
        x = com.loc.m1.B();
        if (this.b.isEmpty()) {
            z = com.loc.m1.B();
            List<com.loc.y0> C2 = C();
            if (C2 != null) {
                this.b.addAll(C2);
                z3 = true;
            }
        }
        o(z3);
    }

    public final WifiInfo l() {
        try {
            if (this.a != null) {
                if (com.loc.m1.N(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    return this.a.getConnectionInfo();
                }
                com.loc.j1.h(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.loc.j1.h(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final void m(boolean z2) {
        r();
        this.b.clear();
        this.p.g(z2);
    }

    public final String n() {
        return this.k;
    }

    public final ArrayList<com.loc.y0> p() {
        if (this.b == null) {
            return null;
        }
        ArrayList<com.loc.y0> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void q() {
        try {
            this.o = true;
            List<com.loc.y0> C2 = C();
            if (C2 != null) {
                this.b.clear();
                this.b.addAll(C2);
            }
            o(true);
        } catch (Throwable unused) {
        }
    }

    public final void r() {
        this.j = null;
        this.b.clear();
    }

    public final void s() {
        E = System.currentTimeMillis();
        com.loc.ek ekVar = this.u;
        if (ekVar != null) {
            ekVar.l();
        }
    }

    public final void t() {
        if (this.a != null && com.loc.m1.B() - z > 4900) {
            z = com.loc.m1.B();
        }
    }

    public final void u() {
        if (this.a == null) {
            return;
        }
        this.v = true;
    }

    public final boolean v() {
        return this.m;
    }

    public final boolean w() {
        return this.n;
    }

    public final WifiInfo x() {
        this.j = l();
        return this.j;
    }

    public final boolean y() {
        return this.e;
    }

    public final String z() {
        boolean z2;
        String str;
        StringBuilder sb = this.f;
        if (sb == null) {
            this.f = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.e = false;
        int size = this.b.size();
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i < size) {
            String c = com.loc.y0.c(this.b.get(i).a);
            if (!this.h && !"<unknown ssid>".equals(this.b.get(i).b)) {
                z3 = true;
            }
            if (TextUtils.isEmpty(this.q) || !this.q.equals(c)) {
                z2 = z4;
                str = "nb";
            } else {
                str = pl2.TAG_ACCESS;
                z2 = true;
            }
            this.f.append(String.format(Locale.US, "#%s,%s", c, str));
            i++;
            z4 = z2;
        }
        if (this.b.size() == 0) {
            z3 = true;
        }
        if (!this.h && !z3) {
            this.e = true;
        }
        if (!z4 && !TextUtils.isEmpty(this.q)) {
            StringBuilder sb2 = this.f;
            sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb2.append(this.q);
            this.f.append(",access");
        }
        return this.f.toString();
    }
}
