package cn.damai.homepage.girl.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y72;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SearchListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String groupId;
    public String keyword;
    public int pageIndex = 1;
    public int pageSize = 15;
    public String sourceType = "10";
    public String sortType = "7";
    public String option = "1073742642";
    public String returnItemOption = "4";
    public String distanceCityId = z20.c();
    public String userId = z20.E();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1276785026") ? (String) ipChange.ipc$dispatch("-1276785026", new Object[]{this}) : y72.a;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671760751")) {
            return ((Boolean) ipChange.ipc$dispatch("671760751", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1763087829")) {
            return ((Boolean) ipChange.ipc$dispatch("-1763087829", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "890951697") ? (String) ipChange.ipc$dispatch("890951697", new Object[]{this}) : y72.b;
    }
}
