package cn.damai.commonbusiness.seatbiz.promotion.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PromotionGroupBean implements Serializable {
    public static final int PERFORM_TYPE = 1;
    public int promotionGroupType;
    public String promotionGroupTypeDesc;
    public List<GroupItemBean> promotionList;
}
