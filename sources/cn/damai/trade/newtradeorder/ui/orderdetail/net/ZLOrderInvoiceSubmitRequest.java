package cn.damai.trade.newtradeorder.ui.orderdetail.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ZLOrderInvoiceSubmitRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String addrId;
    public String companyName;
    public String companyTax;
    public String loginKey = z20.q();
    public String name;
    public String orderId;
    public String payId;
    public String phone;
    public String transId;
    public String typeId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-782331042") ? (String) ipChange.ipc$dispatch("-782331042", new Object[]{this}) : OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_SUBMIT;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055448433")) {
            return ((Boolean) ipChange.ipc$dispatch("-2055448433", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1613904203")) {
            return ((Boolean) ipChange.ipc$dispatch("1613904203", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1385405681") ? (String) ipChange.ipc$dispatch("1385405681", new Object[]{this}) : "1.0";
    }
}
