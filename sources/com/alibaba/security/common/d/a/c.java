package com.alibaba.security.common.d.a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class c {
    private static void a(Activity activity, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
            window.getDecorView().setSystemUiVisibility(0);
            View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(false);
                ViewCompat.requestApplyInsets(childAt);
            }
        } else if (i2 >= 19) {
            Window window2 = activity.getWindow();
            window2.addFlags(ConfigReporter.BIT_GETTER_IMP);
            View childAt2 = ((ViewGroup) window2.findViewById(16908290)).getChildAt(0);
            int a = a.a((Context) activity);
            a.a(activity);
            View view = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a);
            layoutParams.gravity = 48;
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(i);
            view.setTag("statusBarView");
            ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
            if (childAt2 != null && !"marginAdded".equals(childAt2.getTag())) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams2.topMargin += a;
                childAt2.setLayoutParams(layoutParams2);
                childAt2.setTag("marginAdded");
            }
            if (childAt2 != null) {
                childAt2.setFitsSystemWindows(false);
            }
        }
    }

    public static boolean b(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void c(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.addFlags(ConfigReporter.BIT_GETTER_IMP);
            window.getDecorView().setSystemUiVisibility(0);
            View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(false);
                ViewCompat.requestApplyInsets(childAt);
            }
        } else if (i >= 19) {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
            View childAt2 = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            a.a(activity);
            int a = a.a((Context) activity);
            if (childAt2 != null && "marginAdded".equals(childAt2.getTag())) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams.topMargin -= a;
                childAt2.setLayoutParams(layoutParams);
                childAt2.setTag(null);
            }
            if (childAt2 != null) {
                childAt2.setFitsSystemWindows(false);
            }
        }
    }

    private static void d(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.addFlags(ConfigReporter.BIT_GETTER_IMP);
            window.getDecorView().setSystemUiVisibility(0);
            View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(false);
                ViewCompat.requestApplyInsets(childAt);
            }
        } else if (i >= 19) {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
            View childAt2 = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            a.a(activity);
            int a = a.a((Context) activity);
            if (childAt2 != null && "marginAdded".equals(childAt2.getTag())) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams.topMargin -= a;
                childAt2.setLayoutParams(layoutParams);
                childAt2.setTag(null);
            }
            if (childAt2 != null) {
                childAt2.setFitsSystemWindows(false);
            }
        }
    }

    private static void e(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (a(activity) || b(activity)) {
                if (i >= 21) {
                    activity.getWindow().setStatusBarColor(-1);
                } else if (i >= 19) {
                    if (i >= 21) {
                        Window window = activity.getWindow();
                        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
                        window.addFlags(Integer.MIN_VALUE);
                        window.setStatusBarColor(-1);
                        window.getDecorView().setSystemUiVisibility(0);
                        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
                        if (childAt != null) {
                            childAt.setFitsSystemWindows(false);
                            ViewCompat.requestApplyInsets(childAt);
                        }
                    } else if (i >= 19) {
                        Window window2 = activity.getWindow();
                        window2.addFlags(ConfigReporter.BIT_GETTER_IMP);
                        View childAt2 = ((ViewGroup) window2.findViewById(16908290)).getChildAt(0);
                        int a = a.a((Context) activity);
                        a.a(activity);
                        View view = new View(activity);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a);
                        layoutParams.gravity = 48;
                        view.setLayoutParams(layoutParams);
                        view.setBackgroundColor(-1);
                        view.setTag("statusBarView");
                        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
                        if (childAt2 != null && !"marginAdded".equals(childAt2.getTag())) {
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                            layoutParams2.topMargin += a;
                            childAt2.setLayoutParams(layoutParams2);
                            childAt2.setTag("marginAdded");
                        }
                        if (childAt2 != null) {
                            childAt2.setFitsSystemWindows(false);
                        }
                    }
                }
            }
            if (i >= 23) {
                activity.getWindow().setBackgroundDrawableResource(17170445);
                activity.getWindow().getDecorView().setSystemUiVisibility(9216);
                activity.getWindow().setStatusBarColor(-1);
                View childAt3 = ((ViewGroup) activity.getWindow().findViewById(16908290)).getChildAt(0);
                if (childAt3 != null) {
                    childAt3.setFitsSystemWindows(true);
                    ViewCompat.requestApplyInsets(childAt3);
                }
            }
        }
    }

    private static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().setNavigationBarColor(0);
            activity.getWindow().setStatusBarColor(0);
        }
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private static void b(Activity activity, int i) {
        ((ViewGroup) activity.getWindow().findViewById(16908290)).setPadding(0, i, 0, 0);
    }

    public static boolean a(Activity activity) {
        try {
            Class<?> cls = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
            window.getDecorView().setSystemUiVisibility(8192);
            Class<?> cls2 = activity.getWindow().getClass();
            int i = cls.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls);
            Class<?> cls3 = Integer.TYPE;
            cls2.getMethod("setExtraFlags", cls3, cls3).invoke(activity.getWindow(), Integer.valueOf(i), Integer.valueOf(i));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
