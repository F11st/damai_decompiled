package cn.damai.tetris.component.drama.mvp;

import android.app.Application;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.bean.ProjectListBean;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.drama.viewholder.ProjectBroadcastHorAdapter;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mg;
import tb.mu0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectBroadcastListView extends AbsView<ProjectBroadcastListContract.Presenter> implements ProjectBroadcastListContract.View<ProjectBroadcastListContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isShowNumSwiped;
    private ProjectBroadcastHorAdapter mAdapter;
    private ProjectListBean mBean;
    private int mEdgePadding;
    private int mItemOffset;
    private TextView mNowTv;
    private View mNumSwipeV;
    private mg mPanel;
    private RecyclerView mRecyclerView;
    private View mTitleLayout;
    private TextView mTotalTv;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView$a */
    /* loaded from: classes7.dex */
    public class C1828a implements OnItemBindListener<ProjectShowBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1828a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, ProjectShowBean projectShowBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-227964975")) {
                ipChange.ipc$dispatch("-227964975", new Object[]{this, view, projectShowBean, Integer.valueOf(i)});
                return;
            }
            String str = null;
            if (ProjectBroadcastListView.this.mBean != null && ProjectBroadcastListView.this.mBean.mTitleBean != null) {
                str = ProjectBroadcastListView.this.mBean.mTitleBean.title;
            }
            ProjectBroadcastListView.this.getPresenter().exposeItem(view, projectShowBean, i, str);
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(ProjectShowBean projectShowBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1938394362")) {
                ipChange.ipc$dispatch("-1938394362", new Object[]{this, projectShowBean, Integer.valueOf(i)});
            } else {
                ProjectBroadcastListView.this.getPresenter().itemClick(ProjectBroadcastListView.this, projectShowBean, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1829b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC1829b(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "314397374")) {
                ipChange.ipc$dispatch("314397374", new Object[]{this, view});
            } else {
                ProjectBroadcastListView.this.getPresenter().allClick(ProjectBroadcastListView.this, this.a);
            }
        }
    }

    public ProjectBroadcastListView(View view) {
        super(view);
        this.isShowNumSwiped = false;
        Application a = mu0.a();
        this.mEdgePadding = m62.a(a, 21.0f);
        this.mItemOffset = m62.a(a, 12.0f);
        this.mNowTv = (TextView) view.findViewById(R$id.item_now_tv);
        this.mTotalTv = (TextView) view.findViewById(R$id.item_total_tv);
        this.mTitleLayout = view.findViewById(R$id.card_title_layout);
        this.mNumSwipeV = view.findViewById(R$id.item_count_tip_layout);
        this.mPanel = new mg(this.mTitleLayout);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.project_broadcast_recycler);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(a, 0, false));
        this.mAdapter = new ProjectBroadcastHorAdapter(new C1828a());
        this.mRecyclerView.setItemViewCacheSize(-1);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1474629975")) {
                    ipChange.ipc$dispatch("1474629975", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    ProjectBroadcastListView.this.dispatchScrollX(recyclerView2, i);
                }
            }
        });
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1788898431")) {
                    ipChange.ipc$dispatch("-1788898431", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 0) {
                    return;
                }
                boolean z = childAdapterPosition == adapter.getItemCount() - 1;
                if (childAdapterPosition == 0) {
                    rect.left = ProjectBroadcastListView.this.mEdgePadding;
                } else {
                    rect.left = 0;
                }
                if (z) {
                    rect.right = ProjectBroadcastListView.this.mEdgePadding;
                } else {
                    rect.right = ProjectBroadcastListView.this.mItemOffset;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchScrollX(RecyclerView recyclerView, int i) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-267667672")) {
            ipChange.ipc$dispatch("-267667672", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else if (i == 0 || !this.isShowNumSwiped) {
        } else {
            int childCount = recyclerView.getChildCount();
            if (childCount == 1) {
                this.mNowTv.setText("1");
            } else if (childCount <= 1 || (childAt = recyclerView.getChildAt(childCount - 1)) == null) {
            } else {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAt.getRight() > this.mRecyclerView.getMeasuredWidth()) {
                    childAdapterPosition--;
                }
                this.mNowTv.setText((childAdapterPosition + 1) + "");
            }
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.ProjectBroadcastListContract.View
    public void setData(ProjectListBean projectListBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983952304")) {
            ipChange.ipc$dispatch("1983952304", new Object[]{this, projectListBean, Integer.valueOf(i)});
        } else if (projectListBean == null) {
        } else {
            this.mBean = projectListBean;
            int e = wh2.e(projectListBean.result);
            this.mAdapter.d(projectListBean.result);
            CardTitleBean cardTitleBean = projectListBean.mTitleBean;
            this.mPanel.h(cardTitleBean);
            if (cardTitleBean != null && cardTitleBean.hasUrl()) {
                this.mPanel.a(new View$OnClickListenerC1829b(cardTitleBean.url));
            } else {
                this.mPanel.a(null);
            }
            boolean z = (cardTitleBean == null || !cardTitleBean.showAll) && e >= 2;
            this.isShowNumSwiped = z;
            if (z) {
                this.mTotalTv.setText("/" + e);
                this.mRecyclerView.post(new Runnable() { // from class: cn.damai.tetris.component.drama.mvp.ProjectBroadcastListView.5
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "205447121")) {
                            ipChange2.ipc$dispatch("205447121", new Object[]{this});
                            return;
                        }
                        ProjectBroadcastListView projectBroadcastListView = ProjectBroadcastListView.this;
                        projectBroadcastListView.dispatchScrollX(projectBroadcastListView.mRecyclerView, -1);
                    }
                });
            }
            this.mNumSwipeV.setVisibility(this.isShowNumSwiped ? 0 : 8);
        }
    }
}
