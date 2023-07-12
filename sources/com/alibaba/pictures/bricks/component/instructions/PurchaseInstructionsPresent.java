package com.alibaba.pictures.bricks.component.instructions;

import android.view.View;
import com.alibaba.pictures.bricks.component.instructions.PurchaseInstructionsContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class PurchaseInstructionsPresent extends AbsPresenter<GenericItem<ItemValue>, PurchaseInstructionsModel, PurchaseInstructionsView> implements PurchaseInstructionsContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseInstructionsPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255646922")) {
            ipChange.ipc$dispatch("1255646922", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((PurchaseInstructionsPresent) genericItem);
        ((PurchaseInstructionsView) getView()).renderTitle(((PurchaseInstructionsModel) getModel()).getTitle());
        ((PurchaseInstructionsView) getView()).renderContent(((PurchaseInstructionsModel) getModel()).getContent());
    }
}
