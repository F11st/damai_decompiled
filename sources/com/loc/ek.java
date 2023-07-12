package com.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.loc.v0;
import com.uc.webview.export.extension.UCCore;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;
import org.apache.commons.lang3.time.DateUtils;
import tb.c73;
import tb.d73;
import tb.g53;
import tb.i53;
import tb.l73;
import tb.m53;
import tb.s63;
import tb.t43;
import tb.t73;
import tb.u43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ek implements ee {
    private static long k;
    Context a;
    private Handler c;
    x0 f;
    private LocationManager g;
    private a h;
    u43 i;
    private ArrayList<m53> b = new ArrayList<>();
    l73 d = null;
    c1 e = null;
    private volatile boolean j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements LocationListener {
        private ek a;

        a(ek ekVar) {
            this.a = ekVar;
        }

        final void a() {
            this.a = null;
        }

        final void b(ek ekVar) {
            this.a = ekVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                ek ekVar = this.a;
                if (ekVar != null) {
                    ekVar.e(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b extends ck {
        private int b;
        private Location c;

        b(int i) {
            this.b = 0;
            this.b = i;
        }

        b(ek ekVar, Location location) {
            this(1);
            this.c = location;
        }

        private void b() {
            try {
                if (this.c == null || !ek.this.j || m1.f0(ek.this.a)) {
                    return;
                }
                Bundle extras = this.c.getExtras();
                int i = extras != null ? extras.getInt("satellites") : 0;
                if (m1.p(this.c, i)) {
                    return;
                }
                l73 l73Var = ek.this.d;
                if (l73Var != null && !l73Var.o) {
                    l73Var.q();
                }
                ArrayList<y0> c = ek.this.d.c();
                List<dr> i2 = ek.this.e.i();
                v0.a aVar = new v0.a();
                s63 s63Var = new s63();
                s63Var.g = this.c.getAccuracy();
                s63Var.d = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(this.c);
                s63Var.b = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(this.c);
                s63Var.f = this.c.getBearing();
                s63Var.c = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(this.c);
                this.c.isFromMockProvider();
                this.c.getProvider();
                s63Var.e = this.c.getSpeed();
                s63Var.i = (byte) i;
                System.currentTimeMillis();
                s63Var.a = this.c.getTime();
                s63Var.h = this.c.getTime();
                aVar.a = s63Var;
                aVar.b = c;
                WifiInfo l = ek.this.d.l();
                if (l != null) {
                    aVar.c = y0.a(l.getBSSID());
                }
                aVar.d = l73.E;
                aVar.f = this.c.getTime();
                aVar.g = (byte) o.Z(ek.this.a);
                aVar.h = o.e0(ek.this.a);
                aVar.e = ek.this.d.v();
                aVar.j = m1.n(ek.this.a);
                aVar.i = i2;
                m53 d = x0.d(aVar);
                if (d == null) {
                    return;
                }
                synchronized (ek.this.b) {
                    ek.this.b.add(d);
                    if (ek.this.b.size() >= 5) {
                        ek.this.s();
                    }
                }
                ek.this.r();
            } catch (Throwable th) {
                j1.h(th, "cl", "coll");
            }
        }

        private void c() {
            if (m1.f0(ek.this.a)) {
                return;
            }
            v vVar = null;
            try {
                long unused = ek.k = System.currentTimeMillis();
                if (ek.this.i.f.e()) {
                    vVar = v.b(new File(ek.this.i.a), ek.this.i.b);
                    ArrayList arrayList = new ArrayList();
                    byte[] t = ek.t();
                    if (t == null) {
                        try {
                            vVar.close();
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    List k = ek.k(vVar, ek.this.i, arrayList, t);
                    if (k != null && k.size() != 0) {
                        ek.this.i.f.b(true);
                        if (x0.f(v1.u(x0.h(e1.d(t), p1.h(t, x0.g(), v1.w()), k)))) {
                            ek.m(vVar, arrayList);
                        }
                    }
                    try {
                        vVar.close();
                        return;
                    } catch (Throwable unused3) {
                        return;
                    }
                }
                if (vVar != null) {
                    try {
                        vVar.close();
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable th) {
                try {
                    an.m(th, "leg", "uts");
                    if (vVar != null) {
                        try {
                            vVar.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable th2) {
                    if (vVar != null) {
                        try {
                            vVar.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // com.loc.ck
        public final void a() {
            int i = this.b;
            if (i == 1) {
                b();
            } else if (i == 2) {
                c();
            } else if (i == 3) {
                ek.this.u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(Context context) {
        this.a = null;
        this.a = context;
        u43 u43Var = new u43();
        this.i = u43Var;
        e0.e(this.a, u43Var, al.k, 100, 1024000, "0");
        u43 u43Var2 = this.i;
        int i = i1.F;
        boolean z = i1.D;
        int i2 = i1.E;
        u43Var2.f = new i53(context, i, "kKey", new g53(context, z, i2, i2 * 10, "carrierLocKey"));
        this.i.e = new n();
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    private static byte[] i(int i) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<tb.m53> k(com.loc.v r17, tb.u43 r18, java.util.List<java.lang.String> r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ek.k(com.loc.v, tb.u43, java.util.List, byte[]):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(v vVar, List<String> list) {
        if (vVar != null) {
            try {
                for (String str : list) {
                    vVar.r(str);
                }
                vVar.close();
            } catch (Throwable th) {
                an.m(th, "aps", "dlo");
            }
        }
    }

    private static byte[] n(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static byte[] q(int i) {
        return new byte[]{(byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i & 255)};
    }

    static /* synthetic */ byte[] t() {
        return i(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        ArrayList<m53> arrayList;
        try {
            if (!m1.f0(this.a) && (arrayList = this.b) != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.b) {
                    arrayList2.addAll(this.b);
                    this.b.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] i = i(256);
                if (i == null) {
                    return;
                }
                byteArrayOutputStream.write(q(i.length));
                byteArrayOutputStream.write(i);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    m53 m53Var = (m53) it.next();
                    byte[] b2 = m53Var.b();
                    if (b2.length >= 10 && b2.length <= 65535) {
                        byte[] h = p1.h(i, b2, v1.w());
                        byteArrayOutputStream.write(q(h.length));
                        byteArrayOutputStream.write(h);
                        byteArrayOutputStream.write(n(m53Var.a()));
                    }
                }
                b0.c(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.i);
            }
        } catch (Throwable th) {
            j1.h(th, "clm", "wtD");
        }
    }

    @Override // com.loc.ee
    public final d73 a(c73 c73Var) {
        try {
            t73 t73Var = new t73();
            t73Var.J(c73Var.b);
            t73Var.L(c73Var.a);
            t73Var.K(c73Var.c);
            bg.b();
            t43 c = bg.c(t73Var);
            d73 d73Var = new d73();
            d73Var.c = c.a;
            d73Var.b = c.b;
            d73Var.a = 200;
            return d73Var;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        LocationManager locationManager;
        if (m1.f0(this.a)) {
            return;
        }
        try {
            a aVar = this.h;
            if (aVar != null && (locationManager = this.g) != null) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.j) {
                u();
                this.d.d(null);
                this.e.k(null);
                this.e = null;
                this.d = null;
                this.c = null;
                this.j = false;
            }
        } catch (Throwable th) {
            j1.h(th, "clm", ReportManager.f);
        }
    }

    public final void e(Location location) {
        try {
            Handler handler = this.c;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            an.m(th, "cl", "olcc");
        }
    }

    public final void g(c1 c1Var, l73 l73Var, Handler handler) {
        LocationManager locationManager;
        if (this.j || c1Var == null || l73Var == null || handler == null || m1.f0(this.a)) {
            return;
        }
        this.j = true;
        this.e = c1Var;
        this.d = l73Var;
        l73Var.d(this);
        this.e.k(this);
        this.c = handler;
        try {
            if (this.g == null) {
                this.g = (LocationManager) this.a.getSystemService("location");
            }
            if (this.h == null) {
                this.h = new a(this);
            }
            this.h.b(this);
            a aVar = this.h;
            if (aVar != null && (locationManager = this.g) != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(locationManager, "passive", 1000L, -1.0f, aVar);
            }
            if (this.f == null) {
                x0 x0Var = new x0("6.1.0", l.j(this.a), "S128DF1572465B890OE3F7A13167KLEI", l.g(this.a), this);
                this.f = x0Var;
                x0Var.c(o.h0(this.a)).i(o.R(this.a)).l(o.w(this.a)).m(o.Q(this.a)).n(o.k0(this.a)).o(o.T(this.a)).p(Build.getMODEL()).q(Build.getMANUFACTURER()).r(Build.getBRAND()).a(Build.VERSION.SDK_INT).s(Build.VERSION.getRELEASE()).b(y0.a(o.W(this.a))).t(o.W(this.a));
                x0.j();
            }
        } catch (Throwable th) {
            j1.h(th, "col", UCCore.LEGACY_EVENT_INIT);
        }
    }

    public final void l() {
        try {
            Handler handler = this.c;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.loc.ek.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        l73 l73Var;
                        try {
                            ek ekVar = ek.this;
                            if (ekVar.f == null || (l73Var = ekVar.d) == null) {
                                return;
                            }
                            x0.k(l73Var.c());
                        } catch (Throwable th) {
                            j1.h(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            j1.h(th, "cl", "upw");
        }
    }

    public final void o() {
        c1 c1Var;
        try {
            if (this.f == null || (c1Var = this.e) == null) {
                return;
            }
            x0.e(c1Var.i());
        } catch (Throwable th) {
            j1.h(th, "cl", "upc");
        }
    }

    public final void r() {
        try {
            if (!m1.f0(this.a) && System.currentTimeMillis() - k >= DateUtils.MILLIS_PER_MINUTE) {
                o0.f().d(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    public final void s() {
        try {
            o0.f().d(new b(3));
        } catch (Throwable unused) {
        }
    }
}
