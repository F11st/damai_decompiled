package com.alibaba.pictures.bricks.bean;

import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FaqBean {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<String> faqList;
    @Nullable
    private OrderDetail orderBean;

    public FaqBean(@Nullable ArrayList<String> arrayList, @Nullable OrderDetail orderDetail) {
        this.faqList = arrayList;
        this.orderBean = orderDetail;
    }

    @Nullable
    public final ArrayList<String> getFaqList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1927983708") ? (ArrayList) ipChange.ipc$dispatch("1927983708", new Object[]{this}) : this.faqList;
    }

    @Nullable
    public final OrderDetail getOrderBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-767166685") ? (OrderDetail) ipChange.ipc$dispatch("-767166685", new Object[]{this}) : this.orderBean;
    }

    public final void setFaqList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251409188")) {
            ipChange.ipc$dispatch("-251409188", new Object[]{this, arrayList});
        } else {
            this.faqList = arrayList;
        }
    }

    public final void setOrderBean(@Nullable OrderDetail orderDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546706057")) {
            ipChange.ipc$dispatch("-1546706057", new Object[]{this, orderDetail});
        } else {
            this.orderBean = orderDetail;
        }
    }
}
