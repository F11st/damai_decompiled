package cn.damai.search.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.artist.ArtistFollowResultBean;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.search.bean.SearchAccountBean;
import cn.damai.search.bean.SearchAccountResponse;
import cn.damai.search.bean.SearchFollowResponse;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.model.SearchAccountViewModel;
import cn.damai.search.ui.adapter.AccountMoreAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchAccountFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isLoadView;
    private boolean isUserVis;
    private AccountMoreAdapter mAdapter;
    private LinearLayout mEmptyPageLayout;
    private boolean mIsLoadFinish;
    private BaccountInfo mLoginBAccountBean;
    private IRecyclerView mRecyclerView;
    private long mShowTotalCount;
    private long mTotalCount;
    private SearchAccountViewModel viewModel;
    private List<BaccountInfo> mAccountData = new ArrayList();
    private Observer<Integer> pageChangeObserver = new Observer<Integer>() { // from class: cn.damai.search.ui.fragment.SearchAccountFragment.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2070379183")) {
                ipChange.ipc$dispatch("-2070379183", new Object[]{this, num});
            } else {
                SearchAccountFragment.this.loadData();
            }
        }
    };
    private Observer<SearchAccountResponse> feedsObserver = new Observer<SearchAccountResponse>() { // from class: cn.damai.search.ui.fragment.SearchAccountFragment.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable SearchAccountResponse searchAccountResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1968127233")) {
                ipChange.ipc$dispatch("1968127233", new Object[]{this, searchAccountResponse});
                return;
            }
            SearchAccountFragment.this.stopLoading();
            if (SearchAccountFragment.this.isPageFinish() || searchAccountResponse == null) {
                return;
            }
            if (searchAccountResponse.requestFail) {
                if (SearchAccountFragment.this.viewModel.getPageIndex().getValue().intValue() == 1) {
                    SearchAccountFragment searchAccountFragment = SearchAccountFragment.this;
                    String str = searchAccountResponse.errorMsg;
                    searchAccountFragment.onResponseError(str, str, "mtop.damai.wireless.search.baccount.search", ((BaseFragment) searchAccountFragment).rootView, true);
                    return;
                }
                if (TextUtils.isEmpty(searchAccountResponse.errorMsg)) {
                    searchAccountResponse.errorMsg = SearchAccountFragment.this.getResources().getString(R$string.message_network_error_tips);
                }
                ToastUtil.i(searchAccountResponse.errorMsg);
                return;
            }
            SearchAccountBean searchAccountBean = searchAccountResponse.data;
            if (searchAccountBean == null) {
                return;
            }
            SearchAccountFragment searchAccountFragment2 = SearchAccountFragment.this;
            searchAccountFragment2.onResponseSuccess(((BaseFragment) searchAccountFragment2).rootView);
            SearchAccountFragment.this.mTotalCount = searchAccountBean.total;
            int e = wh2.e(searchAccountBean.baccounts);
            if (SearchAccountFragment.this.viewModel.getPageIndex().getValue().intValue() == 1) {
                SearchAccountFragment.this.mShowTotalCount = 0L;
                SearchAccountFragment.this.mAccountData.clear();
                if (e == 0) {
                    if (SearchAccountFragment.this.mAdapter != null) {
                        SearchAccountFragment.this.mAdapter.notifyDataSetChanged();
                    }
                    SearchAccountFragment.this.showEmptyView(true);
                    return;
                }
                SearchAccountFragment.this.showEmptyView(false);
            }
            SearchAccountFragment.this.mShowTotalCount += e;
            SearchAccountFragment.this.mAccountData.addAll(searchAccountBean.baccounts);
            if (SearchAccountFragment.this.mAdapter != null) {
                SearchAccountFragment.this.mAdapter.notifyDataSetChanged();
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements Action<BaccountInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "103636200")) {
                ipChange.ipc$dispatch("103636200", new Object[]{this, baccountInfo});
            } else if (baccountInfo != null) {
                SearchAccountFragment.this.requestAccountFollow(baccountInfo);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements Action<ArtistFollowResultBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(ArtistFollowResultBean artistFollowResultBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1793009417")) {
                ipChange.ipc$dispatch("1793009417", new Object[]{this, artistFollowResultBean});
            } else if (artistFollowResultBean != null) {
                SearchAccountFragment.this.updateAccountFollowState(artistFollowResultBean);
            }
        }
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460666621")) {
            ipChange.ipc$dispatch("-460666621", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R$id.ll_empty_page);
        this.mEmptyPageLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AccountMoreAdapter accountMoreAdapter = new AccountMoreAdapter(getActivity(), this.mAccountData);
        this.mAdapter = accountMoreAdapter;
        this.mRecyclerView.setAdapter(accountMoreAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPageFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1693212794") ? ((Boolean) ipChange.ipc$dispatch("1693212794", new Object[]{this})).booleanValue() : getActivity() == null || getActivity().isFinishing() || isDetached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517510546")) {
            ipChange.ipc$dispatch("1517510546", new Object[]{this});
        } else if (isAdded() && this.isLoadView && this.isUserVis) {
            startProgressDialog();
            this.mIsLoadFinish = false;
            this.viewModel.getAccountData().observe(this, this.feedsObserver);
        }
    }

    public static SearchAccountFragment newInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305401293")) {
            return (SearchAccountFragment) ipChange.ipc$dispatch("-1305401293", new Object[]{str, str2});
        }
        SearchAccountFragment searchAccountFragment = new SearchAccountFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("keyword", str2);
        searchAccountFragment.setArguments(bundle);
        return searchAccountFragment;
    }

    private void rxManagerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334727155")) {
            ipChange.ipc$dispatch("-334727155", new Object[]{this});
            return;
        }
        this.mDMMessage.b(SearchHelper.ACCOUNT_MORE_ATTENTION, new a());
        this.mDMMessage.b("artist_follow_status", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccountState(BaccountInfo baccountInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190230124")) {
            ipChange.ipc$dispatch("-1190230124", new Object[]{this, baccountInfo, str});
            return;
        }
        if (baccountInfo != null) {
            baccountInfo.followStatus = str;
            try {
                int parseInt = Integer.parseInt(baccountInfo.fansCount);
                if (!str.equals("0")) {
                    parseInt++;
                } else if (parseInt > 0) {
                    parseInt--;
                }
                baccountInfo.fansCount = String.valueOf(parseInt);
            } catch (Exception unused) {
            }
        }
        AccountMoreAdapter accountMoreAdapter = this.mAdapter;
        if (accountMoreAdapter != null) {
            accountMoreAdapter.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "21920045") ? ((Integer) ipChange.ipc$dispatch("21920045", new Object[]{this})).intValue() : R$layout.search_baccount_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212954171")) {
            ipChange.ipc$dispatch("212954171", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.viewModel.getPageIndex().setValue(1);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617494192")) {
            ipChange.ipc$dispatch("-617494192", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933595827")) {
            ipChange.ipc$dispatch("-1933595827", new Object[]{this});
            return;
        }
        initIRecycleView();
        rxManagerListener();
        this.isLoadView = true;
        SearchAccountViewModel searchAccountViewModel = (SearchAccountViewModel) ViewModelProviders.of(this).get(SearchAccountViewModel.class);
        this.viewModel = searchAccountViewModel;
        searchAccountViewModel.initParam(getArguments());
        this.viewModel.getPageIndex().observe(this, this.pageChangeObserver);
        this.viewModel.getPageIndex().setValue(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "642068468")) {
            ipChange.ipc$dispatch("642068468", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1006 && LoginManager.k().q()) {
            requestFollow(this.mLoginBAccountBean);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167424499")) {
            ipChange.ipc$dispatch("1167424499", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78673514")) {
            ipChange.ipc$dispatch("78673514", new Object[]{this, view});
        } else if (!this.mIsLoadFinish || this.mShowTotalCount >= this.mTotalCount) {
        } else {
            this.viewModel.getPageIndex().setValue(Integer.valueOf(this.viewModel.getPageIndex().getValue().intValue() + 1));
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254572596")) {
            ipChange.ipc$dispatch("-254572596", new Object[]{this});
        } else if (isAdded()) {
            this.viewModel.getPageIndex().setValue(1);
        }
    }

    public void requestAccountFollow(BaccountInfo baccountInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1050516008")) {
            ipChange.ipc$dispatch("1050516008", new Object[]{this, baccountInfo});
        } else if (this.isUserVis && this.isLoadView) {
            if (!LoginManager.k().q()) {
                this.mLoginBAccountBean = baccountInfo;
                LoginManager.k().y(this, new Intent(), 1006);
                return;
            }
            requestFollow(baccountInfo);
        }
    }

    public void requestFollow(final BaccountInfo baccountInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237566947")) {
            ipChange.ipc$dispatch("-237566947", new Object[]{this, baccountInfo});
        } else if (baccountInfo == null || TextUtils.isEmpty(baccountInfo.type)) {
        } else {
            this.viewModel.getFollowState(baccountInfo.damaiId, baccountInfo.type).observe(this, new Observer<SearchFollowResponse>() { // from class: cn.damai.search.ui.fragment.SearchAccountFragment.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable SearchFollowResponse searchFollowResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1221147310")) {
                        ipChange2.ipc$dispatch("-1221147310", new Object[]{this, searchFollowResponse});
                    } else if (searchFollowResponse == null) {
                    } else {
                        if (searchFollowResponse.requestFail) {
                            if (TextUtils.isEmpty(searchFollowResponse.errorMsg)) {
                                return;
                            }
                            ToastUtil.i(searchFollowResponse.errorMsg);
                            return;
                        }
                        FollowDataBean followDataBean = searchFollowResponse.data;
                        if (followDataBean == null) {
                            return;
                        }
                        SearchAccountFragment.this.updateAccountState(baccountInfo, String.valueOf(followDataBean.getStatus()));
                        ArtistFollowResultBean artistFollowResultBean = new ArtistFollowResultBean();
                        artistFollowResultBean.setArtistId(baccountInfo.damaiId);
                        artistFollowResultBean.setFollowStatus(followDataBean.getStatus());
                        xr.c(SearchHelper.ACCOUNT_MORE_SEARCH_ATTENTION, artistFollowResultBean);
                    }
                }
            });
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600140446")) {
            ipChange.ipc$dispatch("600140446", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.isUserVis = z;
        SearchAccountViewModel searchAccountViewModel = this.viewModel;
        if (searchAccountViewModel == null || searchAccountViewModel.getPageIndex().getValue().intValue() == 1) {
            loadData();
        }
    }

    public void showEmptyView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348508511")) {
            ipChange.ipc$dispatch("-1348508511", new Object[]{this, Boolean.valueOf(z)});
        } else if (isPageFinish()) {
        } else {
            if (z) {
                this.mEmptyPageLayout.setVisibility(0);
                this.mRecyclerView.setVisibility(8);
                return;
            }
            this.mEmptyPageLayout.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
        }
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770921326")) {
            ipChange.ipc$dispatch("770921326", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            stopProgressDialog();
            if (this.viewModel.getPageIndex().getValue().intValue() == 1) {
                this.mRecyclerView.setRefreshing(false);
            }
            this.mIsLoadFinish = true;
        }
    }

    public void updateAccountFollowState(ArtistFollowResultBean artistFollowResultBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213018007")) {
            ipChange.ipc$dispatch("1213018007", new Object[]{this, artistFollowResultBean});
        } else if (artistFollowResultBean != null) {
            String artistId = artistFollowResultBean.getArtistId();
            if (TextUtils.isEmpty(artistId)) {
                return;
            }
            int i = SearchHelper.a;
            if (i < wh2.e(this.mAccountData) && (str = this.mAccountData.get(i).damaiId) != null && str.equals(artistId)) {
                updateAccountState(this.mAccountData.get(i), artistFollowResultBean.getFollowStatus() + "");
                return;
            }
            for (int i2 = 0; i2 < wh2.e(this.mAccountData); i2++) {
                if (this.mAccountData.get(i2).damaiId != null && this.mAccountData.get(i2).damaiId.equals(artistId)) {
                    updateAccountState(this.mAccountData.get(i2), artistFollowResultBean.getFollowStatus() + "");
                    return;
                }
            }
        }
    }
}
