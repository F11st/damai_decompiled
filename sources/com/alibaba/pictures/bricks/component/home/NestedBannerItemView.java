package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NestedBannerItemView extends AbsView<GenericItem<ItemValue>, NestedBannerItemModel, NestedBannerItemPresent> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedBannerItemView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1243412116") ? (View) ipChange.ipc$dispatch("-1243412116", new Object[]{this}) : this.itemView;
    }
}
