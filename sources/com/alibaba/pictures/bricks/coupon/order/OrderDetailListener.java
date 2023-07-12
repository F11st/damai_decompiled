package com.alibaba.pictures.bricks.coupon.order;

import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OrderDetailListener {
    void cancelOrder(@NotNull OrderDetail orderDetail);

    void gotoPay(@NotNull OrderDetail orderDetail);
}
