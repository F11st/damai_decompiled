package cn.damai.user.brand.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandInfoRerquest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String accountapi = "mtop.damai.wireless.search.brand.detail";
    public String bid;
    public String cityId;
    public String projectId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "156359568") ? (String) ipChange.ipc$dispatch("156359568", new Object[]{this}) : this.accountapi;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786697571")) {
            return ((Boolean) ipChange.ipc$dispatch("-786697571", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1112770521")) {
            return ((Boolean) ipChange.ipc$dispatch("1112770521", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1970871005") ? (String) ipChange.ipc$dispatch("-1970871005", new Object[]{this}) : "1.0";
    }
}
