package com.alibaba.pictures.bricks.orderconfirm.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CouponOrderRenderBean implements Serializable {
    private static final long serialVersionUID = -1;
    public BaseRequestData baseRequestData;
    public List<OrderCreateBean> dataList;
    public PriceInfo priceInfo;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class BaseRequestData implements Serializable {
        public int buyAmount;
        public String itemId;
        public String itemType;
        public String skuId;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class PriceDetailBean implements Serializable {
        private static final long serialVersionUID = -1;
        public String amountTip;
        public String numTip;
        public String price;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class PriceInfo implements Serializable {
        private static final long serialVersionUID = -1;
        public List<PriceDetailBean> priceDetailList;
        public String totalPrice;
        public String totalPriceTxt;
    }
}
