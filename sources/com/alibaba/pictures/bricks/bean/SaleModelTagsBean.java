package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SaleModelTagsBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String desc;
    @Nullable
    private String type;

    @Nullable
    public final String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2006045118") ? (String) ipChange.ipc$dispatch("-2006045118", new Object[]{this}) : this.desc;
    }

    @Nullable
    public final String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1710763925") ? (String) ipChange.ipc$dispatch("-1710763925", new Object[]{this}) : this.type;
    }

    public final boolean isCityLimitTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2124339403") ? ((Boolean) ipChange.ipc$dispatch("-2124339403", new Object[]{this})).booleanValue() : "2" == this.type;
    }

    public final void setDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944354012")) {
            ipChange.ipc$dispatch("1944354012", new Object[]{this, str});
        } else {
            this.desc = str;
        }
    }

    public final void setType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786830893")) {
            ipChange.ipc$dispatch("-1786830893", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }
}
