package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuItem;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4648665742827969616L;
    public ActionControlBean actionControl;
    public List<HolidayBean> holidayCalendar;
    public BusinessInfo itemAdditionalInfo;
    public BasicInfoBean itemBasicInfo;
    public ItemBuyBtnBean itemBuyBtn;
    @Deprecated
    public PromotionBean mktPromotion;
    public PerformBean perform;
    public CalendarBean performCalendar;
    public PromotionBean promotionDetail;
    public DialogBean skuRelatedText;
    public TradeInfo tradeinfo;
    public WishHeatBean wishHeat;
    public String x_dataId;
    public String x_dataType;
    public String x_errCode;
    public String x_errMsg;
    public boolean x_mtopFail = false;

    public static SkuBean error(String str, String str2, SkuRequest skuRequest) {
        SkuItem skuItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124069703")) {
            return (SkuBean) ipChange.ipc$dispatch("-124069703", new Object[]{str, str2, skuRequest});
        }
        SkuBean skuBean = new SkuBean();
        skuBean.x_mtopFail = true;
        skuBean.x_errCode = str;
        skuBean.x_errMsg = str2;
        if (skuRequest != null && (skuItem = skuRequest.exParams) != null) {
            skuBean.x_dataId = skuItem.dataId;
            skuBean.x_dataType = skuItem.dataType;
        }
        return skuBean;
    }
}
