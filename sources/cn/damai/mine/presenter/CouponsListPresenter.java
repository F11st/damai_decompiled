package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.CouponData;
import cn.damai.mine.contract.CouponsListContract;
import cn.damai.mine.net.CouponListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponsListPresenter extends CouponsListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.CouponsListContract.Presenter
    public void loadCouponsList(String str, int i, boolean z, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178815398")) {
            ipChange.ipc$dispatch("178815398", new Object[]{this, str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        CouponListRequest couponListRequest = new CouponListRequest();
        couponListRequest.buyerId = z20.E();
        couponListRequest.couponStatus = i;
        couponListRequest.onlyDmSeller = z;
        couponListRequest.pageIndex = i2;
        couponListRequest.pageSize = i3;
        couponListRequest.request(new DMMtopRequestListener<CouponData.DiscountContainer>(CouponData.DiscountContainer.class) { // from class: cn.damai.mine.presenter.CouponsListPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-260388034")) {
                    ipChange2.ipc$dispatch("-260388034", new Object[]{this, str2, str3});
                } else {
                    ((CouponsListContract.View) CouponsListPresenter.this.mView).onNetError(str2, str3, "mtop.damai.wireless.mkt.coupon.queryCouponsOfUser");
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CouponData.DiscountContainer discountContainer) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-782673640")) {
                    ipChange2.ipc$dispatch("-782673640", new Object[]{this, discountContainer});
                    return;
                }
                ((CouponsListContract.View) CouponsListPresenter.this.mView).onNetSuccess();
                ((CouponsListContract.View) CouponsListPresenter.this.mView).returnLoadCouponsList(discountContainer);
            }
        });
    }
}
