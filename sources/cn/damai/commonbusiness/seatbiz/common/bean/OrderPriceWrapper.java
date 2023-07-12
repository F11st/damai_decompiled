package cn.damai.commonbusiness.seatbiz.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class OrderPriceWrapper extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public OrderPrice data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public OrderPrice getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "89573771") ? (OrderPrice) ipChange.ipc$dispatch("89573771", new Object[]{this}) : this.data;
    }
}
