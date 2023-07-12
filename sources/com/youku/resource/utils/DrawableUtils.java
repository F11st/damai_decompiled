package com.youku.resource.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DrawableUtils {
    private static final String TAG = "DrawableUtil";

    public static Drawable getColorDrawable(Drawable drawable, int i) {
        if (drawable == null) {
            return drawable;
        }
        Drawable mutate = drawable.mutate();
        mutate.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return mutate;
    }

    public static Drawable getTintDrawable(Context context, @DrawableRes int i, @ColorRes int i2) {
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        ColorStateList colorStateList = ContextCompat.getColorStateList(context, i2);
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrap, colorStateList);
        return wrap;
    }
}
