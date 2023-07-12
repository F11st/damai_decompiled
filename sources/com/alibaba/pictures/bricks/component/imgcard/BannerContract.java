package com.alibaba.pictures.bricks.component.imgcard;

import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BannerContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @NotNull
        BannerBean getContent();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void renderImage(@NotNull BannerBean bannerBean);
    }
}
