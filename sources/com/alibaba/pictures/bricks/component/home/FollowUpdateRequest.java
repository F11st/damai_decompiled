package com.alibaba.pictures.bricks.component.home;

import cn.damai.network.ApiConstant;
import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;
import tb.hm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FollowUpdateRequest extends DamaiBaseRequest<FollowStateBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String operateType;
    @Nullable
    private String targetId;
    @Nullable
    private String targetType;

    public FollowUpdateRequest() {
        this.API_NAME = ApiConstant.API_NAME_RELATION_UPDATE;
        this.VERSION = "1.2";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final String getOperateType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1413960584") ? (String) ipChange.ipc$dispatch("-1413960584", new Object[]{this}) : this.operateType;
    }

    @Nullable
    public final String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1243402776") ? (String) ipChange.ipc$dispatch("-1243402776", new Object[]{this}) : this.targetId;
    }

    @Nullable
    public final String getTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1045025287") ? (String) ipChange.ipc$dispatch("1045025287", new Object[]{this}) : this.targetType;
    }

    public final void init(boolean z, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362551010")) {
            ipChange.ipc$dispatch("-362551010", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.operateType = z ? "1" : "0";
        this.targetId = str;
        this.targetType = hm1.c(str, 0.0d) >= 1.0E8d ? "7" : "6";
    }

    public final void setOperateType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111910910")) {
            ipChange.ipc$dispatch("1111910910", new Object[]{this, str});
        } else {
            this.operateType = str;
        }
    }

    public final void setTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226891766")) {
            ipChange.ipc$dispatch("226891766", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }

    public final void setTargetType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221129399")) {
            ipChange.ipc$dispatch("221129399", new Object[]{this, str});
        } else {
            this.targetType = str;
        }
    }
}
