package com.alibaba.pictures.bricks.component.home.ball;

import android.view.View;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.xw0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeBallPresent extends AbsPresenter<GenericItem<ItemValue>, HomeBallModel, HomeBallView> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private GenericItem<ItemValue> oldItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeBallPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1901526590")) {
            ipChange.ipc$dispatch("-1901526590", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.onItemClick(view);
        xw0.d(((HomeBallModel) getModel()).getValue());
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461606268")) {
            ipChange.ipc$dispatch("1461606268", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        long currentTimeMillis = System.currentTimeMillis();
        super.init((HomeBallPresent) genericItem);
        if (b41.d(this.oldItem, genericItem)) {
            LogUtil.e("bricks $" + HomeBallPresent.class.getName() + " old", new Object[0]);
            return;
        }
        this.oldItem = genericItem;
        ((HomeBallView) getView()).bindView(((HomeBallModel) getModel()).getValue());
        LogUtil.e("bricks $" + HomeBallPresent.class.getName() + ' ' + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }
}
