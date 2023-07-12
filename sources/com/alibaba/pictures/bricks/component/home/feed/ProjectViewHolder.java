package com.alibaba.pictures.bricks.component.home.feed;

import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.pictures.bricks.bean.WaterFlowRec2Project;
import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HomeFeedProjectViewHolder<WaterFlowRecommendItem> viewHolder;

    public ProjectViewHolder(View view) {
        super(view);
        this.viewHolder = new HomeFeedProjectViewHolder<>(null, view);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727647511")) {
            ipChange.ipc$dispatch("-727647511", new Object[]{this, iItem});
            return;
        }
        try {
            this.viewHolder.a(new WaterFlowRec2Project(getValue()), 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
