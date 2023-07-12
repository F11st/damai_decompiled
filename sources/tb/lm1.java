package tb;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lm1 {
    public static String a() {
        return Build.getMANUFACTURER();
    }

    public static int b() {
        String g = g("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(g)) {
            return -1;
        }
        try {
            return Integer.parseInt(g) + 2;
        } catch (Exception e) {
            nz.d("OSUtils", String.format("get MIUI version code failed: %s", g), e);
            return -1;
        }
    }

    public static String c() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String d() {
        return h() ? "MIUI" : "OTHER";
    }

    public static String e() {
        return i() ? g("ro.miui.ui.version.name") : "";
    }

    public static String f() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r2.<init>()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r2.append(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.Process r4 = r1.exec(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L46
            r1.close()     // Catch: java.io.IOException -> L32
            goto L45
        L32:
            r4 = move-exception
            tb.ry.b(r4)
            goto L45
        L37:
            r4 = move-exception
            goto L3d
        L39:
            r4 = move-exception
            goto L48
        L3b:
            r4 = move-exception
            r1 = r0
        L3d:
            tb.ry.b(r4)     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.io.IOException -> L32
        L45:
            return r0
        L46:
            r4 = move-exception
            r0 = r1
        L48:
            if (r0 == 0) goto L52
            r0.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r0 = move-exception
            tb.ry.b(r0)
        L52:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.lm1.g(java.lang.String):java.lang.String");
    }

    public static boolean h() {
        return (TextUtils.isEmpty(g("ro.miui.ui.version.name")) && b() == -1) ? false : true;
    }

    public static boolean i() {
        return "Xiaomi".equals(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
    }
}
