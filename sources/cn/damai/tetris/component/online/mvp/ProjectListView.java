package cn.damai.tetris.component.online.mvp;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.online.bean.OnlineTitleBean;
import cn.damai.tetris.component.online.bean.ProjectInfoBean;
import cn.damai.tetris.component.online.bean.ProjectList;
import cn.damai.tetris.component.online.mvp.ProjectListContract;
import cn.damai.tetris.component.online.viewholder.OnlineProListRecycleAdapter;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.lo2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectListView extends AbsView<ProjectListContract.Presenter> implements ProjectListContract.View<ProjectListContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnlineProListRecycleAdapter mAdapter;
    private final int mEdgePadding;
    private final lo2 mPanel;
    private int mPos;
    private final int mRightSize;
    private String mTitleName;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnItemBindListener<ProjectInfoBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, ProjectInfoBean projectInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1055022294")) {
                ipChange.ipc$dispatch("-1055022294", new Object[]{this, view, projectInfoBean, Integer.valueOf(i)});
            } else {
                ProjectListView.this.getPresenter().expose(view, projectInfoBean, i, ProjectListView.this.mTitleName);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(ProjectInfoBean projectInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2093234965")) {
                ipChange.ipc$dispatch("2093234965", new Object[]{this, projectInfoBean, Integer.valueOf(i)});
                return;
            }
            ProjectListView projectListView = ProjectListView.this;
            ProjectListView.this.getPresenter().itemClick(projectListView, projectInfoBean, i, projectListView.mTitleName);
        }
    }

    public ProjectListView(View view) {
        super(view);
        this.mRightSize = l62.a(mu0.a(), 12.0f);
        this.mEdgePadding = l62.a(mu0.a(), 21.0f);
        this.mPanel = new lo2(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.online_prolist_recycler);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.online.mvp.ProjectListView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-872403460")) {
                    ipChange.ipc$dispatch("-872403460", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                if (childAdapterPosition == 0) {
                    rect.left = ProjectListView.this.mEdgePadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == ProjectListView.this.mAdapter.getItemCount() - 1) {
                    rect.right = ProjectListView.this.mEdgePadding;
                } else {
                    rect.right = ProjectListView.this.mRightSize;
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        OnlineProListRecycleAdapter onlineProListRecycleAdapter = new OnlineProListRecycleAdapter(new a());
        this.mAdapter = onlineProListRecycleAdapter;
        recyclerView.setAdapter(onlineProListRecycleAdapter);
    }

    @Override // cn.damai.tetris.component.online.mvp.ProjectListContract.View
    public void setData(ProjectList projectList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816852883")) {
            ipChange.ipc$dispatch("-816852883", new Object[]{this, projectList, Integer.valueOf(i)});
        } else if (projectList == null) {
        } else {
            this.mPos = i;
            this.mAdapter.d(projectList.result);
            OnlineTitleBean onlineTitleBean = projectList.mTitleBean;
            if (onlineTitleBean != null) {
                this.mPanel.b(true);
                String str = onlineTitleBean.title;
                this.mTitleName = str;
                this.mPanel.a(str);
            }
        }
    }
}
