package cn.damai.commonbusiness.seatbiz.promotion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.seatbiz.promotion.adapter.PromotionAdapter;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponActivityBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponApplyDataBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponListDataBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionGroupBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.Tip;
import cn.damai.commonbusiness.seatbiz.promotion.bean.UserProfitInfoBean;
import cn.damai.commonbusiness.seatbiz.promotion.request.CouponListRequest;
import cn.damai.commonbusiness.seatbiz.promotion.request.CouponReceiveRequest;
import cn.damai.commonbusiness.seatbiz.promotion.request.CreditsExchangeRequest;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.m91;
import tb.yw1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NcovPromotionFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private PromotionAdapter mAdapter;
    private Context mContext;
    private List<CouponActivityBean> mCouponActivityList;
    private CouponListDataBean mCouponListDataBean;
    private long mItemId;
    private OnConfirmClickListener mListener;
    private String mPageSource;
    private List<CouponActivityBean> mProfitActivityList;
    private List<PromotionGroupBean> mPromotionContentsBeanList;
    private String mPromotionRemark;
    private View mTopView;
    private UserProfitInfoBean mUserProfitInfoBean;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnConfirmClickListener {
        void onCloseClick();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-579754340")) {
                ipChange.ipc$dispatch("-579754340", new Object[]{this, view});
            } else if (NcovPromotionFragment.this.mListener != null) {
                NcovPromotionFragment.this.mListener.onCloseClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(NcovPromotionFragment ncovPromotionFragment) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1531536029")) {
                ipChange.ipc$dispatch("1531536029", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-652140898")) {
                ipChange.ipc$dispatch("-652140898", new Object[]{this, view});
            } else if (NcovPromotionFragment.this.mListener != null) {
                NcovPromotionFragment.this.mListener.onCloseClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements OnCouponApplyClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.OnCouponApplyClickListener
        public void onClick(CouponActivityBean couponActivityBean, int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "303830401")) {
                ipChange.ipc$dispatch("303830401", new Object[]{this, couponActivityBean, Integer.valueOf(i), str, str2, str3});
            } else {
                NcovPromotionFragment.this.applyCoupon(couponActivityBean, i, str, str2, str3);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.OnCouponApplyClickListener
        public void onIntegralConvertClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1258264685")) {
                ipChange.ipc$dispatch("-1258264685", new Object[]{this, Integer.valueOf(i), str, str2, str3});
            } else if (LoginManager.k().q()) {
                NcovPromotionFragment.this.applyCreditsExchange(str, str2, str3);
            } else {
                LoginManager.k().x(NcovPromotionFragment.this.getActivity(), new Intent(), 1000);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.OnCouponApplyClickListener
        public void refreshCouponRequest() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1465510848")) {
                ipChange.ipc$dispatch("-1465510848", new Object[]{this});
            } else {
                NcovPromotionFragment.this.getCouponRequest();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyCoupon(final CouponActivityBean couponActivityBean, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1118730470")) {
            ipChange.ipc$dispatch("1118730470", new Object[]{this, couponActivityBean, Integer.valueOf(i), str, str2, str3});
            return;
        }
        startProgressDialog();
        CouponReceiveRequest couponReceiveRequest = new CouponReceiveRequest();
        couponReceiveRequest.buyerId = z20.E();
        couponReceiveRequest.calcNextApplicable = "true";
        couponReceiveRequest.couponActSpreadId = str;
        couponReceiveRequest.asac = str3;
        couponReceiveRequest.useWua();
        couponReceiveRequest.request(new DMMtopRequestListener<CouponApplyDataBean>(CouponApplyDataBean.class) { // from class: cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "572715271")) {
                    ipChange2.ipc$dispatch("572715271", new Object[]{this, str4, str5});
                } else {
                    NcovPromotionFragment.this.stopProgressDialog();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CouponApplyDataBean couponApplyDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-884539156")) {
                    ipChange2.ipc$dispatch("-884539156", new Object[]{this, couponApplyDataBean});
                    return;
                }
                NcovPromotionFragment.this.stopProgressDialog();
                if (couponApplyDataBean != null) {
                    ToastUtil.a().j(NcovPromotionFragment.this.getActivity(), "领取成功");
                    if (!cb2.d(NcovPromotionFragment.this.mCouponActivityList)) {
                        Iterator it = NcovPromotionFragment.this.mCouponActivityList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CouponActivityBean couponActivityBean2 = (CouponActivityBean) it.next();
                            if (TextUtils.equals(couponActivityBean2.getId(), couponActivityBean.getId())) {
                                couponActivityBean2.setApplicable(couponApplyDataBean.getNextApplicable());
                                NcovPromotionFragment.this.updateCoupon();
                                break;
                            }
                        }
                    }
                    if (cb2.d(couponApplyDataBean.getSuccessCoupons())) {
                        return;
                    }
                    cn.damai.common.user.c.e().x(yw1.f().g(NcovPromotionFragment.this.mPageSource, NcovPromotionFragment.this.mItemId, couponApplyDataBean.getSuccessCoupons().get(0).id));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyCreditsExchange(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863240397")) {
            ipChange.ipc$dispatch("1863240397", new Object[]{this, str, str2, str3});
            return;
        }
        startProgressDialog();
        CreditsExchangeRequest creditsExchangeRequest = new CreditsExchangeRequest();
        creditsExchangeRequest.platform = "204";
        creditsExchangeRequest.asac = str3;
        creditsExchangeRequest.lotteryMixId = str;
        creditsExchangeRequest.exchange4Dm = str2;
        creditsExchangeRequest.request(new DMMtopRequestListener<CouponCreditsBean>(CouponCreditsBean.class) { // from class: cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "564955912")) {
                    ipChange2.ipc$dispatch("564955912", new Object[]{this, str4, str5});
                    return;
                }
                NcovPromotionFragment.this.stopProgressDialog();
                ToastUtil.i(str5);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CouponCreditsBean couponCreditsBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1693335703")) {
                    ipChange2.ipc$dispatch("-1693335703", new Object[]{this, couponCreditsBean});
                    return;
                }
                NcovPromotionFragment.this.stopProgressDialog();
                if (couponCreditsBean != null) {
                    ToastUtil.i(couponCreditsBean.getReturnMsg());
                    NcovPromotionFragment.this.getCouponRequest();
                    return;
                }
                ToastUtil.i("小二很忙，请稍后再试");
            }
        });
    }

    public static NcovPromotionFragment instance(PromotionDataBean promotionDataBean, OnConfirmClickListener onConfirmClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163781093")) {
            return (NcovPromotionFragment) ipChange.ipc$dispatch("163781093", new Object[]{promotionDataBean, onConfirmClickListener});
        }
        NcovPromotionFragment ncovPromotionFragment = new NcovPromotionFragment();
        if (promotionDataBean != null) {
            ncovPromotionFragment.mPageSource = promotionDataBean.pageSource;
            ncovPromotionFragment.mItemId = promotionDataBean.itemId;
            ncovPromotionFragment.mPromotionContentsBeanList = promotionDataBean.promotionContentsBeanListNew;
            ncovPromotionFragment.mPromotionRemark = promotionDataBean.promotionRemark;
            ncovPromotionFragment.mCouponListDataBean = promotionDataBean.couponListDataBean;
        }
        ncovPromotionFragment.mListener = onConfirmClickListener;
        return ncovPromotionFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCoupon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002485871")) {
            ipChange.ipc$dispatch("1002485871", new Object[]{this});
            return;
        }
        this.mAdapter.e(this.mUserProfitInfoBean);
        this.mAdapter.b(this.mCouponActivityList, this.mProfitActivityList, this.mPromotionContentsBeanList, new Tip(this.mPromotionRemark));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePromotion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595944174")) {
            ipChange.ipc$dispatch("-595944174", new Object[]{this});
        } else {
            this.mAdapter.d(this.mPromotionContentsBeanList, new Tip(this.mPromotionRemark));
        }
    }

    public void getCouponRequest() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1042806805")) {
            ipChange.ipc$dispatch("-1042806805", new Object[]{this});
            return;
        }
        startProgressDialog();
        CouponListDataBean couponListDataBean = this.mCouponListDataBean;
        if (couponListDataBean == null) {
            CouponListRequest couponListRequest = new CouponListRequest();
            couponListRequest.itemId = this.mItemId + "";
            couponListRequest.userId = z20.E();
            couponListRequest.request(new DMMtopRequestListener<CouponListDataBean>(CouponListDataBean.class) { // from class: cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "580474630")) {
                        ipChange2.ipc$dispatch("580474630", new Object[]{this, str, str2});
                        return;
                    }
                    NcovPromotionFragment.this.stopProgressDialog();
                    NcovPromotionFragment.this.updatePromotion();
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CouponListDataBean couponListDataBean2) {
                    IpChange ipChange2 = $ipChange;
                    boolean z3 = false;
                    boolean z4 = true;
                    if (AndroidInstantRuntime.support(ipChange2, "-2095122397")) {
                        ipChange2.ipc$dispatch("-2095122397", new Object[]{this, couponListDataBean2});
                        return;
                    }
                    NcovPromotionFragment.this.stopProgressDialog();
                    if (couponListDataBean2 != null) {
                        if (!m91.a(couponListDataBean2.getCouponActivities())) {
                            NcovPromotionFragment.this.mCouponActivityList = couponListDataBean2.getCouponActivities();
                            z3 = true;
                        }
                        if (m91.a(couponListDataBean2.getPerformProfitActivities())) {
                            z4 = z3;
                        } else {
                            NcovPromotionFragment.this.mProfitActivityList = couponListDataBean2.getPerformProfitActivities();
                            NcovPromotionFragment.this.mUserProfitInfoBean = couponListDataBean2.getUserProfitInfo();
                            NcovPromotionFragment.this.mUserProfitInfoBean.isNeedAuthorizeProfit = couponListDataBean2.isNeedAuthorizeProfit();
                            NcovPromotionFragment.this.mUserProfitInfoBean.authorizeProfitText = couponListDataBean2.getAuthorizeProfitText();
                        }
                        if (z4) {
                            NcovPromotionFragment.this.updateCoupon();
                        }
                    }
                }
            });
        } else if (couponListDataBean != null) {
            if (!m91.a(couponListDataBean.getCouponActivities())) {
                this.mCouponActivityList = this.mCouponListDataBean.getCouponActivities();
                z = true;
            }
            if (m91.a(this.mCouponListDataBean.getPerformProfitActivities())) {
                z2 = z;
            } else {
                this.mProfitActivityList = this.mCouponListDataBean.getPerformProfitActivities();
                UserProfitInfoBean userProfitInfo = this.mCouponListDataBean.getUserProfitInfo();
                this.mUserProfitInfoBean = userProfitInfo;
                userProfitInfo.isNeedAuthorizeProfit = this.mCouponListDataBean.isNeedAuthorizeProfit();
                this.mUserProfitInfoBean.authorizeProfitText = this.mCouponListDataBean.getAuthorizeProfitText();
            }
            if (z2) {
                updateCoupon();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1225807441") ? ((Integer) ipChange.ipc$dispatch("1225807441", new Object[]{this})).intValue() : R$layout.fragment_sku_ncov_promotion;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260380521")) {
            ipChange.ipc$dispatch("-260380521", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888999540")) {
            ipChange.ipc$dispatch("1888999540", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175262295")) {
            ipChange.ipc$dispatch("-175262295", new Object[]{this});
            return;
        }
        this.mContext = getContext();
        View findViewById = this.rootView.findViewById(R$id.view_top);
        this.mTopView = findViewById;
        findViewById.setOnClickListener(new a());
        this.rootView.findViewById(R$id.layout_null).setOnClickListener(new b(this));
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R$id.fg_promotion_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.rootView.findViewById(R$id.desc_close).setOnClickListener(new c());
        PromotionAdapter promotionAdapter = new PromotionAdapter(this.mContext, new d());
        this.mAdapter = promotionAdapter;
        promotionAdapter.c(this.mPageSource, String.valueOf(this.mItemId));
        recyclerView.setAdapter(this.mAdapter);
        updateCoupon();
        getCouponRequest();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554183326")) {
            ipChange.ipc$dispatch("-1554183326", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        HashMap hashMap = new HashMap();
        a.b bVar = new a.b();
        bVar.d(String.valueOf(this.mItemId)).i(this.mPageSource).j(hashMap);
        cn.damai.common.user.c.e().p(this, bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403691697")) {
            ipChange.ipc$dispatch("-403691697", new Object[]{this, view});
        }
    }
}
