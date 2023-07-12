package cn.damai.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchAccountResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public SearchAccountBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1272604400") ? ipChange.ipc$dispatch("1272604400", new Object[]{this}) : this.data;
    }
}
