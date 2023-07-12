package cn.damai.category.discountticket.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponApplyRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String calcNextApplicable = "true";
    public String couponActSpreadId;

    public CouponApplyRequest(String str) {
        this.couponActSpreadId = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "306020287") ? (String) ipChange.ipc$dispatch("306020287", new Object[]{this}) : "mtop.damai.wireless.mkt.coupon.applyCoupon4User";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733842510")) {
            return ((Boolean) ipChange.ipc$dispatch("1733842510", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "990233418")) {
            return ((Boolean) ipChange.ipc$dispatch("990233418", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1821210286") ? (String) ipChange.ipc$dispatch("-1821210286", new Object[]{this}) : "1.0";
    }
}
