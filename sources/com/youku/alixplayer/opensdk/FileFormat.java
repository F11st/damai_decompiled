package com.youku.alixplayer.opensdk;

import android.text.TextUtils;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum FileFormat {
    UNKNOWN("-1"),
    MP4("0"),
    HLS("1", LiveManager.StreamConfig.FORMAT_HLS),
    FLV("3", LiveManager.StreamConfig.FORMAT_FLV),
    MP5("4"),
    RTP("6", "rtp"),
    ARTP("7", "artp"),
    LHLS("8", "lhls"),
    GRTN("9", "grtn");
    
    private String protocol;
    private String statistics;

    FileFormat(String str) {
        this.statistics = str;
    }

    public static FileFormat getFileFormatByProtocol(String str) {
        FileFormat[] values;
        if ("sdp".equalsIgnoreCase(str)) {
            str = "rtp";
        } else if ("httpflv".equalsIgnoreCase(str)) {
            str = LiveManager.StreamConfig.FORMAT_FLV;
        }
        for (FileFormat fileFormat : values()) {
            if (str != null && str.equalsIgnoreCase(fileFormat.protocol)) {
                return fileFormat;
            }
        }
        return UNKNOWN;
    }

    public static FileFormat getFileFormatByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.contains(".mp4") && !str.contains(".m5v")) {
            if (!str.contains(".m3u8") && !str.contains(".ts")) {
                if (str.contains(".flv")) {
                    return FLV;
                }
                if (str.contains(".mp5")) {
                    return MP5;
                }
                if (str.contains("artp://")) {
                    return ARTP;
                }
                if (str.contains("artc://")) {
                    return GRTN;
                }
                return UNKNOWN;
            }
            return HLS;
        }
        return MP4;
    }

    public boolean equals(String str) {
        return str != null && str.equalsIgnoreCase(this.protocol);
    }

    public String getStatistics() {
        return this.statistics;
    }

    FileFormat(String str, String str2) {
        this.statistics = str;
        this.protocol = str2;
    }
}
