package com.youku.vpm.framework.monitor;

import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.Table;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OneChange extends Table {
    public OneChange() {
        put("videoCode", (String) null);
        put(TableField.FILE_FORMAT, (String) null);
        put("decodingType", (String) null);
        put("curDownloadChunkIndex", (String) null);
        put("curPlayingChunkIndex", (String) null);
        put("gearBeforeSwitch", (String) null);
        put("gearAfterSwitch", (String) null);
        put("curChunkAvgSpeed", (String) null);
        put("curChunkVariance", (String) null);
        put("currentBufferInMs", (String) null);
        put("maxBufferInMs", (String) null);
        put("minBufferInMs", (String) null);
        put("safeHoldBufferInMs", (String) null);
        put("bweValue", (String) null);
        put("timeAfterPlay", (String) null);
        put("timeAfterSeek", (String) null);
        put("errorCode", (String) null);
        put("curChunkSpeed", (String) null);
        put("speedShakeLevel", (String) null);
        put("predictChunkBitrate", (String) null);
        put("predictChunkSpeed", (String) null);
        put("abrScheme", (String) null);
        put("seekInBuffer", -1.0d);
        put("indexBeforeSeek", -1.0d);
        put("indexAfterSeek", -1.0d);
        put("responseTime", -1.0d);
        put("seekInFFMpegTime", -1.0d);
        put("firstPacketTime", -1.0d);
        put("waitBufferTime", -1.0d);
        put("abrDownLoadM3u8Time", -1.0d);
        put("abrGearSwitchUpFactor", -1.0d);
        put("abrGearSwitchDwonFactor", -1.0d);
        put("abrGearImpairmentCount", -1.0d);
        put("abrSwitchID", -1.0d);
        put("abrSwitchMethod", -1.0d);
        put("abrDurationFromStart", -1.0d);
        put("abrTimeoutIndex", -1.0d);
        put("abrTimeoutCount", -1.0d);
        put("abrTimeoutDurationFromStart", -1.0d);
        put("abrTimeoutCurrentSetting", -1.0d);
        put("abrChangeGearNumber", -1.0d);
        put("abrChangeGearOnSeekNumber", -1.0d);
        put("seekTotalTimeFromKernel", -1.0d);
    }
}
