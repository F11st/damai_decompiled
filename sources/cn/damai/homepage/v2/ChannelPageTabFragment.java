package cn.damai.homepage.v2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.HomeTabListBean;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.homepage.request.HomeTabRequest;
import cn.damai.homepage.ui.adapter.TabPagerAdapter;
import cn.damai.homepage.ui.fragment.HomeCmsFragment;
import cn.damai.homepage.ui.fragment.HomeTabFragment;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import cn.damai.homepage.v2.ChannelPageTabFragment;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.listener.IsRefreshListener;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.resource.widget.YKActionSheet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb2;
import tb.cs;
import tb.k50;
import tb.kg2;
import tb.m91;
import tb.py0;
import tb.t60;
import tb.xy0;
import tb.yh;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class ChannelPageTabFragment extends DamaiBaseMvpFragment<AbstractC0470a<Object, Object>, BaseModel> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C1252a Companion = new C1252a(null);
    @NotNull
    public static final String EXTRA = "extra_key";
    @Nullable
    private final ChannelPageActivity mActivity;
    private int mCurIndex;
    @Nullable
    private HomeTabBean mOldSelectTab;
    @Nullable
    private TabPagerAdapter mPagerAdapter;
    @Nullable
    private HomeTabScrollView mScrollView;
    @Nullable
    private DMIconFontTextView mSearchBack;
    @Nullable
    private TextView mSearchBtn;
    @Nullable
    private DMUpMarqueeView mSearchText;
    @Nullable
    private LinearLayout mSearchView;
    @Nullable
    private HomeTabBean mSelectTab;
    @Nullable
    private HomeTabBean mSelectTab2;
    @Nullable
    private final HomeTabFragment.OnTabClickListener mTabClickListener;
    @Nullable
    private TabExtra mTabExtra;
    @Nullable
    private View mTitleBar;
    @Nullable
    private ViewPager mViewPager;
    @Nullable
    private List<HomeTabBean> mHomeTabBeanList = new ArrayList();
    @NotNull
    private final List<ScrollTitleBean> mTabList = new ArrayList();
    private int mOldPosition = -1;
    @NotNull
    private final IsRefreshListener mHomeIsRefreshListener = new IsRefreshListener() { // from class: tb.vh
        @Override // cn.damai.tetris.listener.IsRefreshListener
        public final void isRrefresh(boolean z) {
            ChannelPageTabFragment.m51mHomeIsRefreshListener$lambda0(z);
        }
    };
    @NotNull
    private final HomeTopBgListener mHomeTopBgListener = new C1253b();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.ChannelPageTabFragment$a */
    /* loaded from: classes14.dex */
    public static final class C1252a {
        private C1252a() {
        }

        public /* synthetic */ C1252a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.ChannelPageTabFragment$b */
    /* loaded from: classes5.dex */
    public static final class C1253b implements HomeTopBgListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1253b() {
        }

        @Override // cn.damai.homepage.ui.listener.HomeTopBgListener
        public void onUpdateBg(@Nullable HomeHeaderBg homeHeaderBg) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-324528959")) {
                ipChange.ipc$dispatch("-324528959", new Object[]{this, homeHeaderBg});
            }
        }

        @Override // cn.damai.homepage.ui.listener.HomeTopBgListener
        @SuppressLint({"NewApi"})
        public void scrollY(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1568378835")) {
                ipChange.ipc$dispatch("-1568378835", new Object[]{this, Integer.valueOf(i)});
            }
        }
    }

    private final void addRefItemId2HomeTabBeanIfNeed(List<? extends HomeTabBean> list, int i, TabExtra tabExtra) {
        HomeTabBean homeTabBean;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-159032175")) {
            ipChange.ipc$dispatch("-159032175", new Object[]{this, list, Integer.valueOf(i), tabExtra});
            return;
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z || tabExtra == null || TextUtils.isEmpty(tabExtra.referItemId) || (homeTabBean = (HomeTabBean) cb2.b(list, i)) == null || !yh.f(tabExtra, homeTabBean)) {
            return;
        }
        homeTabBean.putArgs(MainActivity.KEY_REF_ITEM_ID, tabExtra.referItemId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changePage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523032827")) {
            ipChange.ipc$dispatch("-1523032827", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mOldPosition == i) {
        } else {
            this.mOldPosition = i;
            HomeTabFragment.OnTabClickListener onTabClickListener = this.mTabClickListener;
            if (onTabClickListener != null) {
                onTabClickListener.onTabSelect(i);
            }
            HomeTabScrollView homeTabScrollView = this.mScrollView;
            if (homeTabScrollView != null) {
                homeTabScrollView.selectTitle(i);
            }
            this.mOldSelectTab = this.mSelectTab;
            ScrollTitleBean scrollTitleBean = this.mTabList.get(i);
            b41.g(scrollTitleBean, "null cannot be cast to non-null type cn.damai.commonbusiness.home.bean.HomeTabBean");
            this.mSelectTab = (HomeTabBean) scrollTitleBean;
            ScrollTitleBean scrollTitleBean2 = this.mTabList.get(i);
            b41.g(scrollTitleBean2, "null cannot be cast to non-null type cn.damai.commonbusiness.home.bean.HomeTabBean");
            this.mSelectTab2 = (HomeTabBean) scrollTitleBean2;
            if (this.mSelectTab == null) {
                return;
            }
            this.mCurIndex = i;
            C0529c e = C0529c.e();
            xy0 g = xy0.g();
            int i2 = this.mCurIndex;
            HomeTabBean homeTabBean = this.mSelectTab;
            e.x(g.f(i2, homeTabBean != null ? homeTabBean.name : null));
        }
    }

    private final View createView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1476239192")) {
            return (View) ipChange.ipc$dispatch("-1476239192", new Object[]{this, str});
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.channel_page_bar_text, (ViewGroup) null);
        b41.h(inflate, "from(context)\n          …nnel_page_bar_text, null)");
        View findViewById = inflate.findViewById(R$id.channel_search_text);
        b41.h(findViewById, "view.findViewById(R.id.channel_search_text)");
        ((TextView) findViewById).setText(str);
        inflate.setTag(str);
        return inflate;
    }

    private final void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "699057547")) {
            ipChange.ipc$dispatch("699057547", new Object[]{this});
        } else if (getArguments() != null) {
            this.mTabExtra = (TabExtra) requireArguments().getParcelable("extra_key");
        }
    }

    private final void initStatueBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025902766")) {
            ipChange.ipc$dispatch("2025902766", new Object[]{this});
            return;
        }
        View findViewById = this.rootView.findViewById(R$id.status_bar_space);
        Activity activity = super.mActivity;
        if (activity != null) {
            int a = t60.a(activity, 45.0f);
            if (Build.VERSION.SDK_INT >= 23) {
                if (findViewById != null) {
                    findViewById.getLayoutParams().height = kg2.a(activity);
                    findViewById.setVisibility(0);
                    a = t60.a(activity, 45.0f) + kg2.a(activity);
                }
                kg2.f(requireActivity(), true, R$color.black);
                kg2.d(true, activity);
            } else {
                kg2.f(requireActivity(), false, R$color.black);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                a = t60.a(activity, 45.0f);
            }
            View view = this.mTitleBar;
            ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
            if (layoutParams == null) {
                return;
            }
            layoutParams.height = a;
        }
    }

    private final void initTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099053800")) {
            ipChange.ipc$dispatch("2099053800", new Object[]{this});
            return;
        }
        this.mScrollView = (HomeTabScrollView) this.rootView.findViewById(R$id.horScrollView);
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.viewpager);
    }

    @SuppressLint({"NewApi"})
    private final void initTitleBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2090162898")) {
            ipChange.ipc$dispatch("2090162898", new Object[]{this});
            return;
        }
        this.mTitleBar = this.rootView.findViewById(R$id.channel_header_bar);
        this.mSearchBack = (DMIconFontTextView) this.rootView.findViewById(R$id.channel_header_back);
        this.mSearchView = (LinearLayout) this.rootView.findViewById(R$id.channel_header_search_layout);
        this.mSearchText = (DMUpMarqueeView) this.rootView.findViewById(R$id.channel_header_search);
        this.mSearchBtn = (TextView) this.rootView.findViewById(R$id.channel_header_search_btn);
        DMUpMarqueeView dMUpMarqueeView = this.mSearchText;
        if (dMUpMarqueeView != null) {
            dMUpMarqueeView.setFlipInterval(5000);
        }
        DMUpMarqueeView dMUpMarqueeView2 = this.mSearchText;
        if (dMUpMarqueeView2 != null) {
            dMUpMarqueeView2.setAnimationDuration(500L);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : HomePageGuideBar.Companion.a()) {
            arrayList.add(createView(str));
        }
        DMUpMarqueeView dMUpMarqueeView3 = this.mSearchText;
        if (dMUpMarqueeView3 != null) {
            dMUpMarqueeView3.setItems(arrayList);
        }
        DMIconFontTextView dMIconFontTextView = this.mSearchBack;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setOnClickListener(new View.OnClickListener() { // from class: tb.sh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChannelPageTabFragment.m48initTitleBar$lambda2(ChannelPageTabFragment.this, view);
                }
            });
        }
        DMUpMarqueeView dMUpMarqueeView4 = this.mSearchText;
        if (dMUpMarqueeView4 != null) {
            dMUpMarqueeView4.setOnItemClickListener(new DMUpMarqueeView.OnItemClickListener() { // from class: tb.wh
                @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
                public final void onItemClick(int i, View view) {
                    ChannelPageTabFragment.m49initTitleBar$lambda3(ChannelPageTabFragment.this, i, view);
                }
            });
        }
        TextView textView = this.mSearchBtn;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tb.rh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChannelPageTabFragment.m50initTitleBar$lambda4(ChannelPageTabFragment.this, view);
                }
            });
        }
        py0.I().a0(this.mSearchView, JSON.toJSONString(HomePageGuideBar.Companion.a()), py0.CHANNEL_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initTitleBar$lambda-2  reason: not valid java name */
    public static final void m48initTitleBar$lambda2(ChannelPageTabFragment channelPageTabFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1762299815")) {
            ipChange.ipc$dispatch("-1762299815", new Object[]{channelPageTabFragment, view});
            return;
        }
        b41.i(channelPageTabFragment, "this$0");
        ((DamaiBaseMvpFragment) channelPageTabFragment).mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initTitleBar$lambda-3  reason: not valid java name */
    public static final void m49initTitleBar$lambda3(ChannelPageTabFragment channelPageTabFragment, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055044041")) {
            ipChange.ipc$dispatch("1055044041", new Object[]{channelPageTabFragment, Integer.valueOf(i), view});
            return;
        }
        b41.i(channelPageTabFragment, "this$0");
        channelPageTabFragment.jumpSearch(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initTitleBar$lambda-4  reason: not valid java name */
    public static final void m50initTitleBar$lambda4(ChannelPageTabFragment channelPageTabFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808359657")) {
            ipChange.ipc$dispatch("-808359657", new Object[]{channelPageTabFragment, view});
            return;
        }
        b41.i(channelPageTabFragment, "this$0");
        channelPageTabFragment.jumpSearch(true);
    }

    private final void jumpSearch(boolean z) {
        String str;
        View currentView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041919379")) {
            ipChange.ipc$dispatch("-1041919379", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            DMUpMarqueeView dMUpMarqueeView = this.mSearchText;
            Object tag = (dMUpMarqueeView == null || (currentView = dMUpMarqueeView.getCurrentView()) == null) ? null : currentView.getTag();
            b41.g(tag, "null cannot be cast to non-null type kotlin.String");
            str = (String) tag;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("autowords", str);
            C0529c.e().x(py0.I().s(str));
        } else {
            C0529c.e().x(py0.I().t(str));
        }
        bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
        bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
        DMNav.from(getContext()).withExtras(bundle).toUri(NavUri.b(cs.o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mHomeIsRefreshListener$lambda-0  reason: not valid java name */
    public static final void m51mHomeIsRefreshListener$lambda0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409203748")) {
            ipChange.ipc$dispatch("-1409203748", new Object[]{Boolean.valueOf(z)});
        }
    }

    private final void setViewPaperItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36296830")) {
            ipChange.ipc$dispatch("36296830", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            Field declaredField = Class.forName("android.support.v4.view.ViewPager").getDeclaredField("mCurItem");
            declaredField.setAccessible(true);
            declaredField.setInt(this.mViewPager, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void tabExposure() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265287729")) {
            ipChange.ipc$dispatch("1265287729", new Object[]{this});
            return;
        }
        try {
            HomeTabScrollView homeTabScrollView = this.mScrollView;
            LinearLayout linearLayout = (LinearLayout) (homeTabScrollView != null ? homeTabScrollView.getChildAt(0) : null);
            if (linearLayout == null) {
                return;
            }
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt != null && this.mTabList.size() > i) {
                    ScrollTitleBean scrollTitleBean = this.mTabList.get(i);
                    b41.g(scrollTitleBean, "null cannot be cast to non-null type cn.damai.commonbusiness.home.bean.HomeTabBean");
                    xy0.g().j(childAt, py0.CHANNEL_PAGE, i, ((HomeTabBean) scrollTitleBean).name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTab(HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053815717")) {
            ipChange.ipc$dispatch("2053815717", new Object[]{this, homeTabListBean});
        } else if (yh.g(homeTabListBean)) {
            this.mTabList.clear();
            List<HomeTabBean> d = yh.d(homeTabListBean);
            this.mHomeTabBeanList = d;
            this.mCurIndex = yh.c(this.mTabExtra, d);
            List<HomeTabBean> list = this.mHomeTabBeanList;
            if (list != null) {
                this.mTabList.addAll(list);
            }
            HomeTabScrollView homeTabScrollView = this.mScrollView;
            b41.f(homeTabScrollView);
            homeTabScrollView.setFontColor(R$color.color_000000, R$color.color_9C9CA5).setFontSize(16, 20).setTitle(this.mTabList).setHeight(44).setDefaultPadding(11).setOnTitleClickListener(new View.OnClickListener() { // from class: tb.th
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChannelPageTabFragment.m52updateTab$lambda6(ChannelPageTabFragment.this, view);
                }
            }).commit();
            HomeTabScrollView homeTabScrollView2 = this.mScrollView;
            b41.f(homeTabScrollView2);
            homeTabScrollView2.selectTitle(this.mCurIndex);
            ScrollTitleBean scrollTitleBean = this.mTabList.get(this.mCurIndex);
            b41.g(scrollTitleBean, "null cannot be cast to non-null type cn.damai.commonbusiness.home.bean.HomeTabBean");
            this.mSelectTab = (HomeTabBean) scrollTitleBean;
            updateViewPager(this.mHomeTabBeanList);
            tabExposure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateTab$lambda-6  reason: not valid java name */
    public static final void m52updateTab$lambda6(ChannelPageTabFragment channelPageTabFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50866598")) {
            ipChange.ipc$dispatch("50866598", new Object[]{channelPageTabFragment, view});
            return;
        }
        b41.i(channelPageTabFragment, "this$0");
        ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
        if (scrollTitleBean == null || channelPageTabFragment.mViewPager == null || !cb2.g(channelPageTabFragment.mTabList)) {
            return;
        }
        try {
            ScrollTitleBean scrollTitleBean2 = channelPageTabFragment.mTabList.get(scrollTitleBean.index);
            b41.g(scrollTitleBean2, "null cannot be cast to non-null type cn.damai.commonbusiness.home.bean.HomeTabBean");
            channelPageTabFragment.mSelectTab2 = (HomeTabBean) scrollTitleBean2;
            ViewPager viewPager = channelPageTabFragment.mViewPager;
            b41.f(viewPager);
            viewPager.setCurrentItem(scrollTitleBean.index);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CMSTAB", "TabClick error " + e.getMessage());
        }
    }

    private final void updateViewPager(List<? extends HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531866857")) {
            ipChange.ipc$dispatch("1531866857", new Object[]{this, list});
            return;
        }
        TabPagerAdapter tabPagerAdapter = this.mPagerAdapter;
        HomeCmsFragment b = tabPagerAdapter != null ? tabPagerAdapter.b() : null;
        if (m91.a(list)) {
            return;
        }
        if (this.mPagerAdapter != null && b != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            b41.h(childFragmentManager, "childFragmentManager");
            childFragmentManager.beginTransaction().remove(b).commit();
        }
        addRefItemId2HomeTabBeanIfNeed(list, this.mCurIndex, this.mTabExtra);
        setViewPaperItem(this.mCurIndex);
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        b41.h(childFragmentManager2, "childFragmentManager");
        TabPagerAdapter tabPagerAdapter2 = new TabPagerAdapter(childFragmentManager2, list, this.mHomeTopBgListener, this.mHomeIsRefreshListener);
        this.mPagerAdapter = tabPagerAdapter2;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setAdapter(tabPagerAdapter2);
        }
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.homepage.v2.ChannelPageTabFragment$updateViewPager$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "977562470")) {
                        ipChange2.ipc$dispatch("977562470", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                @SuppressLint({"NewApi"})
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "171425285")) {
                        ipChange2.ipc$dispatch("171425285", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1519766991")) {
                        ipChange2.ipc$dispatch("-1519766991", new Object[]{this, Integer.valueOf(i)});
                    } else {
                        ChannelPageTabFragment.this.changePage(i);
                    }
                }
            });
        }
        ViewPager viewPager3 = this.mViewPager;
        b41.f(viewPager3);
        viewPager3.setCurrentItem(this.mCurIndex);
        PageUtExecutor pageUtExecutor = new PageUtExecutor(super.mActivity, new PageUtExecutor.UTKeyBuilderProvider() { // from class: tb.uh
            @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.UTKeyBuilderProvider
            public final C0525a.C0527b get(int i) {
                C0525a.C0527b m53updateViewPager$lambda7;
                m53updateViewPager$lambda7 = ChannelPageTabFragment.m53updateViewPager$lambda7(ChannelPageTabFragment.this, i);
                return m53updateViewPager$lambda7;
            }
        });
        ViewPager viewPager4 = this.mViewPager;
        b41.f(viewPager4);
        viewPager4.addOnPageChangeListener(pageUtExecutor);
        pageUtExecutor.onPageSelected(this.mCurIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateViewPager$lambda-7  reason: not valid java name */
    public static final C0525a.C0527b m53updateViewPager$lambda7(ChannelPageTabFragment channelPageTabFragment, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422609142")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1422609142", new Object[]{channelPageTabFragment, Integer.valueOf(i)});
        }
        b41.i(channelPageTabFragment, "this$0");
        List<ScrollTitleBean> list = channelPageTabFragment.mTabList;
        if (list != null) {
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) cb2.b(list, i);
            if (scrollTitleBean instanceof HomeTabBean) {
                return new C0525a.C0527b().i(((HomeTabBean) scrollTitleBean).spmb).a(z20.d());
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final Fragment getCurFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775605483")) {
            return (Fragment) ipChange.ipc$dispatch("1775605483", new Object[]{this});
        }
        TabPagerAdapter tabPagerAdapter = this.mPagerAdapter;
        if (tabPagerAdapter != null) {
            return tabPagerAdapter.a();
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-868279214") ? ((Integer) ipChange.ipc$dispatch("-868279214", new Object[]{this})).intValue() : R$layout.channel_page_tab_fragment;
    }

    public final int getMCurIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "904586887") ? ((Integer) ipChange.ipc$dispatch("904586887", new Object[]{this})).intValue() : this.mCurIndex;
    }

    @Nullable
    public final HomeTabBean getMOldSelectTab() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1551958135") ? (HomeTabBean) ipChange.ipc$dispatch("1551958135", new Object[]{this}) : this.mOldSelectTab;
    }

    @Nullable
    public final HomeTabBean getMSelectTab() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-81758866") ? (HomeTabBean) ipChange.ipc$dispatch("-81758866", new Object[]{this}) : this.mSelectTab;
    }

    @Nullable
    public final HomeTabBean getMSelectTab2() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1843756080") ? (HomeTabBean) ipChange.ipc$dispatch("-1843756080", new Object[]{this}) : this.mSelectTab2;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808887798")) {
            ipChange.ipc$dispatch("808887798", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676579061")) {
            ipChange.ipc$dispatch("676579061", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1639646584")) {
            ipChange.ipc$dispatch("-1639646584", new Object[]{this});
            return;
        }
        initTitleBar();
        initStatueBar();
        initTab();
        updateTab(null);
        requestTabData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632712594")) {
            ipChange.ipc$dispatch("-632712594", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639904878")) {
            return (View) ipChange.ipc$dispatch("-639904878", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        super.mActivity = (ChannelPageActivity) getActivity();
        initBundle();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049837682")) {
            ipChange.ipc$dispatch("2049837682", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    public final void requestTabData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373351213")) {
            ipChange.ipc$dispatch("373351213", new Object[]{this});
        } else {
            new HomeTabRequest().request(new DMMtopRequestListener<HomeTabListBean>(HomeTabListBean.class) { // from class: cn.damai.homepage.v2.ChannelPageTabFragment$requestTabData$listener$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(@NotNull String str, @NotNull String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1222278725")) {
                        ipChange2.ipc$dispatch("1222278725", new Object[]{this, str, str2});
                        return;
                    }
                    b41.i(str, "s");
                    b41.i(str2, "s1");
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(@Nullable HomeTabListBean homeTabListBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-465153284")) {
                        ipChange2.ipc$dispatch("-465153284", new Object[]{this, homeTabListBean});
                    } else {
                        ChannelPageTabFragment.this.updateTab(homeTabListBean);
                    }
                }
            });
        }
    }

    public final void setMCurIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440976739")) {
            ipChange.ipc$dispatch("440976739", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mCurIndex = i;
        }
    }

    public final void setMOldSelectTab(@Nullable HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482225069")) {
            ipChange.ipc$dispatch("-482225069", new Object[]{this, homeTabBean});
        } else {
            this.mOldSelectTab = homeTabBean;
        }
    }

    public final void setMSelectTab(@Nullable HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995386924")) {
            ipChange.ipc$dispatch("-1995386924", new Object[]{this, homeTabBean});
        } else {
            this.mSelectTab = homeTabBean;
        }
    }

    public final void setMSelectTab2(@Nullable HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395296538")) {
            ipChange.ipc$dispatch("1395296538", new Object[]{this, homeTabBean});
        } else {
            this.mSelectTab2 = homeTabBean;
        }
    }

    public final void setSelectTab(@Nullable TabExtra tabExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392430983")) {
            ipChange.ipc$dispatch("1392430983", new Object[]{this, tabExtra});
        } else if (tabExtra == null) {
        } else {
            this.mTabExtra = tabExtra;
            int c = yh.c(tabExtra, this.mHomeTabBeanList);
            HomeTabScrollView homeTabScrollView = this.mScrollView;
            if (homeTabScrollView != null) {
                homeTabScrollView.selectTitle(c);
            }
            ViewPager viewPager = this.mViewPager;
            if (viewPager == null) {
                return;
            }
            viewPager.setCurrentItem(c);
        }
    }
}
