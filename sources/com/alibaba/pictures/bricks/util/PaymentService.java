package com.alibaba.pictures.bricks.util;

import com.alibaba.pictures.bricks.orderconfirm.bean.CouponSubmitOrderBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface PaymentService {
    void startPay(@NotNull CouponSubmitOrderBean couponSubmitOrderBean);
}
