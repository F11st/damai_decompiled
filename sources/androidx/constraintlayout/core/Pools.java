package androidx.constraintlayout.core;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        /* JADX INFO: Access modifiers changed from: package-private */
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

        @Override // androidx.constraintlayout.core.Pools.Pool
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

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t) {
            int i = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i < objArr.length) {
                objArr[i] = t;
                this.mPoolSize = i + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.mPoolSize = i3 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
