package com.alibaba.pictures.bricks.component.artist.project.title;

import android.view.View;
import com.alibaba.pictures.R$id;
import com.alient.onearch.adapter.component.header.GenericHeaderPresent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HeaderPresent extends GenericHeaderPresent {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final View renderView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.renderView = view;
    }

    private final boolean hasShowCityComponent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285474067")) {
            return ((Boolean) ipChange.ipc$dispatch("-1285474067", new Object[]{this})).booleanValue();
        }
        Iterator<T> it = ((GenericItem) getItem()).getComponent().getModule().getContainer().getModules().iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = ((IModule) it.next()).getComponents().iterator();
            while (it2.hasNext()) {
                IComponent iComponent = (IComponent) it2.next();
                if (iComponent.getType() == 7610 && (!iComponent.getItems().isEmpty())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final View getRenderView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2104298313") ? (View) ipChange.ipc$dispatch("-2104298313", new Object[]{this}) : this.renderView;
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderPresent, com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        View findViewById;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231848060")) {
            ipChange.ipc$dispatch("1231848060", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init(genericItem);
        View view = this.renderView;
        if (view == null || (findViewById = view.findViewById(R$id.top_line)) == null) {
            return;
        }
        findViewById.setVisibility(hasShowCityComponent() ? 0 : 4);
    }
}
