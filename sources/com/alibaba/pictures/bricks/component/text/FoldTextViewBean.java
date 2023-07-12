package com.alibaba.pictures.bricks.component.text;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FoldTextViewBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String desc;

    @Nullable
    public final String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-896387895") ? (String) ipChange.ipc$dispatch("-896387895", new Object[]{this}) : this.desc;
    }

    public final void setDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983989557")) {
            ipChange.ipc$dispatch("1983989557", new Object[]{this, str});
        } else {
            this.desc = str;
        }
    }
}
