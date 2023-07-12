package cn.damai.mine.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String buyerId;
    public int couponStatus;
    public boolean onlyDmSeller;
    public int pageIndex;
    public int pageSize;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1925366330") ? (String) ipChange.ipc$dispatch("1925366330", new Object[]{this}) : "mtop.damai.wireless.mkt.coupon.queryCouponsOfUser";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1957349152") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-1957349152", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187787469")) {
            return ((Boolean) ipChange.ipc$dispatch("-1187787469", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2082532113")) {
            return ((Boolean) ipChange.ipc$dispatch("-2082532113", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-201864243") ? (String) ipChange.ipc$dispatch("-201864243", new Object[]{this}) : "1.0";
    }
}
