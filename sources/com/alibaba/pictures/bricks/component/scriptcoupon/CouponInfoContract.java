package com.alibaba.pictures.bricks.component.scriptcoupon;

import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface CouponInfoContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @NotNull
        CouponInfoBean getCouponInfoBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        @NotNull
        CouponInfoViewHolder getViewHolder();
    }
}
