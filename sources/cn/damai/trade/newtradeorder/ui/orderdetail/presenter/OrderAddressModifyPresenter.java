package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderModifyAddressInfoRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderModiyAddressSubmitRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderAddressModifyPresenter extends OrderAddressModifyContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.Presenter
    public void requestModifyAddressInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741517543")) {
            ipChange.ipc$dispatch("-1741517543", new Object[]{this, str, str2});
            return;
        }
        OrderModifyAddressInfoRequest orderModifyAddressInfoRequest = new OrderModifyAddressInfoRequest();
        orderModifyAddressInfoRequest.orderId = str;
        orderModifyAddressInfoRequest.addressId = str2;
        orderModifyAddressInfoRequest.request(new DMMtopRequestListener<OrderAddressModifyResult>(OrderAddressModifyResult.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderAddressModifyPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1587166366")) {
                    ipChange2.ipc$dispatch("-1587166366", new Object[]{this, str3, str4});
                    return;
                }
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).stopLoading();
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).onGetModifyAddressInfoError(str3, str4, OrderDetailConstantsApi.API_ORDER_DETAIL_MODIFY_ADDRESS);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderAddressModifyResult orderAddressModifyResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-920189110")) {
                    ipChange2.ipc$dispatch("-920189110", new Object[]{this, orderAddressModifyResult});
                    return;
                }
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).stopLoading();
                if (orderAddressModifyResult != null) {
                    ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).returnModifyAddressInfo(orderAddressModifyResult);
                    ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).onNetSuccess();
                    return;
                }
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).onGetModifyAddressInfoError("SUCCESS", "Bean NULL", OrderDetailConstantsApi.API_ORDER_DETAIL_MODIFY_ADDRESS);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.Presenter
    public void requestNewAddressSubmit(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162042267")) {
            ipChange.ipc$dispatch("-1162042267", new Object[]{this, str, str2});
            return;
        }
        OrderModiyAddressSubmitRequest orderModiyAddressSubmitRequest = new OrderModiyAddressSubmitRequest();
        orderModiyAddressSubmitRequest.orderId = str;
        orderModiyAddressSubmitRequest.addressId = str2;
        orderModiyAddressSubmitRequest.request(new DMMtopRequestListener<OrderAddressSubmitResult>(OrderAddressSubmitResult.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderAddressModifyPresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1594925725")) {
                    ipChange2.ipc$dispatch("-1594925725", new Object[]{this, str3, str4});
                    return;
                }
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).stopLoading();
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).onNewAddressSubmitError(str3, str4);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderAddressSubmitResult orderAddressSubmitResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "816329325")) {
                    ipChange2.ipc$dispatch("816329325", new Object[]{this, orderAddressSubmitResult});
                    return;
                }
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).stopLoading();
                if (orderAddressSubmitResult != null) {
                    ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).returnNewAddressSubmit(orderAddressSubmitResult);
                    ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).onNetSuccess();
                    return;
                }
                ((OrderAddressModifyContract.View) OrderAddressModifyPresenter.this.mView).onNewAddressSubmitError("SUCCESS", "Bean is NULL");
            }
        });
    }
}
