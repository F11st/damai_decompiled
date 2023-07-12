package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class c1 {
    private Context a;
    TelephonyManager g;
    private a1 h;
    SignalStrength k;
    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback m;
    private ek t;
    private boolean b = false;
    private boolean c = false;
    ArrayList<b1> d = new ArrayList<>();
    private String e = null;
    private ArrayList<b1> f = new ArrayList<>();
    private long i = 0;
    PhoneStateListener j = null;
    private Object l = new Object();
    private boolean n = false;
    boolean o = false;
    StringBuilder p = null;
    private String q = null;
    private String r = null;
    String s = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @SuppressLint({"NewApi"})
    /* loaded from: classes10.dex */
    public class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                if (m1.B() - c1.this.i < 500) {
                    return;
                }
                c1.t(c1.this);
                c1.this.j(c1.this.O());
                c1.this.m(list);
                c1.this.i = m1.B();
            } catch (SecurityException e) {
                c1.this.s = e.getMessage();
            } catch (Throwable th) {
                j1.h(th, "Cgi", "cellInfo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                if (c1.this.t != null) {
                    c1.this.t.o();
                }
                if (m1.B() - c1.this.i < 500) {
                    return;
                }
                c1.this.j(c1.this.O());
                c1.this.m(list);
                c1.this.i = m1.B();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            if (m1.B() - c1.this.i < 500) {
                return;
            }
            try {
                c1.this.j(cellLocation);
                c1.this.m(c1.this.P());
                c1.this.i = m1.B();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    c1.this.o(false, false);
                } else if (state != 1) {
                } else {
                    c1.this.E();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength == null) {
                return;
            }
            c1 c1Var = c1.this;
            c1Var.k = signalStrength;
            try {
                if (c1Var.t != null) {
                    c1.this.t.o();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public c1(Context context, Handler handler) {
        this.g = null;
        this.h = null;
        this.a = context;
        this.g = (TelephonyManager) m1.h(context, "phone");
        J();
        a1 a1Var = new a1(context, "cellAge", handler);
        this.h = a1Var;
        a1Var.c();
    }

    private void J() {
        if (this.g == null) {
            return;
        }
        K();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066 A[Catch: Exception -> 0x006c, TRY_LEAVE, TryCatch #0 {Exception -> 0x006c, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x001b, B:10:0x0023, B:11:0x0026, B:16:0x0031, B:20:0x0040, B:26:0x004e, B:30:0x0057, B:34:0x005d, B:35:0x0060, B:36:0x0062, B:38:0x0066), top: B:43:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void K() {
        /*
            r8 = this;
            android.telephony.PhoneStateListener r0 = r8.j     // Catch: java.lang.Exception -> L6c
            if (r0 != 0) goto Lb
            com.loc.c1$b r0 = new com.loc.c1$b     // Catch: java.lang.Exception -> L6c
            r0.<init>()     // Catch: java.lang.Exception -> L6c
            r8.j = r0     // Catch: java.lang.Exception -> L6c
        Lb:
            r0 = 320(0x140, float:4.48E-43)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L6c
            java.lang.String r2 = "hasFineLocPerm"
            java.lang.String r3 = "hasNoFineLocPerm"
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            r5 = 336(0x150, float:4.71E-43)
            r6 = 31
            if (r1 < r6) goto L29
            android.content.Context r7 = r8.a     // Catch: java.lang.Exception -> L6c
            int r7 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L6c
            if (r7 != 0) goto L26
            r8.r = r2     // Catch: java.lang.Exception -> L6c
            goto L29
        L26:
            r8.r = r3     // Catch: java.lang.Exception -> L6c
            goto L2b
        L29:
            r0 = 336(0x150, float:4.71E-43)
        L2b:
            r5 = 17
            if (r1 < r5) goto L62
            if (r1 < r6) goto L60
            android.content.Context r1 = r8.a     // Catch: java.lang.Exception -> L6c
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            int r1 = r1.checkSelfPermission(r5)     // Catch: java.lang.Exception -> L6c
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L3f
            r1 = 1
            goto L40
        L3f:
            r1 = 0
        L40:
            android.content.Context r7 = r8.a     // Catch: java.lang.Exception -> L6c
            int r4 = r7.checkSelfPermission(r4)     // Catch: java.lang.Exception -> L6c
            if (r4 != 0) goto L49
            goto L4a
        L49:
            r5 = 0
        L4a:
            if (r1 == 0) goto L50
            if (r5 == 0) goto L50
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L50:
            if (r1 == 0) goto L55
            java.lang.String r1 = "hasReadPhoneStatePerm"
            goto L57
        L55:
            java.lang.String r1 = "hasNoReadPhoneStatePerm"
        L57:
            r8.q = r1     // Catch: java.lang.Exception -> L6c
            if (r5 == 0) goto L5c
            goto L5d
        L5c:
            r2 = r3
        L5d:
            r8.r = r2     // Catch: java.lang.Exception -> L6c
            goto L62
        L60:
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L62:
            android.telephony.PhoneStateListener r1 = r8.j     // Catch: java.lang.Exception -> L6c
            if (r1 == 0) goto L6b
            android.telephony.TelephonyManager r2 = r8.g     // Catch: java.lang.Exception -> L6c
            r2.listen(r1, r0)     // Catch: java.lang.Exception -> L6c
        L6b:
            return
        L6c:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.c1.K():void");
    }

    private int L() {
        b1 z = z();
        if (z != null) {
            return z.l;
        }
        return 0;
    }

    private CellLocation M() {
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getCellLocation(telephonyManager);
                this.s = null;
                return cellLocation;
            } catch (SecurityException e) {
                this.s = e.getMessage();
            } catch (Throwable th) {
                this.s = null;
                j1.h(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean N() {
        return !this.o && m1.B() - this.i >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation O() {
        if (this.g == null) {
            return null;
        }
        return M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> P() {
        TelephonyManager telephonyManager;
        List<CellInfo> list;
        try {
            if (m1.K() >= 18 && (telephonyManager = this.g) != null) {
                try {
                    list = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(telephonyManager);
                } catch (SecurityException e) {
                    e = e;
                    list = null;
                }
                try {
                    this.s = null;
                } catch (SecurityException e2) {
                    e = e2;
                    this.s = e.getMessage();
                    return list;
                }
                return list;
            }
            return null;
        } catch (Throwable th) {
            j1.h(th, "Cgi", "getNewCells");
            return null;
        }
    }

    private static b1 c(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        b1 b1Var = new b1(i, z);
        b1Var.a = i2;
        b1Var.b = i3;
        b1Var.c = i4;
        b1Var.d = i5;
        b1Var.k = i6;
        return b1Var;
    }

    private b1 d(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] y = m1.y(this.g);
                try {
                    i = Integer.parseInt(y[0]);
                    try {
                        i3 = Integer.parseInt(y[1]);
                        i2 = i;
                    } catch (Throwable unused) {
                        i2 = i;
                        i3 = 0;
                        b1 c = c(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        c.h = cellIdentity2.getSystemId();
                        c.i = cellIdentity2.getNetworkId();
                        c.j = cellIdentity2.getBasestationId();
                        c.f = cellIdentity2.getLatitude();
                        c.g = cellIdentity2.getLongitude();
                        c.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                        return c;
                    }
                } catch (Throwable unused2) {
                    i = 0;
                }
                b1 c2 = c(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                c2.h = cellIdentity2.getSystemId();
                c2.i = cellIdentity2.getNetworkId();
                c2.j = cellIdentity2.getBasestationId();
                c2.f = cellIdentity2.getLatitude();
                c2.g = cellIdentity2.getLongitude();
                c2.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return c2;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private static b1 e(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        b1 c = c(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        c.o = cellInfoGsm.getCellIdentity().getBsic();
        c.p = cellInfoGsm.getCellIdentity().getArfcn();
        c.q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        c.s = cellInfoGsm.getCellSignalStrength().getDbm();
        return c;
    }

    private static b1 f(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        b1 c = c(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        c.o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            c.p = cellIdentity.getEarfcn();
        }
        c.q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        c.s = cellInfoLte.getCellSignalStrength().getDbm();
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.loc.b1 g(android.telephony.CellInfoNr r14, boolean r15) {
        /*
            if (r14 == 0) goto L95
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            if (r0 != 0) goto La
            goto L95
        La:
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            android.telephony.CellIdentityNr r0 = (android.telephony.CellIdentityNr) r0
            int r1 = r0.getTac()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r1 != r2) goto L33
            java.lang.String r2 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER()
            java.lang.String r4 = "HUAWEI"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L33
            java.lang.String r2 = "getHwTac"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2f
            int r1 = com.loc.k1.f(r0, r2, r4)     // Catch: java.lang.Throwable -> L2f
            goto L33
        L2f:
            r2 = move-exception
            r2.printStackTrace()
        L33:
            long r4 = r0.getNci()
            java.lang.String r2 = r0.getMccString()     // Catch: java.lang.Throwable -> L4c
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r6 = r0.getMncString()     // Catch: java.lang.Throwable -> L4a
            int r3 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L4a
            r9 = r2
            r10 = r3
            goto L53
        L4a:
            r6 = move-exception
            goto L4e
        L4c:
            r6 = move-exception
            r2 = 0
        L4e:
            r6.printStackTrace()
            r9 = r2
            r10 = 0
        L53:
            android.telephony.CellSignalStrength r2 = r14.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r2 = (android.telephony.CellSignalStrengthNr) r2
            int r13 = r2.getSsRsrp()
            r7 = 5
            int r11 = r0.getTac()
            r12 = 0
            r8 = r15
            com.loc.b1 r15 = c(r7, r8, r9, r10, r11, r12, r13)
            r15.e = r4
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r2) goto L75
            r15.c = r3
            goto L7e
        L75:
            if (r1 <= r3) goto L7c
            r15.c = r3
            r15.q = r1
            goto L7e
        L7c:
            r15.c = r1
        L7e:
            int r1 = r0.getPci()
            r15.o = r1
            int r0 = r0.getNrarfcn()
            r15.p = r0
            android.telephony.CellSignalStrength r14 = r14.getCellSignalStrength()
            int r14 = r14.getDbm()
            r15.s = r14
            return r15
        L95:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.c1.g(android.telephony.CellInfoNr, boolean):com.loc.b1");
    }

    private static b1 h(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        b1 c = c(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        c.o = cellIdentity.getPsc();
        c.p = cellInfoWcdma.getCellIdentity().getUarfcn();
        c.s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(CellLocation cellLocation) {
        String[] y = m1.y(this.g);
        this.d.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            b1 b1Var = new b1(1, true);
            b1Var.a = m1.S(y[0]);
            b1Var.b = m1.S(y[1]);
            b1Var.c = gsmCellLocation.getLac();
            b1Var.d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.k;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                b1Var.s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : q(gsmSignalStrength);
            }
            b1Var.r = false;
            this.h.d(b1Var);
            this.d.add(b1Var);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            b1 b1Var2 = new b1(2, true);
            b1Var2.a = Integer.parseInt(y[0]);
            b1Var2.b = Integer.parseInt(y[1]);
            b1Var2.f = cdmaCellLocation.getBaseStationLatitude();
            b1Var2.g = cdmaCellLocation.getBaseStationLongitude();
            b1Var2.h = cdmaCellLocation.getSystemId();
            b1Var2.i = cdmaCellLocation.getNetworkId();
            b1Var2.j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.k;
            if (signalStrength2 != null) {
                b1Var2.s = signalStrength2.getCdmaDbm();
            }
            b1Var2.r = false;
            this.h.d(b1Var2);
            this.d.add(b1Var2);
        }
    }

    public static boolean p(int i) {
        return i > 0 && i <= 15;
    }

    private static int q(int i) {
        return (i * 2) - 113;
    }

    @SuppressLint({"NewApi"})
    private void s(boolean z, boolean z2) {
        if (!this.o && this.g != null && Build.VERSION.SDK_INT >= 29 && this.a.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.m == null) {
                this.m = new a();
            }
            this.g.requestCellInfoUpdate(o0.f().c(), this.m);
            if (z2 || z) {
                for (int i = 0; !this.n && i < 20; i++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.c = false;
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.e = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.c = true;
            }
        }
        this.i = m1.B();
    }

    static /* synthetic */ boolean t(c1 c1Var) {
        c1Var.n = true;
        return true;
    }

    public final synchronized b1 A() {
        if (this.o) {
            return null;
        }
        ArrayList<b1> arrayList = this.f;
        if (arrayList.size() > 0) {
            Iterator<b1> it = arrayList.iterator();
            while (it.hasNext()) {
                b1 next = it.next();
                if (next.n) {
                    return next.clone();
                }
            }
            return arrayList.get(0).clone();
        }
        return null;
    }

    public final int B() {
        return L() | (this.b ? 4 : 0) | (this.c ? 8 : 0);
    }

    public final int C() {
        return L() & 3;
    }

    public final TelephonyManager D() {
        return this.g;
    }

    final synchronized void E() {
        this.s = null;
        this.d.clear();
        this.f.clear();
        this.b = false;
        this.c = false;
    }

    public final String F() {
        return this.s;
    }

    public final String G() {
        return this.e;
    }

    public final synchronized String H() {
        if (this.o) {
            E();
        }
        StringBuilder sb = this.p;
        if (sb == null) {
            this.p = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (C() == 1) {
            for (int i = 1; i < this.d.size(); i++) {
                StringBuilder sb2 = this.p;
                sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                sb2.append(this.d.get(i).b);
                StringBuilder sb3 = this.p;
                sb3.append("|");
                sb3.append(this.d.get(i).c);
                StringBuilder sb4 = this.p;
                sb4.append("|");
                sb4.append(this.d.get(i).d);
            }
        }
        for (int i2 = 1; i2 < this.f.size(); i2++) {
            b1 b1Var = this.f.get(i2);
            int i3 = b1Var.l;
            if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
                if (i3 == 2) {
                    StringBuilder sb5 = this.p;
                    sb5.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb5.append(b1Var.l);
                    StringBuilder sb6 = this.p;
                    sb6.append("|");
                    sb6.append(b1Var.a);
                    StringBuilder sb7 = this.p;
                    sb7.append("|");
                    sb7.append(b1Var.h);
                    StringBuilder sb8 = this.p;
                    sb8.append("|");
                    sb8.append(b1Var.i);
                    StringBuilder sb9 = this.p;
                    sb9.append("|");
                    sb9.append(b1Var.j);
                }
            }
            StringBuilder sb10 = this.p;
            sb10.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb10.append(b1Var.l);
            StringBuilder sb11 = this.p;
            sb11.append("|");
            sb11.append(b1Var.a);
            StringBuilder sb12 = this.p;
            sb12.append("|");
            sb12.append(b1Var.b);
            StringBuilder sb13 = this.p;
            sb13.append("|");
            sb13.append(b1Var.c);
            StringBuilder sb14 = this.p;
            sb14.append("|");
            sb14.append(b1Var.a());
        }
        if (this.p.length() > 0) {
            this.p.deleteCharAt(0);
        }
        return this.p.toString();
    }

    public final boolean I() {
        try {
            TelephonyManager telephonyManager = this.g;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperator(telephonyManager))) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.g.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int f = m1.f(m1.L(this.a));
            return f == 0 || f == 4 || f == 2 || f == 5 || f == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<dr> i() {
        ds dsVar;
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(this.g);
        if (Build.VERSION.SDK_INT >= 17 && allCellInfo != null) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    ds dsVar2 = new ds(cellInfo.isRegistered(), true);
                    dsVar2.m = cellIdentity.getLatitude();
                    dsVar2.n = cellIdentity.getLongitude();
                    dsVar2.j = cellIdentity.getSystemId();
                    dsVar2.k = cellIdentity.getNetworkId();
                    dsVar2.l = cellIdentity.getBasestationId();
                    dsVar2.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    dsVar2.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    dsVar = dsVar2;
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    dt dtVar = new dt(cellInfo.isRegistered(), true);
                    dtVar.a = String.valueOf(cellIdentity2.getMcc());
                    dtVar.b = String.valueOf(cellIdentity2.getMnc());
                    dtVar.j = cellIdentity2.getLac();
                    dtVar.k = cellIdentity2.getCid();
                    dtVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    dtVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        dtVar.m = cellIdentity2.getArfcn();
                        dtVar.n = cellIdentity2.getBsic();
                    }
                    arrayList.add(dtVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    du duVar = new du(cellInfo.isRegistered());
                    duVar.a = String.valueOf(cellIdentity3.getMcc());
                    duVar.b = String.valueOf(cellIdentity3.getMnc());
                    duVar.l = cellIdentity3.getPci();
                    duVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    duVar.k = cellIdentity3.getCi();
                    duVar.j = cellIdentity3.getTac();
                    duVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    duVar.c = cellInfoLte.getCellSignalStrength().getDbm();
                    dsVar = duVar;
                    if (Build.VERSION.SDK_INT >= 24) {
                        duVar.m = cellIdentity3.getEarfcn();
                        dsVar = duVar;
                    }
                } else {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        dv dvVar = new dv(cellInfo.isRegistered(), true);
                        dvVar.a = String.valueOf(cellIdentity4.getMcc());
                        dvVar.b = String.valueOf(cellIdentity4.getMnc());
                        dvVar.j = cellIdentity4.getLac();
                        dvVar.k = cellIdentity4.getCid();
                        dvVar.l = cellIdentity4.getPsc();
                        dvVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        dvVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i >= 24) {
                            dvVar.m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(dvVar);
                    }
                }
                arrayList.add(dsVar);
            }
        }
        return arrayList;
    }

    public final void k(ek ekVar) {
        this.t = ekVar;
    }

    final synchronized void m(List<CellInfo> list) {
        ArrayList<b1> arrayList = this.f;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                CellInfo cellInfo = list.get(i);
                if (cellInfo != null) {
                    b1 b1Var = null;
                    boolean isRegistered = cellInfo.isRegistered();
                    if (cellInfo instanceof CellInfoCdma) {
                        b1Var = d((CellInfoCdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoGsm) {
                        b1Var = e((CellInfoGsm) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        b1Var = h((CellInfoWcdma) cellInfo, isRegistered);
                    } else if (cellInfo instanceof CellInfoLte) {
                        b1Var = f((CellInfoLte) cellInfo, isRegistered);
                    } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                        b1Var = g((CellInfoNr) cellInfo, isRegistered);
                    }
                    if (b1Var != null) {
                        this.h.d(b1Var);
                        b1Var.m = (short) Math.min(65535L, this.h.r(b1Var));
                        b1Var.r = true;
                        this.f.add(b1Var);
                    }
                }
            }
            this.b = false;
            ArrayList<b1> arrayList2 = this.f;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.b = true;
            }
        }
    }

    public final void n(boolean z) {
        PhoneStateListener phoneStateListener;
        this.h.g(z);
        this.i = 0L;
        synchronized (this.l) {
        }
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null && (phoneStateListener = this.j) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                j1.h(th, "CgiManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            }
        }
        this.j = null;
        this.k = null;
        this.g = null;
    }

    public final void o(boolean z, boolean z2) {
        try {
            this.o = m1.n(this.a);
            if (N()) {
                s(z, z2);
                j(O());
                m(P());
            }
            if (this.o) {
                E();
            }
        } catch (SecurityException e) {
            this.s = e.getMessage();
        } catch (Throwable th) {
            j1.h(th, "CgiManager", "refresh");
        }
    }

    public final void r() {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z2 = true;
                if (!TextUtils.isEmpty(this.r) && !this.r.equals(str)) {
                    z = true;
                }
                if (TextUtils.isEmpty(this.q) || this.q.equals(str2)) {
                    z2 = z;
                }
                if (z2) {
                    K();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized ArrayList<b1> v() {
        ArrayList<b1> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<b1> arrayList2 = this.d;
        if (arrayList2 != null) {
            Iterator<b1> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<b1> w() {
        ArrayList<b1> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<b1> arrayList2 = this.f;
        if (arrayList2 != null) {
            Iterator<b1> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized b1 z() {
        if (this.o) {
            return null;
        }
        ArrayList<b1> arrayList = this.d;
        if (arrayList.size() > 0) {
            return arrayList.get(0).clone();
        }
        return null;
    }
}
