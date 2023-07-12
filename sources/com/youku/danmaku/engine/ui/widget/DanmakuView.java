package com.youku.danmaku.engine.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import com.youku.danmaku.engine.controller.DrawHandler;
import com.youku.danmaku.engine.controller.DrawHandlerNew;
import com.youku.danmaku.engine.controller.DrawHelper;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.controller.IDanmakuViewController;
import com.youku.danmaku.engine.controller.IDrawHandler;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import com.youku.danmaku.plugin.DanmakuDataEngine;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuView extends View implements IDanmakuView, IDanmakuViewController {
    private static final int MAX_RECORD_SIZE = 50;
    private static final int ONE_SECOND = 1000;
    public static final String TAG = "DanmakuView";
    private IDrawHandler handler;
    private boolean isSurfaceCreated;
    private DrawHandler.Callback mCallback;
    private boolean mClearFlag;
    private DanmakuDataEngine mDanmakuDataEngine;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private boolean mDanmakuVisible;
    private boolean mDrawFinished;
    private Object mDrawMonitor;
    private LinkedList<Long> mDrawTimes;
    protected int mDrawingThreadType;
    private boolean mEnableDanmakuDrwaingCache;
    private int mFrameRate;
    private HandlerThread mHandlerThread;
    private IDanmakuView.OnDanmakuClickListener mOnDanmakuClickListener;
    private long mPreFrameTime;
    private Rect mRect;
    private boolean mRequestRender;
    private Runnable mResumeRunnable;
    private int mResumeTryCount;
    private boolean mShowFps;
    private List<Integer> mTotalFrameRate;
    private DanmakuTouchHelper mTouchHelper;
    private long mUiThreadId;
    private boolean mWaitDrawing;

    public DanmakuView(Context context) {
        super(context);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = false;
        this.mDrawingThreadType = 0;
        this.mDrawMonitor = new Object();
        this.mDrawFinished = false;
        this.mRequestRender = false;
        this.mWaitDrawing = false;
        this.mPreFrameTime = -1L;
        this.mFrameRate = 0;
        this.mTotalFrameRate = new ArrayList();
        this.mResumeTryCount = 0;
        this.mResumeRunnable = new Runnable() { // from class: com.youku.danmaku.engine.ui.widget.DanmakuView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.handler == null) {
                    return;
                }
                DanmakuView.access$408(DanmakuView.this);
                if (DanmakuView.this.mResumeTryCount > 4 || DanmakuView.super.isShown()) {
                    if (DanmakuView.this.handler != null) {
                        DanmakuView.this.handler.resume();
                    }
                } else if (DanmakuView.this.handler instanceof Handler) {
                    ((Handler) DanmakuView.this.handler).postDelayed(this, DanmakuView.this.mResumeTryCount * 100);
                }
            }
        };
        init();
    }

    static /* synthetic */ int access$108(DanmakuView danmakuView) {
        int i = danmakuView.mFrameRate;
        danmakuView.mFrameRate = i + 1;
        return i;
    }

    static /* synthetic */ int access$408(DanmakuView danmakuView) {
        int i = danmakuView.mResumeTryCount;
        danmakuView.mResumeTryCount = i + 1;
        return i;
    }

    private boolean checkClickValid(MotionEvent motionEvent) {
        return this.mRect == null || motionEvent.getY() <= ((float) this.mRect.bottom);
    }

    private float fps() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mDrawTimes.addLast(Long.valueOf(uptimeMillis));
        float longValue = (float) (uptimeMillis - this.mDrawTimes.getFirst().longValue());
        if (this.mDrawTimes.size() > 50) {
            this.mDrawTimes.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.mDrawTimes.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    private void init() {
        this.mUiThreadId = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        DrawHelper.useDrawColorToClearCanvas(true, false);
        this.mTouchHelper = DanmakuTouchHelper.instance(this);
        DanmakuEngineContext.setDensity(getResources().getDisplayMetrics().density);
        this.mDanmakuDataEngine = new DanmakuDataEngine(this);
    }

    private void lockCanvas() {
        IDrawHandler iDrawHandler;
        if (this.mDanmakuVisible) {
            postInvalidateCompat();
            synchronized (this.mDrawMonitor) {
                this.mWaitDrawing = false;
                while (!this.mDrawFinished && this.handler != null) {
                    this.mWaitDrawing = true;
                    try {
                        this.mDrawMonitor.wait(200L);
                    } catch (InterruptedException unused) {
                        if (!this.mDanmakuVisible || (iDrawHandler = this.handler) == null || iDrawHandler.isStop()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.mWaitDrawing = false;
                this.mDrawFinished = false;
            }
        }
    }

    private void lockCanvasAndClear() {
        this.mClearFlag = true;
        lockCanvas();
    }

    @SuppressLint({"NewApi"})
    private void postInvalidateCompat() {
        this.mRequestRender = true;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidate();
        }
    }

    private void prepare() {
        if (this.handler == null) {
            IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
            if (iDanmakuSettingPlugin != null ? iDanmakuSettingPlugin.isNewHandler() : false) {
                this.handler = new DrawHandlerNew(getLooper(this.mDrawingThreadType), this, this.mDanmakuVisible);
            } else {
                this.handler = new DrawHandler(getLooper(this.mDrawingThreadType), this, this.mDanmakuVisible);
            }
            if (Log.isDebug()) {
                Log.d("DanmakuView prepare -> handler=" + this.handler.hashCode());
            }
        }
    }

    private void recodeDrawJank() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.youku.danmaku.engine.ui.widget.DanmakuView.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                long currentTimeMillis = System.currentTimeMillis() - DanmakuView.this.mPreFrameTime;
                if (currentTimeMillis >= 1000) {
                    if (currentTimeMillis <= 1100 && DanmakuView.this.mFrameRate > 0) {
                        DanmakuView.this.mTotalFrameRate.add(Integer.valueOf(DanmakuView.this.mFrameRate));
                    }
                    DanmakuView.this.mFrameRate = 0;
                    DanmakuView.this.mPreFrameTime = System.currentTimeMillis();
                    return;
                }
                DanmakuView.access$108(DanmakuView.this);
            }
        });
    }

    private void releasePlugin() {
        this.mDanmakuDataEngine = null;
    }

    private void stopDraw() {
        unlockCanvasAndPost();
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.quit();
            this.handler = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            this.mHandlerThread = null;
            try {
                handlerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    private void unlockCanvasAndPost() {
        synchronized (this.mDrawMonitor) {
            this.mDrawFinished = true;
            this.mDrawMonitor.notifyAll();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean addDanmaku(BaseDanmaku baseDanmaku) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.addDanmaku(baseDanmaku);
            return true;
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean addDanmakuList(List<BaseDanmaku> list) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.addDanmaku(list);
            return true;
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuViewController
    public void clear() {
        if (isViewReady()) {
            if (this.mDanmakuVisible && Thread.currentThread().getId() != this.mUiThreadId) {
                lockCanvasAndClear();
                return;
            }
            this.mClearFlag = true;
            postInvalidateCompat();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void clearDanmakusOnScreen() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.clearDanmakusOnScreen();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (checkClickValid(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuViewController
    public long drawDanmakus() {
        if (this.isSurfaceCreated) {
            if (isShown()) {
                long uptimeMillis = SystemClock.uptimeMillis();
                lockCanvas();
                return SystemClock.uptimeMillis() - uptimeMillis;
            }
            return -1L;
        }
        return 0L;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void enableDanmakuDrawingCache(boolean z) {
        this.mEnableDanmakuDrwaingCache = z;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public Rect getClipRect() {
        return this.mRect;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public DanmakuContext getConfig() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler == null) {
            return null;
        }
        return iDrawHandler.getConfig();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public IDanmakus getCurrentClickDanmakus(float f, float f2) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.getCurrentVisibleDanmakus();
        }
        return null;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public long getCurrentTime() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.getCurrentTime();
        }
        return 0L;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public IDanmakus getCurrentVisibleDanmakus() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.getCurrentVisibleDanmakus();
        }
        return null;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public DanmakuDataEngine getDanmakuDataEngine() {
        return this.mDanmakuDataEngine;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public int getDrawHandlerVisible() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.isDanmakusVisible() ? 1 : 0;
        }
        return -1;
    }

    protected Looper getLooper(int i) {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
        if (i != 1) {
            int i2 = i != 2 ? i != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DMViewHandlerThread#" + i2, i2);
            this.mHandlerThread = handlerThread2;
            handlerThread2.start();
            return this.mHandlerThread.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public List<Integer> getMSValueList() {
        return this.mTotalFrameRate;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public IDanmakuView.OnDanmakuClickListener getOnDanmakuClickListener() {
        return this.mOnDanmakuClickListener;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public View getView() {
        return this;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean hasDanmakusBySecond(long j) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.hasDanmakusBySecond(j);
        }
        return true;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void hide() {
        this.mDanmakuVisible = false;
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler == null) {
            return;
        }
        iDrawHandler.hideDanmakus(false);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public long hideAndPauseDrawTask() {
        this.mDanmakuVisible = false;
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler == null) {
            return 0L;
        }
        return iDrawHandler.hideDanmakus(true);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.invalidateDanmaku(baseDanmaku, z);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView, com.youku.danmaku.engine.controller.IDanmakuViewController
    public boolean isDanmakuDrawingCacheEnabled() {
        return this.mEnableDanmakuDrwaingCache;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isDanmakuVisible() {
        return this.mDanmakuVisible;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isDrawing() {
        IDrawHandler iDrawHandler = this.handler;
        return (iDrawHandler == null || iDrawHandler.getRenderingState() == null || this.handler.getRenderingState().nothingRendered) ? false : true;
    }

    @Override // android.view.View, com.youku.danmaku.engine.controller.IDanmakuView, com.youku.danmaku.engine.controller.IDanmakuViewController
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.isHardwareAccelerated();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isPaused() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.isStop();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isPrepared() {
        IDrawHandler iDrawHandler = this.handler;
        return iDrawHandler != null && iDrawHandler.isPrepared();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isResume() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.isResume();
        }
        return false;
    }

    @Override // android.view.View, com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isShown() {
        return this.mDanmakuVisible && super.isShown();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuViewController
    public boolean isViewReady() {
        return this.isSurfaceCreated;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mDanmakuVisible && !this.mRequestRender) {
            super.onDraw(canvas);
        } else if (this.mClearFlag) {
            DrawHelper.clearCanvas(canvas);
            this.mClearFlag = false;
            this.mRequestRender = false;
            if (this.mWaitDrawing) {
                unlockCanvasAndPost();
            }
        } else {
            if (this.handler != null) {
                canvas.save();
                Rect rect = this.mRect;
                if (rect != null) {
                    canvas.clipRect(rect);
                }
                IRenderer.RenderingState draw = this.handler.draw(canvas);
                canvas.restore();
                recodeDrawJank();
                if (this.mShowFps) {
                    if (this.mDrawTimes == null) {
                        this.mDrawTimes = new LinkedList<>();
                    }
                    DrawHelper.drawFPS(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(fps()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(draw.cacheHitCount), Long.valueOf(draw.cacheMissCount)));
                }
            }
            this.mRequestRender = false;
            unlockCanvasAndPost();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.notifyDispSizeChanged(i3 - i, i4 - i2);
        }
        this.isSurfaceCreated = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchHelper != null && checkClickValid(motionEvent)) {
            this.mTouchHelper.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void pause() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.pause();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void release() {
        this.mTotalFrameRate.clear();
        stop();
        LinkedList<Long> linkedList = this.mDrawTimes;
        if (linkedList != null) {
            linkedList.clear();
        }
        releasePlugin();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void removeAllDanmakus() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.removeAllDanmakus();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void removeAllLiveDanmakus() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.removeAllLiveDanmakus();
        }
    }

    public void restart() {
        stop();
        start();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void resume() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null && iDrawHandler.isPrepared()) {
            this.mResumeTryCount = 0;
            ((Handler) this.handler).post(this.mResumeRunnable);
        } else if (this.handler == null) {
            restart();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean screenHasData() {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            return iDrawHandler.screenHasData();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void seekTo(Long l) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.seekTo(l);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void seekToNoTime(Long l) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.seekToNoTime(l);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void setCallback(DrawHandler.Callback callback) {
        this.mCallback = callback;
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.setCallback(callback);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void setClipRect(Rect rect) {
        this.mRect = rect;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void setDrawingThreadType(int i) {
        this.mDrawingThreadType = i;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void setOnDanmakuClickListener(IDanmakuView.OnDanmakuClickListener onDanmakuClickListener) {
        this.mOnDanmakuClickListener = onDanmakuClickListener;
        setClickable(onDanmakuClickListener != null);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void show() {
        showAndResumeDrawTask(null);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void showAndResumeDrawTask(Long l) {
        this.mDanmakuVisible = true;
        this.mClearFlag = false;
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler == null) {
            return;
        }
        iDrawHandler.showDanmakus(l);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void showFPS(boolean z) {
        this.mShowFps = z;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void start() {
        start(0L);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void stop() {
        stopDraw();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void toggle() {
        if (this.isSurfaceCreated) {
            IDrawHandler iDrawHandler = this.handler;
            if (iDrawHandler == null) {
                start();
            } else if (iDrawHandler.isStop()) {
                resume();
            } else {
                pause();
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void start(long j) {
        if (Log.isDebug()) {
            Log.d("DanmakuView start -> begin");
        }
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler == null) {
            prepare();
        } else {
            ((Handler) iDrawHandler).removeCallbacksAndMessages(null);
        }
        IDrawHandler iDrawHandler2 = this.handler;
        if (iDrawHandler2 instanceof Handler) {
            ((Handler) iDrawHandler2).obtainMessage(1, Long.valueOf(j)).sendToTarget();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z, int i) {
        IDrawHandler iDrawHandler = this.handler;
        if (iDrawHandler != null) {
            iDrawHandler.invalidateDanmaku(baseDanmaku, z);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void prepare(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext) {
        this.mDanmakuSettingPlugin = danmakuContext.getDanmakuSettingPlugin();
        prepare();
        this.handler.setConfig(danmakuContext);
        this.handler.setParser(baseDanmakuParser);
        this.handler.setCallback(this.mCallback);
        this.handler.prepare();
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = false;
        this.mDrawingThreadType = 0;
        this.mDrawMonitor = new Object();
        this.mDrawFinished = false;
        this.mRequestRender = false;
        this.mWaitDrawing = false;
        this.mPreFrameTime = -1L;
        this.mFrameRate = 0;
        this.mTotalFrameRate = new ArrayList();
        this.mResumeTryCount = 0;
        this.mResumeRunnable = new Runnable() { // from class: com.youku.danmaku.engine.ui.widget.DanmakuView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.handler == null) {
                    return;
                }
                DanmakuView.access$408(DanmakuView.this);
                if (DanmakuView.this.mResumeTryCount > 4 || DanmakuView.super.isShown()) {
                    if (DanmakuView.this.handler != null) {
                        DanmakuView.this.handler.resume();
                    }
                } else if (DanmakuView.this.handler instanceof Handler) {
                    ((Handler) DanmakuView.this.handler).postDelayed(this, DanmakuView.this.mResumeTryCount * 100);
                }
            }
        };
        init();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = false;
        this.mDrawingThreadType = 0;
        this.mDrawMonitor = new Object();
        this.mDrawFinished = false;
        this.mRequestRender = false;
        this.mWaitDrawing = false;
        this.mPreFrameTime = -1L;
        this.mFrameRate = 0;
        this.mTotalFrameRate = new ArrayList();
        this.mResumeTryCount = 0;
        this.mResumeRunnable = new Runnable() { // from class: com.youku.danmaku.engine.ui.widget.DanmakuView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DanmakuView.this.handler == null) {
                    return;
                }
                DanmakuView.access$408(DanmakuView.this);
                if (DanmakuView.this.mResumeTryCount > 4 || DanmakuView.super.isShown()) {
                    if (DanmakuView.this.handler != null) {
                        DanmakuView.this.handler.resume();
                    }
                } else if (DanmakuView.this.handler instanceof Handler) {
                    ((Handler) DanmakuView.this.handler).postDelayed(this, DanmakuView.this.mResumeTryCount * 100);
                }
            }
        };
        init();
    }
}
