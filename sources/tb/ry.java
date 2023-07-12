package tb;

import com.taobao.android.dinamicx.DinamicXEngine;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ry {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x003a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String a(java.lang.Throwable r3) {
        /*
            if (r3 != 0) goto L5
            java.lang.String r3 = ""
            return r3
        L5:
            r0 = 0
            java.io.StringWriter r1 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L25
            r1.<init>()     // Catch: java.lang.Throwable -> L25
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L26
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L26
            r3.printStackTrace(r2)     // Catch: java.lang.Throwable -> L23
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L23
            r2.close()     // Catch: java.io.IOException -> L1e
            r1.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r0 = move-exception
            b(r0)
        L22:
            return r3
        L23:
            r0 = r2
            goto L26
        L25:
            r1 = r0
        L26:
            java.lang.String r3 = "DXExceptionUtil getStackTrace Exception"
            if (r0 == 0) goto L30
            r0.close()     // Catch: java.io.IOException -> L2e
            goto L30
        L2e:
            r0 = move-exception
            goto L36
        L30:
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L2e
            goto L39
        L36:
            b(r0)
        L39:
            return r3
        L3a:
            r3 = move-exception
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.io.IOException -> L41
            goto L43
        L41:
            r0 = move-exception
            goto L49
        L43:
            if (r1 == 0) goto L4c
            r1.close()     // Catch: java.io.IOException -> L41
            goto L4c
        L49:
            b(r0)
        L4c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ry.a(java.lang.Throwable):java.lang.String");
    }

    public static void b(Throwable th) {
        c(th, true);
    }

    public static void c(Throwable th, boolean z) {
        if (!DinamicXEngine.x() || th == null) {
            return;
        }
        th.printStackTrace();
        if (z && wt.n0()) {
            throw new RuntimeException(th);
        }
    }
}
