package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.hy;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class io {
    public static void a(String str, byte[] bArr, in inVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        hy hyVar;
        OutputStream outputStream = null;
        try {
            if (a(inVar.a, str)) {
                return;
            }
            File file = new File(inVar.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            hyVar = hy.a(file, 1, 1, inVar.b * inVar.d);
            try {
                hyVar.a(inVar.d);
                byte[] b = inVar.e.b(bArr);
                hy.a b2 = hyVar.b(str);
                outputStream = b2.a(0);
                outputStream.write(b);
                b2.a();
                hyVar.e();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    hyVar.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (hyVar != null) {
                    try {
                        hyVar.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            hyVar = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.amap.api.mapcore.util.in r9) {
        /*
            java.lang.String r0 = "code"
            r1 = 0
            com.amap.api.mapcore.util.jh r2 = r9.f     // Catch: java.lang.Throwable -> L88
            boolean r2 = r2.c()     // Catch: java.lang.Throwable -> L88
            if (r2 == 0) goto L7d
            com.amap.api.mapcore.util.jh r2 = r9.f     // Catch: java.lang.Throwable -> L88
            r3 = 1
            r2.a(r3)     // Catch: java.lang.Throwable -> L88
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L88
            java.lang.String r4 = r9.a     // Catch: java.lang.Throwable -> L88
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L88
            long r4 = r9.b     // Catch: java.lang.Throwable -> L88
            com.amap.api.mapcore.util.hy r2 = com.amap.api.mapcore.util.hy.a(r2, r3, r3, r4)     // Catch: java.lang.Throwable -> L88
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7a
            r4.<init>()     // Catch: java.lang.Throwable -> L7a
            byte[] r5 = a(r2, r9, r4)     // Catch: java.lang.Throwable -> L7a
            if (r5 == 0) goto L6f
            int r6 = r5.length     // Catch: java.lang.Throwable -> L7a
            if (r6 != 0) goto L2d
            goto L6f
        L2d:
            com.amap.api.mapcore.util.hc r6 = new com.amap.api.mapcore.util.hc     // Catch: java.lang.Throwable -> L7a
            java.lang.String r7 = r9.c     // Catch: java.lang.Throwable -> L7a
            r6.<init>(r5, r7)     // Catch: java.lang.Throwable -> L7a
            com.amap.api.mapcore.util.id r7 = com.amap.api.mapcore.util.id.a()     // Catch: java.lang.Throwable -> L7a
            byte[] r6 = r7.b(r6)     // Catch: java.lang.Throwable -> L7a
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7a
            java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L7a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L7a
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L7a
            boolean r6 = r7.has(r0)     // Catch: java.lang.Throwable -> L7a
            if (r6 == 0) goto L6d
            int r0 = r7.getInt(r0)     // Catch: java.lang.Throwable -> L7a
            if (r0 != r3) goto L6d
            com.amap.api.mapcore.util.jh r0 = r9.f     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L5a
            int r3 = r5.length     // Catch: java.lang.Throwable -> L7a
            r0.a(r3)     // Catch: java.lang.Throwable -> L7a
        L5a:
            com.amap.api.mapcore.util.jh r9 = r9.f     // Catch: java.lang.Throwable -> L7a
            int r9 = r9.b()     // Catch: java.lang.Throwable -> L7a
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r9 >= r0) goto L69
            a(r2, r4)     // Catch: java.lang.Throwable -> L7a
            goto L7d
        L69:
            a(r2)     // Catch: java.lang.Throwable -> L7a
            goto L7d
        L6d:
            r1 = r2
            goto L7d
        L6f:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r9 = move-exception
            r9.printStackTrace()
        L79:
            return
        L7a:
            r9 = move-exception
            r1 = r2
            goto L89
        L7d:
            if (r1 == 0) goto L95
            r1.close()     // Catch: java.lang.Throwable -> L83
            goto L95
        L83:
            r9 = move-exception
            r9.printStackTrace()
            goto L95
        L88:
            r9 = move-exception
        L89:
            java.lang.String r0 = "leg"
            java.lang.String r2 = "uts"
            com.amap.api.mapcore.util.hd.c(r9, r0, r2)     // Catch: java.lang.Throwable -> L96
            if (r1 == 0) goto L95
            r1.close()     // Catch: java.lang.Throwable -> L83
        L95:
            return
        L96:
            r9 = move-exception
            if (r1 == 0) goto La1
            r1.close()     // Catch: java.lang.Throwable -> L9d
            goto La1
        L9d:
            r0 = move-exception
            r0.printStackTrace()
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.io.a(com.amap.api.mapcore.util.in):void");
    }

    private static byte[] a(hy hyVar, in inVar, List<String> list) {
        String[] list2;
        try {
            File c = hyVar.c();
            if (c != null && c.exists()) {
                int i = 0;
                for (String str : c.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = iu.a(hyVar, str2, false);
                        i += a.length;
                        list.add(str2);
                        if (i > inVar.f.b()) {
                            break;
                        }
                        inVar.g.b(a);
                    }
                }
                return inVar.g.a();
            }
        } catch (Throwable th) {
            hd.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(hy hyVar) {
        if (hyVar != null) {
            try {
                hyVar.f();
            } catch (Throwable th) {
                hd.c(th, "ofm", "dlo");
            }
        }
    }

    private static void a(hy hyVar, List<String> list) {
        if (hyVar != null) {
            try {
                for (String str : list) {
                    hyVar.c(str);
                }
                hyVar.close();
            } catch (Throwable th) {
                hd.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            hd.c(th, "leg", "fet");
            return false;
        }
    }
}
