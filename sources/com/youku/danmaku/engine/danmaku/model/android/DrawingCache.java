package com.youku.danmaku.engine.danmaku.model.android;

import com.youku.danmaku.engine.danmaku.model.IDrawingCache;
import com.youku.danmaku.engine.danmaku.model.objectpool.Poolable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DrawingCache implements IDrawingCache<DrawingCacheHolder>, Poolable<DrawingCache> {
    private boolean mIsPooled;
    private DrawingCache mNextElement;
    private int mSize = 0;
    private int referenceCount = 0;
    private final DrawingCacheHolder mHolder = new DrawingCacheHolder();

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public void build(int i, int i2, int i3, boolean z, int i4) {
        this.mHolder.buildCache(i, i2, i3, z, i4);
        this.mSize = this.mHolder.bitmap.getRowBytes() * this.mHolder.bitmap.getHeight();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public synchronized void decreaseReference() {
        this.referenceCount--;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public void destroy() {
        this.mHolder.recycle();
        this.mSize = 0;
        this.referenceCount = 0;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public void erase() {
        this.mHolder.erase();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public synchronized boolean hasReferences() {
        return this.referenceCount > 0;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public int height() {
        return this.mHolder.height;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public synchronized void increaseReference() {
        this.referenceCount++;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Poolable
    public boolean isPooled() {
        return this.mIsPooled;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Poolable
    public void setPooled(boolean z) {
        this.mIsPooled = z;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public int size() {
        return this.mSize;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public int width() {
        return this.mHolder.width;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.danmaku.engine.danmaku.model.IDrawingCache
    public DrawingCacheHolder get() {
        DrawingCacheHolder drawingCacheHolder = this.mHolder;
        if (drawingCacheHolder.bitmap == null) {
            return null;
        }
        return drawingCacheHolder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Poolable
    public DrawingCache getNextPoolable() {
        return this.mNextElement;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Poolable
    public void setNextPoolable(DrawingCache drawingCache) {
        this.mNextElement = drawingCache;
    }
}
