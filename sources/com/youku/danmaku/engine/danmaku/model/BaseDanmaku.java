package com.youku.danmaku.engine.danmaku.model;

import android.os.Bundle;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;
import java.io.Serializable;
import java.util.Observable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseDanmaku extends Observable implements Serializable {
    public static final int CLICK_TEXT_ENABLE = 1;
    public static final String DANMAKU_BR_CHAR = "/n";
    public static final int FLAG_REQUEST_INVALIDATE = 2;
    public static final int FLAG_REQUEST_REMEASURE = 1;
    private static final int INVISIBLE = 0;
    public static final int PRIORITY_LOCAL = 1;
    public static final int PRIORITY_SPECIAL = 2;
    public static final int PRIORITY_SYSTEM = 3;
    public static final int TYPE_FIX_BOTTOM = 4;
    public static final int TYPE_FIX_TOP = 5;
    public static final int TYPE_SCROLL_LR = 6;
    public static final int TYPE_SCROLL_RL = 1;
    public static final int TYPE_SPECIAL = 7;
    private static final int VISIBLE = 1;
    public boolean boldText;
    public IDrawingCache<?> cache;
    public long dmfid;
    public Duration duration;
    public long id;
    public int index;
    public boolean isBombed;
    public boolean isFilter;
    public boolean isGuest;
    public boolean isLive;
    public boolean isSelected;
    public String[] lines;
    public boolean mAssignRow;
    public int[] mBgColorArr;
    public BaseExtraStyle mExtraStyle;
    private Bundle mExtras;
    protected DanmakuTimer mTimer;
    public int minute;
    public Object obj;
    public int offset;
    public float rotationY;
    public float rotationZ;
    public int second;
    public Object tag;
    public CharSequence text;
    public int textColor;
    public int[] textColorArr;
    public int textShadowColor;
    public long time;
    public String userHash;
    public long videoTime;
    public int visibility;
    public int mSubType = 0;
    public boolean isClickVote = false;
    public long mVoteCount = 0;
    public boolean mIsLocal = false;
    public int underlineColor = 0;
    public float textSize = -1.0f;
    public int borderColor = 0;
    public boolean ykHasBorder = false;
    public boolean isGuideDanmaku = false;
    public int padding = 0;
    public float paintWidth = -1.0f;
    public float mTxtWidth = 0.0f;
    public float mConnectWid = 0.0f;
    public float paintHeight = -1.0f;
    public int alpha = AlphaValue.MAX;
    private int mDanmakuLine = 0;
    public byte priority = 0;
    private int visibleResetFlag = 0;
    public int measureResetFlag = 0;
    public GlobalFlagValues flags = null;
    public int requestFlags = 0;
    public int firstShownFlag = -1;
    public int markSource = -1;
    public int mFilterParam = 0;
    public int filterResetFlag = -1;
    public boolean mUseWhiteColor = false;
    public int mClickStatus = 1;
    public String ouid = null;
    public String userId = "0";
    public int mBgcolor = 16342128;
    public long mPropId = -1;

    public int draw(IDisplayer iDisplayer) {
        return iDisplayer.draw(this);
    }

    public abstract float getBottom();

    public int getDanmakuLine() {
        return this.mDanmakuLine;
    }

    public long getDuration() {
        Duration duration = this.duration;
        if (duration == null) {
            return 0L;
        }
        return duration.value;
    }

    public Bundle getExtras() {
        if (this.mExtras != null) {
            return new Bundle(this.mExtras);
        }
        return null;
    }

    public abstract float getLeft();

    public float getPositionY() {
        return 0.0f;
    }

    public abstract float[] getRectAtTime(IDisplayer iDisplayer, long j);

    public abstract float getRight();

    public DanmakuTimer getTimer() {
        return this.mTimer;
    }

    public abstract float getTop();

    public abstract int getType();

    public boolean hasDrawingCache() {
        try {
            IDrawingCache<?> iDrawingCache = this.cache;
            if (iDrawingCache != null) {
                return iDrawingCache.get() != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean hasPassedFilter() {
        if (this.filterResetFlag != this.flags.FILTER_RESET_FLAG) {
            this.mFilterParam = 0;
            return false;
        }
        return true;
    }

    public boolean isFiltered() {
        return this.filterResetFlag == this.flags.FILTER_RESET_FLAG && this.mFilterParam != 0;
    }

    public boolean isLate() {
        DanmakuTimer danmakuTimer = this.mTimer;
        return danmakuTimer == null || danmakuTimer.currMillisecond < this.time;
    }

    public boolean isMeasured() {
        return this.paintWidth > -1.0f && this.paintHeight > -1.0f && this.measureResetFlag == this.flags.MEASURE_RESET_FLAG;
    }

    public boolean isOutside() {
        DanmakuTimer danmakuTimer = this.mTimer;
        return danmakuTimer == null || isOutside(danmakuTimer.currMillisecond);
    }

    public boolean isShown() {
        return this.visibility == 1 && this.visibleResetFlag == this.flags.VISIBLE_RESET_FLAG;
    }

    public boolean isTimeOut() {
        DanmakuTimer danmakuTimer = this.mTimer;
        return danmakuTimer == null || isTimeOut(danmakuTimer.currMillisecond);
    }

    public abstract void layout(IDisplayer iDisplayer, float f, float f2);

    public void measure(IDisplayer iDisplayer, boolean z) {
        iDisplayer.measure(this, z);
        this.measureResetFlag = this.flags.MEASURE_RESET_FLAG;
    }

    public void putExtras(Bundle bundle) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putAll(bundle);
    }

    public void reset() {
    }

    public void setDanmakuLine(int i) {
        this.mDanmakuLine = i;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setPositionX(float f) {
    }

    public void setPositionY(float f) {
    }

    public void setTimeAndUpdateOrder(long j) {
        if (this.time != j) {
            setChanged();
        }
        this.time = j;
        if (hasChanged()) {
            notifyObservers();
        }
    }

    public void setTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.visibleResetFlag = this.flags.VISIBLE_RESET_FLAG;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    private boolean isOutside(long j) {
        long j2 = j - this.time;
        Duration duration = this.duration;
        return j2 < 0 || j2 >= (duration != null ? duration.value : 0L);
    }

    private boolean isTimeOut(long j) {
        Duration duration = this.duration;
        return j - this.time >= (duration != null ? duration.value : 0L);
    }
}
