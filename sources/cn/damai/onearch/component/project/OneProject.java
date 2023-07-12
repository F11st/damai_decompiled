package cn.damai.onearch.component.project;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface OneProject {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Model {
        @NotNull
        ProjectItemBean getProject();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface View {
        @NotNull
        ProjectItemViewHolder getViewHolder();
    }
}
