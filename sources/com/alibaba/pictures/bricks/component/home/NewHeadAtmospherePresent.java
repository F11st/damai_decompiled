package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NewHeadAtmospherePresent extends AbsPresenter<GenericItem<ItemValue>, NewHeadAtmosphereModel, NewHeadAtmosphereView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewHeadAtmospherePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1090221822") ? ((Boolean) ipChange.ipc$dispatch("1090221822", new Object[]{this})).booleanValue() : (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) ? false : true;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160891248")) {
            ipChange.ipc$dispatch("-1160891248", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((NewHeadAtmospherePresent) genericItem);
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        RecyclerView recyclerView = fragment != null ? fragment.getRecyclerView() : null;
        Activity activity = genericItem.getPageContext().getActivity();
        if (activity != null) {
            ((NewHeadAtmosphereView) getView()).bindView(recyclerView, isLargeScreenMode(), activity, genericItem.getPageContext().getEventBus(), ((NewHeadAtmosphereModel) getModel()).getValue());
        }
    }
}
