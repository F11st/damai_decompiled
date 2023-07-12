package cn.damai.search.bean;

import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchFollowResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public FollowDataBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1670615246") ? ipChange.ipc$dispatch("-1670615246", new Object[]{this}) : this.data;
    }
}
