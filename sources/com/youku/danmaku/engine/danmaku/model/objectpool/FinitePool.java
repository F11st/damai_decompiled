package com.youku.danmaku.engine.danmaku.model.objectpool;

import com.youku.danmaku.engine.danmaku.model.objectpool.Poolable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class FinitePool<T extends Poolable<T>> implements Pool<T> {
    private final boolean mInfinite;
    private final int mLimit;
    private final PoolableManager<T> mManager;
    private int mPoolCount;
    private T mRoot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinitePool(PoolableManager<T> poolableManager) {
        this.mManager = poolableManager;
        this.mLimit = 0;
        this.mInfinite = true;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Pool
    public T acquire() {
        T t = this.mRoot;
        if (t != null) {
            this.mRoot = (T) t.getNextPoolable();
            this.mPoolCount--;
        } else {
            t = this.mManager.newInstance();
        }
        if (t != null) {
            t.setNextPoolable(null);
            t.setPooled(false);
            this.mManager.onAcquired(t);
        }
        return t;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Pool
    public void release(T t) {
        if (!t.isPooled()) {
            if (this.mInfinite || this.mPoolCount < this.mLimit) {
                this.mPoolCount++;
                t.setNextPoolable(this.mRoot);
                t.setPooled(true);
                this.mRoot = t;
            }
            this.mManager.onReleased(t);
            return;
        }
        System.out.print("[FinitePool] Element is already in pool: " + t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinitePool(PoolableManager<T> poolableManager, int i) {
        if (i > 0) {
            this.mManager = poolableManager;
            this.mLimit = i;
            this.mInfinite = false;
            return;
        }
        throw new IllegalArgumentException("The pool limit must be > 0");
    }
}
