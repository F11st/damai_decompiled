package com.youku.upsplayer.module;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SimpleVideoInfo {
    private Integer code;
    private String node;
    private String rawData;
    private Stream stream;
    private Map<String, String> trial;
    private String vid;
    private Domain videoDomain;
    private Watermark[] watermarks;

    public Integer getCode() {
        return this.code;
    }

    public String getNode() {
        return this.node;
    }

    public String getRawData() {
        return this.rawData;
    }

    public Stream getStream() {
        return this.stream;
    }

    public Map<String, String> getTrial() {
        return this.trial;
    }

    public String getVid() {
        return this.vid;
    }

    public Domain getVideoDomain() {
        return this.videoDomain;
    }

    public Watermark[] getWatermarks() {
        return this.watermarks;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setNode(String str) {
        this.node = str;
    }

    public void setRawData(String str) {
        this.rawData = str;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public SimpleVideoInfo setTrial(Map<String, String> map) {
        this.trial = map;
        return this;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setVideoDomain(Domain domain) {
        this.videoDomain = domain;
    }

    public void setWatermarks(Watermark[] watermarkArr) {
        this.watermarks = watermarkArr;
    }
}
