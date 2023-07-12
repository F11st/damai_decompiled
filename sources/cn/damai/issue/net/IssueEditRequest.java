package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class IssueEditRequest extends IssueRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.issue.net.IssueRequest, cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "888901635") ? (String) ipChange.ipc$dispatch("888901635", new Object[]{this}) : "mtop.damai.wireless.comment.modify";
    }

    @Override // cn.damai.issue.net.IssueRequest, cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1238328938") ? (String) ipChange.ipc$dispatch("-1238328938", new Object[]{this}) : "1.0";
    }
}
