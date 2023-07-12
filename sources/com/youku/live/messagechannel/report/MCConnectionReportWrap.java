package com.youku.live.messagechannel.report;

import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCConnectionReportWrap {
    @JSONField(name = ALBiometricsKeys.KEY_APP_ID)
    public long appId;
    @JSONField(name = RemoteMessageConst.Notification.CHANNEL_ID)
    public String channelId;
    @JSONField(name = "endTime")
    public long endTime;
    @JSONField(name = "localStartTime")
    public long localStartTime;
    @JSONField(name = LoginConstant.START_TIME)
    public long startTime;
    @JSONField(name = "takeTime")
    public long takeTime;
    @JSONField(name = "success")
    public int success = 0;
    @JSONField(name = "errorMsg")
    public String errorMsg = "";
}
