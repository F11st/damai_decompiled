package com.taobao.weex.adapter;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IDrawableLoader {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface AnimatedTarget extends DrawableTarget {
        void setAnimatedDrawable(@Nullable Drawable drawable);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface DrawableTarget {
        void setDrawable(@Nullable Drawable drawable, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface StaticTarget extends DrawableTarget {
        @Override // com.taobao.weex.adapter.IDrawableLoader.DrawableTarget
        void setDrawable(@Nullable Drawable drawable, boolean z);
    }

    void setDrawable(String str, DrawableTarget drawableTarget, DrawableStrategy drawableStrategy);
}
