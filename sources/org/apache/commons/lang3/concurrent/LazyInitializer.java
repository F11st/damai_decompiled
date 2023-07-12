package org.apache.commons.lang3.concurrent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private static final Object NO_INIT = new Object();
    private volatile T object = (T) NO_INIT;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t = this.object;
        Object obj = NO_INIT;
        if (t == obj) {
            synchronized (this) {
                t = this.object;
                if (t == obj) {
                    t = initialize();
                    this.object = t;
                }
            }
        }
        return t;
    }

    protected abstract T initialize() throws ConcurrentException;
}
