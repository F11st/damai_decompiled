package com.youku.live.livesdk.wkit.component.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class StatusBarUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_FLYME = 1;
    public static final int TYPE_M = 3;
    public static final int TYPE_MIUI = 0;

    public static int getStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906800731")) {
            return ((Integer) ipChange.ipc$dispatch("-906800731", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean setCommonUI(Activity activity, boolean z) {
        View decorView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072000155")) {
            return ((Boolean) ipChange.ipc$dispatch("-1072000155", new Object[]{activity, Boolean.valueOf(z)})).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 23 || (decorView = activity.getWindow().getDecorView()) == null) {
            return false;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        if (decorView.getSystemUiVisibility() != i) {
            decorView.setSystemUiVisibility(i);
        }
        return true;
    }

    public static boolean setFlymeUI(Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255385275")) {
            return ((Boolean) ipChange.ipc$dispatch("1255385275", new Object[]{activity, Boolean.valueOf(z)})).booleanValue();
        }
        try {
            Window window = activity.getWindow();
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setMiuiUI(Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083189142")) {
            return ((Boolean) ipChange.ipc$dispatch("-2083189142", new Object[]{activity, Boolean.valueOf(z)})).booleanValue();
        }
        try {
            Window window = activity.getWindow();
            Class<?> cls = activity.getWindow().getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("setExtraFlags", cls3, cls3);
            declaredMethod.setAccessible(true);
            if (z) {
                declaredMethod.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                declaredMethod.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246997987")) {
            ipChange.ipc$dispatch("1246997987", new Object[]{activity, Boolean.valueOf(z)});
        } else if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
                return;
            }
            viewGroup.setFitsSystemWindows(z);
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731986573")) {
            ipChange.ipc$dispatch("-731986573", new Object[]{activity, Integer.valueOf(i)});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            activity.getWindow().setStatusBarColor(i);
        } else if (i2 >= 19) {
            setTranslucentStatus(activity);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintColor(i);
        }
    }

    public static boolean setStatusBarDarkTheme(Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528451624")) {
            return ((Boolean) ipChange.ipc$dispatch("-528451624", new Object[]{activity, Boolean.valueOf(z)})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (i >= 23) {
                setStatusBarFontIconDark(activity, 3, z);
            } else if (OSUtils.isMiui()) {
                setStatusBarFontIconDark(activity, 0, z);
            } else if (OSUtils.isFlyme()) {
                setStatusBarFontIconDark(activity, 1, z);
            }
            return true;
        }
        return false;
    }

    public static boolean setStatusBarFontIconDark(Activity activity, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698419534")) {
            return ((Boolean) ipChange.ipc$dispatch("-1698419534", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        }
        if (i != 0) {
            if (i != 1) {
                return setCommonUI(activity, z);
            }
            return setFlymeUI(activity, z);
        }
        return setMiuiUI(activity, z);
    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893599375")) {
            ipChange.ipc$dispatch("-893599375", new Object[]{activity});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (i >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags = 67108864 | attributes.flags;
            window2.setAttributes(attributes);
        }
    }
}
