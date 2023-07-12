package com.youku.danmaku.engine.danmaku.model.android.stuffer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDrawingCache;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCacheHolder;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseCacheStuffer {
    Proxy mProxy;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class Proxy {
        public abstract void prepareDrawing(BaseDanmaku baseDanmaku, boolean z);

        public abstract void releaseResource(BaseDanmaku baseDanmaku);
    }

    public void clearCache(BaseDanmaku baseDanmaku) {
    }

    public abstract void clearCaches();

    public boolean drawCache(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, Paint paint) {
        DrawingCacheHolder drawingCacheHolder;
        IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
        if (iDrawingCache == null || (drawingCacheHolder = (DrawingCacheHolder) iDrawingCache.get()) == null) {
            return false;
        }
        return drawingCacheHolder.draw(canvas, f, f2, paint);
    }

    public abstract void drawDanmaku(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.DisplayConfig displayConfig);

    public abstract void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig);

    public void releaseResource(BaseDanmaku baseDanmaku) {
        Proxy proxy = this.mProxy;
        if (proxy != null) {
            proxy.releaseResource(baseDanmaku);
        }
    }

    public void setProxy(Proxy proxy) {
        this.mProxy = proxy;
    }
}
