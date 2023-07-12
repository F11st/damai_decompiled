package com.youku.live.livesdk.preloader;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PlayInfoModel implements Serializable {
    public int bizType;
    public String errCode;
    public String ext;
    public String format;
    public Boolean landScape;
    public PlayInfoBean playInfo;
    public RtcInfoModel rtcInfo;
    public int screenId;
    public String status;
    public String templateId;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class PlayInfoBean implements Serializable {
        public String format;
        public int hv;
        public String playBitrate;
        public String playToken;
        public String streamId;
        public String streamSize;
        public int tcpPort;
        public int udpPort;
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class RtcInfoModel implements Serializable {
        public String apd;
        public String cnn;
        public List<String> gslb;
        public String non;
        public int sessionId;
        public String tk;
        public long ts;
        public String u;
    }
}
