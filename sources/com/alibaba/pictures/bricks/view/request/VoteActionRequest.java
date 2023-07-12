package com.alibaba.pictures.bricks.view.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.bean.VoteActionRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class VoteActionRequest extends DamaiBaseRequest<VoteActionRes> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private String activityId;
    @NotNull
    private String activityOptionId;
    @NotNull
    private String operate;

    public VoteActionRequest(@NotNull String str, @NotNull String str2, boolean z) {
        b41.i(str, "activityId");
        b41.i(str2, "activityOptionId");
        this.activityId = str;
        this.activityOptionId = str2;
        this.operate = z ? "1" : "0";
        this.API_NAME = "mtop.damai.wireless.activity.vote";
        this.VERSION = "2.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @NotNull
    public final String getActivityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1766268172") ? (String) ipChange.ipc$dispatch("-1766268172", new Object[]{this}) : this.activityId;
    }

    @NotNull
    public final String getActivityOptionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1142079305") ? (String) ipChange.ipc$dispatch("1142079305", new Object[]{this}) : this.activityOptionId;
    }

    @NotNull
    public final String getOperate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-910809072") ? (String) ipChange.ipc$dispatch("-910809072", new Object[]{this}) : this.operate;
    }

    public final void setActivityId(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1029621910")) {
            ipChange.ipc$dispatch("-1029621910", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.activityId = str;
    }

    public final void setActivityOptionId(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127074635")) {
            ipChange.ipc$dispatch("-127074635", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.activityOptionId = str;
    }

    public final void setOperate(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213436262")) {
            ipChange.ipc$dispatch("213436262", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.operate = str;
    }
}
