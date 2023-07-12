package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicInteger;
import tb.i42;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleEquals<T> extends e<Boolean> {
    final SingleSource<? extends T> first;
    final SingleSource<? extends T> second;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class InnerObserver<T> implements SingleObserver<T> {
        final AtomicInteger count;
        final int index;
        final SingleObserver<? super Boolean> s;
        final jm set;
        final Object[] values;

        InnerObserver(int i, jm jmVar, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.index = i;
            this.set = jmVar;
            this.values = objArr;
            this.s = singleObserver;
            this.count = atomicInteger;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            int i;
            do {
                i = this.count.get();
                if (i >= 2) {
                    i42.u(th);
                    return;
                }
            } while (!this.count.compareAndSet(i, 2));
            this.set.dispose();
            this.s.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.values[this.index] = t;
            if (this.count.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.s;
                Object[] objArr = this.values;
                singleObserver.onSuccess(Boolean.valueOf(ObjectHelper.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.first = singleSource;
        this.second = singleSource2;
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        jm jmVar = new jm();
        singleObserver.onSubscribe(jmVar);
        this.first.subscribe(new InnerObserver(0, jmVar, objArr, singleObserver, atomicInteger));
        this.second.subscribe(new InnerObserver(1, jmVar, objArr, singleObserver, atomicInteger));
    }
}
