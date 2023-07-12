package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.e;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a {
    private static String a;

    public static k a(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            int d = bVar.d();
            if (d == 0) {
                a2 = a2.a();
            } else if (d == 1) {
                a2 = a2.a(bVar.m());
            } else if (d == 2) {
                a2 = a2.c(bVar.m());
            } else if (d == 3) {
                a2 = a2.b(bVar.m());
            } else if (d == 4) {
                a2 = a2.b();
            } else if (d == 5) {
                a2 = a2.d(bVar.m());
            }
            i c = a2.c();
            bVar.a(new e());
            return bVar.l().a(c);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.meizu.cloud.pushsdk.c.c.i.a r3, com.meizu.cloud.pushsdk.c.a.b r4) {
        /*
            java.lang.String r0 = r4.h()
            java.lang.String r1 = "User-Agent"
            if (r0 == 0) goto L10
            java.lang.String r0 = r4.h()
        Lc:
            r3.a(r1, r0)
            goto L1a
        L10:
            java.lang.String r0 = com.meizu.cloud.pushsdk.c.e.a.a
            if (r0 == 0) goto L1a
            r4.a(r0)
            java.lang.String r0 = com.meizu.cloud.pushsdk.c.e.a.a
            goto Lc
        L1a:
            com.meizu.cloud.pushsdk.c.c.c r0 = r4.o()
            if (r0 == 0) goto L3a
            r3.a(r0)
            java.lang.String r2 = r4.h()
            if (r2 == 0) goto L3a
            java.util.Set r0 = r0.b()
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L3a
            java.lang.String r4 = r4.h()
            r3.a(r1, r4)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.e.a.a(com.meizu.cloud.pushsdk.c.c.i$a, com.meizu.cloud.pushsdk.c.a.b):void");
    }

    public static k b(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c = a2.a().c();
            bVar.a(new e());
            k a3 = bVar.l().a(c);
            com.meizu.cloud.pushsdk.c.h.b.a(a3, bVar.j(), bVar.k());
            return a3;
        } catch (IOException e) {
            try {
                File file = new File(bVar.j() + File.separator + bVar.k());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c = a2.a(new b(bVar.n(), bVar.i())).c();
            bVar.a(new e());
            return bVar.l().a(c);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }
}
