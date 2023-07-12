package cn.damai.comment.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FollowUpdateRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String operateType;
    public String targetId;
    public String targetType;

    public FollowUpdateRequest(boolean z, String str) {
        this.operateType = z ? "1" : "0";
        this.targetId = str;
        this.targetType = jm1.h(str, 0.0d) >= 1.0E8d ? "7" : "6";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "528189424") ? (String) ipChange.ipc$dispatch("528189424", new Object[]{this}) : ApiConstant.API_NAME_RELATION_UPDATE;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645941309")) {
            return ((Boolean) ipChange.ipc$dispatch("1645941309", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878442119")) {
            return ((Boolean) ipChange.ipc$dispatch("-1878442119", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1599041149") ? (String) ipChange.ipc$dispatch("-1599041149", new Object[]{this}) : "1.2";
    }
}
