package com.youku.danmaku.engine.danmaku.model.android;

import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.AutoStopR2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.FBDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.FTDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.GuideR2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.L2RDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.SpecialDanmaku;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import com.youku.danmaku.plugin.IDanmakuTypePlugin;
import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuFactory {
    public static final long ANIMATION_DANMAKU_DURATION = 1000;
    public static final float BILI_PLAYER_HEIGHT = 438.0f;
    public static final float BILI_PLAYER_WIDTH = 682.0f;
    public static final long COMMON_DANMAKU_DURATION = 3800;
    public static final int DANMAKU_MEDIUM_TEXTSIZE = 25;
    public static final long DEFAULT_DANMAKU_DURATION = 8000;
    public static final long DEFAULT_DANMAKU_DURATION_V = 5000;
    public static final long MAX_DANMAKU_DURATION_HIGH_DENSITY = 16000;
    public static final long MAX_DANMAKU_DURATION_HIGH_DENSITY_V = 10000;
    public static final long MIN_DANMAKU_DURATION = 4000;
    public static final long MIN_DANMAKU_DURATION_V = 2500;
    public static final float OLD_BILI_PLAYER_HEIGHT = 385.0f;
    public static final float OLD_BILI_PLAYER_WIDTH = 539.0f;
    private Duration mDurationVerticalAnimDanmaku;
    private Duration mMaxDurationFixDanmaku;
    public Duration mMaxDurationScrollDanmaku;
    private Duration mMaxDurationSpecialDanmaku;
    private DanmakuContext sLastConfig;
    private IDisplayer sLastDisp;
    private int mCurrentDispWidth = 0;
    private int mCurrentDispHeight = 0;
    private float mCurrentDispSizeFactor = 1.0f;
    public long mRealDanmakuDuration = DEFAULT_DANMAKU_DURATION;
    public long mMaxDanmakuDuration = MIN_DANMAKU_DURATION;
    public long mVerticalDanmakuDuration = 1000;
    private IDanmakus sSpecialDanmakus = new Danmakus();

    protected DanmakuFactory(DanmakuContext danmakuContext) {
        this.sLastConfig = danmakuContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DanmakuFactory create(DanmakuContext danmakuContext) {
        return new DanmakuFactory(danmakuContext);
    }

    public static void fillLinePathData(BaseDanmaku baseDanmaku, float[][] fArr, float f, float f2) {
        if (baseDanmaku.getType() == 7 && fArr.length != 0 && fArr[0].length == 2) {
            for (int i = 0; i < fArr.length; i++) {
                float[] fArr2 = fArr[i];
                fArr2[0] = fArr2[0] * f;
                float[] fArr3 = fArr[i];
                fArr3[1] = fArr3[1] * f2;
            }
            ((SpecialDanmaku) baseDanmaku).setLinePathData(fArr);
        }
    }

    private void updateSpecialDanmakuDuration(BaseDanmaku baseDanmaku) {
        Duration duration;
        Duration duration2 = this.mMaxDurationSpecialDanmaku;
        if (duration2 == null || ((duration = baseDanmaku.duration) != null && duration.value > duration2.value)) {
            this.mMaxDurationSpecialDanmaku = baseDanmaku.duration;
            updateMaxDanmakuDuration();
        }
    }

    private void updateSpecialDanmakusDate(float f, float f2) {
        IDanmakuIterator it = this.sSpecialDanmakus.iterator();
        while (it.hasNext()) {
            SpecialDanmaku specialDanmaku = (SpecialDanmaku) it.next();
            fillTranslationData(specialDanmaku, specialDanmaku.beginX, specialDanmaku.beginY, specialDanmaku.endX, specialDanmaku.endY, specialDanmaku.translationDuration, specialDanmaku.translationStartDelay, f, f2);
            SpecialDanmaku.LinePath[] linePathArr = specialDanmaku.linePaths;
            if (linePathArr != null && linePathArr.length > 0) {
                int length = linePathArr.length;
                int i = 0;
                float[][] fArr = (float[][]) Array.newInstance(float.class, length + 1, 2);
                while (i < length) {
                    fArr[i] = linePathArr[i].getBeginPoint();
                    int i2 = i + 1;
                    fArr[i2] = linePathArr[i].getEndPoint();
                    i = i2;
                }
                fillLinePathData(specialDanmaku, fArr, f, f2);
            }
        }
    }

    public BaseDanmaku createDanmaku(int i) {
        return createDanmaku(i, -1, this.sLastConfig);
    }

    public void fillAlphaData(BaseDanmaku baseDanmaku, int i, int i2, long j) {
        if (baseDanmaku.getType() != 7) {
            return;
        }
        ((SpecialDanmaku) baseDanmaku).setAlphaData(i, i2, j);
        updateSpecialDanmakuDuration(baseDanmaku);
    }

    public void fillTranslationData(BaseDanmaku baseDanmaku, float f, float f2, float f3, float f4, long j, long j2, float f5, float f6) {
        if (baseDanmaku.getType() != 7) {
            return;
        }
        ((SpecialDanmaku) baseDanmaku).setTranslationData(f * f5, f2 * f6, f3 * f5, f4 * f6, j, j2);
        updateSpecialDanmakuDuration(baseDanmaku);
    }

    public void notifyDispSizeChanged(DanmakuContext danmakuContext) {
        this.sLastConfig = danmakuContext;
        this.sLastDisp = danmakuContext.getDisplayer();
        createDanmaku(1, danmakuContext);
    }

    public void resetDurationsData() {
        this.sLastDisp = null;
        this.mCurrentDispHeight = 0;
        this.mCurrentDispWidth = 0;
        this.sSpecialDanmakus.clear();
        this.mMaxDurationScrollDanmaku = null;
        this.mMaxDurationFixDanmaku = null;
        this.mMaxDurationSpecialDanmaku = null;
        this.mDurationVerticalAnimDanmaku = null;
        this.mMaxDanmakuDuration = this.sLastConfig.mOrientation == 2 ? DEFAULT_DANMAKU_DURATION : DEFAULT_DANMAKU_DURATION_V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDurationFactor(float f) {
        Duration duration = this.mMaxDurationScrollDanmaku;
        if (duration == null || this.mMaxDurationFixDanmaku == null) {
            return;
        }
        if (this.sLastConfig.mOrientation == 2) {
            this.mRealDanmakuDuration = DEFAULT_DANMAKU_DURATION;
            duration.setFactor(f, DEFAULT_DANMAKU_DURATION);
        } else {
            this.mRealDanmakuDuration = DEFAULT_DANMAKU_DURATION_V;
            duration.setFactor(f, DEFAULT_DANMAKU_DURATION_V);
        }
        updateMaxDanmakuDuration();
    }

    public void updateMaxDanmakuDuration() {
        Duration duration = this.mMaxDurationScrollDanmaku;
        long j = duration == null ? 0L : duration.value;
        Duration duration2 = this.mMaxDurationFixDanmaku;
        long j2 = duration2 == null ? 0L : duration2.value;
        Duration duration3 = this.mMaxDurationSpecialDanmaku;
        long j3 = duration3 != null ? duration3.value : 0L;
        long max = Math.max(j, j2);
        this.mMaxDanmakuDuration = max;
        long max2 = Math.max(max, j3);
        this.mMaxDanmakuDuration = max2;
        if (this.sLastConfig.mOrientation == 2) {
            this.mMaxDanmakuDuration = Math.max((long) MIN_DANMAKU_DURATION, max2);
        } else {
            this.mMaxDanmakuDuration = Math.max((long) MIN_DANMAKU_DURATION_V, max2);
        }
        this.mMaxDanmakuDuration = Math.max(this.mRealDanmakuDuration, this.mMaxDanmakuDuration);
    }

    public boolean updateViewportState(float f, float f2, float f3) {
        int i = (int) f;
        if (this.mCurrentDispWidth == i && this.mCurrentDispHeight == ((int) f2) && this.mCurrentDispSizeFactor == f3) {
            return false;
        }
        long min = Math.min((long) MAX_DANMAKU_DURATION_HIGH_DENSITY, this.mRealDanmakuDuration);
        this.mRealDanmakuDuration = min;
        this.mRealDanmakuDuration = Math.max((long) MIN_DANMAKU_DURATION, min);
        this.mCurrentDispWidth = i;
        this.mCurrentDispHeight = (int) f2;
        this.mCurrentDispSizeFactor = f3;
        return true;
    }

    public BaseDanmaku createDanmaku(int i, int i2) {
        return createDanmaku(i, i2, this.sLastConfig);
    }

    public BaseDanmaku createDanmaku(int i, DanmakuContext danmakuContext) {
        return createDanmaku(i, -1, danmakuContext);
    }

    public BaseDanmaku createDanmaku(int i, int i2, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.sLastConfig = danmakuContext;
        AbsDisplayer displayer = danmakuContext.getDisplayer();
        this.sLastDisp = displayer;
        return createDanmaku(i, i2, displayer.getWidth(), this.sLastDisp.getHeight(), this.mCurrentDispSizeFactor, danmakuContext.scrollSpeedFactor / danmakuContext.getPlaySpeed());
    }

    public BaseDanmaku createDanmaku(int i, float f, float f2, float f3, float f4) {
        return createDanmaku(i, -1, f, f2, f3, f4);
    }

    public BaseDanmaku createDanmaku(int i, int i2, float f, float f2, float f3, float f4) {
        float f5;
        int i3;
        boolean updateViewportState = updateViewportState(f, f2, f3);
        if (this.mMaxDurationScrollDanmaku == null) {
            this.mMaxDurationScrollDanmaku = new Duration(this.mRealDanmakuDuration);
        }
        this.mMaxDurationScrollDanmaku.setFactor(f4, this.mRealDanmakuDuration);
        if (this.mMaxDurationFixDanmaku == null) {
            this.mMaxDurationFixDanmaku = new Duration(COMMON_DANMAKU_DURATION);
        }
        if (this.mDurationVerticalAnimDanmaku == null) {
            this.mDurationVerticalAnimDanmaku = new Duration(this.mVerticalDanmakuDuration);
        }
        if (updateViewportState && f > 0.0f) {
            updateMaxDanmakuDuration();
            int i4 = this.mCurrentDispWidth;
            float f6 = 1.0f;
            if (i4 <= 0 || (i3 = this.mCurrentDispHeight) <= 0) {
                f5 = 1.0f;
            } else {
                f6 = f / i4;
                f5 = f2 / i3;
            }
            if (f2 > 0.0f) {
                updateSpecialDanmakusDate(f6, f5);
            }
        }
        DanmakuContext danmakuContext = this.sLastConfig;
        BaseDanmaku baseDanmaku = null;
        IDanmakuSettingPlugin danmakuSettingPlugin = danmakuContext != null ? danmakuContext.getDanmakuSettingPlugin() : null;
        DanmakuContext danmakuContext2 = this.sLastConfig;
        if (danmakuContext2 != null && danmakuContext2.getDanmakuTypePlugin() != null) {
            IDanmakuTypePlugin danmakuTypePlugin = this.sLastConfig.getDanmakuTypePlugin();
            Duration duration = this.mMaxDurationScrollDanmaku;
            if (i == 4 || i == 5) {
                duration = this.mMaxDurationFixDanmaku;
            }
            baseDanmaku = danmakuTypePlugin.getDanmakuInstance(i, i2, duration, danmakuSettingPlugin);
            if (baseDanmaku != null) {
                if (i == 7) {
                    this.sSpecialDanmakus.addItem(baseDanmaku);
                }
                return baseDanmaku;
            }
        }
        if (i == 1) {
            if (i2 != -3) {
                if (i2 != -2) {
                    return new R2LDanmaku(this.mMaxDurationScrollDanmaku, danmakuSettingPlugin);
                }
                return new AutoStopR2LDanmaku(this.mMaxDurationScrollDanmaku, danmakuSettingPlugin);
            }
            return new GuideR2LDanmaku(this.mMaxDurationScrollDanmaku, danmakuSettingPlugin);
        } else if (i != 4) {
            if (i != 5) {
                if (i != 6) {
                    if (i != 7) {
                        return baseDanmaku;
                    }
                    SpecialDanmaku specialDanmaku = new SpecialDanmaku();
                    this.sSpecialDanmakus.addItem(specialDanmaku);
                    return specialDanmaku;
                }
                return new L2RDanmaku(this.mMaxDurationScrollDanmaku);
            }
            return new FTDanmaku(this.mMaxDurationFixDanmaku);
        } else {
            return new FBDanmaku(this.mMaxDurationFixDanmaku);
        }
    }
}
