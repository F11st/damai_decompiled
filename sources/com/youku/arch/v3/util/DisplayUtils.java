package com.youku.arch.v3.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import androidx.annotation.DimenRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DisplayUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_STATUS_BAR_HEIFHT = 25;
    private static final int DENSITY_400 = 400;
    public static final String EX_DENSITY_HIGH = "_hdpi";
    public static final String EX_DENSITY_LOW = "_ldpi";
    public static final String EX_DENSITY_MEDIUM = "_mdpi";
    public static final String EX_DENSITY_XHIGH = "_xhdpi";
    public static final String EX_DENSITY_XXHIGH = "_xxhdpi";
    private static final float ROUND_DIFFERENCE = 0.5f;
    private static Configuration sConfiguration;
    private static DisplayMetrics sDisplayMetrics;
    private static Typeface sIconTypeFace;
    private static float sSystemStatusBarHeight;

    public static int dp2px(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502665050")) {
            return ((Integer) ipChange.ipc$dispatch("-502665050", new Object[]{Integer.valueOf(i)})).intValue();
        }
        return (int) ((i * getDisplayMetrics().density) + (i > 0 ? 0.5f : -0.5f));
    }

    public static int getBitmapDensity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227373724")) {
            return ((Integer) ipChange.ipc$dispatch("227373724", new Object[0])).intValue();
        }
        int i = getDisplayMetrics().densityDpi;
        if (i <= 120) {
            return 120;
        }
        if (i <= 160) {
            return 160;
        }
        if (i <= 240) {
            return GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
        }
        if (i > 320 && i > 400) {
            return GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
        }
        return 320;
    }

    public static String getBitmapDensityStr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412689776")) {
            return (String) ipChange.ipc$dispatch("-412689776", new Object[0]);
        }
        int bitmapDensity = getBitmapDensity();
        return bitmapDensity != 120 ? bitmapDensity != 160 ? bitmapDensity != 240 ? bitmapDensity != 320 ? bitmapDensity != 480 ? "" : EX_DENSITY_XXHIGH : EX_DENSITY_XHIGH : EX_DENSITY_HIGH : EX_DENSITY_MEDIUM : EX_DENSITY_LOW;
    }

    public static Typeface getBlankPageTypeFace() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731992226")) {
            return (Typeface) ipChange.ipc$dispatch("-731992226", new Object[0]);
        }
        return null;
    }

    private static Configuration getConfiguration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731974956")) {
            return (Configuration) ipChange.ipc$dispatch("731974956", new Object[0]);
        }
        if (sConfiguration == null) {
            sConfiguration = AppInfoProviderProxy.getAppContext().getResources().getConfiguration();
        }
        return sConfiguration;
    }

    public static float getDensity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1442988490") ? ((Float) ipChange.ipc$dispatch("1442988490", new Object[0])).floatValue() : getDisplayMetrics().density;
    }

    public static int getDensityDpi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "610708614") ? ((Integer) ipChange.ipc$dispatch("610708614", new Object[0])).intValue() : getDisplayMetrics().densityDpi;
    }

    public static int getDimensionPixelSize(@DimenRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2005336241") ? ((Integer) ipChange.ipc$dispatch("-2005336241", new Object[]{Integer.valueOf(i)})).intValue() : AppInfoProviderProxy.getAppContext().getResources().getDimensionPixelSize(i);
    }

    private static DisplayMetrics getDisplayMetrics() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857223658")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("857223658", new Object[0]);
        }
        if (sDisplayMetrics == null) {
            sDisplayMetrics = AppInfoProviderProxy.getAppContext().getResources().getDisplayMetrics();
        }
        return sDisplayMetrics;
    }

    public static int getHeightPixels() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1541885959") ? ((Integer) ipChange.ipc$dispatch("1541885959", new Object[0])).intValue() : com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(getDisplayMetrics());
    }

    public static Typeface getIconTypeFace() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361796334")) {
            return (Typeface) ipChange.ipc$dispatch("361796334", new Object[0]);
        }
        if (sIconTypeFace == null) {
            initFonts(AppInfoProviderProxy.getAppContext());
        }
        return sIconTypeFace;
    }

    public static Typeface getLockScreenTypeFaceTypeFace() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939502073")) {
            return (Typeface) ipChange.ipc$dispatch("1939502073", new Object[0]);
        }
        return null;
    }

    public static float getStatusBarHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "322510442") ? ((Float) ipChange.ipc$dispatch("322510442", new Object[0])).floatValue() : sSystemStatusBarHeight;
    }

    public static int getWidthPixels() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1909168062") ? ((Integer) ipChange.ipc$dispatch("-1909168062", new Object[0])).intValue() : com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(getDisplayMetrics());
    }

    public static void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765062324")) {
            ipChange.ipc$dispatch("-1765062324", new Object[]{context});
            return;
        }
        sDisplayMetrics = context.getResources().getDisplayMetrics();
        sConfiguration = context.getResources().getConfiguration();
        initStatusBarHeight(context);
    }

    public static void initFonts(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1112805918")) {
            ipChange.ipc$dispatch("1112805918", new Object[]{context});
            return;
        }
        try {
            sIconTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/ykf_iconfont.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811447970")) {
            ipChange.ipc$dispatch("1811447970", new Object[]{context});
            return;
        }
        sSystemStatusBarHeight = dp2px(25);
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            sSystemStatusBarHeight = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPortrait() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1786945227") ? ((Boolean) ipChange.ipc$dispatch("1786945227", new Object[0])).booleanValue() : getConfiguration().orientation == 1 || (getConfiguration().orientation == 0 && getHeightPixels() > getWidthPixels());
    }

    public static void onConfigurationChanged(Context context, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676625545")) {
            ipChange.ipc$dispatch("-676625545", new Object[]{context, configuration});
            return;
        }
        sDisplayMetrics = context.getResources().getDisplayMetrics();
        sConfiguration = configuration;
    }

    public static int px2dp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10639314")) {
            return ((Integer) ipChange.ipc$dispatch("-10639314", new Object[]{Integer.valueOf(i)})).intValue();
        }
        return (int) ((i / getDisplayMetrics().density) + (i > 0 ? 0.5f : -0.5f));
    }

    public static void initFonts() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780471062")) {
            ipChange.ipc$dispatch("-780471062", new Object[0]);
        } else {
            initFonts(AppInfoProviderProxy.getAppContext());
        }
    }
}
