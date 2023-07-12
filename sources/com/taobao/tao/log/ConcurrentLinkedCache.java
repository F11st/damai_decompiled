package com.taobao.tao.log;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConcurrentLinkedCache<E> extends ConcurrentLinkedQueue<E> {
    @NonNull
    public Iterator<E> getIteratorAndClear() {
        synchronized (this) {
            try {
                try {
                    if (!isEmpty()) {
                        ArrayList arrayList = new ArrayList(this);
                        clear();
                        return arrayList.iterator();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new Iterator<E>() { // from class: com.taobao.tao.log.ConcurrentLinkedCache.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return false;
                    }

                    @Override // java.util.Iterator
                    public E next() {
                        return null;
                    }
                };
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
