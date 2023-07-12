package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.home.adapter.RecentShowPagerAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.viewholder.WantSeeViewHolder;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.mu0;
import tb.oy0;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class WantSeeViewHolder extends CommonViewHolder<HomePageRecentBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int currentTabIndex;
    @NotNull
    private Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> dataMap;
    private boolean isSectionChanged;
    @Nullable
    private Context mContext;
    @Nullable
    private String mModuleTitle;
    @NotNull
    private final ViewPager.OnPageChangeListener mOnPageChangeListener;
    @NotNull
    private final View.OnClickListener mOnTabItemClickListener;
    @Nullable
    private RecentShowPagerAdapter mPagerAdapter;
    @Nullable
    private HomeTabScrollView mTabLayout;
    @Nullable
    private TrackInfo mTrackInfo;
    @Nullable
    private DmViewPager mViewPager;
    @NotNull
    private final List<ScrollTitleBean> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantSeeViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.tabs = new ArrayList();
        this.dataMap = new HashMap();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: cn.damai.tetris.component.home.viewholder.WantSeeViewHolder$mOnPageChangeListener$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1097176701")) {
                    ipChange.ipc$dispatch("-1097176701", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1483221282")) {
                    ipChange.ipc$dispatch("1483221282", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                HomeTabScrollView homeTabScrollView;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "805617806")) {
                    ipChange.ipc$dispatch("805617806", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                homeTabScrollView = WantSeeViewHolder.this.mTabLayout;
                b41.f(homeTabScrollView);
                homeTabScrollView.selectTitle(i);
            }
        };
        this.mOnTabItemClickListener = new View.OnClickListener() { // from class: tb.s03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WantSeeViewHolder.m78mOnTabItemClickListener$lambda0(WantSeeViewHolder.this, view2);
            }
        };
        this.mContext = mu0.a();
        initTabLayout();
        initViewPager();
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void initTabLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111439515")) {
            ipChange.ipc$dispatch("-1111439515", new Object[]{this});
            return;
        }
        View findViewById = this.itemView.findViewById(R$id.homepage_want_see_tablayout);
        b41.g(findViewById, "null cannot be cast to non-null type cn.damai.tetris.component.home.widget.HomeTabScrollView");
        HomeTabScrollView homeTabScrollView = (HomeTabScrollView) findViewById;
        this.mTabLayout = homeTabScrollView;
        b41.f(homeTabScrollView);
        homeTabScrollView.setFontColor(R$color.color_000000, R$color.color_9c9ca5).setFontSize(16, 20).setHeight(39).setSpace(18).setOnTitleClickListener(this.mOnTabItemClickListener);
    }

    private final void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318187526")) {
            ipChange.ipc$dispatch("1318187526", new Object[]{this});
            return;
        }
        View findViewById = this.itemView.findViewById(R$id.homepage_want_see_viewpager);
        b41.g(findViewById, "null cannot be cast to non-null type cn.damai.commonbusiness.view.DmViewPager");
        this.mViewPager = (DmViewPager) findViewById;
        this.mPagerAdapter = new RecentShowPagerAdapter();
        DmViewPager dmViewPager = this.mViewPager;
        b41.f(dmViewPager);
        dmViewPager.setAdapter(this.mPagerAdapter);
        DmViewPager dmViewPager2 = this.mViewPager;
        b41.f(dmViewPager2);
        dmViewPager2.addOnPageChangeListener(this.mOnPageChangeListener);
        DmViewPager dmViewPager3 = this.mViewPager;
        b41.f(dmViewPager3);
        ViewGroup.LayoutParams layoutParams = dmViewPager3.getLayoutParams();
        b41.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.weight = -1.0f;
        layoutParams2.height = t60.a(this.mContext, 234.0f);
        DmViewPager dmViewPager4 = this.mViewPager;
        b41.f(dmViewPager4);
        dmViewPager4.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mOnTabItemClickListener$lambda-0  reason: not valid java name */
    public static final void m78mOnTabItemClickListener$lambda0(WantSeeViewHolder wantSeeViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990564434")) {
            ipChange.ipc$dispatch("1990564434", new Object[]{wantSeeViewHolder, view});
            return;
        }
        b41.i(wantSeeViewHolder, "this$0");
        Object tag = view.getTag();
        b41.g(tag, "null cannot be cast to non-null type cn.damai.uikit.snake.ScrollTitleBean");
        ScrollTitleBean scrollTitleBean = (ScrollTitleBean) tag;
        int i = scrollTitleBean.index;
        wantSeeViewHolder.currentTabIndex = i;
        String str = wantSeeViewHolder.tabs.get(i).name;
        DmViewPager dmViewPager = wantSeeViewHolder.mViewPager;
        if (dmViewPager != null) {
            b41.f(dmViewPager);
            dmViewPager.setCurrentItem(wantSeeViewHolder.currentTabIndex, true);
        }
        oy0.B().A(wantSeeViewHolder.mTrackInfo, wantSeeViewHolder.mModuleTitle, str, scrollTitleBean.index);
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(@Nullable CommonBean commonBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880899387")) {
            ipChange.ipc$dispatch("880899387", new Object[]{this, commonBean, Boolean.valueOf(z)});
            return;
        }
        this.isSectionChanged = z;
        super.setData(commonBean, z);
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    protected void setData(@NotNull CommonBean commonBean) {
        HomeTabScrollView title;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582603961")) {
            ipChange.ipc$dispatch("582603961", new Object[]{this, commonBean});
            return;
        }
        b41.i(commonBean, "bean");
        if ((commonBean instanceof HomePageRecentBean) && this.isSectionChanged) {
            this.mTrackInfo = commonBean.trackInfo;
            HomePageRecentBean homePageRecentBean = (HomePageRecentBean) commonBean;
            this.mModuleTitle = homePageRecentBean.mainTitle;
            this.dataMap.clear();
            Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> wantSeeDataMap = homePageRecentBean.getWantSeeDataMap();
            b41.h(wantSeeDataMap, "bean.wantSeeDataMap");
            this.dataMap = wantSeeDataMap;
            this.tabs.clear();
            ArrayList<String> content = homePageRecentBean.getContent();
            int e = wh2.e(content);
            for (int i = 0; i < e; i++) {
                ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
                scrollTitleBean.id = String.valueOf(i);
                scrollTitleBean.name = content.get(i);
                scrollTitleBean.index = i;
                this.tabs.add(scrollTitleBean);
            }
            HomeTabScrollView homeTabScrollView = this.mTabLayout;
            if (homeTabScrollView != null && (title = homeTabScrollView.setTitle(this.tabs)) != null) {
                title.commit();
            }
            oy0.B().H(this.mTrackInfo, this.mTabLayout, this.tabs);
            RecentShowPagerAdapter recentShowPagerAdapter = this.mPagerAdapter;
            if (recentShowPagerAdapter != null) {
                recentShowPagerAdapter.a(content, this.dataMap, this.mTrackInfo);
            }
            this.currentTabIndex = 0;
            HomeTabScrollView homeTabScrollView2 = this.mTabLayout;
            if (homeTabScrollView2 != null) {
                homeTabScrollView2.selectTitle(0);
            }
            DmViewPager dmViewPager = this.mViewPager;
            if (dmViewPager == null) {
                return;
            }
            dmViewPager.setCurrentItem(this.currentTabIndex);
        }
    }
}
