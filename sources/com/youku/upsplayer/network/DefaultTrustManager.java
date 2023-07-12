package com.youku.upsplayer.network;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DefaultTrustManager implements X509TrustManager {
    private static final String TAG = "DefaultTrustManager";

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        CertificateException certificateException = null;
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            certificateException = new CertificateException("Certificate chain is invalid.");
        } else if (str == null || str.length() == 0) {
            certificateException = new CertificateException("Authentication type is invalid.");
        } else {
            try {
                KeyStore.getInstance(KeyStore.getDefaultType()).load(null);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init((KeyStore) null);
                for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                    ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
                }
            } catch (Throwable th) {
                throw new CertificateException(th);
            }
        }
        if (certificateException != null) {
            throw new CertificateException(certificateException);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
