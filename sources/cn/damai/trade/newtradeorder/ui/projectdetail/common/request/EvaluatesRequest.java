package cn.damai.trade.newtradeorder.ui.projectdetail.common.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class EvaluatesRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long categoryId;
    public int commentType;
    public String ipId;
    public boolean isQueryHotComment;
    public long itemId;
    public int moduleType;
    public int pageIndex;
    public int pageSize;
    public String tourId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1342376558") ? (String) ipChange.ipc$dispatch("1342376558", new Object[]{this}) : "mtop.damai.wireless.comment.module.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1086640684") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1086640684", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570776705")) {
            return ((Boolean) ipChange.ipc$dispatch("-570776705", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840674757")) {
            return ((Boolean) ipChange.ipc$dispatch("-1840674757", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-784854015") ? (String) ipChange.ipc$dispatch("-784854015", new Object[]{this}) : "1.1";
    }
}
