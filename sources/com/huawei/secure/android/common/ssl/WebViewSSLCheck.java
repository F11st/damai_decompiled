package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.C5750b;
import com.huawei.secure.android.common.ssl.util.C5755g;
import com.huawei.secure.android.common.ssl.util.C5758j;
import java.security.cert.X509Certificate;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class WebViewSSLCheck {
    private static final String a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = a;
        C5755g.c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate a2 = C5750b.a(sslError.getCertificate());
        X509Certificate a3 = new C5758j(context).a();
        C5755g.a(str2, "checkServerCertificateNew: error certificate is : " + a2);
        if (C5750b.a(a3, a2)) {
            C5755g.c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        C5755g.b(str2, "checkServerCertificateNew: cancel");
        if (callback != null) {
            callback.onCancel(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return C5750b.a(x509Certificate, C5750b.a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(C5750b.a(str), sslError);
    }
}
