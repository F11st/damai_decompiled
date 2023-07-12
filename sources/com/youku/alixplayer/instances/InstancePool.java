package com.youku.alixplayer.instances;

import com.youku.alixplayer.util.Destructable;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class InstancePool<T extends Destructable> {
    private Queue<T> mInstanceQueue;
    private Instantiater<T> mInstantiater;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Instantiater<T> {
        T instance();
    }

    public InstancePool(Instantiater<T> instantiater, int i) {
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
        if (queue != null ? queue.offer(t) : false) {
            return;
        }
        t.destruct();
    }

    public void setInstantiater(Instantiater<T> instantiater) {
        this.mInstantiater = instantiater;
    }
}
