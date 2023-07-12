package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeProjectItemViewWannaSee extends HomeProjectItemView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeProjectItemViewWannaSee(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getPriceVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793515032")) {
            return ((Boolean) ipChange.ipc$dispatch("-1793515032", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getSubTitleVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972425659")) {
            return ((Boolean) ipChange.ipc$dispatch("-1972425659", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getWantSeeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935898418")) {
            return ((Boolean) ipChange.ipc$dispatch("-935898418", new Object[]{this})).booleanValue();
        }
        return true;
    }
}
