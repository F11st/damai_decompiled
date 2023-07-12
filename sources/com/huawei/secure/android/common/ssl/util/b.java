package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final String a = "b";
    private static final int b = 5;

    public static X509Certificate a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e) {
            String str2 = a;
            g.b(str2, "generateX509FromStr: CertificateException" + e.getMessage());
            return null;
        }
    }

    public static boolean b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e) {
                e = e;
                g.b(a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e2) {
                e = e2;
                g.b(a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e3) {
                g.b(a, "verifyCertificateDate : exception : " + e3.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return !a(x509Certificate, x509CertificateArr) && !a(x509CertificateArr, x509crl) && a(x509CertificateArr[x509CertificateArr.length - 1], str) && b(x509CertificateArr);
    }

    public static boolean a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl != null) {
            try {
                Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
                if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                    return true;
                }
                for (X509CRLEntry x509CRLEntry : revokedCertificates) {
                    if (arrayList.contains(x509CRLEntry.getSerialNumber())) {
                        g.b(a, "verify: certificate revoked");
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                g.b(a, "verify: revoked verify exception : " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        g.b(a, "verify: subject name is error");
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            g.b(a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e) {
            String str = a;
            g.b(str, "verify: publickey InvalidKeyException " + e.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            String str2 = a;
            g.b(str2, "verify: publickey NoSuchAlgorithmException " + e2.getMessage());
            return false;
        } catch (NoSuchProviderException e3) {
            String str3 = a;
            g.b(str3, "verify: publickey NoSuchProviderException " + e3.getMessage());
            return false;
        } catch (SignatureException e4) {
            String str4 = a;
            g.b(str4, "verify: publickey SignatureException " + e4.getMessage());
            return false;
        } catch (CertificateException e5) {
            String str5 = a;
            g.b(str5, "verify: publickey CertificateException " + e5.getMessage());
            return false;
        } catch (Exception e6) {
            String str6 = a;
            g.b(str6, "verify: Exception " + e6.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i = 0;
        while (i < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i].verify(x509CertificateArr[i - 1].getPublicKey());
                } else {
                    g.b(a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i++;
            principal = subjectDN;
        }
        return a(x509Certificate, x509CertificateArr[0]) && b(x509CertificateArr) && a(x509Certificate) && a(x509CertificateArr);
    }

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e) {
                g.a(a, "exception", e);
            }
        }
        return null;
    }

    public static boolean a(X509Certificate[] x509CertificateArr) {
        for (int i = 0; i < x509CertificateArr.length - 1; i++) {
            if (!a(x509CertificateArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
