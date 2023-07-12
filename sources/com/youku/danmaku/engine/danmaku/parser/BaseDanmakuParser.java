package com.youku.danmaku.engine.danmaku.parser;

import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseDanmakuParser {
    protected DanmakuContext mContext;
    private IDanmakus mDanmakus;
    protected IDataSource<?> mDataSource;
    protected IDisplayer mDisp;
    protected float mDispDensity;
    protected int mDispHeight;
    protected int mDispWidth;
    protected float mScaledDensity;
    protected DanmakuTimer mTimer;

    public IDanmakus getDanmakus() {
        IDanmakus iDanmakus = this.mDanmakus;
        if (iDanmakus != null) {
            return iDanmakus;
        }
        this.mContext.mDanmakuFactory.resetDurationsData();
        this.mDanmakus = parse();
        releaseDataSource();
        this.mContext.mDanmakuFactory.updateMaxDanmakuDuration();
        return this.mDanmakus;
    }

    public IDisplayer getDisplayer() {
        return this.mDisp;
    }

    public DanmakuTimer getTimer() {
        return this.mTimer;
    }

    protected float getViewportSizeFactor() {
        return 1.0f / DanmakuUtils.getDispParams(this.mDispDensity);
    }

    public BaseDanmakuParser load(IDataSource<?> iDataSource) {
        this.mDataSource = iDataSource;
        return this;
    }

    protected abstract IDanmakus parse();

    public void release() {
        releaseDataSource();
    }

    protected void releaseDataSource() {
        IDataSource<?> iDataSource = this.mDataSource;
        if (iDataSource != null) {
            iDataSource.release();
        }
        this.mDataSource = null;
    }

    public BaseDanmakuParser setConfig(DanmakuContext danmakuContext) {
        DanmakuContext danmakuContext2 = this.mContext;
        if (danmakuContext2 != null && danmakuContext2 != danmakuContext) {
            this.mDanmakus = null;
        }
        this.mContext = danmakuContext;
        return this;
    }

    public BaseDanmakuParser setDisplayer(IDisplayer iDisplayer) {
        this.mDisp = iDisplayer;
        this.mDispWidth = iDisplayer.getWidth();
        this.mDispHeight = iDisplayer.getHeight();
        this.mDispDensity = iDisplayer.getDensity();
        this.mScaledDensity = iDisplayer.getScaledDensity();
        this.mContext.mDanmakuFactory.updateViewportState(this.mDispWidth, this.mDispHeight, getViewportSizeFactor());
        this.mContext.mDanmakuFactory.updateMaxDanmakuDuration();
        return this;
    }

    public BaseDanmakuParser setTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
        return this;
    }
}
