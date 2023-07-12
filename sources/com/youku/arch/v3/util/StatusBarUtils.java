package com.youku.arch.v3.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StatusBarUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static float DEFAULT_ALPHA = 0.0f;
    public static int DEFAULT_COLOR = 0;
    public static final int MIN_API = 19;
    private static final String TAG = "OneArch.StatusBarUtils";
    private static final Pattern pattern = Pattern.compile("Flyme OS [4|5]", 2);

    public static void darkMode(Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865097198")) {
            ipChange.ipc$dispatch("1865097198", new Object[]{activity, Boolean.valueOf(z)});
        } else if (isFlyme4Later()) {
            darkModeForFlyme4(activity.getWindow(), z);
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(activity.getWindow(), z);
        } else if (Build.VERSION.SDK_INT >= 23) {
            darkModeForM(activity.getWindow(), z);
        }
    }

    public static boolean darkModeForFlyme4(Window window, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1375062091")) {
            return ((Boolean) ipChange.ipc$dispatch("-1375062091", new Object[]{window, Boolean.valueOf(z)})).booleanValue();
        }
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @RequiresApi(23)
    private static void darkModeForM(Window window, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337760675")) {
            ipChange.ipc$dispatch("-1337760675", new Object[]{window, Boolean.valueOf(z)});
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static boolean darkModeForMIUI6(Window window, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949079096")) {
            return ((Boolean) ipChange.ipc$dispatch("-1949079096", new Object[]{window, Boolean.valueOf(z)})).booleanValue();
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getNavBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479595723")) {
            return ((Integer) ipChange.ipc$dispatch("479595723", new Object[]{context})).intValue();
        }
        if (hasNavBar(context)) {
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
            Log.d(TAG, "getNavBarHeight: height=" + dimensionPixelSize);
            return dimensionPixelSize;
        }
        return 0;
    }

    public static int getStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308852288")) {
            return ((Integer) ipChange.ipc$dispatch("1308852288", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return (int) TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics());
    }

    public static boolean hasNavBar(Context context) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1550626599")) {
            return ((Boolean) ipChange.ipc$dispatch("-1550626599", new Object[]{context})).booleanValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        Log.d(TAG, "hasNavBar: config id=" + identifier + "; result=" + z2);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                z = false;
            } else if (!"0".equals(str)) {
                z = z2;
            }
            try {
                Log.d(TAG, "hasNavBar: config id=" + identifier + "; result=" + z);
                return z;
            } catch (Exception unused) {
                z2 = z;
                return z2;
            }
        } catch (Exception unused2) {
        }
    }

    public static void immersive(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381265652")) {
            ipChange.ipc$dispatch("381265652", new Object[]{activity});
        } else {
            immersive(activity, DEFAULT_COLOR, DEFAULT_ALPHA);
        }
    }

    public static boolean isFlyme4Later() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2065379048") ? ((Boolean) ipChange.ipc$dispatch("2065379048", new Object[0])).booleanValue() : Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || pattern.matcher(Build.DISPLAY).find();
    }

    public static boolean isMIUI6Later() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049066399")) {
            return ((Boolean) ipChange.ipc$dispatch("-1049066399", new Object[0])).booleanValue();
        }
        try {
            int parseInt = Integer.parseInt(((String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, "ro.miui.ui.version.name")).replaceAll("[vV]", ""));
            return parseInt >= 6 && parseInt < 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int mixtureColor(int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037832042")) {
            return ((Integer) ipChange.ipc$dispatch("2037832042", new Object[]{Integer.valueOf(i), Float.valueOf(f)})).intValue();
        }
        return (i & 16777215) | (((int) ((((-16777216) & i) == 0 ? 255 : i >>> 24) * f)) << 24);
    }

    public static void setHeightAndPadding(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862511964")) {
            ipChange.ipc$dispatch("-1862511964", new Object[]{context, view});
        } else if (Build.VERSION.SDK_INT >= 19) {
            view.getLayoutParams().height += getStatusBarHeight(context);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setMargin(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832617")) {
            ipChange.ipc$dispatch("-832617", new Object[]{context, view});
        } else if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += getStatusBarHeight(context);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void setPadding(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994216328")) {
            ipChange.ipc$dispatch("994216328", new Object[]{context, view});
        } else if (Build.VERSION.SDK_INT >= 19) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setPaddingSmart(Context context, View view) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1412355251")) {
            ipChange.ipc$dispatch("-1412355251", new Object[]{context, view});
        } else if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (i = layoutParams.height) > 0) {
                layoutParams.height = i + getStatusBarHeight(context);
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setTranslucentView(ViewGroup viewGroup, int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127259603")) {
            ipChange.ipc$dispatch("-1127259603", new Object[]{viewGroup, Integer.valueOf(i), Float.valueOf(f)});
        } else if (Build.VERSION.SDK_INT >= 19) {
            int mixtureColor = mixtureColor(i, f);
            View findViewById = viewGroup.findViewById(16908331);
            if (findViewById == null && mixtureColor != 0) {
                findViewById = new View(viewGroup.getContext());
                findViewById.setId(16908331);
                viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, getStatusBarHeight(viewGroup.getContext())));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(mixtureColor);
            }
        }
    }

    public static void immersive(Activity activity, int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1325010705")) {
            ipChange.ipc$dispatch("1325010705", new Object[]{activity, Integer.valueOf(i), Float.valueOf(f)});
        } else {
            immersive(activity.getWindow(), i, f);
        }
    }

    public static void immersive(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065637233")) {
            ipChange.ipc$dispatch("-1065637233", new Object[]{activity, Integer.valueOf(i)});
        } else {
            immersive(activity.getWindow(), i, 1.0f);
        }
    }

    public static void immersive(Window window) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312830981")) {
            ipChange.ipc$dispatch("312830981", new Object[]{window});
        } else {
            immersive(window, DEFAULT_COLOR, DEFAULT_ALPHA);
        }
    }

    public static void immersive(Window window, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107855262")) {
            ipChange.ipc$dispatch("1107855262", new Object[]{window, Integer.valueOf(i)});
        } else {
            immersive(window, i, 1.0f);
        }
    }

    public static void immersive(Window window, int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16198686")) {
            ipChange.ipc$dispatch("-16198686", new Object[]{window, Integer.valueOf(i), Float.valueOf(f)});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(mixtureColor(i, f));
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
        } else if (i2 >= 19) {
            window.addFlags(ConfigReporter.BIT_GETTER_IMP);
            setTranslucentView((ViewGroup) window.getDecorView(), i, f);
        } else if (i2 < 19 || i2 <= 16) {
        } else {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
        }
    }

    public static void darkMode(Window window, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895147553")) {
            ipChange.ipc$dispatch("1895147553", new Object[]{window, Boolean.valueOf(z)});
        } else if (isFlyme4Later()) {
            darkModeForFlyme4(window, z);
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(window, z);
        } else if (Build.VERSION.SDK_INT >= 23) {
            darkModeForM(window, z);
        }
    }

    public static void darkMode(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1168541606")) {
            ipChange.ipc$dispatch("1168541606", new Object[]{activity});
        } else {
            darkMode(activity.getWindow(), DEFAULT_COLOR, DEFAULT_ALPHA);
        }
    }

    public static void darkMode(Activity activity, int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1982958403")) {
            ipChange.ipc$dispatch("1982958403", new Object[]{activity, Integer.valueOf(i), Float.valueOf(f)});
        } else {
            darkMode(activity.getWindow(), i, f);
        }
    }

    public static void darkMode(Window window, int i, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1380447888")) {
            ipChange.ipc$dispatch("-1380447888", new Object[]{window, Integer.valueOf(i), Float.valueOf(f)});
        } else if (isFlyme4Later()) {
            darkModeForFlyme4(window, true);
            immersive(window, i, f);
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(window, true);
            immersive(window, i, f);
        } else {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                darkModeForM(window, true);
                immersive(window, i, f);
            } else if (i2 >= 19) {
                window.addFlags(ConfigReporter.BIT_GETTER_IMP);
                setTranslucentView((ViewGroup) window.getDecorView(), i, f);
            } else {
                immersive(window, i, f);
            }
        }
    }
}
