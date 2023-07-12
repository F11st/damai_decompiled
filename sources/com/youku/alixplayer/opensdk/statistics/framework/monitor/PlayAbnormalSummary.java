package com.youku.alixplayer.opensdk.statistics.framework.monitor;

import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.vpm.data.ExtrasInfo;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayAbnormalSummary extends Table {
    public PlayAbnormalSummary() {
        put("eventType", (String) null);
        put("decodingType", (String) null);
        put("videoCodec", (String) null);
        put("isPlayFromCache", (String) null);
        put(ExtrasInfo.EXTRAS, (String) null);
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
        put("videoBlackBorderTotal", -1.0d);
        put("audioDecodeInputTotal", -1.0d);
        put("audioDecodeOutputTotal", -1.0d);
        put("playTimeTotal", -1.0d);
        put("playScore", -1.0d);
        put("videoStuckTotal", -1.0d);
        put("imageStuckTotal", -1.0d);
        put("noVideoAudioTotal", -1.0d);
        put("blackScreenBeforePlayTotal", -1.0d);
        put("blackScreenTotal", -1.0d);
        put("blurredScreenTotal", -1.0d);
        put("greenScreenTotal", -1.0d);
        put("noAudioTotal", -1.0d);
        put("audioStuckTotal", -1.0d);
        put("avUnSynchronizedTotal", -1.0d);
        put("subtitleAbnormalTotal", -1.0d);
        put("noAudioIntensityTotal", -1.0d);
        put("hdrVersion", -1.0d);
        put("postSharpVersion", -1.0d);
        put("sampleRate", -1.0d);
        put("frameRate", -1.0d);
        put("videoStuckTime", -1.0d);
        put("noVideoTime", -1.0d);
        put("noVideoAudioTime", -1.0d);
        put("noAudioTime", -1.0d);
        put("audioStuckTime", -1.0d);
        put("avUnSynchronizedTime", -1.0d);
        put("colorFilterVersion", -1.0d);
        put("colorSpaceCorrectVersion", -1.0d);
        put("colorFilterAlgorithm", -1.0d);
        put("audioEnhancementVersion", -1.0d);
        put("avgVideoDecodeCost", -1.0d);
    }
}
