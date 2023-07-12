package cn.damai.category.category.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StarRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean hasFollowed;
    public String sourceId;
    public int pageSize = 15;
    public int pageNumber = 1;
    public Double longitude = Double.valueOf(z20.o());
    public Double latitude = Double.valueOf(z20.n());
    public String distanceCityId = z20.c();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2026676200") ? (String) ipChange.ipc$dispatch("-2026676200", new Object[]{this}) : "mtop.damai.wireless.search.artist.search";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "356708117") ? ((Boolean) ipChange.ipc$dispatch("356708117", new Object[]{this})).booleanValue() : this.hasFollowed;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "414008913") ? ((Boolean) ipChange.ipc$dispatch("414008913", new Object[]{this})).booleanValue() : this.hasFollowed;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "141060523") ? (String) ipChange.ipc$dispatch("141060523", new Object[]{this}) : "1.0";
    }
}
