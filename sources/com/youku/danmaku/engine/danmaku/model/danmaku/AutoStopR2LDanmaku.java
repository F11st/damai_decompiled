package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AutoStopR2LDanmaku extends R2LDanmaku {
    public static final int Danmaku_Pause_PositionCenter = -101;
    public static final int Danmaku_Pause_PositionLeft = -100;
    public static final int Danmaku_Pause_PositionRight = -102;
    private long mDurationTime;
    private boolean mIsFirst;
    private boolean mIsStopped;
    private boolean mNeedStop;
    private long mStopDurationTime;
    private int mStopPosition;

    public AutoStopR2LDanmaku(Duration duration) {
        this(duration, null);
    }

    private void handlerStop(IDisplayer iDisplayer, long j) {
        float width;
        if (this.mIsStopped) {
            return;
        }
        if (this.mIsFirst && j - this.time > 0) {
            int i = this.mStopPosition;
            if (i == -100) {
                width = 0.0f;
            } else if (i == -102) {
                width = iDisplayer.getWidth() - this.paintWidth;
            } else {
                width = i == -101 ? iDisplayer.getWidth() / 2.0f : i;
            }
            if (this.x < width) {
                if (Log.isDebug()) {
                    Log.d("special_type", "x=" + this.x + ", stopPosition=" + width + ", mStepX=" + this.mStepX + ", width=" + this.paintWidth + ", time=" + this.time);
                }
                this.mIsFirst = false;
                this.mNeedStop = true;
                this.x = width;
                setTimeAndUpdateOrder(((float) j) - ((iDisplayer.getWidth() - width) / this.mStepX));
                this.mPreTime = j;
                return;
            }
        }
        if (!this.mNeedStop || this.mIsStopped) {
            return;
        }
        long j2 = j - this.mPreTime;
        long j3 = this.mDurationTime + j2;
        this.mDurationTime = j3;
        if (j3 >= this.mStopDurationTime) {
            this.mIsStopped = true;
            return;
        }
        setTimeAndUpdateOrder(j2 + this.time);
        this.mPreTime = j;
    }

    public long getStopDurationTime() {
        return this.mStopDurationTime;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void layout(IDisplayer iDisplayer, float f, float f2) {
        DanmakuTimer danmakuTimer = this.mTimer;
        if (danmakuTimer != null) {
            long j = danmakuTimer.currMillisecond;
            if (this.mStopDurationTime > 0 && this.mStopPosition != 0) {
                handlerStop(iDisplayer, j);
            }
            if (handlePosition(iDisplayer, j, f2)) {
                return;
            }
        }
        setVisibility(false);
    }

    public void resetState() {
        this.mIsStopped = false;
        this.mNeedStop = false;
        this.mDurationTime = 0L;
        this.mIsFirst = true;
    }

    public void setDurationAnPosition(long j, int i) {
        this.mStopDurationTime = j;
        this.mStopPosition = i;
    }

    public AutoStopR2LDanmaku(Duration duration, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        super(duration, iDanmakuSettingPlugin);
        this.mIsStopped = false;
        this.mNeedStop = false;
        this.mIsFirst = true;
        this.mStopDurationTime = 2000L;
        this.mStopPosition = -100;
    }
}
