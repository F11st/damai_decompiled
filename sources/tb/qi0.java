package tb;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class qi0 {
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:33:0x004b */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L57
            boolean r1 = r4.exists()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
            if (r1 == 0) goto L57
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
            r1.<init>()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L3a
        L18:
            java.lang.String r4 = r2.readLine()     // Catch: java.io.IOException -> L29 java.io.FileNotFoundException -> L2b java.lang.Throwable -> L4a
            if (r4 == 0) goto L22
            r1.append(r4)     // Catch: java.io.IOException -> L29 java.io.FileNotFoundException -> L2b java.lang.Throwable -> L4a
            goto L18
        L22:
            java.lang.String r0 = r1.toString()     // Catch: java.io.IOException -> L29 java.io.FileNotFoundException -> L2b java.lang.Throwable -> L4a
            r4 = r0
            r0 = r2
            goto L58
        L29:
            r4 = move-exception
            goto L31
        L2b:
            r4 = move-exception
            goto L3c
        L2d:
            r4 = move-exception
            goto L4c
        L2f:
            r4 = move-exception
            r2 = r0
        L31:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L45
            goto L63
        L3a:
            r4 = move-exception
            r2 = r0
        L3c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L45
            goto L63
        L45:
            r4 = move-exception
            r4.printStackTrace()
            goto L63
        L4a:
            r4 = move-exception
            r0 = r2
        L4c:
            if (r0 == 0) goto L56
            r0.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r0 = move-exception
            r0.printStackTrace()
        L56:
            throw r4
        L57:
            r4 = r0
        L58:
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            r0.printStackTrace()
        L62:
            r0 = r4
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qi0.a(java.io.File):java.lang.String");
    }
}
