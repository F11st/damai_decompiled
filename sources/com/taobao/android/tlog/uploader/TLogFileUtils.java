package com.taobao.android.tlog.uploader;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TLogFileUtils {
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File copyFile(java.io.File r10, java.io.File r11) throws java.lang.Exception {
        /*
            r0 = 0
        L1:
            r1 = 3
            r2 = 0
            if (r0 >= r1) goto L74
            boolean r1 = r11.exists()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            if (r1 != 0) goto L1f
            java.io.File r1 = r11.getParentFile()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            if (r1 != 0) goto L1c
            java.io.File r1 = r11.getParentFile()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            r1.mkdirs()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
        L1c:
            r11.createNewFile()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
        L1f:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            r3.<init>(r11)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            java.nio.channels.FileChannel r2 = r3.getChannel()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            r4 = 0
            long r6 = r1.size()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            r3 = r1
            r8 = r2
            r3.transferTo(r4, r6, r8)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            r1.close()
            if (r2 == 0) goto L44
            r2.close()
        L44:
            return r11
        L45:
            r10 = move-exception
            r3 = r2
            r2 = r1
            goto L69
        L49:
            r3 = move-exception
            r9 = r2
            r2 = r1
            r1 = r3
            r3 = r9
            goto L54
        L4f:
            r10 = move-exception
            r3 = r2
            goto L69
        L52:
            r1 = move-exception
            r3 = r2
        L54:
            r11.delete()     // Catch: java.lang.Throwable -> L68
            r4 = 2
            if (r0 == r4) goto L67
            if (r2 == 0) goto L5f
            r2.close()
        L5f:
            if (r3 == 0) goto L64
            r3.close()
        L64:
            int r0 = r0 + 1
            goto L1
        L67:
            throw r1     // Catch: java.lang.Throwable -> L68
        L68:
            r10 = move-exception
        L69:
            if (r2 == 0) goto L6e
            r2.close()
        L6e:
            if (r3 == 0) goto L73
            r3.close()
        L73:
            throw r10
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.tlog.uploader.TLogFileUtils.copyFile(java.io.File, java.io.File):java.io.File");
    }
}
