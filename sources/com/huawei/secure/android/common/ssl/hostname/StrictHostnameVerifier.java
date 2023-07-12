package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.C5755g;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class StrictHostnameVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            C5755g.a("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            C5748b.a(str, x509Certificate, true);
            return true;
        } catch (SSLException e) {
            C5755g.b("", "SSLException : " + e.getMessage());
            return false;
        }
    }
}
