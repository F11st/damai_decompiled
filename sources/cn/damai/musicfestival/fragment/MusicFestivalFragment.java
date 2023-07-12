package cn.damai.musicfestival.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.homepage.ui.listener.HomeGetPageListener;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.musicfestival.bean.AtmosphereBean;
import cn.damai.musicfestival.model.MusicFestivalModel;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MusicFestivalFragment extends AbsFragmentV2 implements OnCityChangedListener, HomeGetPageListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_TAB = "tab";
    private HomeTabBean mArgs;
    private String mChangedCityId;
    private ContainerArg mInsetArg;
    private int mScrollDistance;
    private HomeTopBgListener mTopBgListener;
    private boolean isViewCreated = false;
    private MusicFestivalModel mModel = new MusicFestivalModel();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.musicfestival.fragment.MusicFestivalFragment$a */
    /* loaded from: classes6.dex */
    public class C1481a implements OnBizListener<Pair<BaseResponse, AtmosphereBean>> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.musicfestival.fragment.MusicFestivalFragment$a$a */
        /* loaded from: classes6.dex */
        public class C1482a implements OnErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1482a() {
            }

            @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
            public void onClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "297314990")) {
                    ipChange.ipc$dispatch("297314990", new Object[]{this});
                } else {
                    MusicFestivalFragment.this.load(true);
                }
            }
        }

        C1481a(boolean z) {
            this.a = z;
        }

        @Override // cn.damai.tetris.componentplugin.OnBizListener
        /* renamed from: a */
        public void onSuccess(Pair<BaseResponse, AtmosphereBean> pair) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1984979494")) {
                ipChange.ipc$dispatch("-1984979494", new Object[]{this, pair});
                return;
            }
            if (this.a) {
                MusicFestivalFragment.this.stopProgressDialog();
            }
            MusicFestivalFragment.this.hideErrorViewV2();
            MusicFestivalFragment.this.refreshFinish();
            MusicFestivalFragment.this.setData((BaseResponse) pair.first);
            MusicFestivalFragment.this.updateHomeAtmosphere((AtmosphereBean) pair.second);
        }

        @Override // cn.damai.tetris.componentplugin.OnBizListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-719222659")) {
                ipChange.ipc$dispatch("-719222659", new Object[]{this, str, str2});
                return;
            }
            if (this.a) {
                MusicFestivalFragment.this.stopProgressDialog();
            }
            MusicFestivalFragment.this.refreshFinish();
            MusicFestivalFragment.this.showErrorViewV2(str, str2, new C1482a());
        }
    }

    static /* synthetic */ int access$012(MusicFestivalFragment musicFestivalFragment, int i) {
        int i2 = musicFestivalFragment.mScrollDistance + i;
        musicFestivalFragment.mScrollDistance = i2;
        return i2;
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004744016")) {
            ipChange.ipc$dispatch("2004744016", new Object[]{this});
            return;
        }
        this.mScrollDistance = 0;
        updateScrollDistance();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.musicfestival.fragment.MusicFestivalFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "208848957")) {
                    ipChange2.ipc$dispatch("208848957", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                MusicFestivalFragment.access$012(MusicFestivalFragment.this, i2);
                if (MusicFestivalFragment.this.mScrollDistance < 0) {
                    MusicFestivalFragment.this.mScrollDistance = 0;
                }
                MusicFestivalFragment.this.updateScrollDistance();
            }
        });
    }

    public static MusicFestivalFragment getInstance(HomeTabBean homeTabBean, HomeTopBgListener homeTopBgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106553182")) {
            return (MusicFestivalFragment) ipChange.ipc$dispatch("-2106553182", new Object[]{homeTabBean, homeTopBgListener});
        }
        MusicFestivalFragment musicFestivalFragment = new MusicFestivalFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable(KEY_TAB, homeTabBean);
        }
        musicFestivalFragment.setArguments(bundle);
        musicFestivalFragment.mTopBgListener = homeTopBgListener;
        return musicFestivalFragment;
    }

    private boolean isVisibleToUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291362360")) {
            return ((Boolean) ipChange.ipc$dispatch("-291362360", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return getUserVisibleHint() && this.isViewCreated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043907550")) {
            ipChange.ipc$dispatch("-1043907550", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mChangedCityId = null;
        if (z) {
            startProgressDialog();
        }
        this.mModel.load(new C1481a(z));
    }

    private void obtainBundleArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871743380")) {
            ipChange.ipc$dispatch("1871743380", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mArgs = (HomeTabBean) arguments.getSerializable(KEY_TAB);
        }
        HomeTabBean homeTabBean = this.mArgs;
        if (homeTabBean != null) {
            this.mInsetArg = new ContainerArg(homeTabBean.patternName, homeTabBean.patternVersion, homeTabBean.args);
        } else {
            this.mInsetArg = ContainerArg.defaultMusicFestivalArg();
        }
    }

    private void reloadIfCityChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382176321")) {
            ipChange.ipc$dispatch("-382176321", new Object[]{this});
        } else if (!isVisibleToUser() || TextUtils.isEmpty(this.mChangedCityId)) {
        } else {
            load(false);
        }
    }

    private void setContainerArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990834652")) {
            ipChange.ipc$dispatch("1990834652", new Object[]{this});
            return;
        }
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(this.mInsetArg);
        }
    }

    private void setLoadMoreViewColourless() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524690603")) {
            ipChange.ipc$dispatch("1524690603", new Object[]{this});
            return;
        }
        View loadMoreFooterView = this.mRecyclerView.getLoadMoreFooterView();
        if (loadMoreFooterView != null) {
            loadMoreFooterView.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomeAtmosphere(AtmosphereBean atmosphereBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606983207")) {
            ipChange.ipc$dispatch("-1606983207", new Object[]{this, atmosphereBean});
            return;
        }
        HomeTabBean homeTabBean = this.mArgs;
        int i = homeTabBean == null ? 4 : homeTabBean.type;
        String str = atmosphereBean == null ? null : atmosphereBean.bgImg;
        HomeHeaderBg homeHeaderBg = new HomeHeaderBg(null, i, str, TextUtils.isEmpty(str) ? null : "#FFFFFF");
        HomeTopBgListener homeTopBgListener = this.mTopBgListener;
        if (homeTopBgListener != null) {
            homeTopBgListener.onUpdateBg(homeHeaderBg);
            updateScrollDistance();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScrollDistance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007819603")) {
            ipChange.ipc$dispatch("-2007819603", new Object[]{this});
            return;
        }
        HomeTopBgListener homeTopBgListener = this.mTopBgListener;
        if (homeTopBgListener != null) {
            homeTopBgListener.scrollY(this.mScrollDistance);
            cb1.c("HomeDis", "updateScrollDistance =" + this.mScrollDistance);
        }
    }

    @Override // cn.damai.homepage.ui.listener.HomeGetPageListener
    public int getDistance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1068222618") ? ((Integer) ipChange.ipc$dispatch("1068222618", new Object[]{this})).intValue() : this.mScrollDistance;
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805927774")) {
            ipChange.ipc$dispatch("1805927774", new Object[]{this});
        } else {
            load(false);
        }
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649761987")) {
            ipChange.ipc$dispatch("649761987", new Object[]{this});
            return;
        }
        this.mChangedCityId = z20.c();
        reloadIfCityChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067923886")) {
            ipChange.ipc$dispatch("-2067923886", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        this.mScrollDistance = 0;
        this.mChangedCityId = null;
        super.onDestroyView();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32176468")) {
            ipChange.ipc$dispatch("32176468", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-540004139")) {
            ipChange.ipc$dispatch("-540004139", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572072886")) {
            ipChange.ipc$dispatch("572072886", new Object[]{this});
        } else {
            load(false);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673391020")) {
            ipChange.ipc$dispatch("1673391020", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185260720")) {
            ipChange.ipc$dispatch("-1185260720", new Object[]{this, view, bundle});
            return;
        }
        obtainBundleArgs();
        this.mModel.setArg(this.mInsetArg);
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        setContainerArgs();
        enableDividerLine(false);
        enableRefresh();
        enableLoadMore();
        disAbleToTop();
        addScrollListener();
        setLoadMoreViewColourless();
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737105400")) {
            ipChange.ipc$dispatch("-737105400", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean isLazyLoaded = isLazyLoaded();
        super.setUserVisibleHint(z);
        if (isLazyLoaded) {
            reloadIfCityChanged();
        }
    }
}
