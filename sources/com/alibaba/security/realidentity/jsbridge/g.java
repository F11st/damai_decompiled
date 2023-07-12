package com.alibaba.security.realidentity.jsbridge;

import android.text.TextUtils;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g {
    private static final String a = "g";
    private static final List<a> b = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static class a {
        public String a;
        public Class<? extends com.alibaba.security.realidentity.jsbridge.a> b;

        public a(String str, Class<? extends com.alibaba.security.realidentity.jsbridge.a> cls) {
            this.a = str;
            this.b = cls;
        }

        private boolean a(String str) {
            String str2 = this.a;
            if (str2 == null) {
                return false;
            }
            return TextUtils.equals(str, this.a) || Arrays.asList(str2.split(",")).contains(str);
        }
    }

    public static void a() {
        b.clear();
    }

    public static void a(Class<? extends com.alibaba.security.realidentity.jsbridge.a>[] clsArr) {
        String name;
        if (clsArr == null) {
            return;
        }
        try {
            for (Class<? extends com.alibaba.security.realidentity.jsbridge.a> cls : clsArr) {
                f fVar = (f) cls.getAnnotation(f.class);
                if (fVar != null) {
                    name = fVar.a();
                } else {
                    name = cls.getName();
                }
                b.add(new a(name, cls));
            }
        } catch (Throwable th) {
            a("JSTopic add exception", null, th);
        }
    }

    private static void a(String str, String str2, Throwable th) {
        com.alibaba.security.common.c.a.c(a, th.getMessage());
        g.a.a().a(TrackLog.createSdkExceptionLog(str, str2, com.alibaba.security.common.d.b.a(th)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Class<? extends com.alibaba.security.realidentity.jsbridge.a> a(java.lang.String r4) {
        /*
            java.util.List<com.alibaba.security.realidentity.jsbridge.g$a> r0 = com.alibaba.security.realidentity.jsbridge.g.b
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L36
            java.lang.Object r1 = r0.next()
            com.alibaba.security.realidentity.jsbridge.g$a r1 = (com.alibaba.security.realidentity.jsbridge.g.a) r1
            java.lang.String r2 = r1.a
            if (r2 == 0) goto L30
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)
            java.lang.String r3 = r1.a
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            if (r3 != 0) goto L2e
            java.util.List r2 = java.util.Arrays.asList(r2)
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L30
        L2e:
            r2 = 1
            goto L31
        L30:
            r2 = 0
        L31:
            if (r2 == 0) goto L6
            java.lang.Class<? extends com.alibaba.security.realidentity.jsbridge.a> r4 = r1.b
            return r4
        L36:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.jsbridge.g.a(java.lang.String):java.lang.Class");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0035 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, java.lang.String r7, java.lang.String r8, com.alibaba.security.realidentity.jsbridge.h r9) {
        /*
            java.util.List<com.alibaba.security.realidentity.jsbridge.g$a> r0 = com.alibaba.security.realidentity.jsbridge.g.b
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L38
            java.lang.Object r1 = r0.next()
            com.alibaba.security.realidentity.jsbridge.g$a r1 = (com.alibaba.security.realidentity.jsbridge.g.a) r1
            java.lang.String r4 = r1.a
            if (r4 == 0) goto L32
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)
            java.lang.String r5 = r1.a
            boolean r5 = android.text.TextUtils.equals(r7, r5)
            if (r5 != 0) goto L30
            java.util.List r4 = java.util.Arrays.asList(r4)
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L32
        L30:
            r4 = 1
            goto L33
        L32:
            r4 = 0
        L33:
            if (r4 == 0) goto L6
            java.lang.Class<? extends com.alibaba.security.realidentity.jsbridge.a> r0 = r1.b
            goto L39
        L38:
            r0 = 0
        L39:
            if (r0 == 0) goto L49
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Throwable -> L45
            com.alibaba.security.realidentity.jsbridge.a r0 = (com.alibaba.security.realidentity.jsbridge.a) r0     // Catch: java.lang.Throwable -> L45
            r0.a(r6, r8, r9)     // Catch: java.lang.Throwable -> L45
            return r2
        L45:
            r6 = move-exception
            a(r7, r8, r6)
        L49:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.jsbridge.g.a(android.content.Context, java.lang.String, java.lang.String, com.alibaba.security.realidentity.jsbridge.h):boolean");
    }
}
