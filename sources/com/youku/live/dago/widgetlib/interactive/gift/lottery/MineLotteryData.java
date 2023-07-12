package com.youku.live.dago.widgetlib.interactive.gift.lottery;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MineLotteryData {
    private static transient /* synthetic */ IpChange $ipChange;
    public String actorName;
    public boolean isPushMsg;
    public boolean isThirdView;
    public boolean isViewer;
    public int lotteryCount;
    public int lotteryTimes;
    public String roomId;
    private String viewerName;

    public MineLotteryData() {
        this.isThirdView = false;
        this.isViewer = false;
    }

    public String getActorName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1732079868") ? (String) ipChange.ipc$dispatch("-1732079868", new Object[]{this}) : this.actorName;
    }

    public int getLotteryCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1409546949") ? ((Integer) ipChange.ipc$dispatch("-1409546949", new Object[]{this})).intValue() : this.lotteryCount;
    }

    public int getLotteryTimes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1180995492") ? ((Integer) ipChange.ipc$dispatch("1180995492", new Object[]{this})).intValue() : this.lotteryTimes;
    }

    public String getRoomId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-438857304") ? (String) ipChange.ipc$dispatch("-438857304", new Object[]{this}) : this.roomId;
    }

    public String getViwerName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "984378592") ? (String) ipChange.ipc$dispatch("984378592", new Object[]{this}) : this.viewerName;
    }

    public boolean isPushMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1489314091") ? ((Boolean) ipChange.ipc$dispatch("1489314091", new Object[]{this})).booleanValue() : this.isPushMsg;
    }

    public boolean isThirdView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1762085414") ? ((Boolean) ipChange.ipc$dispatch("1762085414", new Object[]{this})).booleanValue() : this.isThirdView;
    }

    public boolean isViewer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-872822802") ? ((Boolean) ipChange.ipc$dispatch("-872822802", new Object[]{this})).booleanValue() : this.isViewer;
    }

    public void setLotteryCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004986823")) {
            ipChange.ipc$dispatch("2004986823", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.lotteryCount = i;
        }
    }

    public void setLotteryTimes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707423870")) {
            ipChange.ipc$dispatch("707423870", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.lotteryTimes = i;
        }
    }

    public void setThirdView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833941988")) {
            ipChange.ipc$dispatch("-833941988", new Object[]{this});
        } else {
            this.isThirdView = true;
        }
    }

    public void setViewer(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1799855452")) {
            ipChange.ipc$dispatch("-1799855452", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isViewer = z;
        }
    }

    public void setViewerName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846272687")) {
            ipChange.ipc$dispatch("846272687", new Object[]{this, str});
        } else {
            this.viewerName = str;
        }
    }

    public MineLotteryData(int i, int i2) {
        this.isThirdView = false;
        this.isViewer = false;
        this.lotteryTimes = i;
        this.lotteryCount = i2;
        this.isPushMsg = false;
    }

    public MineLotteryData(int i, String str, String str2, String str3) {
        this.isThirdView = false;
        this.isViewer = false;
        this.lotteryTimes = i;
        this.isPushMsg = true;
        this.viewerName = str;
        this.actorName = str2;
        this.lotteryCount = 1;
        this.roomId = str3;
    }
}
