package com.youku.alixplayer.opensdk.statistics.framework.monitor;

import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OneEvent extends Table {
    public OneEvent() {
        put("beforeIP", (String) null);
        put("afterIP", (String) null);
        put("URL", (String) null);
        put("bufferState", (String) null);
        put(TableField.FILE_FORMAT, (String) null);
        put("decodingType", (String) null);
        put("videoCode", (String) null);
        put("errorCode", (String) null);
        put("URL", (String) null);
        put("tcSwitchType", (String) null);
        put("tcAverageBufferWater", (String) null);
        put("tcAverageSpeed", (String) null);
        put("tcReferenceBufferWater", (String) null);
        put("tcReferenceSpeed", (String) null);
        put("tcSwitchTime", (String) null);
        put("currentNetSpeed", -1.0d);
        put("sliceID", -1.0d);
        put("slicePos", -1.0d);
        put("targetSpeed", -1.0d);
        put("switchTime", -1.0d);
        put("isSuccess", -1.0d);
        put("beforeTargetBuffer", -1.0d);
        put("afterTargetBuffer", -1.0d);
        put("currentBuffer", -1.0d);
        put("currentBitrate", -1.0d);
        put("playDuration", -1.0d);
        put("durationAfterIpSwitch", -1.0d);
        put("beforeSwitchSpeed", -1.0d);
        put("afterSwitchSpeed", -1.0d);
    }
}
