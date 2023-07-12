package com.alibaba.security.common.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.q */
/* loaded from: classes8.dex */
public class C3825q {
    private static final String a = "q";

    private static int a(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    private static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static float f(Context context) {
        return DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
    }

    private static float g(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static float h(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int a(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 50.0f) + 0.5f);
    }

    private static void b(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.showSoftInput(view, 0);
    }

    public static float c(Context context) {
        return DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
    }

    private static void a(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static int b(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String c() {
        return Build.getMODEL();
    }

    private static String d() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    private static int e() {
        return Build.VERSION.SDK_INT;
    }

    private static void a(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private static String a() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER() + " " + com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    private static <T extends View> T a(Activity activity, int i) {
        return (T) activity.findViewById(i);
    }

    private static int b(Activity activity) {
        return activity.getWindow().findViewById(16908290).getTop() - b((Context) activity);
    }

    private static <T extends View> T a(View view, int i) {
        return (T) view.findViewById(i);
    }

    public static void a(View view) {
        if (view != null && Build.VERSION.SDK_INT > 28) {
            try {
                view.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(view, Boolean.FALSE);
            } catch (IllegalAccessException unused) {
                C3800a.b();
            } catch (NoSuchMethodException unused2) {
                C3800a.b();
            } catch (InvocationTargetException unused3) {
                C3800a.b();
            } catch (Exception unused4) {
                C3800a.b();
            }
        }
    }

    private static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
