package com.alibaba.pictures.bricks.bean;

import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponRuleBean {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OrderDetail orderInfo;
    @Nullable
    private List<CouponServiceRuleBean> ruleList;

    public CouponRuleBean(@Nullable List<CouponServiceRuleBean> list, @Nullable OrderDetail orderDetail) {
        this.ruleList = list;
        this.orderInfo = orderDetail;
    }

    @Nullable
    public final OrderDetail getOrderInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-390918257") ? (OrderDetail) ipChange.ipc$dispatch("-390918257", new Object[]{this}) : this.orderInfo;
    }

    @Nullable
    public final List<CouponServiceRuleBean> getRuleList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1332847497") ? (List) ipChange.ipc$dispatch("-1332847497", new Object[]{this}) : this.ruleList;
    }

    public final void setOrderInfo(@Nullable OrderDetail orderDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527060619")) {
            ipChange.ipc$dispatch("1527060619", new Object[]{this, orderDetail});
        } else {
            this.orderInfo = orderDetail;
        }
    }

    public final void setRuleList(@Nullable List<CouponServiceRuleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1141855285")) {
            ipChange.ipc$dispatch("1141855285", new Object[]{this, list});
        } else {
            this.ruleList = list;
        }
    }
}
