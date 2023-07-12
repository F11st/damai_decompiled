package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class w73 {
    protected static String Q;
    protected static String R;
    public String a = "1";
    protected short b = 0;
    protected String c = null;
    protected String d = null;
    protected String e = null;
    protected String f = null;
    protected String g = null;
    public String h = null;
    public String i = null;
    protected String j = null;
    protected String k = null;
    protected String l = null;
    protected String m = null;
    protected String n = null;
    protected String o = null;
    protected String p = null;
    protected String q = null;
    protected String r = null;
    protected String s = null;
    protected String t = null;
    protected String u = null;
    protected String v = null;
    protected String w = null;
    protected String x = null;
    protected String y = null;
    protected int z = 0;
    protected ArrayList<com.loc.b1> A = new ArrayList<>();
    protected ArrayList<com.loc.b1> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<com.loc.y0> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] I = null;
    private int J = 0;
    protected String K = null;
    protected String L = null;
    protected String M = null;
    protected int N = 0;
    private List<k73> O = null;
    private List<com.loc.b1> P = Collections.synchronizedList(new ArrayList());

    private static int a(String str, byte[] bArr, int i) {
        try {
        } catch (Throwable th) {
            com.loc.j1.h(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
        if (TextUtils.isEmpty(str)) {
            bArr[i] = 0;
            return i + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        if (length > 127) {
            length = 127;
        }
        bArr[i] = (byte) length;
        int i2 = i + 1;
        System.arraycopy(bytes, 0, bArr, i2, length);
        return i2 + length;
    }

    private static void c(com.loc.b1 b1Var, List<com.loc.b1> list) {
        if (b1Var == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(b1Var);
            return;
        }
        long j = AbsPerformance.LONG_NIL;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= size) {
                i2 = i3;
                break;
            }
            com.loc.b1 b1Var2 = list.get(i);
            if (b1Var.c() == null || !b1Var.c().equals(b1Var2.c())) {
                j = Math.min(j, b1Var2.t);
                if (j == b1Var2.t) {
                    i3 = i;
                }
                i++;
            } else {
                int i4 = b1Var.s;
                if (i4 != b1Var2.s) {
                    b1Var2.t = b1Var.t;
                    b1Var2.s = i4;
                }
            }
        }
        if (i2 >= 0) {
            if (size < 3) {
                list.add(b1Var);
            } else if (b1Var.t <= j || i2 >= size) {
            } else {
                list.remove(i2);
                list.add(b1Var);
            }
        }
    }

    private void d(ArrayList<com.loc.b1> arrayList, ArrayList<com.loc.b1> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.loc.b1> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.loc.b1 next = it.next();
                if (next.r && next.n) {
                    c(next, this.P);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        c(arrayList.get(0), this.P);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0.length != 6) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] f(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto Lf
            int r4 = r0.length     // Catch: java.lang.Throwable -> L3e
            if (r4 == r1) goto L1b
        Lf:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L3e
            r4 = 0
        L12:
            if (r4 >= r1) goto L1b
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch: java.lang.Throwable -> L3e
            int r4 = r4 + 1
            goto L12
        L1b:
            r1 = 0
        L1c:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L3e
            if (r1 >= r4) goto L50
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L3e
            r5 = 2
            if (r4 <= r5) goto L30
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = r4.substring(r3, r5)     // Catch: java.lang.Throwable -> L3e
            r0[r1] = r4     // Catch: java.lang.Throwable -> L3e
        L30:
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.Throwable -> L3e
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L3e
            r2[r1] = r4     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 + 1
            goto L1c
        L3e:
            r0 = move-exception
            java.lang.String r1 = "getMacBa "
            java.lang.String r7 = r1.concat(r7)
            java.lang.String r1 = "Req"
            com.loc.j1.h(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.f(r7)
        L50:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.w73.f(java.lang.String):byte[]");
    }

    private void g() {
        String[] strArr = new String[27];
        strArr[0] = this.a;
        strArr[1] = this.c;
        strArr[2] = this.d;
        strArr[3] = this.e;
        strArr[4] = this.f;
        strArr[5] = this.g;
        strArr[6] = this.h;
        strArr[7] = this.i;
        strArr[8] = this.l;
        strArr[9] = this.m;
        strArr[10] = this.n;
        strArr[11] = this.o;
        strArr[12] = this.p;
        strArr[13] = this.q;
        strArr[14] = this.r;
        strArr[15] = this.s;
        strArr[16] = this.t;
        strArr[17] = this.u;
        strArr[18] = this.v;
        strArr[19] = this.w;
        strArr[20] = this.x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = Q;
        strArr[25] = this.L;
        strArr[26] = this.M;
        for (int i = 0; i < 27; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                strArr[i] = "";
            }
        }
        if (TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j))) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k))) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y))) {
            this.y = "0";
        }
        if (!com.loc.c1.p(this.z)) {
            this.z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    public final void b(Context context, boolean z, boolean z2, com.loc.c1 c1Var, l73 l73Var, ConnectivityManager connectivityManager, String str, com.loc.ev evVar) {
        String str2;
        String str3;
        StringBuilder sb;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<com.loc.y0> arrayList;
        int i;
        String j = com.loc.l.j(context);
        int P = com.loc.m1.P();
        this.K = str;
        this.O = null;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str7 = str3;
        String str8 = str2;
        StringBuilder sb2 = new StringBuilder();
        int B = c1Var.B();
        int C = c1Var.C();
        TelephonyManager D = c1Var.D();
        ArrayList<com.loc.b1> v = c1Var.v();
        ArrayList<com.loc.b1> w = c1Var.w();
        ArrayList<com.loc.y0> p = l73Var.p();
        String str9 = C == 2 ? "1" : "0";
        if (D != null) {
            if (TextUtils.isEmpty(com.loc.j1.g)) {
                try {
                    com.loc.j1.g = com.loc.o.h0(context);
                } catch (Throwable th) {
                    str4 = "1";
                    com.loc.j1.h(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            sb = sb2;
            if (TextUtils.isEmpty(com.loc.j1.g) && Build.VERSION.SDK_INT < 29) {
                com.loc.j1.g = "888888888888888";
            }
            if (TextUtils.isEmpty(com.loc.j1.h)) {
                try {
                    com.loc.j1.h = com.loc.o.k0(context);
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    com.loc.j1.h(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(com.loc.j1.h) && Build.VERSION.SDK_INT < 29) {
                com.loc.j1.h = "888888888888888";
            }
        } else {
            sb = sb2;
            str4 = "1";
        }
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Throwable th3) {
            com.loc.j1.h(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean h = l73Var.h(connectivityManager);
        if (com.loc.m1.f(networkInfo) != -1) {
            str5 = com.loc.m1.k(context, D);
            str6 = h ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        if ((B & 4) != 4 || w.isEmpty()) {
            this.B.clear();
        } else {
            this.B.clear();
            this.B.addAll(w);
        }
        this.A.clear();
        this.A.addAll(v);
        StringBuilder sb3 = new StringBuilder();
        if (l73Var.v()) {
            if (h) {
                WifiInfo x = l73Var.x();
                if (l73.i(x)) {
                    sb3.append(x.getBSSID());
                    sb3.append(",");
                    int rssi = x.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = x.getSSID();
                    try {
                        i = x.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i = 32;
                    }
                    if (i >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace(jn1.MUL, "."));
                }
            }
            if (p != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(p);
            }
        } else {
            l73Var.r();
            ArrayList<com.loc.y0> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str8;
        this.d = str7;
        this.f = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        this.g = "android" + Build.VERSION.getRELEASE();
        this.h = com.loc.m1.D(context);
        this.i = str9;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = j;
        this.p = com.loc.j1.g;
        this.q = com.loc.j1.h;
        this.s = String.valueOf(P);
        this.t = com.loc.m1.b0(context);
        this.v = "6.1.0";
        this.w = null;
        this.u = "";
        this.x = str5;
        this.y = str6;
        this.z = B;
        this.C = c1Var.G();
        this.F = l73.A();
        this.D = sb3.toString();
        this.N = (int) ((com.loc.m1.B() - l73Var.B()) / 1000);
        try {
            if (TextUtils.isEmpty(Q)) {
                Q = com.loc.o.R(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(R)) {
                R = com.loc.o.w(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.L)) {
                this.L = com.loc.o.T(context);
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = com.loc.o.Q(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.O = evVar.a(this.B, this.E);
            d(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:12|13|14|(17:272|(1:274)(1:376)|275|(7:277|(1:279)(1:353)|280|(1:282)(1:352)|283|(1:285)(1:351)|286)(12:(11:355|(1:357)(1:375)|358|(1:360)(1:374)|361|(1:363)(1:373)|364|(1:366)(1:372)|367|(1:369)(1:371)|370)|288|(1:290)(1:350)|(1:292)|293|(1:295)(1:348)|296|(1:298)|299|(1:301)|302|(2:304|(2:306|307)(3:308|(11:310|(1:312)(1:343)|313|(1:315)(1:342)|316|(1:318)(1:341)|319|(1:321)|322|(2:337|338)(8:324|(1:326)(1:336)|327|(1:329)|330|(1:332)|333|334)|335)|344))(2:345|(2:347|307)))|287|288|(0)(0)|(0)|292|293|(0)(0)|296|(0)|299|(0)|302|(0)(0))(1:17)|18|(14:22|23|24|25|(1:268)(4:28|(6:30|(3:85|(1:87)|88)(1:(3:36|(1:38)|39)(2:78|(3:80|(1:82)|83)(1:84)))|40|(1:42)|43|(3:64|(1:75)(5:66|(1:68)|(1:70)|71|(3:73|59|60)(1:74))|61)(3:49|(6:53|(1:55)|(1:57)|58|59|60)|61))|89|90)|91|(1:267)(14:95|96|97|98|99|(1:101)|102|103|104|(5:262|(1:264)|107|(2:109|110)|112)|106|107|(0)|112)|113|(1:115)(7:230|(1:232)(1:261)|(1:234)|235|(10:237|238|239|240|241|(1:243)(2:254|(1:256))|244|(1:253)|(2:249|250)(1:252)|251)|259|260)|116|117|118|(1:120)|(28:122|123|124|125|126|(1:128)|129|130|(3:220|221|222)|132|133|134|135|136|137|138|139|(1:141)(1:215)|142|(1:144)|145|(5:147|(1:149)(1:187)|150|(5:153|154|(9:157|(2:164|(6:166|(1:168)|169|170|171|172)(4:173|(3:175|(1:177)|178)|171|172))|179|(1:181)|182|170|171|172|155)|183|184)|152)|188|(4:190|(1:192)(1:208)|193|(3:195|(6:198|(1:200)|201|(2:203|204)(1:206)|205|196)|207))|209|(1:211)|212|213)(28:227|228|124|125|126|(0)|129|130|(0)|132|133|134|135|136|137|138|139|(0)(0)|142|(0)|145|(0)|188|(0)|209|(0)|212|213))|271|25|(0)|268|91|(1:93)|267|113|(0)(0)|116|117|118|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x06d0, code lost:
        r7[r9] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x035e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05b9 A[Catch: all -> 0x05c9, TRY_LEAVE, TryCatch #6 {all -> 0x05c9, blocks: (B:207:0x054f, B:216:0x0588, B:222:0x059a, B:224:0x05b9, B:209:0x0565, B:212:0x0572), top: B:368:0x054f }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x06be A[Catch: all -> 0x06d0, TryCatch #11 {all -> 0x06d0, blocks: (B:261:0x06b0, B:265:0x06be, B:266:0x06c2), top: B:376:0x06b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x06c2 A[Catch: all -> 0x06d0, TRY_LEAVE, TryCatch #11 {all -> 0x06d0, blocks: (B:261:0x06b0, B:265:0x06be, B:266:0x06c2), top: B:376:0x06b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06e3 A[Catch: all -> 0x0704, TryCatch #3 {all -> 0x0704, blocks: (B:271:0x06db, B:273:0x06e3, B:274:0x06ed), top: B:363:0x06db }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x06f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] e() {
        /*
            Method dump skipped, instructions count: 2331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.w73.e():byte[]");
    }
}
