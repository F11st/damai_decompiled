package cn.damai.performance.fragment;

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
import cn.damai.message.observer.Action;
import cn.damai.performance.bean.HeadAtmosphere;
import cn.damai.performance.model.OnlinePerformanceParams;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.core.mtop.BaseResponse;
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
/* loaded from: classes6.dex */
public class OnlinePerformanceFragment extends AbsFragmentV2 implements OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_TAB = "tab";
    private boolean isViewCreated = false;
    private HomeTabBean mArgs;
    private BaseResponse mBaseResponse;
    private String mChangedCityId;
    private int mScrollDistance;
    private HomeTopBgListener mTopBgListener;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "866131408")) {
                ipChange.ipc$dispatch("866131408", new Object[]{this, obj});
            } else {
                OnlinePerformanceFragment.this.request(false);
            }
        }
    }

    static /* synthetic */ int access$312(OnlinePerformanceFragment onlinePerformanceFragment, int i) {
        int i2 = onlinePerformanceFragment.mScrollDistance + i;
        onlinePerformanceFragment.mScrollDistance = i2;
        return i2;
    }

    private void addScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2210627")) {
            ipChange.ipc$dispatch("2210627", new Object[]{this});
            return;
        }
        this.mScrollDistance = 0;
        updateScrollDistance();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.performance.fragment.OnlinePerformanceFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1688388498")) {
                    ipChange2.ipc$dispatch("-1688388498", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                OnlinePerformanceFragment.access$312(OnlinePerformanceFragment.this, i2);
                if (OnlinePerformanceFragment.this.mScrollDistance < 0) {
                    OnlinePerformanceFragment.this.mScrollDistance = 0;
                }
                OnlinePerformanceFragment.this.updateScrollDistance();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        r7 = r2.getItem();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
        if (r7 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        r7 = (cn.damai.performance.bean.HeadResult) com.alibaba.fastjson.JSON.parseObject(r7.toJSONString(), cn.damai.performance.bean.HeadResult.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (r7 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
        if (tb.m91.a(r7.result) != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
        if (r7.result.get(0) == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        return r7.result.get(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.damai.performance.bean.HeadAtmosphere getAtmosphere(cn.damai.tetris.core.mtop.BaseResponse r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.performance.fragment.OnlinePerformanceFragment.$ipChange
            java.lang.String r1 = "-962903994"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r6
            r3 = 1
            r2[r3] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            cn.damai.performance.bean.HeadAtmosphere r7 = (cn.damai.performance.bean.HeadAtmosphere) r7
            return r7
        L1a:
            r0 = 0
            if (r7 == 0) goto L88
            java.util.ArrayList<cn.damai.tetris.core.BaseLayer> r7 = r7.layers     // Catch: java.lang.Exception -> L88
            boolean r1 = tb.cb2.d(r7)     // Catch: java.lang.Exception -> L88
            if (r1 != 0) goto L88
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Exception -> L88
        L29:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L88
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Exception -> L88
            cn.damai.tetris.core.BaseLayer r1 = (cn.damai.tetris.core.BaseLayer) r1     // Catch: java.lang.Exception -> L88
            java.util.List r1 = r1.getSections()     // Catch: java.lang.Exception -> L88
            boolean r2 = tb.cb2.d(r1)     // Catch: java.lang.Exception -> L88
            if (r2 != 0) goto L29
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L88
        L43:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> L88
            if (r2 == 0) goto L29
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> L88
            cn.damai.tetris.core.BaseSection r2 = (cn.damai.tetris.core.BaseSection) r2     // Catch: java.lang.Exception -> L88
            java.lang.String r4 = r2.getComponentId()     // Catch: java.lang.Exception -> L88
            java.lang.String r5 = "live_perform_online_star"
            boolean r4 = android.text.TextUtils.equals(r5, r4)     // Catch: java.lang.Exception -> L88
            if (r4 == 0) goto L43
            cn.damai.tetris.core.NodeData r7 = r2.getItem()     // Catch: java.lang.Exception -> L88
            if (r7 == 0) goto L88
            java.lang.String r7 = r7.toJSONString()     // Catch: java.lang.Exception -> L88
            java.lang.Class<cn.damai.performance.bean.HeadResult> r1 = cn.damai.performance.bean.HeadResult.class
            java.lang.Object r7 = com.alibaba.fastjson.JSON.parseObject(r7, r1)     // Catch: java.lang.Exception -> L88
            cn.damai.performance.bean.HeadResult r7 = (cn.damai.performance.bean.HeadResult) r7     // Catch: java.lang.Exception -> L88
            if (r7 == 0) goto L88
            java.util.List<cn.damai.performance.bean.HeadAtmosphere> r1 = r7.result     // Catch: java.lang.Exception -> L88
            boolean r1 = tb.m91.a(r1)     // Catch: java.lang.Exception -> L88
            if (r1 != 0) goto L88
            java.util.List<cn.damai.performance.bean.HeadAtmosphere> r1 = r7.result     // Catch: java.lang.Exception -> L88
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Exception -> L88
            if (r1 == 0) goto L88
            java.util.List<cn.damai.performance.bean.HeadAtmosphere> r7 = r7.result     // Catch: java.lang.Exception -> L88
            java.lang.Object r7 = r7.get(r3)     // Catch: java.lang.Exception -> L88
            cn.damai.performance.bean.HeadAtmosphere r7 = (cn.damai.performance.bean.HeadAtmosphere) r7     // Catch: java.lang.Exception -> L88
            return r7
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.performance.fragment.OnlinePerformanceFragment.getAtmosphere(cn.damai.tetris.core.mtop.BaseResponse):cn.damai.performance.bean.HeadAtmosphere");
    }

    public static OnlinePerformanceFragment getInstance(HomeTabBean homeTabBean, HomeTopBgListener homeTopBgListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149014392")) {
            return (OnlinePerformanceFragment) ipChange.ipc$dispatch("-149014392", new Object[]{homeTabBean, homeTopBgListener});
        }
        OnlinePerformanceFragment onlinePerformanceFragment = new OnlinePerformanceFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable(KEY_TAB, homeTabBean);
        }
        onlinePerformanceFragment.setArguments(bundle);
        onlinePerformanceFragment.mTopBgListener = homeTopBgListener;
        return onlinePerformanceFragment;
    }

    private boolean isVisibleToUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254338949")) {
            return ((Boolean) ipChange.ipc$dispatch("-1254338949", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return getUserVisibleHint() && this.isViewCreated;
    }

    private void reloadIfCityChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671414542")) {
            ipChange.ipc$dispatch("-671414542", new Object[]{this});
        } else if (!isVisibleToUser() || TextUtils.isEmpty(this.mChangedCityId)) {
        } else {
            this.mChangedCityId = null;
            request(false);
        }
    }

    private void setContainerArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091635831")) {
            ipChange.ipc$dispatch("-2091635831", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mArgs = (HomeTabBean) arguments.getSerializable(KEY_TAB);
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
        if (AndroidInstantRuntime.support(ipChange, "1845956510")) {
            ipChange.ipc$dispatch("1845956510", new Object[]{this});
            return;
        }
        View loadMoreFooterView = this.mRecyclerView.getLoadMoreFooterView();
        if (loadMoreFooterView != null) {
            loadMoreFooterView.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomeAtmosphere(HeadAtmosphere headAtmosphere) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183675741")) {
            ipChange.ipc$dispatch("-183675741", new Object[]{this, headAtmosphere});
        } else if (headAtmosphere == null) {
        } else {
            HomeHeaderBg homeHeaderBg = new HomeHeaderBg(null, 5, headAtmosphere.bgPicture, null);
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
        if (AndroidInstantRuntime.support(ipChange, "1910697434")) {
            ipChange.ipc$dispatch("1910697434", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1487031285")) {
            ipChange.ipc$dispatch("-1487031285", new Object[]{this});
        } else {
            request(false);
        }
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313214602")) {
            ipChange.ipc$dispatch("-313214602", new Object[]{this});
            return;
        }
        this.mChangedCityId = z20.c();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943491798")) {
            ipChange.ipc$dispatch("-943491798", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-496932665")) {
            ipChange.ipc$dispatch("-496932665", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105495810")) {
            ipChange.ipc$dispatch("1105495810", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521040530")) {
            ipChange.ipc$dispatch("-521040530", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569557161")) {
            ipChange.ipc$dispatch("1569557161", new Object[]{this});
        } else {
            request(false);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619568039")) {
            ipChange.ipc$dispatch("-1619568039", new Object[]{this});
            return;
        }
        super.onResume();
        reloadIfCityChanged();
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319513219")) {
            ipChange.ipc$dispatch("319513219", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        this.mDMMessage.b("refreshData", new a());
        enableDividerLine(false);
        enableRefresh();
        addScrollListener();
        enableLoadMore();
        setLoadMoreViewColourless();
        setContainerArgs();
    }

    public void request(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1379102302")) {
            ipChange.ipc$dispatch("1379102302", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mChangedCityId = null;
        if (z) {
            startProgressDialog();
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new OnlinePerformanceParams(1));
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.performance.fragment.OnlinePerformanceFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.performance.fragment.OnlinePerformanceFragment$2$a */
            /* loaded from: classes6.dex */
            public class a implements OnErrClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
                public void onClick() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1101996257")) {
                        ipChange.ipc$dispatch("1101996257", new Object[]{this});
                    } else {
                        OnlinePerformanceFragment.this.request(true);
                    }
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "285333554")) {
                    ipChange2.ipc$dispatch("285333554", new Object[]{this, str, str2});
                    return;
                }
                if (z) {
                    OnlinePerformanceFragment.this.stopProgressDialog();
                }
                OnlinePerformanceFragment.this.refreshFinish();
                OnlinePerformanceFragment.this.showErrorViewV2(str, str2, new a());
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-911993396")) {
                    ipChange2.ipc$dispatch("-911993396", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    OnlinePerformanceFragment.this.stopProgressDialog();
                }
                OnlinePerformanceFragment.this.hideErrorViewV2();
                OnlinePerformanceFragment.this.refreshFinish();
                OnlinePerformanceFragment.this.stopProgressDialog();
                jo2.a = SystemClock.elapsedRealtime();
                if (baseResponse != null) {
                    jo2.b = baseResponse.serverTime;
                }
                OnlinePerformanceFragment.this.setData(baseResponse);
                OnlinePerformanceFragment.this.mBaseResponse = baseResponse;
                OnlinePerformanceFragment onlinePerformanceFragment = OnlinePerformanceFragment.this;
                onlinePerformanceFragment.updateHomeAtmosphere(onlinePerformanceFragment.getAtmosphere(baseResponse));
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026343621")) {
            ipChange.ipc$dispatch("-1026343621", new Object[]{this, Boolean.valueOf(z)});
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
