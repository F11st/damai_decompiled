package com.uploader.implement.b.a;

import android.text.TextUtils;
import com.uploader.implement.C7364a;
import com.uploader.implement.C7399c;
import com.uploader.implement.b.InterfaceC7395b;
import com.uploader.implement.e.C7408b;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.android.agoo.message.MessageService;
import tb.k33;
import tb.p73;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b.a.e */
/* loaded from: classes11.dex */
public class C7391e extends AbstractC7381a {
    HttpURLConnection d;
    boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.b.a.e$a */
    /* loaded from: classes11.dex */
    public class C7392a implements HostnameVerifier {
        final /* synthetic */ String a;

        C7392a(C7391e c7391e, String str) {
            this.a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7391e(C7399c c7399c, C7394g c7394g) {
        super(c7399c, c7394g);
        this.d = null;
        this.e = c7394g.f.startsWith("https://");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(java.net.HttpURLConnection r17, com.uploader.implement.b.InterfaceC7395b r18) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploader.implement.b.a.C7391e.h(java.net.HttpURLConnection, com.uploader.implement.b.b):void");
    }

    private void i(HttpURLConnection httpURLConnection, String str) {
        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new C7392a(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws Exception {
        if (this.d != null) {
            return;
        }
        C7394g c7394g = (C7394g) this.a;
        URL url = new URL(c7394g.f);
        if (this.e) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            this.d = httpURLConnection;
            i(httpURLConnection, c7394g.g);
        } else {
            Proxy proxy = null;
            if (!TextUtils.isEmpty(c7394g.c) && c7394g.d > 0) {
                proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c7394g.c, c7394g.d));
            }
            if (proxy != null) {
                this.d = (HttpURLConnection) url.openConnection(proxy);
            } else {
                this.d = (HttpURLConnection) url.openConnection();
            }
        }
        this.d.setConnectTimeout(10000);
        this.d.setConnectTimeout(10000);
        this.d.setRequestMethod("POST");
        this.d.setDoOutput(true);
        this.d.setDoInput(true);
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public void a(final p73 p73Var, final int i) {
        C7408b.a(new Runnable() { // from class: com.uploader.implement.b.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC7395b e = C7391e.this.e();
                try {
                    C7391e.this.k();
                    Map<String, String> map = p73Var.a;
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            C7391e.this.d.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (C7364a.d(4)) {
                        C7364a.a(4, "ShortLivedConnection", C7391e.this.c + " URL:" + C7391e.this.d.getURL().toString() + " RequestHeaders:" + C7391e.this.d.getRequestProperties());
                    }
                    try {
                        C7391e.this.d.connect();
                        if (e != null) {
                            e.a(C7391e.this, i);
                        }
                        if (p73Var.b != null) {
                            OutputStream outputStream = null;
                            try {
                                try {
                                    outputStream = C7391e.this.d.getOutputStream();
                                    p73 p73Var2 = p73Var;
                                    outputStream.write(p73Var2.b, p73Var2.c, p73Var2.d);
                                    if (C7364a.d(4)) {
                                        C7364a.a(4, "ShortLivedConnection", C7391e.this.c + " BODY:" + new String(p73Var.b));
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (IOException e2) {
                                        if (C7364a.d(8)) {
                                            C7364a.a(8, "ShortLivedConnection", e2.toString());
                                        }
                                    }
                                } catch (Exception e3) {
                                    if (C7364a.d(8)) {
                                        C7364a.b(8, "ShortLivedConnection", C7391e.this.c + " send data error.", e3);
                                    }
                                    C7391e.this.d.disconnect();
                                    k33 k33Var = new k33(MessageService.MSG_DB_COMPLETE, "5", "send data error", true);
                                    if (e != null) {
                                        e.a(C7391e.this, k33Var);
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                            return;
                                        } catch (IOException e4) {
                                            if (C7364a.d(8)) {
                                                C7364a.a(8, "ShortLivedConnection", e4.toString());
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e5) {
                                        if (C7364a.d(8)) {
                                            C7364a.a(8, "ShortLivedConnection", e5.toString());
                                        }
                                    }
                                }
                                throw th;
                            }
                        }
                        if (e != null) {
                            e.b(C7391e.this, i);
                        }
                        C7391e c7391e = C7391e.this;
                        c7391e.h(c7391e.d, e);
                    } catch (Exception e6) {
                        if (C7364a.d(8)) {
                            C7364a.b(8, "ShortLivedConnection", "connect error.", e6);
                        }
                        k33 k33Var2 = new k33(MessageService.MSG_DB_COMPLETE, "4", "connect error", true);
                        if (e != null) {
                            e.a(C7391e.this, k33Var2);
                        }
                    }
                } catch (Exception e7) {
                    if (C7364a.d(8)) {
                        C7364a.b(8, "ShortLivedConnection", C7391e.this.c + " open connection error, ", e7);
                    }
                    k33 k33Var3 = new k33(MessageService.MSG_DB_COMPLETE, "3", "open connection error", true);
                    if (e != null) {
                        e.a(C7391e.this, k33Var3);
                    }
                }
            }
        });
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public boolean b() {
        return true;
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public boolean c() {
        return true;
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public boolean d() {
        return false;
    }

    void j() {
        try {
            this.d.disconnect();
        } catch (Exception unused) {
        }
    }
}
