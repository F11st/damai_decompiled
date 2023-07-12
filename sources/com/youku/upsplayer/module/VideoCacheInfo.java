package com.youku.upsplayer.module;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VideoCacheInfo {
    public String cacheKey;
    public String errorCode;
    public String errorMsg;
    public String langeCode;
    public String qsid;
    public String r1;
    public int requestQuality;
    private Map<String, String> upsStatsMap;
    public VideoInfo videoInfo;
    public String videoInfoStr;

    public Map<String, String> getUpsStatsMap() {
        return this.upsStatsMap;
    }

    public void setUpsStatsMap(Map<String, String> map) {
        this.upsStatsMap = map;
    }
}
