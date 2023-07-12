package com.youku.alixplayer.opensdk.statistics.data;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class Impairment {
    public double impairmentInterval = 0.0d;
    public float loadingPosition;
    public float playLoadingEndTime;
    public float playLoadingStartTime;

    public double getImpairmentDuration() {
        return this.playLoadingEndTime - this.playLoadingStartTime;
    }

    public void reset() {
        this.loadingPosition = 0.0f;
    }
}
