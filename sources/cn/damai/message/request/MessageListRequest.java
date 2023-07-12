package cn.damai.message.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String groupId;
    public boolean isRefresh;
    public String loginkey;
    public String messageId;
    public String pageIndex;
    public String size;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1652394267") ? (String) ipChange.ipc$dispatch("-1652394267", new Object[]{this}) : this.isRefresh ? "mtop.damai.msgbox.user.message.group.get" : "mtop.damai.msgbox.user.message.group.list";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-85908267") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-85908267", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110839832")) {
            return ((Boolean) ipChange.ipc$dispatch("-110839832", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071996004")) {
            return ((Boolean) ipChange.ipc$dispatch("2071996004", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "515342456") ? (String) ipChange.ipc$dispatch("515342456", new Object[]{this}) : "1.0";
    }
}
