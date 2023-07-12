package com.alibaba.pictures.bricks.component.coupon.banner;

import com.alibaba.pictures.bricks.bean.PicInfoBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponBannerContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @NotNull
        PicInfoBean getContent();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void renderImage(@NotNull PicInfoBean picInfoBean);
    }
}
