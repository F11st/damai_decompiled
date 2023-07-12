package com.youku.danmaku.engine.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.youku.danmaku.engine.controller.DrawHandler;
import com.youku.danmaku.engine.controller.DrawHelper;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.controller.IDanmakuViewController;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import com.youku.danmaku.plugin.DanmakuDataEngine;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class DanmakuTextureView extends TextureView implements TextureView.SurfaceTextureListener, IDanmakuView, IDanmakuViewController {
    private static final int MAX_RECORD_SIZE = 50;
    private static final int ONE_SECOND = 1000;
    public static final String TAG = "DanmakuTextureView";
    private DrawHandler handler;
    private boolean isSurfaceCreated;
    private DrawHandler.Callback mCallback;
    private DanmakuDataEngine mDanmakuDataEngine;
    private boolean mDanmakuVisible;
    private LinkedList<Long> mDrawTimes;
    protected int mDrawingThreadType;
    private boolean mEnableDanmakuDrwaingCache;
    private HandlerThread mHandlerThread;
    private IDanmakuView.OnDanmakuClickListener mOnDanmakuClickListener;
    private boolean mShowFps;
    private DanmakuTouchHelper mTouchHelper;

    public DanmakuTextureView(Context context) {
        super(context);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = true;
        this.mDrawingThreadType = 0;
        init();
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

    @TargetApi(11)
    private void init() {
        setLayerType(2, null);
        setOpaque(false);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        setSurfaceTextureListener(this);
        DrawHelper.useDrawColorToClearCanvas(true, true);
        this.mTouchHelper = DanmakuTouchHelper.instance(this);
        this.mDanmakuDataEngine = new DanmakuDataEngine(this);
    }

    private void prepare() {
        if (this.handler == null) {
            this.handler = new DrawHandler(getLooper(this.mDrawingThreadType), this, this.mDanmakuVisible);
        }
    }

    private void releasePlugin() {
        this.mDanmakuDataEngine = null;
    }

    private void stopDraw() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.quit();
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

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean addDanmaku(BaseDanmaku baseDanmaku) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.addDanmaku(baseDanmaku);
            return true;
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean addDanmakuList(List<BaseDanmaku> list) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.addDanmaku(list);
            return true;
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuViewController
    public synchronized void clear() {
        if (isViewReady()) {
            Canvas lockCanvas = lockCanvas();
            if (lockCanvas != null) {
                DrawHelper.clearCanvas(lockCanvas);
                unlockCanvasAndPost(lockCanvas);
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void clearDanmakusOnScreen() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.clearDanmakusOnScreen();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuViewController
    public synchronized long drawDanmakus() {
        if (this.isSurfaceCreated) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (isShown()) {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    DrawHandler drawHandler = this.handler;
                    if (drawHandler != null) {
                        IRenderer.RenderingState draw = drawHandler.draw(lockCanvas);
                        if (this.mShowFps) {
                            if (this.mDrawTimes == null) {
                                this.mDrawTimes = new LinkedList<>();
                            }
                            SystemClock.uptimeMillis();
                            DrawHelper.drawFPS(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(fps()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(draw.cacheHitCount), Long.valueOf(draw.cacheMissCount)));
                        }
                    }
                    if (this.isSurfaceCreated) {
                        unlockCanvasAndPost(lockCanvas);
                    }
                }
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
        return null;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public DanmakuContext getConfig() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return null;
        }
        return drawHandler.getConfig();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public IDanmakus getCurrentClickDanmakus(float f, float f2) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.getCurrentVisibleDanmakus();
        }
        return null;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public long getCurrentTime() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.getCurrentTime();
        }
        return 0L;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public IDanmakus getCurrentVisibleDanmakus() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.getCurrentVisibleDanmakus();
        }
        return null;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public DanmakuDataEngine getDanmakuDataEngine() {
        return this.mDanmakuDataEngine;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public int getDrawHandlerVisible() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.isDanmakusVisible() ? 1 : 0;
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
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i2, i2);
            this.mHandlerThread = handlerThread2;
            handlerThread2.start();
            return this.mHandlerThread.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public List<Integer> getMSValueList() {
        return null;
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
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.hasDanmakusBySecond(j);
        }
        return true;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void hide() {
        this.mDanmakuVisible = false;
        DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return;
        }
        drawHandler.hideDanmakus(false);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public long hideAndPauseDrawTask() {
        this.mDanmakuVisible = false;
        DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return 0L;
        }
        return drawHandler.hideDanmakus(true);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.invalidateDanmaku(baseDanmaku, z);
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
        DrawHandler drawHandler = this.handler;
        return (drawHandler == null || drawHandler.getRenderingState() == null || this.handler.getRenderingState().nothingRendered) ? false : true;
    }

    @Override // android.view.View, com.youku.danmaku.engine.controller.IDanmakuView, com.youku.danmaku.engine.controller.IDanmakuViewController
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isPaused() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.isStop();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isPrepared() {
        DrawHandler drawHandler = this.handler;
        return drawHandler != null && drawHandler.isPrepared();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean isResume() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            return drawHandler.isResume();
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

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.isSurfaceCreated = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.isSurfaceCreated = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.notifyDispSizeChanged(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DanmakuTouchHelper danmakuTouchHelper = this.mTouchHelper;
        if (danmakuTouchHelper != null) {
            danmakuTouchHelper.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void pause() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.pause();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.mDrawTimes;
        if (linkedList != null) {
            linkedList.clear();
        }
        releasePlugin();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void removeAllDanmakus() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.removeAllDanmakus();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void removeAllLiveDanmakus() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.removeAllLiveDanmakus();
        }
    }

    public void restart() {
        stop();
        start();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void resume() {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null && drawHandler.isPrepared()) {
            this.handler.resume();
        } else if (this.handler == null) {
            restart();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public boolean screenHasData() {
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void seekTo(Long l) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.seekTo(l);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void seekToNoTime(Long l) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.seekToNoTime(l);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void setCallback(DrawHandler.Callback callback) {
        this.mCallback = callback;
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.setCallback(callback);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void setClipRect(Rect rect) {
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
        DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            return;
        }
        drawHandler.showDanmakus(l);
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
            DrawHandler drawHandler = this.handler;
            if (drawHandler == null) {
                start();
            } else if (drawHandler.isStop()) {
                resume();
            } else {
                pause();
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void start(long j) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler == null) {
            prepare();
        } else {
            drawHandler.removeCallbacksAndMessages(null);
        }
        this.handler.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z, int i) {
        DrawHandler drawHandler = this.handler;
        if (drawHandler != null) {
            drawHandler.invalidateDanmaku(baseDanmaku, z);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDanmakuView
    public void prepare(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext) {
        prepare();
        this.handler.setConfig(danmakuContext);
        this.handler.setParser(baseDanmakuParser);
        this.handler.setCallback(this.mCallback);
        this.handler.prepare();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = true;
        this.mDrawingThreadType = 0;
        init();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableDanmakuDrwaingCache = true;
        this.mDanmakuVisible = true;
        this.mDrawingThreadType = 0;
        init();
    }
}
