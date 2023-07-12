package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.loc.C5846l;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class b43 {
    static byte[] a;
    static byte[] b;

    public b43(String str) {
        com.loc.r1.a(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "giv");
            return i;
        }
    }

    public static SharedPreferences.Editor b(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                y33.e(th, "sp", "ge");
            }
        }
        return null;
    }

    public static String c(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return com.loc.v1.g(q(context, com.loc.v1.z(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void d(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, com.loc.v1.F(m(context, com.loc.v1.p(str3))));
            e(edit);
        } catch (Throwable unused) {
        }
    }

    public static void e(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            y33.e(th, "sp", "cm");
        }
    }

    public static void f(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                y33.e(th, "sp", "rk");
            }
        }
    }

    public static void g(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "putPrefsInt");
        }
    }

    public static void h(SharedPreferences.Editor editor, String str, long j) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "plv");
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                y33.e(th, "sp", IRequestConst.PS);
            }
        }
    }

    public static void j(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "setPrefsStr");
        }
    }

    public static boolean k(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "gbv");
            return z;
        }
    }

    private static byte[] l(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = a;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = C5846l.j(context).getBytes();
            a = bytes;
            return bytes;
        }
        return bArr;
    }

    public static byte[] m(Context context, byte[] bArr) {
        try {
            return com.loc.p1.h(l(context), bArr, p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static long n(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, 0L);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "glv");
            return 0L;
        }
    }

    public static String o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            com.loc.an.m(th, "csp", "gsv");
            return str3;
        }
    }

    private static byte[] p(Context context) {
        byte[] bArr = b;
        if (bArr == null || bArr.length <= 0) {
            int i = 0;
            if (Build.VERSION.SDK_INT < 9) {
                b = new byte[l(context).length / 2];
                while (true) {
                    byte[] bArr2 = b;
                    if (i >= bArr2.length) {
                        break;
                    }
                    bArr2[i] = l(context)[i];
                    i++;
                }
            } else {
                b = Arrays.copyOfRange(l(context), 0, l(context).length / 2);
            }
            return b;
        }
        return bArr;
    }

    public static byte[] q(Context context, byte[] bArr) {
        try {
            return com.loc.p1.e(l(context), bArr, p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
