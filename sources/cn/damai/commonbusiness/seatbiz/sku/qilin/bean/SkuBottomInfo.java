package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuBottomInfo implements Serializable {
    private static final long serialVersionUID = 5291493204882023687L;
    public int followRelationTargetType;
    public double originalPrice;
    public long promotionAmount;
    public String selectPerformTip;
    public String selectTip;
    public boolean isShowOneLine = false;
    public boolean isShowMengceng = true;
    public double price = 0.0d;
    public double allPrice = 0.0d;
    public String priceTip = "优惠以订单确认页为准";
    public String btn = "确定";
    public String maxByNumTip = "每笔订单限购--张";
    public boolean isShowOnlyBtn = false;
    public int buyStatus = 1;
    public int maxTicketNum = 1;
    public boolean isShowBtn = true;
}
