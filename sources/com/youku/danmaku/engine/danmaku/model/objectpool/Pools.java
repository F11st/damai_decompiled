package com.youku.danmaku.engine.danmaku.model.objectpool;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Pools {
    private Pools() {
    }

    public static <T extends Poolable<T>> Pool<T> finitePool(PoolableManager<T> poolableManager, int i) {
        return new FinitePool(poolableManager, i);
    }

    public static <T extends Poolable<T>> Pool<T> simplePool(PoolableManager<T> poolableManager) {
        return new FinitePool(poolableManager);
    }

    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool) {
        return new SynchronizedPool(pool);
    }

    public static <T extends Poolable<T>> Pool<T> synchronizedPool(Pool<T> pool, Object obj) {
        return new SynchronizedPool(pool, obj);
    }
}
