package com.amap.api.mapcore.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hb {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    public static String e = "s";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";
    private static long l;

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    @TargetApi(9)
    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<gm> b(Context context) {
        List<gm> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new hl(context, false).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - l < DateUtils.MILLIS_PER_MINUTE) {
                return;
            }
            l = System.currentTimeMillis();
            ExecutorService d2 = hd.d();
            if (d2 != null && !d2.isShutdown()) {
                d2.submit(new Runnable() { // from class: com.amap.api.mapcore.util.hb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            he.b(context);
                            he.d(context);
                            he.c(context);
                            it.a(context);
                            ir.a(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            hd.c(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            hd.c(th, "Lg", "proL");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String[] strArr, String str) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                String[] split = str.split(StringUtils.LF);
                for (String str2 : split) {
                    if (a(str2.trim())) {
                        return false;
                    }
                }
                for (String str3 : split) {
                    if (b(strArr, str3.trim())) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("at ") && str.contains("uncaughtException");
    }
}
