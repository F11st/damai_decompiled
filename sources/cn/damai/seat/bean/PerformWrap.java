package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PerformWrap {
    private static transient /* synthetic */ IpChange $ipChange;
    public final BasicInfoBean basic;
    public final PerformBean perform;
    public final PriceBean price;
    public final PromotionBean promotionBean;
    public final int type;

    public PerformWrap(int i, BasicInfoBean basicInfoBean, PerformBean performBean, PriceBean priceBean, PromotionBean promotionBean) {
        this.type = i;
        this.basic = basicInfoBean;
        this.perform = performBean;
        this.price = priceBean;
        this.promotionBean = promotionBean;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1412190764") ? ((Boolean) ipChange.ipc$dispatch("1412190764", new Object[]{this})).booleanValue() : (this.basic == null || this.perform == null) ? false : true;
    }
}
