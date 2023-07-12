package org.android.spdy;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: org.android.spdy.a */
/* loaded from: classes2.dex */
class C8877a {
    private static volatile boolean e;
    private static final Object f = new Object();
    private static C8877a g = new C8877a();
    private Set<TrustAnchor> a;
    private volatile PKIXParameters b = null;
    private volatile CertPathValidator c = null;
    private volatile CertificateFactory d = null;

    private C8877a() {
        this.a = null;
        this.a = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C8877a e() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0034 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = org.android.spdy.C8877a.e     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L7
            monitor-exit(r6)
            return
        L7:
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.security.cert.CertificateException -> L27 java.security.NoSuchAlgorithmException -> L2d java.lang.Throwable -> L6a
            java.lang.String r4 = "PKIX"
            java.security.cert.CertPathValidator r4 = java.security.cert.CertPathValidator.getInstance(r4)     // Catch: java.security.cert.CertificateException -> L23 java.security.NoSuchAlgorithmException -> L25 java.lang.Throwable -> L6a
            java.lang.Object r5 = org.android.spdy.C8877a.f     // Catch: java.security.cert.CertificateException -> L23 java.security.NoSuchAlgorithmException -> L25 java.lang.Throwable -> L6a
            monitor-enter(r5)     // Catch: java.security.cert.CertificateException -> L23 java.security.NoSuchAlgorithmException -> L25 java.lang.Throwable -> L6a
            r6.d = r3     // Catch: java.lang.Throwable -> L20
            r6.c = r4     // Catch: java.lang.Throwable -> L20
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L20
            r0 = 1
            goto L32
        L20:
            r4 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L20
            throw r4     // Catch: java.security.cert.CertificateException -> L23 java.security.NoSuchAlgorithmException -> L25 java.lang.Throwable -> L6a
        L23:
            r4 = move-exception
            goto L29
        L25:
            r4 = move-exception
            goto L2f
        L27:
            r4 = move-exception
            r3 = r2
        L29:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L6a
            goto L32
        L2d:
            r4 = move-exception
            r3 = r2
        L2f:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L6a
        L32:
            if (r0 != 0) goto L36
            monitor-exit(r6)
            return
        L36:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            java.lang.String r4 = "-----BEGIN CERTIFICATE-----\nMIIDdTCCAl2gAwIBAgILBAAAAAABFUtaw5QwDQYJKoZIhvcNAQEFBQAwVzELMAkG\nA1UEBhMCQkUxGTAXBgNVBAoTEEdsb2JhbFNpZ24gbnYtc2ExEDAOBgNVBAsTB1Jv\nb3QgQ0ExGzAZBgNVBAMTEkdsb2JhbFNpZ24gUm9vdCBDQTAeFw05ODA5MDExMjAw\nMDBaFw0yODAxMjgxMjAwMDBaMFcxCzAJBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9i\nYWxTaWduIG52LXNhMRAwDgYDVQQLEwdSb290IENBMRswGQYDVQQDExJHbG9iYWxT\naWduIFJvb3QgQ0EwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDaDuaZ\njc6j40+Kfvvxi4Mla+pIH/EqsLmVEQS98GPR4mdmzxzdzxtIK+6NiY6arymAZavp\nxy0Sy6scTHAHoT0KMM0VjU/43dSMUBUc71DuxC73/OlS8pF94G3VNTCOXkNz8kHp\n1Wrjsok6Vjk4bwY8iGlbKk3Fp1S4bInMm/k8yuX9ifUSPJJ4ltbcdG6TRGHRjcdG\nsnUOhugZitVtbNV4FpWi6cgKOOvyJBNPc1STE4U6G7weNLWLBYy5d4ux2x8gkasJ\nU26Qzns3dLlwR5EiUWMWea6xrkEmCMgZK9FGqkjWZCrXgzT/LCrBbBlDSgeF59N8\n9iFo7+ryUp9/k5DPAgMBAAGjQjBAMA4GA1UdDwEB/wQEAwIBBjAPBgNVHRMBAf8E\nBTADAQH/MB0GA1UdDgQWBBRge2YaRQ2XyolQL30EzTSo//z9SzANBgkqhkiG9w0B\nAQUFAAOCAQEA1nPnfE920I2/7LqivjTFKDK1fPxsnCwrvQmeU79rXqoRSLblCKOz\nyj1hTdNGCbM+w6DjY1Ub8rrvrTnhQ7k4o+YviiY776BQVvnGCv04zcQLcFGUl5gE\n38NflNUVyRRBnMRddWQVDf9VMOyGj/8N7yy5Y0b2qvzfvGn9LhJIZJrglfCm7ymP\nAbEVtQwdpf5pLGkkeB6zpxxxYu7KyJesF12KwvhHhm4qxFYxldBniYUr+WymXUad\nDKqC5JlR3XC321Y9YeRq4VzW9v493kHMB65jUr9TU/Qr6cf9tveCX4XSQRjbgbME\nHMUfpIBvFSDJ3gyICh3WZlXi/EjJKSZp4A==\n-----END CERTIFICATE-----\n"
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            byte[] r4 = r4.getBytes(r5)     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            r0.<init>(r4)     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            java.security.cert.Certificate r0 = r3.generateCertificate(r0)     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            java.lang.Object r3 = org.android.spdy.C8877a.f     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            monitor-enter(r3)     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            java.util.Set<java.security.cert.TrustAnchor> r4 = r6.a     // Catch: java.lang.Throwable -> L61
            java.security.cert.TrustAnchor r5 = new java.security.cert.TrustAnchor     // Catch: java.lang.Throwable -> L61
            r5.<init>(r0, r2)     // Catch: java.lang.Throwable -> L61
            r4.add(r5)     // Catch: java.lang.Throwable -> L61
            java.util.Set<java.security.cert.TrustAnchor> r0 = r6.a     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L5d
            r6.g(r0)     // Catch: java.lang.Throwable -> L61
        L5d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L61
            org.android.spdy.C8877a.e = r1     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
            goto L68
        L61:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L61
            throw r0     // Catch: java.security.cert.CertificateException -> L64 java.lang.Throwable -> L6a
        L64:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6a
        L68:
            monitor-exit(r6)
            return
        L6a:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.C8877a.a():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CertPathValidator b() {
        CertPathValidator certPathValidator;
        synchronized (f) {
            certPathValidator = this.c;
        }
        return certPathValidator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PKIXParameters c() {
        PKIXParameters pKIXParameters;
        synchronized (f) {
            pKIXParameters = this.b;
        }
        return pKIXParameters;
    }

    public CertificateFactory d() {
        CertificateFactory certificateFactory;
        synchronized (f) {
            if (this.d == null) {
                try {
                    this.d = CertificateFactory.getInstance("X.509");
                } catch (CertificateException e2) {
                    e2.printStackTrace();
                }
            }
            certificateFactory = this.d;
        }
        return certificateFactory;
    }

    public Set<TrustAnchor> f() {
        Set<TrustAnchor> set;
        synchronized (f) {
            set = this.a;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PKIXParameters g(Set<TrustAnchor> set) {
        PKIXParameters pKIXParameters = null;
        if (set == null) {
            return null;
        }
        try {
            PKIXParameters pKIXParameters2 = new PKIXParameters(set);
            try {
                pKIXParameters2.setRevocationEnabled(false);
                this.b = pKIXParameters2;
                return pKIXParameters2;
            } catch (InvalidAlgorithmParameterException e2) {
                e = e2;
                pKIXParameters = pKIXParameters2;
                e.printStackTrace();
                return pKIXParameters;
            }
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
        }
    }
}
