package com.alibaba.pictures.bricks.view;

import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface BannerViewBinder {
    @NotNull
    View getView(int i, int i2, @Nullable Object obj, @Nullable View view, @NotNull ViewGroup viewGroup);

    int getViewType(@Nullable Object obj);
}
