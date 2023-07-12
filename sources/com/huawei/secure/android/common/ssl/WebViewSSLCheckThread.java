package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.o;
import okhttp3.q;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class WebViewSSLCheckThread extends Thread {
    private static final String i = WebViewSSLCheckThread.class.getSimpleName();
    private SSLSocketFactory a;
    private HostnameVerifier b;
    private org.apache.http.conn.ssl.SSLSocketFactory c;
    private X509HostnameVerifier d;
    private SslErrorHandler e;
    private String f;
    private Callback g;
    private Context h;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements okhttp3.Callback {
        final /* synthetic */ Callback a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ SslErrorHandler d;

        a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.a = callback;
            this.b = context;
            this.c = str;
            this.d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            String str = WebViewSSLCheckThread.i;
            g.b(str, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.a;
            if (callback != null) {
                callback.onCancel(this.b, this.c);
            } else {
                this.d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, q qVar) throws IOException {
            g.b(WebViewSSLCheckThread.i, "onResponse . proceed");
            Callback callback = this.a;
            if (callback != null) {
                callback.onProceed(this.b, this.c);
            } else {
                this.d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() {
        String str = i;
        g.c(str, "callbackCancel: ");
        Callback callback = this.g;
        if (callback != null) {
            callback.onCancel(this.h, this.f);
        } else if (this.e != null) {
            g.c(str, "callbackCancel 2: ");
            this.e.cancel();
        }
    }

    private void c() {
        g.c(i, "callbackProceed: ");
        Callback callback = this.g;
        if (callback != null) {
            callback.onProceed(this.h, this.f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.c;
    }

    public Callback getCallback() {
        return this.g;
    }

    public Context getContext() {
        return this.h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.a;
    }

    public String getUrl() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Exception e;
        HttpsURLConnection httpsURLConnection;
        super.run();
        HttpsURLConnection httpsURLConnection2 = null;
        if (this.c != null && this.d != null) {
            if (this.e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f)) {
                        try {
                            this.c.setHostnameVerifier(this.d);
                            org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.c;
                            if (sSLSocketFactory instanceof SecureApacheSSLSocketFactory) {
                                ((SecureApacheSSLSocketFactory) sSLSocketFactory).setContext(this.h);
                            }
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme("https", this.c, 443));
                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f));
                            HttpResponse execute = defaultHttpClient.execute(httpGet);
                            g.c(i, "status code is : " + execute.getStatusLine().getStatusCode());
                            f.a((Reader) null);
                            c();
                            return;
                        } catch (Exception e2) {
                            g.b(i, "run: exception : " + e2.getMessage());
                            b();
                            f.a((Reader) null);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    f.a((Reader) null);
                    throw th;
                }
            }
            g.b(i, "sslErrorHandler or url is null");
            b();
            return;
        }
        if (this.a != null) {
            HttpsURLConnection httpsURLConnection3 = this.b;
            try {
                if (httpsURLConnection3 != 0) {
                    try {
                        URLConnection openConnection = new URL(this.f).openConnection();
                        if (openConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) openConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.a);
                                httpsURLConnection.setHostnameVerifier(this.b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.connect();
                                httpsURLConnection2 = httpsURLConnection;
                            } catch (Exception e3) {
                                e = e3;
                                g.b(i, "exception : " + e.getMessage());
                                b();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        c();
                        return;
                    } catch (Exception e4) {
                        e = e4;
                        httpsURLConnection = null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection3 = 0;
                        if (httpsURLConnection3 != 0) {
                            httpsURLConnection3.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        b();
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.g = callback;
    }

    public void setContext(Context context) {
        this.h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, new c(context)));
        } catch (UnrecoverableKeyException e) {
            String str2 = i;
            g.b(str2, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler != null && !TextUtils.isEmpty(str) && context != null) {
            OkHttpClient.b bVar = new OkHttpClient.b();
            try {
                SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
                secureSSLSocketFactoryNew.setContext(context);
                bVar.m(secureSSLSocketFactoryNew, new c(context));
                bVar.i(new StrictHostnameVerifier());
                bVar.b().newCall(new o.a().k(str).b()).enqueue(new a(callback, context, str, sslErrorHandler));
                return;
            } catch (Exception e) {
                String str2 = i;
                g.b(str2, "checkServerCertificateWithOK: exception : " + e.getMessage());
                sslErrorHandler.cancel();
                return;
            }
        }
        g.b(i, "checkServerCertificateWithOK: handler or url or context is null");
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.e = sslErrorHandler;
        this.f = str;
        this.c = sSLSocketFactory;
        this.d = x509HostnameVerifier;
        this.g = callback;
        this.h = context;
    }
}
