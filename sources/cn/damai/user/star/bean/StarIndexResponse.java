package cn.damai.user.star.bean;

import cn.damai.user.userprofile.LiveDataResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarIndexResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public StarInfo data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public StarInfo getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "325709347") ? (StarInfo) ipChange.ipc$dispatch("325709347", new Object[]{this}) : this.data;
    }
}
