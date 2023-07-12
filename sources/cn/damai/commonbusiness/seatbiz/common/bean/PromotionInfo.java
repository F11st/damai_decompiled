package cn.damai.commonbusiness.seatbiz.common.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PromotionInfo implements Serializable {
    private static final long serialVersionUID = 3456;
    public List<String> priceList;
    public String promotionAmount;
    public String promotionDesc;
    public String tag;

    public PromotionInfo() {
    }

    public PromotionInfo(String str, List<String> list, String str2, String str3) {
        this.promotionAmount = str;
        this.priceList = list;
        this.promotionDesc = str2;
        this.tag = str3;
    }
}
