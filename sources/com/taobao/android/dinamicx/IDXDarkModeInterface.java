package com.taobao.android.dinamicx;

import android.content.Context;
import android.view.View;
import androidx.annotation.ColorInt;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXDarkModeInterface {
    void disableForceDark(View view);

    boolean isDark(Context context);

    @ColorInt
    int switchDarkModeColor(int i, @ColorInt int i2);
}
