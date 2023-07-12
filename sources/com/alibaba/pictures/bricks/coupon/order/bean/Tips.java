package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Tips {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final String yellowTips;
    @Nullable
    private final String yellowTipsIcon;

    public Tips(@Nullable String str, @Nullable String str2) {
        this.yellowTips = str;
        this.yellowTipsIcon = str2;
    }

    @Nullable
    public final String getYellowTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1943761410") ? (String) ipChange.ipc$dispatch("-1943761410", new Object[]{this}) : this.yellowTips;
    }

    @Nullable
    public final String getYellowTipsIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2066392727") ? (String) ipChange.ipc$dispatch("2066392727", new Object[]{this}) : this.yellowTipsIcon;
    }
}
