package com.youku.alixplayer.opensdk.statistics.track.business;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SeiDelay {
    public long ntpOffset;
    public long mDelay = 0;
    public String seiTimestamp = "0";
    public String localTimestamp = "0";

    public void reset() {
        this.mDelay = 0L;
        this.seiTimestamp = "0";
        this.ntpOffset = 0L;
        this.localTimestamp = "0";
    }
}
