package cn.damai.search.component.feed;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.onearch.view.AbsPresenter;
import cn.damai.search.component.feed.ProjectFeedContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import tb.c82;
import tb.qd2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ProjectFeedPresent extends AbsPresenter<IItem<ItemValue>, ProjectFeedContract.Model<IItem<ItemValue>>, ProjectFeedContract.View> implements ProjectFeedContract.Presenter<IItem<ItemValue>, ProjectFeedContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ProjectFeedPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    private Context getContext2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1964255701")) {
            return (Context) ipChange.ipc$dispatch("1964255701", new Object[]{this});
        }
        VIEW view = this.view;
        if (view == 0 || ((ProjectFeedContract.View) view).getRenderView() == null) {
            return null;
        }
        return ((ProjectFeedContract.View) this.view).getRenderView().getContext();
    }

    @Override // cn.damai.search.component.feed.ProjectFeedContract.Presenter
    public void exposeProjectCard(View view, ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378427810")) {
            ipChange.ipc$dispatch("-378427810", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
        } else {
            userTrackExpose(view, c82.k(getTrackArgs(), projectItemBean, i));
        }
    }

    @Override // cn.damai.search.component.feed.ProjectFeedContract.Presenter
    public void gotoProjectActivity(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573055758")) {
            ipChange.ipc$dispatch("573055758", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        Context context2 = getContext2();
        if (context2 != null) {
            userTrackClick(c82.k(getTrackArgs(), projectItemBean, i), true);
            qd2.b(context2, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86247666")) {
            ipChange.ipc$dispatch("-86247666", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        ((ProjectFeedContract.View) this.view).render(((ProjectFeedContract.Model) this.model).getBean(), iItem.getIndex());
    }
}
