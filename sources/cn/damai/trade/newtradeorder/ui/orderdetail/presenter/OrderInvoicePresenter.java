package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.message.observer.Action;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceAddInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceAddressRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceInfoRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceSubmitRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderInvoicePresenter extends OrderInvoiceContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter$a */
    /* loaded from: classes8.dex */
    public class C2144a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2144a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329619208")) {
                ipChange.ipc$dispatch("-329619208", new Object[]{this, str});
            } else {
                ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).deliveryTypeChanged(str);
            }
        }
    }

    @Override // cn.damai.common.app.base.AbstractC0470a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005798136")) {
            ipChange.ipc$dispatch("-2005798136", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b("1", new C2144a());
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.Presenter
    public void requestAddressList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749415932")) {
            ipChange.ipc$dispatch("749415932", new Object[]{this});
        } else {
            new ZLOrderInvoiceAddressRequest().request(new DMMtopRequestListener<AddressListBean>(AddressListBean.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1684490470")) {
                        ipChange2.ipc$dispatch("1684490470", new Object[]{this, str, str2});
                    } else {
                        ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).returnAddressListError(str, str2);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(AddressListBean addressListBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2108113823")) {
                        ipChange2.ipc$dispatch("2108113823", new Object[]{this, addressListBean});
                        return;
                    }
                    ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).onNetSuccess();
                    ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).returnAddressList(addressListBean);
                }
            });
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.Presenter
    public void requestInvoiceInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319521181")) {
            ipChange.ipc$dispatch("319521181", new Object[]{this, str});
            return;
        }
        ZLOrderInvoiceInfoRequest zLOrderInvoiceInfoRequest = new ZLOrderInvoiceInfoRequest();
        zLOrderInvoiceInfoRequest.orderId = str;
        zLOrderInvoiceInfoRequest.request(new DMMtopResultRequestListener<InvoiceAddInfo>(InvoiceAddInfo.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1700009188")) {
                    ipChange2.ipc$dispatch("1700009188", new Object[]{this, str2, str3});
                } else {
                    ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).returnInvoiceInfoError(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(InvoiceAddInfo invoiceAddInfo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-941559353")) {
                    ipChange2.ipc$dispatch("-941559353", new Object[]{this, invoiceAddInfo});
                    return;
                }
                ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).onNetSuccess();
                ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).returnInvoiceInfo(invoiceAddInfo);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.Presenter
    public void requestSubmitInvoice(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552947059")) {
            ipChange.ipc$dispatch("1552947059", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9});
            return;
        }
        ZLOrderInvoiceSubmitRequest zLOrderInvoiceSubmitRequest = new ZLOrderInvoiceSubmitRequest();
        zLOrderInvoiceSubmitRequest.orderId = str;
        zLOrderInvoiceSubmitRequest.typeId = str2;
        zLOrderInvoiceSubmitRequest.companyName = str3;
        zLOrderInvoiceSubmitRequest.companyTax = str4;
        zLOrderInvoiceSubmitRequest.transId = str5;
        zLOrderInvoiceSubmitRequest.name = str6;
        zLOrderInvoiceSubmitRequest.phone = str7;
        zLOrderInvoiceSubmitRequest.addrId = str8;
        zLOrderInvoiceSubmitRequest.payId = str9;
        zLOrderInvoiceSubmitRequest.request(new DMMtopResultRequestListener<InvoiceSubmitResult>(InvoiceSubmitResult.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str10, String str11) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1692249829")) {
                    ipChange2.ipc$dispatch("1692249829", new Object[]{this, str10, str11});
                } else {
                    ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).returnSubmitInvoiceError(str10, str11);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(InvoiceSubmitResult invoiceSubmitResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1095187100")) {
                    ipChange2.ipc$dispatch("-1095187100", new Object[]{this, invoiceSubmitResult});
                } else {
                    ((OrderInvoiceContract.View) OrderInvoicePresenter.this.mView).returnSubmitInvoiceInfo(invoiceSubmitResult);
                }
            }
        });
    }
}
