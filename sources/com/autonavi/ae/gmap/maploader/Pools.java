package com.autonavi.ae.gmap.maploader;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Pools {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i > 0) {
                this.mPool = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i = this.mPoolSize;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.mPoolSize = i - 1;
                return t;
            }
            return null;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i = 0;
            while (true) {
                Object[] objArr = this.mPool;
                if (i >= objArr.length) {
                    return;
                }
                objArr[i] = null;
                i++;
            }
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t) {
            if (!isInPool(t)) {
                int i = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i < objArr.length) {
                    objArr[i] = t;
                    this.mPoolSize = i + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i) {
            super(i);
            this.mLock = new Object();
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
