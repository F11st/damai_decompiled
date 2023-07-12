package com.youku.live.messagechannel.connection;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MassSubscribeResult {
    @JSONField(name = ALBiometricsKeys.KEY_APP_ID)
    public long appId;
    @JSONField(name = RemoteMessageConst.Notification.CHANNEL_ID)
    public String channelId;
    @JSONField(name = "requestId")
    public String subscribeRequestId;
    @JSONField(name = "success")
    public boolean success;
    @JSONField(name = "topic")
    public String topic;
}
