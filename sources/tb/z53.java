package tb;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class z53 {
    public static final String a = "mcssdk---";
    private static String b = "MCS";
    private static boolean c = true;
    private static boolean d = true;
    private static String e = "-->";
    private static boolean f = true;

    public static void a(String str) {
        if (c && f) {
            Log.d(a, b + e + str);
        }
    }

    public static void b(String str) {
        if (d && f) {
            Log.e(a, b + e + str);
        }
    }

    public static void c(String str, String str2) {
        if (d && f) {
            Log.e(str, b + e + str2);
        }
    }

    public static void d(boolean z) {
        f = z;
        boolean z2 = z;
        c = z2;
        d = z2;
    }
}
