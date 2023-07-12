package com.amap.api.col.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.col.s.cz;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
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

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dc {
    private static SoftReference<SSLContext> k;
    private static SoftReference<dd> t;
    private boolean a;
    private SSLContext b;
    private Proxy c;
    private String g;
    private cz.a h;
    private d i;
    private boolean l;
    private String m;
    private String n;
    private volatile boolean d = false;
    private long e = -1;
    private long f = 0;
    private String j = "";
    private boolean o = false;
    private boolean p = false;
    private String q = "";
    private String r = "";
    private String s = "";
    private f u = new f();

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
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (!TextUtils.isEmpty(this.e)) {
                    str = str5 + this.e + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (!TextUtils.isEmpty(this.b)) {
                    str2 = str6 + this.b + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f == 1) {
                    str3 = str2 + this.d + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f == 1) {
                    str4 = str3 + this.i + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str4 = str3 + "-#";
                }
                String b = bp.b(cv.a(((str4 + this.c + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                dc.a();
                return b;
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
        public df.b b = df.b.FIRST_NONDEGRADE;
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
            if (!TextUtils.isEmpty(this.d)) {
                str2 = str + this.d + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            } else {
                str2 = str + "-#";
            }
            String b = bp.b(cv.a(((((str2 + this.b.a() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            dc.a();
            return b;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
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

        public final void a(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.a) && str.contains(":") && (split = str.split(":")) != null && split.length > 0) {
                this.a = split[0];
            } else {
                this.a = str;
            }
        }

        public final void b(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.a)) {
                return this.a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final String a() {
            return this.b;
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

        public final void a(df dfVar, URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!TextUtils.isEmpty(dc.this.n) && dfVar.t().b()) {
                c cVar = this.c;
                cVar.c = cVar.e.replace(jn1.ARRAY_START_STR, "").replace(jn1.ARRAY_END_STR, "");
                this.c.e = dc.this.n;
            }
            if (dfVar.t().b()) {
                dfVar.d(this.c.e);
            }
            if (dfVar.t().d()) {
                this.f = dfVar.w();
            }
        }

        public final void b() {
            this.c.i = SystemClock.elapsedRealtime() - this.b;
        }

        public final void c() {
            this.c.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void d() {
            c clone = this.c.clone();
            if (this.c.f > bl.e) {
                clone.m = 1;
            }
            bl.a(clone);
        }

        public final void b(int i) {
            this.c.n = i;
        }

        public final void a() {
            this.c.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void a(dg dgVar) {
            c clone;
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                if (dgVar != null) {
                    dgVar.f = this.c.b.c();
                }
                if (this.c.b.b()) {
                    c cVar = this.c;
                    if (cVar.f > 10000) {
                        bl.a(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    bl.a(false, this.f);
                }
                boolean a = dc.this.a(this.c.e);
                if (a) {
                    bl.c(this.c);
                    bl.a(true, this.d);
                    c cVar2 = this.c;
                    if (cVar2.f > bl.e && (clone = cVar2.clone()) != null) {
                        clone.m = 1;
                        bl.b(clone);
                        clone.toString();
                        dc.a();
                    }
                }
                bl.a(this.g.toString(), this.c.b.c(), false, a);
                this.c.toString();
                dc.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            dc.a();
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    bl.a(false, this.c.e);
                }
                boolean a = dc.this.a(this.c.e);
                if (a) {
                    if (dc.this.p && !TextUtils.isEmpty(dc.this.n) && this.c.b.b()) {
                        bl.c();
                    }
                    if (this.c.b.c()) {
                        bl.a(this.c.b.c(), this.c.e);
                    }
                    bl.c(this.e);
                    bl.a(false, this.d);
                    bl.b(this.c);
                }
                bl.a(this.g.toString(), this.c.b.c(), true, a);
                this.c.toString();
                dc.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j) {
            DecimalFormat decimalFormat = new DecimalFormat(PurchaseConstants.NULL_PRICE);
            this.c.l = decimalFormat.format(((float) j) / 1024.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc() {
        bl.d();
        try {
            this.g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            ci.a(th, "ht", ReportManager.g);
        }
    }

    public static void a() {
    }

    private void c(df dfVar) throws bj {
        this.i = new d((byte) 0);
        this.p = dfVar.x();
        this.c = dfVar.n();
        this.h = dfVar.s();
        this.l = dfVar.p();
        this.j = dfVar.y();
        this.a = bq.a().b(dfVar.r());
        String l = dfVar.t().b() ? dfVar.l() : dfVar.k();
        this.m = l;
        this.m = db.a(l, this.j);
        this.n = dfVar.i();
        if ("loc".equals(this.j)) {
            String k2 = dfVar.k();
            String l2 = dfVar.l();
            if (!TextUtils.isEmpty(k2)) {
                try {
                    this.r = new URL(k2).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(l2)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.n)) {
                    this.q = this.n;
                } else {
                    this.q = new URL(l2).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final dg b(df dfVar) throws bj {
        DataOutputStream dataOutputStream;
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                c(dfVar);
                dg b2 = db.b(this.m, this.j);
                if (b2 != null) {
                    this.u.d();
                    return b2;
                }
                b a2 = a(dfVar, true);
                HttpURLConnection httpURLConnection2 = a2.a;
                try {
                    this.u.b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.u.a();
                    byte[] g = dfVar.g();
                    if (g == null || g.length == 0) {
                        Map<String, String> e2 = dfVar.e();
                        HashMap<String, String> hashMap = cz.e;
                        if (hashMap != null) {
                            if (e2 != null) {
                                e2.putAll(hashMap);
                            } else {
                                e2 = hashMap;
                            }
                        }
                        String a3 = a(e2);
                        if (!TextUtils.isEmpty(a3)) {
                            g = bw.a(a3);
                        }
                    }
                    if (g != null && g.length > 0) {
                        try {
                            this.u.b = SystemClock.elapsedRealtime();
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
                            dataOutputStream.write(g);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.u.b();
                        } catch (Throwable th4) {
                            th = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.u.b();
                            throw th;
                        }
                    }
                    dg a4 = a(a2);
                    this.u.a(a4);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        ci.a(th5, "ht", "mPt");
                    }
                    this.u.d();
                    return a4;
                } catch (bj e3) {
                    e = e3;
                    if (!e.i() && e.g() != 10) {
                        this.u.a(e.g());
                    }
                    ci.a(e, "ht", "mPt");
                    throw e;
                } catch (ConnectException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new bj(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.u.a(8);
                    throw new bj("url异常 - MalformedURLException");
                } catch (SocketException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new bj(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new bj("socket 连接超时 - SocketTimeoutException");
                } catch (InterruptedIOException unused) {
                    this.u.b(7101);
                    this.u.a(7);
                    throw new bj(AMapException.ERROR_UNKNOWN);
                } catch (UnknownHostException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.u.a(5);
                    throw new bj("未知主机 - UnKnowHostException");
                } catch (SSLException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(4);
                    throw new bj("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new bj("IO 操作异常 - IOException");
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.u.a(7);
                    throw new bj("IO 操作异常 - IOException");
                } catch (Throwable th6) {
                    th = th6;
                    ci.a(th, "ht", "mPt");
                    this.u.a(9);
                    throw new bj(AMapException.ERROR_UNKNOWN);
                }
            } catch (bj e12) {
                e = e12;
            } catch (InterruptedIOException unused2) {
            } catch (ConnectException e13) {
                e = e13;
            } catch (MalformedURLException e14) {
                e = e14;
            } catch (SocketException e15) {
                e = e15;
            } catch (SocketTimeoutException e16) {
                e = e16;
            } catch (UnknownHostException e17) {
                e = e17;
            } catch (SSLException e18) {
                e = e18;
            } catch (ConnectTimeoutException e19) {
                e = e19;
            } catch (IOException e20) {
                e = e20;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    ci.a(th9, "ht", "mPt");
                }
            }
            this.u.d();
            throw th8;
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
            eVar2.b(str);
            this.a.add(eVar2);
            return eVar2;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = cz.e;
        if (hashMap != null) {
            if (map != null) {
                map.putAll(hashMap);
            } else {
                map = hashMap;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf >= 0) {
            HashMap hashMap2 = new HashMap();
            String substring = str.substring(indexOf);
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                String encode = URLEncoder.encode(key);
                if (!substring.matches(".*[\\?\\&]" + encode + "=.*")) {
                    hashMap2.put(key, value);
                }
            }
            map = hashMap2;
        }
        if (map.size() == 0) {
            return str;
        }
        String a2 = a((Map<String, String>) map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith("?") && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
        } else {
            stringBuffer.append("?");
        }
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final dg a(df dfVar) throws bj {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        c(dfVar);
                                        String a2 = a(this.m, dfVar.e());
                                        this.m = a2;
                                        dg b2 = db.b(a2, this.j);
                                        if (b2 != null) {
                                            this.u.d();
                                            return b2;
                                        }
                                        b a3 = a(dfVar, false);
                                        HttpURLConnection httpURLConnection = a3.a;
                                        this.u.b = SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.u.a();
                                        dg a4 = a(a3);
                                        this.u.a(a4);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th) {
                                            ci.a(th, "ht", "mgr");
                                        }
                                        this.u.d();
                                        return a4;
                                    } catch (InterruptedIOException unused) {
                                        this.u.b(7101);
                                        this.u.a(7);
                                        throw new bj(AMapException.ERROR_UNKNOWN);
                                    } catch (SSLException e2) {
                                        e2.printStackTrace();
                                        this.u.b(a(e2));
                                        this.u.a(4);
                                        throw new bj("IO 操作异常 - IOException");
                                    }
                                } catch (ConnectException e3) {
                                    this.u.b(a(e3));
                                    this.u.a(6);
                                    throw new bj(AMapException.ERROR_CONNECTION);
                                } catch (UnknownHostException unused2) {
                                    this.u.a(9);
                                    throw new bj("未知主机 - UnKnowHostException");
                                }
                            } catch (SocketTimeoutException e4) {
                                this.u.b(a(e4));
                                this.u.a(2);
                                throw new bj("socket 连接超时 - SocketTimeoutException");
                            } catch (ConnectTimeoutException e5) {
                                e5.printStackTrace();
                                this.u.b(a(e5));
                                this.u.a(2);
                                throw new bj("IO 操作异常 - IOException");
                            }
                        } catch (IOException unused3) {
                            this.u.a(7);
                            throw new bj("IO 操作异常 - IOException");
                        }
                    } catch (bj e6) {
                        if (!e6.i() && e6.g() != 10) {
                            this.u.a(e6.f());
                        }
                        throw e6;
                    }
                } catch (MalformedURLException unused4) {
                    this.u.a(8);
                    throw new bj("url异常 - MalformedURLException");
                }
            } catch (SocketException e7) {
                this.u.b(a(e7));
                this.u.a(6);
                throw new bj(AMapException.ERROR_SOCKET);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142 A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:44:0x00cb, B:47:0x00e3, B:49:0x00e6, B:51:0x00ea, B:53:0x00f0, B:57:0x00f9, B:60:0x0105, B:62:0x0108, B:64:0x010e, B:74:0x013c, B:76:0x0142, B:78:0x014c, B:80:0x015d, B:82:0x0185, B:84:0x01a6, B:85:0x01a9, B:65:0x0124, B:67:0x0128, B:69:0x012b, B:71:0x0131, B:72:0x0138), top: B:139:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.s.dc.b a(com.amap.api.col.s.df r15, boolean r16) throws java.io.IOException, com.amap.api.col.s.bj {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dc.a(com.amap.api.col.s.df, boolean):com.amap.api.col.s.dc$b");
    }

    private dd b() {
        try {
            SoftReference<dd> softReference = t;
            if (softReference == null || softReference.get() == null) {
                t = new SoftReference<>(new dd(bl.c, this.b));
            }
            dd ddVar = k != null ? t.get() : null;
            return ddVar == null ? new dd(bl.c, this.b) : ddVar;
        } catch (Throwable th) {
            cl.c(th, "ht", "gsf");
            return null;
        }
    }

    private static String b(Map<String, List<String>> map) {
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

    private static boolean b(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x016c A[Catch: all -> 0x01b9, IOException -> 0x01be, SocketTimeoutException -> 0x01ec, ConnectTimeoutException -> 0x01f1, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01ec, ConnectTimeoutException -> 0x01f1, IOException -> 0x01be, all -> 0x01b9, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:44:0x00a4, B:104:0x016c, B:105:0x01b8), top: B:158:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[Catch: all -> 0x01b9, IOException -> 0x01be, SocketTimeoutException -> 0x01ec, ConnectTimeoutException -> 0x01f1, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01ec, ConnectTimeoutException -> 0x01f1, IOException -> 0x01be, all -> 0x01b9, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:44:0x00a4, B:104:0x016c, B:105:0x01b8), top: B:158:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.s.dg a(com.amap.api.col.s.dc.b r15) throws com.amap.api.col.s.bj, java.io.IOException {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dc.a(com.amap.api.col.s.dc$b):com.amap.api.col.s.dg");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
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
            java.lang.String r0 = r6.j     // Catch: java.lang.Throwable -> L72
            boolean r7 = com.amap.api.col.s.bl.a(r0, r7)     // Catch: java.lang.Throwable -> L72
            r2 = r7
            goto L73
        L72:
            r2 = 0
        L73:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dc.a(java.util.Map, boolean):boolean");
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        String str;
        c f2;
        if (map != null) {
            try {
                for (String str2 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str2, map.get(str2));
                }
            } catch (Throwable th) {
                ci.a(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = cz.d;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str3, cz.d.get(str3));
            }
        }
        if (!this.m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.j) && bl.a(this.j)) {
            this.o = true;
            httpURLConnection.addRequestProperty("lct", String.valueOf(bl.c(this.j)));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (a(this.u.c.e)) {
            f fVar = this.u;
            if (TextUtils.isEmpty(fVar.c.c)) {
                str = "";
            } else {
                String b2 = bp.b(cv.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.c.c;
                str = b2;
            }
            if (!TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (bl.j && (f2 = bl.f()) != null) {
                httpURLConnection.addRequestProperty("nls", f2.b());
                this.u.e = f2;
            }
            a e2 = bl.e();
            if (e2 != null) {
                httpURLConnection.addRequestProperty("nlf", e2.b());
                this.u.d = e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Map<String, String> map) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (this.l) {
            return true;
        }
        return (!TextUtils.isEmpty(this.n) && (this.n.contains("rest") || this.n.contains("apilocate"))) || b(str);
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
}
