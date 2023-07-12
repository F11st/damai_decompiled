package com.taobao.weex.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.flat.widget.Widget;
import com.taobao.weex.ui.flat.widget.WidgetGroup;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.youku.arch.v3.data.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXViewUtils {
    public static final int DIMENSION_UNSET = -1;
    @Deprecated
    public static final int OPAQUE = -1;
    @Deprecated
    public static final int TRANSLUCENT = -3;
    @Deprecated
    public static final int TRANSPARENT = -2;
    private static final AtomicInteger a = new AtomicInteger(1);
    private static int b;
    private static int c;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Opacity {
    }

    private static boolean a(Canvas canvas) {
        return Build.VERSION.SDK_INT >= 18 || !canvas.isHardwareAccelerated();
    }

    private static boolean b(View view) {
        return Build.VERSION.SDK_INT != 24;
    }

    private static boolean c(@NonNull View view, @NonNull BorderDrawable borderDrawable) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt.getBackground() instanceof BorderDrawable) && ((BorderDrawable) childAt.getBackground()).hasImage() && Build.VERSION.SDK_INT < 21) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static void clipCanvasWithinBorderBox(View view, Canvas canvas) {
        if (a(canvas) && b(view)) {
            Drawable background = view.getBackground();
            if (background instanceof BorderDrawable) {
                BorderDrawable borderDrawable = (BorderDrawable) background;
                if (borderDrawable.isRounded() && c(view, borderDrawable)) {
                    canvas.clipPath(borderDrawable.getContentPath(new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight())));
                }
            }
        }
    }

    private static boolean d(@NonNull Widget widget, @NonNull BorderDrawable borderDrawable) {
        if (widget instanceof WidgetGroup) {
            for (Widget widget2 : ((WidgetGroup) widget).getChildren()) {
                if (widget2.getBackgroundAndBorder().hasImage() && Build.VERSION.SDK_INT < 21) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static int dip2px(float f) {
        float f2;
        try {
            f2 = WXEnvironment.getApplication().getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            WXLogUtils.e("[WXViewUtils] dip2px:", e);
            f2 = 2.0f;
        }
        float f3 = (f * f2) + 0.5f;
        if (f3 <= 0.0f || f3 >= 1.0f) {
            return (int) f3;
        }
        return 1;
    }

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT < 17) {
            do {
                atomicInteger = a;
                i = atomicInteger.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!atomicInteger.compareAndSet(i, i2));
            return i;
        }
        return View.generateViewId();
    }

    @Nullable
    public static BorderDrawable getBorderDrawable(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof BorderDrawable) {
            return (BorderDrawable) background;
        }
        if (background instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) background;
            if (layerDrawable.getNumberOfLayers() > 1) {
                Drawable drawable = layerDrawable.getDrawable(0);
                if (drawable instanceof BorderDrawable) {
                    return (BorderDrawable) drawable;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static int getFullScreenHeight(Context context) {
        WindowManager windowManager;
        if (context != null) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 17 && (windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)) != null && windowManager.getDefaultDisplay() != null) {
                Point point = new Point();
                Display.getRealSize(windowManager.getDefaultDisplay(), point);
                c = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            } else {
                c = DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
            }
            if (WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN) {
                int i = DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
                b = i;
                int i2 = c;
                if (i2 > i) {
                    i = i2;
                }
                c = i;
            }
        } else if (WXEnvironment.isApkDebugable()) {
            throw new WXRuntimeException("Error Context is null When getScreenHeight");
        }
        return c;
    }

    public static int getOpacityFromColor(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        return i2 == 0 ? -2 : -3;
    }

    @Deprecated
    public static float getRealPxByWidth(float f) {
        return getRealPxByWidth(f, FeatureFactory.PRIORITY_ABOVE_NORMAL);
    }

    @Deprecated
    public static float getRealPxByWidth2(float f) {
        return getRealPxByWidth2(f, FeatureFactory.PRIORITY_ABOVE_NORMAL);
    }

    @Deprecated
    public static float getRealSubPxByWidth(float f) {
        return getRealSubPxByWidth(f, FeatureFactory.PRIORITY_ABOVE_NORMAL);
    }

    public static float getScreenDensity(Context context) {
        if (context != null) {
            try {
                return context.getResources().getDisplayMetrics().density;
            } catch (Exception e) {
                WXLogUtils.e("getScreenDensityDpi exception:" + e.getMessage());
                return 3.0f;
            }
        }
        return 3.0f;
    }

    @Deprecated
    public static int getScreenHeight() {
        return getScreenHeight(WXEnvironment.sApplication);
    }

    @Deprecated
    public static int getScreenWidth() {
        return getScreenWidth(WXEnvironment.sApplication);
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return -1;
    }

    @Deprecated
    public static float getWebPxByWidth(float f) {
        return getWebPxByWidth(f, FeatureFactory.PRIORITY_ABOVE_NORMAL);
    }

    public static int getWeexHeight(String str) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            int weexHeight = y.getWeexHeight();
            return (weexHeight >= 0 || weexHeight == -2) ? weexHeight : getScreenHeight(WXEnvironment.sApplication);
        }
        return -3;
    }

    @Deprecated
    public static float getWeexPxByReal(float f) {
        return getWeexPxByReal(f, FeatureFactory.PRIORITY_ABOVE_NORMAL);
    }

    public static int getWeexWidth(String str) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            int weexWidth = y.getWeexWidth();
            return (weexWidth >= 0 || weexWidth == -2) ? weexWidth : getScreenWidth(WXEnvironment.sApplication);
        }
        return -3;
    }

    public static boolean isViewVisible(View view) {
        boolean z;
        if (view == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            z = view.isAttachedToWindow();
        } else {
            z = view.getWindowToken() != null;
        }
        if (z && view.getVisibility() == 0 && view.getAlpha() > 0.0f) {
            Drawable background = view.getBackground();
            if (background == null) {
                return true;
            }
            return i >= 19 ? background.getAlpha() > 0 : background instanceof ColorDrawable ? Color.alpha(((ColorDrawable) background).getColor()) > 0 : !(background instanceof BitmapDrawable) || ((BitmapDrawable) background).getPaint().getAlpha() > 0;
        }
        return false;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static boolean onScreenArea(View view) {
        int height;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            height = layoutParams.height;
        } else {
            height = view.getHeight();
        }
        return (iArr[1] > 0 && iArr[1] - getScreenHeight(WXEnvironment.sApplication) < 0) || (height + iArr[1] > 0 && iArr[1] <= 0);
    }

    public static void setBackGround(View view, Drawable drawable, WXComponent wXComponent) {
        WXErrorCode wXErrorCode;
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
            return;
        }
        try {
            view.setBackground(drawable);
        } catch (Exception unused) {
            if (wXComponent == null) {
                return;
            }
            WXExceptionUtils.commitCriticalExceptionRT(wXComponent.getInstanceId(), WXErrorCode.WX_RENDER_ERR_TEXTURE_SETBACKGROUND, wXComponent.getComponentType() + " setBackGround for android view", wXErrorCode.getErrorMsg() + ": TextureView doesn't support displaying a background drawable!", null);
        }
    }

    @Deprecated
    public static int setScreenWidth(int i) {
        b = i;
        return i;
    }

    public static void updateApplicationScreen(Context context) {
        if (context == null || WXEnvironment.sApplication == null) {
            return;
        }
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        android.util.DisplayMetrics displayMetrics2 = WXEnvironment.sApplication.getResources().getDisplayMetrics();
        displayMetrics2.heightPixels = DisplayMetrics.getheightPixels(displayMetrics);
        displayMetrics2.widthPixels = DisplayMetrics.getwidthPixels(displayMetrics);
        displayMetrics2.density = displayMetrics.density;
        displayMetrics2.densityDpi = displayMetrics.densityDpi;
        displayMetrics2.scaledDensity = displayMetrics.scaledDensity;
        displayMetrics2.xdpi = displayMetrics.xdpi;
    }

    public static float getRealPxByWidth(float f, int i) {
        if (Float.isNaN(f)) {
            return f;
        }
        float screenWidth = (f * getScreenWidth()) / i;
        double d = screenWidth;
        if (d <= 0.005d || screenWidth >= 1.0f) {
            return (float) Math.rint(d);
        }
        return 1.0f;
    }

    public static int getRealPxByWidth2(float f, int i) {
        float screenWidth = (f * getScreenWidth()) / i;
        if (screenWidth <= 0.005d || screenWidth >= 1.0f) {
            return ((int) screenWidth) - 1;
        }
        return 1;
    }

    public static float getRealSubPxByWidth(float f, int i) {
        if (Float.isNaN(f)) {
            return f;
        }
        float screenWidth = (f * getScreenWidth()) / i;
        if (screenWidth <= 0.005d || screenWidth >= 1.0f) {
            return screenWidth;
        }
        return 1.0f;
    }

    public static int getScreenHeight(String str) {
        return WXSDKManager.v().y(str).isFullScreenHeightEnabled() ? getFullScreenHeight(WXEnvironment.sApplication) : getScreenHeight(WXEnvironment.sApplication);
    }

    public static int getScreenWidth(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            b = DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
            if (WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN) {
                int i = DisplayMetrics.getheightPixels(resources.getDisplayMetrics());
                c = i;
                int i2 = b;
                if (i > i2) {
                    i = i2;
                }
                b = i;
            }
        } else if (WXEnvironment.isApkDebugable()) {
            throw new WXRuntimeException("Error Context is null When getScreenHeight");
        }
        return b;
    }

    public static float getWebPxByWidth(float f, int i) {
        double d = f;
        if (d >= -1.9999d || d <= -2.005d) {
            float screenWidth = (f * i) / getScreenWidth();
            if (screenWidth <= 0.005d || screenWidth >= 1.0f) {
                return screenWidth;
            }
            return 1.0f;
        }
        return Float.NaN;
    }

    public static float getWeexPxByReal(float f, int i) {
        return Float.isNaN(f) ? f : (f * i) / getScreenWidth();
    }

    public static int getScreenHeight(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            c = DisplayMetrics.getheightPixels(resources.getDisplayMetrics());
            if (WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN) {
                int i = DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
                b = i;
                int i2 = c;
                if (i2 > i) {
                    i = i2;
                }
                c = i;
            }
        } else if (WXEnvironment.isApkDebugable()) {
            throw new WXRuntimeException("Error Context is null When getScreenHeight");
        }
        return c;
    }

    public static void clipCanvasWithinBorderBox(Widget widget, Canvas canvas) {
        BorderDrawable backgroundAndBorder;
        if (a(canvas) && b(null) && (backgroundAndBorder = widget.getBackgroundAndBorder()) != null) {
            if (backgroundAndBorder.isRounded() && d(widget, backgroundAndBorder)) {
                canvas.clipPath(backgroundAndBorder.getContentPath(new RectF(0.0f, 0.0f, Rect.width(widget.getBorderBox()), Rect.height(widget.getBorderBox()))));
            } else {
                canvas.clipRect(widget.getBorderBox());
            }
        }
    }
}
