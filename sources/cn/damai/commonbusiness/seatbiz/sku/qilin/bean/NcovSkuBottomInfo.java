package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NcovSkuBottomInfo implements Serializable {
    private static final long serialVersionUID = 8225621041414473276L;
    public String buyTip;
    public String discountTip;
    public int followRelationTargetType;
    public double allPrice = 0.0d;
    public double promotionAmount = 0.0d;
    public int buyStatus = 0;
    public boolean isCanClickable = false;
    public int pageType = 1;
}
