package com.youku.b.a;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    public static int a;
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public static boolean g;

    public static void a(Context context) {
        if (g || context == null) {
            return;
        }
        if ((context.getApplicationInfo().flags & 2) != 0) {
            a = 5;
            b = true;
            c = true;
            d = true;
            e = true;
            f = true;
        }
        g = true;
    }

    public static void a(String str, String str2) {
        if (c) {
            if (str2 == null) {
                str2 = "";
            }
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f) {
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2);
        }
    }
}
