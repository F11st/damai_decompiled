package com.youku.live.dago.widgetlib.ailpbaselib.image;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class DagoBaseImageLoader {
    public abstract void load(Context context, String str, ImageLoadListener imageLoadListener);

    public abstract void load(Context context, String str, ImageLoadListener imageLoadListener, int i);

    public abstract void loadCircle(Context context, String str, ImageLoadListener imageLoadListener);

    public abstract void loadCircle(Context context, String str, ImageLoadListener imageLoadListener, int i);

    public abstract void show(Context context, String str, ImageView imageView, int i, int i2);

    public abstract void showCircle(Context context, String str, ImageView imageView);

    public abstract void showCircle(Context context, String str, ImageView imageView, @DrawableRes int i);

    public abstract void showDefault(Context context, String str, ImageView imageView);

    public abstract void showGif(Context context, String str, ImageView imageView);

    public abstract void showRoundCorner(Context context, String str, int i, ImageView imageView);
}
