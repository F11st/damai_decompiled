package com.amap.api.mapcore.util;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.mapcore.util.id;
import com.amap.api.maps.AMapException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ig {
    private int a;
    private int b;
    private boolean c;
    private SSLContext d;
    private Proxy e;
    private volatile boolean f;
    private long g;
    private long h;
    private String i;
    private C4589b j;
    private id.InterfaceC4586a k;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ig$a */
    /* loaded from: classes10.dex */
    public static class C4588a {
        public HttpURLConnection a;
        public int b;

        public C4588a(HttpURLConnection httpURLConnection, int i) {
            this.a = httpURLConnection;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ig$b */
    /* loaded from: classes10.dex */
    public static class C4589b {
        private Vector<C4590c> a;
        private volatile C4590c b;

        private C4589b() {
            this.a = new Vector<>();
            this.b = new C4590c();
        }

        public C4590c a() {
            return this.b;
        }

        public void b(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b.a(str);
        }

        public C4590c a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                C4590c c4590c = this.a.get(i);
                if (c4590c != null && c4590c.a().equals(str)) {
                    return c4590c;
                }
            }
            C4590c c4590c2 = new C4590c();
            c4590c2.b(str);
            this.a.add(c4590c2);
            return c4590c2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ig$c */
    /* loaded from: classes10.dex */
    public static class C4590c implements HostnameVerifier {
        private String a;
        private String b;

        private C4590c() {
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.a)) {
                return this.a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        public String a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ig(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, null);
    }

    public static boolean a(int i) {
        return i == 2;
    }

    private void b() {
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            C4573ha.a(th, "ht", ReportManager.g);
        }
    }

    private void c(int i) {
        try {
            if (i != 2) {
                if (i == 3) {
                    this.a = 5000;
                    this.b = 5000;
                }
            }
            this.a = Math.max(this.a - 5000, 5000);
            this.b = Math.max(this.b - 5000, 5000);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f = true;
    }

    ig(int i, int i2, Proxy proxy, boolean z, id.InterfaceC4586a interfaceC4586a) {
        this.f = false;
        this.g = -1L;
        this.h = 0L;
        this.a = i;
        this.b = i2;
        this.e = proxy;
        this.c = gi.a().b(z);
        if (gi.c()) {
            this.c = false;
        }
        this.k = interfaceC4586a;
        b();
        if (this.c) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                this.d = sSLContext;
            } catch (Throwable th) {
                C4573ha.a(th, "ht", "ne");
            }
        }
        this.j = new C4589b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.h = j;
    }

    private String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a = a(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (a != null) {
            stringBuffer.append("?");
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        this.g = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ik b(String str, String str2, boolean z, String str3, Map<String, String> map, Map<String, String> map2, boolean z2, int i) throws gb {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                C4588a a = a(a(str, map2), a(str2, map2), z, str3, map, false, i);
                try {
                    httpURLConnection = a.a;
                    ik a2 = a(a, z2);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th) {
                            C4573ha.a(th, "ht", "mgr");
                        }
                    }
                    return a2;
                } catch (gb e) {
                    e = e;
                    throw e;
                } catch (InterruptedIOException unused) {
                    throw new gb(AMapException.ERROR_UNKNOWN);
                } catch (ConnectException unused2) {
                    throw new gb(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException unused3) {
                    throw new gb("url异常 - MalformedURLException");
                } catch (SocketException unused4) {
                    throw new gb(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException unused5) {
                    throw new gb("socket 连接超时 - SocketTimeoutException");
                } catch (UnknownHostException unused6) {
                    throw new gb("未知主机 - UnKnowHostException");
                } catch (IOException unused7) {
                    throw new gb("IO 操作异常 - IOException");
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    throw new gb(AMapException.ERROR_UNKNOWN);
                }
            } catch (gb e2) {
                e = e2;
            } catch (InterruptedIOException unused8) {
            } catch (ConnectException unused9) {
            } catch (MalformedURLException unused10) {
            } catch (SocketException unused11) {
            } catch (SocketTimeoutException unused12) {
            } catch (UnknownHostException unused13) {
            } catch (IOException unused14) {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            try {
                gd.a(i);
                b((C4588a) null);
            } catch (Throwable unused15) {
            }
            if (str != 0) {
                try {
                    str.disconnect();
                } catch (Throwable th5) {
                    C4573ha.a(th5, "ht", "mgr");
                }
            }
            throw th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(21:5|6|7|8|(3:183|184|(16:186|11|12|13|14|15|16|17|18|(3:20|21|22)(1:172)|23|(1:25)(1:168)|26|(1:28)(1:167)|29|(6:31|32|33|35|36|(3:38|39|41)(1:45))(14:50|51|52|53|(7:60|61|(4:63|64|65|(1:67)(1:73))(1:159)|(1:69)(1:72)|70|71|54)|161|74|75|76|(1:78)(1:98)|(2:91|92)|80|81|(3:83|84|85)(1:87))))|10|11|12|13|14|15|16|17|18|(0)(0)|23|(0)(0)|26|(0)(0)|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0172, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0174, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0175, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0177, code lost:
        r14 = true;
        r15 = r1;
        r1 = r3;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x017b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x017c, code lost:
        r1 = null;
        r2 = null;
        r3 = null;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0171, code lost:
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b2 A[Catch: all -> 0x0157, TRY_ENTER, TRY_LEAVE, TryCatch #21 {all -> 0x0157, blocks: (B:87:0x0153, B:127:0x01b2), top: B:188:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[Catch: all -> 0x0171, TRY_LEAVE, TryCatch #5 {all -> 0x0171, blocks: (B:18:0x003e, B:20:0x005d), top: B:163:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a A[Catch: all -> 0x0169, TRY_LEAVE, TryCatch #3 {all -> 0x0169, blocks: (B:21:0x0066, B:23:0x006e, B:31:0x0087, B:33:0x008a, B:45:0x00cc), top: B:160:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc A[Catch: all -> 0x0169, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0169, blocks: (B:21:0x0066, B:23:0x006e, B:31:0x0087, B:33:0x008a, B:45:0x00cc), top: B:160:0x0066 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r20, java.lang.String r21, boolean r22, java.lang.String r23, java.util.Map<java.lang.String, java.lang.String> r24, java.util.Map<java.lang.String, java.lang.String> r25, byte[] r26, com.amap.api.mapcore.util.Cif.InterfaceC4587a r27, int r28) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ig.a(java.lang.String, java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, byte[], com.amap.api.mapcore.util.if$a, int):void");
    }

    public static int b(int i) {
        if (i != 2 || gd.a()) {
            return i;
        }
        return 1;
    }

    private void b(C4588a c4588a) {
        a(c4588a, true, 0L, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, String> a(String str, String str2, boolean z, String str3, Map<String, String> map, Map<String, String> map2, boolean z2, int i) throws gb {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                String a = a(str, map2);
                String a2 = a(str2, map2);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    C4588a a3 = a(a, a2, z, str3, map, false, i);
                    try {
                        httpURLConnection = a3.a;
                        if (httpURLConnection.getResponseCode() < 400) {
                            try {
                                a(a3, false, currentTimeMillis, System.currentTimeMillis());
                                HashMap hashMap = new HashMap();
                                for (int i2 = 0; i2 < 50; i2++) {
                                    String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                                    if (headerFieldKey == null) {
                                        break;
                                    }
                                    hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection.getHeaderField(headerFieldKey));
                                }
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    C4573ha.a(th, "hth", "mgr");
                                }
                                return hashMap;
                            } catch (gb e) {
                                e = e;
                                throw e;
                            } catch (InterruptedIOException unused) {
                                throw new gb(AMapException.ERROR_UNKNOWN);
                            } catch (ConnectException unused2) {
                                throw new gb(AMapException.ERROR_CONNECTION);
                            } catch (MalformedURLException unused3) {
                                throw new gb("url异常 - MalformedURLException");
                            } catch (SocketException unused4) {
                                throw new gb(AMapException.ERROR_SOCKET);
                            } catch (SocketTimeoutException unused5) {
                                throw new gb("socket 连接超时 - SocketTimeoutException");
                            } catch (UnknownHostException unused6) {
                                throw new gb("未知主机 - UnKnowHostException");
                            } catch (IOException unused7) {
                                throw new gb("IO 操作异常 - IOException");
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                                throw new gb(AMapException.ERROR_UNKNOWN);
                            }
                        }
                        throw new gb("http读取header失败");
                    } catch (gb e2) {
                        e = e2;
                    } catch (InterruptedIOException unused8) {
                    } catch (ConnectException unused9) {
                    } catch (MalformedURLException unused10) {
                    } catch (SocketException unused11) {
                    } catch (SocketTimeoutException unused12) {
                    } catch (UnknownHostException unused13) {
                    } catch (IOException unused14) {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (gb e3) {
                    e = e3;
                } catch (ConnectException unused15) {
                } catch (MalformedURLException unused16) {
                } catch (SocketException unused17) {
                } catch (SocketTimeoutException unused18) {
                } catch (InterruptedIOException unused19) {
                } catch (UnknownHostException unused20) {
                } catch (IOException unused21) {
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (gb e4) {
                e = e4;
            } catch (InterruptedIOException unused22) {
            } catch (ConnectException unused23) {
            } catch (MalformedURLException unused24) {
            } catch (SocketException unused25) {
            } catch (SocketTimeoutException unused26) {
            } catch (UnknownHostException unused27) {
            } catch (IOException unused28) {
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            if (1 != 0) {
                try {
                    a((C4588a) null);
                    b((C4588a) null);
                } catch (Throwable unused29) {
                }
            }
            if (str != 0) {
                try {
                    str.disconnect();
                } catch (Throwable th7) {
                    C4573ha.a(th7, "hth", "mgr");
                }
            }
            throw th6;
        }
    }

    public static int a(int i, ii iiVar) {
        try {
        } catch (Throwable th) {
            hd.c(th, "htu", "gt");
        }
        if (gd.c()) {
            return 4;
        }
        if ((iiVar == null || iiVar.isSupportIPV6()) && i == 2) {
            if (i == b(i)) {
                return 2;
            }
        }
        return 1;
    }

    private String a(String str, String str2, int i) {
        if (i == 2 || i == 4) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ik a(String str, String str2, boolean z, String str3, Map<String, String> map, byte[] bArr, boolean z2, int i) throws gb {
        C4588a a;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                a = a(str, str2, z, str3, map, true, i);
            } catch (gb e) {
                e = e;
            } catch (InterruptedIOException unused) {
            } catch (ConnectException e2) {
                e = e2;
            } catch (MalformedURLException e3) {
                e = e3;
            } catch (SocketException e4) {
                e = e4;
            } catch (SocketTimeoutException e5) {
                e = e5;
            } catch (UnknownHostException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            } catch (Throwable th) {
                th = th;
            }
            try {
                HttpURLConnection httpURLConnection2 = a.a;
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.close();
                }
                ik a2 = a(a, z2);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th2) {
                        C4573ha.a(th2, "ht", "mPt");
                    }
                }
                return a2;
            } catch (gb e8) {
                e = e8;
                C4573ha.a(e, "ht", "mPt");
                throw e;
            } catch (InterruptedIOException unused2) {
                throw new gb(AMapException.ERROR_UNKNOWN);
            } catch (ConnectException e9) {
                e = e9;
                e.printStackTrace();
                throw new gb(AMapException.ERROR_CONNECTION);
            } catch (MalformedURLException e10) {
                e = e10;
                e.printStackTrace();
                throw new gb("url异常 - MalformedURLException");
            } catch (SocketException e11) {
                e = e11;
                e.printStackTrace();
                throw new gb(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException e12) {
                e = e12;
                e.printStackTrace();
                throw new gb("socket 连接超时 - SocketTimeoutException");
            } catch (UnknownHostException e13) {
                e = e13;
                e.printStackTrace();
                throw new gb("未知主机 - UnKnowHostException");
            } catch (IOException e14) {
                e = e14;
                e.printStackTrace();
                throw new gb("IO 操作异常 - IOException");
            } catch (Throwable th3) {
                th = th3;
                C4573ha.a(th, "ht", "mPt");
                throw new gb(AMapException.ERROR_UNKNOWN);
            }
        } catch (Throwable th4) {
            try {
                gd.a(i);
                b((C4588a) this);
            } catch (Throwable unused3) {
            }
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th5) {
                    C4573ha.a(th5, "ht", "mPt");
                }
            }
            throw th4;
        }
    }

    private String a(int i, String str, Map<String, String> map) {
        String str2 = i != 1 ? "" : id.b;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String uri = parse.buildUpon().encodedAuthority(str2).build().toString();
        if (map != null) {
            map.put("targetHost", host);
        }
        if (this.c) {
            this.j.b(str2);
        }
        return uri;
    }

    C4588a a(String str, String str2, boolean z, String str3, Map<String, String> map, boolean z2, int i) throws IOException {
        HttpsURLConnection httpsURLConnection;
        gg.c();
        String a = a(str, str2, i);
        c(i);
        if (map == null) {
            map = new HashMap<>();
        }
        C4590c a2 = this.j.a();
        if (z && !TextUtils.isEmpty(str3)) {
            a2 = this.j.a(str3);
        }
        String a3 = a(id.a, a, map);
        if (this.c) {
            a3 = gi.a(a3);
        }
        URL url = new URL(a3);
        id.InterfaceC4586a interfaceC4586a = this.k;
        URLConnection a4 = interfaceC4586a != null ? interfaceC4586a.a(this.e, url) : null;
        if (a4 == null) {
            Proxy proxy = this.e;
            if (proxy != null) {
                a4 = url.openConnection(proxy);
            } else {
                a4 = url.openConnection();
            }
        }
        if (this.c) {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) a4;
            httpsURLConnection2.setSSLSocketFactory(this.d.getSocketFactory());
            httpsURLConnection2.setHostnameVerifier(a2);
            httpsURLConnection = httpsURLConnection2;
        } else {
            httpsURLConnection = (HttpURLConnection) a4;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpsURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        }
        a(map, httpsURLConnection);
        if (z2) {
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
        } else {
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setDoInput(true);
        }
        return new C4588a(httpsURLConnection, i);
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private void a(C4588a c4588a) {
        if (c4588a == null) {
            return;
        }
        gd.a(c4588a.b);
    }

    private void a(C4588a c4588a, boolean z, long j, long j2) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        String str2 = null;
        try {
            str2 = c4588a.a.getURL().toString();
            int i = c4588a.b;
            boolean z5 = i == 3;
            z2 = (i == 2 || i == 4) ? true : true;
            z3 = z5;
            str = str2;
        } catch (Throwable unused) {
            str = str2;
            z2 = false;
            z3 = false;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        gd.a(str, z2, z3, z, Math.max(0L, j2 - j));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.mapcore.util.ik a(com.amap.api.mapcore.util.ig.C4588a r17, boolean r18) throws com.amap.api.mapcore.util.gb, java.io.IOException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ig.a(com.amap.api.mapcore.util.ig$a, boolean):com.amap.api.mapcore.util.ik");
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.i);
        } catch (Throwable th) {
            C4573ha.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
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
}
