package cn.damai.category.categorygirl.ui;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.categorygirl.model.CategoryGirlModel;
import cn.damai.category.categorygirl.request.SearchListRequest;
import cn.damai.category.categorygirl.ui.adapter.GirlShowListAdapter;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;
import tb.o91;
import tb.og;
import tb.qd2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GirlShowAllActivity extends SimpleBaseActivity implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_CITYID = "cityId";
    public static final String KEY_GROUPID = "groupId";
    public static final String KEY_GROUPNAME = "groupName";
    private GirlShowListAdapter mAdapter;
    private View mEmptyFoot;
    private View mGoTopView;
    private boolean mIsRequesting;
    private LinearLayout mLayoutPage;
    private View mLineView;
    private LinearLayoutManager mLinearLayoutManager;
    private FrameLayout mListView;
    private CategoryGirlModel mModel;
    private IRecyclerView mRecyclerView;
    private SearchListRequest mRequest = new SearchListRequest();
    private boolean mIsFristPage = true;
    private boolean mHasNextPage = true;
    private Daojishi mDaojishi = new Daojishi();
    private int mTotal = 0;
    private int mTotalTemp = 0;
    private String mGroupId = "";
    private String mGroupName = "";
    private String mCityId = "";
    private View.OnClickListener mProjectItemListener = new c();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1918918038")) {
                ipChange.ipc$dispatch("1918918038", new Object[]{this, view});
            } else {
                GirlShowAllActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1846531480")) {
                ipChange.ipc$dispatch("1846531480", new Object[]{this, view});
            } else {
                GirlShowAllActivity.this.mRecyclerView.smoothScrollToPosition(0);
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
            if (AndroidInstantRuntime.support(ipChange, "1774144922")) {
                ipChange.ipc$dispatch("1774144922", new Object[]{this, view});
                return;
            }
            try {
                ProjectItemBean projectItemBean = (ProjectItemBean) view.getTag();
                if (projectItemBean == null) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
                bundle.putString("projectName", projectItemBean.name);
                bundle.putString("projectImage", projectItemBean.verticalPic);
                qd2.a(GirlShowAllActivity.this, projectItemBean.schema, bundle);
                cn.damai.common.user.c.e().x(og.g().h(projectItemBean.pos, z20.d(), GirlShowAllActivity.this.mGroupName, projectItemBean.id));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1953333277")) {
                ipChange.ipc$dispatch("-1953333277", new Object[]{this, Integer.valueOf(i)});
            } else {
                GirlShowAllActivity.this.request(true);
            }
        }
    }

    static /* synthetic */ int access$812(GirlShowAllActivity girlShowAllActivity, int i) {
        int i2 = girlShowAllActivity.mTotalTemp + i;
        girlShowAllActivity.mTotalTemp = i2;
        return i2;
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2095291878")) {
            ipChange.ipc$dispatch("2095291878", new Object[]{this});
        } else if (getIntent() != null) {
            this.mGroupId = getIntent().getStringExtra("groupId");
            this.mGroupName = getIntent().getStringExtra(KEY_GROUPNAME);
            String stringExtra = getIntent().getStringExtra("cityId");
            this.mCityId = stringExtra;
            this.mRequest.groupId = this.mGroupId;
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.mRequest.distanceCityId = this.mCityId;
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978703486")) {
            ipChange.ipc$dispatch("1978703486", new Object[]{this});
            return;
        }
        this.mModel = new CategoryGirlModel(this.mContext);
        request(true);
        this.mModel.getSearchListBean().observe(this, new Observer<SearchResultBean>() { // from class: cn.damai.category.categorygirl.ui.GirlShowAllActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable SearchResultBean searchResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-737096250")) {
                    ipChange2.ipc$dispatch("-737096250", new Object[]{this, searchResultBean});
                    return;
                }
                GirlShowAllActivity.this.mIsRequesting = false;
                GirlShowAllActivity.this.mRecyclerView.setRefreshing(false);
                GirlShowAllActivity.this.stopProgressDialog();
                GirlShowAllActivity.this.stopBottomProgress();
                if (GirlShowAllActivity.this.mIsFristPage) {
                    if (searchResultBean != null && !o91.a(searchResultBean.projectInfo)) {
                        GirlShowAllActivity.this.onResponseSuccess();
                        if (GirlShowAllActivity.this.mDaojishi.serverTime == 0) {
                            GirlShowAllActivity.this.mDaojishi.setServiceTimeAndDiff(searchResultBean.currentTime);
                        }
                        GirlShowAllActivity.this.mAdapter.b(searchResultBean.projectInfo, GirlShowAllActivity.this.mDaojishi);
                        GirlShowAllActivity.this.mTotal = searchResultBean.total;
                        GirlShowAllActivity.access$812(GirlShowAllActivity.this, searchResultBean.projectInfo.size());
                    } else {
                        GirlShowAllActivity.this.onResponseError("", "", "");
                        return;
                    }
                } else if (searchResultBean != null && !o91.a(searchResultBean.projectInfo)) {
                    GirlShowAllActivity.access$812(GirlShowAllActivity.this, searchResultBean.projectInfo.size());
                    GirlShowAllActivity.this.mAdapter.a(searchResultBean.projectInfo);
                }
                if (GirlShowAllActivity.this.mTotal == GirlShowAllActivity.this.mTotalTemp) {
                    GirlShowAllActivity.this.mHasNextPage = false;
                }
                GirlShowAllActivity.this.mDaojishi.startTimer();
                GirlShowAllActivity.this.mIsFristPage = false;
            }
        });
    }

    private void initList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717474058")) {
            ipChange.ipc$dispatch("717474058", new Object[]{this});
            return;
        }
        this.mLayoutPage = (LinearLayout) findViewById(R$id.layout_page);
        this.mListView = (FrameLayout) findViewById(R$id.layout_list);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.perform_irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        GirlShowListAdapter girlShowListAdapter = new GirlShowListAdapter(this, this.mProjectItemListener);
        this.mAdapter = girlShowListAdapter;
        this.mRecyclerView.setAdapter(girlShowListAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this, 100, false, R$color.color_ffffff));
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.category.categorygirl.ui.GirlShowAllActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1404935076")) {
                    ipChange2.ipc$dispatch("-1404935076", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (GirlShowAllActivity.this.mLinearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    GirlShowAllActivity.this.mLineView.setVisibility(8);
                } else {
                    GirlShowAllActivity.this.mLineView.setVisibility(0);
                }
            }
        });
        View inflate = LayoutInflater.from(this).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot = inflate;
        this.mRecyclerView.addFooterView(inflate);
        this.mEmptyFoot.setVisibility(8);
        View findViewById = findViewById(R$id.image_gotop);
        this.mGoTopView = findViewById;
        findViewById.setOnClickListener(new b());
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847496074")) {
            ipChange.ipc$dispatch("1847496074", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        findViewById(R$id.btn_left).setOnClickListener(new a());
        ((TextView) findViewById(R$id.tv_title)).setText(this.mGroupName);
        int i = R$id.view_line;
        this.mLineView = findViewById(i);
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            findViewById.setVisibility(8);
        }
        this.mLineView = findViewById(i);
    }

    private void reSetPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046305428")) {
            ipChange.ipc$dispatch("2046305428", new Object[]{this});
            return;
        }
        this.mRequest.pageIndex = 1;
        this.mIsFristPage = true;
        this.mHasNextPage = true;
        this.mTotalTemp = 0;
        this.mTotal = 0;
        this.mRecyclerView.scrollToPosition(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void request(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364266289")) {
            ipChange.ipc$dispatch("364266289", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mIsRequesting) {
        } else {
            if (z) {
                reSetPage();
            }
            this.mModel.searchRequest(this.mRequest);
            this.mIsRequesting = true;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-411535062") ? ((Integer) ipChange.ipc$dispatch("-411535062", new Object[]{this})).intValue() : R$layout.category_girl_showall_activity;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989736355")) {
            ipChange.ipc$dispatch("989736355", new Object[]{this});
            return;
        }
        initBundle();
        initTitle();
        initList();
        initData();
        setDamaiUTKeyBuilder(og.g().f(z20.d(), this.mGroupId));
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659102676")) {
            ipChange.ipc$dispatch("1659102676", new Object[]{this, view});
        } else if (this.mHasNextPage) {
            showBottomLoadMore();
            startProgressDialog();
            this.mRequest.pageIndex++;
            request(false);
        } else {
            showBottonEmpty();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "174411830")) {
            ipChange.ipc$dispatch("174411830", new Object[]{this});
        } else {
            request(true);
        }
    }

    protected void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78371160")) {
            ipChange.ipc$dispatch("-78371160", new Object[]{this, str, str2, str3});
            return;
        }
        this.mListView.setVisibility(8);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this, str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setRefreshListener(new d());
            this.mLayoutPage.addView(this.mErrorPage);
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798846161")) {
            ipChange.ipc$dispatch("-1798846161", new Object[]{this});
            return;
        }
        this.mListView.setVisibility(0);
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mLayoutPage.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425856542")) {
            return (String) ipChange.ipc$dispatch("425856542", new Object[]{this});
        }
        return null;
    }

    public void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673259531")) {
            ipChange.ipc$dispatch("-1673259531", new Object[]{this});
            return;
        }
        this.mEmptyFoot.setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    public void showBottonEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471190482")) {
            ipChange.ipc$dispatch("-1471190482", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot.setVisibility(0);
        this.mHasNextPage = false;
    }

    public void stopBottomProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804796798")) {
            ipChange.ipc$dispatch("804796798", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }
}
