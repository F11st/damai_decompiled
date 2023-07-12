package cn.damai.commonbusiness.discover.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class VoteActionRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String activityId;
    public String activityOptionId;
    public String operate;

    public VoteActionRequest(String str, String str2, boolean z) {
        this.activityId = str;
        this.activityOptionId = str2;
        this.operate = z ? "1" : "0";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2109764504") ? (String) ipChange.ipc$dispatch("-2109764504", new Object[]{this}) : "mtop.damai.wireless.activity.vote";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913498821")) {
            return ((Boolean) ipChange.ipc$dispatch("1913498821", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841256449")) {
            return ((Boolean) ipChange.ipc$dispatch("1841256449", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "57972219") ? (String) ipChange.ipc$dispatch("57972219", new Object[]{this}) : "2.0";
    }
}
