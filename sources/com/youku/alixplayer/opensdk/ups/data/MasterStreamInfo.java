package com.youku.alixplayer.opensdk.ups.data;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class MasterStreamInfo {
    public long bandWidth;
    public int fps;
    public int resolution;
    public long size;
    public String streamType;

    public MasterStreamInfo(String str, long j, long j2, int i, int i2) {
        this.streamType = str;
        this.bandWidth = j;
        this.size = j2;
        this.resolution = i;
        this.fps = i2;
    }
}
