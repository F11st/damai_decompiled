package cn.damai.discover.content.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PublishCommentRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String commentType;
    public String loginKey;
    public String mainCommentId;
    public String sourceType;
    public String targetId;
    public String targetType;
    public String text;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "606343590") ? (String) ipChange.ipc$dispatch("606343590", new Object[]{this}) : ContentDetailApi.CONTENT_COMMENT_PUBLISH;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-112962572") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-112962572", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234679481")) {
            return ((Boolean) ipChange.ipc$dispatch("-234679481", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973789693")) {
            return ((Boolean) ipChange.ipc$dispatch("-973789693", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1520886983") ? (String) ipChange.ipc$dispatch("-1520886983", new Object[]{this}) : "2.1";
    }
}
