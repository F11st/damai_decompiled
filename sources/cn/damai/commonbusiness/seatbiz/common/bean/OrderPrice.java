package cn.damai.commonbusiness.seatbiz.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.cb2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class OrderPrice implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 326;
    public String consumeUserAssertTag;
    private boolean isLocal;
    private boolean isNetSuccess;
    public double localOriginalAmount;
    public double localRealAmount;
    public long promotionAmount;
    public String promotionAmountTag;
    public List<PromotionInfo> promotionDetails;
    public long realAmount;
    public boolean useSkuPrice;

    public OrderPrice() {
        this.isNetSuccess = true;
        this.useSkuPrice = true;
        this.isLocal = false;
    }

    public static OrderPrice makeLocal(double[] dArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645277060")) {
            return (OrderPrice) ipChange.ipc$dispatch("1645277060", new Object[]{dArr});
        }
        OrderPrice orderPrice = new OrderPrice();
        orderPrice.isLocal = true;
        orderPrice.localRealAmount = dArr[0];
        orderPrice.localOriginalAmount = dArr[1];
        return orderPrice;
    }

    public String getFormatOriginPriceText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069103310")) {
            return (String) ipChange.ipc$dispatch("2069103310", new Object[]{this});
        }
        if (isHasPromotion()) {
            return "¥" + wh2.c(this.localOriginalAmount);
        }
        return null;
    }

    public String getFormatRealAmountText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-92549541") ? (String) ipChange.ipc$dispatch("-92549541", new Object[]{this}) : wh2.c(this.realAmount / 100.0d);
    }

    public String getFormatRealPriceText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602243606")) {
            return (String) ipChange.ipc$dispatch("1602243606", new Object[]{this});
        }
        if (this.isLocal) {
            return wh2.c(this.localRealAmount);
        }
        if (this.isNetSuccess) {
            return wh2.c(this.realAmount / 100.0d);
        }
        return wh2.c(this.localRealAmount);
    }

    public String getPromotionAmountTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "481315936") ? (String) ipChange.ipc$dispatch("481315936", new Object[]{this}) : this.promotionAmountTag;
    }

    public boolean hasPromotionDetails() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1845671840") ? ((Boolean) ipChange.ipc$dispatch("1845671840", new Object[]{this})).booleanValue() : !cb2.d(this.promotionDetails);
    }

    public boolean isHasPromotion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-840483962") ? ((Boolean) ipChange.ipc$dispatch("-840483962", new Object[]{this})).booleanValue() : this.promotionAmount > 0;
    }

    public boolean isNetSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1694970007") ? ((Boolean) ipChange.ipc$dispatch("-1694970007", new Object[]{this})).booleanValue() : this.isNetSuccess;
    }

    public void prepareAfterNet(double[] dArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330910422")) {
            ipChange.ipc$dispatch("1330910422", new Object[]{this, dArr});
        } else if (dArr == null || dArr.length < 2) {
        } else {
            this.localOriginalAmount = dArr[1];
            if (isNetSuccess()) {
                return;
            }
            this.localRealAmount = dArr[0];
            this.promotionAmountTag = "优惠以订单确认页为准";
        }
    }

    public void setNetSuccess(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461308935")) {
            ipChange.ipc$dispatch("1461308935", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isNetSuccess = z;
        }
    }

    public OrderPrice(boolean z) {
        this.isNetSuccess = true;
        this.useSkuPrice = true;
        this.isLocal = false;
        this.isNetSuccess = z;
    }
}
