package com.youku.live.arch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ContextUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LANDSCAPE = 1;
    private static final int PORTRAIT = 0;
    private static volatile boolean mHasCheckAllScreen = false;
    private static volatile boolean mIsAllScreenDevice = false;
    @NonNull
    private static volatile Point[] mRealSizes = new Point[2];
    private static int sRealScreenHeight = -1;
    private static int sScreenHeight = -1;
    private static int sScreenWidth = -1;

    public static final int dip2px(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443982750")) {
            return ((Integer) ipChange.ipc$dispatch("1443982750", new Object[]{context, Integer.valueOf(i)})).intValue();
        }
        if (context == null) {
            return 0;
        }
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Context getContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-134363270")) {
            return (Context) ipChange.ipc$dispatch("-134363270", new Object[]{context});
        }
        if (context instanceof ContextThemeWrapper) {
            return ((ContextThemeWrapper) context).getBaseContext();
        }
        boolean z = context instanceof Activity;
        return context;
    }

    public static int getFullActivityHeight(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1907982987")) {
            return ((Integer) ipChange.ipc$dispatch("1907982987", new Object[]{context})).intValue();
        }
        if (!isAllScreenDevice(context)) {
            return getScreenHeight(context);
        }
        return getScreenRealHeight(context);
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744477881")) {
            return ((Integer) ipChange.ipc$dispatch("744477881", new Object[]{context})).intValue();
        }
        if (context == null) {
            return 0;
        }
        if (sScreenHeight == -1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
            sScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        }
        return sScreenHeight;
    }

    public static int getScreenRealHeight(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252326665")) {
            return ((Integer) ipChange.ipc$dispatch("-252326665", new Object[]{context})).intValue();
        }
        if (Build.VERSION.SDK_INT < 17) {
            return getScreenHeight(context);
        }
        if (context == null) {
            return 0;
        }
        if (sRealScreenHeight == -1) {
            char c = context.getResources().getConfiguration().orientation != 1 ? (char) 1 : (char) 0;
            if (mRealSizes[c] == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
                if (windowManager == null) {
                    return getScreenHeight(context);
                }
                android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                Display.getRealSize(defaultDisplay, point);
                mRealSizes[c] = point;
                sRealScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(mRealSizes[c]);
            }
        }
        return sRealScreenHeight;
    }

    public static final int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198468864")) {
            return ((Integer) ipChange.ipc$dispatch("-198468864", new Object[]{context})).intValue();
        }
        if (context == null) {
            return 0;
        }
        if (sScreenWidth == -1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
            sScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        }
        return sScreenWidth;
    }

    public static int getStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1172682610")) {
            return ((Integer) ipChange.ipc$dispatch("-1172682610", new Object[]{context})).intValue();
        }
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public static boolean isAllScreenDevice(Context context) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1704753850")) {
            return ((Boolean) ipChange.ipc$dispatch("1704753850", new Object[]{context})).booleanValue();
        }
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        if (context != null && Build.VERSION.SDK_INT >= 21) {
            WindowManager windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
            if (windowManager != null) {
                android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                Display.getRealSize(defaultDisplay, point);
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                if (xVar < yVar) {
                    f2 = xVar;
                    f = yVar;
                } else {
                    float f3 = yVar;
                    f = xVar;
                    f2 = f3;
                }
                if (f / f2 >= 1.97f) {
                    mIsAllScreenDevice = true;
                }
            }
            return mIsAllScreenDevice;
        }
        return false;
    }
}
