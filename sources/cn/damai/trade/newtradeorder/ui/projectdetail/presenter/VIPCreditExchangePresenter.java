package cn.damai.trade.newtradeorder.ui.projectdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import cn.damai.commonbusiness.seatbiz.promotion.request.CreditsExchangeRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class VIPCreditExchangePresenter extends VIPCreditExchangeContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract.Presenter
    public void requestExchange(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901827072")) {
            ipChange.ipc$dispatch("-901827072", new Object[]{this, str, str2, str3, str4});
            return;
        }
        CreditsExchangeRequest creditsExchangeRequest = new CreditsExchangeRequest();
        creditsExchangeRequest.exchange4Dm = str;
        creditsExchangeRequest.lotteryMixId = str2;
        creditsExchangeRequest.platform = str3;
        creditsExchangeRequest.asac = str4;
        creditsExchangeRequest.request(new DMMtopRequestListener<CouponCreditsBean>(CouponCreditsBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.presenter.VIPCreditExchangePresenter$requestExchange$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(@Nullable String str5, @Nullable String str6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "706854834")) {
                    ipChange2.ipc$dispatch("706854834", new Object[]{this, str5, str6});
                    return;
                }
                VIPCreditExchangeContract.View view = (VIPCreditExchangeContract.View) VIPCreditExchangePresenter.this.mView;
                if (view != null) {
                    view.exchangeFail(str5, str6);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(@Nullable CouponCreditsBean couponCreditsBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1076578303")) {
                    ipChange2.ipc$dispatch("1076578303", new Object[]{this, couponCreditsBean});
                } else if (couponCreditsBean != null && couponCreditsBean.isSuccess()) {
                    VIPCreditExchangeContract.View view = (VIPCreditExchangeContract.View) VIPCreditExchangePresenter.this.mView;
                    if (view != null) {
                        view.exchangeSuccess(couponCreditsBean);
                    }
                } else {
                    VIPCreditExchangeContract.View view2 = (VIPCreditExchangeContract.View) VIPCreditExchangePresenter.this.mView;
                    if (view2 != null) {
                        view2.exchangeFail("0", "啊哦，兑换失败了~");
                    }
                }
            }
        });
    }
}
