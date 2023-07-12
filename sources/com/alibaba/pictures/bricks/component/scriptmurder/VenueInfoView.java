package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class VenueInfoView extends AbsView<GenericItem<ItemValue>, VenueInfoModel, VenueInfoPresent> implements VenueInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final VenueInfoViewHolder viewHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VenueInfoView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.viewHolder = new VenueInfoViewHolder(view);
    }

    @Override // com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoContract.View
    @NotNull
    public VenueInfoViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "120226443") ? (VenueInfoViewHolder) ipChange.ipc$dispatch("120226443", new Object[]{this}) : this.viewHolder;
    }
}
