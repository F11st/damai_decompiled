package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.taobao.downloader.adpater.Monitor;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.playerservice.axp.definition.FirstSliceCode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f1 {
    Hashtable<String, ArrayList<a>> a = new Hashtable<>();
    private long b = 0;
    private boolean c = false;
    private String d = "2.0.201501131131".replace(".", "");
    private String e = null;
    boolean f = true;
    long g = 0;
    String h = null;
    b1 i = null;
    private String j = null;
    private long k = 0;
    boolean l = true;
    boolean m = true;
    String n = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private eo a = null;
        private String b = null;

        protected a() {
        }

        public final eo a() {
            return this.a;
        }

        public final void b(eo eoVar) {
            this.a = eoVar;
        }

        public final void c(String str) {
            this.b = TextUtils.isEmpty(str) ? null : str.replace("##", Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        }

        public final String d() {
            return this.b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:18:0x0048, B:20:0x0052, B:22:0x0064, B:25:0x006f, B:27:0x0073, B:29:0x0079, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:16:0x0042), top: B:38:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.loc.eo c(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "cgiwifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 != 0) goto L42
            java.lang.String r1 = "wifi"
            boolean r1 = r5.contains(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L12
            goto L42
        L12:
            java.lang.String r6 = "cgi"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.f1$a>> r6 = r4.a     // Catch: java.lang.Throwable -> L94
            boolean r6 = r6.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r6 == 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.f1$a>> r6 = r4.a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L94
            if (r6 <= 0) goto L40
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.f1$a>> r6 = r4.a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r6 = r6.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Throwable -> L94
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L94
            com.loc.f1$a r6 = (com.loc.f1.a) r6     // Catch: java.lang.Throwable -> L94
            goto L46
        L40:
            r6 = r0
            goto L46
        L42:
            com.loc.f1$a r6 = r4.d(r6, r5)     // Catch: java.lang.Throwable -> L94
        L46:
            if (r6 == 0) goto L9c
            com.loc.eo r1 = r6.a()     // Catch: java.lang.Throwable -> L94
            boolean r1 = com.loc.m1.r(r1)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L9c
            com.loc.eo r1 = r6.a()     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "mem"
            r1.e(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = r6.d()     // Catch: java.lang.Throwable -> L94
            r1.h(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 != 0) goto L85
            long r2 = r1.getTime()     // Catch: java.lang.Throwable -> L94
            boolean r7 = com.loc.i1.f(r2)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L6f
            goto L85
        L6f:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.f1$a>> r7 = r4.a     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            boolean r7 = r7.containsKey(r5)     // Catch: java.lang.Throwable -> L94
            if (r7 == 0) goto L9c
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.f1$a>> r7 = r4.a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L94
            r5.remove(r6)     // Catch: java.lang.Throwable -> L94
            goto L9c
        L85:
            boolean r5 = com.loc.m1.r(r1)     // Catch: java.lang.Throwable -> L94
            if (r5 == 0) goto L8f
            r5 = 0
            r4.g = r5     // Catch: java.lang.Throwable -> L94
        L8f:
            r5 = 4
            r1.setLocationType(r5)     // Catch: java.lang.Throwable -> L94
            return r1
        L94:
            r5 = move-exception
            java.lang.String r6 = "Cache"
            java.lang.String r7 = "get1"
            com.loc.j1.h(r5, r6, r7)
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.f1.c(java.lang.String, java.lang.StringBuilder, boolean):com.loc.eo");
    }

    private a d(StringBuilder sb, String str) {
        a aVar;
        boolean z;
        a aVar2;
        if (this.a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (this.a.containsKey(str)) {
            Hashtable hashtable = new Hashtable();
            Hashtable hashtable2 = new Hashtable();
            Hashtable hashtable3 = new Hashtable();
            ArrayList<a> arrayList = this.a.get(str);
            char c = 1;
            int size = arrayList.size() - 1;
            while (size >= 0) {
                a aVar3 = arrayList.get(size);
                if (!TextUtils.isEmpty(aVar3.d())) {
                    if (!q(aVar3.d(), sb)) {
                        z = false;
                    } else if (m1.t(aVar3.d(), sb.toString())) {
                        aVar2 = aVar3;
                        aVar = aVar2;
                        break;
                    } else {
                        z = true;
                    }
                    n(aVar3.d(), hashtable);
                    n(sb.toString(), hashtable2);
                    hashtable3.clear();
                    for (String str2 : hashtable.keySet()) {
                        hashtable3.put(str2, "");
                    }
                    for (String str3 : hashtable2.keySet()) {
                        hashtable3.put(str3, "");
                    }
                    Set keySet = hashtable3.keySet();
                    double[] dArr = new double[keySet.size()];
                    double[] dArr2 = new double[keySet.size()];
                    Iterator it = keySet.iterator();
                    int i = 0;
                    while (it != null && it.hasNext()) {
                        String str4 = (String) it.next();
                        double d = 1.0d;
                        dArr[i] = hashtable.containsKey(str4) ? 1.0d : 0.0d;
                        if (!hashtable2.containsKey(str4)) {
                            d = 0.0d;
                        }
                        dArr2[i] = d;
                        i++;
                    }
                    keySet.clear();
                    double[] s = s(dArr, dArr2);
                    if (s[0] < 0.800000011920929d) {
                        aVar2 = aVar3;
                        if (s[c] < Math.min(i1.u(), 0.618d)) {
                            if (z && s[0] >= Math.min(i1.u(), 0.618d)) {
                            }
                        }
                        aVar = aVar2;
                        break;
                    }
                    aVar2 = aVar3;
                    aVar = aVar2;
                    break;
                }
                size--;
                c = 1;
            }
            aVar = null;
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
            return aVar;
        }
        return null;
    }

    private String e(String str, StringBuilder sb, Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.e = m1.e0(context);
            if (str.contains("&")) {
                str = str.substring(0, str.indexOf("&"));
            }
            String substring = str.substring(str.lastIndexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                String[] split = sb.toString().split(",access");
                jSONObject.put("mmac", split[0].contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) ? split[0].substring(split[0].lastIndexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + 1) : split[0]);
            }
            return p1.f(e1.e(jSONObject.toString().getBytes("UTF-8"), this.e));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x029a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0260 A[EDGE_INSN: B:139:0x0260->B:91:0x0260 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #0 {all -> 0x00c4, blocks: (B:35:0x00bd, B:45:0x00e6, B:47:0x0100, B:48:0x0104, B:52:0x0119, B:54:0x0129, B:73:0x01b7, B:75:0x01bd, B:77:0x01e9, B:78:0x01f6, B:79:0x01fb, B:49:0x0108, B:51:0x010e, B:58:0x0158, B:59:0x016b, B:68:0x019f, B:63:0x0175), top: B:126:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019f A[Catch: all -> 0x00c4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c4, blocks: (B:35:0x00bd, B:45:0x00e6, B:47:0x0100, B:48:0x0104, B:52:0x0119, B:54:0x0129, B:73:0x01b7, B:75:0x01bd, B:77:0x01e9, B:78:0x01f6, B:79:0x01fb, B:49:0x0108, B:51:0x010e, B:58:0x0158, B:59:0x016b, B:68:0x019f, B:63:0x0175), top: B:126:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0270 A[LOOP:0: B:42:0x00cf->B:93:0x0270, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x027a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(android.content.Context r20, java.lang.String r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.f1.h(android.content.Context, java.lang.String, boolean):void");
    }

    /* JADX WARN: Finally extract failed */
    private void l(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.e == null) {
            this.e = m1.e0(context);
        }
        String e = e(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.d);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.d);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = e;
            byte[] e2 = e1.e(sb.toString().getBytes("UTF-8"), this.e);
            objArr[1] = e2;
            objArr[2] = e1.e(aMapLocation.toStr().getBytes("UTF-8"), this.e);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i = 1; i < 3; i++) {
                objArr[i] = p1.f((byte[]) objArr[i]);
            }
            sQLiteDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            try {
                j1.h(th, "DB", "updateHist");
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (Throwable th2) {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    private static void n(String str, Hashtable<String, String> hashtable) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    private boolean o(eo eoVar, boolean z) {
        if (r(z)) {
            return eoVar == null || i1.f(eoVar.getTime()) || z;
        }
        return false;
    }

    private static boolean p(String str, eo eoVar) {
        if (TextUtils.isEmpty(str) || !m1.r(eoVar) || str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return false;
        }
        return str.contains("network");
    }

    private static boolean q(String str, StringBuilder sb) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        String substring = split[0].contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) ? split[0].substring(split[0].lastIndexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + 1) : split[0];
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        String sb2 = sb.toString();
        return sb2.contains(substring + ",access");
    }

    private boolean r(boolean z) {
        if (i1.r() || z) {
            return this.f || i1.t() || z;
        }
        return false;
    }

    private static double[] s(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            d2 += dArr[i3] * dArr[i3];
            d3 += dArr2[i3] * dArr2[i3];
            d += dArr[i3] * dArr2[i3];
            if (dArr2[i3] == 1.0d) {
                i2++;
                if (dArr[i3] == 1.0d) {
                    i++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d2) * Math.sqrt(d3));
        double d4 = i;
        dArr3[1] = (d4 * 1.0d) / i2;
        dArr3[2] = d4;
        for (int i4 = 0; i4 < 2; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
        }
        return dArr3;
    }

    private boolean u() {
        long B = m1.B();
        long j = this.b;
        long j2 = B - j;
        if (j == 0) {
            return false;
        }
        return this.a.size() > 360 || j2 > 172800000;
    }

    private void v() {
        this.b = 0L;
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.c = false;
    }

    private void w(Context context) throws Exception {
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!m1.o(openOrCreateDatabase, "hist")) {
                if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                    return;
                }
                openOrCreateDatabase.close();
                return;
            }
            String[] strArr = {String.valueOf(m1.g() - 172800000)};
            openOrCreateDatabase.delete("hist" + this.d, "time<?", strArr);
            if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                return;
            }
            openOrCreateDatabase.close();
        } catch (Throwable th) {
            try {
                j1.h(th, "DB", "clearHist p2");
            } finally {
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    public final eo a(Context context, String str, StringBuilder sb, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str) && i1.r()) {
            String str2 = str + "&" + this.l + "&" + this.m + "&" + this.n;
            if (str2.contains(GeocodeSearch.GPS) || !i1.r() || sb == null) {
                return null;
            }
            if (u()) {
                v();
                return null;
            }
            if (z && !this.c) {
                try {
                    String e = e(str2, sb, context);
                    v();
                    h(context, e, z2);
                } catch (Throwable unused) {
                }
            }
            if (this.a.isEmpty()) {
                return null;
            }
            return c(str2, sb, z2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:63:0x00c5, B:66:0x00d4, B:75:0x00e5, B:54:0x00a8, B:55:0x00ac, B:56:0x00b1, B:58:0x00b5, B:59:0x00ba, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:63:0x00c5, B:66:0x00d4, B:75:0x00e5, B:54:0x00a8, B:55:0x00ac, B:56:0x00b1, B:58:0x00b5, B:59:0x00ba, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:63:0x00c5, B:66:0x00d4, B:75:0x00e5, B:54:0x00a8, B:55:0x00ac, B:56:0x00b1, B:58:0x00b5, B:59:0x00ba, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:63:0x00c5, B:66:0x00d4, B:75:0x00e5, B:54:0x00a8, B:55:0x00ac, B:56:0x00b1, B:58:0x00b5, B:59:0x00ba, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ba A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:63:0x00c5, B:66:0x00d4, B:75:0x00e5, B:54:0x00a8, B:55:0x00ac, B:56:0x00b1, B:58:0x00b5, B:59:0x00ba, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d4 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:5:0x000f, B:7:0x0015, B:17:0x0029, B:27:0x004b, B:31:0x0053, B:33:0x0061, B:45:0x0086, B:47:0x008f, B:49:0x0093, B:51:0x0099, B:53:0x00a4, B:63:0x00c5, B:66:0x00d4, B:75:0x00e5, B:54:0x00a8, B:55:0x00ac, B:56:0x00b1, B:58:0x00b5, B:59:0x00ba, B:46:0x008d, B:39:0x0073, B:41:0x0079, B:9:0x0019, B:11:0x001d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00df A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.loc.eo b(com.loc.c1 r16, boolean r17, com.loc.eo r18, tb.l73 r19, java.lang.StringBuilder r20, java.lang.String r21, android.content.Context r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.f1.b(com.loc.c1, boolean, com.loc.eo, tb.l73, java.lang.StringBuilder, java.lang.String, android.content.Context, boolean):com.loc.eo");
    }

    public final void f() {
        this.g = 0L;
        this.h = null;
    }

    public final void g(Context context) {
        if (this.c) {
            return;
        }
        try {
            v();
            h(context, null, false);
        } catch (Throwable th) {
            j1.h(th, "Cache", "loadDB");
        }
        this.c = true;
    }

    public final void i(AMapLocationClientOption aMapLocationClientOption) {
        this.m = aMapLocationClientOption.isNeedAddress();
        this.l = aMapLocationClientOption.isOffset();
        this.f = aMapLocationClientOption.isLocationCacheEnable();
        this.n = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void j(b1 b1Var) {
        this.i = b1Var;
    }

    public final void k(String str) {
        this.h = str;
    }

    public final void m(String str, StringBuilder sb, eo eoVar, Context context, boolean z) {
        try {
            if (m1.r(eoVar)) {
                String str2 = str + "&" + eoVar.isOffset() + "&" + eoVar.i() + "&" + eoVar.j();
                if (!p(str2, eoVar) || eoVar.e().equals("mem") || eoVar.e().equals("file") || eoVar.e().equals("wifioff") || FirstSliceCode.FVV.equals(eoVar.d())) {
                    return;
                }
                if (u()) {
                    v();
                }
                JSONObject f = eoVar.f();
                if (m1.u(f, "offpct")) {
                    f.remove("offpct");
                    eoVar.a(f);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (eoVar.getAccuracy() >= 300.0f) {
                        int i = 0;
                        for (String str3 : sb.toString().split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                            if (str3.contains(",")) {
                                i++;
                            }
                        }
                        if (i >= 8) {
                            return;
                        }
                    } else if (eoVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(eoVar.g())) {
                        String replace = str2.replace("cgiwifi", "cgi");
                        eo h = eoVar.h();
                        if (m1.r(h)) {
                            m(replace, new StringBuilder(), h, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(eoVar.d()))) {
                    return;
                }
                eo c = c(str2, sb, false);
                if (m1.r(c) && c.toStr().equals(eoVar.toStr(3))) {
                    return;
                }
                this.b = m1.B();
                a aVar = new a();
                aVar.b(eoVar);
                aVar.c(TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.a.containsKey(str2)) {
                    this.a.get(str2).add(aVar);
                } else {
                    ArrayList<a> arrayList = new ArrayList<>();
                    arrayList.add(aVar);
                    this.a.put(str2, arrayList);
                }
                if (z) {
                    l(str2, eoVar, sb, context);
                }
            }
        } catch (Throwable th) {
            j1.h(th, "Cache", Monitor.POINT_ADD);
        }
    }

    public final void t(Context context) {
        try {
            v();
            w(context);
            this.c = false;
            this.h = null;
            this.k = 0L;
        } catch (Throwable th) {
            j1.h(th, "Cache", "destroy part");
        }
    }
}
