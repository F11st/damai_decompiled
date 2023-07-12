package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeProjectItemViewSubTitle extends HomeProjectItemView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeProjectItemViewSubTitle(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getPriceVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750833500")) {
            return ((Boolean) ipChange.ipc$dispatch("-750833500", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getSubTitleVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-650390519")) {
            return ((Boolean) ipChange.ipc$dispatch("-650390519", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getWantSeeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353673866")) {
            return ((Boolean) ipChange.ipc$dispatch("353673866", new Object[]{this})).booleanValue();
        }
        return false;
    }
}
