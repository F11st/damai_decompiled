package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class SearchResultDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public SearchResultBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public SearchResultBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "563101946") ? (SearchResultBean) ipChange.ipc$dispatch("563101946", new Object[]{this}) : this.data;
    }
}
