package tb;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a83 {
    public static int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "getPrefsInt");
            return i;
        }
    }

    public static long b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "getPrefsLong");
            return j;
        }
    }

    public static SharedPreferences.Editor c(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static String d(Context context) {
        return context == null ? com.alipay.sdk.m.u.c.b : e(context, "pref", "smac", com.alipay.sdk.m.u.c.b);
    }

    public static String e(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static void f(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    public static void g(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void h(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "setPrefsInt");
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, long j) {
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void j(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "setPrefsStr");
        }
    }

    public static void k(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static boolean l(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            com.loc.j1.h(th, "SpUtil", "getPrefsBoolean");
            return z;
        }
    }
}
