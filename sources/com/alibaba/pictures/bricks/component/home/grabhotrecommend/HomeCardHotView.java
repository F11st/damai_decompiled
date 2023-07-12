package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeCardHotView extends HomeCardGrabView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeCardHotView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView
    public boolean isGrabHotProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352502360")) {
            return ((Boolean) ipChange.ipc$dispatch("-352502360", new Object[]{this})).booleanValue();
        }
        return false;
    }
}
