package com.youku.vpm.track.seek;

import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.track.Track;
import com.youku.vpm.track.commit.OneChangeCommit;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SeekChangeTrack {
    private OneChangeCommit mCommit;
    private long mEndTime;
    private double mSeekCount;
    private double mSeekDuration;
    private SeekNewTrack mSeekNewTrack;
    private long mStartTime;
    private Track mTrack;

    public SeekChangeTrack(Track track) {
        this.mTrack = track;
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
            IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
            long currentTimeMillis = System.currentTimeMillis();
            this.mEndTime = currentTimeMillis;
            OneChangeCommit oneChangeCommit = this.mCommit;
            double d = currentTimeMillis - this.mStartTime;
            oneChangeCommit.changeTotalTimeFromPlayer = d;
            oneChangeCommit.timeConsume = d;
            oneChangeCommit.isSuccess = "1";
            oneChangeCommit.currentPosition = vpmFullInfo.getDouble("progress", -1.0d);
            this.mCommit.commitOneChangeStatistics(TableId.ONECHANGE_SEEK, "2", "seek", this.mTrack, vpmFullInfo);
            this.mSeekCount += 1.0d;
            this.mSeekDuration += this.mCommit.timeConsume;
        }
        SeekNewTrack seekNewTrack = this.mSeekNewTrack;
        if (seekNewTrack != null) {
            seekNewTrack.onSeekComplete();
        }
    }

    public void onSeekTo(int i, int i2) {
        this.mCommit = new OneChangeCommit(this.mTrack);
        this.mStartTime = System.currentTimeMillis();
        this.mCommit.changeStateBefore = String.valueOf(i);
        this.mCommit.changeStateAfter = String.valueOf(i2);
        SeekNewTrack seekNewTrack = new SeekNewTrack(this.mTrack);
        this.mSeekNewTrack = seekNewTrack;
        seekNewTrack.seekFrom = String.valueOf(i);
        this.mSeekNewTrack.seekTo = String.valueOf(i2);
    }
}
