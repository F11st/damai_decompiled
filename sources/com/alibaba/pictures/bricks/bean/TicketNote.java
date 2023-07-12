package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TicketNote implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String content;
    @Nullable
    private String imgUrl;
    @Nullable
    private String title;

    @Nullable
    public final String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-858311155") ? (String) ipChange.ipc$dispatch("-858311155", new Object[]{this}) : this.content;
    }

    @Nullable
    public final String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1742646030") ? (String) ipChange.ipc$dispatch("1742646030", new Object[]{this}) : this.imgUrl;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1428192428") ? (String) ipChange.ipc$dispatch("1428192428", new Object[]{this}) : this.title;
    }

    public final void setContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840871689")) {
            ipChange.ipc$dispatch("1840871689", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public final void setImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087327376")) {
            ipChange.ipc$dispatch("1087327376", new Object[]{this, str});
        } else {
            this.imgUrl = str;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479307446")) {
            ipChange.ipc$dispatch("-479307446", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }
}
