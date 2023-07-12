package com.youku.playerservice.axp.axpinterface;

import android.text.TextUtils;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class PlayDefinition {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum NetworkType {
        HTTP,
        MTOP
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum PlayEnvironment {
        ONLINE(0),
        PRE(1),
        DAILY(2);
        
        int type;

        PlayEnvironment(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum PlayFormat {
        UNKNOWN("-1"),
        MP4("0"),
        HLS("1", LiveManager.StreamConfig.FORMAT_HLS),
        DASH("2"),
        FLV("3", LiveManager.StreamConfig.FORMAT_FLV),
        MP5("4"),
        M5V("5"),
        RTP("6", "rtp"),
        ARTP("7", "artp"),
        LHLS("8", "lhls"),
        GRTN("9", "grtn"),
        RTMP("11", "raphael");
        
        private String protocol;
        private String statistics;

        PlayFormat(String str) {
            this.statistics = str;
        }

        PlayFormat(String str, String str2) {
            this.statistics = str;
            this.protocol = str2;
        }

        public static PlayFormat getPlayFormatByProtocol(String str) {
            PlayFormat[] values;
            if ("sdp".equalsIgnoreCase(str)) {
                str = "rtp";
            } else if ("httpflv".equalsIgnoreCase(str)) {
                str = LiveManager.StreamConfig.FORMAT_FLV;
            }
            for (PlayFormat playFormat : values()) {
                if (str != null && str.equalsIgnoreCase(playFormat.protocol)) {
                    return playFormat;
                }
            }
            return UNKNOWN;
        }

        public static PlayFormat getPlayFormatByStatistics(String str) {
            PlayFormat[] values;
            for (PlayFormat playFormat : values()) {
                if (str != null && str.equalsIgnoreCase(playFormat.statistics)) {
                    return playFormat;
                }
            }
            return UNKNOWN;
        }

        public static PlayFormat getPlayFormatByUrl(String str) {
            return TextUtils.isEmpty(str) ? UNKNOWN : (str.contains(".mp4") || str.contains(".m5v")) ? MP4 : (str.contains(".m3u8") || str.contains(".ts")) ? HLS : str.contains(".flv") ? FLV : str.contains(".mp5") ? MP5 : str.contains("artp://") ? ARTP : str.contains("artc://") ? GRTN : UNKNOWN;
        }

        public boolean equals(String str) {
            return str != null && str.equalsIgnoreCase(this.protocol);
        }

        public String getStatistics() {
            return this.statistics;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum PlayInfoType {
        UNKNOWN(0),
        UPS(1),
        LIVE(2),
        URL(3),
        LOCAL(4);
        
        int type;

        PlayInfoType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum PlayScene {
        UNKNOWN(0),
        SHORT_VIDEO(1),
        LONG_VIDEO(2),
        LIVE_LAIFENG(3),
        LIVE_YOUKU(4);
        
        int type;

        PlayScene(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum PlayType {
        VOD(0),
        LIVE(1),
        URL(2);
        
        int type;

        PlayType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }
}
