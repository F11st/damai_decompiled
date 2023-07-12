package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NestedBannerItemPresent extends AbsPresenter<GenericItem<ItemValue>, NestedBannerItemModel, NestedBannerItemView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedBannerItemPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }
}
