package anet.channel.session;

import android.net.Network;
import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.cf0;
import tb.he;
import tb.je;
import tb.m01;
import tb.ox1;
import tb.x6;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.session.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a implements HostnameVerifier {
        final /* synthetic */ String a;

        C0014a(String str) {
            this.a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class b {
        public int a;
        public Map<String, List<String>> b;
        public int c;
        public boolean d;
    }

    public static b a(anet.channel.request.a aVar) {
        return d(aVar, null, false);
    }

    public static void b(anet.channel.request.a aVar, RequestCb requestCb) {
        d(aVar, requestCb, false);
    }

    public static void c(anet.channel.request.a aVar, RequestCb requestCb, boolean z) {
        d(aVar, requestCb, z);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:9|10|(2:185|186)|12|13|14|15|16|17|18|19|20|21|(2:25|(5:27|28|29|31|32)(2:36|37))|38|(12:49|(1:51)|53|(1:55)|56|57|58|(1:60)|(1:62)|64|65|66)|71|(1:73)|74|57|58|(0)|(0)|64|65|66) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02ba, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03d4 A[Catch: all -> 0x02fc, TRY_LEAVE, TryCatch #15 {all -> 0x02fc, blocks: (B:12:0x0036, B:14:0x0040, B:20:0x00a3, B:22:0x00b6, B:24:0x00bb, B:26:0x00df, B:28:0x0141, B:30:0x014b, B:32:0x0151, B:38:0x01bd, B:39:0x01d2, B:41:0x01f6, B:50:0x0209, B:52:0x0224, B:55:0x0234, B:56:0x023b, B:61:0x025a, B:64:0x0286, B:66:0x02ad, B:59:0x024b, B:60:0x0252, B:101:0x0302, B:103:0x0308, B:104:0x030c, B:106:0x0314, B:108:0x032a, B:107:0x0325, B:116:0x034b, B:124:0x0380, B:134:0x03a7, B:136:0x03d4, B:146:0x0411, B:148:0x043e, B:156:0x0478, B:164:0x04a0, B:172:0x04c6, B:180:0x04ec), top: B:207:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x043e A[Catch: all -> 0x02fc, TRY_LEAVE, TryCatch #15 {all -> 0x02fc, blocks: (B:12:0x0036, B:14:0x0040, B:20:0x00a3, B:22:0x00b6, B:24:0x00bb, B:26:0x00df, B:28:0x0141, B:30:0x014b, B:32:0x0151, B:38:0x01bd, B:39:0x01d2, B:41:0x01f6, B:50:0x0209, B:52:0x0224, B:55:0x0234, B:56:0x023b, B:61:0x025a, B:64:0x0286, B:66:0x02ad, B:59:0x024b, B:60:0x0252, B:101:0x0302, B:103:0x0308, B:104:0x030c, B:106:0x0314, B:108:0x032a, B:107:0x0325, B:116:0x034b, B:124:0x0380, B:134:0x03a7, B:136:0x03d4, B:146:0x0411, B:148:0x043e, B:156:0x0478, B:164:0x04a0, B:172:0x04c6, B:180:0x04ec), top: B:207:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0464 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0286 A[Catch: SSLException -> 0x02f0, SSLHandshakeException -> 0x02f3, all -> 0x02fc, Exception -> 0x0300, IOException -> 0x0347, CancellationException -> 0x037c, ConnectException -> 0x0474, ConnectTimeoutException -> 0x049c, SocketTimeoutException -> 0x04c2, UnknownHostException -> 0x04e8, TRY_ENTER, TryCatch #15 {all -> 0x02fc, blocks: (B:12:0x0036, B:14:0x0040, B:20:0x00a3, B:22:0x00b6, B:24:0x00bb, B:26:0x00df, B:28:0x0141, B:30:0x014b, B:32:0x0151, B:38:0x01bd, B:39:0x01d2, B:41:0x01f6, B:50:0x0209, B:52:0x0224, B:55:0x0234, B:56:0x023b, B:61:0x025a, B:64:0x0286, B:66:0x02ad, B:59:0x024b, B:60:0x0252, B:101:0x0302, B:103:0x0308, B:104:0x030c, B:106:0x0314, B:108:0x032a, B:107:0x0325, B:116:0x034b, B:124:0x0380, B:134:0x03a7, B:136:0x03d4, B:146:0x0411, B:148:0x043e, B:156:0x0478, B:164:0x04a0, B:172:0x04c6, B:180:0x04ec), top: B:207:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02ad A[Catch: SSLException -> 0x02f0, SSLHandshakeException -> 0x02f3, all -> 0x02fc, Exception -> 0x0300, IOException -> 0x0347, CancellationException -> 0x037c, ConnectException -> 0x0474, ConnectTimeoutException -> 0x049c, SocketTimeoutException -> 0x04c2, UnknownHostException -> 0x04e8, TRY_LEAVE, TryCatch #15 {all -> 0x02fc, blocks: (B:12:0x0036, B:14:0x0040, B:20:0x00a3, B:22:0x00b6, B:24:0x00bb, B:26:0x00df, B:28:0x0141, B:30:0x014b, B:32:0x0151, B:38:0x01bd, B:39:0x01d2, B:41:0x01f6, B:50:0x0209, B:52:0x0224, B:55:0x0234, B:56:0x023b, B:61:0x025a, B:64:0x0286, B:66:0x02ad, B:59:0x024b, B:60:0x0252, B:101:0x0302, B:103:0x0308, B:104:0x030c, B:106:0x0314, B:108:0x032a, B:107:0x0325, B:116:0x034b, B:124:0x0380, B:134:0x03a7, B:136:0x03d4, B:146:0x0411, B:148:0x043e, B:156:0x0478, B:164:0x04a0, B:172:0x04c6, B:180:0x04ec), top: B:207:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static anet.channel.session.a.b d(anet.channel.request.a r21, anet.channel.RequestCb r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.a.d(anet.channel.request.a, anet.channel.RequestCb, boolean):anet.channel.session.a$b");
    }

    private static HttpURLConnection e(anet.channel.request.a aVar, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> l = NetworkStatusHelper.l();
        Proxy proxy = l != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) l.first, ((Integer) l.second).intValue())) : null;
        ox1.a();
        NetworkStatusHelper.i().isMobile();
        URL p = aVar.p();
        Network d = NetworkStatusHelper.d();
        if (z && d != null && Build.VERSION.SDK_INT >= 23) {
            ALog.e("awcn.HttpConnector", "openConnection by cellular", aVar.n(), new Object[0]);
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) d.openConnection(p, proxy);
            } else {
                httpURLConnection = (HttpURLConnection) d.openConnection(p);
            }
        } else if (proxy != null) {
            httpURLConnection = (HttpURLConnection) p.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) p.openConnection();
        }
        httpURLConnection.setConnectTimeout(aVar.e());
        httpURLConnection.setReadTimeout(aVar.l());
        httpURLConnection.setRequestMethod(aVar.k());
        if (aVar.a()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> g = aVar.g();
        for (Map.Entry<String, String> entry : g.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String str = g.get(BizTime.HOST);
        if (str == null) {
            str = aVar.h();
        }
        String e = aVar.j().a() ? zh2.e(str, ":", String.valueOf(aVar.j().c())) : str;
        httpURLConnection.setRequestProperty(BizTime.HOST, e);
        if (NetworkStatusHelper.b().equals("cmwap")) {
            httpURLConnection.setRequestProperty("x-online-host", e);
        }
        if (!g.containsKey("Accept-Encoding")) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (p.getProtocol().equalsIgnoreCase("https")) {
            i(httpURLConnection, aVar, str);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void f(anet.channel.request.a aVar, b bVar, RequestCb requestCb, int i, Throwable th) {
        String b2 = cf0.b(i);
        ALog.e("awcn.HttpConnector", "onException", aVar.n(), "errorCode", Integer.valueOf(i), "errMsg", b2, "url", aVar.q(), "host", aVar.h());
        if (bVar != null) {
            bVar.a = i;
        }
        if (!aVar.r.isDone.get()) {
            aVar.r.statusCode = i;
            aVar.r.msg = b2;
            aVar.r.rspEnd = System.currentTimeMillis();
            anet.channel.fulltrace.a.f().log(aVar.r.span, "netRspRecvEnd", null);
            if (i != -204) {
                x6.b().commitStat(new ExceptionStatistic(i, b2, aVar.r, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i, b2, aVar.r);
        }
    }

    private static void g(HttpURLConnection httpURLConnection, anet.channel.request.a aVar, b bVar, RequestCb requestCb) throws IOException, CancellationException {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        anet.channel.util.a aVar2;
        httpURLConnection.getURL().toString();
        anet.channel.util.a aVar3 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                ALog.k("awcn.HttpConnector", "File not found", aVar.n(), "url", aVar.q());
            }
            try {
                inputStream = httpURLConnection.getErrorStream();
            } catch (Exception e2) {
                ALog.d("awcn.HttpConnector", "get error stream failed.", aVar.n(), e2, new Object[0]);
                inputStream = null;
            }
        }
        if (inputStream == null) {
            f(aVar, bVar, requestCb, cf0.ERROR_IO_EXCEPTION, null);
            return;
        }
        if (requestCb == null) {
            int i = bVar.c;
            if (i <= 0) {
                i = 1024;
            } else if (bVar.d) {
                i *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            aVar2 = new anet.channel.util.a(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            InputStream gZIPInputStream = bVar.d ? new GZIPInputStream(aVar2) : aVar2;
            he heVar = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (heVar == null) {
                    heVar = je.a().c(2048);
                }
                int e3 = heVar.e(gZIPInputStream);
                if (e3 != -1) {
                    if (byteArrayOutputStream != null) {
                        heVar.i(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(heVar, false);
                        heVar = null;
                    }
                    long j = e3;
                    aVar.r.recDataSize += j;
                    aVar.r.rspBodyInflateSize += j;
                } else {
                    if (byteArrayOutputStream != null) {
                        heVar.f();
                    } else {
                        requestCb.onDataReceive(heVar, true);
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.toByteArray();
                    }
                    aVar.r.recDataTime = System.currentTimeMillis() - aVar.r.rspStart;
                    aVar.r.rspBodyDeflateSize = aVar2.a();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            throw new CancellationException("task cancelled");
        } catch (Throwable th2) {
            th = th2;
            aVar3 = aVar2;
            aVar.r.recDataTime = System.currentTimeMillis() - aVar.r.rspStart;
            aVar.r.rspBodyDeflateSize = aVar3.a();
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    private static int h(HttpURLConnection httpURLConnection, anet.channel.request.a aVar) {
        int i = 0;
        if (aVar.a()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int v = aVar.v(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            ALog.d("awcn.HttpConnector", "postData", aVar.n(), e, new Object[0]);
                        }
                    }
                    i = v;
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            ALog.d("awcn.HttpConnector", "postData", aVar.n(), e2, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                ALog.d("awcn.HttpConnector", "postData error", aVar.n(), e3, new Object[0]);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e4) {
                        ALog.d("awcn.HttpConnector", "postData", aVar.n(), e4, new Object[0]);
                    }
                }
            }
            long j = i;
            aVar.r.reqBodyInflateSize = j;
            aVar.r.reqBodyDeflateSize = j;
            aVar.r.sendDataSize = j;
        }
        return i;
    }

    private static void i(HttpURLConnection httpURLConnection, anet.channel.request.a aVar, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (aVar.o() != null) {
            httpsURLConnection.setSSLSocketFactory(aVar.o());
        } else if (m01.b() != null) {
            httpsURLConnection.setSSLSocketFactory(m01.b());
            if (ALog.g(2)) {
                ALog.f("awcn.HttpConnector", "HttpSslUtil", aVar.n(), "SslSocketFactory", m01.b());
            }
        }
        if (aVar.i() != null) {
            httpsURLConnection.setHostnameVerifier(aVar.i());
        } else if (m01.a() != null) {
            httpsURLConnection.setHostnameVerifier(m01.a());
            if (ALog.g(2)) {
                ALog.f("awcn.HttpConnector", "HttpSslUtil", aVar.n(), "HostnameVerifier", m01.a());
            }
        } else {
            httpsURLConnection.setHostnameVerifier(new C0014a(str));
        }
    }
}
