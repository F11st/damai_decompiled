package com.youku.gaiax.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.C9796v;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0002H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/common/utils/ScreenUtils;", "", "", "convertDpToPixel", "convertPixelsToDp", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/wt2;", "initScreen", "getScreenWidthPx", "getScreenHeightPx", "getScreenHeightDP", "getScreenWidthDP", "dp", "toPx", "px", "toDp", "", "TAG", "Ljava/lang/String;", "screenWidth", UTConstant.Args.UT_SUCCESS_F, "screenHeight", "Landroid/util/DisplayMetrics;", "dm", "Landroid/util/DisplayMetrics;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ScreenUtils {
    @NotNull
    private static final String TAG = "[GaiaX][Screen]";
    private static float screenHeight;
    private static float screenWidth;
    @NotNull
    public static final ScreenUtils INSTANCE = new ScreenUtils();
    @NotNull
    private static final DisplayMetrics dm = new DisplayMetrics();

    private ScreenUtils() {
    }

    private final float convertDpToPixel(float f) {
        return f * (Resources.getSystem().getDisplayMetrics().densityDpi / 160);
    }

    private final float convertPixelsToDp(float f) {
        return f / (Resources.getSystem().getDisplayMetrics().densityDpi / 160);
    }

    private final void initScreen(Context context) {
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
            Context context2 = app2 == null ? null : app2.topActivity();
            activity = context2 instanceof Activity ? (Activity) context2 : null;
        }
        if (!(screenHeight == 0.0f)) {
            if (!(screenWidth == 0.0f)) {
                IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
                if (!(features != null && features.isSupportResponsiveLayout(activity))) {
                    return;
                }
            }
        }
        if (activity != null) {
            screenWidth = activity.getWindow().getDecorView().getMeasuredWidth();
            float measuredHeight = activity.getWindow().getDecorView().getMeasuredHeight();
            screenHeight = measuredHeight;
            if (!(screenWidth == 0.0f)) {
                if (!(measuredHeight == 0.0f)) {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode()) {
                screenWidth = (float) Math.round((activity.getResources().getConfiguration().screenWidthDp * activity.getResources().getDisplayMetrics().density) + 0.5d);
                float round = (float) Math.round((activity.getResources().getConfiguration().screenHeightDp * activity.getResources().getDisplayMetrics().density) + 0.5d);
                screenHeight = round;
                if (!(screenWidth == 0.0f)) {
                    if (!(round == 0.0f)) {
                        return;
                    }
                }
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = dm;
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
            float f = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            screenWidth = f;
            float f2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            screenHeight = f2;
            if (!(f == 0.0f)) {
                if (!(f2 == 0.0f)) {
                    return;
                }
            }
        }
        IProxyApp app3 = GaiaXProxy.Companion.getInstance().getApp();
        Context applicationContext = app3 == null ? null : app3.applicationContext();
        if (applicationContext != null) {
            Object systemService = applicationContext.getSystemService(C9796v.ATTACH_MODE_WINDOW);
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null) {
                Display defaultDisplay2 = windowManager.getDefaultDisplay();
                if (defaultDisplay2 != null) {
                    com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay2, dm);
                }
                DisplayMetrics displayMetrics2 = dm;
                screenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2);
                screenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2);
            }
        }
    }

    static /* synthetic */ void initScreen$default(ScreenUtils screenUtils, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        screenUtils.initScreen(context);
    }

    public final float getScreenHeightDP(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initScreen(context);
        return convertPixelsToDp(screenHeight);
    }

    public final float getScreenHeightPx(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initScreen(context);
        return screenHeight;
    }

    public final float getScreenWidthDP(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initScreen(context);
        return convertPixelsToDp(screenWidth);
    }

    public final float getScreenWidthPx(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initScreen(context);
        return screenWidth;
    }

    public final float toDp(float f) {
        return convertPixelsToDp(f);
    }

    public final float toPx(float f) {
        return convertDpToPixel(f);
    }

    @Deprecated(message = "")
    public final float getScreenHeightDP() {
        initScreen$default(this, null, 1, null);
        return convertPixelsToDp(screenHeight);
    }

    @Deprecated(message = "")
    public final float getScreenHeightPx() {
        initScreen$default(this, null, 1, null);
        return screenHeight;
    }

    @Deprecated(message = "")
    public final float getScreenWidthDP() {
        initScreen$default(this, null, 1, null);
        return convertPixelsToDp(screenWidth);
    }

    @Deprecated(message = "")
    public final float getScreenWidthPx() {
        initScreen$default(this, null, 1, null);
        return screenWidth;
    }
}
