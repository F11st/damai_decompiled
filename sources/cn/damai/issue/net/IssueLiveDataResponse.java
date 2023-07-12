package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class IssueLiveDataResponse extends LiveDataCommonResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public IssueResponse data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1986433366") ? ipChange.ipc$dispatch("-1986433366", new Object[]{this}) : this.data;
    }
}
