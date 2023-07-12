package cn.damai.discover.main.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.discover.main.bean.ThemePageBean;
import cn.damai.discover.main.ui.adapter.TopicAdapter;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C9548pb;
import tb.C9799v3;
import tb.lm2;
import tb.m62;
import tb.x3;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThemeFeedFragment extends Fragment implements UpLoadMorePanel.LoadMoreEventListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ThemeActivity mActivity;
    private int mItemViewPadding;
    private RecyclerView.OnScrollListener mListener;
    private UpLoadMorePanel mMorePanel;
    private View mView;
    private TopicAdapter mWaterFallAdapter;
    private DamaiRootRecyclerView mWaterfallRev;
    private lm2 mUt = new lm2();
    private boolean isViewCreated = false;
    private int mIndex = 0;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.main.ui.ThemeFeedFragment$a */
    /* loaded from: classes5.dex */
    public class C1063a extends x3 {
        private static transient /* synthetic */ IpChange $ipChange;

        C1063a() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utNoteClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "426344315")) {
                ipChange.ipc$dispatch("426344315", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else {
                C9548pb.j(ThemeFeedFragment.this.mUt.z(i, noteBean.baseUserDO.havanaIdStr, ThemeFeedFragment.this.mIndex, noteBean.id));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.main.ui.ThemeFeedFragment$b */
    /* loaded from: classes5.dex */
    public class C1064b extends TopicAdapter.C1070d {
        private static transient /* synthetic */ IpChange $ipChange;

        C1064b() {
        }

        @Override // cn.damai.discover.main.ui.adapter.TopicAdapter.Exposure
        public void exposureNote(View view, NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "622766116")) {
                ipChange.ipc$dispatch("622766116", new Object[]{this, view, noteBean, Integer.valueOf(i)});
            } else {
                ThemeFeedFragment.this.mUt.t(view, noteBean.id, i, ThemeFeedFragment.this.mIndex);
            }
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-799477713")) {
            ipChange.ipc$dispatch("-799477713", new Object[]{this});
            return;
        }
        this.mWaterfallRev = (DamaiRootRecyclerView) this.mView.findViewById(R$id.recycler_view);
        this.mItemViewPadding = m62.a(this.mActivity, 6.0f);
        this.mWaterfallRev.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.mWaterfallRev.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.discover.main.ui.ThemeFeedFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-15679834")) {
                    ipChange2.ipc$dispatch("-15679834", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() > 1) {
                        rect.set(ThemeFeedFragment.this.mItemViewPadding, ThemeFeedFragment.this.mItemViewPadding, ThemeFeedFragment.this.mItemViewPadding, ThemeFeedFragment.this.mItemViewPadding);
                    } else {
                        rect.set(0, 0, 0, 0);
                    }
                }
            }
        });
        ThemeActivity themeActivity = this.mActivity;
        TopicAdapter topicAdapter = new TopicAdapter(themeActivity, this.mIndex, new C9799v3(themeActivity, new C1063a()));
        this.mWaterFallAdapter = topicAdapter;
        topicAdapter.f(new C1064b());
        this.mWaterFallAdapter.h(this.mUt);
        this.mWaterfallRev.setAdapter(this.mWaterFallAdapter);
        this.mWaterfallRev.setRefreshEnabled(false);
        this.mWaterfallRev.setIsAutoToDefault(false);
        this.mWaterfallRev.setItemAnimator(null);
        this.mWaterfallRev.setOnScrollListener(this.mListener);
        UpLoadMorePanel upLoadMorePanel = new UpLoadMorePanel(this.mActivity, this.mWaterfallRev, this);
        this.mMorePanel = upLoadMorePanel;
        upLoadMorePanel.a();
        this.mMorePanel.e(false);
    }

    public void loadFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121837696")) {
            ipChange.ipc$dispatch("121837696", new Object[]{this});
        } else {
            this.mMorePanel.e(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771689735")) {
            return (View) ipChange.ipc$dispatch("-771689735", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.theme_feed_fragment, (ViewGroup) null);
        this.mActivity = (ThemeActivity) getActivity();
        initView();
        this.isViewCreated = true;
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969698389")) {
            ipChange.ipc$dispatch("-1969698389", new Object[]{this});
            return;
        }
        super.onDestroy();
        DamaiRootRecyclerView damaiRootRecyclerView = this.mWaterfallRev;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.clearOnScrollListeners();
            this.mWaterfallRev.setOnLoadMoreListener(null);
            this.mWaterfallRev.setOnRefreshListener(null);
            this.mWaterfallRev = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011898426")) {
            ipChange.ipc$dispatch("-2011898426", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        super.onDestroyView();
    }

    public void putData(ThemePageBean themePageBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326851316")) {
            ipChange.ipc$dispatch("1326851316", new Object[]{this, themePageBean, Boolean.valueOf(z)});
        } else if (this.isViewCreated && isAdded()) {
            if (z) {
                this.mWaterFallAdapter.c(themePageBean.cards);
            } else {
                this.mWaterFallAdapter.g(themePageBean.cards);
            }
            if (themePageBean.hasNext) {
                this.mMorePanel.e(true);
            } else {
                this.mMorePanel.g();
            }
        }
    }

    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744826129")) {
            ipChange.ipc$dispatch("-1744826129", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mIndex = i;
        }
    }

    public void setUt(lm2 lm2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125113945")) {
            ipChange.ipc$dispatch("2125113945", new Object[]{this, lm2Var});
        } else {
            this.mUt = lm2Var;
        }
    }

    public void setWaterfallScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166373752")) {
            ipChange.ipc$dispatch("-1166373752", new Object[]{this, onScrollListener});
        } else {
            this.mListener = onScrollListener;
        }
    }

    @Override // cn.damai.uikit.irecycler.helper.UpLoadMorePanel.LoadMoreEventListener
    public void startLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358865193")) {
            ipChange.ipc$dispatch("1358865193", new Object[]{this});
        } else {
            this.mActivity.startLoadMore();
        }
    }
}
