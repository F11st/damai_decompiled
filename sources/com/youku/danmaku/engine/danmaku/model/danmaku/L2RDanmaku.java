package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class L2RDanmaku extends R2LDanmaku {
    public L2RDanmaku(Duration duration) {
        super(duration);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku
    protected float getAccurateLeft(IDisplayer iDisplayer, long j) {
        long j2 = j - this.time;
        if (j2 >= this.duration.value) {
            return iDisplayer.getWidth();
        }
        return (this.mStepX * ((float) j2)) - this.paintWidth;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getBottom() {
        return this.y + this.paintHeight;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getLeft() {
        return this.x;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float[] getRectAtTime(IDisplayer iDisplayer, long j) {
        if (isMeasured()) {
            float accurateLeft = getAccurateLeft(iDisplayer, j);
            if (this.RECT == null) {
                this.RECT = new float[4];
            }
            float[] fArr = this.RECT;
            fArr[0] = accurateLeft;
            float f = this.y;
            fArr[1] = f;
            fArr[2] = accurateLeft + this.paintWidth;
            fArr[3] = f + this.paintHeight;
            return fArr;
        }
        return null;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getRight() {
        return this.x + this.paintWidth;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getTop() {
        return this.y;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public int getType() {
        return 6;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void layout(IDisplayer iDisplayer, float f, float f2) {
        DanmakuTimer danmakuTimer = this.mTimer;
        if (danmakuTimer != null) {
            long j = danmakuTimer.currMillisecond;
            long j2 = j - this.time;
            if (j2 >= 0 && j2 < this.duration.value) {
                this.x = getAccurateLeft(iDisplayer, j);
                if (isShown()) {
                    return;
                }
                this.y = f2;
                setVisibility(true);
                return;
            }
        }
        setVisibility(false);
    }
}
