package com.youku.alixplayer.opensdk.statistics.track;

import com.youku.alixplayer.opensdk.statistics.PlayCostTime;
import com.youku.alixplayer.opensdk.statistics.Track;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OneChangeTrack {
    public static final String TAG = "OneChange";
    private PlayCostTime mPlayCostTime = new PlayCostTime();
    private QualityChange mQualityChange;
    private Track mTrack;

    public OneChangeTrack(Track track) {
        this.mTrack = track;
    }

    public void abrSwitch() {
        QualityChange qualityChange = new QualityChange(this.mTrack);
        this.mQualityChange = qualityChange;
        qualityChange.onChangeVideoQuality();
        this.mQualityChange.playTime = this.mPlayCostTime.getPlayTime();
        this.mPlayCostTime.reset();
        this.mQualityChange.onChangeVideoQualityFinish(true, true, this.mTrack);
    }

    public void onCurrentPositionUpdate(int i, int i2) {
        this.mPlayCostTime.onCurrentPositionUpdate(i, i2);
    }
}
