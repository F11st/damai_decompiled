package cn.damai.commonbusiness.banner.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class OrderDetailBannerRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String damaiCityId = z20.c();
    public String visitorId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "48232756") ? (String) ipChange.ipc$dispatch("48232756", new Object[]{this}) : "mtop.damai.wireless.resource.order.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223166087")) {
            return ((Boolean) ipChange.ipc$dispatch("-223166087", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500647349")) {
            return ((Boolean) ipChange.ipc$dispatch("1500647349", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2078997817") ? (String) ipChange.ipc$dispatch("-2078997817", new Object[]{this}) : "1.0";
    }
}
