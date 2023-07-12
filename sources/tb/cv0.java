package tb;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class cv0 {
    /* JADX WARN: Removed duplicated region for block: B:56:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0029 -> B:51:0x004c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: tb.cv0.a(byte[]):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x006b, code lost:
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r8) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L5a
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
        L14:
            r5 = 0
            int r6 = r8.read(r3, r5, r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r7 = -1
            if (r6 == r7) goto L20
            r4.write(r3, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            goto L14
        L20:
            r4.flush()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r4.close()     // Catch: java.lang.Exception -> L2a
        L2a:
            r8.close()     // Catch: java.io.IOException -> L2d
        L2d:
            r1.close()     // Catch: java.io.IOException -> L6e
            goto L6e
        L31:
            r0 = move-exception
            goto L46
        L33:
            goto L5d
        L35:
            r2 = move-exception
            r4 = r0
            r0 = r2
            goto L46
        L39:
            r4 = r0
            goto L5d
        L3b:
            r8 = move-exception
            r4 = r0
            goto L44
        L3e:
            r8 = r0
            r4 = r8
            goto L5d
        L41:
            r8 = move-exception
            r1 = r0
            r4 = r1
        L44:
            r0 = r8
            r8 = r4
        L46:
            if (r4 == 0) goto L4d
            r4.close()     // Catch: java.lang.Exception -> L4c
            goto L4d
        L4c:
        L4d:
            if (r8 == 0) goto L54
            r8.close()     // Catch: java.io.IOException -> L53
            goto L54
        L53:
        L54:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L59
        L59:
            throw r0
        L5a:
            r8 = r0
            r1 = r8
            r4 = r1
        L5d:
            if (r4 == 0) goto L64
            r4.close()     // Catch: java.lang.Exception -> L63
            goto L64
        L63:
        L64:
            if (r8 == 0) goto L6b
            r8.close()     // Catch: java.io.IOException -> L6a
            goto L6b
        L6a:
        L6b:
            if (r1 == 0) goto L6e
            goto L2d
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.cv0.b(byte[]):byte[]");
    }
}
