package cn.damai.trade.newtradeorder.ui.orderdetail.model;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayList;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.helper.OrderPayListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailPayListRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailPayRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailWolfPayRequest;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailPayRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public void requestOrderDetailPay(String str, String str2, String str3, DMMtopRequestListener<OrderPayDTO> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354706300")) {
            ipChange.ipc$dispatch("1354706300", new Object[]{this, str, str2, str3, dMMtopRequestListener});
            return;
        }
        OrderDetailPayRequest orderDetailPayRequest = new OrderDetailPayRequest();
        orderDetailPayRequest.orderId = str;
        orderDetailPayRequest.payCode = str2;
        orderDetailPayRequest.paymentInfoExt = str3;
        orderDetailPayRequest.request(dMMtopRequestListener);
    }

    public void requestOrderDetailPayList(String str, String str2, String str3, DMMtopRequestListener<OrderDetailPayList> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978715578")) {
            ipChange.ipc$dispatch("1978715578", new Object[]{this, str, str2, str3, dMMtopRequestListener});
            return;
        }
        OrderDetailPayListRequest orderDetailPayListRequest = new OrderDetailPayListRequest();
        orderDetailPayListRequest.orderId = str;
        orderDetailPayListRequest.payCode = str2;
        orderDetailPayListRequest.paymentInfoExt = str3;
        orderDetailPayListRequest.request(dMMtopRequestListener);
    }

    public void requestOrderDetailSelfPay(String str, String str2, OrderPayListener<OrderParmasResult> orderPayListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "697645166")) {
            ipChange.ipc$dispatch("697645166", new Object[]{this, str, str2, orderPayListener});
            return;
        }
        OrderDetailWolfPayRequest orderDetailWolfPayRequest = new OrderDetailWolfPayRequest();
        orderDetailWolfPayRequest.orderId = str;
        orderDetailWolfPayRequest.type = str2;
        orderDetailWolfPayRequest.request(orderPayListener);
    }
}
