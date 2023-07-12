package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.q */
/* loaded from: classes12.dex */
public final class CallableC4085q implements Callable<C4089u> {
    public static final HttpRequestRetryHandler e = new C4066ad();
    public C4080l a;
    public Context b;
    public C4083o c;
    public String d;
    public HttpUriRequest f;
    public CookieManager i;
    public AbstractHttpEntity j;
    public HttpHost k;
    public URL l;
    public String q;
    public HttpContext g = new BasicHttpContext();
    public CookieStore h = new BasicCookieStore();
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public String p = null;

    public CallableC4085q(C4080l c4080l, C4083o c4083o) {
        this.a = c4080l;
        this.b = c4080l.a;
        this.c = c4083o;
    }

    public static long a(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if ("max-age".equalsIgnoreCase(strArr[i])) {
                int i2 = i + 1;
                if (strArr[i2] != null) {
                    try {
                        return Long.parseLong(strArr[i2]);
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0L;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        Header[] allHeaders;
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private C4089u a(HttpResponse httpResponse, int i, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        Thread.currentThread().getId();
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity == null) {
                httpResponse.getStatusLine().getStatusCode();
                return null;
            }
            return null;
        }
        Thread.currentThread().getId();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(entity, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.o = false;
            this.a.c(System.currentTimeMillis() - currentTimeMillis);
            this.a.a(byteArray.length);
            C4084p c4084p = new C4084p(a(httpResponse), i, str, byteArray);
            long b = b(httpResponse);
            Header contentType = httpResponse.getEntity().getContentType();
            if (contentType != null) {
                HashMap<String, String> a = a(contentType.getValue());
                str3 = a.get("charset");
                str2 = a.get("Content-Type");
            } else {
                str2 = null;
            }
            c4084p.b(str2);
            c4084p.a(str3);
            c4084p.a(System.currentTimeMillis());
            c4084p.b(b);
            try {
                byteArrayOutputStream.close();
                return c4084p;
            } catch (IOException e2) {
                throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                }
            }
            throw th;
        }
    }

    public static HashMap<String, String> a(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a = C4067b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a.read(bArr);
                    if (read == -1 || this.c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    this.c.f();
                }
                outputStream.flush();
            } catch (Exception e2) {
                e2.getCause();
                throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
            }
        } finally {
            C4086r.a(a);
        }
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return C4067b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private URI b() {
        String a = this.c.a();
        String str = this.d;
        if (str != null) {
            a = str;
        }
        if (a != null) {
            return new URI(a);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b = this.c.b();
            String b2 = this.c.b("gzip");
            if (b != null) {
                if (TextUtils.equals(b2, "true")) {
                    this.j = C4067b.a(b);
                } else {
                    this.j = new ByteArrayEntity(b);
                }
                this.j.setContentType(this.c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLException -> 0x035a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, NoHttpResponseException -> 0x02d8, ConnectTimeoutException -> 0x031a, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:50:0x00f3, B:97:0x022f, B:98:0x023a, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLException -> 0x035a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, NoHttpResponseException -> 0x02d8, ConnectTimeoutException -> 0x031a, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:50:0x00f3, B:97:0x022f, B:98:0x023a, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0146 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLException -> 0x035a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, NoHttpResponseException -> 0x02d8, ConnectTimeoutException -> 0x031a, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:50:0x00f3, B:97:0x022f, B:98:0x023a, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0153 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLException -> 0x035a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, NoHttpResponseException -> 0x02d8, ConnectTimeoutException -> 0x031a, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:50:0x00f3, B:97:0x022f, B:98:0x023a, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c8  */
    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.android.phone.mrpc.core.C4089u call() {
        /*
            Method dump skipped, instructions count: 989
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.CallableC4085q.call():com.alipay.android.phone.mrpc.core.u");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (TextUtils.isEmpty(this.q)) {
            String b = this.c.b("operationType");
            this.q = b;
            return b;
        }
        return this.q;
    }

    private int g() {
        URL h = h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.c.a());
        this.l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.i = cookieManager2;
        return cookieManager2;
    }

    public final C4083o a() {
        return this.c;
    }
}
