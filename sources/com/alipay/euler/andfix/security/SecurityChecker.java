package com.alipay.euler.andfix.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alipay.euler.andfix.log.Log;
import com.alipay.euler.andfix.patch.PatchManager;
import com.uc.webview.export.extension.UCCore;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SecurityChecker {
    public static final String SP_MD5 = "-md5";
    private final Context a;
    private PublicKey b;
    private boolean c;

    public SecurityChecker(Context context, boolean z) {
        this.a = context;
        d(context, z);
    }

    private boolean a(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            for (int length = certificateArr.length - 1; length >= 0; length--) {
                try {
                    certificateArr[length].verify(this.b);
                    return true;
                } catch (Exception e) {
                    Log.e("SecurityChecker", file.getAbsolutePath(), e);
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0052: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:31:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(java.io.File r8) {
        /*
            r7 = this;
            java.lang.String r0 = "getFileMD5"
            java.lang.String r1 = "SecurityChecker"
            boolean r2 = r8.isFile()
            r3 = 0
            if (r2 != 0) goto Lc
            return r3
        Lc:
            r2 = 8192(0x2000, float:1.148E-41)
            byte[] r2 = new byte[r2]
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
        L1b:
            int r8 = r5.read(r2)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L51
            r6 = -1
            if (r8 == r6) goto L27
            r6 = 0
            r4.update(r2, r6, r8)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L51
            goto L1b
        L27:
            r5.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r8 = move-exception
            com.alipay.euler.andfix.log.Log.e(r1, r0, r8)
        L2f:
            java.math.BigInteger r8 = new java.math.BigInteger
            byte[] r0 = r4.digest()
            r8.<init>(r0)
            java.lang.String r8 = r8.toString()
            return r8
        L3d:
            r8 = move-exception
            goto L43
        L3f:
            r8 = move-exception
            goto L53
        L41:
            r8 = move-exception
            r5 = r3
        L43:
            com.alipay.euler.andfix.log.Log.e(r1, r0, r8)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L50
            r5.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r8 = move-exception
            com.alipay.euler.andfix.log.Log.e(r1, r0, r8)
        L50:
            return r3
        L51:
            r8 = move-exception
            r3 = r5
        L53:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.io.IOException -> L59
            goto L5d
        L59:
            r2 = move-exception
            com.alipay.euler.andfix.log.Log.e(r1, r0, r2)
        L5d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.euler.andfix.security.SecurityChecker.b(java.io.File):java.lang.String");
    }

    private String c(String str) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(PatchManager.SP_NAME, 4);
        return sharedPreferences.getString(str + "-md5", null);
    }

    private void d(Context context, boolean z) {
        if (z) {
            this.c = true;
            return;
        }
        try {
            this.b = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()))).getPublicKey();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("SecurityChecker", UCCore.LEGACY_EVENT_INIT, e);
        } catch (CertificateException e2) {
            Log.e("SecurityChecker", UCCore.LEGACY_EVENT_INIT, e2);
        }
    }

    private void e(JarFile jarFile, JarEntry jarEntry) throws IOException {
        InputStream inputStream;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            do {
            } while (inputStream.read(new byte[8192]) > 0);
            inputStream.close();
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private void f(String str, String str2) {
        SharedPreferences.Editor edit = this.a.getSharedPreferences(PatchManager.SP_NAME, 4).edit();
        edit.putString(str + "-md5", str2);
        edit.commit();
    }

    public boolean isDebug() {
        return this.c;
    }

    public void saveOptSig(File file) {
        f(file.getName(), b(file));
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean verifyApk(java.io.File r7) {
        /*
            r6 = this;
            boolean r0 = r6.c
            java.lang.String r1 = "SecurityChecker"
            if (r0 == 0) goto Ld
            java.lang.String r7 = "mDebuggable = true"
            com.alipay.euler.andfix.log.Log.d(r1, r7)
            r7 = 1
            return r7
        Ld:
            r0 = 0
            r2 = 0
            java.util.jar.JarFile r3 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L58
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L58
            java.lang.String r0 = "classes.dex"
            java.util.jar.JarEntry r0 = r3.getJarEntry(r0)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            if (r0 != 0) goto L29
            r3.close()     // Catch: java.io.IOException -> L20
            goto L28
        L20:
            r0 = move-exception
            java.lang.String r7 = r7.getAbsolutePath()
            com.alipay.euler.andfix.log.Log.e(r1, r7, r0)
        L28:
            return r2
        L29:
            r6.e(r3, r0)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            java.security.cert.Certificate[] r0 = r0.getCertificates()     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            if (r0 != 0) goto L3f
            r3.close()     // Catch: java.io.IOException -> L36
            goto L3e
        L36:
            r0 = move-exception
            java.lang.String r7 = r7.getAbsolutePath()
            com.alipay.euler.andfix.log.Log.e(r1, r7, r0)
        L3e:
            return r2
        L3f:
            boolean r0 = r6.a(r7, r0)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L52
            r3.close()     // Catch: java.io.IOException -> L47
            goto L4f
        L47:
            r2 = move-exception
            java.lang.String r7 = r7.getAbsolutePath()
            com.alipay.euler.andfix.log.Log.e(r1, r7, r2)
        L4f:
            return r0
        L50:
            r0 = move-exception
            goto L72
        L52:
            r0 = move-exception
            goto L5c
        L54:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L72
        L58:
            r3 = move-exception
            r5 = r3
            r3 = r0
            r0 = r5
        L5c:
            java.lang.String r4 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L50
            com.alipay.euler.andfix.log.Log.e(r1, r4, r0)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L71
            r3.close()     // Catch: java.io.IOException -> L69
            goto L71
        L69:
            r0 = move-exception
            java.lang.String r7 = r7.getAbsolutePath()
            com.alipay.euler.andfix.log.Log.e(r1, r7, r0)
        L71:
            return r2
        L72:
            if (r3 == 0) goto L80
            r3.close()     // Catch: java.io.IOException -> L78
            goto L80
        L78:
            r2 = move-exception
            java.lang.String r7 = r7.getAbsolutePath()
            com.alipay.euler.andfix.log.Log.e(r1, r7, r2)
        L80:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.euler.andfix.security.SecurityChecker.verifyApk(java.io.File):boolean");
    }

    public boolean verifyOpt(File file) {
        String b = b(file);
        return b != null && TextUtils.equals(b, c(file.getName()));
    }
}
