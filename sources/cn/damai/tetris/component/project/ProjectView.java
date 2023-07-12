package cn.damai.tetris.component.project;

import android.view.View;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.tetris.component.project.ProjectContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectView extends AbsView<ProjectContract.Presenter> implements ProjectContract.View<ProjectContract.Presenter>, OnItemClickListener<ProjectItemBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    ProjectItemViewHolder viewHolder;

    public ProjectView(View view) {
        super(view);
        this.viewHolder = new ProjectItemViewHolder(view.getContext(), view);
    }

    @Override // cn.damai.tetris.component.project.ProjectContract.View
    public ProjectItemViewHolder getHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2031157340") ? (ProjectItemViewHolder) ipChange.ipc$dispatch("-2031157340", new Object[]{this}) : this.viewHolder;
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(ProjectItemBean projectItemBean, int i) {
        rm1.a(this, projectItemBean, i);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public void onEditClick(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432814256")) {
            ipChange.ipc$dispatch("-1432814256", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public void onItemClick(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1931612007")) {
            ipChange.ipc$dispatch("-1931612007", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        }
    }
}
