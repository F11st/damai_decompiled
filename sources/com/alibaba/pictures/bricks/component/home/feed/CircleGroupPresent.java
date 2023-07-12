package com.alibaba.pictures.bricks.component.home.feed;

import android.view.View;
import com.alibaba.pictures.bricks.bean.CircleCard;
import com.alibaba.pictures.bricks.component.home.feed.CircleGroupContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
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
public final class CircleGroupPresent extends AbsPresenter<GenericItem<ItemValue>, CircleGroupModel, CircleGroupView> implements CircleGroupContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleGroupPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.CircleGroupContract.Present
    public void onClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400001737")) {
            ipChange.ipc$dispatch("1400001737", new Object[]{this});
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        Action itemAction = getItemAction();
        action.setActionUrl(itemAction != null ? itemAction.getActionUrl() : null);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348730264")) {
            ipChange.ipc$dispatch("-1348730264", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((CircleGroupPresent) genericItem);
        CircleCard value = ((CircleGroupModel) getModel()).getValue();
        b41.h(value, "model.value");
        ((CircleGroupView) getView()).bindView(value);
    }
}
