package cn.damai.user.brand.bean;

import cn.damai.user.userprofile.LiveDataResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public BrandInfoResult data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public BrandInfoResult getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2011905530") ? (BrandInfoResult) ipChange.ipc$dispatch("-2011905530", new Object[]{this}) : this.data;
    }
}
