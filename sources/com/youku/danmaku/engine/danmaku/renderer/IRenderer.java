package com.youku.danmaku.engine.danmaku.renderer;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuRenderModel;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.ICacheManager;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IRenderer {
    public static final int CACHE_RENDERING = 1;
    public static final int NOTHING_RENDERING = 0;
    public static final int TEXT_RENDERING = 2;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnDanmakuShownListener {
        void onDanmakuShown(BaseDanmaku baseDanmaku);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class RenderingState {
        public static final int UNKNOWN_TIME = -1;
        public long beginTime;
        public long cacheHitCount;
        public long cacheMissCount;
        public long consumingTime;
        public long endTime;
        public int fbDanmakuCount;
        public int ftDanmakuCount;
        public int indexInScreen;
        public int l2rDanmakuCount;
        public BaseDanmaku lastDanmaku;
        public int lastTotalDanmakuCount;
        public boolean nothingRendered;
        public int r2lDanmakuCount;
        public int specialDanmakuCount;
        public long sysTime;
        public DanmakuTimer timer = new DanmakuTimer();
        public int totalDanmakuCount;
        public int totalSizeInScreen;

        public int addCount(int i, int i2) {
            if (i == 1) {
                int i3 = this.r2lDanmakuCount + i2;
                this.r2lDanmakuCount = i3;
                return i3;
            } else if (i == 4) {
                int i4 = this.fbDanmakuCount + i2;
                this.fbDanmakuCount = i4;
                return i4;
            } else if (i == 5) {
                int i5 = this.ftDanmakuCount + i2;
                this.ftDanmakuCount = i5;
                return i5;
            } else if (i == 6) {
                int i6 = this.l2rDanmakuCount + i2;
                this.l2rDanmakuCount = i6;
                return i6;
            } else if (i != 7) {
                return 0;
            } else {
                int i7 = this.specialDanmakuCount + i2;
                this.specialDanmakuCount = i7;
                return i7;
            }
        }

        public int addTotalCount(int i) {
            int i2 = this.totalDanmakuCount + i;
            this.totalDanmakuCount = i2;
            return i2;
        }

        public String logInfo() {
            return "totalDanmakuCount: " + this.totalDanmakuCount + "\nlastTotalDanmakuCount: " + this.lastTotalDanmakuCount + "\nbeginTime: " + this.beginTime + "\nendTime: " + this.endTime + "\nconsumingTime: " + this.consumingTime + "\ncacheHitCount: " + this.cacheHitCount + "\ncacheMissCount: " + this.cacheMissCount;
        }

        public void reset() {
            this.lastTotalDanmakuCount = this.totalDanmakuCount;
            this.totalDanmakuCount = 0;
            this.specialDanmakuCount = 0;
            this.fbDanmakuCount = 0;
            this.ftDanmakuCount = 0;
            this.l2rDanmakuCount = 0;
            this.r2lDanmakuCount = 0;
            this.consumingTime = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.sysTime = 0L;
            this.nothingRendered = false;
        }

        public void set(RenderingState renderingState) {
            if (renderingState == null) {
                return;
            }
            this.lastTotalDanmakuCount = renderingState.lastTotalDanmakuCount;
            this.r2lDanmakuCount = renderingState.r2lDanmakuCount;
            this.l2rDanmakuCount = renderingState.l2rDanmakuCount;
            this.ftDanmakuCount = renderingState.ftDanmakuCount;
            this.fbDanmakuCount = renderingState.fbDanmakuCount;
            this.specialDanmakuCount = renderingState.specialDanmakuCount;
            this.totalDanmakuCount = renderingState.totalDanmakuCount;
            this.consumingTime = renderingState.consumingTime;
            this.beginTime = renderingState.beginTime;
            this.endTime = renderingState.endTime;
            this.nothingRendered = renderingState.nothingRendered;
            this.sysTime = renderingState.sysTime;
            this.cacheHitCount = renderingState.cacheHitCount;
            this.cacheMissCount = renderingState.cacheMissCount;
        }
    }

    void changeSpeed(float f, float f2);

    void changeSpeed(R2LDanmaku r2LDanmaku);

    void clear();

    void clearRetainer();

    void draw(IDisplayer iDisplayer, IDanmakus iDanmakus, long j, RenderingState renderingState);

    void draw(IDisplayer iDisplayer, RenderingState renderingState, DanmakuRenderModel danmakuRenderModel);

    List<BaseDanmaku> getSpecialDanmaku();

    void release();

    void removeOnDanmakuShownListener();

    void setCacheManager(ICacheManager iCacheManager);

    void setOnDanmakuShownListener(OnDanmakuShownListener onDanmakuShownListener);

    void setVerifierEnabled(boolean z);

    void showVisibleDanmakuLog();
}
