package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.TradeInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ClickedPerform {
    private static transient /* synthetic */ IpChange $ipChange;
    public final BasicInfoBean basic;
    public final PerformBean perform;
    public final PriceBean price;
    public final PromotionBean promotionBean;
    public final TradeInfo tradeInfo;
    public final int type;

    public ClickedPerform(int i, BasicInfoBean basicInfoBean, PerformBean performBean, @Nullable PriceBean priceBean, @Nullable PromotionBean promotionBean, TradeInfo tradeInfo) {
        this.type = i;
        this.basic = basicInfoBean;
        this.perform = performBean;
        this.price = priceBean;
        this.promotionBean = promotionBean;
        this.tradeInfo = tradeInfo;
    }

    public boolean appNewUlTron() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87594583")) {
            return ((Boolean) ipChange.ipc$dispatch("-87594583", new Object[]{this})).booleanValue();
        }
        TradeInfo tradeInfo = this.tradeInfo;
        if (tradeInfo != null) {
            return tradeInfo.anewUltron;
        }
        return false;
    }

    public boolean h5NewUlTron() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053169553")) {
            return ((Boolean) ipChange.ipc$dispatch("-2053169553", new Object[]{this})).booleanValue();
        }
        TradeInfo tradeInfo = this.tradeInfo;
        if (tradeInfo != null) {
            return tradeInfo.hnewUltron;
        }
        return false;
    }

    public boolean isHasPerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "286086507") ? ((Boolean) ipChange.ipc$dispatch("286086507", new Object[]{this})).booleanValue() : (this.basic == null || this.perform == null) ? false : true;
    }
}
