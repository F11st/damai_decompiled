package cn.damai.category.category.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.BrandBaseBean;
import cn.damai.category.category.bean.BrandBean;
import cn.damai.category.category.bean.CategoryBrandBean;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.model.CategoryModel;
import cn.damai.category.category.request.BrandRequest;
import cn.damai.category.category.ui.adapter.BrandListAdapter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cs;
import tb.dh;
import tb.kd;
import tb.o91;
import tb.qd2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BrandFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity mActivity;
    private BrandListAdapter mAdapter;
    private FrameLayout mBrandLayout;
    private View mEmptyFoot;
    private View mEmptyView;
    private ResponseErrorPage mErrorPage;
    private int mFirstVisibleItemCount;
    private View mGoTopView;
    private View mLineView;
    private LinearLayoutManager mLinearLayoutManager;
    private CategoryModel mModel;
    private View mPageLayout;
    private IRecyclerView mRecyclerView;
    private View mView;
    private int mFirstVisibleItems = -1;
    private int mFollowIndex = 0;
    private boolean mHasNextPage = true;
    private boolean mIsFirst = true;
    private BrandRequest mBrandRequest = new BrandRequest();
    private View.OnClickListener mBrandItemListener = new View$OnClickListenerC0320b();
    private View.OnClickListener mProjectItemListener = new View$OnClickListenerC0321c();
    private View.OnClickListener mFollowListener = new View$OnClickListenerC0322d();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.BrandFragment$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0319a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0319a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2028047278")) {
                ipChange.ipc$dispatch("-2028047278", new Object[]{this, view});
            } else {
                BrandFragment.this.mRecyclerView.smoothScrollToPosition(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.BrandFragment$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0320b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0320b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2100433836")) {
                ipChange.ipc$dispatch("-2100433836", new Object[]{this, view});
                return;
            }
            try {
                StarAndBrandItem starAndBrandItem = (StarAndBrandItem) view.getTag();
                if (starAndBrandItem == null || starAndBrandItem.starBean == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(FeedsViewModel.ARG_USERID, starAndBrandItem.starBean.damaiId);
                bundle.putString("usertype", "4");
                DMNav.from(BrandFragment.this.mActivity).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
                kd.f(starAndBrandItem.index, starAndBrandItem.starBean.damaiId);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.BrandFragment$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0321c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0321c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "10856533")) {
                ipChange.ipc$dispatch("10856533", new Object[]{this, view});
                return;
            }
            try {
                BrandBean brandBean = (BrandBean) view.getTag();
                if (brandBean == null) {
                    return;
                }
                kd.h(brandBean.cardIndex, brandBean.position, brandBean.id);
                qd2.b(BrandFragment.this.mActivity, brandBean.schema, brandBean.id, brandBean.name, brandBean.verticalPic);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.BrandFragment$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0322d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0322d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2122146902")) {
                ipChange.ipc$dispatch("2122146902", new Object[]{this, view});
                return;
            }
            try {
                StarAndBrandItem starAndBrandItem = (StarAndBrandItem) view.getTag();
                if (starAndBrandItem == null || starAndBrandItem.starBean == null) {
                    return;
                }
                BrandFragment.this.mFollowIndex = starAndBrandItem.position;
                BrandFragment.this.mActivity.startProgressDialog();
                CategoryModel categoryModel = BrandFragment.this.mModel;
                String str = starAndBrandItem.starBean.damaiId;
                categoryModel.followRequest("1", str, starAndBrandItem.starBean.type + "");
                kd.g(starAndBrandItem.index, starAndBrandItem.starBean.damaiId, "1");
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.BrandFragment$e */
    /* loaded from: classes.dex */
    public class C0323e implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0323e() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1077515041")) {
                ipChange.ipc$dispatch("1077515041", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            BrandFragment.this.mActivity.startProgressDialog();
            BrandFragment.this.getRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<StarAndBrandItem> getAllList(CategoryBrandBean categoryBrandBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370278502")) {
            return (List) ipChange.ipc$dispatch("370278502", new Object[]{this, categoryBrandBean});
        }
        List<BrandBaseBean> list = categoryBrandBean.combines;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            BrandBaseBean brandBaseBean = list.get(i);
            if (brandBaseBean != null) {
                if (brandBaseBean.artistVO != null) {
                    StarAndBrandItem starAndBrandItem = new StarAndBrandItem();
                    starAndBrandItem.index = i;
                    starAndBrandItem.starBean = brandBaseBean.artistVO;
                    starAndBrandItem.type = 2;
                    arrayList.add(starAndBrandItem);
                }
                if (!o91.a(brandBaseBean.performanceInfo)) {
                    StarAndBrandItem starAndBrandItem2 = new StarAndBrandItem();
                    starAndBrandItem2.index = i;
                    starAndBrandItem2.type = 8;
                    List<BrandBean> list2 = brandBaseBean.performanceInfo;
                    starAndBrandItem2.brandList = list2;
                    if (list2.size() > 4) {
                        BrandBean brandBean = new BrandBean();
                        brandBean.viewType = 9;
                        starAndBrandItem2.starBean = brandBaseBean.artistVO;
                        starAndBrandItem2.brandList.add(brandBean);
                    }
                    arrayList.add(starAndBrandItem2);
                }
            }
        }
        return arrayList;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345874746")) {
            ipChange.ipc$dispatch("1345874746", new Object[]{this});
            return;
        }
        this.mModel = new CategoryModel(this.mActivity);
        getRequest();
        this.mModel.getCategoryBrandBean().observe(this, new Observer<CategoryBrandBean>() { // from class: cn.damai.category.category.ui.BrandFragment.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CategoryBrandBean categoryBrandBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1486250269")) {
                    ipChange2.ipc$dispatch("1486250269", new Object[]{this, categoryBrandBean});
                    return;
                }
                BrandFragment.this.mActivity.stopProgressDialog();
                BrandFragment.this.mRecyclerView.setRefreshing(false);
                BrandFragment.this.stopBottomProgress();
                if (categoryBrandBean == null) {
                    if (BrandFragment.this.mBrandRequest != null) {
                        dh.a(JSON.toJSONString(BrandFragment.this.mBrandRequest));
                    }
                    BrandFragment.this.onResponseError();
                    return;
                }
                BrandFragment.this.onResponseSuccess();
                BrandFragment.this.mHasNextPage = categoryBrandBean.hasNext;
                if (BrandFragment.this.mIsFirst) {
                    if (o91.a(categoryBrandBean.combines)) {
                        BrandFragment.this.mEmptyView.setVisibility(0);
                        BrandFragment.this.mAdapter.setData(null);
                        return;
                    }
                    BrandFragment.this.mAdapter.setData(BrandFragment.this.getAllList(categoryBrandBean));
                    BrandFragment.this.mIsFirst = false;
                } else if (!o91.a(categoryBrandBean.combines)) {
                    BrandFragment.this.mAdapter.a(BrandFragment.this.getAllList(categoryBrandBean));
                }
                BrandFragment.this.mEmptyView.setVisibility(8);
            }
        });
        this.mModel.getFollowDataBean().observe(this, new Observer<FollowDataBean>() { // from class: cn.damai.category.category.ui.BrandFragment.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-826956911")) {
                    ipChange2.ipc$dispatch("-826956911", new Object[]{this, followDataBean});
                    return;
                }
                BrandFragment.this.mActivity.stopProgressDialog();
                if (followDataBean != null && followDataBean.getStatus() == 1) {
                    ToastUtil.f("关注成功");
                    BrandFragment.this.mAdapter.b(BrandFragment.this.mFollowIndex);
                    return;
                }
                ToastUtil.f("关注失败");
            }
        });
    }

    private void resetPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909986104")) {
            ipChange.ipc$dispatch("1909986104", new Object[]{this});
            return;
        }
        this.mBrandRequest.pageNumber = 1;
        this.mIsFirst = true;
        this.mHasNextPage = true;
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2036662693") ? ((Integer) ipChange.ipc$dispatch("-2036662693", new Object[]{this})).intValue() : R$layout.category_brand_fragment;
    }

    public void getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797352549")) {
            ipChange.ipc$dispatch("-797352549", new Object[]{this});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.mActivity;
        if (damaiBaseActivity != null) {
            damaiBaseActivity.startProgressDialog();
        }
        if (this.mModel == null) {
            this.mModel = new CategoryModel(this.mActivity);
        }
        this.mModel.getBrandRequest(this.mBrandRequest);
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014358605")) {
            ipChange.ipc$dispatch("1014358605", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543760514")) {
            ipChange.ipc$dispatch("-1543760514", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356907615")) {
            ipChange.ipc$dispatch("356907615", new Object[]{this});
            return;
        }
        this.mBrandLayout = (FrameLayout) this.rootView.findViewById(R$id.layout_brand);
        this.mPageLayout = this.rootView.findViewById(R$id.layout_page);
        this.mEmptyView = this.rootView.findViewById(R$id.ll_empty);
        View findViewById = this.rootView.findViewById(R$id.image_gotop);
        this.mGoTopView = findViewById;
        findViewById.setOnClickListener(new View$OnClickListenerC0319a());
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.brand_irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        BrandListAdapter brandListAdapter = new BrandListAdapter(this.mActivity, this.mBrandItemListener, this.mFollowListener, this.mProjectItemListener);
        this.mAdapter = brandListAdapter;
        this.mRecyclerView.setAdapter(brandListAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this.mActivity, 100, false, R$color.color_ffffff));
        this.mEmptyFoot = LayoutInflater.from(this.mActivity).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(this.mActivity, 110.0f)));
        this.mEmptyFoot.setVisibility(8);
        this.mRecyclerView.addFooterView(this.mEmptyFoot);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.category.category.ui.BrandFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-841869536")) {
                    ipChange2.ipc$dispatch("-841869536", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                int findFirstVisibleItemPosition = BrandFragment.this.mLinearLayoutManager.findFirstVisibleItemPosition();
                if (BrandFragment.this.mFirstVisibleItems < 0) {
                    BrandFragment.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                    BrandFragment brandFragment = BrandFragment.this;
                    brandFragment.mFirstVisibleItemCount = brandFragment.mLinearLayoutManager.getChildCount();
                }
                if (findFirstVisibleItemPosition >= BrandFragment.this.mFirstVisibleItemCount) {
                    BrandFragment.this.mGoTopView.setVisibility(0);
                } else {
                    BrandFragment.this.mGoTopView.setVisibility(8);
                }
                if (BrandFragment.this.mLinearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    BrandFragment.this.mLineView.setVisibility(8);
                } else {
                    BrandFragment.this.mLineView.setVisibility(0);
                }
            }
        });
        this.mLineView = this.rootView.findViewById(R$id.view_line);
        initData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46197381")) {
            ipChange.ipc$dispatch("46197381", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572749527")) {
            return (View) ipChange.ipc$dispatch("-572749527", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mActivity = (DamaiBaseActivity) getActivity();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        return onCreateView;
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-437737832")) {
            ipChange.ipc$dispatch("-437737832", new Object[]{this, view});
        } else if (this.mHasNextPage) {
            showBottomLoadMore();
            this.mBrandRequest.pageNumber++;
            getRequest();
        } else {
            showBottonEmpty();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031557370")) {
            ipChange.ipc$dispatch("2031557370", new Object[]{this});
            return;
        }
        resetPage();
        getRequest();
    }

    protected void onResponseError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662280178")) {
            ipChange.ipc$dispatch("-662280178", new Object[]{this});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this.mActivity, null, null, null);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setRefreshListener(new C0323e());
            this.mBrandLayout.addView(this.mErrorPage);
            this.mPageLayout.setVisibility(8);
        }
    }

    protected void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182044147")) {
            ipChange.ipc$dispatch("1182044147", new Object[]{this});
            return;
        }
        try {
            if (this.mErrorPage != null) {
                this.mPageLayout.setVisibility(0);
                this.mErrorPage.setVisibility(8);
                this.mBrandLayout.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540026801")) {
            ipChange.ipc$dispatch("540026801", new Object[]{this});
            return;
        }
        this.mEmptyFoot.setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    public void showBottonEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186524686")) {
            ipChange.ipc$dispatch("-1186524686", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot.setVisibility(0);
        this.mHasNextPage = false;
    }

    public void stopBottomProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276884166")) {
            ipChange.ipc$dispatch("-1276884166", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }
}
