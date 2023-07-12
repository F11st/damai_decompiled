package com.youku.danmaku.engine.controller;

import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.GlobalFlagValues;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakuRenderer;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DrawTask implements IDrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean clearRetainerFlag;
    protected IDanmakus danmakuList;
    protected final DanmakuContext mContext;
    final AbsDisplayer mDisp;
    private boolean mIsHidden;
    private long mLastBeginMills;
    private BaseDanmaku mLastDanmaku;
    private long mLastEndMills;
    BaseDanmakuParser mParser;
    boolean mReadyState;
    final IRenderer mRenderer;
    IDrawTask.TaskListener mTaskListener;
    DanmakuTimer mTimer;
    private long mStartRenderTime = 0;
    private final IRenderer.RenderingState mRenderingState = new IRenderer.RenderingState();
    private IDanmakus danmakus = new Danmakus(4);
    private Danmakus mLiveDanmakus = new Danmakus(4);
    private DanmakuContext.ConfigChangedCallback mConfigChangedCallback = new DanmakuContext.ConfigChangedCallback() { // from class: com.youku.danmaku.engine.controller.DrawTask.1
        @Override // com.youku.danmaku.engine.danmaku.model.android.DanmakuContext.ConfigChangedCallback
        public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return DrawTask.this.onDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        }
    };

    public DrawTask(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.TaskListener taskListener) {
        if (danmakuContext != null) {
            this.mContext = danmakuContext;
            this.mDisp = danmakuContext.getDisplayer();
            this.mTaskListener = taskListener;
            DanmakuRenderer danmakuRenderer = new DanmakuRenderer(danmakuContext);
            this.mRenderer = danmakuRenderer;
            danmakuRenderer.setOnDanmakuShownListener(new IRenderer.OnDanmakuShownListener() { // from class: com.youku.danmaku.engine.controller.DrawTask.2
                @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer.OnDanmakuShownListener
                public void onDanmakuShown(BaseDanmaku baseDanmaku) {
                    IDrawTask.TaskListener taskListener2 = DrawTask.this.mTaskListener;
                    if (taskListener2 != null) {
                        taskListener2.onDanmakuShown(baseDanmaku);
                    }
                }
            });
            danmakuRenderer.setVerifierEnabled(danmakuContext.isPreventOverlappingEnabled() || danmakuContext.isMaxLinesLimited());
            initTimer(danmakuTimer);
            if (danmakuContext.isDuplicateMergingEnabled()) {
                danmakuContext.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                return;
            } else {
                danmakuContext.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                return;
            }
        }
        throw new IllegalArgumentException("context is null");
    }

    private void beginTracing(IRenderer.RenderingState renderingState, IDanmakus iDanmakus) {
        renderingState.reset();
        renderingState.timer.update(SystemClock.uptimeMillis());
        renderingState.indexInScreen = 0;
        renderingState.totalSizeInScreen = iDanmakus != null ? iDanmakus.size() : 0;
    }

    private void endTracing(IRenderer.RenderingState renderingState) {
        boolean z = renderingState.totalDanmakuCount == 0;
        renderingState.nothingRendered = z;
        if (z) {
            renderingState.beginTime = -1L;
        }
        BaseDanmaku baseDanmaku = renderingState.lastDanmaku;
        renderingState.lastDanmaku = null;
        renderingState.endTime = baseDanmaku != null ? baseDanmaku.time : -1L;
        renderingState.consumingTime = renderingState.timer.update(SystemClock.uptimeMillis());
    }

    private static boolean hasInsideDanmakus(IDanmakus iDanmakus) {
        if (iDanmakus == null || iDanmakus.isEmpty()) {
            return false;
        }
        synchronized (iDanmakus) {
            IDanmakuIterator it = iDanmakus.iterator();
            while (it.hasNext()) {
                if (!it.next().isOutside()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized void addDanmaku(BaseDanmaku baseDanmaku) {
        boolean addItem;
        IDrawTask.TaskListener taskListener;
        boolean addItem2;
        if (this.danmakuList == null) {
            return;
        }
        if (baseDanmaku.isLive) {
            this.mLiveDanmakus.addItem(baseDanmaku);
            removeUnusedLiveDanmakusIn(10);
        }
        baseDanmaku.index = this.danmakuList.size();
        boolean z = true;
        long j = this.mLastBeginMills;
        long j2 = baseDanmaku.time;
        if (j <= j2 && j2 <= this.mLastEndMills) {
            synchronized (this.danmakus) {
                addItem2 = this.danmakus.addItem(baseDanmaku);
            }
            z = addItem2;
        } else if (baseDanmaku.isLive) {
            z = false;
        }
        synchronized (this.danmakuList) {
            addItem = this.danmakuList.addItem(baseDanmaku);
        }
        if (!z) {
            this.mLastEndMills = 0L;
            this.mLastBeginMills = 0L;
        }
        if (addItem && (taskListener = this.mTaskListener) != null) {
            taskListener.onDanmakuAdd(baseDanmaku);
        }
        BaseDanmaku baseDanmaku2 = this.mLastDanmaku;
        if (baseDanmaku2 == null || (baseDanmaku2 != null && baseDanmaku.time > baseDanmaku2.time)) {
            this.mLastDanmaku = baseDanmaku;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void addDanmakuList(List<BaseDanmaku> list, long j, GlobalFlagValues globalFlagValues, DanmakuTimer danmakuTimer) {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void clearDanmakusOnScreen(long j) {
        reset(0);
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        Log.d("clearDanmakusOnScreen, mStartRenderTime=" + j);
        this.mStartRenderTime = j;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized IRenderer.RenderingState draw(AbsDisplayer absDisplayer) {
        return drawDanmakus(absDisplayer, this.mTimer);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.youku.danmaku.engine.danmaku.renderer.IRenderer.RenderingState drawDanmakus(com.youku.danmaku.engine.danmaku.model.AbsDisplayer r13, com.youku.danmaku.engine.danmaku.model.DanmakuTimer r14) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.controller.DrawTask.drawDanmakus(com.youku.danmaku.engine.danmaku.model.AbsDisplayer, com.youku.danmaku.engine.danmaku.model.DanmakuTimer):com.youku.danmaku.engine.danmaku.renderer.IRenderer$RenderingState");
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public IDanmakus getVisibleDanmakusOnTime(long j) {
        IDanmakus iDanmakus;
        long j2 = this.mContext.mDanmakuFactory.mMaxDanmakuDuration;
        long j3 = (j - j2) - 100;
        long j4 = j2 + j;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                iDanmakus = null;
                break;
            }
            try {
                iDanmakus = this.danmakuList.subnew(j3, j4);
                break;
            } catch (Exception unused) {
                i = i2;
            }
        }
        final Danmakus danmakus = new Danmakus();
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            iDanmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.DrawTask.5
                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public int accept(BaseDanmaku baseDanmaku) {
                    if (!baseDanmaku.isShown() || baseDanmaku.isOutside()) {
                        return 0;
                    }
                    danmakus.addItem(baseDanmaku);
                    return 0;
                }
            });
        }
        if (Log.isDebug()) {
            Log.d("getVisibleDanmakusOnTime current time=" + Log.showTime(j) + ", visible size=" + danmakus.size());
        }
        return danmakus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleOnDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        boolean z = false;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool = (Boolean) objArr[0];
            if (bool != null) {
                if (bool.booleanValue()) {
                    this.mContext.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                    return true;
                }
                this.mContext.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                return true;
            }
        } else if (!DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
            if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
                IRenderer iRenderer = this.mRenderer;
                if (iRenderer != null) {
                    iRenderer.setVerifierEnabled((this.mContext.isPreventOverlappingEnabled() || this.mContext.isMaxLinesLimited()) ? true : true);
                    return true;
                }
                return true;
            }
        } else {
            requestClearRetainer();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public boolean hasDanmakusBySecond(long j) {
        DanmakuContext danmakuContext;
        DanmakuFactory danmakuFactory;
        IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            return hasInsideDanmakus(this.danmakus);
        }
        IDanmakus iDanmakus2 = this.danmakuList;
        if (iDanmakus2 != null && (danmakuContext = this.mContext) != null && (danmakuFactory = danmakuContext.mDanmakuFactory) != null) {
            long j2 = danmakuFactory.mMaxDanmakuDuration;
            try {
                return hasInsideDanmakus(iDanmakus2.subnew((j - j2) - 100, j + j2));
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    protected void initTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        this.mContext.getDisplayer().getCacheStuffer().clearCache(baseDanmaku);
        int i = baseDanmaku.requestFlags | 2;
        baseDanmaku.requestFlags = i;
        if (z) {
            baseDanmaku.paintWidth = -1.0f;
            baseDanmaku.paintHeight = -1.0f;
            baseDanmaku.requestFlags = i | 1;
            baseDanmaku.measureResetFlag++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadDanmakus(BaseDanmakuParser baseDanmakuParser) {
        this.danmakuList = baseDanmakuParser.setConfig(this.mContext).setDisplayer(this.mDisp).setTimer(this.mTimer).getDanmakus();
        this.mContext.mGlobalFlagValues.resetAll();
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null) {
            this.mLastDanmaku = iDanmakus.last();
        }
    }

    public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean handleOnDanmakuConfigChanged = handleOnDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        IDrawTask.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.onDanmakuConfigChanged();
        }
        return handleOnDanmakuConfigChanged;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDanmakuRemoved(BaseDanmaku baseDanmaku) {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void onPlayStateChanged(int i) {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void prepare() {
        loadDanmakus(this.mParser);
        this.mLastEndMills = 0L;
        this.mLastBeginMills = 0L;
        IDrawTask.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.ready();
            this.mReadyState = true;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void quit() {
        this.mContext.unregisterAllConfigChangedCallbacks();
        IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.release();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized void removeAllDanmakus() {
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            this.danmakuList.clear();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized void removeAllLiveDanmakus() {
        IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            synchronized (this.danmakus) {
                this.danmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.DrawTask.3
                    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                    public int accept(BaseDanmaku baseDanmaku) {
                        if (baseDanmaku.isLive) {
                            DrawTask.this.onDanmakuRemoved(baseDanmaku);
                            return 2;
                        }
                        return 0;
                    }
                });
            }
        }
    }

    protected synchronized void removeUnusedLiveDanmakusIn(final int i) {
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null && !iDanmakus.isEmpty() && !this.mLiveDanmakus.isEmpty()) {
            this.mLiveDanmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.DrawTask.4
                long startTime = SystemClock.uptimeMillis();

                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public int accept(BaseDanmaku baseDanmaku) {
                    boolean isTimeOut = baseDanmaku.isTimeOut();
                    if (SystemClock.uptimeMillis() - this.startTime <= i && isTimeOut) {
                        DrawTask.this.danmakuList.removeItem(baseDanmaku);
                        DrawTask.this.onDanmakuRemoved(baseDanmaku);
                        return 2;
                    }
                    return 1;
                }
            });
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestClear() {
        this.mLastEndMills = 0L;
        this.mLastBeginMills = 0L;
        this.mIsHidden = false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestClearRetainer() {
        this.clearRetainerFlag = true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestHide() {
        this.mIsHidden = true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void reset(int i) {
        IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null) {
            iDanmakus.clear();
        }
        IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.clear();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public boolean screenHasData() {
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void seek(long j, int i) {
        BaseDanmaku last;
        reset(0);
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        if (j < 1000) {
            j = 0;
        }
        this.mStartRenderTime = j;
        this.mRenderingState.reset();
        this.mRenderingState.endTime = this.mStartRenderTime;
        this.mLastEndMills = 0L;
        this.mLastBeginMills = 0L;
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus == null || (last = iDanmakus.last()) == null || last.isTimeOut()) {
            return;
        }
        this.mLastDanmaku = last;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void setParser(BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
        this.mReadyState = false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void start() {
        this.mContext.registerConfigChangedCallback(this.mConfigChangedCallback);
    }
}
