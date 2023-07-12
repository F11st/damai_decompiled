package com.youku.danmaku.engine.danmaku.model.objectpool;

import com.youku.danmaku.engine.danmaku.model.objectpool.Poolable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class SynchronizedPool<T extends Poolable<T>> implements Pool<T> {
    private final Object mLock;
    private final Pool<T> mPool;

    public SynchronizedPool(Pool<T> pool) {
        this.mPool = pool;
        this.mLock = this;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Pool
    public T acquire() {
        T acquire;
        synchronized (this.mLock) {
            acquire = this.mPool.acquire();
        }
        return acquire;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.objectpool.Pool
    public void release(T t) {
        synchronized (this.mLock) {
            this.mPool.release(t);
        }
    }

    public SynchronizedPool(Pool<T> pool, Object obj) {
        this.mPool = pool;
        this.mLock = obj;
    }
}
