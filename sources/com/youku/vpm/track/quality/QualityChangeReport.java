package com.youku.vpm.track.quality;

import com.youku.vpm.framework.TableId;
import com.youku.vpm.track.Track;
import com.youku.vpm.track.commit.OneChangeCommit;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class QualityChangeReport extends OneChangeCommit {
    public QualityChangeReport(Track track) {
        super(track);
    }

    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public void onChangeQualityFinish(boolean z, String str, String str2) {
        this.isSuccess = z ? "1" : "0";
        this.timeConsume = currentTimeMillis() - this.changeStartTime;
        this.isAuto = "0";
        this.changeStateBefore = str;
        this.changeStateAfter = str2;
        commit(TableId.ONECHANGE_QUALITY, "0");
    }

    public void onChangeQualityStart() {
        this.changeStartTime = currentTimeMillis();
    }
}
