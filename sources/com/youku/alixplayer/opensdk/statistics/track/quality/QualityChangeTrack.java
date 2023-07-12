package com.youku.alixplayer.opensdk.statistics.track.quality;

import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.statistics.PlayCostTime;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.track.QualityChange;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.TLogUtil;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class QualityChangeTrack {
    public static final String TAG = "OneChange-quality";
    private long mEndTime;
    private PlayCostTime mPlayCostTime = new PlayCostTime();
    private QualityChange mQualityChange;
    private Track mTrack;

    public QualityChangeTrack(Track track) {
        this.mTrack = track;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public void onChangeVideoQualityFinish(boolean z, boolean z2) {
        if (this.mTrack.getYoukuVideoInfo() == null) {
            TLogUtil.loge("OneChange-quality", "commit onChangeVideoQualityFinish --> sdkvideoInfo is null.");
        } else if (this.mQualityChange == null) {
            TLogUtil.loge("OneChange-quality", "commit onChangeVideoQualityFinish --> mQualityChange is null.");
        } else {
            this.mEndTime = System.currentTimeMillis();
            this.mQualityChange.playTime = this.mPlayCostTime.getPlayTime();
            this.mQualityChange.currentPosition = this.mTrack.getPlayerContainer().getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL);
            this.mPlayCostTime.reset();
            this.mQualityChange.onChangeVideoQualityFinish(z, z2, this.mTrack);
        }
    }

    public void onChangeVideoQualityStart(int i, Quality quality, Quality quality2) {
        QualityChange qualityChange = new QualityChange(this.mTrack);
        this.mQualityChange = qualityChange;
        qualityChange.onChangeVideoQuality(i, quality, quality2);
    }

    public void onCurrentPositionUpdate(int i, int i2) {
        this.mPlayCostTime.onCurrentPositionUpdate(i, i2);
    }
}
