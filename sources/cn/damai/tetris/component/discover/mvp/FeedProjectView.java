package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.viewholder.FeedProjectViewHolder;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.discover.mvp.FeedProjectContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FeedProjectView extends AbsView<FeedProjectContract.Presenter> implements FeedProjectContract.View<FeedProjectContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private FeedProjectViewHolder mViewHolder;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnItemBindListener<ProjectItemBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1161667525")) {
                ipChange.ipc$dispatch("1161667525", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
                return;
            }
            FeedProjectContract.Presenter presenter = FeedProjectView.this.getPresenter();
            if (presenter != null) {
                presenter.exposeItem(view, projectItemBean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1451327952")) {
                ipChange.ipc$dispatch("-1451327952", new Object[]{this, projectItemBean, Integer.valueOf(i)});
                return;
            }
            FeedProjectContract.Presenter presenter = FeedProjectView.this.getPresenter();
            if (presenter != null) {
                presenter.itemClick(FeedProjectView.this, projectItemBean, i);
            }
        }
    }

    public FeedProjectView(View view) {
        super(view);
        this.mViewHolder = new FeedProjectViewHolder(view, new a());
    }

    @Override // cn.damai.tetris.component.discover.mvp.FeedProjectContract.View
    public void setData(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769538617")) {
            ipChange.ipc$dispatch("-769538617", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        } else {
            this.mViewHolder.a(projectItemBean, i);
        }
    }
}
