package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuRenderModel;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.ICacheManager;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.renderer.Renderer;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuRendererNew extends Renderer {
    private ICacheManager mCacheManager;
    private final DanmakuContext mContext;
    private final DanmakusRetainer mDanmakusRetainer;
    private IRenderer.OnDanmakuShownListener mOnDanmakuShownListener;
    private DanmakuTimer mStartTimer;
    private DanmakusRetainer.Verifier mVerifier;
    private final List<BaseDanmaku> mShowList = new ArrayList();
    private final List<BaseDanmaku> mFilterHighLevelList = new ArrayList();
    private final List<BaseDanmaku> mYoukuSpecialItemList = new ArrayList();
    private final List<BaseDanmaku> mTopItemList = new ArrayList();
    private final List<BaseDanmaku> mTimeOutList = new ArrayList();
    private final DanmakusRetainer.Verifier verifier = new DanmakusRetainer.Verifier() { // from class: com.youku.danmaku.engine.danmaku.renderer.android.DanmakuRendererNew.1
        @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.Verifier
        public boolean skipLayout(BaseDanmaku baseDanmaku, float f, int i, boolean z) {
            if (DanmakuRendererNew.this.mContext.mDanmakuFilters.filterSecondary(baseDanmaku, i, 0, DanmakuRendererNew.this.mStartTimer, z, DanmakuRendererNew.this.mContext)) {
                baseDanmaku.setVisibility(false);
                return true;
            }
            return false;
        }
    };

    public DanmakuRendererNew(DanmakuContext danmakuContext) {
        this.mContext = danmakuContext;
        this.mDanmakusRetainer = new DanmakusRetainer(danmakuContext.getDanmakuLayoutPlugin(), danmakuContext.getDanmakuSettingPlugin());
    }

    private void composingDanmaku(List<BaseDanmaku> list, DanmakuRenderModel danmakuRenderModel, IRenderer.RenderingState renderingState, IDisplayer iDisplayer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (BaseDanmaku baseDanmaku : list) {
            if (baseDanmaku != null && baseDanmaku.duration != null) {
                if (z) {
                    baseDanmaku.filterResetFlag = -1;
                    baseDanmaku.mFilterParam = 0;
                }
                baseDanmaku.time = danmakuRenderModel.mCurrentMillisecond;
                if (!baseDanmaku.hasPassedFilter()) {
                    DanmakuContext danmakuContext = this.mContext;
                    danmakuContext.mDanmakuFilters.filter(baseDanmaku, renderingState.indexInScreen, renderingState.totalSizeInScreen, this.mStartTimer, false, danmakuContext);
                }
                if (!baseDanmaku.isFiltered()) {
                    if (!baseDanmaku.isMeasured()) {
                        baseDanmaku.measure(iDisplayer, false);
                    }
                    this.mDanmakusRetainer.fix(baseDanmaku, iDisplayer, this.mVerifier);
                    if (z && baseDanmaku.isFilter) {
                        this.mFilterHighLevelList.add(baseDanmaku);
                    } else if (baseDanmaku.isShown()) {
                        if (baseDanmaku.lines == null && baseDanmaku.getBottom() > iDisplayer.getHeight()) {
                            baseDanmaku.setVisibility(false);
                        } else {
                            ICacheManager iCacheManager = this.mCacheManager;
                            if (iCacheManager != null) {
                                iCacheManager.addDanmaku(baseDanmaku);
                            }
                            this.mShowList.add(baseDanmaku);
                        }
                    }
                } else if (z) {
                    this.mFilterHighLevelList.add(baseDanmaku);
                }
            }
        }
        if (z) {
            for (BaseDanmaku baseDanmaku2 : this.mFilterHighLevelList) {
                list.remove(baseDanmaku2);
            }
        }
        for (BaseDanmaku baseDanmaku3 : this.mShowList) {
            list.remove(baseDanmaku3);
        }
    }

    private void drawBaseDanmaku(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, IRenderer.RenderingState renderingState) {
        int draw = baseDanmaku.draw(iDisplayer);
        if (draw == 1) {
            renderingState.cacheHitCount++;
        } else if (draw == 2) {
            renderingState.cacheMissCount++;
            ICacheManager iCacheManager = this.mCacheManager;
            if (iCacheManager != null) {
                iCacheManager.addDanmaku(baseDanmaku);
            }
        }
        renderingState.addCount(baseDanmaku.getType(), 1);
        renderingState.addTotalCount(1);
        IRenderer.OnDanmakuShownListener onDanmakuShownListener = this.mOnDanmakuShownListener;
        if (onDanmakuShownListener != null) {
            int i = baseDanmaku.firstShownFlag;
            int i2 = this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG;
            if (i != i2) {
                baseDanmaku.firstShownFlag = i2;
                onDanmakuShownListener.onDanmakuShown(baseDanmaku);
            }
        }
    }

    private void drawScreenList(List<BaseDanmaku> list, IRenderer.RenderingState renderingState, IDisplayer iDisplayer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mYoukuSpecialItemList.clear();
        this.mTopItemList.clear();
        this.mTimeOutList.clear();
        for (BaseDanmaku baseDanmaku : list) {
            renderingState.lastDanmaku = baseDanmaku;
            if (baseDanmaku.isTimeOut()) {
                iDisplayer.recycle(baseDanmaku);
                this.mTimeOutList.add(baseDanmaku);
            } else {
                if (!baseDanmaku.hasPassedFilter()) {
                    DanmakuContext danmakuContext = this.mContext;
                    danmakuContext.mDanmakuFilters.filter(baseDanmaku, renderingState.indexInScreen, renderingState.totalSizeInScreen, this.mStartTimer, false, danmakuContext);
                }
                if (baseDanmaku.isFiltered()) {
                    baseDanmaku.setVisibility(false);
                } else {
                    baseDanmaku.setVisibility(true);
                    if (baseDanmaku.isBombed) {
                        this.mTimeOutList.add(baseDanmaku);
                    } else {
                        if (baseDanmaku.getType() == 1) {
                            renderingState.indexInScreen++;
                        }
                        if (!baseDanmaku.isMeasured()) {
                            baseDanmaku.measure(iDisplayer, false);
                        }
                        this.mDanmakusRetainer.fix(baseDanmaku, iDisplayer, this.mVerifier);
                        if (baseDanmaku.isShown() && (baseDanmaku.lines != null || baseDanmaku.getBottom() <= iDisplayer.getHeight())) {
                            if (this.mContext.getDanmakuSettingPlugin() == null || baseDanmaku.lines != null || baseDanmaku.getDanmakuLine() < this.mContext.getDanmakuSettingPlugin().getLineCount()) {
                                if (!baseDanmaku.isSelected) {
                                    byte b = baseDanmaku.priority;
                                    if (b != 2 && b != 3) {
                                        if (baseDanmaku.getType() == 5) {
                                            this.mTopItemList.add(baseDanmaku);
                                        }
                                        drawBaseDanmaku(baseDanmaku, iDisplayer, renderingState);
                                    } else {
                                        this.mYoukuSpecialItemList.add(baseDanmaku);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (BaseDanmaku baseDanmaku2 : this.mYoukuSpecialItemList) {
            drawBaseDanmaku(baseDanmaku2, iDisplayer, renderingState);
        }
        for (BaseDanmaku baseDanmaku3 : this.mTopItemList) {
            drawBaseDanmaku(baseDanmaku3, iDisplayer, renderingState);
        }
        if (this.mTimeOutList.isEmpty()) {
            return;
        }
        for (BaseDanmaku baseDanmaku4 : this.mTimeOutList) {
            list.remove(baseDanmaku4);
            BaseExtraStyle baseExtraStyle = baseDanmaku4.mExtraStyle;
            if (baseExtraStyle != null && baseExtraStyle.isAniImage()) {
                baseDanmaku4.mExtraStyle.releaseResource(baseDanmaku4);
            }
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void changeSpeed(float f, float f2) {
        this.mDanmakusRetainer.changeSpeed(f, f2);
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void clear() {
        clearRetainer();
        this.mContext.mDanmakuFilters.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void clearRetainer() {
        this.mDanmakusRetainer.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.Renderer, com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void draw(IDisplayer iDisplayer, IRenderer.RenderingState renderingState, DanmakuRenderModel danmakuRenderModel) {
        this.mStartTimer = renderingState.timer;
        this.mShowList.clear();
        this.mFilterHighLevelList.clear();
        if (!danmakuRenderModel.mClearRetainerFlag) {
            synchronized (danmakuRenderModel.mHighLevelList) {
                composingDanmaku(danmakuRenderModel.mHighLevelList, danmakuRenderModel, renderingState, iDisplayer, true);
            }
            if (!danmakuRenderModel.hasNormalHighLevelDanmaku()) {
                synchronized (danmakuRenderModel.mNormalLevelList) {
                    composingDanmaku(danmakuRenderModel.mNormalLevelList, danmakuRenderModel, renderingState, iDisplayer, false);
                }
            }
        }
        synchronized (danmakuRenderModel.mScreenDanmakuList) {
            danmakuRenderModel.mScreenDanmakuList.addAll(this.mShowList);
            drawScreenList(danmakuRenderModel.mScreenDanmakuList, renderingState, iDisplayer);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void release() {
        this.mDanmakusRetainer.release();
        this.mContext.mDanmakuFilters.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void removeOnDanmakuShownListener() {
        this.mOnDanmakuShownListener = null;
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void setCacheManager(ICacheManager iCacheManager) {
        this.mCacheManager = iCacheManager;
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void setOnDanmakuShownListener(IRenderer.OnDanmakuShownListener onDanmakuShownListener) {
        this.mOnDanmakuShownListener = onDanmakuShownListener;
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void setVerifierEnabled(boolean z) {
        this.mVerifier = z ? this.verifier : null;
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void showVisibleDanmakuLog() {
        this.mDanmakusRetainer.showVisibleDanmakuLog();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void changeSpeed(R2LDanmaku r2LDanmaku) {
        this.mDanmakusRetainer.changeSpeed(r2LDanmaku);
    }
}
