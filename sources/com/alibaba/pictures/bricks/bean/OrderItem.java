package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String nickName;
    @Nullable
    private String text;
    @Nullable
    private String time;

    @Nullable
    public final String getNickName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1253217515") ? (String) ipChange.ipc$dispatch("-1253217515", new Object[]{this}) : this.nickName;
    }

    @Nullable
    public final String getText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1798484940") ? (String) ipChange.ipc$dispatch("-1798484940", new Object[]{this}) : this.text;
    }

    @Nullable
    public final String getTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "954091988") ? (String) ipChange.ipc$dispatch("954091988", new Object[]{this}) : this.time;
    }

    public final void setNickName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77365143")) {
            ipChange.ipc$dispatch("-77365143", new Object[]{this, str});
        } else {
            this.nickName = str;
        }
    }

    public final void setText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211215062")) {
            ipChange.ipc$dispatch("-211215062", new Object[]{this, str});
        } else {
            this.text = str;
        }
    }

    public final void setTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780676214")) {
            ipChange.ipc$dispatch("-780676214", new Object[]{this, str});
        } else {
            this.time = str;
        }
    }
}
