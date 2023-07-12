package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.observer.Action;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailCanResellBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundCheck;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.helper.OrderPayListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDeliveyRemindRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailCanResellRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailCancelRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailPayRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailRefundCheckRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailWolfPayRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderSeatRemindRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.mo1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailPresenter extends OrderDetailContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter$a */
    /* loaded from: classes8.dex */
    public class C2140a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2140a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2012022032")) {
                ipChange.ipc$dispatch("2012022032", new Object[]{this, obj});
            } else if (obj != null) {
                try {
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).jumpTicketServicePage((ArrayList) obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter$b */
    /* loaded from: classes8.dex */
    public class C2141b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2141b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1589843567")) {
                ipChange.ipc$dispatch("-1589843567", new Object[]{this, obj});
            } else if (obj != null) {
                try {
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).requestRefundCheckRequest((String) obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter$c */
    /* loaded from: classes8.dex */
    public class C2142c implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2142c() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-896741870")) {
                ipChange.ipc$dispatch("-896741870", new Object[]{this, obj});
            } else {
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).requestCanReSellRequest();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter$d */
    /* loaded from: classes8.dex */
    public class C2143d implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2143d() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-203640173")) {
                ipChange.ipc$dispatch("-203640173", new Object[]{this, obj});
            } else if (obj == null || !(obj instanceof ArrayList)) {
            } else {
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).openNoticePop((ArrayList) obj);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void cancelOrderDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045633578")) {
            ipChange.ipc$dispatch("1045633578", new Object[]{this, str});
            return;
        }
        OrderDetailCancelRequest orderDetailCancelRequest = new OrderDetailCancelRequest();
        orderDetailCancelRequest.orderId = str;
        orderDetailCancelRequest.request(new DMMtopRequestListener<String>(String.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "485509104")) {
                    ipChange2.ipc$dispatch("485509104", new Object[]{this, str2, str3});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailCancelFail(str2, str3);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "188368311")) {
                    ipChange2.ipc$dispatch("188368311", new Object[]{this, str2});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailCancel();
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void getOrderDetailData(String str, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295516828")) {
            ipChange.ipc$dispatch("1295516828", new Object[]{this, str, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        OrderDetailRequest orderDetailRequest = new OrderDetailRequest();
        orderDetailRequest.orderId = str;
        orderDetailRequest.checkModifyResult = z;
        orderDetailRequest.checkInvoiceResult = z2;
        orderDetailRequest.request(new DMMtopRequestListener<OrderDetailBean>(OrderDetailBean.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "508787181")) {
                    ipChange2.ipc$dispatch("508787181", new Object[]{this, str2, str3});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailFail(str2, str3, OrderDetailConstantsApi.API_ORDER_DETAIL);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderDetailBean orderDetailBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-542676017")) {
                    ipChange2.ipc$dispatch("-542676017", new Object[]{this, orderDetailBean});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).onNetSuccess();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailData(orderDetailBean);
            }
        });
    }

    @Override // cn.damai.common.app.base.AbstractC0470a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374732866")) {
            ipChange.ipc$dispatch("374732866", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(mo1.NOTIFY_JUMP_TICKET_SERVICE, new C2140a());
        this.mDMMessage.b(mo1.REFUND_CHECK_SERVICE, new C2141b());
        this.mDMMessage.b(mo1.NOTIFY_CANCEL_SELL, new C2142c());
        this.mDMMessage.b(mo1.NOTIFY_OPEN_NOTICE_POP, new C2143d());
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailCanResell(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "620928729")) {
            ipChange.ipc$dispatch("620928729", new Object[]{this, str});
            return;
        }
        OrderDetailCanResellRequest orderDetailCanResellRequest = new OrderDetailCanResellRequest();
        orderDetailCanResellRequest.orderId = str;
        orderDetailCanResellRequest.request(new DMMtopRequestListener<OrderDetailCanResellBean>(OrderDetailCanResellBean.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "881043369")) {
                    ipChange2.ipc$dispatch("881043369", new Object[]{this, str2, str3});
                    return;
                }
                OrderDetailCanResellBean orderDetailCanResellBean = new OrderDetailCanResellBean();
                orderDetailCanResellBean.errorCode = str2;
                orderDetailCanResellBean.errorMsg = str3;
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnCanResellData(orderDetailCanResellBean, false);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderDetailCanResellBean orderDetailCanResellBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1800807752")) {
                    ipChange2.ipc$dispatch("1800807752", new Object[]{this, orderDetailCanResellBean});
                } else {
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnCanResellData(orderDetailCanResellBean, true);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailChooseSeatRemind(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16831279")) {
            ipChange.ipc$dispatch("16831279", new Object[]{this, str});
            return;
        }
        OrderSeatRemindRequest orderSeatRemindRequest = new OrderSeatRemindRequest();
        orderSeatRemindRequest.orderId = str;
        orderSeatRemindRequest.request(new DMMtopRequestListener<String>(String.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "896562087")) {
                    ipChange2.ipc$dispatch("896562087", new Object[]{this, str2, str3});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1029373216")) {
                    ipChange2.ipc$dispatch("-1029373216", new Object[]{this, str2});
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailDeliveryRemind(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838209225")) {
            ipChange.ipc$dispatch("-838209225", new Object[]{this, str});
            return;
        }
        OrderDeliveyRemindRequest orderDeliveyRemindRequest = new OrderDeliveyRemindRequest();
        orderDeliveyRemindRequest.orderId = str;
        orderDeliveyRemindRequest.request(new DMMtopRequestListener<String>(String.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "477749745")) {
                    ipChange2.ipc$dispatch("477749745", new Object[]{this, str2, str3});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1213860310")) {
                    ipChange2.ipc$dispatch("1213860310", new Object[]{this, str2});
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailPay(String str, String str2, String str3, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930796265")) {
            ipChange.ipc$dispatch("1930796265", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        OrderDetailPayRequest orderDetailPayRequest = new OrderDetailPayRequest();
        orderDetailPayRequest.orderId = str;
        orderDetailPayRequest.payCode = str2;
        orderDetailPayRequest.paymentInfoExt = str3;
        orderDetailPayRequest.request(new DMMtopRequestListener<OrderPayDTO>(OrderPayDTO.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "501027822")) {
                    ipChange2.ipc$dispatch("501027822", new Object[]{this, str4, str5});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailPayFail(str4, str5);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderPayDTO orderPayDTO) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2021515976")) {
                    ipChange2.ipc$dispatch("-2021515976", new Object[]{this, orderPayDTO});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                if (orderPayDTO != null) {
                    orderPayDTO.payTypeId = i;
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailPay(orderPayDTO);
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailPayFail("success", "支付数据异常");
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailRefundCheck(String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980024264")) {
            ipChange.ipc$dispatch("980024264", new Object[]{this, str, str2});
            return;
        }
        OrderDetailRefundCheckRequest orderDetailRefundCheckRequest = new OrderDetailRefundCheckRequest();
        orderDetailRefundCheckRequest.orderId = str;
        orderDetailRefundCheckRequest.request(new DMMtopRequestListener<OrderDetailRefundCheck>(OrderDetailRefundCheck.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "888802728")) {
                    ipChange2.ipc$dispatch("888802728", new Object[]{this, str3, str4});
                } else {
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).refundCheckResult(true, "", str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderDetailRefundCheck orderDetailRefundCheck) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-193912196")) {
                    ipChange2.ipc$dispatch("-193912196", new Object[]{this, orderDetailRefundCheck});
                } else if (orderDetailRefundCheck != null) {
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).refundCheckResult(orderDetailRefundCheck.isCanApply(), orderDetailRefundCheck.failReason, str2);
                } else {
                    ((OrderDetailContract.View) OrderDetailPresenter.this.mView).refundCheckResult(true, "", str2);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderWolfDetailPay(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380220670")) {
            ipChange.ipc$dispatch("-380220670", new Object[]{this, str, str2});
            return;
        }
        OrderDetailWolfPayRequest orderDetailWolfPayRequest = new OrderDetailWolfPayRequest();
        orderDetailWolfPayRequest.orderId = str;
        orderDetailWolfPayRequest.type = str2;
        orderDetailWolfPayRequest.request(new OrderPayListener<OrderParmasResult>(OrderParmasResult.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "493268463")) {
                    ipChange2.ipc$dispatch("493268463", new Object[]{this, str3, str4});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailPayFail(str3, str4);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderParmasResult orderParmasResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1358328367")) {
                    ipChange2.ipc$dispatch("-1358328367", new Object[]{this, orderParmasResult});
                    return;
                }
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).stopLoading();
                ((OrderDetailContract.View) OrderDetailPresenter.this.mView).returnOrderDetailWolfPay(orderParmasResult);
            }
        });
    }
}
