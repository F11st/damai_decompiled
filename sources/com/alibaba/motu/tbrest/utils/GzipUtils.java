package com.alibaba.motu.tbrest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class GzipUtils {
    /* JADX WARN: Removed duplicated region for block: B:56:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0029 -> B:51:0x004c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] gzip(byte[] r4) {
        /*
            if (r4 == 0) goto L64
            int r0 = r4.length
            if (r0 != 0) goto L6
            goto L64
        L6:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            int r3 = r4.length     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.write(r4)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L4d
            r2.finish()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L4d
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L4d
            r2.close()     // Catch: java.io.IOException -> L20
            goto L24
        L20:
            r4 = move-exception
            r4.printStackTrace()
        L24:
            r1.close()     // Catch: java.io.IOException -> L28
            goto L4c
        L28:
            r4 = move-exception
            r4.printStackTrace()
            goto L4c
        L2d:
            r4 = move-exception
            goto L3a
        L2f:
            r4 = move-exception
            goto L4f
        L31:
            r4 = move-exception
            r2 = r0
            goto L3a
        L34:
            r4 = move-exception
            r1 = r0
            goto L4f
        L37:
            r4 = move-exception
            r1 = r0
            r2 = r1
        L3a:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L47
            r2.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r4 = move-exception
            r4.printStackTrace()
        L47:
            if (r1 == 0) goto L4c
            r1.close()     // Catch: java.io.IOException -> L28
        L4c:
            return r0
        L4d:
            r4 = move-exception
            r0 = r2
        L4f:
            if (r0 == 0) goto L59
            r0.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r0 = move-exception
            r0.printStackTrace()
        L59:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.io.IOException -> L5f
            goto L63
        L5f:
            r0 = move-exception
            r0.printStackTrace()
        L63:
            throw r4
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.utils.GzipUtils.gzip(byte[]):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    public static byte[] gzipAndRc4Bytes(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    ?? r1 = "UTF-8";
                    gZIPOutputStream2.write(str.getBytes("UTF-8"));
                    gZIPOutputStream2.flush();
                    gZIPOutputStream2.close();
                    gZIPOutputStream = r1;
                } catch (IOException e) {
                    e = e;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.printStackTrace();
                    gZIPOutputStream = gZIPOutputStream;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                        gZIPOutputStream = gZIPOutputStream;
                    }
                    byte[] rc4 = RC4.rc4(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    return rc4;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            byte[] rc42 = RC4.rc4(byteArrayOutputStream.toByteArray());
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return rc42;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x003c -> B:87:0x0076). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] unGzip(byte[] r8) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L56
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L56
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
        L14:
            r5 = 0
            int r6 = r8.read(r3, r5, r2)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L77
            r7 = -1
            if (r6 == r7) goto L20
            r4.write(r3, r5, r6)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L77
            goto L14
        L20:
            r4.flush()     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L77
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L77
            r4.close()     // Catch: java.lang.Exception -> L2b
            goto L2f
        L2b:
            r2 = move-exception
            r2.printStackTrace()
        L2f:
            r8.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r8 = move-exception
            r8.printStackTrace()
        L37:
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L76
        L3b:
            r8 = move-exception
            r8.printStackTrace()
            goto L76
        L40:
            r2 = move-exception
            goto L5a
        L42:
            r2 = move-exception
            r4 = r0
            r0 = r2
            goto L78
        L46:
            r2 = move-exception
            r4 = r0
            goto L5a
        L49:
            r8 = move-exception
            r4 = r0
            goto L53
        L4c:
            r2 = move-exception
            r8 = r0
            r4 = r8
            goto L5a
        L50:
            r8 = move-exception
            r1 = r0
            r4 = r1
        L53:
            r0 = r8
            r8 = r4
            goto L78
        L56:
            r2 = move-exception
            r8 = r0
            r1 = r8
            r4 = r1
        L5a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L67
            r4.close()     // Catch: java.lang.Exception -> L63
            goto L67
        L63:
            r2 = move-exception
            r2.printStackTrace()
        L67:
            if (r8 == 0) goto L71
            r8.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r8 = move-exception
            r8.printStackTrace()
        L71:
            if (r1 == 0) goto L76
            r1.close()     // Catch: java.io.IOException -> L3b
        L76:
            return r0
        L77:
            r0 = move-exception
        L78:
            if (r4 == 0) goto L82
            r4.close()     // Catch: java.lang.Exception -> L7e
            goto L82
        L7e:
            r2 = move-exception
            r2.printStackTrace()
        L82:
            if (r8 == 0) goto L8c
            r8.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L88:
            r8 = move-exception
            r8.printStackTrace()
        L8c:
            if (r1 == 0) goto L96
            r1.close()     // Catch: java.io.IOException -> L92
            goto L96
        L92:
            r8 = move-exception
            r8.printStackTrace()
        L96:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.utils.GzipUtils.unGzip(byte[]):byte[]");
    }
}
