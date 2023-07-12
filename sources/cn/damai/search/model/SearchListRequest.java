package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y72;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String favourableId;
    public String keyword;
    public int pageIndex;
    public int pageSize = 15;
    public String cityId = "0";
    public String sourceType = "10";
    public String sortType = "4";
    public String returnItemStatusOption = "0";
    public String option = "";
    public String channel = "10001";
    public String returnItemOption = "4";
    public String distanceCityId = z20.c();
    public String userId = z20.E();
    public String longitude = "";
    public String latitude = "";

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1956582277") ? (String) ipChange.ipc$dispatch("-1956582277", new Object[]{this}) : y72.a;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482834158")) {
            return ((Boolean) ipChange.ipc$dispatch("-482834158", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067734286")) {
            return ((Boolean) ipChange.ipc$dispatch("1067734286", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "211154446") ? (String) ipChange.ipc$dispatch("211154446", new Object[]{this}) : y72.b;
    }
}
