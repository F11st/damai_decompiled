package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.home.adapter.RecentShowPagerAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
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
import tb.cs;
import tb.mu0;
import tb.oy0;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RecentShowViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CUSTOMLABEL_KEY = "customLabel";
    private static final String ENDDATE_KEY = "endDate";
    private static final String STARTDATE_KEY = "startDate";
    private int currentTabIndex;
    private Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> dataMap;
    private boolean isSectionChanged;
    private Context mContext;
    private String mModuleTitle;
    private LinearLayout mModuleTitleMoreLayout;
    private TextView mModuleTitleMoreText;
    private View.OnClickListener mOnClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View.OnClickListener mOnTabItemClickListener;
    private RecentShowPagerAdapter mPagerAdapter;
    private HomeTabScrollView mTabLayout;
    private TrackInfo mTrackInfo;
    private DmViewPager mViewPager;
    private List<ScrollTitleBean> tabs;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.viewholder.RecentShowViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1862a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1862a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1207671848")) {
                ipChange.ipc$dispatch("-1207671848", new Object[]{this, view});
                return;
            }
            oy0.B().n(RecentShowViewHolder.this.mTrackInfo, RecentShowViewHolder.this.mModuleTitle);
            HomePageRecentBean.CustomLabel customLabel = (HomePageRecentBean.CustomLabel) view.getTag();
            Bundle bundle = new Bundle();
            if (customLabel != null) {
                bundle.putString(RecentShowViewHolder.CUSTOMLABEL_KEY, customLabel.text);
                bundle.putString(RecentShowViewHolder.STARTDATE_KEY, customLabel.startDate);
                bundle.putString(RecentShowViewHolder.ENDDATE_KEY, customLabel.endDate);
            }
            DMNav.from(RecentShowViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.A));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.viewholder.RecentShowViewHolder$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1863b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1863b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "903618521")) {
                ipChange.ipc$dispatch("903618521", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            RecentShowViewHolder.this.currentTabIndex = scrollTitleBean.index;
            String str = ((ScrollTitleBean) RecentShowViewHolder.this.tabs.get(scrollTitleBean.index)).name;
            if (RecentShowViewHolder.this.mViewPager != null) {
                RecentShowViewHolder.this.mViewPager.setCurrentItem(RecentShowViewHolder.this.currentTabIndex, true);
            }
            oy0.B().o(RecentShowViewHolder.this.mTrackInfo, RecentShowViewHolder.this.mModuleTitle, str, scrollTitleBean.index);
        }
    }

    public RecentShowViewHolder(View view) {
        super(view);
        this.tabs = new ArrayList();
        this.dataMap = new HashMap();
        this.currentTabIndex = 0;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: cn.damai.tetris.component.home.viewholder.RecentShowViewHolder.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1384715109")) {
                    ipChange.ipc$dispatch("-1384715109", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "908411962")) {
                    ipChange.ipc$dispatch("908411962", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "670941606")) {
                    ipChange.ipc$dispatch("670941606", new Object[]{this, Integer.valueOf(i)});
                } else {
                    RecentShowViewHolder.this.mTabLayout.selectTitle(i);
                }
            }
        };
        this.mOnClickListener = new View$OnClickListenerC1862a();
        this.mOnTabItemClickListener = new View$OnClickListenerC1863b();
        this.mContext = mu0.a();
        this.mModuleTitleMoreLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_recent_more_layout);
        this.mModuleTitleMoreText = (TextView) this.itemView.findViewById(R$id.homepage_recent_more_text);
        this.mModuleTitleMoreLayout.setOnClickListener(this.mOnClickListener);
        initTabLayout();
        initViewPager();
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private void initTabLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003970754")) {
            ipChange.ipc$dispatch("1003970754", new Object[]{this});
            return;
        }
        HomeTabScrollView homeTabScrollView = (HomeTabScrollView) this.itemView.findViewById(R$id.homepage_recent_tablayout);
        this.mTabLayout = homeTabScrollView;
        homeTabScrollView.setFontColor(R$color.color_000000, R$color.color_9c9ca5).setFontSize(16, 20).setHeight(39).setSpace(18).setOnTitleClickListener(this.mOnTabItemClickListener);
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861369501")) {
            ipChange.ipc$dispatch("-861369501", new Object[]{this});
            return;
        }
        this.mViewPager = (DmViewPager) this.itemView.findViewById(R$id.homepage_recent_viewpager);
        RecentShowPagerAdapter recentShowPagerAdapter = new RecentShowPagerAdapter();
        this.mPagerAdapter = recentShowPagerAdapter;
        this.mViewPager.setAdapter(recentShowPagerAdapter);
        this.mViewPager.addOnPageChangeListener(this.mOnPageChangeListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mViewPager.getLayoutParams();
        layoutParams.weight = -1.0f;
        layoutParams.height = t60.a(this.mContext, 234.0f);
        this.mViewPager.setLayoutParams(layoutParams);
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "33745342")) {
            ipChange.ipc$dispatch("33745342", new Object[]{this, commonBean, Boolean.valueOf(z)});
            return;
        }
        this.isSectionChanged = z;
        super.setData(commonBean, z);
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    protected void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691649578")) {
            ipChange.ipc$dispatch("-691649578", new Object[]{this, commonBean});
        } else if ((commonBean instanceof HomePageRecentBean) && this.isSectionChanged) {
            HomePageRecentBean homePageRecentBean = (HomePageRecentBean) commonBean;
            this.mTrackInfo = commonBean.trackInfo;
            this.mModuleTitle = homePageRecentBean.mainTitle;
            this.mModuleTitleMoreText.setText(homePageRecentBean.moreText);
            this.mModuleTitleMoreLayout.setVisibility(TextUtils.isEmpty(homePageRecentBean.moreText) ? 8 : 0);
            this.dataMap.clear();
            this.dataMap = homePageRecentBean.getDataMap();
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
            this.mTabLayout.setTitle(this.tabs).commit();
            this.mModuleTitleMoreLayout.setTag(homePageRecentBean.customLabel);
            this.mPagerAdapter.a(content, this.dataMap, this.mTrackInfo);
            this.currentTabIndex = 0;
            this.mTabLayout.selectTitle(0);
            this.mViewPager.setCurrentItem(this.currentTabIndex);
        }
    }
}
