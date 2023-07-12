package cn.damai.trade.newtradeorder.ui.orderlist.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.observer.Action;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListResultBean;
import cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract;
import cn.damai.trade.newtradeorder.ui.orderlist.net.OrderListRequest;
import cn.damai.trade.newtradeorder.ui.orderlist.net.api.OrderListConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.uo1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderListPresenter extends OrderListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderlist.presenter.OrderListPresenter$a */
    /* loaded from: classes8.dex */
    public class C2228a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2228a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1223510428")) {
                ipChange.ipc$dispatch("-1223510428", new Object[]{this, str});
            } else {
                ((OrderListContract.View) OrderListPresenter.this.mView).startTimerNotify();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderlist.presenter.OrderListPresenter$b */
    /* loaded from: classes8.dex */
    public class C2229b implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2229b() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-530408731")) {
                ipChange.ipc$dispatch("-530408731", new Object[]{this, str});
            } else {
                ((OrderListContract.View) OrderListPresenter.this.mView).orderListRefreshNotify();
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract.Presenter
    public void getOrderListData(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307385464")) {
            ipChange.ipc$dispatch("307385464", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        OrderListRequest orderListRequest = new OrderListRequest();
        orderListRequest.pageNum = i;
        orderListRequest.pageSize = i2;
        orderListRequest.queryType = i3;
        orderListRequest.request(new DMMtopRequestListener<OrderListResultBean>(OrderListResultBean.class) { // from class: cn.damai.trade.newtradeorder.ui.orderlist.presenter.OrderListPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-168489391")) {
                    ipChange2.ipc$dispatch("-168489391", new Object[]{this, str, str2});
                    return;
                }
                ((OrderListContract.View) OrderListPresenter.this.mView).stopLoading();
                ((OrderListContract.View) OrderListPresenter.this.mView).onNetError(str, str2, OrderListConstantsApi.ORDER_LIST_API);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderListResultBean orderListResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-424493138")) {
                    ipChange2.ipc$dispatch("-424493138", new Object[]{this, orderListResultBean});
                    return;
                }
                ((OrderListContract.View) OrderListPresenter.this.mView).stopLoading();
                ((OrderListContract.View) OrderListPresenter.this.mView).onNetSuccess();
                ((OrderListContract.View) OrderListPresenter.this.mView).returnOrderListData(orderListResultBean);
            }
        });
    }

    @Override // cn.damai.common.app.base.AbstractC0470a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240709660")) {
            ipChange.ipc$dispatch("240709660", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(uo1.NOTIFY_ORDER_LIST_SELF, new C2228a());
        this.mDMMessage.b(uo1.NOTIFY_ORDER_LIST_REFRESH, new C2229b());
    }
}
