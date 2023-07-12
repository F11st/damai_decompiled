package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class IssueRenderLiveDataResponse extends LiveDataCommonResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public IssueRenderResponse data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-742220704") ? ipChange.ipc$dispatch("-742220704", new Object[]{this}) : this.data;
    }
}
