package cn.damai.search.v2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$raw;
import cn.damai.onearch.errpage.ErrorControlView;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.v2.SearchActivity;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.bean.SearchExtra;
import cn.damai.search.v2.bean.SearchResultTabBean;
import cn.damai.search.v2.fragment.SearchHistoryFragment;
import cn.damai.search.v2.listener.ISearchUIController;
import cn.damai.search.v2.listener.OnEggListener;
import cn.damai.search.v2.listener.OnHisWordClickListener;
import cn.damai.search.v2.listener.OnSearchInputListener;
import cn.damai.search.v2.listener.SearchInputObserver;
import cn.damai.search.v2.tool.SearchEggManager;
import cn.damai.search.v2.tool.SearchInputManager;
import cn.damai.search.v2.view.DownFocusViewFlipper;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.tabs.TabLayout;
import com.taobao.weex.ui.component.helper.SoftKeyboardDetector;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.BaseViewPagerAdapter;
import com.youku.arch.v3.page.GenericActivity;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import tb.bf0;
import tb.c82;
import tb.cb1;
import tb.lp0;
import tb.on1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class SearchActivity extends GenericActivity implements ErrorControlView, ISearchUIController, TabLayout.OnTabSelectedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PAGE_SEARCH_EGG_INDEX = 3;
    public static final int PAGE_SEARCH_HISTORY_INDEX = 0;
    public static final int PAGE_SEARCH_RESULT_INDEX = 2;
    public static final int PAGE_SUGGEST_WORD_INDEX = 1;
    private volatile boolean isSearchResultPageInitiated = false;
    private SearchEggManager mEggManager;
    private bf0 mErrControlImpl;
    private SearchInputObserver mHistoryObserver;
    private SearchInputManager mInputManager;
    private ViewGroup mTabUi;
    public C0525a.C0527b mUTBuilder;
    private DownFocusViewFlipper pageContainer;
    private TabLayout searchResultTabLayout;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class SearchResultTabRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        private SearchResultTabRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        public IRequest build(Map<String, ?> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1606973387")) {
                return (IRequest) ipChange.ipc$dispatch("1606973387", new Object[]{this, map});
            }
            Uri parse = Uri.parse("android.resource://" + SearchActivity.this.getPackageName() + "/" + R$raw.damai_search_result_tab_list);
            Bundle bundle = new Bundle();
            bundle.putParcelable("uri", parse);
            Request build = new Request.Builder().setStrategy(Constants.RequestStrategy.LOCAL_FILE).setRequestId(IdGenerator.getId()).setDataParams(new HashMap()).build();
            build.setBundle(bundle);
            return build;
        }

        /* synthetic */ SearchResultTabRequestBuilder(SearchActivity searchActivity, C1635a c1635a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.SearchActivity$a */
    /* loaded from: classes6.dex */
    public class C1635a implements DownFocusViewFlipper.OnDispatchDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1635a() {
        }

        @Override // cn.damai.search.v2.view.DownFocusViewFlipper.OnDispatchDownListener
        public void onDispatchDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "380818637")) {
                ipChange.ipc$dispatch("380818637", new Object[]{this});
            } else if (SoftKeyboardDetector.isKeyboardVisible(SearchActivity.this)) {
                SoftInputUtils.a(SearchActivity.this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.SearchActivity$b */
    /* loaded from: classes6.dex */
    public class C1636b implements OnSearchInputListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.v2.SearchActivity$b$a */
        /* loaded from: classes6.dex */
        public class C1637a implements OnEggListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ InputInfo a;

            C1637a(InputInfo inputInfo) {
                this.a = inputInfo;
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void onEggFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1305911271")) {
                    ipChange.ipc$dispatch("-1305911271", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                SearchActivity.this.mHistoryObserver.dispatchInputWord(this.a);
                if (!z) {
                    SearchActivity.this.confirmSearchWordForSearchResult(this.a);
                }
                c82.s(this.a);
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void showLoading(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "488402623")) {
                    ipChange.ipc$dispatch("488402623", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                SearchActivity.this.showDialogLoading(z);
                if (z) {
                    return;
                }
                SearchActivity.this.pageContainer.setVisibility(0);
            }
        }

        C1636b() {
        }

        @Override // cn.damai.search.v2.listener.OnSearchInputListener
        public void onSearchInputClick(InputInfo inputInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1493590813")) {
                ipChange.ipc$dispatch("1493590813", new Object[]{this, inputInfo});
            } else if (SearchActivity.this.mEggManager == null) {
            } else {
                SearchActivity.this.mEggManager.i(inputInfo.inputText, new C1637a(inputInfo));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.SearchActivity$c */
    /* loaded from: classes6.dex */
    public class C1638c implements OnHisWordClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.v2.SearchActivity$c$a */
        /* loaded from: classes6.dex */
        public class C1639a implements OnEggListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1639a() {
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void onEggFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1094560358")) {
                    ipChange.ipc$dispatch("-1094560358", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                } else {
                    SearchActivity searchActivity = SearchActivity.this;
                    searchActivity.confirmSearchWordForSearchResult(searchActivity.mInputManager.getCurrentInputInfo());
                }
            }

            @Override // cn.damai.search.v2.listener.OnEggListener
            public void showLoading(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "699753536")) {
                    ipChange.ipc$dispatch("699753536", new Object[]{this, Boolean.valueOf(z)});
                } else {
                    SearchActivity.this.showDialogLoading(z);
                }
            }
        }

        C1638c() {
        }

        @Override // cn.damai.search.v2.listener.OnHisWordClickListener
        public void onHistoryWordClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "217093368")) {
                ipChange.ipc$dispatch("217093368", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            SearchActivity.this.mInputManager.m(str);
            SearchActivity.this.mEggManager.i(str, new C1639a());
        }
    }

    private void addSearchResultTabView(CharSequence charSequence, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1478783432")) {
            ipChange.ipc$dispatch("-1478783432", new Object[]{this, charSequence, Integer.valueOf(i)});
            return;
        }
        TabLayout.Tab tabAt = this.searchResultTabLayout.getTabAt(i);
        TextView textView = new TextView(this);
        textView.setText(charSequence);
        textView.setGravity(17);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(getResources().getColor(R$color.color_999999));
        if (tabAt != null) {
            tabAt.setCustomView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void confirmSearchWordForSearchResult(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338330306")) {
            ipChange.ipc$dispatch("338330306", new Object[]{this, inputInfo});
            return;
        }
        this.pageContainer.setDisplayedChild(2);
        if (!this.isSearchResultPageInitiated) {
            load(new HashMap());
            return;
        }
        int tabCount = this.searchResultTabLayout.getTabCount();
        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                View customView = this.searchResultTabLayout.getTabAt(i).getCustomView();
                if (customView instanceof TextView) {
                    c82.i(customView, i, ((TextView) customView).getText().toString(), this.mInputManager.getCurrentInputInfo());
                }
            }
        }
        SearchResultViewPagerAdapter searchResultViewPagerAdapter = (SearchResultViewPagerAdapter) getViewPagerAdapter();
        for (int i2 = 0; i2 < getViewPagerAdapter().getFragments().size(); i2++) {
            WeakReference<Fragment> valueAt = searchResultViewPagerAdapter.getFragments().valueAt(i2);
            if (valueAt.get() != null && (valueAt.get() instanceof SearchInputObserver)) {
                ((SearchInputObserver) valueAt.get()).dispatchInputWord(inputInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$onTabDataLoaded$0(List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929184710")) {
            return ipChange.ipc$dispatch("-1929184710", new Object[]{this, list});
        }
        this.searchResultTabLayout.setupWithViewPager(getViewPager());
        this.searchResultTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        getViewPager().setOffscreenPageLimit(list.size());
        ((SearchResultViewPagerAdapter) getViewPagerAdapter()).setDataset(list);
        ((SearchResultViewPagerAdapter) getViewPagerAdapter()).notifyDataSetChanged();
        for (int i = 0; i < list.size(); i++) {
            addSearchResultTabView(((SearchResultTabBean) list.get(i)).title, i);
        }
        if (this.searchResultTabLayout.getTabCount() > 0) {
            this.isSearchResultPageInitiated = true;
            confirmSearchWordForSearchResult(this.mInputManager.getCurrentInputInfo());
            TabLayout.Tab tabAt = this.searchResultTabLayout.getTabAt(0);
            if (tabAt != null) {
                onTabSelected(tabAt);
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    @Nullable
    public ViewGroup getErrContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-142855944") ? (ViewGroup) ipChange.ipc$dispatch("-142855944", new Object[]{this}) : this.mTabUi;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    @Nullable
    public Activity getErrContainerActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "901599354") ? (Activity) ipChange.ipc$dispatch("901599354", new Object[]{this}) : this;
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1945287341") ? ((Integer) ipChange.ipc$dispatch("-1945287341", new Object[]{this})).intValue() : R$layout.activity_search_v2;
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    protected String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1771187743") ? (String) ipChange.ipc$dispatch("-1771187743", new Object[]{this}) : "search_home";
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    public RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1007257046") ? (RequestBuilder) ipChange.ipc$dispatch("1007257046", new Object[]{this}) : new SearchResultTabRequestBuilder(this, null);
    }

    public SearchInputManager getSearchInputManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1844877180") ? (SearchInputManager) ipChange.ipc$dispatch("1844877180", new Object[]{this}) : this.mInputManager;
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    protected int getViewPagerResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "776801295") ? ((Integer) ipChange.ipc$dispatch("776801295", new Object[]{this})).intValue() : R$id.search_v2_search_result;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void hideErrView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917244615")) {
            ipChange.ipc$dispatch("917244615", new Object[]{this});
            return;
        }
        bf0 bf0Var = this.mErrControlImpl;
        if (bf0Var != null) {
            bf0Var.hideErrView();
        }
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    protected BaseViewPagerAdapter initViewPageAdapter(FragmentManager fragmentManager) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1606621923") ? (BaseViewPagerAdapter) ipChange.ipc$dispatch("1606621923", new Object[]{this, fragmentManager}) : new SearchResultViewPagerAdapter(this, fragmentManager);
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public boolean isErrViewShown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368370542")) {
            return ((Boolean) ipChange.ipc$dispatch("1368370542", new Object[]{this})).booleanValue();
        }
        bf0 bf0Var = this.mErrControlImpl;
        if (bf0Var != null) {
            return bf0Var.isErrViewShown();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488886036")) {
            ipChange.ipc$dispatch("488886036", new Object[]{this, bundle});
            return;
        }
        supportRequestWindowFeature(1);
        setRequestedOrientation(1);
        super.onCreate(bundle);
        lp0 lp0Var = lp0.INSTANCE;
        lp0Var.b(this, bundle);
        if (getIntent() != null) {
            lp0Var.b(this, getIntent().getExtras());
        }
        SearchExtra obtainExtra = SearchExtra.obtainExtra(this);
        boolean a = on1.a();
        cb1.c("SearchOSwitch", "isDowngrade2OldPage " + a);
        if (a) {
            DMNav.from(this).withExtras(SearchExtra.makeBundle2OldSearch(obtainExtra)).toHost("home_search_bak");
            finish();
            return;
        }
        this.pageContainer = (DownFocusViewFlipper) findViewById(R$id.page_container);
        this.searchResultTabLayout = (TabLayout) findViewById(R$id.search_result_tab_layout);
        this.mTabUi = (ViewGroup) findViewById(R$id.search_v2_word_tab_ui);
        if (!TextUtils.isEmpty(obtainExtra.autowords)) {
            this.pageContainer.setVisibility(4);
        }
        this.pageContainer.setListener(new C1635a());
        SearchInputManager searchInputManager = new SearchInputManager(this, this, findViewById(R$id.header_search_v2_ui), this.pageContainer.getChildAt(1), obtainExtra, new C1636b());
        this.mInputManager = searchInputManager;
        searchInputManager.p();
        this.mEggManager = new SearchEggManager(this, this.pageContainer.getChildAt(3), this, this.mInputManager);
        SearchHistoryFragment searchHistoryFragment = SearchHistoryFragment.getInstance(new C1638c());
        this.mHistoryObserver = searchHistoryFragment;
        getSupportFragmentManager().beginTransaction().add(R$id.search_v2_search_history_layout, searchHistoryFragment).commitAllowingStateLoss();
        this.pageContainer.setDisplayedChild(0);
        this.mErrControlImpl = new bf0(this);
        this.mUTBuilder = c82.f(obtainExtra.keywords);
        C0529c.e().m(this);
        C0529c.e().K(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781455532")) {
            ipChange.ipc$dispatch("-1781455532", new Object[]{this});
            return;
        }
        super.onDestroy();
        bf0 bf0Var = this.mErrControlImpl;
        if (bf0Var != null) {
            bf0Var.showDialogLoading(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138671592")) {
            ipChange.ipc$dispatch("-1138671592", new Object[]{this});
            return;
        }
        super.onPause();
        C0529c.e().q(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708705519")) {
            ipChange.ipc$dispatch("708705519", new Object[]{this});
            return;
        }
        super.onResume();
        C0529c.e().n(this, this.mUTBuilder);
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    public void onTabDataLoaded(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1379023782")) {
            ipChange.ipc$dispatch("1379023782", new Object[]{this, jSONObject});
            return;
        }
        final List<SearchResultTabBean> parseTabData = parseTabData(jSONObject);
        getActivityContext().runOnUIThreadLocked(new Function0() { // from class: tb.t72
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object lambda$onTabDataLoaded$0;
                lambda$onTabDataLoaded$0 = SearchActivity.this.lambda$onTabDataLoaded$0(parseTabData);
                return lambda$onTabDataLoaded$0;
            }
        });
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7352645")) {
            ipChange.ipc$dispatch("-7352645", new Object[]{this, tab});
            return;
        }
        Fragment fragment = getViewPagerAdapter().getFragment(tab.getPosition());
        if (fragment instanceof ISearchTabSwitch) {
            ((ISearchTabSwitch) fragment).onPageEnter();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656131634")) {
            ipChange.ipc$dispatch("-656131634", new Object[]{this, tab});
            return;
        }
        TextView textView = (TextView) tab.getCustomView();
        if (textView == null) {
            return;
        }
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(-16777216);
        Fragment fragment = getViewPagerAdapter().getFragment(tab.getPosition());
        if (fragment instanceof ISearchTabSwitch) {
            ((ISearchTabSwitch) fragment).onPageEnter();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695733397")) {
            ipChange.ipc$dispatch("1695733397", new Object[]{this, tab});
            return;
        }
        TextView textView = (TextView) tab.getCustomView();
        if (textView == null) {
            return;
        }
        textView.setTextSize(1, 15.0f);
        textView.setTextColor(getResources().getColor(R$color.color_999999));
        Fragment fragment = getViewPagerAdapter().getFragment(tab.getPosition());
        if (fragment instanceof ISearchTabSwitch) {
            ((ISearchTabSwitch) fragment).onPageExit();
        }
    }

    @Override // com.youku.arch.v3.page.GenericActivity
    protected List<SearchResultTabBean> parseTabData(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-253046394") ? (List) ipChange.ipc$dispatch("-253046394", new Object[]{this, jSONObject}) : jSONObject.getJSONArray("data").toJavaList(SearchResultTabBean.class);
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void showDialogLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "795534780")) {
            ipChange.ipc$dispatch("795534780", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        bf0 bf0Var = this.mErrControlImpl;
        if (bf0Var != null) {
            bf0Var.showDialogLoading(z);
        }
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void showErrView(ErrControlViewInfo errControlViewInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120115376")) {
            ipChange.ipc$dispatch("-2120115376", new Object[]{this, errControlViewInfo});
            return;
        }
        bf0 bf0Var = this.mErrControlImpl;
        if (bf0Var != null) {
            try {
                bf0Var.showErrView(errControlViewInfo);
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // cn.damai.search.v2.listener.ISearchUIController
    public void showUi(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59329671")) {
            ipChange.ipc$dispatch("-59329671", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        C0529c.e().v("hotsearch_list", "search");
        C0529c.e().v("searchhistory", "search");
        this.pageContainer.setDisplayedChild(i);
    }

    public void switchSearchResultTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476527920")) {
            ipChange.ipc$dispatch("476527920", new Object[]{this, Integer.valueOf(i)});
        } else if (getViewPager().getAdapter() == null || getViewPager().getAdapter().getCount() <= i || i <= 0) {
        } else {
            getViewPager().setCurrentItem(i, true);
        }
    }
}
