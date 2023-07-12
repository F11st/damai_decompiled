package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.a.C5945b;
import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.c.c.C5960e;
import com.meizu.cloud.pushsdk.c.c.C5968i;
import com.meizu.cloud.pushsdk.c.c.C5971k;
import com.meizu.cloud.pushsdk.c.h.C5997b;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.e.a */
/* loaded from: classes10.dex */
public final class C5976a {
    private static String a;

    public static C5971k a(C5945b c5945b) throws C5953a {
        try {
            C5968i.C5969a a2 = new C5968i.C5969a().a(c5945b.e());
            a(a2, c5945b);
            int d = c5945b.d();
            if (d == 0) {
                a2 = a2.a();
            } else if (d == 1) {
                a2 = a2.a(c5945b.m());
            } else if (d == 2) {
                a2 = a2.c(c5945b.m());
            } else if (d == 3) {
                a2 = a2.b(c5945b.m());
            } else if (d == 4) {
                a2 = a2.b();
            } else if (d == 5) {
                a2 = a2.d(c5945b.m());
            }
            C5968i c = a2.c();
            c5945b.a(new C5960e());
            return c5945b.l().a(c);
        } catch (IOException e) {
            throw new C5953a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.meizu.cloud.pushsdk.c.c.C5968i.C5969a r3, com.meizu.cloud.pushsdk.c.a.C5945b r4) {
        /*
            java.lang.String r0 = r4.h()
            java.lang.String r1 = "User-Agent"
            if (r0 == 0) goto L10
            java.lang.String r0 = r4.h()
        Lc:
            r3.a(r1, r0)
            goto L1a
        L10:
            java.lang.String r0 = com.meizu.cloud.pushsdk.c.e.C5976a.a
            if (r0 == 0) goto L1a
            r4.a(r0)
            java.lang.String r0 = com.meizu.cloud.pushsdk.c.e.C5976a.a
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.e.C5976a.a(com.meizu.cloud.pushsdk.c.c.i$a, com.meizu.cloud.pushsdk.c.a.b):void");
    }

    public static C5971k b(C5945b c5945b) throws C5953a {
        try {
            C5968i.C5969a a2 = new C5968i.C5969a().a(c5945b.e());
            a(a2, c5945b);
            C5968i c = a2.a().c();
            c5945b.a(new C5960e());
            C5971k a3 = c5945b.l().a(c);
            C5997b.a(a3, c5945b.j(), c5945b.k());
            return a3;
        } catch (IOException e) {
            try {
                File file = new File(c5945b.j() + File.separator + c5945b.k());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new C5953a(e);
        }
    }

    public static C5971k c(C5945b c5945b) throws C5953a {
        try {
            C5968i.C5969a a2 = new C5968i.C5969a().a(c5945b.e());
            a(a2, c5945b);
            C5968i c = a2.a(new C5977b(c5945b.n(), c5945b.i())).c();
            c5945b.a(new C5960e());
            return c5945b.l().a(c);
        } catch (IOException e) {
            throw new C5953a(e);
        }
    }
}
