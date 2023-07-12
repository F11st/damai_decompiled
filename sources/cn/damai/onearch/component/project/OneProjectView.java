package cn.damai.onearch.component.project;

import android.view.View;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.onearch.component.project.OneProject;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class OneProjectView extends AbsView<GenericItem<ItemValue>, OneProjectModel, OneProjectPresent> implements OneProject.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @NotNull
    private final ProjectItemViewHolder mViewHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneProjectView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mViewHolder = new ProjectItemViewHolder(mu0.a(), view);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "238335315") ? (View) ipChange.ipc$dispatch("238335315", new Object[]{this}) : this.itemView;
    }

    @Override // cn.damai.onearch.component.project.OneProject.View
    @NotNull
    public ProjectItemViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-370460884") ? (ProjectItemViewHolder) ipChange.ipc$dispatch("-370460884", new Object[]{this}) : this.mViewHolder;
    }
}
