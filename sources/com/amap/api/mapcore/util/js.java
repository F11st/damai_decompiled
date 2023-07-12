package com.amap.api.mapcore.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class js {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    public static HashMap<String, Long> s = new HashMap<>(36);
    public static long t = 0;
    static int u = 0;
    public static long w = 0;
    WifiManager a;
    Context i;
    ArrayList<ScanResult> b = new ArrayList<>();
    ArrayList<kx> c = new ArrayList<>();
    boolean j = false;
    StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    private volatile WifiInfo y = null;
    String o = null;
    TreeMap<Integer, ScanResult> p = null;
    public boolean q = true;
    public boolean r = false;
    ConnectivityManager v = null;
    private long z = 30000;
    volatile boolean x = false;

    public js(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.i = context;
    }

    private static boolean a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e2) {
            jy.a(e2, "Aps", "wifiSigFine");
        }
        return i2 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !kc.a(wifiInfo.getBSSID())) ? false : true;
    }

    private void d(boolean z) {
        String valueOf;
        ArrayList<ScanResult> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (kc.b() - g > DateUtils.MILLIS_PER_HOUR) {
            b();
        }
        if (this.p == null) {
            this.p = new TreeMap<>(Collections.reverseOrder());
        }
        this.p.clear();
        if (this.r && z) {
            try {
                this.c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ScanResult scanResult = this.b.get(i);
            if (kc.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                if (this.r && z) {
                    try {
                        kx kxVar = new kx(false);
                        kxVar.b = scanResult.SSID;
                        kxVar.d = scanResult.frequency;
                        kxVar.e = scanResult.timestamp;
                        kxVar.a = kx.a(scanResult.BSSID);
                        kxVar.c = (short) scanResult.level;
                        if (Build.VERSION.SDK_INT >= 17) {
                            short elapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult.timestamp / 1000)) / 1000);
                            kxVar.g = elapsedRealtime;
                            if (elapsedRealtime < 0) {
                                kxVar.g = (short) 0;
                            }
                        }
                        kxVar.f = System.currentTimeMillis();
                        this.c.add(kxVar);
                    } catch (Throwable unused2) {
                    }
                }
                if (!TextUtils.isEmpty(scanResult.SSID)) {
                    valueOf = "<unknown ssid>".equals(scanResult.SSID) ? "unkwn" : String.valueOf(i);
                    this.p.put(Integer.valueOf((scanResult.level * 25) + i), scanResult);
                }
                scanResult.SSID = valueOf;
                this.p.put(Integer.valueOf((scanResult.level * 25) + i), scanResult);
            }
        }
        this.b.clear();
        for (ScanResult scanResult2 : this.p.values()) {
            this.b.add(scanResult2);
        }
        this.p.clear();
    }

    private void e(boolean z) {
        this.l = z;
        this.m = true;
        this.n = true;
        this.z = 30000L;
    }

    public static String i() {
        return String.valueOf(kc.b() - g);
    }

    private List<ScanResult> j() {
        long b;
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    for (ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                    if (s.isEmpty() || !s.equals(hashMap)) {
                        s = hashMap;
                        b = kc.b();
                    }
                    this.o = null;
                    return scanResults;
                }
                b = kc.b();
                t = b;
                this.o = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                jy.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            WifiManager wifiManager = this.a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            jy.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private int l() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean m() {
        long b = kc.b() - d;
        if (b < 4900) {
            return false;
        }
        if (!n() || b >= 9900) {
            if (u > 1) {
                long j = this.z;
                if (j == 30000) {
                    j = jx.b() != -1 ? jx.b() : 30000L;
                }
                if (Build.VERSION.SDK_INT >= 28 && b < j) {
                    return false;
                }
            }
            if (this.a != null) {
                d = kc.b();
                int i = u;
                if (i < 2) {
                    u = i + 1;
                }
                return this.a.startScan();
            }
            return false;
        }
        return false;
    }

    private boolean n() {
        if (this.v == null) {
            this.v = (ConnectivityManager) kc.a(this.i, "connectivity");
        }
        return a(this.v);
    }

    private boolean o() {
        if (this.a == null) {
            return false;
        }
        return kc.c(this.i);
    }

    private void p() {
        if (s()) {
            long b = kc.b();
            if (b - e >= 10000) {
                this.b.clear();
                h = g;
            }
            q();
            if (b - e >= 10000) {
                for (int i = 20; i > 0 && g == h; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void q() {
        if (s()) {
            try {
                if (m()) {
                    f = kc.b();
                }
            } catch (Throwable th) {
                jy.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void r() {
        if (h != g) {
            List<ScanResult> list = null;
            try {
                list = j();
            } catch (Throwable th) {
                jy.a(th, "WifiManager", "updateScanResult");
            }
            h = g;
            if (list == null) {
                this.b.clear();
                return;
            }
            this.b.clear();
            this.b.addAll(list);
        }
    }

    private boolean s() {
        boolean o = o();
        this.q = o;
        if (o && this.l) {
            if (f == 0) {
                return true;
            }
            if (kc.b() - f >= 4900 && kc.b() - g >= 1500) {
                kc.b();
                return true;
            }
        }
        return false;
    }

    public final ArrayList<ScanResult> a() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void a(boolean z) {
        Context context = this.i;
        if (!jx.a() || !this.n || this.a == null || context == null || !z || kc.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) ka.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                ka.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            jy.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (kc.a(com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == 1) {
                return a(wifiManager.getConnectionInfo());
            }
            return false;
        } catch (Throwable th) {
            jy.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b() {
        this.y = null;
        this.b.clear();
    }

    public final void b(boolean z) {
        if (z) {
            p();
        } else {
            q();
        }
        boolean z2 = false;
        if (this.x) {
            this.x = false;
            b();
        }
        r();
        if (kc.b() - g > 20000) {
            this.b.clear();
        }
        e = kc.b();
        if (this.b.isEmpty()) {
            g = kc.b();
            List<ScanResult> j = j();
            if (j != null) {
                this.b.addAll(j);
                z2 = true;
            }
        }
        d(z2);
    }

    public final void c() {
        if (this.a != null && kc.b() - g > 4900) {
            g = kc.b();
        }
    }

    public final void c(boolean z) {
        e(z);
    }

    public final void d() {
        int i;
        if (this.a == null) {
            return;
        }
        try {
            i = l();
        } catch (Throwable th) {
            jy.a(th, "Aps", "onReceive part");
            i = 4;
        }
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        if (i == 0 || i == 1 || i == 4) {
            this.x = true;
        }
    }

    public final boolean e() {
        return this.q;
    }

    public final WifiInfo f() {
        this.y = k();
        return this.y;
    }

    public final boolean g() {
        return this.j;
    }

    public final void h() {
        b();
        this.b.clear();
    }
}
