package cn.damai.category.categorygirl.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y72;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        return AndroidInstantRuntime.support(ipChange, "-421119792") ? (String) ipChange.ipc$dispatch("-421119792", new Object[]{this}) : y72.a;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702935901")) {
            return ((Boolean) ipChange.ipc$dispatch("1702935901", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353753241")) {
            return ((Boolean) ipChange.ipc$dispatch("1353753241", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1746616931") ? (String) ipChange.ipc$dispatch("1746616931", new Object[]{this}) : y72.b;
    }
}
