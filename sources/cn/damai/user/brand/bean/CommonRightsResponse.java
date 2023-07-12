package cn.damai.user.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CommonRightsResponse extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public CommonRightsData data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public CommonRightsData getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1575047917") ? (CommonRightsData) ipChange.ipc$dispatch("-1575047917", new Object[]{this}) : this.data;
    }
}
