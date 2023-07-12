package com.alibaba.pictures.bricks.coupon.order.bean;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public enum ButtonStatus {
    NULL(null),
    GONE("0"),
    CANCEL_PAY("1"),
    USE_UN_CLICK("2"),
    USE_CLICK("3"),
    COMMENT("4"),
    SEE_COMMENT("5");
    
    @Nullable
    private final String status;

    ButtonStatus(String str) {
        this.status = str;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }
}
