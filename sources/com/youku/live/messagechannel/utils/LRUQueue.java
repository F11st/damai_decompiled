package com.youku.live.messagechannel.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LRUQueue<T extends Comparable<T>> extends LinkedBlockingQueue<T> {
    private static transient /* synthetic */ IpChange $ipChange;

    public LRUQueue(int i) {
        super(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((LRUQueue<T>) ((Comparable) obj));
    }

    public synchronized boolean add(T t) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2009537877")) {
            return ((Boolean) ipChange.ipc$dispatch("2009537877", new Object[]{this, t})).booleanValue();
        } else if (t == null) {
            return false;
        } else {
            Iterator<T> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Comparable comparable = (Comparable) it.next();
                if (comparable.compareTo(t) == 0) {
                    remove(comparable);
                    break;
                }
            }
            if (remainingCapacity() <= 0) {
                remove();
            }
            super.add((LRUQueue<T>) t);
            return z;
        }
    }
}
