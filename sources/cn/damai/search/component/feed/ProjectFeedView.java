package cn.damai.search.component.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.IFeedProjectBean;
import cn.damai.commonbusiness.discover.viewholder.HomeFeedProjectViewHolder;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.onearch.view.AbsView;
import cn.damai.search.component.bean.ProjectItemBeanWrap;
import cn.damai.search.component.feed.ProjectFeedContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ProjectFeedView extends AbsView<IItem<ItemValue>, ProjectFeedContract.Model<IItem<ItemValue>>, ProjectFeedContract.Presenter<IItem<ItemValue>, ProjectFeedContract.Model<IItem<ItemValue>>>> implements ProjectFeedContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private HomeFeedProjectViewHolder<ProjectItemBean> mHolder;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements OnItemBindListener<IFeedProjectBean<ProjectItemBean>> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, IFeedProjectBean<ProjectItemBean> iFeedProjectBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "799698810")) {
                ipChange.ipc$dispatch("799698810", new Object[]{this, view, iFeedProjectBean, Integer.valueOf(i)});
                return;
            }
            PRESENTER presenter = ProjectFeedView.this.presenter;
            if (presenter != 0) {
                ((ProjectFeedContract.Presenter) presenter).exposeProjectCard(view, iFeedProjectBean.getRaw(), i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(IFeedProjectBean<ProjectItemBean> iFeedProjectBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "905736111")) {
                ipChange.ipc$dispatch("905736111", new Object[]{this, iFeedProjectBean, Integer.valueOf(i)});
                return;
            }
            PRESENTER presenter = ProjectFeedView.this.presenter;
            if (presenter != 0) {
                ((ProjectFeedContract.Presenter) presenter).gotoProjectActivity(iFeedProjectBean.getRaw(), i);
            }
        }
    }

    public ProjectFeedView(View view) {
        super(view);
        ViewGroup viewGroup = (ViewGroup) view;
        HomeFeedProjectViewHolder<ProjectItemBean> homeFeedProjectViewHolder = new HomeFeedProjectViewHolder<>(viewGroup, LayoutInflater.from(mu0.a()).inflate(R$layout.item_discover_feed_project_home, viewGroup, false), new a());
        this.mHolder = homeFeedProjectViewHolder;
        viewGroup.addView(homeFeedProjectViewHolder.itemView);
    }

    @Override // cn.damai.search.component.feed.ProjectFeedContract.View
    public void render(ProjectItemBeanWrap projectItemBeanWrap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-191201551")) {
            ipChange.ipc$dispatch("-191201551", new Object[]{this, projectItemBeanWrap, Integer.valueOf(i)});
        } else if (projectItemBeanWrap == null || projectItemBeanWrap.mBean == null) {
        } else {
            this.mHolder.a(projectItemBeanWrap, i);
        }
    }
}
