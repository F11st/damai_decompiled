package com.amap.api.mapcore.util;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kz {
    private HashMap<Long, la> a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (i2 & 65535) | ((i & 65535) << 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.amap.api.mapcore.util.la r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L77
            boolean r2 = r9.p
            if (r2 != 0) goto L9
            goto L77
        L9:
            java.util.HashMap<java.lang.Long, com.amap.api.mapcore.util.la> r2 = r8.a
            int r3 = r9.k
            r4 = 1
            if (r3 == r4) goto L24
            r4 = 2
            if (r3 == r4) goto L1b
            r4 = 3
            if (r3 == r4) goto L24
            r4 = 4
            if (r3 == r4) goto L24
            r3 = r0
            goto L30
        L1b:
            int r3 = r9.c()
            int r4 = r9.d()
            goto L2c
        L24:
            int r3 = r9.a()
            int r4 = r9.b()
        L2c:
            long r3 = a(r3, r4)
        L30:
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
            java.lang.Object r5 = r2.get(r5)
            com.amap.api.mapcore.util.la r5 = (com.amap.api.mapcore.util.la) r5
            if (r5 != 0) goto L4a
            long r5 = com.amap.api.mapcore.util.kc.b()
            r9.m = r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.put(r3, r9)
            return r0
        L4a:
            int r6 = r5.e()
            int r7 = r9.e()
            if (r6 == r7) goto L62
            long r5 = com.amap.api.mapcore.util.kc.b()
            r9.m = r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.put(r3, r9)
            return r0
        L62:
            long r0 = r5.m
            r9.m = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            r2.put(r0, r9)
            long r0 = com.amap.api.mapcore.util.kc.b()
            long r2 = r5.m
            long r0 = r0 - r2
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.kz.a(com.amap.api.mapcore.util.la):long");
    }

    public final void a() {
        this.a.clear();
        this.b = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r13 != 4) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        if (r12 != 4) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0065 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.ArrayList<? extends com.amap.api.mapcore.util.la> r15) {
        /*
            r14 = this;
            if (r15 == 0) goto La7
            long r0 = com.amap.api.mapcore.util.kc.b()
            long r2 = r14.b
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L18
            long r2 = r0 - r2
            r6 = 60000(0xea60, double:2.9644E-319)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 >= 0) goto L18
            return
        L18:
            java.util.HashMap<java.lang.Long, com.amap.api.mapcore.util.la> r2 = r14.a
            int r3 = r15.size()
            r6 = 0
            r7 = 0
        L20:
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 1
            if (r7 >= r3) goto L68
            java.lang.Object r12 = r15.get(r7)
            com.amap.api.mapcore.util.la r12 = (com.amap.api.mapcore.util.la) r12
            boolean r13 = r12.p
            if (r13 == 0) goto L65
            int r13 = r12.k
            if (r13 == r11) goto L40
            if (r13 == r10) goto L3b
            if (r13 == r9) goto L40
            if (r13 == r8) goto L40
            goto L48
        L3b:
            int r4 = r12.h
            int r5 = r12.i
            goto L44
        L40:
            int r4 = r12.c
            int r5 = r12.d
        L44:
            long r4 = a(r4, r5)
        L48:
            java.lang.Long r8 = java.lang.Long.valueOf(r4)
            java.lang.Object r8 = r2.get(r8)
            com.amap.api.mapcore.util.la r8 = (com.amap.api.mapcore.util.la) r8
            if (r8 == 0) goto L65
            int r9 = r8.e()
            int r10 = r12.e()
            if (r9 != r10) goto L63
            long r8 = r8.m
            r12.m = r8
            goto L65
        L63:
            r12.m = r0
        L65:
            int r7 = r7 + 1
            goto L20
        L68:
            r2.clear()
            int r3 = r15.size()
        L6f:
            if (r6 >= r3) goto La5
            java.lang.Object r7 = r15.get(r6)
            com.amap.api.mapcore.util.la r7 = (com.amap.api.mapcore.util.la) r7
            boolean r12 = r7.p
            if (r12 == 0) goto La2
            int r12 = r7.k
            if (r12 == r11) goto L8f
            if (r12 == r10) goto L86
            if (r12 == r9) goto L8f
            if (r12 == r8) goto L8f
            goto L9b
        L86:
            int r4 = r7.c()
            int r5 = r7.d()
            goto L97
        L8f:
            int r4 = r7.a()
            int r5 = r7.b()
        L97:
            long r4 = a(r4, r5)
        L9b:
            java.lang.Long r12 = java.lang.Long.valueOf(r4)
            r2.put(r12, r7)
        La2:
            int r6 = r6 + 1
            goto L6f
        La5:
            r14.b = r0
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.kz.a(java.util.ArrayList):void");
    }
}
