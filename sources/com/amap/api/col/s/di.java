package com.amap.api.col.s;

import com.amap.api.col.s.cw;
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
public final class di {
    public static void a(String str, byte[] bArr, dh dhVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        cw cwVar;
        OutputStream outputStream = null;
        try {
            if (a(dhVar.a, str)) {
                return;
            }
            File file = new File(dhVar.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            cwVar = cw.a(file, dhVar.b);
            try {
                cwVar.a(dhVar.d);
                byte[] b = dhVar.e.b(bArr);
                cw.C4405a b2 = cwVar.b(str);
                outputStream = b2.a();
                outputStream.write(b);
                b2.b();
                cwVar.b();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    cwVar.close();
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
                if (cwVar != null) {
                    try {
                        cwVar.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            cwVar = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0082, code lost:
        r10.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(com.amap.api.col.s.dh r10) {
        /*
            java.lang.String r0 = "code"
            r1 = -1
            r2 = 0
            com.amap.api.col.s.ea r3 = r10.f     // Catch: java.lang.Throwable -> L94
            boolean r3 = r3.c()     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L89
            com.amap.api.col.s.ea r3 = r10.f     // Catch: java.lang.Throwable -> L94
            r4 = 1
            r3.a(r4)     // Catch: java.lang.Throwable -> L94
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L94
            java.lang.String r5 = r10.a     // Catch: java.lang.Throwable -> L94
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L94
            long r5 = r10.b     // Catch: java.lang.Throwable -> L94
            com.amap.api.col.s.cw r3 = com.amap.api.col.s.cw.a(r3, r5)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            byte[] r6 = a(r3, r10, r5)     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L7b
            int r7 = r6.length     // Catch: java.lang.Throwable -> L86
            if (r7 != 0) goto L2e
            goto L7b
        L2e:
            com.amap.api.col.s.ck r7 = new com.amap.api.col.s.ck     // Catch: java.lang.Throwable -> L86
            java.lang.String r8 = r10.c     // Catch: java.lang.Throwable -> L86
            r7.<init>(r6, r8)     // Catch: java.lang.Throwable -> L86
            com.amap.api.col.s.cz.a()     // Catch: java.lang.Throwable -> L86
            com.amap.api.col.s.dg r7 = com.amap.api.col.s.cz.a(r7)     // Catch: java.lang.Throwable -> L86
            byte[] r7 = r7.a     // Catch: java.lang.Throwable -> L86
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L86
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Throwable -> L86
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L86
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L86
            boolean r7 = r8.has(r0)     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L79
            int r0 = r8.getInt(r0)     // Catch: java.lang.Throwable -> L86
            if (r0 != r4) goto L79
            com.amap.api.col.s.ea r0 = r10.f     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L5c
            int r4 = r6.length     // Catch: java.lang.Throwable -> L86
            r0.a(r4)     // Catch: java.lang.Throwable -> L86
        L5c:
            com.amap.api.col.s.ea r10 = r10.f     // Catch: java.lang.Throwable -> L86
            int r10 = r10.b()     // Catch: java.lang.Throwable -> L86
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r10 >= r0) goto L6b
            a(r3, r5)     // Catch: java.lang.Throwable -> L86
            goto L77
        L6b:
            r3.c()     // Catch: java.lang.Throwable -> L6f
            goto L77
        L6f:
            r10 = move-exception
            java.lang.String r0 = "ofm"
            java.lang.String r4 = "dlo"
            com.amap.api.col.s.cl.c(r10, r0, r4)     // Catch: java.lang.Throwable -> L86
        L77:
            int r10 = r6.length     // Catch: java.lang.Throwable -> L94
            return r10
        L79:
            r2 = r3
            goto L89
        L7b:
            if (r3 == 0) goto L85
            r3.close()     // Catch: java.lang.Throwable -> L81
            goto L85
        L81:
            r10 = move-exception
            r10.printStackTrace()
        L85:
            return r1
        L86:
            r10 = move-exception
            r2 = r3
            goto L95
        L89:
            if (r2 == 0) goto La1
            r2.close()     // Catch: java.lang.Throwable -> L8f
            goto La1
        L8f:
            r10 = move-exception
            r10.printStackTrace()
            goto La1
        L94:
            r10 = move-exception
        L95:
            java.lang.String r0 = "leg"
            java.lang.String r3 = "uts"
            com.amap.api.col.s.cl.c(r10, r0, r3)     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La1
            r2.close()     // Catch: java.lang.Throwable -> L8f
        La1:
            return r1
        La2:
            r10 = move-exception
            if (r2 == 0) goto Lad
            r2.close()     // Catch: java.lang.Throwable -> La9
            goto Lad
        La9:
            r0 = move-exception
            r0.printStackTrace()
        Lad:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.di.a(com.amap.api.col.s.dh):int");
    }

    private static byte[] a(cw cwVar, dh dhVar, List<String> list) {
        String[] list2;
        try {
            File a = cwVar.a();
            if (a != null && a.exists()) {
                int i = 0;
                for (String str : a.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a2 = dn.a(cwVar, str2);
                        i += a2.length;
                        list.add(str2);
                        if (i > dhVar.f.b()) {
                            break;
                        }
                        dhVar.g.b(a2);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return dhVar.g.a();
            }
        } catch (Throwable th) {
            cl.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(cw cwVar, List<String> list) {
        if (cwVar != null) {
            try {
                for (String str : list) {
                    cwVar.c(str);
                }
                cwVar.close();
            } catch (Throwable th) {
                cl.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            cl.c(th, "leg", "fet");
            return false;
        }
    }
}
