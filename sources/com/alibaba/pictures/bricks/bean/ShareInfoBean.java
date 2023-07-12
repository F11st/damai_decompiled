package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShareInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String shareImage;
    @Nullable
    private String shareSubTitle;
    @Nullable
    private String shareTitle;
    @Nullable
    private String shareUrl;

    @Nullable
    public final String getShareImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1813489087") ? (String) ipChange.ipc$dispatch("1813489087", new Object[]{this}) : this.shareImage;
    }

    @Nullable
    public final String getShareSubTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "637679882") ? (String) ipChange.ipc$dispatch("637679882", new Object[]{this}) : this.shareSubTitle;
    }

    @Nullable
    public final String getShareTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1282391612") ? (String) ipChange.ipc$dispatch("1282391612", new Object[]{this}) : this.shareTitle;
    }

    @Nullable
    public final String getShareUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "142647827") ? (String) ipChange.ipc$dispatch("142647827", new Object[]{this}) : this.shareUrl;
    }

    public final void setShareImage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1726296577")) {
            ipChange.ipc$dispatch("-1726296577", new Object[]{this, str});
        } else {
            this.shareImage = str;
        }
    }

    public final void setShareSubTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719543468")) {
            ipChange.ipc$dispatch("719543468", new Object[]{this, str});
        } else {
            this.shareSubTitle = str;
        }
    }

    public final void setShareTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010449118")) {
            ipChange.ipc$dispatch("-1010449118", new Object[]{this, str});
        } else {
            this.shareTitle = str;
        }
    }

    public final void setShareUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244787499")) {
            ipChange.ipc$dispatch("244787499", new Object[]{this, str});
        } else {
            this.shareUrl = str;
        }
    }
}
