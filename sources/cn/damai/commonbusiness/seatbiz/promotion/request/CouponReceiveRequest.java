package cn.damai.commonbusiness.seatbiz.promotion.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponReceiveRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String asac;
    public String buyerId;
    public String calcNextApplicable;
    public String couponActSpreadId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1330962606") ? (String) ipChange.ipc$dispatch("-1330962606", new Object[]{this}) : "mtop.damai.wireless.mkt.coupon.applyCoupon4User";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1748658376") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1748658376", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.GET;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490033893")) {
            return ((Boolean) ipChange.ipc$dispatch("-1490033893", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483569449")) {
            return ((Boolean) ipChange.ipc$dispatch("-483569449", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "836774117") ? (String) ipChange.ipc$dispatch("836774117", new Object[]{this}) : "1.0";
    }
}
