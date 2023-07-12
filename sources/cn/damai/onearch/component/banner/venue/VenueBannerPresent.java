package cn.damai.onearch.component.banner.venue;

import android.view.View;
import cn.damai.onearch.component.banner.venue.VenueBannerContract;
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
/* loaded from: classes6.dex */
public final class VenueBannerPresent extends AbsPresenter<GenericItem<ItemValue>, VenueBannerModel, VenueBannerView> implements VenueBannerContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VenueBannerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982966696")) {
            ipChange.ipc$dispatch("982966696", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((VenueBannerPresent) genericItem);
        String str = ((VenueBannerModel) getModel()).getValue().pic;
        b41.h(str, "model.value.pic");
        ((VenueBannerView) getView()).renderBanner(str);
    }
}
