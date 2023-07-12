package tb;

import android.content.Context;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qa2 {
    private static File a;

    public static File a(String str) {
        Context c;
        if (a == null && (c = hu0.c()) != null) {
            a = c.getCacheDir();
        }
        return new File(a, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[Catch: all -> 0x0119, TryCatch #6 {, blocks: (B:8:0x0011, B:13:0x0049, B:29:0x007a, B:31:0x0081, B:35:0x0092, B:37:0x0098, B:39:0x009e, B:45:0x00e1, B:49:0x00e7, B:54:0x00f6, B:56:0x00fa, B:40:0x00d0, B:27:0x0076, B:62:0x0109, B:63:0x010c, B:64:0x010d), top: B:83:0x000b, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098 A[Catch: all -> 0x0119, TryCatch #6 {, blocks: (B:8:0x0011, B:13:0x0049, B:29:0x007a, B:31:0x0081, B:35:0x0092, B:37:0x0098, B:39:0x009e, B:45:0x00e1, B:49:0x00e7, B:54:0x00f6, B:56:0x00fa, B:40:0x00d0, B:27:0x0076, B:62:0x0109, B:63:0x010c, B:64:0x010d), top: B:83:0x000b, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void b(java.io.Serializable r17, java.io.File r18, anet.channel.statist.StrategyStatObject r19) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qa2.b(java.io.Serializable, java.io.File, anet.channel.statist.StrategyStatObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
        if (r4 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized <T> T c(java.io.File r14, anet.channel.statist.StrategyStatObject r15) {
        /*
            java.lang.Class<tb.qa2> r0 = tb.qa2.class
            monitor-enter(r0)
            if (r15 == 0) goto Lf
            java.lang.String r1 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> Lc
            r15.readStrategyFilePath = r1     // Catch: java.lang.Throwable -> Lc
            goto Lf
        Lc:
            r14 = move-exception
            goto Lbd
        Lf:
            r1 = 0
            r2 = 3
            r3 = 0
            boolean r4 = r14.exists()     // Catch: java.lang.Throwable -> L97
            r5 = 2
            r6 = 1
            if (r4 != 0) goto L35
            boolean r4 = anet.channel.util.ALog.g(r2)     // Catch: java.lang.Throwable -> L97
            if (r4 == 0) goto L33
            java.lang.String r4 = "awcn.SerializeHelper"
            java.lang.String r7 = "file not exist."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = "file"
            r5[r1] = r8     // Catch: java.lang.Throwable -> L97
            java.lang.String r14 = r14.getName()     // Catch: java.lang.Throwable -> L97
            r5[r6] = r14     // Catch: java.lang.Throwable -> L97
            anet.channel.util.ALog.k(r4, r7, r3, r5)     // Catch: java.lang.Throwable -> L97
        L33:
            monitor-exit(r0)
            return r3
        L35:
            if (r15 == 0) goto L39
            r15.isFileExists = r6     // Catch: java.lang.Throwable -> L97
        L39:
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L97
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L97
            r4.<init>(r14)     // Catch: java.lang.Throwable -> L97
            java.io.ObjectInputStream r9 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L94
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L94
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L94
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L94
            java.lang.Object r10 = r9.readObject()     // Catch: java.lang.Throwable -> L94
            r9.close()     // Catch: java.lang.Throwable -> L92
            long r11 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L92
            long r11 = r11 - r7
            if (r15 == 0) goto L5e
            r15.isReadObjectSucceed = r6     // Catch: java.lang.Throwable -> L92
            r15.readCostTime = r11     // Catch: java.lang.Throwable -> L92
        L5e:
            java.lang.String r7 = "awcn.SerializeHelper"
            java.lang.String r8 = "restore end."
            r9 = 6
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L92
            java.lang.String r13 = "file"
            r9[r1] = r13     // Catch: java.lang.Throwable -> L92
            java.io.File r13 = r14.getAbsoluteFile()     // Catch: java.lang.Throwable -> L92
            r9[r6] = r13     // Catch: java.lang.Throwable -> L92
            java.lang.String r6 = "size"
            r9[r5] = r6     // Catch: java.lang.Throwable -> L92
            long r5 = r14.length()     // Catch: java.lang.Throwable -> L92
            java.lang.Long r14 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L92
            r9[r2] = r14     // Catch: java.lang.Throwable -> L92
            r14 = 4
            java.lang.String r5 = "cost"
            r9[r14] = r5     // Catch: java.lang.Throwable -> L92
            r14 = 5
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L92
            r9[r14] = r5     // Catch: java.lang.Throwable -> L92
            anet.channel.util.ALog.f(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L92
        L8e:
            r4.close()     // Catch: java.lang.Throwable -> Lc java.io.IOException -> Lb4
            goto Lb4
        L92:
            r14 = move-exception
            goto L9a
        L94:
            r14 = move-exception
            r10 = r3
            goto L9a
        L97:
            r14 = move-exception
            r4 = r3
            r10 = r4
        L9a:
            boolean r2 = anet.channel.util.ALog.g(r2)     // Catch: java.lang.Throwable -> Lb6
            if (r2 == 0) goto Laa
            java.lang.String r2 = "awcn.SerializeHelper"
            java.lang.String r5 = "restore file fail."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb6
            anet.channel.util.ALog.j(r2, r5, r3, r14, r1)     // Catch: java.lang.Throwable -> Lb6
        Laa:
            if (r15 == 0) goto Lb1
            java.lang.String r1 = "SerializeHelper.restore()"
            r15.appendErrorTrace(r1, r14)     // Catch: java.lang.Throwable -> Lb6
        Lb1:
            if (r4 == 0) goto Lb4
            goto L8e
        Lb4:
            monitor-exit(r0)
            return r10
        Lb6:
            r14 = move-exception
            if (r4 == 0) goto Lbc
            r4.close()     // Catch: java.lang.Throwable -> Lc java.io.IOException -> Lbc
        Lbc:
            throw r14     // Catch: java.lang.Throwable -> Lc
        Lbd:
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qa2.c(java.io.File, anet.channel.statist.StrategyStatObject):java.lang.Object");
    }
}
