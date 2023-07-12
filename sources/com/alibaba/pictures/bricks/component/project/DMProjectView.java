package com.alibaba.pictures.bricks.component.project;

import android.content.Context;
import android.view.View;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DMProjectView extends AbsView<IItem<ItemValue>, DMProjectModel, DMProjectPresent> implements DMProjectContract$View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private DMProjectViewHolder projectItemViewHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DMProjectView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        Context context = view.getContext();
        b41.h(context, "view.context");
        this.projectItemViewHolder = new DMProjectViewHolder(context, view);
    }

    @Override // com.alibaba.pictures.bricks.component.project.DMProjectContract$View
    @NotNull
    public DMProjectViewHolder fetchViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2097524821") ? (DMProjectViewHolder) ipChange.ipc$dispatch("2097524821", new Object[]{this}) : this.projectItemViewHolder;
    }

    @NotNull
    public final DMProjectViewHolder getProjectItemViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1507142523") ? (DMProjectViewHolder) ipChange.ipc$dispatch("1507142523", new Object[]{this}) : this.projectItemViewHolder;
    }

    public final void setProjectItemViewHolder(@NotNull DMProjectViewHolder dMProjectViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825075745")) {
            ipChange.ipc$dispatch("825075745", new Object[]{this, dMProjectViewHolder});
            return;
        }
        b41.i(dMProjectViewHolder, "<set-?>");
        this.projectItemViewHolder = dMProjectViewHolder;
    }
}
