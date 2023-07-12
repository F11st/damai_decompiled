package com.youku.danmaku.engine.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.util.AndroidUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import com.youku.danmaku.plugin.IDanmakuMonitorPlugin;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.LinkedList;
import java.util.List;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DrawHandler extends Handler implements IDrawHandler {
    private static final int MAX_RECORD_SIZE = 500;
    public IDrawTask drawTask;
    private Callback mCallback;
    private DanmakuContext mContext;
    private long mCordonTime;
    private long mCordonTime2;
    private IDanmakuMonitorPlugin mDanmakuMonitorPlugin;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private IDanmakuViewController mDanmakuView;
    private boolean mDanmakusVisible;
    private long mDesireSeekingTime;
    private AbsDisplayer mDisp;
    private LinkedList<Long> mDrawTimes;
    private FrameCallback mFrameCallback;
    private long mFrameUpdateRate;
    private boolean mIdleSleep;
    private boolean mInSeekingAction;
    private boolean mInSyncAction;
    private volatile boolean mInWaitingState;
    private long mLastDeltaTime;
    private BaseDanmakuParser mParser;
    private boolean mReady;
    private long mRemainingTime;
    private final IRenderer.RenderingState mRenderingState;
    private UpdateThread mThread;
    private long mThresholdTime;
    private long mTimeBase;
    private boolean mUpdateInSeparateThread;
    private byte mUpdateMethod;
    private long pausedPosition;
    private boolean quitFlag;
    private DanmakuTimer timer;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Callback {
        void danmakuShown(BaseDanmaku baseDanmaku);

        void drawingFinished();

        void prepared();

        void updateTimer(DanmakuTimer danmakuTimer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @TargetApi(16)
    /* loaded from: classes2.dex */
    public class FrameCallback implements Choreographer.FrameCallback {
        private FrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            DrawHandler.this.sendEmptyMessage(2);
        }
    }

    public DrawHandler(Looper looper, IDanmakuViewController iDanmakuViewController, boolean z) {
        super(looper);
        this.pausedPosition = 0L;
        this.quitFlag = true;
        this.timer = new DanmakuTimer();
        this.mDanmakusVisible = true;
        this.mRenderingState = new IRenderer.RenderingState();
        this.mDrawTimes = new LinkedList<>();
        this.mCordonTime = 30L;
        this.mCordonTime2 = 60L;
        this.mFrameUpdateRate = 16L;
        this.mUpdateMethod = (byte) 0;
        chooseUpdateMethod();
        this.mIdleSleep = true ^ DeviceUtils.f();
        bindView(iDanmakuViewController);
        if (z) {
            showDanmakus(null);
        } else {
            hideDanmakus(false);
        }
        this.mDanmakusVisible = z;
    }

    private void addDanmakuForNew(BaseDanmaku baseDanmaku) {
        if (this.drawTask != null) {
            baseDanmaku.flags = this.mContext.mGlobalFlagValues;
            baseDanmaku.setTimer(this.timer);
            baseDanmaku.time = getCurrentTime();
            this.drawTask.addDanmaku(baseDanmaku);
        }
    }

    private void addDanmakuForOld(BaseDanmaku baseDanmaku) {
        if (this.drawTask != null) {
            baseDanmaku.flags = this.mContext.mGlobalFlagValues;
            baseDanmaku.setTimer(this.timer);
            this.drawTask.addDanmaku(baseDanmaku);
            obtainMessage(11).sendToTarget();
        }
    }

    private void bindView(IDanmakuViewController iDanmakuViewController) {
        this.mDanmakuView = iDanmakuViewController;
    }

    private void chooseUpdateMethod() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mUpdateMethod = (byte) 2;
        }
        if (this.mUpdateMethod == 0) {
            this.mFrameCallback = new FrameCallback();
        }
        this.mUpdateInSeparateThread = this.mUpdateMethod == 1;
    }

    private IDrawTask createDrawTask(boolean z, DanmakuTimer danmakuTimer, Context context, int i, int i2, boolean z2, IDrawTask.TaskListener taskListener) {
        AbsDisplayer displayer = this.mContext.getDisplayer();
        this.mDisp = displayer;
        displayer.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDisp.setDensities(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
        this.mDisp.setHardwareAccelerated(z2);
        IDrawTask drawTask = getDrawTask(context, z, danmakuTimer, taskListener);
        drawTask.setParser(this.mParser);
        drawTask.prepare();
        obtainMessage(10, Boolean.FALSE).sendToTarget();
        return drawTask;
    }

    private synchronized long getAverageRenderingTime() {
        int size = this.mDrawTimes.size();
        if (size <= 0) {
            return 0L;
        }
        Long peekFirst = this.mDrawTimes.peekFirst();
        Long peekLast = this.mDrawTimes.peekLast();
        if (peekFirst != null && peekLast != null) {
            return (peekLast.longValue() - peekFirst.longValue()) / size;
        }
        return 0L;
    }

    private IDrawTask getDrawTask(Context context, boolean z, DanmakuTimer danmakuTimer, IDrawTask.TaskListener taskListener) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        return (iDanmakuSettingPlugin == null || !iDanmakuSettingPlugin.isEnableVideoSpeed()) ? z ? new CacheManagingDrawTask(danmakuTimer, this.mContext, taskListener, (AndroidUtils.getMemoryClass(context) * 1048576) / 3) : new DrawTask(danmakuTimer, this.mContext, taskListener) : z ? new CacheDrawTaskNew(danmakuTimer, this.mContext, taskListener) : new DrawTaskNew(danmakuTimer, this.mContext, taskListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRenderingConfigs() {
        long max = Math.max(33L, ((float) 16) * 2.5f);
        this.mCordonTime = max;
        this.mCordonTime2 = ((float) max) * 2.5f;
        long max2 = Math.max(16L, 15L);
        this.mFrameUpdateRate = max2;
        this.mThresholdTime = max2 + 3;
    }

    private void loge(String str, String str2, String str3) {
        IDanmakuMonitorPlugin iDanmakuMonitorPlugin = this.mDanmakuMonitorPlugin;
        if (iDanmakuMonitorPlugin != null) {
            iDanmakuMonitorPlugin.loge(str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRendering() {
        if (this.mInWaitingState) {
            IDrawTask iDrawTask = this.drawTask;
            if (iDrawTask != null) {
                iDrawTask.requestClear();
            }
            if (this.mUpdateInSeparateThread) {
                synchronized (this) {
                    this.mDrawTimes.clear();
                }
                synchronized (this.drawTask) {
                    this.drawTask.notifyAll();
                }
            } else {
                this.mDrawTimes.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.mInWaitingState = false;
        }
    }

    private void prepare(final Runnable runnable) {
        if (this.drawTask == null) {
            this.drawTask = createDrawTask(this.mDanmakuView.isDanmakuDrawingCacheEnabled(), this.timer, this.mDanmakuView.getContext(), this.mDanmakuView.getWidth(), this.mDanmakuView.getHeight(), this.mDanmakuView.isHardwareAccelerated(), new IDrawTask.TaskListener() { // from class: com.youku.danmaku.engine.controller.DrawHandler.3
                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakuAdd(BaseDanmaku baseDanmaku) {
                    if (baseDanmaku.isTimeOut()) {
                        return;
                    }
                    long j = baseDanmaku.time - DrawHandler.this.timer.currMillisecond;
                    if (j >= DrawHandler.this.mContext.mDanmakuFactory.mMaxDanmakuDuration || (!DrawHandler.this.mInWaitingState && !DrawHandler.this.mRenderingState.nothingRendered)) {
                        if (j <= 0 || j > DrawHandler.this.mContext.mDanmakuFactory.mMaxDanmakuDuration) {
                            return;
                        }
                        DrawHandler.this.sendEmptyMessageDelayed(11, j);
                        return;
                    }
                    DrawHandler.this.notifyRendering();
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakuConfigChanged() {
                    DrawHandler.this.redrawIfNeeded();
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakuShown(BaseDanmaku baseDanmaku) {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.danmakuShown(baseDanmaku);
                    }
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakusDrawingFinished() {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.drawingFinished();
                    }
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void ready() {
                    DrawHandler.this.initRenderingConfigs();
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private synchronized void quitUpdateThread() {
        UpdateThread updateThread = this.mThread;
        this.mThread = null;
        if (updateThread != null) {
            synchronized (this.drawTask) {
                this.drawTask.notifyAll();
            }
            updateThread.quit();
            try {
                updateThread.join(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void recordRenderingTime() {
        try {
            this.mDrawTimes.addLast(Long.valueOf(SystemClock.uptimeMillis()));
            if (this.mDrawTimes.size() > 500) {
                this.mDrawTimes.pollFirst();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redrawIfNeeded() {
        if (this.quitFlag && this.mDanmakusVisible) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long syncTimer(long j) {
        long j2 = 0;
        if (!this.mInSeekingAction && !this.mInSyncAction) {
            this.mInSyncAction = true;
            long j3 = j - this.mTimeBase;
            if (this.mDanmakusVisible && !this.mRenderingState.nothingRendered && !this.mInWaitingState) {
                long j4 = j3 - this.timer.currMillisecond;
                long max = Math.max(this.mFrameUpdateRate, getAverageRenderingTime());
                if (j4 <= 2000) {
                    long j5 = this.mRenderingState.consumingTime;
                    long j6 = this.mCordonTime;
                    if (j5 <= j6 && max <= j6) {
                        long j7 = this.mFrameUpdateRate;
                        long min = Math.min(this.mCordonTime, Math.max(j7, max + (j4 / j7)));
                        long j8 = this.mLastDeltaTime;
                        long j9 = min - j8;
                        if (j9 > 3 && j9 < 8 && j8 >= this.mFrameUpdateRate && j8 <= this.mCordonTime) {
                            min = j8;
                        }
                        long j10 = j4 - min;
                        this.mLastDeltaTime = min;
                        j4 = min;
                        j2 = j10;
                    }
                }
                this.mRemainingTime = j2;
                this.timer.add(j4);
                j2 = j4;
            } else {
                this.timer.update(j3);
                this.mRemainingTime = 0L;
            }
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.updateTimer(this.timer);
            }
            this.mInSyncAction = false;
        }
        return j2;
    }

    private void syncTimerIfNeeded() {
        if (this.mInWaitingState) {
            syncTimer(SystemClock.uptimeMillis());
        }
    }

    private void updateDanmakus() {
        byte b = this.mUpdateMethod;
        if (b == 0) {
            updateInChoreographer();
        } else if (b == 1) {
            updateInNewThread();
        } else if (b == 2) {
            updateInCurrentThread();
        }
    }

    @TargetApi(16)
    private void updateInChoreographer() {
        if (this.quitFlag) {
            return;
        }
        try {
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
            if (syncTimer(SystemClock.uptimeMillis()) < 0) {
                removeMessages(2);
                return;
            }
            long drawDanmakus = this.mDanmakuView.drawDanmakus();
            removeMessages(2);
            if (drawDanmakus > this.mCordonTime2) {
                this.timer.add(drawDanmakus);
                this.mDrawTimes.clear();
            }
            if (!this.mDanmakusVisible) {
                waitRendering(10000000L);
                return;
            }
            IRenderer.RenderingState renderingState = this.mRenderingState;
            if (renderingState.nothingRendered && this.mIdleSleep) {
                long j = renderingState.endTime - this.timer.currMillisecond;
                if (j > 500) {
                    waitRendering(j - 10);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("DrawHandler", "Choreographer is error! use UPDATE_IN_NEW_THREAD");
            loge("YKDanmaku.update", "Choreographer is error: " + e.getMessage(), "other");
            this.mUpdateMethod = (byte) 1;
            this.mUpdateInSeparateThread = true;
            updateInNewThread();
        }
    }

    private void updateInCurrentThread() {
        if (this.quitFlag) {
            return;
        }
        long syncTimer = syncTimer(SystemClock.uptimeMillis());
        if (syncTimer < 0) {
            removeMessages(2);
            sendEmptyMessageDelayed(2, 60 - syncTimer);
            return;
        }
        long drawDanmakus = this.mDanmakuView.drawDanmakus();
        removeMessages(2);
        if (drawDanmakus > this.mCordonTime2) {
            this.timer.add(drawDanmakus);
            this.mDrawTimes.clear();
        }
        if (!this.mDanmakusVisible) {
            waitRendering(10000000L);
            return;
        }
        IRenderer.RenderingState renderingState = this.mRenderingState;
        if (renderingState.nothingRendered && this.mIdleSleep) {
            long j = renderingState.endTime - this.timer.currMillisecond;
            if (j > 500) {
                waitRendering(j - 10);
                return;
            }
        }
        long j2 = this.mFrameUpdateRate;
        if (drawDanmakus < j2) {
            sendEmptyMessageDelayed(2, j2 - drawDanmakus);
        } else {
            sendEmptyMessage(2);
        }
    }

    private void updateInNewThread() {
        if (this.mThread != null) {
            return;
        }
        UpdateThread updateThread = new UpdateThread("DFM Update") { // from class: com.youku.danmaku.engine.controller.DrawHandler.2
            @Override // com.youku.danmaku.engine.controller.UpdateThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                while (!isQuited() && !DrawHandler.this.quitFlag) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    if (DrawHandler.this.mFrameUpdateRate - (SystemClock.uptimeMillis() - uptimeMillis) <= 1) {
                        long syncTimer = DrawHandler.this.syncTimer(uptimeMillis2);
                        if (syncTimer >= 0) {
                            long drawDanmakus = DrawHandler.this.mDanmakuView.drawDanmakus();
                            if (drawDanmakus > DrawHandler.this.mCordonTime2) {
                                DrawHandler.this.timer.add(drawDanmakus);
                                DrawHandler.this.mDrawTimes.clear();
                            }
                            if (!DrawHandler.this.mDanmakusVisible) {
                                DrawHandler.this.waitRendering(10000000L);
                            } else if (DrawHandler.this.mRenderingState.nothingRendered && DrawHandler.this.mIdleSleep) {
                                long j = DrawHandler.this.mRenderingState.endTime - DrawHandler.this.timer.currMillisecond;
                                if (j > 500) {
                                    DrawHandler.this.notifyRendering();
                                    DrawHandler.this.waitRendering(j - 10);
                                }
                            }
                        } else {
                            SystemClock.sleep(60 - syncTimer);
                        }
                        uptimeMillis = uptimeMillis2;
                    } else {
                        SystemClock.sleep(1L);
                    }
                }
            }
        };
        this.mThread = updateThread;
        updateThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitRendering(long j) {
        if (isStop() || !isPrepared() || this.mInSeekingAction) {
            return;
        }
        this.mRenderingState.sysTime = SystemClock.uptimeMillis();
        this.mInWaitingState = true;
        if (!this.mUpdateInSeparateThread) {
            if (j == 10000000) {
                removeMessages(11);
                removeMessages(2);
                return;
            }
            removeMessages(11);
            removeMessages(2);
            sendEmptyMessageDelayed(11, j);
        } else if (this.mThread == null) {
        } else {
            try {
                synchronized (this.drawTask) {
                    if (j == 10000000) {
                        this.drawTask.wait();
                    } else {
                        this.drawTask.wait(j);
                    }
                    sendEmptyMessage(11);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void addDanmaku(BaseDanmaku baseDanmaku) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null && iDanmakuSettingPlugin.isEnableVideoSpeed()) {
            addDanmakuForNew(baseDanmaku);
        } else {
            addDanmakuForOld(baseDanmaku);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void clearDanmakusOnScreen() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null && (iDanmakuSettingPlugin.isNewTypesetting() || this.mDanmakuSettingPlugin.isNewCompose())) {
            IDrawTask iDrawTask = this.drawTask;
            if (iDrawTask != null) {
                iDrawTask.clearDanmakusOnScreen(getCurrentTime());
                return;
            }
            return;
        }
        obtainMessage(13).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public IRenderer.RenderingState draw(Canvas canvas) {
        if (this.drawTask == null) {
            return this.mRenderingState;
        }
        this.mDisp.setExtraData(canvas);
        this.mRenderingState.set(this.drawTask.draw(this.mDisp));
        recordRenderingTime();
        return this.mRenderingState;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public DanmakuContext getConfig() {
        return this.mContext;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public long getCurrentTime() {
        long j;
        long j2;
        if (this.mReady) {
            if (this.mInSeekingAction) {
                return this.mDesireSeekingTime;
            }
            if (!this.quitFlag && this.mInWaitingState) {
                j = SystemClock.uptimeMillis();
                j2 = this.mTimeBase;
            } else {
                j = this.timer.currMillisecond;
                j2 = this.mRemainingTime;
            }
            return j - j2;
        }
        return 0L;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public IDanmakus getCurrentVisibleDanmakus() {
        if (this.drawTask != null) {
            return this.drawTask.getVisibleDanmakusOnTime(getCurrentTime());
        }
        return null;
    }

    public IDisplayer getDisplayer() {
        return this.mDisp;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public IRenderer.RenderingState getRenderingState() {
        return this.mRenderingState;
    }

    public boolean getVisibility() {
        return this.mDanmakusVisible;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b7  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.controller.DrawHandler.handleMessage(android.os.Message):void");
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean hasDanmakusBySecond(long j) {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            return iDrawTask.hasDanmakusBySecond(j);
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public long hideDanmakus(boolean z) {
        if (!this.mDanmakusVisible) {
            return this.timer.currMillisecond;
        }
        this.mDanmakusVisible = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.timer.currMillisecond;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null && baseDanmaku != null) {
            iDrawTask.invalidateDanmaku(baseDanmaku, z);
        }
        redrawIfNeeded();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isDanmakusVisible() {
        return this.mDanmakusVisible;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isPrepared() {
        return this.mReady;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isResume() {
        return true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isStop() {
        return this.quitFlag;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void notifyDispSizeChanged(int i, int i2) {
        AbsDisplayer absDisplayer = this.mDisp;
        if (absDisplayer == null) {
            return;
        }
        if (absDisplayer.getWidth() == i && this.mDisp.getHeight() == i2) {
            return;
        }
        this.mDisp.setSize(i, i2);
        obtainMessage(10, Boolean.TRUE).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void pause() {
        removeMessages(3);
        syncTimerIfNeeded();
        sendEmptyMessage(7);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void quit() {
        sendEmptyMessage(6);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void removeAllDanmakus() {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllDanmakus();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void removeAllLiveDanmakus() {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllLiveDanmakus();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void resume() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean screenHasData() {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            return iDrawTask.screenHasData();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void seekTo(Long l) {
        this.mInSeekingAction = true;
        this.mDesireSeekingTime = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        SeekModel seekModel = new SeekModel();
        seekModel.time = l.longValue();
        seekModel.type = 0;
        obtainMessage(4, seekModel).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void seekToNoTime(Long l) {
        this.mInSeekingAction = true;
        this.mDesireSeekingTime = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        SeekModel seekModel = new SeekModel();
        seekModel.time = l.longValue();
        seekModel.type = 1;
        obtainMessage(4, seekModel).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void setConfig(DanmakuContext danmakuContext) {
        this.mContext = danmakuContext;
        this.mDanmakuMonitorPlugin = danmakuContext.getDanmakuMonitorPlugin();
        this.mDanmakuSettingPlugin = this.mContext.getDanmakuSettingPlugin();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void setParser(BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void showDanmakus(Long l) {
        if (this.mDanmakusVisible) {
            return;
        }
        this.mDanmakusVisible = true;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(8, l).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void addDanmaku(List<BaseDanmaku> list) {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.addDanmakuList(list, getCurrentTime(), this.mContext.mGlobalFlagValues, this.timer);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void prepare() {
        sendEmptyMessage(5);
    }
}
