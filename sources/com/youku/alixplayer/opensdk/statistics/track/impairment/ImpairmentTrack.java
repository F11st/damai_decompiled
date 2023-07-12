package com.youku.alixplayer.opensdk.statistics.track.impairment;

import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.statistics.Track;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ImpairmentTrack {
    public static final String TAG = "Impairment";
    private boolean isloading;
    private ImpairmentCommit mCommit;
    protected int mDropCount;
    public double mImpairmentDuration = 0.0d;
    public int mImpairmentOrder = 0;
    private AlixPlayerContainer mPlayer;
    private StartLoadingCommit mStartLoadingCommit;
    private Track mTrack;

    public ImpairmentTrack(Track track) {
        this.mPlayer = track.getPlayerContainer();
        this.mTrack = track;
    }

    public double getDropCount() {
        return this.mDropCount;
    }

    public double getImpairmentDuration() {
        return this.mImpairmentDuration;
    }

    public double getImpairmentFrequency() {
        return this.mImpairmentOrder;
    }

    public void onDropVideoFrames(int i) {
        this.mDropCount++;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPlayLoadingEnd(java.lang.String r12, int r13, int r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.opensdk.statistics.track.impairment.ImpairmentTrack.onPlayLoadingEnd(java.lang.String, int, int, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPlayLoadingStart(java.lang.String r10, int r11, int r12, java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.opensdk.statistics.track.impairment.ImpairmentTrack.onPlayLoadingStart(java.lang.String, int, int, java.lang.Object):void");
    }
}
