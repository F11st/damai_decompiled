package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class StatusInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Long closeTime;
    @Nullable
    private Long currentTime;
    @Nullable
    private String dialogTips;
    @Nullable
    private String orderStatusStr;
    @Nullable
    private String orderTips;
    private long overdueTime;
    @Nullable
    private String showStatus;
    @Nullable
    private String totalAmount;

    @Nullable
    public final Long getCloseTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "155300822") ? (Long) ipChange.ipc$dispatch("155300822", new Object[]{this}) : this.closeTime;
    }

    @Nullable
    public final Long getCurrentTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1797520297") ? (Long) ipChange.ipc$dispatch("-1797520297", new Object[]{this}) : this.currentTime;
    }

    @Nullable
    public final String getDialogTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-821914726") ? (String) ipChange.ipc$dispatch("-821914726", new Object[]{this}) : this.dialogTips;
    }

    @Nullable
    public final String getOrderStatusStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "814324267") ? (String) ipChange.ipc$dispatch("814324267", new Object[]{this}) : this.orderStatusStr;
    }

    @Nullable
    public final String getOrderTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "962275170") ? (String) ipChange.ipc$dispatch("962275170", new Object[]{this}) : this.orderTips;
    }

    public final long getOverdueTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1499978773") ? ((Long) ipChange.ipc$dispatch("-1499978773", new Object[]{this})).longValue() : this.overdueTime;
    }

    @Nullable
    public final String getShowStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1899768521") ? (String) ipChange.ipc$dispatch("1899768521", new Object[]{this}) : this.showStatus;
    }

    @Nullable
    public final String getTotalAmount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-271784648") ? (String) ipChange.ipc$dispatch("-271784648", new Object[]{this}) : this.totalAmount;
    }

    public final void setCloseTime(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "195377322")) {
            ipChange.ipc$dispatch("195377322", new Object[]{this, l});
        } else {
            this.closeTime = l;
        }
    }

    public final void setCurrentTime(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561486519")) {
            ipChange.ipc$dispatch("-561486519", new Object[]{this, l});
        } else {
            this.currentTime = l;
        }
    }

    public final void setDialogTips(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1819436156")) {
            ipChange.ipc$dispatch("-1819436156", new Object[]{this, str});
        } else {
            this.dialogTips = str;
        }
    }

    public final void setOrderStatusStr(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357141779")) {
            ipChange.ipc$dispatch("357141779", new Object[]{this, str});
        } else {
            this.orderStatusStr = str;
        }
    }

    public final void setOrderTips(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2095521620")) {
            ipChange.ipc$dispatch("2095521620", new Object[]{this, str});
        } else {
            this.orderTips = str;
        }
    }

    public final void setOverdueTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1665362721")) {
            ipChange.ipc$dispatch("1665362721", new Object[]{this, Long.valueOf(j)});
        } else {
            this.overdueTime = j;
        }
    }

    public final void setShowStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948365877")) {
            ipChange.ipc$dispatch("948365877", new Object[]{this, str});
        } else {
            this.showStatus = str;
        }
    }

    public final void setTotalAmount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135340738")) {
            ipChange.ipc$dispatch("-2135340738", new Object[]{this, str});
        } else {
            this.totalAmount = str;
        }
    }
}
