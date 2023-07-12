package com.loc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.maps.AMapException;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import com.loc.bg;
import com.loc.bl;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;
import tb.jn1;
import tb.r43;
import tb.t43;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bj {
    private static SoftReference<SSLContext> o;
    private static SoftReference<a0> p;
    private boolean a;
    private SSLContext b;
    private Proxy c;
    private String d;
    private bg.a e;
    private d f;
    private boolean h;
    private String i;
    private String j;
    private String g = "";
    private boolean k = false;
    private boolean l = false;
    private String m = "";
    private f n = new f();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements Cloneable, Comparable {
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public int h;
        public long i;
        public volatile AtomicInteger j = new AtomicInteger(1);

        public a(c cVar) {
            this.b = cVar.c;
            this.c = cVar.e;
            this.e = cVar.d;
            this.f = cVar.m;
            this.g = cVar.n;
            this.h = cVar.b.a();
            this.d = cVar.a;
            this.i = cVar.f;
            if (this.f == 10) {
                this.a = 0;
            }
        }

        /* renamed from: a */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            StringBuilder sb4;
            try {
                String str = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (TextUtils.isEmpty(this.e)) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append("-#");
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.e);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                }
                String str2 = (sb.toString() + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (TextUtils.isEmpty(this.b)) {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append("-#");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(this.b);
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                }
                String sb5 = sb2.toString();
                if (this.f == 1) {
                    sb3 = new StringBuilder();
                    sb3.append(sb5);
                    sb3.append(this.d);
                    sb3.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(sb5);
                    sb3.append("-#");
                }
                String sb6 = sb3.toString();
                if (this.f == 1) {
                    sb4 = new StringBuilder();
                    sb4.append(sb6);
                    sb4.append(this.i);
                    sb4.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(sb6);
                    sb4.append("-#");
                }
                String f = p1.f(r43.a(((sb4.toString() + this.c + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                bj.f();
                return f;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.a - ((a) obj).a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        public HttpURLConnection a;
        public int b = this.b;
        public int b = this.b;

        public b(HttpURLConnection httpURLConnection) {
            this.a = httpURLConnection;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c implements Cloneable {
        public String a = "";
        public bl.b b = bl.b.FIRST_NONDEGRADE;
        public String c = "";
        public String d = "";
        public String e = "";
        public long f = 0;
        public long g = 0;
        public long h = 0;
        public long i = 0;
        public long j = 0;
        public String k = "-";
        public String l = "-";
        public int m = 0;
        public int n = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        protected final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.c)) {
                str = "-#";
            } else {
                str = this.c + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            }
            if (TextUtils.isEmpty(this.d)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.d + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            }
            String f = p1.f(r43.a(((((str2 + this.b.a() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            bj.f();
            return f;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d {
        private Vector<e> a;
        private volatile e b;

        private d() {
            this.a = new Vector<>();
            this.b = new e((byte) 0);
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                e eVar = this.a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e((byte) 0);
            eVar2.c(str);
            this.a.add(eVar2);
            return eVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class e implements HostnameVerifier {
        private String a;
        private String b;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final String a() {
            return this.b;
        }

        public final void b(String str) {
            String[] split;
            if (TextUtils.isEmpty(this.a) || !str.contains(":") || (split = str.split(":")) == null || split.length <= 0) {
                this.a = str;
            } else {
                this.a = split[0];
            }
        }

        public final void c(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.a) ? this.a.equals(str) : !TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class f {
        long a = 0;
        long b = 0;
        c c = new c();
        a d;
        c e;
        String f;
        URL g;

        f() {
        }

        public final void a() {
            this.c.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void b(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            bj.f();
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    m.p(false, this.c.e);
                }
                boolean i2 = bj.this.i(this.c.e);
                if (i2) {
                    if (bj.this.l && !TextUtils.isEmpty(bj.this.j) && this.c.b.b()) {
                        m.H();
                    }
                    if (this.c.b.c()) {
                        m.p(this.c.b.c(), this.c.e);
                    }
                    m.F(this.e);
                    m.o(false, this.d);
                    m.y(this.c);
                }
                m.n(this.g.toString(), this.c.b.c(), true, i2);
                this.c.toString();
                bj.f();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j) {
            DecimalFormat decimalFormat = new DecimalFormat(PurchaseConstants.NULL_PRICE);
            this.c.l = decimalFormat.format(((float) j) / 1024.0f);
        }

        public final void d(bl blVar, URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!TextUtils.isEmpty(bj.this.j) && blVar.D().b()) {
                c cVar = this.c;
                cVar.c = cVar.e.replace(jn1.ARRAY_START_STR, "").replace(jn1.ARRAY_END_STR, "");
                this.c.e = bj.this.j;
            }
            if (blVar.D().b()) {
                blVar.g(this.c.e);
            }
            if (blVar.D().d()) {
                this.f = blVar.G();
            }
        }

        public final void e(t43 t43Var) {
            c clone;
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                if (t43Var != null) {
                    t43Var.e = this.c.b.c();
                }
                if (this.c.b.b()) {
                    c cVar = this.c;
                    if (cVar.f > 10000) {
                        m.p(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    m.p(false, this.f);
                }
                boolean i = bj.this.i(this.c.e);
                if (i) {
                    m.F(this.c);
                    m.o(true, this.d);
                    c cVar2 = this.c;
                    if (cVar2.f > m.r && (clone = cVar2.clone()) != null) {
                        clone.m = 1;
                        m.y(clone);
                        clone.toString();
                        bj.f();
                    }
                }
                m.n(this.g.toString(), this.c.b.c(), false, i);
                this.c.toString();
                bj.f();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.c.i = SystemClock.elapsedRealtime() - this.b;
        }

        public final void g(int i) {
            this.c.n = i;
        }

        public final void h() {
            this.c.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void i() {
            c clone = this.c.clone();
            if (this.c.f > m.r) {
                clone.m = 1;
            }
            m.j(clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj() {
        m.K();
        try {
            this.d = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            y33.e(th, "ht", ReportManager.g);
        }
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return MessageConstant$MessageType.MESSAGE_DATA;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        return exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(key));
                sb.append("=");
                sb.append(URLEncoder.encode(value));
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private tb.t43 d(com.loc.bj.b r14) throws com.loc.k, java.io.IOException {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bj.d(com.loc.bj$b):tb.t43");
    }

    public static void f() {
    }

    private void g(Map<String, String> map, HttpURLConnection httpURLConnection) {
        String str;
        c N;
        if (map != null) {
            try {
                for (String str2 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str2, map.get(str2));
                }
            } catch (Throwable th) {
                y33.e(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = bg.d;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str3, bg.d.get(str3));
            }
        }
        if (!this.i.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.g) && m.r(this.g)) {
            this.k = true;
            httpURLConnection.addRequestProperty("lct", String.valueOf(m.D(this.g)));
        }
        httpURLConnection.addRequestProperty("csid", this.d);
        if (i(this.n.c.e)) {
            f fVar = this.n;
            if (TextUtils.isEmpty(fVar.c.c)) {
                str = "";
            } else {
                String f2 = p1.f(r43.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.c.c;
                str = f2;
            }
            if (!TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (m.y && (N = m.N()) != null) {
                httpURLConnection.addRequestProperty("nls", N.b());
                this.n.e = N;
            }
            a M = m.M();
            if (M != null) {
                httpURLConnection.addRequestProperty("nlf", M.b());
                this.n.d = M;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str) {
        if (this.h) {
            return true;
        }
        return (!TextUtils.isEmpty(this.j) && (this.j.contains("rest") || this.j.contains("apilocate"))) || o(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "#"
            java.lang.String r1 = "lct"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "sc"
            java.lang.Object r4 = r7.get(r4)     // Catch: java.lang.Throwable -> L72
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L3c
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L72
            if (r5 <= 0) goto L3c
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L72
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L72
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L72
            if (r5 != 0) goto L3c
            boolean r5 = r4.contains(r0)     // Catch: java.lang.Throwable -> L72
            if (r5 != 0) goto L2a
        L28:
            r0 = 1
            goto L3d
        L2a:
            java.lang.String[] r0 = r4.split(r0)     // Catch: java.lang.Throwable -> L72
            int r4 = r0.length     // Catch: java.lang.Throwable -> L72
            if (r4 <= r2) goto L3c
            java.lang.String r4 = "1"
            r0 = r0[r2]     // Catch: java.lang.Throwable -> L72
            boolean r0 = r4.equals(r0)     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L3c
            goto L28
        L3c:
            r0 = 0
        L3d:
            if (r0 != 0) goto L40
            return r3
        L40:
            if (r8 == 0) goto L73
            boolean r8 = r7.containsKey(r1)     // Catch: java.lang.Throwable -> L72
            if (r8 == 0) goto L72
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Throwable -> L72
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L72
            if (r7 == 0) goto L72
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L72
            if (r8 <= 0) goto L72
            java.lang.Object r7 = r7.get(r3)     // Catch: java.lang.Throwable -> L72
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L72
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L72
            if (r8 != 0) goto L72
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L72
            long r7 = r7.longValue()     // Catch: java.lang.Throwable -> L72
            java.lang.String r0 = r6.g     // Catch: java.lang.Throwable -> L72
            boolean r7 = com.loc.m.s(r0, r7)     // Catch: java.lang.Throwable -> L72
            r2 = r7
            goto L73
        L72:
            r2 = 0
        L73:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bj.j(java.util.Map, boolean):boolean");
    }

    private a0 k() {
        try {
            SoftReference<a0> softReference = p;
            if (softReference == null || softReference.get() == null) {
                p = new SoftReference<>(new a0(m.g, this.b));
            }
            a0 a0Var = o != null ? p.get() : null;
            return a0Var == null ? new a0(m.g, this.b) : a0Var;
        } catch (Throwable th) {
            an.m(th, "ht", "gsf");
            return null;
        }
    }

    private static String l(Map<String, List<String>> map) {
        try {
            List<String> list = map.get(IRequestConst.SC);
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    private void m(bl blVar) throws k {
        this.f = new d((byte) 0);
        this.l = blVar.H();
        this.c = blVar.x();
        this.e = blVar.C();
        this.h = blVar.z();
        this.g = blVar.I();
        this.a = q1.a().e(blVar.B());
        String v = blVar.D().b() ? blVar.v() : blVar.u();
        this.i = v;
        this.i = y.a(v, this.g);
        this.j = blVar.s();
        if ("loc".equals(this.g)) {
            String u = blVar.u();
            String v2 = blVar.v();
            if (!TextUtils.isEmpty(u)) {
                try {
                    new URL(u).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(v2)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.j)) {
                    new URL(v2).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    private static boolean o(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0140 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:44:0x00c9, B:47:0x00e1, B:49:0x00e4, B:51:0x00e8, B:53:0x00ee, B:57:0x00f7, B:60:0x0103, B:62:0x0106, B:64:0x010c, B:74:0x013a, B:76:0x0140, B:78:0x014a, B:80:0x015b, B:82:0x0183, B:84:0x01a4, B:85:0x01a7, B:65:0x0122, B:67:0x0126, B:69:0x0129, B:71:0x012f, B:72:0x0136), top: B:138:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.loc.bj.b p(com.loc.bl r15) throws java.io.IOException, com.loc.k {
        /*
            Method dump skipped, instructions count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bj.p(com.loc.bl):com.loc.bj$b");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t43 e(bl blVar) throws k {
        DataOutputStream dataOutputStream;
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                m(blVar);
                t43 q = y.q(this.i, this.g);
                if (q != null) {
                    this.n.i();
                    return q;
                }
                b p2 = p(blVar);
                HttpURLConnection httpURLConnection2 = p2.a;
                try {
                    this.n.b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.n.a();
                    byte[] r = blVar.r();
                    if (r == null || r.length == 0) {
                        Map<String, String> q2 = blVar.q();
                        HashMap<String, String> hashMap = bg.e;
                        if (hashMap != null) {
                            if (q2 != null) {
                                q2.putAll(hashMap);
                            } else {
                                q2 = hashMap;
                            }
                        }
                        String c2 = c(q2);
                        if (!TextUtils.isEmpty(c2)) {
                            r = v1.p(c2);
                        }
                    }
                    if (r != null && r.length > 0) {
                        try {
                            this.n.b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                dataOutputStream = new DataOutputStream(outputStream);
                            } catch (Throwable th2) {
                                dataOutputStream = null;
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            dataOutputStream = null;
                            th = th3;
                            outputStream = null;
                        }
                        try {
                            dataOutputStream.write(r);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.n.f();
                        } catch (Throwable th4) {
                            th = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.n.f();
                            throw th;
                        }
                    }
                    t43 d2 = d(p2);
                    this.n.e(d2);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        y33.e(th5, "ht", "mPt");
                    }
                    this.n.i();
                    return d2;
                } catch (k e2) {
                    e = e2;
                    if (!e.i() && e.g() != 10) {
                        this.n.b(e.g());
                    }
                    y33.e(e, "ht", "mPt");
                    throw e;
                } catch (InterruptedIOException unused) {
                    this.n.g(7101);
                    this.n.b(7);
                    throw new k(AMapException.ERROR_UNKNOWN);
                } catch (ConnectException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.n.g(a(e));
                    this.n.b(6);
                    throw new k(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.n.b(8);
                    throw new k("url异常 - MalformedURLException");
                } catch (SocketException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.n.g(a(e));
                    this.n.b(6);
                    throw new k(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.n.g(a(e));
                    this.n.b(2);
                    throw new k("socket 连接超时 - SocketTimeoutException");
                } catch (UnknownHostException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.n.b(5);
                    throw new k("未知主机 - UnKnowHostException");
                } catch (SSLException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.n.g(a(e));
                    this.n.b(4);
                    throw new k("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.n.g(a(e));
                    this.n.b(2);
                    throw new k("IO 操作异常 - IOException");
                } catch (IOException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.n.b(7);
                    throw new k("IO 操作异常 - IOException");
                } catch (Throwable th6) {
                    th = th6;
                    y33.e(th, "ht", "mPt");
                    this.n.b(9);
                    throw new k(AMapException.ERROR_UNKNOWN);
                }
            } catch (k e11) {
                e = e11;
            } catch (InterruptedIOException unused2) {
            } catch (ConnectException e12) {
                e = e12;
            } catch (MalformedURLException e13) {
                e = e13;
            } catch (SocketException e14) {
                e = e14;
            } catch (SocketTimeoutException e15) {
                e = e15;
            } catch (UnknownHostException e16) {
                e = e16;
            } catch (SSLException e17) {
                e = e17;
            } catch (ConnectTimeoutException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    y33.e(th9, "ht", "mPt");
                }
            }
            this.n.i();
            throw th8;
        }
    }
}
