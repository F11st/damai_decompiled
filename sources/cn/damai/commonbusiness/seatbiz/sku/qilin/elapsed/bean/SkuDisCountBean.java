package cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean;

import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PricePromotionBean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuDisCountBean {
    public String priceAfterPromotion;
    public String promotionDesc;
    public String tag;

    public SkuDisCountBean(PricePromotionBean pricePromotionBean) {
        if (pricePromotionBean != null) {
            this.priceAfterPromotion = pricePromotionBean.priceAfterPromotion;
            this.promotionDesc = pricePromotionBean.promotionDesc;
            this.tag = pricePromotionBean.tag;
        }
    }

    public SkuDisCountBean() {
    }
}
