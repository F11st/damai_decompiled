package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BottomAction {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String extra;
    @Nullable
    private String title;

    public BottomAction() {
        this(null, null, 3, null);
    }

    public BottomAction(@Nullable String str, @Nullable String str2) {
        this.title = str;
        this.extra = str2;
    }

    @Nullable
    public final String getExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "444102305") ? (String) ipChange.ipc$dispatch("444102305", new Object[]{this}) : this.extra;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "544674025") ? (String) ipChange.ipc$dispatch("544674025", new Object[]{this}) : this.title;
    }

    public final void setExtra(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921330187")) {
            ipChange.ipc$dispatch("-921330187", new Object[]{this, str});
        } else {
            this.extra = str;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2098574163")) {
            ipChange.ipc$dispatch("-2098574163", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public /* synthetic */ BottomAction(String str, String str2, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
