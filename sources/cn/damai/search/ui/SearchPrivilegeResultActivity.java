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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.search.bean.ResultBean;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.SearchPrivilegeRecommendBean;
import cn.damai.search.model.SearchPrivilegeModel;
import cn.damai.search.model.SearchPrivilegeRequest;
import cn.damai.search.ui.adapter.SearchAdapter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.b82;
import tb.cb2;
import tb.kg2;
import tb.ms;
import tb.wh2;
import tb.y72;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchPrivilegeResultActivity extends DamaiBaseActivity implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SearchAdapter mAdapter;
    private SearchAdapter mAdapterTheme;
    private TextView mCancelTv;
    private DMIconFontTextView mDeleteLayout;
    private LinearLayout mErrorLayout;
    private String mHint;
    private EditText mInputEdit;
    private InputMethodManager mInputMethodManager;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayoutManager mLinearLayoutManagerTheme;
    private IRecyclerView mRecyclerView;
    private ImageView mTopIv;
    private IRecyclerView themeEvaluateIrc;
    private DMIconFontTextView titleClose;
    private List<SearchDataHolder> mDataHolderList = new ArrayList();
    private List<SearchDataHolder> mThemeEvaDataHolderList = new ArrayList();
    private boolean isRequesting = false;
    private String themeId = null;
    private SearchPrivilegeModel mModel = new SearchPrivilegeModel();
    private boolean hasNextPage = false;
    private boolean isLoadingMore = false;
    String tipDesc = "";
    private TextWatcher mEditTextWatch = new C1599b();
    private TextView.OnEditorActionListener mKeySearchListener = new TextView.OnEditorActionListener() { // from class: cn.damai.search.ui.SearchPrivilegeResultActivity.4
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1333937256")) {
                return ((Boolean) ipChange.ipc$dispatch("-1333937256", new Object[]{this, textView, Integer.valueOf(i), keyEvent})).booleanValue();
            }
            if (i == 3) {
                SearchPrivilegeResultActivity.this.InputMethodHide();
                SearchPrivilegeResultActivity.this.requestSearchV2(true, true);
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View$OnClickListenerC1600c();
    private View.OnClickListener mItemClick = new View$OnClickListenerC1601d();
    private View.OnClickListener mThemeEvaItemClick = new View$OnClickListenerC1602e();
    private int mFirstVisibleItems = 0;
    private int mFirstVisibleItemCount = 0;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.search.ui.SearchPrivilegeResultActivity.8
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-646352404")) {
                ipChange.ipc$dispatch("-646352404", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            int findFirstVisibleItemPosition = SearchPrivilegeResultActivity.this.mLinearLayoutManager.findFirstVisibleItemPosition();
            if (SearchPrivilegeResultActivity.this.mFirstVisibleItems <= 0) {
                SearchPrivilegeResultActivity.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                SearchPrivilegeResultActivity searchPrivilegeResultActivity = SearchPrivilegeResultActivity.this;
                searchPrivilegeResultActivity.mFirstVisibleItemCount = searchPrivilegeResultActivity.mLinearLayoutManager.getChildCount();
            }
            if (findFirstVisibleItemPosition >= SearchPrivilegeResultActivity.this.mFirstVisibleItemCount) {
                if (SearchPrivilegeResultActivity.this.mTopIv.getVisibility() != 0) {
                    SearchPrivilegeResultActivity.this.mTopIv.setVisibility(0);
                }
            } else if (SearchPrivilegeResultActivity.this.mTopIv.getVisibility() != 8) {
                SearchPrivilegeResultActivity.this.mTopIv.setVisibility(8);
            }
        }
    };
    private View.OnTouchListener mTouchListener = new View$OnTouchListenerC1603f();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchPrivilegeResultActivity$a */
    /* loaded from: classes6.dex */
    public class C1598a implements SearchPrivilegeModel.OnCombineListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1598a(String str) {
            this.a = str;
        }

        @Override // cn.damai.search.model.SearchPrivilegeModel.OnCombineListener
        public void onFail(boolean z, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1576264675")) {
                ipChange.ipc$dispatch("-1576264675", new Object[]{this, Boolean.valueOf(z), str, str2});
                return;
            }
            SearchPrivilegeResultActivity.this.isLoadingMore = false;
            SearchPrivilegeResultActivity.this.stopLoading();
            SearchPrivilegeResultActivity.this.error(z, str, str2, y72.a, this.a, 1);
        }

        @Override // cn.damai.search.model.SearchPrivilegeModel.OnCombineListener
        public void onSuccess(@NonNull SearchPrivilegeModel.CombineBean combineBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1719303472")) {
                ipChange.ipc$dispatch("1719303472", new Object[]{this, combineBean});
                return;
            }
            SearchPrivilegeResultActivity.this.stopLoading();
            SearchPrivilegeResultActivity.this.hasNextPage = combineBean.isHasMore;
            SearchPrivilegeResultActivity.this.isLoadingMore = false;
            SearchPrivilegeResultActivity.this.returnSearchListV2(combineBean, this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchPrivilegeResultActivity$b */
    /* loaded from: classes15.dex */
    public class C1599b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C1599b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1806215132")) {
                ipChange.ipc$dispatch("1806215132", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                SearchPrivilegeResultActivity.this.mDeleteLayout.setVisibility(0);
            } else {
                SearchPrivilegeResultActivity.this.mDeleteLayout.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-353919513")) {
                ipChange.ipc$dispatch("-353919513", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1193434631")) {
                ipChange.ipc$dispatch("1193434631", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchPrivilegeResultActivity$c */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1600c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1600c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1368509917")) {
                ipChange.ipc$dispatch("1368509917", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.tv_cancel) {
                SearchPrivilegeResultActivity.this.InputMethodHide();
                SearchPrivilegeResultActivity.this.finish();
            } else if (id == R$id.ll_delete) {
                SearchPrivilegeResultActivity.this.mInputEdit.setText("");
                SearchPrivilegeResultActivity.this.InputMethodShow();
                SearchPrivilegeResultActivity.this.mTopIv.setVisibility(8);
                SearchPrivilegeResultActivity.this.mDataHolderList.clear();
                if (SearchPrivilegeResultActivity.this.mAdapter != null) {
                    SearchPrivilegeResultActivity.this.mAdapter.notifyDataSetChanged();
                }
                SearchPrivilegeResultActivity.this.showThemeEvaluateIrc(true);
            } else if (id == R$id.iv_top) {
                if (SearchPrivilegeResultActivity.this.isRequesting || SearchPrivilegeResultActivity.this.mRecyclerView == null) {
                    return;
                }
                if (SearchPrivilegeResultActivity.this.mLinearLayoutManager.findFirstVisibleItemPosition() > 50) {
                    SearchPrivilegeResultActivity.this.mLinearLayoutManager.scrollToPosition(0);
                } else {
                    SearchPrivilegeResultActivity.this.mRecyclerView.smoothScrollToPosition(0);
                }
            } else if (id == R$id.search_title_close) {
                SearchPrivilegeResultActivity.this.InputMethodHide();
                SearchPrivilegeResultActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchPrivilegeResultActivity$d */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1601d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1601d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-815167010")) {
                ipChange.ipc$dispatch("-815167010", new Object[]{this, view});
                return;
            }
            SearchPrivilegeResultActivity searchPrivilegeResultActivity = SearchPrivilegeResultActivity.this;
            searchPrivilegeResultActivity.itemClick(view, searchPrivilegeResultActivity.mAdapter);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchPrivilegeResultActivity$e */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1602e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1602e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1296123359")) {
                ipChange.ipc$dispatch("1296123359", new Object[]{this, view});
                return;
            }
            SearchPrivilegeResultActivity searchPrivilegeResultActivity = SearchPrivilegeResultActivity.this;
            searchPrivilegeResultActivity.itemClick(view, searchPrivilegeResultActivity.mAdapterTheme);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchPrivilegeResultActivity$f */
    /* loaded from: classes15.dex */
    public class View$OnTouchListenerC1603f implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnTouchListenerC1603f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1504829553")) {
                return ((Boolean) ipChange.ipc$dispatch("1504829553", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                SearchPrivilegeResultActivity.this.InputMethodHide();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InputMethodHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978701150")) {
            ipChange.ipc$dispatch("-1978701150", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-824029433")) {
            ipChange.ipc$dispatch("-824029433", new Object[]{this});
            return;
        }
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        }
        this.mInputMethodManager.showSoftInput(this.mInputEdit, 2);
    }

    private void clearList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71372316")) {
            ipChange.ipc$dispatch("-71372316", new Object[]{this});
        } else {
            this.mDataHolderList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProjectItemBean convertBean(SearchPrivilegeRecommendBean.CommentProjectRecommendResult commentProjectRecommendResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620553766")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("-620553766", new Object[]{this, commentProjectRecommendResult});
        }
        ProjectItemBean projectItemBean = new ProjectItemBean();
        projectItemBean.verticalPic = commentProjectRecommendResult.postUrl;
        String str = commentProjectRecommendResult.cityName;
        projectItemBean.venueCity = str;
        projectItemBean.name = commentProjectRecommendResult.projectName;
        projectItemBean.showTime = commentProjectRecommendResult.performTimeSpanDesc;
        projectItemBean.venueName = commentProjectRecommendResult.venueName;
        projectItemBean.id = commentProjectRecommendResult.itemId;
        projectItemBean.cityName = str;
        projectItemBean.categoryName = commentProjectRecommendResult.projectType;
        projectItemBean.storeId = commentProjectRecommendResult.storeId;
        projectItemBean.priceDesc = commentProjectRecommendResult.priceDesc;
        projectItemBean.playerCount = commentProjectRecommendResult.playerCount;
        projectItemBean.itemType = commentProjectRecommendResult.itemType;
        return projectItemBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void editFocus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1931758943")) {
            ipChange.ipc$dispatch("-1931758943", new Object[]{this});
            return;
        }
        SoftInputUtils.d(this);
        this.mInputEdit.setFocusable(true);
        this.mInputEdit.setFocusableInTouchMode(true);
        this.mInputEdit.requestFocus();
        this.mInputEdit.requestFocusFromTouch();
    }

    private String getInput() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "193322169") ? (String) ipChange.ipc$dispatch("193322169", new Object[]{this}) : this.mInputEdit.getText().toString();
    }

    private void hideEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140337953")) {
            ipChange.ipc$dispatch("-2140337953", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.themeEvaluateIrc.setVisibility(8);
        this.mErrorLayout.setVisibility(8);
    }

    private void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795619900")) {
            ipChange.ipc$dispatch("-1795619900", new Object[]{this});
            return;
        }
        onResponseSuccess(this.mErrorLayout);
        if (this.mErrorLayout.getVisibility() == 0) {
            this.mErrorLayout.setVisibility(8);
        }
    }

    private void initEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1979500891")) {
            ipChange.ipc$dispatch("-1979500891", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "396042780")) {
            ipChange.ipc$dispatch("396042780", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        this.mThemeEvaDataHolderList.clear();
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
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        this.mLinearLayoutManagerTheme = linearLayoutManager2;
        this.themeEvaluateIrc.setLayoutManager(linearLayoutManager2);
        SearchAdapter searchAdapter2 = new SearchAdapter(this.mContext, this.mThemeEvaDataHolderList, null);
        this.mAdapterTheme = searchAdapter2;
        searchAdapter2.b(this.mThemeEvaItemClick);
        this.themeEvaluateIrc.setAdapter(this.mAdapterTheme);
        this.themeEvaluateIrc.setRefreshEnabled(false);
        this.themeEvaluateIrc.setLoadMoreEnabled(false);
        this.themeEvaluateIrc.setIsAutoToDefault(false);
        this.themeEvaluateIrc.getLoadMoreFooterView().setVisibility(8);
        this.themeEvaluateIrc.setOnScrollListener(this.mScrollListener);
        this.themeEvaluateIrc.setOnTouchListener(this.mTouchListener);
        this.themeEvaluateIrc.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemClick(View view, SearchAdapter searchAdapter) {
        SearchDataHolder searchDataHolder;
        String str;
        String str2;
        BaccountInfo baccountInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346460273")) {
            ipChange.ipc$dispatch("-1346460273", new Object[]{this, view, searchAdapter});
        } else if (view.getTag() == null) {
        } else {
            try {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue < 0 || intValue >= searchAdapter.getItemCount() || (searchDataHolder = searchAdapter.getData().get(intValue)) == null) {
                    return;
                }
                int i = searchDataHolder.mType;
                if (i != 13 && i != 17 && i != 21) {
                    if (i != 14 || (baccountInfo = searchDataHolder.mAccountInfo) == null) {
                        return;
                    }
                    C0529c.e().z(b82.C().k(baccountInfo.damaiId));
                    setResultAndFinish(new ResultBean(baccountInfo.damaiId, baccountInfo.name, baccountInfo.headPic, baccountInfo.description, "2"), "", "");
                    return;
                }
                ProjectItemBean projectItemBean = searchDataHolder.mProjectItem;
                if (projectItemBean == null) {
                    return;
                }
                String str3 = TextUtils.isEmpty(projectItemBean.showTime) ? "时间待定" : projectItemBean.showTime;
                String str4 = TextUtils.isEmpty(projectItemBean.venueName) ? "场馆待定" : projectItemBean.venueName;
                String str5 = str3 + " | " + str4;
                if (TextUtils.isEmpty(projectItemBean.venueCity)) {
                    str = str5;
                    str2 = "";
                } else {
                    str2 = "【" + projectItemBean.venueCity + "】";
                    str = projectItemBean.venueCity + " | " + str3 + " | " + str4;
                }
                String str6 = str2 + projectItemBean.name;
                if (i == 21 && "1".equals(projectItemBean.categoryName)) {
                    String str7 = projectItemBean.showTime;
                    if (TextUtils.isEmpty(str7)) {
                        str7 = CommentItemMoreUtil.o(Long.valueOf(searchDataHolder.beginTime), "yyyy.MM.dd");
                    }
                    String n = CommentItemMoreUtil.n(projectItemBean.cityName, str7, projectItemBean.venueName);
                    C0529c.e().z(b82.C().j(projectItemBean.id, projectItemBean.storeId));
                    ResultBean resultBean = new ResultBean(projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic, n, "3");
                    String str8 = searchDataHolder.targetId;
                    long j = searchDataHolder.beginTime;
                    setResultAndFinish(resultBean, str8, j == 0 ? null : String.valueOf(j));
                    return;
                }
                if (i == 21 && "0".equals(projectItemBean.categoryName)) {
                    C0529c.e().z(b82.C().l(projectItemBean.id));
                } else {
                    C0529c.e().z(b82.C().k(projectItemBean.id));
                }
                setResultAndFinish(new ResultBean(projectItemBean.id, str6, projectItemBean.verticalPic, str, "1"), "", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loadData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91677099")) {
            ipChange.ipc$dispatch("91677099", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.mHint = extras.getString("hint", "");
        this.themeId = extras.getString("themeId", "");
        this.mInputEdit.setHint(this.mHint);
    }

    private void loadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897290032")) {
            ipChange.ipc$dispatch("-897290032", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.layout_search_input);
        if (findViewById != null) {
            ms.a(this, findViewById, false);
        }
        this.mInputEdit = (EditText) findViewById(R$id.et_keyword);
        this.mCancelTv = (TextView) findViewById(R$id.tv_cancel);
        this.titleClose = (DMIconFontTextView) findViewById(R$id.search_title_close);
        this.mDeleteLayout = (DMIconFontTextView) findViewById(R$id.ll_delete);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.themeEvaluateIrc = (IRecyclerView) findViewById(R$id.theme_evaluate_irc);
        this.mTopIv = (ImageView) findViewById(R$id.iv_top);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_error);
        this.mErrorLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.mTopIv.setVisibility(8);
        this.mDeleteLayout.setVisibility(8);
        this.titleClose.setOnClickListener(this.mOnClickListener);
        this.mDeleteLayout.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSearchV2(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564752004")) {
            ipChange.ipc$dispatch("-1564752004", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        String input = getInput();
        if (TextUtils.isEmpty(input)) {
            stopLoading();
            return;
        }
        if (z) {
            this.hasNextPage = false;
        }
        if (z2) {
            showLoading("");
        }
        this.mModel.load(z, input, new C1598a(input));
    }

    private void setResultAndFinish(ResultBean resultBean, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600033531")) {
            ipChange.ipc$dispatch("-600033531", new Object[]{this, resultBean, str, str2});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(IssueConstants.ProjectID, resultBean.id);
        intent.putExtra("projectName", resultBean.name);
        intent.putExtra("projectImage", resultBean.imageUrl);
        intent.putExtra("timeAddress", resultBean.desc);
        intent.putExtra(IssueConstants.privilegeType, resultBean.type);
        if ("3".equals(resultBean.type)) {
            intent.putExtra("targetId", str);
            intent.putExtra("time", str2);
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showThemeEvaluateIrc(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864974318")) {
            ipChange.ipc$dispatch("1864974318", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        hideErrorView();
        if (z) {
            this.mRecyclerView.setVisibility(8);
            if (this.mThemeEvaDataHolderList.size() > 0) {
                this.themeEvaluateIrc.setVisibility(0);
                return;
            } else {
                showEmptyView(this.tipDesc);
                return;
            }
        }
        this.mRecyclerView.setVisibility(0);
        this.themeEvaluateIrc.setVisibility(8);
    }

    private void themeEvaluateRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105768590")) {
            ipChange.ipc$dispatch("2105768590", new Object[]{this});
            return;
        }
        showLoading("");
        SearchPrivilegeRequest searchPrivilegeRequest = new SearchPrivilegeRequest();
        if (!TextUtils.isEmpty(this.themeId)) {
            searchPrivilegeRequest.themeId = this.themeId;
        }
        searchPrivilegeRequest.request(new DMMtopRequestListener<SearchPrivilegeRecommendBean>(SearchPrivilegeRecommendBean.class) { // from class: cn.damai.search.ui.SearchPrivilegeResultActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1242978752")) {
                    ipChange2.ipc$dispatch("-1242978752", new Object[]{this, str, str2});
                    return;
                }
                SearchPrivilegeResultActivity.this.stopLoading();
                SearchPrivilegeResultActivity searchPrivilegeResultActivity = SearchPrivilegeResultActivity.this;
                searchPrivilegeResultActivity.showEmptyView(searchPrivilegeResultActivity.tipDesc);
                SearchPrivilegeResultActivity.this.editFocus();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchPrivilegeRecommendBean searchPrivilegeRecommendBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-563356018")) {
                    ipChange2.ipc$dispatch("-563356018", new Object[]{this, searchPrivilegeRecommendBean});
                    return;
                }
                SearchPrivilegeResultActivity.this.stopLoading();
                if (searchPrivilegeRecommendBean != null && (wh2.e(searchPrivilegeRecommendBean.themeList) != 0 || wh2.e(searchPrivilegeRecommendBean.evaluatedList) != 0)) {
                    if (wh2.e(searchPrivilegeRecommendBean.themeList) > 0) {
                        for (int i = 0; i < searchPrivilegeRecommendBean.themeList.size(); i++) {
                            ProjectItemBean convertBean = SearchPrivilegeResultActivity.this.convertBean(searchPrivilegeRecommendBean.themeList.get(i));
                            SearchDataHolder searchDataHolder = new SearchDataHolder(21);
                            if (i == 0) {
                                searchDataHolder.isSectionFirst = true;
                            } else {
                                searchDataHolder.isSectionFirst = false;
                            }
                            searchDataHolder.showDiv = false;
                            searchDataHolder.mProjectItem = convertBean;
                            searchDataHolder.isRecommendProject = false;
                            SearchPrivilegeResultActivity.this.mThemeEvaDataHolderList.add(searchDataHolder);
                        }
                    }
                    if (wh2.e(searchPrivilegeRecommendBean.evaluatedList) > 0) {
                        for (int i2 = 0; i2 < searchPrivilegeRecommendBean.evaluatedList.size(); i2++) {
                            SearchPrivilegeRecommendBean.CommentProjectRecommendResult commentProjectRecommendResult = searchPrivilegeRecommendBean.evaluatedList.get(i2);
                            ProjectItemBean convertBean2 = SearchPrivilegeResultActivity.this.convertBean(commentProjectRecommendResult);
                            SearchDataHolder searchDataHolder2 = new SearchDataHolder(21);
                            if (i2 == 0) {
                                searchDataHolder2.isSectionFirst = true;
                                if (SearchPrivilegeResultActivity.this.mThemeEvaDataHolderList.size() > 0) {
                                    searchDataHolder2.showDiv = true;
                                } else {
                                    searchDataHolder2.showDiv = false;
                                }
                            } else {
                                searchDataHolder2.isSectionFirst = false;
                                searchDataHolder2.showDiv = false;
                            }
                            searchDataHolder2.beginTime = commentProjectRecommendResult.beginTime;
                            searchDataHolder2.targetId = commentProjectRecommendResult.targetId;
                            searchDataHolder2.mProjectItem = convertBean2;
                            searchDataHolder2.isRecommendProject = false;
                            SearchPrivilegeResultActivity.this.mThemeEvaDataHolderList.add(searchDataHolder2);
                        }
                    }
                    SearchDataHolder searchDataHolder3 = new SearchDataHolder(4);
                    searchDataHolder3.mTipType = 7;
                    searchDataHolder3.mArtistName = "点击搜索框查找更多项目~";
                    SearchPrivilegeResultActivity.this.mThemeEvaDataHolderList.add(searchDataHolder3);
                    SearchPrivilegeResultActivity.this.showThemeEvaluateIrc(true);
                    if (SearchPrivilegeResultActivity.this.mAdapterTheme != null) {
                        SearchPrivilegeResultActivity.this.mAdapterTheme.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                SearchPrivilegeResultActivity searchPrivilegeResultActivity = SearchPrivilegeResultActivity.this;
                searchPrivilegeResultActivity.showEmptyView(searchPrivilegeResultActivity.tipDesc);
                SearchPrivilegeResultActivity.this.editFocus();
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113963645")) {
            ipChange.ipc$dispatch("-113963645", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void error(boolean z, String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375194866")) {
            ipChange.ipc$dispatch("-375194866", new Object[]{this, Boolean.valueOf(z), str, str2, str3, str4, Integer.valueOf(i)});
        } else if (getInput().equals(str4)) {
            if (z) {
                onResponseError(str2, str, str3, this.mErrorLayout, true);
                this.mErrorLayout.setVisibility(0);
                return;
            }
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-126370169") ? ((Integer) ipChange.ipc$dispatch("-126370169", new Object[]{this})).intValue() : R$layout.activity_search_privilege_result;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484506668")) {
            ipChange.ipc$dispatch("-1484506668", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestSearchV2(true, true);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699172649")) {
            ipChange.ipc$dispatch("-1699172649", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935538022")) {
            ipChange.ipc$dispatch("935538022", new Object[]{this});
            return;
        }
        loadView();
        initIRecycleView();
        initEvent();
        loadData();
        themeEvaluateRequest();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776377108")) {
            ipChange.ipc$dispatch("1776377108", new Object[]{this, bundle});
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
        setDamaiUTKeyBuilder(b82.C().E());
        C0529c.e().K(this);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969319409")) {
            ipChange.ipc$dispatch("1969319409", new Object[]{this, view});
        } else if (!this.hasNextPage || this.isLoadingMore) {
        } else {
            this.isLoadingMore = true;
            requestSearchV2(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688489681")) {
            ipChange.ipc$dispatch("-688489681", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        loadData();
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505736493")) {
            ipChange.ipc$dispatch("-1505736493", new Object[]{this});
        } else {
            requestSearchV2(true, false);
        }
    }

    public void returnSearchListV2(SearchPrivilegeModel.CombineBean combineBean, String str) {
        boolean z;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "2073445893")) {
            ipChange.ipc$dispatch("2073445893", new Object[]{this, combineBean, str});
            return;
        }
        showThemeEvaluateIrc(false);
        if (TextUtils.equals(getInput(), str)) {
            boolean z3 = combineBean.isFirstPage;
            boolean z4 = combineBean.isHasMore;
            List<ProjectItemBean> list = combineBean.showList;
            List<BaccountInfo> list2 = combineBean.bAccountList;
            if (z3) {
                clearList();
            }
            if (cb2.d(list)) {
                z = false;
            } else {
                for (ProjectItemBean projectItemBean : list) {
                    SearchDataHolder searchDataHolder = new SearchDataHolder(13);
                    searchDataHolder.isSectionFirst = this.mDataHolderList.size() == 0;
                    searchDataHolder.showDiv = false;
                    searchDataHolder.mProjectItem = projectItemBean;
                    searchDataHolder.isRecommendProject = false;
                    this.mDataHolderList.add(searchDataHolder);
                }
                z = true;
            }
            if (!cb2.d(list2)) {
                for (BaccountInfo baccountInfo : list2) {
                    SearchDataHolder searchDataHolder2 = new SearchDataHolder(14);
                    if (this.mDataHolderList.size() != 0) {
                        List<SearchDataHolder> list3 = this.mDataHolderList;
                        if (list3.get(list3.size() - 1).mType == 14) {
                            searchDataHolder2.mAccountInfo = baccountInfo;
                            this.mDataHolderList.add(searchDataHolder2);
                        }
                    }
                    searchDataHolder2.isSectionFirst = true;
                    searchDataHolder2.showDiv = this.mDataHolderList.size() > 0;
                    searchDataHolder2.mAccountInfo = baccountInfo;
                    this.mDataHolderList.add(searchDataHolder2);
                }
                z = true;
            }
            if (!cb2.d(combineBean.pastshowList)) {
                for (ProjectItemBean projectItemBean2 : combineBean.pastshowList) {
                    SearchDataHolder searchDataHolder3 = new SearchDataHolder(17);
                    if (this.mDataHolderList.size() != 0) {
                        List<SearchDataHolder> list4 = this.mDataHolderList;
                        if (list4.get(list4.size() - 1).mType == 17) {
                            searchDataHolder3.mProjectItem = projectItemBean2;
                            searchDataHolder3.isRecommendProject = false;
                            this.mDataHolderList.add(searchDataHolder3);
                        }
                    }
                    searchDataHolder3.isSectionFirst = true;
                    searchDataHolder3.showDiv = this.mDataHolderList.size() > 0;
                    searchDataHolder3.mProjectItem = projectItemBean2;
                    searchDataHolder3.isRecommendProject = false;
                    this.mDataHolderList.add(searchDataHolder3);
                }
                z = true;
            }
            boolean z5 = z && !z4;
            if (z3 && !z) {
                z2 = true;
            }
            if (z5) {
                SearchDataHolder searchDataHolder4 = new SearchDataHolder(4);
                searchDataHolder4.mTipType = 2;
                searchDataHolder4.mArtistName = str;
                this.mDataHolderList.add(searchDataHolder4);
            }
            if (z2) {
                C0529c.e().x(b82.C().g(getInput(), "1"));
                showEmptyView("没有找到符合条件的项目\n您可以减少筛选条件重新重试");
            } else {
                if (z3) {
                    C0529c.e().x(b82.C().g(getInput(), "0"));
                }
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
        if (AndroidInstantRuntime.support(ipChange, "-931517253")) {
            return (String) ipChange.ipc$dispatch("-931517253", new Object[]{this});
        }
        this.bese_head_view.setVisibility(8);
        return "";
    }

    public void showEmptyView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1855857308")) {
            ipChange.ipc$dispatch("-1855857308", new Object[]{this, str});
            return;
        }
        this.mRecyclerView.setVisibility(8);
        this.themeEvaluateIrc.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            onResponseError(3, str, "SUCCESS", y72.a, this.mErrorLayout, true);
        }
        this.mErrorLayout.setVisibility(0);
    }

    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599186006")) {
            ipChange.ipc$dispatch("599186006", new Object[]{this, str});
        }
    }

    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842778554")) {
            ipChange.ipc$dispatch("1842778554", new Object[]{this, str});
            return;
        }
        this.isRequesting = true;
        startProgressDialog();
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993259189")) {
            ipChange.ipc$dispatch("993259189", new Object[]{this});
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
