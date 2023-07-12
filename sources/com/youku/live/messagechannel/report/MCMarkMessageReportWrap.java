package com.youku.live.messagechannel.report;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.common.Constants;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMarkMessageReportWrap {
    @JSONField(name = ALBiometricsKeys.KEY_APP_ID)
    public long appId;
    @JSONField(name = RemoteMessageConst.Notification.CHANNEL_ID)
    public String channelId;
    @JSONField(name = "eventSecond")
    public int eventSecond;
    @JSONField(name = "eventTime")
    public long eventTime;
    @JSONField(name = "markMessages")
    public List<MCMarkMessageReportData> markMessages;
    @JSONField(name = "onBackground")
    public int onBackground;
    @JSONField(name = "onFrontFirstReport")
    public int onFrontFirstReport;
    @JSONField(name = "onlineTime")
    public long onlineTime;
    @JSONField(name = "probeMessage")
    public MCMarkMessageReportData probeMessage;
    @JSONField(name = Constants.Name.INTERVAL)
    public int reportInterval;
    @JSONField(name = TypedValues.Cycle.S_WAVE_PERIOD)
    public int reportPeriod;
    @JSONField(name = "reportSysProbeMode")
    public int reportSysProbeMode;
}
