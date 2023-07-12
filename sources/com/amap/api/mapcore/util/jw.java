package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.util.ArrayList;
import tb.jn1;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class jw {
    protected static String J;
    protected static String L;
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
    protected String A = null;
    protected String B = null;
    protected ArrayList<la> C = new ArrayList<>();
    protected String D = null;
    protected String E = null;
    protected ArrayList<ScanResult> F = new ArrayList<>();
    protected String G = null;
    protected String H = null;
    protected byte[] I = null;
    private byte[] O = null;
    private int P = 0;
    protected String K = null;
    protected String M = null;
    protected String N = null;

    private static int a(String str, byte[] bArr, int i) {
        try {
        } catch (Throwable th) {
            jy.a(th, "Req", "copyContentWithByteLen");
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

    private String a(String str, int i) {
        String[] split = this.B.split("\\*")[i].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0.length != 6) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(java.lang.String r7) {
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
            if (r1 >= r4) goto L58
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
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getMacBa "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r1 = "Req"
            com.amap.api.mapcore.util.jy.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.a(r7)
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jw.a(java.lang.String):byte[]");
    }

    private String b(String str) {
        String str2 = this.A;
        if (str2.contains(str + jn1.G)) {
            String str3 = this.A;
            int indexOf = str3.indexOf(str + jn1.G);
            String str4 = this.A;
            return this.A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
        }
        return "0";
    }

    private void b() {
        String[] strArr = new String[28];
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
        strArr[21] = this.A;
        strArr[22] = this.B;
        strArr[23] = this.E;
        strArr[24] = this.G;
        strArr[25] = this.H;
        strArr[26] = J;
        strArr[27] = this.N;
        for (int i = 0; i < 28; i++) {
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
        if (!lb.a(this.z)) {
            this.z = 0;
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
    }

    public final void a(Context context, boolean z, boolean z2, lb lbVar, js jsVar, ConnectivityManager connectivityManager, String str) {
        String str2;
        String str3;
        int i;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ArrayList<ScanResult> arrayList;
        String str10;
        String str11;
        ArrayList<ScanResult> arrayList2;
        int i2;
        String f = gc.f(context);
        int d = kc.d();
        this.K = str;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str12 = str3;
        String str13 = str2;
        StringBuilder sb = new StringBuilder();
        int e = lbVar.e();
        int f2 = lbVar.f();
        TelephonyManager g = lbVar.g();
        ArrayList<la> c = lbVar.c();
        ArrayList<la> d2 = lbVar.d();
        ArrayList<ScanResult> a = jsVar.a();
        String str14 = f2 == 2 ? "1" : "0";
        if (g != null) {
            if (TextUtils.isEmpty(jy.e)) {
                try {
                    jy.e = gg.w(context);
                } catch (Throwable th) {
                    str4 = "1";
                    jy.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            i = d;
            if (TextUtils.isEmpty(jy.e) && Build.VERSION.SDK_INT < 29) {
                jy.e = "888888888888888";
            }
            if (TextUtils.isEmpty(jy.f)) {
                try {
                    jy.f = gg.y(context);
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    jy.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(jy.f) && Build.VERSION.SDK_INT < 29) {
                jy.f = "888888888888888";
            }
        } else {
            i = d;
            str4 = "1";
        }
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Throwable th3) {
            jy.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a2 = jsVar.a(connectivityManager);
        if (kc.a(networkInfo) != -1) {
            str5 = kc.b(g);
            str6 = a2 ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        String str15 = str6;
        String str16 = str5;
        if (c.isEmpty()) {
            str7 = f;
            str8 = str13;
            str9 = str12;
            arrayList = a;
            str10 = "0";
            str11 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            str7 = f;
            str10 = "0";
            str9 = str12;
            str8 = str13;
            if (f2 == 1) {
                la laVar = c.get(0);
                arrayList = a;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(laVar.a);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(laVar.b);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(laVar.c);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(laVar.d);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(laVar.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                for (int i3 = 1; i3 < c.size(); i3++) {
                    la laVar2 = c.get(i3);
                    sb.append(laVar2.c);
                    sb.append(",");
                    sb.append(laVar2.d);
                    sb.append(",");
                    sb.append(laVar2.j);
                    if (i3 < c.size() - 1) {
                        sb.append(jn1.MUL);
                    }
                }
            } else if (f2 != 2) {
                arrayList = a;
                str11 = "";
            } else {
                la laVar3 = c.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(laVar3.a);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(laVar3.g);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(laVar3.h);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(laVar3.i);
                sb2.append("</bid>");
                if (laVar3.f > 0 && laVar3.e > 0) {
                    sb2.append("<lon>");
                    sb2.append(laVar3.f);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(laVar3.e);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(laVar3.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                arrayList = a;
            }
            sb2.delete(0, sb2.length());
        }
        if ((e & 4) != 4 || d2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(d2);
        }
        StringBuilder sb3 = new StringBuilder();
        if (jsVar.e()) {
            if (a2) {
                WifiInfo f3 = jsVar.f();
                if (js.a(f3)) {
                    sb3.append(f3.getBSSID());
                    sb3.append(",");
                    int rssi = f3.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = f3.getSSID();
                    try {
                        i2 = f3.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i2 = 32;
                    }
                    if (i2 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace(jn1.MUL, "."));
                }
            }
            if (arrayList != null && (arrayList2 = this.F) != null) {
                arrayList2.clear();
                this.F.addAll(arrayList);
            }
        } else {
            jsVar.b();
            ArrayList<ScanResult> arrayList3 = this.F;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str8;
        this.d = str9;
        this.f = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        this.g = "android" + Build.VERSION.getRELEASE();
        this.h = kc.b(context);
        this.i = str14;
        String str17 = str10;
        this.j = str17;
        this.k = str17;
        this.l = str17;
        this.m = str17;
        this.n = str17;
        this.o = str7;
        this.p = jy.e;
        this.q = jy.f;
        this.s = String.valueOf(i);
        this.t = kc.d(context);
        this.v = "4.9.0";
        this.w = null;
        this.u = "";
        this.x = str16;
        this.y = str15;
        this.z = e;
        this.A = str11;
        this.B = sb.toString();
        this.D = lbVar.j();
        this.G = js.i();
        this.E = sb3.toString();
        try {
            if (TextUtils.isEmpty(J)) {
                J = gg.i(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(L)) {
                L = gg.b(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = gg.j(context);
            }
        } catch (Throwable unused5) {
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:12|13|14|(8:188|(1:190)(5:(1:216)|192|(1:194)|195|(2:197|(2:199|200)(3:201|(3:203|(1:210)(2:205|206)|207)|211))(1:(2:213|200)))|191|192|(0)|194|195|(0)(0))|17|(14:21|22|23|24|(1:184)(5:27|(1:29)|30|(5:32|(8:34|(3:67|(1:69)|70)(6:39|(3:41|(1:43)|44)|46|(1:48)|49|(8:51|(2:63|62)|55|(1:57)|(1:59)|60|61|62))|45|46|(1:65)|48|49|(0))|71|72|62)|73)|74|(1:76)(13:164|165|166|167|168|(1:170)|171|172|173|(4:179|(1:181)|176|177)|175|176|177)|77|(1:79)(8:130|(1:132)(1:163)|133|(1:135)|136|(12:138|139|140|141|142|(1:157)(1:144)|145|146|(1:156)|150|(2:152|153)(1:155)|154)|161|162)|80|81|82|(1:84)|(24:86|87|88|89|90|(1:92)|93|94|(3:120|121|122)|96|97|98|99|100|101|102|103|(1:105)(1:115)|106|(1:108)|109|(1:111)|112|113)(24:127|128|88|89|90|(0)|93|94|(0)|96|97|98|99|100|101|102|103|(0)(0)|106|(0)|109|(0)|112|113))|187|24|(0)|184|74|(0)(0)|77|(0)(0)|80|81|82|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x041d, code lost:
        if (r14 < (-128)) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x049c, code lost:
        r7[r0] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x048a A[Catch: all -> 0x049c, TryCatch #8 {all -> 0x049c, blocks: (B:166:0x047c, B:170:0x048a, B:171:0x048e), top: B:219:0x047c }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x048e A[Catch: all -> 0x049c, TRY_LEAVE, TryCatch #8 {all -> 0x049c, blocks: (B:166:0x047c, B:170:0x048a, B:171:0x048e), top: B:219:0x047c }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04af A[Catch: all -> 0x04d0, TryCatch #0 {all -> 0x04d0, blocks: (B:176:0x04a7, B:178:0x04af, B:179:0x04b9), top: B:206:0x04a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0182 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0220 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0307  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a() {
        /*
            Method dump skipped, instructions count: 1353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jw.a():byte[]");
    }
}
