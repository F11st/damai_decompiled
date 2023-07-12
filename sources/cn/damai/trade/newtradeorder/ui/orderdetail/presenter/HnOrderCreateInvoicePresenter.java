package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceSubmitInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceInfoRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceSubmitRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HnOrderCreateInvoicePresenter extends HnOrderCreateInvoiceContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.Presenter
    public void requestInvoiceInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82520787")) {
            ipChange.ipc$dispatch("82520787", new Object[]{this, str});
            return;
        }
        HNOrderInvoiceInfoRequest hNOrderInvoiceInfoRequest = new HNOrderInvoiceInfoRequest();
        hNOrderInvoiceInfoRequest.orderId = str;
        hNOrderInvoiceInfoRequest.request(new DMMtopRequestListener<HnInvoiceApplyInfoResult>(HnInvoiceApplyInfoResult.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.HnOrderCreateInvoicePresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2086702617")) {
                    ipChange2.ipc$dispatch("2086702617", new Object[]{this, str2, str3});
                    return;
                }
                ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).stopLoading();
                ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).returnInvoiceInfoError(str2, str3, OrderDetailConstantsApi.API_HN_ORDER_APPLY_INVOICE_INFO);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1995055913")) {
                    ipChange2.ipc$dispatch("-1995055913", new Object[]{this, hnInvoiceApplyInfoResult});
                    return;
                }
                ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).stopLoading();
                if (hnInvoiceApplyInfoResult != null) {
                    ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).returnInvoiceInfo(hnInvoiceApplyInfoResult);
                } else {
                    ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).returnInvoiceInfoError(null, " 数据为空...", OrderDetailConstantsApi.API_HN_ORDER_APPLY_INVOICE_INFO);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.Presenter
    public void submitInvoiceInfo(HNOrderInvoiceSubmitRequest hNOrderInvoiceSubmitRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226157007")) {
            ipChange.ipc$dispatch("226157007", new Object[]{this, hNOrderInvoiceSubmitRequest});
        } else if (hNOrderInvoiceSubmitRequest == null) {
            ((HnOrderCreateInvoiceContract.View) this.mView).stopLoading();
        } else {
            hNOrderInvoiceSubmitRequest.request(new DMMtopRequestListener<HnInvoiceSubmitInfoResult>(HnInvoiceSubmitInfoResult.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.HnOrderCreateInvoicePresenter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2078943258")) {
                        ipChange2.ipc$dispatch("2078943258", new Object[]{this, str, str2});
                        return;
                    }
                    ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).stopLoading();
                    ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).returnInvoiceSubmitInfoError(str, str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(HnInvoiceSubmitInfoResult hnInvoiceSubmitInfoResult) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "72015710")) {
                        ipChange2.ipc$dispatch("72015710", new Object[]{this, hnInvoiceSubmitInfoResult});
                        return;
                    }
                    ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).stopLoading();
                    if (hnInvoiceSubmitInfoResult != null) {
                        ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).returnInvoiceSubmitInfo(hnInvoiceSubmitInfoResult);
                    } else {
                        ((HnOrderCreateInvoiceContract.View) HnOrderCreateInvoicePresenter.this.mView).returnInvoiceSubmitInfoError(null, " 数据为空...");
                    }
                }
            });
        }
    }
}
