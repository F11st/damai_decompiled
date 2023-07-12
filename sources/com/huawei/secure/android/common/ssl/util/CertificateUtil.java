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
/* loaded from: classes10.dex */
public final class CertificateUtil {
    private static final String a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static X509Certificate getHwCbgRootCA(Context context) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(j.e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
            } catch (IOException e) {
                e = e;
                inputStream = null;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e2) {
                e = e2;
                inputStream = null;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                inputStream = null;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e4) {
                e = e4;
                inputStream = null;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                f.a(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(j.f);
                context = inputStream;
            } catch (IOException e5) {
                e = e5;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e6) {
                e = e6;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e8) {
                e = e8;
                g.b(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            }
            f.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th2) {
            inputStream2 = context;
            th = th2;
            f.a(inputStream2);
            throw th;
        }
    }
}
