package com.youku.alixplayer.opensdk.statistics.track.seek;

import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.statistics.framework.MSGTABLEID;
import com.youku.alixplayer.opensdk.statistics.track.commit.OneChangeCommit;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SeekChangeTrack {
    private OneChangeCommit mCommit;
    private long mEndTime;
    private AlixPlayerContainer mPlayerContainer;
    private double mSeekCount;
    private double mSeekDuration;
    private long mStartTime;
    private Track mTrack;

    public SeekChangeTrack(Track track) {
        this.mTrack = track;
        this.mPlayerContainer = track.getPlayerContainer();
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public double getSeekCount() {
        return this.mSeekCount;
    }

    public double getSeekDuration() {
        return this.mSeekDuration;
    }

    public void onSeekComplete() {
        if (this.mCommit != null) {
            YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
            long currentTimeMillis = System.currentTimeMillis();
            this.mEndTime = currentTimeMillis;
            OneChangeCommit oneChangeCommit = this.mCommit;
            double d = currentTimeMillis - this.mStartTime;
            oneChangeCommit.changeTotalTimeFromPlayer = d;
            oneChangeCommit.timeConsume = d;
            oneChangeCommit.isSuccess = "1";
            oneChangeCommit.currentPosition = this.mPlayerContainer.getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL);
            this.mCommit.commitOneChangeStatistics(MSGTABLEID.ONECHANGE_SEEK, "2", "seek", this.mTrack, youkuVideoInfo);
            this.mSeekCount += 1.0d;
            this.mSeekDuration += this.mCommit.timeConsume;
        }
    }

    public void onSeekTo(double d) {
        this.mCommit = new OneChangeCommit(this.mTrack);
        this.mStartTime = System.currentTimeMillis();
        this.mCommit.changeStateBefore = String.valueOf(this.mPlayerContainer.getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL));
        this.mCommit.changeStateAfter = String.valueOf(d);
    }
}
