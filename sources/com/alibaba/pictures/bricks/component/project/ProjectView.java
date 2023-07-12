package com.alibaba.pictures.bricks.component.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.bricks.component.project.ProjectContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectView extends AbsView<IItem<ItemValue>, ProjectContract.Model<IItem<ItemValue>>, ProjectContract.Presenter<IItem<ItemValue>, ProjectContract.Model<IItem<ItemValue>>>> implements ProjectContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    BricksProjectViewHolder projectItemViewHolder;

    public ProjectView(View view) {
        super(view);
        Context context = view.getContext();
        BricksProjectViewHolder bricksProjectViewHolder = new BricksProjectViewHolder(context, LayoutInflater.from(context));
        this.projectItemViewHolder = bricksProjectViewHolder;
        ((ViewGroup) view).addView(bricksProjectViewHolder.itemView);
    }

    @Override // com.alibaba.pictures.bricks.component.project.ProjectContract.View
    public BricksProjectViewHolder getHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "902139774") ? (BricksProjectViewHolder) ipChange.ipc$dispatch("902139774", new Object[]{this}) : this.projectItemViewHolder;
    }
}
