package cn.damai.commonbusiness.seatbiz.promotion.bean;

import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionContentsBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PromotionDataBean implements Serializable {
    private static final long serialVersionUID = 5242775696772718L;
    public CouponListDataBean couponListDataBean;
    public long itemId;
    public String pageSource;
    @Deprecated
    public List<PromotionContentsBean> promotionContentsBeanList;
    public List<PromotionGroupBean> promotionContentsBeanListNew;
    public String promotionRemark;

    public PromotionDataBean() {
    }

    public PromotionDataBean(String str, long j, List<PromotionGroupBean> list, String str2, CouponListDataBean couponListDataBean, String str3) {
        this.pageSource = str;
        this.itemId = j;
        this.promotionContentsBeanListNew = list;
        this.promotionRemark = str2;
        this.couponListDataBean = couponListDataBean;
    }

    public PromotionDataBean(String str, long j, List<PromotionContentsBean> list, String str2, CouponListDataBean couponListDataBean) {
        this.pageSource = str;
        this.itemId = j;
        this.promotionContentsBeanList = list;
        this.promotionRemark = str2;
        this.couponListDataBean = couponListDataBean;
    }
}
