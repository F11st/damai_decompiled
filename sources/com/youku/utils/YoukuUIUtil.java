package com.youku.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.taobao.atlas.runtime.RuntimeVariables;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.palette.graphics.Palette;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.baseproject.basecard.widget.CustomView;
import com.baseproject.basecard.widget.WithCornerMaskImageView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import com.youku.widget.CornerMarkDrawable;
import com.youku.widget.TouchDelegateGroup;
import java.lang.reflect.Method;
import tb.C9796v;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuUIUtil {
    private static int DEFAULT_ORIENTATION = 0;
    public static final int TYPEV_VIP_FOUR = 4;
    public static final int TYPE_ACTIVITY_TWO = 2;
    public static final int TYPE_OPERATION_THREE = 3;
    public static final int TYPE_RECOMMEND_SIX = 6;
    private static int s_SystemUiVisibilityOrigin = -1;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface onChannelPageScrollListener {
        void showHomeTopView(boolean z);

        void startHomeAnim(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface onGalleryPaletteListener {
        void onItemSwitch(int i, int i2, int i3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface onPaletteGeneratedListener {
        void onGenerated(int i);
    }

    public static void clearCornerMask(WithCornerMaskImageView withCornerMaskImageView) {
        withCornerMaskImageView.setMask(null);
    }

    public static int getDeviceDefaultOrientation(Context context) {
        if (DEFAULT_ORIENTATION == 0) {
            Configuration configuration = context.getResources().getConfiguration();
            int rotation = ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRotation();
            if (((rotation != 0 && rotation != 2) || configuration.orientation != 2) && ((rotation != 1 && rotation != 3) || configuration.orientation != 1)) {
                DEFAULT_ORIENTATION = 1;
            } else {
                DEFAULT_ORIENTATION = 2;
            }
        }
        return DEFAULT_ORIENTATION;
    }

    public static int getHomeTopHeaderHeight(Context context, boolean z) {
        if (context == null) {
            context = RuntimeVariables.androidApplication;
        }
        if (context != null) {
            if (isTransparentStatusBar()) {
                if (z) {
                    return context.getResources().getDimensionPixelOffset(R$dimen.recycler_view_header_height_skin_with_status_bar);
                }
                return context.getResources().getDimensionPixelOffset(R$dimen.recycler_view_header_height_with_status_bar);
            } else if (z) {
                return context.getResources().getDimensionPixelOffset(R$dimen.recycler_view_header_height_skin_no_status_bar);
            } else {
                return context.getResources().getDimensionPixelOffset(R$dimen.recycler_view_header_height_no_status_bar);
            }
        }
        return 76;
    }

    public static void getPaletteColor(BitmapDrawable bitmapDrawable, final onPaletteGeneratedListener onpalettegeneratedlistener) {
        Bitmap createBitmap;
        if (bitmapDrawable == null || bitmapDrawable.getBitmap() == null) {
            return;
        }
        Bitmap bitmap = bitmapDrawable.getBitmap();
        int min = Math.min(bitmap.getHeight(), 100);
        if (min > 0 && (createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), min)) != null) {
            try {
                Palette.from(createBitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.youku.utils.YoukuUIUtil.4
                    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                    public void onGenerated(Palette palette) {
                        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
                        if (mutedSwatch != null) {
                            int rgb = mutedSwatch.getRgb();
                            onPaletteGeneratedListener onpalettegeneratedlistener2 = onPaletteGeneratedListener.this;
                            if (onpalettegeneratedlistener2 != null) {
                                onpalettegeneratedlistener2.onGenerated(rgb);
                            }
                        }
                    }
                });
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static String getXiaomiVersion() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.miui.ui.version.name");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isActivityContextValid(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isRestricted() || activity.getWindow() == null) ? false : true;
    }

    public static boolean isMiPad() {
        String model = Build.getMODEL();
        return !TextUtils.isEmpty(model) && model.contains("MI PAD");
    }

    public static boolean isPad(Context context) {
        if (context != null) {
            return 2 == getDeviceDefaultOrientation(context) || isMiPad();
        }
        return false;
    }

    public static boolean isTransparentStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (!isXiaomiDevice()) {
                return true;
            }
            String xiaomiVersion = getXiaomiVersion();
            if (TextUtils.isEmpty(xiaomiVersion)) {
                return false;
            }
            try {
                int intValue = Integer.valueOf(xiaomiVersion.replace("V", "")).intValue();
                if (isXiaomiDevice() && intValue >= 9) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static boolean isXiaomiDevice() {
        return "Xiaomi".equals(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
    }

    public static void setCornerMark(Context context, int i, String str, WithCornerMaskImageView withCornerMaskImageView) {
        setCornerMark(context, i, str, withCornerMaskImageView, null);
    }

    public static void setCornerMarkData(Context context, int i, String str, WithCornerMaskImageView withCornerMaskImageView) {
        setCornerMarkData(context, i, str, withCornerMaskImageView, null);
    }

    public static void setStatusBarTextColorBlack(Activity activity, boolean z) {
        if (isTransparentStatusBar()) {
            if (s_SystemUiVisibilityOrigin == -1) {
                s_SystemUiVisibilityOrigin = activity.getWindow().getDecorView().getSystemUiVisibility();
            }
            Window window = activity.getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
                if (z) {
                    window.getDecorView().setSystemUiVisibility(9216);
                } else if (s_SystemUiVisibilityOrigin != -1) {
                    window.getDecorView().setSystemUiVisibility(s_SystemUiVisibilityOrigin);
                }
            }
        }
    }

    public static void setViewTouchDelegate(final TouchDelegateGroup touchDelegateGroup, final View view, final View view2, final int i, final int i2, final int i3, final int i4) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.utils.YoukuUIUtil.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                @SuppressLint({"NewApi"})
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    View view3 = view2;
                    view3.getHitRect(rect);
                    rect.top -= i;
                    rect.bottom += i2;
                    rect.left -= i3;
                    rect.right += i4;
                    TouchDelegate touchDelegate = new TouchDelegate(rect, view3);
                    if (View.class.isInstance(view)) {
                        touchDelegateGroup.addTouchDelegate(touchDelegate);
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    private static void setXiaomiStatusBarDarkMode(boolean z, Activity activity) {
        if (isTransparentStatusBar()) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static double viewSize(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        int i = width * height;
        if (!view.getGlobalVisibleRect(rect) || i <= 0) {
            return 0.0d;
        }
        return ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect)) * 1.0d) / i;
    }

    public static void clearCornerMask(WithCornerMaskImageView withCornerMaskImageView, View view) {
        ((CustomView) view).setMask(null);
    }

    public static void setCornerMark(Context context, int i, String str, WithCornerMaskImageView withCornerMaskImageView, View view) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.corner_mask_text_size);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.corner_mask_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.corner_mask_height);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.home_personal_movie_12px);
        int i2 = R$drawable.corner_mark_red;
        if (i == 4) {
            i2 = R$drawable.corner_mark_yellow;
        } else if (i == 6) {
            i2 = R$drawable.corner_mark_black;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, i2));
        CornerMarkDrawable cornerMarkDrawable = new CornerMarkDrawable(new RectShape());
        cornerMarkDrawable.setText(str);
        cornerMarkDrawable.setTextSize(dimensionPixelSize);
        cornerMarkDrawable.getPaint().setAlpha(1);
        cornerMarkDrawable.setTextColor(Color.parseColor("#ffffff"));
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(dimensionPixelSize);
        int measureText = ((int) textPaint.measureText(str)) + (dimensionPixelOffset * 2);
        cornerMarkDrawable.setIntrinsicHeight(dimensionPixelSize2);
        cornerMarkDrawable.setIntrinsicWidth(measureText);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, cornerMarkDrawable});
        int right = withCornerMaskImageView.getRight() - dimensionPixelSize3;
        layerDrawable.setBounds(right - measureText, dimensionPixelSize3, right, dimensionPixelSize2 + dimensionPixelSize3);
        if (view == null) {
            withCornerMaskImageView.setMask(layerDrawable);
        } else {
            ((CustomView) view).setMask(layerDrawable);
        }
    }

    public static void setCornerMarkData(final Context context, final int i, final String str, final WithCornerMaskImageView withCornerMaskImageView, final View view) {
        if (view == null) {
            if (withCornerMaskImageView.getHeight() > 0) {
                setCornerMark(context, i, str, withCornerMaskImageView);
            } else {
                withCornerMaskImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.utils.YoukuUIUtil.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        YoukuUIUtil.setCornerMark(context, i, str, withCornerMaskImageView);
                        ViewTreeObserver viewTreeObserver = withCornerMaskImageView.getViewTreeObserver();
                        if (Build.VERSION.SDK_INT >= 16) {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        } else {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        }
                    }
                });
            }
        } else if (view.getHeight() > 0) {
            setCornerMark(context, i, str, withCornerMaskImageView, view);
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.utils.YoukuUIUtil.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    YoukuUIUtil.setCornerMark(context, i, str, withCornerMaskImageView, view);
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    public static void setViewTouchDelegate(TouchDelegateGroup touchDelegateGroup, View view, View view2) {
        setViewTouchDelegate(touchDelegateGroup, view, view2, 100, 100, 100, 100);
    }

    public static void setViewTouchDelegate(View view, View view2, int i, int i2, int i3, int i4) {
        if (view != null) {
            TouchDelegate touchDelegate = view.getTouchDelegate();
            if (touchDelegate == null || !(touchDelegate instanceof TouchDelegateGroup)) {
                touchDelegate = new TouchDelegateGroup(view);
                view.setTouchDelegate(touchDelegate);
            }
            setViewTouchDelegate((TouchDelegateGroup) touchDelegate, view, view2, i, i2, i3, i4);
        }
    }

    public static void setViewTouchDelegate(View view, View view2) {
        if (view != null) {
            TouchDelegate touchDelegate = view.getTouchDelegate();
            if (touchDelegate == null || !(touchDelegate instanceof TouchDelegateGroup)) {
                touchDelegate = new TouchDelegateGroup(view);
                view.setTouchDelegate(touchDelegate);
            }
            setViewTouchDelegate((TouchDelegateGroup) touchDelegate, view, view2);
        }
    }

    public static void setViewTouchDelegate(View view) {
        setViewTouchDelegate((View) view.getParent(), view);
    }

    public static void setViewTouchDelegate(View view, int i, int i2, int i3, int i4) {
        setViewTouchDelegate((View) view.getParent(), view, i, i2, i3, i4);
    }

    public static void setViewTouchDelegate(View view, int i) {
        setViewTouchDelegate((View) view.getParent(), view, i, i, i, i);
    }
}
