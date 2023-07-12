package com.youku.danmaku.engine.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.ICacheManager;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDrawingCache;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCache;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCachePoolManager;
import com.youku.danmaku.engine.danmaku.model.objectpool.Pool;
import com.youku.danmaku.engine.danmaku.model.objectpool.Pools;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import tv.cjump.jni.NativeBitmapFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CacheManagingDrawTask extends DrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_CACHE_SCREEN_SIZE = 3;
    private CacheManager mCacheManager;
    private DanmakuTimer mCacheTimer;
    private final Object mDrawingNotify;
    private int mMaxCacheSize;
    private int mRemainingCacheCount;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class CacheManager implements ICacheManager {
        public static final byte RESULT_FAILED = 1;
        public static final byte RESULT_FAILED_OVERSIZE = 2;
        public static final byte RESULT_SUCCESS = 0;
        private static final String TAG = "CacheManager";
        Pool<DrawingCache> mCachePool;
        DrawingCachePoolManager mCachePoolManager;
        Danmakus mCaches = new Danmakus();
        private boolean mEndFlag;
        private CacheHandler mHandler;
        private int mMaxSize;
        private int mRealSize;
        private int mScreenSize;
        public HandlerThread mThread;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public class CacheHandler extends Handler {
            public static final int ADD_DANMAKKU = 2;
            public static final int BUILD_CACHES = 3;
            public static final int CLEAR_ALL_CACHES = 7;
            public static final int CLEAR_OUTSIDE_CACHES = 8;
            public static final int CLEAR_OUTSIDE_CACHES_AND_RESET = 9;
            public static final int CLEAR_TIMEOUT_CACHES = 4;
            public static final int DISABLE_CANCEL_FLAG = 18;
            public static final int DISPATCH_ACTIONS = 16;
            private static final int PREPARE = 1;
            public static final int QUIT = 6;
            public static final int REBUILD_CACHE = 17;
            public static final int SEEK = 5;
            private boolean mCancelFlag;
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean mSeekedFlag;

            public CacheHandler(Looper looper) {
                super(looper);
            }

            private void addDanmakuAndBuildCache(BaseDanmaku baseDanmaku) {
                if (baseDanmaku.isTimeOut()) {
                    return;
                }
                if (baseDanmaku.time <= CacheManagingDrawTask.this.mCacheTimer.currMillisecond + CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration || baseDanmaku.isLive) {
                    if (baseDanmaku.flags == null) {
                        if (Log.isDebug()) {
                            Log.d(CacheManager.TAG, "danmaku flags is null, text=" + ((Object) baseDanmaku.text) + ", time=" + baseDanmaku.minute + "," + baseDanmaku.second);
                        }
                    } else if ((baseDanmaku.priority == 0 && baseDanmaku.isFiltered()) || baseDanmaku.hasDrawingCache()) {
                    } else {
                        buildCache(baseDanmaku, true);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public byte buildCache(BaseDanmaku baseDanmaku, boolean z) {
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(CacheManagingDrawTask.this.mDisp, true);
                }
                DrawingCache drawingCache = null;
                try {
                    CacheManager cacheManager = CacheManager.this;
                    BaseDanmaku findReuseableCache = cacheManager.findReuseableCache(baseDanmaku, true, CacheManagingDrawTask.this.mContext.cachingPolicy.maxTimesOfStrictReusableFinds);
                    DrawingCache drawingCache2 = findReuseableCache != null ? (DrawingCache) findReuseableCache.cache : null;
                    try {
                        if (drawingCache2 != null) {
                            drawingCache2.increaseReference();
                            baseDanmaku.cache = drawingCache2;
                            CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, 0, z);
                            return (byte) 0;
                        }
                        CacheManager cacheManager2 = CacheManager.this;
                        BaseDanmaku findReuseableCache2 = cacheManager2.findReuseableCache(baseDanmaku, false, CacheManagingDrawTask.this.mContext.cachingPolicy.maxTimesOfReusableFinds);
                        if (findReuseableCache2 != null) {
                            drawingCache2 = (DrawingCache) findReuseableCache2.cache;
                        }
                        if (drawingCache2 != null) {
                            findReuseableCache2.cache = null;
                            CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                            baseDanmaku.cache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask.mDisp, drawingCache2, cacheManagingDrawTask.mContext.cachingPolicy.bitsPerPixelOfCache);
                            CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, 0, z);
                            return (byte) 0;
                        }
                        int cacheSize = DanmakuUtils.getCacheSize((int) baseDanmaku.paintWidth, (int) baseDanmaku.paintHeight, CacheManagingDrawTask.this.mContext.cachingPolicy.bitsPerPixelOfCache / 8);
                        if (cacheSize * 2 > CacheManagingDrawTask.this.mMaxCacheSize) {
                            return (byte) 1;
                        }
                        if (!z && CacheManager.this.mRealSize + cacheSize > CacheManager.this.mMaxSize) {
                            CacheManagingDrawTask.this.mCacheManager.clearTimeOutAndFilteredCaches(cacheSize, false);
                            return (byte) 1;
                        }
                        DrawingCache acquire = CacheManager.this.mCachePool.acquire();
                        CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                        DrawingCache buildDanmakuDrawingCache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask2.mDisp, acquire, cacheManagingDrawTask2.mContext.cachingPolicy.bitsPerPixelOfCache);
                        baseDanmaku.cache = buildDanmakuDrawingCache;
                        boolean push = CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, CacheManager.this.sizeOf(baseDanmaku), z);
                        if (!push) {
                            releaseDanmakuCache(baseDanmaku, buildDanmakuDrawingCache);
                        }
                        return (!push ? 1 : 0) == 1 ? (byte) 1 : (byte) 0;
                    } catch (Exception unused) {
                        drawingCache = drawingCache2;
                        releaseDanmakuCache(baseDanmaku, drawingCache);
                        return (byte) 1;
                    } catch (OutOfMemoryError unused2) {
                        drawingCache = drawingCache2;
                        releaseDanmakuCache(baseDanmaku, drawingCache);
                        return (byte) 1;
                    }
                } catch (Exception unused3) {
                } catch (OutOfMemoryError unused4) {
                }
            }

            private long dispatchAction() {
                long j = CacheManagingDrawTask.this.mCacheTimer.currMillisecond;
                CacheManager cacheManager = CacheManager.this;
                CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                long j2 = cacheManagingDrawTask.mTimer.currMillisecond;
                DanmakuContext danmakuContext = cacheManagingDrawTask.mContext;
                if (j <= j2 - danmakuContext.mDanmakuFactory.mMaxDanmakuDuration) {
                    if (danmakuContext.cachingPolicy.periodOfRecycle != -1) {
                        cacheManager.evictAllNotInScreen();
                    }
                    CacheManagingDrawTask.this.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                    sendEmptyMessage(3);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction BUILD_CACHES");
                    }
                    return 0L;
                }
                float poolPercent = cacheManager.getPoolPercent();
                if (Log.isDebug()) {
                    Log.d(CacheManager.TAG, "getPoolPercent=" + poolPercent + ", mRealSize=" + CacheManager.this.mRealSize + ", mMaxSize=" + CacheManager.this.mMaxSize);
                }
                BaseDanmaku first = CacheManager.this.mCaches.first();
                long j3 = first != null ? first.time - CacheManagingDrawTask.this.mTimer.currMillisecond : 0L;
                CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                long j4 = cacheManagingDrawTask2.mContext.mDanmakuFactory.mMaxDanmakuDuration;
                long j5 = 2 * j4;
                if (poolPercent < 0.6f && j3 > j4) {
                    cacheManagingDrawTask2.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction level < 0.6f BUILD_CACHES");
                    }
                    return 0L;
                } else if (poolPercent > 0.4f && j3 < (-j5)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction CLEAR_TIMEOUT_CACHES");
                    }
                    return 0L;
                } else if (poolPercent >= 0.9f) {
                    return 0L;
                } else {
                    long j6 = cacheManagingDrawTask2.mCacheTimer.currMillisecond - CacheManagingDrawTask.this.mTimer.currMillisecond;
                    if (first != null && first.isTimeOut()) {
                        CacheManagingDrawTask cacheManagingDrawTask3 = CacheManagingDrawTask.this;
                        if (j6 < (-cacheManagingDrawTask3.mContext.mDanmakuFactory.mMaxDanmakuDuration)) {
                            cacheManagingDrawTask3.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                            sendEmptyMessage(8);
                            sendEmptyMessage(3);
                            return 0L;
                        }
                    }
                    if (j6 > j5) {
                        return 0L;
                    }
                    removeMessages(3);
                    sendEmptyMessage(3);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction end BUILD_CACHES");
                    }
                    return 0L;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
                r19.this$1.this$0.mCacheTimer.update(r12);
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
                return 0;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private long prepareCaches(final boolean r20) {
                /*
                    Method dump skipped, instructions count: 224
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.CacheHandler.prepareCaches(boolean):long");
            }

            private void releaseDanmakuCache(BaseDanmaku baseDanmaku, DrawingCache drawingCache) {
                if (drawingCache == null) {
                    drawingCache = (DrawingCache) baseDanmaku.cache;
                }
                baseDanmaku.cache = null;
                if (drawingCache == null) {
                    return;
                }
                drawingCache.destroy();
                CacheManager.this.mCachePool.release(drawingCache);
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
            }

            public boolean createCache(BaseDanmaku baseDanmaku) {
                DrawingCache drawingCache;
                DrawingCache acquire;
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(CacheManagingDrawTask.this.mDisp, true);
                }
                try {
                    acquire = CacheManager.this.mCachePool.acquire();
                } catch (Exception unused) {
                    drawingCache = null;
                } catch (OutOfMemoryError unused2) {
                    drawingCache = null;
                }
                try {
                    CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                    drawingCache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask.mDisp, acquire, cacheManagingDrawTask.mContext.cachingPolicy.bitsPerPixelOfCache);
                    baseDanmaku.cache = drawingCache;
                    return true;
                } catch (Exception unused3) {
                    if (drawingCache != null) {
                        CacheManager.this.mCachePool.release(drawingCache);
                    }
                    baseDanmaku.cache = null;
                    return false;
                } catch (OutOfMemoryError unused4) {
                    if (drawingCache != null) {
                        CacheManager.this.mCachePool.release(drawingCache);
                    }
                    baseDanmaku.cache = null;
                    return false;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:50:0x0159  */
            /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void handleMessage(android.os.Message r10) {
                /*
                    Method dump skipped, instructions count: 538
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.CacheHandler.handleMessage(android.os.Message):void");
            }

            public boolean isPause() {
                return this.mPause;
            }

            public void onPlayStateChanged(boolean z) {
                this.mIsPlayerPause = !z;
            }

            public void pause() {
                this.mPause = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void requestBuildCacheAndDraw(long j) {
                removeMessages(3);
                this.mSeekedFlag = true;
                sendEmptyMessage(18);
                CacheManagingDrawTask.this.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond + j);
                sendEmptyMessage(3);
            }

            public void requestCancelCaching() {
                this.mCancelFlag = true;
            }

            public void resume() {
                sendEmptyMessage(18);
                this.mPause = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
            }
        }

        public CacheManager(int i, int i2) {
            DrawingCachePoolManager drawingCachePoolManager = new DrawingCachePoolManager();
            this.mCachePoolManager = drawingCachePoolManager;
            this.mCachePool = Pools.finitePool(drawingCachePoolManager, 800);
            this.mScreenSize = 3;
            this.mEndFlag = false;
            this.mRealSize = 0;
            this.mMaxSize = i;
            this.mScreenSize = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long clearCache(BaseDanmaku baseDanmaku) {
            IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
            if (iDrawingCache == null) {
                return 0L;
            }
            if (iDrawingCache.hasReferences()) {
                iDrawingCache.decreaseReference();
                baseDanmaku.cache = null;
                return 0L;
            }
            long sizeOf = sizeOf(baseDanmaku);
            iDrawingCache.destroy();
            baseDanmaku.cache = null;
            return sizeOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCachePool() {
            while (true) {
                DrawingCache acquire = this.mCachePool.acquire();
                if (acquire == null) {
                    return;
                }
                acquire.destroy();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeOutAndFilteredCaches(final int i, final boolean z) {
            this.mCaches.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.5
                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public int accept(BaseDanmaku baseDanmaku) {
                    if (!CacheManager.this.mEndFlag && CacheManager.this.mRealSize + i > CacheManager.this.mMaxSize) {
                        if (!baseDanmaku.isTimeOut() && !baseDanmaku.isFiltered()) {
                            return z ? 1 : 0;
                        }
                        CacheManager.this.entryRemoved(false, baseDanmaku, null);
                        return 2;
                    }
                    return 1;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeOutCaches() {
            this.mCaches.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.3
                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public int accept(BaseDanmaku baseDanmaku) {
                    if (baseDanmaku.isTimeOut()) {
                        IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
                        if (CacheManagingDrawTask.this.mContext.cachingPolicy.periodOfRecycle != -1 || iDrawingCache == null || iDrawingCache.hasReferences() || iDrawingCache.size() / CacheManagingDrawTask.this.mMaxCacheSize >= CacheManagingDrawTask.this.mContext.cachingPolicy.forceRecyleThreshold) {
                            if (!CacheManager.this.mEndFlag) {
                                synchronized (CacheManagingDrawTask.this.mDrawingNotify) {
                                    try {
                                        try {
                                            CacheManagingDrawTask.this.mDrawingNotify.wait(30L);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                            return 1;
                                        }
                                    } finally {
                                    }
                                }
                            }
                            CacheManager.this.entryRemoved(false, baseDanmaku, null);
                            return 2;
                        }
                        return 0;
                    }
                    return 1;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAll() {
            Danmakus danmakus = this.mCaches;
            if (danmakus != null) {
                danmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.1
                    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                    public int accept(BaseDanmaku baseDanmaku) {
                        CacheManager.this.entryRemoved(true, baseDanmaku, null);
                        return 0;
                    }
                });
                this.mCaches.clear();
            }
            this.mRealSize = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void evictAllNotInScreen() {
            Danmakus danmakus = this.mCaches;
            if (danmakus != null) {
                danmakus.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.2
                    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                    public int accept(BaseDanmaku baseDanmaku) {
                        if (baseDanmaku.isOutside()) {
                            CacheManager.this.entryRemoved(true, baseDanmaku, null);
                            return 2;
                        }
                        return 0;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BaseDanmaku findReuseableCache(final BaseDanmaku baseDanmaku, final boolean z, final int i) {
            final int slopPixel = (!z ? CacheManagingDrawTask.this.mDisp.getSlopPixel() * 2 : 0) + CacheManagingDrawTask.this.mContext.cachingPolicy.reusableOffsetPixel;
            IDanmakus.Consumer<BaseDanmaku, BaseDanmaku> consumer = new IDanmakus.Consumer<BaseDanmaku, BaseDanmaku>() { // from class: com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.4
                int count = 0;
                BaseDanmaku mResult;

                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public int accept(BaseDanmaku baseDanmaku2) {
                    IDrawingCache<?> iDrawingCache;
                    int i2 = this.count;
                    this.count = i2 + 1;
                    if (i2 >= i) {
                        return 1;
                    }
                    if (baseDanmaku2.priority != 2 && (iDrawingCache = baseDanmaku2.cache) != null && iDrawingCache.get() != null) {
                        float f = baseDanmaku2.paintWidth;
                        BaseDanmaku baseDanmaku3 = baseDanmaku;
                        if (f == baseDanmaku3.paintWidth && baseDanmaku2.paintHeight == baseDanmaku3.paintHeight && baseDanmaku2.underlineColor == baseDanmaku3.underlineColor && baseDanmaku2.borderColor == baseDanmaku3.borderColor && baseDanmaku2.ykHasBorder == baseDanmaku3.ykHasBorder && baseDanmaku2.textColor == baseDanmaku3.textColor && baseDanmaku2.text.equals(baseDanmaku3.text) && baseDanmaku2.tag == baseDanmaku.tag) {
                            this.mResult = baseDanmaku2;
                            return 1;
                        } else if (z) {
                            return 0;
                        } else {
                            if (!baseDanmaku2.isTimeOut()) {
                                return 1;
                            }
                            if (iDrawingCache.hasReferences()) {
                                return 0;
                            }
                            float width = iDrawingCache.width() - baseDanmaku.paintWidth;
                            float height = iDrawingCache.height() - baseDanmaku.paintHeight;
                            if (width >= 0.0f) {
                                int i3 = slopPixel;
                                if (width <= i3 && height >= 0.0f && height <= i3) {
                                    this.mResult = baseDanmaku2;
                                    return 1;
                                }
                            }
                        }
                    }
                    return 0;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public BaseDanmaku result() {
                    return this.mResult;
                }
            };
            this.mCaches.forEach(consumer);
            return consumer.result();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean push(BaseDanmaku baseDanmaku, int i, boolean z) {
            int i2 = 0;
            int i3 = 0;
            while (this.mRealSize + i > this.mMaxSize && this.mCaches.size() > 0) {
                BaseDanmaku first = this.mCaches.first();
                if (first != null && first.isTimeOut()) {
                    if (entryRemoved(false, first, baseDanmaku) <= 0) {
                        i2++;
                    }
                    if (i2 > 5) {
                        return false;
                    }
                    if (!this.mCaches.removeItem(first)) {
                        Log.d(TAG, "push remove cache failed");
                        i3++;
                    }
                    if (i3 > 3) {
                        Log.d(TAG, "push remove cache retry more than 3");
                        return false;
                    }
                } else if (!z) {
                    return false;
                }
            }
            this.mCaches.addItem(baseDanmaku);
            this.mRealSize += i;
            return true;
        }

        @Override // com.youku.danmaku.engine.danmaku.model.ICacheManager
        public void addDanmaku(BaseDanmaku baseDanmaku) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                if (baseDanmaku.isLive) {
                    if (baseDanmaku.isTimeOut()) {
                        return;
                    }
                    this.mHandler.createCache(baseDanmaku);
                    return;
                }
                cacheHandler.obtainMessage(2, baseDanmaku).sendToTarget();
            }
        }

        public void begin() {
            this.mEndFlag = false;
            if (this.mThread == null) {
                HandlerThread handlerThread = new HandlerThread("DMCache-BuildingThread");
                this.mThread = handlerThread;
                handlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new CacheHandler(this.mThread.getLooper());
            }
            this.mHandler.begin();
        }

        public void end() {
            this.mEndFlag = true;
            synchronized (CacheManagingDrawTask.this.mDrawingNotify) {
                CacheManagingDrawTask.this.mDrawingNotify.notifyAll();
            }
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.removeCallbacksAndMessages(null);
                this.mHandler.pause();
                this.mHandler = null;
            }
            HandlerThread handlerThread = this.mThread;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.mThread.quit();
                this.mThread = null;
            }
        }

        protected long entryRemoved(boolean z, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
            if (iDrawingCache != null) {
                long clearCache = clearCache(baseDanmaku);
                if (baseDanmaku.isTimeOut()) {
                    CacheManagingDrawTask.this.mContext.getDisplayer().getCacheStuffer().releaseResource(baseDanmaku);
                }
                if (clearCache <= 0) {
                    return 0L;
                }
                this.mRealSize = (int) (this.mRealSize - clearCache);
                this.mCachePool.release((DrawingCache) iDrawingCache);
                return clearCache;
            }
            return 0L;
        }

        public long getFirstCacheTime() {
            BaseDanmaku first;
            Danmakus danmakus = this.mCaches;
            if (danmakus == null || danmakus.size() <= 0 || (first = this.mCaches.first()) == null) {
                return 0L;
            }
            return first.time;
        }

        public float getPoolPercent() {
            int i = this.mMaxSize;
            if (i == 0) {
                return 0.0f;
            }
            return this.mRealSize / i;
        }

        public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestCancelCaching();
                this.mHandler.obtainMessage(17, baseDanmaku).sendToTarget();
                this.mHandler.sendEmptyMessage(18);
                requestBuild(0L);
            }
        }

        public void onPlayStateChanged(int i) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.onPlayStateChanged(i == 1);
            }
        }

        public void post(Runnable runnable) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.post(runnable);
        }

        public void requestBuild(long j) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestBuildCacheAndDraw(j);
            }
        }

        public void requestClearAll() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.removeMessages(3);
            this.mHandler.removeMessages(18);
            this.mHandler.requestCancelCaching();
            this.mHandler.removeMessages(7);
            this.mHandler.sendEmptyMessage(7);
        }

        public void requestClearTimeout() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.removeMessages(4);
            this.mHandler.sendEmptyMessage(4);
        }

        public void requestClearUnused() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.removeMessages(9);
            this.mHandler.sendEmptyMessage(9);
        }

        public void resume() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.resume();
            } else {
                begin();
            }
        }

        public void seek(long j) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            cacheHandler.requestCancelCaching();
            this.mHandler.removeMessages(3);
            this.mHandler.obtainMessage(5, Long.valueOf(j)).sendToTarget();
        }

        protected int sizeOf(BaseDanmaku baseDanmaku) {
            try {
                IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
                if (iDrawingCache == null || iDrawingCache.hasReferences()) {
                    return 0;
                }
                return baseDanmaku.cache.size();
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public CacheManagingDrawTask(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.TaskListener taskListener, int i) {
        super(danmakuTimer, danmakuContext, taskListener);
        this.mMaxCacheSize = 2;
        this.mDrawingNotify = new Object();
        NativeBitmapFactory.g();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.f()) {
            this.mMaxCacheSize = i * 2;
        }
        if (Log.isDebug()) {
            Log.d("CacheManagingDrawTask", "maxCacheSize=" + this.mMaxCacheSize);
        }
        CacheManager cacheManager = new CacheManager(this.mMaxCacheSize, 3);
        this.mCacheManager = cacheManager;
        this.mRenderer.setCacheManager(cacheManager);
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void addDanmaku(BaseDanmaku baseDanmaku) {
        super.addDanmaku(baseDanmaku);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            return;
        }
        cacheManager.addDanmaku(baseDanmaku);
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public IRenderer.RenderingState draw(AbsDisplayer absDisplayer) {
        CacheManager cacheManager;
        IRenderer.RenderingState draw = super.draw(absDisplayer);
        synchronized (this.mDrawingNotify) {
            this.mDrawingNotify.notify();
        }
        if (draw != null && (cacheManager = this.mCacheManager) != null && draw.totalDanmakuCount - draw.lastTotalDanmakuCount < -20) {
            cacheManager.requestClearTimeout();
            this.mCacheManager.requestBuild(-this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
        }
        return draw;
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask
    protected void initTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
        DanmakuTimer danmakuTimer2 = new DanmakuTimer();
        this.mCacheTimer = danmakuTimer2;
        danmakuTimer2.update(danmakuTimer.currMillisecond);
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        super.invalidateDanmaku(baseDanmaku, z);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            return;
        }
        cacheManager.invalidateDanmaku(baseDanmaku, z);
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask
    public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        CacheManager cacheManager;
        CacheManager cacheManager2;
        if (!super.handleOnDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
                requestClear();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && (cacheManager2 = this.mCacheManager) != null)) {
                    cacheManager2.requestBuild(0L);
                }
                requestClear();
            } else if (!DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                CacheManager cacheManager3 = this.mCacheManager;
                if (cacheManager3 != null) {
                    cacheManager3.requestClearUnused();
                    this.mCacheManager.requestBuild(0L);
                }
            } else {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
                }
                CacheManager cacheManager4 = this.mCacheManager;
                if (cacheManager4 != null) {
                    cacheManager4.requestClearAll();
                    this.mCacheManager.requestBuild(-this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
                }
            }
        }
        if (this.mTaskListener == null || (cacheManager = this.mCacheManager) == null) {
            return true;
        }
        cacheManager.post(new Runnable() { // from class: com.youku.danmaku.engine.controller.CacheManagingDrawTask.1
            @Override // java.lang.Runnable
            public void run() {
                CacheManagingDrawTask.this.mTaskListener.onDanmakuConfigChanged();
            }
        });
        return true;
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask
    protected void onDanmakuRemoved(BaseDanmaku baseDanmaku) {
        super.onDanmakuRemoved(baseDanmaku);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            int i = this.mRemainingCacheCount + 1;
            this.mRemainingCacheCount = i;
            if (i > 5) {
                cacheManager.requestClearTimeout();
                this.mRemainingCacheCount = 0;
                return;
            }
            return;
        }
        IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
        if (iDrawingCache != null) {
            if (iDrawingCache.hasReferences()) {
                baseDanmaku.cache.decreaseReference();
            } else {
                baseDanmaku.cache.destroy();
            }
            baseDanmaku.cache = null;
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void onPlayStateChanged(int i) {
        super.onPlayStateChanged(i);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.onPlayStateChanged(i);
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void prepare() {
        loadDanmakus(this.mParser);
        this.mCacheManager.begin();
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void quit() {
        super.quit();
        reset(0);
        this.mRenderer.setCacheManager(null);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.end();
            this.mCacheManager = null;
        }
        NativeBitmapFactory.h();
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void removeAllDanmakus() {
        super.removeAllDanmakus();
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.requestClearAll();
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void seek(long j, int i) {
        super.seek(j, i);
        if (this.mCacheManager == null) {
            start();
        }
        this.mCacheManager.seek(j);
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask, com.youku.danmaku.engine.controller.IDrawTask
    public void start() {
        super.start();
        NativeBitmapFactory.g();
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            CacheManager cacheManager2 = new CacheManager(this.mMaxCacheSize, 3);
            this.mCacheManager = cacheManager2;
            cacheManager2.begin();
            this.mRenderer.setCacheManager(this.mCacheManager);
            return;
        }
        cacheManager.resume();
    }
}
