package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponData extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private DiscountContainer data;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class Coupon implements Serializable {
        public String cancelBtnText;
        public String cancelConfirmMsg;
        public boolean cancelable;
        public String decreaseMoneyNum;
        public String decreaseMoneyTag;
        public String desc;
        public String effectiveEndTime;
        public String effectiveStartTime;
        public String effectiveTimeText;
        public String id;
        public String itemChannelUsableStatus;
        public String name;
        public String oldDmCouponId;
        public String overAmountText;
        public String sourceTag;
        public String status;
        public String subCouponActId;
        public String tag;
        public String umpCouponTplId;
        public String unLimitItem;
        public String useCouponUrlH5;
        public String useCouponUrlMobile;
        public String usedTimeStr;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class DiscountContainer {
        public List<Coupon> coupons;
        public long totalCount;
    }

    public void setData(DiscountContainer discountContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1613031396")) {
            ipChange.ipc$dispatch("1613031396", new Object[]{this, discountContainer});
        } else {
            this.data = discountContainer;
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public DiscountContainer getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1886066598") ? (DiscountContainer) ipChange.ipc$dispatch("1886066598", new Object[]{this}) : this.data;
    }
}
