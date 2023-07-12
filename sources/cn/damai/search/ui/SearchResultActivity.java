package cn.damai.search.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.contract.SearchResultContract;
import cn.damai.search.presenter.SearchResultPresenter;
import cn.damai.search.ui.adapter.SearchAdapter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ta.utdid2.device.UTDevice;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.List;
import tb.b82;
import tb.ja1;
import tb.kg2;
import tb.ms;
import tb.pl;
import tb.wh2;
import tb.y72;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchResultActivity extends DamaiBaseActivity<SearchResultPresenter, SearchResultContract.Model> implements SearchResultContract.View, OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SearchAdapter mAdapter;
    private TextView mCancelTv;
    private String mCityId;
    private DMIconFontTextView mDeleteLayout;
    private LinearLayout mErrorLayout;
    private String mHint;
    private EditText mInputEdit;
    private InputMethodManager mInputMethodManager;
    private LinearLayoutManager mLinearLayoutManager;
    private IRecyclerView mRecyclerView;
    private ImageView mTopIv;
    String mUtAAID;
    private List<SearchDataHolder> mDataHolderList = new ArrayList();
    private int mPageIndex = 1;
    private boolean isRequesting = false;
    private int mProjectSize = 0;
    private int mProjectAllSize = 0;
    private String mFavourableId = "";
    private String mFavourableTitle = "";
    private TextWatcher mEditTextWatch = new a();
    private TextView.OnEditorActionListener mKeySearchListener = new TextView.OnEditorActionListener() { // from class: cn.damai.search.ui.SearchResultActivity.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1785473237")) {
                return ((Boolean) ipChange.ipc$dispatch("1785473237", new Object[]{this, textView, Integer.valueOf(i), keyEvent})).booleanValue();
            }
            if (i == 3) {
                SearchResultActivity.this.InputMethodHide();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new b();
    private View.OnClickListener mItemClick = new c();
    private int mFirstVisibleItems = 0;
    private int mFirstVisibleItemCount = 0;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.search.ui.SearchResultActivity.5
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2049767694")) {
                ipChange.ipc$dispatch("2049767694", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            int findFirstVisibleItemPosition = SearchResultActivity.this.mLinearLayoutManager.findFirstVisibleItemPosition();
            if (SearchResultActivity.this.mFirstVisibleItems <= 0) {
                SearchResultActivity.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                SearchResultActivity searchResultActivity = SearchResultActivity.this;
                searchResultActivity.mFirstVisibleItemCount = searchResultActivity.mLinearLayoutManager.getChildCount();
            }
            if (findFirstVisibleItemPosition >= SearchResultActivity.this.mFirstVisibleItemCount) {
                if (SearchResultActivity.this.mTopIv.getVisibility() != 0) {
                    SearchResultActivity.this.mTopIv.setVisibility(0);
                }
            } else if (SearchResultActivity.this.mTopIv.getVisibility() != 8) {
                SearchResultActivity.this.mTopIv.setVisibility(8);
            }
        }
    };
    private View.OnTouchListener mTouchListener = new d();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1743733735")) {
                ipChange.ipc$dispatch("-1743733735", new Object[]{this, editable});
                return;
            }
            if (editable.length() > 0) {
                SearchResultActivity.this.mDeleteLayout.setVisibility(0);
            } else {
                SearchResultActivity.this.mDeleteLayout.setVisibility(8);
            }
            SearchResultActivity.this.mPageIndex = 1;
            SearchResultActivity.this.requestSearch();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-930895926")) {
                ipChange.ipc$dispatch("-930895926", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1480797846")) {
                ipChange.ipc$dispatch("-1480797846", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-263415168")) {
                ipChange.ipc$dispatch("-263415168", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.tv_cancel) {
                SearchResultActivity.this.InputMethodHide();
                SearchResultActivity.this.finish();
            } else if (id == R$id.ll_delete) {
                SearchResultActivity.this.mInputEdit.setText("");
                SearchResultActivity.this.InputMethodShow();
            } else if (id != R$id.iv_top || SearchResultActivity.this.isRequesting || SearchResultActivity.this.mRecyclerView == null) {
            } else {
                if (SearchResultActivity.this.mLinearLayoutManager.findFirstVisibleItemPosition() > 50) {
                    SearchResultActivity.this.mLinearLayoutManager.scrollToPosition(0);
                } else {
                    SearchResultActivity.this.mRecyclerView.smoothScrollToPosition(0);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchDataHolder searchDataHolder;
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1847875201")) {
                ipChange.ipc$dispatch("1847875201", new Object[]{this, view});
            } else if (view.getTag() == null) {
            } else {
                try {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (intValue < 0 || intValue >= SearchResultActivity.this.mAdapter.getItemCount() || (searchDataHolder = SearchResultActivity.this.mAdapter.getData().get(intValue)) == null || searchDataHolder.mType != 0 || (projectItemBean = searchDataHolder.mProjectItem) == null) {
                        return;
                    }
                    cn.damai.common.user.c e = cn.damai.common.user.c.e();
                    b82 C = b82.C();
                    SearchResultActivity searchResultActivity = SearchResultActivity.this;
                    e.x(C.t(searchResultActivity.mUtAAID, projectItemBean.id, searchResultActivity.getInput(), 0, projectItemBean.alg, intValue));
                    Bundle bundle = new Bundle();
                    bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
                    bundle.putString("projectName", projectItemBean.name);
                    bundle.putString("projectImage", projectItemBean.verticalPic);
                    bundle.putString("projectPrice", SearchResultActivity.this.getProjectPrice(projectItemBean.formattedPriceStr, projectItemBean.promotionPrice, projectItemBean.displayStatus));
                    DMNav.from(SearchResultActivity.this).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class d implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1423078765")) {
                return ((Boolean) ipChange.ipc$dispatch("-1423078765", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                SearchResultActivity.this.InputMethodHide();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InputMethodHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537297443")) {
            ipChange.ipc$dispatch("-537297443", new Object[]{this});
            return;
        }
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        }
        this.mInputMethodManager.hideSoftInputFromWindow(this.mInputEdit.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InputMethodShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617374274")) {
            ipChange.ipc$dispatch("617374274", new Object[]{this});
            return;
        }
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        }
        this.mInputMethodManager.showSoftInput(this.mInputEdit, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getInput() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-823565772") ? (String) ipChange.ipc$dispatch("-823565772", new Object[]{this}) : this.mInputEdit.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getProjectPrice(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251807778")) {
            return (String) ipChange.ipc$dispatch("-1251807778", new Object[]{this, str, str2, str3});
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                return String.format("%1$s%2$s", "¥", str2);
            }
            return String.format("%1$s%2$s", "¥", str);
        }
        return "";
    }

    private void hideEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990766298")) {
            ipChange.ipc$dispatch("1990766298", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.mErrorLayout.setVisibility(8);
    }

    private void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1959482945")) {
            ipChange.ipc$dispatch("-1959482945", new Object[]{this});
            return;
        }
        onResponseSuccess(this.mErrorLayout);
        if (this.mErrorLayout.getVisibility() == 0) {
            this.mErrorLayout.setVisibility(8);
        }
    }

    private void initEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356796448")) {
            ipChange.ipc$dispatch("1356796448", new Object[]{this});
            return;
        }
        this.mInputEdit.addTextChangedListener(this.mEditTextWatch);
        this.mInputEdit.setOnEditorActionListener(this.mKeySearchListener);
        this.mCancelTv.setOnClickListener(this.mOnClickListener);
        this.mDeleteLayout.setOnClickListener(this.mOnClickListener);
        this.mTopIv.setOnClickListener(this.mOnClickListener);
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129884737")) {
            ipChange.ipc$dispatch("2129884737", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        SearchAdapter searchAdapter = new SearchAdapter(this.mContext, this.mDataHolderList, null);
        this.mAdapter = searchAdapter;
        searchAdapter.b(this.mItemClick);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnTouchListener(this.mTouchListener);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this));
    }

    private void loadData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740363056")) {
            ipChange.ipc$dispatch("-1740363056", new Object[]{this});
            return;
        }
        this.mCityId = z20.c();
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.mFavourableId = extras.getString("favourableId", "");
            this.mFavourableTitle = extras.getString("favourableTag", "");
            String string = extras.getString("hint", "");
            this.mHint = string;
            this.mInputEdit.setHint(string);
        }
        loadSearchRequest();
    }

    private void loadSearchRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2126348119")) {
            ipChange.ipc$dispatch("-2126348119", new Object[]{this});
            return;
        }
        showLoading("");
        requestSearch();
    }

    private void loadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565637109")) {
            ipChange.ipc$dispatch("1565637109", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.layout_search_input);
        if (findViewById != null) {
            ms.a(this, findViewById, false);
        }
        this.mInputEdit = (EditText) findViewById(R$id.et_keyword);
        this.mCancelTv = (TextView) findViewById(R$id.tv_cancel);
        this.mDeleteLayout = (DMIconFontTextView) findViewById(R$id.ll_delete);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mTopIv = (ImageView) findViewById(R$id.iv_top);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_error);
        this.mErrorLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.mTopIv.setVisibility(8);
        this.mDeleteLayout.setVisibility(8);
        this.mDeleteLayout.setOnClickListener(this.mOnClickListener);
        this.mInputEdit.setFocusable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSearch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630843181")) {
            ipChange.ipc$dispatch("-1630843181", new Object[]{this});
            return;
        }
        String input = getInput();
        if (input == null) {
            input = "";
        }
        String str = input;
        double[] b2 = ja1.b();
        if (b2 != null) {
            ((SearchResultPresenter) this.mPresenter).getSearchList(str, this.mFavourableId, this.mPageIndex, String.valueOf(b2[0]), String.valueOf(b2[1]));
        } else {
            ((SearchResultPresenter) this.mPresenter).getSearchList(str, this.mFavourableId, this.mPageIndex, "", "");
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619878312")) {
            ipChange.ipc$dispatch("1619878312", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.search.contract.SearchResultContract.View
    public void error(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2006068007")) {
            ipChange.ipc$dispatch("-2006068007", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
        } else if (getInput().equals(str4)) {
            int i2 = this.mPageIndex;
            if (i2 <= 1) {
                onResponseError(str2, str, str3, this.mErrorLayout, true);
                this.mErrorLayout.setVisibility(0);
                return;
            }
            this.mPageIndex = i2 - 1;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2009769794") ? ((Integer) ipChange.ipc$dispatch("2009769794", new Object[]{this})).intValue() : R$layout.activity_search_result;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311322745")) {
            ipChange.ipc$dispatch("311322745", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPageIndex = 1;
        loadSearchRequest();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863035694")) {
            ipChange.ipc$dispatch("-1863035694", new Object[]{this});
        } else {
            ((SearchResultPresenter) this.mPresenter).setVM(this, (SearchResultContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896502133")) {
            ipChange.ipc$dispatch("-896502133", new Object[]{this});
            return;
        }
        loadView();
        initIRecycleView();
        initEvent();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495358001")) {
            ipChange.ipc$dispatch("-495358001", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        setDamaiUTKeyBuilder(b82.C().F(this.mFavourableTitle));
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675266028")) {
            ipChange.ipc$dispatch("675266028", new Object[]{this, view});
        } else if (this.mProjectAllSize > this.mProjectSize) {
            this.mPageIndex++;
            loadSearchRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431937770")) {
            ipChange.ipc$dispatch("1431937770", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        loadData();
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830560846")) {
            ipChange.ipc$dispatch("1830560846", new Object[]{this});
        } else {
            requestSearch();
        }
    }

    @Override // cn.damai.search.contract.SearchResultContract.View
    public void returnSearchList(SearchResultBean searchResultBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527985619")) {
            ipChange.ipc$dispatch("-1527985619", new Object[]{this, searchResultBean, str});
            return;
        }
        hideErrorView();
        if (str.equals(getInput())) {
            if (this.mPageIndex == 1) {
                this.mDataHolderList.clear();
                this.mProjectSize = 0;
                this.mProjectAllSize = 0;
                SearchDataHolder searchDataHolder = new SearchDataHolder(4);
                searchDataHolder.mTipType = 5;
                searchDataHolder.mArtistName = this.mFavourableTitle;
                this.mDataHolderList.add(searchDataHolder);
                this.mUtAAID = System.currentTimeMillis() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + UTDevice.getUtdid(this);
            }
            if (searchResultBean != null) {
                this.mProjectAllSize = searchResultBean.total;
                int e = wh2.e(searchResultBean.projectInfo);
                this.mProjectSize += e;
                for (int i = 0; i < e; i++) {
                    SearchDataHolder searchDataHolder2 = new SearchDataHolder(0);
                    searchDataHolder2.mProjectItem = searchResultBean.projectInfo.get(i);
                    searchDataHolder2.isRecommendProject = false;
                    this.mDataHolderList.add(searchDataHolder2);
                }
            }
            if (wh2.e(this.mDataHolderList) == 1) {
                showEmptyView();
            } else {
                hideEmptyView();
            }
            SearchAdapter searchAdapter = this.mAdapter;
            if (searchAdapter != null) {
                searchAdapter.a(str);
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948405194")) {
            return (String) ipChange.ipc$dispatch("-1948405194", new Object[]{this});
        }
        this.bese_head_view.setVisibility(8);
        return "";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204808725")) {
            ipChange.ipc$dispatch("1204808725", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(8);
        onResponseError(3, "暂无可使用当前优惠券的项目哦", "SUCCESS", y72.a, this.mErrorLayout, true);
        this.mErrorLayout.setVisibility(0);
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740564591")) {
            ipChange.ipc$dispatch("-1740564591", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548725173")) {
            ipChange.ipc$dispatch("548725173", new Object[]{this, str});
            return;
        }
        this.isRequesting = true;
        startProgressDialog();
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165568144")) {
            ipChange.ipc$dispatch("-1165568144", new Object[]{this});
            return;
        }
        this.isRequesting = false;
        stopProgressDialog();
        IRecyclerView iRecyclerView = this.mRecyclerView;
        if (iRecyclerView != null) {
            iRecyclerView.setRefreshing(false);
        }
    }
}
