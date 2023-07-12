package cn.damai.search.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.artist.ArtistFollowResultBean;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.search.bean.PageIndexParams;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.bean.SearchFindWord;
import cn.damai.search.bean.SearchFindWordList;
import cn.damai.search.bean.SearchSuggest;
import cn.damai.search.bean.SearchTourUT;
import cn.damai.search.bean.SearchWord;
import cn.damai.search.bean.youku.SearchResultBeanV2;
import cn.damai.search.contract.SearchContract;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.helper.SearchListener;
import cn.damai.search.presenter.SearchPresenter;
import cn.damai.search.ui.adapter.SearchAdapterV2;
import cn.damai.search.ui.customview.SearchTabPanel;
import cn.damai.search.ui.viewholder.WaterFlowRecommendGoodsCardViewHolder;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.WrapperAdapter;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.fastjson.JSON;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ta.utdid2.device.UTDevice;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.resource.widget.YKActionSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.b23;
import tb.b82;
import tb.c21;
import tb.cb2;
import tb.d82;
import tb.e82;
import tb.kg2;
import tb.ms;
import tb.qd2;
import tb.wh2;
import tb.x72;
import tb.z20;
import tb.z6;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class SearchMainActivity extends DamaiBaseActivity<SearchPresenter, SearchContract.Model> implements SearchContract.View, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_SEARCH_PAGE = "search";
    private SearchAdapterV2 mAdapter;
    private String mAutoWords;
    private TextView mCancelTv;
    private String mCityId;
    SearchSuggest mClickSuggestWord;
    private DMIconFontTextView mDeleteLayout;
    private LinearLayout mErrorLayout;
    private int mErrorPageType;
    private View mHeadLayoutView;
    private String mHistoryDataUt;
    private String mInputDesc;
    private EditText mInputEdit;
    private InputMethodManager mInputMethodManager;
    private boolean mIsEggs;
    private StaggeredGridLayoutManager mLayoutManager;
    private BaccountInfo mLoginBAccountBean;
    private FrameLayout mMainContaineLayout;
    private IRecyclerView mRecyclerView;
    private SearchFindWordList mSearchFindData;
    private d82 mSearchUtKeyWord;
    private SearchTabPanel mTabPanel;
    private View mTempView;
    private View mTitleInputView;
    private View mTitleView;
    private ImageView mTopIv;
    private String mUtAAID;
    private List<SearchDataHolder> mDataHolderList = new ArrayList();
    private SearchDataHolder mHotDataHolder = new SearchDataHolder(2);
    private SearchDataHolder mHistoryDataHolder = new SearchDataHolder(3);
    private boolean isRequesting = false;
    private boolean mGetSearchFind = false;
    private int mDamaiProjectTotal = 0;
    private List<String> mHistoryData = new ArrayList();
    private String mKeyWords = "";
    private String mKeyWordsType = "";
    private SearchHelper.InputState mInputState = SearchHelper.InputState.INIT;
    private SearchHelper.PageState mPageState = SearchHelper.PageState.HOT_SEARCH_PAGE;
    private boolean exitAccount = false;
    private boolean existBrand = false;
    private boolean initCustomUT = true;
    private PageIndexParams mPageIndexParams = new PageIndexParams();
    private ConcurrentHashMap<String, BaccountInfo> mBAccountMap = new ConcurrentHashMap<>();
    private RecyclerView.ItemDecoration mItemDecoration = new RecyclerView.ItemDecoration(this) { // from class: cn.damai.search.ui.SearchMainActivity.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1792893534")) {
                ipChange.ipc$dispatch("1792893534", new Object[]{this, rect, view, recyclerView, state});
                return;
            }
            super.getItemOffsets(rect, view, recyclerView, state);
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            if ((childViewHolder instanceof NoteViewHolder) || (childViewHolder instanceof WaterFlowRecommendGoodsCardViewHolder)) {
                ViewGroup.LayoutParams layoutParams = childViewHolder.itemView.getLayoutParams();
                if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                    if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex() % 2 == 0) {
                        rect.left = ScreenUtil.dip2px(view.getContext(), 21.0f);
                        rect.right = ScreenUtil.dip2px(view.getContext(), 4.0f);
                        rect.top = ScreenUtil.dip2px(view.getContext(), 4.0f);
                        rect.bottom = ScreenUtil.dip2px(view.getContext(), 4.0f);
                        return;
                    }
                    rect.left = ScreenUtil.dip2px(view.getContext(), 4.0f);
                    rect.right = ScreenUtil.dip2px(view.getContext(), 21.0f);
                    rect.top = ScreenUtil.dip2px(view.getContext(), 4.0f);
                    rect.bottom = ScreenUtil.dip2px(view.getContext(), 4.0f);
                }
            }
        }
    };
    private View.OnFocusChangeListener mFocusListener = new View$OnFocusChangeListenerC1596i();
    private TextWatcher mEditTextWatch = new C1597j();
    private TextView.OnEditorActionListener mKeySearchListener = new TextView.OnEditorActionListener() { // from class: cn.damai.search.ui.SearchMainActivity.9
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1881865554")) {
                return ((Boolean) ipChange.ipc$dispatch("1881865554", new Object[]{this, textView, Integer.valueOf(i), keyEvent})).booleanValue();
            }
            if (i == 3) {
                String input = SearchMainActivity.this.getInput();
                if (TextUtils.isEmpty(input)) {
                    if (TextUtils.isEmpty(SearchMainActivity.this.mKeyWords)) {
                        return true;
                    }
                    if ("home_feed".equals(SearchMainActivity.this.mKeyWordsType)) {
                        SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_CLICK_SEARCH_ENTER_BRAND_TYPE;
                    } else {
                        SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_CLICK_SEARCH_ENTER;
                    }
                    SearchMainActivity.this.mInputEdit.setText(SearchMainActivity.this.mKeyWords);
                    SearchMainActivity.this.mInputEdit.setSelection(SearchMainActivity.this.mKeyWords.length());
                    SearchMainActivity searchMainActivity = SearchMainActivity.this;
                    searchMainActivity.updateHistoryKey(searchMainActivity.mKeyWords);
                } else if (SearchMainActivity.this.mPageState == SearchHelper.PageState.SEARCH_SUGGEST_PAGE) {
                    SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_INPUT_WORD_ENTER;
                    SearchMainActivity.this.mInputEdit.setText(input);
                    SearchMainActivity.this.mInputEdit.setSelection(input.length());
                    SearchMainActivity.this.updateHistoryKey(input);
                }
                SearchMainActivity.this.InputMethodHide();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View$OnClickListenerC1587a();
    private SearchListener mFlowerClickListener = new C1588b();
    private View.OnClickListener mItemClick = new View$OnClickListenerC1590c();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1587a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1587a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-790676534")) {
                ipChange.ipc$dispatch("-790676534", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.tv_cancel) {
                SearchMainActivity.this.InputMethodHide();
                SearchMainActivity.this.finish();
            } else if (id == R$id.ll_delete) {
                C0529c.e().x(b82.C().q(SearchMainActivity.this.getInput()));
                SearchMainActivity.this.mInputState = SearchHelper.InputState.INIT;
                SearchMainActivity.this.mInputEdit.setText("");
                SearchMainActivity.this.mInputEdit.setFocusable(true);
                SearchMainActivity.this.mInputEdit.setFocusableInTouchMode(true);
                SearchMainActivity.this.mInputEdit.requestFocus();
                SearchMainActivity.this.mInputEdit.findFocus();
                SearchMainActivity.this.InputMethodShow();
            } else if (id == R$id.iv_top && SearchMainActivity.this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE && !SearchMainActivity.this.isRequesting) {
                if (SearchMainActivity.this.mRecyclerView != null && SearchMainActivity.this.mLayoutManager != null) {
                    SearchMainActivity.this.mLayoutManager.scrollToPosition(0);
                }
                C0529c.e().x(b82.C().z(SearchMainActivity.this.getInput()));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$b */
    /* loaded from: classes6.dex */
    public class C1588b implements SearchListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private DMDialog a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.ui.SearchMainActivity$b$a */
        /* loaded from: classes15.dex */
        public class DialogInterface$OnClickListenerC1589a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC1589a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1818862935")) {
                    ipChange.ipc$dispatch("1818862935", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                SearchMainActivity searchMainActivity = SearchMainActivity.this;
                searchMainActivity.mHistoryDataUt = SearchHelper.a(searchMainActivity.mContext);
                SearchMainActivity.this.mHistoryData.clear();
                SearchMainActivity.this.updateFindAdvertView();
            }
        }

        C1588b() {
        }

        @Override // cn.damai.search.helper.SearchListener
        public void onDeleteHistoryClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1281274538")) {
                ipChange.ipc$dispatch("-1281274538", new Object[]{this, view});
                return;
            }
            SearchMainActivity.this.clearFocus();
            SearchMainActivity.this.InputMethodHide();
            C0529c.e().x(b82.C().p());
            DMDialog dMDialog = new DMDialog(SearchMainActivity.this);
            this.a = dMDialog;
            dMDialog.v("确认清空搜索历史？");
            this.a.i("取消", null);
            this.a.n("确定", new DialogInterface$OnClickListenerC1589a());
            this.a.show();
        }

        @Override // cn.damai.search.helper.SearchListener
        public void onHistoryTextClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1856641698")) {
                ipChange.ipc$dispatch("-1856641698", new Object[]{this, view});
                return;
            }
            String str = (String) view.getTag();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String[] split = str.split(",");
            if (split.length == 0) {
                return;
            }
            String str2 = split[0];
            C0529c.e().x(b82.C().r(str2, split.length > 1 ? split[1] : "0"));
            int length = str2 != null ? str2.length() : 0;
            SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_CLICK_HISTORY_WORD;
            if (length > 30) {
                SearchMainActivity.this.mInputEdit.setText(str2.substring(0, 30));
                SearchMainActivity.this.mInputEdit.setSelection(30);
            } else {
                SearchMainActivity.this.mInputEdit.setText(str2);
                SearchMainActivity.this.mInputEdit.setSelection(length);
            }
            SearchMainActivity searchMainActivity = SearchMainActivity.this;
            searchMainActivity.updateHistoryKey(searchMainActivity.getInput());
        }

        @Override // cn.damai.search.helper.SearchListener
        public void onSearchEggsRecommendItemClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "533564550")) {
                ipChange.ipc$dispatch("533564550", new Object[]{this, view});
            } else if (view == null) {
            } else {
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int i = SearchHelper.i(SearchMainActivity.this.mInputState);
                int i2 = R$id.search_eggs_item_index;
                C0529c.e().x(b82.C().v("", SearchMainActivity.this.getInput(), str, view.getTag(i2) instanceof String ? (String) view.getTag(i2) : "", i));
                DMNav.from(SearchMainActivity.this).toUri(str);
            }
        }

        @Override // cn.damai.search.helper.SearchListener
        public void onSearchFindTextClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1885048861")) {
                ipChange.ipc$dispatch("1885048861", new Object[]{this, view});
                return;
            }
            SearchFindWord searchFindWord = (SearchFindWord) view.getTag();
            if (searchFindWord == null) {
                return;
            }
            C0529c.e().x(b82.C().s(searchFindWord.keyword, searchFindWord.alg, searchFindWord.reason, searchFindWord.wordType, searchFindWord.pos));
            int i = searchFindWord.action;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                DMNav.from(SearchMainActivity.this).toUri(searchFindWord.url);
                return;
            }
            SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_CLICK_HOT_WORD;
            if ((TextUtils.isEmpty(searchFindWord.keyword) ? 0 : searchFindWord.keyword.length()) > 30) {
                SearchMainActivity.this.mInputEdit.setText(searchFindWord.keyword.substring(0, 30));
                SearchMainActivity.this.mInputEdit.setSelection(30);
            } else {
                SearchMainActivity.this.mInputEdit.setText(searchFindWord.keyword);
                SearchMainActivity.this.mInputEdit.setSelection(searchFindWord.keyword.length());
            }
            SearchMainActivity searchMainActivity = SearchMainActivity.this;
            searchMainActivity.updateHistoryKey(searchMainActivity.getInput());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$c */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1590c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1590c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchDataHolder searchDataHolder;
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-863063092")) {
                ipChange.ipc$dispatch("-863063092", new Object[]{this, view});
            } else if (view.getTag() == null) {
            } else {
                try {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (intValue < 0 || intValue >= SearchMainActivity.this.mAdapter.getItemCount() || (searchDataHolder = SearchMainActivity.this.mAdapter.getData().get(intValue)) == null) {
                        return;
                    }
                    int i = searchDataHolder.mType;
                    if (i == 0) {
                        SearchMainActivity.this.jumpProjectDetailPage(searchDataHolder.mProjectItem, intValue - SearchMainActivity.this.mAdapter.f());
                    } else if (i != 8) {
                        if (i == 9 && (projectItemBean = searchDataHolder.mProjectItem) != null) {
                            C0529c.e().x(b82.C().y(projectItemBean.id, projectItemBean.name, TextUtils.isEmpty(projectItemBean.utKeyWord) ? SearchMainActivity.this.getInput() : projectItemBean.utKeyWord, SearchHelper.i(SearchMainActivity.this.mInputState), projectItemBean.alg, intValue));
                            qd2.b(SearchMainActivity.this, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
                        }
                    } else {
                        SearchMainActivity searchMainActivity = SearchMainActivity.this;
                        SearchSuggest searchSuggest = searchDataHolder.mSuggestWord;
                        searchMainActivity.mClickSuggestWord = searchSuggest;
                        if (searchSuggest == null) {
                            return;
                        }
                        String str = searchSuggest.sugWord;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        String trim = str.trim();
                        if (TextUtils.isEmpty(trim)) {
                            return;
                        }
                        try {
                            SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_CLICK_SUGGEST_WORD;
                            SearchMainActivity.this.mInputEdit.setText(trim);
                            SearchMainActivity.this.mInputEdit.setSelection(trim.length());
                            SearchMainActivity.this.updateHistoryKey(trim);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$d */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class C1591d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[SearchHelper.InputState.values().length];
            b = iArr;
            try {
                iArr[SearchHelper.InputState.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[SearchHelper.InputState.USER_INPUT_WORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[SearchHelper.InputState.AUTO_INPUT_WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[SearchHelper.InputState.USER_CLICK_SEARCH_ENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SearchHelper.InputState.USER_CLICK_SEARCH_ENTER_BRAND_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[SearchHelper.InputState.USER_INPUT_WORD_ENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[SearchHelper.InputState.USER_CLICK_HOT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[SearchHelper.InputState.USER_CLICK_HISTORY_WORD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[SearchHelper.InputState.USER_CLICK_SUGGEST_WORD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[PageIndexParams.PageRequestType.values().length];
            a = iArr2;
            try {
                iArr2[PageIndexParams.PageRequestType.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PageIndexParams.PageRequestType.NOTE_NEXT_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PageIndexParams.PageRequestType.PROJECT_NEXT_PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$e */
    /* loaded from: classes6.dex */
    public class C1592e implements SearchTabPanel.OnRecyclerViewListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1592e() {
        }

        @Override // cn.damai.search.ui.customview.SearchTabPanel.OnRecyclerViewListener
        public void onFirstItemPosition(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-236806672")) {
                ipChange.ipc$dispatch("-236806672", new Object[]{this, Integer.valueOf(i)});
            } else if (i >= 15) {
                if (SearchMainActivity.this.mTopIv.getVisibility() != 0) {
                    SearchMainActivity.this.mTopIv.setVisibility(0);
                }
            } else if (SearchMainActivity.this.mTopIv.getVisibility() != 8) {
                SearchMainActivity.this.mTopIv.setVisibility(8);
            }
        }

        @Override // cn.damai.search.ui.customview.SearchTabPanel.OnRecyclerViewListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "536270315")) {
                return ((Boolean) ipChange.ipc$dispatch("536270315", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                SearchMainActivity.this.clearFocus();
                SearchMainActivity.this.InputMethodHide();
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$f */
    /* loaded from: classes6.dex */
    public class C1593f implements SearchTabPanel.UtParamsProvider {
        private static transient /* synthetic */ IpChange $ipChange;

        C1593f() {
        }

        @Override // cn.damai.search.ui.customview.SearchTabPanel.UtParamsProvider
        public String getAaid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1258353906") ? (String) ipChange.ipc$dispatch("1258353906", new Object[]{this}) : SearchMainActivity.this.mUtAAID;
        }

        @Override // cn.damai.search.ui.customview.SearchTabPanel.UtParamsProvider
        public String getInputWord() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-790924333") ? (String) ipChange.ipc$dispatch("-790924333", new Object[]{this}) : SearchMainActivity.this.getInput();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$g */
    /* loaded from: classes6.dex */
    public class C1594g implements SearchAdapterV2.OnXItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1594g() {
        }

        @Override // cn.damai.search.ui.adapter.SearchAdapterV2.OnXItemClickListener
        public void onLoadMoreProjectClicked(@Nullable List<SearchDataHolder> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1961761323")) {
                ipChange.ipc$dispatch("-1961761323", new Object[]{this, list});
            } else if (cb2.d(list)) {
                if (SearchMainActivity.this.isRequesting) {
                    return;
                }
                SearchMainActivity.this.requestSearch(PageIndexParams.PageRequestType.PROJECT_NEXT_PAGE, true);
            } else {
                SearchHelper.p(SearchMainActivity.this.mDataHolderList, list);
                if (SearchMainActivity.this.mAdapter != null) {
                    SearchMainActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$h */
    /* loaded from: classes6.dex */
    public class C1595h implements WrapperAdapter.FullSpanTypeChecker {
        private static transient /* synthetic */ IpChange $ipChange;

        C1595h(SearchMainActivity searchMainActivity) {
        }

        @Override // cn.damai.uikit.irecycler.WrapperAdapter.FullSpanTypeChecker
        public boolean isTypeFullSpan(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1753807273") ? ((Boolean) ipChange.ipc$dispatch("-1753807273", new Object[]{this, Integer.valueOf(i)})).booleanValue() : (i == 18 || i == 19) ? false : true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$i */
    /* loaded from: classes15.dex */
    public class View$OnFocusChangeListenerC1596i implements View.OnFocusChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnFocusChangeListenerC1596i() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-913042924")) {
                ipChange.ipc$dispatch("-913042924", new Object[]{this, view, Boolean.valueOf(z)});
            } else if (z && SearchMainActivity.this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE) {
                SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_INPUT_WORD;
                SearchMainActivity.this.resetData();
                SearchMainActivity.this.resetTitleView();
                SearchMainActivity.this.requestSearchSuggest();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.SearchMainActivity$j */
    /* loaded from: classes15.dex */
    public class C1597j implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C1597j() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "242939798")) {
                ipChange.ipc$dispatch("242939798", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                if (SearchMainActivity.this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE) {
                    SearchMainActivity.this.mInputState = SearchHelper.InputState.USER_INPUT_WORD;
                }
                switch (C1591d.b[SearchMainActivity.this.mInputState.ordinal()]) {
                    case 1:
                    case 2:
                        SearchMainActivity.this.resetData();
                        SearchMainActivity.this.resetTitleView();
                        SearchMainActivity.this.requestSearchSuggest();
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        SearchMainActivity.this.resetData();
                        SearchMainActivity.this.resetTitleView();
                        SearchMainActivity.this.requestSearchEggs();
                        break;
                }
                SearchMainActivity.this.mDeleteLayout.setVisibility(0);
                SearchMainActivity.this.mInputEdit.setTextSize(1, 14.0f);
            } else {
                SearchMainActivity.this.mInputState = SearchHelper.InputState.INIT;
                SearchMainActivity.this.mDeleteLayout.setVisibility(8);
                SearchMainActivity.this.mInputEdit.setTextSize(1, 12.0f);
                SearchMainActivity.this.resetData();
                SearchMainActivity.this.resetTitleView();
                if (SearchMainActivity.this.mGetSearchFind) {
                    SearchMainActivity.this.updateFindAdvertView();
                } else {
                    SearchMainActivity.this.requestSearchFind();
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1200886381")) {
                ipChange.ipc$dispatch("1200886381", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-23460467")) {
                ipChange.ipc$dispatch("-23460467", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InputMethodHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16236289")) {
            ipChange.ipc$dispatch("16236289", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1170908006")) {
            ipChange.ipc$dispatch("1170908006", new Object[]{this});
            return;
        }
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        }
        this.mInputMethodManager.showSoftInput(this.mInputEdit, 2);
    }

    private void cancelTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558096611")) {
            ipChange.ipc$dispatch("1558096611", new Object[]{this});
            return;
        }
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.g.stopTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFocus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186542513")) {
            ipChange.ipc$dispatch("186542513", new Object[]{this});
            return;
        }
        EditText editText = this.mInputEdit;
        if (editText != null) {
            editText.clearFocus();
        }
    }

    private void dispatchActivityUsable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645915653")) {
            ipChange.ipc$dispatch("-1645915653", new Object[]{this});
        } else {
            this.mTempView.setVisibility(0);
        }
    }

    private void getHistoryKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820334419")) {
            ipChange.ipc$dispatch("-820334419", new Object[]{this});
            return;
        }
        String e = SearchHelper.e(this.mContext);
        this.mHistoryDataUt = e;
        if (TextUtils.isEmpty(e)) {
            return;
        }
        this.mHistoryData.clear();
        this.mHistoryData.addAll(Arrays.asList(this.mHistoryDataUt.split(",")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getInput() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1274250840") ? (String) ipChange.ipc$dispatch("1274250840", new Object[]{this}) : this.mInputEdit.getText().toString();
    }

    private String getSuggestProjectWord(List<SearchSuggest> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1109880886") ? (String) ipChange.ipc$dispatch("1109880886", new Object[]{this, list}) : wh2.e(list) < 0 ? "" : list.get(0).sugWord;
    }

    private void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683547107")) {
            ipChange.ipc$dispatch("1683547107", new Object[]{this});
            return;
        }
        onResponseSuccess(this.mErrorLayout);
        if (this.mErrorLayout.getVisibility() == 0) {
            this.mErrorLayout.setVisibility(8);
        }
    }

    private void initEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721893308")) {
            ipChange.ipc$dispatch("-1721893308", new Object[]{this});
            return;
        }
        this.mInputEdit.setOnFocusChangeListener(this.mFocusListener);
        this.mInputEdit.addTextChangedListener(this.mEditTextWatch);
        this.mInputEdit.setOnEditorActionListener(this.mKeySearchListener);
        this.mCancelTv.setOnClickListener(this.mOnClickListener);
        this.mDeleteLayout.setOnClickListener(this.mOnClickListener);
        this.mTopIv.setOnClickListener(this.mOnClickListener);
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109561245")) {
            ipChange.ipc$dispatch("2109561245", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.mLayoutManager = staggeredGridLayoutManager;
        this.mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        SearchAdapterV2 searchAdapterV2 = new SearchAdapterV2(this.mContext, this.mDataHolderList, this.mBAccountMap, new C1594g());
        this.mAdapter = searchAdapterV2;
        searchAdapterV2.l(this.mItemClick);
        this.mAdapter.h(this.mFlowerClickListener);
        this.mRecyclerView.setAdapter(this.mAdapter);
        c21.b(this.mRecyclerView);
        this.mRecyclerView.getWrapAdapter().c(new C1595h(this));
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.addItemDecoration(this.mItemDecoration);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021813763")) {
            ipChange.ipc$dispatch("2021813763", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            int a = kg2.a(this);
            if (findViewById != null) {
                findViewById.getLayoutParams().height = a;
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            this.mHeadLayoutView.getLayoutParams().height = a + ScreenUtil.dip2px(this, 52.0f);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.mHeadLayoutView.getLayoutParams().height = ScreenUtil.dip2px(this, 52.0f);
    }

    private void loadAutoSearchWords() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546247614")) {
            ipChange.ipc$dispatch("-546247614", new Object[]{this});
        } else if (TextUtils.isEmpty(this.mAutoWords)) {
        } else {
            this.mInputState = SearchHelper.InputState.AUTO_INPUT_WORD;
            this.mInputEdit.setText(this.mAutoWords);
            this.mInputEdit.setSelection(this.mAutoWords.length());
            updateHistoryKey(this.mAutoWords);
        }
    }

    private void loadCustomUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1576200646")) {
            ipChange.ipc$dispatch("1576200646", new Object[]{this});
        } else if (this.initCustomUT) {
            this.initCustomUT = false;
            setSearchCustomHotAndHistory();
            b82.C().I(this.mSearchUtKeyWord);
        }
    }

    private void loadData(boolean z) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195323864")) {
            ipChange.ipc$dispatch("-1195323864", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCityId = z20.c();
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.mAutoWords = extras.getString("autowords", "");
            this.mKeyWords = extras.getString(OneArchConstants.LayoutKey.KEY_WORDS, "");
            this.mKeyWordsType = extras.getString("keyType", "");
            String string = extras.getString(YKActionSheet.ACTION_STYLE_DESCRIBE, "");
            this.mInputDesc = string;
            updateInputEditHit(string);
        }
        setSearchCustomKeyWord(this.mInputDesc);
        getHistoryKey();
        if (z && TextUtils.isEmpty(this.mAutoWords)) {
            getWindow().setSoftInputMode(4);
        }
        loadAutoSearchWords();
    }

    private void loadDiscountCustomUT(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1085844303")) {
            ipChange.ipc$dispatch("1085844303", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("discountInfo", str);
            C0529c.e().A(hashMap, "search", "yhtc_search_discountinfo");
        }
    }

    private void loadErrorPage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679014021")) {
            ipChange.ipc$dispatch("-1679014021", new Object[]{this, str, str2, str3});
            return;
        }
        onResponseError(str2, str, str3, this.mErrorLayout, true);
        resetTitleView();
        this.mErrorLayout.setVisibility(0);
    }

    private void recoverTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1882056315")) {
            ipChange.ipc$dispatch("1882056315", new Object[]{this});
            return;
        }
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.g.autoStartAndStop();
        }
    }

    private void requestFollow(final BaccountInfo baccountInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789406141")) {
            ipChange.ipc$dispatch("-1789406141", new Object[]{this, baccountInfo});
        } else if (baccountInfo == null || TextUtils.isEmpty(baccountInfo.type)) {
        } else {
            FollowRequest followRequest = new FollowRequest();
            followRequest.operateType = "1";
            followRequest.targetId = String.valueOf(baccountInfo.damaiId);
            followRequest.targetType = String.valueOf(baccountInfo.type);
            if (this.existBrand) {
                C0529c.e().x(b82.C().m(followRequest.targetId, followRequest.targetType, true));
            } else {
                C0529c.e().x(b82.C().h(this.mUtAAID, true, followRequest.targetId, followRequest.targetType, getInput(), SearchHelper.i(this.mInputState)));
            }
            followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.search.ui.SearchMainActivity.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1854663237")) {
                        ipChange2.ipc$dispatch("1854663237", new Object[]{this, str, str2});
                    } else if (TextUtils.isEmpty(str2)) {
                    } else {
                        ToastUtil.i(str2);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(FollowDataBean followDataBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "976152699")) {
                        ipChange2.ipc$dispatch("976152699", new Object[]{this, followDataBean});
                    } else {
                        SearchMainActivity.this.updateAccountFollow(baccountInfo, String.valueOf(followDataBean.getStatus()));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSearch(PageIndexParams.PageRequestType pageRequestType, boolean z) {
        PageIndexParams.Params homePageParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333890042")) {
            ipChange.ipc$dispatch("333890042", new Object[]{this, pageRequestType, Boolean.valueOf(z)});
        } else if (pageRequestType == null || pageRequestType == PageIndexParams.PageRequestType.NONE) {
        } else {
            String input = getInput();
            if (TextUtils.isEmpty(input)) {
                return;
            }
            setPageState(SearchHelper.PageState.SEARCH_RESULT_PAGE, pageRequestType == PageIndexParams.PageRequestType.HOME);
            this.mMainContaineLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            showLoading("");
            if (z) {
                startProgressDialog();
            }
            int i = C1591d.a[pageRequestType.ordinal()];
            if (i == 1) {
                homePageParams = this.mPageIndexParams.getHomePageParams();
            } else if (i != 2) {
                homePageParams = this.mPageIndexParams.getProjectNextPageParams();
            } else {
                homePageParams = this.mPageIndexParams.getNoteNextPageParams();
            }
            ((SearchPresenter) this.mPresenter).getSearchListV2(input, homePageParams);
            loadCustomUT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSearchEggs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611724279")) {
            ipChange.ipc$dispatch("-611724279", new Object[]{this});
            return;
        }
        String input = getInput();
        if (TextUtils.isEmpty(input)) {
            return;
        }
        clearFocus();
        InputMethodHide();
        this.mMainContaineLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        showLoading("");
        setPageState(SearchHelper.PageState.SEARCH_RESULT_PAGE);
        ((SearchPresenter) this.mPresenter).getSearchEggs(input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSearchFind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339055486")) {
            ipChange.ipc$dispatch("339055486", new Object[]{this});
        } else if (this.mGetSearchFind) {
        } else {
            setPageState(SearchHelper.PageState.HOT_SEARCH_PAGE);
            ((SearchPresenter) this.mPresenter).getSearchFindList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSearchSuggest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433003471")) {
            ipChange.ipc$dispatch("1433003471", new Object[]{this});
            return;
        }
        String input = getInput();
        if (TextUtils.isEmpty(input)) {
            return;
        }
        setPageState(SearchHelper.PageState.SEARCH_SUGGEST_PAGE);
        this.mMainContaineLayout.setBackgroundResource(R$drawable.bg_search_hot_text_page);
        showLoading("");
        ((SearchPresenter) this.mPresenter).getSearchSuggest(input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877044149")) {
            ipChange.ipc$dispatch("877044149", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.notifyDataSetChanged();
        }
        this.mDamaiProjectTotal = 0;
        this.exitAccount = false;
        this.existBrand = false;
        this.mPageIndexParams.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756416846")) {
            ipChange.ipc$dispatch("756416846", new Object[]{this});
            return;
        }
        this.mTitleView.setBackgroundResource(R$drawable.app_title_bg);
        kg2.d(true, this);
        View view = this.mTitleInputView;
        if (view != null) {
            ms.a(this, view, false);
        }
        this.mCancelTv.setTextColor(-16777216);
    }

    private void setPageState(SearchHelper.PageState pageState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480441724")) {
            ipChange.ipc$dispatch("480441724", new Object[]{this, pageState});
        } else {
            setPageState(pageState, true);
        }
    }

    private void setSearchCustomHotAndHistory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416112141")) {
            ipChange.ipc$dispatch("1416112141", new Object[]{this});
            return;
        }
        if (this.mSearchUtKeyWord == null) {
            this.mSearchUtKeyWord = new d82();
        }
        this.mSearchUtKeyWord.c = this.mHistoryDataUt;
        SearchFindWordList searchFindWordList = this.mSearchFindData;
        if (searchFindWordList == null || wh2.e(searchFindWordList.hotWords) <= 0) {
            return;
        }
        this.mSearchUtKeyWord.b = JSON.toJSONString(this.mSearchFindData.hotWords);
    }

    private void setSearchCustomKeyWord(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872695384")) {
            ipChange.ipc$dispatch("1872695384", new Object[]{this, str});
            return;
        }
        if (this.mSearchUtKeyWord == null) {
            this.mSearchUtKeyWord = new d82();
        }
        this.mSearchUtKeyWord.a = str;
    }

    private void showSearchEggsList(SearchEggs searchEggs, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397575465")) {
            ipChange.ipc$dispatch("-397575465", new Object[]{this, searchEggs, str});
            return;
        }
        updateServerTime(searchEggs.currentTime);
        hideErrorView();
        this.mDataHolderList.clear();
        List<SearchEggs.SearchEggHeader> list = searchEggs.header;
        if ((list != null && list.size() >= 4) || !TextUtils.isEmpty(searchEggs.backgroundPic)) {
            SearchDataHolder searchDataHolder = new SearchDataHolder(11);
            searchDataHolder.mSearchEggs = searchEggs;
            this.mDataHolderList.add(searchDataHolder);
        }
        List<ProjectItemBean> list2 = searchEggs.projectInfo;
        if (list2 != null && list2.size() > 0) {
            for (int i = 0; i < searchEggs.projectInfo.size(); i++) {
                SearchDataHolder searchDataHolder2 = new SearchDataHolder(0);
                searchDataHolder2.mProjectItem = searchEggs.projectInfo.get(i);
                searchDataHolder2.isRecommendProject = false;
                this.mDataHolderList.add(searchDataHolder2);
            }
        }
        SearchDataHolder searchDataHolder3 = new SearchDataHolder(4);
        searchDataHolder3.isVisableLine = false;
        List<ProjectItemBean> list3 = searchEggs.projectInfo;
        if (list3 != null && list3.size() > 0) {
            searchDataHolder3.mTipType = 2;
            searchDataHolder3.mArtistName = str;
        } else {
            searchDataHolder3.mTipType = 3;
            searchDataHolder3.mArtistName = str;
        }
        this.mDataHolderList.add(searchDataHolder3);
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.k(str);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccountFollow(BaccountInfo baccountInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204446232")) {
            ipChange.ipc$dispatch("1204446232", new Object[]{this, baccountInfo, str});
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
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFindAdvertView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44448479")) {
            ipChange.ipc$dispatch("-44448479", new Object[]{this});
            return;
        }
        setPageState(SearchHelper.PageState.HOT_SEARCH_PAGE);
        this.mTitleView.setBackgroundResource(R$drawable.transparent_bg);
        this.mMainContaineLayout.setBackgroundResource(R$drawable.bg_search_hot_text_page);
        this.mDataHolderList.clear();
        hideErrorView();
        SearchFindWordList searchFindWordList = this.mSearchFindData;
        if (searchFindWordList != null ? searchFindWordList.isFindTop() : true) {
            SearchFindWordList searchFindWordList2 = this.mSearchFindData;
            if (searchFindWordList2 != null && wh2.e(searchFindWordList2.hotWords) > 0) {
                SearchDataHolder searchDataHolder = this.mHotDataHolder;
                searchDataHolder.mSearchFindWordList = this.mSearchFindData;
                this.mDataHolderList.add(searchDataHolder);
            }
            if (this.mHistoryData.size() > 0) {
                SearchDataHolder searchDataHolder2 = this.mHistoryDataHolder;
                searchDataHolder2.mHistoryKey = this.mHistoryData;
                this.mDataHolderList.add(searchDataHolder2);
            }
        } else {
            if (this.mHistoryData.size() > 0) {
                SearchDataHolder searchDataHolder3 = this.mHistoryDataHolder;
                searchDataHolder3.mHistoryKey = this.mHistoryData;
                this.mDataHolderList.add(searchDataHolder3);
            }
            SearchFindWordList searchFindWordList3 = this.mSearchFindData;
            if (searchFindWordList3 != null && wh2.e(searchFindWordList3.hotWords) > 0) {
                SearchDataHolder searchDataHolder4 = this.mHotDataHolder;
                searchDataHolder4.mSearchFindWordList = this.mSearchFindData;
                this.mDataHolderList.add(searchDataHolder4);
            }
        }
        if (this.mDataHolderList.size() == 0) {
            this.mDataHolderList.add(new SearchDataHolder(5));
        }
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHistoryKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680151214")) {
            ipChange.ipc$dispatch("-680151214", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
        } else {
            if (this.mHistoryData.contains(str)) {
                this.mHistoryData.remove(str);
            } else if (wh2.e(this.mHistoryData) >= 10) {
                this.mHistoryData.remove(9);
            }
            this.mHistoryData.add(0, str);
            SearchHelper.t(this.mContext, this.mHistoryData);
        }
    }

    private void updateInputEditHit(String str) {
        EditText editText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48241534")) {
            ipChange.ipc$dispatch("48241534", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || (editText = this.mInputEdit) == null) {
        } else {
            editText.setHint(str);
        }
    }

    private void updateServerTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427591489")) {
            ipChange.ipc$dispatch("1427591489", new Object[]{this, Long.valueOf(j)});
            return;
        }
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.g(j);
        }
    }

    private void updateWordPage(ProjectItemBean projectItemBean, List<SearchSuggest> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521314243")) {
            ipChange.ipc$dispatch("-521314243", new Object[]{this, projectItemBean, list});
            return;
        }
        int e = wh2.e(list);
        if (e == 0) {
            return;
        }
        this.mDataHolderList.clear();
        if (projectItemBean != null) {
            SearchDataHolder searchDataHolder = new SearchDataHolder(9);
            searchDataHolder.mProjectItem = projectItemBean;
            this.mDataHolderList.add(searchDataHolder);
        }
        for (int i = 0; i < e; i++) {
            SearchDataHolder searchDataHolder2 = new SearchDataHolder(8);
            SearchSuggest searchSuggest = list.get(i);
            searchDataHolder2.mSuggestWord = searchSuggest;
            searchSuggest.index = i;
            this.mDataHolderList.add(searchDataHolder2);
        }
        SearchAdapterV2 searchAdapterV2 = this.mAdapter;
        if (searchAdapterV2 != null) {
            searchAdapterV2.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599554820")) {
            ipChange.ipc$dispatch("1599554820", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void error(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487929547")) {
            ipChange.ipc$dispatch("-1487929547", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
            return;
        }
        this.mErrorPageType = i;
        if (i == 0) {
            if (this.mPageState != SearchHelper.PageState.HOT_SEARCH_PAGE) {
                return;
            }
            updateFindAdvertView();
            b23.a(e82.a(str3, str, str2, this.mCityId), e82.SEARCH_HOT_WORD_ERROR_CODE, e82.SEARCH_HOT_WORD_ERROR_MSG);
        } else if (i == 1) {
            if (this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE && getInput().equals(str4)) {
                loadErrorPage(str, str2, str3);
                b23.a(e82.b(str3, str, str2, this.mCityId, str4), e82.SEARCH_ERROR_CODE, e82.SEARCH_ERROR_MSG);
            }
        } else if (i != 2) {
            if (i == 3 && this.mPageState == SearchHelper.PageState.SEARCH_SUGGEST_PAGE && str4.equals(getInput())) {
                hideErrorView();
                this.mDataHolderList.clear();
                SearchAdapterV2 searchAdapterV2 = this.mAdapter;
                if (searchAdapterV2 != null) {
                    searchAdapterV2.notifyDataSetChanged();
                }
            }
        } else if (this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE && getInput().equals(str4)) {
            requestSearch(PageIndexParams.PageRequestType.HOME, false);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1673586074") ? ((Integer) ipChange.ipc$dispatch("-1673586074", new Object[]{this})).intValue() : R$layout.activity_search;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091407829")) {
            ipChange.ipc$dispatch("2091407829", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.mErrorPageType;
        if (i2 == 0) {
            if (this.mGetSearchFind) {
                updateFindAdvertView();
            } else {
                requestSearchFind();
            }
        } else if (i2 == 1) {
            requestSearch(PageIndexParams.PageRequestType.HOME, true);
        } else if (i2 != 2) {
        } else {
            requestSearchEggs();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779994358")) {
            ipChange.ipc$dispatch("1779994358", new Object[]{this});
        } else {
            ((SearchPresenter) this.mPresenter).setVM(this, (SearchContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164530713")) {
            ipChange.ipc$dispatch("-164530713", new Object[]{this});
            return;
        }
        this.mMainContaineLayout = (FrameLayout) findViewById(R$id.search_container);
        this.mInputEdit = (EditText) findViewById(R$id.et_keyword);
        this.mCancelTv = (TextView) findViewById(R$id.tv_cancel);
        this.mDeleteLayout = (DMIconFontTextView) findViewById(R$id.ll_delete);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mTopIv = (ImageView) findViewById(R$id.iv_top);
        this.mHeadLayoutView = findViewById(R$id.search_head_layout);
        this.mTitleView = findViewById(R$id.search_title_layout);
        this.mTitleInputView = findViewById(R$id.layout_search_input);
        this.mTempView = findViewById(R$id.temp_view);
        ms.a(this, this.mTitleInputView, false);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_error);
        this.mErrorLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.mTopIv.setVisibility(8);
        this.mDeleteLayout.setVisibility(8);
        RadioGroup radioGroup = (RadioGroup) findViewById(R$id.search_top_tab_layout);
        if (!TextUtils.isEmpty(z6.a())) {
            z6.d(this.mTitleView);
        }
        initIRecycleView();
        initEvent();
        this.mTabPanel = new SearchTabPanel(radioGroup, this.mRecyclerView, new C1592e(), new C1593f());
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void jumpAccountMainPage(BaccountInfo baccountInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1689396188")) {
            ipChange.ipc$dispatch("1689396188", new Object[]{this, baccountInfo});
        } else if (baccountInfo == null) {
        } else {
            if (this.existBrand) {
                C0529c.e().x(b82.C().n(this.mUtAAID, baccountInfo.damaiId, baccountInfo.type));
            } else {
                C0529c.e().x(b82.C().i(this.mUtAAID, baccountInfo.damaiId, baccountInfo.type, getInput(), SearchHelper.i(this.mInputState)));
            }
            x72.a(baccountInfo, this.mContext);
        }
    }

    public void jumpProjectDetailPage(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632430496")) {
            ipChange.ipc$dispatch("-632430496", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        } else if (projectItemBean == null) {
        } else {
            C0529c.e().x(b82.C().t(this.mUtAAID, projectItemBean.id, getInput(), SearchHelper.i(this.mInputState), projectItemBean.alg, i));
            InputMethodHide();
            qd2.b(this, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651701234")) {
            ipChange.ipc$dispatch("-651701234", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1006 && LoginManager.k().q()) {
            requestFollow(this.mLoginBAccountBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166744307")) {
            ipChange.ipc$dispatch("1166744307", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initTitleStatusBar();
        setDamaiUTKeyBuilder(b82.C().F(this.mKeyWords));
        C0529c.e().K(this);
        loadData(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "533789427")) {
            ipChange.ipc$dispatch("533789427", new Object[]{this});
            return;
        }
        cancelTimer();
        OrangeConfigCenter.c().g("damai_use_youku_search_api");
        super.onDestroy();
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227749904")) {
            ipChange.ipc$dispatch("227749904", new Object[]{this, view});
        } else if (this.isRequesting) {
        } else {
            requestSearch(this.mPageIndexParams.getUiLoadMorePageType(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490032114")) {
            ipChange.ipc$dispatch("-1490032114", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        loadData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452464265")) {
            ipChange.ipc$dispatch("-452464265", new Object[]{this});
            return;
        }
        super.onPause();
        cancelTimer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506296176")) {
            ipChange.ipc$dispatch("506296176", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.mPageState == SearchHelper.PageState.HOT_SEARCH_PAGE) {
            requestSearchFind();
            this.mInputEdit.setFocusable(true);
            this.mInputEdit.setFocusableInTouchMode(true);
            this.mInputEdit.requestFocus();
            this.mInputEdit.findFocus();
        }
        if (this.mIsEggs) {
            this.mOnClickListener.onClick(this.mDeleteLayout);
            this.mIsEggs = false;
        }
        recoverTimer();
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void pageRefresh(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "567132257")) {
            ipChange.ipc$dispatch("567132257", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            resetData();
            resetTitleView();
            requestSearchSuggest();
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void requestAccountFollow(BaccountInfo baccountInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184513346")) {
            ipChange.ipc$dispatch("184513346", new Object[]{this, baccountInfo});
        } else if (!LoginManager.k().q()) {
            this.mLoginBAccountBean = baccountInfo;
            LoginManager.k().x(this, new Intent(), 1006);
        } else {
            requestFollow(baccountInfo);
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void returnSearchEggs(SearchEggs searchEggs, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295365772")) {
            ipChange.ipc$dispatch("1295365772", new Object[]{this, searchEggs, str});
        } else if (this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE && str.equals(getInput())) {
            hideErrorView();
            if (searchEggs != null && (TextUtils.equals("1", searchEggs.type) || TextUtils.equals("2", searchEggs.type))) {
                stopLoading();
                if (this.mInputState == SearchHelper.InputState.USER_CLICK_SUGGEST_WORD && this.mClickSuggestWord != null) {
                    C0529c e = C0529c.e();
                    b82 C = b82.C();
                    SearchSuggest searchSuggest = this.mClickSuggestWord;
                    e.x(C.x(searchSuggest.keyword, searchSuggest.sugWord, searchSuggest.alg, searchSuggest.index));
                }
                if (TextUtils.equals("1", searchEggs.type)) {
                    showSearchEggsList(searchEggs, str);
                    return;
                } else if (!TextUtils.isEmpty(searchEggs.url)) {
                    this.mIsEggs = true;
                    DMNav.from(this).toUri(searchEggs.url);
                    return;
                }
            }
            if (this.mInputState == SearchHelper.InputState.USER_CLICK_SUGGEST_WORD && this.mClickSuggestWord != null) {
                C0529c e2 = C0529c.e();
                b82 C2 = b82.C();
                SearchSuggest searchSuggest2 = this.mClickSuggestWord;
                e2.x(C2.w(searchSuggest2.keyword, searchSuggest2.sugWord, searchSuggest2.alg, searchSuggest2.index));
            }
            requestSearch(PageIndexParams.PageRequestType.HOME, false);
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void returnSearchFindList(SearchFindWordList searchFindWordList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252300616")) {
            ipChange.ipc$dispatch("-1252300616", new Object[]{this, searchFindWordList});
        } else if (this.mPageState != SearchHelper.PageState.HOT_SEARCH_PAGE) {
        } else {
            dispatchActivityUsable();
            if (searchFindWordList != null) {
                this.mGetSearchFind = true;
                this.mSearchFindData = searchFindWordList;
                if (TextUtils.isEmpty(this.mInputDesc)) {
                    String searchTip = searchFindWordList.getSearchTip();
                    this.mInputDesc = searchTip;
                    this.mKeyWords = searchTip;
                    setSearchCustomKeyWord(searchTip);
                    updateInputEditHit(this.mInputDesc);
                }
            }
            updateFindAdvertView();
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void returnSearchListV2(SearchResultBeanV2 searchResultBeanV2, String str, PageIndexParams.Params params) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1695653066")) {
            ipChange.ipc$dispatch("-1695653066", new Object[]{this, searchResultBeanV2, str, params});
        } else if (this.mPageState == SearchHelper.PageState.SEARCH_RESULT_PAGE && this.mAdapter != null && str.equals(getInput())) {
            hideErrorView();
            dispatchActivityUsable();
            this.mPageIndexParams.updateNextPageParams(params, searchResultBeanV2);
            this.mAdapter.k(str);
            if (params.isHomeRequest()) {
                this.mUtAAID = System.currentTimeMillis() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + UTDevice.getUtdid(this);
                updateServerTime(searchResultBeanV2.currentTime);
                C0529c.e().x(b82.C().K(str, String.valueOf(searchResultBeanV2.total), SearchHelper.i(this.mInputState)));
                this.mAdapter.i(this.mUtAAID, SearchHelper.i(this.mInputState));
                if (this.mPageIndexParams.isCanShowTabLayout()) {
                    this.mTabPanel.r();
                } else {
                    this.mTabPanel.o();
                }
                this.mBAccountMap.clear();
                BaccountInfo baccountInfo = (BaccountInfo) cb2.b(searchResultBeanV2.baccountInfo, 0);
                if (baccountInfo != null) {
                    this.mBAccountMap.put(baccountInfo.damaiId, baccountInfo);
                }
                this.exitAccount = baccountInfo != null;
                this.existBrand = wh2.e(searchResultBeanV2.brandOptimization) >= 3;
                List<SearchDataHolder> h = SearchHelper.h(searchResultBeanV2, this.mUtAAID, str, this.mInputState);
                this.mDataHolderList.clear();
                if (!cb2.d(h)) {
                    this.mDataHolderList.addAll(h);
                }
                this.mAdapter.k(str);
                this.mAdapter.notifyDataSetChanged();
                loadDiscountCustomUT(searchResultBeanV2.discountInfo);
            } else if (params.isNoteNextPageRequest()) {
                Pair<Integer, Integer> q = SearchHelper.q(this.mDataHolderList, SearchHelper.k(searchResultBeanV2.contentNoteList));
                if (q != null) {
                    this.mAdapter.notifyItemRangeInserted(q.first.intValue(), q.second.intValue());
                }
            } else if (params.isProjectNextPageRequest()) {
                List<SearchDataHolder> m = SearchHelper.m(searchResultBeanV2.projectInfo);
                if (!cb2.d(m)) {
                    SearchHelper.r(this.mDataHolderList, m);
                }
                SearchHelper.c(this.mDataHolderList, !searchResultBeanV2.isEnd, str);
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void returnSearchSuggest(SearchWord searchWord, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124058052")) {
            ipChange.ipc$dispatch("2124058052", new Object[]{this, searchWord, str});
        } else if (this.mPageState == SearchHelper.PageState.SEARCH_SUGGEST_PAGE && str.equals(getInput())) {
            hideErrorView();
            if (searchWord != null) {
                r3 = searchWord.project != null;
                if (wh2.e(searchWord.words) > 0) {
                    r3 = true;
                }
            }
            if (r3) {
                updateServerTime(searchWord.currentTime);
                ProjectItemBean projectItemBean = searchWord.project;
                if (projectItemBean != null) {
                    projectItemBean.utKeyWord = getSuggestProjectWord(searchWord.words);
                }
                updateWordPage(searchWord.project, searchWord.words);
                return;
            }
            this.mDataHolderList.clear();
            SearchAdapterV2 searchAdapterV2 = this.mAdapter;
            if (searchAdapterV2 != null) {
                searchAdapterV2.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149411418")) {
            return (String) ipChange.ipc$dispatch("149411418", new Object[]{this});
        }
        this.bese_head_view.setVisibility(8);
        return "";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "552871481")) {
            ipChange.ipc$dispatch("552871481", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988137141")) {
            ipChange.ipc$dispatch("1988137141", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101209049")) {
            ipChange.ipc$dispatch("101209049", new Object[]{this, str});
        } else {
            this.isRequesting = true;
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553956716")) {
            ipChange.ipc$dispatch("-553956716", new Object[]{this});
            return;
        }
        this.isRequesting = false;
        IRecyclerView iRecyclerView = this.mRecyclerView;
        if (iRecyclerView != null) {
            iRecyclerView.setRefreshing(false);
        }
        stopProgressDialog();
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void tourCityJumpProject(SearchTourUT searchTourUT) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990101207")) {
            ipChange.ipc$dispatch("-990101207", new Object[]{this, searchTourUT});
        } else if (searchTourUT != null) {
            C0529c.e().x(b82.C().L(this.mUtAAID, searchTourUT.projectId, this.mKeyWords, SearchHelper.i(this.mInputState), searchTourUT.index));
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, searchTourUT.projectId);
            if (!TextUtils.isEmpty(searchTourUT.name)) {
                bundle.putString("projectName", searchTourUT.name);
            }
            if (!TextUtils.isEmpty(searchTourUT.verticalPic)) {
                bundle.putString("projectImage", searchTourUT.verticalPic);
            }
            qd2.a(this.mContext, searchTourUT.schema, bundle);
        }
    }

    @Override // cn.damai.search.contract.SearchContract.View
    public void updateAccountFollowState(ArtistFollowResultBean artistFollowResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379259971")) {
            ipChange.ipc$dispatch("-379259971", new Object[]{this, artistFollowResultBean});
        } else if (artistFollowResultBean != null && this.mBAccountMap.containsKey(artistFollowResultBean.getArtistId())) {
            updateAccountFollow(this.mBAccountMap.get(artistFollowResultBean.getArtistId()), artistFollowResultBean.getFollowStatus() + "");
        }
    }

    private void setPageState(SearchHelper.PageState pageState, boolean z) {
        SearchTabPanel searchTabPanel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008837336")) {
            ipChange.ipc$dispatch("2008837336", new Object[]{this, pageState, Boolean.valueOf(z)});
            return;
        }
        this.mPageState = pageState;
        if (!z || (searchTabPanel = this.mTabPanel) == null) {
            return;
        }
        searchTabPanel.o();
    }
}
