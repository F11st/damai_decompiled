package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* compiled from: Taobao */
/* renamed from: com.huawei.secure.android.common.ssl.util.j */
/* loaded from: classes10.dex */
public class C5758j {
    private static final String b = "X509CertificateUtil";
    public static final String c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";
    private Context a;

    public C5758j(Context context) {
        this.a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate a(String str, String str2) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(e);
                inputStream = this.a.getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e3) {
                e = e3;
                inputStream = null;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                inputStream = null;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e5) {
                e = e5;
                inputStream = null;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                AbstractC5754f.a(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                str = inputStream;
            } catch (IOException e6) {
                e = e6;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e7) {
                e = e7;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e9) {
                e = e9;
                C5755g.b(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                AbstractC5754f.a((InputStream) str);
                return x509Certificate;
            }
            AbstractC5754f.a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = str;
            AbstractC5754f.a(inputStream2);
            throw th;
        }
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }

    public X509Certificate a() {
        return a(g, h);
    }
}
