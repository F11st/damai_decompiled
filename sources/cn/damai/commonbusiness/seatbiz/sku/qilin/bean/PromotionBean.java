package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionGroupBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PromotionBean implements Serializable {
    private static final long serialVersionUID = 3090914159163785646L;
    @Deprecated
    public List<PromotionContentsBean> contexts;
    public List<PromotionGroupBean> promotionGroupList;
    public String promotionRemark;
    public String skuPromotionRelations;
}
