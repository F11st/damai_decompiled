package com.loc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import org.apache.commons.lang3.time.DateUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class al {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    private static long e = 0;
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";
    private static Vector<u1> l = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<u1> b() {
        Vector<u1> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = l;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return l;
        }
    }

    public static void c(final Context context) {
        try {
            if (System.currentTimeMillis() - e < DateUtils.MILLIS_PER_MINUTE) {
                return;
            }
            e = System.currentTimeMillis();
            o0.f().d(new ck() { // from class: com.loc.al.1
                @Override // com.loc.ck
                public final void a() {
                    try {
                        ao.k(context);
                        ao.m(context);
                        ao.l(context);
                        bs.b(context);
                        bq.c(context);
                    } catch (RejectedExecutionException unused) {
                    } catch (Throwable th) {
                        an.m(th, "Lg", "proL");
                    }
                }
            });
        } catch (Throwable th) {
            an.m(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    public static void d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void e(u1 u1Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (u1Var == null) {
                    return;
                }
                if (l.contains(u1Var)) {
                    return;
                }
                l.add(u1Var);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        r1 = r7.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        if (r2 >= r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (h(r6, r7[r2].trim()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(java.lang.String[] r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L4d
            if (r7 != 0) goto L6
            goto L4d
        L6:
            java.lang.String r1 = "\n"
            java.lang.String[] r7 = r7.split(r1)     // Catch: java.lang.Throwable -> L49
            int r1 = r7.length     // Catch: java.lang.Throwable -> L49
            r2 = 0
        Le:
            r3 = 1
            if (r2 >= r1) goto L35
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L49
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L49
            if (r5 != 0) goto L2e
            java.lang.String r5 = "at "
            boolean r5 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L2e
            java.lang.String r5 = "uncaughtException"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            r3 = 0
        L2f:
            if (r3 == 0) goto L32
            return r0
        L32:
            int r2 = r2 + 1
            goto Le
        L35:
            int r1 = r7.length     // Catch: java.lang.Throwable -> L49
            r2 = 0
        L37:
            if (r2 >= r1) goto L4d
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L49
            boolean r4 = h(r6, r4)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L46
            return r3
        L46:
            int r2 = r2 + 1
            goto L37
        L49:
            r6 = move-exception
            r6.printStackTrace()
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.al.f(java.lang.String[], java.lang.String):boolean");
    }

    public static void g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(jn1.BRACKET_END_STR) && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }
}
