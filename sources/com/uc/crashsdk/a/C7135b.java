package com.uc.crashsdk.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.uplayer.AliMediaPlayer;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: Taobao */
/* renamed from: com.uc.crashsdk.a.b */
/* loaded from: classes11.dex */
public final class C7135b {
    private static final int[] a = {126, DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH, 115, 241, 101, 198, 215, 134};
    private static final int[] b = {125, 185, 233, 226, SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, 142, 151, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_LOADING_FACTOR_STEP};
    private static final int[] c = {238, 185, 233, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD, SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, 142, 151, 167};

    public static String a(String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream3.read(bArr);
                C7140g.a(fileInputStream3);
                byte[] a2 = a(bArr, a);
                if (a2 != null && a2.length > 0) {
                    int length = a2.length - 1;
                    String str2 = a2[length] == 10 ? new String(a2, 0, length) : new String(a2);
                    C7140g.a((Closeable) null);
                    return str2;
                }
                C7140g.a((Closeable) null);
                return null;
            } catch (Exception e) {
                fileInputStream = fileInputStream3;
                e = e;
                try {
                    C7140g.a(e);
                    C7140g.a(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    C7140g.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream3;
                th = th2;
                C7140g.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (Exception e) {
                C7140g.a(e);
            }
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:17|(3:18|19|(2:20|21))|(2:22|23)|24|25|26|27|(1:45)(1:32)) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1 = com.uc.crashsdk.a.C7140g.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
        com.uc.crashsdk.a.C7140g.a(r9);
        r9 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L3
            return r7
        L3:
            boolean r0 = com.uc.crashsdk.a.C7140g.a(r7)
            if (r0 == 0) goto La
            return r7
        La:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto Lbf
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L22
            goto Lbf
        L22:
            byte[] r1 = com.uc.crashsdk.a.C7140g.e(r0)
            if (r1 == 0) goto Lbf
            int r2 = r1.length
            if (r2 > 0) goto L2d
            goto Lbf
        L2d:
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L84
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4a
            r4.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L45
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L45
            r5.write(r1)     // Catch: java.lang.Throwable -> L43
            r4.flush()     // Catch: java.lang.Throwable -> L43
            goto L51
        L43:
            r9 = move-exception
            goto L4e
        L45:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L4e
        L4a:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L4e:
            com.uc.crashsdk.a.C7140g.a(r9)     // Catch: java.lang.Throwable -> L7c
        L51:
            com.uc.crashsdk.a.C7140g.a(r4)
            com.uc.crashsdk.a.C7140g.a(r5)
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L5d
            r9 = 1
            goto L62
        L5d:
            r9 = move-exception
            com.uc.crashsdk.a.C7140g.a(r9)
            r9 = 0
        L62:
            if (r9 == 0) goto L7b
            if (r1 == 0) goto L7b
            int r9 = r1.length
            if (r9 > 0) goto L6a
            goto L7b
        L6a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = 1
            goto L86
        L7b:
            return r7
        L7c:
            r7 = move-exception
            com.uc.crashsdk.a.C7140g.a(r4)
            com.uc.crashsdk.a.C7140g.a(r5)
            throw r7
        L84:
            r8 = r7
            r9 = 0
        L86:
            if (r9 == 0) goto Lbf
            java.lang.String r9 = r0.getName()
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto La5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r4 = ".tmp"
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r4 = 1
            goto La7
        La5:
            r9 = r8
            r4 = 0
        La7:
            java.io.File r5 = new java.io.File
            r5.<init>(r9)
            boolean r9 = com.uc.crashsdk.a.C7140g.a(r5, r1)
            if (r9 != 0) goto Lb4
            r2 = 0
            goto Lbc
        Lb4:
            if (r4 == 0) goto Lbc
            r0.delete()
            r5.renameTo(r0)
        Lbc:
            if (r2 == 0) goto Lbf
            return r8
        Lbf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.C7135b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e) {
                C7140g.a(e);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            C7140g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), a);
        if (b2 == null) {
            return false;
        }
        try {
            fileOutputStream.write(b2);
            z = true;
        } finally {
            try {
                return z;
            } finally {
            }
        }
        return z;
    }
}
