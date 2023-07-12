package cn.damai.comment.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.discover.content.net.ContentDetailApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CommentPraiseRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int operate;
    public String targetId;
    public int targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1938162291") ? (String) ipChange.ipc$dispatch("1938162291", new Object[]{this}) : ContentDetailApi.CONTENT_COMMENT_PRAISE;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955859482")) {
            return ((Boolean) ipChange.ipc$dispatch("955859482", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "672853014")) {
            return ((Boolean) ipChange.ipc$dispatch("672853014", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-189068282") ? (String) ipChange.ipc$dispatch("-189068282", new Object[]{this}) : "1.0";
    }
}
