package cn.damai.mine.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.common.bean.RankBean;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.bean.FocusEvent;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.mine.adapter.MultiAdapter;
import cn.damai.mine.bean.PageData;
import cn.damai.mine.bean.PageType;
import cn.damai.mine.listener.OnBizListener;
import cn.damai.mine.listener.OnErrClickListener;
import cn.damai.mine.listener.OnWannaBeanListener;
import cn.damai.mine.model.WannaSeeModel;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.hi1;
import tb.m62;
import tb.mu0;
import tb.u3;
import tb.w3;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MultipleListFragment extends BaseFuncFragment implements UpLoadMorePanel.LoadMoreEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_REQ_LOGIN = 4387;
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    private static final String TAG = "Multiple";
    private FragmentActivity mActivity;
    private MultiAdapter mAdapter;
    private int mItemOffset;
    private OnWannaBeanListener mListener;
    private ViewGroup mMainView;
    private WannaSeeModel mModel;
    private UpLoadMorePanel mMorePanel;
    private DamaiRootRecyclerView mRecyclerView;
    private PageType mType;
    private boolean isViewCreated = false;
    private boolean isFocusChanged = false;
    private xr mFocusSubscriber = new xr();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements Action<FocusEvent> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(FocusEvent focusEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1784195263")) {
                ipChange.ipc$dispatch("-1784195263", new Object[]{this, focusEvent});
            } else {
                MultipleListFragment.this.isFocusChanged = true;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b extends w3 {
        private static transient /* synthetic */ IpChange $ipChange;

        b(MultipleListFragment multipleListFragment) {
        }

        @Override // cn.damai.mine.listener.MultiClickUt
        public void utNoteClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1872632528")) {
                ipChange.ipc$dispatch("-1872632528", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else {
                cn.damai.common.user.c.e().x(hi1.m().o(i));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements MultiAdapter.Exposure {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.mine.adapter.MultiAdapter.Exposure
        public void exposureNote(View view, NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1323818663")) {
                ipChange.ipc$dispatch("-1323818663", new Object[]{this, view, noteBean, Integer.valueOf(i)});
            } else {
                hi1.i(view, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, noteBean.id, i);
            }
        }

        @Override // cn.damai.mine.adapter.MultiAdapter.Exposure
        public void exposureProject(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-239918529")) {
                ipChange.ipc$dispatch("-239918529", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            } else {
                hi1.i(view, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, projectItemBean.id, i);
            }
        }

        @Override // cn.damai.mine.adapter.MultiAdapter.Exposure
        public void exposureRank(View view, RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1511937649")) {
                ipChange.ipc$dispatch("1511937649", new Object[]{this, view, rankBean, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class d implements OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.uikit.irecycler.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2093775493")) {
                ipChange.ipc$dispatch("2093775493", new Object[]{this});
            } else {
                MultipleListFragment.this.tryLoad(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class e implements OnErrClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.mine.listener.OnErrClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1787119946")) {
                ipChange.ipc$dispatch("-1787119946", new Object[]{this});
            } else {
                MultipleListFragment.this.openLoginActivity();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class f implements OnBizListener<PageData<List>> {
        private static transient /* synthetic */ IpChange $ipChange;
        final boolean a;

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public class a implements OnErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.mine.listener.OnErrClickListener
            public void onClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-837851112")) {
                    ipChange.ipc$dispatch("-837851112", new Object[]{this});
                } else {
                    MultipleListFragment.this.tryLoad(true);
                }
            }
        }

        public f(boolean z) {
            this.a = z;
        }

        @Override // cn.damai.mine.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PageData<List> pageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-396496323")) {
                ipChange.ipc$dispatch("-396496323", new Object[]{this, pageData});
                return;
            }
            MultipleListFragment.this.stopLoading();
            if (this.a) {
                MultipleListFragment.this.hideErrResView();
                if (cb2.d(pageData.data)) {
                    MultipleListFragment.this.showEmptyView(MultipleListFragment.this.mType == null ? "" : MultipleListFragment.this.mType.getPageEmptyMsg());
                }
            }
            if (pageData.hasMore) {
                MultipleListFragment.this.mMorePanel.d();
            } else {
                MultipleListFragment.this.mMorePanel.g();
            }
            MultipleListFragment.this.mAdapter.e(pageData.data, this.a);
        }

        @Override // cn.damai.mine.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1624704496")) {
                ipChange.ipc$dispatch("1624704496", new Object[]{this, str, str2});
                return;
            }
            MultipleListFragment.this.stopLoading();
            if (this.a) {
                MultipleListFragment.this.showErrorView(str, str2, new a());
                return;
            }
            ToastUtil.i(str2);
            MultipleListFragment.this.mMorePanel.d();
        }
    }

    private void addItemDecorationIfNeed(DamaiRootRecyclerView damaiRootRecyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371540006")) {
            ipChange.ipc$dispatch("-1371540006", new Object[]{this, damaiRootRecyclerView});
        } else if (PageType.RECORD == this.mType) {
            this.mItemOffset = m62.a(this.mActivity, 6.0f);
            int a2 = m62.a(this.mActivity, 15.0f);
            damaiRootRecyclerView.setPadding(a2, 0, a2, 0);
            damaiRootRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.mine.fragment.MultipleListFragment.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1214683551")) {
                        ipChange2.ipc$dispatch("1214683551", new Object[]{this, rect, view, recyclerView, state});
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof RecyclerView.LayoutParams) {
                        if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() > 1) {
                            rect.set(MultipleListFragment.this.mItemOffset, MultipleListFragment.this.mItemOffset, MultipleListFragment.this.mItemOffset, MultipleListFragment.this.mItemOffset);
                        } else {
                            rect.set(0, 0, 0, 0);
                        }
                    }
                }
            });
        }
    }

    public static MultipleListFragment instance(PageType pageType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384296683")) {
            return (MultipleListFragment) ipChange.ipc$dispatch("1384296683", new Object[]{pageType});
        }
        MultipleListFragment multipleListFragment = new MultipleListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_TYPE, pageType);
        multipleListFragment.setArguments(bundle);
        return multipleListFragment;
    }

    private boolean isStaggeredLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-38080951") ? ((Boolean) ipChange.ipc$dispatch("-38080951", new Object[]{this})).booleanValue() : PageType.RECORD == this.mType;
    }

    private boolean isViewPrepared() {
        FragmentActivity fragmentActivity;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "712593937") ? ((Boolean) ipChange.ipc$dispatch("712593937", new Object[]{this})).booleanValue() : (this.mType == null || !this.isViewCreated || (fragmentActivity = this.mActivity) == null || fragmentActivity.isFinishing()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLoginActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237075869")) {
            ipChange.ipc$dispatch("-1237075869", new Object[]{this});
            return;
        }
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        LoginManager.k().y(this, new Intent(), 4387);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryLoad(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007949860")) {
            ipChange.ipc$dispatch("1007949860", new Object[]{this, Boolean.valueOf(z)});
        } else if (!LoginManager.k().q()) {
            showLoginView(new e());
        } else {
            this.mModel.load(z, new f(z));
        }
    }

    private void tryLoadIfLoginChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-209295480")) {
            ipChange.ipc$dispatch("-209295480", new Object[]{this});
        } else if (isViewPrepared() && isShowingLoginView() && LoginManager.k().q()) {
            hideErrResView();
            tryLoad(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1609008502") ? ((Integer) ipChange.ipc$dispatch("1609008502", new Object[]{this})).intValue() : R$layout.fragment_main_multiple_list;
    }

    @Override // cn.damai.mine.fragment.BaseFuncFragment
    public ViewGroup getMainView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "416608216") ? (ViewGroup) ipChange.ipc$dispatch("416608216", new Object[]{this}) : this.mMainView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.mine.fragment.BaseFuncFragment, cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547424028")) {
            ipChange.ipc$dispatch("-547424028", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        this.isViewCreated = true;
        this.mMainView = (ViewGroup) this.rootView.findViewById(R$id.main_view);
        super.initView();
        DamaiRootRecyclerView damaiRootRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.multi_list);
        this.mRecyclerView = damaiRootRecyclerView;
        damaiRootRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
        if (isStaggeredLayout()) {
            int a2 = m62.a(mu0.a(), 0.0f);
            this.mRecyclerView.setPadding(a2, 0, a2, 0);
            this.mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        } else {
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        }
        FragmentActivity fragmentActivity = this.mActivity;
        MultiAdapter multiAdapter = new MultiAdapter(fragmentActivity, new u3(fragmentActivity, new b(this)));
        this.mAdapter = multiAdapter;
        multiAdapter.c(new c());
        this.mRecyclerView.setAdapter(this.mAdapter);
        addItemDecorationIfNeed(this.mRecyclerView);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setOnRefreshListener(new d());
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setItemAnimator(null);
        UpLoadMorePanel upLoadMorePanel = new UpLoadMorePanel(this.mActivity, this.mRecyclerView, this);
        this.mMorePanel = upLoadMorePanel;
        upLoadMorePanel.a();
        tryLoad(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062863146")) {
            ipChange.ipc$dispatch("-2062863146", new Object[]{this, bundle});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mType = (PageType) arguments.getSerializable(EXTRA_TYPE);
        }
        if (this.mType == null) {
            this.mType = PageType.RECORD;
        }
        this.mModel = new WannaSeeModel(this.mType, this.mListener);
        this.mFocusSubscriber.b(this.mType.isProject() ? FocusEvent.EVENT_NAME_PROJECT_FOCUS_CHANGED : FocusEvent.EVENT_NAME_NOTE_FOCUS_CHANGED, new a());
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548998550")) {
            ipChange.ipc$dispatch("1548998550", new Object[]{this});
            return;
        }
        super.onDestroy();
        xr xrVar = this.mFocusSubscriber;
        if (xrVar != null) {
            xrVar.a();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932118991")) {
            ipChange.ipc$dispatch("-932118991", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        super.onDestroyView();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123402861")) {
            ipChange.ipc$dispatch("123402861", new Object[]{this});
            return;
        }
        super.onResume();
        tryLoad(true);
    }

    public void setListener(OnWannaBeanListener onWannaBeanListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000942232")) {
            ipChange.ipc$dispatch("-2000942232", new Object[]{this, onWannaBeanListener});
        } else {
            this.mListener = onWannaBeanListener;
        }
    }

    @Override // cn.damai.uikit.irecycler.helper.UpLoadMorePanel.LoadMoreEventListener
    public void startLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1856322668")) {
            ipChange.ipc$dispatch("-1856322668", new Object[]{this});
        } else {
            tryLoad(false);
        }
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104434295")) {
            ipChange.ipc$dispatch("104434295", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setRefreshing(false);
        }
        stopProgressDialog();
    }
}
