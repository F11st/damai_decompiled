package cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ZLOrderDetailCancelRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String loginkey = z20.q();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-855239245") ? (String) ipChange.ipc$dispatch("-855239245", new Object[]{this}) : "mtop.damai.wireless.my.cancelOrder";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901966118")) {
            return ((Boolean) ipChange.ipc$dispatch("-901966118", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008846550")) {
            return ((Boolean) ipChange.ipc$dispatch("2008846550", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1312497478") ? (String) ipChange.ipc$dispatch("1312497478", new Object[]{this}) : "1.0";
    }
}
