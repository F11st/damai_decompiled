package com.alimm.xadsdk.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.youku.arch.v3.data.Constants;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DeviceUtils {
    private static final String TAG = "DeviceUtils";

    public static Point getAppWindowSize(@NonNull Context context) {
        Point point = new Point();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            } else {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
                point.x = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                point.y = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            }
        } catch (Exception e) {
            LogUtils.d("DeviceUtils", "getAppWindowSize size failed.", e);
        }
        if (LogUtils.DEBUG) {
            LogUtils.d("DeviceUtils", "getAppWindowSize: appWindowSize = " + point);
        }
        return point;
    }

    public static int getNavigationBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
    }

    public static int getStatusBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public static boolean isHuaweiDevice() {
        String lowerCase = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND().toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains("huawei");
    }

    public static boolean isNavigationBarShow(@NonNull Context context) {
        if (isXiaomiDevice()) {
            try {
                return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0;
            } catch (Throwable unused) {
                return false;
            }
        } else if (isHuaweiDevice()) {
            int i = Build.VERSION.SDK_INT;
            ContentResolver contentResolver = context.getContentResolver();
            return (i < 21 ? Settings.System.getInt(contentResolver, "navigationbar_is_min", 0) : Settings.Global.getInt(contentResolver, "navigationbar_is_min", 0)) == 0;
        } else if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
            if (LogUtils.DEBUG) {
                LogUtils.d("DeviceUtils", "isNavigationBarShow: sY = " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) + ", rY = " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
            }
            return isSamsungDevice() ? Math.abs(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) >= getNavigationBarHeight(context) : com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) != com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        }
    }

    public static boolean isSamsungDevice() {
        String lowerCase = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND().toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains("samsung");
    }

    public static boolean isXiaomiDevice() {
        String lowerCase = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND().toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains("xiaomi");
    }
}
