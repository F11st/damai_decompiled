package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeProjectItemViewPrice extends HomeProjectItemView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeProjectItemViewPrice(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getPriceVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804255085")) {
            return ((Boolean) ipChange.ipc$dispatch("804255085", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getSubTitleVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476390560")) {
            return ((Boolean) ipChange.ipc$dispatch("1476390560", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemView
    public boolean getWantSeeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145185043")) {
            return ((Boolean) ipChange.ipc$dispatch("145185043", new Object[]{this})).booleanValue();
        }
        return false;
    }
}
