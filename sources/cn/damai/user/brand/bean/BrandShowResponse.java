package cn.damai.user.brand.bean;

import cn.damai.user.userprofile.LiveDataResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandShowResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public NearbyShows data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public NearbyShows getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1563822338") ? (NearbyShows) ipChange.ipc$dispatch("-1563822338", new Object[]{this}) : this.data;
    }
}
