package cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean;

import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionContentsBean;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuPerformPromotion {
    public String content;
    public List<Integer> performanceIds;
    public String tag;

    public SkuPerformPromotion() {
    }

    public SkuPerformPromotion(PromotionContentsBean promotionContentsBean) {
        this.tag = promotionContentsBean.tag;
        this.content = promotionContentsBean.content;
    }
}
