package com.alibaba.pictures.bricks.orderconfirm.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CouponSubmitOrderBean implements Serializable {
    public static final String PAY_TYPE_ALIPAY = "ALIPAY_QMPAY";
    public static final String PAY_TYPE_WECHAT = "WECHAT";
    private static final long serialVersionUID = -1;
    public String orderId;
    public String payTypeCode;
    public String payUrl;
}
