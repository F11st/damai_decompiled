package cn.damai.commonbusiness.address.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AddressDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private AddressListBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public AddressListBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-641583716") ? (AddressListBean) ipChange.ipc$dispatch("-641583716", new Object[]{this}) : this.data;
    }
}
