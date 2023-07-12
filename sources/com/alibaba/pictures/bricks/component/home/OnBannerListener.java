package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnBannerListener {
    void onBannerItemClick(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i);

    void onBannerViewExpose(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i);
}
