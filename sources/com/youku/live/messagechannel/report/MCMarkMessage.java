package com.youku.live.messagechannel.report;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.message.MCMessage;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMarkMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    public long bizFinishedTime;
    public long dispatchTime;
    public MCMessage mcMessage;
    public boolean processTimeout;

    public MCMarkMessage(long j, long j2, MCMessage mCMessage, boolean z) {
        this.dispatchTime = j;
        this.bizFinishedTime = j2;
        this.mcMessage = mCMessage;
        this.processTimeout = z;
    }

    public MCMarkMessageReportData convert2MCMarkMessageReportData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734503669")) {
            return (MCMarkMessageReportData) ipChange.ipc$dispatch("1734503669", new Object[]{this});
        }
        MCMessage mCMessage = this.mcMessage;
        String str = mCMessage.msgId;
        String name = mCMessage.connectionSource.name();
        MCMessage mCMessage2 = this.mcMessage;
        String str2 = mCMessage2.msgType;
        String str3 = mCMessage2.qos;
        long j = mCMessage2.sendTime;
        long j2 = this.dispatchTime;
        long j3 = this.bizFinishedTime;
        return new MCMarkMessageReportData(str, name, str2, str3, j, j2, j2 - j, j3, j3 - j, j3 - j2, this.processTimeout);
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "412643914")) {
            return (String) ipChange.ipc$dispatch("412643914", new Object[]{this});
        }
        return "MCMarkMessage{dispatchTime=" + this.dispatchTime + ", bizFinishedTime=" + this.bizFinishedTime + ", mcMessage=" + this.mcMessage + ", processTimeout=" + this.processTimeout + '}';
    }
}
