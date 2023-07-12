package com.alibaba.pictures.bricks.coupon.view;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnFagActionListener {
    void onFagAllClick(@NotNull OrderDetail orderDetail);

    void onItemClick(@NotNull View view, @NotNull String str, @NotNull OrderDetail orderDetail, int i);

    void onItemExpose(@NotNull View view, @NotNull String str, @Nullable OrderDetail orderDetail, int i);
}
