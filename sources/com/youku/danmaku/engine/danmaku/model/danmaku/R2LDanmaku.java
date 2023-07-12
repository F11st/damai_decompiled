package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class R2LDanmaku extends BaseDanmaku {
    protected static final long CORDON_RENDERING_TIME = 40;
    protected static final long MAX_RENDERING_TIME = 100;
    protected float[] RECT;
    protected IDanmakuSettingPlugin mDanmakuSettingPlugin;
    protected int mDistance;
    protected long mPreTime;
    protected float mStepX;
    private float positionY;
    protected float x;
    protected float y;

    public R2LDanmaku(Duration duration) {
        this(duration, null);
    }

    protected float getAccurateLeft(IDisplayer iDisplayer, long j) {
        long j2 = j - this.time;
        if (j2 >= this.duration.value) {
            return -this.paintWidth;
        }
        return iDisplayer.getWidth() - (((float) j2) * this.mStepX);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getBottom() {
        float f = this.y + this.paintHeight;
        BaseExtraStyle baseExtraStyle = this.mExtraStyle;
        return baseExtraStyle != null ? f + baseExtraStyle.getTopPadding() : f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getLeft() {
        return this.x;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getPositionY() {
        return this.positionY;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
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

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getRight() {
        return this.x + this.paintWidth;
    }

    public float getStepX() {
        return this.mStepX;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getTop() {
        return this.y;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public int getType() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean handlePosition(IDisplayer iDisplayer, long j, float f) {
        long j2 = j - this.time;
        if (j2 < 0 || j2 >= this.duration.value) {
            return false;
        }
        this.x = getAccurateLeft(iDisplayer, j);
        if (!isShown()) {
            this.y = f;
            setVisibility(true);
        }
        return true;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void layout(IDisplayer iDisplayer, float f, float f2) {
        DanmakuTimer danmakuTimer = this.mTimer;
        if (danmakuTimer == null || !handlePosition(iDisplayer, danmakuTimer.currMillisecond, f2)) {
            setVisibility(false);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void measure(IDisplayer iDisplayer, boolean z) {
        super.measure(iDisplayer, z);
        this.mDistance = (int) (iDisplayer.getWidth() + this.paintWidth);
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null && (iDanmakuSettingPlugin.isNewTypesetting() || this.mDanmakuSettingPlugin.isNewCompose())) {
            float f = this.mStepX;
            if (f <= 0.0f) {
                float uniformSpeed = this.mDanmakuSettingPlugin.getUniformSpeed();
                this.mStepX = uniformSpeed;
                this.duration.value = this.mDistance / uniformSpeed;
                return;
            }
            this.duration.value = this.mDistance / f;
            return;
        }
        this.mStepX = this.mDistance / ((float) this.duration.value);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void reset() {
        this.x = 0.0f;
        this.y = -1.0f;
        this.mStepX = 0.275f;
        Duration duration = this.duration;
        if (duration != null) {
            duration.value = DanmakuFactory.DEFAULT_DANMAKU_DURATION;
        }
        setVisibility(false);
    }

    public void resetTop() {
        this.y = -1.0f;
    }

    public void setDistanceOffset(float f) {
        this.mDistance = (int) (this.mDistance + f);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void setPositionX(float f) {
        this.x = f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void setPositionY(float f) {
        this.positionY = f;
        this.y = f;
    }

    public void setSpeedAndChangeDuration(float f) {
        DanmakuTimer danmakuTimer = this.mTimer;
        if (danmakuTimer != null) {
            float f2 = this.mStepX;
            Duration duration = this.duration;
            long j = duration.value;
            long j2 = this.time;
            this.mStepX = f;
            duration.value = this.mDistance / f;
            long j3 = danmakuTimer.currMillisecond;
            this.time = ((float) j3) - ((((float) (j3 - j2)) * f2) / f);
            if (Log.isDebug()) {
                Log.d("changeSpeed", "old step=" + f2 + ", new step=" + f + ", oldDuration=" + j + ", newDuration=" + this.duration.value + ", left=" + this.x + ", currMS=" + j3 + ", old time=" + j2 + ", new time=" + this.time);
            }
        }
    }

    public void setStepAndCalculateDuration(float f) {
        this.mStepX = f;
        this.duration.value = this.mDistance / f;
    }

    public void setTopPosition(float f) {
        this.y = f;
    }

    public R2LDanmaku(Duration duration, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.x = 0.0f;
        this.y = -1.0f;
        this.positionY = -1.0f;
        this.RECT = null;
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null && (iDanmakuSettingPlugin.isNewTypesetting() || this.mDanmakuSettingPlugin.isNewCompose())) {
            Duration duration2 = new Duration(duration.value);
            this.duration = duration2;
            duration2.setFactor(duration.factor, duration.value);
            return;
        }
        this.duration = duration;
    }
}
