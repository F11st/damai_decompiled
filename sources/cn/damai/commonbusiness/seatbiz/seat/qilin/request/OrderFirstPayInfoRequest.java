package cn.damai.commonbusiness.seatbiz.seat.qilin.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class OrderFirstPayInfoRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ORDER_FIRST_PAY_INFO = "mtop.damai.wireless.seat.chooseSeatParam";
    public long orderId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-176452863") ? (String) ipChange.ipc$dispatch("-176452863", new Object[]{this}) : ORDER_FIRST_PAY_INFO;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753313100")) {
            return ((Boolean) ipChange.ipc$dispatch("1753313100", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773366072")) {
            return ((Boolean) ipChange.ipc$dispatch("-1773366072", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1991283860") ? (String) ipChange.ipc$dispatch("1991283860", new Object[]{this}) : "2.0";
    }
}
