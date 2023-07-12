package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C8753a;

/* compiled from: Taobao */
/* renamed from: okhttp3.k */
/* loaded from: classes2.dex */
public final class C8815k {
    private final TlsVersion a;
    private final C8747e b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private C8815k(TlsVersion tlsVersion, C8747e c8747e, List<Certificate> list, List<Certificate> list2) {
        this.a = tlsVersion;
        this.b = c8747e;
        this.c = list;
        this.d = list2;
    }

    public static C8815k b(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
                C8747e b = C8747e.b(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol != null) {
                    if (!"NONE".equals(protocol)) {
                        TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                        try {
                            certificateArr = sSLSession.getPeerCertificates();
                        } catch (SSLPeerUnverifiedException unused) {
                            certificateArr = null;
                        }
                        if (certificateArr != null) {
                            emptyList = C8753a.u(certificateArr);
                        } else {
                            emptyList = Collections.emptyList();
                        }
                        Certificate[] localCertificates = sSLSession.getLocalCertificates();
                        if (localCertificates != null) {
                            emptyList2 = C8753a.u(localCertificates);
                        } else {
                            emptyList2 = Collections.emptyList();
                        }
                        return new C8815k(forJavaName, b, emptyList, emptyList2);
                    }
                    throw new IOException("tlsVersion == NONE");
                }
                throw new IllegalStateException("tlsVersion == null");
            }
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public static C8815k c(TlsVersion tlsVersion, C8747e c8747e, List<Certificate> list, List<Certificate> list2) {
        Objects.requireNonNull(tlsVersion, "tlsVersion == null");
        Objects.requireNonNull(c8747e, "cipherSuite == null");
        return new C8815k(tlsVersion, c8747e, C8753a.t(list), C8753a.t(list2));
    }

    private List<String> e(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public C8747e a() {
        return this.b;
    }

    public List<Certificate> d() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C8815k) {
            C8815k c8815k = (C8815k) obj;
            return this.a.equals(c8815k.a) && this.b.equals(c8815k.b) && this.c.equals(c8815k.c) && this.d.equals(c8815k.d);
        }
        return false;
    }

    public List<Certificate> f() {
        return this.c;
    }

    public TlsVersion g() {
        return this.a;
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.a + " cipherSuite=" + this.b + " peerCertificates=" + e(this.c) + " localCertificates=" + e(this.d) + '}';
    }
}
