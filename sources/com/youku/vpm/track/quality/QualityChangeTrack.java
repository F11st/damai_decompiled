package com.youku.vpm.track.quality;

import com.youku.vpm.PlayCostTime;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TLogUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class QualityChangeTrack {
    public static final String TAG = "OneChange-quality";
    private long mBeginTime;
    private long mEndTime;
    private PlayCostTime mPlayCostTime = new PlayCostTime();
    private QualityChangeReport mQualityChangeReport;
    private final Track mTrack;

    public QualityChangeTrack(Track track) {
        this.mTrack = track;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public void onChangeVideoQualityFinish(boolean z, String str, String str2) {
        if (this.mQualityChangeReport == null) {
            TLogUtil.loge("OneChange-quality", "commit onChangeVideoQualityFinish --> mQualityChange is null.");
            return;
        }
        this.mEndTime = System.currentTimeMillis();
        this.mQualityChangeReport.currentPosition = this.mTrack.getVpmFullInfo().getDouble("progress", -1.0d);
        this.mPlayCostTime.reset();
        this.mQualityChangeReport.onChangeQualityFinish(z, str, str2);
    }

    public void onChangeVideoQualityStart() {
        if (this.mTrack.getVpmFullInfo() != null) {
            this.mQualityChangeReport = new QualityChangeReport(this.mTrack);
            this.mBeginTime = System.currentTimeMillis();
            this.mQualityChangeReport.onChangeQualityStart();
        }
    }
}
