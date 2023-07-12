package cn.damai.homepage.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.C0535a;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomePageData;
import cn.damai.homepage.bean.HomePageWaterFlowRecommend;
import cn.damai.homepage.request.HomeConfigRequest;
import cn.damai.homepage.request.HomePageExhibitionRequest;
import cn.damai.homepage.request.HomePageGuessRequest;
import cn.damai.homepage.request.HomeParams;
import cn.damai.homepage.request.IHomeFeedReq;
import cn.damai.homepage.ui.adapter.GuessAdapter;
import cn.damai.homepage.ui.listener.HomeGetPageListener;
import cn.damai.homepage.ui.listener.HomeGoTopOrRecommendListener;
import cn.damai.homepage.ui.listener.HomeRefreshListener;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.component.home.bean.HomeTitleBean;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.listener.IsRefreshListener;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV3;
import cn.damai.tetris.page.WrappedVirtualLayoutManager;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.cs;
import tb.e11;
import tb.fm;
import tb.g30;
import tb.gz0;
import tb.ir1;
import tb.ky0;
import tb.ly0;
import tb.m62;
import tb.m91;
import tb.mr1;
import tb.mu0;
import tb.ny0;
import tb.om;
import tb.py0;
import tb.xr;
import tb.ys;
import tb.yy0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HomeCmsFragment extends AbsFragmentV3 implements OnCityChangedListener, HomeGetPageListener, HomeGoTopOrRecommendListener, HomeRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAB_BUCKET = "ABTrackInfo";
    private static final int REQUEST_CODE_OPEN_MESSAGE_CENTER = 111;
    public static final int SCROLLY_DIS_H = 1000;
    HomePageData[] exhibitionDataCache;
    HomePageData guessDataCache;
    private MainActivity mActivity;
    private BaseResponse mBaseResponse;
    private HomeData mData;
    private GuessAdapter mGuessAdapter;
    private HomeHeaderBg mHomeHeaderBg;
    private boolean mIsCreateView;
    private boolean mIsNeedRequest;
    private List<HomeTitleBean.Title> mainTitles;
    private String module;
    private List<fm> mGuessData = new ArrayList();
    public boolean isRequest = false;
    private int mDistance = 0;
    private boolean mHasAddGuessTitle = false;
    private boolean isLoad = false;
    private int pageNum = 1;
    private int guessIndex = 0;
    private String offset = "";
    private boolean isLastPage = false;
    private String mainTitlestr = null;
    IHomeFeedReq request = new HomePageGuessRequest();
    int feedsShowTabIndex = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.5
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int itemCount;
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1663595429")) {
                ipChange.ipc$dispatch("-1663595429", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                HomeCmsFragment.this.isLoad = false;
            }
            if (i == 0) {
                if (!HomeCmsFragment.this.isLoad) {
                    HomeCmsFragment.this.handleScrollY();
                }
                if (((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager != null) {
                    int findFirstVisibleItemPosition = ((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager.findFirstVisibleItemPosition();
                    int i3 = -1;
                    int d = om.c(mu0.a()).d("dm_home_weinituijian_title");
                    RecyclerView.Adapter adapter = ((AbsFragment) HomeCmsFragment.this).mRecyclerView.getAdapter();
                    if (adapter != null && (itemCount = adapter.getItemCount()) > 0) {
                        while (true) {
                            if (i2 >= itemCount) {
                                break;
                            } else if (adapter.getItemViewType(i2) == d) {
                                i3 = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (i3 > 0) {
                        if (findFirstVisibleItemPosition >= i3) {
                            ((MainActivity) HomeCmsFragment.this.getActivity()).getTabbarManager().h().i();
                        } else {
                            ((MainActivity) HomeCmsFragment.this.getActivity()).getTabbarManager().h().h();
                        }
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1853879964")) {
                ipChange.ipc$dispatch("-1853879964", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            if (HomeCmsFragment.this.isLoad) {
                if (((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager != null) {
                    ((AbsFragmentV3) HomeCmsFragment.this).mLayoutManager.scrollToPositionWithOffset(0, 0);
                    return;
                }
                return;
            }
            ((AbsFragmentV3) HomeCmsFragment.this).mScrollY += i2;
            Log.d("mScrollY", ((AbsFragmentV3) HomeCmsFragment.this).mScrollY + "         dy" + i2 + "");
            if (((AbsFragmentV3) HomeCmsFragment.this).mIsRefreshDown) {
                return;
            }
            HomeCmsFragment.this.handleScrollY();
        }
    };

    static /* synthetic */ int access$1412(HomeCmsFragment homeCmsFragment, int i) {
        int i2 = homeCmsFragment.pageNum + i;
        homeCmsFragment.pageNum = i2;
        return i2;
    }

    private void addGradientBackground() {
        View findViewById;
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673619330")) {
            ipChange.ipc$dispatch("-673619330", new Object[]{this});
            return;
        }
        View view = getView();
        if (view == null || (findViewById = view.findViewById(R$id.tetris_root_container)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = mu0.a().getDrawable(R$drawable.homepage_shape_home_bg);
        } else {
            drawable = mu0.a().getResources().getDrawable(R$drawable.homepage_shape_home_bg);
        }
        findViewById.setBackground(drawable);
    }

    private void addTitleTab(HomePageWaterFlowRecommend homePageWaterFlowRecommend) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859434300")) {
            ipChange.ipc$dispatch("-1859434300", new Object[]{this, homePageWaterFlowRecommend});
        } else if (this.pageNum > 1) {
        } else {
            if (homePageWaterFlowRecommend == null) {
                homePageWaterFlowRecommend = new HomePageWaterFlowRecommend();
            }
            if (homePageWaterFlowRecommend.mainTitles == null) {
                homePageWaterFlowRecommend.mainTitles = new ArrayList();
            }
            py0.I().c0(this.feedsShowTabIndex);
            if (this.feedsShowTabIndex == 0) {
                this.mainTitlestr = JSON.toJSONString(homePageWaterFlowRecommend.mainTitles);
                this.mainTitles = homePageWaterFlowRecommend.mainTitles;
                py0.I().d0(this.mainTitles);
            }
            try {
                if (this.mHasAddGuessTitle) {
                    return;
                }
                this.exhibitionDataCache = new HomePageData[this.mainTitles.size()];
                addComponent(this.mBaseResponse, g30.e(this.mainTitlestr));
                this.mHasAddGuessTitle = true;
                setData(this.mBaseResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cache2Response(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775770366")) {
            ipChange.ipc$dispatch("-775770366", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ny0.b(ny0.HOMEPAGE_GET, "", getContext());
            if (TextUtils.isEmpty(str)) {
                str = C0535a.n(mu0.a().getResources().openRawResource(R$raw.default_home_cms));
                z = false;
            } else {
                z = true;
            }
        }
        try {
            BaseResponse baseResponse = (BaseResponse) JSON.parseObject(str, BaseResponse.class);
            this.mBaseResponse = baseResponse;
            if (z) {
                this.mBaseResponse = g30.a(baseResponse);
            }
            this.mHasAddGuessTitle = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateHomePage();
    }

    private HomePageExhibitionRequest genFeedRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486422575")) {
            return (HomePageExhibitionRequest) ipChange.ipc$dispatch("-486422575", new Object[]{this});
        }
        HomePageExhibitionRequest homePageExhibitionRequest = new HomePageExhibitionRequest();
        List<HomeTitleBean.Title> list = this.mainTitles;
        if (list != null && this.feedsShowTabIndex < list.size() && this.mainTitles.get(this.feedsShowTabIndex) != null) {
            homePageExhibitionRequest.groupId = this.mainTitles.get(this.feedsShowTabIndex).groupId;
            homePageExhibitionRequest.dispatchCardCode = this.mainTitles.get(this.feedsShowTabIndex).dispatchCardCode;
        }
        return homePageExhibitionRequest;
    }

    private String getTitle(List<HomeTitleBean.Title> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644609276")) {
            return (String) ipChange.ipc$dispatch("-1644609276", new Object[]{this, list});
        }
        if (list == null || this.feedsShowTabIndex >= list.size() || list.get(this.feedsShowTabIndex) == null) {
            return null;
        }
        return list.get(this.feedsShowTabIndex).name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScrollY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969299321")) {
            ipChange.ipc$dispatch("1969299321", new Object[]{this});
            return;
        }
        WrappedVirtualLayoutManager wrappedVirtualLayoutManager = this.mLayoutManager;
        if (wrappedVirtualLayoutManager == null) {
            return;
        }
        int findFirstVisibleItemPosition = wrappedVirtualLayoutManager.findFirstVisibleItemPosition();
        View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        this.mDistance = 0;
        if (findFirstVisibleItemPosition <= 2) {
            this.mDistance = findViewByPosition != null ? Math.abs(findViewByPosition.getTop()) : 0;
        } else {
            this.mDistance = m62.a(this.mActivity, 1000.0f);
        }
        HomeTopBgListener homeTopBgListener = this.mHomeTopBgListener;
        if (homeTopBgListener != null) {
            homeTopBgListener.scrollY(this.mDistance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasHomePageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395321841")) {
            return ((Boolean) ipChange.ipc$dispatch("-395321841", new Object[]{this})).booleanValue();
        }
        BaseResponse baseResponse = this.mBaseResponse;
        return (baseResponse == null || cb2.d(baseResponse.layers)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133782739")) {
            ipChange.ipc$dispatch("133782739", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        BaseResponse baseResponse = this.mBaseResponse;
        if (baseResponse != null && !m91.a(baseResponse.layers) && !z) {
            updateHomePage();
        } else if (z) {
            HomeParams homeParams = new HomeParams();
            requestCdn(homeParams.getPatternName(), homeParams.getVersion(), z20.c());
        } else {
            cache2Response(false, null);
        }
    }

    public static HomeCmsFragment newInstance(HomeTopBgListener homeTopBgListener, IsRefreshListener isRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141749317")) {
            return (HomeCmsFragment) ipChange.ipc$dispatch("-1141749317", new Object[]{homeTopBgListener, isRefreshListener});
        }
        HomeCmsFragment homeCmsFragment = new HomeCmsFragment();
        homeCmsFragment.setArguments(new Bundle());
        homeCmsFragment.mHomeTopBgListener = homeTopBgListener;
        homeCmsFragment.mIsRefreshListener = isRefreshListener;
        return homeCmsFragment;
    }

    private void requestConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787595380")) {
            ipChange.ipc$dispatch("-1787595380", new Object[]{this});
        } else {
            new HomeConfigRequest().request(new DMMtopRequestListener<HomeConfigBean>(HomeConfigBean.class) { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1625400819")) {
                        ipChange2.ipc$dispatch("1625400819", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(HomeConfigBean homeConfigBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2137924237")) {
                        ipChange2.ipc$dispatch("2137924237", new Object[]{this, homeConfigBean});
                    } else if (HomeCmsFragment.this.isVisible()) {
                        if (homeConfigBean == null) {
                            onFail("", "");
                            return;
                        }
                        HomeConfigBean k = yy0.k();
                        if (k != null) {
                            homeConfigBean = k;
                        }
                        String d = g30.d(homeConfigBean);
                        if (!TextUtils.isEmpty(d)) {
                            xr.c(HomeMessage.SEARCH_WORD, d);
                        }
                        HomeCmsFragment.this.mHomeHeaderBg = g30.c(homeConfigBean);
                        HomeCmsFragment homeCmsFragment = HomeCmsFragment.this;
                        if (homeCmsFragment.mHomeTopBgListener != null && homeCmsFragment.mHomeHeaderBg != null) {
                            HomeCmsFragment homeCmsFragment2 = HomeCmsFragment.this;
                            homeCmsFragment2.mHomeTopBgListener.onUpdateBg(homeCmsFragment2.mHomeHeaderBg);
                        }
                        g30.g(homeConfigBean);
                        if (homeConfigBean.pop != null) {
                            HomeCmsFragment.this.mData.lottieType = homeConfigBean.pop.iconType;
                            ky0.d().i(homeConfigBean);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestGuess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030269307")) {
            ipChange.ipc$dispatch("-1030269307", new Object[]{this});
            return;
        }
        requestConfig();
        if (z20.K()) {
            IHomeFeedReq homePageGuessRequest = this.feedsShowTabIndex == 0 ? new HomePageGuessRequest() : genFeedRequest();
            this.request = homePageGuessRequest;
            requestHomePageGuessData(1, homePageGuessRequest);
        }
    }

    private void requestHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943005937")) {
            ipChange.ipc$dispatch("-1943005937", new Object[]{this});
            return;
        }
        HomeParams homeParams = new HomeParams();
        homeParams.comboDamaiCityId = z20.c();
        final TetrisRequest tetrisRequest = new TetrisRequest(homeParams);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void dispatchStringResult(String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1845564157")) {
                    ipChange2.ipc$dispatch("1845564157", new Object[]{this, str});
                } else if (TextUtils.isEmpty(str)) {
                } else {
                    ny0.c(ny0.HOMEPAGE_GET, str, mu0.a());
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-734538774")) {
                    ipChange2.ipc$dispatch("-734538774", new Object[]{this, str, str2});
                    return;
                }
                ((AbsFragmentV3) HomeCmsFragment.this).mRefreshLayout.refreshComplete();
                gz0.d(tetrisRequest.getApiName(), str, str2, z20.c());
                HomeCmsFragment.this.loadCache(true);
                if (HomeCmsFragment.this.hasHomePageData()) {
                    HomeCmsFragment.this.requestGuess();
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1638267668")) {
                    ipChange2.ipc$dispatch("1638267668", new Object[]{this, baseResponse});
                } else if (HomeCmsFragment.this.isVisible()) {
                    ((AbsFragmentV3) HomeCmsFragment.this).mRefreshLayout.refreshComplete();
                    HomeCmsFragment.this.mIsNeedRequest = false;
                    if (baseResponse != null && !m91.a(baseResponse.layers)) {
                        HomeCmsFragment.this.mBaseResponse = g30.a(baseResponse);
                        HomeCmsFragment.this.mHasAddGuessTitle = false;
                        HomeCmsFragment.this.mData.feedIndex = g30.b(HomeCmsFragment.this.mBaseResponse);
                        HomeCmsFragment.this.updateHomePage();
                        HomeCmsFragment.this.requestGuess();
                        return;
                    }
                    onFail("", "");
                }
            }
        });
    }

    private void requestHomePageGuessData(final int i, final IHomeFeedReq iHomeFeedReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978910485")) {
            ipChange.ipc$dispatch("-978910485", new Object[]{this, Integer.valueOf(i), iHomeFeedReq});
            return;
        }
        showLoading(null);
        this.request = iHomeFeedReq;
        iHomeFeedReq.setCityId(String.valueOf(z20.c()));
        if (ir1.i(mr1.LOCATION)) {
            IHomeFeedReq iHomeFeedReq2 = this.request;
            iHomeFeedReq2.setLatitude(z20.n() + "");
            IHomeFeedReq iHomeFeedReq3 = this.request;
            iHomeFeedReq3.setLongitude(z20.o() + "");
        }
        this.request.setPageNum(i == -1 ? this.pageNum : i);
        if (this.pageNum == 1) {
            this.offset = "";
            this.isLastPage = false;
        }
        this.request.setOffset(this.offset);
        ((DMBaseMtopRequest) this.request).request(new DMMtopRequestListener<HomePageData>(HomePageData.class) { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1617641460")) {
                    ipChange2.ipc$dispatch("1617641460", new Object[]{this, str, str2});
                    return;
                }
                if (!e11.b().c(str)) {
                    gz0.a("mtop.damai.wireless.home.guess.get", str, str2, z20.c());
                }
                if (HomeCmsFragment.this.isVisible()) {
                    HomeCmsFragment.this.showLoadError(null);
                    HomeCmsFragment.this.showEmptyList(iHomeFeedReq);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(HomePageData homePageData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2128455769")) {
                    ipChange2.ipc$dispatch("-2128455769", new Object[]{this, homePageData});
                } else if (HomeCmsFragment.this.isVisible()) {
                    if (i <= 1) {
                        HomeCmsFragment.this.resetIndex();
                    }
                    if (HomeCmsFragment.this.updateGuess(homePageData)) {
                        if (HomeCmsFragment.this.pageNum == 1) {
                            if (iHomeFeedReq instanceof HomePageGuessRequest) {
                                HomeCmsFragment.this.guessDataCache = homePageData;
                            } else {
                                HomeCmsFragment homeCmsFragment = HomeCmsFragment.this;
                                homeCmsFragment.exhibitionDataCache[homeCmsFragment.feedsShowTabIndex] = homePageData;
                            }
                        }
                        HomeCmsFragment.access$1412(HomeCmsFragment.this, 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582635414")) {
            ipChange.ipc$dispatch("-1582635414", new Object[]{this});
            return;
        }
        this.mGuessData.clear();
        GuessAdapter guessAdapter = this.mGuessAdapter;
        if (guessAdapter != null) {
            guessAdapter.b();
        }
        this.pageNum = 1;
        this.guessIndex = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmptyList(IHomeFeedReq iHomeFeedReq) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722254208")) {
            ipChange.ipc$dispatch("-722254208", new Object[]{this, iHomeFeedReq});
        } else if (this.pageNum == 1) {
            this.mGuessData.clear();
            GuessAdapter guessAdapter = this.mGuessAdapter;
            if (guessAdapter != null) {
                guessAdapter.b();
                this.mGuessAdapter.notifyDataSetChanged();
            }
            if (iHomeFeedReq instanceof HomePageGuessRequest) {
                this.guessDataCache = null;
                return;
            }
            HomePageData[] homePageDataArr = this.exhibitionDataCache;
            if (homePageDataArr == null || (i = this.feedsShowTabIndex) >= homePageDataArr.length) {
                return;
            }
            homePageDataArr[i] = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateGuess(HomePageData homePageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652795269")) {
            return ((Boolean) ipChange.ipc$dispatch("652795269", new Object[]{this, homePageData})).booleanValue();
        }
        showLoadInit(null);
        HomePageWaterFlowRecommend b = ly0.b(homePageData);
        if (b != null && !m91.a(b.content)) {
            this.offset = b.offset;
            List<fm> a = ly0.a(this.pageNum, this.guessIndex, b.content);
            if (m91.a(a)) {
                showLoadEnd(null);
                addTitleTab(b);
                return false;
            }
            if (this.pageNum == 1) {
                addTitleTab(b);
                this.mGuessData.addAll(a);
                this.mGuessAdapter.a(true, getTitle(b.mainTitles), this.mGuessData);
            } else {
                this.mGuessData.addAll(a);
                this.mGuessAdapter.a(false, getTitle(b.mainTitles), a);
            }
            this.guessIndex = this.mGuessData.size() - 1;
            if (!TextUtils.isEmpty(b.isLast) && "1".equals(b.isLast)) {
                this.isLastPage = true;
            }
            if (this.isLastPage) {
                showLoadEnd(b.lastPage);
            }
            return true;
        }
        showEmptyList(this.request);
        showLoadEnd(null);
        addTitleTab(b);
        return false;
    }

    private void updateHomeAB() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089372164")) {
            ipChange.ipc$dispatch("1089372164", new Object[]{this});
        } else if (getProperties() != null) {
            C0529c.e().O(getActivity(), getProperties());
            Log.e("abtest", "  home updateHomeAB updatePageProperties size: " + getProperties().size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289712822")) {
            ipChange.ipc$dispatch("289712822", new Object[]{this});
            return;
        }
        BaseResponse baseResponse = this.mBaseResponse;
        if (baseResponse == null || m91.a(baseResponse.layers)) {
            return;
        }
        setData(this.mBaseResponse);
    }

    @Override // cn.damai.homepage.ui.listener.HomeGetPageListener
    public int getDistance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1750527621") ? ((Integer) ipChange.ipc$dispatch("1750527621", new Object[]{this})).intValue() : this.mDistance;
    }

    @Override // cn.damai.homepage.ui.listener.HomeGoTopOrRecommendListener
    public void goTop(boolean z) {
        int itemCount;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2022216036")) {
            ipChange.ipc$dispatch("2022216036", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mLayoutManager == null || !isVisible()) {
        } else {
            if (z) {
                this.mLayoutManager.scrollToPositionWithOffset(0, 0);
            } else if (this.mRecyclerView != null) {
                int i2 = this.mData.feedIndex;
                int d = om.c(mu0.a()).d("dm_home_weinituijian_title");
                RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
                if (adapter != null && (itemCount = adapter.getItemCount()) > 0) {
                    while (true) {
                        if (i >= itemCount) {
                            break;
                        } else if (adapter.getItemViewType(i) == d) {
                            i2 = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                this.mLayoutManager.scrollToPositionWithOffset(i2, 5);
            }
        }
    }

    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711324915")) {
            ipChange.ipc$dispatch("711324915", new Object[]{this});
        } else if (z20.l()) {
            HomeParams homeParams = new HomeParams();
            requestCdn(homeParams.getPatternName(), homeParams.getVersion(), z20.c());
        } else {
            requestHome();
        }
    }

    public void loadCacheAndRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632181629")) {
            ipChange.ipc$dispatch("632181629", new Object[]{this});
        } else if (!isVisible() || this.mRefreshLayout == null) {
        } else {
            DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
            if (damaiRootRecyclerView != null) {
                damaiRootRecyclerView.scrollToPosition(0);
            }
            loadCache(false);
            this.mRefreshLayout.autoRefresh();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948051969")) {
            ipChange.ipc$dispatch("-1948051969", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 111) {
            DMNav.from(getActivity()).toUri(NavUri.b(cs.x));
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onCdnResponse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028190312")) {
            ipChange.ipc$dispatch("-2028190312", new Object[]{this, str});
            return;
        }
        super.onCdnResponse(str);
        cache2Response(false, str);
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406506798")) {
            ipChange.ipc$dispatch("406506798", new Object[]{this});
            return;
        }
        this.mIsNeedRequest = true;
        loadCacheAndRefresh();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322300130")) {
            ipChange.ipc$dispatch("1322300130", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mIsCreateView = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060249822")) {
            ipChange.ipc$dispatch("-1060249822", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        Log.e("abtest", "  home onHiddenChanged : " + z);
        if (z) {
            ys.d().n();
        } else {
            ys.d().g();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513893761")) {
            ipChange.ipc$dispatch("-513893761", new Object[]{this, view});
        } else if (z20.K()) {
            IHomeFeedReq homePageGuessRequest = this.feedsShowTabIndex == 0 ? new HomePageGuessRequest() : genFeedRequest();
            this.request = homePageGuessRequest;
            requestHomePageGuessData(this.pageNum, homePageGuessRequest);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243496010")) {
            ipChange.ipc$dispatch("1243496010", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 1 && (obj instanceof ScrollTitleBean)) {
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) obj;
            resetIndex();
            int i2 = scrollTitleBean.index;
            this.feedsShowTabIndex = i2;
            if (i2 == 0) {
                HomePageData homePageData = this.guessDataCache;
                if (homePageData == null) {
                    requestHomePageGuessData(1, new HomePageGuessRequest());
                } else if (updateGuess(homePageData)) {
                    this.pageNum++;
                }
            } else {
                HomePageData[] homePageDataArr = this.exhibitionDataCache;
                if (homePageDataArr != null && homePageDataArr[i2] != null) {
                    if (updateGuess(homePageDataArr[i2])) {
                        this.pageNum++;
                    }
                } else {
                    requestHomePageGuessData(1, genFeedRequest());
                }
            }
            py0.I().P(scrollTitleBean.name, scrollTitleBean.index);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790812966")) {
            ipChange.ipc$dispatch("790812966", new Object[]{this});
            return;
        }
        super.onPause();
        Log.e("abtest", "  home onResume");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459618207")) {
            ipChange.ipc$dispatch("-459618207", new Object[]{this});
            return;
        }
        showLoadInit(null);
        this.mGuessData.clear();
        this.guessDataCache = null;
        HomePageData[] homePageDataArr = this.exhibitionDataCache;
        if (homePageDataArr != null) {
            this.exhibitionDataCache = new HomePageData[homePageDataArr.length];
        }
        GuessAdapter guessAdapter = this.mGuessAdapter;
        if (guessAdapter != null) {
            guessAdapter.b();
        }
        this.pageNum = 1;
        this.guessIndex = 0;
        if (AppConfig.g().equals(AppConfig.EnvMode.prepare) && z20.j()) {
            z20.l0(false);
        }
        initData();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393184673")) {
            ipChange.ipc$dispatch("393184673", new Object[]{this});
            return;
        }
        super.onResume();
        this.isRequest = false;
        Log.e("abtest", "  home onResume :" + getUserVisibleHint());
        if (getProperties() != null) {
            C0529c.e().O(getActivity(), getProperties());
            Log.e("abtest", "abs onResume updatePageProperties : size : " + getProperties().size());
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833917754")) {
            ipChange.ipc$dispatch("833917754", new Object[]{this});
        } else {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038512660")) {
            ipChange.ipc$dispatch("-2038512660", new Object[]{this});
        } else {
            super.onStop();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV3, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666633669")) {
            ipChange.ipc$dispatch("-666633669", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.isLoad = true;
        this.mIsCreateView = true;
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mActivity = mainActivity;
        this.mData = mainActivity.getData();
        disAbleToTop();
        enableDividerLine(false);
        this.mLoadMoreView.setBackgroundColor(Color.parseColor("#f3f4f5"));
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        this.mGuessAdapter = new GuessAdapter(this.mActivity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mGuessAdapter);
        this.mPageContainer.addSubAdapters(arrayList);
        this.module = "bizTypeHome";
        DTemplateManager.q("bizTypeHome").p(DTemplateManager.CacheStrategy.STRATEGY_DEFAULT);
        loadCacheAndRefresh();
        new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1661600635")) {
                    ipChange2.ipc$dispatch("-1661600635", new Object[]{this});
                } else {
                    HomeCmsFragment.this.isLoad = false;
                }
            }
        }, 600L);
    }

    @Override // cn.damai.homepage.ui.listener.HomeRefreshListener
    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355426664")) {
            ipChange.ipc$dispatch("-1355426664", new Object[]{this});
            return;
        }
        this.mIsNeedRequest = true;
        loadCacheAndRefresh();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546878707")) {
            ipChange.ipc$dispatch("546878707", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        Log.e("abtest", "  home setUserVisibleHint : " + z);
        if (z) {
            this.isLoad = false;
        } else {
            updateHomeAB();
        }
    }

    public void showExhibitionTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184610316")) {
            ipChange.ipc$dispatch("-184610316", new Object[]{this});
        } else if (this.mLayoutManager == null || !isVisible()) {
        } else {
            goTop(false);
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1650799136")) {
                        ipChange2.ipc$dispatch("1650799136", new Object[]{this});
                        return;
                    }
                    HomeCmsFragment.this.sendMsg(new Message(2, 1));
                    new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.ui.fragment.HomeCmsFragment.6.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1078662733")) {
                                ipChange3.ipc$dispatch("-1078662733", new Object[]{this});
                            } else {
                                HomeCmsFragment.this.goTop(false);
                            }
                        }
                    }, 500L);
                }
            }, 800L);
        }
    }
}
