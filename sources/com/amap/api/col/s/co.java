package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class co {
    static byte[] a;
    static byte[] b;
    private String c;

    public co(String str) {
        this.c = bs.a(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, bw.g(a(context, bw.a(str3))));
            a(edit);
        } catch (Throwable unused) {
        }
    }

    public static byte[] b(Context context, byte[] bArr) {
        try {
            return bp.a(a(context), bArr, b(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private static byte[] b(Context context) {
        byte[] bArr = b;
        if (bArr == null || bArr.length <= 0) {
            int i = 0;
            if (Build.VERSION.SDK_INT >= 9) {
                b = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
            } else {
                b = new byte[a(context).length / 2];
                while (true) {
                    byte[] bArr2 = b;
                    if (i >= bArr2.length) {
                        break;
                    }
                    bArr2[i] = a(context)[i];
                    i++;
                }
            }
            return b;
        }
        return bArr;
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return bp.b(a(context), bArr, b(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = a;
        if (bArr == null || bArr.length <= 0) {
            byte[] bytes = bk.f(context).getBytes();
            a = bytes;
            return bytes;
        }
        return bArr;
    }

    public static long b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, 0L);
        } catch (Throwable th) {
            cl.c(th, "csp", "glv");
            return 0L;
        }
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return bw.a(b(context, bw.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            cl.c(th, "csp", "gsv");
            return str3;
        }
    }

    public static SharedPreferences.Editor a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                ci.a(th, "sp", "ge");
            }
        }
        return null;
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            ci.a(th, "sp", "cm");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            cl.c(th, "csp", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            cl.c(th, "csp", "putPrefsInt");
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            cl.c(th, "csp", "gbv");
            return z;
        }
    }

    public static int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            cl.c(th, "csp", "giv");
            return i;
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (Throwable th) {
            cl.c(th, "csp", "plv");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                ci.a(th, "sp", IRequestConst.PS);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                ci.a(th, "sp", "rk");
            }
        }
    }
}
