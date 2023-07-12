package cn.damai.commonbusiness.calendar.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CategoryCalendarRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String categoryId;
    public String cityName;
    public String damaiID = z20.c();
    public String endDate;
    public String startDate;
    public String subcategoryId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "293683087") ? (String) ipChange.ipc$dispatch("293683087", new Object[]{this}) : "mtop.damai.wireless.search.performance.calendar.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562833022")) {
            return ((Boolean) ipChange.ipc$dispatch("1562833022", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-141127302")) {
            return ((Boolean) ipChange.ipc$dispatch("-141127302", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1833547486") ? (String) ipChange.ipc$dispatch("-1833547486", new Object[]{this}) : "1.0";
    }
}
