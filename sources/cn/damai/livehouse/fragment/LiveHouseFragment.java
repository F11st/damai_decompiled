package cn.damai.livehouse.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeHeaderBg;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.livehouse.model.LiveHouseParams;
import cn.damai.message.observer.Action;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.jo2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LiveHouseFragment extends AbsFragmentV2 implements OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_TAB = "tab";
    private boolean isViewCreated = false;
    private HomeTabBean mArgs;
    private BaseResponse mBaseResponse;
    private String mChangedCityId;
    private int mScrollDistance;
    private HomeTopBgListener mTopBgListener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.livehouse.fragment.LiveHouseFragment$a */
    /* loaded from: classes5.dex */
    public class C1319a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1319a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1998663677")) {
                ipChange.ipc$dispatch("-1998663677", new Object[]{this, obj});
            } else {
                LiveHouseFragment.this.request(false);
            }
        }
    }

    static /* synthetic */ int access$512(LiveHouseFragment liveHouseFragment, int i) {
        int i2 = liveHouseFragment.mScrollDistance + i;
        liveHouseFragment.mScrollDistance = i2;
        return i2;
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018692208")) {
            ipChange.ipc$dispatch("2018692208", new Object[]{this});
            return;
        }
        this.mScrollDistance = 0;
        updateScrollDistance();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.livehouse.fragment.LiveHouseFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1450124133")) {
                    ipChange2.ipc$dispatch("-1450124133", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                LiveHouseFragment.access$512(LiveHouseFragment.this, i2);
                if (LiveHouseFragment.this.mScrollDistance < 0) {
                    LiveHouseFragment.this.mScrollDistance = 0;
                }
                LiveHouseFragment.this.updateScrollDistance();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        r6 = r2.getItem();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
        if (r6 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        r6 = (cn.damai.tetris.component.livehouse.bean.AritstHeadResult) com.alibaba.fastjson.JSON.parseObject(r6.toJSONString(), cn.damai.tetris.component.livehouse.bean.AritstHeadResult.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (r6 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        r6 = r6.atmosphere;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r6.bgImg == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere getAtmosphere(cn.damai.tetris.core.mtop.BaseResponse r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.livehouse.fragment.LiveHouseFragment.$ipChange
            java.lang.String r1 = "-691712832"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r3 = 1
            r2[r3] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere r6 = (cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere) r6
            return r6
        L1a:
            r0 = 0
            if (r6 == 0) goto L76
            java.util.ArrayList<cn.damai.tetris.core.BaseLayer> r6 = r6.layers     // Catch: java.lang.Exception -> L76
            boolean r1 = tb.cb2.d(r6)     // Catch: java.lang.Exception -> L76
            if (r1 != 0) goto L76
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Exception -> L76
        L29:
            boolean r1 = r6.hasNext()     // Catch: java.lang.Exception -> L76
            if (r1 == 0) goto L76
            java.lang.Object r1 = r6.next()     // Catch: java.lang.Exception -> L76
            cn.damai.tetris.core.BaseLayer r1 = (cn.damai.tetris.core.BaseLayer) r1     // Catch: java.lang.Exception -> L76
            java.util.List r1 = r1.getSections()     // Catch: java.lang.Exception -> L76
            boolean r2 = tb.cb2.d(r1)     // Catch: java.lang.Exception -> L76
            if (r2 != 0) goto L29
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L76
        L43:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L76
            if (r2 == 0) goto L29
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L76
            cn.damai.tetris.core.BaseSection r2 = (cn.damai.tetris.core.BaseSection) r2     // Catch: java.lang.Exception -> L76
            java.lang.String r3 = r2.getComponentId()     // Catch: java.lang.Exception -> L76
            java.lang.String r4 = "dm_header_video"
            boolean r3 = android.text.TextUtils.equals(r4, r3)     // Catch: java.lang.Exception -> L76
            if (r3 == 0) goto L43
            cn.damai.tetris.core.NodeData r6 = r2.getItem()     // Catch: java.lang.Exception -> L76
            if (r6 == 0) goto L76
            java.lang.String r6 = r6.toJSONString()     // Catch: java.lang.Exception -> L76
            java.lang.Class<cn.damai.tetris.component.livehouse.bean.AritstHeadResult> r1 = cn.damai.tetris.component.livehouse.bean.AritstHeadResult.class
            java.lang.Object r6 = com.alibaba.fastjson.JSON.parseObject(r6, r1)     // Catch: java.lang.Exception -> L76
            cn.damai.tetris.component.livehouse.bean.AritstHeadResult r6 = (cn.damai.tetris.component.livehouse.bean.AritstHeadResult) r6     // Catch: java.lang.Exception -> L76
            if (r6 == 0) goto L76
            cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere r6 = r6.atmosphere     // Catch: java.lang.Exception -> L76
            java.lang.String r1 = r6.bgImg     // Catch: java.lang.Exception -> L76
            if (r1 == 0) goto L76
            return r6
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.livehouse.fragment.LiveHouseFragment.getAtmosphere(cn.damai.tetris.core.mtop.BaseResponse):cn.damai.tetris.component.livehouse.bean.AritstHeadAtmosphere");
    }

    public static LiveHouseFragment getInstance(HomeTabBean homeTabBean, HomeTopBgListener homeTopBgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1552931614")) {
            return (LiveHouseFragment) ipChange.ipc$dispatch("-1552931614", new Object[]{homeTabBean, homeTopBgListener});
        }
        LiveHouseFragment liveHouseFragment = new LiveHouseFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable(KEY_TAB, homeTabBean);
        }
        liveHouseFragment.setArguments(bundle);
        liveHouseFragment.mTopBgListener = homeTopBgListener;
        liveHouseFragment.mArgs = homeTabBean;
        return liveHouseFragment;
    }

    private boolean isVisibleToUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487995672")) {
            return ((Boolean) ipChange.ipc$dispatch("-487995672", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return getUserVisibleHint() && this.isViewCreated;
    }

    private void obtainBundleArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71078004")) {
            ipChange.ipc$dispatch("71078004", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getSerializable(KEY_TAB) == null) {
            return;
        }
        this.mArgs = (HomeTabBean) arguments.getSerializable(KEY_TAB);
    }

    private void reloadIfCityChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137134303")) {
            ipChange.ipc$dispatch("137134303", new Object[]{this});
        } else if (!isVisibleToUser() || TextUtils.isEmpty(this.mChangedCityId)) {
        } else {
            this.mChangedCityId = null;
            request(false);
        }
    }

    private void setContainerArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190169276")) {
            ipChange.ipc$dispatch("190169276", new Object[]{this});
            return;
        }
        HomeTabBean homeTabBean = this.mArgs;
        ContainerArg containerArg = homeTabBean != null ? new ContainerArg(homeTabBean.patternName, homeTabBean.patternVersion, homeTabBean.args) : null;
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(containerArg);
        }
    }

    private void setLoadMoreViewColourless() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063345205")) {
            ipChange.ipc$dispatch("-1063345205", new Object[]{this});
            return;
        }
        View loadMoreFooterView = this.mRecyclerView.getLoadMoreFooterView();
        if (loadMoreFooterView != null) {
            loadMoreFooterView.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomeAtmosphere(AritstHeadAtmosphere aritstHeadAtmosphere) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569509053")) {
            ipChange.ipc$dispatch("1569509053", new Object[]{this, aritstHeadAtmosphere});
        } else if (aritstHeadAtmosphere == null) {
        } else {
            HomeHeaderBg homeHeaderBg = new HomeHeaderBg(null, 6, aritstHeadAtmosphere.bgImg, null);
            HomeTopBgListener homeTopBgListener = this.mTopBgListener;
            if (homeTopBgListener != null) {
                homeTopBgListener.onUpdateBg(homeHeaderBg);
                updateScrollDistance();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScrollDistance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205907853")) {
            ipChange.ipc$dispatch("1205907853", new Object[]{this});
            return;
        }
        HomeTopBgListener homeTopBgListener = this.mTopBgListener;
        if (homeTopBgListener != null) {
            homeTopBgListener.scrollY(this.mScrollDistance);
            cb1.c("HomeDis", "updateScrollDistance =" + this.mScrollDistance);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-659215298")) {
            ipChange.ipc$dispatch("-659215298", new Object[]{this});
        } else {
            request(false);
        }
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453128675")) {
            ipChange.ipc$dispatch("453128675", new Object[]{this});
            return;
        }
        this.mChangedCityId = z20.c();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050999977")) {
            ipChange.ipc$dispatch("-1050999977", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.isViewCreated = false;
        this.mScrollDistance = 0;
        this.mChangedCityId = null;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965287540")) {
            ipChange.ipc$dispatch("965287540", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756829771")) {
            ipChange.ipc$dispatch("-1756829771", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048526117")) {
            ipChange.ipc$dispatch("-1048526117", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462048982")) {
            ipChange.ipc$dispatch("1462048982", new Object[]{this});
        } else {
            request(false);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791752052")) {
            ipChange.ipc$dispatch("-791752052", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210980240")) {
            ipChange.ipc$dispatch("-1210980240", new Object[]{this, view, bundle});
            return;
        }
        obtainBundleArgs();
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        this.mDMMessage.b("refreshData", new C1319a());
        enableDividerLine(false);
        enableRefresh();
        addScrollListener();
        enableLoadMore();
        setLoadMoreViewColourless();
        setContainerArgs();
    }

    public void request(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088049007")) {
            ipChange.ipc$dispatch("-2088049007", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mChangedCityId = null;
        if (z) {
            startProgressDialog();
        }
        LiveHouseParams liveHouseParams = new LiveHouseParams(1);
        HomeTabBean homeTabBean = this.mArgs;
        if (homeTabBean != null) {
            liveHouseParams.outPatternName = homeTabBean.patternName;
            liveHouseParams.outPatternVersion = homeTabBean.patternVersion;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(liveHouseParams);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.livehouse.fragment.LiveHouseFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.livehouse.fragment.LiveHouseFragment$2$a */
            /* loaded from: classes5.dex */
            public class C1318a implements OnErrClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C1318a() {
                }

                @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
                public void onClick() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "865851342")) {
                        ipChange.ipc$dispatch("865851342", new Object[]{this});
                    } else {
                        LiveHouseFragment.this.request(true);
                    }
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1107926943")) {
                    ipChange2.ipc$dispatch("1107926943", new Object[]{this, str, str2});
                    return;
                }
                if (z) {
                    LiveHouseFragment.this.stopProgressDialog();
                }
                LiveHouseFragment.this.refreshFinish();
                LiveHouseFragment.this.showErrorViewV2(str, str2, new C1318a());
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-142702145")) {
                    ipChange2.ipc$dispatch("-142702145", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    LiveHouseFragment.this.stopProgressDialog();
                }
                LiveHouseFragment.this.hideErrorViewV2();
                LiveHouseFragment.this.refreshFinish();
                LiveHouseFragment.this.stopProgressDialog();
                jo2.a = SystemClock.elapsedRealtime();
                if (baseResponse != null) {
                    jo2.b = baseResponse.serverTime;
                }
                LiveHouseFragment.this.setData(baseResponse);
                LiveHouseFragment.this.mBaseResponse = baseResponse;
                if (((AbsFragment) LiveHouseFragment.this).mRecyclerView != null) {
                    ((AbsFragment) LiveHouseFragment.this).mRecyclerView.scrollToPosition(0);
                }
                LiveHouseFragment liveHouseFragment = LiveHouseFragment.this;
                liveHouseFragment.updateHomeAtmosphere(liveHouseFragment.getAtmosphere(baseResponse));
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-217794776")) {
            ipChange.ipc$dispatch("-217794776", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean isLazyLoaded = isLazyLoaded();
        super.setUserVisibleHint(z);
        if (isLazyLoaded) {
            reloadIfCityChanged();
        }
        if (z) {
            updateHomeAtmosphere(getAtmosphere(this.mBaseResponse));
        }
    }
}
