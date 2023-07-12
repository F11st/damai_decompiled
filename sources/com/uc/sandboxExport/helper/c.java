package com.uc.sandboxExport.helper;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private static Method a;

        static {
            try {
                a = Class.forName("android.util.Log").getDeclaredMethod("println", Integer.TYPE, String.class, String.class);
            } catch (Throwable unused) {
            }
        }

        public static void a(int i, String str, String str2) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(null, Integer.valueOf(i), str, str2);
                    return;
                } catch (Throwable unused) {
                    a = null;
                }
            }
            Log.println(i, str, str2);
        }
    }

    public static String a(String str, Object... objArr) {
        if (objArr != null) {
            try {
                return objArr.length != 0 ? String.format(Locale.getDefault(), str, objArr) : str;
            } catch (Throwable unused) {
                return str;
            }
        }
        return str;
    }

    public static void b(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Throwable a3 = a(objArr);
        if (a3 != null) {
            a(str, a2, a3);
        } else {
            a(str, a2);
        }
    }

    public static Throwable a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static void a(int i, String str, String str2, Throwable th) {
        a.a(i, str, str2);
        if (th != null) {
            a.a(i, str, th.toString());
            a.a(i, str, Log.getStackTraceString(th));
        }
    }

    public static void a(String str, String str2) {
        a(6, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(6, str, str2, th);
    }

    public static void a(String str, String str2, Object... objArr) {
        String a2 = a(str2, objArr);
        Throwable a3 = a(objArr);
        if (a3 != null) {
            a(4, str, a2, a3);
        } else {
            a(4, str, a2, null);
        }
    }
}
