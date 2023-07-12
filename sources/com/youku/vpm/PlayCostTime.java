package com.youku.vpm;

import com.youku.vpm.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayCostTime {
    private double mLastPositionSecond = -1.0d;
    private double mPlayTime;

    public double getPlayTime() {
        return this.mPlayTime;
    }

    public void onCurrentPositionUpdate(int i, int i2) {
        double currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.mLastPositionSecond != currentTimeMillis) {
            Logger.d("PlayCostTime", "cost:" + (currentTimeMillis - this.mLastPositionSecond));
            this.mLastPositionSecond = currentTimeMillis;
            this.mPlayTime = this.mPlayTime + 1000.0d;
        }
    }

    public void reset() {
        this.mPlayTime = 0.0d;
    }
}
