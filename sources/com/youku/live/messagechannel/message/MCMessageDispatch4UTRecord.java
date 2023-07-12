package com.youku.live.messagechannel.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMessageDispatch4UTRecord {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = ALBiometricsKeys.KEY_APP_ID)
    public long appId;
    @JSONField(name = RemoteMessageConst.Notification.CHANNEL_ID)
    public String channelId;
    @JSONField(name = "connectionSource")
    public String connectionSource;
    @JSONField(name = "dispatchCallbackTime")
    public long dispatchCallbackTime;
    @JSONField(name = "dispatchTime")
    public long dispatchTime;
    @JSONField(name = "expireTime")
    public int expireTime;
    @JSONField(name = RemoteMessageConst.MSGID)
    public String msgId;
    @JSONField(name = "msgType")
    public String msgType;
    @JSONField(name = "onlineTime")
    public long onlineTime;
    @JSONField(name = "qos")
    public String qos;
    @JSONField(name = RemoteMessageConst.SEND_TIME)
    public long sendTime;
    @JSONField(name = "statMark")
    public boolean statMark;

    public MCMessageDispatch4UTRecord(long j, String str, String str2, String str3, String str4, String str5, long j2, int i, boolean z, long j3, long j4, long j5) {
        this.appId = j;
        this.channelId = str;
        this.connectionSource = str2;
        this.msgId = str3;
        this.msgType = str4;
        this.qos = str5;
        this.sendTime = j2;
        this.expireTime = i;
        this.dispatchTime = j3;
        this.dispatchCallbackTime = j4;
        this.onlineTime = j5;
        this.statMark = z;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616645746")) {
            return (String) ipChange.ipc$dispatch("616645746", new Object[]{this});
        }
        return "MCMessageDispatch4UTRecord{appId=" + this.appId + ", channelId='" + this.channelId + "', connectionSource='" + this.connectionSource + "', msgId='" + this.msgId + "', msgType='" + this.msgType + "', qos='" + this.qos + "', sendTime=" + this.sendTime + ", expireTime=" + this.expireTime + ", statMark=" + this.statMark + ", dispatchTime=" + this.dispatchTime + ", dispatchCallbackTime=" + this.dispatchCallbackTime + ", onlineTime=" + this.onlineTime + '}';
    }
}
