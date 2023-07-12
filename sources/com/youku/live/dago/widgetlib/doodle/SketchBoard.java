package com.youku.live.dago.widgetlib.doodle;

import android.graphics.drawable.Drawable;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface SketchBoard {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnDrawListener {
        void onDraw(int i, int i2, int i3, int i4);
    }

    @MainThread
    void clear();

    @MainThread
    void draw(@NonNull Drawable drawable, int i, int i2, int i3);

    @MainThread
    void draw(@NonNull Drawable drawable, int i, int i2, int i3, int i4, int i5);

    int getBoardHeight();

    int getBoardWidth();

    void setDrawLimit(int i);

    void setOnDrawListener(OnDrawListener onDrawListener);
}
