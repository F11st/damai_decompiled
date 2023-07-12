package com.youku.alixplayer.opensdk.statistics.track;

import com.taobao.weex.common.Constants;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.track.commit.OneChangeCommit;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.TLogUtil;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class QualityChange extends OneChangeCommit {
    private Quality mFromQuality;
    private Quality mToQuality;

    public QualityChange(Track track) {
        super(track);
    }

    private long currentTimeMillis() {
        return System.nanoTime() / 1000000;
    }

    public void onChangeVideoQuality() {
        Quality quality = Quality.UNKNOWN;
        onChangeVideoQuality(-1, quality, quality);
    }

    public void onChangeVideoQualityFinish(boolean z, boolean z2, Track track) {
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        this.isSuccess = z2 ? "1" : "0";
        this.timeConsume = currentTimeMillis() - this.changeStartTime;
        this.isAuto = z ? "1" : "0";
        this.changeStateBefore = this.mFromQuality.getDescription();
        this.changeStateAfter = this.mToQuality.getDescription();
        TLogUtil.loge("OneChange", "onChangeVideoQualityFinish:isAuto:" + z + "  mFromQuality:" + this.mFromQuality + " mToQuality" + this.mToQuality + " changeStateBefore:" + this.changeStateBefore + " changeStateAfter:" + this.changeStateAfter);
        super.commitOneChangeStatistics(MSGTABLEID.ONECHANGE_QUALITY, "0", Constants.Name.QUALITY, track, youkuVideoInfo);
    }

    public void onChangeVideoQuality(int i, Quality quality, Quality quality2) {
        this.mFromQuality = quality;
        this.mToQuality = quality2;
        setQualityMode(i);
        this.changeStartTime = currentTimeMillis();
        TLogUtil.loge("OneChange", "onChangeVideoQuality:mode:" + i + " fromQuality:" + quality + " toQuality:" + quality2);
    }
}
