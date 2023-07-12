package com.alibaba.pictures.bricks.selector.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptSelectMo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String describe;
    @Nullable
    private String headImgUrl;
    @Nullable
    private String targetId;
    @Nullable
    private String targetName;
    @Nullable
    private String targetType;

    @Nullable
    public final String getDescribe() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2043246744") ? (String) ipChange.ipc$dispatch("-2043246744", new Object[]{this}) : this.describe;
    }

    @Nullable
    public final String getHeadImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "494310985") ? (String) ipChange.ipc$dispatch("494310985", new Object[]{this}) : this.headImgUrl;
    }

    @Nullable
    public final String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-246431575") ? (String) ipChange.ipc$dispatch("-246431575", new Object[]{this}) : this.targetId;
    }

    @Nullable
    public final String getTargetName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-526659239") ? (String) ipChange.ipc$dispatch("-526659239", new Object[]{this}) : this.targetName;
    }

    @Nullable
    public final String getTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1356642440") ? (String) ipChange.ipc$dispatch("1356642440", new Object[]{this}) : this.targetType;
    }

    public final void setDescribe(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201532534")) {
            ipChange.ipc$dispatch("1201532534", new Object[]{this, str});
        } else {
            this.describe = str;
        }
    }

    public final void setHeadImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328855221")) {
            ipChange.ipc$dispatch("328855221", new Object[]{this, str});
        } else {
            this.headImgUrl = str;
        }
    }

    public final void setTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068227925")) {
            ipChange.ipc$dispatch("1068227925", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }

    public final void setTargetName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256450651")) {
            ipChange.ipc$dispatch("-1256450651", new Object[]{this, str});
        } else {
            this.targetName = str;
        }
    }

    public final void setTargetType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1291326550")) {
            ipChange.ipc$dispatch("1291326550", new Object[]{this, str});
        } else {
            this.targetType = str;
        }
    }
}
