package cn.damai.mine.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.adapter.CouponListNewAdapter;
import cn.damai.mine.bean.CouponData;
import cn.damai.mine.contract.CouponsListContract;
import cn.damai.mine.presenter.CouponsListPresenter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.dg1;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponFragment extends DamaiBaseMvpFragment<CouponsListPresenter, CouponsListContract.Model> implements CouponsListContract.View, OnRefreshListener, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int COUPON_LEFT = 0;
    public static int COUPON_MIDDLE = 1;
    public static int COUPON_RIGHT = 2;
    private static final int SIZE_PAGE = 10;
    private CouponListNewAdapter mAdapter;
    private int mCouponModel;
    private LinearLayout mEmptyPageLayout;
    private boolean mIsViewCreated;
    private boolean mIsViewDestroyed;
    private boolean mIsVisibleToUser;
    private int mPosition;
    private IRecyclerView mRecyclerView;
    private int mPageIndex = 1;
    private boolean hasNext = true;
    private List<CouponData.Coupon> mCouponList = new ArrayList();

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895931031")) {
            ipChange.ipc$dispatch("895931031", new Object[]{this});
            return;
        }
        int i = getArguments().getInt("position");
        this.mPosition = i;
        if (i == COUPON_LEFT) {
            this.mCouponModel = 1;
        } else if (i == COUPON_MIDDLE) {
            this.mCouponModel = 6;
        } else if (i == COUPON_RIGHT) {
            this.mCouponModel = 3;
        }
        this.mPageIndex = 1;
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322623090")) {
            ipChange.ipc$dispatch("1322623090", new Object[]{this});
            return;
        }
        this.mEmptyPageLayout = (LinearLayout) this.rootView.findViewById(R$id.ll_empty_page);
        ((TextView) this.rootView.findViewById(R$id.tv_null_tip)).setText("您暂时没有优惠券哦");
        this.mEmptyPageLayout.setVisibility(8);
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CouponListNewAdapter couponListNewAdapter = new CouponListNewAdapter(getActivity(), this.mPosition, this.mCouponList);
        this.mAdapter = couponListNewAdapter;
        this.mRecyclerView.setAdapter(couponListNewAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
    }

    private boolean isPageFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-479049879") ? ((Boolean) ipChange.ipc$dispatch("-479049879", new Object[]{this})).booleanValue() : getActivity() == null || getActivity().isFinishing() || isDetached();
    }

    private void loadCouponsList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-799294188")) {
            ipChange.ipc$dispatch("-799294188", new Object[]{this});
        } else if (this.mIsVisibleToUser && this.mIsViewCreated && !this.mIsViewDestroyed) {
            requestCouponsList();
        }
    }

    public static CouponFragment newInstance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858698108")) {
            return (CouponFragment) ipChange.ipc$dispatch("858698108", new Object[]{Integer.valueOf(i)});
        }
        CouponFragment couponFragment = new CouponFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("position", Integer.valueOf(i));
        couponFragment.setArguments(bundle);
        return couponFragment;
    }

    private void updateEmptyView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672310652")) {
            ipChange.ipc$dispatch("-672310652", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mEmptyPageLayout.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
        } else {
            this.mEmptyPageLayout.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-530673762") ? ((Integer) ipChange.ipc$dispatch("-530673762", new Object[]{this})).intValue() : R$layout.fragment_user_coupons;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1959308502")) {
            ipChange.ipc$dispatch("-1959308502", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestCouponsList();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761839681")) {
            ipChange.ipc$dispatch("761839681", new Object[]{this});
        } else {
            ((CouponsListPresenter) this.mPresenter).setVM(this, (CouponsListContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93036100")) {
            ipChange.ipc$dispatch("-93036100", new Object[]{this});
            return;
        }
        initData();
        initIRecycleView();
        this.mIsViewCreated = true;
        this.mIsViewDestroyed = false;
        loadCouponsList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091455650")) {
            ipChange.ipc$dispatch("2091455650", new Object[]{this, view});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991124569")) {
            ipChange.ipc$dispatch("991124569", new Object[]{this});
            return;
        }
        super.onDestroyView();
        this.mIsViewDestroyed = true;
        this.mIsViewCreated = false;
        this.mPageIndex = 1;
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445292891")) {
            ipChange.ipc$dispatch("1445292891", new Object[]{this, view});
        } else if (this.hasNext) {
            this.mPageIndex++;
            requestCouponsList();
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939237797")) {
            ipChange.ipc$dispatch("1939237797", new Object[]{this, str, str2, str3});
            return;
        }
        stopLoading();
        if (isPageFinish()) {
            return;
        }
        if (this.mPageIndex == 1) {
            onResponseError(str2, str, str3, this.rootView, true);
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = "网络不稳定 辛苦稍后重试";
            }
            ToastUtil.i(str2);
        }
        dg1.a(str, str2);
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240735060")) {
            ipChange.ipc$dispatch("-1240735060", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            onResponseSuccess(this.rootView);
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968204093")) {
            ipChange.ipc$dispatch("968204093", new Object[]{this});
            return;
        }
        this.mPageIndex = 1;
        requestCouponsList();
    }

    public void refreshRequestCouponsList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828707358")) {
            ipChange.ipc$dispatch("-828707358", new Object[]{this});
            return;
        }
        showLoading("");
        this.mPageIndex = 1;
        ((CouponsListPresenter) this.mPresenter).loadCouponsList(z20.E(), this.mCouponModel, true, this.mPageIndex, 10);
    }

    public void requestCouponsList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737258485")) {
            ipChange.ipc$dispatch("737258485", new Object[]{this});
            return;
        }
        showLoading("");
        ((CouponsListPresenter) this.mPresenter).loadCouponsList(z20.E(), this.mCouponModel, true, this.mPageIndex, 10);
    }

    @Override // cn.damai.mine.contract.CouponsListContract.View
    public void returnLoadCouponsList(CouponData.DiscountContainer discountContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321013875")) {
            ipChange.ipc$dispatch("321013875", new Object[]{this, discountContainer});
            return;
        }
        stopLoading();
        if (isPageFinish() || discountContainer == null) {
            return;
        }
        if (this.mPageIndex == 1) {
            if (wh2.e(discountContainer.coupons) == 0) {
                showEmptyView();
                return;
            } else {
                updateEmptyView(false);
                this.mCouponList.clear();
            }
        }
        this.mCouponList.addAll(discountContainer.coupons);
        CouponListNewAdapter couponListNewAdapter = this.mAdapter;
        if (couponListNewAdapter != null) {
            couponListNewAdapter.notifyDataSetChanged();
        }
        int e = wh2.e(discountContainer.coupons);
        if (e > 0) {
            if (e < 10) {
                this.hasNext = false;
            } else {
                this.hasNext = true;
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133436623")) {
            ipChange.ipc$dispatch("2133436623", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.mIsVisibleToUser = z;
        this.mIsViewDestroyed = false;
        loadCouponsList();
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465283196")) {
            ipChange.ipc$dispatch("-465283196", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            updateEmptyView(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479124160")) {
            ipChange.ipc$dispatch("-479124160", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318752036")) {
            ipChange.ipc$dispatch("1318752036", new Object[]{this, str});
        } else {
            startProgressDialog();
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IRecyclerView iRecyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961719649")) {
            ipChange.ipc$dispatch("-961719649", new Object[]{this});
            return;
        }
        if (this.mPageIndex == 1 && (iRecyclerView = this.mRecyclerView) != null) {
            iRecyclerView.setRefreshing(false);
        }
        stopProgressDialog();
    }
}
