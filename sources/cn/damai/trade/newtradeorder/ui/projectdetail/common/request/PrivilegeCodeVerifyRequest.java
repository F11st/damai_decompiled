package cn.damai.trade.newtradeorder.ui.projectdetail.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PrivilegeCodeVerifyRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long activityId;
    public long bizObjId;
    public int bizObjType;
    public String buyerId;
    public String channelId;
    public String code;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-685125493") ? (String) ipChange.ipc$dispatch("-685125493", new Object[]{this}) : "mtop.damai.wireless.mkt.privilege.verifyandsigncode";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "637903471") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("637903471", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045118210")) {
            return ((Boolean) ipChange.ipc$dispatch("2045118210", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521529602")) {
            return ((Boolean) ipChange.ipc$dispatch("-521529602", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1482611230") ? (String) ipChange.ipc$dispatch("1482611230", new Object[]{this}) : "1.0";
    }
}
