package com.youku.live.livesdk.wkit.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.live.livesdk.R;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveStatusBarUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;
    private static final int TAG_KEY_HAVE_SET_OFFSET = -123;
    private static final int FAKE_STATUS_BAR_VIEW_ID = R.id.statusbarutil_fake_status_bar_view;
    private static final int FAKE_TRANSLUCENT_VIEW_ID = R.id.statusbarutil_translucent_view;
    private static TypedValue mTmpValue = new TypedValue();

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976659752")) {
            return ((Boolean) ipChange.ipc$dispatch("-1976659752", new Object[]{window, Boolean.valueOf(z)})).booleanValue();
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

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005260869")) {
            return ((Boolean) ipChange.ipc$dispatch("-1005260869", new Object[]{window, Boolean.valueOf(z)})).booleanValue();
        }
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int StatusBarLightMode(Activity activity) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1049709341")) {
            return ((Integer) ipChange.ipc$dispatch("-1049709341", new Object[]{activity})).intValue();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            if (i2 >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8192);
                i = 3;
            }
            if (MIUISetStatusBarLightMode(activity.getWindow(), true)) {
                return 1;
            }
            if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
                return 2;
            }
            return i;
        }
        return 0;
    }

    private static void addTranslucentView(Activity activity, @IntRange(from = 0, to = 255) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995902376")) {
            ipChange.ipc$dispatch("-995902376", new Object[]{activity, Integer.valueOf(i)});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(Color.argb(i, 0, 0, 0));
            return;
        }
        viewGroup.addView(createTranslucentStatusBarView(activity, i));
    }

    private static int calculateStatusColor(@ColorInt int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089230206")) {
            return ((Integer) ipChange.ipc$dispatch("2089230206", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (i2 / 255.0f);
        return ((int) (((i & 255) * f) + 0.5d)) | (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | (-16777216) | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8);
    }

    @TargetApi(19)
    private static void clearPreviousSetting(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119872484")) {
            ipChange.ipc$dispatch("-2119872484", new Object[]{activity});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    private static View createStatusBarView(Activity activity, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1222255401") ? (View) ipChange.ipc$dispatch("1222255401", new Object[]{activity, Integer.valueOf(i)}) : createStatusBarView(activity, i, 0);
    }

    private static View createTranslucentStatusBarView(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779058010")) {
            return (View) ipChange.ipc$dispatch("-1779058010", new Object[]{activity, Integer.valueOf(i)});
        }
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        view.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return view;
    }

    public static int getResourceValue(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1633817833")) {
            return ((Integer) ipChange.ipc$dispatch("-1633817833", new Object[]{context, Integer.valueOf(i)})).intValue();
        }
        TypedValue typedValue = mTmpValue;
        context.getResources().getValue(i, typedValue, true);
        return (int) TypedValue.complexToFloat(typedValue.data);
    }

    public static int getStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1107332809") ? ((Integer) ipChange.ipc$dispatch("-1107332809", new Object[]{context})).intValue() : context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public static int getStatusBarHeightInDp(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582667800")) {
            return ((Integer) ipChange.ipc$dispatch("-582667800", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return getResourceValue(context, identifier);
        }
        return 0;
    }

    public static void hideFakeStatusBarView(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "852039319")) {
            ipChange.ipc$dispatch("852039319", new Object[]{activity});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = viewGroup.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    public static void hideNavKey(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "55778128")) {
            ipChange.ipc$dispatch("55778128", new Object[]{context});
        } else if (context == null || !(context instanceof Activity)) {
        } else {
            int i = Build.VERSION.SDK_INT;
            if (i > 11 && i < 19) {
                ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i >= 19) {
                ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(4615);
            }
        }
    }

    public static void setColor(Activity activity, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680066692")) {
            ipChange.ipc$dispatch("-1680066692", new Object[]{activity, Integer.valueOf(i)});
        } else {
            setColor(activity, i, 112);
        }
    }

    @Deprecated
    public static void setColorDiff(Activity activity, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427975327")) {
            ipChange.ipc$dispatch("-1427975327", new Object[]{activity, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT < 19) {
        } else {
            transparentStatusBar(activity);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View findViewById = viewGroup.findViewById(FAKE_STATUS_BAR_VIEW_ID);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i);
            } else {
                viewGroup.addView(createStatusBarView(activity, i));
            }
            setRootView(activity);
        }
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049205827")) {
            ipChange.ipc$dispatch("-1049205827", new Object[]{activity, drawerLayout, Integer.valueOf(i)});
        } else {
            setColorForDrawerLayout(activity, drawerLayout, i, 112);
        }
    }

    @Deprecated
    public static void setColorForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081625784")) {
            ipChange.ipc$dispatch("1081625784", new Object[]{activity, drawerLayout, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(FAKE_STATUS_BAR_VIEW_ID);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(calculateStatusColor(i, 112));
            } else {
                viewGroup.addView(createStatusBarView(activity, i), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
            }
            setDrawerLayoutProperty(drawerLayout, viewGroup);
        }
    }

    public static void setColorForSwipeBack(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992425964")) {
            ipChange.ipc$dispatch("-1992425964", new Object[]{activity, Integer.valueOf(i)});
        } else {
            setColorForSwipeBack(activity, i, 112);
        }
    }

    public static void setColorNoTranslucent(Activity activity, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587930356")) {
            ipChange.ipc$dispatch("587930356", new Object[]{activity, Integer.valueOf(i)});
        } else {
            setColor(activity, i, 0);
        }
    }

    public static void setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558937909")) {
            ipChange.ipc$dispatch("1558937909", new Object[]{activity, drawerLayout, Integer.valueOf(i)});
        } else {
            setColorForDrawerLayout(activity, drawerLayout, i, 0);
        }
    }

    private static void setDrawerLayoutProperty(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1669746246")) {
            ipChange.ipc$dispatch("1669746246", new Object[]{drawerLayout, viewGroup});
            return;
        }
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
    }

    private static void setRootView(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283915261")) {
            ipChange.ipc$dispatch("283915261", new Object[]{activity});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255676789")) {
            ipChange.ipc$dispatch("1255676789", new Object[]{activity, Boolean.valueOf(z)});
        } else if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
                return;
            }
            viewGroup.setFitsSystemWindows(z);
        }
    }

    public static void setTranslucent(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188404495")) {
            ipChange.ipc$dispatch("-1188404495", new Object[]{activity});
        } else {
            setTranslucent(activity, 112);
        }
    }

    @Deprecated
    public static void setTranslucentDiff(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404349292")) {
            ipChange.ipc$dispatch("404349292", new Object[]{activity});
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
            setRootView(activity);
        }
    }

    public static void setTranslucentForCoordinatorLayout(Activity activity, @IntRange(from = 0, to = 255) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881670851")) {
            ipChange.ipc$dispatch("1881670851", new Object[]{activity, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT < 19) {
        } else {
            transparentStatusBar(activity);
            addTranslucentView(activity, i);
        }
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168490480")) {
            ipChange.ipc$dispatch("-168490480", new Object[]{activity, drawerLayout});
        } else {
            setTranslucentForDrawerLayout(activity, drawerLayout, 112);
        }
    }

    @Deprecated
    public static void setTranslucentForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463175499")) {
            ipChange.ipc$dispatch("-463175499", new Object[]{activity, drawerLayout});
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    public static void setTranslucentForImageView(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716139192")) {
            ipChange.ipc$dispatch("716139192", new Object[]{activity, view});
        } else {
            setTranslucentForImageView(activity, 112, view);
        }
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380333485")) {
            ipChange.ipc$dispatch("380333485", new Object[]{activity, view});
        } else {
            setTranslucentForImageViewInFragment(activity, 112, view);
        }
    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009425823")) {
            ipChange.ipc$dispatch("2009425823", new Object[]{activity});
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

    public static void setTransparent(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1795063576")) {
            ipChange.ipc$dispatch("1795063576", new Object[]{activity});
        } else if (Build.VERSION.SDK_INT < 19) {
        } else {
            transparentStatusBar(activity);
            setRootView(activity);
        }
    }

    public static void setTransparentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692424055")) {
            ipChange.ipc$dispatch("1692424055", new Object[]{activity, drawerLayout});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 19) {
            return;
        }
        if (i >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        }
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
        }
        setDrawerLayoutProperty(drawerLayout, viewGroup);
    }

    public static void setTransparentForImageView(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152485809")) {
            ipChange.ipc$dispatch("1152485809", new Object[]{activity, view});
        } else {
            setTranslucentForImageView(activity, 0, view);
        }
    }

    public static void setTransparentForImageViewInFragment(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248728730")) {
            ipChange.ipc$dispatch("-1248728730", new Object[]{activity, view});
        } else {
            setTranslucentForImageViewInFragment(activity, 0, view);
        }
    }

    private static void setTransparentForWindow(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254804419")) {
            ipChange.ipc$dispatch("-254804419", new Object[]{activity});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (i >= 19) {
            activity.getWindow().setFlags(ConfigReporter.BIT_GETTER_IMP, ConfigReporter.BIT_GETTER_IMP);
        }
    }

    public static void showNavKey(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1479338571")) {
            ipChange.ipc$dispatch("1479338571", new Object[]{context});
        } else if (context == null || !(context instanceof Activity)) {
        } else {
            int i = Build.VERSION.SDK_INT;
            if (i > 11 && i < 19) {
                ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(0);
            } else if (i >= 19) {
                ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    @TargetApi(19)
    private static void transparentStatusBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089709255")) {
            ipChange.ipc$dispatch("-2089709255", new Object[]{activity});
        } else if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            activity.getWindow().addFlags(134217728);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        }
    }

    private static View createStatusBarView(Activity activity, @ColorInt int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108872318")) {
            return (View) ipChange.ipc$dispatch("108872318", new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(calculateStatusColor(i, i2));
        view.setId(FAKE_STATUS_BAR_VIEW_ID);
        return view;
    }

    public static void setColor(Activity activity, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542430457")) {
            ipChange.ipc$dispatch("-542430457", new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            activity.getWindow().setStatusBarColor(calculateStatusColor(i, i2));
        } else if (i3 >= 19) {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewById = viewGroup.findViewById(FAKE_STATUS_BAR_VIEW_ID);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(calculateStatusColor(i, i2));
            } else {
                viewGroup.addView(createStatusBarView(activity, i, i2));
            }
            setRootView(activity);
        }
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834387174")) {
            ipChange.ipc$dispatch("1834387174", new Object[]{activity, drawerLayout, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 19) {
            return;
        }
        if (i3 >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        }
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        View findViewById = viewGroup.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(i);
        } else {
            viewGroup.addView(createStatusBarView(activity, i), 0);
        }
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), getStatusBarHeight(activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
        setDrawerLayoutProperty(drawerLayout, viewGroup);
        addTranslucentView(activity, i2);
    }

    public static void setColorForSwipeBack(Activity activity, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635633297")) {
            ipChange.ipc$dispatch("-1635633297", new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View childAt = viewGroup.getChildAt(0);
            int statusBarHeight = getStatusBarHeight(activity);
            if (childAt != null && (childAt instanceof CoordinatorLayout)) {
                final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) childAt;
                if (i3 < 21) {
                    coordinatorLayout.setFitsSystemWindows(false);
                    viewGroup.setBackgroundColor(calculateStatusColor(i, i2));
                    if (viewGroup.getPaddingTop() < statusBarHeight) {
                        viewGroup.setPadding(0, statusBarHeight, 0, 0);
                        coordinatorLayout.post(new Runnable() { // from class: com.youku.live.livesdk.wkit.utils.LiveStatusBarUtil.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "907153052")) {
                                    ipChange2.ipc$dispatch("907153052", new Object[]{this});
                                } else {
                                    CoordinatorLayout.this.requestLayout();
                                }
                            }
                        });
                    }
                } else {
                    coordinatorLayout.setStatusBarBackgroundColor(calculateStatusColor(i, i2));
                }
            } else {
                viewGroup.setPadding(0, statusBarHeight, 0, 0);
                viewGroup.setBackgroundColor(calculateStatusColor(i, i2));
            }
            setTransparentForWindow(activity);
        }
    }

    public static void setTranslucent(Activity activity, @IntRange(from = 0, to = 255) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814195762")) {
            ipChange.ipc$dispatch("1814195762", new Object[]{activity, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT < 19) {
        } else {
            setTransparent(activity);
            addTranslucentView(activity, i);
        }
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, @IntRange(from = 0, to = 255) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928208141")) {
            ipChange.ipc$dispatch("-928208141", new Object[]{activity, drawerLayout, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT < 19) {
        } else {
            setTransparentForDrawerLayout(activity, drawerLayout);
            addTranslucentView(activity, i);
        }
    }

    public static void setTranslucentForImageView(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823555017")) {
            ipChange.ipc$dispatch("823555017", new Object[]{activity, Integer.valueOf(i), view});
        } else if (Build.VERSION.SDK_INT < 19) {
        } else {
            setTransparentForWindow(activity);
            addTranslucentView(activity, i);
            if (view != null) {
                Object tag = view.getTag(TAG_KEY_HAVE_SET_OFFSET);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(TAG_KEY_HAVE_SET_OFFSET, Boolean.TRUE);
                }
            }
        }
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996487308")) {
            ipChange.ipc$dispatch("-996487308", new Object[]{activity, Integer.valueOf(i), view});
            return;
        }
        setTranslucentForImageView(activity, i, view);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 21) {
            return;
        }
        clearPreviousSetting(activity);
    }
}
