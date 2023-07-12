package cn.damai.category.discountticket.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponListRes {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CouponActivityBean> couponActivities;

    public boolean hasCoupons() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1594889399") ? ((Boolean) ipChange.ipc$dispatch("1594889399", new Object[]{this})).booleanValue() : wh2.e(this.couponActivities) > 0;
    }
}
