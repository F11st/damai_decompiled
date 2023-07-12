package cn.damai.discover.main.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.home.bean.HomeContentFloatBean;
import cn.damai.commonbusiness.wannasee.bean.PageData;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.wannasee.listener.RefreshCallBack;
import cn.damai.commonbusiness.wannasee.view.NestScrollErrResView;
import cn.damai.discover.main.ui.listener.OnActivityResultListener;
import cn.damai.discover.main.ui.model.RecommendModel;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import in.srain.cube.views.ptr.PtrFrameLayout;
import tb.m62;
import tb.qx1;
import tb.s90;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RecommendFragment extends AbsFragmentV2 implements PtrChildHandler, OnActivityResultListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private FragmentActivity mActivity;
    private OnOverPageListener mOverPageListener;
    private NestScrollErrResView mResView;
    private int mTopPadding;
    private RecommendModel mModel = new RecommendModel();
    private boolean isViewCreated = false;
    private qx1 mHandler = new c(this);

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnOverPageListener {
        void onOverPage(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements OnBizListener<PageData<BaseResponse>> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnBizListener a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.discover.main.ui.RecommendFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0043a implements OnErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0043a() {
            }

            @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
            public void onClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2641644")) {
                    ipChange.ipc$dispatch("2641644", new Object[]{this});
                    return;
                }
                RecommendFragment.this.hideErrView();
                RecommendFragment.this.loadPage(null);
            }
        }

        a(OnBizListener onBizListener) {
            this.a = onBizListener;
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PageData<BaseResponse> pageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "599006618")) {
                ipChange.ipc$dispatch("599006618", new Object[]{this, pageData});
                return;
            }
            OnBizListener onBizListener = this.a;
            if (onBizListener != null) {
                onBizListener.onBizSuccess(pageData.data);
            }
            RecommendFragment.this.hideErrView();
            RecommendFragment.this.setData(pageData.data);
            if (pageData.hasMore) {
                RecommendFragment.this.loadMoreResetV2(true);
            } else {
                RecommendFragment.this.showNoMoreV2();
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1978667716")) {
                ipChange.ipc$dispatch("1978667716", new Object[]{this, str, str2});
                return;
            }
            OnBizListener onBizListener = this.a;
            if (onBizListener != null) {
                onBizListener.onBizFail(str, str2);
            }
            RecommendFragment.this.showErrView(str, str2, new C0043a());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements OnBizListener<PageData<BaseResponse>> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PageData<BaseResponse> pageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-9070245")) {
                ipChange.ipc$dispatch("-9070245", new Object[]{this, pageData});
                return;
            }
            if (pageData.hasMore) {
                RecommendFragment.this.loadMoreResetV2(true);
            } else {
                RecommendFragment.this.showNoMoreV2();
            }
            RecommendFragment.this.loadMore4Sections(pageData.data);
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1547129565")) {
                ipChange.ipc$dispatch("-1547129565", new Object[]{this, str, str2});
            } else {
                RecommendFragment.this.loadMoreResetV2(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c extends qx1 {
        private static transient /* synthetic */ IpChange $ipChange;

        c(RecommendFragment recommendFragment) {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1930769703")) {
                ipChange.ipc$dispatch("-1930769703", new Object[]{this, ptrFrameLayout});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements OnBizListener<BaseResponse> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RefreshCallBack a;
        final /* synthetic */ PtrFrameLayout b;

        d(RecommendFragment recommendFragment, RefreshCallBack refreshCallBack, PtrFrameLayout ptrFrameLayout) {
            this.a = refreshCallBack;
            this.b = ptrFrameLayout;
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(BaseResponse baseResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "719481991")) {
                ipChange.ipc$dispatch("719481991", new Object[]{this, baseResponse});
                return;
            }
            this.a.onRefreshSuccess(s90.e(baseResponse));
            this.b.refreshComplete();
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-8789535")) {
                ipChange.ipc$dispatch("-8789535", new Object[]{this, str, str2});
            } else {
                this.b.refreshComplete();
            }
        }
    }

    private void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151782958")) {
            ipChange.ipc$dispatch("151782958", new Object[]{this, view});
            return;
        }
        this.isViewCreated = true;
        this.mActivity = getActivity();
        UpLoadMorePanel.b(this.mRecyclerView);
        setUpWaterFallView();
        NestScrollErrResView nestScrollErrResView = new NestScrollErrResView(this.mActivity);
        this.mResView = nestScrollErrResView;
        ((FrameLayout) view.findViewById(R$id.root_fl)).addView(nestScrollErrResView, -1, -1);
        this.mResView.setVisibility(8);
        enableDividerLine(false);
        loadMoreResetV2(false);
        disableRefresh();
        setModelParamsFromIntent();
        loadPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPage(@Nullable OnBizListener<BaseResponse> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31495206")) {
            ipChange.ipc$dispatch("31495206", new Object[]{this, onBizListener});
        } else {
            this.mModel.load(true, new a(onBizListener));
        }
    }

    private void setModelParamsFromIntent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-686809050")) {
            ipChange.ipc$dispatch("-686809050", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra(HomeContentFloatBean.HIGH_LIGHT_CARD_JSON);
        intent.removeExtra(HomeContentFloatBean.HIGH_LIGHT_CARD_JSON);
        this.mModel.setHighLightCard(stringExtra);
    }

    private void setUpWaterFallView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533782399")) {
            ipChange.ipc$dispatch("1533782399", new Object[]{this});
            return;
        }
        this.mTopPadding = m62.a(this.mActivity, 10.0f);
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.discover.main.ui.RecommendFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1440859611")) {
                    ipChange2.ipc$dispatch("1440859611", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() == 0) {
                        rect.set(0, RecommendFragment.this.mTopPadding, 0, 0);
                    } else {
                        rect.set(0, 0, 0, 0);
                    }
                }
            }
        });
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.discover.main.ui.RecommendFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-994529285")) {
                    ipChange2.ipc$dispatch("-994529285", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (RecommendFragment.this.mOverPageListener != null) {
                    RecommendFragment.this.mOverPageListener.onOverPage(s90.h(recyclerView));
                }
            }
        });
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "489478953") ? ((Boolean) ipChange.ipc$dispatch("489478953", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue() : this.isViewCreated && isAdded() && this.mHandler.checkCanDoRefresh(ptrFrameLayout, this.mRecyclerView, view2);
    }

    public void hideErrView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842279095")) {
            ipChange.ipc$dispatch("-1842279095", new Object[]{this});
        } else {
            this.mResView.hide();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978460114")) {
            return (View) ipChange.ipc$dispatch("-1978460114", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.fragment_recommend, viewGroup, false);
        viewGroup2.addView(super.onCreateView(layoutInflater, viewGroup2, bundle), -1, -1);
        return viewGroup2;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951981654")) {
            ipChange.ipc$dispatch("1951981654", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mModel.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784095503")) {
            ipChange.ipc$dispatch("-784095503", new Object[]{this});
            return;
        }
        super.onDestroyView();
        this.isViewCreated = false;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956805133")) {
            ipChange.ipc$dispatch("-1956805133", new Object[]{this, view});
            return;
        }
        showLoadMoreV2();
        this.mModel.load(false, new b());
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335497814")) {
            ipChange.ipc$dispatch("1335497814", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170063317")) {
            ipChange.ipc$dispatch("170063317", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public void onRefreshBegin(PtrFrameLayout ptrFrameLayout, RefreshCallBack refreshCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776452074")) {
            ipChange.ipc$dispatch("1776452074", new Object[]{this, ptrFrameLayout, refreshCallBack});
        } else {
            loadPage(new d(this, refreshCallBack, ptrFrameLayout));
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169208145")) {
            ipChange.ipc$dispatch("-169208145", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        disAbleToTop();
        initView(view);
    }

    @Override // cn.damai.discover.main.ui.listener.OnActivityResultListener
    public boolean processActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1975194697")) {
            return ((Boolean) ipChange.ipc$dispatch("-1975194697", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        }
        return false;
    }

    public void setOverPageListener(OnOverPageListener onOverPageListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404373559")) {
            ipChange.ipc$dispatch("-1404373559", new Object[]{this, onOverPageListener});
        } else {
            this.mOverPageListener = onOverPageListener;
        }
    }

    public void showErrView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "174471648")) {
            ipChange.ipc$dispatch("174471648", new Object[]{this, str, str2, onErrClickListener});
        } else {
            this.mResView.showErrorView(str, str2, onErrClickListener);
        }
    }

    public void tryScroll2Top() {
        DamaiRootRecyclerView damaiRootRecyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053771962")) {
            ipChange.ipc$dispatch("-2053771962", new Object[]{this});
            return;
        }
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity == null || fragmentActivity.isFinishing() || !this.isViewCreated || (damaiRootRecyclerView = this.mRecyclerView) == null || damaiRootRecyclerView.getChildCount() <= 5) {
            return;
        }
        this.mRecyclerView.scrollToPosition(0);
    }
}
