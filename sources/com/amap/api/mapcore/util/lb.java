package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.youku.playerservice.axp.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class lb {
    private static boolean v;
    TelephonyManager d;
    CellLocation f;
    private Context l;
    private kz p;
    private Object q;
    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback t;
    private ky w;
    int a = 0;
    ArrayList<la> b = new ArrayList<>();
    ArrayList<ks> c = new ArrayList<>();
    private String m = null;
    private ArrayList<la> n = new ArrayList<>();
    private int o = -113;
    long e = 0;
    private int r = 0;
    private long s = 0;
    boolean g = false;
    PhoneStateListener h = null;
    private boolean u = false;
    String i = null;
    boolean j = false;
    StringBuilder k = null;
    private boolean x = false;
    private Object y = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @SuppressLint({"NewApi"})
    /* loaded from: classes10.dex */
    public class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            lb.d(lb.this);
            CellLocation a = lb.this.a(list);
            if (a != null) {
                lb lbVar = lb.this;
                lbVar.f = a;
                lbVar.g = true;
                lbVar.r();
                lb.this.s = kc.b();
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
                if (lb.this.w != null) {
                    lb.this.w.a();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            try {
                if (lb.this.a(cellLocation)) {
                    lb lbVar = lb.this;
                    lbVar.f = cellLocation;
                    lbVar.g = true;
                    lbVar.r();
                    lb.this.s = kc.b();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    lb.this.b();
                } else if (state != 1) {
                } else {
                    lb.this.i();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            int i2 = -113;
            try {
                int i3 = lb.this.a;
                if (i3 == 1 || i3 == 2) {
                    i2 = kc.a(i);
                }
                lb.this.b(i2);
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength == null) {
                return;
            }
            int i = -113;
            try {
                int i2 = lb.this.a;
                if (i2 == 1) {
                    i = kc.a(signalStrength.getGsmSignalStrength());
                } else if (i2 == 2) {
                    i = signalStrength.getCdmaDbm();
                }
                lb.this.b(i);
                if (lb.this.w != null) {
                    lb.this.w.a();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public lb(Context context) {
        this.d = null;
        this.p = null;
        this.l = context;
        this.d = (TelephonyManager) kc.a(context, "phone");
        k();
        this.p = new kz();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        CellLocation cellLocation;
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = ka.a(obj, str, objArr);
            cellLocation = a2 != null ? (CellLocation) a2 : null;
        } catch (Throwable unused) {
        }
        if (b(cellLocation)) {
            return cellLocation;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    public synchronized CellLocation a(List<CellInfo> list) {
        CdmaCellLocation cdmaCellLocation;
        CdmaCellLocation cdmaCellLocation2;
        CdmaCellLocation cdmaCellLocation3 = null;
        if (list != null) {
            if (!list.isEmpty()) {
                la laVar = null;
                for (int i = 0; i < list.size(); i++) {
                    CellInfo cellInfo = list.get(i);
                    if (cellInfo != null) {
                        try {
                            laVar = a(cellInfo);
                            if (laVar != null) {
                                break;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
                if (laVar != null) {
                    try {
                        if (laVar.k == 2) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(laVar.i, laVar.e, laVar.f, laVar.g, laVar.h);
                            } catch (Throwable unused2) {
                            }
                        } else {
                            GsmCellLocation gsmCellLocation = new GsmCellLocation();
                            try {
                                gsmCellLocation.setLacAndCid(laVar.c, laVar.d);
                                cdmaCellLocation2 = gsmCellLocation;
                            } catch (Throwable unused3) {
                                cdmaCellLocation3 = gsmCellLocation;
                                cdmaCellLocation = null;
                            }
                        }
                    } catch (Throwable unused4) {
                        cdmaCellLocation = cdmaCellLocation3;
                    }
                    CdmaCellLocation cdmaCellLocation4 = cdmaCellLocation3;
                    cdmaCellLocation3 = cdmaCellLocation;
                    cdmaCellLocation2 = cdmaCellLocation4;
                } else {
                    cdmaCellLocation2 = null;
                }
                return cdmaCellLocation3 == null ? cdmaCellLocation2 : cdmaCellLocation3;
            }
        }
        return null;
    }

    private static la a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        la laVar = new la(i, z);
        laVar.a = i2;
        laVar.b = i3;
        laVar.c = i4;
        laVar.d = i5;
        laVar.j = i6;
        return laVar;
    }

    private la a(CellInfo cellInfo) {
        boolean isRegistered = cellInfo.isRegistered();
        if (cellInfo instanceof CellInfoCdma) {
            return a((CellInfoCdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoGsm) {
            return a((CellInfoGsm) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoWcdma) {
            return a((CellInfoWcdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoLte) {
            return a((CellInfoLte) cellInfo, isRegistered);
        }
        return null;
    }

    private la a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a2 = kc.a(this.d);
                try {
                    i = Integer.parseInt(a2[0]);
                    try {
                        i3 = Integer.parseInt(a2[1]);
                        i2 = i;
                    } catch (Throwable unused) {
                        i2 = i;
                        i3 = 0;
                        la a3 = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a3.g = cellIdentity2.getSystemId();
                        a3.h = cellIdentity2.getNetworkId();
                        a3.i = cellIdentity2.getBasestationId();
                        a3.e = cellIdentity2.getLatitude();
                        a3.f = cellIdentity2.getLongitude();
                        return a3;
                    }
                } catch (Throwable unused2) {
                    i = 0;
                }
                la a32 = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a32.g = cellIdentity2.getSystemId();
                a32.h = cellIdentity2.getNetworkId();
                a32.i = cellIdentity2.getBasestationId();
                a32.e = cellIdentity2.getLatitude();
                a32.f = cellIdentity2.getLongitude();
                return a32;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private static la a(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm != null && cellInfoGsm.getCellIdentity() != null) {
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
            }
        }
        return null;
    }

    private static la a(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte != null && cellInfoLte.getCellIdentity() != null) {
            CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
            if (c(cellIdentity.getTac()) && d(cellIdentity.getCi())) {
                la a2 = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
                a2.o = cellIdentity.getPci();
                return a2;
            }
        }
        return null;
    }

    private static la a(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma != null && cellInfoWcdma.getCellIdentity() != null) {
            CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                la a2 = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
                a2.o = cellIdentity.getPsc();
                return a2;
            }
        }
        return null;
    }

    private la a(CellLocation cellLocation, String[] strArr) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        la laVar = new la(1, true);
        laVar.a = kc.d(strArr[0]);
        laVar.b = kc.d(strArr[1]);
        laVar.c = gsmCellLocation.getLac();
        laVar.d = gsmCellLocation.getCid();
        laVar.j = this.o;
        return laVar;
    }

    private static la a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            la laVar = new la(1, false);
            laVar.a = Integer.parseInt(strArr[0]);
            laVar.b = Integer.parseInt(strArr[1]);
            laVar.c = ka.b(neighboringCellInfo, "getLac", new Object[0]);
            laVar.d = neighboringCellInfo.getCid();
            laVar.j = kc.a(neighboringCellInfo.getRssi());
            return laVar;
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private synchronized void a(CellLocation cellLocation, String[] strArr, boolean z) {
        la a2;
        if (cellLocation != null) {
            if (this.d != null) {
                this.b.clear();
                if (b(cellLocation)) {
                    this.a = 1;
                    this.b.add(a(cellLocation, strArr));
                    if (Build.VERSION.SDK_INT <= 28) {
                        List<NeighboringCellInfo> list = (List) ka.a(this.d, "getNeighboringCellInfo", new Object[0]);
                        if (list != null && !list.isEmpty()) {
                            for (NeighboringCellInfo neighboringCellInfo : list) {
                                if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (a2 = a(neighboringCellInfo, strArr)) != null && !this.b.contains(a2)) {
                                    this.b.add(a2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static boolean a(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i) {
        ArrayList<la> arrayList;
        if (i == -113) {
            this.o = -113;
            return;
        }
        this.o = i;
        int i2 = this.a;
        if ((i2 == 1 || i2 == 2) && (arrayList = this.b) != null && !arrayList.isEmpty()) {
            try {
                this.b.get(0).j = this.o;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.telephony.CellLocation r5, java.lang.String[] r6) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            java.util.ArrayList<com.amap.api.mapcore.util.la> r0 = r4.b
            r0.clear()
            java.lang.Object r0 = r4.q     // Catch: java.lang.Throwable -> Lb4
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L38
            java.lang.Class r0 = r5.getClass()     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "mGsmCellLoc"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch: java.lang.Throwable -> L34
            boolean r3 = r0.isAccessible()     // Catch: java.lang.Throwable -> L34
            if (r3 != 0) goto L21
            r0.setAccessible(r1)     // Catch: java.lang.Throwable -> L34
        L21:
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Throwable -> L34
            android.telephony.gsm.GsmCellLocation r0 = (android.telephony.gsm.GsmCellLocation) r0     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L34
            boolean r3 = r4.b(r0)     // Catch: java.lang.Throwable -> L34
            if (r3 == 0) goto L34
            r4.a(r0, r6, r2)     // Catch: java.lang.Throwable -> L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 == 0) goto L38
            return
        L38:
            boolean r0 = r4.b(r5)     // Catch: java.lang.Throwable -> Lb4
            if (r0 != 0) goto L3f
            return
        L3f:
            r0 = 2
            r4.a = r0     // Catch: java.lang.Throwable -> Lb4
            com.amap.api.mapcore.util.la r3 = new com.amap.api.mapcore.util.la     // Catch: java.lang.Throwable -> Lb4
            r3.<init>(r0, r1)     // Catch: java.lang.Throwable -> Lb4
            r0 = r6[r2]     // Catch: java.lang.Throwable -> Lb4
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> Lb4
            r3.a = r0     // Catch: java.lang.Throwable -> Lb4
            r6 = r6[r1]     // Catch: java.lang.Throwable -> Lb4
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> Lb4
            r3.b = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "getSystemId"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb4
            int r6 = com.amap.api.mapcore.util.ka.b(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb4
            r3.g = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "getNetworkId"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb4
            int r6 = com.amap.api.mapcore.util.ka.b(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb4
            r3.h = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "getBaseStationId"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb4
            int r6 = com.amap.api.mapcore.util.ka.b(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb4
            r3.i = r6     // Catch: java.lang.Throwable -> Lb4
            int r6 = r4.o     // Catch: java.lang.Throwable -> Lb4
            r3.j = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "getBaseStationLatitude"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb4
            int r6 = com.amap.api.mapcore.util.ka.b(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb4
            r3.e = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "getBaseStationLongitude"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb4
            int r5 = com.amap.api.mapcore.util.ka.b(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb4
            r3.f = r5     // Catch: java.lang.Throwable -> Lb4
            int r6 = r3.e     // Catch: java.lang.Throwable -> Lb4
            if (r6 != r5) goto L94
            if (r6 <= 0) goto L94
            goto L95
        L94:
            r1 = 0
        L95:
            if (r6 < 0) goto La2
            if (r5 < 0) goto La2
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r0) goto La2
            if (r5 == r0) goto La2
            if (r1 == 0) goto La6
        La2:
            r3.e = r2     // Catch: java.lang.Throwable -> Lb4
            r3.f = r2     // Catch: java.lang.Throwable -> Lb4
        La6:
            java.util.ArrayList<com.amap.api.mapcore.util.la> r5 = r4.b     // Catch: java.lang.Throwable -> Lb4
            boolean r5 = r5.contains(r3)     // Catch: java.lang.Throwable -> Lb4
            if (r5 != 0) goto Lb3
            java.util.ArrayList<com.amap.api.mapcore.util.la> r5 = r4.b     // Catch: java.lang.Throwable -> Lb4
            r5.add(r3)     // Catch: java.lang.Throwable -> Lb4
        Lb3:
            return
        Lb4:
            r5 = move-exception
            java.lang.String r6 = "CgiManager"
            java.lang.String r0 = "hdlCdmaLocChange"
            com.amap.api.mapcore.util.jy.a(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.lb.b(android.telephony.CellLocation, java.lang.String[]):void");
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private int c(CellLocation cellLocation) {
        if (this.j || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            jy.a(th, Utils.TAG, "getCellLocT");
            return 0;
        }
    }

    private static boolean c(int i) {
        return (i == -1 || i == 0 || i > 65535) ? false : true;
    }

    private static boolean d(int i) {
        return (i == -1 || i == 0 || i == 65535 || i >= 268435455) ? false : true;
    }

    static /* synthetic */ boolean d(lb lbVar) {
        lbVar.u = true;
        return true;
    }

    private void k() {
        Object a2;
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager == null) {
            return;
        }
        try {
            this.a = c(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getCellLocation(telephonyManager));
        } catch (SecurityException e) {
            this.i = e.getMessage();
        } catch (Throwable th) {
            this.i = null;
            jy.a(th, "CgiManager", "CgiManager");
            this.a = 0;
        }
        try {
            int w = w();
            this.r = w;
            if (w != 1) {
                a2 = kc.a(w != 2 ? this.l : this.l, "phone2");
            } else {
                a2 = kc.a(this.l, "phone_msim");
            }
            this.q = a2;
        } catch (Throwable unused) {
        }
        hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.lb.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (lb.this.y) {
                    if (!lb.this.x) {
                        lb.this.l();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int i;
        this.h = new b();
        try {
            i = ka.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            i = 0;
        }
        if (i == 0) {
            try {
                this.d.listen(this.h, 16);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        try {
            this.d.listen(this.h, i | 16);
        } catch (Throwable unused3) {
        }
    }

    private CellLocation m() {
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getCellLocation(telephonyManager);
                this.i = null;
                if (b(cellLocation)) {
                    this.f = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e) {
                this.i = e.getMessage();
            } catch (Throwable th) {
                this.i = null;
                jy.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean n() {
        return !this.j && kc.b() - this.e >= 10000;
    }

    private void o() {
        i();
    }

    private synchronized void p() {
        int f = f();
        if (f != 1) {
            if (f == 2 && this.b.isEmpty()) {
                this.a = 0;
            }
        } else if (this.b.isEmpty()) {
            this.a = 0;
        }
    }

    @SuppressLint({"NewApi"})
    private synchronized void q() {
        if (!this.j && this.d != null) {
            if (Build.VERSION.SDK_INT >= 29 && this.l.getApplicationInfo().targetSdkVersion >= 29) {
                if (this.t == null) {
                    this.t = new a();
                }
                this.d.requestCellInfoUpdate(hd.d(), this.t);
            }
            CellLocation s = s();
            if (!b(s)) {
                s = t();
            }
            if (b(s)) {
                this.f = s;
                this.s = kc.b();
            } else if (kc.b() - this.s > DateUtils.MILLIS_PER_MINUTE) {
                this.f = null;
                this.b.clear();
                this.n.clear();
            }
        }
        this.g = true;
        if (b(this.f)) {
            r();
        }
        try {
            if (kc.c() >= 18) {
                v();
            }
        } catch (Throwable unused) {
        }
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.a |= 8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() {
        String[] a2 = kc.a(this.d);
        int c = c(this.f);
        if (c == 1) {
            a(this.f, a2, false);
            return;
        }
        if (c == 2) {
            b(this.f, a2);
        }
    }

    @SuppressLint({"NewApi"})
    private CellLocation s() {
        TelephonyManager telephonyManager = this.d;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        if (kc.c() >= 18) {
            try {
                cellLocation = a(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(telephonyManager));
            } catch (SecurityException e) {
                this.i = e.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation m = m();
        if (b(m)) {
            return m;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        return a2 != null ? a2 : a(telephonyManager, "getCellLocationGemini", 1);
    }

    private CellLocation t() {
        if (!v) {
            v = true;
        }
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> u = u();
            if (u.isInstance(obj)) {
                Object cast = u.cast(obj);
                CellLocation a2 = a(cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                CellLocation a3 = a(cast, "getCellLocation", 1);
                if (a3 != null) {
                    return a3;
                }
                CellLocation a4 = a(cast, "getCellLocationGemini", 1);
                if (a4 != null) {
                    return a4;
                }
                cellLocation = a(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private Class<?> u() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i = this.r;
        try {
            return systemClassLoader.loadClass(i != 0 ? i != 1 ? i != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            jy.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v() {
        /*
            r11 = this;
            android.telephony.TelephonyManager r0 = r11.d
            if (r0 != 0) goto L5
            return
        L5:
            java.util.ArrayList<com.amap.api.mapcore.util.la> r1 = r11.n
            com.amap.api.mapcore.util.kz r2 = r11.p
            r3 = 0
            java.util.List r0 = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(r0)     // Catch: java.lang.SecurityException -> L13
            r11.i = r3     // Catch: java.lang.SecurityException -> L11
            goto L1d
        L11:
            r3 = move-exception
            goto L17
        L13:
            r0 = move-exception
            r10 = r3
            r3 = r0
            r0 = r10
        L17:
            java.lang.String r3 = r3.getMessage()
            r11.i = r3
        L1d:
            if (r0 == 0) goto L51
            int r3 = r0.size()
            if (r3 == 0) goto L51
            if (r1 == 0) goto L2a
            r1.clear()
        L2a:
            r4 = 0
        L2b:
            if (r4 >= r3) goto L51
            java.lang.Object r5 = r0.get(r4)
            android.telephony.CellInfo r5 = (android.telephony.CellInfo) r5
            if (r5 == 0) goto L4e
            com.amap.api.mapcore.util.la r5 = r11.a(r5)     // Catch: java.lang.Throwable -> L4e
            if (r5 != 0) goto L3c
            goto L4e
        L3c:
            r6 = 65535(0xffff, double:3.23786E-319)
            long r8 = r2.a(r5)     // Catch: java.lang.Throwable -> L4e
            long r6 = java.lang.Math.min(r6, r8)     // Catch: java.lang.Throwable -> L4e
            int r7 = (int) r6     // Catch: java.lang.Throwable -> L4e
            short r6 = (short) r7     // Catch: java.lang.Throwable -> L4e
            r5.l = r6     // Catch: java.lang.Throwable -> L4e
            r1.add(r5)     // Catch: java.lang.Throwable -> L4e
        L4e:
            int r4 = r4 + 1
            goto L2b
        L51:
            if (r1 == 0) goto L62
            int r0 = r1.size()
            if (r0 <= 0) goto L62
            int r0 = r11.a
            r0 = r0 | 4
            r11.a = r0
            r2.a(r1)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.lb.v():void");
    }

    private int w() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.r = 1;
        } catch (Throwable unused) {
        }
        if (this.r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.r = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<ks> a() {
        kt ktVar;
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(this.d);
        if (Build.VERSION.SDK_INT >= 17) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    kt ktVar2 = new kt(cellInfo.isRegistered(), true);
                    ktVar2.m = cellIdentity.getLatitude();
                    ktVar2.n = cellIdentity.getLongitude();
                    ktVar2.j = cellIdentity.getSystemId();
                    ktVar2.k = cellIdentity.getNetworkId();
                    ktVar2.l = cellIdentity.getBasestationId();
                    ktVar2.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    ktVar2.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    ktVar = ktVar2;
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    ku kuVar = new ku(cellInfo.isRegistered(), true);
                    kuVar.a = String.valueOf(cellIdentity2.getMcc());
                    kuVar.b = String.valueOf(cellIdentity2.getMnc());
                    kuVar.j = cellIdentity2.getLac();
                    kuVar.k = cellIdentity2.getCid();
                    kuVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    kuVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        kuVar.m = cellIdentity2.getArfcn();
                        kuVar.n = cellIdentity2.getBsic();
                    }
                    arrayList.add(kuVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    kv kvVar = new kv(cellInfo.isRegistered());
                    kvVar.a = String.valueOf(cellIdentity3.getMcc());
                    kvVar.b = String.valueOf(cellIdentity3.getMnc());
                    kvVar.l = cellIdentity3.getPci();
                    kvVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    kvVar.k = cellIdentity3.getCi();
                    kvVar.m = cellIdentity3.getEarfcn();
                    kvVar.j = cellIdentity3.getTac();
                    kvVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    kvVar.c = cellInfoLte.getCellSignalStrength().getDbm();
                    ktVar = kvVar;
                    if (Build.VERSION.SDK_INT >= 24) {
                        kvVar.m = cellIdentity3.getEarfcn();
                        ktVar = kvVar;
                    }
                } else {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        kw kwVar = new kw(cellInfo.isRegistered(), true);
                        kwVar.a = String.valueOf(cellIdentity4.getMcc());
                        kwVar.b = String.valueOf(cellIdentity4.getMnc());
                        kwVar.j = cellIdentity4.getLac();
                        kwVar.k = cellIdentity4.getCid();
                        kwVar.l = cellIdentity4.getPsc();
                        kwVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        kwVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i >= 24) {
                            kwVar.m = cellIdentity4.getUarfcn();
                        }
                        arrayList.add(kwVar);
                    }
                }
                arrayList.add(ktVar);
            }
        }
        return arrayList;
    }

    final boolean a(CellLocation cellLocation) {
        String str;
        boolean z = false;
        if (cellLocation == null) {
            return false;
        }
        int c = c(cellLocation);
        if (c == 1) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (Throwable th) {
                th = th;
                str = "cgiUseful Cgi.I_GSM_T";
            }
        } else if (c != 2) {
            return true;
        } else {
            try {
                if (ka.b(cellLocation, "getSystemId", new Object[0]) > 0 && ka.b(cellLocation, "getNetworkId", new Object[0]) >= 0) {
                    if (ka.b(cellLocation, "getBaseStationId", new Object[0]) >= 0) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_CDMA_T";
            }
        }
        jy.a(th, "CgiManager", str);
        return true;
    }

    public final synchronized void b() {
        try {
            try {
                this.j = kc.a(this.l);
                if (n() || this.b.isEmpty()) {
                    q();
                    this.e = kc.b();
                }
                if (this.j) {
                    o();
                } else {
                    p();
                }
            } catch (SecurityException e) {
                this.i = e.getMessage();
            }
        }
    }

    public final synchronized ArrayList<la> c() {
        return this.b;
    }

    public final ArrayList<la> d() {
        return this.n;
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.a & 3;
    }

    public final TelephonyManager g() {
        return this.d;
    }

    public final void h() {
        PhoneStateListener phoneStateListener;
        this.p.a();
        this.s = 0L;
        synchronized (this.y) {
            this.x = true;
        }
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null && (phoneStateListener = this.h) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                jy.a(th, "CgiManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            }
        }
        this.h = null;
        this.o = -113;
        this.d = null;
        this.q = null;
    }

    final synchronized void i() {
        this.i = null;
        this.f = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String j() {
        return this.m;
    }
}
