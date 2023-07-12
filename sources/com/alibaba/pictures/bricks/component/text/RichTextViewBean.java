package com.alibaba.pictures.bricks.component.text;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RichTextViewBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String detailContent;

    @Nullable
    public final String getDetailContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1857293227") ? (String) ipChange.ipc$dispatch("1857293227", new Object[]{this}) : this.detailContent;
    }

    public final void setDetailContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127148501")) {
            ipChange.ipc$dispatch("-127148501", new Object[]{this, str});
        } else {
            this.detailContent = str;
        }
    }
}
