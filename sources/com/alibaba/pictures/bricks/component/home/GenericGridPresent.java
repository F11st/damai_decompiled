package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.alient.onearch.adapter.component.grid.GenericGridPresenter;
import com.alient.onearch.adapter.component.grid.GenericGridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.nd;
import tb.r8;
import tb.s8;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GenericGridPresent extends GenericGridPresenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericGridPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @Override // com.alient.onearch.adapter.component.grid.GenericGridPresenter, com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        boolean z;
        boolean z2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1360257835")) {
            ipChange.ipc$dispatch("1360257835", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        Bundle bundle = genericItem.getComponent().getPageContext().getBundle();
        if (bundle != null) {
            z2 = bundle.getBoolean(r8.KEY_IS_HAS_ATMOSPHERE, false);
            z = bundle.getBoolean(r8.KEY_IS_HAS_CLICK_AREA_HEIGHT, false);
        } else {
            z = false;
            z2 = false;
        }
        Activity activity = genericItem.getPageContext().getActivity();
        if (activity != null) {
            s8 a = r8.INSTANCE.a(activity);
            if (z2) {
                if (z) {
                    i = -a.b();
                } else {
                    i = -(a.c() + a.b());
                }
            }
            View renderView = ((GenericGridView) getView()).getRenderView();
            ViewGroup.LayoutParams layoutParams = renderView != null ? renderView.getLayoutParams() : null;
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null && marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                View renderView2 = ((GenericGridView) getView()).getRenderView();
                if (renderView2 != null) {
                    renderView2.requestLayout();
                }
            }
        }
        nd.a("isHasAtmosphere=" + z2 + " isHasClickArea=" + z, r8.TAG);
        super.init(genericItem);
    }
}
