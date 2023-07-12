package cn.damai.category.discountticket.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.category.discountticket.bean.biz.FirstPageData;
import cn.damai.category.discountticket.bean.biz.MorePageData;
import cn.damai.category.discountticket.contract.DiscountTicketContract;
import cn.damai.category.discountticket.model.BaseListener;
import cn.damai.category.discountticket.model.OnApplyCouponListener;
import cn.damai.category.discountticket.model.OnShareListener;
import cn.damai.category.discountticket.model.OnTListener;
import cn.damai.category.discountticket.ui.DiscountTicketActivity;
import cn.damai.category.discountticket.ui.OnErrorClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DiscountTicketPresenter extends DiscountTicketContract.DtPresenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements BaseListener<FirstPageData> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.category.discountticket.presenter.DiscountTicketPresenter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0021a implements OnErrorClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0021a() {
            }

            @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
            public void handleError(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-49686384")) {
                    ipChange.ipc$dispatch("-49686384", new Object[]{this, Integer.valueOf(i)});
                } else {
                    DiscountTicketPresenter.this.load(true);
                }
            }
        }

        a(boolean z) {
            this.a = z;
        }

        @Override // cn.damai.category.discountticket.model.BaseListener
        /* renamed from: a */
        public void onSuccess(FirstPageData firstPageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "511473899")) {
                ipChange.ipc$dispatch("511473899", new Object[]{this, firstPageData});
                return;
            }
            if (this.a) {
                ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showDialogLoading(false);
            }
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showFirstPage(firstPageData);
        }

        @Override // cn.damai.category.discountticket.model.BaseListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1193728607")) {
                ipChange.ipc$dispatch("-1193728607", new Object[]{this, str, str2});
                return;
            }
            if (this.a) {
                ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showDialogLoading(false);
            }
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showErrorView(str, str2, null, new C0021a());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements OnTListener<MorePageData> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.category.discountticket.model.OnTListener
        /* renamed from: a */
        public void callBack(MorePageData morePageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "45217208")) {
                ipChange.ipc$dispatch("45217208", new Object[]{this, morePageData});
            } else {
                ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showMorePage(morePageData);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements OnShareListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.category.discountticket.model.OnShareListener
        public void onShare(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2057977430")) {
                ipChange.ipc$dispatch("2057977430", new Object[]{this, bundle});
            } else {
                ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showShareView(bundle);
            }
        }

        @Override // cn.damai.category.discountticket.model.OnShareListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1789067243")) {
                ipChange.ipc$dispatch("-1789067243", new Object[]{this, Boolean.valueOf(z)});
            } else {
                ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showDialogLoading(z);
            }
        }

        @Override // cn.damai.category.discountticket.model.OnShareListener
        public void toast(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2021897279")) {
                ipChange.ipc$dispatch("-2021897279", new Object[]{this, str});
            } else {
                ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showErrorTip(str);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements OnApplyCouponListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HeaderCouponBean a;

        d(HeaderCouponBean headerCouponBean) {
            this.a = headerCouponBean;
        }

        @Override // cn.damai.category.discountticket.model.OnApplyCouponListener
        public void onApplyFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2077280764")) {
                ipChange.ipc$dispatch("-2077280764", new Object[]{this, str, str2});
                return;
            }
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showDialogLoading(false);
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showErrorTip(str2);
        }

        @Override // cn.damai.category.discountticket.model.OnApplyCouponListener
        public void onApplyResultFinish(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1340143352")) {
                ipChange.ipc$dispatch("-1340143352", new Object[]{this, str});
                return;
            }
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showDialogLoading(false);
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).showErrorTip(str);
            ((DiscountTicketContract.DtView) DiscountTicketPresenter.this.mView).updateRecyclerViewItem(this.a);
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtPresenter
    public void applyCoupon(HeaderCouponBean headerCouponBean, CouponActivityBean couponActivityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774402025")) {
            ipChange.ipc$dispatch("774402025", new Object[]{this, headerCouponBean, couponActivityBean});
            return;
        }
        ((DiscountTicketContract.DtView) this.mView).showDialogLoading(true);
        ((DiscountTicketContract.DtModel) this.mModel).applyCoupon(headerCouponBean, couponActivityBean, new d(headerCouponBean));
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtPresenter
    public void changeCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456418284")) {
            ipChange.ipc$dispatch("456418284", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && ((DiscountTicketContract.DtModel) this.mModel).changeCityId(str)) {
            load(true);
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtPresenter
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643364195")) {
            ipChange.ipc$dispatch("-1643364195", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            ((DiscountTicketContract.DtView) this.mView).showDialogLoading(true);
        }
        ((DiscountTicketContract.DtModel) this.mModel).load(new a(z));
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtPresenter
    public void loadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16487554")) {
            ipChange.ipc$dispatch("16487554", new Object[]{this});
        } else {
            ((DiscountTicketContract.DtModel) this.mModel).loadMore(new b());
        }
    }

    @Override // cn.damai.common.app.base.a
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46703310")) {
            ipChange.ipc$dispatch("-46703310", new Object[]{this});
            return;
        }
        M m = this.mModel;
        if (m != 0) {
            ((DiscountTicketContract.DtModel) m).destroy();
        }
        super.onDestroy();
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtPresenter
    public void openMoreActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351074289")) {
            ipChange.ipc$dispatch("-351074289", new Object[]{this});
            return;
        }
        HeaderData headerData = ((DiscountTicketContract.DtModel) this.mModel).getHeaderData();
        String cityId = ((DiscountTicketContract.DtModel) this.mModel).getCityId();
        Context context = this.mContext;
        if (!(context instanceof Activity) || headerData == null) {
            return;
        }
        DiscountTicketActivity.open((Activity) context, new DtParams(7, headerData, cityId));
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtPresenter
    public void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63513582")) {
            ipChange.ipc$dispatch("63513582", new Object[]{this});
        } else {
            ((DiscountTicketContract.DtModel) this.mModel).share(new c());
        }
    }
}
