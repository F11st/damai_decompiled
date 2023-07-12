package com.alibaba.pictures.bricks.component.scriptcoupon;

import android.view.View;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponInfoView extends AbsView<GenericItem<ItemValue>, CouponInfoModel, CouponInfoPresent> implements CouponInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final CouponInfoViewHolder viewHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponInfoView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.viewHolder = new CouponInfoViewHolder(view);
    }

    @Override // com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoContract.View
    @NotNull
    public CouponInfoViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "935411465") ? (CouponInfoViewHolder) ipChange.ipc$dispatch("935411465", new Object[]{this}) : this.viewHolder;
    }
}
