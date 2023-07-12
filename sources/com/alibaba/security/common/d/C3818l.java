package com.alibaba.security.common.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.alibaba.security.common.c.C3800a;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.l */
/* loaded from: classes8.dex */
public final class C3818l {
    private static final String a = "PackageUtils";

    public static String a(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r3) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch: java.lang.Exception -> L14
            if (r1 != 0) goto L8
            return r0
        L8:
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L12
            r2 = 0
            android.content.pm.ApplicationInfo r0 = r1.getApplicationInfo(r3, r2)     // Catch: java.lang.Exception -> L12
            goto L1e
        L12:
            goto L15
        L14:
            r1 = r0
        L15:
            boolean r3 = com.alibaba.security.common.c.C3800a.a()
            if (r3 == 0) goto L1e
            com.alibaba.security.common.c.C3800a.b()
        L1e:
            if (r0 == 0) goto L27
            java.lang.CharSequence r3 = r1.getApplicationLabel(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L29
        L27:
            java.lang.String r3 = ""
        L29:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.d.C3818l.b(android.content.Context):java.lang.String");
    }

    public static String c(Context context) {
        PackageManager packageManager;
        PackageInfo packageInfo = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            if (C3800a.a()) {
                C3800a.b();
            }
        }
        if (packageManager == null) {
            return null;
        }
        packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        return packageInfo != null ? packageInfo.versionName : "";
    }

    public static boolean d(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
