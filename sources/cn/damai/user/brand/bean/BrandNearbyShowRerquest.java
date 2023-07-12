package cn.damai.user.brand.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandNearbyShowRerquest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int pageSize = 15;
    public String bid;
    public String cityId;
    public String excludeProjectId;
    private String accountapi = "mtop.damai.wireless.search.brand.nearshow";
    public int pageNo = 1;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-839155294") ? (String) ipChange.ipc$dispatch("-839155294", new Object[]{this}) : this.accountapi;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070861109")) {
            return ((Boolean) ipChange.ipc$dispatch("-2070861109", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312775545")) {
            return ((Boolean) ipChange.ipc$dispatch("-312775545", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1328581429") ? (String) ipChange.ipc$dispatch("1328581429", new Object[]{this}) : "1.0";
    }
}
