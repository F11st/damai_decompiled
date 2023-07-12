package com.taobao.weex.ui.flat.widget;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.taobao.weex.ui.view.border.BorderDrawable;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public interface Widget {
    public static final String TAG = "Widget";

    void draw(@NonNull Canvas canvas);

    @Nullable
    BorderDrawable getBackgroundAndBorder();

    @NonNull
    Rect getBorderBox();

    @NonNull
    Point getLocInFlatContainer();

    void onDraw(@NonNull Canvas canvas);

    void setBackgroundAndBorder(@NonNull BorderDrawable borderDrawable);

    void setContentBox(int i, int i2, int i3, int i4);

    void setLayout(int i, int i2, int i3, int i4, int i5, int i6, Point point);
}
