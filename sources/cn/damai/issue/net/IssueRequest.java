package cn.damai.issue.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.discover.content.net.ContentDetailApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class IssueRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public Long associatedThemeId;
    public Long cliqueId;
    public String commentId;
    public String commentType;
    public Long dmId;
    public List<String> dmTags;
    public String forwardId;
    public String forwardType;
    public String grades;
    public List<String> images;
    public String ipId;
    public String itemId;
    public String mainCommentId;
    public String scriptId;
    public String sourceType;
    public boolean spoilerType;
    public String storeId;
    public String targetId;
    public String targetType;
    public String targetValidTime;
    public String text;
    public String uniqueOrderId;
    public String video;
    public String watchActivityId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1499209945") ? (String) ipChange.ipc$dispatch("1499209945", new Object[]{this}) : ContentDetailApi.CONTENT_COMMENT_PUBLISH;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-270097311") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-270097311", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978131852")) {
            return ((Boolean) ipChange.ipc$dispatch("-978131852", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828020208")) {
            return ((Boolean) ipChange.ipc$dispatch("1828020208", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-628020628") ? (String) ipChange.ipc$dispatch("-628020628", new Object[]{this}) : "2.1";
    }
}
