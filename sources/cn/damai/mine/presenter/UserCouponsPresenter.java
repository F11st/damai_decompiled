package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.CouponApplyResultBean;
import cn.damai.mine.contract.UserCouponsContract;
import cn.damai.mine.net.CouponCodeExchangeRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class UserCouponsPresenter extends UserCouponsContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.UserCouponsContract.Presenter
    public void addCoupon(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677633612")) {
            ipChange.ipc$dispatch("-677633612", new Object[]{this, str, str2});
            return;
        }
        CouponCodeExchangeRequest couponCodeExchangeRequest = new CouponCodeExchangeRequest();
        couponCodeExchangeRequest.buyerId = str;
        couponCodeExchangeRequest.couponCode = str2;
        couponCodeExchangeRequest.request(new DMMtopRequestListener<CouponApplyResultBean.CouponApplyDataBean>(CouponApplyResultBean.CouponApplyDataBean.class) { // from class: cn.damai.mine.presenter.UserCouponsPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1076467353")) {
                    ipChange2.ipc$dispatch("-1076467353", new Object[]{this, str3, str4});
                } else {
                    ((UserCouponsContract.View) UserCouponsPresenter.this.mView).onReturnExchangeCouponError(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CouponApplyResultBean.CouponApplyDataBean couponApplyDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "167772656")) {
                    ipChange2.ipc$dispatch("167772656", new Object[]{this, couponApplyDataBean});
                } else {
                    ((UserCouponsContract.View) UserCouponsPresenter.this.mView).returnAddCoupon(couponApplyDataBean);
                }
            }
        });
    }
}
