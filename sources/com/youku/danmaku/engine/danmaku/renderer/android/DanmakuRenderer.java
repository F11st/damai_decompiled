package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.controller.DanmakuFilters;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.ICacheManager;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.danmaku.AutoStopR2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.renderer.Renderer;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuRenderer extends Renderer {
    private ICacheManager mCacheManager;
    private final DanmakuContext mContext;
    private final DanmakusRetainer mDanmakusRetainer;
    private IRenderer.OnDanmakuShownListener mOnDanmakuShownListener;
    private DanmakuTimer mStartTimer;
    private DanmakusRetainer.Verifier mVerifier;
    private final DanmakusRetainer.Verifier verifier = new DanmakusRetainer.Verifier() { // from class: com.youku.danmaku.engine.danmaku.renderer.android.DanmakuRenderer.1
        @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.Verifier
        public boolean skipLayout(BaseDanmaku baseDanmaku, float f, int i, boolean z) {
            if (baseDanmaku.priority == 0 && DanmakuRenderer.this.mContext.mDanmakuFilters.filterSecondary(baseDanmaku, i, 0, DanmakuRenderer.this.mStartTimer, z, DanmakuRenderer.this.mContext)) {
                baseDanmaku.setVisibility(false);
                return true;
            }
            return false;
        }
    };
    private Consumer mConsumer = new Consumer();
    private List<BaseDanmaku> mSpecialLiveList = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private class Consumer extends IDanmakus.DefaultConsumer<BaseDanmaku> {
        public IDisplayer disp;
        private BaseDanmaku lastItem;
        public IRenderer.RenderingState renderingState;
        public ArrayList<BaseDanmaku> sysDanmakuItems;
        public ArrayList<BaseDanmaku> youkuSpecialItems;

        private Consumer() {
            this.youkuSpecialItems = new ArrayList<>();
            this.sysDanmakuItems = new ArrayList<>();
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public void after() {
            this.renderingState.lastDanmaku = this.lastItem;
            super.after();
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public void before() {
            super.before();
            DanmakuRenderer.this.mSpecialLiveList.clear();
            if (this.youkuSpecialItems == null) {
                this.youkuSpecialItems = new ArrayList<>();
            }
            this.youkuSpecialItems.clear();
            if (this.sysDanmakuItems == null) {
                this.sysDanmakuItems = new ArrayList<>();
            }
            this.sysDanmakuItems.clear();
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public int accept(BaseDanmaku baseDanmaku) {
            this.lastItem = baseDanmaku;
            if (baseDanmaku.isTimeOut()) {
                this.disp.recycle(baseDanmaku);
                return 0;
            }
            if (!baseDanmaku.hasPassedFilter()) {
                DanmakuFilters danmakuFilters = DanmakuRenderer.this.mContext.mDanmakuFilters;
                IRenderer.RenderingState renderingState = this.renderingState;
                danmakuFilters.filter(baseDanmaku, renderingState.indexInScreen, renderingState.totalSizeInScreen, DanmakuRenderer.this.mStartTimer, false, DanmakuRenderer.this.mContext);
            }
            if (baseDanmaku.priority == 0 && baseDanmaku.isFiltered()) {
                baseDanmaku.setVisibility(false);
                return 0;
            } else if (baseDanmaku.isLate()) {
                if (DanmakuRenderer.this.mCacheManager != null && !baseDanmaku.hasDrawingCache()) {
                    DanmakuRenderer.this.mCacheManager.addDanmaku(baseDanmaku);
                }
                return 0;
            } else {
                if (baseDanmaku.getType() == 1) {
                    this.renderingState.indexInScreen++;
                }
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(this.disp, false);
                }
                DanmakuRenderer.this.mDanmakusRetainer.fix(baseDanmaku, this.disp, DanmakuRenderer.this.mVerifier);
                if (baseDanmaku.isShown()) {
                    if (baseDanmaku.lines != null || baseDanmaku.getBottom() <= this.disp.getHeight()) {
                        byte b = baseDanmaku.priority;
                        if (b == 2) {
                            if (baseDanmaku instanceof AutoStopR2LDanmaku) {
                                DanmakuRenderer.this.mSpecialLiveList.add(baseDanmaku);
                            }
                            this.youkuSpecialItems.add(baseDanmaku);
                            return 0;
                        } else if (b == 3) {
                            if (baseDanmaku instanceof AutoStopR2LDanmaku) {
                                DanmakuRenderer.this.mSpecialLiveList.add(baseDanmaku);
                            }
                            this.sysDanmakuItems.add(baseDanmaku);
                            return 0;
                        } else {
                            int draw = baseDanmaku.draw(this.disp);
                            if (draw == 1) {
                                this.renderingState.cacheHitCount++;
                            } else if (draw == 2) {
                                this.renderingState.cacheMissCount++;
                                if (DanmakuRenderer.this.mCacheManager != null) {
                                    DanmakuRenderer.this.mCacheManager.addDanmaku(baseDanmaku);
                                }
                            }
                            this.renderingState.addCount(baseDanmaku.getType(), 1);
                            this.renderingState.addTotalCount(1);
                            if (DanmakuRenderer.this.mOnDanmakuShownListener != null && baseDanmaku.firstShownFlag != DanmakuRenderer.this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG) {
                                baseDanmaku.firstShownFlag = DanmakuRenderer.this.mContext.mGlobalFlagValues.FIRST_SHOWN_RESET_FLAG;
                                DanmakuRenderer.this.mOnDanmakuShownListener.onDanmakuShown(baseDanmaku);
                            }
                            return 0;
                        }
                    }
                    return 0;
                }
                return 0;
            }
        }
    }

    public DanmakuRenderer(DanmakuContext danmakuContext) {
        this.mContext = danmakuContext;
        this.mDanmakusRetainer = new DanmakusRetainer(danmakuContext.getDanmakuLayoutPlugin(), danmakuContext.getDanmakuSettingPlugin());
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

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void changeSpeed(float f, float f2) {
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void changeSpeed(R2LDanmaku r2LDanmaku) {
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
    public void draw(IDisplayer iDisplayer, IDanmakus iDanmakus, long j, IRenderer.RenderingState renderingState) {
        this.mStartTimer = renderingState.timer;
        Consumer consumer = this.mConsumer;
        consumer.disp = iDisplayer;
        consumer.renderingState = renderingState;
        iDanmakus.forEachSync(consumer);
        Iterator<BaseDanmaku> it = this.mConsumer.youkuSpecialItems.iterator();
        while (it.hasNext()) {
            drawBaseDanmaku(it.next(), iDisplayer, renderingState);
        }
        Iterator<BaseDanmaku> it2 = this.mConsumer.sysDanmakuItems.iterator();
        while (it2.hasNext()) {
            drawBaseDanmaku(it2.next(), iDisplayer, renderingState);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.Renderer, com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public List<BaseDanmaku> getSpecialDanmaku() {
        return this.mSpecialLiveList;
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
    }
}
