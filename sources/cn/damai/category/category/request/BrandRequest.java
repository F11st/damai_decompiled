package cn.damai.category.category.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BrandRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int pageSize = 15;
    public int pageNumber = 1;
    public Double longitude = Double.valueOf(z20.o());
    public Double latitude = Double.valueOf(z20.n());
    public String currentCityId = z20.c();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-156450417") ? (String) ipChange.ipc$dispatch("-156450417", new Object[]{this}) : "mtop.damai.wireless.search.brand.search";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178761342")) {
            return ((Boolean) ipChange.ipc$dispatch("178761342", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205849978")) {
            return ((Boolean) ipChange.ipc$dispatch("1205849978", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2011286306") ? (String) ipChange.ipc$dispatch("2011286306", new Object[]{this}) : "1.0";
    }
}
