package com.youku.alixplayer.instances.System;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SystemInstancePool<T> {
    private Queue<T> mInstanceQueue;
    private Instantiater<T> mInstantiater;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Instantiater<T> {
        T instance();
    }

    public SystemInstancePool(Instantiater<T> instantiater, int i) {
        this.mInstantiater = instantiater;
        if (i >= 1) {
            this.mInstanceQueue = new ArrayBlockingQueue(i);
        }
    }

    public T acquire() {
        Queue<T> queue = this.mInstanceQueue;
        T poll = queue != null ? queue.poll() : null;
        return poll == null ? this.mInstantiater.instance() : poll;
    }

    public void release(T t) {
        Queue<T> queue = this.mInstanceQueue;
        if (queue != null) {
            queue.offer(t);
        }
    }

    public void setSystemInstancePool(Instantiater<T> instantiater) {
        this.mInstantiater = instantiater;
    }
}
