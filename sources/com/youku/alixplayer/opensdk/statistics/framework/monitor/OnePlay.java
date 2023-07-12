package com.youku.alixplayer.opensdk.statistics.framework.monitor;

import com.youku.alixplayer.opensdk.statistics.framework.table.Table;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OnePlay extends Table {
    public OnePlay() {
        put("shiftCDN", (String) null);
        put("HLSInfo", (String) null);
        put("isPlayFromCache", (String) null);
        put("videoCode", (String) null);
        put("isCDN", (String) null);
        put("decodingType", (String) null);
        put(TableField.FILE_FORMAT, (String) null);
        put("CDNIP", (String) null);
        put("URL", (String) null);
        put("OrangeSession", (String) null);
        put("cdnUrlReqDuration", -1.0d);
        put("D_CDN_ONPrepare", -1.0d);
        put("D_CDN_ONPrepare_open", -1.0d);
        put("D_CDN_Find_StreamInfo", -1.0d);
        put("D_CDN_READ_First_Frame", -1.0d);
        put("D_Decode_First_Frame", -1.0d);
        put("D_CND_OPEN_AVIO", -1.0d);
        put("D_CND_OPEN_Header", -1.0d);
        put("D_PIPE_Create", -1.0d);
        put("D_CDN_M3U8_Download", -1.0d);
        put("D_CDN_M3U8_Parser", -1.0d);
        put("D_Sourcer_Read_First_Frame", -1.0d);
        put("D_SOURCE_Create", -1.0d);
        put("D_Wait_Surface_Time", -1.0d);
        put("D_Signal_Time", -1.0d);
        put("D_Media_Time", -1.0d);
        put("videoFrameRate", -1.0d);
        put("avgVideoBitrate", -1.0d);
        put("avgKeyFrameSize", -1.0d);
        put("unUsedBufferSize", -1.0d);
        put("totalDownloadBufferSize", -1.0d);
        put("usedExternalBufferSize", -1.0d);
        put("initTargetBuffer", -1.0d);
        put("maxTargetBuffer", -1.0d);
        put("curTargetBuffer", -1.0d);
        put("isEnableTargetBufferAdaptive", -1.0d);
        put("bufferAdaptiveChangeCnt", -1.0d);
        put("userConsumeDuration", -1.0d);
        put("hdrVersion", -1.0d);
        put("postSharpVersion", -1.0d);
        put("cacheAdIntercept", -1.0d);
        put("preloadDataLength", -1.0d);
    }
}
