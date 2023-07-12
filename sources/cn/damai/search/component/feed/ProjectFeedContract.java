package cn.damai.search.component.feed;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.search.component.bean.ProjectItemBeanWrap;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.IContract;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ProjectFeedContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface Model<D extends IItem<ItemValue>> extends IContract.Model<D> {
        ProjectItemBeanWrap getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface Presenter<D extends IItem<ItemValue>, M extends Model<D>> extends IContract.Presenter<D, M> {
        void exposeProjectCard(android.view.View view, ProjectItemBean projectItemBean, int i);

        void gotoProjectActivity(ProjectItemBean projectItemBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface View extends IContract.View {
        void render(ProjectItemBeanWrap projectItemBeanWrap, int i);
    }
}
