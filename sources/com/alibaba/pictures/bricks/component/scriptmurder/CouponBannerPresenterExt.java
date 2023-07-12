package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponBannerPresenterExt extends BaseBannerPresenter {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private GenericItem<ItemValue> lastItem;
    @NotNull
    private String totalSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponBannerPresenterExt(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.totalSize = "";
    }

    public final void disPatch(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773968545")) {
            ipChange.ipc$dispatch("-1773968545", new Object[]{this, str});
            return;
        }
        b41.i(str, "msg");
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, null);
        }
    }

    @Nullable
    public final GenericItem<ItemValue> getLastItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-731743780") ? (GenericItem) ipChange.ipc$dispatch("-731743780", new Object[]{this}) : this.lastItem;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.Presenter
    public void onPageChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087078546")) {
            ipChange.ipc$dispatch("-2087078546", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onPageChanged(i);
        V view = getView();
        b41.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerViewExt");
        ((CouponBannerViewExt) view).updateImgLength(this.totalSize, String.valueOf(i + 1));
    }

    public final void setLastItem(@Nullable GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704599552")) {
            ipChange.ipc$dispatch("-1704599552", new Object[]{this, genericItem});
        } else {
            this.lastItem = genericItem;
        }
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter, com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Node node;
        List<Node> children;
        Node node2;
        List<Node> children2;
        String valueOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637185647")) {
            ipChange.ipc$dispatch("-1637185647", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init(genericItem);
        if (this.lastItem == genericItem) {
            return;
        }
        this.lastItem = genericItem;
        IContainer<ModelValue> container = genericItem.getContainer();
        ModelValue property = container != null ? container.getProperty() : null;
        b41.g(property, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
        List<Node> children3 = property.getChildren();
        if (children3 != null) {
            if (children3.isEmpty()) {
                children3 = null;
            }
            if (children3 == null || (node = children3.get(0)) == null || (children = node.getChildren()) == null) {
                return;
            }
            if (children.isEmpty()) {
                children = null;
            }
            if (children == null || (node2 = children.get(0)) == null || (children2 = node2.getChildren()) == null) {
                return;
            }
            List<Node> list = children2.isEmpty() ? null : children2;
            if (list == null || (valueOf = String.valueOf(list.size())) == null) {
                return;
            }
            this.totalSize = valueOf;
            V view = getView();
            b41.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerViewExt");
            ((CouponBannerViewExt) view).updateImgLength(valueOf, "1");
        }
    }
}
