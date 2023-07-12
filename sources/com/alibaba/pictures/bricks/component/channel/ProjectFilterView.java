package com.alibaba.pictures.bricks.component.channel;

import android.view.View;
import cn.damai.projectfiltercopy.bean.FilterResponse;
import com.alibaba.pictures.bricks.component.channel.ProjectFilterContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectFilterView extends AbsView<GenericItem<ItemValue>, ProjectFilterModel, ProjectFilterPresent> implements ProjectFilterContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectFilterView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
    }

    @Override // com.alibaba.pictures.bricks.component.channel.ProjectFilterContract.View
    public void bind(@Nullable FilterResponse filterResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814261167")) {
            ipChange.ipc$dispatch("1814261167", new Object[]{this, filterResponse});
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "115858637") ? (View) ipChange.ipc$dispatch("115858637", new Object[]{this}) : this.itemView;
    }
}
