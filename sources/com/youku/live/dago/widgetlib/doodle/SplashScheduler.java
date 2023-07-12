package com.youku.live.dago.widgetlib.doodle;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.live.dago.widgetlib.doodle.RobotPainter;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface SplashScheduler<I, C> {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class IconItem {
        public Drawable icon;
        public int iconIdentity;
        public String stringId;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnSplashUpdateListener {
        void onPaintingEnd();

        void onPaintingStart();

        void onSplashUpdate(float f, float f2, int i, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SplashItem {
        public IconItem iconItem;
        public float x;
        public float y;
    }

    void addOnSplashUpdateListener(@NonNull OnSplashUpdateListener onSplashUpdateListener);

    void enableTouch(boolean z);

    @NonNull
    View getContentView();

    @Nullable
    IconItem getIconItem(int i);

    @NonNull
    SketchBoard getSketchBoard();

    boolean isTouchEnabled();

    void removeOnSplashUpdateListener(@NonNull OnSplashUpdateListener onSplashUpdateListener);

    void render(@NonNull I i);

    void render(@NonNull I i, long j);

    void selectIcon(int i);

    void setDrawLimit(int i);

    void setIcons(@NonNull IconItem... iconItemArr);

    void setParser(@NonNull SplashItemParser<I, C> splashItemParser);

    void setRenderScaleType(RobotPainter.ScaleType scaleType);

    void switchTouchable();

    void updateCanvasSize(@NonNull C c);
}
