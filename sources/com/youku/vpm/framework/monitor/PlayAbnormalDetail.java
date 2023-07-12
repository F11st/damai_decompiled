package com.youku.vpm.framework.monitor;

import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.Table;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayAbnormalDetail extends Table {
    public PlayAbnormalDetail() {
        put("eventType", (String) null);
        put("errorCode", (String) null);
        put("videoCodec", (String) null);
        put("decodingType", (String) null);
        put(TableField.FILE_FORMAT, (String) null);
        put("isPlayFromCache", (String) null);
        put("isP2P", (String) null);
        put("videoDecodeDroppedFramesTotal", -1.0d);
        put("videoRenderDroppedFramesTotal", -1.0d);
        put("audioDecodeDroppedFramesTotal", -1.0d);
        put("audioRenderDroppedFramesTotal", -1.0d);
        put("avgVideoBitrate", -1.0d);
        put("avgAudioBitrate", -1.0d);
        put("avgVideoDecodeFrameRate", -1.0d);
        put("avgAuidoDecodeFrameRate", -1.0d);
        put("avgVideoRenderFrameRate", -1.0d);
        put("avgAudioRenderFrameRate", -1.0d);
        put("avgVideoRenderCost", -1.0d);
        put("videoDecodeInputTotal", -1.0d);
        put("videoDecodeOutputTotal", -1.0d);
        put("audioDecodeInputTotal", -1.0d);
        put("audioDecodeOutputTotal", -1.0d);
        put("currentDropFrames", -1.0d);
        put("currentUnsyncCount", -1.0d);
        put("currentIndex", -1.0d);
        put("currentPosition", -1.0d);
        put("currentPlaytime", -1.0d);
        put("sampleRate", -1.0d);
        put("frameRate", -1.0d);
        put("speed", -1.0d);
        put("audioLatency", -1.0d);
        put("videoSourcePacketNum", -1.0d);
        put("audioSourcePacketNum", -1.0d);
        put("videoSourceBytes", -1.0d);
        put("audioSourceBytes", -1.0d);
        put("videoSourcePipelineNum", -1.0d);
        put("audioSourcePipelineNum", -1.0d);
        put("audioFilters", -1.0d);
        put("videoFilters", -1.0d);
        put("avgVideoDecodeCost", -1.0d);
        put("feedType", -1.0d);
    }
}
